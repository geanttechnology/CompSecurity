// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.File;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            FileObjectStore, ParseObject

class this._cls0
    implements Callable
{

    final FileObjectStore this$0;

    public ParseObject call()
        throws Exception
    {
        if (!FileObjectStore.access$100(FileObjectStore.this).exists())
        {
            return null;
        } else
        {
            return FileObjectStore.access$400(FileObjectStore.access$000(FileObjectStore.this), FileObjectStore.access$100(FileObjectStore.this), newBuilder(FileObjectStore.access$300(FileObjectStore.this)));
        }
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    e()
    {
        this$0 = FileObjectStore.this;
        super();
    }
}
