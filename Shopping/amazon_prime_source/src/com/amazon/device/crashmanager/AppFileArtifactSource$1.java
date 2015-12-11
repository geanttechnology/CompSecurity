// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import java.io.File;
import java.io.FileFilter;

// Referenced classes of package com.amazon.device.crashmanager:
//            AppFileArtifactSource

class this._cls0
    implements FileFilter
{

    final AppFileArtifactSource this$0;

    public boolean accept(File file)
    {
        return file.getName().startsWith("crashlog.v2.amzcl");
    }

    ()
    {
        this$0 = AppFileArtifactSource.this;
        super();
    }
}
