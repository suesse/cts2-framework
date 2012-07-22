package edu.mayo.cts2.framework.core.json;

import static org.junit.Assert.*;

import org.junit.Test

import edu.mayo.cts2.framework.model.codesystem.CodeSystemCatalogEntry
import edu.mayo.cts2.framework.model.core.EntryDescription
import edu.mayo.cts2.framework.model.core.ScopedEntityName
import edu.mayo.cts2.framework.model.core.TsAnyType
import edu.mayo.cts2.framework.model.entity.EntityDescription
import edu.mayo.cts2.framework.model.entity.NamedEntityDescription

class JsonConverterTest {
	
	@Test
	void TestGetJsonClass(){
		def converter = new JsonConverter()
		
		def json = """
		{"CodeSystemCatalogEntry":{"codeSystemName":"csname","designedForOntologyTaskList":[],"usedOntologyEngineeringToolList":[],"releaseFormatList":[],"about":"urn:oid:about","keywordList":[],"resourceTypeList":[],"additionalDocumentationList":[],"sourceAndRoleList":[],"noteList":[],"propertyList":[],"alternateIDList":[],"entryState":"ACTIVE"}}
		"""	
		
		assertEquals "CodeSystemCatalogEntry", converter.getJsonClass(json).getSimpleName()
	}
	
	@Test
	void TestFromObjectWithExtra(){
		def converter = new JsonConverter()
		
		def json = """
		{"CodeSystemCatalogEntry":{"somethingElse" : "aDifferentThing", "codeSystemName":"csname","about":"urn:oid:about","entryState":"ACTIVE"}}
		"""
		
		def cs = converter.fromJson(json);
		assertEquals "CodeSystemCatalogEntry", cs.class.getSimpleName()
		assertEquals "urn:oid:about", cs.about
		assertEquals "csname", cs.codeSystemName
		assertEquals "ACTIVE", cs.entryState.toString()
	}

	
	
	@Test
	void TestJsonToObject(){
		def converter = new JsonConverter()
		
		def json = """
		{"CodeSystemCatalogEntry":{"codeSystemName":"csname","designedForOntologyTaskList":[],"usedOntologyEngineeringToolList":[],"releaseFormatList":[],"about":"urn:oid:about","keywordList":[],"resourceTypeList":[],"additionalDocumentationList":[],"sourceAndRoleList":[],"noteList":[],"propertyList":[],"alternateIDList":[],"entryState":"ACTIVE"}}
		"""
		
		assertEquals "csname", converter.fromJson(json, CodeSystemCatalogEntry).codeSystemName
	}
	
	@Test
	void TestObjectToJsonSpecialChars(){
		def converter = new JsonConverter()
		def cs = new CodeSystemCatalogEntry(resourceSynopsis: new EntryDescription(value: new TsAnyType()));
		cs.resourceSynopsis.value.content = '&lt;a href="http://obo.cvs.sourceforge.net/*checkout*/song/ontology/sofa.obo"&gt;SOFA&lt;/a&gt; '
		
		def json = converter.toJson(cs);
		
		def cs_return = converter.fromJson(json)
		
		assertEquals cs, cs_return
	}
	
	
	
	@Test
	void TestSetChoiceValue(){
		def converter = new JsonConverter()
		
		def ed = new NamedEntityDescription(entityID:new ScopedEntityName(name:"n",namespace:"ns"))
		
		def des = new EntityDescription()
		des.setNamedEntity(ed)
		
		converter.setChoiceValue(des);
		
		assertNotNull des.namedEntity;
		assertNotNull des.choiceValue;

	}
	
	@Test
	void TestGetJsonFromObject(){
		def converter = new JsonConverter()
		
		def cs = new CodeSystemCatalogEntry()
		cs.addKeyword("test1");
		cs.addKeyword("test2");
		
		assertTrue converter.toJson(cs).contains("\"keywords\":[\"test1\",\"test2\"]");
	}

}
