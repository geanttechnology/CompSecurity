// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.view.MenuItem;
import android.widget.Toast;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class this._cls0
    implements Runnable
{

    final VideoPlayerActivity this$0;

    public void run()
    {
        VideoPlayerActivity.access$3600(VideoPlayerActivity.this).setVisible(true);
        Toast.makeText(VideoPlayerActivity.this, getString(0x7f0b013b), 1).show();
    }

    ()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
