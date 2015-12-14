// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.pm.PackageManager;
import com.flurry.android.FlurryAgent;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.model.res.ShareButtonInfo;
import com.wantu.model.res.TResInfo;
import java.util.HashMap;
import java.util.Map;

public class apq
{

    public static String a = axw.g(InstaBeautyApplication.a().b());
    public static ShareButtonInfo c = null;
    public static String d = "TextFont";
    public static String e = "TextColor";
    public static String f = "TextImage";
    public static String g = "TextStyle";
    private static apq h = null;
    public TResInfo b;
    private TPhotoMagComposeManager i;

    public apq()
    {
        b = null;
        i = null;
    }

    public static void a(int j)
    {
        String s = "Chinese";
        if (!yp.b())
        {
            s = "English";
        }
        HashMap hashmap = new HashMap();
        hashmap.put(s, (new StringBuilder()).append("tz_").append(j).toString());
        FlurryAgent.logEvent("TieZhi_RealUse", hashmap);
    }

    public static void a(String s)
    {
        String s1 = "Chinese";
        if (!yp.b())
        {
            s1 = "English";
        }
        HashMap hashmap = new HashMap();
        hashmap.put(s1, s);
        FlurryAgent.logEvent("ProEdit_RealUse", hashmap);
    }

    public static void a(String s, String s1)
    {
        String s2 = "Chinese";
        if (!yp.b())
        {
            s2 = "English";
        }
        HashMap hashmap = new HashMap();
        hashmap.put(s2, s1);
        FlurryAgent.logEvent((new StringBuilder()).append("FontLabel_").append(s).toString(), hashmap);
    }

    public static void a(String s, String s1, String s2, String s3)
    {
        String s4 = "Chinese";
        if (!yp.b())
        {
            s4 = "English";
        }
        HashMap hashmap = new HashMap();
        hashmap.put("langurage", s4);
        if (s != null)
        {
            hashmap.put("textColor", s);
        }
        if (s1 != null)
        {
            hashmap.put("textImage", s1);
        }
        if (s2 != null)
        {
            hashmap.put("textStyle", s2);
        }
        if (s3 != null)
        {
            hashmap.put("textFont", s3);
        }
        FlurryAgent.logEvent("FontLabel_RealUse", hashmap);
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
        if (!yp.b())
        {
            s = "English";
        }
        HashMap hashmap = new HashMap();
        hashmap.put(s, (new StringBuilder()).append("slimcount_").append(j).toString());
        FlurryAgent.logEvent("slim_count", hashmap);
    }

    public static boolean b()
    {
        return true;
    }

    public static apq c()
    {
        if (h != null) goto _L2; else goto _L1
_L1:
        apq;
        JVM INSTR monitorenter ;
        if (h == null)
        {
            h = new apq();
        }
        apq;
        JVM INSTR monitorexit ;
_L2:
        return h;
        Exception exception;
        exception;
        apq;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public TPhotoMagComposeManager d()
    {
        if (i == null)
        {
            i = new TPhotoMagComposeManager();
        }
        return i;
    }

}
