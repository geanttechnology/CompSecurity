// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.callback;

import android.os.Parcel;

// Referenced classes of package com.amazon.identity.auth.device.callback:
//            RemoteCallbackWrapper

static final class 
    implements android.os.lback.RemoteCallbackWrapper._cls1
{

    public RemoteCallbackWrapper createFromParcel(Parcel parcel)
    {
        return new RemoteCallbackWrapper(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public RemoteCallbackWrapper[] newArray(int i)
    {
        return new RemoteCallbackWrapper[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
