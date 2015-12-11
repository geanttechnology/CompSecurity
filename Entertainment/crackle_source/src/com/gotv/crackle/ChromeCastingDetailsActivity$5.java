// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.widget.SeekBar;

// Referenced classes of package com.gotv.crackle:
//            ChromeCastingDetailsActivity

class this._cls0
    implements android.widget.
{

    int newposition;
    final ChromeCastingDetailsActivity this$0;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (flag)
        {
            newposition = i;
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
        ChromeCastingDetailsActivity.access$1702(ChromeCastingDetailsActivity.this, true);
        ChromeCastingDetailsActivity.access$1800(ChromeCastingDetailsActivity.this);
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        ChromeCastingDetailsActivity.access$1702(ChromeCastingDetailsActivity.this, false);
        seekTo(newposition);
        ChromeCastingDetailsActivity.access$800(ChromeCastingDetailsActivity.this, 15000);
        ChromeCastingDetailsActivity.access$1900(ChromeCastingDetailsActivity.this);
    }

    ()
    {
        this$0 = ChromeCastingDetailsActivity.this;
        super();
    }
}
