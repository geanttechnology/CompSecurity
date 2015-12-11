// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import java.io.IOException;

public final class att
{

    private Context a;
    private avz b;
    private bbw c;
    private boolean d;

    private att(Context context)
    {
        a.d(context);
        a = context;
        d = false;
    }

    private atu a()
    {
        a.i("Calling this from your main thread can lead to deadlock");
        a.d(b);
        a.d(c);
        if (!d)
        {
            throw new IOException("AdvertisingIdService is not connected.");
        }
        atu atu1;
        try
        {
            atu1 = new atu(c.a(), c.a(true));
        }
        catch (RemoteException remoteexception)
        {
            throw new IOException("Remote exception");
        }
        return atu1;
    }

    public static atu a(Context context)
    {
        context = new att(context);
        Object obj;
        a.i("Calling this from your main thread can lead to deadlock");
        if (((att) (context)).d)
        {
            context.b();
        }
        context.b = b(((att) (context)).a);
        obj = ((att) (context)).a;
        context.c = a(((att) (context)).b);
        context.d = true;
        obj = context.a();
        context.b();
        return ((atu) (obj));
        Exception exception;
        exception;
        context.b();
        throw exception;
    }

    private static bbw a(avz avz1)
    {
        try
        {
            avz1 = bbx.a(avz1.a());
        }
        // Misplaced declaration of an exception variable
        catch (avz avz1)
        {
            throw new IOException("Interrupted exception");
        }
        return avz1;
    }

    private static avz b(Context context)
    {
        avz avz1;
        Intent intent;
        try
        {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new avu(9);
        }
        try
        {
            avw.b(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IOException(context);
        }
        avz1 = new avz();
        intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, avz1, 1))
        {
            return avz1;
        } else
        {
            throw new IOException("Connection failure");
        }
    }

    private void b()
    {
        a.i("Calling this from your main thread can lead to deadlock");
        if (a == null || b == null)
        {
            return;
        }
        try
        {
            if (d)
            {
                a.unbindService(b);
            }
        }
        catch (IllegalArgumentException illegalargumentexception) { }
        d = false;
        c = null;
        b = null;
    }
}
