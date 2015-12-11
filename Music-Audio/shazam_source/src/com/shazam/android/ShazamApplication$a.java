// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android;

import com.shazam.android.u.c;
import com.shazam.i.b.u.a;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.shazam.android:
//            ShazamApplication

private final class <init>
    implements com.facebook.ion.a
{

    final ShazamApplication a;

    public final void a()
    {
        c c1 = com.shazam.i.b.u.a.a();
        if (com.shazam.b.e.a.a(c1.a()))
        {
            c1.b.submit(c1.c);
        }
    }

    private (ShazamApplication shazamapplication)
    {
        a = shazamapplication;
        super();
    }

    a(ShazamApplication shazamapplication, byte byte0)
    {
        this(shazamapplication);
    }
}
