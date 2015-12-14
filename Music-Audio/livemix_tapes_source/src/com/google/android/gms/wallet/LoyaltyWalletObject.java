// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzli;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TimeInterval;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.wallet:
//            zzj

public final class LoyaltyWalletObject
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzj();
    private final int mVersionCode;
    int state;
    String zzaFb;
    String zzaWI;
    String zzaWJ;
    String zzaWK;
    String zzaWL;
    String zzaWM;
    String zzaWN;
    String zzaWO;
    String zzaWP;
    ArrayList zzaWQ;
    TimeInterval zzaWR;
    ArrayList zzaWS;
    String zzaWT;
    String zzaWU;
    ArrayList zzaWV;
    boolean zzaWW;
    ArrayList zzaWX;
    ArrayList zzaWY;
    ArrayList zzaWZ;
    LoyaltyPoints zzaXa;
    String zzhL;

    LoyaltyWalletObject()
    {
        mVersionCode = 4;
        zzaWQ = zzli.zzpM();
        zzaWS = zzli.zzpM();
        zzaWV = zzli.zzpM();
        zzaWX = zzli.zzpM();
        zzaWY = zzli.zzpM();
        zzaWZ = zzli.zzpM();
    }

    LoyaltyWalletObject(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, String s7, String s8, String s9, int j, ArrayList arraylist, TimeInterval timeinterval, 
            ArrayList arraylist1, String s10, String s11, ArrayList arraylist2, boolean flag, ArrayList arraylist3, ArrayList arraylist4, 
            ArrayList arraylist5, LoyaltyPoints loyaltypoints)
    {
        mVersionCode = i;
        zzhL = s;
        zzaWI = s1;
        zzaWJ = s2;
        zzaWK = s3;
        zzaFb = s4;
        zzaWL = s5;
        zzaWM = s6;
        zzaWN = s7;
        zzaWO = s8;
        zzaWP = s9;
        state = j;
        zzaWQ = arraylist;
        zzaWR = timeinterval;
        zzaWS = arraylist1;
        zzaWT = s10;
        zzaWU = s11;
        zzaWV = arraylist2;
        zzaWW = flag;
        zzaWX = arraylist3;
        zzaWY = arraylist4;
        zzaWZ = arraylist5;
        zzaXa = loyaltypoints;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAccountId()
    {
        return zzaWI;
    }

    public String getAccountName()
    {
        return zzaFb;
    }

    public String getBarcodeAlternateText()
    {
        return zzaWL;
    }

    public String getBarcodeType()
    {
        return zzaWM;
    }

    public String getBarcodeValue()
    {
        return zzaWN;
    }

    public String getId()
    {
        return zzhL;
    }

    public String getIssuerName()
    {
        return zzaWJ;
    }

    public String getProgramName()
    {
        return zzaWK;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzj.zza(this, parcel, i);
    }

}
