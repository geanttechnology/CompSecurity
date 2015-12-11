// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.ShoppingCart;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ShoppingCartDataManagerBase

public class RT extends RT
{

    final ShoppingCartDataManagerBase this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        ShoppingCart shoppingcart = (ShoppingCart)ShoppingCartDataManagerBase.cacheManager.get(ShoppingCartDataManagerBase.getCacheKey(siteId, userId, true));
        avoid = shoppingcart;
        if (shoppingcart == null)
        {
            avoid = shoppingcart;
            if (!action.action)
            {
                avoid = (ShoppingCart)ShoppingCartDataManagerBase.cacheManager.get(ShoppingCartDataManagerBase.getCacheKey(siteId, userId, false));
            }
        }
        return new Content(avoid);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Content content)
    {
        super.cute(content);
        outstandingTasks.remove(this);
        if (content == null || content.getData() == null)
        {
            getCartAsync(action.action);
            return;
        }
        if (caller != null)
        {
            caller.nged(ShoppingCartDataManagerBase.this, action, content);
            return;
        } else
        {
            ((action)ShoppingCartDataManagerBase.access$200(ShoppingCartDataManagerBase.this)).nged(ShoppingCartDataManagerBase.this, action, content);
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    protected void onPreExecute()
    {
        super.ute();
        if (caller != null)
        {
            caller.ding(ShoppingCartDataManagerBase.this, action);
            return;
        } else
        {
            ((action)ShoppingCartDataManagerBase.access$100(ShoppingCartDataManagerBase.this)).ding(ShoppingCartDataManagerBase.this, action);
            return;
        }
    }

    public (String s, String s1, boolean flag,  )
    {
        this$0 = ShoppingCartDataManagerBase.this;
         1;
        if (flag)
        {
            1 = RT;
        } else
        {
            1 = RT;
        }
        super(ShoppingCartDataManagerBase.this, 1, s, null, s1, );
    }
}
