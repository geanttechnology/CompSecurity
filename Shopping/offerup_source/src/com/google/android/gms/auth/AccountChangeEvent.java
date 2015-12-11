// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.auth:
//            zza

public class AccountChangeEvent
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    final int mVersion;
    final long zzRr;
    final String zzRs;
    final int zzRt;
    final int zzRu;
    final String zzRv;

    AccountChangeEvent(int i, long l, String s, int j, int k, String s1)
    {
        mVersion = i;
        zzRr = l;
        zzRs = (String)zzx.zzw(s);
        zzRt = j;
        zzRu = k;
        zzRv = s1;
    }

    public AccountChangeEvent(long l, String s, int i, int j, String s1)
    {
        mVersion = 1;
        zzRr = l;
        zzRs = (String)zzx.zzw(s);
        zzRt = i;
        zzRu = j;
        zzRv = s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof AccountChangeEvent)
            {
                if (mVersion != ((AccountChangeEvent) (obj = (AccountChangeEvent)obj)).mVersion || zzRr != ((AccountChangeEvent) (obj)).zzRr || !zzw.equal(zzRs, ((AccountChangeEvent) (obj)).zzRs) || zzRt != ((AccountChangeEvent) (obj)).zzRt || zzRu != ((AccountChangeEvent) (obj)).zzRu || !zzw.equal(zzRv, ((AccountChangeEvent) (obj)).zzRv))
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public String getAccountName()
    {
        return zzRs;
    }

    public String getChangeData()
    {
        return zzRv;
    }

    public int getChangeType()
    {
        return zzRt;
    }

    public int getEventIndex()
    {
        return zzRu;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(mVersion), Long.valueOf(zzRr), zzRs, Integer.valueOf(zzRt), Integer.valueOf(zzRu), zzRv
        });
    }

    public String toString()
    {
        String s = "UNKNOWN";
        zzRt;
        JVM INSTR tableswitch 1 4: default 36
    //                   1 94
    //                   2 100
    //                   3 112
    //                   4 106;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return (new StringBuilder("AccountChangeEvent {accountName = ")).append(zzRs).append(", changeType = ").append(s).append(", changeData = ").append(zzRv).append(", eventIndex = ").append(zzRu).append("}").toString();
_L2:
        s = "ADDED";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "REMOVED";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "RENAMED_TO";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "RENAMED_FROM";
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

}
