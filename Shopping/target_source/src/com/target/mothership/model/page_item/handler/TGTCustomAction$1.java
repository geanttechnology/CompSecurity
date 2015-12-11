// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.page_item.handler:
//            TGTCustomAction

static final class 
    implements android.os.
{

    public TGTCustomAction a(Parcel parcel)
    {
        return new TGTCustomAction(parcel, null);
    }

    public TGTCustomAction[] a(int i)
    {
        return new TGTCustomAction[i];
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
