// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.internal:
//            hw, ee

public class hu
    implements SafeParcelable
{

    public static final hw CREATOR = new hw();
    private final String DR[];
    private final String DS[];
    private final String DT[];
    private final String DU;
    private final String DV;
    private final String DW;
    private final String DX;
    private final String jG;
    private final int kg;

    hu(int i, String s, String as[], String as1[], String as2[], String s1, String s2, 
            String s3, String s4)
    {
        kg = i;
        jG = s;
        DR = as;
        DS = as1;
        DT = as2;
        DU = s1;
        DV = s2;
        DW = s3;
        DX = s4;
    }

    public hu(String s, String as[], String as1[], String as2[], String s1, String s2, String s3)
    {
        kg = 1;
        jG = s;
        DR = as;
        DS = as1;
        DT = as2;
        DU = s1;
        DV = s2;
        DW = s3;
        DX = null;
    }

    public int describeContents()
    {
        return 0;
    }

    public String[] eR()
    {
        return DR;
    }

    public String[] eS()
    {
        return DS;
    }

    public String[] eT()
    {
        return DT;
    }

    public String eU()
    {
        return DU;
    }

    public String eV()
    {
        return DV;
    }

    public String eW()
    {
        return DW;
    }

    public String eX()
    {
        return DX;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof hu)
        {
            if (kg == ((hu) (obj = (hu)obj)).kg && ee.equal(jG, ((hu) (obj)).jG) && Arrays.equals(DR, ((hu) (obj)).DR) && Arrays.equals(DS, ((hu) (obj)).DS) && Arrays.equals(DT, ((hu) (obj)).DT) && ee.equal(DU, ((hu) (obj)).DU) && ee.equal(DV, ((hu) (obj)).DV) && ee.equal(DW, ((hu) (obj)).DW) && ee.equal(DX, ((hu) (obj)).DX))
            {
                return true;
            }
        }
        return false;
    }

    public String getAccountName()
    {
        return jG;
    }

    public int getVersionCode()
    {
        return kg;
    }

    public int hashCode()
    {
        return ee.hashCode(new Object[] {
            Integer.valueOf(kg), jG, DR, DS, DT, DU, DV, DW, DX
        });
    }

    public String toString()
    {
        return ee.e(this).a("versionCode", Integer.valueOf(kg)).a("accountName", jG).a("requestedScopes", DR).a("visibleActivities", DS).a("requiredFeatures", DT).a("packageNameForAuth", DU).a("callingPackageName", DV).a("applicationName", DW).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        hw.a(this, parcel, i);
    }

}
