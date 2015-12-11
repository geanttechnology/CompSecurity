// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.sdk.availability:
//            FileStore

static class timeStamp
    implements FilenameFilter
{

    private final long timeStamp;

    public boolean accept(File file, String s)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (s != null)
        {
            flag = flag1;
            if (FileStore.access$000().matcher(s).matches())
            {
                flag = flag1;
                if ((new File(file, s)).lastModified() >= timeStamp)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public (long l)
    {
        timeStamp = l;
    }
}
