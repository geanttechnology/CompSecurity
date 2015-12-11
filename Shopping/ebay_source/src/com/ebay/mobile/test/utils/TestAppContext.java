// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.test.utils;

import com.ebay.nautilus.domain.test.utils.TestDomainContext;
import com.ebay.nautilus.kernel.content.EbayAppInfo;
import com.ebay.nautilus.kernel.content.EbayAppInfoImpl;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.EbayContextFactory;
import com.ebay.nautilus.kernel.test.utils.AnnotationHelper;
import com.ebay.nautilus.kernel.test.utils.TestEbayContext;

public final class TestAppContext
{

    private static final EbayContextFactory appInfoFactory = new com.ebay.nautilus.kernel.content.EbayContextFactory.Single() {

        protected EbayAppInfo create(EbayContext ebaycontext)
        {
            return new EbayAppInfoImpl("com.ebay.mobile", "4.1.5.22", false);
        }

        protected volatile Object create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

    };

    public TestAppContext()
    {
    }

    public static TestEbayContext create(AnnotationHelper annotationhelper)
    {
        annotationhelper = TestDomainContext.create(annotationhelper);
        annotationhelper.setExtension(com/ebay/nautilus/kernel/content/EbayAppInfo, appInfoFactory);
        return annotationhelper;
    }

}
