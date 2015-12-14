// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.nearby.messages:
//            zzd

public class Strategy
    implements SafeParcelable
{
    public static class Builder
    {

        private int zzaJM;
        private int zzaJN;
        private int zzaJP;
        private int zzaJQ;

        public Strategy build()
        {
            if (zzaJP == 2)
            {
                if (zzaJQ != 3)
                {
                    throw new IllegalStateException("Discovery mode must be DISCOVERY_MODE_DEFAULT.");
                }
                if (zzaJN == 1)
                {
                    throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
                }
            }
            return new Strategy(2, 0, zzaJM, zzaJN, false, zzaJP, zzaJQ);
        }

        public Builder setDiscoveryMode(int i)
        {
            zzaJQ = i;
            return this;
        }

        public Builder setDistanceType(int i)
        {
            zzaJN = i;
            return this;
        }

        public Builder setTtlSeconds(int i)
        {
            boolean flag;
            if (i == 0x7fffffff || i > 0 && i <= 0x15180)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "ttlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", new Object[] {
                Integer.valueOf(i), Integer.valueOf(0x15180)
            });
            zzaJM = i;
            return this;
        }

        public Builder zzim(int i)
        {
            zzaJP = i;
            return this;
        }

        public Builder()
        {
            zzaJQ = 3;
            zzaJM = 300;
            zzaJN = 0;
            zzaJP = 1;
        }
    }


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
    public static final Strategy zzaJK;
    final int versionCode;
    final int zzaJL;
    final int zzaJM;
    final int zzaJN;
    final boolean zzaJO;
    final int zzaJP;
    final int zzaJQ;

    Strategy(int i, int j, int k, int l, boolean flag, int i1, int j1)
    {
        versionCode = i;
        zzaJL = j;
        if (j == 0)
        {
            zzaJQ = j1;
            break MISSING_BLOCK_LABEL_24;
        } else
        {
            switch (j)
            {
            default:
                zzaJQ = 3;
                break;

            case 2: // '\002'
                zzaJQ = 1;
                break;

            case 3: // '\003'
                zzaJQ = 2;
                break;
            }
            continue;
        }
        do
        {
            zzaJN = l;
            zzaJO = flag;
            if (flag)
            {
                zzaJP = 2;
                zzaJM = 0x7fffffff;
                return;
            }
            if (i1 == 0)
            {
                zzaJP = 1;
                zzaJM = k;
                return;
            }
            zzaJP = i1;
            zzaJM = k;
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
            if (versionCode != ((Strategy) (obj)).versionCode || zzaJQ != ((Strategy) (obj)).zzaJQ || zzaJM != ((Strategy) (obj)).zzaJM || zzaJN != ((Strategy) (obj)).zzaJN || zzaJP != ((Strategy) (obj)).zzaJP)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return (((versionCode * 31 + zzaJQ) * 31 + zzaJM) * 31 + zzaJN) * 31 + zzaJP;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
    }

    static 
    {
        BLE_ONLY = (new Builder()).zzim(2).setTtlSeconds(0x7fffffff).build();
        zzaJK = BLE_ONLY;
    }
}
