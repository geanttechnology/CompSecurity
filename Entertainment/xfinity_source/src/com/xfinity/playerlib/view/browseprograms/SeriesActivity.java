// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.content.Intent;
import android.os.Bundle;
import com.comcast.cim.android.view.flow.FilterRequestObserver;
import com.xfinity.playerlib.alt.speechrecognizers.TvSeriesSpeechRecognizer;
import com.xfinity.playerlib.view.flyinmenu.PlayNowFlyinMenuActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            SeriesFilterDialog

public class SeriesActivity extends PlayNowFlyinMenuActivity
    implements FilterRequestObserver
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/browseprograms/SeriesActivity);

    public SeriesActivity()
    {
    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.flyin_tv_browse;
    }

    public int getSearchBackIcon()
    {
        return com.xfinity.playerlib.R.drawable.ico_back_tv;
    }

    protected Class getSpeechRecognizerClass()
    {
        return com/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer;
    }

    public void showFilter(Bundle bundle)
    {
        Intent intent = new Intent(this, com/xfinity/playerlib/view/browseprograms/SeriesFilterDialog);
        intent.putExtras(bundle);
        startActivityForResult(intent, 0);
    }

}
