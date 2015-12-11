// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

// Referenced classes of package com.google.ads.conversiontracking:
//            m, n, s, q, 
//            t, o

public final class l
{
    public static final class a
    {

        private final String a;
        private final boolean b;

        public String a()
        {
            return a;
        }

        public boolean b()
        {
            return b;
        }

        public a(String s1, boolean flag)
        {
            a = s1;
            b = flag;
        }
    }


    public static a a(Context context)
        throws IOException, IllegalStateException, m, n
    {
        s.a("Calling this from your main thread can lead to deadlock");
        return a(context, b(context));
    }

    static a a(Context context, q q1)
        throws IOException
    {
        Object obj;
        obj = t.a.a(q1.a());
        obj = new a(((t) (obj)).a(), ((t) (obj)).a(true));
        try
        {
            context.unbindService(q1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.i("AdvertisingIdClient", "getAdvertisingIdInfo unbindService failed.", context);
            return ((a) (obj));
        }
        return ((a) (obj));
        Object obj1;
        obj1;
        Log.i("AdvertisingIdClient", "GMS remote exception ", ((Throwable) (obj1)));
        throw new IOException("Remote exception");
        obj1;
        try
        {
            context.unbindService(q1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.i("AdvertisingIdClient", "getAdvertisingIdInfo unbindService failed.", context);
        }
        throw obj1;
        obj1;
        throw new IOException("Interrupted exception");
    }

    private static q b(Context context)
        throws IOException, m, n
    {
        q q1;
        Intent intent;
        try
        {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new m(9);
        }
        try
        {
            o.b(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IOException(context);
        }
        q1 = new q();
        intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, q1, 1))
        {
            return q1;
        } else
        {
            throw new IOException("Connection failure");
        }
    }
}
