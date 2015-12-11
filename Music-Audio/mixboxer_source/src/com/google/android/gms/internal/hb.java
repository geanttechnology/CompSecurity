// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            gs, hc, hd, eg, 
//            ee

public final class hb extends gs
    implements SafeParcelable
{

    private static final hb AJ = new hb(0, new hd[0], new float[0], 0L);
    public static final hc CREATOR = new hc();
    private final hd AK[];
    private final float AL[];
    final int kg;
    private final long vO;

    hb(int i, hd ahd[], float af[], long l)
    {
        boolean flag;
        if (ahd.length == af.length)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.b(flag, "mismatched places to probabilities arrays");
        kg = i;
        AK = ahd;
        AL = af;
        vO = l;
    }

    public hd[] dU()
    {
        return AK;
    }

    public float[] dV()
    {
        return AL;
    }

    public int describeContents()
    {
        hc hc1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof hb))
            {
                return false;
            }
            obj = (hb)obj;
            if (!AK.equals(((hb) (obj)).AK) || !AL.equals(((hb) (obj)).AL))
            {
                return false;
            }
        }
        return true;
    }

    public long getTimestampMillis()
    {
        return vO;
    }

    public int hashCode()
    {
        return ee.hashCode(new Object[] {
            AK, AL
        });
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("PlaceEstimate{");
        for (int i = 0; i < AK.length; i++)
        {
            stringbuilder.append(String.format("(%f, %s)", new Object[] {
                Float.valueOf(AL[i]), AK[i].toString()
            }));
            if (i != AK.length - 1)
            {
                stringbuilder.append(",");
            }
        }

        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        hc hc1 = CREATOR;
        hc.a(this, parcel, i);
    }

}
