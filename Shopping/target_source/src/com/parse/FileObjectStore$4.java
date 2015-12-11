// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.File;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            FileObjectStore, ParseFileUtils

class this._cls0
    implements Callable
{

    final FileObjectStore this$0;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        if (FileObjectStore.access$100(FileObjectStore.this).exists() && !ParseFileUtils.deleteQuietly(FileObjectStore.access$100(FileObjectStore.this)))
        {
            throw new RuntimeException("Unable to delete");
        } else
        {
            return null;
        }
    }

    e()
    {
        this$0 = FileObjectStore.this;
        super();
    }
}
