// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.nodes;


// Referenced classes of package org.jsoup.nodes:
//            Node, Attributes, Entities

public class DataNode extends Node
{

    private static final String DATA_KEY = "data";

    public DataNode(String s, String s1)
    {
        super(s1);
        attributes.put("data", s);
    }

    public static DataNode createFromEncoded(String s, String s1)
    {
        return new DataNode(Entities.unescape(s), s1);
    }

    public String getWholeData()
    {
        return attributes.get("data");
    }

    public String nodeName()
    {
        return "#data";
    }

    void outerHtmlHead(StringBuilder stringbuilder, int i, Document.OutputSettings outputsettings)
    {
        stringbuilder.append(getWholeData());
    }

    void outerHtmlTail(StringBuilder stringbuilder, int i, Document.OutputSettings outputsettings)
    {
    }

    public DataNode setWholeData(String s)
    {
        attributes.put("data", s);
        return this;
    }

    public String toString()
    {
        return outerHtml();
    }
}
