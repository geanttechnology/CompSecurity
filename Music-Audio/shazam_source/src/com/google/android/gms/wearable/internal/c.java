// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.e;
import com.google.android.gms.wearable.g;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            bj

public final class c extends e
    implements g
{

    public c(DataHolder dataholder, int i)
    {
        super(dataholder, i);
    }

    public final Object a()
    {
        return new bj(this);
    }

    public final String b()
    {
        return b("asset_id");
    }

    public final String c()
    {
        return b("asset_key");
    }
}
