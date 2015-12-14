// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptimize;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.apptimize:
//            ji, e9, at, b3, 
//            ApptimizeVar, dQ, bc, gF, 
//            x, aq, c3, cb, 
//            il, iK, ev, gx, 
//            d4, bu, gW, gA, 
//            b_, j, ew, ApptimizeOptions, 
//            gI, gr, aO, hK, 
//            g, gR, g_, i_, 
//            gy, s, jC, hz, 
//            iP, aj, d7, go, 
//            t, e8, v, iX, 
//            dU, by, bI, l, 
//            cf, b6, el, cp, 
//            ApptimizeExperiment, ApptimizeTest

public class Apptimize
{

    public static boolean a;
    private static Map b;
    private static dU c;
    private static Boolean d;
    private static final Object e;
    private static Map f;
    private static by g;
    private static bI h;
    private static final CountDownLatch i;
    private static boolean j;
    private static d4 k;
    private static l l;
    private static String m;
    public static int n;
    private static Map o;
    private static gx p;
    private static ji q;
    private static boolean r;
    private static cf s;
    private static b3 t;
    private static b6 u;
    private static OnExperimentRunListener v;
    private static il w;
    private static final String x[];

    private Apptimize()
    {
    }

    static ApptimizeVar a(String s1, String s2, String s3, Object obj)
    {
        s1 = new ApptimizeVar(s1, s2, s3, obj);
        return (ApptimizeVar)at.a(m, s1, new dQ(s1));
    }

    static Object a(ApptimizeVar apptimizevar, ApptimizeOptions apptimizeoptions)
    {
        Object obj = bc.c(apptimizevar);
        return at.a(m, obj, new gF(obj, apptimizevar, apptimizeoptions));
    }

    private static void a(Context context)
    {
        at.a(m, new x(context));
    }

    private static void a(Context context, String s1, el el, ApptimizeOptions apptimizeoptions)
    {
        at.a(m, new aq(s1, context, apptimizeoptions, el), x[0]);
    }

    private static void a(ApptimizeOptions apptimizeoptions, cp cp)
    {
        at.a(m, new c3(apptimizeoptions, cp));
    }

    private static void a(String s1, Object obj)
    {
        at.a(m, new cb(s1, obj));
    }

    private static boolean a()
    {
label0:
        {
            synchronized (e)
            {
                if (w == null || w.d())
                {
                    break label0;
                }
            }
            return true;
        }
        obj;
        JVM INSTR monitorexit ;
        int i1;
        try
        {
            i1 = android.os.Build.VERSION.SDK_INT;
        }
        catch (RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        return i1 < 14;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void addToMetric(String s1, double d1)
    {
        at.a(m, new iK(s1, d1));
    }

    private static Properties b(Context context)
    {
        AssetManager assetmanager = context.getAssets();
        context = new Properties();
        try
        {
            context.load(assetmanager.open(x[2]));
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            return context;
        }
        catch (IOException ioexception)
        {
            ev.k(m, x[1], ioexception);
            System.exit(0);
            return context;
        }
        return context;
    }

    static void b()
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        if (p != null)
        {
            p.m();
        }
        if (k == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        if (k.j() != null)
        {
            k.j().u();
        }
        obj1 = k.b();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        ((gW) (obj1)).j();
        obj1 = k.e();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        ((gA) (obj1)).c();
        ev.n(m, x[3]);
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static gA c()
    {
        return t.f();
    }

    public static void clearAllForcedVariants()
    {
        at.a(m, new b_());
    }

    public static void clearForcedVariant(Long long1)
    {
        at.a(m, new j(long1));
    }

    public static void clearUserAttribute(String s1)
    {
        a(s1, null);
    }

    public static void disable()
    {
        at.a(m, new ew());
    }

    public static double doubleForTest(String s1, double d1)
    {
        return doubleForTest(s1, d1, new ApptimizeOptions());
    }

    public static double doubleForTest(String s1, double d1, ApptimizeOptions apptimizeoptions)
    {
        return ((Double)at.a(m, Double.valueOf(d1), new gI(d1, s1, apptimizeoptions))).doubleValue();
    }

    public static void event(String s1)
    {
        track(s1);
    }

    public static void event(String s1, double d1)
    {
        track(s1, d1);
    }

    public static void forceVariant(Long long1)
    {
        at.a(m, new gr(long1));
    }

    public static String getExperimentString(String s1, String s2)
    {
        return stringForTest(s1, s2);
    }

    public static Map getTestInfo()
    {
        return getTestInfo(new ApptimizeOptions());
    }

    public static Map getTestInfo(ApptimizeOptions apptimizeoptions)
    {
        return (Map)at.a(m, new HashMap(), new aO(apptimizeoptions));
    }

    public static String getUserId()
    {
        return (String)at.a(m, "", new hK());
    }

    public static Map getVariants()
    {
        return getVariants(new ApptimizeOptions());
    }

    public static Map getVariants(ApptimizeOptions apptimizeoptions)
    {
        return (Map)at.a(m, new HashMap(), new g(apptimizeoptions));
    }

    public static void goalAchieved(String s1)
    {
        at.a(m, new gR(s1));
    }

    public static int integerForTest(String s1, int i1)
    {
        return integerForTest(s1, i1, new ApptimizeOptions());
    }

    public static int integerForTest(String s1, int i1, ApptimizeOptions apptimizeoptions)
    {
        return ((Integer)at.a(m, Integer.valueOf(i1), new g_(i1, s1, apptimizeoptions))).intValue();
    }

    public static void metricAchieved(String s1)
    {
        at.a(m, new i_(s1));
    }

    public static void reset()
    {
        at.a(m, new gy());
    }

    public static void runExperiment(String s1, ApptimizeExperiment apptimizeexperiment)
    {
        runTest(s1, apptimizeexperiment);
    }

    public static void runTest(String s1, ApptimizeTest apptimizetest)
    {
        runTest(s1, apptimizetest, new ApptimizeOptions());
    }

    public static void runTest(String s1, ApptimizeTest apptimizetest, ApptimizeOptions apptimizeoptions)
    {
        s1 = (RuntimeException)at.a(m, null, new s(apptimizetest, s1, apptimizeoptions));
        if (s1 != null)
        {
            try
            {
                throw s1;
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                throw s1;
            }
        } else
        {
            return;
        }
    }

    public static void setActiveCodeBlockForExperiment(String s1, String s2)
    {
        at.a(m, new jC(s1, s2));
    }

    public static void setActiveValueForDynamicVariable(ApptimizeVar apptimizevar, Object obj)
    {
        at.a(m, new hz(apptimizevar, obj));
    }

    public static void setMetric(String s1, double d1)
    {
        at.a(m, new iP(s1, d1));
    }

    public static void setOffline(boolean flag)
    {
        at.a(m, new aj(flag));
    }

    public static void setOnExperimentRunListener(OnExperimentRunListener onexperimentrunlistener)
    {
        at.a(m, new d7(onexperimentrunlistener));
    }

    public static void setTestmodeActive(boolean flag)
    {
        at.a(m, new go(flag));
    }

    public static void setUserAttribute(String s1, double d1)
    {
        a(s1, Double.valueOf(d1));
    }

    public static void setUserAttribute(String s1, int i1)
    {
        a(s1, Integer.valueOf(i1));
    }

    public static void setUserAttribute(String s1, String s2)
    {
        a(s1, s2);
    }

    public static void setUserAttribute(String s1, boolean flag)
    {
        a(s1, Boolean.valueOf(flag));
    }

    public static void setup(Context context, String s1)
    {
        setup(context, s1, new ApptimizeOptions());
    }

    public static void setup(Context context, String s1, ApptimizeOptions apptimizeoptions)
    {
        at.a(m, new t(apptimizeoptions, context, s1));
    }

    public static String stringForTest(String s1, String s2)
    {
        return stringForTest(s1, s2, new ApptimizeOptions());
    }

    public static String stringForTest(String s1, String s2, ApptimizeOptions apptimizeoptions)
    {
        return (String)at.a(m, s2, new e8(s2, s1, apptimizeoptions));
    }

    public static void track(String s1)
    {
        at.a(m, new v(s1));
    }

    public static void track(String s1, double d1)
    {
        at.a(m, new iX(s1, d1));
    }

    static 
    {
        char ac[];
        int j1;
        ac = "?Y\f\036l\023@\006\017%\nA\016\017r^H\022J`\006J\031\032q\027F\022Jr\026@\037\002%\tH\017\004\"\n\t\037\013p\031A\bJ-\027G\\\031`\n\\\fJq\026[\031\013aW\022\\\036m\027Z\\\031m\021\\\020\016%\020F\bJm\037_\031Jm\037Y\f\017k\033MR".toCharArray();
        j1 = ac.length;
        if (j1 > 1) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L11:
        int k1;
        int l1;
        l1 = i1;
        k1 = i1;
_L9:
        char ac1[];
        char c1;
        ac1 = ac;
        c1 = ac1[k1];
        l1 % 5;
        JVM INSTR tableswitch 0 3: default 68
    //                   0 826
    //                   1 833
    //                   2 840
    //                   3 847;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        i1 = 5;
_L55:
label0:
        {
            ac1[k1] = (char)(i1 ^ c1);
            l1++;
            if (j1 != 0)
            {
                break label0;
            }
            k1 = j1;
        }
        if (true) goto _L9; else goto _L8
        k1 = j1;
        ac1 = ac;
_L62:
        ac = ac1;
        j1 = k1;
        i1 = l1;
        if (k1 > l1) goto _L11; else goto _L10
_L10:
        String s1;
        s1 = (new String(ac1)).intern();
        ac = ";Q\037\017u\n@\023\004%\tA\031\004%\022F\035\016l\020N\\\013u\016]\025\007l\004LR\032w\021Y\031\030q\027L\017".toCharArray();
        j1 = ac.length;
        if (j1 > 1) goto _L13; else goto _L12
_L12:
        i1 = 0;
_L22:
        l1 = i1;
        k1 = i1;
_L20:
        ac1 = ac;
        c1 = ac1[k1];
        l1 % 5;
        JVM INSTR tableswitch 0 3: default 204
    //                   0 854
    //                   1 861
    //                   2 868
    //                   3 875;
           goto _L14 _L15 _L16 _L17 _L18
_L15:
        break; /* Loop/switch isn't completed */
_L14:
        i1 = 5;
_L56:
label1:
        {
            ac1[k1] = (char)(i1 ^ c1);
            l1++;
            if (j1 != 0)
            {
                break label1;
            }
            k1 = j1;
        }
        if (true) goto _L20; else goto _L19
        k1 = j1;
        ac1 = ac;
_L61:
        ac = ac1;
        j1 = k1;
        i1 = l1;
        if (k1 > l1) goto _L22; else goto _L21
_L21:
        String s2;
        s2 = (new String(ac1)).intern();
        ac = "\037Y\f\036l\023@\006\017+\016[\023\032`\f]\025\017v".toCharArray();
        j1 = ac.length;
        if (j1 > 1) goto _L24; else goto _L23
_L23:
        i1 = 0;
_L33:
        l1 = i1;
        k1 = i1;
_L31:
        ac1 = ac;
        c1 = ac1[k1];
        l1 % 5;
        JVM INSTR tableswitch 0 3: default 340
    //                   0 882
    //                   1 889
    //                   2 896
    //                   3 903;
           goto _L25 _L26 _L27 _L28 _L29
_L26:
        break; /* Loop/switch isn't completed */
_L25:
        i1 = 5;
_L57:
label2:
        {
            ac1[k1] = (char)(i1 ^ c1);
            l1++;
            if (j1 != 0)
            {
                break label2;
            }
            k1 = j1;
        }
        if (true) goto _L31; else goto _L30
        k1 = j1;
        ac1 = ac;
_L60:
        ac = ac1;
        j1 = k1;
        i1 = l1;
        if (k1 > l1) goto _L33; else goto _L32
_L32:
        String s3;
        s3 = (new String(ac1)).intern();
        ac = "?Y\f\036l\023@\006\017%\022@\036\030d\fP\\\003v^G\023\035%\032@\017\013g\022L\030D".toCharArray();
        j1 = ac.length;
        if (j1 > 1) goto _L35; else goto _L34
_L34:
        i1 = 0;
_L44:
        l1 = i1;
        k1 = i1;
_L42:
        ac1 = ac;
        c1 = ac1[k1];
        l1 % 5;
        JVM INSTR tableswitch 0 3: default 476
    //                   0 910
    //                   1 917
    //                   2 924
    //                   3 931;
           goto _L36 _L37 _L38 _L39 _L40
_L37:
        break; /* Loop/switch isn't completed */
_L36:
        i1 = 5;
_L58:
label3:
        {
            ac1[k1] = (char)(i1 ^ c1);
            l1++;
            if (j1 != 0)
            {
                break label3;
            }
            k1 = j1;
        }
        if (true) goto _L42; else goto _L41
        k1 = j1;
        ac1 = ac;
_L59:
        ac = ac1;
        j1 = k1;
        i1 = l1;
        if (k1 > l1) goto _L44; else goto _L43
_L43:
        x = (new String[] {
            s1, s2, s3, (new String(ac1)).intern()
        });
        ac = "?Y\f\036l\023@\006\017".toCharArray();
        j1 = ac.length;
        if (j1 > 1)
        {
            break MISSING_BLOCK_LABEL_986;
        }
        i1 = 0;
_L54:
        l1 = i1;
        k1 = i1;
_L51:
        ac1 = ac;
        c1 = ac1[k1];
        l1 % 5;
        JVM INSTR tableswitch 0 3: default 632
    //                   0 663
    //                   1 670
    //                   2 677
    //                   3 684;
           goto _L45 _L46 _L47 _L48 _L49
_L49:
        break MISSING_BLOCK_LABEL_684;
_L46:
        break; /* Loop/switch isn't completed */
_L45:
        i1 = 5;
_L52:
        ac1[k1] = (char)(i1 ^ c1);
        l1++;
        if (j1 != 0)
        {
            break MISSING_BLOCK_LABEL_691;
        }
        k1 = j1;
        if (true) goto _L51; else goto _L50
_L50:
        i1 = 126;
          goto _L52
_L47:
        i1 = 41;
          goto _L52
_L48:
        i1 = 124;
          goto _L52
        i1 = 106;
          goto _L52
        k1 = j1;
        ac1 = ac;
_L63:
        ac = ac1;
        j1 = k1;
        i1 = l1;
        if (k1 > l1) goto _L54; else goto _L53
_L53:
        m = (new String(ac1)).intern();
        e = new Object();
        i = new CountDownLatch(1);
        j = false;
        q = new ji();
        b = new HashMap();
        d = null;
        t = (b3)at.a(m, null, new e9());
        v = null;
        r = false;
        f = new HashMap();
        o = new HashMap();
        return;
_L8:
        i1 = 126;
          goto _L55
_L5:
        i1 = 41;
          goto _L55
_L6:
        i1 = 124;
          goto _L55
_L7:
        i1 = 106;
          goto _L55
_L19:
        i1 = 126;
          goto _L56
_L16:
        i1 = 41;
          goto _L56
_L17:
        i1 = 124;
          goto _L56
_L18:
        i1 = 106;
          goto _L56
_L30:
        i1 = 126;
          goto _L57
_L27:
        i1 = 41;
          goto _L57
_L28:
        i1 = 124;
          goto _L57
_L29:
        i1 = 106;
          goto _L57
_L41:
        i1 = 126;
          goto _L58
_L38:
        i1 = 41;
          goto _L58
_L39:
        i1 = 124;
          goto _L58
_L40:
        i1 = 106;
          goto _L58
_L35:
        l1 = 0;
        ac1 = ac;
        k1 = j1;
          goto _L59
_L24:
        l1 = 0;
        ac1 = ac;
        k1 = j1;
          goto _L60
_L13:
        l1 = 0;
        ac1 = ac;
        k1 = j1;
          goto _L61
_L2:
        l1 = 0;
        ac1 = ac;
        k1 = j1;
          goto _L62
        l1 = 0;
        ac1 = ac;
        k1 = j1;
          goto _L63
    }





/*
    static d4 access$1002(d4 d4_1)
    {
        k = d4_1;
        return d4_1;
    }

*/


/*
    static boolean access$102(boolean flag)
    {
        j = flag;
        return flag;
    }

*/



/*
    static l access$1102(l l1)
    {
        l = l1;
        return l1;
    }

*/



/*
    static boolean access$1202(boolean flag)
    {
        r = flag;
        return flag;
    }

*/



/*
    static Map access$1302(Map map)
    {
        o = map;
        return map;
    }

*/



/*
    static Map access$1402(Map map)
    {
        f = map;
        return map;
    }

*/



/*
    static OnExperimentRunListener access$1502(OnExperimentRunListener onexperimentrunlistener)
    {
        v = onexperimentrunlistener;
        return onexperimentrunlistener;
    }

*/




/*
    static cf access$1702(cf cf)
    {
        s = cf;
        return cf;
    }

*/



/*
    static bI access$1802(bI bi)
    {
        h = bi;
        return bi;
    }

*/



/*
    static by access$1902(by by)
    {
        g = by;
        return by;
    }

*/






/*
    static gx access$2202(gx gx1)
    {
        p = gx1;
        return gx1;
    }

*/



/*
    static dU access$2402(dU du)
    {
        c = du;
        return du;
    }

*/


/*
    static b6 access$2502(b6 b6)
    {
        u = b6;
        return b6;
    }

*/



/*
    static il access$302(il il1)
    {
        w = il1;
        return il1;
    }

*/







/*
    static Map access$802(Map map)
    {
        b = map;
        return map;
    }

*/



/*
    static Boolean access$902(Boolean boolean1)
    {
        d = boolean1;
        return boolean1;
    }

*/
}
