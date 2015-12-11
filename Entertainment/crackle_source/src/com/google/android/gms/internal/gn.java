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
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            dw, gm, ec, eg, 
//            gl, gq, ds

public class gn extends dw
{
    private final class a extends dw.b
    {

        private final int mC;
        private final String xY[];
        final gn xZ;

        protected void a(com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener onaddgeofencesresultlistener)
        {
            if (onaddgeofencesresultlistener != null)
            {
                onaddgeofencesresultlistener.onAddGeofencesResult(mC, xY);
            }
        }

        protected void aL()
        {
        }

        protected void b(Object obj)
        {
            a((com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener)obj);
        }

        public a(com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener onaddgeofencesresultlistener, int i, String as[])
        {
            xZ = gn.this;
            super(gn.this, onaddgeofencesresultlistener);
            mC = LocationStatusCodes.aR(i);
            xY = as;
        }
    }

    private static final class b extends gk.a
    {

        private com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener ya;
        private com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener yb;
        private gn yc;

        public void onAddGeofencesResult(int i, String as[])
            throws RemoteException
        {
            if (yc == null)
            {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            } else
            {
                gn gn1 = yc;
                gn gn2 = yc;
                gn2.getClass();
                gn1.a(gn2. new a(ya, i, as));
                yc = null;
                ya = null;
                yb = null;
                return;
            }
        }

        public void onRemoveGeofencesByPendingIntentResult(int i, PendingIntent pendingintent)
        {
            if (yc == null)
            {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
                return;
            } else
            {
                gn gn1 = yc;
                gn gn2 = yc;
                gn2.getClass();
                gn1.a(gn2. new d(1, yb, i, pendingintent));
                yc = null;
                ya = null;
                yb = null;
                return;
            }
        }

        public void onRemoveGeofencesByRequestIdsResult(int i, String as[])
        {
            if (yc == null)
            {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
                return;
            } else
            {
                gn gn1 = yc;
                gn gn2 = yc;
                gn2.getClass();
                gn1.a(gn2. new d(2, yb, i, as));
                yc = null;
                ya = null;
                yb = null;
                return;
            }
        }

        public b(com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener onaddgeofencesresultlistener, gn gn1)
        {
            ya = onaddgeofencesresultlistener;
            yb = null;
            yc = gn1;
        }

        public b(com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener onremovegeofencesresultlistener, gn gn1)
        {
            yb = onremovegeofencesresultlistener;
            ya = null;
            yc = gn1;
        }
    }

    private final class c
        implements gq
    {

        final gn xZ;

        public void bP()
        {
            gn.a(xZ);
        }

        public IInterface bQ()
        {
            return dJ();
        }

        public gl dJ()
        {
            return (gl)gn.b(xZ);
        }

        private c()
        {
            xZ = gn.this;
            super();
        }

    }

    private final class d extends dw.b
    {

        private final int mC;
        private final PendingIntent mPendingIntent;
        private final String xY[];
        final gn xZ;
        private final int yd;

        protected void a(com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener onremovegeofencesresultlistener)
        {
label0:
            {
label1:
                {
                    if (onremovegeofencesresultlistener != null)
                    {
                        switch (yd)
                        {
                        default:
                            Log.wtf("LocationClientImpl", (new StringBuilder()).append("Unsupported action: ").append(yd).toString());
                            break;

                        case 1: // '\001'
                            break label1;

                        case 2: // '\002'
                            break label0;
                        }
                    }
                    return;
                }
                onremovegeofencesresultlistener.onRemoveGeofencesByPendingIntentResult(mC, mPendingIntent);
                return;
            }
            onremovegeofencesresultlistener.onRemoveGeofencesByRequestIdsResult(mC, xY);
        }

        protected void aL()
        {
        }

        protected void b(Object obj)
        {
            a((com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener)obj);
        }

        public d(int i, com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener onremovegeofencesresultlistener, int j, PendingIntent pendingintent)
        {
            boolean flag = true;
            xZ = gn.this;
            super(gn.this, onremovegeofencesresultlistener);
            if (i != 1)
            {
                flag = false;
            }
            ds.p(flag);
            yd = i;
            mC = LocationStatusCodes.aR(j);
            mPendingIntent = pendingintent;
            xY = null;
        }

        public d(int i, com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener onremovegeofencesresultlistener, int j, String as[])
        {
            xZ = gn.this;
            super(gn.this, onremovegeofencesresultlistener);
            boolean flag;
            if (i == 2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ds.p(flag);
            yd = i;
            mC = LocationStatusCodes.aR(j);
            xY = as;
            mPendingIntent = null;
        }
    }


    private final String jG = null;
    private final gq xP = new c();
    private final gm xV;
    private final HashMap xW = new HashMap();
    private final String xX;

    public gn(Context context, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener, String s)
    {
        super(context, connectioncallbacks, onconnectionfailedlistener, new String[0]);
        xV = new gm(context, xP);
        xX = s;
    }

    static void a(gn gn1)
    {
        gn1.bP();
    }

    static IInterface b(gn gn1)
    {
        return gn1.bQ();
    }

    protected gl M(IBinder ibinder)
    {
        return gl.a.L(ibinder);
    }

    protected void a(ec ec1, dw.e e)
        throws RemoteException
    {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", xX);
        ec1.e(e, 0x40ba50, getContext().getPackageName(), bundle);
    }

    public void addGeofences(List list, PendingIntent pendingintent, com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener onaddgeofencesresultlistener)
    {
        bP();
        boolean flag;
        if (list != null && list.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.b(flag, "At least one geofence must be specified.");
        eg.b(pendingintent, "PendingIntent must be specified.");
        eg.b(onaddgeofencesresultlistener, "OnAddGeofencesResultListener not provided.");
        if (onaddgeofencesresultlistener != null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        onaddgeofencesresultlistener = null;
        try
        {
            ((gl)bQ()).a(list, pendingintent, onaddgeofencesresultlistener, getContext().getPackageName());
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

    protected String am()
    {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected String an()
    {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    public void disconnect()
    {
        synchronized (xV)
        {
            if (isConnected())
            {
                xV.removeAllListeners();
                xV.dI();
            }
            super.disconnect();
        }
        return;
        exception;
        gm1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Location getLastLocation()
    {
        return xV.getLastLocation();
    }

    protected IInterface p(IBinder ibinder)
    {
        return M(ibinder);
    }

    public void removeActivityUpdates(PendingIntent pendingintent)
    {
        bP();
        eg.f(pendingintent);
        try
        {
            ((gl)bQ()).removeActivityUpdates(pendingintent);
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
        bP();
        eg.b(pendingintent, "PendingIntent must be specified.");
        eg.b(onremovegeofencesresultlistener, "OnRemoveGeofencesResultListener not provided.");
        if (onremovegeofencesresultlistener != null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        onremovegeofencesresultlistener = null;
_L1:
        try
        {
            ((gl)bQ()).a(pendingintent, onremovegeofencesresultlistener, getContext().getPackageName());
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
        bP();
        String as[];
        boolean flag;
        if (list != null && list.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.b(flag, "geofenceRequestIds can't be null nor empty.");
        eg.b(onremovegeofencesresultlistener, "OnRemoveGeofencesResultListener not provided.");
        as = (String[])list.toArray(new String[0]);
        if (onremovegeofencesresultlistener != null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        list = null;
        try
        {
            ((gl)bQ()).a(as, list, getContext().getPackageName());
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
        xV.removeLocationUpdates(pendingintent);
    }

    public void removeLocationUpdates(LocationListener locationlistener)
    {
        xV.removeLocationUpdates(locationlistener);
    }

    public void requestActivityUpdates(long l, PendingIntent pendingintent)
    {
        boolean flag = true;
        bP();
        eg.f(pendingintent);
        if (l < 0L)
        {
            flag = false;
        }
        eg.b(flag, "detectionIntervalMillis must be >= 0");
        try
        {
            ((gl)bQ()).a(l, true, pendingintent);
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
        xV.requestLocationUpdates(locationrequest, pendingintent);
    }

    public void requestLocationUpdates(LocationRequest locationrequest, LocationListener locationlistener)
    {
        requestLocationUpdates(locationrequest, locationlistener, null);
    }

    public void requestLocationUpdates(LocationRequest locationrequest, LocationListener locationlistener, Looper looper)
    {
        synchronized (xV)
        {
            xV.requestLocationUpdates(locationrequest, locationlistener, looper);
        }
        return;
        locationrequest;
        gm1;
        JVM INSTR monitorexit ;
        throw locationrequest;
    }

    public void setMockLocation(Location location)
    {
        xV.setMockLocation(location);
    }

    public void setMockMode(boolean flag)
    {
        xV.setMockMode(flag);
    }
}
