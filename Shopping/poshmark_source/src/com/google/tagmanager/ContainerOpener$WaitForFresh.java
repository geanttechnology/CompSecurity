// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            ContainerOpener, Container

private class mOldestTimeToBeFresh
    implements mOldestTimeToBeFresh
{

    private final long mOldestTimeToBeFresh;
    final ContainerOpener this$0;

    private boolean isFresh()
    {
        return mOldestTimeToBeFresh < ContainerOpener.access$100(ContainerOpener.this).getLastRefreshTime();
    }

    public void containerRefreshBegin(Container container, this._cls0 _pcls0)
    {
    }

    public void containerRefreshFailure(Container container, this._cls0 _pcls0, this._cls0 _pcls0_1)
    {
        if (_pcls0 == )
        {
            ContainerOpener.access$000(ContainerOpener.this, container);
        }
    }

    public void containerRefreshSuccess(Container container, this._cls0 _pcls0)
    {
        if (_pcls0 ==  || isFresh())
        {
            ContainerOpener.access$000(ContainerOpener.this, container);
        }
    }

    public (long l)
    {
        this$0 = ContainerOpener.this;
        super();
        mOldestTimeToBeFresh = l;
    }
}
