// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.home;

import com.amazon.mShop.control.BaseController;
import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.customclientfields.CustomClientFields;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.BasicProductsRequest;
import com.amazon.rio.j2me.client.services.mShop.BasicProductsResponse;
import com.amazon.rio.j2me.client.services.mShop.BasicProductsResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import java.util.List;
import java.util.Vector;

// Referenced classes of package com.amazon.mShop.control.home:
//            BasicProductsSubscriber

public class BasicProductsController extends BaseController
    implements BasicProductsResponseListener
{

    private BasicProductsSubscriber mBasicProductsSubscriber;

    public BasicProductsController(BasicProductsSubscriber basicproductssubscriber)
    {
        mBasicProductsSubscriber = basicproductssubscriber;
    }

    public void cancelled(ServiceCall servicecall)
    {
    }

    public void completed(final BasicProductsResponse response, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final BasicProductsController this$0;
            final BasicProductsResponse val$response;
            final ServiceCall val$sc;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    serviceCallCompleted();
                    mBasicProductsSubscriber.onBasicProductsReceived(response);
                }
            }

            
            {
                this$0 = BasicProductsController.this;
                sc = servicecall;
                response = basicproductsresponse;
                super();
            }
        });
    }

    public void error(final Exception exp, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final BasicProductsController this$0;
            final Exception val$exp;
            final ServiceCall val$sc;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    serviceCallCompleted();
                    mBasicProductsSubscriber.onError(exp, sc);
                }
            }

            
            {
                this$0 = BasicProductsController.this;
                sc = servicecall;
                exp = exception;
                super();
            }
        });
    }

    protected volatile GenericSubscriber getSubscriber()
    {
        return getSubscriber();
    }

    protected BasicProductsSubscriber getSubscriber()
    {
        return mBasicProductsSubscriber;
    }

    public void requestBasicProducts(List list, String s)
    {
        BasicProductsRequest basicproductsrequest = new BasicProductsRequest();
        if (list != null)
        {
            list = new Vector(list);
        } else
        {
            list = null;
        }
        basicproductsrequest.setAsins(list);
        CustomClientFields.setCustomHeaderFields("basic_products_v32", true, s);
        serviceCallStarted(ServiceController.getMShopService().basicProducts(basicproductsrequest, this), null);
    }





}
