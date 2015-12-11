// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.kernel.util:
//            SaxHandler

public static abstract class  extends 
{

    protected abstract void setValue(boolean flag)
        throws SAXException;

    public void text(String s)
        throws SAXException
    {
        setValue(Boolean.parseBoolean(s));
    }

    public ()
    {
    }
}
