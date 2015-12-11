// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            c

public final class g extends c
{

    public final StringBuilder c = new StringBuilder();

    public g(c c1)
    {
        super(c1);
    }

    public final volatile Object a()
    {
        return c.toString();
    }

    public final void characters(char ac[], int i, int j)
        throws SAXException
    {
        c.append(ac, i, j);
    }

    public final void startElement(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        c.setLength(0);
    }
}
