// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;

import java.io.File;
import java.util.Comparator;

// Referenced classes of package com.amazon.gallery.framework.data.store:
//            CloudDriveAssetDiskEvictor

public static class 
    implements Comparator
{

    public int compare(File file, File file1)
    {
        long l = file.lastModified() - file1.lastModified();
        if (l > 0L)
        {
            return 1;
        }
        if (l < 0L)
        {
            return -1;
        } else
        {
            return file.compareTo(file1);
        }
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((File)obj, (File)obj1);
    }

    public ()
    {
    }
}
