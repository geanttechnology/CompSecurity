// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.internal:
//            eh, hh, ib, en, 
//            er, hg, hl, ed

public class hi extends eh
{
    private final class a extends eh.b
    {

        private final String Lt[];
        final hi Lu;
        private final int yJ;

        protected void a(com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener onaddgeofencesresultlistener)
        {
            if (onaddgeofencesresultlistener != null)
            {
                onaddgeofencesresultlistener.onAddGeofencesResult(yJ, Lt);
            }
        }

        protected volatile void a(Object obj)
        {
            a((com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener)obj);
        }

        protected void cP()
        {
        }

        public a(com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener onaddgeofencesresultlistener, int i, String as[])
        {
            Lu = hi.this;
            super(hi.this, onaddgeofencesresultlistener);
            yJ = LocationStatusCodes.bl(i);
            Lt = as;
        }
    }

    private static final class b extends hf.a
    {

        private com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener Lv;
        private com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener Lw;
        private hi Lx;

        public void onAddGeofencesResult(int i, String as[])
            throws RemoteException
        {
            if (Lx == null)
            {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            } else
            {
                hi hi1 = Lx;
                hi hi2 = Lx;
                hi2.getClass();
                hi1.a(hi2. new a(Lv, i, as));
                Lx = null;
                Lv = null;
                Lw = null;
                return;
            }
        }

        public void onRemoveGeofencesByPendingIntentResult(int i, PendingIntent pendingintent)
        {
            if (Lx == null)
            {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
                return;
            } else
            {
                hi hi1 = Lx;
                hi hi2 = Lx;
                hi2.getClass();
                hi1.a(hi2. new d(1, Lw, i, pendingintent));
                Lx = null;
                Lv = null;
                Lw = null;
                return;
            }
        }

        public void onRemoveGeofencesByRequestIdsResult(int i, String as[])
        {
            if (Lx == null)
            {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
                return;
            } else
            {
                hi hi1 = Lx;
                hi hi2 = Lx;
                hi2.getClass();
                hi1.a(hi2. new d(2, Lw, i, as));
                Lx = null;
                Lv = null;
                Lw = null;
                return;
            }
        }

        public b(com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener onaddgeofencesresultlistener, hi hi1)
        {
            Lv = onaddgeofencesresultlistener;
            Lw = null;
            Lx = hi1;
        }

        public b(com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener onremovegeofencesresultlistener, hi hi1)
        {
            Lw = onremovegeofencesresultlistener;
            Lv = null;
            Lx = hi1;
        }
    }

    private final class c
        implements hl
    {

        final hi Lu;

        public void bm()
        {
            hi.a(Lu);
        }

        public IInterface eb()
        {
            return gm();
        }

        public hg gm()
        {
            return (hg)hi.b(Lu);
        }

        private c()
        {
            Lu = hi.this;
            super();
        }

    }

    private final class d extends eh.b
    {

        private final String Lt[];
        final hi Lu;
        private final int Ly;
        private final PendingIntent mPendingIntent;
        private final int yJ;

        protected void a(com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener onremovegeofencesresultlistener)
        {
label0:
            {
label1:
                {
                    if (onremovegeofencesresultlistener != null)
                    {
                        switch (Ly)
                        {
                        default:
                            Log.wtf("LocationClientImpl", (new StringBuilder()).append("Unsupported action: ").append(Ly).toString());
                            break;

                        case 1: // '\001'
                            break label1;

                        case 2: // '\002'
                            break label0;
                        }
                    }
                    return;
                }
                onremovegeofencesresultlistener.onRemoveGeofencesByPendingIntentResult(yJ, mPendingIntent);
                return;
            }
            onremovegeofencesresultlistener.onRemoveGeofencesByRequestIdsResult(yJ, Lt);
        }

        protected volatile void a(Object obj)
        {
            a((com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener)obj);
        }

        protected void cP()
        {
        }

        public d(int i, com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener onremovegeofencesresultlistener, int j, PendingIntent pendingintent)
        {
            boolean flag = true;
            Lu = hi.this;
            super(hi.this, onremovegeofencesresultlistener);
            if (i != 1)
            {
                flag = false;
            }
            ed.v(flag);
            Ly = i;
            yJ = LocationStatusCodes.bl(j);
            mPendingIntent = pendingintent;
            Lt = null;
        }

        public d(int i, com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener onremovegeofencesresultlistener, int j, String as[])
        {
            Lu = hi.this;
            super(hi.this, onremovegeofencesresultlistener);
            boolean flag;
            if (i == 2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ed.v(flag);
            Ly = i;
            yJ = LocationStatusCodes.bl(j);
            Lt = as;
            mPendingIntent = null;
        }
    }


    private final hl Lk = new c();
    private final hh Lq;
    private final ib Lr;
    private final String Ls;
    private final String vi = null;

    public hi(Context context, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener, String s)
    {
        super(context, connectioncallbacks, onconnectionfailedlistener, new String[0]);
        Lq = new hh(context, Lk);
        Ls = s;
        Lr = new ib(getContext(), Locale.getDefault(), Lk);
    }

    static void a(hi hi1)
    {
        hi1.bm();
    }

    static IInterface b(hi hi1)
    {
        return hi1.eb();
    }

    protected hg Q(IBinder ibinder)
    {
        return hg.a.P(ibinder);
    }

    protected void a(en en1, eh.e e)
        throws RemoteException
    {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", Ls);
        en1.e(e, 0x41f6b8, getContext().getPackageName(), bundle);
    }

    protected String aF()
    {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected String aG()
    {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    public void addGeofences(List list, PendingIntent pendingintent, com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener onaddgeofencesresultlistener)
    {
        bm();
        boolean flag;
        if (list != null && list.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        er.b(flag, "At least one geofence must be specified.");
        er.b(pendingintent, "PendingIntent must be specified.");
        er.b(onaddgeofencesresultlistener, "OnAddGeofencesResultListener not provided.");
        if (onaddgeofencesresultlistener != null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        onaddgeofencesresultlistener = null;
        try
        {
            ((hg)eb()).a(list, pendingintent, onaddgeofencesresultlistener, getContext().getPackageName());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            throw new IllegalStateException(list);
        }
        onaddgeofencesresultlistener = new b(onaddgeofencesresultlistener, this);
        break MISSING_BLOCK_LABEL_47;
    }

    public void disconnect()
    {
        synchronized (Lq)
        {
            if (isConnected())
            {
                Lq.removeAllListeners();
                Lq.gl();
            }
            super.disconnect();
        }
        return;
        exception;
        hh1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Location getLastLocation()
    {
        return Lq.getLastLocation();
    }

    protected IInterface p(IBinder ibinder)
    {
        return Q(ibinder);
    }

    public void removeActivityUpdates(PendingIntent pendingintent)
    {
        bm();
        er.f(pendingintent);
        try
        {
            ((hg)eb()).removeActivityUpdates(pendingintent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PendingIntent pendingintent)
        {
            throw new IllegalStateException(pendingintent);
        }
    }

    public void removeGeofences(PendingIntent pendingintent, com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener onremovegeofencesresultlistener)
    {
        bm();
        er.b(pendingintent, "PendingIntent must be specified.");
        er.b(onremovegeofencesresultlistener, "OnRemoveGeofencesResultListener not provided.");
        if (onremovegeofencesresultlistener != null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        onremovegeofencesresultlistener = null;
_L1:
        try
        {
            ((hg)eb()).a(pendingintent, onremovegeofencesresultlistener, getContext().getPackageName());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PendingIntent pendingintent)
        {
            throw new IllegalStateException(pendingintent);
        }
        onremovegeofencesresultlistener = new b(onremovegeofencesresultlistener, this);
          goto _L1
    }

    public void removeGeofences(List list, com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener onremovegeofencesresultlistener)
    {
        bm();
        String as[];
        boolean flag;
        if (list != null && list.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        er.b(flag, "geofenceRequestIds can't be null nor empty.");
        er.b(onremovegeofencesresultlistener, "OnRemoveGeofencesResultListener not provided.");
        as = (String[])list.toArray(new String[0]);
        if (onremovegeofencesresultlistener != null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        list = null;
        try
        {
            ((hg)eb()).a(as, list, getContext().getPackageName());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            throw new IllegalStateException(list);
        }
        list = new b(onremovegeofencesresultlistener, this);
        break MISSING_BLOCK_LABEL_54;
    }

    public void removeLocationUpdates(PendingIntent pendingintent)
    {
        Lq.removeLocationUpdates(pendingintent);
    }

    public void removeLocationUpdates(LocationListener locationlistener)
    {
        Lq.removeLocationUpdates(locationlistener);
    }

    public void requestActivityUpdates(long l, PendingIntent pendingintent)
    {
        boolean flag = true;
        bm();
        er.f(pendingintent);
        if (l < 0L)
        {
            flag = false;
        }
        er.b(flag, "detectionIntervalMillis must be >= 0");
        try
        {
            ((hg)eb()).a(l, true, pendingintent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PendingIntent pendingintent)
        {
            throw new IllegalStateException(pendingintent);
        }
    }

    public void requestLocationUpdates(LocationRequest locationrequest, PendingIntent pendingintent)
    {
        Lq.requestLocationUpdates(locationrequest, pendingintent);
    }

    public void requestLocationUpdates(LocationRequest locationrequest, LocationListener locationlistener)
    {
        requestLocationUpdates(locationrequest, locationlistener, null);
    }

    public void requestLocationUpdates(LocationRequest locationrequest, LocationListener locationlistener, Looper looper)
    {
        synchronized (Lq)
        {
            Lq.requestLocationUpdates(locationrequest, locationlistener, looper);
        }
        return;
        locationrequest;
        hh1;
        JVM INSTR monitorexit ;
        throw locationrequest;
    }

    public void setMockLocation(Location location)
    {
        Lq.setMockLocation(location);
    }

    public void setMockMode(boolean flag)
    {
        Lq.setMockMode(flag);
    }
}
