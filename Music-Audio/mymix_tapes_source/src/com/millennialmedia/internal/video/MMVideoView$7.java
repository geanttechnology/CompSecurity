// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;


// Referenced classes of package com.millennialmedia.internal.video:
//            MMVideoView

class this._cls0
    implements Runnable
{

    final MMVideoView this$0;

    public void run()
    {
        MMVideoView.access$900(MMVideoView.this).onPause();
    }

    diaController()
    {
        this$0 = MMVideoView.this;
        super();
    }
}
