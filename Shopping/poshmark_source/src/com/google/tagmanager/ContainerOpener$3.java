// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.TimerTask;

// Referenced classes of package com.google.tagmanager:
//            ContainerOpener, Log

class this._cls0 extends TimerTask
{

    final ContainerOpener this$0;

    public void run()
    {
        Log.i("Timer expired.");
        ContainerOpener.access$000(ContainerOpener.this, ContainerOpener.access$100(ContainerOpener.this));
    }

    ()
    {
        this$0 = ContainerOpener.this;
        super();
    }
}
