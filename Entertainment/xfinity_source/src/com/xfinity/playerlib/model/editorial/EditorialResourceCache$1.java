// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.editorial;

import com.comcast.cim.cmasl.utils.provider.Provider;

// Referenced classes of package com.xfinity.playerlib.model.editorial:
//            EditorialResourceCache, EditorialResponseHandler

class this._cls0
    implements Provider
{

    final EditorialResourceCache this$0;

    public EditorialResponseHandler get()
    {
        return new EditorialResponseHandler(EditorialResourceCache.access$000(EditorialResourceCache.this), EditorialResourceCache.access$100(EditorialResourceCache.this));
    }

    public volatile Object get()
    {
        return get();
    }

    ()
    {
        this$0 = EditorialResourceCache.this;
        super();
    }
}
