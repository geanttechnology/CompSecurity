// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.app.Application;
import android.content.Context;
import com.ebay.common.PrefUserContext;
import com.ebay.nautilus.domain.content.DomainContext;
import com.ebay.nautilus.domain.content.dm.UserContext;
import com.ebay.nautilus.kernel.content.EbayAppInfo;
import com.ebay.nautilus.kernel.content.EbayAppInfoImpl;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.EbayContextFactories;

// Referenced classes of package com.ebay.mobile:
//            AppSettings

public class AppContext extends DomainContext
{
    private static final class AppInfoFactory extends com.ebay.nautilus.kernel.content.EbayContextFactory.Single
    {

        public EbayAppInfo create(EbayContext ebaycontext)
        {
            return new EbayAppInfoImpl("com.ebay.mobile", "4.1.5.22", false);
        }

        public volatile Object create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        private AppInfoFactory()
        {
        }

    }

    private static final class UserContextFactory extends com.ebay.nautilus.kernel.content.EbayContextFactory.Single
    {

        protected UserContext create(EbayContext ebaycontext)
        {
            return new PrefUserContext(ebaycontext);
        }

        protected volatile Object create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        private UserContextFactory()
        {
        }

    }


    public AppContext(Application application)
    {
        addAppContextFactories(application, factories, AppSettings.inst);
    }

    public static void addAppContextFactories(Context context, EbayContextFactories ebaycontextfactories, com.ebay.nautilus.domain.content.DomainContext.Factory factory)
    {
        addDomainContextFactories(context, ebaycontextfactories, factory);
        ebaycontextfactories.put(com/ebay/nautilus/domain/content/dm/UserContext, new UserContextFactory()).put(com/ebay/nautilus/kernel/content/EbayAppInfo, new AppInfoFactory());
    }
}
