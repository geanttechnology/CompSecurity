// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.Toast;
import com.amazon.mobile.mash.api.MASHCordovaPlugin;
import com.amazon.mobile.mash.error.MASHError;
import com.amazon.now.AmazonActivity;
import com.amazon.now.cart.CartActivity;
import com.amazon.now.cart.CartController;
import com.amazon.now.cart.CartResponse;
import com.amazon.now.map.MapWebActivity;
import com.amazon.now.map.MarkerInfo;
import com.amazon.now.permissions.PermissionsHelper;
import com.amazon.now.util.AppUtils;
import com.amazon.now.util.ImageUtil;
import com.amazon.now.util.LocationUtil;
import com.amazon.now.util.UpdateUtil;
import com.amazon.now.voice.VoiceSearchInitializer;
import java.util.LinkedList;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MASHHoudiniPlugin extends MASHCordovaPlugin
{
    class _cls1OnButtonClickListener
        implements android.content.DialogInterface.OnClickListener
    {

        private int mButtonIndex;
        final _cls10 this$1;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            class _cls10
                implements Runnable
            {

                final MASHHoudiniPlugin this$0;
                final JSONObject val$args;
                final CallbackContext val$callbackContext;

                public void run()
                {
                    Object obj = new android.app.AlertDialog.Builder(cordova.getActivity());
                    Object obj1 = args.optString("title");
                    if (AppUtils.isDefined(((String) (obj1))))
                    {
                        ((android.app.AlertDialog.Builder) (obj)).setTitle(((CharSequence) (obj1)));
                    }
                    obj1 = args.optString("message");
                    if (AppUtils.isDefined(((String) (obj1))))
                    {
                        ((android.app.AlertDialog.Builder) (obj)).setMessage(((CharSequence) (obj1)));
                    }
                    int i = 0;
                    obj1 = args.optJSONArray("buttonTitles");
                    if (obj1 != null)
                    {
                        int j = ((JSONArray) (obj1)).length();
                        i = j;
                        if (j >= 1)
                        {
                            String s = ((JSONArray) (obj1)).optString(0);
                            i = j;
                            if (AppUtils.isDefined(s))
                            {
                                ((android.app.AlertDialog.Builder) (obj)).setPositiveButton(s, new _cls1OnButtonClickListener(0));
                                i = j;
                                if (j >= 2)
                                {
                                    obj1 = ((JSONArray) (obj1)).optString(1);
                                    i = j;
                                    if (AppUtils.isDefined(((String) (obj1))))
                                    {
                                        ((android.app.AlertDialog.Builder) (obj)).setNeutralButton(((CharSequence) (obj1)), new _cls1OnButtonClickListener(1));
                                        i = j;
                                    }
                                }
                            }
                        }
                    }
                    obj1 = args.optString("cancelButtonTitle");
                    if (AppUtils.isDefined(((String) (obj1))))
                    {
                        ((android.app.AlertDialog.Builder) (obj)).setNegativeButton(((CharSequence) (obj1)), new _cls1OnButtonClickListener(i));
                    }
                    ((android.app.AlertDialog.Builder) (obj)).setIcon(0);
                    obj = ((android.app.AlertDialog.Builder) (obj)).create();
                    if (!cordova.getActivity().isFinishing())
                    {
                        ((AlertDialog) (obj)).show();
                    }
                }

            
            {
                this$0 = MASHHoudiniPlugin.this;
                args = jsonobject;
                callbackContext = callbackcontext;
                super();
            }
            }

            callbackContext.success(mButtonIndex);
        }

        _cls1OnButtonClickListener(int i)
        {
            this$1 = _cls10.this;
            super();
            mButtonIndex = i;
        }
    }


    public static final String SERVICE_NAME = "Houdini";

    public MASHHoudiniPlugin()
    {
    }

    private void addToCart(final JSONObject args, final CallbackContext callbackContext)
    {
        runOnUiThread(new Runnable() {

            final MASHHoudiniPlugin this$0;
            final JSONObject val$args;
            final CallbackContext val$callbackContext;

            public void run()
            {
                String s = args.optString("asin");
                String s1 = args.optString("offerId");
                if (!AppUtils.isDefined(s) || !AppUtils.isDefined(s1))
                {
                    callbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
                    return;
                }
                String s2 = args.optString("qid");
                String s3 = args.optString("sr");
                String s4 = args.optString("ref");
                String s5 = args.optString("merchantId");
                int i = args.optInt("quantity", 1);
                Activity activity;
                if (args.optBoolean("showSpinner", true))
                {
                    activity = cordova.getActivity();
                } else
                {
                    activity = null;
                }
                CartController.getInstance().addToCart(activity, s, s1, s5, s2, s3, s4, i, new com.amazon.now.cart.CartController.CartCallback() {

                    final _cls3 this$1;

                    public void onFailure(CartResponse cartresponse, String s)
                    {
                        CartController.getInstance().addToCartFailureMessage(cordova.getActivity(), s);
                        callbackContext.error(MASHError.TIMEOUT.toJSONObejct());
                    }

                    public void onSuccess(CartResponse cartresponse)
                    {
                        CartController.getInstance().addToCartSuccessMessage(cordova.getActivity());
                        callbackContext.success();
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
            }

            
            {
                this$0 = MASHHoudiniPlugin.this;
                args = jsonobject;
                callbackContext = callbackcontext;
                super();
            }
        });
    }

    private void cartDidUpdate(final int quantity, final CallbackContext callbackContext)
    {
        runOnUiThread(new Runnable() {

            final MASHHoudiniPlugin this$0;
            final CallbackContext val$callbackContext;
            final int val$quantity;

            public void run()
            {
                if (CartController.getInstance().getCartCount() != quantity && (cordova.getActivity() instanceof CartActivity))
                {
                    ((CartActivity)cordova.getActivity()).shouldRefreshOnPause(true);
                }
                CartController.getInstance().cartDidUpdate(quantity);
                callbackContext.success();
            }

            
            {
                this$0 = MASHHoudiniPlugin.this;
                quantity = i;
                callbackContext = callbackcontext;
                super();
            }
        });
    }

    private void deliveryMapUpdateLocations(final JSONObject args, final CallbackContext callbackContext)
    {
        runOnUiThread(new Runnable() {

            final MASHHoudiniPlugin this$0;
            final JSONObject val$args;
            final CallbackContext val$callbackContext;

            public void run()
            {
                MapWebActivity mapwebactivity = (MapWebActivity)cordova.getActivity();
                JSONObject jsonobject1 = args.optJSONObject("destination");
                JSONObject jsonobject = args.optJSONObject("courier");
                JSONArray jsonarray = args.optJSONArray("couriers");
                Object obj = args.opt("origin");
                LinkedList linkedlist = new LinkedList();
                if (jsonobject1 != null)
                {
                    String s3 = jsonobject1.optString("destinationName");
                    double d = jsonobject1.optDouble("latitude", -200D);
                    double d5 = jsonobject1.optDouble("longitude", -200D);
                    if (MarkerInfo.isValid(d, d5))
                    {
                        linkedlist.add(new MarkerInfo(s3, d, d5));
                    }
                }
                if (jsonarray != null)
                {
                    for (int i = 0; i < jsonarray.length(); i++)
                    {
                        Object obj3 = jsonarray.optJSONObject(i);
                        String s1 = ((JSONObject) (obj3)).optString("courierName");
                        double d1 = ((JSONObject) (obj3)).optDouble("latitude", -200D);
                        double d6 = ((JSONObject) (obj3)).optDouble("longitude", -200D);
                        String s4 = ((JSONObject) (obj3)).optString("imageUrl");
                        obj3 = ((JSONObject) (obj3)).optString("id");
                        if (MarkerInfo.isValid(d1, d6) && AppUtils.isDefined(((String) (obj3))))
                        {
                            linkedlist.add(new MarkerInfo(s1, d1, d6, s4, ((String) (obj3))));
                        }
                    }

                }
                if (obj instanceof JSONArray)
                {
                    obj = (JSONArray)obj;
                    for (int j = 0; j < ((JSONArray) (obj)).length(); j++)
                    {
                        Object obj2 = ((JSONArray) (obj)).optJSONObject(j);
                        String s2 = ((JSONObject) (obj2)).optString("originName");
                        double d2 = ((JSONObject) (obj2)).optDouble("latitude", -200D);
                        double d7 = ((JSONObject) (obj2)).optDouble("longitude", -200D);
                        obj2 = ((JSONObject) (obj2)).optString("imageUrl");
                        if (MarkerInfo.isValid(d2, d7))
                        {
                            linkedlist.add(new MarkerInfo(s2, d2, d7, ((String) (obj2))));
                        }
                    }

                } else
                if (obj instanceof JSONObject)
                {
                    Object obj1 = (JSONObject)obj;
                    obj = ((JSONObject) (obj1)).optString("originName");
                    double d3 = ((JSONObject) (obj1)).optDouble("latitude", -200D);
                    double d8 = ((JSONObject) (obj1)).optDouble("longitude", -200D);
                    obj1 = ((JSONObject) (obj1)).optString("imageUrl");
                    if (MarkerInfo.isValid(d3, d8))
                    {
                        linkedlist.add(new MarkerInfo(((String) (obj)), d3, d8, ((String) (obj1))));
                    }
                }
                if (jsonarray == null && jsonobject != null)
                {
                    String s = jsonobject.optString("courierName");
                    double d4 = jsonobject.optDouble("latitude", -200D);
                    double d9 = jsonobject.optDouble("longitude", -200D);
                    if (MarkerInfo.isValid(d4, d9))
                    {
                        linkedlist.add(new MarkerInfo(s, d4, d9, null, null));
                    }
                }
                if (linkedlist.isEmpty())
                {
                    callbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
                    return;
                } else
                {
                    mapwebactivity.plotMarkers(linkedlist);
                    callbackContext.success();
                    return;
                }
            }

            
            {
                this$0 = MASHHoudiniPlugin.this;
                args = jsonobject;
                callbackContext = callbackcontext;
                super();
            }
        });
    }

    private void deliveryMapUpdateMapBarItems(final JSONObject args, final CallbackContext callbackContext)
    {
        runOnUiThread(new Runnable() {

            final MASHHoudiniPlugin this$0;
            final JSONObject val$args;
            final CallbackContext val$callbackContext;

            public void run()
            {
                MapWebActivity mapwebactivity = (MapWebActivity)cordova.getActivity();
                Object obj1 = args.optJSONObject("left");
                Object obj = args.optJSONObject("right");
                if (obj1 != null && obj != null)
                {
                    String s = ((JSONObject) (obj1)).optString("text");
                    obj1 = ((JSONObject) (obj1)).optString("color");
                    String s1 = ((JSONObject) (obj)).optString("text");
                    obj = ((JSONObject) (obj)).optString("color");
                    if (AppUtils.isDefined(s) && AppUtils.isDefined(((String) (obj1))) && AppUtils.isDefined(s1) && AppUtils.isDefined(((String) (obj))))
                    {
                        mapwebactivity.displayMapBar(s, ((String) (obj1)), s1, ((String) (obj)));
                        callbackContext.success();
                        return;
                    }
                }
                callbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
            }

            
            {
                this$0 = MASHHoudiniPlugin.this;
                args = jsonobject;
                callbackContext = callbackcontext;
                super();
            }
        });
    }

    private void launchAppStore(JSONObject jsonobject, final CallbackContext callbackContext)
    {
        runOnUiThread(new Runnable() {

            final MASHHoudiniPlugin this$0;
            final CallbackContext val$callbackContext;

            public void run()
            {
                if (UpdateUtil.launchAppStore((AmazonActivity)cordova.getActivity()))
                {
                    callbackContext.success();
                    return;
                } else
                {
                    callbackContext.error(MASHError.UNKNOWN.toJSONObejct());
                    return;
                }
            }

            
            {
                this$0 = MASHHoudiniPlugin.this;
                callbackContext = callbackcontext;
                super();
            }
        });
    }

    private void refreshCart(final JSONObject args, final CallbackContext callbackContext)
    {
        runOnUiThread(new Runnable() {

            final MASHHoudiniPlugin this$0;
            final JSONObject val$args;
            final CallbackContext val$callbackContext;

            public void run()
            {
                Activity activity;
                if (args.optBoolean("showSpinner", false))
                {
                    activity = cordova.getActivity();
                } else
                {
                    activity = null;
                }
                CartController.getInstance().fetchCartCount(activity, new com.amazon.now.cart.CartController.CartCallback() {

                    final _cls6 this$1;

                    public void onFailure(CartResponse cartresponse, String s)
                    {
                        callbackContext.error(MASHError.TIMEOUT.toJSONObejct());
                    }

                    public void onSuccess(CartResponse cartresponse)
                    {
                        callbackContext.success();
                    }

            
            {
                this$1 = _cls6.this;
                super();
            }
                });
            }

            
            {
                this$0 = MASHHoudiniPlugin.this;
                args = jsonobject;
                callbackContext = callbackcontext;
                super();
            }
        });
    }

    private void removeItem(final JSONObject args, final CallbackContext callbackContext)
    {
        runOnUiThread(new Runnable() {

            final MASHHoudiniPlugin this$0;
            final JSONObject val$args;
            final CallbackContext val$callbackContext;

            public void run()
            {
                String s = args.optString("itemId");
                String s1 = args.optString("offerId");
                int i = args.optInt("quantity", -1);
                Activity activity;
                if (args.optBoolean("showSpinner", false))
                {
                    activity = cordova.getActivity();
                } else
                {
                    activity = null;
                }
                if (AppUtils.isDefined(s) && AppUtils.isDefined(s1) && i > -1)
                {
                    CartController.getInstance().removeItem(activity, s, i, s1, new com.amazon.now.cart.CartController.CartCallback() {

                        final _cls5 this$1;

                        public void onFailure(CartResponse cartresponse, String s)
                        {
                            callbackContext.error(MASHError.TIMEOUT.toJSONObejct());
                        }

                        public void onSuccess(CartResponse cartresponse)
                        {
                            callbackContext.success();
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                }
            }

            
            {
                this$0 = MASHHoudiniPlugin.this;
                args = jsonobject;
                callbackContext = callbackcontext;
                super();
            }
        });
    }

    private void search(final JSONObject args, final CallbackContext callbackContext)
    {
        runOnUiThread(new Runnable() {

            final MASHHoudiniPlugin this$0;
            final JSONObject val$args;
            final CallbackContext val$callbackContext;

            public void run()
            {
                String s = null;
                JSONArray jsonarray = args.optJSONArray("discriminators");
                Object obj = s;
                if (jsonarray != null)
                {
                    obj = s;
                    try
                    {
                        if (jsonarray.length() > 0)
                        {
                            obj = jsonarray.getString(0);
                        }
                    }
                    catch (JSONException jsonexception)
                    {
                        jsonexception = s;
                    }
                }
                s = ((String) (obj));
                if (TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    s = args.optString("discriminator", null);
                }
                ((AmazonActivity)cordova.getActivity()).search(args.optString("merchantId", null), s);
                callbackContext.success();
                return;
            }

            
            {
                this$0 = MASHHoudiniPlugin.this;
                args = jsonobject;
                callbackContext = callbackcontext;
                super();
            }
        });
    }

    private void setLocation(final JSONObject args, final CallbackContext callbackContext)
    {
        runOnUiThread(new Runnable() {

            final MASHHoudiniPlugin this$0;
            final JSONObject val$args;
            final CallbackContext val$callbackContext;

            public void run()
            {
                String s = args.optString("displayName");
                String s1 = args.optString("domain");
                String s2 = args.optString("marketplaceId");
                String s3 = args.optString("postalCode");
                String s4 = args.optString("menuBackgroundURL");
                JSONObject jsonobject = args.optJSONObject("mapStartLocation");
                double d = -200D;
                double d1 = -200D;
                if (jsonobject != null)
                {
                    d = jsonobject.optDouble("latitude", -200D);
                    d1 = jsonobject.optDouble("longitude", -200D);
                }
                if (AppUtils.isDefined(s3) && AppUtils.isDefined(s2) && ImageUtil.isImageServerUrl(s4))
                {
                    LocationUtil.changeLocation((AmazonActivity)cordova.getActivity(), s, s1, s2, s3, s4, d, d1, callbackContext);
                    return;
                } else
                {
                    callbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
                    return;
                }
            }

            
            {
                this$0 = MASHHoudiniPlugin.this;
                args = jsonobject;
                callbackContext = callbackcontext;
                super();
            }
        });
    }

    private void showAlert(final JSONObject args, final CallbackContext callbackContext)
    {
        runOnUiThread(new _cls10());
    }

    private void updateItem(final JSONObject args, final CallbackContext callbackContext)
    {
        runOnUiThread(new Runnable() {

            final MASHHoudiniPlugin this$0;
            final JSONObject val$args;
            final CallbackContext val$callbackContext;

            public void run()
            {
                String s = args.optString("itemId");
                String s1 = args.optString("offerId");
                int i = args.optInt("quantity", -1);
                Activity activity;
                if (args.optBoolean("showSpinner", false))
                {
                    activity = cordova.getActivity();
                } else
                {
                    activity = null;
                }
                if (AppUtils.isDefined(s) && AppUtils.isDefined(s1) && i > -1)
                {
                    CartController.getInstance().updateQuantity(activity, s, i, s1, new com.amazon.now.cart.CartController.CartCallback() {

                        final _cls4 this$1;

                        public void onFailure(CartResponse cartresponse, String s)
                        {
                            callbackContext.error(MASHError.TIMEOUT.toJSONObejct());
                        }

                        public void onSuccess(CartResponse cartresponse)
                        {
                            callbackContext.success();
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                    return;
                } else
                {
                    callbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
                    return;
                }
            }

            
            {
                this$0 = MASHHoudiniPlugin.this;
                args = jsonobject;
                callbackContext = callbackcontext;
                super();
            }
        });
    }

    private void updateStores(JSONObject jsonobject, final CallbackContext callbackContext)
    {
        runOnUiThread(new Runnable() {

            final MASHHoudiniPlugin this$0;
            final CallbackContext val$callbackContext;

            public void run()
            {
                LocationUtil.fetchStores(cordova.getActivity(), new com.amazon.now.location.Store.StoreFetchCallback() {

                    final _cls12 this$1;

                    public void onComplete()
                    {
                        callbackContext.success();
                    }

                    public void onFailure()
                    {
                        callbackContext.error(MASHError.UNKNOWN.toJSONObejct());
                    }

            
            {
                this$1 = _cls12.this;
                super();
            }
                });
            }

            
            {
                this$0 = MASHHoudiniPlugin.this;
                callbackContext = callbackcontext;
                super();
            }
        });
    }

    private void voiceSearch(JSONObject jsonobject, final CallbackContext callbackContext)
    {
        runOnUiThread(new Runnable() {

            final MASHHoudiniPlugin this$0;
            final CallbackContext val$callbackContext;

            public void run()
            {
                if (VoiceSearchInitializer.hasInitialized())
                {
                    PermissionsHelper.launchVoiceSearch((AmazonActivity)cordova.getActivity());
                    callbackContext.success();
                    return;
                } else
                {
                    Toast.makeText(cordova.getActivity(), 0x7f07007d, 0).show();
                    callbackContext.error(MASHError.UNKNOWN.toJSONObejct());
                    return;
                }
            }

            
            {
                this$0 = MASHHoudiniPlugin.this;
                callbackContext = callbackcontext;
                super();
            }
        });
    }

    public boolean execute(String s, String s1, CallbackContext callbackcontext)
        throws JSONException
    {
        if (!"deliveryMapUpdateLocations".equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
        if (cordova.getActivity() instanceof MapWebActivity)
        {
            deliveryMapUpdateLocations(new JSONObject(s1), callbackcontext);
        }
_L4:
        return true;
_L2:
        if ("deliveryMapUpdateControlAreaHeight".equalsIgnoreCase(s)) goto _L4; else goto _L3
_L3:
        if (!"deliveryMapUpdateMapBarItems".equalsIgnoreCase(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!(cordova.getActivity() instanceof MapWebActivity)) goto _L4; else goto _L5
_L5:
        deliveryMapUpdateMapBarItems(new JSONObject(s1), callbackcontext);
        return true;
        if ("deliveryMapInit".equalsIgnoreCase(s)) goto _L4; else goto _L6
_L6:
        if ("cartAddItem".equalsIgnoreCase(s))
        {
            addToCart(new JSONObject(s1), callbackcontext);
            return true;
        }
        if ("cartUpdateItem".equalsIgnoreCase(s))
        {
            updateItem(new JSONObject(s1), callbackcontext);
            return true;
        }
        if ("cartRemoveItem".equalsIgnoreCase(s))
        {
            removeItem(new JSONObject(s1), callbackcontext);
            return true;
        }
        if ("cartRefresh".equalsIgnoreCase(s))
        {
            refreshCart(new JSONObject(s1), callbackcontext);
            return true;
        }
        if ("CartDidUpdate".equalsIgnoreCase(s))
        {
            cartDidUpdate((new JSONObject(s1)).getInt("newCartQuantity"), callbackcontext);
            return true;
        }
        if ("gotoSearch".equalsIgnoreCase(s))
        {
            search(new JSONObject(s1), callbackcontext);
            return true;
        }
        if ("gotoVoiceSearch".equalsIgnoreCase(s))
        {
            voiceSearch(new JSONObject(s1), callbackcontext);
            return true;
        }
        if ("showAlert".equalsIgnoreCase(s))
        {
            showAlert(new JSONObject(s1), callbackcontext);
            return true;
        }
        if ("marketplaceUpdateLocation".equalsIgnoreCase(s))
        {
            setLocation(new JSONObject(s1), callbackcontext);
            return true;
        }
        if ("marketplaceUpdateStores".equalsIgnoreCase(s))
        {
            updateStores(new JSONObject(s1), callbackcontext);
            return true;
        }
        if ("launchAppStoreListing".equalsIgnoreCase(s))
        {
            launchAppStore(new JSONObject(s1), callbackcontext);
            return true;
        } else
        {
            return false;
        }
    }
}
