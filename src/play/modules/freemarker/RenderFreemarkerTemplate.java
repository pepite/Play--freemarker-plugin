/**
 *
 * Copyright 2010, Lunatech Labs.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 *
 * User: nicolas
 * Date: Mar 7, 2010
 *
 */
package play.modules.freemarker;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import play.exceptions.UnexpectedException;
import play.mvc.Http;
import play.mvc.results.Result;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

public class RenderFreemarkerTemplate extends Result {

    public Template template;
    Map<String, Object> args;

    public RenderFreemarkerTemplate(Template template, Map<String, Object> args) {
        this.template = template;
        this.args = args;
    }

    public void apply(Http.Request request, Http.Response response) {
        try {
            response.contentType = "text/html; charset=" + template.getEncoding();
            OutputStream out = response.out;
            PrintWriter writer = new PrintWriter(out);

            // Merge the data-model and the template
            template.process(args, writer);
        } catch (Exception e) {
            throw new UnexpectedException(e);
        }
    }

}
