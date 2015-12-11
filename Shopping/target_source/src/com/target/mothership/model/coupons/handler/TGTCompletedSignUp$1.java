// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.coupons.handler:
//            TGTCompletedSignUp

static final class 
    implements android.os.ons.handler.TGTCompletedSignUp._cls1
{

    public TGTCompletedSignUp a(Parcel parcel)
    {
        return new TGTCompletedSignUp(parcel);
    }

    public TGTCompletedSignUp[] a(int i)
    {
        return new TGTCompletedSignUp[i];
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
