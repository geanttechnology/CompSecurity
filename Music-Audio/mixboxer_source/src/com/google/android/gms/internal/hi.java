// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            hj, ee

public class hi
    implements SafeParcelable
{

    public static final hj CREATOR = new hj();
    public final String Bn;
    public final String Bo;
    public final int versionCode;

    public hi(int i, String s, String s1)
    {
        versionCode = i;
        Bn = s;
        Bo = s1;
    }

    public int describeContents()
    {
        hj hj1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || !(obj instanceof hi))
            {
                return false;
            }
            obj = (hi)obj;
            if (!Bo.equals(((hi) (obj)).Bo) || !Bn.equals(((hi) (obj)).Bn))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return ee.hashCode(new Object[] {
            Bn, Bo
        });
    }

    public String toString()
    {
        return ee.e(this).a("clientPackageName", Bn).a("locale", Bo).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        hj hj1 = CREATOR;
        hj.a(this, parcel, i);
    }

}
