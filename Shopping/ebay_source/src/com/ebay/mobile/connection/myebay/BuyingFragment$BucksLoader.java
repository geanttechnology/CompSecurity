// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.myebay;

import android.content.AsyncTaskLoader;
import android.content.Context;
import com.ebay.common.model.cart.Incentive;
import com.ebay.common.model.cart.UserIncentives;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.connection.myebay:
//            BuyingFragment

private static class auth extends AsyncTaskLoader
{

    private final Authentication auth;
    private final EbayContext context;
    private Incentive eBayBucks;
    private ResultStatus status;

    public Incentive loadInBackground()
    {
        Object obj;
        Object obj1;
        obj1 = new com.ebay.common.net.api.cart.centivesRequest(EbayApiUtil.getCartApi(getContext(), auth), com.ebay.common.net.api.cart.tiveType.VOUCHER);
        obj = null;
        obj1 = (com.ebay.common.net.api.cart.centivesResponse)context.getConnector().sendRequest(((com.ebay.nautilus.kernel.net.Request) (obj1)));
        obj = obj1;
        status = ((com.ebay.common.net.api.cart.centivesResponse) (obj1)).getResultStatus();
        obj = obj1;
_L2:
label0:
        {
            if (obj == null || status == null || status.hasError())
            {
                break label0;
            }
            obj = ((com.ebay.common.net.api.cart.centivesResponse) (obj)).getUserIncentives();
            if (obj == null)
            {
                break label0;
            }
            obj = ((UserIncentives) (obj)).incentives;
            if (obj == null || ((List) (obj)).size() <= 0)
            {
                break label0;
            }
            obj = ((List) (obj)).iterator();
            Incentive incentive;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                incentive = (Incentive)((Iterator) (obj)).next();
            } while (!incentive.discountType.equals("AMOUNT"));
            eBayBucks = incentive;
        }
        return eBayBucks;
        InterruptedException interruptedexception;
        interruptedexception;
        interruptedexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    protected void onStartLoading()
    {
        if (status != null && !status.hasError())
        {
            deliverResult(eBayBucks);
            return;
        } else
        {
            forceLoad();
            return;
        }
    }

    public vesResponse(EbayContext ebaycontext, Authentication authentication)
    {
        super((Context)ebaycontext.getExtension(android/content/Context));
        context = ebaycontext;
        auth = authentication;
    }
}
