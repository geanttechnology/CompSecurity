// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.impl;

import android.os.Parcel;

// Referenced classes of package com.gimbal.internal.proximity.impl:
//            TransmitterInternal

static final class 
    implements android.os.l.TransmitterInternal._cls1
{

    public final Object createFromParcel(Parcel parcel)
    {
        return new TransmitterInternal(parcel, null);
    }

    public final volatile Object[] newArray(int i)
    {
        return new TransmitterInternal[i];
    }

    ()
    {
    }
}
