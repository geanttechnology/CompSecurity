// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.view.View;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls0
    implements android.view.Listener
{

    final MainPage this$0;

    public void onClick(View view)
    {
        shouldSendNoti = false;
        if (SCREEN_STATE == 2)
        {
            setUnFullScreen(false);
        }
        closePlayer();
    }

    ()
    {
        this$0 = MainPage.this;
        super();
    }
}
