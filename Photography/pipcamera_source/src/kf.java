// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.model.res.TResInfo;
import java.util.HashMap;
import java.util.Map;

public class kf
{

    public static String a = pb.h(PIPCameraApplication.b().c());
    public static String b = "http://ad.apps.fm/YyEDSG_OXxJKhkGXO8dkH65px440Px0vtrw1ww5B54xC6wkBpLo2DgJzhrASYnVl5iDa0Ctro7z0cWq4V7V3Jg";
    public static String c = "http://ad.apps.fm/lPPSA_B5fHuGQMSIR6hUA65px440Px0vtrw1ww5B54ywoOdRRKpcbxv_JVGwGM37659dXsX8iE4jKVDkG6GSig";
    public static String d = "http://ad.apps.fm/NvvuFcXzEMeN6nNK_Dp1dK5px440Px0vtrw1ww5B54zHVRDxcXYB5iUtrTjML8EyaB7ZgL-Ty63g329o22TcMf342emEw_IuVrm3SN_AUQg";
    public static String e = "http://ad.apps.fm/IWGwnASr_ylPuwIKfDBoVa5px440Px0vtrw1ww5B54zHVRDxcXYB5iUtrTjML8EyaB7ZgL-Ty63g329o22TcMbe-6S8M2QkHhyXcYGVgHeY";
    private static kf g = null;
    public TResInfo f;
    private TPhotoMagComposeManager h;
    private yf i;

    public kf()
    {
        h = null;
        f = null;
        i = null;
        h = new TPhotoMagComposeManager();
    }

    public static void a(int j)
    {
        String s = "Chinese";
        if (!ew.b())
        {
            s = "English";
        }
        HashMap hashmap = new HashMap();
        hashmap.put(s, (new StringBuilder()).append("pip1_").append(j).toString());
        FlurryAgent.logEvent("Pip_RealUseID", hashmap);
    }

    public static void a(String s)
    {
        String s1 = "Chinese";
        if (!ew.b())
        {
            s1 = "English";
        }
        HashMap hashmap = new HashMap();
        hashmap.put(s1, (new StringBuilder()).append("pip2_").append(s).toString());
        FlurryAgent.logEvent("Pip2_RealUse", hashmap);
    }

    public static boolean a()
    {
        return true;
    }

    public static boolean a(Context context, String s)
    {
        if (s != null)
        {
            try
            {
                context = context.getPackageManager().getPackageInfo(s, 0);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                Crashlytics.logException(context);
                context = null;
            }
            if (context != null)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean a(Class class1, String s)
    {
        if (!s.endsWith(":")) goto _L2; else goto _L1
_L1:
        s = s.split(":")[0];
        try
        {
            class1 = class1.getDeclaredMethod(s, new Class[] {
                java/lang/String
            });
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1.printStackTrace();
            return false;
        }
        if (class1 == null) goto _L4; else goto _L3
_L3:
        return true;
_L2:
        try
        {
            class1 = class1.getClass().getDeclaredMethod(s, new Class[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1.printStackTrace();
            return false;
        }
        if (class1 != null) goto _L3; else goto _L4
_L4:
        return false;
    }

    public static void b(int j)
    {
        String s = "Chinese";
        if (!ew.b())
        {
            s = "English";
        }
        HashMap hashmap = new HashMap();
        hashmap.put(s, (new StringBuilder()).append("tz_").append(j).toString());
        FlurryAgent.logEvent("TieZhi_RealUse", hashmap);
    }

    public static void b(String s)
    {
        String s1 = "Chinese";
        if (!ew.b())
        {
            s1 = "English";
        }
        HashMap hashmap = new HashMap();
        hashmap.put(s1, s);
        FlurryAgent.logEvent("ProEdit_RealUse", hashmap);
    }

    public static boolean b()
    {
        return true;
    }

    public static kf c()
    {
        if (g != null) goto _L2; else goto _L1
_L1:
        kf;
        JVM INSTR monitorenter ;
        if (g == null)
        {
            g = new kf();
        }
        kf;
        JVM INSTR monitorexit ;
_L2:
        return g;
        Exception exception;
        exception;
        kf;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void c(String s)
    {
        String s1 = "Chinese";
        if (!ew.b())
        {
            s1 = "English";
        }
        HashMap hashmap = new HashMap();
        hashmap.put(s1, s);
        FlurryAgent.logEvent("Collage_Show", hashmap);
    }

    public static void d(String s)
    {
        String s1 = "Chinese";
        if (!ew.b())
        {
            s1 = "English";
        }
        HashMap hashmap = new HashMap();
        hashmap.put(s1, s);
        FlurryAgent.logEvent("Collage_Bg_Selected", hashmap);
    }

    public static void e(String s)
    {
        String s1 = "Chinese";
        if (!ew.b())
        {
            s1 = "English";
        }
        HashMap hashmap = new HashMap();
        hashmap.put(s1, s);
        FlurryAgent.logEvent("Collage_Model_Selected", hashmap);
    }

    public yf d()
    {
        if (i == null)
        {
            i = new yf();
        }
        return i;
    }

    public TPhotoMagComposeManager e()
    {
        if (h == null)
        {
            h = new TPhotoMagComposeManager();
        }
        return h;
    }

    public int f()
    {
        char c2 = '\u0264';
        float f1 = PIPCameraApplication.a.getResources().getDisplayMetrics().widthPixels;
        char c1 = c2;
        if (f1 > 960F)
        {
            c1 = c2;
            if (PIPCameraApplication.c >= 64)
            {
                c1 = c2;
                if (gb.c())
                {
                    char c3 = '\u03C0';
                    c1 = c3;
                    if (f1 > 1080F)
                    {
                        c1 = c3;
                        if (PIPCameraApplication.c >= 256)
                        {
                            c1 = c3;
                            if (gb.g())
                            {
                                c1 = '\u0500';
                            }
                        }
                    }
                }
            }
        }
        return c1;
    }

}
