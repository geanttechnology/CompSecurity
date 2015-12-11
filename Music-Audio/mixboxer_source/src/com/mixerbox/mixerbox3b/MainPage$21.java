// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.view.View;
import android.webkit.WebView;
import java.util.ArrayList;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls0
    implements android.view.Listener
{

    final MainPage this$0;

    public void onClick(View view)
    {
        if (currentTime >= 5)
        {
            wv.loadUrl("javascript:seekTo(0)");
            return;
        }
        if (MainPage.PLAYER_REPEAT == 2 && arrayPlayingSong.size() > 0)
        {
            view = MainPage.this;
            view.playingSongIndex = ((MainPage) (view)).playingSongIndex - 1;
            if (playingSongIndex == -1)
            {
                playingSongIndex = arrayPlayingSong.size() - 1;
            }
        }
        playPreviousSong();
    }

    ()
    {
        this$0 = MainPage.this;
        super();
    }
}
