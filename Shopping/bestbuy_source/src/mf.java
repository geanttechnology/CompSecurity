// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.bbyscan.CaptureQRCodeActivity;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragmentContainer;
import com.bestbuy.android.activities.giftcard.ManualEnterGiftCardDetailsFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.registry.ScannedItemFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import java.util.Iterator;
import java.util.List;

public class mf
{

    private static String b = "0";
    private String a;
    private nb c;
    private String d;
    private String e;

    public mf()
    {
        a = getClass().getName();
    }

    public Fragment a(Activity activity)
    {
        for (activity = ((BBYBaseFragmentActivity)activity).getSupportFragmentManager().getFragments().iterator(); activity.hasNext();)
        {
            Fragment fragment = (Fragment)activity.next();
            if (fragment != null && (fragment instanceof BaseFragmentContainer) && fragment.isVisible())
            {
                return fragment;
            }
        }

        return null;
    }

    public void a(int i, int j, Intent intent, Activity activity)
    {
        if (i != 99) goto _L2; else goto _L1
_L1:
        if (j != BBYBaseFragmentActivity.PRODUCT_SCAN || intent == null) goto _L4; else goto _L3
_L3:
        Object obj;
        String s1;
        String s2;
        boolean flag;
        c = nb.a();
        s1 = "";
        obj = "";
        s2 = intent.getExtras().getString("ProductScan");
        if (intent.getExtras().containsKey("ProductId"))
        {
            obj = intent.getExtras().getString("ProductId");
        }
        if (intent.getExtras().containsKey("SkuId"))
        {
            s1 = intent.getExtras().getString("SkuId");
        }
        flag = intent.getExtras().getBoolean("fromLifeEventsProductScan");
        d = intent.getExtras().getString("uuid");
        e = intent.getExtras().getString("type");
        if (flag) goto _L6; else goto _L5
_L5:
        if (!s2.contains("?c=")) goto _L8; else goto _L7
_L7:
        intent = s2.substring(s2.indexOf("?c="), s2.length()).replace("?c=", "");
        intent.substring(0, 7);
        intent = intent.substring(7, intent.length());
        obj = ((BBYBaseFragmentActivity)activity).getCurrentActionBarTitle();
        intent = new PDPFragment(intent, "", false);
        obj = new PDPFragmentContainer(((String) (obj)));
        activity = ((BBYBaseFragmentActivity)activity).getSupportFragmentManager();
        j = activity.getBackStackEntryCount();
        for (i = 0; i < j - 1; i++)
        {
            activity.popBackStackImmediate();
        }

        activity = activity.findFragmentById(0x7f0c0033);
        if (activity instanceof HomeTabFragment)
        {
            ((BaseTabContainer)((HomeTabFragment)activity).e()).a(((Fragment) (obj)), true);
            ((BaseFragmentContainer) (obj)).a(intent, true);
        }
_L2:
        return;
_L8:
        if (s1 == null) goto _L2; else goto _L9
_L9:
        ((HomeActivity)activity).openPDP(s1, ((String) (obj)), false);
        return;
_L6:
        intent = intent.getExtras().getString("skuid");
        ls.a(activity, intent);
        ((BaseFragmentContainer)a(activity)).a(new ScannedItemFragment(activity, intent, d, e), true, "ScannedItemFragment");
        return;
_L4:
        if (j == 0)
        {
            kf.a(a, "SCAN CANCELED");
            return;
        }
        if (j != BBYBaseFragmentActivity.GC_SCAN_SUCCESS)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (intent == null || !intent.hasExtra("gift_id")) goto _L2; else goto _L10
_L10:
        String s = intent.getStringExtra("gift_id");
        intent = new ManualEnterGiftCardDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("gift_id", s);
        intent.setArguments(bundle);
        activity = ((FragmentActivity)activity).getSupportFragmentManager().beginTransaction();
        activity.add(0x7f0c0033, intent, "ManualEnterGiftCardDetailsFragment");
        activity.addToBackStack(null);
        activity.commit();
        return;
        if (j != BBYBaseFragmentActivity.MANUAL_ENTER) goto _L2; else goto _L11
_L11:
        intent = new ManualEnterGiftCardDetailsFragment();
        activity = ((FragmentActivity)activity).getSupportFragmentManager().beginTransaction();
        activity.add(0x7f0c0033, intent, "ManualEnterGiftCardDetailsFragment");
        activity.addToBackStack(null);
        activity.commit();
        return;
    }

    public void a(Activity activity, String s, String s1)
    {
        a(activity, s, s1, "", "");
    }

    public void a(Activity activity, String s, String s1, String s2, String s3)
    {
        b = s;
        s = new Intent("android.intent.action.GET_CONTENT");
        if (s != null)
        {
            s.putExtra("screen_name", b);
            s.putExtra("screen_title", s1);
            s.putExtra("uuid", s2);
            s.putExtra("type", s3);
            s.setClassName(activity, com/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity.getName());
            activity.startActivityForResult(s, 99);
            activity.overridePendingTransition(0x7f04000e, 0x7f040005);
        }
    }

}
