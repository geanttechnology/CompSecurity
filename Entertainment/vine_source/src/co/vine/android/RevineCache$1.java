// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Parcel;

// Referenced classes of package co.vine.android:
//            RevineCache

static final class 
    implements android.os.ator
{

    public RevineCache createFromParcel(Parcel parcel)
    {
        return new RevineCache(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public RevineCache[] newArray(int i)
    {
        return new RevineCache[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
