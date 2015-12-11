// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view;

import android.content.Context;
import com.ebay.mobile.AppSettings;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.EbayContextFactories;
import java.util.Collections;
import java.util.Set;

// Referenced classes of package com.ebay.common.view:
//            EbaySearchProvider

private static final class factories extends EbayContext
{

    private final EbayContextFactories factories = new EbayContextFactories();

    public EbayContext getApplicationContext()
    {
        return this;
    }

    protected Object getExtension(EbayContext ebaycontext, Class class1)
    {
        return factories.get(class1, ebaycontext);
    }

    public Set getExtensionTypes()
    {
        return Collections.unmodifiableSet(factories.keySet());
    }

    public (Context context)
    {
        AppSettings.init(context).addContextFactories(context, factories);
    }
}
