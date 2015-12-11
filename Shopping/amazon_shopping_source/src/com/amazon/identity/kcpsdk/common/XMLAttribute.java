// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;

import org.w3c.dom.Element;

// Referenced classes of package com.amazon.identity.kcpsdk.common:
//            XMLEntity

public class XMLAttribute extends XMLEntity
{

    private final String mKey;
    private final String mValue;

    public XMLAttribute(String s, String s1)
    {
        mKey = s;
        mValue = s1;
    }

    void toXML(Element element)
    {
        element.setAttribute(mKey, mValue);
    }
}
