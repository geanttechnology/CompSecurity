// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmj;
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
    String zzaHT;
    String zzbcP;
    String zzbcQ;
    String zzbcR;
    String zzbcS;
    String zzbcT;
    String zzbcU;
    String zzbcV;
    String zzbcW;
    ArrayList zzbcX;
    TimeInterval zzbcY;
    ArrayList zzbcZ;
    String zzbda;
    String zzbdb;
    ArrayList zzbdc;
    boolean zzbdd;
    ArrayList zzbde;
    ArrayList zzbdf;
    ArrayList zzbdg;
    LoyaltyPoints zzbdh;
    String zzhL;

    LoyaltyWalletObject()
    {
        mVersionCode = 4;
        zzbcX = zzmj.zzqs();
        zzbcZ = zzmj.zzqs();
        zzbdc = zzmj.zzqs();
        zzbde = zzmj.zzqs();
        zzbdf = zzmj.zzqs();
        zzbdg = zzmj.zzqs();
    }

    LoyaltyWalletObject(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, String s7, String s8, String s9, int j, ArrayList arraylist, TimeInterval timeinterval, 
            ArrayList arraylist1, String s10, String s11, ArrayList arraylist2, boolean flag, ArrayList arraylist3, ArrayList arraylist4, 
            ArrayList arraylist5, LoyaltyPoints loyaltypoints)
    {
        mVersionCode = i;
        zzhL = s;
        zzbcP = s1;
        zzbcQ = s2;
        zzbcR = s3;
        zzaHT = s4;
        zzbcS = s5;
        zzbcT = s6;
        zzbcU = s7;
        zzbcV = s8;
        zzbcW = s9;
        state = j;
        zzbcX = arraylist;
        zzbcY = timeinterval;
        zzbcZ = arraylist1;
        zzbda = s10;
        zzbdb = s11;
        zzbdc = arraylist2;
        zzbdd = flag;
        zzbde = arraylist3;
        zzbdf = arraylist4;
        zzbdg = arraylist5;
        zzbdh = loyaltypoints;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String getAccountId()
    {
        return zzbcP;
    }

    public final String getAccountName()
    {
        return zzaHT;
    }

    public final String getBarcodeAlternateText()
    {
        return zzbcS;
    }

    public final String getBarcodeType()
    {
        return zzbcT;
    }

    public final String getBarcodeValue()
    {
        return zzbcU;
    }

    public final String getId()
    {
        return zzhL;
    }

    public final String getIssuerName()
    {
        return zzbcQ;
    }

    public final String getProgramName()
    {
        return zzbcR;
    }

    public final int getVersionCode()
    {
        return mVersionCode;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzj.zza(this, parcel, i);
    }

}
