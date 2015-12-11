// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTTeamMemberDiscount

static final class 
    implements android.os.ndler.TGTTeamMemberDiscount._cls1
{

    public TGTTeamMemberDiscount a(Parcel parcel)
    {
        return new TGTTeamMemberDiscount(parcel, null);
    }

    public TGTTeamMemberDiscount[] a(int i)
    {
        return new TGTTeamMemberDiscount[i];
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
