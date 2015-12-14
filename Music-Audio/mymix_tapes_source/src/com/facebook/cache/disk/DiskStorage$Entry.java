// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;

// Referenced classes of package com.facebook.cache.disk:
//            DiskStorage

public static interface 
{

    public abstract BinaryResource getResource();

    public abstract long getSize();

    public abstract long getTimestamp();
}
