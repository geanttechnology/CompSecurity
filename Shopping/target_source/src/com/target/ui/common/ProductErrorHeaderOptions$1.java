// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.common;

import android.os.Parcel;

// Referenced classes of package com.target.ui.common:
//            ProductErrorHeaderOptions

static final class 
    implements android.os.Options._cls1
{

    public ProductErrorHeaderOptions a(Parcel parcel)
    {
        return new ProductErrorHeaderOptions(parcel);
    }

    public ProductErrorHeaderOptions[] a(int i)
    {
        return new ProductErrorHeaderOptions[i];
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
