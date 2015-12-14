// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.WriteAwareParcelable;

// Referenced classes of package com.google.android.gms.drive.events:
//            DriveEvent, zzk

public class QueryResultEventParcelable extends WriteAwareParcelable
    implements DriveEvent
{

    public static final zzk CREATOR = new zzk();
    final int mVersionCode;
    final DataHolder zzYX;
    final boolean zzahH;
    final int zzahI;

    QueryResultEventParcelable(int i, DataHolder dataholder, boolean flag, int j)
    {
        mVersionCode = i;
        zzYX = dataholder;
        zzahH = flag;
        zzahI = j;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getType()
    {
        return 3;
    }

    public void zzI(Parcel parcel, int i)
    {
        zzk.zza(this, parcel, i);
    }

    public DataHolder zzqA()
    {
        return zzYX;
    }

    public boolean zzqB()
    {
        return zzahH;
    }

    public int zzqC()
    {
        return zzahI;
    }

}
