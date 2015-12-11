// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.content.Context;
import android.hardware.SensorManager;

// Referenced classes of package com.iovation.mobile.android.details:
//            i, j

public class p
    implements i
{

    public p()
    {
    }

    Integer a(SensorManager sensormanager)
    {
        if (sensormanager.getDefaultSensor(8) != null)
        {
            return Integer.valueOf(1);
        } else
        {
            return Integer.valueOf(0);
        }
    }

    public void a(Context context, j j1)
    {
        j1.a("PROX", a((SensorManager)context.getSystemService("sensor")).toString());
    }
}
