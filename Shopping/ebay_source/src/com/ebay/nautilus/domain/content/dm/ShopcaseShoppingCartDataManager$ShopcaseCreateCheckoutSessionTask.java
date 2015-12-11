// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.shopcase.CreateCheckoutSessionRequest;
import com.ebay.nautilus.domain.net.api.shopcase.ShopcaseCheckoutSessionMapper;
import com.ebay.nautilus.domain.net.api.shopcase.ShopcaseCheckoutSessionResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.Collection;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ShopcaseShoppingCartDataManager

public final class useProx extends useProx
{

    Map clientAttributes;
    private final Collection itemReferenceIds;
    final ShopcaseShoppingCartDataManager this$0;
    private final boolean useProx;

    protected transient Content doInBackground(Void avoid[])
    {
        try
        {
            avoid = new CreateCheckoutSessionRequest(iafToken, site, itemReferenceIds, useProx, clientAttributes);
            avoid = (ShopcaseCheckoutSessionResponse)ShopcaseShoppingCartDataManager.access$500(ShopcaseShoppingCartDataManager.this, avoid);
            if (avoid.hasSuccessResponseCode() && ((ShopcaseCheckoutSessionResponse) (avoid)).checkoutSession != null)
            {
                invalidateCache();
                return (new ShopcaseCheckoutSessionMapper(((ShopcaseCheckoutSessionResponse) (avoid)).checkoutSession)).toContentModel();
            }
            avoid = new Content(null, avoid.getResultStatus());
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            return new Content(ResultStatus.CANCELED);
        }
        return avoid;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Content content)
    {
        super.doInBackground(content);
        outstandingTasks.remove(this);
        if (!content.getStatus().hasError() && content.getData() != null)
        {
            cancelOutstandingTasks();
            if (caller != null)
            {
                caller.caller(ShopcaseShoppingCartDataManager.this, content);
                return;
            } else
            {
                ((this._cls0)ShopcaseShoppingCartDataManager.access$600(ShopcaseShoppingCartDataManager.this))._mth0(ShopcaseShoppingCartDataManager.this, content);
                return;
            }
        }
        if (caller != null)
        {
            caller.caller(ShopcaseShoppingCartDataManager.this, new Content(content.getStatus()));
            return;
        } else
        {
            ((this._cls0)ShopcaseShoppingCartDataManager.access$700(ShopcaseShoppingCartDataManager.this))._mth0(ShopcaseShoppingCartDataManager.this, new Content(content.getStatus()));
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (Collection collection, String s, String s1,  , Map map)
    {
        this$0 = ShopcaseShoppingCartDataManager.this;
        super(ShopcaseShoppingCartDataManager.this, this._fld0, s, null, s1, );
        itemReferenceIds = collection;
        clientAttributes = map;
        useProx = DeviceConfiguration.getAsync().get(DcsNautilusBoolean.PROX);
    }
}
