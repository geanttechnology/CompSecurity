// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import android.content.Context;
import java.io.Serializable;

// Referenced classes of package com.amazon.sdk.availability:
//            Measurement

public interface MeasurementManager
{

    public abstract void putMeasurement(Context context, Measurement measurement);

    public abstract void putMeasurement(Context context, Measurement measurement, Serializable serializable);

    public abstract void setIdentityInformation(Context context, String s, String s1, String s2, String s3, String s4, String as[]);
}
