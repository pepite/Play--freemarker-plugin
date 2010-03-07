<#macro myLayout title="YABE">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>${title}</title>		
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <link rel="stylesheet" type="text/css" media="screen" href="@{'/public/stylesheets/main.css'}" />
        <link rel="shortcut icon" type="image/png" href="@{'/public/images/favicon.png'}" />
        <script src="@{'/public/javascripts/jquery-1.3.2.min.js'}"></script>
        <script src="@{'/public/javascripts/jquery.tools.min.js'}"></script>
    </head>
    <body>
        
        <div id="header">
            <div id="logo">
                yabe.
            </div>
            <ul id="tools">
                <li>
                    <a href="@{Admin.index()}">Log in to write something</a>
                </li>
            </ul>
            <div id="title">
                <span class="about">About this blog</span>
                <h1><a href="@{Application.index()}">${blogTitle}</a></h1>
                <h2>${blogBaseline}</h2>
            </div>
        </div>
        
        <div id="main">
            <#nested/>
        </div>
        
        <p id="footer">
            Yabe is a (not so) powerful blog engine built with the 
            <a href="http://www.playframework.org">play framework</a>
            as a tutorial application.
        </p>
        
    </body>
</html>
</#macro>