// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzli;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.wallet.wobs:
//            zza, TimeInterval

public class CommonWalletObject
    implements SafeParcelable
{
    public final class zza
    {

        final CommonWalletObject zzaYu;

        public CommonWalletObject zzCo()
        {
            return zzaYu;
        }

        public zza zzfu(String s)
        {
            zzaYu.zzhL = s;
            return this;
        }

        private zza()
        {
            zzaYu = CommonWalletObject.this;
            super();
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new com.google.android.gms.wallet.wobs.zza();
    private final int mVersionCode;
    String name;
    int state;
    String zzaWJ;
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
    String zzhL;

    CommonWalletObject()
    {
        mVersionCode = 1;
        zzaWQ = zzli.zzpM();
        zzaWS = zzli.zzpM();
        zzaWV = zzli.zzpM();
        zzaWX = zzli.zzpM();
        zzaWY = zzli.zzpM();
        zzaWZ = zzli.zzpM();
    }

    CommonWalletObject(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, String s7, int j, ArrayList arraylist, TimeInterval timeinterval, ArrayList arraylist1, String s8, 
            String s9, ArrayList arraylist2, boolean flag, ArrayList arraylist3, ArrayList arraylist4, ArrayList arraylist5)
    {
        mVersionCode = i;
        zzhL = s;
        zzaWP = s1;
        name = s2;
        zzaWJ = s3;
        zzaWL = s4;
        zzaWM = s5;
        zzaWN = s6;
        zzaWO = s7;
        state = j;
        zzaWQ = arraylist;
        zzaWR = timeinterval;
        zzaWS = arraylist1;
        zzaWT = s8;
        zzaWU = s9;
        zzaWV = arraylist2;
        zzaWW = flag;
        zzaWX = arraylist3;
        zzaWY = arraylist4;
        zzaWZ = arraylist5;
    }

    public static zza zzCn()
    {
        CommonWalletObject commonwalletobject = new CommonWalletObject();
        commonwalletobject.getClass();
        return commonwalletobject. new zza();
    }

    public int describeContents()
    {
        return 0;
    }

    public String getId()
    {
        return zzhL;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.wallet.wobs.zza.zza(this, parcel, i);
    }

}
