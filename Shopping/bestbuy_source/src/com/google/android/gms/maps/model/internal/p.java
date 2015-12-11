// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import apb;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.maps.model.internal:
//            a

public final class p
    implements SafeParcelable
{

    public static final apb CREATOR = new apb();
    private final int a;
    private a b;

    public p()
    {
        a = 1;
    }

    public p(int i, a a1)
    {
        a = i;
        b = a1;
    }

    public int a()
    {
        return a;
    }

    public a b()
    {
        return b;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        apb.a(this, parcel, i);
    }

}
