// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.list;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model.list:
//            ListDetailItem

static final class 
    implements android.os.r
{

    public ListDetailItem a(Parcel parcel)
    {
        return new ListDetailItem(parcel, null);
    }

    public ListDetailItem[] a(int i)
    {
        return new ListDetailItem[i];
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
