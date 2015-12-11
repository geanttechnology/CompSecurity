// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.content.res.Resources;
import android.widget.ImageButton;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class val.flag
    implements Runnable
{

    final val.flag this$1;
    final int val$flag;

    public void run()
    {
        shouldPlay = val$flag;
        if (shouldPlay == 1)
        {
            btnPlay.setImageDrawable(getResources().getDrawable(0x7f0200ed));
        } else
        {
            btnPlay.setImageDrawable(getResources().getDrawable(0x7f0200ef));
        }
        sendNotification();
    }

    ()
    {
        this$1 = final_;
        val$flag = I.this;
        super();
    }
}
