// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.params;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.common.params:
//            RegistrySearchParam

static final class 
    implements android.os.ms.RegistrySearchParam._cls1
{

    public RegistrySearchParam a(Parcel parcel)
    {
        return new RegistrySearchParam(parcel);
    }

    public RegistrySearchParam[] a(int i)
    {
        return new RegistrySearchParam[i];
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
