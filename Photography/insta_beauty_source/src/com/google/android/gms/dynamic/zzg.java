// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzu;

public abstract class zzg
{

    private final String zzaju;
    private Object zzajv;

    public zzg(String s)
    {
        zzaju = s;
    }

    public final Object zzak(Context context)
    {
        if (zzajv == null)
        {
            zzu.zzu(context);
            context = GooglePlayServicesUtil.getRemoteContext(context);
            if (context == null)
            {
                throw new zza("Could not get remote context.");
            }
            context = context.getClassLoader();
            try
            {
                zzajv = zzd((IBinder)context.loadClass(zzaju).newInstance());
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new zza("Could not load creator class.", context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new zza("Could not instantiate creator.", context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new zza("Could not access creator.", context);
            }
        }
        return zzajv;
    }

    public abstract Object zzd(IBinder ibinder);

    private class zza extends Exception
    {

        public zza(String s)
        {
            super(s);
        }

        public zza(String s, Throwable throwable)
        {
            super(s, throwable);
        }
    }

}
