// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            InlineAd

class val.isClosed
    implements Runnable
{

    final InlineAd this$0;
    final int val$height;
    final boolean val$isClosed;
    final lineListener val$localInlineListener;
    final int val$width;

    public void run()
    {
        val$localInlineListener.onResized(InlineAd.this, val$width, val$height, val$isClosed);
    }

    lineListener()
    {
        this$0 = final_inlinead;
        val$localInlineListener = linelistener;
        val$width = i;
        val$height = j;
        val$isClosed = Z.this;
        super();
    }
}
