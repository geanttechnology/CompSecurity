// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

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

// Referenced classes of package android.support.v7:
//            lz, me, mg, mi, 
//            mf

public abstract class ma extends lz
{
    static class a extends Exception
    {

        public a()
        {
        }

        public a(Throwable throwable)
        {
            super(throwable);
        }
    }


    static boolean d = false;
    private static Method e;
    private static Method f;
    private static Method g;
    private static Method h;
    private static Method i;
    private static Method j;
    private static Method k;
    private static Method l;
    private static Method m;
    private static Method n;
    private static Method o;
    private static Method p;
    private static Method q;
    private static String r;
    private static String s;
    private static String t;
    private static long u = 0L;
    private static mg v;

    protected ma(Context context, me me1, mf mf)
    {
        super(context, me1, mf);
    }

    static String a()
        throws a
    {
        if (r == null)
        {
            throw new a();
        } else
        {
            return r;
        }
    }

    static String a(Context context, me me1)
        throws a
    {
        if (s != null)
        {
            return s;
        }
        if (h == null)
        {
            throw new a();
        }
        try
        {
            context = (ByteBuffer)h.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        throw new a();
        s = me1.a(context.array(), true);
        context = s;
        return context;
    }

    static ArrayList a(MotionEvent motionevent, DisplayMetrics displaymetrics)
        throws a
    {
        if (i == null || motionevent == null)
        {
            throw new a();
        }
        try
        {
            motionevent = (ArrayList)i.invoke(null, new Object[] {
                motionevent, displaymetrics
            });
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            throw new a(motionevent);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            throw new a(motionevent);
        }
        return motionevent;
    }

    protected static void a(String s1, Context context, me me1)
    {
        android/support/v7/ma;
        JVM INSTR monitorenter ;
        boolean flag = d;
        if (!flag)
        {
            try
            {
                v = new mg(me1, null);
                r = s1;
                j(context);
                u = b().longValue();
                d = true;
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
            finally
            {
                android/support/v7/ma;
            }
        }
        android/support/v7/ma;
        JVM INSTR monitorexit ;
        return;
        throw s1;
    }

    static Long b()
        throws a
    {
        if (e == null)
        {
            throw new a();
        }
        Long long1;
        try
        {
            long1 = (Long)e.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new a(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new a(invocationtargetexception);
        }
        return long1;
    }

    static String b(Context context, me me1)
        throws a
    {
        if (t != null)
        {
            return t;
        }
        if (k == null)
        {
            throw new a();
        }
        try
        {
            context = (ByteBuffer)k.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        throw new a();
        t = me1.a(context.array(), true);
        context = t;
        return context;
    }

    private static String b(byte abyte0[], String s1)
        throws a
    {
        try
        {
            abyte0 = new String(v.a(abyte0, s1), "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new a(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new a(abyte0);
        }
        return abyte0;
    }

    static String c()
        throws a
    {
        if (g == null)
        {
            throw new a();
        }
        String s1;
        try
        {
            s1 = (String)g.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new a(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new a(invocationtargetexception);
        }
        return s1;
    }

    static String c(Context context)
        throws a
    {
        if (j == null)
        {
            throw new a();
        }
        try
        {
            context = (String)j.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        throw new a();
        return context;
    }

    static Long d()
        throws a
    {
        if (f == null)
        {
            throw new a();
        }
        Long long1;
        try
        {
            long1 = (Long)f.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new a(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new a(invocationtargetexception);
        }
        return long1;
    }

    static String d(Context context)
        throws a
    {
        if (n == null)
        {
            throw new a();
        }
        try
        {
            context = (String)n.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        return context;
    }

    static Long e(Context context)
        throws a
    {
        if (o == null)
        {
            throw new a();
        }
        try
        {
            context = (Long)o.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        return context;
    }

    static ArrayList f(Context context)
        throws a
    {
        if (l == null)
        {
            throw new a();
        }
        try
        {
            context = (ArrayList)l.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        if (context.size() == 2)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        throw new a();
        return context;
    }

    static int[] g(Context context)
        throws a
    {
        if (m == null)
        {
            throw new a();
        }
        try
        {
            context = (int[])m.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        return context;
    }

    static int h(Context context)
        throws a
    {
        if (p == null)
        {
            throw new a();
        }
        int i1;
        try
        {
            i1 = ((Integer)p.invoke(null, new Object[] {
                context
            })).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        return i1;
    }

    static int i(Context context)
        throws a
    {
        if (q == null)
        {
            throw new a();
        }
        int i1;
        try
        {
            i1 = ((Integer)q.invoke(null, new Object[] {
                context
            })).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        return i1;
    }

    private static void j(Context context)
        throws a
    {
        File file;
        File file1;
        byte abyte0[];
        String s1;
        byte abyte1[];
        Class class1;
        Object obj;
        Class class2;
        Class class3;
        Class class4;
        Class class5;
        Class class6;
        Class class7;
        Class class8;
        Class class9;
        Class class10;
        Object obj1;
        try
        {
            abyte0 = v.a(mi.a());
            abyte1 = v.a(abyte0, mi.b());
            file1 = context.getCacheDir();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        file = file1;
        if (file1 != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        file1 = context.getDir("dex", 0);
        file = file1;
        if (file1 != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        throw new a();
        file1 = File.createTempFile("ads", ".jar", file);
        obj = new FileOutputStream(file1);
        ((FileOutputStream) (obj)).write(abyte1, 0, abyte1.length);
        ((FileOutputStream) (obj)).close();
        obj1 = new DexClassLoader(file1.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
        context = ((DexClassLoader) (obj1)).loadClass(b(abyte0, mi.k()));
        class1 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, mi.y()));
        obj = ((DexClassLoader) (obj1)).loadClass(b(abyte0, mi.s()));
        class2 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, mi.o()));
        class3 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, mi.A()));
        class4 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, mi.m()));
        class5 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, mi.w()));
        class6 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, mi.u()));
        class7 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, mi.i()));
        class8 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, mi.g()));
        class9 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, mi.e()));
        class10 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, mi.q()));
        obj1 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, mi.c()));
        e = context.getMethod(b(abyte0, mi.l()), new Class[0]);
        f = class1.getMethod(b(abyte0, mi.z()), new Class[0]);
        g = ((Class) (obj)).getMethod(b(abyte0, mi.t()), new Class[0]);
        h = class2.getMethod(b(abyte0, mi.p()), new Class[] {
            android/content/Context
        });
        i = class3.getMethod(b(abyte0, mi.B()), new Class[] {
            android/view/MotionEvent, android/util/DisplayMetrics
        });
        j = class4.getMethod(b(abyte0, mi.n()), new Class[] {
            android/content/Context
        });
        k = class5.getMethod(b(abyte0, mi.x()), new Class[] {
            android/content/Context
        });
        l = class6.getMethod(b(abyte0, mi.v()), new Class[] {
            android/content/Context
        });
        m = class7.getMethod(b(abyte0, mi.j()), new Class[] {
            android/content/Context
        });
        n = class8.getMethod(b(abyte0, mi.h()), new Class[] {
            android/content/Context
        });
        o = class9.getMethod(b(abyte0, mi.f()), new Class[] {
            android/content/Context
        });
        p = class10.getMethod(b(abyte0, mi.r()), new Class[] {
            android/content/Context
        });
        q = ((Class) (obj1)).getMethod(b(abyte0, mi.d()), new Class[] {
            android/content/Context
        });
        context = file1.getName();
        file1.delete();
        (new File(file, context.replace(".jar", ".dex"))).delete();
        return;
        context;
        s1 = file1.getName();
        file1.delete();
        (new File(file, s1.replace(".jar", ".dex"))).delete();
        throw context;
    }

    protected void a(Context context)
    {
        try
        {
            a(1, c());
        }
        catch (a a11) { }
        try
        {
            a(2, a());
        }
        catch (a a10) { }
        try
        {
            long l1 = b().longValue();
            a(25, l1);
            if (u != 0L)
            {
                a(17, l1 - u);
                a(23, u);
            }
        }
        catch (a a9) { }
        try
        {
            ArrayList arraylist = f(context);
            a(31, ((Long)arraylist.get(0)).longValue());
            a(32, ((Long)arraylist.get(1)).longValue());
        }
        catch (a a8) { }
        try
        {
            a(33, d().longValue());
        }
        catch (a a7) { }
        try
        {
            a(27, a(context, c));
        }
        catch (a a6) { }
        try
        {
            a(29, b(context, c));
        }
        catch (a a5) { }
        try
        {
            int ai[] = g(context);
            a(5, ai[0]);
            a(6, ai[1]);
        }
        catch (a a4) { }
        try
        {
            a(12, h(context));
        }
        catch (a a3) { }
        try
        {
            a(3, i(context));
        }
        catch (a a2) { }
        try
        {
            a(34, d(context));
        }
        catch (a a1) { }
        try
        {
            a(35, e(context).longValue());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        context;
    }

    protected void b(Context context)
    {
        try
        {
            a(2, a());
        }
        catch (a a5) { }
        try
        {
            a(1, c());
        }
        catch (a a4) { }
        try
        {
            a(25, b().longValue());
        }
        catch (a a3) { }
        try
        {
            ArrayList arraylist = a(a, b);
            a(14, ((Long)arraylist.get(0)).longValue());
            a(15, ((Long)arraylist.get(1)).longValue());
            if (arraylist.size() >= 3)
            {
                a(16, ((Long)arraylist.get(2)).longValue());
            }
        }
        catch (a a2) { }
        try
        {
            a(34, d(context));
        }
        catch (a a1) { }
        try
        {
            a(35, e(context).longValue());
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
