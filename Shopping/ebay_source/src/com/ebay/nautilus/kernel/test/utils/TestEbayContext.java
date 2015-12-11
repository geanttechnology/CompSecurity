// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.test.utils;

import android.util.Log;
import com.ebay.nautilus.kernel.content.EbayAppInfo;
import com.ebay.nautilus.kernel.content.EbayAppInfoImpl;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.EbayContextFactories;
import com.ebay.nautilus.kernel.content.EbayContextFactory;
import com.ebay.nautilus.kernel.content.EbayResources;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TestEbayContext extends EbayContext
{
    private static final class ResourcesFactory
        implements EbayContextFactory, EbayResources
    {

        public EbayResources get(EbayContext ebaycontext)
        {
            return this;
        }

        public volatile Object get(EbayContext ebaycontext)
        {
            return get(ebaycontext);
        }

        public String getString(int i)
        {
            return "test case";
        }

        public transient String getString(int i, Object aobj[])
        {
            return "test case";
        }

        private ResourcesFactory()
        {
        }

    }


    private static final EbayContextFactory appInfoFactory = new com.ebay.nautilus.kernel.content.EbayContextFactory.SingleWrap(new com.ebay.nautilus.kernel.content.EbayContextFactory.Constant(new EbayAppInfoImpl("APPLICATION_ID", "0.0.0.0", true)));
    private static final ResourcesFactory resourceFactory = new ResourcesFactory();
    private final EbayContextFactories factories;

    public TestEbayContext()
    {
        factories = (new EbayContextFactories()).put(com/ebay/nautilus/kernel/content/EbayAppInfo, appInfoFactory).put(com/ebay/nautilus/kernel/content/EbayResources, resourceFactory);
    }

    public EbayContext getApplicationContext()
    {
        return this;
    }

    public Object getExtension(EbayContext ebaycontext, Class class1)
    {
        ebaycontext = ((EbayContext) (factories.get(class1, ebaycontext)));
        if (ebaycontext == null)
        {
            Log.e("UnitTest", (new StringBuilder()).append("Attempt to get ").append(class1.getName()).append(" failed").toString());
        }
        return ebaycontext;
    }

    public Set getExtensionTypes()
    {
        return Collections.unmodifiableSet(new HashSet(factories.keySet()));
    }

    public final EbayContextFactory getFactory(Class class1)
    {
        return factories.getFactory(class1);
    }

    public final TestEbayContext setExtension(Class class1, EbayContextFactory ebaycontextfactory)
    {
        if (class1 == null)
        {
            throw new IllegalArgumentException("type is null");
        }
        if (ebaycontextfactory == null)
        {
            throw new IllegalArgumentException("factory is null");
        } else
        {
            factories.put(class1, ebaycontextfactory);
            return this;
        }
    }

    public final TestEbayContext setExtension(Class class1, Object obj)
    {
        return setExtension(class1, ((EbayContextFactory) (new com.ebay.nautilus.kernel.content.EbayContextFactory.Constant(obj))));
    }

}
