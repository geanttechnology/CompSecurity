// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import ahq;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class y
    implements SafeParcelable
{

    public static final ahq CREATOR = new ahq();
    public final int a;
    public final boolean b;
    public final boolean c;

    public y(int i, boolean flag, boolean flag1)
    {
        a = i;
        b = flag;
        c = flag1;
    }

    public y(boolean flag, boolean flag1)
    {
        a = 1;
        b = flag;
        c = flag1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ahq.a(this, parcel, i);
    }

}
