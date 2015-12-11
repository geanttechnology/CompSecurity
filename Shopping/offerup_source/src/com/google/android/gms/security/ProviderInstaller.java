// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import java.lang.reflect.Method;

public class ProviderInstaller
{

    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static Method zzaUV = null;
    private static final GoogleApiAvailability zzacJ = GoogleApiAvailability.getInstance();
    private static final Object zzpy = new Object();

    public ProviderInstaller()
    {
    }

    public static void installIfNeeded(Context context)
    {
        Context context1;
        zzx.zzb(context, "Context must not be null");
        zzacJ.zzab(context);
        context1 = GooglePlayServicesUtil.getRemoteContext(context);
        if (context1 == null)
        {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new GooglePlayServicesNotAvailableException(8);
        }
        if (true) goto _L2; else goto _L1
_L1:
        context;
        JVM INSTR monitorenter ;
_L2:
        synchronized (zzpy)
        {
            if (zzaUV == null)
            {
                zzaM(context1);
            }
            zzaUV.invoke(null, new Object[] {
                context1
            });
        }
        return;
        Exception exception;
        exception;
        Log.e("ProviderInstaller", (new StringBuilder("Failed to install provider: ")).append(exception.getMessage()).toString());
        throw new GooglePlayServicesNotAvailableException(8);
        exception1;
        context;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerinstalllistener)
    {
        zzx.zzb(context, "Context must not be null");
        zzx.zzb(providerinstalllistener, "Listener must not be null");
        zzx.zzci("Must be called on the UI thread");
        (new _cls1(context, providerinstalllistener)).execute(new Void[0]);
    }

    static GoogleApiAvailability zzCd()
    {
        return zzacJ;
    }

    private static void zzaM(Context context)
    {
        zzaUV = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[] {
            android/content/Context
        });
    }


    private class _cls1 extends AsyncTask
    {

        final ProviderInstallListener zzaUW;
        final Context zzry;

        protected final Object doInBackground(Object aobj[])
        {
            return zzc((Void[])aobj);
        }

        protected final void onPostExecute(Object obj)
        {
            zze((Integer)obj);
        }

        protected final transient Integer zzc(Void avoid[])
        {
            try
            {
                ProviderInstaller.installIfNeeded(zzry);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return Integer.valueOf(avoid.getConnectionStatusCode());
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return Integer.valueOf(((GooglePlayServicesNotAvailableException) (avoid)).errorCode);
            }
            return Integer.valueOf(0);
        }

        protected final void zze(Integer integer)
        {
            if (integer.intValue() == 0)
            {
                zzaUW.onProviderInstalled();
                return;
            } else
            {
                Intent intent = ProviderInstaller.zzCd().zza(zzry, integer.intValue(), "pi");
                zzaUW.onProviderInstallFailed(integer.intValue(), intent);
                return;
            }
        }

        _cls1(Context context, ProviderInstallListener providerinstalllistener)
        {
            zzry = context;
            zzaUW = providerinstalllistener;
            super();
        }

        private class ProviderInstallListener
        {

            public abstract void onProviderInstallFailed(int i, Intent intent);

            public abstract void onProviderInstalled();
        }

    }

}
