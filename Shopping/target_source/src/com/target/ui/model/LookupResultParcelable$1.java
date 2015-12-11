// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model:
//            LookupResultParcelable

static final class 
    implements android.os.elable._cls1
{

    public LookupResultParcelable a(Parcel parcel)
    {
        return new LookupResultParcelable(parcel, null);
    }

    public LookupResultParcelable[] a(int i)
    {
        return new LookupResultParcelable[i];
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
