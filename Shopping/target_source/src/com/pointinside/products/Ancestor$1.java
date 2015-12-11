// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import android.os.Parcel;

// Referenced classes of package com.pointinside.products:
//            Ancestor

static final class 
    implements android.os.Creator
{

    public Ancestor createFromParcel(Parcel parcel)
    {
        return new Ancestor(parcel.readString(), parcel.readString());
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public Ancestor[] newArray(int i)
    {
        return new Ancestor[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
