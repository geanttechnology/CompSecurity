// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.nautilus.kernel.util:
//            SaxHandler

public static abstract class  extends 
{

    public  get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        throw new SAXNotRecognizedException(s1);
    }

    public boolean isTextElement()
    {
        return true;
    }

    public abstract void text(String s)
        throws SAXException;

    public ()
    {
    }
}
