// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import android.graphics.PixelFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ad, bo

public class at
{
    class a
    {

        final at a;

        public String a()
        {
            return Build.MANUFACTURER;
        }

        a()
        {
            a = at.this;
            super();
        }
    }


    private static at E = new at();
    public String A;
    public String B;
    public String C;
    public int D;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public String h;
    public String i;
    public int j;
    public int k;
    public String l;
    public int m;
    public long n;
    public long o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public List t;
    public String u;
    public String v;
    public String w;
    public boolean x;
    public String y;
    public String z;

    private at()
    {
        Object obj;
        Object obj1;
        Object obj2;
        f = "";
        g = false;
        i = "";
        w = "";
        z = "";
        A = "";
        C = "";
        D = 0;
        obj = ad.v();
        obj1 = Executors.newSingleThreadExecutor();
        obj2 = ((ExecutorService) (obj1)).submit(new Callable() {

            final at a;

            public Map a()
                throws Exception
            {
                if (android.os.Build.VERSION.SDK_INT <= 8)
                {
                    break MISSING_BLOCK_LABEL_144;
                }
                int i1;
                Class.forName("com.google.android.gms.common.GooglePlayServicesUtil");
                i1 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(ad.v());
                if (i1 != 0)
                {
                    break MISSING_BLOCK_LABEL_144;
                }
                Object obj3 = AdvertisingIdClient.getAdvertisingIdInfo(ad.v());
                if (obj3 == null)
                {
                    break MISSING_BLOCK_LABEL_144;
                }
                Object obj5;
                boolean flag1;
                obj5 = ((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj3)).getId();
                flag1 = ((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj3)).isLimitAdTrackingEnabled();
                if (obj5 == null) goto _L2; else goto _L1
_L1:
                if (((String) (obj5)).length() <= 0) goto _L2; else goto _L3
_L3:
                obj3 = obj5;
_L8:
                if (obj5 == null)
                {
                    break MISSING_BLOCK_LABEL_115;
                }
                if (((String) (obj5)).length() <= 0)
                {
                    break MISSING_BLOCK_LABEL_115;
                }
_L4:
                obj5 = new HashMap();
                ((Map) (obj5)).put("udid", obj3);
                ((Map) (obj5)).put("optOut_Ad", new Boolean(flag1));
                return ((Map) (obj5));
_L2:
                obj3 = "";
                continue; /* Loop/switch isn't completed */
                flag1 = false;
                  goto _L4
                Object obj4;
                obj4;
                ad.d((new StringBuilder()).append("Google Play Services Client Library is not included exception: ").append(obj4).toString());
_L6:
                return null;
                obj4;
                continue; /* Loop/switch isn't completed */
                obj4;
                continue; /* Loop/switch isn't completed */
                obj4;
                continue; /* Loop/switch isn't completed */
                obj4;
                continue; /* Loop/switch isn't completed */
                obj4;
                if (true) goto _L6; else goto _L5
_L5:
                if (true) goto _L8; else goto _L7
_L7:
            }

            public Object call()
                throws Exception
            {
                return a();
            }

            
            {
                a = at.this;
                super();
            }
        });
        obj2 = (Map)((Future) (obj2)).get(1000L, TimeUnit.MILLISECONDS);
        if (obj2 != null)
        {
            try
            {
                f = (String)((Map) (obj2)).get("udid");
                g = ((Boolean)((Map) (obj2)).get("optOut_Ad")).booleanValue();
            }
            catch (TimeoutException timeoutexception)
            {
                timeoutexception.printStackTrace();
                ((ExecutorService) (obj1)).shutdown();
                if (E == null)
                {
                    f = "";
                    g = false;
                } else
                {
                    f = E.f;
                    g = E.g;
                }
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
            catch (ExecutionException executionexception)
            {
                executionexception.printStackTrace();
            }
        }
        ((ExecutorService) (obj1)).shutdown();
        h = ad.p();
        a = ad.y();
        if (ad.q() >= 4)
        {
            b = (new a()).a();
        } else
        {
            b = "Android";
        }
        y = TimeZone.getDefault().getID();
        obj1 = (TelephonyManager)((Context) (obj)).getSystemService("phone");
        u = ((TelephonyManager) (obj1)).getSimCountryIso();
        if (u == null)
        {
            u = "";
        }
        v = ((TelephonyManager) (obj1)).getNetworkCountryIso();
        if (v == null)
        {
            v = "";
        }
        if (u == null || u.length() <= 0) goto _L2; else goto _L1
_L1:
        w = u;
_L15:
        if (((TelephonyManager) (obj1)).getSimState() == 5)
        {
            l = ((TelephonyManager) (obj1)).getSimOperatorName();
        }
        if (l == null || l.length() == 0)
        {
            l = ((TelephonyManager) (obj1)).getNetworkOperatorName();
            if (l == null)
            {
                l = "";
            }
        }
        obj2 = ((TelephonyManager) (obj1)).getSimOperator();
        if (obj2 == null) goto _L4; else goto _L3
_L3:
        if (((String) (obj2)).length() <= 0) goto _L4; else goto _L5
_L5:
        z = ((String) (obj2)).substring(0, 3);
        A = ((String) (obj2)).substring(3);
_L11:
        String s1;
        Exception exception;
        boolean flag;
        if (((TelephonyManager) (obj1)).getPhoneType() == 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        x = flag;
        B = ad.n;
        if (B == null)
        {
            B = "";
        }
        c = Build.MODEL;
        if (c == null)
        {
            c = "";
        }
        d = "Android OS";
        e = android.os.Build.VERSION.RELEASE;
        if (e == null)
        {
            e = "";
        }
        obj1 = ((ConnectivityManager)((Context) (obj)).getSystemService("connectivity")).getActiveNetworkInfo();
        if (obj1 == null) goto _L7; else goto _L6
_L6:
        if (((NetworkInfo) (obj1)).getTypeName().compareToIgnoreCase("WIFI") != 0) goto _L9; else goto _L8
_L8:
        i = "wifi";
        C = "";
_L7:
        obj = ((WindowManager)((Context) (obj)).getSystemService("window")).getDefaultDisplay();
        obj1 = new DisplayMetrics();
        ((Display) (obj)).getMetrics(((DisplayMetrics) (obj1)));
        j = Math.round(((DisplayMetrics) (obj1)).widthPixels);
        k = Math.round(((DisplayMetrics) (obj1)).heightPixels);
        obj1 = new PixelFormat();
        PixelFormat.getPixelFormatInfo(((Display) (obj)).getPixelFormat(), ((PixelFormat) (obj1)));
        m = ((PixelFormat) (obj1)).bitsPerPixel;
        n = Runtime.getRuntime().freeMemory();
        o = d();
        p = 0;
        q = c();
        r = e();
        D = bo.a();
        s = false;
        t = new ArrayList();
        return;
_L2:
        if (v != null && v.length() > 0)
        {
            w = v;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        s1 = ((TelephonyManager) (obj1)).getNetworkOperator();
        if (s1 == null) goto _L11; else goto _L10
_L10:
        if (s1.length() <= 0) goto _L11; else goto _L12
_L12:
        z = s1.substring(0, 3);
        A = s1.substring(3);
          goto _L11
        exception;
        ad.d((new StringBuilder()).append("Exception fetch mcc,mnc:").append(exception).toString());
          goto _L11
_L9:
        if (((NetworkInfo) (obj1)).getTypeName().compareToIgnoreCase("MOBILE") == 0)
        {
            i = "cellular";
            switch (((NetworkInfo) (obj1)).getSubtype())
            {
            default:
                C = "";
                break;

            case 1: // '\001'
            case 2: // '\002'
            case 4: // '\004'
            case 7: // '\007'
            case 11: // '\013'
                C = "2g";
                break;

            case 3: // '\003'
            case 5: // '\005'
            case 6: // '\006'
            case 8: // '\b'
            case 9: // '\t'
            case 10: // '\n'
            case 12: // '\f'
            case 14: // '\016'
            case 15: // '\017'
                C = "3g";
                break;

            case 13: // '\r'
                C = "4g";
                break;
            }
        } else
        if (((NetworkInfo) (obj1)).getTypeName() != null)
        {
            i = ((NetworkInfo) (obj1)).getTypeName().toLowerCase();
            C = "";
        }
        if (true) goto _L7; else goto _L13
_L13:
        if (true) goto _L15; else goto _L14
_L14:
    }

    public static at a()
    {
        if (E != null) goto _L2; else goto _L1
_L1:
        com/tremorvideo/sdk/android/videoad/at;
        JVM INSTR monitorenter ;
        E = new at();
        com/tremorvideo/sdk/android/videoad/at;
        JVM INSTR monitorexit ;
_L4:
        return E;
        Exception exception;
        exception;
        com/tremorvideo/sdk/android/videoad/at;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        E.f();
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static at b()
    {
        return E;
    }

    private boolean c()
    {
        boolean flag = false;
        Object obj;
        try
        {
            obj = ad.v().getSystemService("sensor");
        }
        catch (Exception exception)
        {
            return false;
        }
        if (obj != null)
        {
            flag = true;
        }
        return flag;
    }

    private long d()
    {
        StatFs statfs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        return (long)Math.abs(statfs.getFreeBlocks() * statfs.getBlockSize());
    }

    private boolean e()
    {
        boolean flag = false;
        Object obj;
        try
        {
            obj = ad.v().getSystemService("location");
        }
        catch (Exception exception)
        {
            return false;
        }
        if (obj != null)
        {
            flag = true;
        }
        return flag;
    }

    private void f()
    {
        D = bo.a();
    }

}
