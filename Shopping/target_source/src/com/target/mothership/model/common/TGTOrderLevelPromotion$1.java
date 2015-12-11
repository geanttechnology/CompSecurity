// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.common:
//            TGTOrderLevelPromotion

static final class A
    implements android.os.GTOrderLevelPromotion._cls1
{

    public TGTOrderLevelPromotion a(Parcel parcel)
    {
        return new TGTOrderLevelPromotion(parcel, null);
    }

    public TGTOrderLevelPromotion[] a(int i)
    {
        return new TGTOrderLevelPromotion[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    A()
    {
    }
}
