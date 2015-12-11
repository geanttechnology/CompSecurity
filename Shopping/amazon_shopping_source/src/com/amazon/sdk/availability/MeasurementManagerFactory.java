// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;


// Referenced classes of package com.amazon.sdk.availability:
//            MeasurementManagerImpl, MeasurementManager

public final class MeasurementManagerFactory
{

    private MeasurementManagerFactory()
    {
    }

    public static MeasurementManager getMeasurementManager()
    {
        return new MeasurementManagerImpl();
    }
}
