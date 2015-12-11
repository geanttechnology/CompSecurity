// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;

import java.util.Set;

// Referenced classes of package com.ebay.nautilus.kernel.content:
//            EbayContext

public class EbayContextWrapper extends EbayContext
{

    private final EbayContext base;

    public EbayContextWrapper(EbayContext ebaycontext)
    {
        if (ebaycontext == null)
        {
            throw new IllegalArgumentException("baseContext is null");
        } else
        {
            base = ebaycontext;
            return;
        }
    }

    public EbayContext getApplicationContext()
    {
        return base.getApplicationContext();
    }

    public final EbayContext getBaseContext()
    {
        return base;
    }

    public Object getExtension(EbayContext ebaycontext, Class class1)
    {
        return base.getExtension(ebaycontext, class1);
    }

    public Set getExtensionTypes()
    {
        return base.getExtensionTypes();
    }
}
