// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.view.ViewGroup;
import com.flurry.sdk.i;
import com.flurry.sdk.j;
import com.flurry.sdk.jo;
import com.flurry.sdk.kc;
import com.flurry.sdk.lg;
import com.flurry.sdk.v;
import com.flurry.sdk.w;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            FlurryAdSize, FlurryAdListener, ICustomAdNetworkHandler

public class FlurryAds
{

    private static final String a = com/flurry/android/FlurryAds.getSimpleName();

    private FlurryAds()
    {
    }

    public static void clearLocation()
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kc.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            lg.a().a("ExplicitLocation", null);
            return;
        }
    }

    public static void clearTargetingKeywords()
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kc.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            j.a().f();
            return;
        }
    }

    public static void clearUserCookies()
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kc.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            j.a().e();
            return;
        }
    }

    public static void displayAd(Context context, String s, ViewGroup viewgroup)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kc.b(a, "Device SDK Version older than 10");
            return;
        }
        if (jo.a() == null)
        {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        }
        if (context == null)
        {
            kc.b(a, "Context passed to displayAd was null.");
            return;
        }
        if (s == null)
        {
            kc.b(a, "Ad space name passed to displayAd was null.");
            return;
        }
        if (s.length() == 0)
        {
            kc.b(a, "Ad space name passed to displayAd was empty.");
            return;
        }
        if (viewgroup == null)
        {
            kc.b(a, "ViewGroup passed to displayAd was null.");
            return;
        }
        Object obj = i.a();
        if (obj == null)
        {
            try
            {
                kc.b(a, "Could not find FlurryAds module. Please make sure the library is included.");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                kc.a(a, "Exception while displaying Ad: ", context);
            }
            return;
        }
        obj = ((i) (obj)).e().a(context, s);
        if (obj != null) goto _L2; else goto _L1
_L1:
        context = new v(context, viewgroup, s);
_L4:
        context.r();
        return;
_L2:
        context = ((Context) (obj));
        if (viewgroup == ((v) (obj)).g()) goto _L4; else goto _L3
_L3:
        kc.b(a, "An ad must be displayed with the same context and viewGroup as the fetch.");
        return;
    }

    public static void enableTestAds(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kc.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            j.a().a(flag);
            return;
        }
    }

    public static void fetchAd(Context context, String s, ViewGroup viewgroup, FlurryAdSize flurryadsize)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kc.b(a, "Device SDK Version older than 10");
            return;
        }
        if (jo.a() == null)
        {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        }
        if (context == null)
        {
            kc.b(a, "Context passed to fetchAd was null.");
            return;
        }
        if (s == null)
        {
            kc.b(a, "Ad space name passed to fetchAd was null.");
            return;
        }
        if (s.length() == 0)
        {
            kc.b(a, "Ad space name passed to fetchAd was empty.");
            return;
        }
        if (viewgroup == null)
        {
            kc.b(a, "ViewGroup passed to fetchAd was null.");
            return;
        }
        if (flurryadsize == null)
        {
            kc.b(a, "FlurryAdSize passed to fetchAd was null.");
            return;
        }
        flurryadsize = i.a();
        if (flurryadsize == null)
        {
            try
            {
                kc.b(a, "Could not find FlurryAds module. Please make sure the library is included.");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                kc.a(a, "Exception while fetching Ad: ", context);
            }
            return;
        }
        v v1 = flurryadsize.e().a(context, s);
        if (v1 != null) goto _L2; else goto _L1
_L1:
        flurryadsize = new v(context, viewgroup, s);
_L4:
        flurryadsize.q();
        return;
_L2:
        flurryadsize = v1;
        if (viewgroup == v1.g()) goto _L4; else goto _L3
_L3:
        v1.a();
        flurryadsize = new v(context, viewgroup, s);
          goto _L4
    }

    public static boolean getAd(Context context, String s, ViewGroup viewgroup, FlurryAdSize flurryadsize, long l)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kc.b(a, "Device SDK Version older than 10");
            return false;
        }
        if (jo.a() == null)
        {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        }
        if (context == null)
        {
            kc.b(a, "Context passed to getAd was null.");
            return false;
        }
        if (s == null)
        {
            kc.b(a, "Ad space name passed to getAd was null.");
            return false;
        }
        if (s.length() == 0)
        {
            kc.b(a, "Ad space name passed to getAd was empty.");
            return false;
        }
        if (viewgroup == null)
        {
            kc.b(a, "ViewGroup passed to getAd was null.");
            return false;
        }
        if (flurryadsize == null)
        {
            kc.b(a, "FlurryAdSize passed to getAd was null.");
            return false;
        }
        if (Looper.getMainLooper().getThread() != Thread.currentThread())
        {
            kc.b(a, "getAd must be called from UI thread.");
            return false;
        }
        try
        {
            flurryadsize = i.a();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            kc.a(a, "Exception while getting Ad : ", context);
            return false;
        }
        if (flurryadsize != null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        kc.b(a, "Could not find FlurryAds module. Please make sure the library is included.");
        return false;
        v v1 = flurryadsize.e().a(context, s);
        if (v1 != null) goto _L2; else goto _L1
_L1:
        flurryadsize = new v(context, viewgroup, s);
_L5:
        return flurryadsize.s();
_L2:
        if (context != v1.f()) goto _L4; else goto _L3
_L3:
        flurryadsize = v1;
        if (viewgroup == v1.g()) goto _L5; else goto _L4
_L4:
        v1.a();
        flurryadsize = new v(context, viewgroup, s);
          goto _L5
    }

    public static void initializeAds(Context context)
    {
    }

    public static boolean isAdAvailable(Context context, String s, FlurryAdSize flurryadsize, long l)
    {
        if (android.os.Build.VERSION.SDK_INT >= 10) goto _L2; else goto _L1
_L1:
        kc.b(a, "Device SDK Version older than 10");
_L4:
        return false;
_L2:
        if (jo.a() == null)
        {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        }
        if (context == null)
        {
            kc.b(a, "Context passed to isAdAvailable was null.");
            return false;
        }
        if (s == null)
        {
            kc.b(a, "Ad space name passed to isAdAvailable was null.");
            return false;
        }
        if (s.length() == 0)
        {
            kc.b(a, "Ad space name passed to isAdAvailable was empty.");
            return false;
        }
        if (flurryadsize == null)
        {
            kc.b(a, "FlurryAdSize passed to isAdAvailable was null.");
            return false;
        }
        try
        {
            flurryadsize = i.a();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            kc.a(a, "Exception while checking Ads if available: ", context);
            return false;
        }
        if (flurryadsize != null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        kc.b(a, "Could not find FlurryAds module. Please make sure the library is included.");
        return false;
        context = flurryadsize.e().a(context, s);
        if (context == null) goto _L4; else goto _L3
_L3:
        boolean flag = context.p();
        return flag;
    }

    public static boolean isAdReady(String s)
    {
        if (android.os.Build.VERSION.SDK_INT >= 10) goto _L2; else goto _L1
_L1:
        kc.b(a, "Device SDK Version older than 10");
_L4:
        return false;
_L2:
        i k;
        if (jo.a() == null)
        {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        }
        if (s == null)
        {
            kc.b(a, "Ad space name passed to isAdReady was null.");
            return false;
        }
        if (s.length() == 0)
        {
            kc.b(a, "Ad space name passed to isAdReady was empty.");
            return false;
        }
        try
        {
            k = i.a();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            kc.a(a, "Exception while checking Ads if ready: ", s);
            return false;
        }
        if (k != null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        kc.b(a, "Could not find FlurryAds module. Please make sure the library is included.");
        return false;
        s = k.e().a(s);
        if (s == null) goto _L4; else goto _L3
_L3:
        boolean flag = s.p();
        return flag;
    }

    public static void removeAd(Context context, String s, ViewGroup viewgroup)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kc.b(a, "Device SDK Version older than 10");
            return;
        }
        if (jo.a() == null)
        {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        }
        if (context == null)
        {
            kc.b(a, "Context passed to removeAd was null.");
            return;
        }
        if (s == null)
        {
            kc.b(a, "Ad space name passed to removeAd was null.");
            return;
        }
        if (s.length() == 0)
        {
            kc.b(a, "Ad space name passed to removeAd was empty.");
            return;
        }
        if (viewgroup == null)
        {
            kc.b(a, "ViewGroup passed to removeAd was null.");
            return;
        }
        viewgroup = i.a();
        if (viewgroup == null)
        {
            try
            {
                kc.b(a, "Could not find FlurryAds module. Please make sure the library is included.");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                kc.a(a, "Exception while removing Ad: ", context);
            }
            return;
        }
        viewgroup.e().b(context, s);
        return;
    }

    public static void setAdListener(FlurryAdListener flurryadlistener)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kc.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            j.a().a(flurryadlistener);
            return;
        }
    }

    public static void setCustomAdNetworkHandler(ICustomAdNetworkHandler icustomadnetworkhandler)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kc.b(a, "Device SDK Version older than 10");
            return;
        }
        if (icustomadnetworkhandler == null)
        {
            kc.b(a, "ICustomAdNetworkHandler passed to setCustomAdNetworkHandler was null.");
            return;
        } else
        {
            j.a().a(icustomadnetworkhandler);
            return;
        }
    }

    public static void setLocation(float f, float f1)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kc.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            Location location = new Location("Explicit");
            location.setLatitude(f);
            location.setLongitude(f1);
            lg.a().a("ExplicitLocation", location);
            return;
        }
    }

    public static void setTargetingKeywords(Map map)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kc.b(a, "Device SDK Version older than 10");
        } else
        {
            if (map == null)
            {
                kc.b(a, "targetingKeywords Map passed to setTargetingKeywords was null.");
                return;
            }
            if (map != null)
            {
                j.a().b(map);
                return;
            }
        }
    }

    public static void setUserCookies(Map map)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kc.b(a, "Device SDK Version older than 10");
            return;
        }
        if (map == null)
        {
            kc.b(a, "userCookies Map passed to setUserCookies was null.");
            return;
        } else
        {
            j.a().a(map);
            return;
        }
    }

}
