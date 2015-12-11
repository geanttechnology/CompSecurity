// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;


// Referenced classes of package com.ebay.nautilus.kernel.content:
//            EbayContextFactory, EbayContext

public static final class o
    implements EbayContextFactory
{

    private final Object o;

    public Object get(EbayContext ebaycontext)
    {
        return o;
    }

    public (Object obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("o is null");
        } else
        {
            o = obj;
            return;
        }
    }
}
