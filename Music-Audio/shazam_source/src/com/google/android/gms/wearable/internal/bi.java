// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.e;
import com.google.android.gms.wearable.d;
import com.google.android.gms.wearable.f;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            bh, f

public final class bi extends e
    implements d
{

    private final int c;

    public bi(DataHolder dataholder, int i, int j)
    {
        super(dataholder, i);
        c = j;
    }

    public final Object a()
    {
        return new bh(this);
    }

    public final f b()
    {
        return new com.google.android.gms.wearable.internal.f(a, b, c);
    }

    public final int c()
    {
        return a("event_type");
    }

    public final String toString()
    {
        String s;
        if (a("event_type") == 1)
        {
            s = "changed";
        } else
        if (a("event_type") == 2)
        {
            s = "deleted";
        } else
        {
            s = "unknown";
        }
        return (new StringBuilder("DataEventRef{ type=")).append(s).append(", dataitem=").append(b()).append(" }").toString();
    }
}
