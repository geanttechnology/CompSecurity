// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.view.ViewGroup;
import com.flurry.sdk.fp;
import com.flurry.sdk.gd;
import com.flurry.sdk.hg;
import com.flurry.sdk.i;
import com.flurry.sdk.j;
import com.flurry.sdk.u;
import com.flurry.sdk.v;
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
            gd.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            hg.a().a("ExplicitLocation", null);
            return;
        }
    }

    public static void clearTargetingKeywords()
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            gd.b(a, "Device SDK Version older than 10");
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
            gd.b(a, "Device SDK Version older than 10");
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
            gd.b(a, "Device SDK Version older than 10");
            return;
        }
        if (fp.a() == null)
        {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        }
        if (context == null)
        {
            gd.b(a, "Context passed to displayAd was null.");
            return;
        }
        if (s == null)
        {
            gd.b(a, "Ad space name passed to displayAd was null.");
            return;
        }
        if (s.length() == 0)
        {
            gd.b(a, "Ad space name passed to displayAd was empty.");
            return;
        }
        if (viewgroup == null)
        {
            gd.b(a, "ViewGroup passed to displayAd was null.");
            return;
        }
        Object obj = i.a();
        if (obj == null)
        {
            try
            {
                gd.b(a, "Could not find FlurryAds module. Please make sure the library is included.");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                gd.a(a, "Exception while displaying Ad: ", context);
            }
            return;
        }
        obj = ((i) (obj)).e().a(context, s);
        if (obj != null) goto _L2; else goto _L1
_L1:
        context = new u(context, viewgroup, s);
_L4:
        context.q();
        return;
_L2:
        context = ((Context) (obj));
        if (viewgroup == ((u) (obj)).f()) goto _L4; else goto _L3
_L3:
        gd.b(a, "An ad must be displayed with the same context and viewGroup as the fetch.");
        return;
    }

    public static void enableTestAds(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            gd.b(a, "Device SDK Version older than 10");
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
            gd.b(a, "Device SDK Version older than 10");
            return;
        }
        if (fp.a() == null)
        {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        }
        if (context == null)
        {
            gd.b(a, "Context passed to fetchAd was null.");
            return;
        }
        if (s == null)
        {
            gd.b(a, "Ad space name passed to fetchAd was null.");
            return;
        }
        if (s.length() == 0)
        {
            gd.b(a, "Ad space name passed to fetchAd was empty.");
            return;
        }
        if (viewgroup == null)
        {
            gd.b(a, "ViewGroup passed to fetchAd was null.");
            return;
        }
        if (flurryadsize == null)
        {
            gd.b(a, "FlurryAdSize passed to fetchAd was null.");
            return;
        }
        flurryadsize = i.a();
        if (flurryadsize == null)
        {
            try
            {
                gd.b(a, "Could not find FlurryAds module. Please make sure the library is included.");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                gd.a(a, "Exception while fetching Ad: ", context);
            }
            return;
        }
        u u1 = flurryadsize.e().a(context, s);
        if (u1 != null) goto _L2; else goto _L1
_L1:
        flurryadsize = new u(context, viewgroup, s);
_L4:
        flurryadsize.p();
        return;
_L2:
        flurryadsize = u1;
        if (viewgroup == u1.f()) goto _L4; else goto _L3
_L3:
        u1.a();
        flurryadsize = new u(context, viewgroup, s);
          goto _L4
    }

    public static boolean getAd(Context context, String s, ViewGroup viewgroup, FlurryAdSize flurryadsize, long l)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            gd.b(a, "Device SDK Version older than 10");
            return false;
        }
        if (fp.a() == null)
        {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        }
        if (context == null)
        {
            gd.b(a, "Context passed to getAd was null.");
            return false;
        }
        if (s == null)
        {
            gd.b(a, "Ad space name passed to getAd was null.");
            return false;
        }
        if (s.length() == 0)
        {
            gd.b(a, "Ad space name passed to getAd was empty.");
            return false;
        }
        if (viewgroup == null)
        {
            gd.b(a, "ViewGroup passed to getAd was null.");
            return false;
        }
        if (flurryadsize == null)
        {
            gd.b(a, "FlurryAdSize passed to getAd was null.");
            return false;
        }
        if (Looper.getMainLooper().getThread() != Thread.currentThread())
        {
            gd.b(a, "getAd must be called from UI thread.");
            return false;
        }
        try
        {
            flurryadsize = i.a();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            gd.a(a, "Exception while getting Ad : ", context);
            return false;
        }
        if (flurryadsize != null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        gd.b(a, "Could not find FlurryAds module. Please make sure the library is included.");
        return false;
        u u1 = flurryadsize.e().a(context, s);
        if (u1 != null) goto _L2; else goto _L1
_L1:
        flurryadsize = new u(context, viewgroup, s);
_L5:
        return flurryadsize.r();
_L2:
        if (context != u1.e()) goto _L4; else goto _L3
_L3:
        flurryadsize = u1;
        if (viewgroup == u1.f()) goto _L5; else goto _L4
_L4:
        u1.a();
        flurryadsize = new u(context, viewgroup, s);
          goto _L5
    }

    public static void initializeAds(Context context)
    {
    }

    public static boolean isAdAvailable(Context context, String s, FlurryAdSize flurryadsize, long l)
    {
        if (android.os.Build.VERSION.SDK_INT >= 10) goto _L2; else goto _L1
_L1:
        gd.b(a, "Device SDK Version older than 10");
_L4:
        return false;
_L2:
        if (fp.a() == null)
        {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        }
        if (context == null)
        {
            gd.b(a, "Context passed to isAdAvailable was null.");
            return false;
        }
        if (s == null)
        {
            gd.b(a, "Ad space name passed to isAdAvailable was null.");
            return false;
        }
        if (s.length() == 0)
        {
            gd.b(a, "Ad space name passed to isAdAvailable was empty.");
            return false;
        }
        if (flurryadsize == null)
        {
            gd.b(a, "FlurryAdSize passed to isAdAvailable was null.");
            return false;
        }
        try
        {
            flurryadsize = i.a();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            gd.a(a, "Exception while checking Ads if available: ", context);
            return false;
        }
        if (flurryadsize != null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        gd.b(a, "Could not find FlurryAds module. Please make sure the library is included.");
        return false;
        context = flurryadsize.e().a(context, s);
        if (context == null) goto _L4; else goto _L3
_L3:
        boolean flag = context.o();
        return flag;
    }

    public static boolean isAdReady(String s)
    {
        if (android.os.Build.VERSION.SDK_INT >= 10) goto _L2; else goto _L1
_L1:
        gd.b(a, "Device SDK Version older than 10");
_L4:
        return false;
_L2:
        i k;
        if (fp.a() == null)
        {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        }
        if (s == null)
        {
            gd.b(a, "Ad space name passed to isAdReady was null.");
            return false;
        }
        if (s.length() == 0)
        {
            gd.b(a, "Ad space name passed to isAdReady was empty.");
            return false;
        }
        try
        {
            k = i.a();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            gd.a(a, "Exception while checking Ads if ready: ", s);
            return false;
        }
        if (k != null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        gd.b(a, "Could not find FlurryAds module. Please make sure the library is included.");
        return false;
        s = k.e().a(s);
        if (s == null) goto _L4; else goto _L3
_L3:
        boolean flag = s.o();
        return flag;
    }

    public static void removeAd(Context context, String s, ViewGroup viewgroup)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            gd.b(a, "Device SDK Version older than 10");
            return;
        }
        if (fp.a() == null)
        {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        }
        if (context == null)
        {
            gd.b(a, "Context passed to removeAd was null.");
            return;
        }
        if (s == null)
        {
            gd.b(a, "Ad space name passed to removeAd was null.");
            return;
        }
        if (s.length() == 0)
        {
            gd.b(a, "Ad space name passed to removeAd was empty.");
            return;
        }
        if (viewgroup == null)
        {
            gd.b(a, "ViewGroup passed to removeAd was null.");
            return;
        }
        viewgroup = i.a();
        if (viewgroup == null)
        {
            try
            {
                gd.b(a, "Could not find FlurryAds module. Please make sure the library is included.");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                gd.a(a, "Exception while removing Ad: ", context);
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
            gd.b(a, "Device SDK Version older than 10");
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
            gd.b(a, "Device SDK Version older than 10");
            return;
        }
        if (icustomadnetworkhandler == null)
        {
            gd.b(a, "ICustomAdNetworkHandler passed to setCustomAdNetworkHandler was null.");
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
            gd.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            Location location = new Location("Explicit");
            location.setLatitude(f);
            location.setLongitude(f1);
            hg.a().a("ExplicitLocation", location);
            return;
        }
    }

    public static void setTargetingKeywords(Map map)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            gd.b(a, "Device SDK Version older than 10");
        } else
        {
            if (map == null)
            {
                gd.b(a, "targetingKeywords Map passed to setTargetingKeywords was null.");
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
            gd.b(a, "Device SDK Version older than 10");
            return;
        }
        if (map == null)
        {
            gd.b(a, "userCookies Map passed to setUserCookies was null.");
            return;
        } else
        {
            j.a().a(map);
            return;
        }
    }

}
