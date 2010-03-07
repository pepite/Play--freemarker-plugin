<#import "../main.ftl" as layout>
<@layout.myLayout "Home">
<#if frontPost??>
    
    <#if (olderPosts??)>
    
        <div class="older-posts">    
            <h3>Older posts <span class="from">from this blog</span></h3>

            <#list olderPosts as oldPost>
               ${oldPost.title}
            </#list>         
        </div>
        
    </#if>   
<#else>
    <div class="empty">
        There is currently nothing to read here.
    </div>
</#if>
</@layout.myLayout>