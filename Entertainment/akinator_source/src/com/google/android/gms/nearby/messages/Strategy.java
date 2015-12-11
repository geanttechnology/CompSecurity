// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.nearby.messages:
//            zzd

public class Strategy
    implements SafeParcelable
{

    public static final Strategy BLE_ONLY;
    public static final android.os.Parcelable.Creator CREATOR = new zzd();
    public static final Strategy DEFAULT = (new Builder()).build();
    public static final int DISCOVERY_MODE_BROADCAST = 1;
    public static final int DISCOVERY_MODE_DEFAULT = 3;
    public static final int DISCOVERY_MODE_SCAN = 2;
    public static final int DISTANCE_TYPE_DEFAULT = 0;
    public static final int DISTANCE_TYPE_EARSHOT = 1;
    public static final int TTL_SECONDS_DEFAULT = 300;
    public static final int TTL_SECONDS_INFINITE = 0x7fffffff;
    public static final int TTL_SECONDS_MAX = 0x15180;
    public static final Strategy zzaQi;
    final int mVersionCode;
    final int zzaQj;
    final int zzaQk;
    final int zzaQl;
    final boolean zzaQm;
    final int zzaQn;
    final int zzaQo;

    Strategy(int i, int j, int k, int l, boolean flag, int i1, int j1)
    {
        mVersionCode = i;
        zzaQj = j;
        if (j == 0)
        {
            zzaQo = j1;
            break MISSING_BLOCK_LABEL_24;
        } else
        {
            switch (j)
            {
            default:
                zzaQo = 3;
                break;

            case 2: // '\002'
                zzaQo = 1;
                break;

            case 3: // '\003'
                zzaQo = 2;
                break;
            }
            continue;
        }
        do
        {
            zzaQl = l;
            zzaQm = flag;
            if (flag)
            {
                zzaQn = 2;
                zzaQk = 0x7fffffff;
                return;
            }
            if (i1 == 0)
            {
                zzaQn = 1;
                zzaQk = k;
                return;
            }
            zzaQn = i1;
            zzaQk = k;
            break;
        } while (true);
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof Strategy))
            {
                return false;
            }
            obj = (Strategy)obj;
            if (mVersionCode != ((Strategy) (obj)).mVersionCode || zzaQo != ((Strategy) (obj)).zzaQo || zzaQk != ((Strategy) (obj)).zzaQk || zzaQl != ((Strategy) (obj)).zzaQl || zzaQn != ((Strategy) (obj)).zzaQn)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return (((mVersionCode * 31 + zzaQo) * 31 + zzaQk) * 31 + zzaQl) * 31 + zzaQn;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
    }

    static 
    {
    /* block-local class not found */
    class Builder {}

        BLE_ONLY = (new Builder()).zziz(2).setTtlSeconds(0x7fffffff).build();
        zzaQi = BLE_ONLY;
    }
}
