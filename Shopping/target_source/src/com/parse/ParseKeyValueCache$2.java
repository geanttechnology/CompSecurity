// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.File;
import java.util.Comparator;

// Referenced classes of package com.parse:
//            ParseKeyValueCache

static final class 
    implements Comparator
{

    public int compare(File file, File file1)
    {
        int i = Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file1.lastModified()));
        if (i != 0)
        {
            return i;
        } else
        {
            return file.getName().compareTo(file1.getName());
        }
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((File)obj, (File)obj1);
    }

    ()
    {
    }
}
