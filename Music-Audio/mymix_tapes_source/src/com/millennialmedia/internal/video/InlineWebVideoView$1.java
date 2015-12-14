// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;


// Referenced classes of package com.millennialmedia.internal.video:
//            InlineWebVideoView, MMVideoView

class this._cls0
    implements com.millennialmedia.internal.utils.Listener
{

    private boolean didPause;
    final InlineWebVideoView this$0;

    public void onViewableChanged(boolean flag)
    {
        if (flag)
        {
            if (didPause)
            {
                didPause = false;
                InlineWebVideoView.access$500(InlineWebVideoView.this).start();
            }
        } else
        if (InlineWebVideoView.access$600(InlineWebVideoView.this).isPlaying())
        {
            didPause = true;
            InlineWebVideoView.access$500(InlineWebVideoView.this).pause();
            return;
        }
    }

    lineVideoControls()
    {
        this$0 = InlineWebVideoView.this;
        super();
    }
}
