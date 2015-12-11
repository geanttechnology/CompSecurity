// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.Presentation;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import com.gotv.crackle.views.MediaControllerView;
import tv.freewheel.ad.interfaces.IAdContext;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity, Application

private final class this._cls0 extends Presentation
{

    final VideoPlayerActivity this$0;

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        int i;
        if (Application.isFanhattan())
        {
            i = 0x7f03007c;
        } else
        {
            i = 0x7f03007b;
        }
        setContentView(i);
        VideoPlayerActivity.access$8802(VideoPlayerActivity.this, true);
        findViewById(0x7f0a019f).setVisibility(8);
        if (VideoPlayerActivity.access$3400(VideoPlayerActivity.this) != null)
        {
            VideoPlayerActivity.access$3400(VideoPlayerActivity.this).setVisibility(8);
        }
        VideoPlayerActivity.access$8900(VideoPlayerActivity.this).setVisibility(0);
        VideoPlayerActivity.access$9000(VideoPlayerActivity.this);
        VideoPlayerActivity.access$3402(VideoPlayerActivity.this, findViewById(0x7f0a019e));
        VideoPlayerActivity.access$700(VideoPlayerActivity.this).registerVideoDisplayBase(VideoPlayerActivity.access$9100(VideoPlayerActivity.this));
        VideoPlayerActivity.access$600(VideoPlayerActivity.this).init(VideoPlayerActivity.access$500(VideoPlayerActivity.this), VideoPlayerActivity.access$9200(VideoPlayerActivity.this));
        VideoPlayerActivity.access$200(VideoPlayerActivity.this);
    }

    public (Context context, Display display)
    {
        this$0 = VideoPlayerActivity.this;
        super(context, display);
    }
}
