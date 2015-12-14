// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.disk;

import java.io.File;

// Referenced classes of package com.facebook.cache.disk:
//            DefaultDiskStorageSupplier, DiskStorage

static class rootDirectory
{

    public final File rootDirectory;
    public final DiskStorage storage;

    (File file, DiskStorage diskstorage)
    {
        storage = diskstorage;
        rootDirectory = file;
    }
}
