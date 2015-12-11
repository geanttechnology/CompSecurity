// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.contextualmenu.api;

import android.os.Parcel;

// Referenced classes of package com.fanhattan.services.contextualmenu.api:
//            ContextualMenu

static final class 
    implements android.os.r
{

    public ContextualMenu createFromParcel(Parcel parcel)
    {
        return new ContextualMenu(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public ContextualMenu[] newArray(int i)
    {
        return new ContextualMenu[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
