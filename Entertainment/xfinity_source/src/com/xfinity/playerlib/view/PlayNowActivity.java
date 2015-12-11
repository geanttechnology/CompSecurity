// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view;

import android.os.Bundle;
import com.comcast.cim.android.accessibility.PassiveStateChangeListener;
import com.comcast.cim.android.accessibility.SpeechDelegate;
import com.comcast.cim.android.view.launch.AuthenticatingActivity;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.model.system.PlayerAndroidDevice;
import com.comcast.cim.model.user.UserManager;
import com.ijsbrandslob.appirater.Appirater;
import com.xfinity.playerlib.alt.speechrecognizers.PlayerSpeechRecognizer;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.view.search.SearchActivity;

public abstract class PlayNowActivity extends AuthenticatingActivity
    implements PassiveStateChangeListener
{
    protected class PlayNowActivitySpeechListener extends com.comcast.cim.android.view.common.BaseActivity.ActivitySpeechListener
    {

        final PlayNowActivity this$0;

        public boolean onSpeechResponseSearch(String as[])
        {
            getSpeechDelegate().startSearch(com/xfinity/playerlib/view/search/SearchActivity, as);
            return false;
        }

        protected PlayNowActivitySpeechListener()
        {
            this$0 = PlayNowActivity.this;
            super(PlayNowActivity.this);
        }
    }


    protected PlayerAndroidDevice androidDevice;
    private Appirater appirater;
    protected PlayNowUserManager userManager;

    public PlayNowActivity()
    {
        userManager = PlayerContainer.getInstance().getUserManager();
        androidDevice = PlayerContainer.getInstance().getAndroidDevice();
        appirater = PlayerContainer.getInstance().getAppirater();
    }

    protected void addDefaultActivitySpeechListener()
    {
        addSpeechListener(new PlayNowActivitySpeechListener());
    }

    protected abstract int getLayoutId();

    protected Class getSpeechRecognizerClass()
    {
        return com/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;
    }

    protected UserManager getUserManager()
    {
        return userManager;
    }

    public void onCreate(Bundle bundle)
    {
        setupTalkDelegateForAccessibilityViaLayout();
        super.onCreate(bundle);
        setContentView(getLayoutId());
    }

    protected void onPause()
    {
        super.onPause();
        appirater.dismiss();
    }

    public void onResumeInternal()
    {
        super.onResumeInternal();
        appirater.appEnteredForeground(true, this);
    }
}
