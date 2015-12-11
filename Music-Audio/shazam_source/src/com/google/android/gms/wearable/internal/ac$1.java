// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            aw, ac, ao, x

final class nit> extends aw
{

    final ac c;

    protected final g a(Status status)
    {
        return new <init>(status, new ArrayList());
    }

    protected final void a(com.google.android.gms.common.api._cls1 _pcls1)
    {
        ((x)((ao)_pcls1).m()).d(new <init>(this));
    }

    (ac ac1, c c1)
    {
        c = ac1;
        super(c1);
    }
}
