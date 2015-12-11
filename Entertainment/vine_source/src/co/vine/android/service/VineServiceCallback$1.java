// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.os.Parcel;

// Referenced classes of package co.vine.android.service:
//            VineServiceCallback

static final class 
    implements android.os.ceCallback._cls1
{

    public VineServiceCallback createFromParcel(Parcel parcel)
    {
        return new VineServiceCallback(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public VineServiceCallback[] newArray(int i)
    {
        return new VineServiceCallback[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
