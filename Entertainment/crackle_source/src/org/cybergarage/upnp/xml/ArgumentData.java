// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.xml;


// Referenced classes of package org.cybergarage.upnp.xml:
//            NodeData

public class ArgumentData extends NodeData
{

    private String value;

    public ArgumentData()
    {
        value = "";
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String s)
    {
        value = s;
    }
}
