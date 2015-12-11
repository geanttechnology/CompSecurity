// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmj;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.wallet.wobs:
//            zza, TimeInterval

public class CommonWalletObject
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new com.google.android.gms.wallet.wobs.zza();
    private final int mVersionCode;
    String name;
    int state;
    String zzbcQ;
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
    String zzhL;

    CommonWalletObject()
    {
        mVersionCode = 1;
        zzbcX = zzmj.zzqs();
        zzbcZ = zzmj.zzqs();
        zzbdc = zzmj.zzqs();
        zzbde = zzmj.zzqs();
        zzbdf = zzmj.zzqs();
        zzbdg = zzmj.zzqs();
    }

    CommonWalletObject(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, String s7, int j, ArrayList arraylist, TimeInterval timeinterval, ArrayList arraylist1, String s8, 
            String s9, ArrayList arraylist2, boolean flag, ArrayList arraylist3, ArrayList arraylist4, ArrayList arraylist5)
    {
        mVersionCode = i;
        zzhL = s;
        zzbcW = s1;
        name = s2;
        zzbcQ = s3;
        zzbcS = s4;
        zzbcT = s5;
        zzbcU = s6;
        zzbcV = s7;
        state = j;
        zzbcX = arraylist;
        zzbcY = timeinterval;
        zzbcZ = arraylist1;
        zzbda = s8;
        zzbdb = s9;
        zzbdc = arraylist2;
        zzbdd = flag;
        zzbde = arraylist3;
        zzbdf = arraylist4;
        zzbdg = arraylist5;
    }

    public static zza zzEI()
    {
        CommonWalletObject commonwalletobject = new CommonWalletObject();
        commonwalletobject.getClass();
        return commonwalletobject. new zza(null);
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


    private class zza
    {

        final CommonWalletObject zzbeC;

        public final CommonWalletObject zzEJ()
        {
            return zzbeC;
        }

        public final zza zzfv(String s)
        {
            zzbeC.zzhL = s;
            return this;
        }

        private zza()
        {
            zzbeC = CommonWalletObject.this;
            super();
        }

        zza(_cls1 _pcls1)
        {
            this();
        }
    }

}
