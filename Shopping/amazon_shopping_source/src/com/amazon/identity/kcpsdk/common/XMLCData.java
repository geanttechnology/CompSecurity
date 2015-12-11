// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package com.amazon.identity.kcpsdk.common:
//            XMLEntity

public class XMLCData extends XMLEntity
{

    private final String mCData;

    public XMLCData(String s)
    {
        mCData = s;
    }

    void toXML(Element element)
    {
        element.appendChild(element.getOwnerDocument().createCDATASection(mCData));
    }
}
