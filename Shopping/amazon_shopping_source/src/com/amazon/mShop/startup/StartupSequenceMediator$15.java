// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import com.amazon.mShop.util.mediator.Mediator;

// Referenced classes of package com.amazon.mShop.startup:
//            StartupTask, StartupSequenceMediator

class this._cls0 extends StartupTask
{

    final StartupSequenceMediator this$0;

    public void start()
    {
        com.amazon.mShop.util._mth15("StartupSequenceMediator", (new StringBuilder()).append("start ").append(getId()).toString());
        end("taskResultSucceed");
    }

    _cls9(Mediator mediator, String s)
    {
        this$0 = StartupSequenceMediator.this;
        super(mediator, s);
    }
}
