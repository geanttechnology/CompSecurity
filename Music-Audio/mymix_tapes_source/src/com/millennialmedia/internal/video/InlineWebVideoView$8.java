// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.widget.FrameLayout;
import android.widget.ImageView;

// Referenced classes of package com.millennialmedia.internal.video:
//            InlineWebVideoView

class this._cls0
    implements Runnable
{

    final InlineWebVideoView this$0;

    public void run()
    {
        if (InlineWebVideoView.access$1200(InlineWebVideoView.this).getParent() == null)
        {
            InlineWebVideoView.access$2100(InlineWebVideoView.this).addView(InlineWebVideoView.access$1200(InlineWebVideoView.this));
        }
    }

    ()
    {
        this$0 = InlineWebVideoView.this;
        super();
    }
}
