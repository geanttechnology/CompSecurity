// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable;

import com.google.android.gms.common.data.DataHolder;

// Referenced classes of package com.google.android.gms.wearable:
//            p, e

final class a
    implements Runnable
{

    final DataHolder a;
    final aHolder b;

    public final void run()
    {
        (new e(a)).b();
    }

    aHolder(aHolder aholder, DataHolder dataholder)
    {
        b = aholder;
        a = dataholder;
        super();
    }
}
