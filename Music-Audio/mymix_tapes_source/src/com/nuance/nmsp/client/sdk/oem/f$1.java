// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmsp.client.sdk.oem;

import android.os.Looper;

// Referenced classes of package com.nuance.nmsp.client.sdk.oem:
//            f, a

final class a
    implements Runnable
{

    private f a;

    public final void run()
    {
        Looper.prepare();
        f.b(a).a();
        Looper.loop();
    }

    (f f1)
    {
        a = f1;
        super();
    }
}
