// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import com.bumptech.glide.manager.Lifecycle;

// Referenced classes of package com.bumptech.glide:
//            RequestManager

class 
    implements Runnable
{

    final RequestManager this$0;
    final Lifecycle val$lifecycle;

    public void run()
    {
        val$lifecycle.addListener(RequestManager.this);
    }

    ()
    {
        this$0 = final_requestmanager;
        val$lifecycle = Lifecycle.this;
        super();
    }
}
