// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.refine;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model.refine:
//            ProductRefineModel

static final class 
    implements android.os.ctRefineModel._cls2
{

    public ProductRefineModel a(Parcel parcel)
    {
        return new ProductRefineModel(parcel, null);
    }

    public ProductRefineModel[] a(int i)
    {
        return new ProductRefineModel[i];
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
