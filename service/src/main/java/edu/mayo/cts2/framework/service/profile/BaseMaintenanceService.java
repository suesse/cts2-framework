/*
 * Copyright: (c) 2004-2011 Mayo Foundation for Medical Education and 
 * Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
 * triple-shield Mayo logo are trademarks and service marks of MFMER.
 *
 * Except as contained in the copyright notice above, or as used to identify 
 * MFMER as the author of this software, the trade names, trademarks, service
 * marks, or product names of the copyright holder shall not be used in
 * advertising, promotion or otherwise in connection with this software without
 * prior written authorization of the copyright holder.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.mayo.cts2.framework.service.profile;

import edu.mayo.cts2.framework.model.core.IsChangeable;


/**
 * The Interface MaintenanceService.
 *
 * @param <T> the generic type
 * @param <R> the generic type
 * @param <I> the generic type
 * @author <a href="mailto:kevin.peterson@mayo.edu">Kevin Peterson</a>
 */
public interface BaseMaintenanceService<
	T extends IsChangeable, 
	R extends IsChangeable,
	I> extends Cts2Profile {

	/**
	 * Update changeable metadata.
	 *
	 * @param identifier the identifier
	 * @param request the request
	 */
	public void updateChangeableMetadata(I identifier, UpdateChangeableMetadataRequest request);
	
	/**
	 * Update resource.
	 *
	 * @param resource the resource
	 */
	public void updateResource(T resource);
	
	/**
	 * Creates the resource.
	 *
	 * @param resource the resource
	 * @return the t
	 *
	 * @throws ChangeSetIsNotOpenException The requested ChangeSet is not open
	 */
	public T createResource(R resource);
	
	/**
	 * Delete resource.
	 *
	 * @param identifier the identifier
	 * @param changeSetUri the change set uri
	 */
	public void deleteResource(I identifier, String changeSetUri);
	
}