// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.deeplink;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.amazon.now.AmazonActivity;
import com.amazon.now.cart.CartActivity;
import com.amazon.now.detail.DetailsActivity;
import com.amazon.now.home.HomeActivity;
import com.amazon.now.location.Location;
import com.amazon.now.location.OnboardVerificationHelper;
import com.amazon.now.net.JsonFetcher;
import com.amazon.now.orders.OrderStatusActivity;
import com.amazon.now.platform.TaskCallback;
import com.amazon.now.search.SearchIntentBuilder;
import com.amazon.now.util.AppUtils;
import com.amazon.now.web.WebActivity;
import com.amazon.now.web.YourAccountActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class DeepLinkActivity extends AmazonActivity
{
    private static final class DeepLinkType extends Enum
    {

        private static final DeepLinkType $VALUES[];
        public static final DeepLinkType BROWSE_NODE;
        public static final DeepLinkType CART;
        public static final DeepLinkType DETAIL_PAGE;
        public static final DeepLinkType GENERIC;
        public static final DeepLinkType ORDER_STATUS;
        public static final DeepLinkType SEARCH;
        public static final DeepLinkType YOUR_ACCOUNT;

        public static DeepLinkType valueOf(String s)
        {
            return (DeepLinkType)Enum.valueOf(com/amazon/now/deeplink/DeepLinkActivity$DeepLinkType, s);
        }

        public static DeepLinkType[] values()
        {
            return (DeepLinkType[])$VALUES.clone();
        }

        static 
        {
            DETAIL_PAGE = new DeepLinkType("DETAIL_PAGE", 0);
            BROWSE_NODE = new DeepLinkType("BROWSE_NODE", 1);
            SEARCH = new DeepLinkType("SEARCH", 2);
            ORDER_STATUS = new DeepLinkType("ORDER_STATUS", 3);
            YOUR_ACCOUNT = new DeepLinkType("YOUR_ACCOUNT", 4);
            CART = new DeepLinkType("CART", 5);
            GENERIC = new DeepLinkType("GENERIC", 6);
            $VALUES = (new DeepLinkType[] {
                DETAIL_PAGE, BROWSE_NODE, SEARCH, ORDER_STATUS, YOUR_ACCOUNT, CART, GENERIC
            });
        }

        private DeepLinkType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/now/deeplink/DeepLinkActivity.getSimpleName();
    private Context mContext;
    private Uri mDataUri;
    private DeepLinkType mDeepLinkType;

    public DeepLinkActivity()
    {
    }

    private void onboard(String s)
    {
        hideSpinner();
        if (!AppUtils.isDefined(s))
        {
            AppUtils.resetActivityStack(this);
            return;
        }
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(s);
        builder.setPositiveButton(0x7f07006f, new android.content.DialogInterface.OnClickListener() {

            final DeepLinkActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                AppUtils.resetActivityStack(DeepLinkActivity.this);
            }

            
            {
                this$0 = DeepLinkActivity.this;
                super();
            }
        });
        builder.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final DeepLinkActivity this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                AppUtils.resetActivityStack(DeepLinkActivity.this);
            }

            
            {
                this$0 = DeepLinkActivity.this;
                super();
            }
        });
        builder.setCancelable(true);
        if (!isFinishing())
        {
            builder.create().show();
            return;
        } else
        {
            AppUtils.resetActivityStack(this);
            return;
        }
    }

    private void processDeepLink(Map map)
    {
        Object obj;
        hideSpinner();
        obj = new Intent();
        static class _cls5
        {

            static final int $SwitchMap$com$amazon$now$deeplink$DeepLinkActivity$DeepLinkType[];

            static 
            {
                $SwitchMap$com$amazon$now$deeplink$DeepLinkActivity$DeepLinkType = new int[DeepLinkType.values().length];
                try
                {
                    $SwitchMap$com$amazon$now$deeplink$DeepLinkActivity$DeepLinkType[DeepLinkType.DETAIL_PAGE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$amazon$now$deeplink$DeepLinkActivity$DeepLinkType[DeepLinkType.SEARCH.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$now$deeplink$DeepLinkActivity$DeepLinkType[DeepLinkType.ORDER_STATUS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$now$deeplink$DeepLinkActivity$DeepLinkType[DeepLinkType.YOUR_ACCOUNT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$now$deeplink$DeepLinkActivity$DeepLinkType[DeepLinkType.CART.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$now$deeplink$DeepLinkActivity$DeepLinkType[DeepLinkType.BROWSE_NODE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$now$deeplink$DeepLinkActivity$DeepLinkType[DeepLinkType.GENERIC.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls5..SwitchMap.com.amazon.now.deeplink.DeepLinkActivity.DeepLinkType[mDeepLinkType.ordinal()];
        JVM INSTR tableswitch 1 7: default 64
    //                   1 98
    //                   2 272
    //                   3 351
    //                   4 376
    //                   5 395
    //                   6 414
    //                   7 414;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L7
_L1:
        map = ((Map) (obj));
_L15:
        obj = HomeActivity.getHomeIntent(mContext);
        mContext.startActivities(new Intent[] {
            obj, map
        });
        finish();
        return;
_L2:
        String s;
        String s1;
        s = (String)map.get("asin");
        if (!AppUtils.isDefined(s))
        {
            onboard(null);
            return;
        }
        s1 = mDataUri.getQuery();
        map = (String)map.get("merchantId");
        if (!AppUtils.isDefined(map)) goto _L9; else goto _L8
_L8:
        s = (new StringBuilder()).append(s).append("?m=").append(map).toString();
        map = s;
        if (!TextUtils.isEmpty(s1))
        {
            map = (new StringBuilder()).append(s).append("&").append(s1).toString();
        }
_L10:
        ((Intent) (obj)).setClass(mContext, com/amazon/now/detail/DetailsActivity);
        ((Intent) (obj)).putExtra("asinPath", map);
        map = ((Map) (obj));
        continue; /* Loop/switch isn't completed */
_L9:
        map = s;
        if (!TextUtils.isEmpty(s1))
        {
            map = (new StringBuilder()).append(s).append("?").append(s1).toString();
        }
        if (true) goto _L10; else goto _L3
_L3:
        obj = mDataUri.toString();
        if (!((String) (obj)).contains("/s/")) goto _L12; else goto _L11
_L11:
        map = ((String) (obj)).substring(((String) (obj)).indexOf("/s/"));
_L13:
        obj = new SearchIntentBuilder(mContext);
        ((SearchIntentBuilder) (obj)).dataUrl(map);
        map = ((SearchIntentBuilder) (obj)).build();
        continue; /* Loop/switch isn't completed */
_L12:
        map = ((Map) (obj));
        if (((String) (obj)).contains("/s?"))
        {
            map = ((String) (obj)).substring(((String) (obj)).indexOf("/s?"));
        }
        if (true) goto _L13; else goto _L4
_L4:
        ((Intent) (obj)).setClass(mContext, com/amazon/now/orders/OrderStatusActivity);
        ((Intent) (obj)).setData(mDataUri);
        map = ((Map) (obj));
        continue; /* Loop/switch isn't completed */
_L5:
        setupWebIntent(((Intent) (obj)), com/amazon/now/web/YourAccountActivity);
        ((Intent) (obj)).setFlags(0x20000);
        map = ((Map) (obj));
        continue; /* Loop/switch isn't completed */
_L6:
        setupWebIntent(((Intent) (obj)), com/amazon/now/cart/CartActivity);
        ((Intent) (obj)).setFlags(0x20000);
        map = ((Map) (obj));
        continue; /* Loop/switch isn't completed */
_L7:
        setupWebIntent(((Intent) (obj)), com/amazon/now/web/WebActivity);
        map = ((Map) (obj));
        if (true) goto _L15; else goto _L14
_L14:
    }

    private void setupWebIntent(Intent intent, Class class1)
    {
        Uri uri = Uri.parse(AppUtils.getServiceUrl(mContext));
        android.net.Uri.Builder builder = mDataUri.buildUpon();
        builder.scheme(uri.getScheme());
        builder.authority(uri.getAuthority());
        intent.setClass(mContext, class1);
        intent.putExtra("intentUrlKey", builder.build().toString());
    }

    private void verifyAsin(final String asin)
    {
        android.net.Uri.Builder builder = Uri.parse(AppUtils.getServiceUrl(this)).buildUpon();
        builder.appendPath("getBuyabilityDetails").appendPath(asin);
        (new JsonFetcher(builder.toString(), new com.amazon.now.net.JsonFetcher.JsonCallback() {

            final DeepLinkActivity this$0;
            final String val$asin;

            public void response(String s)
            {
                Object obj;
                HashMap hashmap;
                boolean flag;
                boolean flag1;
                flag1 = false;
                hashmap = new HashMap();
                obj = null;
                flag = flag1;
                s = new JSONObject(s);
                flag = flag1;
                flag1 = s.optBoolean("buyable", false);
                if (!flag1) goto _L2; else goto _L1
_L1:
                flag = flag1;
                hashmap.put("merchantId", s.optString("merchantId", null));
                flag = flag1;
                s = obj;
_L3:
                if (flag)
                {
                    hashmap.put("asin", asin);
                    processDeepLink(hashmap);
                    return;
                } else
                {
                    onboard(s);
                    return;
                }
_L2:
                flag = flag1;
                s = s.optString("errorMessage", null);
                flag = flag1;
                  goto _L3
                s;
                Log.e(DeepLinkActivity.TAG, s.toString(), s);
                s = obj;
                  goto _L3
            }

            
            {
                this$0 = DeepLinkActivity.this;
                asin = s;
                super();
            }
        })).fetch();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        showSpinner();
        mContext = this;
        mDataUri = getIntent().getData();
        if (mDataUri != null && mDataUri.getHost() != null && mDataUri.getHost().contains("primenow.amazon.") && Location.isSet())
        {
            List list = mDataUri.getPathSegments();
            bundle = list;
            if (list != null)
            {
                bundle = list;
                if (list.size() > 0)
                {
                    bundle = list;
                    if (((String)list.get(0)).equalsIgnoreCase("deeplink"))
                    {
                        String s = mDataUri.getQueryParameter("redirect");
                        bundle = list;
                        if (!TextUtils.isEmpty(s))
                        {
                            bundle = Uri.parse(s).buildUpon();
                            bundle.scheme(mDataUri.getScheme());
                            bundle.authority(mDataUri.getAuthority());
                            mDataUri = bundle.build();
                            bundle = mDataUri.getPathSegments();
                        }
                    }
                }
            }
            if (bundle == null || bundle.size() == 0)
            {
                onboard(null);
                return;
            }
            if (((String)bundle.get(0)).equalsIgnoreCase("dp") && bundle.size() > 1)
            {
                mDeepLinkType = DeepLinkType.DETAIL_PAGE;
                verifyAsin((String)bundle.get(1));
                return;
            }
            if (((String)bundle.get(0)).equalsIgnoreCase("b"))
            {
                mDeepLinkType = DeepLinkType.BROWSE_NODE;
            } else
            if (((String)bundle.get(0)).equalsIgnoreCase("s"))
            {
                mDeepLinkType = DeepLinkType.SEARCH;
            } else
            {
                if (((String)bundle.get(0)).equalsIgnoreCase("start"))
                {
                    onboard(null);
                    return;
                }
                if (((String)bundle.get(0)).equalsIgnoreCase("setExperiment"))
                {
                    AppUtils.resetActivityStack(this, mDataUri);
                    return;
                }
                if (((String)bundle.get(0)).equalsIgnoreCase("orderStatus"))
                {
                    mDeepLinkType = DeepLinkType.ORDER_STATUS;
                } else
                if (((String)bundle.get(0)).equalsIgnoreCase("restaurants"))
                {
                    if (bundle.size() > 1 && ((String)bundle.get(1)).equalsIgnoreCase("order-status"))
                    {
                        mDeepLinkType = DeepLinkType.ORDER_STATUS;
                    } else
                    {
                        mDeepLinkType = DeepLinkType.GENERIC;
                    }
                } else
                if (((String)bundle.get(0)).equalsIgnoreCase("yourAccount"))
                {
                    mDeepLinkType = DeepLinkType.YOUR_ACCOUNT;
                } else
                if (((String)bundle.get(0)).equalsIgnoreCase("cart"))
                {
                    mDeepLinkType = DeepLinkType.CART;
                } else
                {
                    mDeepLinkType = DeepLinkType.GENERIC;
                }
            }
            OnboardVerificationHelper.verify(this, new TaskCallback() {

                final DeepLinkActivity this$0;

                public void failure()
                {
                    onboard(null);
                }

                public void success()
                {
                    processDeepLink(null);
                }

            
            {
                this$0 = DeepLinkActivity.this;
                super();
            }
            });
            return;
        } else
        {
            onboard(null);
            return;
        }
    }




}
