// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Field;

public abstract class dv
    implements SafeParcelable
{

    private static final Object a = new Object();
    private static ClassLoader b = null;
    private static Integer c = null;
    public boolean s;

    public dv()
    {
        s = false;
    }

    private static ClassLoader a()
    {
        ClassLoader classloader;
        synchronized (a)
        {
            classloader = b;
        }
        return classloader;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static boolean a(Class class1)
    {
        boolean flag;
        try
        {
            flag = "SAFE_PARCELABLE_NULL_STRING".equals(class1.getField("NULL").get(null));
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return false;
        }
        return flag;
    }

    public static boolean b(String s1)
    {
        ClassLoader classloader = a();
        if (classloader == null)
        {
            return true;
        }
        boolean flag;
        try
        {
            flag = a(classloader.loadClass(s1));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return false;
        }
        return flag;
    }

    public static Integer t()
    {
        Integer integer;
        synchronized (a)
        {
            integer = c;
        }
        return integer;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
