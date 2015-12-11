// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            l

public final class ProxyCard
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new l();
    String GY;
    String GZ;
    int Ha;
    int Hb;
    private final int kg;

    ProxyCard(int i, String s, String s1, int j, int k)
    {
        kg = i;
        GY = s;
        GZ = s1;
        Ha = j;
        Hb = k;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getCvn()
    {
        return GZ;
    }

    public int getExpirationMonth()
    {
        return Ha;
    }

    public int getExpirationYear()
    {
        return Hb;
    }

    public String getPan()
    {
        return GY;
    }

    public int getVersionCode()
    {
        return kg;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        l.a(this, parcel, i);
    }

}
