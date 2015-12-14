// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.vision.barcode:
//            Barcode, zzf

public static class issuingCountry
    implements SafeParcelable
{

    public static final zzf CREATOR = new zzf();
    public String addressCity;
    public String addressState;
    public String addressStreet;
    public String addressZip;
    public String birthDate;
    public String documentType;
    public String expiryDate;
    public String firstName;
    public String gender;
    public String issueDate;
    public String issuingCountry;
    public String lastName;
    public String licenseNumber;
    public String middleName;
    final int versionCode;

    public int describeContents()
    {
        zzf zzf1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzf zzf1 = CREATOR;
        zzf.zza(this, parcel, i);
    }


    public able()
    {
        versionCode = 1;
    }

    public versionCode(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, String s7, String s8, String s9, String s10, String s11, String s12, 
            String s13)
    {
        versionCode = i;
        documentType = s;
        firstName = s1;
        middleName = s2;
        lastName = s3;
        gender = s4;
        addressStreet = s5;
        addressCity = s6;
        addressState = s7;
        addressZip = s8;
        licenseNumber = s9;
        issueDate = s10;
        expiryDate = s11;
        birthDate = s12;
        issuingCountry = s13;
    }
}
