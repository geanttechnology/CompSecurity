// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.test.utils;

import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.content.EbayPreferences;
import com.ebay.nautilus.domain.content.EbayPreferencesImpl;
import com.ebay.nautilus.domain.content.dm.UserContext;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.EbayContextFactory;
import com.ebay.nautilus.kernel.test.utils.AnnotationHelper;
import com.ebay.nautilus.kernel.test.utils.TestEbayContext;
import com.ebay.nautilus.kernel.test.utils.TestSharedPreferences;

// Referenced classes of package com.ebay.nautilus.domain.test.utils:
//            TestUserContext

public final class TestDomainContext
{
    private static final class EbayPreferencesFactory extends com.ebay.nautilus.kernel.content.EbayContextFactory.Single
    {

        protected EbayPreferences create(EbayContext ebaycontext)
        {
            return new EbayPreferencesImpl((UserContext)ebaycontext.getExtension(com/ebay/nautilus/domain/content/dm/UserContext), "com.ebay.nautilus.domain", new TestSharedPreferences());
        }

        protected volatile Object create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        private EbayPreferencesFactory()
        {
        }

    }


    private static final EbayContextFactory ebayCredentialsFactory = new com.ebay.nautilus.kernel.content.EbayContextFactory.Constant(new EbayAppCredentials("dummyTracking", "dummyAppId", "dummyName", "dummyDevId", "dummyCert", "dummyPaypalAppId", "dummyUserAgent"));

    public TestDomainContext()
    {
    }

    public static TestEbayContext create(AnnotationHelper annotationhelper)
    {
        TestEbayContext testebaycontext = new TestEbayContext();
        testebaycontext.setExtension(com/ebay/nautilus/domain/EbayAppCredentials, ebayCredentialsFactory);
        testebaycontext.setExtension(com/ebay/nautilus/domain/content/EbayPreferences, new EbayPreferencesFactory());
        testebaycontext.setExtension(com/ebay/nautilus/domain/content/dm/UserContext, new TestUserContext(testebaycontext, annotationhelper));
        return testebaycontext;
    }

}
