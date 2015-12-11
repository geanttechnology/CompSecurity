// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageButton;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class val.btnRepeat
    implements android.view.Listener
{

    final MainPage this$0;
    final ImageButton val$btnRepeat;

    public void onClick(View view)
    {
        MixerBoxUtils.logMsg((new StringBuilder()).append("CHANGE REPEAT MODE: ").append(MainPage.PLAYER_REPEAT).toString());
        MainPage.access$200(MainPage.this).removeMessages(1);
        MainPage.access$200(MainPage.this).sendEmptyMessageDelayed(1, 4000L);
        if (MainPage.PLAYER_REPEAT == 1)
        {
            MainPage.PLAYER_REPEAT = 2;
            val$btnRepeat.setImageDrawable(getResources().getDrawable(0x7f0200fe));
            MixerBoxUtils.toastMsg(MainPage.this, getResources().getString(0x7f08008b), 0);
            return;
        } else
        {
            MainPage.PLAYER_REPEAT = 1;
            val$btnRepeat.setImageDrawable(getResources().getDrawable(0x7f0200fd));
            MixerBoxUtils.toastMsg(MainPage.this, getResources().getString(0x7f08008a), 0);
            return;
        }
    }

    andler()
    {
        this$0 = final_mainpage;
        val$btnRepeat = ImageButton.this;
        super();
    }
}
