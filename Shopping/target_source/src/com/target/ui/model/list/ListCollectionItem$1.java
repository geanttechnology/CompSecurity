// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.list;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model.list:
//            ListCollectionItem

static final class 
    implements android.os.lectionItem._cls1
{

    public ListCollectionItem a(Parcel parcel)
    {
        return new ListCollectionItem(parcel, null);
    }

    public ListCollectionItem[] a(int i)
    {
        return new ListCollectionItem[i];
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
