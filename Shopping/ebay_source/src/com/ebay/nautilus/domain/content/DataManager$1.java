// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;


// Referenced classes of package com.ebay.nautilus.domain.content:
//            DataManager

class this._cls0
    implements Runnable
{

    final DataManager this$0;

    public void run()
    {
        if (observable.isEmpty())
        {
            onLastObserverUnregistered();
        }
    }

    servable()
    {
        this$0 = DataManager.this;
        super();
    }
}
