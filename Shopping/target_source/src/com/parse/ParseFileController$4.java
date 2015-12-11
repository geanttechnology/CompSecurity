// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.File;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseFileController

class val.cacheFile
    implements Callable
{

    final ParseFileController this$0;
    final File val$cacheFile;

    public Boolean call()
        throws Exception
    {
        return Boolean.valueOf(val$cacheFile.exists());
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    ()
    {
        this$0 = final_parsefilecontroller;
        val$cacheFile = File.this;
        super();
    }
}
