// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.os.Parcel;

// Referenced classes of package com.tapjoy.internal:
//            bt

static final class ator
    implements android.os.lable.Creator
{

    public final Object createFromParcel(Parcel parcel)
    {
        return new bt(parcel.readString());
    }

    public final volatile Object[] newArray(int i)
    {
        return new bt[i];
    }

    ator()
    {
    }
}
