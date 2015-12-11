// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.tags.cache;

import com.comcast.cim.cmasl.utils.provider.Provider;
import com.xfinity.playerlib.model.tags.http.TagsResponseHandler;

// Referenced classes of package com.xfinity.playerlib.model.tags.cache:
//            TagsRootCache

class this._cls0
    implements Provider
{

    final TagsRootCache this$0;

    public TagsResponseHandler get()
    {
        return new TagsResponseHandler(TagsRootCache.access$000(TagsRootCache.this));
    }

    public volatile Object get()
    {
        return get();
    }

    er()
    {
        this$0 = TagsRootCache.this;
        super();
    }
}
