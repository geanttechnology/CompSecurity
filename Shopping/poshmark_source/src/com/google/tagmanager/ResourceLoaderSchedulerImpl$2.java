// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            ResourceLoaderSchedulerImpl, ResourceLoader, CtfeHost

class this._cls0
    implements sourceLoaderFactory
{

    final ResourceLoaderSchedulerImpl this$0;

    public ResourceLoader createResourceLoader(CtfeHost ctfehost)
    {
        return new ResourceLoader(ResourceLoaderSchedulerImpl.access$000(ResourceLoaderSchedulerImpl.this), ResourceLoaderSchedulerImpl.access$100(ResourceLoaderSchedulerImpl.this), ctfehost);
    }

    sourceLoaderFactory()
    {
        this$0 = ResourceLoaderSchedulerImpl.this;
        super();
    }
}
