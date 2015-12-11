// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.os.Parcel;

// Referenced classes of package com.paypal.android.sdk.payments:
//            bg

final class ak
    implements android.os.Parcelable.Creator
{

    ak()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return (bg)parcel.readSerializable();
    }

    public final volatile Object[] newArray(int i)
    {
        return new bg[i];
    }
}
