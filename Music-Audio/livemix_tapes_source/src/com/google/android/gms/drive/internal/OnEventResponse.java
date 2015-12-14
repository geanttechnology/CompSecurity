// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzba

public class OnEventResponse
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzba();
    final int mVersionCode;
    final int zzafk;
    final ChangeEvent zzajN;
    final CompletionEvent zzajO;
    final QueryResultEventParcelable zzajP;
    final ChangesAvailableEvent zzajQ;
    final ProgressEvent zzajR;

    OnEventResponse(int i, int j, ChangeEvent changeevent, CompletionEvent completionevent, QueryResultEventParcelable queryresulteventparcelable, ChangesAvailableEvent changesavailableevent, ProgressEvent progressevent)
    {
        mVersionCode = i;
        zzafk = j;
        zzajN = changeevent;
        zzajO = completionevent;
        zzajP = queryresulteventparcelable;
        zzajQ = changesavailableevent;
        zzajR = progressevent;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzba.zza(this, parcel, i);
    }

    public DriveEvent zzqS()
    {
        switch (zzafk)
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unexpected event type ").append(zzafk).toString());

        case 1: // '\001'
            return zzajN;

        case 2: // '\002'
            return zzajO;

        case 3: // '\003'
            return zzajP;

        case 4: // '\004'
            return zzajQ;

        case 5: // '\005'
        case 6: // '\006'
            return zzajR;
        }
    }

}
