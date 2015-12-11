// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import java.util.ArrayList;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            ErrorElement

static final class index extends com.ebay.nautilus.kernel.util.ndex
{

    private final int index;
    private final ArrayList parameters;

    public void text(String s)
        throws SAXException
    {
        if (index != -1)
        {
            parameters.set(index, s);
            return;
        } else
        {
            parameters.add(s);
            return;
        }
    }

    public (ArrayList arraylist, int i)
    {
        parameters = arraylist;
        index = i;
    }
}
