// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.contentprovider;

import android.content.Context;
import android.util.Log;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.DBException;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.CartItems;
import com.amazon.rio.j2me.client.services.mShop.HomeResponseListener;
import com.amazon.rio.j2me.client.services.mShop.HomeShoveler;
import com.amazon.rio.j2me.client.services.mShop.LoginData;
import com.amazon.rio.j2me.client.services.mShop.Notification;
import com.amazon.rio.j2me.client.services.mShop.PromoSlot;
import java.util.List;

// Referenced classes of package com.amazon.mShop.contentprovider:
//            HomeServiceCallWrapper, WidgetDatabaseHelper, WidgetContentProvider

static final class val.context
    implements HomeResponseListener
{

    final Context val$context;

    private void finishAction()
    {
        ServiceCall _tmp = HomeServiceCallWrapper.access$102(null);
    }

    public void cancelled(ServiceCall servicecall)
    {
        finishAction();
    }

    public void completed(ServiceCall servicecall)
    {
        finishAction();
    }

    public void error(Exception exception, ServiceCall servicecall)
    {
        finishAction();
        try
        {
            WidgetDatabaseHelper.getInstance(val$context.getApplicationContext()).cleanOldHomeShovelerContent();
            WidgetContentProvider.sendContentUpdatedIntent(val$context.getApplicationContext());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            Log.i(HomeServiceCallWrapper.access$000(), exception.getMessage());
        }
    }

    public void receivedCartItems(CartItems cartitems, ServiceCall servicecall)
    {
    }

    public void receivedCompletedRemembersItemIds(List list, ServiceCall servicecall)
    {
    }

    public void receivedLoginData(LoginData logindata, ServiceCall servicecall)
    {
    }

    public void receivedNotification(Notification notification, ServiceCall servicecall)
    {
    }

    public void receivedPromoSlot0(PromoSlot promoslot, ServiceCall servicecall)
    {
    }

    public void receivedPromoSlot1(PromoSlot promoslot, ServiceCall servicecall)
    {
    }

    public void receivedShoveler0(HomeShoveler homeshoveler, ServiceCall servicecall)
    {
        try
        {
            WidgetDatabaseHelper.getInstance(val$context.getApplicationContext()).cleanOldHomeShovelerContent();
            if (SSOUtil.isSSOSupported(val$context))
            {
                WidgetDatabaseHelper.getInstance(val$context.getApplicationContext()).updateHomeShovelerItems(homeshoveler);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HomeShoveler homeshoveler)
        {
            Log.i(HomeServiceCallWrapper.access$000(), homeshoveler.getMessage());
        }
    }

    public void receivedShoveler1(HomeShoveler homeshoveler, ServiceCall servicecall)
    {
        try
        {
            if (SSOUtil.isSSOSupported(val$context))
            {
                WidgetDatabaseHelper.getInstance(val$context.getApplicationContext()).updateHomeShovelerItems(homeshoveler);
            }
            WidgetContentProvider.sendContentUpdatedIntent(val$context.getApplicationContext());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HomeShoveler homeshoveler)
        {
            Log.i(HomeServiceCallWrapper.access$000(), homeshoveler.getMessage());
        }
    }

    ener(Context context1)
    {
        val$context = context1;
        super();
    }
}
