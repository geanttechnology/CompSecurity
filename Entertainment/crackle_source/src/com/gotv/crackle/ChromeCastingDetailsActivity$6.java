// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.widget.SeekBar;
import com.gotv.crackle.helpers.ChromeCastHelper;

// Referenced classes of package com.gotv.crackle:
//            ChromeCastingDetailsActivity

class this._cls0
    implements android.widget.
{

    final ChromeCastingDetailsActivity this$0;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        double d = (float)seekbar.getProgress() / 100F;
        ChromeCastingDetailsActivity.access$2000(ChromeCastingDetailsActivity.this).setVolume(d);
    }

    ()
    {
        this$0 = ChromeCastingDetailsActivity.this;
        super();
    }
}
