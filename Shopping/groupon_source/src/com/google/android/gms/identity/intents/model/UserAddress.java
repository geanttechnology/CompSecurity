// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.identity.intents.model:
//            zzb

public final class UserAddress
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    String name;
    private final int zzCY;
    String zzEr;
    String zzawA;
    String zzawB;
    String zzawC;
    String zzawD;
    String zzawE;
    String zzawF;
    String zzawG;
    String zzawH;
    String zzawI;
    String zzawJ;
    boolean zzawK;
    String zzawL;
    String zzawM;

    UserAddress()
    {
        zzCY = 1;
    }

    UserAddress(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, String s7, String s8, String s9, String s10, String s11, boolean flag, 
            String s12, String s13)
    {
        zzCY = i;
        name = s;
        zzawA = s1;
        zzawB = s2;
        zzawC = s3;
        zzawD = s4;
        zzawE = s5;
        zzawF = s6;
        zzawG = s7;
        zzEr = s8;
        zzawH = s9;
        zzawI = s10;
        zzawJ = s11;
        zzawK = flag;
        zzawL = s12;
        zzawM = s13;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getVersionCode()
    {
        return zzCY;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
