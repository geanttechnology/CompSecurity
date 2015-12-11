// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            zzi, Feature

public class RegisterSectionInfo
    implements SafeParcelable
{

    public static final zzi CREATOR = new zzi();
    final int mVersionCode;
    public final String name;
    public final int weight;
    public final String zzQF;
    public final boolean zzQG;
    public final boolean zzQH;
    public final String zzQI;
    public final Feature zzQJ[];
    final int zzQK[];
    public final String zzQL;

    RegisterSectionInfo(int i, String s, String s1, boolean flag, int j, boolean flag1, String s2, 
            Feature afeature[], int ai[], String s3)
    {
        mVersionCode = i;
        name = s;
        zzQF = s1;
        zzQG = flag;
        weight = j;
        zzQH = flag1;
        zzQI = s2;
        zzQJ = afeature;
        zzQK = ai;
        zzQL = s3;
    }

    RegisterSectionInfo(String s, String s1, boolean flag, int i, boolean flag1, String s2, Feature afeature[], 
            int ai[], String s3)
    {
        this(2, s, s1, flag, i, flag1, s2, afeature, ai, s3);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzi.zza(this, parcel, i);
    }

}
