// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.content.Context;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.d;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            o, k

public class m extends o
    implements d
{

    private boolean c;
    private final k d;
    private final String e = a("place_id", "");

    public m(DataHolder dataholder, int i, Context context)
    {
        super(dataholder, i);
        if (context != null)
        {
            dataholder = k.a(context);
        } else
        {
            dataholder = null;
        }
        d = dataholder;
        c = a("place_is_logging_enabled", false);
    }
}
