// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.kernel.util:
//            SaxHandler

public static class 
{

    private static final reuseElement reuseElement = new <init>();

    public void endElement()
        throws SAXException
    {
    }

    public  get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        return reuseElement;
    }

    public boolean isTextElement()
    {
        return false;
    }

    public void text(String s)
        throws SAXException
    {
    }


    public ()
    {
    }
}
