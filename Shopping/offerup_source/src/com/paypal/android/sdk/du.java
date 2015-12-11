// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.os.Parcel;

// Referenced classes of package com.paypal.android.sdk:
//            ew

final class du
    implements android.os.Parcelable.Creator
{

    du()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return new ew(parcel);
    }

    public final volatile Object[] newArray(int i)
    {
        return new ew[i];
    }
}
