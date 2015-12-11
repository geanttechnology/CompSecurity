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
//            zzbb

public class OnEventResponse
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzbb();
    final int mVersionCode;
    final int zzaho;
    final ChangeEvent zzame;
    final CompletionEvent zzamf;
    final QueryResultEventParcelable zzamg;
    final ChangesAvailableEvent zzamh;
    final ProgressEvent zzami;

    OnEventResponse(int i, int j, ChangeEvent changeevent, CompletionEvent completionevent, QueryResultEventParcelable queryresulteventparcelable, ChangesAvailableEvent changesavailableevent, ProgressEvent progressevent)
    {
        mVersionCode = i;
        zzaho = j;
        zzame = changeevent;
        zzamf = completionevent;
        zzamg = queryresulteventparcelable;
        zzamh = changesavailableevent;
        zzami = progressevent;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzbb.zza(this, parcel, i);
    }

    public DriveEvent zzrA()
    {
        switch (zzaho)
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unexpected event type ").append(zzaho).toString());

        case 1: // '\001'
            return zzame;

        case 2: // '\002'
            return zzamf;

        case 3: // '\003'
            return zzamg;

        case 4: // '\004'
            return zzamh;

        case 5: // '\005'
        case 6: // '\006'
            return zzami;
        }
    }

}
