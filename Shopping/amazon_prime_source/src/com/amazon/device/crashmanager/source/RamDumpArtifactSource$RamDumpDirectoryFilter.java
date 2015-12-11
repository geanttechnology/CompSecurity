// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.source;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Set;

// Referenced classes of package com.amazon.device.crashmanager.source:
//            RamDumpArtifactSource

private class <init>
    implements FilenameFilter
{

    final RamDumpArtifactSource this$0;

    public boolean accept(File file, String s)
    {
        file = new File(file, s);
        return RamDumpArtifactSource.RAMDUMP_FOLDER_NAMES.contains(s) && file.isDirectory();
    }

    private ()
    {
        this$0 = RamDumpArtifactSource.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
