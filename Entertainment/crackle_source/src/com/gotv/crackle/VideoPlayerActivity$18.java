// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.Dialog;
import android.content.DialogInterface;
import com.gotv.crackle.views.MediaControllerView;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class this._cls0
    implements android.content.Listener
{

    final VideoPlayerActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            VideoPlayerActivity.access$600(VideoPlayerActivity.this).pausePlayback(false);
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface) { }
        mLowBandwidthDialog.dismiss();
        finish();
    }

    ew()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
