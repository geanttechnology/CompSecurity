// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.os.Parcel;

// Referenced classes of package com.target.ui.view.product:
//            ProductCollectionHeaderView

static final class I
    implements android.os.ew.SavedState._cls1
{

    public I a(Parcel parcel)
    {
        return new nit>(parcel, null);
    }

    public nit>[] a(int i)
    {
        return new nit>[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    I()
    {
    }
}
