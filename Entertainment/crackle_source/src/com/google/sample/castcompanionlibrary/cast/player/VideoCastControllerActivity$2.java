// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast.player;

import android.widget.SeekBar;
import android.widget.TextView;
import com.google.sample.castcompanionlibrary.cast.VideoCastManager;
import com.google.sample.castcompanionlibrary.utils.LogUtils;
import com.google.sample.castcompanionlibrary.utils.Utils;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast.player:
//            VideoCastControllerActivity

class this._cls0
    implements android.widget.r
{

    final VideoCastControllerActivity this$0;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        VideoCastControllerActivity.access$700(VideoCastControllerActivity.this).setText(Utils.formatMillis(i));
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
        VideoCastControllerActivity.access$600(VideoCastControllerActivity.this);
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        if (VideoCastControllerActivity.access$300(VideoCastControllerActivity.this) != 2) goto _L2; else goto _L1
_L1:
        VideoCastControllerActivity.access$302(VideoCastControllerActivity.this, 4);
        VideoCastControllerActivity.access$400(VideoCastControllerActivity.this, VideoCastControllerActivity.access$300(VideoCastControllerActivity.this));
        VideoCastControllerActivity.access$100(VideoCastControllerActivity.this).play(seekbar.getProgress());
_L4:
        VideoCastControllerActivity.access$500(VideoCastControllerActivity.this);
        return;
_L2:
        if (VideoCastControllerActivity.access$300(VideoCastControllerActivity.this) == 3)
        {
            VideoCastControllerActivity.access$100(VideoCastControllerActivity.this).seek(seekbar.getProgress());
        }
        if (true) goto _L4; else goto _L3
_L3:
        seekbar;
        LogUtils.LOGE(VideoCastControllerActivity.access$000(), "Failed to complete seek", seekbar);
        finish();
        return;
    }

    ()
    {
        this$0 = VideoCastControllerActivity.this;
        super();
    }
}
