// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.view.View;
import android.widget.ToggleButton;
import com.millennialmedia.internal.MMWebView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.internal.video:
//            InlineWebVideoView

class val.showExpandControls
    implements android.view..InlineWebVideoView._cls2
{

    final InlineWebVideoView this$0;
    final boolean val$showExpandControls;
    final boolean val$showMediaControls;

    public void onClick(View view)
    {
        InlineWebVideoView.access$000(InlineWebVideoView.this);
        view = (MMWebView)InlineWebVideoView.access$700(InlineWebVideoView.this).get();
        if (view != null)
        {
            view.invokeCallback(InlineWebVideoView.access$800(InlineWebVideoView.this), new Object[] {
                getTag(), "click"
            });
        }
        if (val$showMediaControls)
        {
            InlineWebVideoView.access$500(InlineWebVideoView.this).setAlpha(1.0F);
            InlineWebVideoView.access$500(InlineWebVideoView.this).setVisibility(0);
        }
        if (val$showExpandControls)
        {
            InlineWebVideoView.access$900(InlineWebVideoView.this).setAlpha(1.0F);
            InlineWebVideoView.access$900(InlineWebVideoView.this).setVisibility(0);
        }
        if (val$showMediaControls || val$showExpandControls)
        {
            InlineWebVideoView.access$1000(InlineWebVideoView.this);
        }
    }

    lineVideoControls()
    {
        this$0 = final_inlinewebvideoview;
        val$showMediaControls = flag;
        val$showExpandControls = Z.this;
        super();
    }
}
