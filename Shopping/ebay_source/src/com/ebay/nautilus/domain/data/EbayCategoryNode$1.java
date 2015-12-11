// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            EbayCategoryNode

static final class 
    implements android.os.EbayCategoryNode._cls1
{

    public EbayCategoryNode createFromParcel(Parcel parcel)
    {
        return new EbayCategoryNode(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public EbayCategoryNode[] newArray(int i)
    {
        return new EbayCategoryNode[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
