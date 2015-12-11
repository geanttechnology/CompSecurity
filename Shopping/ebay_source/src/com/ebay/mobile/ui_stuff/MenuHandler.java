// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.ui_stuff;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.ebay.common.Preferences;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.DealsWebViewActivity;
import com.ebay.mobile.activities.OptionsMenuGetter;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.activities.eBay;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.shoppingcart.ShoppingCartActivity;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.content.InternalDomainError;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.TrackingSupport;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.mobile.ui_stuff:
//            Util

public class MenuHandler
{

    public static final String MENU_NAVIGATE_UP = "com.ebay.mobile.menu.NAVIGATE_UP";
    public static final int MENU_SHOPPING_CART_ID = 0x7f1009e6;
    public static final String param_signin = "signin";

    public MenuHandler()
    {
    }

    private static void addSourceIdTracking(Intent intent, String s)
    {
        if (s != null && intent != null)
        {
            intent.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(s, "pmn"));
        }
    }

    public static boolean create(Activity activity, Menu menu)
    {
        activity.getMenuInflater().inflate(0x7f110000, menu);
        menu = menu.findItem(0x7f1009e6);
        if (menu != null)
        {
            menu.setTitle(0x7f070a7c);
            menu = MenuItemCompat.getActionView(menu);
            if (menu != null)
            {
                menu.findViewById(0x7f10008c).setVisibility(8);
            }
            if (!(activity instanceof ShoppingCartActivity))
            {
                menu.setOnClickListener(new android.view.View.OnClickListener(activity) {

                    final Activity val$a;

                    public void onClick(View view)
                    {
                        if (!Util.hasNetwork())
                        {
                            MenuHandler.showNoNetwork(a);
                            return;
                        }
                        boolean flag = MyApp.getPrefs().isSignedIn();
                        view = null;
                        if (a instanceof TrackingSupport)
                        {
                            view = ((TrackingSupport)a).getTrackingEventName();
                        }
                        if (flag)
                        {
                            if (a instanceof ItemViewActivity)
                            {
                                Intent intent = new Intent(a, com/ebay/mobile/shoppingcart/ShoppingCartActivity);
                                MenuHandler.addSourceIdTracking(intent, view);
                                a.startActivityForResult(intent, 17);
                                return;
                            }
                            if ((a instanceof eBay) || (a instanceof DealsWebViewActivity))
                            {
                                Intent intent1 = new Intent(a, com/ebay/mobile/shoppingcart/ShoppingCartActivity);
                                MenuHandler.addSourceIdTracking(intent1, view);
                                a.startActivity(intent1);
                                return;
                            } else
                            {
                                MenuHandler.redirect(a, 0x7f1009e6, view);
                                return;
                            }
                        } else
                        {
                            ArrayList arraylist = MenuHandler.getIntents(a, 0x7f1009e6, view, true);
                            Intent intent2 = SignInModalActivity.getIntentForSignIn(view, a);
                            MenuHandler.addSourceIdTracking(intent2, view);
                            intent2.putParcelableArrayListExtra("redirect_intents", arraylist);
                            a.startActivity(intent2);
                            return;
                        }
                    }

            
            {
                a = activity;
                super();
            }
                });
            }
        }
        return true;
    }

    public static final View getActionView(Activity activity, int i)
    {
        Menu menu = null;
        if (activity instanceof OptionsMenuGetter)
        {
            menu = ((OptionsMenuGetter)activity).getOptionsMenu();
        }
        if (menu == null)
        {
            activity = null;
        } else
        {
            activity = menu.findItem(i);
        }
        if (activity == null)
        {
            return null;
        } else
        {
            return activity.getActionView();
        }
    }

    private static ArrayList getIntents(Activity activity, int i, String s, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        if (flag)
        {
            Intent intent = new Intent(activity, com/ebay/mobile/activities/eBay);
            addSourceIdTracking(intent, s);
            intent.addFlags(0x4000000);
            arraylist.add(intent);
        }
        switch (i)
        {
        default:
            return arraylist;

        case 2131757542: 
            activity = new Intent(activity, com/ebay/mobile/shoppingcart/ShoppingCartActivity);
            break;
        }
        addSourceIdTracking(activity, s);
        arraylist.add(activity);
        return arraylist;
    }

    public static void prepare(Activity activity, Menu menu)
    {
        activity = menu.findItem(0x7f1009e6);
        if (activity != null)
        {
            activity.setEnabled(true);
            activity.setVisible(MyApp.getDeviceConfiguration().isShoppingCartEnabled());
        }
    }

    private static void redirect(Activity activity, int i, String s)
    {
        for (s = getIntents(activity, i, s, false).iterator(); s.hasNext(); activity.startActivity((Intent)s.next())) { }
    }

    public static void sendTrackingEventForNavigation(Activity activity, String s)
    {
        TrackingData trackingdata = new TrackingData("Menu", TrackingType.EVENT);
        trackingdata.addKeyValuePair("mfls", s);
        trackingdata.send(activity);
    }

    private static void showNoNetwork(Activity activity)
    {
        EbayErrorHandler.handleResultStatus(activity, -1, ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
            InternalDomainError.getNoNetworkMessage()
        }));
    }




}
