// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OnEventResponse

public class zzba
    implements android.os.Parcelable.Creator
{

    public zzba()
    {
    }

    static void zza(OnEventResponse oneventresponse, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, oneventresponse.mVersionCode);
        zzb.zzc(parcel, 2, oneventresponse.zzafk);
        zzb.zza(parcel, 3, oneventresponse.zzajN, i, false);
        zzb.zza(parcel, 5, oneventresponse.zzajO, i, false);
        zzb.zza(parcel, 6, oneventresponse.zzajP, i, false);
        zzb.zza(parcel, 7, oneventresponse.zzajQ, i, false);
        zzb.zza(parcel, 8, oneventresponse.zzajR, i, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbo(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdc(i);
    }

    public OnEventResponse zzbo(Parcel parcel)
    {
        int i = 0;
        ProgressEvent progressevent = null;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        ChangesAvailableEvent changesavailableevent = null;
        QueryResultEventParcelable queryresulteventparcelable = null;
        CompletionEvent completionevent = null;
        ChangeEvent changeevent = null;
        int j = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(l))
                {
                case 4: // '\004'
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 3: // '\003'
                    changeevent = (ChangeEvent)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, ChangeEvent.CREATOR);
                    break;

                case 5: // '\005'
                    completionevent = (CompletionEvent)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, CompletionEvent.CREATOR);
                    break;

                case 6: // '\006'
                    queryresulteventparcelable = (QueryResultEventParcelable)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, QueryResultEventParcelable.CREATOR);
                    break;

                case 7: // '\007'
                    changesavailableevent = (ChangesAvailableEvent)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, ChangesAvailableEvent.CREATOR);
                    break;

                case 8: // '\b'
                    progressevent = (ProgressEvent)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, ProgressEvent.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new OnEventResponse(j, i, changeevent, completionevent, queryresulteventparcelable, changesavailableevent, progressevent);
            }
        } while (true);
    }

    public OnEventResponse[] zzdc(int i)
    {
        return new OnEventResponse[i];
    }
}
