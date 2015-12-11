// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.registry;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model.registry:
//            RegistryRefineModel

static final class 
    implements android.os.stryRefineModel._cls1
{

    public RegistryRefineModel a(Parcel parcel)
    {
        return new RegistryRefineModel(parcel);
    }

    public RegistryRefineModel[] a(int i)
    {
        return new RegistryRefineModel[i];
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
