// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.content.Intent;
import android.os.Bundle;
import com.comcast.cim.android.view.flow.FilterRequestObserver;
import com.xfinity.playerlib.alt.speechrecognizers.MoviesSpeechRecognizer;
import com.xfinity.playerlib.view.flyinmenu.PlayNowFlyinMenuActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            MoviesFilterDialog

public class MoviesActivity extends PlayNowFlyinMenuActivity
    implements FilterRequestObserver
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/browseprograms/MoviesActivity);

    public MoviesActivity()
    {
    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.flyin_movie_browse;
    }

    public int getSearchBackIcon()
    {
        return com.xfinity.playerlib.R.drawable.ico_back_movie;
    }

    protected Class getSpeechRecognizerClass()
    {
        return com/xfinity/playerlib/alt/speechrecognizers/MoviesSpeechRecognizer;
    }

    public void showFilter(Bundle bundle)
    {
        Intent intent = new Intent(this, com/xfinity/playerlib/view/browseprograms/MoviesFilterDialog);
        intent.putExtras(bundle);
        startActivityForResult(intent, 0);
    }

}
