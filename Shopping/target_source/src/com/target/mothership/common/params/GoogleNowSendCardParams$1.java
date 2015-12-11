// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.params;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.common.params:
//            GoogleNowSendCardParams

static final class 
    implements android.os.oogleNowSendCardParams._cls1
{

    public GoogleNowSendCardParams a(Parcel parcel)
    {
        return new GoogleNowSendCardParams(parcel, null);
    }

    public GoogleNowSendCardParams[] a(int i)
    {
        return new GoogleNowSendCardParams[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    ()
    {
    }
}
