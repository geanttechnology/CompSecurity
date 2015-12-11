// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.ui_stuff;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.DealsWebViewActivity;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.activities.eBay;
import com.ebay.mobile.shoppingcart.ShoppingCartActivity;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.shell.app.TrackingSupport;

// Referenced classes of package com.ebay.mobile.ui_stuff:
//            MenuHandler, Util

static final class val.a
    implements android.view.stener
{

    final Activity val$a;

    public void onClick(View view)
    {
        if (!Util.hasNetwork())
        {
            MenuHandler.access$000(val$a);
            return;
        }
        boolean flag = MyApp.getPrefs().isSignedIn();
        view = null;
        if (val$a instanceof TrackingSupport)
        {
            view = ((TrackingSupport)val$a).getTrackingEventName();
        }
        if (flag)
        {
            if (val$a instanceof ItemViewActivity)
            {
                Intent intent = new Intent(val$a, com/ebay/mobile/shoppingcart/ShoppingCartActivity);
                MenuHandler.access$100(intent, view);
                val$a.startActivityForResult(intent, 17);
                return;
            }
            if ((val$a instanceof eBay) || (val$a instanceof DealsWebViewActivity))
            {
                Intent intent1 = new Intent(val$a, com/ebay/mobile/shoppingcart/ShoppingCartActivity);
                MenuHandler.access$100(intent1, view);
                val$a.startActivity(intent1);
                return;
            } else
            {
                MenuHandler.access$200(val$a, 0x7f1009e6, view);
                return;
            }
        } else
        {
            java.util.ArrayList arraylist = MenuHandler.access$300(val$a, 0x7f1009e6, view, true);
            Intent intent2 = SignInModalActivity.getIntentForSignIn(view, val$a);
            MenuHandler.access$100(intent2, view);
            intent2.putParcelableArrayListExtra("redirect_intents", arraylist);
            val$a.startActivity(intent2);
            return;
        }
    }

    ctivity(Activity activity)
    {
        val$a = activity;
        super();
    }
}
