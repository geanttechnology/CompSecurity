// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package com.google.android.gms.internal:
//            ct, ch, da, cf, 
//            cd, av, ci, cc, 
//            db

public abstract class cb extends ct
{
    public static final class a extends cb
    {

        private final Context mContext;

        public void aD()
        {
        }

        public ch aE()
        {
            return ci.a(mContext, new av());
        }

        public a(Context context, cd cd, ca.a a1)
        {
            super(cd, a1);
            mContext = context;
        }
    }

    public static final class b extends cb
        implements com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener
    {

        private final Object mg = new Object();
        private final ca.a nY;
        private final cc nZ;

        public void aD()
        {
            synchronized (mg)
            {
                if (nZ.isConnected() || nZ.isConnecting())
                {
                    nZ.disconnect();
                }
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public ch aE()
        {
            obj;
            JVM INSTR monitorenter ;
            ch ch1;
            synchronized (mg)
            {
                ch1 = nZ.aH();
            }
            return ch1;
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
            nY.a(new cf(0));
        }

        public void onDisconnected()
        {
            da.s("Disconnected from remote ad request service.");
        }

        public b(Context context, cd cd1, ca.a a1)
        {
            super(cd1, a1);
            nY = a1;
            nZ = new cc(context, this, this, cd1.kN.pW);
            nZ.connect();
        }
    }


    private final cd mf;
    private final ca.a nY;

    public cb(cd cd, ca.a a1)
    {
        mf = cd;
        nY = a1;
    }

    private static cf a(ch ch1, cd cd)
    {
        try
        {
            ch1 = ch1.b(cd);
        }
        // Misplaced declaration of an exception variable
        catch (ch ch1)
        {
            da.b("Could not fetch ad response from ad request service.", ch1);
            return null;
        }
        return ch1;
    }

    public final void aB()
    {
        Object obj = aE();
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = new cf(0);
_L4:
        aD();
        nY.a(((cf) (obj)));
        return;
_L2:
        cf cf1 = a(((ch) (obj)), mf);
        obj = cf1;
        if (cf1 != null) goto _L4; else goto _L3
_L3:
        obj = new cf(0);
          goto _L4
        Exception exception;
        exception;
        aD();
        throw exception;
    }

    public abstract void aD();

    public abstract ch aE();

    public final void onStop()
    {
        aD();
    }
}
