// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.cast:
//            zzc

public class JoinOptions
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzc();
    private final int mVersionCode;
    private int zzVR;

    public JoinOptions()
    {
        this(1, 0);
    }

    JoinOptions(int i, int j)
    {
        mVersionCode = i;
        zzVR = j;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof JoinOptions))
            {
                return false;
            }
            obj = (JoinOptions)obj;
            if (zzVR != ((JoinOptions) (obj)).zzVR)
            {
                return false;
            }
        }
        return true;
    }

    public int getConnectionType()
    {
        return zzVR;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(zzVR)
        });
    }

    public String toString()
    {
        zzVR;
        JVM INSTR tableswitch 0 2: default 32
    //                   0 49
    //                   1 32
    //                   2 55;
           goto _L1 _L2 _L1 _L3
_L1:
        String s = "UNKNOWN";
_L5:
        return String.format("joinOptions(connectionType=%s)", new Object[] {
            s
        });
_L2:
        s = "STRONG";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "INVISIBLE";
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

}
