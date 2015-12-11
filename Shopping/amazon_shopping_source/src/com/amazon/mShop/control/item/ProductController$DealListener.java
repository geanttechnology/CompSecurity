// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.item;

import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.customclientfields.CustomClientFields;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.Deal;
import com.amazon.rio.j2me.client.services.mShop.DealRequest;
import com.amazon.rio.j2me.client.services.mShop.DealResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;

// Referenced classes of package com.amazon.mShop.control.item:
//            ProductController

private class <init>
    implements DealResponseListener
{

    private ServiceCall dealServiceCall;
    final ProductController this$0;

    public void cancel()
    {
        if (dealServiceCall != null)
        {
            dealServiceCall.cancel();
            dealServiceCall = null;
        }
    }

    public void cancelled(ServiceCall servicecall)
    {
    }

    public void completed(ServiceCall servicecall)
    {
    }

    public void error(final Exception e, final ServiceCall sc)
    {
        com.amazon.mShop.platform.ner().invokeLater(new Runnable() {

            final ProductController.DealListener this$1;
            final Exception val$e;
            final ServiceCall val$sc;

            public void run()
            {
                if (sc == dealServiceCall)
                {
                    ProductController.access$1000(this$0, e, sc);
                }
            }

            
            {
                this$1 = ProductController.DealListener.this;
                sc = servicecall;
                e = exception;
                super();
            }
        });
    }

    public void receivedDeal(final Deal value, final ServiceCall sc)
    {
        if (value.getMsToStart() != null)
        {
            value.setMsToStart(Integer.valueOf((int)(System.currentTimeMillis() / 1000L + (long)(value.getMsToStart().intValue() / 1000))));
        }
        if (value.getMsToEnd() != null)
        {
            value.setMsToEnd(Integer.valueOf((int)(System.currentTimeMillis() / 1000L + (long)(value.getMsToEnd().intValue() / 1000))));
        }
        com.amazon.mShop.platform.().invokeLater(new Runnable() {

            final ProductController.DealListener this$1;
            final ServiceCall val$sc;
            final Deal val$value;

            public void run()
            {
                if (sc == dealServiceCall)
                {
                    setDeal(value);
                    ProductController.access$3100(this$0);
                }
            }

            
            {
                this$1 = ProductController.DealListener.this;
                sc = servicecall;
                value = deal;
                super();
            }
        });
    }

    public void requestDeal(String s)
    {
        cancel();
        DealRequest dealrequest = new DealRequest();
        dealrequest.setDealId(s);
        dealrequest.setShowVariations(Boolean.valueOf(true));
        dealrequest.setAsin(ProductController.access$3600(ProductController.this));
        CustomClientFields.setCustomHeaderFields("deal_v32", true, ProductController.access$1200(ProductController.this));
        dealServiceCall = ServiceController.getMShopService().deal(dealrequest, this);
    }


    private _cls2.val.e()
    {
        this$0 = ProductController.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
