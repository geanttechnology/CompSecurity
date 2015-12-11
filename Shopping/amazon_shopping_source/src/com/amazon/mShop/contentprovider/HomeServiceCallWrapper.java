// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.contentprovider;

import android.content.Context;
import android.util.Log;
import com.amazon.mShop.customclientfields.CustomClientFields;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.DBException;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.CartItems;
import com.amazon.rio.j2me.client.services.mShop.HomeRequest;
import com.amazon.rio.j2me.client.services.mShop.HomeResponseListener;
import com.amazon.rio.j2me.client.services.mShop.HomeShoveler;
import com.amazon.rio.j2me.client.services.mShop.LoginData;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.Notification;
import com.amazon.rio.j2me.client.services.mShop.PromoSlot;
import java.util.List;

// Referenced classes of package com.amazon.mShop.contentprovider:
//            WidgetDatabaseHelper, WidgetContentProvider

public class HomeServiceCallWrapper
{

    private static final String TAG = com/amazon/mShop/contentprovider/HomeServiceCallWrapper.getSimpleName();
    private static volatile ServiceCall sHomeServiceCall = null;

    public HomeServiceCallWrapper()
    {
    }

    public static void startHomeCall(Context context)
    {
        context = new HomeResponseListener(context) {

            final Context val$context;

            private void finishAction()
            {
                HomeServiceCallWrapper.sHomeServiceCall = null;
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
                    WidgetDatabaseHelper.getInstance(context.getApplicationContext()).cleanOldHomeShovelerContent();
                    WidgetContentProvider.sendContentUpdatedIntent(context.getApplicationContext());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception)
                {
                    Log.i(HomeServiceCallWrapper.TAG, exception.getMessage());
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
                    WidgetDatabaseHelper.getInstance(context.getApplicationContext()).cleanOldHomeShovelerContent();
                    if (SSOUtil.isSSOSupported(context))
                    {
                        WidgetDatabaseHelper.getInstance(context.getApplicationContext()).updateHomeShovelerItems(homeshoveler);
                    }
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (HomeShoveler homeshoveler)
                {
                    Log.i(HomeServiceCallWrapper.TAG, homeshoveler.getMessage());
                }
            }

            public void receivedShoveler1(HomeShoveler homeshoveler, ServiceCall servicecall)
            {
                try
                {
                    if (SSOUtil.isSSOSupported(context))
                    {
                        WidgetDatabaseHelper.getInstance(context.getApplicationContext()).updateHomeShovelerItems(homeshoveler);
                    }
                    WidgetContentProvider.sendContentUpdatedIntent(context.getApplicationContext());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (HomeShoveler homeshoveler)
                {
                    Log.i(HomeServiceCallWrapper.TAG, homeshoveler.getMessage());
                }
            }

            
            {
                context = context1;
                super();
            }
        };
        com/amazon/mShop/contentprovider/HomeServiceCallWrapper;
        JVM INSTR monitorenter ;
        if (sHomeServiceCall == null)
        {
            HomeRequest homerequest = new HomeRequest();
            homerequest.setApplicationStarted(Boolean.FALSE);
            homerequest.setReturnCartItems(Boolean.FALSE);
            homerequest.setReturnPromoSlot0(Boolean.FALSE);
            homerequest.setReturnPromoSlot1(Boolean.FALSE);
            homerequest.setReturnShoveler0(Boolean.TRUE);
            homerequest.setReturnShoveler1(Boolean.TRUE);
            CustomClientFields.setCustomHeaderFields("home_v38", false, CustomClientFields.getAmazonRequestId());
            sHomeServiceCall = AndroidPlatform.getInstance().getMShopService().home(homerequest, context);
        }
        com/amazon/mShop/contentprovider/HomeServiceCallWrapper;
        JVM INSTR monitorexit ;
        return;
        context;
        com/amazon/mShop/contentprovider/HomeServiceCallWrapper;
        JVM INSTR monitorexit ;
        throw context;
    }




/*
    static ServiceCall access$102(ServiceCall servicecall)
    {
        sHomeServiceCall = servicecall;
        return servicecall;
    }

*/
}
