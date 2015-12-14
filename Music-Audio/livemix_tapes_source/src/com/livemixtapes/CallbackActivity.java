// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package com.livemixtapes:
//            NowPlayingActivity

public class CallbackActivity extends Activity
{

    public CallbackActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        int i = getIntent().getIntExtra("which", 1);
        if (i == 1)
        {
            NowPlayingActivity.pause();
        } else
        if (i == 2)
        {
            NowPlayingActivity.nextTrack();
        } else
        {
            NowPlayingActivity.previousTrack();
        }
        finish();
    }
}
