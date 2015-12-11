// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.a;
import com.google.android.gms.location.places.internal.m;

// Referenced classes of package com.google.android.gms.location.places:
//            m, d

public class e extends a
    implements g
{

    private final Context b;
    private final Status c;
    private final String d;

    public e(DataHolder dataholder, Context context)
    {
        super(dataholder);
        b = context;
        c = m.c(dataholder.e());
        if (dataholder != null && dataholder.f() != null)
        {
            d = dataholder.f().getString("com.google.android.gms.location.places.PlaceBuffer.ATTRIBUTIONS_EXTRA_KEY");
            return;
        } else
        {
            d = null;
            return;
        }
    }

    public Status a()
    {
        return c;
    }

    public Object a(int i)
    {
        return b(i);
    }

    public d b(int i)
    {
        return new m(a, i, b);
    }
}
