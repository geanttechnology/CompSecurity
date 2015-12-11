// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;

import com.ebay.nautilus.kernel.net.Connector;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.kernel.content:
//            EbayAppInfo, EbayResources

public abstract class EbayContext
{

    public EbayContext()
    {
    }

    public final EbayAppInfo getAppInfo()
    {
        return (EbayAppInfo)getExtension(com/ebay/nautilus/kernel/content/EbayAppInfo);
    }

    public abstract EbayContext getApplicationContext();

    public EbayContext getBaseContext()
    {
        return null;
    }

    public final Connector getConnector()
    {
        return (Connector)getExtension(com/ebay/nautilus/kernel/net/Connector);
    }

    protected abstract Object getExtension(EbayContext ebaycontext, Class class1);

    public final Object getExtension(Class class1)
    {
        return getExtension(this, class1);
    }

    public abstract Set getExtensionTypes();

    public final EbayResources getResources()
    {
        return (EbayResources)getExtension(com/ebay/nautilus/kernel/content/EbayResources);
    }

    public final String getString(int i)
    {
        return getResources().getString(i);
    }

    public final transient String getString(int i, Object aobj[])
    {
        return getResources().getString(i, aobj);
    }
}
