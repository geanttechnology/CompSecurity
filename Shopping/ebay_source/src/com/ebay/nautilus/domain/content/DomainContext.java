// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.content.dm.UserContext;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.EbayContextFactories;
import com.ebay.nautilus.kernel.content.KernelContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.AsBeaconManager;
import com.ebay.nautilus.kernel.net.Connector;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            EbayPreferences, EbayPreferencesImpl

public class DomainContext extends KernelContext
{
    public static interface Factory
    {

        public abstract EbayAppCredentials createApplicationCredentials(EbayContext ebaycontext);

        public abstract SharedPreferences getDomainSharedPreferences();

        public abstract void rewriteServiceErrors(EbayContext ebaycontext, ResultStatus resultstatus);
    }

    private static final class Init
    {

        protected final Factory appFactory;

        public void addDomainContextFactories(EbayContextFactories ebaycontextfactories)
        {
            ebaycontextfactories.put(com/ebay/nautilus/kernel/net/Connector, new ConnectorFactory()).put(com/ebay/nautilus/domain/EbayAppCredentials, new AppCredentialsFactory()).put(com/ebay/nautilus/domain/content/EbayPreferences, new PreferencesFactory()).put(com/ebay/nautilus/domain/content/dm/UserContext, new UserContextFactory()).put(com/ebay/nautilus/kernel/net/AsBeaconManager, new PersistentAsBeaconManagerFactory());
        }

        public Init(Factory factory)
        {
            if (factory == null)
            {
                throw new IllegalArgumentException("factory is null");
            } else
            {
                appFactory = factory;
                return;
            }
        }
    }

    private final class Init.AppCredentialsFactory extends com.ebay.nautilus.kernel.content.EbayContextFactory.Single
    {

        final Init this$0;

        protected EbayAppCredentials create(EbayContext ebaycontext)
        {
            return appFactory.createApplicationCredentials(ebaycontext);
        }

        protected volatile Object create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        private Init.AppCredentialsFactory()
        {
            this$0 = Init.this;
            super();
        }

    }

    private final class Init.ConnectorFactory extends com.ebay.nautilus.kernel.content.EbayContextFactory.Single
    {

        final Init this$0;

        public Connector create(EbayContext ebaycontext)
        {
            return new Init.DomainConnector(ebaycontext);
        }

        public volatile Object create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        private Init.ConnectorFactory()
        {
            this$0 = Init.this;
            super();
        }

    }

    private final class Init.DomainConnector extends com.ebay.nautilus.kernel.net.Connector.Impl
    {

        final Init this$0;

        public Response sendRequest(Request request)
            throws InterruptedException
        {
            request = super.sendRequest(request);
            ResultStatus resultstatus = request.getResultStatus();
            if (resultstatus.hasMessage())
            {
                appFactory.rewriteServiceErrors(ebayContext, resultstatus);
            }
            return request;
        }

        public Init.DomainConnector(EbayContext ebaycontext)
        {
            this$0 = Init.this;
            super(ebaycontext);
        }
    }

    private final class Init.PreferencesFactory extends com.ebay.nautilus.kernel.content.EbayContextFactory.Single
    {

        final Init this$0;

        protected EbayPreferences create(EbayContext ebaycontext)
        {
            return new EbayPreferencesImpl((UserContext)ebaycontext.getExtension(com/ebay/nautilus/domain/content/dm/UserContext), "com.ebay.nautilus.domain", appFactory.getDomainSharedPreferences());
        }

        protected volatile Object create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        private Init.PreferencesFactory()
        {
            this$0 = Init.this;
            super();
        }

    }

    private final class Init.UserContextFactory extends com.ebay.nautilus.kernel.content.EbayContextFactory.Single
    {

        final Init this$0;

        protected UserContext create(EbayContext ebaycontext)
        {
            return new UserContext(ebaycontext);
        }

        protected volatile Object create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        private Init.UserContextFactory()
        {
            this$0 = Init.this;
            super();
        }

    }

    private static final class PersistentAsBeaconManager extends AsBeaconManager
    {

        static final String ID_KEY = "app_speed_beacon_id";
        final EbayPreferences prefs;

        public int nextIdentifier()
        {
            int i = super.nextIdentifier();
            EbayPreferences.Editor editor = prefs.edit();
            editor.putInt(false, "app_speed_beacon_id", i);
            editor.commit();
            return i;
        }

        PersistentAsBeaconManager(EbayContext ebaycontext)
        {
            prefs = DomainContext.getPreferences(ebaycontext);
            id = prefs.getInt(false, "app_speed_beacon_id", 0);
        }
    }

    private static final class PersistentAsBeaconManagerFactory extends com.ebay.nautilus.kernel.content.EbayContextFactory.Single
    {

        protected AsBeaconManager create(EbayContext ebaycontext)
        {
            return new PersistentAsBeaconManager(ebaycontext);
        }

        protected volatile Object create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        private PersistentAsBeaconManagerFactory()
        {
        }

    }


    protected DomainContext()
    {
    }

    public DomainContext(Application application, Factory factory)
    {
        addDomainContextFactories(application, factories, factory);
    }

    public static void addDomainContextFactories(Context context, EbayContextFactories ebaycontextfactories, Factory factory)
    {
        addKernelContextFactories(context, ebaycontextfactories);
        (new Init(factory)).addDomainContextFactories(ebaycontextfactories);
    }

    public static EbayPreferences getPreferences(EbayContext ebaycontext)
    {
        return (EbayPreferences)ebaycontext.getExtension(com/ebay/nautilus/domain/content/EbayPreferences);
    }
}
