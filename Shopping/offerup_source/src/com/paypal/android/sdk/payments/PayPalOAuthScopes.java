// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.paypal.android.sdk.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.paypal.android.sdk.payments:
//            as

public final class PayPalOAuthScopes
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new as();
    public static final String a;
    public static final String b;
    private List c;

    public PayPalOAuthScopes()
    {
        c = new ArrayList();
    }

    private PayPalOAuthScopes(Parcel parcel)
    {
        c = new ArrayList();
        int j = parcel.readInt();
        for (int i = 0; i < j; i++)
        {
            c.add(parcel.readString());
        }

    }

    PayPalOAuthScopes(Parcel parcel, byte byte0)
    {
        this(parcel);
    }

    public PayPalOAuthScopes(Set set)
    {
        this();
        String s;
        for (set = set.iterator(); set.hasNext(); c.add(s))
        {
            s = (String)set.next();
        }

    }

    final List a()
    {
        return c;
    }

    final String b()
    {
        return TextUtils.join(" ", c);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String toString()
    {
        return String.format((new StringBuilder()).append(com/paypal/android/sdk/payments/PayPalOAuthScopes.getSimpleName()).append(": {%s}").toString(), new Object[] {
            c
        });
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(c.size());
        for (i = 0; i < c.size(); i++)
        {
            parcel.writeString((String)c.get(i));
        }

    }

    static 
    {
        a = o.a.a();
        o.b.a();
        o.c.a();
        b = o.e.a();
        o.f.a();
        o.g.a();
        o.d.a();
    }
}
