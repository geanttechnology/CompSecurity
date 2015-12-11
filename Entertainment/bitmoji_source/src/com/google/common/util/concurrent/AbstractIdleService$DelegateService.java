// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

// Referenced classes of package com.google.common.util.concurrent:
//            AbstractService, AbstractIdleService, MoreExecutors

private final class <init> extends AbstractService
{

    final AbstractIdleService this$0;

    protected final void doStart()
    {
        MoreExecutors.renamingDecorator(executor(), AbstractIdleService.access$200(AbstractIdleService.this)).execute(new Runnable() {

            final AbstractIdleService.DelegateService this$1;

            public void run()
            {
                try
                {
                    startUp();
                    notifyStarted();
                    return;
                }
                catch (Throwable throwable)
                {
                    notifyFailed(throwable);
                }
            }

            
            {
                this$1 = AbstractIdleService.DelegateService.this;
                super();
            }
        });
    }

    protected final void doStop()
    {
        MoreExecutors.renamingDecorator(executor(), AbstractIdleService.access$200(AbstractIdleService.this)).execute(new Runnable() {

            final AbstractIdleService.DelegateService this$1;

            public void run()
            {
                try
                {
                    shutDown();
                    notifyStopped();
                    return;
                }
                catch (Throwable throwable)
                {
                    notifyFailed(throwable);
                }
            }

            
            {
                this$1 = AbstractIdleService.DelegateService.this;
                super();
            }
        });
    }

    public String toString()
    {
        return AbstractIdleService.this.toString();
    }

    private _cls2.this._cls1()
    {
        this$0 = AbstractIdleService.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
