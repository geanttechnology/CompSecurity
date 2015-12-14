// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.widget.TextView;

// Referenced classes of package com.millennialmedia.internal.video:
//            VASTVideoView

class val.timeLeftToSkip
    implements Runnable
{

    final VASTVideoView this$0;
    final int val$timeLeftToSkip;

    public void run()
    {
        VASTVideoView.access$2500(VASTVideoView.this).setVisibility(0);
        VASTVideoView.access$2500(VASTVideoView.this).setText((new StringBuilder()).append("").append(val$timeLeftToSkip).toString());
    }

    _cls9()
    {
        this$0 = final_vastvideoview;
        val$timeLeftToSkip = I.this;
        super();
    }
}
