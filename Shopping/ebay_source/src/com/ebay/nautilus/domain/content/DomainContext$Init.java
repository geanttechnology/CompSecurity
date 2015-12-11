// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.content.dm.UserContext;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.EbayContextFactories;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.AsBeaconManager;
import com.ebay.nautilus.kernel.net.Connector;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            DomainContext, EbayPreferences, EbayPreferencesImpl

private static final class appFactory
{
    private final class AppCredentialsFactory extends com.ebay.nautilus.kernel.content.EbayContextFactory.Single
    {

        final DomainContext.Init this$0;

        protected EbayAppCredentials create(EbayContext ebaycontext)
        {
            return appFactory.createApplicationCredentials(ebaycontext);
        }

        protected volatile Object create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        private AppCredentialsFactory()
        {
            this$0 = DomainContext.Init.this;
            super();
        }

        AppCredentialsFactory(DomainContext._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ConnectorFactory extends com.ebay.nautilus.kernel.content.EbayContextFactory.Single
    {

        final DomainContext.Init this$0;

        public Connector create(EbayContext ebaycontext)
        {
            return new DomainConnector(ebaycontext);
        }

        public volatile Object create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        private ConnectorFactory()
        {
            this$0 = DomainContext.Init.this;
            super();
        }

        ConnectorFactory(DomainContext._cls1 _pcls1)
        {
            this();
        }
    }

    private final class DomainConnector extends com.ebay.nautilus.kernel.net.Connector.Impl
    {

        final DomainContext.Init this$0;

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

        public DomainConnector(EbayContext ebaycontext)
        {
            this$0 = DomainContext.Init.this;
            super(ebaycontext);
        }
    }

    private final class PreferencesFactory extends com.ebay.nautilus.kernel.content.EbayContextFactory.Single
    {

        final DomainContext.Init this$0;

        protected EbayPreferences create(EbayContext ebaycontext)
        {
            return new EbayPreferencesImpl((UserContext)ebaycontext.getExtension(com/ebay/nautilus/domain/content/dm/UserContext), "com.ebay.nautilus.domain", appFactory.getDomainSharedPreferences());
        }

        protected volatile Object create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        private PreferencesFactory()
        {
            this$0 = DomainContext.Init.this;
            super();
        }

        PreferencesFactory(DomainContext._cls1 _pcls1)
        {
            this();
        }
    }

    private final class UserContextFactory extends com.ebay.nautilus.kernel.content.EbayContextFactory.Single
    {

        final DomainContext.Init this$0;

        protected UserContext create(EbayContext ebaycontext)
        {
            return new UserContext(ebaycontext);
        }

        protected volatile Object create(EbayContext ebaycontext)
        {
            return create(ebaycontext);