// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            b, av, ad, a, 
//            aq, t

public class au extends hb
{

    private final ExecutorService agU = Executors.newCachedThreadPool();
    private final HashMap ame = new HashMap();
    private final HashMap amf = new HashMap();
    private final HashMap amg = new HashMap();

    public au(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, connectioncallbacks, onconnectionfailedlistener, new String[0]);
    }

    protected void a(int i, IBinder ibinder, Bundle bundle)
    {
        if (Log.isLoggable("WearableClient", 2))
        {
            Log.d("WearableClient", (new StringBuilder()).append("onPostInitHandler: statusCode ").append(i).toString());
        }
        if (i != 0) goto _L2; else goto _L1
_L1:
        Object obj;
        ad ad1;
        obj = new a() {

            final au amh;

            public void a(Status status)
            {
            }

            
            {
                amh = au.this;
                super();
            }
        };
        if (Log.isLoggable("WearableClient", 2))
        {
            Log.d("WearableClient", (new StringBuilder()).append("onPostInitHandler: service ").append(ibinder).toString());
        }
        ad1 = ad.a.by(ibinder);
        java.util.Map.Entry entry;
        for (Iterator iterator = ame.entrySet().iterator(); iterator.hasNext(); ad1.a(((ab) (obj)), new b((av)entry.getValue())))
        {
            entry = (java.util.Map.Entry)iterator.next();
            if (Log.isLoggable("WearableClient", 2))
            {
                Log.d("WearableClient", (new StringBuilder()).append("onPostInitHandler: adding Data listener ").append(entry.getValue()).toString());
            }
        }

          goto _L3
_L2:
        Log.d("WearableClient", "WearableClientImpl.onPostInitHandler: done");
        super.a(i, ibinder, bundle);
        return;
_L3:
        java.util.Map.Entry entry1;
        for (Iterator iterator1 = amf.entrySet().iterator(); iterator1.hasNext(); ad1.a(((ab) (obj)), new b((av)entry1.getValue())))
        {
            entry1 = (java.util.Map.Entry)iterator1.next();
            if (Log.isLoggable("WearableClient", 2))
            {
                Log.d("WearableClient", (new StringBuilder()).append("onPostInitHandler: adding Message listener ").append(entry1.getValue()).toString());
            }
        }

        try
        {
            Iterator iterator2 = amg.entrySet().iterator();
            while (iterator2.hasNext()) 
            {
                java.util.Map.Entry entry2 = (java.util.Map.Entry)iterator2.next();
                if (Log.isLoggable("WearableClient", 2))
                {
                    Log.d("WearableClient", (new StringBuilder()).append("onPostInitHandler: adding Node listener ").append(entry2.getValue()).toString());
                }
                ad1.a(((ab) (obj)), new b((av)entry2.getValue()));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.d("WearableClient", "WearableClientImpl.onPostInitHandler: error while adding listener", ((Throwable) (obj)));
        }
        if (true) goto _L2; else goto _L4
_L4:
    }

    public void a(com.google.android.gms.common.api.a.d d, String s, String s1, byte abyte0[])
        throws RemoteException
    {
        ((ad)ft()).a(new a(d) {

            final au amh;
            final com.google.android.gms.common.api.a.d ami;

            public void a(aq aq1)
            {
                ami.a(new ae.a(new Status(aq1.statusCode), aq1.amc));
            }

            
            {
                amh = au.this;
                ami = d;
                super();
            }
        }, s, s1, abyte0);
    }

    protected void a(hi hi1, com.google.android.gms.internal.hb.e e)
        throws RemoteException
    {
        hi1.e(e, 0x4da6e8, getContext().getPackageName());
    }

    protected String bu()
    {
        return "com.google.android.gms.wearable.BIND";
    }

    protected String bv()
    {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    protected ad bz(IBinder ibinder)
    {
        return ad.a.by(ibinder);
    }

    public void disconnect()
    {
        super.disconnect();
        ame.clear();
        amf.clear();
        amg.clear();
    }

    public void q(com.google.android.gms.common.api.a.d d)
        throws RemoteException
    {
        ((ad)ft()).f(new a(d) {

            final au amh;
            final com.google.android.gms.common.api.a.d ami;

            public void a(t t1)
            {
                ArrayList arraylist = new ArrayList();
                arraylist.addAll(t1.alN);
                ami.a(new ah.a(new Status(t1.statusCode), arraylist));
            }

            
            {
                amh = au.this;
                ami = d;
                super();
            }
        });
    }

    protected IInterface x(IBinder ibinder)
    {
        return bz(ibinder);
    }
}
