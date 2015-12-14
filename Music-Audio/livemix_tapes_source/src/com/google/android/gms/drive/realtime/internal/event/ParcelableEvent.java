// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive.realtime.internal.event:
//            zzc, TextInsertedDetails, TextDeletedDetails, ValuesAddedDetails, 
//            ValuesRemovedDetails, ValuesSetDetails, ValueChangedDetails, ReferenceShiftedDetails, 
//            ObjectChangedDetails, FieldChangedDetails

public class ParcelableEvent
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzc();
    final int mVersionCode;
    final String zzGY;
    final String zzGh;
    final String zzamb;
    final List zzamh;
    final boolean zzami;
    final boolean zzamj;
    final boolean zzamk;
    final String zzaml;
    final TextInsertedDetails zzamm;
    final TextDeletedDetails zzamn;
    final ValuesAddedDetails zzamo;
    final ValuesRemovedDetails zzamp;
    final ValuesSetDetails zzamq;
    final ValueChangedDetails zzamr;
    final ReferenceShiftedDetails zzams;
    final ObjectChangedDetails zzamt;
    final FieldChangedDetails zzamu;

    ParcelableEvent(int i, String s, String s1, List list, boolean flag, boolean flag1, boolean flag2, 
            String s2, String s3, TextInsertedDetails textinserteddetails, TextDeletedDetails textdeleteddetails, ValuesAddedDetails valuesaddeddetails, ValuesRemovedDetails valuesremoveddetails, ValuesSetDetails valuessetdetails, 
            ValueChangedDetails valuechangeddetails, ReferenceShiftedDetails referenceshifteddetails, ObjectChangedDetails objectchangeddetails, FieldChangedDetails fieldchangeddetails)
    {
        mVersionCode = i;
        zzGY = s;
        zzGh = s1;
        zzamh = list;
        zzami = flag;
        zzamj = flag1;
        zzamk = flag2;
        zzamb = s2;
        zzaml = s3;
        zzamm = textinserteddetails;
        zzamn = textdeleteddetails;
        zzamo = valuesaddeddetails;
        zzamp = valuesremoveddetails;
        zzamq = valuessetdetails;
        zzamr = valuechangeddetails;
        zzams = referenceshifteddetails;
        zzamt = objectchangeddetails;
        zzamu = fieldchangeddetails;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

}
