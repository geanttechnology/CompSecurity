// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.common:
//            TGTPickUpPersonDetails

static final class A
    implements android.os.GTPickUpPersonDetails._cls1
{

    public TGTPickUpPersonDetails a(Parcel parcel)
    {
        return new TGTPickUpPersonDetails(parcel, null);
    }

    public TGTPickUpPersonDetails[] a(int i)
    {
        return new TGTPickUpPersonDetails[i];
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
