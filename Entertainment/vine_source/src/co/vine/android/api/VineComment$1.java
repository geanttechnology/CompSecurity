// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;

// Referenced classes of package co.vine.android.api:
//            VineComment

static final class 
    implements android.os.ator
{

    public VineComment createFromParcel(Parcel parcel)
    {
        return new VineComment(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public VineComment[] newArray(int i)
    {
        return new VineComment[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
