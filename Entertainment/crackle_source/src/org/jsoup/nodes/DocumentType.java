// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.nodes;

import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;

// Referenced classes of package org.jsoup.nodes:
//            Node

public class DocumentType extends Node
{

    public DocumentType(String s, String s1, String s2, String s3)
    {
        super(s3);
        Validate.notEmpty(s);
        attr("name", s);
        attr("publicId", s1);
        attr("systemId", s2);
    }

    public String nodeName()
    {
        return "#doctype";
    }

    void outerHtmlHead(StringBuilder stringbuilder, int i, Document.OutputSettings outputsettings)
    {
        stringbuilder.append("<!DOCTYPE ").append(attr("name"));
        if (!StringUtil.isBlank(attr("publicId")))
        {
            stringbuilder.append(" PUBLIC \"").append(attr("publicId")).append("\"");
        }
        if (!StringUtil.isBlank(attr("systemId")))
        {
            stringbuilder.append(" \"").append(attr("systemId")).append("\"");
        }
        stringbuilder.append('>');
    }

    void outerHtmlTail(StringBuilder stringbuilder, int i, Document.OutputSettings outputsettings)
    {
    }
}
