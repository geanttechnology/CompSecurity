// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.nodes;


// Referenced classes of package org.jsoup.nodes:
//            Node, Attributes

public class XmlDeclaration extends Node
{

    private static final String DECL_KEY = "declaration";
    private final boolean isProcessingInstruction;

    public XmlDeclaration(String s, String s1, boolean flag)
    {
        super(s1);
        attributes.put("declaration", s);
        isProcessingInstruction = flag;
    }

    public String getWholeDeclaration()
    {
        return attributes.get("declaration");
    }

    public String nodeName()
    {
        return "#declaration";
    }

    void outerHtmlHead(StringBuilder stringbuilder, int i, Document.OutputSettings outputsettings)
    {
        outputsettings = stringbuilder.append("<");
        if (isProcessingInstruction)
        {
            stringbuilder = "!";
        } else
        {
            stringbuilder = "?";
        }
        outputsettings.append(stringbuilder).append(getWholeDeclaration()).append(">");
    }

    void outerHtmlTail(StringBuilder stringbuilder, int i, Document.OutputSettings outputsettings)
    {
    }

    public String toString()
    {
        return outerHtml();
    }
}
