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
    final int zzUS;
    final DriveId zzags;
    final long zzahF;
    final long zzahG;
    final int zzxJ;

    ProgressEvent(int i, DriveId driveid, int j, long l, long l1, 
            int k)
    {
        mVersionCode = i;
        zzags = driveid;
        zzxJ = j;
        zzahF = l;
        zzahG = l1;
        zzUS = k;
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
        if (!zzw.equal(zzags, ((ProgressEvent) (obj)).zzags) || zzxJ != ((ProgressEvent) (obj)).zzxJ || zzahF != ((ProgressEvent) (obj)).zzahF)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzahG == ((ProgressEvent) (obj)).zzahG) goto _L4; else goto _L5
_L5:
        return false;
    }

    public int getType()
    {
        return zzUS;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzags, Integer.valueOf(zzxJ), Long.valueOf(zzahF), Long.valueOf(zzahG)
        });
    }

    public String toString()
    {
        return String.format("ProgressEvent[DriveId: %s, status: %d, bytes transferred: %d, total bytes: %d]", new Object[] {
            zzags, Integer.valueOf(zzxJ), Long.valueOf(zzahF), Long.valueOf(zzahG)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzh.zza(this, parcel, i);
    }

}
