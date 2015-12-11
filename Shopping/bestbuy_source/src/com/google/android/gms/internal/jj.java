// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import acx;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class jj
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new acx();
    public final int a;
    public final int b;
    public int c;
    public String d;
    public IBinder e;
    public Scope f[];
    public Bundle g;

    public jj(int i, int j, int k, String s, IBinder ibinder, Scope ascope[], Bundle bundle)
    {
        a = i;
        b = j;
        c = k;
        d = s;
        e = ibinder;
        f = ascope;
        g = bundle;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        acx.a(this, parcel, i);
    }

}
