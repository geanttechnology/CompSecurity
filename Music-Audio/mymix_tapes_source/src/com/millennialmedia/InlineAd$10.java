// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            InlineAd

class ineListener
    implements Runnable
{

    final InlineAd this$0;
    final ineListener val$localInlineListener;

    public void run()
    {
        val$localInlineListener.onExpanded(InlineAd.this);
    }

    ineListener()
    {
        this$0 = final_inlinead;
        val$localInlineListener = ineListener.this;
        super();
    }
}
