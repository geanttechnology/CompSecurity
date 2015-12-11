// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.Date;

public final class bc
{

    private static boolean a = false;
    private static boolean b = false;
    private static final Method c = a(java/lang/Throwable, "getSuppressed");

    public static StringBuilder a(InputStream inputstream)
    {
        if (inputstream != null) goto _L2; else goto _L1
_L1:
        inputstream = new StringBuilder();
_L4:
        return inputstream;
_L2:
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        StringBuilder stringbuilder = new StringBuilder();
        do
        {
            String s = bufferedreader.readLine();
            inputstream = stringbuilder;
            if (s == null)
            {
                continue;
            }
            stringbuilder.append(s);
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static Method a(Class class1, String s)
    {
        Method method;
        try
        {
            method = class1.getMethod(s, new Class[0]);
        }
        catch (Throwable throwable)
        {
            a((new StringBuilder("Agent couldn't find method ")).append(class1.getName()).append(".").append(s).toString());
            return null;
        }
        if (method == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        method.setAccessible(true);
        return method;
    }

    public static void a(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
        Log.e("ADInstrumentation", "Error closing input stream", closeable);
        return;
    }

    public static void a(String s)
    {
        if (a)
        {
            Log.d("ADInstrumentation", s);
        }
    }

    public static void a(String s, int i)
    {
        if (a)
        {
            Log.d("ADInstrumentation", String.format(s, new Object[] {
                Integer.valueOf(i)
            }));
        }
    }

    public static void a(String s, Object obj)
    {
        if (a)
        {
            Log.d("ADInstrumentation", String.format(s, new Object[] {
                obj
            }));
        }
    }

    public static void a(String s, Object obj, Object obj1)
    {
        if (a)
        {
            Log.d("ADInstrumentation", String.format(s, new Object[] {
                obj, obj1
            }));
        }
    }

    public static void a(String s, Throwable throwable)
    {
        if (a)
        {
            Log.d("ADInstrumentation", s, throwable);
        }
    }

    public static void a(boolean flag)
    {
        a = flag;
    }

    public static boolean a()
    {
        return a;
    }

    public static Throwable[] a(Throwable throwable)
    {
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        throwable = (Throwable[])c.invoke(throwable, new Object[0]);
        return throwable;
        throwable;
        return new Throwable[0];
    }

    public static String b()
    {
        return DateFormat.getTimeInstance(0).format(new Date());
    }

    public static void b(String s, Throwable throwable)
    {
        Log.e("ADInstrumentation", s, throwable);
    }

}
