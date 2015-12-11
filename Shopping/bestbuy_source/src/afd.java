// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class afd extends aeo
{

    private final afa e;
    private final ael f;
    private final acn g;

    public afd(Context context, Looper looper, String s, qo qo, qp qp, String s1, String s2)
    {
        this(context, looper, s, qo, qp, s1, s2, null);
    }

    public afd(Context context, Looper looper, String s, qo qo, qp qp, String s1, String s2, 
            String s3)
    {
        super(context, looper, qo, qp, s1);
        e = new afa(context, a);
        f = ael.a(context, s2, s3, a);
        g = acn.a(context, a);
    }

    public void a(ahx ahx)
    {
        e.a(ahx);
    }

    public void a(PendingIntent pendingintent, aih aih)
    {
        i();
        ady.a(pendingintent, "PendingIntent must be specified.");
        ady.a(aih, "OnRemoveGeofencesResultListener not provided.");
        if (aih == null)
        {
            aih = null;
        } else
        {
            aih = new aff(aih, this);
        }
        ((aex)j()).a(pendingintent, aih, h().getPackageName());
    }

    public void a(GeofencingRequest geofencingrequest, PendingIntent pendingintent, aig aig)
    {
        i();
        ady.a(geofencingrequest, "geofencingRequest can't be null.");
        ady.a(pendingintent, "PendingIntent must be specified.");
        ady.a(aig, "OnAddGeofencesResultListener not provided.");
        if (aig == null)
        {
            aig = null;
        } else
        {
            aig = new aff(aig, this);
        }
        ((aex)j()).a(geofencingrequest, pendingintent, aig);
    }

    public void a(LocationRequest locationrequest, ahx ahx, Looper looper)
    {
        synchronized (e)
        {
            e.a(locationrequest, ahx, looper);
        }
        return;
        locationrequest;
        afa1;
        JVM INSTR monitorexit ;
        throw locationrequest;
    }

    public void a(List list, aih aih)
    {
        i();
        String as[];
        boolean flag;
        if (list != null && list.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ady.b(flag, "geofenceRequestIds can't be null nor empty.");
        ady.a(aih, "OnRemoveGeofencesResultListener not provided.");
        as = (String[])list.toArray(new String[0]);
        if (aih == null)
        {
            list = null;
        } else
        {
            list = new aff(aih, this);
        }
        ((aex)j()).a(as, list, h().getPackageName());
    }

    public void b()
    {
        afa afa1 = e;
        afa1;
        JVM INSTR monitorenter ;
        boolean flag = c();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        e.a();
        e.b();
_L1:
        super.b();
        afa1;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", ((Throwable) (obj)));
          goto _L1
        obj;
        afa1;
        JVM INSTR monitorexit ;
        throw obj;
    }
}
