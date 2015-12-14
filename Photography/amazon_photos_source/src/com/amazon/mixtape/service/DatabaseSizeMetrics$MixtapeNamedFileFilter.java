// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package com.amazon.mixtape.service:
//            DatabaseSizeMetrics

private static class <init>
    implements FilenameFilter
{

    public boolean accept(File file, String s)
    {
        return s.contains("mixtape");
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
