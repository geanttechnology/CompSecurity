// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package com.google.android.gms.internal:
//            cm, cd, ct, cb, 
//            bz, ar, ce, by, 
//            cu

public abstract class bx extends cm
{
    public static final class a extends bx
    {

        private final Context mContext;

        public void ak()
        {
        }

        public cd al()
        {
            return ce.a(mContext, new ar());
        }

        public a(Context context, bz bz, bw.a a1)
        {
            super(bz, a1);
            mContext = context;
        }
    }

    public static final class b extends bx
        implements com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener
    {

        private final Object fx = new Object();
        private final bw.a hn;
        private final by ho;

        public void ak()
        {
            synchronized (fx)
            {
                if (ho.isConnected() || ho.isConnecting())
                {
                    ho.disconnect();
                }
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public cd al()
        {
            obj;
            JVM INSTR monitorenter ;
            cd cd1;
            synchronized (fx)
            {
                cd1 = ho.ao();
            }
            return cd1;
            IllegalStateException illegalstateexception;
            illegalstateexception;
            obj;
            JVM INSTR monitorexit ;
            return null;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void onConnected(Bundle bundle)
        {
            start();
        }

        public void onConnectionFailed(ConnectionResult connectionresult)
        {
            hn.a(new cb(0));
        }

        public void onDisconnected()
        {
            ct.r("Disconnected from remote ad request service.");
        }

        public b(Context context, bz bz1, bw.a a1)
        {
            super(bz1, a1);
            hn = a1;
            ho = new by(context, this, this, bz1.ej.iL);
            ho.connect();
        }
    }


    private final bz fw;
    private final bw.a hn;

    public bx(bz bz, bw.a a1)
    {
        fw = bz;
        hn = a1;
    }

    private static cb a(cd cd1, bz bz)
    {
        try
        {
            cd1 = cd1.b(bz);
        }
        // Misplaced declaration of an exception variable
        catch (cd cd1)
        {
            ct.b("Could not fetch ad response from ad request service.", cd1);
            return null;
        }
        return cd1;
    }

    public final void ai()
    {
        Object obj = al();
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = new cb(0);
_L4:
        ak();
        hn.a(((cb) (obj)));
        return;
_L2:
        cb cb1 = a(((cd) (obj)), fw);
        obj = cb1;
        if (cb1 != null) goto _L4; else goto _L3
_L3:
        obj = new cb(0);
          goto _L4
        Exception exception;
        exception;
        ak();
        throw exception;
    }

    public abstract void ak();

    public abstract cd al();

    public final void onStop()
    {
        ak();
    }
}
