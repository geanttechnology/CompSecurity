// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.container;

import com.xfinity.playerlib.model.editorial.CoverParser;
import com.xfinity.playerlib.model.editorial.EditorialResourceFactory;
import com.xfinity.playerlib.model.editorial.EditorialVideoCoverResource;

// Referenced classes of package com.comcast.cim.container:
//            PlayerContainer

class this._cls0
    implements EditorialResourceFactory
{

    final PlayerContainer this$0;

    public EditorialVideoCoverResource createResource(CoverParser coverparser, String s)
    {
        return new EditorialVideoCoverResource(coverparser.getPrograms(s), coverparser.getCollectionTitle(s));
    }

    public volatile Object createResource(Object obj, String s)
    {
        return createResource((CoverParser)obj, s);
    }

    ialVideoCoverResource()
    {
        this$0 = PlayerContainer.this;
        super();
    }
}
