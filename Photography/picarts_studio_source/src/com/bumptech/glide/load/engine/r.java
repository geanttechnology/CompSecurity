// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.b;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

// Referenced classes of package com.bumptech.glide.load.engine:
//            y

public final class r extends WeakReference
{

    private final b a;

    public r(b b, y y, ReferenceQueue referencequeue)
    {
        super(y, referencequeue);
        a = b;
    }

    static b a(r r1)
    {
        return r1.a;
    }
}
