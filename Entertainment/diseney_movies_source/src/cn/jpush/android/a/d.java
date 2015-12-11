// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.telephony.CellLocation;
import android.widget.Toast;
import cn.jpush.android.service.PushService;
import cn.jpush.android.util.a;
import cn.jpush.android.util.x;
import java.util.Date;
import org.json.JSONArray;

// Referenced classes of package cn.jpush.android.a:
//            e, b, i, g, 
//            f

public abstract class d
{

    private static final String A[];
    public static int b;
    public static boolean c;
    private static boolean f;
    public String a;
    protected boolean d;
    private boolean e;
    private int g;
    private b h;
    private g i;
    private Context j;
    private int k[];
    private f l;
    private boolean m;
    private final BroadcastReceiver n;
    private long o;
    private int p;
    private boolean q;
    private boolean r;
    private i s;
    private int t;
    private final Date u;
    private JSONArray v;
    private boolean w;
    private boolean x;
    private String y;
    private JSONArray z;

    private d(Context context)
    {
        e = false;
        q = false;
        u = new Date();
        x = false;
        n = new e(this, (byte)0);
        j = context.getApplicationContext();
        h = new b(context);
        s = new i(context);
        i = new g(context);
    }

    private d(Context context, String s1)
    {
        this(context);
        if (s1 == null || "".equals(s1))
        {
            a = A[6];
            return;
        } else
        {
            a = s1;
            return;
        }
    }

    private d(Context context, String s1, boolean flag)
    {
        this(context, s1);
        x = flag;
    }

    public d(Context context, String s1, boolean flag, boolean flag1)
    {
        this(context, s1, flag);
        e = flag1;
    }

    static int a(d d1, int i1)
    {
        d1.p = 3;
        return 3;
    }

    static Context a(d d1)
    {
        return d1.j;
    }

    static JSONArray a(d d1, JSONArray jsonarray)
    {
        d1.z = jsonarray;
        return jsonarray;
    }

    static void a(d d1, Object obj)
    {
        if (f)
        {
            obj.toString();
            cn.jpush.android.util.x.c();
            obj = String.valueOf(obj);
            Toast.makeText(d1.j, ((CharSequence) (obj)), 0).show();
        }
    }

    public static boolean a(Context context)
    {
        return cn.jpush.android.util.a.c(context, A[5]) && cn.jpush.android.util.a.c(context, A[2]) && cn.jpush.android.util.a.c(context, A[4]) && cn.jpush.android.util.a.c(context, A[3]);
    }

    static boolean a(d d1, boolean flag)
    {
        d1.m = false;
        return false;
    }

    static b b(d d1)
    {
        return d1.h;
    }

    static f c(d d1)
    {
        return d1.l;
    }

    static int d(d d1)
    {
        return d1.p;
    }

    static i e(d d1)
    {
        return d1.s;
    }

    static boolean f(d d1)
    {
        return d1.m;
    }

    static int g(d d1)
    {
        return d1.g;
    }

    static int[] h(d d1)
    {
        return d1.k;
    }

    static boolean i(d d1)
    {
        return d1.x;
    }

    static BroadcastReceiver j(d d1)
    {
        return d1.n;
    }

    static long k(d d1)
    {
        return d1.o;
    }

    static boolean l(d d1)
    {
        return d1.r;
    }

    public final String a()
    {
        String s2 = i.d();
        String s1 = s2;
        if (s2 == null)
        {
            s1 = "";
        }
        return s1;
    }

    public final void a(JSONArray jsonarray)
    {
        v = jsonarray;
    }

    public final JSONArray b()
    {
        if (!cn.jpush.android.util.a.c(j, A[5]))
        {
            return null;
        }
        if (h.e())
        {
            return h.b();
        } else
        {
            return v;
        }
    }

    public final void b(JSONArray jsonarray)
    {
        z = jsonarray;
    }

    public final JSONArray c()
    {
        if (z != null)
        {
            return z;
        } else
        {
            return null;
        }
    }

    public abstract void d();

    public final void e()
    {
        if (p != 1)
        {
            return;
        }
        CellLocation.requestLocationUpdate();
        p = 2;
        l.sendEmptyMessage(1);
        if (s.b().isWifiEnabled())
        {
            s.b().startScan();
            r = false;
            return;
        }
        if (!e)
        {
            l.sendEmptyMessageDelayed(5, 0L);
            return;
        }
        o = System.currentTimeMillis();
        if (!c || !s.b().setWifiEnabled(true))
        {
            l.sendEmptyMessageDelayed(5, 8000L);
            return;
        } else
        {
            r = true;
            return;
        }
    }

    public final void f()
    {
        if (!PushService.z) goto _L2; else goto _L1
_L1:
        return;
_L2:
        PushService.z = true;
        e = false;
        x = false;
        if (cn.jpush.android.util.a.c(j, A[5]))
        {
            v = h.c();
        } else
        {
            cn.jpush.android.util.x.f();
            v = null;
        }
        if (!cn.jpush.android.util.a.c(j, A[2]))
        {
            cn.jpush.android.util.x.f();
            z = null;
        } else
        {
            w = s.a();
            if (!s.a())
            {
                if (!e)
                {
                    z = null;
                } else
                if (!cn.jpush.android.util.a.c(j, A[4]))
                {
                    cn.jpush.android.util.x.f();
                    z = null;
                } else
                if (!x)
                {
                    j.registerReceiver(n, new IntentFilter(A[0]));
                    j.registerReceiver(n, new IntentFilter(A[1]));
                    s.b().setWifiEnabled(true);
                    q = true;
                }
            } else
            {
                z = s.c();
            }
        }
        if (cn.jpush.android.util.a.c(j, A[3])) goto _L4; else goto _L3
_L3:
        cn.jpush.android.util.x.f();
_L6:
        y = "";
_L7:
        if (!q && !x)
        {
            d();
            return;
        }
          goto _L1
_L4:
        if (!i.a()) goto _L6; else goto _L5
_L5:
        i.b();
        if ("" != i.d() && i.d() != null && System.currentTimeMillis() - i.e() < 30000L)
        {
            t = 0;
            y = i.d();
        }
          goto _L7
    }

    public final void g()
    {
        PushService.z = false;
        if (cn.jpush.android.util.a.c(j, A[3]) && i.a())
        {
            i.c();
        }
        if (!w && cn.jpush.android.util.a.c(j, A[4]))
        {
            s.b().setWifiEnabled(false);
        }
        if (p > 0 && a(j))
        {
            j.unregisterReceiver(n);
            l = null;
            p = 0;
            if (!w)
            {
                d = false;
                s.b().setWifiEnabled(false);
            }
        }
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i1;
        as = new String[7];
        i1 = 0;
        obj1 = "\027c\007}/\037iMa%\002#\024f&\037#0L\0018R1J\023#A7\\";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int j1;
        int k1;
        int l1;
        int i2;
        byte byte2;
        int j2;
        ac = ((String) (obj1)).toCharArray();
        j1 = ac.length;
        i2 = 0;
        k1 = 0;
        byte2 = byte0;
        obj1 = ac;
        j2 = i1;
        as1 = ((String []) (obj));
        l1 = j1;
        if (j1 > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        l1 = k1;
_L9:
        obj1 = obj;
        i2 = obj1[k1];
        l1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 383
    //                   1 390
    //                   2 397
    //                   3 404;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_404;
_L3:
        byte0 = 64;
_L13:
label0:
        {
            obj1[k1] = (char)(byte0 ^ i2);
            l1++;
            if (j1 != 0)
            {
                break label0;
            }
            k1 = j1;
        }
        if (true) goto _L9; else goto _L8
        i2 = l1;
        l1 = j1;
        as1 = as2;
        j2 = i1;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i1 = j2;
        as2 = as1;
        j1 = l1;
        k1 = i2;
        if (l1 > i2) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[j2] = ((String) (obj));
            i1 = 1;
            obj1 = "\027c\007}/\037iMa%\002#\024f&\037#4F\006?R0[\001\"H<L\b7C$J\004";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j2] = ((String) (obj));
            i1 = 2;
            obj1 = "\027c\007}/\037iM\177%\004`\n|3\037b\r!\0015N&\\\023)Z*I\t)^7N\0243";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j2] = ((String) (obj));
            i1 = 3;
            obj1 = "\027c\007}/\037iM\177%\004`\n|3\037b\r!\0015N&\\\023)K*A\005)A,L\001\"D,A";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j2] = ((String) (obj));
            i1 = 4;
            obj1 = "\027c\007}/\037iM\177%\004`\n|3\037b\r!\003>L-H\005)Z*I\t)^7N\0243";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j2] = ((String) (obj));
            i1 = 5;
            obj1 = "\027c\007}/\037iM\177%\004`\n|3\037b\r!\0015N&\\\023)N,N\022%H<C\0175L7F\0178";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j2] = ((String) (obj));
            i1 = 6;
            obj1 = "\027a\017";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j2] = ((String) (obj));
            A = as;
            b = 15000;
            c = true;
            f = false;
            return;
        }
          goto _L12
_L8:
        byte0 = 118;
          goto _L13
_L5:
        byte0 = 13;
          goto _L13
_L6:
        byte0 = 99;
          goto _L13
        byte0 = 15;
          goto _L13
    }
}
