// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.e;

// Referenced classes of package com.google.android.gms.games:
//            Player, g, PlayerEntity

public final class d extends e
    implements Player
{

    private final g c;

    public d(DataHolder dataholder, int j)
    {
        this(dataholder, j, (byte)0);
    }

    private d(DataHolder dataholder, int j, byte byte0)
    {
        super(dataholder, j);
        c = new g();
    }

    private Player i()
    {
        return new PlayerEntity(this);
    }

    public final Object a()
    {
        return i();
    }

    public final String b()
    {
        return d(c.a);
    }

    public final String c()
    {
        return d(c.b);
    }

    public final Uri d()
    {
        return f(c.c);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final Uri e()
    {
        return f(c.d);
    }

    public final boolean equals(Object obj)
    {
        return PlayerEntity.a(this, obj);
    }

    public final long f()
    {
        return a(c.e);
    }

    public final long g()
    {
        String s = c.g;
        if (!super.a.c.containsKey(s))
        {
            return -1L;
        } else
        {
            return a(c.g);
        }
    }

    public final int h()
    {
        return b(c.f);
    }

    public final int hashCode()
    {
        return PlayerEntity.a(this);
    }

    public final String toString()
    {
        return PlayerEntity.b(this);
    }

    public final void writeToParcel(Parcel parcel, int j)
    {
        ((PlayerEntity)i()).writeToParcel(parcel, j);
    }
}
