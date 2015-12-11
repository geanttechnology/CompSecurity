// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;


// Referenced classes of package com.amazon.ansel.fetch:
//            AbstractLoaderListener, LoaderGroup, ResourceLoader

private class loader extends AbstractLoaderListener
{

    private final ResourceLoader loader;
    final LoaderGroup this$0;

    public void done()
    {
        loaderDone(loader);
    }

    public (ResourceLoader resourceloader)
    {
        this$0 = LoaderGroup.this;
        super();
        loader = resourceloader;
    }
}
