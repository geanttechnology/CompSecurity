// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.content.Intent;
import android.os.Bundle;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.utils.MixerBoxConstants;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

public class LoginBridge extends SherlockActivity
{

    public LoginBridge()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030041);
        getSupportActionBar().hide();
        Object obj = getIntent().getExtras();
        bundle = ((Bundle) (obj));
        if (obj == null)
        {
            bundle = new Bundle();
        }
        if (bundle.containsKey("isLogIn") && bundle.getBoolean("isLogIn"))
        {
            bundle.putBoolean("isLogIn", true);
        } else
        {
            bundle.putBoolean("isLogIn", false);
        }
        MixerBoxConstants.shouldOnCreate = true;
        obj = new Intent();
        ((Intent) (obj)).putExtras(bundle);
        ((Intent) (obj)).setClass(this, com/mixerbox/mixerbox3b/MainPage);
        startActivity(((Intent) (obj)));
        finish();
    }

    protected void onStart()
    {
        super.onStart();
        FlurryAgent.onStartSession(this, "Z8QPYZT3PBG8R6ZNSDXQ");
    }

    protected void onStop()
    {
        FlurryAgent.onEndSession(this);
        super.onStop();
    }
}
