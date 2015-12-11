// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.sponsorpay.SponsorPay;
import com.sponsorpay.credentials.SPCredentials;
import com.sponsorpay.mediation.SPMediationCoordinator;
import com.sponsorpay.publisher.SponsorPayPublisher;
import com.sponsorpay.publisher.currency.SPCurrencyServerListener;
import com.sponsorpay.publisher.mbe.mediation.SPBrandEngageMediationJSInterface;
import com.sponsorpay.publisher.mbe.mediation.SPMediationValidationEvent;
import com.sponsorpay.publisher.mbe.mediation.SPMediationVideoEvent;
import com.sponsorpay.publisher.mbe.mediation.SPTPNVideoEvent;
import com.sponsorpay.publisher.mbe.mediation.SPTPNVideoValidationResult;
import com.sponsorpay.utils.HostInfo;
import com.sponsorpay.utils.SPWebClient;
import com.sponsorpay.utils.SponsorPayBaseUrlProvider;
import com.sponsorpay.utils.SponsorPayLogger;
import com.sponsorpay.utils.StringUtils;
import com.sponsorpay.utils.UrlBuilder;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.sponsorpay.publisher.mbe:
//            SPBrandEngageOffersStatus, SPBrandEngageClientStatusListener

public class SPBrandEngageClient
{

    private static final String ABOUT_BLANK = "about:blank";
    public static final SPBrandEngageClient INSTANCE = new SPBrandEngageClient();
    private static final String KEY_FOR_AD_FORMAT_CUSTOM_PARAMETER = "ad_format";
    private static final String KEY_FOR_CLIENT_CUSTOM_PARAMETER = "client";
    private static final String KEY_FOR_PLATFORM_CUSTOM_PARAMETER = "platform";
    private static final String KEY_FOR_REWARDED_CUSTOM_PARAMETER = "rewarded";
    private static final int LOAD_URL = 123;
    private static final String MBE_URL_KEY = "mbe";
    private static final int ON_PAUSE = 522;
    public static final String SP_ENGAGEMENT_STATUS = "ENGAGEMENT_STATUS";
    private static final String SP_JS_NOTIFY = "javascript:Sponsorpay.MBE.SDKInterface.notify";
    private static final String SP_NUMBER_OF_OFFERS_PARAMETER_KEY = "n";
    private static final String SP_REQUEST_OFFER_ANSWER = "requestOffers";
    private static final String SP_REQUEST_PLAY = "play";
    private static final String SP_REQUEST_START_STATUS = "start";
    public static final String SP_REQUEST_STATUS_PARAMETER_ABORTED_VALUE = "CLOSE_ABORTED";
    private static final String SP_REQUEST_STATUS_PARAMETER_ENGAGED = "USER_ENGAGED";
    public static final String SP_REQUEST_STATUS_PARAMETER_ERROR = "ERROR";
    public static final String SP_REQUEST_STATUS_PARAMETER_FINISHED_VALUE = "CLOSE_FINISHED";
    private static final String SP_REQUEST_STATUS_PARAMETER_KEY = "status";
    private static final String SP_REQUEST_STATUS_PARAMETER_STARTED_VALUE = "STARTED";
    private static final String SP_REQUEST_VALIDATE = "validate";
    private static final String SP_START_ENGAGEMENT = "javascript:Sponsorpay.MBE.SDKInterface.do_start()";
    private static final String SP_THIRD_PARTY_ID_PARAMETER = "id";
    private static final String SP_THIRD_PARTY_NETWORK_PARAMETER = "tpn";
    private static final String TAG = "SPBrandEngageClient";
    public static final int TIMEOUT = 10000;
    private static final int VALIDATION_RESULT = 2;
    private static final int VCS_TIMEOUT = 3000;
    private static final int VIDEO_EVENT = 1;
    private Activity mActivity;
    private WebChromeClient mChromeClient;
    private Context mContext;
    private String mCurrency;
    private Map mCustomParameters;
    private Handler mHandler;
    private IntentFilter mIntentFilter;
    private SPBrandEngageMediationJSInterface mJSInterface;
    private BroadcastReceiver mNetworkStateReceiver;
    private android.view.View.OnTouchListener mOnTouchListener;
    private boolean mShowRewardsNotification;
    private boolean mShowingDialog;
    private SPBrandEngageOffersStatus mStatus;
    private SPBrandEngageClientStatusListener mStatusListener;
    private SPCurrencyServerListener mVCSListener;
    private WebViewClient mWebClient;
    private WebView mWebView;
    private Handler mWebViewHandler;

    private SPBrandEngageClient()
    {
        mShowingDialog = false;
        mShowRewardsNotification = true;
        mStatus = SPBrandEngageOffersStatus.MUST_QUERY_SERVER_FOR_OFFERS;
        mIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        mNetworkStateReceiver = new BroadcastReceiver() {

            final SPBrandEngageClient this$0;

            public void onReceive(Context context, Intent intent)
            {
                boolean flag = false;
                if (!intent.getBooleanExtra("noConnectivity", false))
                {
                    flag = true;
                }
                if (!flag && mStatus == SPBrandEngageOffersStatus.SHOWING_OFFERS)
                {
                    SponsorPayLogger.e("SPBrandEngageClient", "Connection has been lost");
                    mHandler.post(new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            showErrorDialog(SponsorPayPublisher.getUIString(com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.MBE_ERROR_DIALOG_MESSAGE_OFFLINE));
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }
            }


            
            {
                this$0 = SPBrandEngageClient.this;
                super();
            }
        };
        mHandler = new Handler() {

            final SPBrandEngageClient this$0;

            public void handleMessage(Message message)
            {
                switch (message.what)
                {
                default:
                    return;

                case 2: // '\002'
                    SponsorPayLogger.d("SPBrandEngageClient", "Timeout reached, canceling request...");
                    processQueryOffersResponse(0);
                    return;

                case 1: // '\001'
                    showErrorDialog(SponsorPayPublisher.getUIString(com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.MBE_ERROR_DIALOG_MESSAGE_DEFAULT));
                    return;
                }
            }

            
            {
                this$0 = SPBrandEngageClient.this;
                super();
            }
        };
        mWebViewHandler = new Handler(Looper.getMainLooper()) {

            final SPBrandEngageClient this$0;

            public void handleMessage(Message message)
            {
                message.what;
                JVM INSTR lookupswitch 2: default 32
            //                           123: 40
            //                           522: 95;
                   goto _L1 _L2 _L3
_L1:
                SponsorPayLogger.e("SPBrandEngageClient", "Unknow message what field");
_L5:
                return;
_L2:
                if (mWebView == null) goto _L5; else goto _L4
_L4:
                message = message.obj.toString();
                mWebView.loadUrl(message);
                if (!message.equals("about:blank")) goto _L5; else goto _L6
_L6:
                mWebView = null;
                mActivity = null;
                return;
_L3:
                doPauseWebView();
                return;
            }

            
            {
                this$0 = SPBrandEngageClient.this;
                super(looper);
            }
        };
        mJSInterface = new SPBrandEngageMediationJSInterface();
    }

    private boolean canChangeParameters()
    {
        return mStatus.canChangeParameters();
    }

    private void changeStatus(String s)
    {
        if (s.equals("STARTED"))
        {
            mHandler.removeMessages(1);
            setClientStatus(SPBrandEngageOffersStatus.SHOWING_OFFERS);
            notifyListener(SPBrandEngageClientStatusListener.SPBrandEngageClientStatus.STARTED);
        } else
        {
            if (s.equals("CLOSE_FINISHED"))
            {
                clearWebViewPage();
                notifyListener(SPBrandEngageClientStatusListener.SPBrandEngageClientStatus.CLOSE_FINISHED);
                showRewardsNotification();
                checkForCoins();
                return;
            }
            if (s.equals("CLOSE_ABORTED"))
            {
                clearWebViewPage();
                notifyListener(SPBrandEngageClientStatusListener.SPBrandEngageClientStatus.CLOSE_ABORTED);
                return;
            }
            if (s.equals("ERROR"))
            {
                showErrorDialog(SponsorPayPublisher.getUIString(com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.MBE_ERROR_DIALOG_MESSAGE_DEFAULT));
                return;
            }
            if (s.equals("USER_ENGAGED"))
            {
                setClientStatus(SPBrandEngageOffersStatus.USER_ENGAGED);
                return;
            }
        }
    }

    private void checkEngagementStarted()
    {
        mHandler.sendEmptyMessageDelayed(1, 10000L);
    }

    private void checkForCoins()
    {
        if (mVCSListener != null)
        {
            mHandler.postDelayed(new Runnable() {

                final SPBrandEngageClient this$0;

                public void run()
                {
                    if (mVCSListener != null)
                    {
                        try
                        {
                            SponsorPayPublisher.requestNewCoins(SponsorPay.getCurrentCredentials().getCredentialsToken(), mContext, mVCSListener, null, null, mCurrency);
                            return;
                        }
                        catch (RuntimeException runtimeexception)
                        {
                            SponsorPayLogger.e("SPBrandEngageClient", "Error in VCS request", runtimeexception);
                        }
                        return;
                    } else
                    {
                        SponsorPayLogger.d("SPBrandEngageClient", "There's no VCS listener");
                        return;
                    }
                }

            
            {
                this$0 = SPBrandEngageClient.this;
                super();
            }
            }, 3000L);
        }
    }

    private void clearWebViewPage()
    {
        if (mWebView != null)
        {
            loadUrl("about:blank");
        }
        setClientStatus(SPBrandEngageOffersStatus.MUST_QUERY_SERVER_FOR_OFFERS);
    }

    private void doPauseWebView()
    {
        if (mWebView == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        Class.forName("android.webkit.WebView").getMethod("onPause", null).invoke(mWebView, null);
        return;
        Exception exception;
        exception;
        SponsorPayLogger.e("SPBrandEngageClient", "onPause error", exception);
        return;
    }

    private String getBaseUrl()
    {
        return SponsorPayBaseUrlProvider.getBaseUrl("mbe");
    }

    private android.view.View.OnTouchListener getOnTouchListener()
    {
        if (mOnTouchListener == null)
        {
            android.view.GestureDetector.OnDoubleTapListener ondoubletaplistener = new android.view.GestureDetector.OnDoubleTapListener() {

                final SPBrandEngageClient this$0;

                public boolean onDoubleTap(MotionEvent motionevent)
                {
                    SponsorPayLogger.d("SPBrandEngageClient", "double tap event");
                    return true;
                }

                public boolean onDoubleTapEvent(MotionEvent motionevent)
                {
                    SponsorPayLogger.d("SPBrandEngageClient", "double tap event");
                    return true;
                }

                public boolean onSingleTapConfirmed(MotionEvent motionevent)
                {
                    return false;
                }

            
            {
                this$0 = SPBrandEngageClient.this;
                super();
            }
            };
            final GestureDetector gestureDetector = new GestureDetector(new android.view.GestureDetector.OnGestureListener() {

                final SPBrandEngageClient this$0;

                public boolean onDown(MotionEvent motionevent)
                {
                    return false;
                }

                public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
                {
                    return false;
                }

                public void onLongPress(MotionEvent motionevent)
                {
                }

                public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
                {
                    return false;
                }

                public void onShowPress(MotionEvent motionevent)
                {
                }

                public boolean onSingleTapUp(MotionEvent motionevent)
                {
                    return false;
                }

            
            {
                this$0 = SPBrandEngageClient.this;
                super();
            }
            });
            gestureDetector.setOnDoubleTapListener(ondoubletaplistener);
            mOnTouchListener = new android.view.View.OnTouchListener() {

                final SPBrandEngageClient this$0;
                private final GestureDetector val$gestureDetector;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    return gestureDetector.onTouchEvent(motionevent);
                }

            
            {
                this$0 = SPBrandEngageClient.this;
                gestureDetector = gesturedetector;
                super();
            }
            };
        }
        return mOnTouchListener;
    }

    private WebChromeClient getWebChromeClient()
    {
        if (mChromeClient == null)
        {
            mChromeClient = new WebChromeClient() {

                final SPBrandEngageClient this$0;

                private void showJSDialog(String s, String s1)
                {
                    SponsorPayLogger.d("SPBrandEngageClient", (new StringBuilder("js alert - ")).append(s1).toString());
                    if (!mShowingDialog)
                    {
                        mShowingDialog = true;
                        if (mActivity == null)
                        {
                            s = mContext;
                        } else
                        {
                            s = mActivity;
                        }
                        s = new android.app.AlertDialog.Builder(s);
                        s.setTitle(SponsorPayPublisher.getUIString(com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.MBE_FORFEIT_DIALOG_TITLE)).setMessage(s1).setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

                            final _cls7 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                changeStatus("CLOSE_ABORTED");
                                mShowingDialog = false;
                            }

            
            {
                this$1 = _cls7.this;
                super();
            }
                        }).setNegativeButton("Cancel", new android.content.DialogInterface.OnClickListener() {

                            final _cls7 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                mShowingDialog = false;
                            }

            
            {
                this$1 = _cls7.this;
                super();
            }
                        }).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                            final _cls7 this$1;

                            public void onCancel(DialogInterface dialoginterface)
                            {
                                mShowingDialog = false;
                            }

            
            {
                this$1 = _cls7.this;
                super();
            }
                        });
                        s.show();
                    }
                }

                public boolean onJsConfirm(WebView webview, String s, String s1, JsResult jsresult)
                {
                    SponsorPayLogger.d("SPBrandEngageClient", (new StringBuilder("js alert - ")).append(s1).toString());
                    showJSDialog(s, s1);
                    jsresult.cancel();
                    return true;
                }


            
            {
                this$0 = SPBrandEngageClient.this;
                super();
            }
            };
        }
        return mChromeClient;
    }

    private WebViewClient getWebClient()
    {
        if (mWebClient == null)
        {
            mWebClient = new SPWebClient(mActivity) {

                final SPBrandEngageClient this$0;

                protected Activity getHostActivity()
                {
                    return mActivity;
                }

                protected void onPlayStoreNotFound()
                {
                    showErrorDialog(SponsorPayPublisher.getUIString(com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.ERROR_PLAY_STORE_UNAVAILABLE));
                }

                public void onReceivedError(WebView webview, int i, String s, String s1)
                {
                    SponsorPayLogger.d("SPBrandEngageClient", (new StringBuilder("onReceivedError url - ")).append(s1).append(" - ").append(s).toString());
                    if (mStatus == SPBrandEngageOffersStatus.QUERYING_SERVER_FOR_OFFERS)
                    {
                        notifyListener(SPBrandEngageClientStatusListener.SPBrandEngageClientStatus.ERROR);
                        clearWebViewPage();
                    } else
                    {
                        showErrorDialog(SponsorPayPublisher.getUIString(com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.MBE_ERROR_DIALOG_MESSAGE_DEFAULT));
                    }
                    super.onReceivedError(webview, i, s, s1);
                }

                protected void onSponsorPayExitScheme(int i, String s)
                {
                    Activity activity = getHostActivity();
                    if (activity == null)
                    {
                        return;
                    } else
                    {
                        activity.setResult(i);
                        launchActivityWithUrl(s);
                        return;
                    }
                }

                protected void onTargetActivityStart(String s)
                {
                    changeStatus("USER_ENGAGED");
                    notifyListener(SPBrandEngageClientStatusListener.SPBrandEngageClientStatus.PENDING_CLOSE);
                }

                protected void processSponsorPayScheme(String s, Uri uri)
                {
                    if (s.equals("requestOffers"))
                    {
                        processQueryOffersResponse(Integer.parseInt(uri.getQueryParameter("n")));
                    } else
                    {
                        if (s.equals("start"))
                        {
                            changeStatus(uri.getQueryParameter("status"));
                            return;
                        }
                        if (s.equals("validate"))
                        {
                            s = uri.getQueryParameter("tpn");
                            SponsorPayLogger.d("SPBrandEngageClient", (new StringBuilder("MBE client asks to validate a third party network: ")).append(s).toString());
                            HashMap hashmap = new HashMap(1);
                            hashmap.put("id", uri.getQueryParameter("id"));
                            SPMediationCoordinator.INSTANCE.validateVideoNetwork(mContext, s, hashmap, new SPMediationValidationEvent() {

                                final _cls6 this$1;

                                public void validationEventResult(String s, SPTPNVideoValidationResult sptpnvideovalidationresult, Map map)
                                {
                                    s = String.format("%s('validate', {tpn:'%s', id:%s, result:'%s'})", new Object[] {
                                        "javascript:Sponsorpay.MBE.SDKInterface.notify", s, map.get("id"), sptpnvideovalidationresult
                                    });
                                    SponsorPayLogger.d("SPBrandEngageClient", (new StringBuilder("Notifying - ")).append(s).toString());
                                    loadUrl(s);
                                }

            
            {
                this$1 = _cls6.this;
                super();
            }
                            });
                            return;
                        }
                        if (s.equals("play"))
                        {
                            s = uri.getQueryParameter("tpn");
                            HashMap hashmap1 = new HashMap(1);
                            hashmap1.put("id", uri.getQueryParameter("id"));
                            SponsorPayLogger.d("SPBrandEngageClient", (new StringBuilder("MBE client asks to play an offer from a third party network:")).append(s).toString());
                            SPMediationCoordinator.INSTANCE.startVideoEngagement(mActivity, s, hashmap1, new SPMediationVideoEvent() {

                                final _cls6 this$1;

                                public void videoEventOccured(String s, SPTPNVideoEvent sptpnvideoevent, Map map)
                                {
                                    if (sptpnvideoevent == SPTPNVideoEvent.SPTPNVideoEventStarted)
                                    {
                                        changeStatus("STARTED");
                                    }
                                    s = String.format("%s('play', {tpn:'%s', id:%s, result:'%s'})", new Object[] {
                                        "javascript:Sponsorpay.MBE.SDKInterface.notify", s, map.get("id"), sptpnvideoevent
                                    });
                                    SponsorPayLogger.d("SPBrandEngageClient", (new StringBuilder("Notifying - ")).append(s).toString());
                                    loadUrl(s);
                                }

            
            {
                this$1 = _cls6.this;
                super();
            }
                            });
                            return;
                        }
                    }
                }

                public boolean shouldOverrideUrlLoading(WebView webview, String s)
                {
                    if (s.contains("youtube.com"))
                    {
                        SponsorPayLogger.d("SPBrandEngageClient", "Preventing Youtube app");
                        return true;
                    } else
                    {
                        return super.shouldOverrideUrlLoading(webview, s);
                    }
                }


            
            {
                this$0 = SPBrandEngageClient.this;
                super(activity);
            }
            };
        }
        return mWebClient;
    }

    private void loadUrl(String s)
    {
        if (StringUtils.notNullNorEmpty(s))
        {
            Message message = Message.obtain(mWebViewHandler);
            message.what = 123;
            message.obj = s;
            message.sendToTarget();
        }
    }

    private void notifyListener(SPBrandEngageClientStatusListener.SPBrandEngageClientStatus spbrandengageclientstatus)
    {
        if (mStatusListener != null)
        {
            SponsorPayLogger.i("SPBrandEngageClient", (new StringBuilder("SPBrandEngageClientStatus -> ")).append(spbrandengageclientstatus).toString());
            mStatusListener.didChangeStatus(spbrandengageclientstatus);
        }
    }

    private void processQueryOffersResponse(int i)
    {
        mHandler.removeMessages(2);
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            setClientStatus(SPBrandEngageOffersStatus.READY_TO_SHOW_OFFERS);
        } else
        {
            clearWebViewPage();
        }
        if (mStatusListener != null)
        {
            mStatusListener.didReceiveOffers(flag);
        }
    }

    private void setClientStatus(SPBrandEngageOffersStatus spbrandengageoffersstatus)
    {
        if (mStatus != spbrandengageoffersstatus)
        {
            mStatus = spbrandengageoffersstatus;
            SponsorPayLogger.d("SPBrandEngageClient", (new StringBuilder("SPBrandEngageClient mStatus -> ")).append(spbrandengageoffersstatus.name()).toString());
        }
    }

    private void setupWebView(Activity activity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            activity = activity.getApplicationContext();
        }
        mContext = activity;
        mWebView = new WebView(mContext);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setPluginsEnabled(true);
        mWebView.getSettings().setUseWideViewPort(false);
        mWebView.setBackgroundColor(0);
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            mWebView.getSettings().setUserAgentString("Mozilla/5.0 (X11; CrOS i686 4319.74.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.57 Safari/537.36 (Sponsorpay SDK)");
        }
        mWebView.setScrollBarStyle(0);
        mWebView.setWebChromeClient(getWebChromeClient());
        mWebView.setWebViewClient(getWebClient());
        mWebView.setOnTouchListener(getOnTouchListener());
        mWebView.addJavascriptInterface(mJSInterface, mJSInterface.getInterfaceName());
    }

    private void showErrorDialog(String s)
    {
        if (mShowingDialog || mWebView == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        mShowingDialog = true;
        Object obj;
        if (mActivity == null)
        {
            obj = mContext;
        } else
        {
            obj = mActivity;
        }
        obj = new android.app.AlertDialog.Builder(((Context) (obj)));
        ((android.app.AlertDialog.Builder) (obj)).setTitle(SponsorPayPublisher.getUIString(com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.MBE_ERROR_DIALOG_TITLE)).setMessage(s).setNeutralButton(SponsorPayPublisher.getUIString(com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.MBE_ERROR_DIALOG_BUTTON_TITLE_DISMISS), new android.content.DialogInterface.OnClickListener() {

            final SPBrandEngageClient this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                notifyListener(SPBrandEngageClientStatusListener.SPBrandEngageClientStatus.ERROR);
                clearWebViewPage();
                mShowingDialog = false;
            }

            
            {
                this$0 = SPBrandEngageClient.this;
                super();
            }
        });
        ((android.app.AlertDialog.Builder) (obj)).show();
        return;
        s;
        mShowingDialog = false;
        SponsorPayLogger.e("SPBrandEngageClient", "Unable to show the dialog window");
        return;
    }

    private void showRewardsNotification()
    {
        if (mShowRewardsNotification)
        {
            Toast.makeText(mContext, SponsorPayPublisher.getUIString(com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.MBE_REWARD_NOTIFICATION), 1).show();
        }
    }

    private void startQueryingOffers(SPCredentials spcredentials)
    {
        spcredentials = UrlBuilder.newBuilder(getBaseUrl(), spcredentials).setCurrency(mCurrency).addExtraKeysValues(mCustomParameters).addKeyValue("client", "sdk").addKeyValue("platform", "android").addKeyValue("rewarded", "1").addKeyValue("ad_format", "video").addScreenMetrics().buildUrl();
        SponsorPayLogger.d("SPBrandEngageClient", (new StringBuilder("Loading URL: ")).append(spcredentials).toString());
        loadUrl(spcredentials);
        setClientStatus(SPBrandEngageOffersStatus.QUERYING_SERVER_FOR_OFFERS);
        mHandler.sendEmptyMessageDelayed(2, 10000L);
    }

    public boolean canRequestOffers()
    {
        return mStatus.canRequestOffers();
    }

    public boolean canStartEngagement()
    {
        return mStatus.canShowOffers();
    }

    public void closeEngagement()
    {
        if (mContext != null)
        {
            try
            {
                mContext.unregisterReceiver(mNetworkStateReceiver);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                SponsorPayLogger.e("SPBrandEngageClient", illegalargumentexception.getMessage(), illegalargumentexception);
            }
        }
        if (mStatus == SPBrandEngageOffersStatus.USER_ENGAGED)
        {
            changeStatus("CLOSE_FINISHED");
            return;
        } else
        {
            changeStatus("CLOSE_ABORTED");
            return;
        }
    }

    public void onPause()
    {
        Message message = Message.obtain(mWebViewHandler);
        message.what = 522;
        message.sendToTarget();
    }

    public boolean playThroughMediation()
    {
        return mJSInterface.playThroughTirdParty(mWebView);
    }

    public boolean requestOffers(SPCredentials spcredentials, Activity activity)
    {
        if (canRequestOffers())
        {
            if (!HostInfo.isDeviceSupported())
            {
                processQueryOffersResponse(0);
            } else
            {
                if (mWebView == null)
                {
                    setupWebView(activity);
                }
                startQueryingOffers(spcredentials);
            }
            return true;
        } else
        {
            SponsorPayLogger.d("SPBrandEngageClient", "SPBrandEngageClient cannot request offers at this point. It might be requesting offers right now or an offer might be currently being presented to the user.");
            return false;
        }
    }

    public boolean setCurrencyListener(SPCurrencyServerListener spcurrencyserverlistener)
    {
        if (canChangeParameters())
        {
            mVCSListener = spcurrencyserverlistener;
            setClientStatus(SPBrandEngageOffersStatus.MUST_QUERY_SERVER_FOR_OFFERS);
            return true;
        } else
        {
            SponsorPayLogger.d("SPBrandEngageClient", "Cannot change the currency listener while a request to the server is going on or an offer is being presented to the user.");
            return false;
        }
    }

    public boolean setCurrencyName(String s)
    {
        if (canChangeParameters())
        {
            mCurrency = s;
            setClientStatus(SPBrandEngageOffersStatus.MUST_QUERY_SERVER_FOR_OFFERS);
            return true;
        } else
        {
            SponsorPayLogger.d("SPBrandEngageClient", "Cannot change the currency while a request to the server is going on or an offer is being presented to the user.");
            return false;
        }
    }

    public boolean setCustomParameters(Map map)
    {
        if (canChangeParameters())
        {
            mCustomParameters = map;
            setClientStatus(SPBrandEngageOffersStatus.MUST_QUERY_SERVER_FOR_OFFERS);
            return true;
        } else
        {
            SponsorPayLogger.d("SPBrandEngageClient", "Cannot change custom parameters while a request to the server is going on or an offer is being presented to the user.");
            return false;
        }
    }

    public void setShowRewardsNotification(boolean flag)
    {
        mShowRewardsNotification = flag;
    }

    public boolean setStatusListener(SPBrandEngageClientStatusListener spbrandengageclientstatuslistener)
    {
        boolean flag = canChangeParameters();
        if (flag)
        {
            mStatusListener = spbrandengageclientstatuslistener;
            return flag;
        } else
        {
            SponsorPayLogger.d("SPBrandEngageClient", "Cannot change the status listener while a request to the server is going on or an offer is being presented to the user.");
            return flag;
        }
    }

    public boolean shouldShowRewardsNotification()
    {
        return mShowRewardsNotification;
    }

    public boolean startEngagement(Activity activity)
    {
        return startEngagement(activity, playThroughMediation());
    }

    public boolean startEngagement(Activity activity, boolean flag)
    {
        if (activity != null)
        {
            if (canStartEngagement())
            {
                loadUrl("javascript:Sponsorpay.MBE.SDKInterface.do_start()");
                mActivity = activity;
                if (!flag)
                {
                    mActivity.addContentView(mWebView, new android.widget.FrameLayout.LayoutParams(-1, -1));
                    mContext.registerReceiver(mNetworkStateReceiver, mIntentFilter);
                }
                checkEngagementStarted();
                return true;
            }
            SponsorPayLogger.d("SPBrandEngageClient", "SPBrandEngageClient is not ready to show offers. Call requestOffers() and wait until your listener is called with the confirmation that offers have been received.");
        } else
        {
            SponsorPayLogger.d("SPBrandEngageClient", "The provided activity is null, SPBrandEngageClient cannot start the engagement.");
        }
        return false;
    }



















}
