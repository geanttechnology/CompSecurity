// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            ax

public final class aw
    implements SafeParcelable
{

    public static final ax CREATOR = new ax();
    public final int backgroundColor;
    public final int mD;
    public final int mE;
    public final int mF;
    public final int mG;
    public final int mH;
    public final int mI;
    public final int mJ;
    public final String mK;
    public final int mL;
    public final String mM;
    public final int mN;
    public final int mO;
    public final String mP;
    public final int versionCode;

    aw(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, String s, int j2, String s1, int k2, int l2, 
            String s2)
    {
        versionCode = i;
        mD = j;
        backgroundColor = k;
        mE = l;
        mF = i1;
        mG = j1;
        mH = k1;
        mI = l1;
        mJ = i2;
        mK = s;
        mL = j2;
        mM = s1;
        mN = k2;
        mO = l2;
        mP = s2;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ax.a(this, parcel, i);
    }

}
