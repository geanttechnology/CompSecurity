// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.disk;

import java.io.IOException;

// Referenced classes of package com.facebook.cache.disk:
//            DiskStorage

public interface DiskStorageSupplier
{

    public abstract DiskStorage get()
        throws IOException;
}
