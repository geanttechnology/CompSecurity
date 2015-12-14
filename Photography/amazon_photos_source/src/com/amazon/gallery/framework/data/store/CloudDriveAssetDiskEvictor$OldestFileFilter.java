// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;

import java.io.File;
import java.io.FileFilter;
import java.util.SortedSet;
import java.util.TreeSet;

// Referenced classes of package com.amazon.gallery.framework.data.store:
//            CloudDriveAssetDiskEvictor

private static class filterNameSnippet
    implements FileFilter
{

    private long filesTotalSize;
    private final String filterNameSnippet;
    private final int limit;
    private SortedSet oldestFilesSet;

    public boolean accept(File file)
    {
        if (file.getName().contains(filterNameSnippet))
        {
            filesTotalSize = filesTotalSize + file.length();
            oldestFilesSet.add(file);
            if (oldestFilesSet.size() > limit)
            {
                oldestFilesSet.remove(oldestFilesSet.last());
                return false;
            }
        }
        return false;
    }

    public long getFilesTotalSize()
    {
        return filesTotalSize;
    }

    public SortedSet getOldestFiles()
    {
        return oldestFilesSet;
    }

    public Y(int i, String s)
    {
        limit = i;
        oldestFilesSet = new TreeSet(CloudDriveAssetDiskEvictor.LAST_MODIFIED_TIME_COMPARATOR);
        filesTotalSize = 0L;
        filterNameSnippet = s;
    }
}
