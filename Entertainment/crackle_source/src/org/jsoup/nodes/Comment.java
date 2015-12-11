// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.nodes;


// Referenced classes of package org.jsoup.nodes:
//            Node, Attributes

public class Comment extends Node
{

    private static final String COMMENT_KEY = "comment";

    public Comment(String s, String s1)
    {
        super(s1);
        attributes.put("comment", s);
    }

    public String getData()
    {
        return attributes.get("comment");
    }

    public String nodeName()
    {
        return "#comment";
    }

    void outerHtmlHead(StringBuilder stringbuilder, int i, Document.OutputSettings outputsettings)
    {
        if (outputsettings.prettyPrint())
        {
            indent(stringbuilder, i, outputsettings);
        }
        stringbuilder.append("<!--").append(getData()).append("-->");
    }

    void outerHtmlTail(StringBuilder stringbuilder, int i, Document.OutputSettings outputsettings)
    {
    }

    public String toString()
    {
        return outerHtml();
    }
}
