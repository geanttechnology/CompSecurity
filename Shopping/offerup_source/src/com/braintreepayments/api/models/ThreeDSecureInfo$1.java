// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.models;

import android.os.Parcel;

// Referenced classes of package com.braintreepayments.api.models:
//            ThreeDSecureInfo

final class _cls9
    implements android.os.ls.ThreeDSecureInfo._cls1
{

    public final ThreeDSecureInfo createFromParcel(Parcel parcel)
    {
        return new ThreeDSecureInfo(parcel, null);
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final ThreeDSecureInfo[] newArray(int i)
    {
        return new ThreeDSecureInfo[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    _cls9()
    {
    }
}
