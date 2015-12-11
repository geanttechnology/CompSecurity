// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.cachemanager;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.ebay.nautilus.kernel.cachemanager:
//            CacheManager

public static interface I
{

    public abstract void deflateCached(OutputStream outputstream, Object obj)
        throws IOException;

    public abstract Object inflateCached(InputStream inputstream, Class class1)
        throws IOException;
}
