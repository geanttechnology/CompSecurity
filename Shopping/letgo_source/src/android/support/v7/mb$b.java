// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package android.support.v7:
//            mb

private static final class a
    implements Runnable
{

    private Context a;

    public void run()
    {
        AdvertisingIdClient advertisingidclient;
        advertisingidclient = new AdvertisingIdClient(a);
        advertisingidclient.start();
        android/support/v7/mb;
        JVM INSTR monitorenter ;
        if (mb.f() != null) goto _L2; else goto _L1
_L1:
        mb.a(advertisingidclient);
_L3:
        android/support/v7/mb;
        JVM INSTR monitorexit ;
_L4:
        mb.g().countDown();
        return;
_L2:
        advertisingidclient.finish();
          goto _L3
        Exception exception;
        exception;
        android/support/v7/mb;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch (c c1)
        {
            mb.a(true);
        }
        catch (IOException ioexception) { }
        catch (d d1) { }
          goto _L4
    }

    public ommon.d(Context context)
    {
        a = context.getApplicationContext();
        if (a == null)
        {
            a = context;
        }
    }
}
