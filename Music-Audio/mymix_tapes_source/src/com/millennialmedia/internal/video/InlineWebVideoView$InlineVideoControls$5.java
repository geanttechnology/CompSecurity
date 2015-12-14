// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.content.Context;
import android.media.AudioManager;
import android.widget.CompoundButton;

// Referenced classes of package com.millennialmedia.internal.video:
//            InlineWebVideoView, MMVideoView

class val.mmVideoView
    implements android.widget.lineVideoControls._cls5
{

    final tContext this$1;
    final MMVideoView val$mmVideoView;
    final InlineWebVideoView val$this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (val$mmVideoView != null)
        {
            if (flag)
            {
                val$mmVideoView.mute();
            } else
            {
                val$mmVideoView.unmute();
                compoundbutton = (AudioManager)tContext().getSystemService("audio");
                if (compoundbutton.getStreamVolume(3) == 0)
                {
                    compoundbutton.setStreamVolume(3, compoundbutton.getStreamMaxVolume(3) / 3, 0);
                    return;
                }
            }
        }
    }

    Q()
    {
        this$1 = final_q;
        val$this$0 = inlinewebvideoview;
        val$mmVideoView = MMVideoView.this;
        super();
    }
}
