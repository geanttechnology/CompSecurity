// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.net.api.ecas.EcasApiContext;
import com.ebay.nautilus.domain.net.api.ecas.EcasApiRequest;
import com.ebay.nautilus.domain.net.api.ecas.EcasApiResponse;
import com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCart;
import com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCartResponse;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            EcasShoppingCartDataManager

public abstract class shoppingApiContext extends shoppingApiContext
{

    protected final EcasApiContext ecasApiContext;
    protected final EbayShoppingApi shoppingApiContext;
    final EcasShoppingCartDataManager this$0;

    protected abstract EcasApiRequest createRequest();

    protected transient Content doInBackground(Void avoid[])
    {
        avoid = new ResultStatusOwner();
        EcasApiResponse ecasapiresponse = (EcasApiResponse)EcasShoppingCartDataManager.access$100(EcasShoppingCartDataManager.this, createRequest(), avoid);
        if (ecasapiresponse != null && !avoid.getResultStatus().hasError() && ecasapiresponse.casResponse != null)
        {
            return new Content(ecasapiresponse.casResponse, ecasapiresponse.getResultStatus());
        } else
        {
            return new Content(avoid.getResultStatus());
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Content content)
    {
        super.stExecute(content);
        if ((!content.getStatus().hasError() || action.action) && content.getData() != null)
        {
            EcasShoppingCartResponse ecasshoppingcartresponse = (EcasShoppingCartResponse)content.getData();
            if (ecasshoppingcartresponse != null && ecasshoppingcartresponse.shoppingCart != null)
            {
                content = ecasshoppingcartresponse.shoppingCart.getItemIds();
            } else
            {
                content = Collections.emptyList();
            }
            content = new ArrayList(content);
            if (!content.isEmpty() && action.lData)
            {
                outstandingTasks.add(DataManager.executeOnThreadPool(new <init>(EcasShoppingCartDataManager.this, shoppingApiContext, ecasshoppingcartresponse, siteId, itemId, userId, action, caller), content.toArray(new Long[0])));
            } else
            {
                outstandingTasks.add(DataManager.executeOnThreadPool(new k(EcasShoppingCartDataManager.this, ecasshoppingcartresponse, Collections.emptyList(), siteId, itemId, userId, action, caller), new Void[0]));
            }
            outstandingTasks.remove(this);
            return;
        }
        outstandingTasks.remove(this);
        if (caller != null)
        {
            caller.rtChanged(EcasShoppingCartDataManager.this, action, new Content(content.getStatus()));
            return;
        } else
        {
            ((action)EcasShoppingCartDataManager.access$200(EcasShoppingCartDataManager.this)).rtChanged(EcasShoppingCartDataManager.this, action, new Content(content.getStatus()));
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    protected void onPreExecute()
    {
        super.eExecute();
        if (caller != null)
        {
            caller.rtLoading(EcasShoppingCartDataManager.this, action);
            return;
        } else
        {
            ((action)EcasShoppingCartDataManager.access$000(EcasShoppingCartDataManager.this)).rtLoading(EcasShoppingCartDataManager.this, action);
            return;
        }
    }

    protected k(k k, EcasApiContext ecasapicontext, EbayShoppingApi ebayshoppingapi, String s, String s1, k k1, 
            String s2)
    {
        this$0 = EcasShoppingCartDataManager.this;
        super(EcasShoppingCartDataManager.this, k, s, s1, s2, k1);
        ecasApiContext = ecasapicontext;
        shoppingApiContext = ebayshoppingapi;
    }
}
