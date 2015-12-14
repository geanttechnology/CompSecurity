// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

// Referenced classes of package com.bumptech.glide.load.engine:
//            Engine, EngineResource

private static class key extends WeakReference
{

    private final Key key;


    public A(Key key1, EngineResource engineresource, ReferenceQueue referencequeue)
    {
        super(engineresource, referencequeue);
        key = key1;
    }
}
