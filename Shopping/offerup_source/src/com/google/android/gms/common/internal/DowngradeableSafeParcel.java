// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Field;

public abstract class DowngradeableSafeParcel
    implements SafeParcelable
{

    private static final Object zzafm = new Object();
    private static ClassLoader zzafn = null;
    private static Integer zzafo = null;
    private boolean zzafp;

    public DowngradeableSafeParcel()
    {
        zzafp = false;
    }

    private static boolean zza(Class class1)
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

    protected static boolean zzck(String s)
    {
        ClassLoader classloader = zzoS();
        if (classloader == null)
        {
            return true;
        }
        boolean flag;
        try
        {
            flag = zza(classloader.loadClass(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return flag;
    }

    protected static ClassLoader zzoS()
    {
        ClassLoader classloader;
        synchronized (zzafm)
        {
            classloader = zzafn;
        }
        return classloader;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static Integer zzoT()
    {
        Integer integer;
        synchronized (zzafm)
        {
            integer = zzafo;
        }
        return integer;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected boolean zzoU()
    {
        return zzafp;
    }

}
