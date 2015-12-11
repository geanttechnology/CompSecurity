// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.net.Connector;
import java.util.Collections;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.kernel.content:
//            EbayContext, EbayContextFactories, EbayAppInfo, EbayResources, 
//            EbayContextFactory

public class KernelContext extends EbayContext
{
    private static final class AppInfoFactory extends EbayContextFactory.Single
    {

        public EbayAppInfo create(EbayContext ebaycontext)
        {
            return NautilusKernel.getAppInfo((Context)ebaycontext.getExtension(android/content/Context));
        }

        public volatile Object create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        private AppInfoFactory()
        {
        }

    }

    private static final class ConnectorFactory
        implements EbayContextFactory
    {

        public Connector get(EbayContext ebaycontext)
        {
            return new com.ebay.nautilus.kernel.net.Connector.Impl(ebaycontext);
        }

        public volatile Object get(EbayContext ebaycontext)
        {
            return get(ebaycontext);
        }

        private ConnectorFactory()
        {
        }

    }

    private static final class ResourcesFactory extends ContextWrapper
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

        public ResourcesFactory(Context context)
        {
            super(context);
        }
    }


    private static EbayContext singleBaseContext;
    protected final EbayContextFactories factories;

    protected KernelContext()
    {
        factories = new EbayContextFactories();
        if (singleBaseContext != null)
        {
            throw new RuntimeException("There must be exactly one");
        } else
        {
            singleBaseContext = this;
            return;
        }
    }

    public KernelContext(Application application)
    {
        this();
        addKernelContextFactories(application, factories);
    }

    public static void addKernelContextFactories(Context context, EbayContextFactories ebaycontextfactories)
    {
        ebaycontextfactories.put(android/content/Context, new EbayContextFactory.Constant(context)).put(com/ebay/nautilus/kernel/net/Connector, new ConnectorFactory()).put(com/ebay/nautilus/kernel/content/EbayAppInfo, new AppInfoFactory()).put(com/ebay/nautilus/kernel/content/EbayResources, new ResourcesFactory(context));
    }

    public static EbayContext getSingleBaseContext(Application application)
    {
        com/ebay/nautilus/kernel/content/KernelContext;
        JVM INSTR monitorenter ;
        if (singleBaseContext == null)
        {
            singleBaseContext = new KernelContext(application);
        }
        application = singleBaseContext;
        com/ebay/nautilus/kernel/content/KernelContext;
        JVM INSTR monitorexit ;
        return application;
        application;
        throw application;
    }

    public EbayContext getApplicationContext()
    {
        return this;
    }

    public Object getExtension(EbayContext ebaycontext, Class class1)
    {
        return factories.get(class1, ebaycontext);
    }

    public Set getExtensionTypes()
    {
        return Collections.unmodifiableSet(factories.keySet());
    }
}
