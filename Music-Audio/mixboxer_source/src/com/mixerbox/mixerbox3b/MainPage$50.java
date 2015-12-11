// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import com.flurry.android.FlurryAgent;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls0
    implements Runnable
{

    final MainPage this$0;

    public void run()
    {
        FlurryAgent.logEvent("action:mb3_first_launch");
        int i = MixerBoxSharedPreferences.getUserType(MainPage.this);
        if (i == 1)
        {
            FlurryAgent.logEvent("status:v307_push_local");
            MixerBoxClient.get("http://bit.ly/androidv307_launch_local", null, new AsyncHttpResponseHandler());
        } else
        {
            if (i == 2)
            {
                FlurryAgent.logEvent("status:v307_push_server");
                MixerBoxClient.get("http://bit.ly/androidv307_launch_server", null, new AsyncHttpResponseHandler());
                return;
            }
            if (i == 3)
            {
                FlurryAgent.logEvent("status:v307_push_local_and_server");
                MixerBoxClient.get("http://bit.ly/androidv307_launch_local_and_server", null, new AsyncHttpResponseHandler());
                return;
            }
            if (i == 4)
            {
                FlurryAgent.logEvent("status:v307_push_neither");
                MixerBoxClient.get("http://bit.ly/androidv307_launch_neither", null, new AsyncHttpResponseHandler());
                return;
            }
        }
    }

    oxClient()
    {
        this$0 = MainPage.this;
        super();
    }
}
