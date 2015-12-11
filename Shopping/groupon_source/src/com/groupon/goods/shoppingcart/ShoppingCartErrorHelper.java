// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;

import android.content.DialogInterface;
import android.content.res.Resources;
import com.groupon.models.error.GrouponException;
import com.groupon.util.DialogManager;

// Referenced classes of package com.groupon.goods.shoppingcart:
//            MaxQuantityException, ShoppingCartPresenter

public class ShoppingCartErrorHelper
{
    private class CancelCacheCartDialogClick
        implements android.content.DialogInterface.OnClickListener
    {

        final ShoppingCartErrorHelper this$0;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            if (shoppingCartPresenter != null)
            {
                shoppingCartPresenter.cartCacheCancelled();
            }
        }

        private CancelCacheCartDialogClick()
        {
            this$0 = ShoppingCartErrorHelper.this;
            super();
        }

    }

    private class RetryCacheCartDialogClick
        implements android.content.DialogInterface.OnClickListener
    {

        final ShoppingCartErrorHelper this$0;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            if (shoppingCartPresenter != null)
            {
                shoppingCartPresenter.cacheCart();
            }
        }

        private RetryCacheCartDialogClick()
        {
            this$0 = ShoppingCartErrorHelper.this;
            super();
        }

    }


    private DialogManager dialogManager;
    private Resources resources;
    private ShoppingCartPresenter shoppingCartPresenter;

    public ShoppingCartErrorHelper()
    {
    }

    public void setShoppingCartPresenter(ShoppingCartPresenter shoppingcartpresenter)
    {
        shoppingCartPresenter = shoppingcartpresenter;
    }

    public void shoudDisplayErrorDialog(Exception exception, boolean flag)
    {
        if (exception instanceof MaxQuantityException)
        {
            int i = ((MaxQuantityException)exception).maxItems;
            exception = resources.getString(0x7f080267);
            String s = String.format(resources.getString(0x7f080266), new Object[] {
                Integer.valueOf(i)
            });
            dialogManager.showAlertDialog(exception, s);
            return;
        }
        if (exception instanceof GrouponException)
        {
            exception = exception.getMessage();
        } else
        {
            exception = resources.getString(0x7f080165);
        }
        if (flag)
        {
            dialogManager.showAlertDialog(null, exception, resources.getString(0x7f080336), new RetryCacheCartDialogClick(), resources.getString(0x7f080084), new CancelCacheCartDialogClick(), true);
            return;
        } else
        {
            dialogManager.showAlertDialog(null, exception);
            return;
        }
    }

}
