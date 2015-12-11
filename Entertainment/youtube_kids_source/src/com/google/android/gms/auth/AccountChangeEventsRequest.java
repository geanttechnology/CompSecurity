// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth;

import android.os.Parcel;
import atw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest
    implements SafeParcelable
{

    public static final atw CREATOR = new atw();
    public final int a;
    public int b;
    public String c;

    public AccountChangeEventsRequest()
    {
        a = 1;
    }

    public AccountChangeEventsRequest(int i, int j, String s)
    {
        a = i;
        b = j;
        c = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        atw.a(this, parcel);
    }

}
