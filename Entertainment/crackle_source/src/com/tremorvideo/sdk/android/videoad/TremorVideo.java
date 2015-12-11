// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import com.tremorvideo.sdk.android.adapter.TremorAdapterCalls;
import java.util.Map;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ad, au, aa, Playvideo, 
//            AdViewManager, Settings

public class TremorVideo
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a e[];
        private String d;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/tremorvideo/sdk/android/videoad/TremorVideo$a, s);
        }

        public static a[] values()
        {
            return (a[])e.clone();
        }

        public String toString()
        {
            return d;
        }

        static 
        {
            a = new a("Default", 0, "Default");
            b = new a("AppStart", 1, "App Start");
            c = new a("PreRoll", 2, "Pre Roll");
            e = (new a[] {
                a, b, c
            });
        }

        private a(String s, int i, String s1)
        {
            super(s, i);
            d = s1;
        }
    }


    public static boolean _Initialized = false;
    private static Context a = null;
    private static long b = 0L;

    public TremorVideo()
    {
    }

    public static void destroy()
    {
        if (!_Initialized)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        ad.C();
        ad.b();
        _Initialized = false;
        a = null;
        b = 0L;
        return;
        Exception exception;
        exception;
    }

    public static double getAdDuration()
    {
        if (isAdReady())
        {
            return (double)TremorAdapterCalls.getAdDuration();
        } else
        {
            return -1D;
        }
    }

    public static double getPlayheadTime()
    {
        if (isAdReady())
        {
            return (double)TremorAdapterCalls.getPlayHeadMS();
        } else
        {
            return -1D;
        }
    }

    public static String getSDKVersion()
    {
        return ad.y();
    }

    public static void handleAnalyticsEvent(Activity activity, String s)
    {
        if (_Initialized)
        {
            ad.a(activity, s);
            return;
        } else
        {
            ad.d("Unable to send event until Tremor has been initialized");
            return;
        }
    }

    public static void handleAnalyticsEvent(Activity activity, String s, Map map)
    {
        if (_Initialized)
        {
            ad.a(activity, s, map);
            return;
        } else
        {
            ad.d("Unable to send event until Tremor has been initialized");
            return;
        }
    }

    public static void handleAnalyticsStateChange(Activity activity, String s)
    {
        if (_Initialized)
        {
            ad.b(activity, s);
            return;
        } else
        {
            ad.d("Unable to send event until Tremor has been initialized");
            return;
        }
    }

    public static void initialize(Context context, String s)
    {
        if (!_Initialized)
        {
            a = context;
            ad.a(context, new String[] {
                s
            });
            b = 0L;
        }
    }

    public static void initialize(Context context, String as[])
    {
        if (!_Initialized)
        {
            a = context;
            ad.a(context, as);
            b = 0L;
        }
    }

    public static boolean isAdReady()
    {
        boolean flag = true;
        if (!_Initialized)
        {
            flag = false;
        } else
        if (ad.e != 1)
        {
            return isAdReady(ad.o());
        }
        return flag;
    }

    public static boolean isAdReady(String s)
    {
        boolean flag = true;
        if (!_Initialized)
        {
            flag = false;
        } else
        if (ad.e != 1)
        {
            return ad.A().a(s);
        }
        return flag;
    }

    public static boolean isDownloadStarted()
    {
        if (!_Initialized)
        {
            return false;
        } else
        {
            String s = ad.o();
            return ad.A().g(s);
        }
    }

    public static boolean isManualAdReady()
    {
        boolean flag = true;
        if (!_Initialized)
        {
            flag = false;
        } else
        if (ad.e != 1)
        {
            return isManualAdReady(ad.o());
        }
        return flag;
    }

    public static boolean isManualAdReady(String s)
    {
        boolean flag = true;
        if (!_Initialized)
        {
            flag = false;
        } else
        if (ad.e != 1)
        {
            return ad.A().c(s);
        }
        return flag;
    }

    public static void registerAvailableImpression(Activity activity)
    {
        if (_Initialized)
        {
            registerAvailableImpression(ad.o(), activity);
        }
    }

    public static void registerAvailableImpression(String s, Activity activity)
    {
        long l;
        if (_Initialized)
        {
            if ((l = ad.D()) - b >= 2000L)
            {
                au au1 = ad.A();
                au1.f(s);
                ad.d("Sending Avail...");
                b = l;
                aa.a(activity, au1.g());
                return;
            }
        }
    }

    public static boolean showAd(Activity activity, int i)
        throws Exception
    {
        ad.d("TremorDebug: TremorVideo.ShowAd - Starting");
        if (!_Initialized)
        {
            ad.d(" TremorDebug: TremorVideo.ShowAd - not initialized return false");
            return false;
        }
        if (showAd(activity, ad.o(), i))
        {
            ad.d("TremorDebug: TremorVideo.ShowAd - return true");
            return true;
        } else
        {
            ad.d("TremorDebug: TremorVideo.ShowAd - return false");
            return false;
        }
    }

    public static boolean showAd(Activity activity, String s, int i)
        throws Exception
    {
        ad.d("TremorDebug: showAd - start");
        if (_Initialized) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        au au1 = ad.A();
        if (ad.e != 1) goto _L4; else goto _L3
_L3:
        if (au1.a(s))
        {
            if (!au1.e(s))
            {
                ad.d("TremorDebug: startAd - startAdView returned false. Throw an exception");
                throw new Exception("An ad has already been started.");
            }
            ad.d("TremorDebug: startAd - returned true. Start the play video activity");
            ad.d((new StringBuilder()).append("Starting ad for: ").append(s).toString());
            s = new Intent(a, com/tremorvideo/sdk/android/videoad/Playvideo);
            s.putExtra("tremorVideoType", "ad");
            try
            {
                ad.d("TremorDebug: startAd - starting activity");
                activity.startActivityForResult(s, i);
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                ad.d("TremorDebug: startAd - Exception starting activity");
                throw new Exception("Unable to create the ad intent. Make sure you add the 'com.tremorvideo.sdk.android.videoad.Playvideo' activity to your AndroiManifest.xml.");
            }
        } else
        {
            int j = (int)(Math.random() * 100D);
            if (j > ad.i)
            {
                ad.d((new StringBuilder()).append("Throttle: ").append(j).append(" / ").append(ad.i).append("  Skipping ad request").toString());
                return false;
            }
            ad.d((new StringBuilder()).append("Throttle: ").append(j).append(" / ").append(ad.i).append("  Requesting Ad").toString());
            s = new Intent(a, com/tremorvideo/sdk/android/videoad/Playvideo);
            s.putExtra("tremorVideoType", "adProgress");
            try
            {
                ad.d("TremorDebug: showAd - starting activity");
                activity.startActivityForResult(s, i);
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                ad.d("TremorDebug: showAd - Exception starting activity");
                throw new Exception("Unable to create the ad intent. Make sure you add the 'com.tremorvideo.sdk.android.videoad.Playvideo' activity to your AndroiManifest.xml.");
            }
        }
_L5:
        return true;
_L4:
label0:
        {
            if (au1.a(s))
            {
                break label0;
            }
            ad.d("TremorDebug: startAd - start");
            au1.f(s);
            long l = ad.D();
            if (l - b >= 2000L)
            {
                ad.d("Sending Avail...");
                b = l;
                aa.a(activity, au1.g());
                return false;
            }
        }
          goto _L1
        ad.d("TremorDebug: startAd - calling startAdView");
        if (!au1.e(s))
        {
            ad.d("TremorDebug: startAd - startAdView returned false. Throw an exception");
            throw new Exception("An ad has already been started.");
        }
        ad.d("TremorDebug: startAd - returned true. Start the play video activity");
        ad.d((new StringBuilder()).append("Starting ad for: ").append(s).toString());
        s = new Intent(a, com/tremorvideo/sdk/android/videoad/Playvideo);
        s.putExtra("tremorVideoType", "ad");
        try
        {
            ad.d("TremorDebug: startAd - starting activity");
            activity.startActivityForResult(s, i);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            ad.d("TremorDebug: startAd - Exception starting activity");
            throw new Exception("Unable to create the ad intent. Make sure you add the 'com.tremorvideo.sdk.android.videoad.Playvideo' activity to your AndroiManifest.xml.");
        }
          goto _L5
    }

    public static AdViewManager showAdManual(Activity activity, ViewGroup viewgroup)
        throws Exception
    {
        if (!_Initialized)
        {
            return null;
        } else
        {
            return showAdManual(activity, ad.o(), viewgroup);
        }
    }

    public static AdViewManager showAdManual(Activity activity, String s, ViewGroup viewgroup)
        throws Exception
    {
        if (!_Initialized)
        {
            return null;
        }
        au au1 = ad.A();
        if (ad.e == 1)
        {
            if (au1.c(s))
            {
                if (!au1.e(s))
                {
                    throw new Exception("An ad has already been started.");
                } else
                {
                    return new AdViewManager(activity, viewgroup, au1.f());
                }
            } else
            {
                return new AdViewManager(activity, viewgroup, null);
            }
        }
        if (!au1.c(s))
        {
            au1.f(s);
            long l = ad.D();
            if (l - b >= 2000L)
            {
                ad.d("Sending Avail...");
                b = l;
                aa.a(activity, au1.g());
            }
            return null;
        }
        if (!au1.e(s))
        {
            throw new Exception("An ad has already been started.");
        } else
        {
            return new AdViewManager(activity, viewgroup, au1.f());
        }
    }

    public static boolean showVASTAd(Activity activity, String s, int i)
        throws Exception
    {
        return showVASTAd(activity, s, i, 0, true);
    }

    public static boolean showVASTAd(Activity activity, String s, int i, int j)
        throws Exception
    {
        return showVASTAd(activity, s, i, j, true);
    }

    public static boolean showVASTAd(Activity activity, String s, int i, int j, boolean flag)
        throws Exception
    {
        a = activity;
        ad.a = a;
        ad.o = null;
        if (s != null && s.length() > 0 && URLUtil.isValidUrl(s))
        {
            Intent intent = new Intent(a, com/tremorvideo/sdk/android/videoad/Playvideo);
            intent.putExtra("tremorVideoType", "ad");
            intent.putExtra("vastURL", s);
            intent.putExtra("skipDelaySeconds", j);
            intent.putExtra("bWaterMark", flag);
            try
            {
                ad.d("TremorDebug: showVASTAd - starting activity");
                activity.startActivityForResult(intent, i);
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                ad.d("TremorDebug: showVASTAd - Exception starting activity");
                throw new Exception("Unable to create the ad intent. Make sure you add the 'com.tremorvideo.sdk.android.videoad.Playvideo' activity to your AndroiManifest.xml.");
            }
            return true;
        } else
        {
            ad.d("TremorDebug: showVASTAd - Not a valid VAST URL");
            return false;
        }
    }

    public static boolean showVASTAd(Activity activity, String s, int i, boolean flag)
        throws Exception
    {
        return showVASTAd(activity, s, i, 0, flag);
    }

    public static void start()
    {
        if (!_Initialized)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        ad.B();
        if (ad.d && (!ad.j || ad.e != 0)) goto _L2; else goto _L1
_L1:
        ad.A().a(false);
_L4:
        return;
_L2:
        if (ad.j) goto _L4; else goto _L3
_L3:
        ad.k = true;
        return;
        ad.k = true;
        return;
    }

    public static void stop()
    {
        if (!_Initialized)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        ad.C();
        if (!ad.d || ad.j && ad.e == 0)
        {
            ad.A().c();
        }
        return;
        Exception exception;
        exception;
    }

    public static void updateSettings(Settings settings)
    {
        if (_Initialized)
        {
            ad.a(settings);
            return;
        } else
        {
            ad.l = settings;
            return;
        }
    }

}
