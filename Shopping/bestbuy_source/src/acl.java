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

public abstract class acl extends ack
{

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
    private static String n;
    private static String o;
    private static String p;
    private static long q = 0L;
    private static afp r;

    protected acl(Context context, aek aek1, aem aem)
    {
        super(context, aek1, aem);
    }

    static String a()
    {
        if (n == null)
        {
            throw new acm();
        } else
        {
            return n;
        }
    }

    static String a(Context context, aek aek1)
    {
        if (o != null)
        {
            return o;
        }
        if (h == null)
        {
            throw new acm();
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
            throw new acm(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new acm(context);
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        throw new acm();
        o = aek1.a(context.array(), true);
        context = o;
        return context;
    }

    static ArrayList a(MotionEvent motionevent, DisplayMetrics displaymetrics)
    {
        if (i == null || motionevent == null)
        {
            throw new acm();
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
            throw new acm(motionevent);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            throw new acm(motionevent);
        }
        return motionevent;
    }

    protected static void a(String s, Context context, aek aek1)
    {
        acl;
        JVM INSTR monitorenter ;
        boolean flag = d;
        if (!flag)
        {
            try
            {
                r = new afp(aek1, null);
                n = s;
                g(context);
                q = b().longValue();
                d = true;
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            finally
            {
                acl;
            }
        }
        acl;
        JVM INSTR monitorexit ;
        return;
        throw s;
    }

    static Long b()
    {
        if (e == null)
        {
            throw new acm();
        }
        Long long1;
        try
        {
            long1 = (Long)e.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new acm(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new acm(invocationtargetexception);
        }
        return long1;
    }

    static String b(Context context, aek aek1)
    {
        if (p != null)
        {
            return p;
        }
        if (k == null)
        {
            throw new acm();
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
            throw new acm(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new acm(context);
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        throw new acm();
        p = aek1.a(context.array(), true);
        context = p;
        return context;
    }

    private static String b(byte abyte0[], String s)
    {
        try
        {
            abyte0 = new String(r.a(abyte0, s), "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new acm(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new acm(abyte0);
        }
        return abyte0;
    }

    static String c()
    {
        if (g == null)
        {
            throw new acm();
        }
        String s;
        try
        {
            s = (String)g.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new acm(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new acm(invocationtargetexception);
        }
        return s;
    }

    static Long d()
    {
        if (f == null)
        {
            throw new acm();
        }
        Long long1;
        try
        {
            long1 = (Long)f.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new acm(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new acm(invocationtargetexception);
        }
        return long1;
    }

    static String d(Context context)
    {
        if (j == null)
        {
            throw new acm();
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
            throw new acm(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new acm(context);
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        throw new acm();
        return context;
    }

    static ArrayList e(Context context)
    {
        if (l == null)
        {
            throw new acm();
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
            throw new acm(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new acm(context);
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        if (context.size() == 2)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        throw new acm();
        return context;
    }

    static int[] f(Context context)
    {
        if (m == null)
        {
            throw new acm();
        }
        try
        {
            context = (int[])(int[])m.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new acm(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new acm(context);
        }
        return context;
    }

    private static void g(Context context)
    {
        File file;
        File file1;
        byte abyte0[];
        String s;
        byte abyte1[];
        Class class1;
        Object obj;
        Class class2;
        Class class3;
        Class class4;
        Class class5;
        Class class6;
        Object obj1;
        try
        {
            abyte0 = r.a(afz.a());
            abyte1 = r.a(abyte0, afz.b());
            file1 = context.getCacheDir();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new acm(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new acm(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new acm(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new acm(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new acm(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new acm(context);
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
        throw new acm();
        file1 = File.createTempFile("ads", ".jar", file);
        obj = new FileOutputStream(file1);
        ((FileOutputStream) (obj)).write(abyte1, 0, abyte1.length);
        ((FileOutputStream) (obj)).close();
        obj1 = new DexClassLoader(file1.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
        context = ((DexClassLoader) (obj1)).loadClass(b(abyte0, afz.e()));
        class1 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, afz.q()));
        obj = ((DexClassLoader) (obj1)).loadClass(b(abyte0, afz.k()));
        class2 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, afz.i()));
        class3 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, afz.s()));
        class4 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, afz.g()));
        class5 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, afz.o()));
        class6 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, afz.m()));
        obj1 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, afz.c()));
        e = context.getMethod(b(abyte0, afz.f()), new Class[0]);
        f = class1.getMethod(b(abyte0, afz.r()), new Class[0]);
        g = ((Class) (obj)).getMethod(b(abyte0, afz.l()), new Class[0]);
        h = class2.getMethod(b(abyte0, afz.j()), new Class[] {
            android/content/Context
        });
        i = class3.getMethod(b(abyte0, afz.t()), new Class[] {
            android/view/MotionEvent, android/util/DisplayMetrics
        });
        j = class4.getMethod(b(abyte0, afz.h()), new Class[] {
            android/content/Context
        });
        k = class5.getMethod(b(abyte0, afz.p()), new Class[] {
            android/content/Context
        });
        l = class6.getMethod(b(abyte0, afz.n()), new Class[] {
            android/content/Context
        });
        m = ((Class) (obj1)).getMethod(b(abyte0, afz.d()), new Class[] {
            android/content/Context
        });
        context = file1.getName();
        file1.delete();
        (new File(file, context.replace(".jar", ".dex"))).delete();
        return;
        context;
        s = file1.getName();
        file1.delete();
        (new File(file, s.replace(".jar", ".dex"))).delete();
        throw context;
    }

    protected void b(Context context)
    {
        try
        {
            a(1, c());
        }
        catch (acm acm7) { }
        try
        {
            a(2, a());
        }
        catch (acm acm6) { }
        try
        {
            long l1 = b().longValue();
            a(25, l1);
            if (q != 0L)
            {
                a(17, l1 - q);
                a(23, q);
            }
        }
        catch (acm acm5) { }
        try
        {
            ArrayList arraylist = e(context);
            a(31, ((Long)arraylist.get(0)).longValue());
            a(32, ((Long)arraylist.get(1)).longValue());
        }
        catch (acm acm4) { }
        try
        {
            a(33, d().longValue());
        }
        catch (acm acm3) { }
        try
        {
            a(27, a(context, c));
        }
        catch (acm acm2) { }
        try
        {
            a(29, b(context, c));
        }
        catch (acm acm1) { }
        try
        {
            context = f(context);
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

    protected void c(Context context)
    {
        try
        {
            a(2, a());
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        try
        {
            a(1, c());
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        try
        {
            a(25, b().longValue());
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        try
        {
            context = a(a, b);
            a(14, ((Long)context.get(0)).longValue());
            a(15, ((Long)context.get(1)).longValue());
            if (context.size() >= 3)
            {
                a(16, ((Long)context.get(2)).longValue());
            }
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
