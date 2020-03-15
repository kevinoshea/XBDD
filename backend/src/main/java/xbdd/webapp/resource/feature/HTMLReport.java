/**
 * Copyright (C) 2015 Orion Health (Orchestral Development Ltd)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package xbdd.webapp.resource.feature;

import xbdd.webapp.util.Coordinates;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/html-report/{product}/{major}.{minor}.{servicePack}/{build}")
public class HTMLReport {

	private static final String VIEW_ID = "/listFeaturesForReport";

	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response getIt(@BeanParam final Coordinates coordinates, @Context final ServletContext context,
			@Context final HttpServletRequest req) {
		final Map<String, Object> map = new HashMap<String, Object>();
		map.put("product", coordinates.getProduct());
		map.put("version", coordinates.getVersionString());
		map.put("build", coordinates.getBuild());
		map.put("featureid", null);
		map.put("isAdmin", req.isUserInRole("admin"));
		return Response.ok().build();
	}

	/**
	 * Uses the '.+' regexp on featureId to allow for symbols such as slashes in the id
	 *
	 * @param String featureId The featureId to get the history for
	 * @return Response The feature view page
	 */
	@GET
	@Path("/{featureid:.+}")
	@Produces(MediaType.TEXT_HTML)
	public Response getItFeat(@BeanParam final Coordinates coordinates, @PathParam("featureid") final String featureid,
			@Context final HttpServletRequest req,
			@Context final ServletContext context) {
		final Map<String, Object> map = new HashMap<String, Object>();
		map.put("product", coordinates.getProduct());
		map.put("version", coordinates.getVersionString());
		map.put("build", coordinates.getBuild());
		map.put("featureid", featureid);
		map.put("isAdmin", req.isUserInRole("admin"));
		return Response.ok().build();
	}
}