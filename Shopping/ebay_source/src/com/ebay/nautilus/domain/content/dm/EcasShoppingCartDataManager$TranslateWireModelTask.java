// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.ShoppingCart;
import com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCartMapper;
import com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCartResponse;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            EcasShoppingCartDataManager, ShoppingCartDataManagerBase

public final class ebayItems extends ebayItems
{

    private final List ebayItems;
    private final EcasShoppingCartResponse ecasShoppingCart;
    final EcasShoppingCartDataManager this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        avoid = (new EcasShoppingCartMapper(ecasShoppingCart, EcasShoppingCartDataManager.access$500(ebayItems), action, itemId)).toContentModel();
        ShoppingCartDataManagerBase.cacheManager.clear();
        if (action.action && avoid != null && avoid.getData() != null)
        {
            ShoppingCartDataManagerBase.cacheManager.put(ShoppingCartDataManagerBase.getCacheKey(siteId, userId, action.action), avoid.getData());
        }
        return avoid;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Content content)
    {
label0:
        {
label1:
            {
                super.Execute(content);
                outstandingTasks.remove(this);
                if (content != null)
                {
                    if (content.getData() == null || content.getStatus().hasError() && !action.action)
                    {
                        break label0;
                    }
                    ShoppingCartDataManagerBase.setBuyableItemCount(((ShoppingCart)content.getData()).summary.nt);
                    if (caller == null)
                    {
                        break label1;
                    }
                    caller.Changed(EcasShoppingCartDataManager.this, action, content);
                }
                return;
            }
            ((action)EcasShoppingCartDataManager.access$600(EcasShoppingCartDataManager.this)).Changed(EcasShoppingCartDataManager.this, action, content);
            return;
        }
        if (caller != null)
        {
            caller.Changed(EcasShoppingCartDataManager.this, action, new Content(content.getStatus()));
            return;
        } else
        {
            ((action)EcasShoppingCartDataManager.access$700(EcasShoppingCartDataManager.this)).Changed(EcasShoppingCartDataManager.this, action, new Content(content.getStatus()));
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (EcasShoppingCartResponse ecasshoppingcartresponse, List list, String s, String s1, String s2,  , 
             1)
    {
        this$0 = EcasShoppingCartDataManager.this;
        super(EcasShoppingCartDataManager.this, , s, s1, s2, 1);
        ecasShoppingCart = ecasshoppingcartresponse;
        ebayItems = list;
    }
}
