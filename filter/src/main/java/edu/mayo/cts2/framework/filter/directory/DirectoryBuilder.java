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
package edu.mayo.cts2.framework.filter.directory;

import java.util.Set;

import edu.mayo.cts2.framework.model.command.ResolvedFilter;
import edu.mayo.cts2.framework.model.directory.DirectoryResult;
import edu.mayo.cts2.framework.model.service.core.Query;

/**
 * A Builder-Pattern interface for assembling a {@link DirectoryResult}. This is
 * intended to be used mostly in CTS2 Query Service implementations.
 *
 * @param <T> the generic type
 * @author <a href="mailto:kevin.peterson@mayo.edu">Kevin Peterson</a>
 */
public interface DirectoryBuilder<T> {
	
	/**
	 * Restrict.
	 *
	 * @param filterComponent the filter component
	 * @return the directory builder
	 */
	public DirectoryBuilder<T> restrict(Set<ResolvedFilter> filterComponent);
	
	public DirectoryBuilder<T> restrict(ResolvedFilter filterComponent);
	
	/**
	 * Restrict.
	 *
	 * @param query the query
	 * @return the directory builder
	 */
	public DirectoryBuilder<T> restrict(Query query);
	
	/**
	 * Adds the max to return.
	 *
	 * @param maxToReturn the max to return
	 * @return the directory builder
	 */
	public DirectoryBuilder<T> addMaxToReturn(int maxToReturn);
	
	/**
	 * Adds the start.
	 *
	 * @param start the start
	 * @return the directory builder
	 */
	public DirectoryBuilder<T> addStart(int start);
	
	/**
	 * Resolve.
	 *
	 * @return the directory result
	 */
	public DirectoryResult<T> resolve();
	
	/**
	 * Count.
	 *
	 * @return the int
	 */
	public int count();
}
