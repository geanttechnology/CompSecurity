// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import com.applovin.adview.AdViewController;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.adview.ClickTrackingOverlayView;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.ca;
import com.applovin.impl.sdk.cc;
import com.applovin.impl.sdk.dh;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.applovin.impl.adview:
//            r, f, k, i, 
//            l, o, j, h, 
//            b, a, g, x, 
//            m

public class AdViewControllerImpl
    implements AdViewController
{

    private Activity a;
    private AppLovinSdk b;
    private AppLovinAdService c;
    private AppLovinLogger d;
    private AppLovinAdSize e;
    private r f;
    private l g;
    private o h;
    private AppLovinAd i;
    private Runnable j;
    private Runnable k;
    private Runnable l;
    private volatile AppLovinAd m;
    private ClickTrackingOverlayView n;
    private WeakReference o;
    private final AtomicReference p = new AtomicReference();
    private volatile boolean q;
    private volatile boolean r;
    private volatile boolean s;
    private volatile boolean t;
    private volatile AppLovinAdLoadListener u;
    private volatile AppLovinAdDisplayListener v;
    private volatile AppLovinAdVideoPlaybackListener w;
    private volatile AppLovinAdClickListener x;
    private volatile boolean y;

    public AdViewControllerImpl()
    {
        m = null;
        n = null;
        o = null;
        q = false;
        r = true;
        s = false;
        t = false;
    }

    static AppLovinAdLoadListener a(AdViewControllerImpl adviewcontrollerimpl)
    {
        return adviewcontrollerimpl.u;
    }

    static void a(View view, AppLovinAdSize applovinadsize)
    {
        b(view, applovinadsize);
    }

    private void a(ViewGroup viewgroup, AppLovinSdk applovinsdk, AppLovinAdSize applovinadsize, Context context)
    {
        if (viewgroup == null)
        {
            throw new IllegalArgumentException("No parent view specified");
        }
        if (applovinsdk == null)
        {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (applovinadsize == null)
        {
            throw new IllegalArgumentException("No ad size specified");
        }
        if (!(context instanceof Activity))
        {
            throw new IllegalArgumentException("Specified context is not an activity");
        }
        b = applovinsdk;
        c = applovinsdk.getAdService();
        d = applovinsdk.getLogger();
        e = applovinadsize;
        a = (Activity)context;
        i = dh.a();
        f = new r(this, applovinsdk);
        l = new f(this, null);
        j = new k(this, null);
        k = new i(this, null);
        g = new l(this, applovinsdk);
        if (a(context))
        {
            h = b();
            viewgroup.setBackgroundColor(0);
            viewgroup.addView(h);
            b(h, applovinadsize);
            h.setVisibility(8);
            a(((Runnable) (new j(this, null))));
            q = true;
            return;
        } else
        {
            d.userError("AppLovinAdView", "Web view database is corrupt, AdView not loaded");
            return;
        }
    }

    private void a(AppLovinAd applovinad, AppLovinAdView applovinadview, Uri uri)
    {
        if (n == null)
        {
            d.d("AppLovinAdView", "Creating and rendering click overlay");
            n = new ClickTrackingOverlayView(applovinadview.getContext(), b);
            n.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
            applovinadview.addView(n);
            applovinadview.bringChildToFront(n);
            ((AppLovinAdServiceImpl)c).trackForegroundClick(applovinad, applovinadview, this, uri);
            return;
        } else
        {
            d.d("AppLovinAdView", "Skipping click overlay rendering because it already exists");
            return;
        }
    }

    private void a(Runnable runnable)
    {
        a.runOnUiThread(runnable);
    }

    private static boolean a(Context context)
    {
        try
        {
            if (android.os.Build.VERSION.SDK_INT < 11)
            {
                context = WebViewDatabase.getInstance(context);
                Method method = android/webkit/WebViewDatabase.getDeclaredMethod("getCacheTotalSize", new Class[0]);
                method.setAccessible(true);
                method.invoke(context, new Object[0]);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("AppLovinAdView", "Error invoking getCacheTotalSize()", context);
            return true;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("AppLovinAdView", "Error invoking getCacheTotalSize()", context);
            return true;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("AppLovinAdView", "Error invoking getCacheTotalSize()", context);
            return true;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("AppLovinAdView", "getCacheTotalSize() reported exception", context);
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("AppLovinAdView", "Unexpected error while checking DB state", context);
            return false;
        }
        return true;
    }

    private o b()
    {
        o o1 = new o(f, b, a);
        o1.setBackgroundColor(0);
        o1.setWillNotCacheDrawing(false);
        if ((new ca(b)).F() && android.os.Build.VERSION.SDK_INT >= 19)
        {
            o1.setLayerType(2, null);
        }
        return o1;
    }

    static AppLovinLogger b(AdViewControllerImpl adviewcontrollerimpl)
    {
        return adviewcontrollerimpl.d;
    }

    private static void b(View view, AppLovinAdSize applovinadsize)
    {
        Object obj = view.getResources().getDisplayMetrics();
        int i1;
        int j1;
        if (applovinadsize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel()))
        {
            i1 = -1;
        } else
        if (applovinadsize.getWidth() == -1)
        {
            i1 = ((DisplayMetrics) (obj)).widthPixels;
        } else
        {
            i1 = (int)TypedValue.applyDimension(1, applovinadsize.getWidth(), ((DisplayMetrics) (obj)));
        }
        if (applovinadsize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel()))
        {
            j1 = -1;
        } else
        if (applovinadsize.getHeight() == -1)
        {
            j1 = ((DisplayMetrics) (obj)).heightPixels;
        } else
        {
            j1 = (int)TypedValue.applyDimension(1, applovinadsize.getHeight(), ((DisplayMetrics) (obj)));
        }
        obj = (android.widget.RelativeLayout.LayoutParams)view.getLayoutParams();
        applovinadsize = ((AppLovinAdSize) (obj));
        if (obj == null)
        {
            applovinadsize = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        }
        applovinadsize.width = i1;
        applovinadsize.height = j1;
        if (applovinadsize instanceof android.widget.RelativeLayout.LayoutParams)
        {
            applovinadsize.addRule(10);
            applovinadsize.addRule(9);
        }
        view.setLayoutParams(applovinadsize);
    }

    static o c(AdViewControllerImpl adviewcontrollerimpl)
    {
        return adviewcontrollerimpl.h;
    }

    static AppLovinAd d(AdViewControllerImpl adviewcontrollerimpl)
    {
        return adviewcontrollerimpl.m;
    }

    static AppLovinSdk e(AdViewControllerImpl adviewcontrollerimpl)
    {
        return adviewcontrollerimpl.b;
    }

    static Activity f(AdViewControllerImpl adviewcontrollerimpl)
    {
        return adviewcontrollerimpl.a;
    }

    static AppLovinAdDisplayListener g(AdViewControllerImpl adviewcontrollerimpl)
    {
        return adviewcontrollerimpl.v;
    }

    static AppLovinAdClickListener h(AdViewControllerImpl adviewcontrollerimpl)
    {
        return adviewcontrollerimpl.x;
    }

    static AppLovinAdVideoPlaybackListener i(AdViewControllerImpl adviewcontrollerimpl)
    {
        return adviewcontrollerimpl.w;
    }

    void a()
    {
        a(l);
        a(((Runnable) (new h(this, m))));
        m = null;
    }

    void a(int i1)
    {
        if (!s)
        {
            c.addAdUpdateListener(g, e);
            a(l);
        }
        a(((Runnable) (new b(this, i1))));
    }

    void a(AppLovinAd applovinad)
    {
        if (applovinad != null)
        {
            t = true;
            if (!s)
            {
                c.addAdUpdateListener(g, e);
                renderAd(applovinad);
            } else
            {
                p.set(applovinad);
                d.d("AppLovinAdView", "Ad view has paused when an ad was recieved, ad saved for later");
            }
            a(((Runnable) (new a(this, applovinad))));
            return;
        } else
        {
            d.e("AppLovinAdView", "No provided when to the view controller");
            a(-1);
            return;
        }
    }

    void a(AppLovinAd applovinad, AppLovinAdView applovinadview, AdViewControllerImpl adviewcontrollerimpl, Uri uri)
    {
        adviewcontrollerimpl = (AppLovinAdServiceImpl)c;
        if ((new ca(b)).H() && uri != null)
        {
            a(applovinad, applovinadview, uri);
        } else
        {
            adviewcontrollerimpl.trackClickOn(applovinad, applovinadview, this, uri);
        }
        a(((Runnable) (new g(this, applovinad))));
    }

    public void destroy()
    {
        if (c != null)
        {
            c.removeAdUpdateListener(g, getSize());
        }
        if (h != null)
        {
            try
            {
                h.removeAllViews();
                h.destroy();
            }
            catch (Throwable throwable)
            {
                d.w("AppLovinAdView", "Unable to destroy ad view", throwable);
            }
        }
        s = true;
    }

    public void dismissInterstitialIfRequired()
    {
        if ((new ca(b)).L())
        {
            if (a != null && (a instanceof AppLovinInterstitialActivity))
            {
                ((AppLovinInterstitialActivity)a).dismiss();
            } else
            if (o != null)
            {
                x x1 = (x)o.get();
                if (x1 != null)
                {
                    x1.dismiss();
                    return;
                }
            }
        }
    }

    public AppLovinAdSize getSize()
    {
        return e;
    }

    public void initializeAdView(ViewGroup viewgroup, Context context, AppLovinAdSize applovinadsize, AppLovinSdk applovinsdk, AttributeSet attributeset)
    {
        if (viewgroup == null)
        {
            throw new IllegalArgumentException("No parent view specified");
        }
        if (context == null)
        {
            Log.e("AppLovinSdk", "Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
        } else
        {
            AppLovinAdSize applovinadsize1 = applovinadsize;
            if (applovinadsize == null)
            {
                applovinadsize = com.applovin.impl.adview.m.a(attributeset);
                applovinadsize1 = applovinadsize;
                if (applovinadsize == null)
                {
                    applovinadsize1 = AppLovinAdSize.BANNER;
                }
            }
            applovinadsize = applovinsdk;
            if (applovinsdk == null)
            {
                applovinadsize = AppLovinSdk.getInstance(context);
            }
            if (applovinadsize != null && !applovinadsize.hasCriticalErrors())
            {
                a(viewgroup, applovinadsize, applovinadsize1, context);
                if (com.applovin.impl.adview.m.b(attributeset))
                {
                    loadNextAd();
                    return;
                }
            }
        }
    }

    public boolean isAdReadyToDisplay()
    {
        return b.getAdService().hasPreloadedAd(e);
    }

    public boolean isAutoDestroy()
    {
        return r;
    }

    public boolean isForegroundClickInvalidated()
    {
        return y;
    }

    public void loadNextAd()
    {
        if (b != null && g != null && a != null && q)
        {
            c.loadNextAd(e, g);
            return;
        } else
        {
            Log.i("AppLovinSdk", "Unable to load next ad: AppLovinAdView is not initialized.");
            return;
        }
    }

    public void onAdHtmlLoaded(WebView webview)
    {
        if (m == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        webview.setVisibility(0);
        if (v != null)
        {
            v.adDisplayed(m);
        }
        return;
        webview;
        d.userError("AppLovinAdView", "Exception while notifying ad display listener", webview);
        return;
    }

    public void onDetachedFromWindow()
    {
        if (q)
        {
            a(new h(this, m));
            if (r)
            {
                destroy();
                return;
            }
        }
    }

    public void onVisibilityChanged(int i1)
    {
        if (q && r)
        {
            if (i1 == 8 || i1 == 4)
            {
                pause();
                return;
            }
            if (i1 == 0)
            {
                resume();
                return;
            }
        }
    }

    public void pause()
    {
        if (!q)
        {
            return;
        }
        c.removeAdUpdateListener(g, getSize());
        AppLovinAd applovinad = m;
        renderAd(i);
        if (applovinad != null)
        {
            p.set(applovinad);
        }
        s = true;
    }

    public void removeClickTrackingOverlay()
    {
        if (n != null)
        {
            android.view.ViewParent viewparent = n.getParent();
            if (viewparent != null && (viewparent instanceof ViewGroup))
            {
                ((ViewGroup)viewparent).removeView(n);
                n = null;
            }
            return;
        } else
        {
            d.d("AppLovinAdView", "Asked to remove an overlay when none existed. Skipping...");
            return;
        }
    }

    public void renderAd(AppLovinAd applovinad)
    {
        if (applovinad == null)
        {
            throw new IllegalArgumentException("No ad specified");
        }
        if (!q)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        if (applovinad == m) goto _L2; else goto _L1
_L1:
        d.d("AppLovinAdView", (new StringBuilder()).append("Rendering ad # ").append(applovinad.getAdIdNumber()).append(" (").append(applovinad.getSize()).append(")").toString());
        a(new h(this, m));
        p.set(null);
        m = applovinad;
        if (applovinad.getSize() != e) goto _L4; else goto _L3
_L3:
        a(j);
_L5:
        (new cc(b)).a();
        return;
_L4:
        if (applovinad.getSize() == AppLovinAdSize.INTERSTITIAL)
        {
            a(l);
            a(k);
        }
        if (true) goto _L5; else goto _L2
_L2:
        d.w("AppLovinAdView", (new StringBuilder()).append("Ad # ").append(applovinad.getAdIdNumber()).append(" is already showing, ignoring").toString());
        return;
        Log.i("AppLovinSdk", "Unable to render ad: AppLovinAdView is not initialized.");
        return;
    }

    public void resume()
    {
        if (!q)
        {
            return;
        }
        if (t)
        {
            c.addAdUpdateListener(g, e);
        }
        AppLovinAd applovinad = (AppLovinAd)p.getAndSet(null);
        if (applovinad != null)
        {
            renderAd(applovinad);
        }
        s = false;
    }

    public void setAdClickListener(AppLovinAdClickListener applovinadclicklistener)
    {
        x = applovinadclicklistener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener applovinaddisplaylistener)
    {
        v = applovinaddisplaylistener;
    }

    public void setAdLoadListener(AppLovinAdLoadListener applovinadloadlistener)
    {
        u = applovinadloadlistener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener applovinadvideoplaybacklistener)
    {
        w = applovinadvideoplaybacklistener;
    }

    public void setAutoDestroy(boolean flag)
    {
        r = flag;
    }

    public void setIsForegroundClickInvalidated(boolean flag)
    {
        y = flag;
    }

    public void setParentDialog(WeakReference weakreference)
    {
        o = weakreference;
    }
}
