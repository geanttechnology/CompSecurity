// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.domain.net.api.shopcase.ShopcaseCartResponse;
import com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ShopcaseShoppingCartDataManager

public abstract class itemReferenceId extends itemReferenceId
{

    protected final Long itemReferenceId;
    final ShopcaseShoppingCartDataManager this$0;

    protected abstract EbayCosRequest createRequest();

    protected transient Content doInBackground(Void avoid[])
    {
        try
        {
            avoid = (ShopcaseCartResponse)ShopcaseShoppingCartDataManager.access$100(ShopcaseShoppingCartDataManager.this, createRequest());
            avoid = new Content(((ShopcaseCartResponse) (avoid)).shopCart, avoid.getResultStatus());
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
        super.e(content);
        if ((!content.getStatus().hasError() || action.action) && content.getData() != null)
        {
            outstandingTasks.add(DataManager.executeOnThreadPool(new k(ShopcaseShoppingCartDataManager.this, (ShopCart)content.getData(), siteId, itemReferenceId, itemId, userId, action, caller), new Void[0]));
            outstandingTasks.remove(this);
            return;
        }
        outstandingTasks.remove(this);
        if (caller != null)
        {
            caller.d(ShopcaseShoppingCartDataManager.this, action, new Content(content.getStatus()));
            return;
        } else
        {
            ((action)ShopcaseShoppingCartDataManager.access$200(ShopcaseShoppingCartDataManager.this)).d(ShopcaseShoppingCartDataManager.this, action, new Content(content.getStatus()));
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    protected void onPreExecute()
    {
        super.();
        if (caller != null)
        {
            caller.g(ShopcaseShoppingCartDataManager.this, action);
            return;
        } else
        {
            ((action)ShopcaseShoppingCartDataManager.access$000(ShopcaseShoppingCartDataManager.this)).g(ShopcaseShoppingCartDataManager.this, action);
            return;
        }
    }

    protected k(k k, String s, Long long1, String s1, String s2, k k1)
    {
        this$0 = ShopcaseShoppingCartDataManager.this;
        super(ShopcaseShoppingCartDataManager.this, k, s, s1, s2, k1);
        itemReferenceId = long1;
    }
}
