// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.medialets.analytics.MMAnalyticsManager;
import com.medialets.analytics.MMEvent;
import com.medialets.thrift.AdEvent;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

// Referenced classes of package com.medialets.advertising:
//            BannerAdView, InterstitialAdView, g, a, 
//            AdManager, AdManagerService, ae, j, 
//            AdWebView, d, ag, aa, 
//            y, x, i, ab, 
//            JSBridge

public abstract class AdView extends RelativeLayout
{
    public static interface AdListener
    {

        public abstract void onAdVisible(AdView adview);

        public abstract void onFinishedLoadingView(AdView adview);

        public abstract void onInterstitialDismissed(AdView adview);

        public abstract void onNoAdsAvailable(AdView adview);
    }


    public static final int TYPE_BANNER = 1;
    protected static final int TYPE_EXPANDABLE = 3;
    public static final int TYPE_INTERSTITIAL = 2;
    private RelativeLayout a;
    private i b;
    private Rect c;
    protected boolean isDismissed;
    protected MMEvent mAdEvent;
    protected ab mAdEventListener;
    protected AdListener mAdListener;
    protected ae mAdvertisement;
    protected String mBlockedKeywords;
    protected boolean mClickReceived;
    protected HashMap mCustomMacros;
    protected boolean mDisplayWhenReady;
    protected boolean mDurationTimerRunning;
    protected int mHeight;
    protected boolean mIgnoreFullscreen;
    protected JSBridge mJsBridge;
    protected AdListener mListener;
    protected boolean mLoadingViewVisible;
    protected int mRandom;
    protected String mSlotKeywords;
    protected String mSlotName;
    protected HashMap mStandardMacros;
    protected long mStartTime;
    protected boolean mViewRendered;
    protected AdWebView mWebView;
    protected int mWidth;

    public AdView(Context context)
    {
        super(context);
        mDisplayWhenReady = true;
        mClickReceived = false;
        mDurationTimerRunning = false;
        mLoadingViewVisible = false;
        mIgnoreFullscreen = false;
        mViewRendered = false;
        isDismissed = false;
        c = new Rect(getLeft(), getTop(), getRight(), getBottom());
    }

    public AdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mDisplayWhenReady = true;
        mClickReceived = false;
        mDurationTimerRunning = false;
        mLoadingViewVisible = false;
        mIgnoreFullscreen = false;
        mViewRendered = false;
        isDismissed = false;
        c = new Rect(getLeft(), getTop(), getRight(), getBottom());
    }

    public AdView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mDisplayWhenReady = true;
        mClickReceived = false;
        mDurationTimerRunning = false;
        mLoadingViewVisible = false;
        mIgnoreFullscreen = false;
        mViewRendered = false;
        isDismissed = false;
        c = new Rect(getLeft(), getTop(), getRight(), getBottom());
    }

    private boolean a(View view, ViewGroup viewgroup, int i)
    {
label0:
        do
        {
label1:
            {
                Object obj = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                if (i == -1 && viewgroup != null && (viewgroup.getParent() instanceof ViewGroup))
                {
                    obj = (ViewGroup)viewgroup.getParent();
                    i = viewgroup.indexOfChild(view) - 1;
                    view = viewgroup;
                    viewgroup = ((ViewGroup) (obj));
                    continue;
                }
                if ((view instanceof ViewGroup) && i >= 0)
                {
                    boolean flag;
                    if (view instanceof BannerAdView)
                    {
                        flag = true;
                    } else
                    if (view instanceof InterstitialAdView)
                    {
                        flag = true;
                    } else
                    if (view instanceof g)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag)
                    {
                        obj = (ViewGroup)view;
                        do
                        {
                            if (i < 0)
                            {
                                break;
                            }
                            View view1 = ((ViewGroup) (obj)).getChildAt(i);
                            if (view1 == this)
                            {
                                return false;
                            }
                            if (view1 != null && view1.getVisibility() == 0)
                            {
                                if (view1 instanceof ViewGroup)
                                {
                                    view = (ViewGroup)view1;
                                    i = view.getChildCount() - 1;
                                    viewgroup = ((ViewGroup) (obj));
                                    continue label0;
                                }
                                if ((new Rect(view1.getLeft(), view1.getTop(), view1.getRight(), view1.getBottom())).contains(c))
                                {
                                    return true;
                                }
                            }
                            i--;
                        } while (true);
                        break label1;
                    }
                }
                if ((view instanceof g) && ((g)view).a() == this)
                {
                    return false;
                }
                if (((Rect) (obj)).contains(c))
                {
                    return true;
                }
            }
            if (viewgroup != null && (viewgroup.getParent() instanceof ViewGroup))
            {
                ViewGroup viewgroup1 = (ViewGroup)viewgroup.getParent();
                i = viewgroup.indexOfChild(view) - 1;
                view = viewgroup;
                viewgroup = viewgroup1;
            } else
            {
                return false;
            }
        } while (true);
    }

    public void cleanUp(WebView webview, String s)
    {
        com.medialets.advertising.a.d("Cleanup: removing the ad view from parent.");
        setVisibility(8);
    }

    protected final void commitEventData()
    {
        if (mAdEvent == null || !mDurationTimerRunning && mAdEvent.getDurationForKey("MMAdViewDuration") == null)
        {
            return;
        } else
        {
            stopDurationTimer();
            mAdEvent.setNumberForKey("MMAdExit", Double.valueOf(3D));
            AdManager.getInstance().mService.getAnalyticsManager().trackAdEvent(mAdEvent).toString();
            return;
        }
    }

    protected abstract void dismiss();

    protected void dismissFullscreen()
    {
        Activity activity = AdManager.getInstance().getCurrentActivity();
        if (!mAdvertisement.g())
        {
            Object obj = activity.getWindow().findViewById(0x1020016);
            if (obj != null)
            {
                obj = (ViewGroup)((View) (obj)).getParent();
                if (obj != null)
                {
                    ((ViewGroup) (obj)).setVisibility(0);
                }
            }
            if (!mIgnoreFullscreen)
            {
                activity.getWindow().clearFlags(1024);
            }
        }
    }

    protected final void dismissLoadingView()
    {
        if (!mLoadingViewVisible)
        {
            return;
        }
        if (getSlotType() == 1)
        {
            ViewGroup viewgroup = (ViewGroup)AdManager.getInstance().getCurrentActivity().getWindow().findViewById(0x1020002);
            if (viewgroup.indexOfChild(a) != -1)
            {
                viewgroup.removeView(a);
            }
        } else
        {
            removeView(a);
        }
        com.medialets.advertising.a.c("Loading view has been dismissed!");
        mLoadingViewVisible = false;
    }

    protected void display()
    {
        if (getSlotType() != 3 && mAdvertisement != null)
        {
            if (!mAdvertisement.q().isEmpty())
            {
                (new Thread(new j(mAdvertisement.q(), mRandom, d.a(mWebView.getSettings().getUserAgentString(), true)))).start();
            }
            if (mAdListener != null)
            {
                mAdListener.onAdVisible(this);
            }
        }
    }

    public final void displayWhenReady()
    {
        mDisplayWhenReady = true;
    }

    public final void displayWhenReady(boolean flag)
    {
        mDisplayWhenReady = flag;
    }

    protected final MMEvent getAdEvent()
    {
        return mAdEvent;
    }

    protected final AdWebView getAdWebView()
    {
        return mWebView;
    }

    protected final ae getAdvertisement()
    {
        return mAdvertisement;
    }

    public final String getBlockedKeywords()
    {
        return mBlockedKeywords;
    }

    protected final i getBrowser()
    {
        return b;
    }

    public String getSlotKeywords()
    {
        return mSlotKeywords;
    }

    public String getSlotName()
    {
        return mSlotName;
    }

    public abstract int getSlotType();

    protected void handleFullscreen()
    {
        Activity activity = AdManager.getInstance().getCurrentActivity();
        if (!mAdvertisement.g())
        {
            setBackgroundColor(0xff000000);
            mWebView.setBackgroundColor(0xff000000);
            Object obj = activity.getWindow().findViewById(0x1020016);
            if (obj != null)
            {
                obj = (ViewGroup)((View) (obj)).getParent();
                if (obj != null)
                {
                    ((ViewGroup) (obj)).setVisibility(8);
                }
            }
            if ((activity.getWindow().getAttributes().flags & 0x400) != 1024)
            {
                activity.getWindow().addFlags(1024);
                return;
            } else
            {
                mIgnoreFullscreen = true;
                return;
            }
        } else
        {
            mWebView.setBackgroundColor(0);
            return;
        }
    }

    protected final boolean isClicked()
    {
        return mClickReceived;
    }

    protected abstract boolean isDismissing();

    protected boolean isViewHidden()
    {
        boolean flag = true;
        if (getSlotType() != 1 && getSlotType() != 2)
        {
            flag = false;
        } else
        if (getVisibility() == 0)
        {
            Object obj1 = AdManager.getInstance().getCurrentActivity();
            boolean flag1;
            if (obj1 instanceof ActivityGroup)
            {
                Object obj = (ActivityGroup)obj1;
                obj1 = (ViewGroup)((Activity) (obj1)).getWindow().findViewById(0x1020002);
                flag1 = a(((View) (obj1)), null, ((ViewGroup) (obj1)).getChildCount() - 1);
                if (!flag1)
                {
                    obj = ((ActivityGroup) (obj)).getCurrentActivity();
                    if (obj != null)
                    {
                        obj = (ViewGroup)((Activity) (obj)).getWindow().findViewById(0x1020002);
                        return a(((View) (obj)), null, ((ViewGroup) (obj)).getChildCount() - 1);
                    }
                }
            } else
            {
                ViewGroup viewgroup = (ViewGroup)((Activity) (obj1)).getWindow().findViewById(0x1020002);
                return a(viewgroup, null, viewgroup.getChildCount() - 1);
            }
            return flag1;
        }
        return flag;
    }

    public final boolean loadAdTag(WebView webview, String s)
    {
        if (webview != null)
        {
            commitEventData();
        }
        if (webview != null && webview.indexOfChild(this) == -1)
        {
            webview.addView(this, new android.view.ViewGroup.LayoutParams(-1, -2));
        }
        if (s.startsWith("medialets:"))
        {
            com.medialets.advertising.a.a((new StringBuilder()).append("Medialets ad tag request: ").append(s).toString());
            String s1 = s.substring(10, s.indexOf("?"));
            webview = s.substring(s.indexOf("?") + 1).split("&");
            if (!s1.equals("launchAd"))
            {
                com.medialets.advertising.a.a("No launchAd request found in the ad tag.");
                return false;
            }
            s = new HashMap();
            for (int i = 0; i < webview.length; i++)
            {
                String as[] = webview[i].split("=");
                if (as.length > 1)
                {
                    s.put(as[0], as[1]);
                }
            }

            if (mSlotName == null || mSlotName.trim().equals(""))
            {
                com.medialets.advertising.a.c("--- Slot name is required. Please set a slot name on the AdView to display ads. ---");
                return false;
            }
            if (prepare((String)s.get("adID")))
            {
                com.medialets.advertising.a.a((new StringBuilder()).append("Loading ad via tag: ").append((String)s.get("adID")).toString());
            } else
            {
                com.medialets.advertising.a.a("Requested ad not available, loading alternate.");
                webview = URLDecoder.decode((String)s.get("alternate"));
                s = new android.widget.RelativeLayout.LayoutParams(-1, -2);
                getAdWebView().setLayoutParams(s);
                getAdWebView().loadDataWithBaseURL("about:blank", webview, "text/html", "utf-8", "about:blank");
                getAdWebView().bringToFront();
            }
            invalidate();
            setVisibility(0);
            bringToFront();
            com.medialets.advertising.a.d("View should be rendered.");
            com.medialets.advertising.a.d((new StringBuilder()).append("View size: ").append(getWidth()).append("x").append(getHeight()).toString());
            return true;
        } else
        {
            setVisibility(8);
            com.medialets.advertising.a.a("No medialets ad tag found.");
            return false;
        }
    }

    protected void loadAdvertisement()
    {
        mWebView.setCustomMacros(mCustomMacros);
        if (getSlotType() != 3)
        {
            setStandardMacros();
        }
        mWebView.setStandardMacros(mStandardMacros);
        mWebView.setAdvertisement(mAdvertisement);
        if (getSlotType() != 3)
        {
            mAdEvent = new MMEvent("MMAdViewed");
            mAdEvent.setStringForKey("MMAdID", mAdvertisement.d());
            mAdEvent.setNumberForKey("MMAdExit", Double.valueOf(6D));
            mAdEvent.setStringForKey("MMAdSlot", mSlotName);
            mAdEvent.setStringForKey("MMAdVersion", String.valueOf(mAdvertisement.c()));
            mAdEvent.setSlotName(mSlotName);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (keyevent.getKeyCode() == 4)
        {
            if (!mLoadingViewVisible);
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return true;
    }

    protected void onWindowVisibilityChanged(int i)
    {
label0:
        {
            if (i == 0)
            {
                if (mClickReceived)
                {
                    if (getSlotType() == 1)
                    {
                        a.setVisibility(8);
                    } else
                    {
                        dismissLoadingView();
                    }
                }
                mClickReceived = false;
            }
            if (getSlotType() != 3)
            {
                com.medialets.advertising.a.d((new StringBuilder()).append("Window visibility: ").append(i).append(" and view visibility: ").append(getVisibility()).toString());
                if (i == 0 && getVisibility() == 0)
                {
                    break label0;
                }
                stopDurationTimer();
            }
            return;
        }
        startDurationTimer();
    }

    public final boolean prepare()
    {
        if (!isDismissed) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        ag ag1 = AdManager.getInstance().mService.getDataStore();
        if (mAdEvent != null)
        {
            commitEventData();
        }
        if (mSlotName == null || mSlotName.trim().equals(""))
        {
            com.medialets.advertising.a.c("--- Slot name is required. Please set a slot name on the AdView to display ads. ---");
            return false;
        }
        if (mWidth == 0)
        {
            mWidth = getLayoutParams().width;
        }
        if (mHeight == 0)
        {
            mHeight = getLayoutParams().height;
        }
        com.medialets.advertising.a.d((new StringBuilder()).append("Size for ").append(mSlotName).append(": ").append(mWidth).append("x").append(mHeight).toString());
        mAdvertisement = aa.a(ag1.a(mWidth, mHeight, getSlotType()), this);
        if (mAdvertisement != null)
        {
            break; /* Loop/switch isn't completed */
        }
        com.medialets.advertising.a.a((new StringBuilder()).append("No advertisements returned for slot: ").append(mSlotName).toString());
        if (mAdListener != null)
        {
            mAdListener.onNoAdsAvailable(this);
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
        loadAdvertisement();
        if (!mDisplayWhenReady) goto _L5; else goto _L4
_L4:
        display();
_L7:
        return true;
_L5:
        if (mAdListener != null)
        {
            mAdListener.onFinishedLoadingView(this);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final boolean prepare(String s)
    {
        if (!isDismissed) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (mSlotName == null || mSlotName.trim().equals(""))
        {
            com.medialets.advertising.a.c("--- Slot name is required. Please set a slot name on the AdView to display ads. ---");
            return false;
        }
        ag ag1 = AdManager.getInstance().mService.getDataStore();
        if (mAdEvent != null)
        {
            commitEventData();
        }
        if (mWidth == 0)
        {
            mWidth = getLayoutParams().width;
        }
        if (mHeight == 0)
        {
            mHeight = getLayoutParams().height;
        }
        s = ag1.a(s);
        if (s == null || s.l() >= s.e() || s.m() >= s.f() || !aa.a(s, this) || s == null) goto _L1; else goto _L3
_L3:
        mAdvertisement = s;
        loadAdvertisement();
        if (!mDisplayWhenReady) goto _L5; else goto _L4
_L4:
        display();
_L7:
        return true;
_L5:
        if (mAdListener != null)
        {
            mAdListener.onFinishedLoadingView(this);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected abstract void renderLayout();

    protected final void setAdEvent(MMEvent mmevent)
    {
        mAdEvent = mmevent;
    }

    protected void setAdEventListener(ab ab)
    {
        mAdEventListener = ab;
    }

    public void setAdListener(AdListener adlistener)
    {
        mAdListener = adlistener;
    }

    protected void setAdvertisement(ae ae1)
    {
        mAdvertisement = ae1;
    }

    public final void setBlockedKeywords(String s)
    {
        mBlockedKeywords = s;
    }

    protected final void setBrowser(i i)
    {
        b = i;
    }

    protected final void setClicked(boolean flag)
    {
        mClickReceived = flag;
    }

    public void setCustomMacros(HashMap hashmap)
    {
        mCustomMacros = hashmap;
    }

    public void setHeight(int i)
    {
        Display display1 = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display1.getMetrics(displaymetrics);
        float f = i;
        mHeight = (new Double(Math.ceil(displaymetrics.density * f))).intValue();
        if (getLayoutParams() != null)
        {
            getLayoutParams().height = mHeight;
        } else
        {
            setLayoutParams(new android.view.ViewGroup.LayoutParams(0, mHeight));
        }
        setMinimumHeight(i);
        invalidate();
        requestLayout();
    }

    public void setSlotKeywords(String s)
    {
        mSlotKeywords = s;
    }

    public void setSlotName(String s)
    {
        mSlotName = s;
    }

    protected void setStandardMacros()
    {
        mStandardMacros = new HashMap();
        AdManager admanager = AdManager.getInstance();
        Object obj = new DisplayMetrics();
        y.c().getMetrics(((DisplayMetrics) (obj)));
        obj = (new StringBuilder()).append(((DisplayMetrics) (obj)).widthPixels).append("x").append(((DisplayMetrics) (obj)).heightPixels).toString();
        double ad[] = y.e();
        mRandom = (new Random()).nextInt() * 0x989680;
        mRandom = Math.abs(mRandom);
        mStandardMacros.put("$$_SCREENRES_$$", obj);
        mStandardMacros.put("$$_APPRES_$$", obj);
        mStandardMacros.put("$$_LAT_$$", String.valueOf(ad[0]));
        mStandardMacros.put("$$_LON_$$", String.valueOf(ad[1]));
        mStandardMacros.put("$$_ADID_$$", mAdvertisement.d());
        mStandardMacros.put("$$_ADHEIGHT_$$", String.valueOf(mAdvertisement.i()));
        mStandardMacros.put("$$_ADWIDTH_$$", String.valueOf(mAdvertisement.h()));
        mStandardMacros.put("$$_DEVICEID_$$", y.a(y.d()));
        mStandardMacros.put("$$_APPID_$$", admanager.mService.getApplicationId());
        mStandardMacros.put("$$_APPVER_$$", admanager.mService.getApplicationVersion());
        mStandardMacros.put("$$_SDKVER_$$", "2.2.11");
        mStandardMacros.put("$$_OSVER_$$", x.ANDROID_VERSION);
        mStandardMacros.put("$$_SLOTNAME_$$", mSlotName);
        mStandardMacros.put("$$_RANDOM_$$", String.valueOf(mRandom));
    }

    public void setWidth(int i)
    {
        Display display1 = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display1.getMetrics(displaymetrics);
        float f = i;
        mWidth = (new Double(Math.ceil(displaymetrics.density * f))).intValue();
        if (getLayoutParams() != null)
        {
            getLayoutParams().width = mWidth;
        } else
        {
            setLayoutParams(new android.view.ViewGroup.LayoutParams(mWidth, 0));
        }
        setMinimumWidth(i);
        invalidate();
        requestLayout();
    }

    protected final void showLoadingView()
    {
        if (mLoadingViewVisible)
        {
            return;
        }
        a = new RelativeLayout(getContext());
        a.setGravity(17);
        a.setVisibility(0);
        Object obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        obj.alignWithParent = true;
        a.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        final class a
            implements android.view.View.OnTouchListener
        {

            public final boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            a()
            {
            }
        }

        a.setOnTouchListener(new a());
        obj = new ProgressBar(getContext(), null, 0x101007a);
        ((ProgressBar) (obj)).setIndeterminate(true);
        ((ProgressBar) (obj)).setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-2, -2));
        a.setBackgroundColor(Color.argb(165, 0, 0, 0));
        a.addView(((View) (obj)));
        if (getSlotType() == 1)
        {
            ((ViewGroup)AdManager.getInstance().getCurrentActivity().getWindow().findViewById(0x1020002)).addView(a);
        } else
        {
            addView(a);
        }
        mLoadingViewVisible = true;
    }

    protected void startDurationTimer()
    {
label0:
        {
            if (!mDurationTimerRunning)
            {
                mStartTime = System.currentTimeMillis();
                mDurationTimerRunning = true;
                com.medialets.advertising.a.d("Starting the view timer...");
                if (mAdEvent.getDurationForKey("MMAdViewDuration") == null)
                {
                    break label0;
                }
                mAdEvent.getDurationForKey("MMAdViewDuration").doubleValue();
            }
            return;
        }
        com.medialets.advertising.a.a("in start timer accumulatedDuration is null");
    }

    protected void stopDurationTimer()
    {
        if (!mDurationTimerRunning || mAdEvent == null)
        {
            return;
        }
        double d2 = System.currentTimeMillis() - mStartTime;
        double d1 = 0.0D;
        if (mAdEvent.getDurationForKey("MMAdViewDuration") != null)
        {
            d1 = mAdEvent.getDurationForKey("MMAdViewDuration").doubleValue() * 1000D;
        } else
        {
            com.medialets.advertising.a.a("accumulatedDuration is null");
        }
        d1 = (d1 + d2) / 1000D;
        com.medialets.advertising.a.d("Stopping view timer...");
        mAdEvent.setDurationForKey("MMAdViewDuration", Double.valueOf(d1));
        mDurationTimerRunning = false;
        mAdEvent.getDurationForKey("MMAdViewDuration").doubleValue();
    }
}
