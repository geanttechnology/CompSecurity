// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public abstract class azd extends azc
{

    private static Method c;
    private static Method d;
    private static Method e;
    private static Method f;
    private static Method g;
    private static Method h;
    private static Method i;
    private static Method j;
    private static Method k;
    private static String l;
    private static String m;
    private static String n;
    private static long o = 0L;
    private static bbd p;
    private static boolean q = false;

    protected azd(Context context, bbb bbb1, bbc bbc)
    {
        super(context, bbb1, bbc);
    }

    private static String a(Context context, bbb bbb1)
    {
        if (m != null)
        {
            return m;
        }
        if (f == null)
        {
            throw new aze();
        }
        try
        {
            context = (ByteBuffer)f.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new aze(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new aze(context);
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        throw new aze();
        context = bbb1.a(context.array(), true);
        m = context;
        return context;
    }

    private static String a(byte abyte0[], String s)
    {
        try
        {
            abyte0 = new String(p.a(abyte0, s), "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new aze(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new aze(abyte0);
        }
        return abyte0;
    }

    private static ArrayList a(MotionEvent motionevent, DisplayMetrics displaymetrics)
    {
        if (g == null || motionevent == null)
        {
            throw new aze();
        }
        try
        {
            motionevent = (ArrayList)g.invoke(null, new Object[] {
                motionevent, displaymetrics
            });
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            throw new aze(motionevent);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            throw new aze(motionevent);
        }
        return motionevent;
    }

    protected static void a(String s, Context context, bbb bbb1)
    {
        azd;
        JVM INSTR monitorenter ;
        boolean flag = q;
        if (flag) goto _L2; else goto _L1
_L1:
        p = new bbd(bbb1, null);
        l = s;
        byte abyte0[];
        byte abyte1[];
        abyte0 = p.a(a.d());
        abyte1 = p.a(abyte0, a.e());
        bbb1 = context.getCacheDir();
        s = bbb1;
        if (bbb1 != null) goto _L4; else goto _L3
_L3:
        bbb1 = context.getDir("dex", 0);
        s = bbb1;
        if (bbb1 != null) goto _L4; else goto _L5
_L5:
        throw new aze();
        s;
        try
        {
            throw new aze(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        finally
        {
            azd;
        }
_L2:
        azd;
        JVM INSTR monitorexit ;
        return;
_L4:
        bbb1 = File.createTempFile("ads", ".jar", s);
        FileOutputStream fileoutputstream = new FileOutputStream(bbb1);
        fileoutputstream.write(abyte1, 0, abyte1.length);
        fileoutputstream.close();
        Object obj = new DexClassLoader(bbb1.getAbsolutePath(), s.getAbsolutePath(), null, context.getClassLoader());
        context = ((DexClassLoader) (obj)).loadClass(a(abyte0, a.h()));
        Class class1 = ((DexClassLoader) (obj)).loadClass(a(abyte0, a.t()));
        Class class2 = ((DexClassLoader) (obj)).loadClass(a(abyte0, a.n()));
        Class class3 = ((DexClassLoader) (obj)).loadClass(a(abyte0, a.l()));
        Class class4 = ((DexClassLoader) (obj)).loadClass(a(abyte0, a.v()));
        Class class5 = ((DexClassLoader) (obj)).loadClass(a(abyte0, a.j()));
        Class class6 = ((DexClassLoader) (obj)).loadClass(a(abyte0, a.r()));
        Class class7 = ((DexClassLoader) (obj)).loadClass(a(abyte0, a.p()));
        obj = ((DexClassLoader) (obj)).loadClass(a(abyte0, a.f()));
        c = context.getMethod(a(abyte0, a.i()), new Class[0]);
        d = class1.getMethod(a(abyte0, a.u()), new Class[0]);
        e = class2.getMethod(a(abyte0, a.o()), new Class[0]);
        f = class3.getMethod(a(abyte0, a.m()), new Class[] {
            android/content/Context
        });
        g = class4.getMethod(a(abyte0, a.w()), new Class[] {
            android/view/MotionEvent, android/util/DisplayMetrics
        });
        h = class5.getMethod(a(abyte0, a.k()), new Class[] {
            android/content/Context
        });
        i = class6.getMethod(a(abyte0, a.s()), new Class[] {
            android/content/Context
        });
        j = class7.getMethod(a(abyte0, a.q()), new Class[] {
            android/content/Context
        });
        k = ((Class) (obj)).getMethod(a(abyte0, a.g()), new Class[] {
            android/content/Context
        });
        context = bbb1.getName();
        bbb1.delete();
        (new File(s, context.replace(".jar", ".dex"))).delete();
        o = c().longValue();
        q = true;
        if (true) goto _L2; else goto _L6
_L6:
        context;
        String s1 = bbb1.getName();
        bbb1.delete();
        (new File(s, s1.replace(".jar", ".dex"))).delete();
        throw context;
        s;
        throw new aze(s);
        throw s;
        s;
        throw new aze(s);
        s;
        throw new aze(s);
        s;
        throw new aze(s);
        s;
        throw new aze(s);
    }

    private static String b()
    {
        if (l == null)
        {
            throw new aze();
        } else
        {
            return l;
        }
    }

    private static String b(Context context, bbb bbb1)
    {
        if (n != null)
        {
            return n;
        }
        if (i == null)
        {
            throw new aze();
        }
        try
        {
            context = (ByteBuffer)i.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new aze(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new aze(context);
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        throw new aze();
        context = bbb1.a(context.array(), true);
        n = context;
        return context;
    }

    private static Long c()
    {
        if (c == null)
        {
            throw new aze();
        }
        Long long1;
        try
        {
            long1 = (Long)c.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new aze(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new aze(invocationtargetexception);
        }
        return long1;
    }

    static String c(Context context)
    {
        if (h == null)
        {
            throw new aze();
        }
        try
        {
            context = (String)h.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new aze(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new aze(context);
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        throw new aze();
        return context;
    }

    private static String d()
    {
        if (e == null)
        {
            throw new aze();
        }
        String s;
        try
        {
            s = (String)e.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new aze(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new aze(invocationtargetexception);
        }
        return s;
    }

    private static ArrayList d(Context context)
    {
        if (j == null)
        {
            throw new aze();
        }
        try
        {
            context = (ArrayList)j.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new aze(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new aze(context);
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        if (context.size() == 2)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        throw new aze();
        return context;
    }

    private static Long e()
    {
        if (d == null)
        {
            throw new aze();
        }
        Long long1;
        try
        {
            long1 = (Long)d.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new aze(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new aze(invocationtargetexception);
        }
        return long1;
    }

    private static int[] e(Context context)
    {
        if (k == null)
        {
            throw new aze();
        }
        try
        {
            context = (int[])k.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new aze(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new aze(context);
        }
        return context;
    }

    protected final void a()
    {
        IOException ioexception;
        try
        {
            a(2, b());
        }
        catch (aze aze4) { }
        try
        {
            a(1, d());
        }
        catch (aze aze3) { }
        try
        {
            a(25, c().longValue());
        }
        catch (aze aze2) { }
        try
        {
            ArrayList arraylist = a(((MotionEvent) (null)), a);
            a(14, ((Long)arraylist.get(0)).longValue());
            a(15, ((Long)arraylist.get(1)).longValue());
            if (arraylist.size() >= 3)
            {
                a(16, ((Long)arraylist.get(2)).longValue());
            }
            return;
        }
        catch (aze aze1)
        {
            return;
        }
        ioexception;
    }

    protected void b(Context context)
    {
        try
        {
            a(1, d());
        }
        catch (aze aze7) { }
        try
        {
            a(2, b());
        }
        catch (aze aze6) { }
        try
        {
            long l1 = c().longValue();
            a(25, l1);
            if (o != 0L)
            {
                a(17, l1 - o);
                a(23, o);
            }
        }
        catch (aze aze5) { }
        try
        {
            ArrayList arraylist = d(context);
            a(31, ((Long)arraylist.get(0)).longValue());
            a(32, ((Long)arraylist.get(1)).longValue());
        }
        catch (aze aze4) { }
        try
        {
            a(33, e().longValue());
        }
        catch (aze aze3) { }
        try
        {
            a(27, a(context, b));
        }
        catch (aze aze2) { }
        try
        {
            a(29, b(context, b));
        }
        catch (aze aze1) { }
        try
        {
            context = e(context);
            a(5, context[0]);
            a(6, context[1]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        context;
    }

}
