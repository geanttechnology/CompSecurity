// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import org.roboguice.shaded.goole.common.cache.CacheLoader;

// Referenced classes of package com.google.inject.internal:
//            ProvisionListenerCallbackStore, ProvisionListenerStackCallback

class this._cls0 extends CacheLoader
{

    final ProvisionListenerCallbackStore this$0;

    public ProvisionListenerStackCallback load(yBinding ybinding)
    {
        return ProvisionListenerCallbackStore.access$000(ProvisionListenerCallbackStore.this, ybinding.binding);
    }

    public volatile Object load(Object obj)
        throws Exception
    {
        return load((yBinding)obj);
    }

    yBinding()
    {
        this$0 = ProvisionListenerCallbackStore.this;
        super();
    }
}
