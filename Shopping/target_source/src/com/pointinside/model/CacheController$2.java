// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.model;

import java.io.File;
import java.io.FileFilter;

// Referenced classes of package com.pointinside.model:
//            CacheController

class this._cls0
    implements FileFilter
{

    final CacheController this$0;

    public boolean accept(File file)
    {
        return file.isDirectory();
    }

    ()
    {
        this$0 = CacheController.this;
        super();
    }
}
