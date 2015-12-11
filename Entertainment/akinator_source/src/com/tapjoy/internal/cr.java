// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package com.tapjoy.internal:
//            cs, ag

public final class cr
{
    static final class a
        implements ServiceConnection
    {

        boolean a;
        private final BlockingQueue b = new LinkedBlockingQueue();

        public static a a(Context context)
        {
            if (ag.b(context.getPackageManager(), "com.google.android.gms") < 0x3d0900)
            {
                throw new IOException("Google Play services not available.");
            }
            a a1 = new a();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, a1, 1))
            {
                return a1;
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
                return cs.a.a((IBinder)b.take());
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

        private a()
        {
            a = false;
        }
    }


    public String a;
    public boolean b;

    public cr()
    {
    }

    public final boolean a(Context context)
    {
        if (Looper.myLooper() != Looper.getMainLooper()) goto _L2; else goto _L1
_L1:
        if (!"unknown".equals(Build.DEVICE)) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        throw new IllegalStateException("Calling this from your main thread can lead to deadlock");
_L2:
        Object obj1;
        a a2;
        a a3;
        a a4;
        a a5;
        a a6;
        a2 = null;
        a3 = null;
        a4 = null;
        a5 = null;
        a6 = null;
        obj1 = null;
        a a1 = a.a(context);
        obj1 = a1;
        a2 = a1;
        a3 = a1;
        a4 = a1;
        a5 = a1;
        a6 = a1;
        cs cs1 = a1.a();
        obj1 = a1;
        a2 = a1;
        a3 = a1;
        a4 = a1;
        a5 = a1;
        a6 = a1;
        a = cs1.a();
        obj1 = a1;
        a2 = a1;
        a3 = a1;
        a5 = a1;
        a6 = a1;
        b = cs1.a(true);
_L5:
        Object obj;
        if (a1 != null)
        {
            try
            {
                context.unbindService(a1);
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        return true;
        obj1;
          goto _L5
        obj;
        if (obj1 != null)
        {
            try
            {
                context.unbindService(((ServiceConnection) (obj1)));
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return false;
            }
            return false;
        }
          goto _L3
        obj;
        if (a2 != null)
        {
            try
            {
                context.unbindService(a2);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return false;
            }
            return false;
        }
          goto _L3
        obj;
        if (a3 != null)
        {
            try
            {
                context.unbindService(a3);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return false;
            }
            return false;
        }
          goto _L3
        obj;
        if (a4 != null)
        {
            try
            {
                context.unbindService(a4);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return false;
            }
            return false;
        }
          goto _L3
        obj;
        if (a5 == null) goto _L3; else goto _L6
_L6:
        try
        {
            context.unbindService(a5);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return false;
        obj;
        if (a6 != null)
        {
            try
            {
                context.unbindService(a6);
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        throw obj;
    }
}
