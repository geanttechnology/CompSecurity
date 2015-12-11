// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.internal;

import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package com.groupon.tracking.mobile.internal:
//            LogClient, LogFileSpec

class getExtension
    implements FilenameFilter
{

    final LogClient this$0;
    final LogFileSpec tmpFileSpec;

    public boolean accept(File file, String s)
    {
        return tmpFileSpec.matchesSpec(s);
    }

    ()
    {
        this$0 = LogClient.this;
        super();
        tmpFileSpec = new LogFileSpec(LogClient.access$000(LogClient.this).getPrefix(), (new StringBuilder()).append(LogClient.access$000(LogClient.this).getExtension()).append(".").append("tmp").toString());
    }
}
