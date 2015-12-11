// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package com.parse:
//            ParseKeyValueCache

static final class val.suffix
    implements FilenameFilter
{

    final String val$suffix;

    public boolean accept(File file, String s)
    {
        return s.endsWith(val$suffix);
    }

    (String s)
    {
        val$suffix = s;
        super();
    }
}
