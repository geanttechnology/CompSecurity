// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.common.internal.Preconditions;
import java.io.File;

// Referenced classes of package com.facebook.cache.disk:
//            DefaultDiskStorage

class <init>
    implements <init>
{

    private final FileBinaryResource resource;
    private long size;
    final DefaultDiskStorage this$0;
    private long timestamp;

    public volatile BinaryResource getResource()
    {
        return getResource();
    }

    public FileBinaryResource getResource()
    {
        return resource;
    }

    public long getSize()
    {
        if (size < 0L)
        {
            size = resource.size();
        }
        return size;
    }

    public long getTimestamp()
    {
        if (timestamp < 0L)
        {
            timestamp = resource.getFile().lastModified();
        }
        return timestamp;
    }

    private (File file)
    {
        this$0 = DefaultDiskStorage.this;
        super();
        Preconditions.checkNotNull(file);
        resource = FileBinaryResource.createOrNull(file);
        size = -1L;
        timestamp = -1L;
    }

    timestamp(File file, timestamp timestamp1)
    {
        this(file);
    }
}
