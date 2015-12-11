// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.nautilus.kernel.util:
//            SaxHandler

private static final class child
{

    private child child;
    public nt element;
    public final nt parent;

    public final child get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        s = element.get(s, s1, s2, attributes);
        if (s == null)
        {
            throw new SAXNotRecognizedException(s1);
        }
        if (child != null)
        {
            child.element = s;
        } else
        {
            child = new <init>(this, s);
        }
        return child;
    }

    public nt(nt nt, nt nt1)
    {
        parent = nt;
        element = nt1;
        child = null;
    }
}
