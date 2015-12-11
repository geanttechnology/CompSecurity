// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.supersonicads.sdk.data.AdUnitsReady;
import com.supersonicads.sdk.data.AdUnitsState;
import com.supersonicads.sdk.data.SSABCParameters;
import com.supersonicads.sdk.data.SSAFile;
import com.supersonicads.sdk.data.SSAObj;
import com.supersonicads.sdk.listeners.OnGenericFunctionListener;
import com.supersonicads.sdk.listeners.OnInterstitialListener;
import com.supersonicads.sdk.listeners.OnOfferWallListener;
import com.supersonicads.sdk.listeners.OnRewardedVideoListener;
import com.supersonicads.sdk.precache.DownloadManager;
import com.supersonicads.sdk.utils.DeviceProperties;
import com.supersonicads.sdk.utils.LocationHelper;
import com.supersonicads.sdk.utils.Logger;
import com.supersonicads.sdk.utils.SDKUtils;
import com.supersonicads.sdk.utils.SupersonicSharedPrefHelper;
import com.supersonicads.sdk.utils.SupersonicStorageUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.supersonicads.sdk.controller:
//            VideoEventsListener, OpenUrlActivity, InterstitialActivity, ControllerActivity

public class SupersonicWebView extends WebView
    implements com.supersonicads.sdk.precache.DownloadManager.OnPreCacheCompletion, DownloadListener
{
    private class ChromeClient extends WebChromeClient
    {

        final SupersonicWebView this$0;

        public View getVideoLoadingProgressView()
        {
            FrameLayout framelayout = new FrameLayout(getBaseContext());
            framelayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
            return framelayout;
        }

        public boolean onConsoleMessage(ConsoleMessage consolemessage)
        {
            Logger.i("MyApplication", (new StringBuilder()).append(consolemessage.message()).append(" -- From line ").append(consolemessage.lineNumber()).append(" of ").append(consolemessage.sourceId()).toString());
            return true;
        }

        public boolean onCreateWindow(WebView webview, boolean flag, boolean flag1, Message message)
        {
            webview = new WebView(webview.getContext());
            webview.setWebChromeClient(this);
            webview.setWebViewClient(new FrameBustWebViewClient());
            ((android.webkit.WebView.WebViewTransport)message.obj).setWebView(webview);
            message.sendToTarget();
            Logger.i("onCreateWindow", "onCreateWindow");
            return true;
        }

        public void onHideCustomView()
        {
            Logger.i("Test", "onHideCustomView");
            if (mCustomView == null)
            {
                return;
            } else
            {
                mCustomView.setVisibility(8);
                mCustomViewContainer.removeView(mCustomView);
                mCustomView = null;
                mCustomViewContainer.setVisibility(8);
                mCustomViewCallback.onCustomViewHidden();
                setVisibility(0);
                return;
            }
        }

        public void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
        {
            Logger.i("Test", "onShowCustomView");
            setVisibility(8);
            if (mCustomView != null)
            {
                Logger.i("Test", "mCustomView != null");
                customviewcallback.onCustomViewHidden();
                return;
            } else
            {
                Logger.i("Test", "mCustomView == null");
                mCustomViewContainer.addView(view);
                mCustomView = view;
                mCustomViewCallback = customviewcallback;
                mCustomViewContainer.setVisibility(0);
                return;
            }
        }

        private ChromeClient()
        {
            this$0 = SupersonicWebView.this;
            super();
        }

    }

    private class FrameBustWebViewClient extends WebViewClient
    {

        final SupersonicWebView this$0;

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            Intent intent = new Intent(webview.getContext(), com/supersonicads/sdk/controller/OpenUrlActivity);
            intent.putExtra(SupersonicWebView.EXTERNAL_URL, s);
            intent.putExtra(SupersonicWebView.SECONDARY_WEB_VIEW, false);
            webview.getContext().startActivity(intent);
            return true;
        }

        private FrameBustWebViewClient()
        {
            this$0 = SupersonicWebView.this;
            super();
        }

    }

    public class JSInterface
    {

        final SupersonicWebView this$0;
        volatile int udiaResults;

        private void injectGetUDIA(String s, JSONArray jsonarray)
        {
            if (!TextUtils.isEmpty(s))
            {
                s = generateJSToInject(s, jsonarray.toString(), "onGetUDIASuccess", "onGetUDIAFail");
                injectJavascript(s);
            }
        }

        private void sendResults(String s, JSONArray jsonarray)
        {
            Logger.i(TAG, (new StringBuilder()).append("sendResults: ").append(udiaResults).toString());
            if (udiaResults <= 0)
            {
                injectGetUDIA(s, jsonarray);
            }
        }

        public void adClicked(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("adClicked(").append(s).append(")").toString());
            if (shouldNotifyDeveloper(com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial.toString()))
            {
                Context context = getBaseContext();
                if (context instanceof Activity)
                {
                    ((Activity)context).runOnUiThread(new Runnable() {

                        final JSInterface this$1;

                        public void run()
                        {
                            mOnInitInterstitialListener.onInterstitialAdClicked();
                        }

            
            {
                this$1 = JSInterface.this;
                super();
            }
                    });
                }
                toastingErrMsg("onInterstitialAdClicked", s);
            }
        }

        public void adCredited(String s)
        {
            final String appKey;
            final String userId;
            final String mlatestCompeltionsTime;
            final String product;
            Object obj;
            String s1;
            final int credits;
            final int totalCredits;
            final boolean mMd5Signature;
            final boolean mTotalCreditsFlag;
            boolean flag;
            Log.d(PUB_TAG, (new StringBuilder()).append("adCredited(").append(s).append(")").toString());
            obj = new SSAObj(s);
            appKey = ((SSAObj) (obj)).getString("credits");
            boolean flag1;
            if (appKey != null)
            {
                credits = Integer.parseInt(appKey);
            } else
            {
                credits = 0;
            }
            s1 = ((SSAObj) (obj)).getString("total");
            if (s1 != null)
            {
                totalCredits = Integer.parseInt(s1);
            } else
            {
                totalCredits = 0;
            }
            product = ((SSAObj) (obj)).getString("productType");
            flag1 = ((SSAObj) (obj)).getBoolean("externalPoll");
            mTotalCreditsFlag = false;
            mlatestCompeltionsTime = null;
            mMd5Signature = false;
            flag = false;
            if (flag1)
            {
                appKey = mOWCreditsAppKey;
                userId = mOWCreditsUserId;
            } else
            {
                appKey = mOWAppKey;
                userId = mOWUserId;
            }
            if (!product.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.toString())) goto _L2; else goto _L1
_L1:
            if (!((SSAObj) (obj)).isNull("signature") && !((SSAObj) (obj)).isNull("timestamp") && !((SSAObj) (obj)).isNull("totalCreditsFlag")) goto _L4; else goto _L3
_L3:
            responseBack(s, false, "One of the keys are missung: signature/timestamp/totalCreditsFlag", null);
_L6:
            return;
_L4:
            if (((SSAObj) (obj)).getString("signature").equalsIgnoreCase(SDKUtils.getMD5((new StringBuilder()).append(s1).append(appKey).append(userId).toString())))
            {
                mMd5Signature = true;
            } else
            {
                responseBack(s, false, "Controller signature is not equal to SDK signature", null);
                mMd5Signature = flag;
            }
            mTotalCreditsFlag = ((SSAObj) (obj)).getBoolean("totalCreditsFlag");
            mlatestCompeltionsTime = ((SSAObj) (obj)).getString("timestamp");
_L2:
            if (shouldNotifyDeveloper(product))
            {
                obj = getBaseContext();
                if (obj instanceof Activity)
                {
                    ((Activity)obj).runOnUiThread(s. new Runnable() {

                        final JSInterface this$1;
                        final String val$appKey;
                        final int val$credits;
                        final boolean val$mMd5Signature;
                        final boolean val$mTotalCreditsFlag;
                        final String val$mlatestCompeltionsTime;
                        final String val$product;
                        final int val$totalCredits;
                        final String val$userId;
                        final String val$value;

                        public void run()
                        {
                            if (product.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect.toString()))
                            {
                                mOnRewardedVideoListener.onRVAdCredited(credits);
                            } else
                            if (product.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.toString()) && mMd5Signature && mOnOfferWallListener.onOWAdCredited(credits, totalCredits, mTotalCreditsFlag) && !TextUtils.isEmpty(mlatestCompeltionsTime))
                            {
                                if (SupersonicSharedPrefHelper.getSupersonicPrefHelper().setLatestCompeltionsTime(mlatestCompeltionsTime, appKey, userId))
                                {
                                    responseBack(value, true, null, null);
                                    return;
                                } else
                                {
                                    responseBack(value, false, "Time Stamp could not be stored", null);
                                    return;
                                }
                            }
                        }

            
            {
                this$1 = final_jsinterface;
                product = s;
                credits = i;
                mMd5Signature = flag;
                totalCredits = j;
                mTotalCreditsFlag = flag1;
                mlatestCompeltionsTime = s1;
                appKey = s2;
                userId = s3;
                value = String.this;
                super();
            }
                    });
                    return;
                }
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        public void adUnitsReady(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("adUnitsReady(").append(s).append(")").toString());
            final AdUnitsReady adUnitsReady = new AdUnitsReady(s);
            if (!adUnitsReady.isNumOfAdUnitsExist())
            {
                responseBack(s, false, "Num Of Ad Units Do Not Exist", null);
            } else
            {
                responseBack(s, true, null, null);
                s = adUnitsReady.getProductType();
                if (shouldNotifyDeveloper(s))
                {
                    Context context = getBaseContext();
                    if (context instanceof Activity)
                    {
                        ((Activity)context).runOnUiThread(s. new Runnable() {

                            final JSInterface this$1;
                            final AdUnitsReady val$adUnitsReady;
                            final String val$product;

                            public void run()
                            {
label0:
                                {
                                    boolean flag;
                                    if (Integer.parseInt(adUnitsReady.getNumOfAdUnits()) > 0)
                                    {
                                        flag = true;
                                    } else
                                    {
                                        flag = false;
                                    }
                                    if (product.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect.toString()))
                                    {
                                        mSavedState.setRewardedVideoInitSuccess(true);
                                        if (!flag)
                                        {
                                            break label0;
                                        }
                                        Log.d(TAG, "onRVInitSuccess()");
                                        mOnRewardedVideoListener.onRVInitSuccess(adUnitsReady);
                                    }
                                    return;
                                }
                                mOnRewardedVideoListener.onRVNoMoreOffers();
                            }

            
            {
                this$1 = final_jsinterface;
                adUnitsReady = adunitsready;
                product = String.this;
                super();
            }
                        });
                        return;
                    }
                }
            }
        }

        public void alert(String s)
        {
        }

        protected void changeInterstitialState(boolean flag, String s)
        {
            this;
            JVM INSTR monitorenter ;
            boolean flag2 = false;
            if (mIsInterstitialAvailable != null) goto _L2; else goto _L1
_L1:
            mIsInterstitialAvailable = Boolean.valueOf(flag);
            boolean flag1 = true;
_L4:
            if (!flag1)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            if (shouldNotifyDeveloper(s))
            {
                mOnInitInterstitialListener.onInterstitialAvailability(mIsInterstitialAvailable.booleanValue());
                toastingErrMsg("onInterstitialAvailability", String.valueOf(flag));
            }
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_117;
            }
            if (mIsInterstitialAvailable.booleanValue())
            {
                break MISSING_BLOCK_LABEL_117;
            }
            mIsInterstitialAvailable = Boolean.valueOf(true);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
            flag1 = flag2;
            if (flag)
            {
                continue; /* Loop/switch isn't completed */
            }
            flag1 = flag2;
            if (!mIsInterstitialAvailable.booleanValue())
            {
                continue; /* Loop/switch isn't completed */
            }
            flag1 = true;
            mIsInterstitialAvailable = Boolean.valueOf(false);
            if (true) goto _L4; else goto _L3
_L3:
            s;
            throw s;
        }

        public void createCalendarEvent(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("createCalendarEvent(").append(s).append(")").toString());
            try
            {
                s = new JSONObject();
                JSONObject jsonobject = new JSONObject();
                jsonobject.put("frequency", "weekly");
                s.put("id", "testevent723GDf84");
                s.put("description", "Watch this crazy show on cannel 5!");
                s.put("start", "2014-02-01T20:00:00-8:00");
                s.put("end", "2014-06-30T20:00:00-8:00");
                s.put("status", "pending");
                s.put("recurrence", jsonobject.toString());
                s.put("reminder", "2014-02-01T19:50:00-8:00");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }

        public void deleteFile(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("deleteFile(").append(s).append(")").toString());
            SSAFile ssafile = new SSAFile(s);
            if (!SupersonicStorageUtils.isPathExist(mCacheDirectory, ssafile.getPath()))
            {
                responseBack(s, false, "File not exist", "1");
                return;
            } else
            {
                boolean flag = SupersonicStorageUtils.deleteFile(mCacheDirectory, ssafile.getPath(), ssafile.getFile());
                responseBack(s, flag, null, null);
                return;
            }
        }

        public void deleteFolder(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("deleteFolder(").append(s).append(")").toString());
            SSAFile ssafile = new SSAFile(s);
            if (!SupersonicStorageUtils.isPathExist(mCacheDirectory, ssafile.getPath()))
            {
                responseBack(s, false, "Folder not exist", "1");
                return;
            } else
            {
                boolean flag = SupersonicStorageUtils.deleteFolder(mCacheDirectory, ssafile.getPath());
                responseBack(s, flag, null, null);
                return;
            }
        }

        public void displayWebView(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("displayWebView(").append(s).append(")").toString());
            responseBack(s, true, null, null);
            s = new SSAObj(s);
            boolean flag = ((Boolean)s.get("display")).booleanValue();
            String s2 = s.getString("productType");
            if (flag)
            {
                if (getState() != State.Display)
                {
                    setState(State.Display);
                    Logger.i(TAG, (new StringBuilder()).append("State: ").append(mState).toString());
                    Context context = getBaseContext();
                    String s1 = getOrientationState();
                    int i = SDKUtils.getApplicationRotation(context);
                    if (s2.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial.toString()))
                    {
                        s = new Intent(context, com/supersonicads/sdk/controller/InterstitialActivity);
                    } else
                    {
                        s = new Intent(context, com/supersonicads/sdk/controller/ControllerActivity);
                        if (com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect.toString().equalsIgnoreCase(s2))
                        {
                            s.putExtra("productType", com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect.toString());
                            mSavedState.adOpened(com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect.ordinal());
                        } else
                        {
                            s.putExtra("productType", com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.toString());
                            mSavedState.adOpened(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.ordinal());
                        }
                    }
                    s.putExtra("orientation_set_flag", s1);
                    s.putExtra("rotation_set_flag", i);
                    context.startActivity(s);
                    return;
                } else
                {
                    Logger.i(TAG, (new StringBuilder()).append("State: ").append(mState).toString());
                    return;
                }
            } else
            {
                setState(State.Gone);
                closeWebView();
                return;
            }
        }

        public void getApplicationInfo(String s)
        {
            String s1;
            String s2;
            String s3;
            Object aobj[];
            Logger.i(TAG, (new StringBuilder()).append("getApplicationInfo(").append(s).append(")").toString());
            s1 = extractSuccessFunctionToCall(s);
            s2 = extractFailFunctionToCall(s);
            s3 = (new SSAObj(s)).getString("productType");
            s = null;
            aobj = new Object[2];
            aobj = getApplicationParams(s3);
            s3 = (String)aobj[0];
            if (!((Boolean)aobj[1]).booleanValue()) goto _L2; else goto _L1
_L1:
            if (!TextUtils.isEmpty(s2))
            {
                s = s2;
            }
_L4:
            if (!TextUtils.isEmpty(s))
            {
                s = generateJSToInject(s, s3, "onGetApplicationInfoSuccess", "onGetApplicationInfoFail");
                injectJavascript(s);
            }
            return;
_L2:
            if (!TextUtils.isEmpty(s1))
            {
                s = s1;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void getCachedFilesMap(String s)
        {
            String s1;
            Object obj;
label0:
            {
                Logger.i(TAG, (new StringBuilder()).append("getCachedFilesMap(").append(s).append(")").toString());
                s1 = extractSuccessFunctionToCall(s);
                if (!TextUtils.isEmpty(s1))
                {
                    obj = new SSAObj(s);
                    if (((SSAObj) (obj)).containsKey("path"))
                    {
                        break label0;
                    }
                    responseBack(s, false, "path key does not exist", null);
                }
                return;
            }
            obj = (String)((SSAObj) (obj)).get("path");
            if (!SupersonicStorageUtils.isPathExist(mCacheDirectory, ((String) (obj))))
            {
                responseBack(s, false, "path file does not exist on disk", null);
                return;
            } else
            {
                s = SupersonicStorageUtils.getCachedFilesMap(mCacheDirectory, ((String) (obj)));
                s = generateJSToInject(s1, s, "onGetCachedFilesMapSuccess", "onGetCachedFilesMapFail");
                injectJavascript(s);
                return;
            }
        }

        public void getDeviceStatus(String s)
        {
            String s1;
            String s2;
            String s3;
            boolean flag;
            Logger.i(TAG, (new StringBuilder()).append("getDeviceStatus(").append(s).append(")").toString());
            s1 = extractSuccessFunctionToCall(s);
            s2 = extractFailFunctionToCall(s);
            s = ((String) (new Object[2]));
            s = ((String) (getDeviceParams(getBaseContext())));
            s3 = (String)s[0];
            flag = ((Boolean)s[1]).booleanValue();
            s = null;
            if (!flag) goto _L2; else goto _L1
_L1:
            if (!TextUtils.isEmpty(s2))
            {
                s = s2;
            }
_L4:
            if (!TextUtils.isEmpty(s))
            {
                s = generateJSToInject(s, s3, "onGetDeviceStatusSuccess", "onGetDeviceStatusFail");
                injectJavascript(s);
            }
            return;
_L2:
            if (!TextUtils.isEmpty(s1))
            {
                s = s1;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void getOrientation(String s)
        {
            s = extractSuccessFunctionToCall(s);
            String s1 = SDKUtils.getOrientation(getBaseContext()).toString();
            if (!TextUtils.isEmpty(s))
            {
                s = generateJSToInject(s, s1, "onGetOrientationSuccess", "onGetOrientationFail");
                injectJavascript(s);
            }
        }

        public void getUDIA(String s)
        {
            udiaResults = 0;
            Logger.i(TAG, (new StringBuilder()).append("getUDIA(").append(s).append(")").toString());
            String s1 = extractSuccessFunctionToCall(s);
            SSAObj ssaobj = new SSAObj(s);
            if (!ssaobj.containsKey("getByFlag"))
            {
                responseBack(s, false, "getByFlag key does not exist", null);
            } else
            {
                int i = Integer.parseInt(ssaobj.getString("getByFlag"));
                if (i != 0)
                {
                    String s2 = Integer.toBinaryString(i);
                    if (TextUtils.isEmpty(s2))
                    {
                        responseBack(s, false, "fialed to convert getByFlag", null);
                        return;
                    }
                    char ac[] = (new StringBuilder(s2)).reverse().toString().toCharArray();
                    s = new JSONArray();
                    if (ac[3] == '0')
                    {
                        JSONObject jsonobject = new JSONObject();
                        Location location;
                        try
                        {
                            jsonobject.put("sessions", SupersonicSharedPrefHelper.getSupersonicPrefHelper().getSessions());
                            SupersonicSharedPrefHelper.getSupersonicPrefHelper().deleteSessions();
                            s.put(jsonobject);
                        }
                        catch (JSONException jsonexception) { }
                    }
                    if (ac[2] == '1')
                    {
                        udiaResults = udiaResults + 1;
                        location = LocationHelper.getLastLocation(getBaseContext());
                        if (location != null)
                        {
                            jsonobject = new JSONObject();
                            try
                            {
                                jsonobject.put("latitude", location.getLatitude());
                                jsonobject.put("longitude", location.getLongitude());
                                s.put(jsonobject);
                                udiaResults = udiaResults - 1;
                                sendResults(s1, s);
                                Logger.i(TAG, "done location");
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (String s)
                            {
                                return;
                            }
                        } else
                        {
                            udiaResults = udiaResults - 1;
                            return;
                        }
                    }
                }
            }
        }

        public void getUserData(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("getUserData(").append(s).append(")").toString());
            Object obj = new SSAObj(s);
            if (!((SSAObj) (obj)).containsKey("key"))
            {
                responseBack(s, false, "key does not exist", null);
                return;
            } else
            {
                s = extractSuccessFunctionToCall(s);
                obj = ((SSAObj) (obj)).getString("key");
                String s1 = SupersonicSharedPrefHelper.getSupersonicPrefHelper().getUserData(((String) (obj)));
                obj = parseToJson(((String) (obj)), s1, null, null, null, null, null, null, null, false);
                s = generateJSToInject(s, ((String) (obj)));
                injectJavascript(s);
                return;
            }
        }

        public void getUserUniqueId(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("getUserUniqueId(").append(s).append(")").toString());
            Object obj = new SSAObj(s);
            if (!((SSAObj) (obj)).containsKey("productType"))
            {
                responseBack(s, false, "productType does not exist", null);
            } else
            {
                s = extractSuccessFunctionToCall(s);
                if (!TextUtils.isEmpty(s))
                {
                    obj = ((SSAObj) (obj)).getString("productType");
                    String s1 = SupersonicSharedPrefHelper.getSupersonicPrefHelper().getUniqueId(((String) (obj)));
                    obj = parseToJson("userUniqueId", s1, "productType", ((String) (obj)), null, null, null, null, null, false);
                    s = generateJSToInject(s, ((String) (obj)), "onGetUserUniqueIdSuccess", "onGetUserUniqueIdFail");
                    injectJavascript(s);
                    return;
                }
            }
        }

        public void initController(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("initController(").append(s).append(")").toString());
            s = new SSAObj(s);
            if (s.containsKey("stage"))
            {
                s = s.getString("stage");
                if ("ready".equalsIgnoreCase(s))
                {
                    mControllerState = com.supersonicads.sdk.data.SSAEnums.ControllerState.Ready;
                    mGlobalControllerTimer.cancel();
                    mLoadControllerTimer.cancel();
                    if (mRVmiss)
                    {
                        initBrandConnect(mBCAppKey, mBCUserId, mExtraParameters, mOnRewardedVideoListener);
                    }
                    if (mISmiss)
                    {
                        initInterstitial(mISAppKey, mISUserId, mExtraParameters, mOnInitInterstitialListener);
                    }
                    if (mOWmiss)
                    {
                        showOfferWall(mOWAppKey, mOWUserId, mExtraParameters, mOnOfferWallListener);
                    }
                    if (mOWCreditsMiss)
                    {
                        getOfferWallCredits(mOWCreditsAppKey, mOWCreditsUserId, mOnOfferWallListener);
                    }
                    restoreState(mSavedState);
                } else
                {
                    if ("loaded".equalsIgnoreCase(s))
                    {
                        mControllerState = com.supersonicads.sdk.data.SSAEnums.ControllerState.Loaded;
                        return;
                    }
                    if ("failed".equalsIgnoreCase(s))
                    {
                        mControllerState = com.supersonicads.sdk.data.SSAEnums.ControllerState.Failed;
                        if (mRVmiss)
                        {
                            sendProductErrorMessage(com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect);
                        }
                        if (mISmiss)
                        {
                            sendProductErrorMessage(com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial);
                        }
                        if (mOWmiss)
                        {
                            sendProductErrorMessage(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall);
                        }
                        if (mOWCreditsMiss)
                        {
                            sendProductErrorMessage(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWallCredits);
                            return;
                        }
                    } else
                    {
                        Logger.i(TAG, "No STAGE mentioned! Should not get here!");
                        return;
                    }
                }
            }
        }

        public void interstitialAvailability(String s)
        {
            Log.d(TAG, (new StringBuilder()).append("interstitialAvailability(").append(s).append(")").toString());
            changeInterstitialState(Boolean.parseBoolean((new SSAObj(s)).getString("available")), com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial.toString());
        }

        public void onAdWindowsClosed(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onAdWindowsClosed(").append(s).append(")").toString());
            mSavedState.adClosed();
            s = (new SSAObj(s)).getString("productType");
            if (!s.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect.toString())) goto _L2; else goto _L1
_L1:
            Log.d(PUB_TAG, "onRVAdClosed()");
_L4:
            if (shouldNotifyDeveloper(s) && s != null)
            {
                Context context = getBaseContext();
                if (context instanceof Activity)
                {
                    ((Activity)context).runOnUiThread(s. new Runnable() {

                        final JSInterface this$1;
                        final String val$product;

                        public void run()
                        {
                            if (product.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect.toString()))
                            {
                                mOnRewardedVideoListener.onRVAdClosed();
                            } else
                            {
                                if (product.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial.toString()))
                                {
                                    mOnInitInterstitialListener.onInterstitialAdClosed();
                                    return;
                                }
                                if (product.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.toString()))
                                {
                                    mOnOfferWallListener.onOWAdClosed();
                                    return;
                                }
                            }
                        }

            
            {
                this$1 = final_jsinterface;
                product = String.this;
                super();
            }
                    });
                }
            }
            return;
_L2:
            if (s.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial.toString()))
            {
                Log.d(PUB_TAG, "onISAdClosed()");
            } else
            if (s.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.toString()))
            {
                Log.d(PUB_TAG, "onOWAdClosed()");
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void onGenericFunctionFail(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onGenericFunctionFail(").append(s).append(")").toString());
            if (mOnGenericFunctionListener == null)
            {
                Logger.d(TAG, "genericFunctionListener was not found");
                return;
            }
            String s1 = (new SSAObj(s)).getString("errMsg");
            Context context = getBaseContext();
            if (context instanceof Activity)
            {
                ((Activity)context).runOnUiThread(s1. new Runnable() {

                    final JSInterface this$1;
                    final String val$message;

                    public void run()
                    {
                        mOnGenericFunctionListener.onGFFail(message);
                    }

            
            {
                this$1 = final_jsinterface;
                message = String.this;
                super();
            }
                });
            }
            responseBack(s, true, null, null);
            toastingErrMsg("onGenericFunctionFail", s);
        }

        public void onGenericFunctionSuccess(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onGenericFunctionSuccess(").append(s).append(")").toString());
            if (mOnGenericFunctionListener == null)
            {
                Logger.d(TAG, "genericFunctionListener was not found");
                return;
            }
            Context context = getBaseContext();
            if (context instanceof Activity)
            {
                ((Activity)context).runOnUiThread(new Runnable() {

                    final JSInterface this$1;

                    public void run()
                    {
                        mOnGenericFunctionListener.onGFSuccess();
                    }

            
            {
                this$1 = JSInterface.this;
                super();
            }
                });
            }
            responseBack(s, true, null, null);
        }

        public void onGetApplicationInfoFail(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onGetApplicationInfoFail(").append(s).append(")").toString());
            responseBack(s, true, null, null);
            toastingErrMsg("onGetApplicationInfoFail", s);
        }

        public void onGetApplicationInfoSuccess(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onGetApplicationInfoSuccess(").append(s).append(")").toString());
            responseBack(s, true, null, null);
            toastingErrMsg("onGetApplicationInfoSuccess", s);
        }

        public void onGetCachedFilesMapFail(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onGetCachedFilesMapFail(").append(s).append(")").toString());
            responseBack(s, true, null, null);
            toastingErrMsg("onGetCachedFilesMapFail", s);
        }

        public void onGetCachedFilesMapSuccess(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onGetCachedFilesMapSuccess(").append(s).append(")").toString());
            responseBack(s, true, null, null);
            toastingErrMsg("onGetCachedFilesMapSuccess", s);
        }

        public void onGetDeviceStatusFail(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onGetDeviceStatusFail(").append(s).append(")").toString());
            responseBack(s, true, null, null);
            toastingErrMsg("onGetDeviceStatusFail", s);
        }

        public void onGetDeviceStatusSuccess(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onGetDeviceStatusSuccess(").append(s).append(")").toString());
            responseBack(s, true, null, null);
            toastingErrMsg("onGetDeviceStatusSuccess", s);
        }

        public void onGetUDIAFail(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onGetUDIAFail(").append(s).append(")").toString());
        }

        public void onGetUDIASuccess(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onGetUDIASuccess(").append(s).append(")").toString());
        }

        public void onGetUserCreditsFail(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onGetUserCreditsFail(").append(s).append(")").toString());
            String s1 = (new SSAObj(s)).getString("errMsg");
            if (shouldNotifyDeveloper(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.toString()))
            {
                Context context = getBaseContext();
                if (context instanceof Activity)
                {
                    ((Activity)context).runOnUiThread(s1. new Runnable() {

                        final JSInterface this$1;
                        final String val$message;

                        public void run()
                        {
                            String s1 = message;
                            String s = s1;
                            if (s1 == null)
                            {
                                s = "We're sorry, some error occurred. we will investigate it";
                            }
                            mOnOfferWallListener.onGetOWCreditsFailed(s);
                        }

            
            {
                this$1 = final_jsinterface;
                message = String.this;
                super();
            }
                    });
                }
            }
            responseBack(s, true, null, null);
            toastingErrMsg("onGetUserCreditsFail", s);
        }

        public void onGetUserUniqueIdFail(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onGetUserUniqueIdFail(").append(s).append(")").toString());
        }

        public void onGetUserUniqueIdSuccess(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onGetUserUniqueIdSuccess(").append(s).append(")").toString());
        }

        public void onInitBrandConnectFail(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onInitBrandConnectFail(").append(s).append(")").toString());
            String s1 = (new SSAObj(s)).getString("errMsg");
            mSavedState.setRewardedVideoInitSuccess(false);
            if (shouldNotifyDeveloper(com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect.toString()))
            {
                Context context = getBaseContext();
                if (context instanceof Activity)
                {
                    ((Activity)context).runOnUiThread(s1. new Runnable() {

                        final JSInterface this$1;
                        final String val$message;

                        public void run()
                        {
                            String s1 = message;
                            String s = s1;
                            if (s1 == null)
                            {
                                s = "We're sorry, some error occurred. we will investigate it";
                            }
                            Log.d(TAG, (new StringBuilder()).append("onRVInitFail(message:").append(message).append(")").toString());
                            mOnRewardedVideoListener.onRVInitFail(s);
                        }

            
            {
                this$1 = final_jsinterface;
                message = String.this;
                super();
            }
                    });
                }
            }
            responseBack(s, true, null, null);
            toastingErrMsg("onInitBrandConnectFail", s);
        }

        public void onInitBrandConnectSuccess(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onInitBrandConnectSuccess(").append(s).append(")").toString());
            SSABCParameters ssabcparameters = new SSABCParameters(s);
            SupersonicSharedPrefHelper.getSupersonicPrefHelper().setSSABCParameters(ssabcparameters);
            responseBack(s, true, null, null);
            toastingErrMsg("onInitBrandConnectSuccess", s);
        }

        public void onInitInterstitialFail(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onInitInterstitialFail(").append(s).append(")").toString());
            mSavedState.setInterstitialInitSuccess(false);
            String s1 = (new SSAObj(s)).getString("errMsg");
            if (mSavedState.reportInitInterstitial())
            {
                mSavedState.setReportInitInterstitial(false);
                if (shouldNotifyDeveloper(com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial.toString()))
                {
                    Context context = getBaseContext();
                    if (context instanceof Activity)
                    {
                        ((Activity)context).runOnUiThread(s1. new Runnable() {

                            final JSInterface this$1;
                            final String val$message;

                            public void run()
                            {
                                String s1 = message;
                                String s = s1;
                                if (s1 == null)
                                {
                                    s = "We're sorry, some error occurred. we will investigate it";
                                }
                                Log.d(TAG, (new StringBuilder()).append("onInterstitialInitFail(message:").append(s).append(")").toString());
                                mOnInitInterstitialListener.onInterstitialInitFail(s);
                            }

            
            {
                this$1 = final_jsinterface;
                message = String.this;
                super();
            }
                        });
                    }
                }
            }
            responseBack(s, true, null, null);
            toastingErrMsg("onInitInterstitialFail", s);
        }

        public void onInitInterstitialSuccess(String s)
        {
            Logger.i(TAG, "onInitInterstitialSuccess()");
            toastingErrMsg("onInitInterstitialSuccess", "true");
            mSavedState.setInterstitialInitSuccess(true);
            if (mSavedState.reportInitInterstitial())
            {
                mSavedState.setReportInitInterstitial(false);
                if (shouldNotifyDeveloper(com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial.toString()))
                {
                    s = getBaseContext();
                    if (s instanceof Activity)
                    {
                        ((Activity)s).runOnUiThread(new Runnable() {

                            final JSInterface this$1;

                            public void run()
                            {
                                Log.d(TAG, "onInterstitialInitSuccess()");
                                mOnInitInterstitialListener.onInterstitialInitSuccess();
                            }

            
            {
                this$1 = JSInterface.this;
                super();
            }
                        });
                    }
                }
            }
        }

        public void onOfferWallGeneric(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onOfferWallGeneric(").append(s).append(")").toString());
            if (shouldNotifyDeveloper(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.toString()))
            {
                mOnOfferWallListener.onOWGeneric("", "");
            }
        }

        public void onRewardedVideoGeneric(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onRewardedVideoGeneric(").append(s).append(")").toString());
            if (shouldNotifyDeveloper(com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect.toString()))
            {
                mOnRewardedVideoListener.onRVGeneric("", "");
            }
        }

        public void onShowBrandConnectFail(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onShowBrandConnectFail(").append(s).append(")").toString());
            responseBack(s, true, null, null);
            toastingErrMsg("onShowBrandConnectFail", s);
        }

        public void onShowBrandConnectSuccess(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onShowBrandConnectSuccess(").append(s).append(")").toString());
            responseBack(s, true, null, null);
            toastingErrMsg("onShowBrandConnectSuccess", s);
        }

        public void onShowInterstitialFail(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onShowInterstitialFail(").append(s).append(")").toString());
            String s1 = (new SSAObj(s)).getString("errMsg");
            responseBack(s, true, null, null);
            if (shouldNotifyDeveloper(com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial.toString()))
            {
                Context context = getBaseContext();
                if (context instanceof Activity)
                {
                    ((Activity)context).runOnUiThread(s1. new Runnable() {

                        final JSInterface this$1;
                        final String val$message;

                        public void run()
                        {
                            String s1 = message;
                            String s = s1;
                            if (s1 == null)
                            {
                                s = "We're sorry, some error occurred. we will investigate it";
                            }
                            mOnInitInterstitialListener.onInterstitialShowFail(s);
                        }

            
            {
                this$1 = final_jsinterface;
                message = String.this;
                super();
            }
                    });
                }
            }
            toastingErrMsg("onShowInterstitialFail", s);
        }

        public void onShowInterstitialSuccess(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onShowInterstitialSuccess(").append(s).append(")").toString());
            mSavedState.adOpened(com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial.ordinal());
            responseBack(s, true, null, null);
            if (shouldNotifyDeveloper(com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial.toString()))
            {
                Context context = getBaseContext();
                if (context instanceof Activity)
                {
                    ((Activity)context).runOnUiThread(new Runnable() {

                        final JSInterface this$1;

                        public void run()
                        {
                            mOnInitInterstitialListener.onInterstitialShowSuccess();
                        }

            
            {
                this$1 = JSInterface.this;
                super();
            }
                    });
                }
                toastingErrMsg("onShowInterstitialSuccess", s);
            }
        }

        public void onShowOfferWallFail(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onShowOfferWallFail(").append(s).append(")").toString());
            String s1 = (new SSAObj(s)).getString("errMsg");
            if (shouldNotifyDeveloper(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.toString()))
            {
                Context context = getBaseContext();
                if (context instanceof Activity)
                {
                    ((Activity)context).runOnUiThread(s1. new Runnable() {

                        final JSInterface this$1;
                        final String val$message;

                        public void run()
                        {
                            String s1 = message;
                            String s = s1;
                            if (s1 == null)
                            {
                                s = "We're sorry, some error occurred. we will investigate it";
                            }
                            mOnOfferWallListener.onOWShowFail(s);
                        }

            
            {
                this$1 = final_jsinterface;
                message = String.this;
                super();
            }
                    });
                }
            }
            responseBack(s, true, null, null);
            toastingErrMsg("onShowOfferWallFail", s);
        }

        public void onShowOfferWallSuccess(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onShowOfferWallSuccess(").append(s).append(")").toString());
            mSavedState.adOpened(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.ordinal());
            if (shouldNotifyDeveloper(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.toString()))
            {
                Context context = getBaseContext();
                if (context instanceof Activity)
                {
                    ((Activity)context).runOnUiThread(new Runnable() {

                        final JSInterface this$1;

                        public void run()
                        {
                            mOnOfferWallListener.onOWShowSuccess();
                        }

            
            {
                this$1 = JSInterface.this;
                super();
            }
                    });
                }
            }
            responseBack(s, true, null, null);
            toastingErrMsg("onShowOfferWallSuccess", s);
        }

        public void onUDIAFail(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onUDIAFail(").append(s).append(")").toString());
        }

        public void onUDIASuccess(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("onUDIASuccess(").append(s).append(")").toString());
        }

        public void onVideoStatusChanged(String s)
        {
label0:
            {
                Log.d(TAG, (new StringBuilder()).append("onVideoStatusChanged(").append(s).append(")").toString());
                s = new SSAObj(s);
                String s1 = s.getString("productType");
                if (mVideoEventsListener != null && !TextUtils.isEmpty(s1) && com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect.toString().equalsIgnoreCase(s1))
                {
                    s = s.getString("status");
                    if (!"started".equalsIgnoreCase(s))
                    {
                        break label0;
                    }
                    mVideoEventsListener.onVideoStarted();
                }
                return;
            }
            if ("paused".equalsIgnoreCase(s))
            {
                mVideoEventsListener.onVideoPaused();
                return;
            }
            if ("playing".equalsIgnoreCase(s))
            {
                mVideoEventsListener.onVideoResumed();
                return;
            }
            if ("ended".equalsIgnoreCase(s))
            {
                mVideoEventsListener.onVideoEnded();
                return;
            }
            if ("stopped".equalsIgnoreCase(s))
            {
                mVideoEventsListener.onVideoStopped();
                return;
            } else
            {
                Logger.i(TAG, (new StringBuilder()).append("onVideoStatusChanged: unknown status: ").append(s).toString());
                return;
            }
        }

        public void openUrl(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("openUrl(").append(s).append(")").toString());
            Object obj = new SSAObj(s);
            s = ((SSAObj) (obj)).getString("url");
            Object obj1 = ((SSAObj) (obj)).getString("method");
            obj = getBaseContext();
            if (((String) (obj1)).equalsIgnoreCase("external_browser"))
            {
                ((Context) (obj)).startActivity((new Intent("android.intent.action.VIEW")).setData(Uri.parse(s)));
            } else
            {
                if (((String) (obj1)).equalsIgnoreCase("webview"))
                {
                    obj1 = new Intent(((Context) (obj)), com/supersonicads/sdk/controller/OpenUrlActivity);
                    ((Intent) (obj1)).putExtra(SupersonicWebView.EXTERNAL_URL, s);
                    ((Intent) (obj1)).putExtra(SupersonicWebView.SECONDARY_WEB_VIEW, true);
                    ((Context) (obj)).startActivity(((Intent) (obj1)));
                    return;
                }
                if (((String) (obj1)).equalsIgnoreCase("store"))
                {
                    Intent intent = new Intent(((Context) (obj)), com/supersonicads/sdk/controller/OpenUrlActivity);
                    intent.putExtra(SupersonicWebView.EXTERNAL_URL, s);
                    intent.putExtra(SupersonicWebView.IS_STORE, true);
                    intent.putExtra(SupersonicWebView.SECONDARY_WEB_VIEW, true);
                    ((Context) (obj)).startActivity(intent);
                    return;
                }
            }
        }

        public void removeCloseEventHandler(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("removeCloseEventHandler(").append(s).append(")").toString());
            if (mCloseEventTimer != null)
            {
                mCloseEventTimer.cancel();
            }
            isRemoveCloseEventHandler = true;
        }

        public void saveFile(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("saveFile(").append(s).append(")").toString());
            SSAFile ssafile = new SSAFile(s);
            if (SDKUtils.getAvailableSpaceInMB(getBaseContext(), mCacheDirectory) <= 0L)
            {
                responseBack(s, false, "no_disk_space", null);
                return;
            }
            if (!SupersonicStorageUtils.isExternalStorageAvailable())
            {
                responseBack(s, false, "sotrage_unavailable", null);
                return;
            }
            if (SupersonicStorageUtils.isFileCached(mCacheDirectory, ssafile))
            {
                responseBack(s, false, "file_already_exist", null);
                return;
            }
            if (!SDKUtils.isOnline(getBaseContext()))
            {
                responseBack(s, false, "no_network_connection", null);
                return;
            }
            responseBack(s, true, null, null);
            s = ssafile.getLastUpdateTime();
            if (s != null)
            {
                String s1 = String.valueOf(s);
                if (!TextUtils.isEmpty(s1))
                {
                    s = ssafile.getPath();
                    if (s.contains("/"))
                    {
                        s = ssafile.getPath().split("/");
                        s = s[s.length - 1];
                    }
                    SupersonicSharedPrefHelper.getSupersonicPrefHelper().setCampaignLastUpdate(s, s1);
                }
            }
            downloadManager.downloadFile(ssafile);
        }

        public void setBackButtonState(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("setBackButtonState(").append(s).append(")").toString());
            s = (new SSAObj(s)).getString("state");
            SupersonicSharedPrefHelper.getSupersonicPrefHelper().setBackButtonState(s);
        }

        public void setForceClose(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("setForceClose(").append(s).append(")").toString());
            s = new SSAObj(s);
            String s1 = s.getString("width");
            String s2 = s.getString("height");
            mHiddenForceCloseWidth = Integer.parseInt(s1);
            mHiddenForceCloseHeight = Integer.parseInt(s2);
            mHiddenForceCloseLocation = s.getString("position");
        }

        public void setOrientation(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("setOrientation(").append(s).append(")").toString());
            s = (new SSAObj(s)).getString("orientation");
            setOrientationState(s);
            int i = SDKUtils.getApplicationRotation(getBaseContext());
            if (mChangeListener != null)
            {
                mChangeListener.onSetOrientationCalled(s, i);
            }
        }

        public void setStoreSearchKeys(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("setStoreSearchKeys(").append(s).append(")").toString());
            SupersonicSharedPrefHelper.getSupersonicPrefHelper().setSearchKeys(s);
        }

        public void setUserData(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("setUserData(").append(s).append(")").toString());
            Object obj = new SSAObj(s);
            if (!((SSAObj) (obj)).containsKey("key"))
            {
                responseBack(s, false, "key does not exist", null);
                return;
            }
            if (!((SSAObj) (obj)).containsKey("value"))
            {
                responseBack(s, false, "value does not exist", null);
                return;
            }
            String s1 = ((SSAObj) (obj)).getString("key");
            obj = ((SSAObj) (obj)).getString("value");
            if (SupersonicSharedPrefHelper.getSupersonicPrefHelper().setUserData(s1, ((String) (obj))))
            {
                s = extractSuccessFunctionToCall(s);
                s1 = parseToJson(s1, ((String) (obj)), null, null, null, null, null, null, null, false);
                s = generateJSToInject(s, s1);
                injectJavascript(s);
                return;
            } else
            {
                responseBack(s, false, "SetUserData failed writing to shared preferences", null);
                return;
            }
        }

        public void setUserUniqueId(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("setUserUniqueId(").append(s).append(")").toString());
            Object obj = new SSAObj(s);
            if (!((SSAObj) (obj)).containsKey("userUniqueId") || !((SSAObj) (obj)).containsKey("productType"))
            {
                responseBack(s, false, "uniqueId or productType does not exist", null);
                return;
            }
            String s1 = ((SSAObj) (obj)).getString("userUniqueId");
            obj = ((SSAObj) (obj)).getString("productType");
            if (SupersonicSharedPrefHelper.getSupersonicPrefHelper().setUniqueId(s1, ((String) (obj))))
            {
                responseBack(s, true, null, null);
                return;
            } else
            {
                responseBack(s, false, "setUserUniqueId failed", null);
                return;
            }
        }

        public void setWebviewBackgroundColor(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("setWebviewBackgroundColor(").append(s).append(")").toString());
            setWebviewBackground(s);
        }

        public void toggleUDIA(String s)
        {
            Logger.i(TAG, (new StringBuilder()).append("toggleUDIA(").append(s).append(")").toString());
            SSAObj ssaobj = new SSAObj(s);
            if (!ssaobj.containsKey("toggle"))
            {
                responseBack(s, false, "toggle key does not exist", null);
            } else
            {
                int i = Integer.parseInt(ssaobj.getString("toggle"));
                if (i != 0)
                {
                    String s1 = Integer.toBinaryString(i);
                    if (TextUtils.isEmpty(s1))
                    {
                        responseBack(s, false, "fialed to convert toggle", null);
                        return;
                    }
                    if (s1.toCharArray()[3] == '0')
                    {
                        SupersonicSharedPrefHelper.getSupersonicPrefHelper().setShouldRegisterSessions(true);
                        return;
                    } else
                    {
                        SupersonicSharedPrefHelper.getSupersonicPrefHelper().setShouldRegisterSessions(false);
                        return;
                    }
                }
            }
        }

        public JSInterface(Context context)
        {
            this$0 = SupersonicWebView.this;
            super();
            udiaResults = 0;
        }
    }

    public static interface OnWebViewControllerChangeListener
    {

        public abstract void onHide();

        public abstract void onSetOrientationCalled(String s, int i);
    }

    public static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State Display;
        public static final State Gone;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/supersonicads/sdk/controller/SupersonicWebView$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            Display = new State("Display", 0);
            Gone = new State("Gone", 1);
            $VALUES = (new State[] {
                Display, Gone
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }

    private class SupersonicWebViewTouchListener
        implements android.view.View.OnTouchListener
    {

        final SupersonicWebView this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (motionevent.getAction() != 1) goto _L2; else goto _L1
_L1:
            float f;
            float f1;
            int i;
            int j;
            int k;
            int l;
            int i1;
            int j1;
            f = motionevent.getX();
            f1 = motionevent.getY();
            Logger.i(TAG, (new StringBuilder()).append("X:").append((int)f).append(" Y:").append((int)f1).toString());
            j1 = SDKUtils.getDeviceWidth();
            i1 = SDKUtils.getDeviceHeight();
            Logger.i(TAG, (new StringBuilder()).append("Width:").append(j1).append(" Height:").append(i1).toString());
            k = SDKUtils.dpToPx(mHiddenForceCloseWidth);
            l = SDKUtils.dpToPx(mHiddenForceCloseHeight);
            i = 0;
            j = 0;
            if (!"top-right".equalsIgnoreCase(mHiddenForceCloseLocation)) goto _L4; else goto _L3
_L3:
            i = j1 - (int)f;
            j = (int)f1;
_L6:
            if (i <= k && j <= l)
            {
                isRemoveCloseEventHandler = false;
                if (mCloseEventTimer != null)
                {
                    mCloseEventTimer.cancel();
                }
                mCloseEventTimer = (new CountDownTimer(2000L, 500L) {

                    final SupersonicWebViewTouchListener this$1;

                    public void onFinish()
                    {
                        Logger.i(TAG, "Close Event Timer Finish");
                        if (isRemoveCloseEventHandler)
                        {
                            isRemoveCloseEventHandler = false;
                            return;
                        } else
                        {
                            engageEnd("forceClose");
                            return;
                        }
                    }

                    public void onTick(long l)
                    {
                        Logger.i(TAG, (new StringBuilder()).append("Close Event Timer Tick ").append(l).toString());
                    }

            
            {
                this$1 = SupersonicWebViewTouchListener.this;
                super(l, l1);
            }
                }).start();
            }
_L2:
            return false;
_L4:
            if ("top-left".equalsIgnoreCase(mHiddenForceCloseLocation))
            {
                i = (int)f;
                j = (int)f1;
            } else
            if ("bottom-right".equalsIgnoreCase(mHiddenForceCloseLocation))
            {
                i = j1 - (int)f;
                j = i1 - (int)f1;
            } else
            if ("bottom-left".equalsIgnoreCase(mHiddenForceCloseLocation))
            {
                i = (int)f;
                j = i1 - (int)f1;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        private SupersonicWebViewTouchListener()
        {
            this$0 = SupersonicWebView.this;
            super();
        }

    }

    private class ViewClient extends WebViewClient
    {

        final SupersonicWebView this$0;

        public void onPageFinished(WebView webview, String s)
        {
            Logger.i("onPageFinished", s);
            if (s.contains("adUnit") || s.contains("index.html"))
            {
                pageFinished();
            }
            super.onPageFinished(webview, s);
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            Logger.i("onPageStarted", s);
            super.onPageStarted(webview, s, bitmap);
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            Logger.i("onReceivedError", (new StringBuilder()).append(s1).append(" ").append(s).toString());
            super.onReceivedError(webview, i, s, s1);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webview, String s)
        {
            boolean flag;
            Logger.i("shouldInterceptRequest", s);
            flag = false;
            boolean flag1 = (new URL(s)).getFile().contains("mraid.js");
            if (flag1)
            {
                flag = true;
            }
_L2:
            Object obj;
            File file;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_120;
            }
            obj = (new StringBuilder()).append("file://").append(mCacheDirectory).append(File.separator).append("mraid.js").toString();
            file = new File(((String) (obj)));
            new FileInputStream(file);
            obj = new WebResourceResponse("text/javascript", "UTF-8", getClass().getResourceAsStream(((String) (obj))));
            return ((WebResourceResponse) (obj));
            Object obj1;
            obj1;
            return super.shouldInterceptRequest(webview, s);
            obj1;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            Logger.i("shouldOverrideUrlLoading", s);
            if (handleSearchKeysURLs(s))
            {
                interceptedUrlToStore();
                return true;
            } else
            {
                return super.shouldOverrideUrlLoading(webview, s);
            }
        }

        private ViewClient()
        {
            this$0 = SupersonicWebView.this;
            super();
        }

    }


    public static int DISPLAY_WEB_VIEW_INTENT = 0;
    public static String EXTERNAL_URL = "external_url";
    public static String IS_STORE = "is_store";
    public static String IS_STORE_CLOSE = "is_store_close";
    private static String JSON_KEY_FAIL = "fail";
    private static String JSON_KEY_SUCCESS = "success";
    public static int OPEN_URL_INTENT = 1;
    public static String SECONDARY_WEB_VIEW = "secondary_web_view";
    public static String WEBVIEW_TYPE = "webview_type";
    public static int mDebugMode = 0;
    public static String mDownloadDomain = "http://s.ssacdn.com/";
    private final String GENERIC_MESSAGE = "We're sorry, some error occurred. we will investigate it";
    private String PUB_TAG;
    private String TAG;
    private DownloadManager downloadManager;
    private Boolean isKitkatAndAbove;
    private boolean isRemoveCloseEventHandler;
    private String mBCAppKey;
    private String mBCUserId;
    private String mCacheDirectory;
    private OnWebViewControllerChangeListener mChangeListener;
    private CountDownTimer mCloseEventTimer;
    private BroadcastReceiver mConnectionReceiver;
    private String mControllerKeyPressed;
    private com.supersonicads.sdk.data.SSAEnums.ControllerState mControllerState;
    private View mCustomView;
    private android.webkit.WebChromeClient.CustomViewCallback mCustomViewCallback;
    private FrameLayout mCustomViewContainer;
    private Map mExtraParameters;
    private boolean mGlobalControllerTimeFinish;
    private CountDownTimer mGlobalControllerTimer;
    private int mHiddenForceCloseHeight;
    private String mHiddenForceCloseLocation;
    private int mHiddenForceCloseWidth;
    private String mISAppKey;
    private Map mISExtraParameters;
    private String mISUserId;
    private boolean mISmiss;
    private Boolean mIsInterstitialAvailable;
    private FrameLayout mLayout;
    private CountDownTimer mLoadControllerTimer;
    private String mOWAppKey;
    private String mOWCreditsAppKey;
    private boolean mOWCreditsMiss;
    private String mOWCreditsUserId;
    private String mOWUserId;
    private boolean mOWmiss;
    private OnGenericFunctionListener mOnGenericFunctionListener;
    private OnInterstitialListener mOnInitInterstitialListener;
    private OnOfferWallListener mOnOfferWallListener;
    private OnRewardedVideoListener mOnRewardedVideoListener;
    private String mOrientationState;
    private boolean mRVmiss;
    private String mRequestParameters;
    private AdUnitsState mSavedState;
    private Object mSavedStateLocker;
    private State mState;
    private Uri mUri;
    private VideoEventsListener mVideoEventsListener;
    private ChromeClient mWebChromeClient;

    public SupersonicWebView(Context context)
    {
        super(context);
        TAG = com/supersonicads/sdk/controller/SupersonicWebView.getSimpleName();
        PUB_TAG = "Supersonic";
        mIsInterstitialAvailable = null;
        mControllerKeyPressed = "interrupt";
        mHiddenForceCloseWidth = 50;
        mHiddenForceCloseHeight = 50;
        mHiddenForceCloseLocation = "top-right";
        mControllerState = com.supersonicads.sdk.data.SSAEnums.ControllerState.None;
        isKitkatAndAbove = null;
        mSavedStateLocker = new Object();
        mConnectionReceiver = new BroadcastReceiver() {

            final SupersonicWebView this$0;

            public void onReceive(Context context1, Intent intent)
            {
                boolean flag = false;
                boolean flag1 = false;
                context1 = (ConnectivityManager)context1.getSystemService("connectivity");
                intent = context1.getNetworkInfo(1);
                if (intent != null)
                {
                    flag = intent.isConnected();
                }
                context1 = context1.getNetworkInfo(0);
                if (context1 != null)
                {
                    flag1 = context1.isConnected();
                }
                if (mControllerState == com.supersonicads.sdk.data.SSAEnums.ControllerState.Ready)
                {
                    deviceStatusChanged(flag, flag1);
                }
            }

            
            {
                this$0 = SupersonicWebView.this;
                super();
            }
        };
        mSavedState = new AdUnitsState();
        Logger.i(TAG, "C'tor");
        initLayout(context);
        mCacheDirectory = SupersonicStorageUtils.initializeCacheDirectory(context);
        downloadManager = DownloadManager.getInstance(mCacheDirectory);
        downloadManager.setOnPreCacheCompletion(this);
        mWebChromeClient = new ChromeClient();
        setWebViewClient(new ViewClient());
        setWebChromeClient(mWebChromeClient);
        setWebViewSettings();
        addJavascriptInterface(new JSInterface(context), "Android");
        setDownloadListener(this);
        setOnTouchListener(new SupersonicWebViewTouchListener());
    }

    private void closeWebView()
    {
        if (mChangeListener != null)
        {
            mChangeListener.onHide();
        }
    }

    private void createInitProductJSMethod(com.supersonicads.sdk.data.SSAEnums.ProductType producttype)
    {
        String s = null;
        if (producttype != com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect) goto _L2; else goto _L1
_L1:
        s = generateJSToInject("initBrandConnect", "onInitBrandConnectSuccess", "onInitBrandConnectFail");
_L4:
        if (s != null)
        {
            injectJavascript(s);
        }
        return;
_L2:
        if (producttype == com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial)
        {
            producttype = new HashMap();
            producttype.put("applicationKey", mISAppKey);
            producttype.put("applicationUserId", mISUserId);
            if (mISExtraParameters != null)
            {
                producttype.putAll(mISExtraParameters);
            }
            s = generateJSToInject("initInterstitial", flatMapToJsonAsString(producttype), "onInitInterstitialSuccess", "onInitInterstitialFail");
        } else
        if (producttype == com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall)
        {
            s = generateJSToInject("showOfferWall", "onShowOfferWallSuccess", "onShowOfferWallFail");
        } else
        if (producttype == com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWallCredits)
        {
            s = generateJSToInject("getUserCredits", parseToJson("productType", "OfferWall", "applicationKey", mOWCreditsAppKey, "applicationUserId", mOWCreditsUserId, null, null, null, false), "null", "onGetUserCreditsFail");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void evaluateJavascriptKitKat(String s)
    {
        evaluateJavascript(s, null);
    }

    private String extractFailFunctionToCall(String s)
    {
        return (new SSAObj(s)).getString(JSON_KEY_FAIL);
    }

    private String extractSuccessFunctionToCall(String s)
    {
        return (new SSAObj(s)).getString(JSON_KEY_SUCCESS);
    }

    private String flatMapToJsonAsString(Map map)
    {
        JSONObject jsonobject = new JSONObject();
        if (map != null)
        {
            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                try
                {
                    jsonobject.putOpt((String)entry.getKey(), SDKUtils.encodeString((String)entry.getValue()));
                }
                catch (JSONException jsonexception)
                {
                    Logger.i(TAG, (new StringBuilder()).append("flatMapToJsonAsStringfailed ").append(jsonexception.toString()).toString());
                }
                map.remove();
            }
        }
        return jsonobject.toString();
    }

    private String generateJSToInject(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("SSA_CORE.SDKController.runFunction('").append(s).append("');");
        return stringbuilder.toString();
    }

    private String generateJSToInject(String s, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("SSA_CORE.SDKController.runFunction('").append(s).append("?parameters=").append(s1).append("');");
        return stringbuilder.toString();
    }

    private String generateJSToInject(String s, String s1, String s2)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("SSA_CORE.SDKController.runFunction('").append(s).append("','").append(s1).append("','").append(s2).append("');");
        return stringbuilder.toString();
    }

    private String generateJSToInject(String s, String s1, String s2, String s3)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("SSA_CORE.SDKController.runFunction('").append(s).append("?parameters=").append(s1).append("','").append(s2).append("','").append(s3).append("');");
        return stringbuilder.toString();
    }

    private Object[] getApplicationParams(String s)
    {
        boolean flag = false;
        JSONObject jsonobject = new JSONObject();
        Object obj = "";
        String s1 = "";
        if (!TextUtils.isEmpty(s))
        {
            if (s.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect.toString()))
            {
                obj = mBCAppKey;
                s1 = mBCUserId;
            } else
            if (s.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial.toString()))
            {
                obj = mISAppKey;
                s1 = mISUserId;
            } else
            if (s.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.toString()))
            {
                obj = mOWAppKey;
                s1 = mOWUserId;
            }
            try
            {
                jsonobject.put("productType", s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        } else
        {
            flag = true;
        }
        if (!TextUtils.isEmpty(s1))
        {
            try
            {
                jsonobject.put(SDKUtils.encodeString("applicationUserId"), SDKUtils.encodeString(s1));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        } else
        {
            flag = true;
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            try
            {
                jsonobject.put(SDKUtils.encodeString("applicationKey"), SDKUtils.encodeString(((String) (obj))));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        } else
        {
            flag = true;
        }
        if (mExtraParameters != null && !mExtraParameters.isEmpty())
        {
            for (s = mExtraParameters.entrySet().iterator(); s.hasNext();)
            {
                obj = (java.util.Map.Entry)s.next();
                if (((String)((java.util.Map.Entry) (obj)).getKey()).equalsIgnoreCase("sdkWebViewCache"))
                {
                    setWebviewCache((String)((java.util.Map.Entry) (obj)).getValue());
                }
                try
                {
                    jsonobject.put(SDKUtils.encodeString((String)((java.util.Map.Entry) (obj)).getKey()), SDKUtils.encodeString((String)((java.util.Map.Entry) (obj)).getValue()));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((JSONException) (obj)).printStackTrace();
                }
            }

        }
        return (new Object[] {
            jsonobject.toString(), Boolean.valueOf(flag)
        });
    }

    private Context getBaseContext()
    {
        return ((MutableContextWrapper)getContext()).getBaseContext();
    }

    private Object[] getDeviceParams(Context context)
    {
        JSONObject jsonobject;
        Object obj;
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag2 = false;
        flag1 = false;
        obj = DeviceProperties.getInstance(context);
        jsonobject = new JSONObject();
        flag = flag2;
        jsonobject.put("appOrientation", "none");
        flag = flag2;
        String s = ((DeviceProperties) (obj)).getDeviceOem();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        flag = flag2;
        jsonobject.put(SDKUtils.encodeString("deviceOEM"), SDKUtils.encodeString(s));
        flag = flag2;
        s = ((DeviceProperties) (obj)).getDeviceModel();
        if (s == null) goto _L2; else goto _L1
_L1:
        flag = flag2;
        jsonobject.put(SDKUtils.encodeString("deviceModel"), SDKUtils.encodeString(s));
_L15:
        flag = flag1;
        SDKUtils.loadGoogleAdvertiserInfo(context);
        flag = flag1;
        s = SDKUtils.getAdvertiserId();
        flag = flag1;
        flag2 = SDKUtils.isLimitAdTrackingEnabled();
        flag = flag1;
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_221;
        }
        flag = flag1;
        Logger.i(TAG, "add AID and LAT");
        flag = flag1;
        jsonobject.put("isLimitAdTrackingEnabled", Boolean.valueOf(flag2));
        flag = flag1;
        jsonobject.put((new StringBuilder()).append("deviceIds").append("[").append("AID").append("]").toString(), SDKUtils.encodeString(s));
        flag = flag1;
        s = ((DeviceProperties) (obj)).getDeviceOsType();
        if (s == null) goto _L4; else goto _L3
_L3:
        flag = flag1;
        jsonobject.put(SDKUtils.encodeString("deviceOs"), SDKUtils.encodeString(s));
_L16:
        flag = flag1;
        s = Integer.toString(((DeviceProperties) (obj)).getDeviceOsVersion());
        if (s == null) goto _L6; else goto _L5
_L5:
        flag = flag1;
        jsonobject.put(SDKUtils.encodeString("deviceOSVersion"), s);
_L17:
        flag = flag1;
        s = ((DeviceProperties) (obj)).getSupersonicSdkVersion();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_326;
        }
        flag = flag1;
        jsonobject.put(SDKUtils.encodeString("SDKVersion"), SDKUtils.encodeString(s));
        flag = flag1;
        if (((DeviceProperties) (obj)).getDeviceCarrier() == null)
        {
            break MISSING_BLOCK_LABEL_373;
        }
        flag = flag1;
        if (((DeviceProperties) (obj)).getDeviceCarrier().length() <= 0)
        {
            break MISSING_BLOCK_LABEL_373;
        }
        flag = flag1;
        jsonobject.put(SDKUtils.encodeString("mobileCarrier"), SDKUtils.encodeString(((DeviceProperties) (obj)).getDeviceCarrier()));
        flag = flag1;
        obj = SDKUtils.getConnectionType(context);
        flag = flag1;
        if (TextUtils.isEmpty(((CharSequence) (obj)))) goto _L8; else goto _L7
_L7:
        flag = flag1;
        jsonobject.put(SDKUtils.encodeString("connectionType"), SDKUtils.encodeString(((String) (obj))));
_L18:
        flag = flag1;
        obj = context.getResources().getConfiguration().locale.getLanguage();
        flag = flag1;
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            break MISSING_BLOCK_LABEL_463;
        }
        flag = flag1;
        jsonobject.put(SDKUtils.encodeString("deviceLanguage"), SDKUtils.encodeString(((String) (obj)).toUpperCase()));
        flag = flag1;
        if (!SupersonicStorageUtils.isExternalStorageAvailable()) goto _L10; else goto _L9
_L9:
        flag = flag1;
        long l = SDKUtils.getAvailableSpaceInMB(context, mCacheDirectory);
        flag = flag1;
        jsonobject.put(SDKUtils.encodeString("diskFreeSize"), SDKUtils.encodeString(String.valueOf(l)));
_L19:
        flag = flag1;
        context = String.valueOf(SDKUtils.getDeviceWidth());
        if (context == null) goto _L12; else goto _L11
_L11:
        flag = flag1;
        obj = new StringBuilder();
        flag = flag1;
        ((StringBuilder) (obj)).append(SDKUtils.encodeString("deviceScreenSize")).append("[").append(SDKUtils.encodeString("width")).append("]");
        flag = flag1;
        jsonobject.put(((StringBuilder) (obj)).toString(), SDKUtils.encodeString(context));
_L20:
        flag = flag1;
        context = String.valueOf(SDKUtils.getDeviceHeight());
        if (context == null) goto _L14; else goto _L13
_L13:
        flag = flag1;
        obj = new StringBuilder();
        flag = flag1;
        ((StringBuilder) (obj)).append(SDKUtils.encodeString("deviceScreenSize")).append("[").append(SDKUtils.encodeString("height")).append("]");
        flag = flag1;
        jsonobject.put(((StringBuilder) (obj)).toString(), SDKUtils.encodeString(context));
_L21:
        flag = flag1;
        context = SDKUtils.getPackageName(getBaseContext());
        flag = flag1;
        if (TextUtils.isEmpty(context))
        {
            break MISSING_BLOCK_LABEL_712;
        }
        flag = flag1;
        jsonobject.put(SDKUtils.encodeString("bundleId"), SDKUtils.encodeString(context));
        flag = flag1;
        context = String.valueOf(SDKUtils.getDeviceScale());
        flag2 = flag1;
        flag = flag1;
        if (TextUtils.isEmpty(context))
        {
            break MISSING_BLOCK_LABEL_761;
        }
        flag = flag1;
        jsonobject.put(SDKUtils.encodeString("deviceScreenScale"), SDKUtils.encodeString(context));
        flag2 = flag1;
_L22:
        return (new Object[] {
            jsonobject.toString(), Boolean.valueOf(flag2)
        });
_L2:
        flag1 = true;
          goto _L15
_L4:
        flag1 = true;
          goto _L16
_L6:
        flag1 = true;
          goto _L17
_L8:
        flag1 = true;
          goto _L18
_L10:
        flag1 = true;
          goto _L19
_L12:
        flag1 = true;
          goto _L20
_L14:
        flag1 = true;
          goto _L21
        context;
        context.printStackTrace();
        flag2 = flag;
          goto _L22
    }

    private String getRequestParameters()
    {
        Object obj = DeviceProperties.getInstance(getBaseContext());
        StringBuilder stringbuilder = new StringBuilder();
        String s1 = ((DeviceProperties) (obj)).getSupersonicSdkVersion();
        if (!TextUtils.isEmpty(s1))
        {
            stringbuilder.append("SDKVersion").append("=").append(s1).append("&");
        }
        obj = ((DeviceProperties) (obj)).getDeviceOsType();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            stringbuilder.append("deviceOs").append("=").append(((String) (obj)));
        }
        boolean flag = false;
        if (getDebugMode() != 0)
        {
            flag = true;
            stringbuilder.append("&").append("debug").append("=").append(getDebugMode());
        }
        if (!"http://s.ssacdn.com/".equalsIgnoreCase(SupersonicSharedPrefHelper.getSupersonicPrefHelper().getSDKLoadUrl()) && getUri() != null)
        {
            String s3 = (new StringBuilder()).append(getUri().getScheme()).append(":").toString();
            String s2 = getUri().getHost();
            int i = getUri().getPort();
            String s = s2;
            if (i != -1)
            {
                s = (new StringBuilder()).append(s2).append(":").append(i).toString();
            }
            if (!flag)
            {
                stringbuilder.append("&").append("debug").append("=").append(getDebugMode());
            }
            stringbuilder.append("&").append("protocol").append("=").append(s3).append("&").append("domain").append("=").append(s);
        }
        return stringbuilder.toString();
    }

    private Uri getUri()
    {
        return mUri;
    }

    private void initLayout(Context context)
    {
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        mLayout = new FrameLayout(context);
        mCustomViewContainer = new FrameLayout(context);
        android.widget.FrameLayout.LayoutParams layoutparams1 = new android.widget.FrameLayout.LayoutParams(-1, -1);
        mCustomViewContainer.setLayoutParams(layoutparams1);
        mCustomViewContainer.setVisibility(8);
        context = new FrameLayout(context);
        context.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        context.addView(this);
        mLayout.addView(mCustomViewContainer, layoutparams);
        mLayout.addView(context);
    }

    private void initProduct(String s, String s1, Map map, com.supersonicads.sdk.data.SSAEnums.ProductType producttype, String s2)
    {
        if (TextUtils.isEmpty(s1) || TextUtils.isEmpty(s))
        {
            triggerOnControllerInitProductFail("User id or Application key are missing", producttype);
        } else
        {
            if (mControllerState == com.supersonicads.sdk.data.SSAEnums.ControllerState.Ready)
            {
                SupersonicSharedPrefHelper.getSupersonicPrefHelper().setApplicationKey(s, producttype);
                SupersonicSharedPrefHelper.getSupersonicPrefHelper().setUserID(s1, producttype);
                createInitProductJSMethod(producttype);
                return;
            }
            setMissProduct(producttype);
            if (mControllerState == com.supersonicads.sdk.data.SSAEnums.ControllerState.Failed)
            {
                triggerOnControllerInitProductFail(SDKUtils.createErrorMessage(s2, "Initiating Controller"), producttype);
                return;
            }
            if (mGlobalControllerTimeFinish)
            {
                downloadController();
                return;
            }
        }
    }

    private void injectJavascript(final String url)
    {
        final Object scriptBuilder = "empty";
        if (getDebugMode() != com.supersonicads.sdk.data.SSAEnums.DebugMode.MODE_0.getValue()) goto _L2; else goto _L1
_L1:
        Object obj = "console.log(\"JS exeption: \" + JSON.stringify(e));";
_L4:
        scriptBuilder = new StringBuilder();
        ((StringBuilder) (scriptBuilder)).append("try{").append(url).append("}catch(e){").append(((String) (obj))).append("}");
        url = (new StringBuilder()).append("javascript:").append(((StringBuilder) (scriptBuilder)).toString()).toString();
        obj = getBaseContext();
        if (obj instanceof Activity)
        {
            ((Activity)obj).runOnUiThread(new Runnable() {

                final SupersonicWebView this$0;
                final StringBuilder val$scriptBuilder;
                final String val$url;

                public void run()
                {
                    Logger.i(TAG, url);
                    if (isKitkatAndAbove == null)
                    {
                        break MISSING_BLOCK_LABEL_98;
                    }
                    if (isKitkatAndAbove.booleanValue())
                    {
                        evaluateJavascriptKitKat(scriptBuilder.toString());
                        return;
                    }
                    try
                    {
                        loadUrl(url);
                        return;
                    }
                    catch (Throwable throwable)
                    {
                        Logger.e(TAG, (new StringBuilder()).append("injectJavascript: ").append(throwable.toString()).toString());
                    }
                    return;
                    int i = android.os.Build.VERSION.SDK_INT;
                    if (i < 19)
                    {
                        break MISSING_BLOCK_LABEL_265;
                    }
                    evaluateJavascriptKitKat(scriptBuilder.toString());
                    isKitkatAndAbove = Boolean.valueOf(true);
                    return;
                    Object obj1;
                    obj1;
                    Logger.e(TAG, (new StringBuilder()).append("evaluateJavascrip NoSuchMethodError: SDK version=").append(android.os.Build.VERSION.SDK_INT).append(" ").append(obj1).toString());
                    loadUrl(url);
                    isKitkatAndAbove = Boolean.valueOf(false);
                    return;
                    obj1;
                    Logger.e(TAG, (new StringBuilder()).append("evaluateJavascrip Exception: SDK version=").append(android.os.Build.VERSION.SDK_INT).append(" ").append(obj1).toString());
                    loadUrl(url);
                    isKitkatAndAbove = Boolean.valueOf(false);
                    return;
                    loadUrl(url);
                    isKitkatAndAbove = Boolean.valueOf(false);
                    return;
                }

            
            {
                this$0 = SupersonicWebView.this;
                url = s;
                scriptBuilder = stringbuilder;
                super();
            }
            });
        }
        return;
_L2:
        obj = scriptBuilder;
        if (getDebugMode() >= com.supersonicads.sdk.data.SSAEnums.DebugMode.MODE_1.getValue())
        {
            obj = scriptBuilder;
            if (getDebugMode() <= com.supersonicads.sdk.data.SSAEnums.DebugMode.MODE_3.getValue())
            {
                obj = "console.log(\"JS exeption: \" + JSON.stringify(e));";
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private String mapToJson(Map map)
    {
        JSONObject jsonobject = new JSONObject();
        if (map != null && !map.isEmpty())
        {
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
            {
                String s = (String)iterator.next();
                String s1 = (String)map.get(s);
                try
                {
                    jsonobject.put(s, SDKUtils.encodeString(s1));
                }
                catch (JSONException jsonexception)
                {
                    jsonexception.printStackTrace();
                }
            }

        }
        return jsonobject.toString();
    }

    private String parseToJson(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, boolean flag)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
            {
                jsonobject.put(s, SDKUtils.encodeString(s1));
            }
            if (!TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s3))
            {
                jsonobject.put(s2, SDKUtils.encodeString(s3));
            }
            if (!TextUtils.isEmpty(s4) && !TextUtils.isEmpty(s5))
            {
                jsonobject.put(s4, SDKUtils.encodeString(s5));
            }
            if (!TextUtils.isEmpty(s6) && !TextUtils.isEmpty(s7))
            {
                jsonobject.put(s6, SDKUtils.encodeString(s7));
            }
            if (!TextUtils.isEmpty(s8))
            {
                jsonobject.put(s8, flag);
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return jsonobject.toString();
    }

    private void resetMissProduct()
    {
        mRVmiss = false;
        mISmiss = false;
        mOWmiss = false;
        mOWCreditsMiss = false;
    }

    private void responseBack(String s, boolean flag, String s1, String s2)
    {
        Object obj = new SSAObj(s);
        String s3 = ((SSAObj) (obj)).getString(JSON_KEY_SUCCESS);
        String s5 = ((SSAObj) (obj)).getString(JSON_KEY_FAIL);
        obj = null;
        if (flag)
        {
            if (!TextUtils.isEmpty(s3))
            {
                obj = s3;
            }
        } else
        if (!TextUtils.isEmpty(s5))
        {
            obj = s5;
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            String s4 = s;
            if (!TextUtils.isEmpty(s1))
            {
                try
                {
                    s4 = (new JSONObject(s)).put("errMsg", s1).toString();
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    s4 = s;
                }
            }
            s = s4;
            if (!TextUtils.isEmpty(s2))
            {
                try
                {
                    s = (new JSONObject(s4)).put("errCode", s2).toString();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s = s4;
                }
            }
            injectJavascript(generateJSToInject(((String) (obj)), s));
        }
    }

    private void sendProductErrorMessage(com.supersonicads.sdk.data.SSAEnums.ProductType producttype)
    {
        String s = "";
        static class _cls7
        {

            static final int $SwitchMap$com$supersonicads$sdk$data$SSAEnums$ProductType[];

            static 
            {
                $SwitchMap$com$supersonicads$sdk$data$SSAEnums$ProductType = new int[com.supersonicads.sdk.data.SSAEnums.ProductType.values().length];
                try
                {
                    $SwitchMap$com$supersonicads$sdk$data$SSAEnums$ProductType[com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$supersonicads$sdk$data$SSAEnums$ProductType[com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$supersonicads$sdk$data$SSAEnums$ProductType[com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$supersonicads$sdk$data$SSAEnums$ProductType[com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWallCredits.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls7..SwitchMap.com.supersonicads.sdk.data.SSAEnums.ProductType[producttype.ordinal()];
        JVM INSTR tableswitch 1 4: default 44
    //                   1 57
    //                   2 64
    //                   3 71
    //                   4 78;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        triggerOnControllerInitProductFail(SDKUtils.createErrorMessage(s, "Initiating Controller"), producttype);
        return;
_L2:
        s = "Init BC";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "Init IS";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "Show OW";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "Show OW Credits";
        if (true) goto _L1; else goto _L6
_L6:
    }

    private void setDisplayZoomControls(WebSettings websettings)
    {
        if (android.os.Build.VERSION.SDK_INT > 11)
        {
            websettings.setDisplayZoomControls(false);
        }
    }

    public static void setEXTERNAL_URL(String s)
    {
        EXTERNAL_URL = s;
    }

    private void setMediaPlaybackJellyBean(WebSettings websettings)
    {
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            websettings.setMediaPlaybackRequiresUserGesture(false);
        }
    }

    private void setMissProduct(com.supersonicads.sdk.data.SSAEnums.ProductType producttype)
    {
        if (producttype != com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect) goto _L2; else goto _L1
_L1:
        mRVmiss = true;
_L4:
        Logger.i(TAG, (new StringBuilder()).append("setMissProduct(").append(producttype).append(")").toString());
        return;
_L2:
        if (producttype == com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial)
        {
            mISmiss = true;
        } else
        if (producttype == com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall)
        {
            mOWmiss = true;
        } else
        if (producttype == com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWallCredits)
        {
            mOWCreditsMiss = true;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void setUri(Uri uri)
    {
        mUri = uri;
    }

    private void setWebDebuggingEnabled()
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setWebContentsDebuggingEnabled(true);
        }
    }

    private void setWebViewSettings()
    {
        WebSettings websettings = getSettings();
        websettings.setLoadWithOverviewMode(true);
        websettings.setUseWideViewPort(true);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        websettings.setBuiltInZoomControls(false);
        websettings.setJavaScriptEnabled(true);
        websettings.setSupportMultipleWindows(true);
        websettings.setJavaScriptCanOpenWindowsAutomatically(true);
        websettings.setGeolocationEnabled(true);
        websettings.setGeolocationDatabasePath("/data/data/org.itri.html5webview/databases/");
        websettings.setDomStorageEnabled(true);
        try
        {
            setDisplayZoomControls(websettings);
            setMediaPlaybackJellyBean(websettings);
            return;
        }
        catch (Throwable throwable)
        {
            Logger.e(TAG, (new StringBuilder()).append("setWebSettings - ").append(throwable.toString()).toString());
        }
    }

    private void setWebviewBackground(String s)
    {
        s = (new SSAObj(s)).getString("color");
        int i = 0;
        if (!"transparent".equalsIgnoreCase(s))
        {
            i = Color.parseColor(s);
        }
        setBackgroundColor(i);
    }

    private void setWebviewCache(String s)
    {
        if (s.equalsIgnoreCase("0"))
        {
            getSettings().setCacheMode(2);
            return;
        } else
        {
            getSettings().setCacheMode(-1);
            return;
        }
    }

    private boolean shouldNotifyDeveloper(String s)
    {
        boolean flag;
        flag = false;
        if (s == null)
        {
            Logger.d(TAG, "Trying to trigger a listener - no product was found");
            return false;
        }
        if (!s.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial.toString())) goto _L2; else goto _L1
_L1:
        if (mOnInitInterstitialListener != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L4:
        if (!flag)
        {
            Logger.d(TAG, (new StringBuilder()).append("Trying to trigger a listener - no listener was found for product ").append(s).toString());
        }
        return flag;
_L2:
        if (s.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect.toString()))
        {
            if (mOnRewardedVideoListener != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        if (s.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.toString()) || s.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWallCredits.toString()))
        {
            if (mOnOfferWallListener != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void toastingErrMsg(final String methodName, final String message)
    {
        message = (new SSAObj(message)).getString("errMsg");
        if (!TextUtils.isEmpty(message))
        {
            Context context = getBaseContext();
            if (context instanceof Activity)
            {
                ((Activity)context).runOnUiThread(new Runnable() {

                    final SupersonicWebView this$0;
                    final String val$message;
                    final String val$methodName;

                    public void run()
                    {
                        if (getDebugMode() == com.supersonicads.sdk.data.SSAEnums.DebugMode.MODE_3.getValue())
                        {
                            Toast.makeText(getBaseContext(), (new StringBuilder()).append(methodName).append(" : ").append(message).toString(), 1).show();
                        }
                    }

            
            {
                this$0 = SupersonicWebView.this;
                methodName = s;
                message = s1;
                super();
            }
                });
            }
        }
    }

    private void triggerOnControllerInitProductFail(final String message, final com.supersonicads.sdk.data.SSAEnums.ProductType type)
    {
        if (shouldNotifyDeveloper(type.toString()))
        {
            Context context = getBaseContext();
            if (context instanceof Activity)
            {
                ((Activity)context).runOnUiThread(new Runnable() {

                    final SupersonicWebView this$0;
                    final String val$message;
                    final com.supersonicads.sdk.data.SSAEnums.ProductType val$type;

                    public void run()
                    {
                        if (com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect != type) goto _L2; else goto _L1
_L1:
                        mSavedState.setRewardedVideoInitSuccess(false);
                        Log.d(TAG, (new StringBuilder()).append("onRVInitFail(message:").append(message).append(")").toString());
                        mOnRewardedVideoListener.onRVInitFail(message);
_L4:
                        return;
_L2:
                        if (com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial != type)
                        {
                            break; /* Loop/switch isn't completed */
                        }
                        mSavedState.setInterstitialInitSuccess(false);
                        if (mSavedState.reportInitInterstitial())
                        {
                            Log.d(TAG, (new StringBuilder()).append("onInterstitialInitFail(message:").append(message).append(")").toString());
                            mOnInitInterstitialListener.onInterstitialInitFail(message);
                            mSavedState.setReportInitInterstitial(false);
                            return;
                        }
                        if (true) goto _L4; else goto _L3
_L3:
                        if (com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall == type)
                        {
                            mOnOfferWallListener.onOWShowFail(message);
                            return;
                        }
                        if (com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWallCredits == type)
                        {
                            mOnOfferWallListener.onGetOWCreditsFailed(message);
                            return;
                        }
                        if (true) goto _L4; else goto _L5
_L5:
                    }

            
            {
                this$0 = SupersonicWebView.this;
                type = producttype;
                message = s;
                super();
            }
                });
            }
        }
    }

    public void assetCached(String s, String s1)
    {
        injectJavascript(generateJSToInject("assetCached", parseToJson("file", s, "path", s1, null, null, null, null, null, false)));
    }

    public void assetCachedFailed(String s, String s1, String s2)
    {
        injectJavascript(generateJSToInject("assetCachedFailed", parseToJson("file", s, "path", s1, "errMsg", s2, null, null, null, false)));
    }

    public void destroy()
    {
        super.destroy();
        if (downloadManager != null)
        {
            downloadManager.release();
        }
        if (mConnectionReceiver != null)
        {
            mConnectionReceiver = null;
        }
    }

    public void deviceStatusChanged(boolean flag, boolean flag1)
    {
        String s = "none";
        if (!flag) goto _L2; else goto _L1
_L1:
        s = "wifi";
_L4:
        injectJavascript(generateJSToInject("deviceStatusChanged", parseToJson("connectionType", s, null, null, null, null, null, null, null, false)));
        return;
_L2:
        if (flag1)
        {
            s = "3g";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void downloadController()
    {
        SupersonicStorageUtils.deleteFile(mCacheDirectory, "", "mobileController.html");
        setUri(Uri.parse(SupersonicSharedPrefHelper.getSupersonicPrefHelper().getSDKLoadUrl()));
        Object obj = SupersonicSharedPrefHelper.getSupersonicPrefHelper().getSDKDownloadUrl();
        String s = ((String) (obj));
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            s = "http://s.ssacdn.com/mobileSDKController/mobileController.html";
        }
        obj = new SSAFile(s, "");
        mGlobalControllerTimer = (new CountDownTimer(40000L, 1000L) {

            final SupersonicWebView this$0;

            public void onFinish()
            {
                Logger.i(TAG, "Global Controller Timer Finish");
                mGlobalControllerTimeFinish = true;
            }

            public void onTick(long l)
            {
                Logger.i(TAG, (new StringBuilder()).append("Global Controller Timer Tick ").append(l).toString());
            }

            
            {
                this$0 = SupersonicWebView.this;
                super(l, l1);
            }
        }).start();
        if (!downloadManager.isMobileControllerThreadLive())
        {
            Logger.i(TAG, (new StringBuilder()).append("Download Mobile Controller: ").append(s).toString());
            downloadManager.downloadMobileControllerFile(((SSAFile) (obj)));
            return;
        } else
        {
            Logger.i(TAG, "Download Mobile Controller: already alive");
            return;
        }
    }

    public void engageEnd(String s)
    {
        if (s.equals("forceClose"))
        {
            closeWebView();
        }
        injectJavascript(generateJSToInject("engageEnd", parseToJson("action", s, null, null, null, null, null, null, null, false)));
    }

    public void enterBackground()
    {
        if (mControllerState == com.supersonicads.sdk.data.SSAEnums.ControllerState.Ready)
        {
            injectJavascript(generateJSToInject("enterBackground"));
        }
    }

    public void enterForeground()
    {
        if (mControllerState == com.supersonicads.sdk.data.SSAEnums.ControllerState.Ready)
        {
            injectJavascript(generateJSToInject("enterForeground"));
        }
    }

    public void forceShowInterstitial()
    {
        injectJavascript(generateJSToInject("forceShowInterstitial", "onShowInterstitialSuccess", "onShowInterstitialFail"));
    }

    public String getControllerKeyPressed()
    {
        String s = mControllerKeyPressed;
        setControllerKeyPressed("interrupt");
        return s;
    }

    public int getDebugMode()
    {
        return mDebugMode;
    }

    public String getDownloadDomain()
    {
        return mDownloadDomain;
    }

    public FrameLayout getLayout()
    {
        return mLayout;
    }

    public void getOfferWallCredits(String s, String s1, OnOfferWallListener onofferwalllistener)
    {
        mOWCreditsAppKey = s;
        mOWCreditsUserId = s1;
        mOnOfferWallListener = onofferwalllistener;
        initProduct(mOWCreditsAppKey, mOWCreditsUserId, null, com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWallCredits, "Show OW Credits");
    }

    public String getOrientationState()
    {
        return mOrientationState;
    }

    public AdUnitsState getSavedState()
    {
        return mSavedState;
    }

    public State getState()
    {
        return mState;
    }

    public boolean handleSearchKeysURLs(String s)
    {
label0:
        {
            Object obj = SupersonicSharedPrefHelper.getSupersonicPrefHelper().getSearchKeys();
            if (obj == null || ((List) (obj)).isEmpty())
            {
                break label0;
            }
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
            } while (!s.contains((String)((Iterator) (obj)).next()));
            s = new Intent("android.intent.action.VIEW", Uri.parse(s));
            getBaseContext().startActivity(s);
            return true;
        }
        return false;
    }

    public void hideCustomView()
    {
        mWebChromeClient.onHideCustomView();
    }

    public boolean inCustomView()
    {
        return mCustomView != null;
    }

    public void initBrandConnect(String s, String s1, Map map, OnRewardedVideoListener onrewardedvideolistener)
    {
        mBCAppKey = s;
        mBCUserId = s1;
        mExtraParameters = map;
        mOnRewardedVideoListener = onrewardedvideolistener;
        mSavedState.setRewardedVideoAppKey(mBCAppKey);
        mSavedState.setRewardedVideoUserId(mBCUserId);
        mSavedState.setRewardedVideoExtraParams(mExtraParameters);
        initProduct(mBCAppKey, mBCUserId, mExtraParameters, com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect, "Init BC");
    }

    public void initInterstitial(String s, String s1, Map map, OnInterstitialListener oninterstitiallistener)
    {
        mISAppKey = s;
        mISUserId = s1;
        mISExtraParameters = map;
        mOnInitInterstitialListener = oninterstitiallistener;
        mSavedState.setInterstitialAppKey(mISAppKey);
        mSavedState.setInterstitialUserId(mISUserId);
        mSavedState.setInterstitialExtraParams(mISExtraParameters);
        mSavedState.setReportInitInterstitial(true);
        initProduct(mISAppKey, mISUserId, mExtraParameters, com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial, "Init IS");
    }

    public void interceptedUrlToStore()
    {
        injectJavascript(generateJSToInject("interceptedUrlToStore"));
    }

    public boolean isInterstitialAdAvailable()
    {
        if (mIsInterstitialAvailable == null)
        {
            return false;
        } else
        {
            return mIsInterstitialAvailable.booleanValue();
        }
    }

    public void load(int i)
    {
        String s;
        try
        {
            loadUrl("about:blank");
        }
        catch (Throwable throwable)
        {
            Logger.e(TAG, (new StringBuilder()).append("WebViewController:: load: ").append(throwable.toString()).toString());
        }
        s = (new StringBuilder()).append("file://").append(mCacheDirectory).append(File.separator).append("mobileController.html").toString();
        if ((new File((new StringBuilder()).append(mCacheDirectory).append(File.separator).append("mobileController.html").toString())).exists())
        {
            mRequestParameters = getRequestParameters();
            s = (new StringBuilder()).append(s).append("?").append(mRequestParameters).toString();
            mLoadControllerTimer = (new CountDownTimer(1000L, i) {

                final SupersonicWebView this$0;
                final int val$loadAttemp;

                public void onFinish()
                {
                    Logger.i(TAG, "Loading Controller Timer Finish");
                    if (loadAttemp == 2)
                    {
                        mGlobalControllerTimer.cancel();
                        if (mRVmiss)
                        {
                            sendProductErrorMessage(com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect);
                        }
                        if (mISmiss)
                        {
                            sendProductErrorMessage(com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial);
                        }
                        if (mOWmiss)
                        {
                            sendProductErrorMessage(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall);
                        }
                        if (mOWCreditsMiss)
                        {
                            sendProductErrorMessage(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWallCredits);
                        }
                        return;
                    } else
                    {
                        load(2);
                        return;
                    }
                }

                public void onTick(long l)
                {
                    Logger.i(TAG, (new StringBuilder()).append("Loading Controller Timer Tick ").append(l).toString());
                }

            
            {
                this$0 = SupersonicWebView.this;
                loadAttemp = i;
                super(final_l, l1);
            }
            }).start();
            try
            {
                loadUrl(s);
            }
            catch (Throwable throwable1)
            {
                Logger.e(TAG, (new StringBuilder()).append("WebViewController:: load: ").append(throwable1.toString()).toString());
            }
            Logger.i(TAG, (new StringBuilder()).append("load(): ").append(s).toString());
            return;
        } else
        {
            Logger.i(TAG, "load(): Mobile Controller HTML Does not exist");
            return;
        }
    }

    public void nativeNavigationPressed(String s)
    {
        injectJavascript(generateJSToInject("nativeNavigationPressed", parseToJson("action", s, null, null, null, null, null, null, null, false)));
    }

    public void onDownloadStart(String s, String s1, String s2, String s3, long l)
    {
        Logger.i(TAG, (new StringBuilder()).append(s).append(" ").append(s3).toString());
    }

    public void onFileDownloadFail(SSAFile ssafile)
    {
        if (ssafile.getFile().contains("mobileController.html"))
        {
            mGlobalControllerTimer.cancel();
            if (mRVmiss)
            {
                sendProductErrorMessage(com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect);
            }
            if (mISmiss)
            {
                sendProductErrorMessage(com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial);
            }
            if (mOWmiss)
            {
                sendProductErrorMessage(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall);
            }
            if (mOWCreditsMiss)
            {
                sendProductErrorMessage(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWallCredits);
            }
            return;
        } else
        {
            assetCachedFailed(ssafile.getFile(), ssafile.getPath(), ssafile.getErrMsg());
            return;
        }
    }

    public void onFileDownloadSuccess(SSAFile ssafile)
    {
        if (ssafile.getFile().contains("mobileController.html"))
        {
            load(1);
            return;
        } else
        {
            assetCached(ssafile.getFile(), ssafile.getPath());
            return;
        }
    }

    public void pageFinished()
    {
        injectJavascript(generateJSToInject("pageFinished"));
    }

    public void pause()
    {
        if (android.os.Build.VERSION.SDK_INT <= 10)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        onPause();
        return;
        Throwable throwable;
        throwable;
        Logger.i(TAG, (new StringBuilder()).append("WebViewController: pause() - ").append(throwable).toString());
        return;
    }

    public void registerConnectionReceiver(Context context)
    {
        context.registerReceiver(mConnectionReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void removeVideoEventsListener()
    {
        mVideoEventsListener = null;
    }

    public void restoreState(AdUnitsState adunitsstate)
    {
        Object obj = mSavedStateLocker;
        obj;
        JVM INSTR monitorenter ;
        if (!adunitsstate.shouldRestore() || !mControllerState.equals(com.supersonicads.sdk.data.SSAEnums.ControllerState.Ready)) goto _L2; else goto _L1
_L1:
        int i;
        Log.d(TAG, (new StringBuilder()).append("restoreState(state:").append(adunitsstate).append(")").toString());
        i = adunitsstate.getDisplayedProduct();
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_457;
        }
        if (i != com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect.ordinal()) goto _L4; else goto _L3
_L3:
        Log.d(TAG, "onRVAdClosed()");
        if (mOnRewardedVideoListener != null)
        {
            mOnRewardedVideoListener.onRVAdClosed();
        }
_L7:
        adunitsstate.adOpened(-1);
_L9:
        if (adunitsstate.isInterstitialInitSuccess())
        {
            Log.d(TAG, "onInterstitialAvailability(false)");
            if (mOnInitInterstitialListener != null)
            {
                mOnInitInterstitialListener.onInterstitialAvailability(false);
            }
            String s = adunitsstate.getInterstitialAppKey();
            String s2 = adunitsstate.getInterstitialUserId();
            Map map = adunitsstate.getInterstitialExtraParams();
            Log.d(TAG, (new StringBuilder()).append("initInterstitial(appKey:").append(s).append(", userId:").append(s2).append(", extraParam:").append(map).append(")").toString());
            initInterstitial(s, s2, map, mOnInitInterstitialListener);
        }
        if (adunitsstate.isRewardedVideoInitSuccess())
        {
            Log.d(TAG, "onRVNoMoreOffers()");
            if (mOnRewardedVideoListener != null)
            {
                mOnRewardedVideoListener.onRVNoMoreOffers();
            }
            String s1 = adunitsstate.getRewardedVideoAppKey();
            String s3 = adunitsstate.getRewardedVideoUserId();
            Map map1 = adunitsstate.getRewardedVideoExtraParams();
            Log.d(TAG, (new StringBuilder()).append("initRewardedVideo(appKey:").append(s1).append(", userId:").append(s3).append(", extraParam:").append(map1).append(")").toString());
            initBrandConnect(s1, s3, map1, mOnRewardedVideoListener);
        }
        adunitsstate.setShouldRestore(false);
_L2:
        mSavedState = adunitsstate;
        obj;
        JVM INSTR monitorexit ;
        return;
_L4:
        if (i != com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial.ordinal()) goto _L6; else goto _L5
_L5:
        Log.d(TAG, "onInterstitialAdClosed()");
        if (mOnInitInterstitialListener != null)
        {
            mOnInitInterstitialListener.onInterstitialAdClosed();
        }
          goto _L7
        adunitsstate;
        obj;
        JVM INSTR monitorexit ;
        throw adunitsstate;
_L6:
        if (i != com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.ordinal()) goto _L7; else goto _L8
_L8:
        Log.d(TAG, "onOWAdClosed()");
        if (mOnOfferWallListener != null)
        {
            mOnOfferWallListener.onOWAdClosed();
        }
          goto _L7
        Log.d(TAG, "No ad was opened");
          goto _L9
    }

    public void resume()
    {
        if (android.os.Build.VERSION.SDK_INT <= 10)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        onResume();
        return;
        Throwable throwable;
        throwable;
        Logger.i(TAG, (new StringBuilder()).append("WebViewController: onResume() - ").append(throwable).toString());
        return;
    }

    public void runGenericFunction(String s, Map map, OnGenericFunctionListener ongenericfunctionlistener)
    {
        mOnGenericFunctionListener = ongenericfunctionlistener;
        if ("initBrandConnect".equalsIgnoreCase(s))
        {
            initBrandConnect((String)map.get("applicationUserId"), (String)map.get("applicationKey"), map, mOnRewardedVideoListener);
            return;
        }
        if ("showBrandConnect".equalsIgnoreCase(s))
        {
            showBrandConnect();
            return;
        } else
        {
            injectJavascript(generateJSToInject(s, mapToJson(map), "onGenericFunctionSuccess", "onGenericFunctionFail"));
            return;
        }
    }

    public WebBackForwardList saveState(Bundle bundle)
    {
        return super.saveState(bundle);
    }

    public void setControllerKeyPressed(String s)
    {
        mControllerKeyPressed = s;
    }

    public void setDebugMode(int i)
    {
        mDebugMode = i;
    }

    public void setDownloadDomain(String s)
    {
        mDownloadDomain = s;
    }

    public void setOnWebViewControllerChangeListener(OnWebViewControllerChangeListener onwebviewcontrollerchangelistener)
    {
        mChangeListener = onwebviewcontrollerchangelistener;
    }

    public void setOrientationState(String s)
    {
        mOrientationState = s;
    }

    public void setState(State state)
    {
        mState = state;
    }

    public void setVideoEventsListener(VideoEventsListener videoeventslistener)
    {
        mVideoEventsListener = videoeventslistener;
    }

    public void showBrandConnect()
    {
        injectJavascript(generateJSToInject("showBrandConnect", "onShowBrandConnectSuccess", "onShowBrandConnectFail"));
    }

    public void showInterstitial()
    {
        injectJavascript(generateJSToInject("showInterstitial", "onShowInterstitialSuccess", "onShowInterstitialFail"));
    }

    public void showOfferWall(String s, String s1, Map map, OnOfferWallListener onofferwalllistener)
    {
        mOWAppKey = s;
        mOWUserId = s1;
        mExtraParameters = map;
        mOnOfferWallListener = onofferwalllistener;
        initProduct(mOWAppKey, mOWUserId, mExtraParameters, com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall, "Show OW");
    }

    public void unregisterConnectionReceiver(Context context)
    {
        try
        {
            context.unregisterReceiver(mConnectionReceiver);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e(TAG, (new StringBuilder()).append("unregisterConnectionReceiver - ").append(context).toString());
        }
    }

    public void viewableChange(boolean flag, String s)
    {
        injectJavascript(generateJSToInject("viewableChange", parseToJson("webview", s, null, null, null, null, null, null, "isViewable", flag)));
    }





/*
    static View access$1202(SupersonicWebView supersonicwebview, View view)
    {
        supersonicwebview.mCustomView = view;
        return view;
    }

*/




/*
    static android.webkit.WebChromeClient.CustomViewCallback access$1402(SupersonicWebView supersonicwebview, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        supersonicwebview.mCustomViewCallback = customviewcallback;
        return customviewcallback;
    }

*/




/*
    static com.supersonicads.sdk.data.SSAEnums.ControllerState access$1602(SupersonicWebView supersonicwebview, com.supersonicads.sdk.data.SSAEnums.ControllerState controllerstate)
    {
        supersonicwebview.mControllerState = controllerstate;
        return controllerstate;
    }

*/




























/*
    static int access$402(SupersonicWebView supersonicwebview, int i)
    {
        supersonicwebview.mHiddenForceCloseWidth = i;
        return i;
    }

*/













/*
    static int access$502(SupersonicWebView supersonicwebview, int i)
    {
        supersonicwebview.mHiddenForceCloseHeight = i;
        return i;
    }

*/



/*
    static Boolean access$5102(SupersonicWebView supersonicwebview, Boolean boolean1)
    {
        supersonicwebview.mIsInterstitialAvailable = boolean1;
        return boolean1;
    }

*/








/*
    static Boolean access$5702(SupersonicWebView supersonicwebview, Boolean boolean1)
    {
        supersonicwebview.isKitkatAndAbove = boolean1;
        return boolean1;
    }

*/




/*
    static String access$602(SupersonicWebView supersonicwebview, String s)
    {
        supersonicwebview.mHiddenForceCloseLocation = s;
        return s;
    }

*/



/*
    static boolean access$702(SupersonicWebView supersonicwebview, boolean flag)
    {
        supersonicwebview.isRemoveCloseEventHandler = flag;
        return flag;
    }

*/



/*
    static CountDownTimer access$802(SupersonicWebView supersonicwebview, CountDownTimer countdowntimer)
    {
        supersonicwebview.mCloseEventTimer = countdowntimer;
        return countdowntimer;
    }

*/


/*
    static boolean access$902(SupersonicWebView supersonicwebview, boolean flag)
    {
        supersonicwebview.mGlobalControllerTimeFinish = flag;
        return flag;
    }

*/
}
