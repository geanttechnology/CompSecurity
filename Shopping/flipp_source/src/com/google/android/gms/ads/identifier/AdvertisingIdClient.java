// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.e;
import com.google.android.gms.common.g;
import com.google.android.gms.common.i;
import com.google.android.gms.internal.kn;
import com.google.android.gms.internal.ko;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public final class AdvertisingIdClient
{

    public AdvertisingIdClient()
    {
    }

    private static i g(Context context)
    {
        i j;
        Intent intent;
        try
        {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new e(9);
        }
        try
        {
            com.google.android.gms.common.g.b(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IOException(context);
        }
        j = new i();
        intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, j, 1))
        {
            return j;
        } else
        {
            throw new IOException("Connection failure");
        }
    }

    public static Info getAdvertisingIdInfo(Context context)
    {
        i j;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            throw new IllegalStateException("Calling this from your main thread can lead to deadlock");
        }
        j = g(context);
        if (j.a)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_67;
        Object obj;
        obj;
        Log.i("AdvertisingIdClient", "GMS remote exception ", ((Throwable) (obj)));
        throw new IOException("Remote exception");
        obj;
        context.unbindService(j);
        throw obj;
        Object obj1;
        j.a = true;
        obj1 = ko.a((IBinder)j.b.take());
        obj1 = new Info(((kn) (obj1)).a(), ((kn) (obj1)).a(true));
        context.unbindService(j);
        return ((Info) (obj1));
        obj1;
        throw new IOException("Interrupted exception");
    }

    private class Info
    {

        private final String eb;
        private final boolean ec;

        public final String getId()
        {
            return eb;
        }

        public final boolean isLimitAdTrackingEnabled()
        {
            return ec;
        }

        Info(String s, boolean flag)
        {
            eb = s;
            ec = flag;
        }
    }

}
