// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.ShoppingCart;
import com.ebay.nautilus.domain.net.api.shopcase.ShopcaseErrorHandler;
import com.ebay.nautilus.domain.net.api.shopcase.ShopcaseShoppingCartMapper;
import com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ShopcaseShoppingCartDataManager, ShoppingCartDataManagerBase

public final class itemReferenceId extends itemReferenceId
{

    private final Long itemReferenceId;
    private final ShopCart shopCaseModel;
    final ShopcaseShoppingCartDataManager this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        avoid = (new ShopcaseShoppingCartMapper(shopCaseModel, new ShopcaseErrorHandler(action, itemId, itemReferenceId))).toContentModel();
        ShoppingCartDataManagerBase.cacheManager.clear();
        if (action.action && avoid.getData() != null)
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
        super.doInBackground(content);
        outstandingTasks.remove(this);
        ResultStatus resultstatus = content.getStatus();
        if (content.getData() != null && (!resultstatus.hasError() || action.action))
        {
            ShoppingCartDataManagerBase.setBuyableItemCount(((ShoppingCart)content.getData()).summary.action);
            if (caller != null)
            {
                caller.caller(ShopcaseShoppingCartDataManager.this, action, content);
                return;
            } else
            {
                ((action)ShopcaseShoppingCartDataManager.access$300(ShopcaseShoppingCartDataManager.this))._mth0(ShopcaseShoppingCartDataManager.this, action, content);
                return;
            }
        }
        if (caller != null)
        {
            caller.caller(ShopcaseShoppingCartDataManager.this, action, new Content(resultstatus));
            return;
        } else
        {
            ((action)ShopcaseShoppingCartDataManager.access$400(ShopcaseShoppingCartDataManager.this))._mth0(ShopcaseShoppingCartDataManager.this, action, new Content(resultstatus));
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (ShopCart shopcart, String s, Long long1, String s1, String s2,  , 
             1)
    {
        this$0 = ShopcaseShoppingCartDataManager.this;
        super(ShopcaseShoppingCartDataManager.this, , s, s1, s2, 1);
        shopCaseModel = shopcart;
        itemReferenceId = long1;
    }
}
