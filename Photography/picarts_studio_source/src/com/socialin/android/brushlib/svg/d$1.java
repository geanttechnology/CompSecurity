// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.svg;

import android.support.v4.util.LruCache;

// Referenced classes of package com.socialin.android.brushlib.svg:
//            d, a

final class > extends LruCache
{

    protected final Object create(Object obj)
    {
        obj = (String)obj;
        return a.a(d.b(), ((String) (obj)));
    }

    ()
    {
        super(10);
    }
}
