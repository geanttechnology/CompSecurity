// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.source;

import java.io.File;
import java.util.Comparator;

// Referenced classes of package com.amazon.device.crashmanager.source:
//            RamDumpArtifactSource

private static final class <init>
    implements Comparator
{

    public int compare(File file, File file1)
    {
        return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file1.lastModified()));
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((File)obj, (File)obj1);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
