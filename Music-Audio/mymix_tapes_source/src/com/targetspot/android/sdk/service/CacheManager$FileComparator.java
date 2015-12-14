// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import java.io.File;
import java.util.Comparator;

// Referenced classes of package com.targetspot.android.sdk.service:
//            CacheManager

class this._cls0
    implements Comparator
{

    final CacheManager this$0;

    public int compare(File file, File file1)
    {
        long l = file.lastModified();
        long l1 = file1.lastModified();
        if (l < l1)
        {
            return -1;
        }
        return l <= l1 ? 0 : 1;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((File)obj, (File)obj1);
    }

    ()
    {
        this$0 = CacheManager.this;
        super();
    }
}
