// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.widget.CompoundButton;

// Referenced classes of package com.millennialmedia.internal.video:
//            InlineWebVideoView, MMVideoView

class val.mmVideoView
    implements android.widget.lineVideoControls._cls3
{

    final val.mmVideoView this$1;
    final MMVideoView val$mmVideoView;
    final InlineWebVideoView val$this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
label0:
        {
            if (val$mmVideoView != null)
            {
                if (!flag)
                {
                    break label0;
                }
                val$mmVideoView.start();
            }
            return;
        }
        val$mmVideoView.pause();
    }

    Q()
    {
        this$1 = final_q;
        val$this$0 = inlinewebvideoview;
        val$mmVideoView = MMVideoView.this;
        super();
    }
}
