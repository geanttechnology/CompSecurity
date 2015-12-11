// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.p;

import com.shazam.model.Tag;
import java.util.concurrent.Semaphore;

// Referenced classes of package com.shazam.android.persistence.p:
//            e

final class a
    implements Runnable
{

    final Tag a;
    final e b;

    public final void run()
    {
        b.a(a);
        e.f().release();
        return;
        Exception exception;
        exception;
        e.f().release();
        throw exception;
    }

    (e e1, Tag tag)
    {
        b = e1;
        a = tag;
        super();
    }
}
