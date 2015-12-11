// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import cn.jpush.android.data.JPushLocalNotification;
import cn.jpush.android.data.i;
import cn.jpush.android.data.k;
import cn.jpush.android.util.x;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package cn.jpush.android.service:
//            i, ServiceInterface, h

public final class g
{

    private static g a;
    private static ExecutorService b;
    private static i f;
    private static k g;
    private static final String z[];
    private Handler c;
    private Context d;
    private String e;

    private g(Context context)
    {
        c = null;
        d = null;
        e = "";
        x.c();
        c = new Handler(Looper.getMainLooper());
        d = context;
        e = d.getPackageName();
    }

    static Context a(g g1)
    {
        return g1.d;
    }

    static i a()
    {
        return f;
    }

    static i a(i j)
    {
        f = j;
        return j;
    }

    public static g a(Context context)
    {
        x.c();
        if (a == null)
        {
            a = new g(context);
        }
        return a;
    }

    private void a(long l, long l1)
    {
        x.c();
        if (l < 0L)
        {
            x.f();
        } else
        if (c != null)
        {
            cn.jpush.android.service.i j = new cn.jpush.android.service.i(this, l);
            if (l1 <= 0L)
            {
                x.c();
                c.post(j);
                return;
            } else
            {
                (new StringBuilder(z[3])).append(l1).toString();
                x.c();
                c.postDelayed(j, l1);
                return;
            }
        }
    }

    private void a(Context context, String s, String s1, String s2)
    {
        x.c();
        Intent intent = new Intent(z[7]);
        intent.putExtra(z[8], s2);
        intent.putExtra(z[9], s1);
        intent.putExtra(z[6], s);
        intent.putExtra(z[10], 1);
        intent.addCategory(s1);
        context.sendOrderedBroadcast(intent, (new StringBuilder()).append(s1).append(z[5]).toString());
        x.c();
    }

    static void a(g g1, Context context)
    {
        Object obj;
        x.c();
        obj = null;
        Cursor cursor;
        if (f == null)
        {
            f = new i(context);
        }
        f.a();
        long l = System.currentTimeMillis();
        cursor = f.a(1, l);
        obj = cursor;
        if (((Cursor) (obj)).moveToFirst())
        {
            do
            {
                i j = f;
                i.a(((Cursor) (obj)), g);
                g1.a(context, g.d(), g1.e, "");
                f.b(g.a(), 0, 0, 0, g.d(), g.f(), g.e());
            } while (((Cursor) (obj)).moveToNext());
        }
        f.b();
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
_L2:
        return;
        context;
        g1 = ((g) (obj));
_L5:
        x.d(z[1], (new StringBuilder(z[4])).append(context.getMessage()).toString());
        context.printStackTrace();
        if (g1 == null) goto _L2; else goto _L1
_L1:
        g1.close();
        return;
        g1;
        obj = null;
_L4:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw g1;
        g1;
        continue; /* Loop/switch isn't completed */
        context;
        obj = g1;
        g1 = context;
        if (true) goto _L4; else goto _L3
_L3:
        context;
        g1 = ((g) (obj));
          goto _L5
    }

    static void a(g g1, Context context, String s, String s1, String s2)
    {
        g1.a(context, s, s1, s2);
    }

    public static boolean a(Context context, long l)
    {
        x.b(z[1], z[0]);
        if (f == null)
        {
            f = new i(context);
        }
        context = null;
        Object obj;
        f.a();
        obj = f.a(l, 0);
        context = ((Context) (obj));
        obj = f;
        i.a(context, g);
        if (g.b() > 0)
        {
            (new StringBuilder(z[2])).append(g.b()).toString();
            x.c();
            f.b(l, 0, 1, 0, g.d(), g.f(), g.e());
        }
        f.b();
        if (context != null)
        {
            context.close();
        }
_L2:
        return true;
        Exception exception;
        exception;
_L5:
        if (context == null) goto _L2; else goto _L1
_L1:
        context.close();
        return true;
        context;
        Context context1;
        context1 = null;
        exception = context;
_L4:
        if (context1 != null)
        {
            context1.close();
        }
        throw exception;
        exception;
        context1 = context;
        if (true) goto _L4; else goto _L3
_L3:
        exception;
          goto _L5
    }

    static k b()
    {
        return g;
    }

    static String b(g g1)
    {
        return g1.e;
    }

    public static void b(Context context)
    {
        x.b(z[1], z[11]);
        if (f == null)
        {
            f = new i(context);
        }
        f.a();
        if (f.c())
        {
            x.c();
        }
        f.b();
    }

    public final boolean a(Context context, JPushLocalNotification jpushlocalnotification)
    {
        long l;
        long l1;
        x.b(z[1], z[12]);
        l = System.currentTimeMillis();
        l1 = jpushlocalnotification.getBroadcastTime() - l;
        if (ServiceInterface.j(context))
        {
            x.c();
        }
        if (f == null)
        {
            f = new i(context);
        }
        context = null;
        Object obj;
        f.a();
        obj = f.a(jpushlocalnotification.getNotificationId(), 0);
        context = ((Context) (obj));
        obj = f;
        i.a(context, g);
        if ((long)g.a() == jpushlocalnotification.getNotificationId()) goto _L2; else goto _L1
_L1:
        f.a(jpushlocalnotification.getNotificationId(), 1, 0, 0, jpushlocalnotification.toJSON(), jpushlocalnotification.getBroadcastTime(), l);
_L3:
        f.b();
        if (context != null)
        {
            context.close();
        }
_L4:
        Exception exception;
        if (l1 < 0x493e0L)
        {
            a(jpushlocalnotification.getNotificationId(), l1);
            return true;
        } else
        {
            return true;
        }
_L2:
        f.b(jpushlocalnotification.getNotificationId(), 1, 0, 0, jpushlocalnotification.toJSON(), jpushlocalnotification.getBroadcastTime(), l);
          goto _L3
        exception;
_L7:
        if (context != null)
        {
            context.close();
        }
          goto _L4
        context;
        exception = null;
        jpushlocalnotification = context;
_L6:
        if (exception != null)
        {
            exception.close();
        }
        throw jpushlocalnotification;
        jpushlocalnotification;
        exception = context;
        if (true) goto _L6; else goto _L5
_L5:
        exception;
          goto _L7
    }

    public final void c(Context context)
    {
        x.c();
        if (f == null)
        {
            f = new i(context);
        }
        Object obj;
        context = null;
        obj = context;
        f.a();
        obj = context;
        long l = System.currentTimeMillis();
        obj = context;
        context = f.a(l, 0x493e0L);
        obj = context;
        if (!context.moveToFirst()) goto _L2; else goto _L1
_L1:
        obj = context;
        Object obj1 = f;
        obj = context;
        i.a(context, g);
        obj = context;
        a(g.a(), g.f() - l);
        obj = context;
        if (context.moveToNext()) goto _L1; else goto _L2
_L2:
        obj = context;
        f.b();
        if (context != null)
        {
            try
            {
                context.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                (new StringBuilder(z[13])).append(context).toString();
            }
            x.c();
            context.printStackTrace();
            return;
        }
          goto _L3
        context;
        if (obj == null) goto _L3; else goto _L4
_L4:
        ((Cursor) (obj)).close();
        return;
        context;
        obj1 = null;
        obj = context;
_L5:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        ((Cursor) (obj1)).close();
        throw obj;
        obj;
        obj1 = context;
        if (true) goto _L5; else goto _L3
_L3:
    }

    public final void d(Context context)
    {
        x.c();
        b.execute(new h(this, context));
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int j;
        as = new String[14];
        j = 0;
        obj1 = "(T6Z\007?\021\027Z\022;]\025Z\0053W2V\020.X4[Q";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int l;
        int i1;
        int j1;
        int k1;
        byte byte2;
        int l1;
        ac = ((String) (obj1)).toCharArray();
        l = ac.length;
        k1 = 0;
        i1 = 0;
        byte2 = byte0;
        obj1 = ac;
        l1 = j;
        as1 = ((String []) (obj));
        j1 = l;
        if (l > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        j1 = i1;
_L9:
        obj1 = obj;
        k1 = obj1[i1];
        j1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 568
    //                   1 575
    //                   2 582
    //                   3 589;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_589;
_L3:
        byte0 = 113;
_L13:
label0:
        {
            obj1[i1] = (char)(byte0 ^ k1);
            j1++;
            if (l != 0)
            {
                break label0;
            }
            i1 = l;
        }
        if (true) goto _L9; else goto _L8
        k1 = j1;
        j1 = l;
        as1 = as2;
        l1 = j;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        j = l1;
        as2 = as1;
        l = j1;
        i1 = k1;
        if (j1 > k1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[l1] = ((String) (obj));
            j = 1;
            obj1 = "\020a.F\031\026^8T\035\024^/\\\0273R:A\0305_\030P\037.T)";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[l1] = ((String) (obj));
            j = 2;
            obj1 = "(T6Z\007?\0217Z\022;]{V\036/_/\025Kz";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[l1] = ((String) (obj));
            j = 3;
            obj1 = "*^(AQ>T7T\b?U{\017Q";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[l1] = ((String) (obj));
            j = 4;
            obj1 = ".C2R\026?C\027{:3]7e\0035R>F\002`\021";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[l1] = ((String) (obj));
            j = 5;
            obj1 = "tA>G\0343B(\\\0364\037\021e$\ty\004x4\tb\032r4";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[l1] = ((String) (obj));
            j = 6;
            obj1 = "7T(F\020=T";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[l1] = ((String) (obj));
            j = 7;
            obj1 = "9_u_\001/B3\033\0204U)Z\030>\0372[\005?_/\033?\025e\022s8\031p\017|>\024n\tp2\037x\rp5\005a\tz)\003";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[l1] = ((String) (obj));
            j = 8;
            obj1 = ")T5Q\024(x?";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[l1] = ((String) (obj));
            j = 9;
            obj1 = ";A+|\025";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[l1] = ((String) (obj));
            j = 10;
            obj1 = "4^/\\\0273R:\\\0364n/L\001?";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[l1] = ((String) (obj));
            j = 11;
            obj1 = "9]>T\003zP7YQ6^8T\035z_4A\030<X8T\0053^5\025";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[l1] = ((String) (obj));
            j = 12;
            obj1 = ";U?\025=5R:Y?5E2S\0309P/\\\0364";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[l1] = ((String) (obj));
            j = 13;
            obj1 = "3_2AQ\026^8T\035\024^/\\\0273R:A\0305_{V\020)E{P\t*Ea";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[l1] = ((String) (obj));
            z = as;
            a = null;
            b = Executors.newSingleThreadExecutor();
            f = null;
            g = new k();
            return;
        }
          goto _L12
_L8:
        byte0 = 90;
          goto _L13
_L5:
        byte0 = 49;
          goto _L13
_L6:
        byte0 = 91;
          goto _L13
        byte0 = 53;
          goto _L13
    }
}
