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
    final String zzHP;
    final String zzaoB;
    final List zzaoH;
    final boolean zzaoI;
    final boolean zzaoJ;
    final boolean zzaoK;
    final String zzaoL;
    final TextInsertedDetails zzaoM;
    final TextDeletedDetails zzaoN;
    final ValuesAddedDetails zzaoO;
    final ValuesRemovedDetails zzaoP;
    final ValuesSetDetails zzaoQ;
    final ValueChangedDetails zzaoR;
    final ReferenceShiftedDetails zzaoS;
    final ObjectChangedDetails zzaoT;
    final FieldChangedDetails zzaoU;

    ParcelableEvent(int i, String s, String s1, List list, boolean flag, boolean flag1, boolean flag2, 
            String s2, String s3, TextInsertedDetails textinserteddetails, TextDeletedDetails textdeleteddetails, ValuesAddedDetails valuesaddeddetails, ValuesRemovedDetails valuesremoveddetails, ValuesSetDetails valuessetdetails, 
            ValueChangedDetails valuechangeddetails, ReferenceShiftedDetails referenceshifteddetails, ObjectChangedDetails objectchangeddetails, FieldChangedDetails fieldchangeddetails)
    {
        mVersionCode = i;
        zzHP = s;
        zzGY = s1;
        zzaoH = list;
        zzaoI = flag;
        zzaoJ = flag1;
        zzaoK = flag2;
        zzaoB = s2;
        zzaoL = s3;
        zzaoM = textinserteddetails;
        zzaoN = textdeleteddetails;
        zzaoO = valuesaddeddetails;
        zzaoP = valuesremoveddetails;
        zzaoQ = valuessetdetails;
        zzaoR = valuechangeddetails;
        zzaoS = referenceshifteddetails;
        zzaoT = objectchangeddetails;
        zzaoU = fieldchangeddetails;
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
