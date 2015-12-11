// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;

import android.os.Parcel;

// Referenced classes of package com.urbanairship.push.iam:
//            InAppMessage

final class 
    implements android.os.tor
{

    public final InAppMessage createFromParcel(Parcel parcel)
    {
        return new InAppMessage(parcel, null);
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final InAppMessage[] newArray(int i)
    {
        return new InAppMessage[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
