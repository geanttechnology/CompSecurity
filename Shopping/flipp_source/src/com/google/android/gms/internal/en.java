// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            hg, ep, hk

public class en
    implements SafeParcelable
{

    public static final hg CREATOR = new hg();
    final int a;
    final ep b;

    en(int i, ep ep1)
    {
        a = i;
        b = ep1;
    }

    private en(ep ep1)
    {
        a = 1;
        b = ep1;
    }

    public static en a(hk hk)
    {
        if (hk instanceof ep)
        {
            return new en((ep)hk);
        } else
        {
            throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        hg.a(this, parcel, i);
    }

}
