// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.cachelib;

import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package com.comcast.cim.cmasl.cachelib:
//            NamespacedFileCache

class this._cls0
    implements FilenameFilter
{

    final NamespacedFileCache this$0;

    public boolean accept(File file, String s)
    {
        return s.startsWith(NamespacedFileCache.access$100(NamespacedFileCache.this));
    }

    ()
    {
        this$0 = NamespacedFileCache.this;
        super();
    }
}
