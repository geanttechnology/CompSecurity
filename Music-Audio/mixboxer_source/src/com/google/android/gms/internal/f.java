// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

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

// Referenced classes of package com.google.android.gms.internal:
//            e, j, l, n, 
//            k

public abstract class f extends e
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


    private static Method dA;
    private static Method dB;
    private static Method dC;
    private static Method dD;
    private static String dE;
    private static l dF;
    static boolean dG = false;
    private static Method dy;
    private static Method dz;
    private static long startTime = 0L;

    protected f(Context context, j j1, k k)
    {
        super(context, j1, k);
    }

    static String a(Context context, j j1)
        throws a
    {
        if (dA == null)
        {
            throw new a();
        }
        try
        {
            context = (ByteBuffer)dA.invoke(null, new Object[] {
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
            break MISSING_BLOCK_LABEL_55;
        }
        throw new a();
        context = j1.a(context.array(), true);
        return context;
    }

    static ArrayList a(MotionEvent motionevent, DisplayMetrics displaymetrics)
        throws a
    {
        if (dB == null || motionevent == null)
        {
            throw new a();
        }
        try
        {
            motionevent = (ArrayList)dB.invoke(null, new Object[] {
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

    protected static void a(String s, Context context, j j1)
    {
        com/google/android/gms/internal/f;
        JVM INSTR monitorenter ;
        boolean flag = dG;
        if (!flag)
        {
            try
            {
                dF = new l(j1, null);
                dE = s;
                e(context);
                startTime = e().longValue();
                dG = true;
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            finally
            {
                com/google/android/gms/internal/f;
            }
        }
        com/google/android/gms/internal/f;
        JVM INSTR monitorexit ;
        return;
        throw s;
    }

    static String b(Context context, j j1)
        throws a
    {
        if (dD == null)
        {
            throw new a();
        }
        try
        {
            context = (ByteBuffer)dD.invoke(null, new Object[] {
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
            break MISSING_BLOCK_LABEL_55;
        }
        throw new a();
        context = j1.a(context.array(), true);
        return context;
    }

    private static String b(byte abyte0[], String s)
        throws a
    {
        try
        {
            abyte0 = new String(dF.c(abyte0, s), "UTF-8");
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

    static String d()
        throws a
    {
        if (dE == null)
        {
            throw new a();
        } else
        {
            return dE;
        }
    }

    static String d(Context context)
        throws a
    {
        if (dC == null)
        {
            throw new a();
        }
        try
        {
            context = (String)dC.invoke(null, new Object[] {
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

    static Long e()
        throws a
    {
        if (dy == null)
        {
            throw new a();
        }
        Long long1;
        try
        {
            long1 = (Long)dy.invoke(null, new Object[0]);
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

    private static void e(Context context)
        throws a
    {
        File file;
        File file1;
        byte abyte0[];
        byte abyte1[];
        Class class1;
        Object obj;
        Class class2;
        Class class3;
        Object obj1;
        try
        {
            abyte0 = dF.d(n.getKey());
            abyte1 = dF.c(abyte0, n.i());
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
        context = ((DexClassLoader) (obj1)).loadClass(b(abyte0, n.j()));
        class1 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, n.p()));
        obj = ((DexClassLoader) (obj1)).loadClass(b(abyte0, n.n()));
        class2 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, n.t()));
        class3 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, n.l()));
        obj1 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, n.r()));
        dy = context.getMethod(b(abyte0, n.k()), new Class[0]);
        dz = class1.getMethod(b(abyte0, n.q()), new Class[0]);
        dA = ((Class) (obj)).getMethod(b(abyte0, n.o()), new Class[] {
            android/content/Context
        });
        dB = class2.getMethod(b(abyte0, n.u()), new Class[] {
            android/view/MotionEvent, android/util/DisplayMetrics
        });
        dC = class3.getMethod(b(abyte0, n.m()), new Class[] {
            android/content/Context
        });
        dD = ((Class) (obj1)).getMethod(b(abyte0, n.s()), new Class[] {
            android/content/Context
        });
        context = file1.getName();
        file1.delete();
        (new File(file, context.replace(".jar", ".dex"))).delete();
        return;
    }

    static String f()
        throws a
    {
        if (dz == null)
        {
            throw new a();
        }
        String s;
        try
        {
            s = (String)dz.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new a(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new a(invocationtargetexception);
        }
        return s;
    }

    protected void b(Context context)
    {
        try
        {
            a(1, f());
        }
        catch (a a3) { }
        try
        {
            a(2, d());
        }
        catch (a a2) { }
        try
        {
            a(25, e().longValue());
        }
        catch (a a1) { }
        try
        {
            a(24, d(context));
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
            a(2, d());
        }
        catch (a a5) { }
        try
        {
            a(1, f());
        }
        catch (a a4) { }
        try
        {
            long l1 = e().longValue();
            a(25, l1);
            if (startTime != 0L)
            {
                a(17, l1 - startTime);
                a(23, startTime);
            }
        }
        catch (a a3) { }
        try
        {
            ArrayList arraylist = a(du, dv);
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
            a(27, a(context, dw));
        }
        catch (a a1) { }
        try
        {
            a(29, b(context, dw));
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
