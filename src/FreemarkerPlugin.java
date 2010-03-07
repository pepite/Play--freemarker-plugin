import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import play.Logger;
import play.Play;
import play.PlayPlugin;
import play.exceptions.TemplateNotFoundException;
import play.libs.IO;
import play.libs.MimeTypes;
import play.modules.freemarker.RenderFreemarkerTemplate;
import play.mvc.Http;
import play.mvc.Scope;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2010, Nicolas Leroux.
 * <p/>
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 * <p/>
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 * <p/>
 * User: nicolas
 * Date: Mar 7, 2010
 */

public class FreemarkerPlugin extends PlayPlugin {

    private Configuration cfg;

    public void onApplicationStart() {
        try {
            Logger.info("onApplicationStart: begin");

            // Initialize the FreeMarker configuration;
            // - Create a configuration instance
            cfg = new Configuration();
            cfg.setDefaultEncoding("UTF-8");
            // TODO: that is not working for module templates
            cfg.setDirectoryForTemplateLoading(new File(Play.applicationPath, "app/views"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean renderTemplate(String templateName, Map<String, Object> args) throws TemplateNotFoundException {
        final String freemarkerTemplateName = templateName.substring(0, templateName.lastIndexOf(".")) + ".ftl";
        try {
            Logger.info("renderTemplate: begin");
            // There is always a .format
            Template template = cfg.getTemplate(freemarkerTemplateName);
            throw new RenderFreemarkerTemplate(template, args);
        } catch (IOException e) {
            // We did not find a template. Give the hand to the default engine template.
            throw new TemplateNotFoundException(freemarkerTemplateName);
            //return false;
        }
    }

}
