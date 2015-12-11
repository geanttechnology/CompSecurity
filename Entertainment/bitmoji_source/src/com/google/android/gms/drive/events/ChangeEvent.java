// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.events:
//            ResourceEvent, a

public final class ChangeEvent
    implements SafeParcelable, ResourceEvent
{

    public static final android.os.Parcelable.Creator CREATOR = new a();
    final DriveId CS;
    final int Dl;
    final int wj;

    ChangeEvent(int i, DriveId driveid, int j)
    {
        wj = i;
        CS = driveid;
        Dl = j;
    }

    public int describeContents()
    {
        return 0;
    }

    public DriveId getDriveId()
    {
        return CS;
    }

    public int getType()
    {
        return 1;
    }

    public boolean hasContentChanged()
    {
        return (Dl & 2) != 0;
    }

    public boolean hasMetadataChanged()
    {
        return (Dl & 1) != 0;
    }

    public String toString()
    {
        return String.format("ChangeEvent [id=%s,changeFlags=%x]", new Object[] {
            CS, Integer.valueOf(Dl)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        a.a(this, parcel, i);
    }

}
