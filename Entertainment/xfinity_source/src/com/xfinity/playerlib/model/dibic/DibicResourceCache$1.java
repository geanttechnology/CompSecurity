// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.dibic;

import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;

// Referenced classes of package com.xfinity.playerlib.model.dibic:
//            DibicResourceCache, DibicResponseHandler

class this._cls0
    implements Provider
{

    final DibicResourceCache this$0;

    public DibicResponseHandler get()
    {
        return new DibicResponseHandler(DibicResourceCache.access$000(DibicResourceCache.this), DibicResourceCache.access$100(DibicResourceCache.this), (TagsRoot)DibicResourceCache.access$200(DibicResourceCache.this).execute(), DibicResourceCache.access$300(DibicResourceCache.this));
    }

    public volatile Object get()
    {
        return get();
    }

    ()
    {
        this$0 = DibicResourceCache.this;
        super();
    }
}
