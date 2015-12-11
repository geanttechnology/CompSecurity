// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;

// Referenced classes of package co.vine.android.api:
//            VineClientFlags

static final class 
    implements android.os.
{

    public VineClientFlags createFromParcel(Parcel parcel)
    {
        return new VineClientFlags(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public VineClientFlags[] newArray(int i)
    {
        return new VineClientFlags[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
