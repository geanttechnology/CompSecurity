// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import atg;
import ath;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class OfferWalletObject
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new atg();
    public String a;
    public String b;
    public CommonWalletObject c;
    private final int d;

    OfferWalletObject()
    {
        d = 3;
    }

    public OfferWalletObject(int i, String s, String s1, CommonWalletObject commonwalletobject)
    {
        d = i;
        b = s1;
        if (i < 3)
        {
            c = CommonWalletObject.a().a(s).a();
            return;
        } else
        {
            c = commonwalletobject;
            return;
        }
    }

    public int a()
    {
        return d;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        atg.a(this, parcel, i);
    }

}
