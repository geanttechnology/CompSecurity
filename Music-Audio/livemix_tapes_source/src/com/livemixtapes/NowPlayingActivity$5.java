// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.View;
import com.livemixtapes.ui.FadeImageButton;
import java.util.ArrayList;
import java.util.Collections;

// Referenced classes of package com.livemixtapes:
//            NowPlayingActivity

class this._cls0
    implements android.view.y._cls5
{

    final NowPlayingActivity this$0;

    public void onClick(View view)
    {
        boolean flag;
        if (NowPlayingActivity.shuffleStatus)
        {
            NowPlayingActivity.tracksList = new ArrayList(NowPlayingActivity.savedTracksList);
            NowPlayingActivity.shuffle.setImageResource(0x7f0200dd);
        } else
        {
            Collections.shuffle(NowPlayingActivity.tracksList);
            NowPlayingActivity.shuffle.setImageResource(0x7f0200dc);
        }
        if (NowPlayingActivity.shuffleStatus)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        NowPlayingActivity.shuffleStatus = flag;
    }

    ()
    {
        this$0 = NowPlayingActivity.this;
        super();
    }
}
