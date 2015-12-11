// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.api;

import android.app.Activity;
import android.app.Application;
import android.app.TabActivity;
import android.content.Context;
import cn.jpush.android.service.PushService;
import cn.jpush.android.util.a;
import cn.jpush.android.util.ac;
import cn.jpush.android.util.af;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.i;
import cn.jpush.android.util.x;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.api:
//            a, h, f, i, 
//            g, j

public class e
{

    public static boolean a;
    public static boolean b;
    private static final String c;
    private static e e;
    private static final String z[];
    private ExecutorService d;
    private String f;
    private String g;
    private ArrayList h;
    private long i;
    private long j;
    private long k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private WeakReference q;
    private JSONObject r;
    private Object s;

    private e()
    {
        d = Executors.newSingleThreadExecutor();
        f = null;
        g = null;
        h = new ArrayList();
        i = 30L;
        j = 0L;
        k = 0L;
        l = false;
        m = true;
        n = true;
        o = false;
        p = true;
        q = null;
        r = null;
        s = new Object();
    }

    private JSONObject a(Context context, long l1)
    {
        af.a().b(context, z[11], j);
        StringBuilder stringbuilder = new StringBuilder();
        String s1 = cn.jpush.android.util.a.v(context);
        if (!ai.a(s1))
        {
            stringbuilder.append(s1);
        }
        s1 = cn.jpush.android.util.a.l(context);
        if (!ai.a(s1))
        {
            stringbuilder.append(s1);
        }
        stringbuilder.append(l1);
        g = cn.jpush.android.util.a.a(stringbuilder.toString());
        af.a().b(context, z[0], g);
        context = new JSONObject();
        try
        {
            a(((JSONObject) (context)));
            context.put(z[2], PushService.m + Math.abs(l1 / 1000L - PushService.n));
            context.put(z[0], g);
            context.put(z[5], z[20]);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    static void a(e e1, Context context)
    {
        boolean flag1 = true;
        if (!e1.m) goto _L2; else goto _L1
_L1:
        boolean flag;
        e1.m = false;
        String s1 = c;
        x.c();
        long l1 = af.a().a(context, z[3], -1L);
        flag = flag1;
        if (l1 != -1L)
        {
            flag = flag1;
            if (e1.j - l1 <= e1.i * 1000L)
            {
                flag = false;
            }
        }
_L4:
        Object obj;
        e1.l = flag;
        if (!e1.l)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = c;
        x.c();
        obj = new JSONArray();
        JSONObject jsonobject = e1.a(context, e1.j);
        if (jsonobject != null)
        {
            ((JSONArray) (obj)).put(jsonobject);
        }
        Object obj1 = e1.s;
        obj1;
        JVM INSTR monitorenter ;
        JSONObject jsonobject1 = e1.d(context);
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        int i1 = jsonobject1.length();
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        try
        {
            jsonobject1.put(z[5], z[1]);
            jsonobject1.put(z[2], PushService.m + Math.abs(System.currentTimeMillis() / 1000L - PushService.n));
        }
        catch (Exception exception) { }
        ac.a(context, z[4], null);
        e1.r = null;
        e1.h = new ArrayList();
        obj1;
        JVM INSTR monitorexit ;
        if (jsonobject1 != null && jsonobject1.length() > 0)
        {
            ((JSONArray) (obj)).put(jsonobject1);
        }
        ac.a(context, ((JSONArray) (obj)));
        return;
_L2:
        flag = flag1;
        if (e1.j - e1.k <= e1.i * 1000L)
        {
            flag = false;
        }
        if (true) goto _L4; else goto _L3
        e1;
        throw e1;
_L3:
        e1.g = af.a().a(context, z[0], null);
        return;
    }

    private static void a(JSONObject jsonobject)
    {
        String s2 = cn.jpush.android.util.i.a();
        String s1 = s2.split("_")[0];
        s2 = s2.split("_")[1];
        jsonobject.put(z[18], s1);
        jsonobject.put(z[19], s2);
    }

    private static boolean a(String s1)
    {
        StackTraceElement astacktraceelement[];
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        astacktraceelement = (new Throwable()).getStackTrace();
        if (astacktraceelement.length < 2) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L8:
        flag1 = flag;
        if (i1 >= astacktraceelement.length) goto _L2; else goto _L3
_L3:
        Object obj;
        obj = astacktraceelement[i1];
        flag1 = flag;
        if (!((StackTraceElement) (obj)).getMethodName().equals(s1)) goto _L5; else goto _L4
_L4:
        obj = Class.forName(((StackTraceElement) (obj)).getClassName());
_L6:
        flag1 = flag;
        if (((Class) (obj)).getSuperclass() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (((Class) (obj)).getSuperclass() == android/app/Activity)
        {
            flag1 = true;
            break; /* Loop/switch isn't completed */
        }
        obj = ((Class) (obj)).getSuperclass();
        if (true) goto _L6; else goto _L5
        s1;
        flag1 = flag;
_L2:
        return flag1;
_L5:
        i1++;
        flag = flag1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static e b()
    {
        if (e != null) goto _L2; else goto _L1
_L1:
        cn/jpush/android/api/e;
        JVM INSTR monitorenter ;
        e = new e();
        cn/jpush/android/api/e;
        JVM INSTR monitorexit ;
_L2:
        return e;
        Exception exception;
        exception;
        throw exception;
    }

    static void b(e e1, Context context)
    {
        boolean flag = false;
        if (context == null) goto _L2; else goto _L1
_L1:
        Object obj1 = e1.s;
        obj1;
        JVM INSTR monitorenter ;
        Object obj;
        af.a().b(context, z[3], e1.k);
        af.a().b(context, z[13], e1.k);
        if (!e1.n)
        {
            break MISSING_BLOCK_LABEL_246;
        }
        e1.n = false;
        if (e1.l || e1.d(context) == null)
        {
            break MISSING_BLOCK_LABEL_246;
        }
        obj = e1.d(context).optJSONArray(z[12]);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_246;
        }
        Object obj2 = new ArrayList();
        int i1 = 0;
_L3:
        int j1 = ((JSONArray) (obj)).length();
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_215;
        }
        Object obj4 = ((JSONArray) (obj)).optJSONObject(i1);
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        Object obj5 = ((JSONObject) (obj4)).keys();
        if (((Iterator) (obj5)).hasNext())
        {
            obj5 = (String)((Iterator) (obj5)).next();
            ((ArrayList) (obj2)).add(new cn.jpush.android.api.a(((String) (obj5)), ((JSONObject) (obj4)).getLong(((String) (obj5)))));
        }
_L4:
        i1++;
          goto _L3
        Exception exception;
        exception;
        String s1 = c;
        exception.getMessage();
        x.f();
          goto _L4
        e1;
        throw e1;
        ((ArrayList) (obj2)).addAll(e1.h);
        e1.h = new ArrayList();
        e1.h.addAll(((java.util.Collection) (obj2)));
        obj = e1.d(context);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_264;
        }
        obj = new JSONObject();
        obj2 = new JSONArray();
        i1 = ((flag) ? 1 : 0);
_L5:
        JSONObject jsonobject;
        if (i1 >= e1.h.size())
        {
            break MISSING_BLOCK_LABEL_345;
        }
        exception = (cn.jpush.android.api.a)e1.h.get(i1);
        jsonobject = new JSONObject();
        Object obj3;
        long l1;
        try
        {
            jsonobject.put(((cn.jpush.android.api.a) (exception)).a, ((cn.jpush.android.api.a) (exception)).b);
            ((JSONArray) (obj2)).put(jsonobject);
        }
        catch (JSONException jsonexception) { }
        i1++;
          goto _L5
        i1 = ((JSONArray) (obj2)).length();
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_370;
        }
        try
        {
            ((JSONObject) (obj)).put(z[12], obj2);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj3) { }
        i1 = ((JSONObject) (obj)).length();
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_517;
        }
        try
        {
            l1 = af.a().a(context, z[11], 0L);
            l1 = (e1.k - l1) / 1000L;
            ((JSONObject) (obj)).put(z[10], l1);
            ((JSONObject) (obj)).put(z[2], PushService.m + Math.abs(System.currentTimeMillis() / 1000L - PushService.n));
            ((JSONObject) (obj)).put(z[0], e1.g);
            a(((JSONObject) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj3) { }
        e1.r = ((JSONObject) (obj));
        obj2 = e1.r;
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_506;
        }
        try
        {
            ac.a(context, e1.r.toString().getBytes(z[9]).length);
        }
        // Misplaced declaration of an exception variable
        catch (e e1) { }
        ac.a(context, z[4], ((JSONObject) (obj)));
        obj1;
        JVM INSTR monitorexit ;
_L2:
    }

    private boolean c(Context context, String s1)
    {
        if (!p)
        {
            context = c;
            x.d();
            return false;
        }
        if (context == null)
        {
            context = c;
            x.d();
            return false;
        }
        if (context instanceof Application)
        {
            x.e(c, (new StringBuilder(z[6])).append(s1).toString());
            return false;
        }
        if (!a(s1))
        {
            throw new SecurityException(z[7]);
        } else
        {
            return true;
        }
    }

    private JSONObject d(Context context)
    {
        if (r == null)
        {
            r = ac.a(context, z[4]);
        }
        return r;
    }

    public final void a(long l1)
    {
        i = l1;
    }

    public final void a(Context context)
    {
        if (!c(context, z[14]))
        {
            return;
        }
        a = true;
        try
        {
            if (Class.forName(context.getClass().getName()).newInstance() instanceof TabActivity)
            {
                o = false;
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        if (o)
        {
            x.e(c, z[15]);
            return;
        }
        o = true;
        j = System.currentTimeMillis();
        f = context.getClass().getName();
        try
        {
            d.execute(new h(this, context));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public final void a(Context context, String s1)
    {
        if (o)
        {
            x.e(c, z[8]);
            return;
        }
        o = true;
        f = s1;
        j = System.currentTimeMillis();
        try
        {
            d.execute(new f(this, context));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public final void a(boolean flag)
    {
        p = flag;
    }

    public final boolean a()
    {
        return p;
    }

    public final void b(Context context)
    {
        if (!c(context, z[22]))
        {
            return;
        }
        b = true;
        try
        {
            if (Class.forName(context.getClass().getName()).newInstance() instanceof TabActivity)
            {
                o = true;
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        if (!o)
        {
            x.e(c, z[21]);
            return;
        }
        o = false;
        if (f != null && f.equals(context.getClass().getName()))
        {
            k = System.currentTimeMillis();
            long l1 = (k - j) / 1000L;
            cn.jpush.android.api.a a1 = new cn.jpush.android.api.a(f, l1);
            h.add(a1);
            try
            {
                d.execute(new cn.jpush.android.api.i(this, context));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
        } else
        {
            context = c;
            x.d();
            return;
        }
    }

    public final void b(Context context, String s1)
    {
        if (!o)
        {
            x.e(c, z[17]);
            return;
        }
        o = false;
        if (f != null && f.equals(s1))
        {
            k = System.currentTimeMillis();
            long l1 = (k - j) / 1000L;
            s1 = new cn.jpush.android.api.a(f, l1);
            h.add(s1);
            try
            {
                d.execute(new g(this, context));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
        } else
        {
            x.e(c, z[16]);
            return;
        }
    }

    public final void c(Context context)
    {
        try
        {
            if (f == null || !o)
            {
                break MISSING_BLOCK_LABEL_75;
            }
            k = System.currentTimeMillis();
            long l1 = (k - j) / 1000L;
            cn.jpush.android.api.a a1 = new cn.jpush.android.api.a(f, l1);
            h.add(a1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        d.execute(new j(this, context));
        return;
        context;
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i1;
        as = new String[23];
        i1 = 0;
        obj1 = "H\t1}oT\002\035gb";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac1[];
        int j1;
        int k1;
        int l1;
        int i2;
        byte byte2;
        int j2;
        ac1 = ((String) (obj1)).toCharArray();
        j1 = ac1.length;
        i2 = 0;
        k1 = 0;
        byte2 = byte0;
        obj1 = ac1;
        j2 = i1;
        as1 = ((String []) (obj));
        l1 = j1;
        if (j1 > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac1;
        byte1 = byte0;
_L11:
        l1 = k1;
_L9:
        obj1 = obj;
        i2 = obj1[k1];
        l1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 789
    //                   1 796
    //                   2 803
    //                   3 810;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_810;
_L3:
        byte0 = 6;
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
            obj1 = "Z\0176gp^36ktV\005,or^";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j2] = ((String) (obj));
            i1 = 2;
            obj1 = "R\030+cc";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j2] = ((String) (obj));
            i1 = 3;
            obj1 = "W\r1zYK\r7}c";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j2] = ((String) (obj));
            i1 = 4;
            obj1 = "Q\0347}nd\0376ord\017#mn^B(}iU";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j2] = ((String) (obj));
            i1 = 5;
            obj1 = "O\0252k";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j2] = ((String) (obj));
            i1 = 6;
            obj1 = "x\003,zcC\030b}nT\031.j&Y\tboh\033-!zoM\0056w&T\002bznR\037bccO\004-j&\001L";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j2] = ((String) (obj));
            i1 = 7;
            obj1 = "q<7}nh-lahi\t1{k^D\001ahO\t:z/\033\0017}r\033\016'.oU\032-ec_L+`&z\0176gpR\030; iU>'}sV\tj'";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[j2] = ((String) (obj));
            i1 = 8;
            obj1 = "q<7}nr\0026kt]\r!k(T\002\020kuN\001'&/\033\0017}r\033\016'.eZ\000.kb\033\r$zcIL!ojW\t&.Lk\0311fOU\030'|`Z\017' iU<#{u^Dk.oUL.ouOL\003mrR\032+z\177\033\0030.@I\r%ccU\030";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[j2] = ((String) (obj));
            i1 = 9;
            obj1 = "N\030$#>";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[j2] = ((String) (obj));
            i1 = 10;
            obj1 = "_\0310orR\003,";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[j2] = ((String) (obj));
            i1 = 11;
            obj1 = "X\0310Qu^\0371giU31zgI\030";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[j2] = ((String) (obj));
            i1 = 12;
            obj1 = "Z\0176gpR\030+ku";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[j2] = ((String) (obj));
            i1 = 13;
            obj1 = "X\0310Qu^\t1giU3'`b";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[j2] = ((String) (obj));
            i1 = 14;
            obj1 = "T\002\020kuN\001'";
            byte0 = 13;
            obj = as;
            break;

        case 13: // '\r'
            as1[j2] = ((String) (obj));
            i1 = 15;
            obj1 = "q<7}nr\0026kt]\r!k(T\002\020kuN\001'&/\033\0017}r\033\016'.eZ\000.kb\033\r$zcIL!ojW\t&.Lk\0311fOU\030'|`Z\017' iU<#{u^Dk.gU\bbDVN\037*GhO\t0hgX\tlahi\t1{k^L1fiN\000&.hT\030blc\033\017#bj^\bbciI\tbzoV\tbgh\033\000#}r\033-!zoM\0056w&T\036bHtZ\013/khOLb";
            byte0 = 14;
            obj = as;
            break;

        case 14: // '\016'
            as1[j2] = ((String) (obj));
            i1 = 16;
            obj1 = "K\r%k&U\r/k&_\005&`!OL/orX\004bzn^L.ouOL-`c\033\034#}u^\bbl\177\033\003,\\cH\031/k";
            byte0 = 15;
            obj = as;
            break;

        case 15: // '\017'
            as1[j2] = ((String) (obj));
            i1 = 17;
            obj1 = "q<7}nr\0026kt]\r!k(T\002\022osH\tj'&V\0311z&Y\tbmgW\000'j&Z\n6kt\033\017#bj^\bbDVN\037*GhO\t0hgX\tlahi\t1{k^Dk.oUL6foHL\003mrR\032+z\177\033\0030.@I\r%ccU\030";
            byte0 = 16;
            obj = as;
            break;

        case 16: // '\020'
            as1[j2] = ((String) (obj));
            i1 = 18;
            obj1 = "_\r6k";
            byte0 = 17;
            obj = as;
            break;

        case 17: // '\021'
            as1[j2] = ((String) (obj));
            i1 = 19;
            obj1 = "O\005/k";
            byte0 = 18;
            obj = as;
            break;

        case 18: // '\022'
            as1[j2] = ((String) (obj));
            i1 = 20;
            obj1 = "Z\0176gp^3.osU\017*";
            byte0 = 19;
            obj = as;
            break;

        case 19: // '\023'
            as1[j2] = ((String) (obj));
            i1 = 21;
            obj1 = "q<7}nr\0026kt]\r!k(T\002\022osH\tj'&V\0311z&Y\tbmgW\000'j&Z\n6kt\033\017#bj^\bbDVN\037*GhO\t0hgX\tlahi\t1{k^Dk.gU\bbDVN\037*GhO\t0hgX\tlahk\r7}c\033\037*asW\bb`iOL k&X\r.bc_L/at^L6gk^L+`&O\004+}&z\0176gpR\030;.iIL\004|g\\\001'`r\033Wb";
            byte0 = 20;
            obj = as;
            break;

        case 20: // '\024'
            as1[j2] = ((String) (obj));
            i1 = 22;
            obj1 = "T\002\022osH\t";
            byte0 = 21;
            obj = as;
            break;

        case 21: // '\025'
            as1[j2] = ((String) (obj));
            z = as;
            c = cn/jpush/android/api/e.getSimpleName();
            e = null;
            a = false;
            b = false;
            return;
        }
          goto _L12
_L8:
        byte0 = 59;
          goto _L13
_L5:
        byte0 = 108;
          goto _L13
_L6:
        byte0 = 66;
          goto _L13
        byte0 = 14;
          goto _L13
    }
}
