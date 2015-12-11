// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.search;

import com.amazon.mShop.control.BaseController;
import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.AdvSearchSuggestionsRequest;
import com.amazon.rio.j2me.client.services.mShop.AdvSearchSuggestionsResponse;
import com.amazon.rio.j2me.client.services.mShop.AdvSearchSuggestionsResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;

// Referenced classes of package com.amazon.mShop.control.search:
//            AdvSearchSuggestionsSubscriber

public class AdvSearchSuggestionsController extends BaseController
    implements AdvSearchSuggestionsResponseListener
{

    private AdvSearchSuggestionsRequest mAdvSearchSuggestionsRequest;
    private final AdvSearchSuggestionsSubscriber mSubscriber;

    public AdvSearchSuggestionsController(AdvSearchSuggestionsSubscriber advsearchsuggestionssubscriber)
    {
        mSubscriber = advsearchsuggestionssubscriber;
        mAdvSearchSuggestionsRequest = new AdvSearchSuggestionsRequest();
        mAdvSearchSuggestionsRequest.setMaxSuggestions(Integer.valueOf(10));
    }

    public void completed(final AdvSearchSuggestionsResponse value, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final AdvSearchSuggestionsController this$0;
            final ServiceCall val$sc;
            final AdvSearchSuggestionsResponse val$value;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    serviceCallCompleted();
                    mSubscriber.onSearchSuggestionsReceived(value.getSuggestions());
                }
            }

            
            {
                this$0 = AdvSearchSuggestionsController.this;
                sc = servicecall;
                value = advsearchsuggestionsresponse;
                super();
            }
        });
    }

    public void getSearchSuggestions(String s)
    {
        mAdvSearchSuggestionsRequest.setQuery(s);
        cancel();
        serviceCallStarted(com.amazon.mShop.platform.Platform.Factory.getInstance().getMShopService().advSearchSuggestions(mAdvSearchSuggestionsRequest, this), null);
    }

    protected volatile GenericSubscriber getSubscriber()
    {
        return getSubscriber();
    }

    protected AdvSearchSuggestionsSubscriber getSubscriber()
    {
        return mSubscriber;
    }



}
