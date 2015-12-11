// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.nautilus.kernel.util:
//            SaxHandler

public static abstract class  extends 
{

    protected abstract void setValue(double d)
        throws SAXException;

    public void text(String s)
        throws SAXException
    {
        try
        {
            setValue(Double.parseDouble(s));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new SAXNotRecognizedException(s.getLocalizedMessage());
        }
    }

    public ()
    {
    }
}
