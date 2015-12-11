// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.content.res.Resources;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.ArrayList;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        MainPage mainpage = _fld0;
        mainpage.errorCount = mainpage.errorCount + 1;
        MixerBoxUtils.logMsg((new StringBuilder()).append("errorCount = ").append(errorCount).toString());
        FlurryAgent.logEvent("status:youtube_player_error");
        if (arrayPlayingSong == null || errorCount > arrayPlayingSong.size() + 2)
        {
            closePlayer();
            MixerBoxUtils.toastMsg(_fld0, getResources().getString(0x7f08005a), 1);
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
