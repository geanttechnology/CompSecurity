// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.math.BigDecimal;
import java.util.Currency;

// Referenced classes of package com.paypal.android.sdk:
//            dq

public class es
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new dq();
    private static boolean d;
    private BigDecimal a;
    private Currency b;
    private long c;

    public es(Parcel parcel)
    {
        c = parcel.readLong();
        a = new BigDecimal(parcel.readString());
        try
        {
            b = Currency.getInstance(parcel.readString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            Log.e("MoneySpec", "Exception reading currency code from parcel, reset to default");
        }
        throw new NullPointerException();
    }

    public final BigDecimal a()
    {
        throw new NullPointerException();
    }

    public final Currency b()
    {
        throw new NullPointerException();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (!d && !(obj instanceof es))
        {
            throw new AssertionError();
        }
        obj = (es)obj;
        return ((es) (obj)).a == a && ((es) (obj)).b.equals(b);
    }

    public String toString()
    {
        throw new NullPointerException();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(c);
        parcel.writeString(a.toString());
        parcel.writeString(b.getCurrencyCode());
    }

    static 
    {
        boolean flag;
        if (!com/paypal/android/sdk/es.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = flag;
    }
}
