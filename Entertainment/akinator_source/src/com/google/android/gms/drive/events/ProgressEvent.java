// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.events:
//            DriveEvent, zzh

public final class ProgressEvent
    implements DriveEvent
{

    public static final android.os.Parcelable.Creator CREATOR = new zzh();
    final int mVersionCode;
    final int zzWJ;
    final DriveId zzaiA;
    final long zzajP;
    final long zzajQ;
    final int zzys;

    ProgressEvent(int i, DriveId driveid, int j, long l, long l1, 
            int k)
    {
        mVersionCode = i;
        zzaiA = driveid;
        zzys = j;
        zzajP = l;
        zzajQ = l1;
        zzWJ = k;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = true;
        if (obj != null && obj.getClass() == getClass()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (obj == this) goto _L4; else goto _L3
_L3:
        obj = (ProgressEvent)obj;
        if (!zzw.equal(zzaiA, ((ProgressEvent) (obj)).zzaiA) || zzys != ((ProgressEvent) (obj)).zzys || zzajP != ((ProgressEvent) (obj)).zzajP)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzajQ == ((ProgressEvent) (obj)).zzajQ) goto _L4; else goto _L5
_L5:
        return false;
    }

    public int getType()
    {
        return zzWJ;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaiA, Integer.valueOf(zzys), Long.valueOf(zzajP), Long.valueOf(zzajQ)
        });
    }

    public String toString()
    {
        return String.format("ProgressEvent[DriveId: %s, status: %d, bytes transferred: %d, total bytes: %d]", new Object[] {
            zzaiA, Integer.valueOf(zzys), Long.valueOf(zzajP), Long.valueOf(zzajQ)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzh.zza(this, parcel, i);
    }

}
