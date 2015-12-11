// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import com.elokence.limuleapi.MinibaseFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            HomeActivity

class this._cls0 extends Thread
{

    final HomeActivity this$0;

    public void run()
    {
        MinibaseFactory.sharedInstance().loadMinibase(true);
    }

    ()
    {
        this$0 = HomeActivity.this;
        super();
    }
}
