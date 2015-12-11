// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.nav;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.amazon.now.AmazonActivity;
import com.amazon.now.ChromeStyle;
import com.amazon.now.account.SSO;
import com.amazon.now.account.User;
import com.amazon.now.account.UserListener;
import com.amazon.now.browse.BrowseActivity;
import com.amazon.now.debug.DebugActivity;
import com.amazon.now.home.WelcomeScreen;
import com.amazon.now.location.Location;
import com.amazon.now.location.Store;
import com.amazon.now.location.StorefrontWebActivity;
import com.amazon.now.orders.YourOrdersActivity;
import com.amazon.now.restaurants.RestaurantsActivity;
import com.amazon.now.util.AppUtils;
import com.amazon.now.util.ImageUtil;
import com.amazon.now.util.LocationUtil;
import com.amazon.now.web.ContactUsActivity;
import com.amazon.now.web.HelpAndAboutActivity;
import com.amazon.now.web.ShopPastPurchaseActivity;
import com.amazon.now.web.YourAccountActivity;
import java.util.List;

// Referenced classes of package com.amazon.now.nav:
//            NavListItem

public class NavListAdapter extends ArrayAdapter
    implements android.widget.AdapterView.OnItemClickListener, UserListener
{

    private static final NavListItem DIVIDER;
    private static final NavListItem SPACER;
    private Context mContext;

    public NavListAdapter(Context context)
    {
        super(context, 0);
        mContext = context;
        addMenuItems();
    }

    private void addMenuItems()
    {
        super.add(new NavListItem(NavListItem.NavItemType.LOGO, null, NavListItem.NavLayoutType.LOGO));
        super.add(new NavListItem(NavListItem.NavItemType.LOCATION, getLocationString(), NavListItem.NavLayoutType.LOCATION));
        if (!User.isSignedIn())
        {
            super.add(new NavListItem(NavListItem.NavItemType.SIGN_IN, mContext.getString(0x7f070089), NavListItem.NavLayoutType.NORMAL));
            super.add(DIVIDER);
        }
        super.add(new NavListItem(NavListItem.NavItemType.HOME, mContext.getString(0x7f070085), NavListItem.NavLayoutType.NORMAL));
        super.add(DIVIDER);
        super.add(new NavListItem(NavListItem.NavItemType.SHOP_PAST_PURCHASE, mContext.getString(0x7f070093), NavListItem.NavLayoutType.NORMAL));
        super.add(DIVIDER);
        super.add(new NavListItem(NavListItem.NavItemType.BROWSE_BY_CATEGORY, mContext.getString(0x7f070081), NavListItem.NavLayoutType.NORMAL));
        super.add(DIVIDER);
        if (LocationUtil.getStoreCount() > 1)
        {
            super.add(new NavListItem(NavListItem.NavItemType.SHOP_BY_STORES, null, NavListItem.NavLayoutType.SHOP_BY_STORES));
            super.add(DIVIDER);
        }
        if (LocationUtil.isRestaurantsEnabled())
        {
            super.add(new NavListItem(NavListItem.NavItemType.RESTAURANTS, mContext.getString(0x7f070092), NavListItem.NavLayoutType.NORMAL));
            super.add(DIVIDER);
        }
        super.add(new NavListItem(NavListItem.NavItemType.YOUR_ORDERS, mContext.getString(0x7f070087), NavListItem.NavLayoutType.NORMAL));
        super.add(DIVIDER);
        super.add(new NavListItem(NavListItem.NavItemType.YOUR_ACCOUNT, mContext.getString(0x7f07007f), NavListItem.NavLayoutType.NORMAL));
        super.add(DIVIDER);
        super.add(new NavListItem(NavListItem.NavItemType.HELP_ABOUT, mContext.getString(0x7f070084), NavListItem.NavLayoutType.NORMAL));
        super.add(DIVIDER);
        super.add(new NavListItem(NavListItem.NavItemType.CONTACT_US, mContext.getString(0x7f070083), NavListItem.NavLayoutType.NORMAL));
        super.add(DIVIDER);
        super.add(new NavListItem(NavListItem.NavItemType.LOCATION, mContext.getString(0x7f070082), NavListItem.NavLayoutType.NORMAL));
        super.add(DIVIDER);
        if (User.isSignedIn() && !AppUtils.isAmazonDevice())
        {
            super.add(new NavListItem(NavListItem.NavItemType.SIGN_OUT, mContext.getString(0x7f07008a), NavListItem.NavLayoutType.NORMAL));
            super.add(DIVIDER);
        }
        if (AppUtils.isAppDebuggable(mContext))
        {
            super.add(new NavListItem(NavListItem.NavItemType.DEBUG, mContext.getString(0x7f0700c6), NavListItem.NavLayoutType.NORMAL));
            super.add(DIVIDER);
        }
        super.add(SPACER);
    }

    private String getLocationString()
    {
        String s = Location.getZipcode();
        if (TextUtils.isEmpty(s))
        {
            return Location.getName();
        } else
        {
            return String.format(mContext.getString(0x7f070086), new Object[] {
                s
            });
        }
    }

    private void setupStores(View view)
    {
        LinearLayout linearlayout = (LinearLayout)view.findViewById(0x7f0e0070);
        List list = LocationUtil.getStoreList();
        if (list != null && !list.isEmpty())
        {
            view = null;
            byte byte0;
            int i;
            if (list.size() == 4)
            {
                byte0 = 2;
            } else
            {
                byte0 = 3;
            }
            for (i = 0; i < list.size(); i++)
            {
                Object obj = view;
                if (i > 0)
                {
                    obj = view;
                    if (i % byte0 == 0)
                    {
                        linearlayout.addView(view);
                        obj = null;
                    }
                }
                view = ((View) (obj));
                if (obj == null)
                {
                    view = new LinearLayout(mContext);
                    view.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
                    view.setOrientation(0);
                }
                obj = new ImageView(mContext);
                final Store store = (Store)list.get(i);
                int l = mContext.getResources().getDimensionPixelSize(0x7f0b0020);
                int k = (((AmazonActivity)mContext).calculateLeftNavWidth() - l * 4) / 3;
                int j = k;
                if (!mContext.getResources().getBoolean(0x7f090001))
                {
                    j = (k * 2) / 3;
                }
                ImageUtil.setImageFromUrl(new com.amazon.now.util.ImageUtil.ImageReadyCallback(((ImageView) (obj))), store.getImageUrl(), j, j, true);
                android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(j, j);
                layoutparams.setMargins(l, l / 2, 0, l / 2);
                ((ImageView) (obj)).setLayoutParams(layoutparams);
                ((ImageView) (obj)).setBackgroundColor(mContext.getResources().getColor(0x7f0d001e));
                ((ImageView) (obj)).setPadding(l, l, l, l);
                ((ImageView) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                    final NavListAdapter this$0;
                    final Store val$store;

                    public void onClick(View view1)
                    {
                        view1 = new Intent(getContext(), com/amazon/now/location/StorefrontWebActivity);
                        view1.putExtra("intentUrlKey", store.getStoreUrl());
                        view1.putExtra("intentStyleKey", new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NORMAL, store.getStoreColor(), true));
                        mContext.startActivity(view1);
                        ((AmazonActivity)getContext()).closeLeftNav();
                    }

            
            {
                this$0 = NavListAdapter.this;
                store = store1;
                super();
            }
                });
                view.addView(((View) (obj)));
            }

            linearlayout.addView(view);
            return;
        } else
        {
            view.setVisibility(8);
            return;
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = (NavListItem)super.getItem(i);
        static class _cls4
        {

            static final int $SwitchMap$com$amazon$now$nav$NavListItem$NavItemType[];
            static final int $SwitchMap$com$amazon$now$nav$NavListItem$NavLayoutType[];

            static 
            {
                $SwitchMap$com$amazon$now$nav$NavListItem$NavItemType = new int[NavListItem.NavItemType.values().length];
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavItemType[NavListItem.NavItemType.LOCATION.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavItemType[NavListItem.NavItemType.LOGO.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavItemType[NavListItem.NavItemType.HOME.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavItemType[NavListItem.NavItemType.ALL_STORES.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavItemType[NavListItem.NavItemType.SHOP_PAST_PURCHASE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavItemType[NavListItem.NavItemType.BROWSE_BY_CATEGORY.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavItemType[NavListItem.NavItemType.YOUR_ACCOUNT.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavItemType[NavListItem.NavItemType.YOUR_ORDERS.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavItemType[NavListItem.NavItemType.HELP_ABOUT.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavItemType[NavListItem.NavItemType.CONTACT_US.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavItemType[NavListItem.NavItemType.SIGN_IN.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavItemType[NavListItem.NavItemType.SIGN_OUT.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavItemType[NavListItem.NavItemType.RESTAURANTS.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavItemType[NavListItem.NavItemType.DEBUG.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                $SwitchMap$com$amazon$now$nav$NavListItem$NavLayoutType = new int[NavListItem.NavLayoutType.values().length];
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavLayoutType[NavListItem.NavLayoutType.LOGO.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavLayoutType[NavListItem.NavLayoutType.SPACER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavLayoutType[NavListItem.NavLayoutType.DIVIDER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavLayoutType[NavListItem.NavLayoutType.LOCATION.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavLayoutType[NavListItem.NavLayoutType.SHOP_BY_STORES.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$now$nav$NavListItem$NavLayoutType[NavListItem.NavLayoutType.NORMAL.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls4..SwitchMap.com.amazon.now.nav.NavListItem.NavLayoutType[view.getLayoutType().ordinal()];
        JVM INSTR tableswitch 1 5: default 56
    //                   1 133
    //                   2 140
    //                   3 147
    //                   4 154
    //                   5 161;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_161;
_L1:
        i = 0x7f030014;
_L7:
        viewgroup = LayoutInflater.from(getContext()).inflate(i, viewgroup, false);
        if (view.getLayoutType() == NavListItem.NavLayoutType.NORMAL || view.getLayoutType() == NavListItem.NavLayoutType.LOCATION)
        {
            ((TextView)viewgroup.findViewById(0x7f0e006f)).setText(view.getName());
            viewgroup.setFocusable(false);
        } else
        {
            viewgroup.setEnabled(false);
        }
        if (view.getLayoutType() == NavListItem.NavLayoutType.SHOP_BY_STORES)
        {
            setupStores(viewgroup);
        }
        return viewgroup;
_L2:
        i = 0x7f030013;
          goto _L7
_L3:
        i = 0x7f030015;
          goto _L7
_L4:
        i = 0x7f030011;
          goto _L7
_L5:
        i = 0x7f030012;
          goto _L7
        i = 0x7f030016;
          goto _L7
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (!((AmazonActivity)mContext).isLeftNavOpen())
        {
            return;
        }
        adapterview = (NavListItem)((ListView)adapterview).getItemAtPosition(i);
        _cls4..SwitchMap.com.amazon.now.nav.NavListItem.NavItemType[adapterview.getItemType().ordinal()];
        JVM INSTR tableswitch 1 14: default 108
    //                   1 109
    //                   2 153
    //                   3 153
    //                   4 141
    //                   5 166
    //                   6 176
    //                   7 200
    //                   8 210
    //                   9 220
    //                   10 230
    //                   11 240
    //                   12 254
    //                   13 267
    //                   14 278;
           goto _L1 _L2 _L3 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        return;
_L2:
        adapterview = new Intent(mContext, com/amazon/now/home/WelcomeScreen);
        adapterview.putExtra("intentKeyChangeLocation", true);
        mContext.startActivity(adapterview);
_L16:
        ((AmazonActivity)mContext).closeLeftNav();
        return;
_L3:
        AppUtils.goHome((AmazonActivity)mContext);
        continue; /* Loop/switch isn't completed */
_L5:
        ShopPastPurchaseActivity.startActivity(mContext);
        continue; /* Loop/switch isn't completed */
_L6:
        mContext.startActivity(new Intent(mContext, com/amazon/now/browse/BrowseActivity));
        continue; /* Loop/switch isn't completed */
_L7:
        YourAccountActivity.startActivity(mContext);
        continue; /* Loop/switch isn't completed */
_L8:
        YourOrdersActivity.startActivity(mContext);
        continue; /* Loop/switch isn't completed */
_L9:
        HelpAndAboutActivity.startActivity(mContext);
        continue; /* Loop/switch isn't completed */
_L10:
        ContactUsActivity.startActivity(mContext);
        continue; /* Loop/switch isn't completed */
_L11:
        SSO.authenticateUser((Activity)mContext, null);
        continue; /* Loop/switch isn't completed */
_L12:
        SSO.promptToDeregister((Activity)mContext);
        continue; /* Loop/switch isn't completed */
_L13:
        RestaurantsActivity.startActivity(mContext, null);
        continue; /* Loop/switch isn't completed */
_L14:
        adapterview = new Intent(mContext, com/amazon/now/debug/DebugActivity);
        mContext.startActivity(adapterview);
        if (true) goto _L16; else goto _L15
_L15:
    }

    public void recreate()
    {
        clear();
        addMenuItems();
        notifyDataSetChanged();
    }

    public void userSignedIn()
    {
        ((Activity)mContext).runOnUiThread(new Runnable() {

            final NavListAdapter this$0;

            public void run()
            {
                recreate();
            }

            
            {
                this$0 = NavListAdapter.this;
                super();
            }
        });
    }

    public void userSignedOut()
    {
        ((Activity)mContext).runOnUiThread(new Runnable() {

            final NavListAdapter this$0;

            public void run()
            {
                recreate();
            }

            
            {
                this$0 = NavListAdapter.this;
                super();
            }
        });
    }

    static 
    {
        SPACER = new NavListItem(NavListItem.NavItemType.SPACER, "", NavListItem.NavLayoutType.SPACER);
        DIVIDER = new NavListItem(NavListItem.NavItemType.DIVIDER, "", NavListItem.NavLayoutType.DIVIDER);
    }

}
