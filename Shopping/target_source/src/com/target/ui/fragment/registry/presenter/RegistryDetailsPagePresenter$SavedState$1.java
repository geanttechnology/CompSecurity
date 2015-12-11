// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.registry.presenter;

import android.os.Parcel;

// Referenced classes of package com.target.ui.fragment.registry.presenter:
//            RegistryDetailsPagePresenter

static final class Y
    implements android.os.ailsPagePresenter.SavedState._cls1
{

    public Y a(Parcel parcel)
    {
        return new nit>(parcel);
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

    Y()
    {
    }
}
