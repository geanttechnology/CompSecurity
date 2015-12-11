// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.ota;

import android.os.Parcel;

// Referenced classes of package com.amazon.dcp.ota:
//            UpdateState

static final class 
    implements android.os.ator
{

    public UpdateState createFromParcel(Parcel parcel)
    {
        return UpdateState.fromValue(parcel.readInt());
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public UpdateState[] newArray(int i)
    {
        return new UpdateState[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
