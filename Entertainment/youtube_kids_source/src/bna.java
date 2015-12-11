// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.lang.reflect.Method;

public final class bna
{

    private static Method a;

    public static String a(String s)
    {
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        s = (String)a.invoke(null, new Object[] {
            s
        });
        return s;
        s;
        bmo.b("Exception getting system property: ", s);
        return null;
    }

    static 
    {
        Object obj = ClassLoader.getSystemClassLoader();
        try
        {
            obj = ((ClassLoader) (obj)).loadClass("android.os.SystemProperties").getMethod("get", new Class[] {
                java/lang/String
            });
            a = ((Method) (obj));
        }
        catch (Exception exception)
        {
            bmo.b("Exception looking up system properties methods: ", exception);
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        bmo.c("Couldn't load system properties getString");
    }
}
