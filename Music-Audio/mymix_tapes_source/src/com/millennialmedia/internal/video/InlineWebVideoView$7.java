// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import com.millennialmedia.internal.utils.ViewUtils;

// Referenced classes of package com.millennialmedia.internal.video:
//            InlineWebVideoView

class this._cls0
    implements Runnable
{

    final InlineWebVideoView this$0;

    public void run()
    {
        ViewUtils.removeFromParent(InlineWebVideoView.access$1200(InlineWebVideoView.this));
    }

    ()
    {
        this$0 = InlineWebVideoView.this;
        super();
    }
}
