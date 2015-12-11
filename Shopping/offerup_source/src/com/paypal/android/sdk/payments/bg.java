// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.paypal.android.sdk.payments:
//            ak

final class bg extends Enum
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ak();
    public static final bg a;
    public static final bg b;
    public static final bg c;
    public static final bg d;
    public static final bg e;
    public static final bg f;
    public static final bg g;
    public static final bg h;
    public static final bg i;
    public static final bg j;
    public static final bg k;
    public static final bg l;
    public static final bg m;
    private static final bg n[];

    private bg(String s, int i1)
    {
        super(s, i1);
    }

    public static bg valueOf(String s)
    {
        return (bg)Enum.valueOf(com/paypal/android/sdk/payments/bg, s);
    }

    public static bg[] values()
    {
        return (bg[])n.clone();
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeSerializable(this);
    }

    static 
    {
        a = new bg("EMAIL", 0);
        b = new bg("PIN", 1);
        c = new bg("EMAIL_LOGIN_IN_PROGRESS", 2);
        d = new bg("PIN_LOGIN_IN_PROGRESS", 3);
        e = new bg("EMAIL_LOGIN_FAILED", 4);
        f = new bg("PIN_LOGIN_FAILED", 5);
        g = new bg("TWO_FA_SEND_FIRST_SMS", 6);
        h = new bg("TWO_FA_SEND_FIRST_SMS_IN_PROGRESS", 7);
        i = new bg("TWO_FA_SEND_ANOTHER_SMS_IN_PROGRESS", 8);
        j = new bg("TWO_FA_ENTER_OTP", 9);
        k = new bg("TWO_FA_LOGIN_OTP_IN_PROGRESS", 10);
        l = new bg("TWO_FA_SEND_SMS_FAILED", 11);
        m = new bg("TWO_FA_LOGIN_OTP_FAILED", 12);
        n = (new bg[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m
        });
    }
}
