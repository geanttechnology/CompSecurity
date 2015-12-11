// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package com.tapjoy.internal:
//            cr, ag, cs

static final class a
    implements ServiceConnection
{

    boolean a;
    private final BlockingQueue b = new LinkedBlockingQueue();

    public static nnection a(Context context)
    {
        if (ag.b(context.getPackageManager(), "com.google.android.gms") < 0x3d0900)
        {
            throw new IOException("Google Play services not available.");
        }
        eManager emanager = new <init>();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, emanager, 1))
        {
            return emanager;
        } else
        {
            throw new IOException("Connection failure");
        }
    }

    public final cs a()
    {
        if (a)
        {
            throw new IllegalStateException();
        } else
        {
            a = true;
            return a((IBinder)b.take());
        }
    }

    public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        try
        {
            b.put(ibinder);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ComponentName componentname)
        {
            return;
        }
    }

    public final void onServiceDisconnected(ComponentName componentname)
    {
    }

    private Name()
    {
        a = false;
    }
}
