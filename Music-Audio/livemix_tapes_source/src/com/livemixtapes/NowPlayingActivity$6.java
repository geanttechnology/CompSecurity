// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.View;
import com.livemixtapes.ui.FadeImageButton;

// Referenced classes of package com.livemixtapes:
//            NowPlayingActivity

class this._cls0
    implements android.view.y._cls6
{

    final NowPlayingActivity this$0;

    public void onClick(View view)
    {
        boolean flag;
        if (NowPlayingActivity.repeatStatus)
        {
            NowPlayingActivity.repeat.setImageResource(0x7f0200cf);
        } else
        {
            NowPlayingActivity.repeat.setImageResource(0x7f0200ce);
        }
        if (NowPlayingActivity.repeatStatus)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        NowPlayingActivity.repeatStatus = flag;
    }

    ()
    {
        this$0 = NowPlayingActivity.this;
        super();
    }
}
