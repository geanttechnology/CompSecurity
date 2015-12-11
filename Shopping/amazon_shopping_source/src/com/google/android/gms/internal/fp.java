// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            fq, fm

public class fp
    implements SafeParcelable
{

    public static final fq CREATOR = new fq();
    public final String name;
    public final int weight;
    final int xM;
    public final String yb;
    public final boolean yc;
    public final boolean yd;
    public final String ye;
    public final fm yf[];
    final int yg[];
    public final String yh;

    fp(int i, String s, String s1, boolean flag, int j, boolean flag1, String s2, 
            fm afm[], int ai[], String s3)
    {
        xM = i;
        name = s;
        yb = s1;
        yc = flag;
        weight = j;
        yd = flag1;
        ye = s2;
        yf = afm;
        yg = ai;
        yh = s3;
    }

    public int describeContents()
    {
        fq fq1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof fp)
        {
            obj = (fp)obj;
            flag = flag1;
            if (name.equals(((fp) (obj)).name))
            {
                flag = flag1;
                if (yb.equals(((fp) (obj)).yb))
                {
                    flag = flag1;
                    if (yc == ((fp) (obj)).yc)
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        fq fq1 = CREATOR;
        fq.a(this, parcel, i);
    }

}
