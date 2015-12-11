// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import com.xfinity.playerlib.alt.speechrecognizers.FeaturedSpeechRecognizer;
import com.xfinity.playerlib.view.flyinmenu.PlayNowFlyinMenuActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FeaturedActivity extends PlayNowFlyinMenuActivity
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/featured/FeaturedActivity);

    public FeaturedActivity()
    {
    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.flyin_featured;
    }

    public int getSearchBackIcon()
    {
        return com.xfinity.playerlib.R.drawable.ico_back_featured;
    }

    protected Class getSpeechRecognizerClass()
    {
        return com/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;
    }

    public void onResumeInternal()
    {
        super.onResumeInternal();
        checkTalkBackModeOnResume();
    }

}
