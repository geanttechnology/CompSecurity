// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            ContainerOpener, Container

static final class val.future
    implements tifier
{

    final ntainerFutureImpl val$future;

    public void containerAvailable(Container container)
    {
        val$future.setContainer(container);
    }

    ntainerFutureImpl(ntainerFutureImpl ntainerfutureimpl)
    {
        val$future = ntainerfutureimpl;
        super();
    }
}
