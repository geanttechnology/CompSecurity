// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth;

import a;
import android.os.Parcel;
import atx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class AccountChangeEventsResponse
    implements SafeParcelable
{

    public static final atx CREATOR = new atx();
    public final int a;
    public final List b;

    public AccountChangeEventsResponse(int i, List list)
    {
        a = i;
        b = (List)a.d(list);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        atx.a(this, parcel);
    }

}
