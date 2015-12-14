// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.fitness.data:
//            zzl

public class MapValue
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzl();
    private final int mVersionCode;
    private final int zzaoq;
    private final float zzaou;

    public MapValue(int i, float f)
    {
        this(1, i, f);
    }

    MapValue(int i, int j, float f)
    {
        mVersionCode = i;
        zzaoq = j;
        zzaou = f;
    }

    private boolean zza(MapValue mapvalue)
    {
        if (zzaoq != mapvalue.zzaoq) goto _L2; else goto _L1
_L1:
        zzaoq;
        JVM INSTR tableswitch 2 2: default 32
    //                   2 46;
           goto _L3 _L4
_L3:
        if (zzaou != mapvalue.zzaou) goto _L6; else goto _L5
_L5:
        return true;
_L4:
        if (asFloat() != mapvalue.asFloat())
        {
            return false;
        }
        if (true) goto _L5; else goto _L6
_L6:
        return false;
_L2:
        return false;
    }

    public static MapValue zzc(float f)
    {
        return new MapValue(2, f);
    }

    public float asFloat()
    {
        boolean flag;
        if (zzaoq == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Value is not in float format");
        return zzaou;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof MapValue) && zza((MapValue)obj);
    }

    int getFormat()
    {
        return zzaoq;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return (int)zzaou;
    }

    public String toString()
    {
        switch (zzaoq)
        {
        default:
            return "unknown";

        case 2: // '\002'
            return Float.toString(asFloat());
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzl.zza(this, parcel, i);
    }

    float zzrM()
    {
        return zzaou;
    }

}
