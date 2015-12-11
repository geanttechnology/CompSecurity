// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.net.api.ecas.CreateCheckoutSessionRequest;
import com.ebay.nautilus.domain.net.api.ecas.EcasApiContext;
import com.ebay.nautilus.domain.net.api.ecas.EcasApiResponse;
import com.ebay.nautilus.domain.net.api.ecas.models.EcasCheckoutResponse;
import com.ebay.nautilus.domain.net.api.ecas.models.EcasCheckoutSessionAdapter;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            EcasShoppingCartDataManager

public final class clientAttributes extends clientAttributes
{

    private final EcasApiContext apiContext;
    private final Long cartId;
    Map clientAttributes;
    private final List shoppingCartLineItemIds;
    final EcasShoppingCartDataManager this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        avoid = new ResultStatusOwner();
        EcasApiResponse ecasapiresponse = (EcasApiResponse)EcasShoppingCartDataManager.access$800(EcasShoppingCartDataManager.this, new CreateCheckoutSessionRequest(apiContext, cartId, shoppingCartLineItemIds, clientAttributes), avoid);
        if (ecasapiresponse != null)
        {
            if (ecasapiresponse.hasSuccessResponseCode() && ecasapiresponse.casResponse != null)
            {
                avoid = EcasCheckoutSessionAdapter.toContentModel((EcasCheckoutResponse)ecasapiresponse.casResponse);
                invalidateCache();
                return avoid;
            } else
            {
                return new Content(ecasapiresponse.getResultStatus());
            }
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
        super.cute(content);
        outstandingTasks.remove(this);
        if (!content.getStatus().hasError() && content.getData() != null)
        {
            cancelOutstandingTasks();
            if (caller != null)
            {
                caller.Complete(EcasShoppingCartDataManager.this, content);
                return;
            } else
            {
                ((this._cls0)EcasShoppingCartDataManager.access$900(EcasShoppingCartDataManager.this)).Complete(EcasShoppingCartDataManager.this, content);
                return;
            }
        }
        if (caller != null)
        {
            caller.Complete(EcasShoppingCartDataManager.this, new Content(content.getStatus()));
            return;
        } else
        {
            ((this._cls0)EcasShoppingCartDataManager.access$1000(EcasShoppingCartDataManager.this)).Complete(EcasShoppingCartDataManager.this, new Content(content.getStatus()));
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (EcasApiContext ecasapicontext, Long long1, List list,  , Map map)
    {
        this$0 = EcasShoppingCartDataManager.this;
        super(EcasShoppingCartDataManager.this, SION, null, null, null, );
        cartId = long1;
        shoppingCartLineItemIds = list;
        apiContext = ecasapicontext;
        clientAttributes = map;
    }
}
