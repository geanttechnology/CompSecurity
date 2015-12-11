// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.common:
//            TGTOrderProductImage

static final class 
    implements android.os..TGTOrderProductImage._cls1
{

    public TGTOrderProductImage a(Parcel parcel)
    {
        return new TGTOrderProductImage(parcel, null);
    }

    public TGTOrderProductImage[] a(int i)
    {
        return new TGTOrderProductImage[i];
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
