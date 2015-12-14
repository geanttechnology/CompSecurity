// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.drive.events:
//            DriveEvent, zzb, ChangesAvailableOptions

public final class ChangesAvailableEvent
    implements SafeParcelable, DriveEvent
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    final int mVersionCode;
    final String zzQE;
    final ChangesAvailableOptions zzahn;

    ChangesAvailableEvent(int i, String s, ChangesAvailableOptions changesavailableoptions)
    {
        mVersionCode = i;
        zzQE = s;
        zzahn = changesavailableoptions;
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
        obj = (ChangesAvailableEvent)obj;
        if (!zzw.equal(zzahn, ((ChangesAvailableEvent) (obj)).zzahn))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(zzQE, ((ChangesAvailableEvent) (obj)).zzQE)) goto _L4; else goto _L5
_L5:
        return false;
    }

    public int getType()
    {
        return 4;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzahn, zzQE
        });
    }

    public String toString()
    {
        return String.format(Locale.US, "ChangesAvailableEvent [changesAvailableOptions=%s]", new Object[] {
            zzahn
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
