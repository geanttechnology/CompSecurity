// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import android.os.Parcel;

// Referenced classes of package com.urbanairship.push:
//            PushMessage

final class 
    implements android.os.ator
{

    public final PushMessage createFromParcel(Parcel parcel)
    {
        return new PushMessage(parcel.readBundle());
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final PushMessage[] newArray(int i)
    {
        return new PushMessage[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
