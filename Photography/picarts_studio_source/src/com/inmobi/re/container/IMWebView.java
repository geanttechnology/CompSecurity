// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.VideoView;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.configs.ConfigParams;
import com.inmobi.re.configs.Initializer;
import com.inmobi.re.container.mraidimpl.MRAIDAudioVideoController;
import com.inmobi.re.container.mraidimpl.MRAIDBasic;
import com.inmobi.re.container.mraidimpl.MRAIDExpandController;
import com.inmobi.re.container.mraidimpl.MRAIDInterstitialController;
import com.inmobi.re.container.mraidimpl.MRAIDResizeController;
import com.inmobi.re.controller.JSUtilityController;
import com.inmobi.re.controller.util.AVPlayer;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.re.container:
//            CustomView

public class IMWebView extends WebView
    implements Serializable
{

    public static final String DIMENSIONS = "expand_dimensions";
    public static final String EXPAND_URL = "expand_url";
    private static Class G = null;
    protected static final int IMWEBVIEW_INTERSTITIAL_ID = 117;
    public static final String PLAYER_PROPERTIES = "player_properties";
    private static int d[] = {
        0x101011f, 0x1010120
    };
    private static final long serialVersionUID = 0x6282f5dae34d0336L;
    public static boolean userInitiatedClose = false;
    private c A;
    private ArrayList B;
    private AtomicBoolean C;
    private ViewParent D;
    private int E;
    private boolean F;
    private WebViewClient H;
    private WebChromeClient I;
    private android.media.MediaPlayer.OnCompletionListener J;
    private boolean K;
    double a;
    public AtomicBoolean acqMutexcPos;
    public AtomicBoolean acqMutexdPos;
    AtomicBoolean b;
    InstantVideoCallbackCallback c;
    public JSONObject curPosition;
    public JSONObject defPosition;
    public AtomicBoolean doNotFireVisibilityChanged;
    private boolean e;
    private boolean f;
    private JSUtilityController g;
    private float h;
    private int i;
    public AtomicBoolean isMutexAquired;
    public boolean isTablet;
    private int j;
    private ViewState k;
    private IMWebViewPlayableListener l;
    private VideoView m;
    public MRAIDAudioVideoController mAudioVideoController;
    public MRAIDExpandController mExpandController;
    public MRAIDInterstitialController mInterstitialController;
    public boolean mIsInterstitialAd;
    public boolean mIsViewable;
    public IMWebViewListener mListener;
    public MRAIDBasic mMraidBasic;
    public IMWebView mOriginalWebviewForExpandUrl;
    public MRAIDResizeController mResizeController;
    public boolean mWebViewIsBrowserActivity;
    protected boolean mraidLoaded;
    public Object mutex;
    public Object mutexcPos;
    public Object mutexdPos;
    private View n;
    private android.webkit.WebChromeClient.CustomViewCallback o;
    private ViewGroup p;
    public int publisherOrientation;
    private FrameLayout q;
    private ArrayList r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private Message w;
    public String webviewUserAgent;
    private Message x;
    private Activity y;
    private WebViewClient z;

    public IMWebView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        doNotFireVisibilityChanged = new AtomicBoolean(false);
        f = false;
        k = ViewState.LOADING;
        o = null;
        s = false;
        mIsInterstitialAd = false;
        isTablet = false;
        mOriginalWebviewForExpandUrl = null;
        mWebViewIsBrowserActivity = false;
        t = false;
        u = false;
        mutex = new Object();
        mutexcPos = new Object();
        mutexdPos = new Object();
        isMutexAquired = new AtomicBoolean(false);
        acqMutexcPos = new AtomicBoolean(true);
        acqMutexdPos = new AtomicBoolean(true);
        B = new ArrayList();
        C = new AtomicBoolean();
        F = false;
        H = new _cls1();
        I = new _cls10();
        mIsViewable = false;
        J = new _cls13();
        a = -1D;
        b = new AtomicBoolean(false);
        K = true;
        c = null;
        y = (Activity)context;
        c();
        getContext().obtainStyledAttributes(attributeset, d).recycle();
    }

    public IMWebView(Context context, IMWebViewListener imwebviewlistener)
    {
        super(context);
        doNotFireVisibilityChanged = new AtomicBoolean(false);
        f = false;
        k = ViewState.LOADING;
        o = null;
        s = false;
        mIsInterstitialAd = false;
        isTablet = false;
        mOriginalWebviewForExpandUrl = null;
        mWebViewIsBrowserActivity = false;
        t = false;
        u = false;
        mutex = new Object();
        mutexcPos = new Object();
        mutexdPos = new Object();
        isMutexAquired = new AtomicBoolean(false);
        acqMutexcPos = new AtomicBoolean(true);
        acqMutexdPos = new AtomicBoolean(true);
        B = new ArrayList();
        C = new AtomicBoolean();
        F = false;
        H = new _cls1();
        I = new _cls10();
        mIsViewable = false;
        J = new _cls13();
        a = -1D;
        b = new AtomicBoolean(false);
        K = true;
        c = null;
        mListener = imwebviewlistener;
        y = (Activity)context;
        c();
    }

    public IMWebView(Context context, IMWebViewListener imwebviewlistener, boolean flag, boolean flag1)
    {
        super(context);
        doNotFireVisibilityChanged = new AtomicBoolean(false);
        f = false;
        k = ViewState.LOADING;
        o = null;
        s = false;
        mIsInterstitialAd = false;
        isTablet = false;
        mOriginalWebviewForExpandUrl = null;
        mWebViewIsBrowserActivity = false;
        t = false;
        u = false;
        mutex = new Object();
        mutexcPos = new Object();
        mutexdPos = new Object();
        isMutexAquired = new AtomicBoolean(false);
        acqMutexcPos = new AtomicBoolean(true);
        acqMutexdPos = new AtomicBoolean(true);
        B = new ArrayList();
        C = new AtomicBoolean();
        F = false;
        H = new _cls1();
        I = new _cls10();
        mIsViewable = false;
        J = new _cls13();
        a = -1D;
        b = new AtomicBoolean(false);
        K = true;
        c = null;
        y = (Activity)context;
        mIsInterstitialAd = flag;
        mWebViewIsBrowserActivity = flag1;
        if (mIsInterstitialAd)
        {
            setId(117);
        }
        mListener = imwebviewlistener;
        c();
    }

    private int a(Activity activity)
    {
        Iterator iterator = activity.getPackageManager().queryIntentActivities(new Intent(activity, activity.getClass()), 0x10000).iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        ResolveInfo resolveinfo = (ResolveInfo)iterator.next();
        if (!resolveinfo.activityInfo.name.contentEquals(activity.getClass().getName())) goto _L4; else goto _L3
_L3:
        activity = resolveinfo;
_L6:
        return ((ResolveInfo) (activity)).activityInfo.configChanges;
_L2:
        activity = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static Message a(IMWebView imwebview, Message message)
    {
        imwebview.w = message;
        return message;
    }

    static View a(IMWebView imwebview, View view)
    {
        imwebview.n = view;
        return view;
    }

    static android.webkit.WebChromeClient.CustomViewCallback a(IMWebView imwebview, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        imwebview.o = customviewcallback;
        return customviewcallback;
    }

    static WebViewClient a(IMWebView imwebview)
    {
        return imwebview.z;
    }

    static FrameLayout a(IMWebView imwebview, FrameLayout framelayout)
    {
        imwebview.q = framelayout;
        return framelayout;
    }

    static VideoView a(IMWebView imwebview, VideoView videoview)
    {
        imwebview.m = videoview;
        return videoview;
    }

    static ArrayList a(IMWebView imwebview, ArrayList arraylist)
    {
        imwebview.r = arraylist;
        return arraylist;
    }

    private void a(int i1, int j1)
    {
        injectJavaScript((new StringBuilder("window.mraid.broadcastEvent('sizeChange',")).append(i1).append(",").append(j1).append(");").toString());
    }

    private void a(View view, android.view.View.OnKeyListener onkeylistener)
    {
        view.setOnKeyListener(onkeylistener);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            int i1 = 0;
            for (int j1 = view.getChildCount(); i1 < j1; i1++)
            {
                a(view.getChildAt(i1), onkeylistener);
            }

        }
    }

    private void a(View view, android.view.View.OnTouchListener ontouchlistener)
    {
        view.setOnTouchListener(ontouchlistener);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            int i1 = 0;
            for (int j1 = view.getChildCount(); i1 < j1; i1++)
            {
                a(view.getChildAt(i1), ontouchlistener);
            }

        }
    }

    private void a(SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(y);
        builder.setPositiveButton("Continue", new _cls7(sslerrorhandler));
        builder.setNegativeButton("Go Back", new _cls8(sslerrorhandler));
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            builder.setNeutralButton("Open Browser", new _cls9(sslerror));
        }
        builder.setTitle("Security Warning");
        builder.setMessage("There are problems with the security certificate for this site.");
        sslerrorhandler = builder.create();
        try
        {
            sslerrorhandler.show();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SslErrorHandler sslerrorhandler)
        {
            Log.internal("[InMobi]-[RE]-4.5.2", "Dialog could not be shown due to an exception.", sslerrorhandler);
        }
    }

    static void a(IMWebView imwebview, View view, android.view.View.OnKeyListener onkeylistener)
    {
        imwebview.a(view, onkeylistener);
    }

    static void a(IMWebView imwebview, View view, android.view.View.OnTouchListener ontouchlistener)
    {
        imwebview.a(view, ontouchlistener);
    }

    static void a(IMWebView imwebview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        imwebview.a(sslerrorhandler, sslerror);
    }

    static void a(IMWebView imwebview, String s1)
    {
        imwebview.c(s1);
    }

    private void a(String s1)
    {
        super.loadUrl(s1);
    }

    private void a(boolean flag)
    {
        Log.debug("[InMobi]-[RE]-4.5.2", (new StringBuilder("Viewable:")).append(flag).toString());
        injectJavaScript((new StringBuilder("window.mraid.broadcastEvent('viewableChange',")).append(isViewable()).append(");").toString());
    }

    static boolean a(IMWebView imwebview, boolean flag)
    {
        imwebview.F = flag;
        return flag;
    }

    static ViewState b(IMWebView imwebview)
    {
        return imwebview.k;
    }

    private void b(String s1)
    {
        evaluateJavascript(s1, null);
    }

    static boolean b(IMWebView imwebview, boolean flag)
    {
        imwebview.f = flag;
        return flag;
    }

    static AtomicBoolean c(IMWebView imwebview)
    {
        return imwebview.C;
    }

    private void c()
    {
        b();
        userInitiatedClose = false;
        setScrollContainer(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        webviewUserAgent = getSettings().getUserAgentString();
        InternalSDKUtil.getUserAgent();
        setBackgroundColor(Initializer.getConfigParams().getWebviewBgColor());
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        h = y.getResources().getDisplayMetrics().density;
        e = false;
        getSettings().setJavaScriptEnabled(true);
        getSettings().setGeolocationEnabled(true);
        g = new JSUtilityController(this, getContext());
        addJavascriptInterface(g, "utilityController");
        setWebViewClient(H);
        setWebChromeClient(I);
        mExpandController = new MRAIDExpandController(this, y);
        mResizeController = new MRAIDResizeController(this, y);
        mMraidBasic = new MRAIDBasic(this, y);
        mInterstitialController = new MRAIDInterstitialController(this, y);
        mAudioVideoController = new MRAIDAudioVideoController(this);
        A = new c(mMraidBasic, mExpandController, mInterstitialController, mAudioVideoController, mResizeController);
        mExpandController.mSensorDisplay = ((WindowManager)y.getSystemService("window")).getDefaultDisplay();
        mAudioVideoController.videoValidateWidth = y.getResources().getDisplayMetrics().widthPixels;
        try
        {
            addJavascriptInterface(G.getDeclaredConstructor(new Class[] {
                com/inmobi/re/container/IMWebView
            }).newInstance(new Object[] {
                this
            }), "imaiController");
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.5.2", "Error adding js interface imai controller");
        }
        g.setWebViewClosed(false);
    }

    private void c(String s1)
    {
        s1 = new Intent("android.intent.action.VIEW", Uri.parse(s1));
        s1.addFlags(0x10000000);
        y.startActivity(s1);
        fireOnLeaveApplication();
    }

    private void d()
    {
        Log.debug("[InMobi]-[RE]-4.5.2", "IMWebView-> initStates");
        k = ViewState.LOADING;
        C.set(false);
    }

    static boolean d(IMWebView imwebview)
    {
        return imwebview.f;
    }

    static ArrayList e(IMWebView imwebview)
    {
        return imwebview.B;
    }

    private void e()
    {
        if (k == ViewState.EXPANDED)
        {
            mExpandController.closeExpanded();
        }
        invalidate();
        g.stopAllListeners();
        resetLayout();
    }

    static Message f(IMWebView imwebview)
    {
        return imwebview.w;
    }

    private void f()
    {
        if (n == null)
        {
            return;
        }
        if (o != null)
        {
            o.onCustomViewHidden();
        }
        o = null;
        if (n != null && n.getParent() != null)
        {
            ((ViewGroup)n.getParent()).removeView(n);
        }
        n = null;
    }

    static Message g(IMWebView imwebview)
    {
        return imwebview.x;
    }

    private boolean g()
    {
        return b.get();
    }

    static View h(IMWebView imwebview)
    {
        return imwebview.n;
    }

    static Activity i(IMWebView imwebview)
    {
        return imwebview.y;
    }

    static FrameLayout j(IMWebView imwebview)
    {
        return imwebview.q;
    }

    static VideoView k(IMWebView imwebview)
    {
        return imwebview.m;
    }

    static android.media.MediaPlayer.OnCompletionListener l(IMWebView imwebview)
    {
        return imwebview.J;
    }

    static void m(IMWebView imwebview)
    {
        imwebview.f();
    }

    static JSUtilityController n(IMWebView imwebview)
    {
        return imwebview.g;
    }

    static ViewGroup o(IMWebView imwebview)
    {
        return imwebview.p;
    }

    static void p(IMWebView imwebview)
    {
        imwebview.WebView.destroy();
    }

    static ArrayList q(IMWebView imwebview)
    {
        return imwebview.r;
    }

    public static void setIMAIController(Class class1)
    {
        G = class1;
    }

    void a()
    {
        if (r == null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L7:
        if (i1 >= r.size()) goto _L4; else goto _L3
_L3:
        a a1 = (a)r.get(i1);
        if (a1.getStatus() == android.os.AsyncTask.Status.RUNNING)
        {
            a1.cancel(true);
        }
          goto _L5
_L4:
        r.clear();
        r = null;
_L2:
        b();
        return;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[RE]-4.5.2", "Exception deleting saved content dirs and stopping download task");
        return;
_L5:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void addJavascriptObject(Object obj, String s1)
    {
        addJavascriptInterface(obj, s1);
    }

    void b()
    {
        Object obj;
        String as[];
        obj = InternalSDKUtil.getContext();
        obj = new File((new StringBuilder()).append(((Context) (obj)).getExternalFilesDir(null)).append("/im_cached_content/").toString());
        if (!((File) (obj)).exists() || !((File) (obj)).isDirectory())
        {
            break MISSING_BLOCK_LABEL_90;
        }
        as = ((File) (obj)).list();
        int i1 = 0;
        do
        {
            try
            {
                if (i1 >= as.length)
                {
                    break;
                }
                (new File(((File) (obj)), as[i1])).delete();
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[RE]-4.5.2", "Exception deleting saved content dirs and stopping download task");
                return;
            }
            i1++;
        } while (true);
        ((File) (obj)).delete();
    }

    public void broadcastEventIMraid(String s1, Object obj)
    {
        try
        {
            y.runOnUiThread(new _cls11(obj, s1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.internal("[InMobi]-[RE]-4.5.2", "Exception broadcasting events", s1);
        }
    }

    public void broadcastEventIMraid(String s1, String s2)
    {
        try
        {
            y.runOnUiThread(new _cls12(s2, s1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.internal("[InMobi]-[RE]-4.5.2", "Exception broadcasting events", s1);
        }
    }

    public void cancelLoad()
    {
        C.set(true);
    }

    public void cancelSaveContent(String s1)
    {
        if (r == null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L7:
        if (i1 >= r.size()) goto _L2; else goto _L3
_L3:
        a a1 = (a)r.get(i1);
        if (!a1.a().equals(s1) || a1.getStatus() != android.os.AsyncTask.Status.RUNNING) goto _L5; else goto _L4
_L4:
        a1.cancel(true);
_L2:
        return;
_L5:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void clearView()
    {
        e();
        super.clearView();
    }

    public void close()
    {
        try
        {
            a();
            g.setWebViewClosed(true);
            if (!A.hasMessages(1001))
            {
                A.sendEmptyMessage(1001);
            }
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.5.2", "Exception closing webview. Webview not initialized properly", exception);
        }
    }

    public void closeExpanded()
    {
        A.sendEmptyMessage(1005);
    }

    protected void closeOpened(View view)
    {
        ((ViewGroup)((Activity)getContext()).getWindow().getDecorView()).removeView(view);
        requestLayout();
    }

    public void closeResized()
    {
        A.sendEmptyMessage(1031);
    }

    public void closeVideo(String s1)
    {
        AVPlayer avplayer = mAudioVideoController.getVideoPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "closeVideo");
            return;
        }
        if (avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED)
        {
            raiseError("Invalid player state", "closeVideo");
            return;
        } else
        {
            mAudioVideoController.videoPlayerList.remove(s1);
            s1 = A.obtainMessage(1012);
            s1.obj = avplayer;
            A.sendMessage(s1);
            return;
        }
    }

    public void deinit()
    {
        if (getStateVariable() == ViewState.EXPANDED || getStateVariable() == ViewState.EXPANDING)
        {
            close();
        }
    }

    public void destroy()
    {
        Log.debug("[InMobi]-[RE]-4.5.2", "IMWebView: Destroy called.");
        close();
        postInHandler(new _cls5());
    }

    public void disableCloseRegion()
    {
        CustomView customview = (CustomView)((ViewGroup)getRootView()).findViewById(226);
        if (customview != null)
        {
            customview.disableView(u);
        }
    }

    public void disableHardwareAcceleration()
    {
        K = false;
        Log.internal("[InMobi]-[RE]-4.5.2", "disableHardwareAcceleration called.");
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            WrapperFunctions.disableHardwareAccl(this);
            mExpandController.disableEnableHardwareAccelerationForExpandWithURLView();
        }
    }

    public void doHidePlayers()
    {
        A.sendEmptyMessage(1023);
    }

    public void expand(String s1, com.inmobi.re.controller.JSController.ExpandProperties expandproperties)
    {
        setState(ViewState.EXPANDING);
        mExpandController.mIsExpandUrlValid = false;
        isMutexAquired.set(true);
        Message message = A.obtainMessage(1004);
        Bundle bundle = new Bundle();
        bundle.putString("expand_url", s1);
        message.setData(bundle);
        mExpandController.expandProperties = expandproperties;
        Log.debug("[InMobi]-[RE]-4.5.2", (new StringBuilder("Dimensions: {")).append(mExpandController.expandProperties.x).append(" ,").append(mExpandController.expandProperties.y).append(" ,").append(mExpandController.expandProperties.width).append(" ,").append(mExpandController.expandProperties.height).append("}").toString());
        mExpandController.tempExpPropsLock = mExpandController.expandProperties.lockOrientation;
        A.sendMessage(message);
    }

    public void fireOnDismissAdScreen()
    {
        if (mListener != null)
        {
            mListener.onDismissAdScreen();
        }
    }

    public void fireOnLeaveApplication()
    {
        if (mListener != null)
        {
            mListener.onLeaveApplication();
        }
    }

    public void fireOnShowAdScreen()
    {
        if (mListener != null && getStateVariable() == ViewState.DEFAULT && !mIsInterstitialAd)
        {
            IMBrowserActivity.requestOnAdDismiss(A.obtainMessage(1028));
            mListener.onShowAdScreen();
        }
    }

    public Activity getActivity()
    {
        return y;
    }

    public int getAudioVolume(String s1)
    {
        s1 = mAudioVideoController.getCurrentAudioPlayer(s1);
        if (s1 == null)
        {
            raiseError("Invalid property ID", "getAudioVolume");
            return -1;
        } else
        {
            return s1.getVolume();
        }
    }

    public String getCurrentRotation(int i1)
    {
        switch (i1)
        {
        default:
            return "-1";

        case 0: // '\0'
            return "0";

        case 1: // '\001'
            return "90";

        case 2: // '\002'
            return "180";

        case 3: // '\003'
            return "270";
        }
    }

    public boolean getCustomClose()
    {
        return t;
    }

    public float getDensity()
    {
        return h;
    }

    public boolean getDisableCloseRegion()
    {
        return u;
    }

    public int getDismissMessage()
    {
        return 1028;
    }

    public Activity getExpandedActivity()
    {
        return y;
    }

    public int getIntegerCurrentRotation()
    {
        int i1 = DeviceInfo.getDisplayRotation(((WindowManager)y.getSystemService("window")).getDefaultDisplay());
        int j1 = i1;
        if (DeviceInfo.isDefOrientationLandscape(i1, y.getResources().getDisplayMetrics().widthPixels, y.getResources().getDisplayMetrics().heightPixels))
        {
            j1 = i1 + 1;
            i1 = j1;
            if (j1 > 3)
            {
                i1 = 0;
            }
            j1 = i1;
            if (DeviceInfo.isTablet(y.getApplicationContext()))
            {
                isTablet = true;
                j1 = i1;
            }
        }
        return j1;
    }

    public double getLastGoodKnownMicValue()
    {
        return a;
    }

    public ArrayList getMRAIDUrls()
    {
        return B;
    }

    public int getOriginalIndex()
    {
        return E;
    }

    public ViewParent getOriginalParent()
    {
        if (D == null)
        {
            saveOriginalViewParent();
        }
        return D;
    }

    public String getPlacementType()
    {
        if (mIsInterstitialAd)
        {
            return "interstitial";
        } else
        {
            return "inline";
        }
    }

    public IMWebViewPlayableListener getPlayableListener()
    {
        return l;
    }

    public String getSize()
    {
        return (new StringBuilder("{ width: ")).append((int)((float)getWidth() / h)).append(", height: ").append((int)((float)getHeight() / h)).append("}").toString();
    }

    public String getState()
    {
        return k.toString().toLowerCase(Locale.ENGLISH);
    }

    public ViewState getStateVariable()
    {
        return k;
    }

    public int getVideoVolume(String s1)
    {
        s1 = mAudioVideoController.getVideoPlayer(s1);
        if (s1 == null)
        {
            raiseError("Invalid property ID", "getVideoVolume");
            return -1;
        } else
        {
            return s1.getVolume();
        }
    }

    public ViewState getViewState()
    {
        return k;
    }

    public Handler getWebviewHandler()
    {
        return A;
    }

    public void hide()
    {
        A.sendEmptyMessage(1002);
    }

    public void hideVideo(String s1)
    {
        Message message = A.obtainMessage(1013);
        Bundle bundle = new Bundle();
        bundle.putString("pid", s1);
        message.setData(bundle);
        A.sendMessage(message);
    }

    public void incentCompleted(HashMap hashmap)
    {
        Message message = A.obtainMessage(1034);
        Bundle bundle = new Bundle();
        bundle.putSerializable("incent_ad_map", hashmap);
        message.setData(bundle);
        message.sendToTarget();
    }

    public void injectJavaScript(String s1)
    {
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        s1 = (new StringBuilder("javascript:try{")).append(s1).append("}catch(e){}").toString();
        if (s1.length() < 400)
        {
            Log.debug("[InMobi]-[RE]-4.5.2", (new StringBuilder("Injecting JavaScript: ")).append(s1).toString());
        }
        if (g())
        {
            break MISSING_BLOCK_LABEL_99;
        }
        if (android.os.Build.VERSION.SDK_INT < 19)
        {
            a(s1);
            return;
        }
        try
        {
            b(s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.internal("[InMobi]-[RE]-4.5.2", "Error injecting javascript ", s1);
        }
    }

    public boolean isAudioMuted(String s1)
    {
        s1 = mAudioVideoController.getCurrentAudioPlayer(s1);
        if (s1 == null)
        {
            raiseError("Invalid property ID", "isAudioMuted");
            return false;
        } else
        {
            return s1.isMediaMuted();
        }
    }

    public boolean isBusy()
    {
        return s;
    }

    public boolean isConfigChangesListed(Activity activity)
    {
        int i1 = android.os.Build.VERSION.SDK_INT;
        int j1 = a(activity);
        boolean flag;
        if ((j1 & 0x10) == 0 || (j1 & 0x20) == 0 || (j1 & 0x80) == 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (i1 >= 13 && ((j1 & 0x400) == 0 || (j1 & 0x800) == 0))
        {
            i1 = 0;
        } else
        {
            i1 = 1;
        }
        return flag && i1;
    }

    public boolean isEnabledHardwareAcceleration()
    {
        return K;
    }

    public boolean isExpanded()
    {
        return k == ViewState.EXPANDED;
    }

    public boolean isLandscapeSyncOrientation(int i1)
    {
        return i1 == 1 || i1 == 3;
    }

    public boolean isModal()
    {
        return mIsInterstitialAd || k == ViewState.EXPANDED;
    }

    public boolean isPageFinished()
    {
        return e;
    }

    public boolean isPortraitSyncOrientation(int i1)
    {
        return i1 == 0 || i1 == 2;
    }

    public boolean isVideoMuted(String s1)
    {
        s1 = mAudioVideoController.getVideoPlayer(s1);
        if (s1 == null)
        {
            raiseError("Invalid property ID", "isVideoMuted");
            return false;
        } else
        {
            return s1.isMediaMuted();
        }
    }

    public boolean isViewable()
    {
        return mIsViewable;
    }

    public void loadData(String s1, String s2, String s3)
    {
        f = false;
        super.loadData(s1, s2, s3);
    }

    public void loadDataWithBaseURL(String s1, String s2, String s3, String s4, String s5)
    {
        f = false;
        if (k == ViewState.EXPANDED)
        {
            return;
        } else
        {
            d();
            super.loadDataWithBaseURL(s1, s2, s3, s4, s5);
            return;
        }
    }

    public void loadUrl(String s1)
    {
        f = false;
        if (k == ViewState.EXPANDED)
        {
            return;
        } else
        {
            d();
            super.loadUrl(s1);
            return;
        }
    }

    public void lockExpandOrientation(Activity activity, boolean flag, String s1)
    {
        int i1;
        try
        {
            if (!isConfigChangesListed(activity))
            {
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            Log.debug("[InMobi]-[RE]-4.5.2", "Exception handling the orientation ", activity);
            return;
        }
        i1 = activity.getRequestedOrientation();
        if (i1 == 0 || i1 == 1)
        {
            break MISSING_BLOCK_LABEL_236;
        }
        if (android.os.Build.VERSION.SDK_INT >= 9 && (i1 == 8 || i1 == 9 || i1 == 6 || i1 == 7))
        {
            break MISSING_BLOCK_LABEL_236;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        i1 = getIntegerCurrentRotation();
        mExpandController.initialExpandOrientation = activity.getRequestedOrientation();
        if (s1.equalsIgnoreCase("portrait"))
        {
            mExpandController.useLockOrient = true;
            activity.setRequestedOrientation(WrapperFunctions.getParamPortraitOrientation(i1));
            return;
        }
        if (s1.equalsIgnoreCase("landscape"))
        {
            mExpandController.useLockOrient = true;
            activity.setRequestedOrientation(WrapperFunctions.getParamLandscapeOrientation(i1));
            return;
        }
        mExpandController.useLockOrient = true;
        if (activity.getResources().getConfiguration().orientation == 2)
        {
            Log.internal("[InMobi]-[RE]-4.5.2", "In allowFalse, none mode dev orientation:ORIENTATION_LANDSCAPE");
            activity.setRequestedOrientation(0);
            return;
        }
        Log.internal("[InMobi]-[RE]-4.5.2", "In allowFalse, none mode dev orientation:ORIENTATION_PORTRAIT");
        activity.setRequestedOrientation(1);
        return;
        if (activity.getResources().getConfiguration().orientation == 2)
        {
            Log.internal("[InMobi]-[RE]-4.5.2", "In allow true,  device orientation:ORIENTATION_LANDSCAPE");
            return;
        }
        Log.internal("[InMobi]-[RE]-4.5.2", "In allow true,  device orientation:ORIENTATION_PORTRAIT");
    }

    public void mediaPlayerReleased(AVPlayer avplayer)
    {
        mAudioVideoController.mediaPlayerReleased(avplayer);
    }

    public void muteAudio(String s1)
    {
        AVPlayer avplayer = mAudioVideoController.getCurrentAudioPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "muteAudio");
            return;
        }
        if (avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED)
        {
            raiseError("Invalid player state", "muteAudio");
            return;
        } else
        {
            Message message = A.obtainMessage(1019);
            Bundle bundle = new Bundle();
            bundle.putString("aplayerref", s1);
            message.setData(bundle);
            message.sendToTarget();
            return;
        }
    }

    public void muteVideo(String s1)
    {
        s1 = mAudioVideoController.getVideoPlayer(s1);
        if (s1 == null)
        {
            raiseError("Invalid property ID", "muteVideo");
            return;
        }
        if (s1.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED || s1.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.INIT)
        {
            raiseError("Invalid player state", "muteVideo");
            return;
        } else
        {
            Message message = A.obtainMessage(1015);
            message.obj = s1;
            A.sendMessage(message);
            return;
        }
    }

    protected void onAttachedToWindow()
    {
        Log.debug("[InMobi]-[RE]-4.5.2", "IMWebView-> onAttachedToWindow");
        saveOriginalViewParent();
        if (!v)
        {
            android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
            i = layoutparams.height;
            j = layoutparams.width;
            v = true;
        }
        g.registerBroadcastListener();
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow()
    {
        Log.debug("[InMobi]-[RE]-4.5.2", "IMWebView-> onDetatchedFromWindow");
        g.stopAllListeners();
        B.clear();
        g.unRegisterBroadcastListener();
        if (mIsInterstitialAd && !mWebViewIsBrowserActivity)
        {
            mInterstitialController.handleInterstitialClose();
        }
        super.onDetachedFromWindow();
    }

    protected void onIMWebviewVisibilityChanged(boolean flag)
    {
        if (mIsViewable != flag)
        {
            mIsViewable = flag;
            if (!doNotFireVisibilityChanged.get())
            {
                a(flag);
                return;
            }
        }
    }

    public void onOrientationEventChange()
    {
        A.sendEmptyMessage(1027);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (i1 != 0 && j1 != 0)
        {
            if (!F)
            {
                a((int)((float)i1 / getDensity()), (int)((float)j1 / getDensity()));
            }
            F = false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        requestFocus();
        return super.onTouchEvent(motionevent);
    }

    protected void onWindowVisibilityChanged(int i1)
    {
        super.onWindowVisibilityChanged(i1);
        boolean flag;
        if (i1 == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        onIMWebviewVisibilityChanged(flag);
        if (i1 == 0)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        if (g.supports("vibrate"))
        {
            ((Vibrator)y.getSystemService("vibrator")).cancel();
        }
        return;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[RE]-4.5.2", "Failed to cancel existing vibration", exception);
        return;
    }

    public void openExternal(String s1)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(s1));
        intent.addFlags(0x10000000);
        try
        {
            getContext().startActivity(intent);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            raiseError("Request must specify a valid URL", "openExternal");
            return;
        }
        if (mListener != null)
        {
            mListener.onLeaveApplication();
        }
    }

    public void openURL(String s1)
    {
        if (!isViewable())
        {
            raiseError("Cannot open URL.Ad is not viewable yet", "openURL");
            return;
        } else
        {
            Message message = A.obtainMessage(1024);
            Bundle bundle = new Bundle();
            bundle.putString("expand_url", s1);
            message.setData(bundle);
            A.sendMessage(message);
            return;
        }
    }

    public void pageFinishedCallbackForAdCreativeTesting(Message message)
    {
        x = message;
    }

    public void pauseAudio(String s1)
    {
        AVPlayer avplayer = mAudioVideoController.getCurrentAudioPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "pauseAudio");
        } else
        {
            if (avplayer.getState() != com.inmobi.re.controller.util.AVPlayer.playerState.PLAYING)
            {
                if (avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.INIT && !avplayer.isPrepared())
                {
                    avplayer.setAutoPlay(false);
                    return;
                } else
                {
                    raiseError("Invalid player state", "pauseAudio");
                    return;
                }
            }
            if (avplayer.isPlaying())
            {
                Message message = A.obtainMessage(1010);
                Bundle bundle = new Bundle();
                bundle.putString("aplayerref", s1);
                message.setData(bundle);
                message.sendToTarget();
                return;
            }
        }
    }

    public void pauseVideo(String s1)
    {
        Message message = A.obtainMessage(1011);
        Bundle bundle = new Bundle();
        bundle.putString("pid", s1);
        message.setData(bundle);
        A.sendMessage(message);
    }

    public void playAudio(String s1, boolean flag, boolean flag1, boolean flag2, String s2, String s3, String s4)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        boolean flag3 = isMutexAquired.get();
        if (!flag3)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        mutex.wait();
_L1:
        obj;
        JVM INSTR monitorexit ;
        if (!mIsInterstitialAd && k != ViewState.EXPANDED)
        {
            raiseError("Cannot play audio.Ad is not in an expanded state", "playAudio");
            return;
        }
        break MISSING_BLOCK_LABEL_84;
        InterruptedException interruptedexception;
        interruptedexception;
        Log.debug("[InMobi]-[RE]-4.5.2", "mutex failed ", interruptedexception);
          goto _L1
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
        if (!isViewable())
        {
            raiseError("Cannot play audio.Ad is not viewable yet", "playAudio");
            return;
        } else
        {
            com.inmobi.re.controller.JSController.PlayerProperties playerproperties = new com.inmobi.re.controller.JSController.PlayerProperties();
            playerproperties.setProperties(false, flag, flag1, flag2, s2, s3, s4);
            s2 = new Bundle();
            s2.putString("expand_url", s1);
            s2.putParcelable("player_properties", playerproperties);
            s1 = A.obtainMessage(1007);
            s1.setData(s2);
            A.sendMessage(s1);
            return;
        }
    }

    public void playVideo(String s1, boolean flag, boolean flag1, boolean flag2, boolean flag3, com.inmobi.re.controller.JSController.Dimensions dimensions, String s2, 
            String s3, String s4)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        boolean flag4 = isMutexAquired.get();
        if (!flag4)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        mutex.wait();
_L1:
        obj;
        JVM INSTR monitorexit ;
        if (!mIsInterstitialAd && k != ViewState.EXPANDED)
        {
            raiseError("Cannot play video.Ad is not in an expanded state", "playVideo");
            return;
        }
        break MISSING_BLOCK_LABEL_84;
        InterruptedException interruptedexception;
        interruptedexception;
        Log.debug("[InMobi]-[RE]-4.5.2", "mutex failed ", interruptedexception);
          goto _L1
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
        if (!isViewable())
        {
            raiseError("Cannot play video.Ad is not viewable yet", "playVideo");
            return;
        }
        if (!mAudioVideoController.videoPlayerList.isEmpty() && mAudioVideoController.videoPlayerList.size() >= 5 && !mAudioVideoController.videoPlayerList.containsKey(s4))
        {
            raiseError("Player Error. Exceeding permissible limit for saved play instances", "playVideo");
            return;
        } else
        {
            Message message = A.obtainMessage(1006);
            com.inmobi.re.controller.JSController.PlayerProperties playerproperties = new com.inmobi.re.controller.JSController.PlayerProperties();
            playerproperties.setProperties(flag, flag1, flag2, flag3, s2, s3, s4);
            s2 = new Bundle();
            s2.putString("expand_url", s1);
            s2.putParcelable("player_properties", playerproperties);
            Log.debug("[InMobi]-[RE]-4.5.2", (new StringBuilder("Before validation dimension: (")).append(dimensions.x).append(", ").append(dimensions.y).append(", ").append(dimensions.width).append(", ").append(dimensions.height).append(")").toString());
            mAudioVideoController.validateVideoDimensions(dimensions);
            Log.debug("[InMobi]-[RE]-4.5.2", (new StringBuilder("After validation dimension: (")).append(dimensions.x).append(", ").append(dimensions.y).append(", ").append(dimensions.width).append(", ").append(dimensions.height).append(")").toString());
            s2.putParcelable("expand_dimensions", dimensions);
            message.setData(s2);
            A.sendMessage(message);
            return;
        }
    }

    public void postInHandler(Runnable runnable)
    {
        A.post(runnable);
    }

    public void postInjectJavaScript(String s1)
    {
        if (s1 != null)
        {
            Message message = A.obtainMessage(1025);
            Bundle bundle = new Bundle();
            bundle.putString("injectMessage", s1);
            message.setData(bundle);
            message.sendToTarget();
        }
    }

    public void raiseCameraPictureCapturedEvent(String s1, int i1, int j1)
    {
        s1 = (new StringBuilder("window.mraidview.fireCameraPictureCatpturedEvent('")).append(s1).append("','").append(i1).append("','").append(j1).append("')").toString();
        if (y != null)
        {
            y.runOnUiThread(new _cls2(s1));
        }
    }

    public void raiseError(String s1, String s2)
    {
        Message message = A.obtainMessage(1008);
        Bundle bundle = new Bundle();
        bundle.putString("message", s1);
        bundle.putString("action", s2);
        message.setData(bundle);
        A.sendMessage(message);
    }

    public void raiseGalleryImageSelectedEvent(String s1, int i1, int j1)
    {
        s1 = (new StringBuilder("window.mraidview.fireGalleryImageSelectedEvent('")).append(s1).append("','").append(i1).append("','").append(j1).append("')").toString();
        if (y != null)
        {
            y.runOnUiThread(new _cls4(s1));
        }
    }

    public void raiseMicEvent(double d1)
    {
        a = d1;
        String s1 = (new StringBuilder("window.mraid.broadcastEvent('micIntensityChange',")).append(d1).append(")").toString();
        if (y != null)
        {
            y.runOnUiThread(new _cls14(s1));
        }
    }

    public void raiseVibrateCompleteEvent()
    {
        if (y != null)
        {
            y.runOnUiThread(new _cls3());
        }
    }

    public void requestOnInterstitialClosed(Message message)
    {
        mInterstitialController.mMsgOnInterstitialClosed = message;
    }

    public void requestOnInterstitialShown(Message message)
    {
        mInterstitialController.mMsgOnInterstitialShown = message;
    }

    public void resetLayout()
    {
        android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
        if (v)
        {
            layoutparams.height = i;
            layoutparams.width = j;
        }
        setVisibility(0);
        requestLayout();
    }

    public void resetMraid()
    {
        mExpandController.reset();
        mResizeController.reset();
        g.reset();
    }

    public void resize(com.inmobi.re.controller.JSController.ResizeProperties resizeproperties)
    {
        setState(ViewState.RESIZING);
        isMutexAquired.set(true);
        Message message = A.obtainMessage(1030);
        mResizeController.resizeProperties = resizeproperties;
        A.sendMessage(message);
    }

    public void saveFile(File file, String s1, String s2)
    {
        (new a(file, s1, s2)).execute(new Void[0]);
    }

    public void saveOriginalViewParent()
    {
        if (D == null)
        {
            D = getParent();
            if (D != null)
            {
                int j1 = ((ViewGroup)D).getChildCount();
                int i1;
                for (i1 = 0; i1 < j1 && ((ViewGroup)D).getChildAt(i1) != this; i1++) { }
                E = i1;
                return;
            }
        }
    }

    public void seekAudio(String s1, int i1)
    {
        s1 = mAudioVideoController.getCurrentAudioPlayer(s1);
        if (s1 == null)
        {
            raiseError("Invalid property ID", "seekAudio");
            return;
        }
        if (s1.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED)
        {
            raiseError("Invalid player state", "seekAudio");
            return;
        } else
        {
            Message message = A.obtainMessage(1022);
            Bundle bundle = new Bundle();
            bundle.putInt("seekaudio", i1);
            message.setData(bundle);
            message.obj = s1;
            message.sendToTarget();
            return;
        }
    }

    public void seekVideo(String s1, int i1)
    {
        s1 = mAudioVideoController.getVideoPlayer(s1);
        if (s1 == null)
        {
            raiseError("Invalid property ID", "seekVideo");
            return;
        }
        if (s1.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED || s1.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.INIT)
        {
            raiseError("Invalid player state", "seekVideo");
            return;
        } else
        {
            Message message = A.obtainMessage(1018);
            Bundle bundle = new Bundle();
            bundle.putInt("seek", i1);
            message.setData(bundle);
            message.obj = s1;
            A.sendMessage(message);
            return;
        }
    }

    public void sendToCPHandler()
    {
        A.sendEmptyMessage(1029);
    }

    public void sendToDPHandler()
    {
        A.sendEmptyMessage(1032);
    }

    public void sendasyncPing(String s1)
    {
        g.asyncPing(s1);
    }

    public void setActivity(Activity activity)
    {
        y = activity;
    }

    public void setAudioVolume(String s1, int i1)
    {
        if (mAudioVideoController.getCurrentAudioPlayer(s1) == null)
        {
            raiseError("Invalid property ID", "setAudioVolume");
            return;
        } else
        {
            Message message = A.obtainMessage(1021);
            Bundle bundle = new Bundle();
            bundle.putInt("vol", i1);
            bundle.putString("aplayerref", s1);
            message.setData(bundle);
            message.sendToTarget();
            return;
        }
    }

    public void setBrowserActivity(Activity activity)
    {
        if (activity != null)
        {
            y = (IMBrowserActivity)activity;
        }
    }

    public void setBusy(boolean flag)
    {
        s = flag;
    }

    public void setCallBack(InstantVideoCallbackCallback instantvideocallbackcallback)
    {
        c = instantvideocallbackcallback;
    }

    public void setCloseButton()
    {
        CustomView customview;
        byte byte0;
        try
        {
            customview = (CustomView)((ViewGroup)getRootView()).findViewById(225);
        }
        catch (Exception exception)
        {
            return;
        }
        if (customview == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        if (getCustomClose())
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        customview.setVisibility(byte0);
    }

    public void setCustomClose(boolean flag)
    {
        t = flag;
        Message message = A.obtainMessage(1009);
        A.sendMessage(message);
    }

    public void setDisableCloseRegion(boolean flag)
    {
        u = flag;
        Message message = A.obtainMessage(1035);
        A.sendMessage(message);
    }

    public void setExpandPropertiesForInterstitial(boolean flag, boolean flag1, String s1)
    {
        setCustomClose(flag);
        mInterstitialController.orientationValueForInterstitial = s1;
        mInterstitialController.lockOrientationValueForInterstitial = flag1;
        if (mWebViewIsBrowserActivity)
        {
            mExpandController.handleOrientationFor2Piece();
        }
        if (isViewable() && mIsInterstitialAd)
        {
            A.sendEmptyMessage(1026);
        }
    }

    public void setExternalWebViewClient(WebViewClient webviewclient)
    {
        z = webviewclient;
    }

    public void setOrientationPropertiesForInterstitial(boolean flag, String s1)
    {
        mInterstitialController.orientationValueForInterstitial = s1;
        mInterstitialController.lockOrientationValueForInterstitial = flag;
        if (mWebViewIsBrowserActivity)
        {
            mExpandController.handleOrientationFor2Piece();
        }
        if (isViewable() && mIsInterstitialAd)
        {
            A.sendEmptyMessage(1026);
        }
    }

    public void setOriginalParent(ViewParent viewparent)
    {
        D = viewparent;
    }

    public void setPlayableListener(IMWebViewPlayableListener imwebviewplayablelistener)
    {
        l = imwebviewplayablelistener;
    }

    public void setState(ViewState viewstate)
    {
        Log.debug("[InMobi]-[RE]-4.5.2", (new StringBuilder("State changing from ")).append(k).append(" to ").append(viewstate).toString());
        k = viewstate;
        if (viewstate != ViewState.EXPANDING && viewstate != ViewState.RESIZING)
        {
            injectJavaScript((new StringBuilder("window.mraid.broadcastEvent('stateChange','")).append(getState()).append("');").toString());
        }
    }

    public void setVideoVolume(String s1, int i1)
    {
        s1 = mAudioVideoController.getVideoPlayer(s1);
        if (s1 == null)
        {
            raiseError("Invalid property ID", "setVideoVolume");
            return;
        }
        if (s1.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED)
        {
            raiseError("Invalid player state", "setVideoVolume");
            return;
        } else
        {
            Message message = A.obtainMessage(1017);
            Bundle bundle = new Bundle();
            bundle.putInt("volume", i1);
            message.setData(bundle);
            message.obj = s1;
            A.sendMessage(message);
            return;
        }
    }

    public void show()
    {
        A.sendEmptyMessage(1003);
    }

    public void showVideo(String s1)
    {
        Message message = A.obtainMessage(1014);
        Bundle bundle = new Bundle();
        bundle.putString("pid", s1);
        message.setData(bundle);
        A.sendMessage(message);
    }

    public void unMuteAudio(String s1)
    {
        AVPlayer avplayer = mAudioVideoController.getCurrentAudioPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "unmuteAudio");
            return;
        }
        if (avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED)
        {
            raiseError("Invalid player state", "unmuteAudio");
            return;
        } else
        {
            Message message = A.obtainMessage(1020);
            Bundle bundle = new Bundle();
            bundle.putString("aplayerref", s1);
            message.setData(bundle);
            message.sendToTarget();
            return;
        }
    }

    public void unMuteVideo(String s1)
    {
        s1 = mAudioVideoController.getVideoPlayer(s1);
        if (s1 == null)
        {
            raiseError("Invalid property ID", "unMuteVideo");
            return;
        }
        if (s1.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED || s1.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.INIT)
        {
            raiseError("Invalid player state", "unMuteVideo");
            return;
        } else
        {
            Message message = A.obtainMessage(1016);
            message.obj = s1;
            A.sendMessage(message);
            return;
        }
    }

    public void userInteraction(HashMap hashmap)
    {
        Message message = A.obtainMessage(1033);
        Bundle bundle = new Bundle();
        bundle.putSerializable("map", hashmap);
        message.setData(bundle);
        message.sendToTarget();
    }


    private class ViewState extends Enum
    {

        public static final ViewState DEFAULT;
        public static final ViewState EXPANDED;
        public static final ViewState EXPANDING;
        public static final ViewState HIDDEN;
        public static final ViewState LOADING;
        public static final ViewState RESIZED;
        public static final ViewState RESIZING;
        private static final ViewState a[];

        public static ViewState valueOf(String s1)
        {
            return (ViewState)Enum.valueOf(com/inmobi/re/container/IMWebView$ViewState, s1);
        }

        public static ViewState[] values()
        {
            return (ViewState[])a.clone();
        }

        static 
        {
            LOADING = new ViewState("LOADING", 0);
            DEFAULT = new ViewState("DEFAULT", 1);
            RESIZED = new ViewState("RESIZED", 2);
            EXPANDED = new ViewState("EXPANDED", 3);
            EXPANDING = new ViewState("EXPANDING", 4);
            HIDDEN = new ViewState("HIDDEN", 5);
            RESIZING = new ViewState("RESIZING", 6);
            a = (new ViewState[] {
                LOADING, DEFAULT, RESIZED, EXPANDED, EXPANDING, HIDDEN, RESIZING
            });
        }

        private ViewState(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls10 {}


    /* member class not found */
    class _cls13 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls9 {}


    /* member class not found */
    class c {}


    /* member class not found */
    class a {}


    /* member class not found */
    class _cls11 {}


    /* member class not found */
    class _cls12 {}


    /* member class not found */
    class _cls5 {}


    private class IMWebViewListener
    {

        public abstract void onDismissAdScreen();

        public abstract void onDisplayFailed();

        public abstract void onError();

        public abstract void onExpand();

        public abstract void onExpandClose();

        public abstract void onIncentCompleted(Map map);

        public abstract void onLeaveApplication();

        public abstract void onResize(ResizeDimensions resizedimensions);

        public abstract void onResizeClose();

        public abstract void onShowAdScreen();

        public abstract void onUserInteraction(Map map);
    }


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls14 {}


    /* member class not found */
    class _cls3 {}

}
