// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.PendingIntent;
import android.util.Log;

final class aff extends aev
{

    private aig a;
    private aih b;
    private afd c;

    public aff(aig aig, afd afd1)
    {
        a = aig;
        b = null;
        c = afd1;
    }

    public aff(aih aih, afd afd1)
    {
        b = aih;
        a = null;
        c = afd1;
    }

    public void a(int i, PendingIntent pendingintent)
    {
        if (c == null)
        {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
            return;
        } else
        {
            afd afd1 = c;
            afd afd2 = c;
            afd2.getClass();
            afd1.a(new afg(afd2, 1, b, i, pendingintent));
            c = null;
            a = null;
            b = null;
            return;
        }
    }

    public void a(int i, String as[])
    {
        if (c == null)
        {
            Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
            return;
        } else
        {
            afd afd1 = c;
            afd afd2 = c;
            afd2.getClass();
            afd1.a(new afe(afd2, a, i, as));
            c = null;
            a = null;
            b = null;
            return;
        }
    }

    public void b(int i, String as[])
    {
        if (c == null)
        {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
            return;
        } else
        {
            afd afd1 = c;
            afd afd2 = c;
            afd2.getClass();
            afd1.a(new afg(afd2, 2, b, i, as));
            c = null;
            a = null;
            b = null;
            return;
        }
    }
}
