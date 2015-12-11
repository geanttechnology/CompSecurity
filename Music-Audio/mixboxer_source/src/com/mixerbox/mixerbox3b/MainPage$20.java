// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.view.View;
import java.util.ArrayList;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls0
    implements android.view.Listener
{

    final MainPage this$0;

    public void onClick(View view)
    {
        if (MainPage.PLAYER_REPEAT == 2 && arrayPlayingSong.size() > 0)
        {
            playingSongIndex = (playingSongIndex + 1) % arrayPlayingSong.size();
        }
        playNextSong();
    }

    ()
    {
        this$0 = MainPage.this;
        super();
    }
}
