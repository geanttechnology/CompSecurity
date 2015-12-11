// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import auu;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            al

public class ab
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new auu();
    public final int a;
    public final int b;
    public final al c;

    public ab(int i, int j, al al)
    {
        a = i;
        b = j;
        c = al;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        auu.a(this, parcel, i);
    }

}
