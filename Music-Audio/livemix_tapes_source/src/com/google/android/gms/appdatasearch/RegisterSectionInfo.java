// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            zzi, Feature

public class RegisterSectionInfo
    implements SafeParcelable
{
    public static final class zza
    {

        private final String mName;
        private String zzPH;
        private boolean zzPI;
        private int zzPJ;
        private boolean zzPK;
        private String zzPL;
        private final List zzPM = new ArrayList();
        private BitSet zzPN;
        private String zzPO;

        public zza zzM(boolean flag)
        {
            zzPI = flag;
            return this;
        }

        public zza zzN(boolean flag)
        {
            zzPK = flag;
            return this;
        }

        public zza zzak(int i)
        {
            if (zzPN == null)
            {
                zzPN = new BitSet();
            }
            zzPN.set(i);
            return this;
        }

        public zza zzby(String s)
        {
            zzPH = s;
            return this;
        }

        public zza zzbz(String s)
        {
            zzPO = s;
            return this;
        }

        public RegisterSectionInfo zzld()
        {
            int i = 0;
            int ai[] = null;
            if (zzPN != null)
            {
                int ai1[] = new int[zzPN.cardinality()];
                int j = zzPN.nextSetBit(0);
                do
                {
                    ai = ai1;
                    if (j < 0)
                    {
                        break;
                    }
                    ai1[i] = j;
                    j = zzPN.nextSetBit(j + 1);
                    i++;
                } while (true);
            }
            return new RegisterSectionInfo(mName, zzPH, zzPI, zzPJ, zzPK, zzPL, (Feature[])zzPM.toArray(new Feature[zzPM.size()]), ai, zzPO);
        }

        public zza(String s)
        {
            mName = s;
            zzPJ = 1;
        }
    }


    public static final zzi CREATOR = new zzi();
    final int mVersionCode;
    public final String name;
    public final int weight;
    public final String zzPA;
    public final boolean zzPB;
    public final boolean zzPC;
    public final String zzPD;
    public final Feature zzPE[];
    final int zzPF[];
    public final String zzPG;

    RegisterSectionInfo(int i, String s, String s1, boolean flag, int j, boolean flag1, String s2, 
            Feature afeature[], int ai[], String s3)
    {
        mVersionCode = i;
        name = s;
        zzPA = s1;
        zzPB = flag;
        weight = j;
        zzPC = flag1;
        zzPD = s2;
        zzPE = afeature;
        zzPF = ai;
        zzPG = s3;
    }

    RegisterSectionInfo(String s, String s1, boolean flag, int i, boolean flag1, String s2, Feature afeature[], 
            int ai[], String s3)
    {
        this(2, s, s1, flag, i, flag1, s2, afeature, ai, s3);
    }

    public int describeContents()
    {
        zzi zzi1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzi zzi1 = CREATOR;
        zzi.zza(this, parcel, i);
    }

}
