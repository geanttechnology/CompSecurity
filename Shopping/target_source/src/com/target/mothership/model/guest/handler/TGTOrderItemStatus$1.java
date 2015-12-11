// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            TGTOrderItemStatus

static final class 
    implements android.os.t.handler.TGTOrderItemStatus._cls1
{

    public TGTOrderItemStatus a(Parcel parcel)
    {
        return new TGTOrderItemStatus(parcel, null);
    }

    public TGTOrderItemStatus[] a(int i)
    {
        return new TGTOrderItemStatus[i];
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
