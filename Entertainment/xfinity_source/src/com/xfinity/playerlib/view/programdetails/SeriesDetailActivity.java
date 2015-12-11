// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.view.videoplay.VideoPlayerActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            DetailActivity

public class SeriesDetailActivity extends DetailActivity
    implements DetailFragment.PlayPressedListener
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/programdetails/SeriesDetailActivity);

    public SeriesDetailActivity()
    {
    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.flyin_series_detail;
    }

    public void onPlayOrResumePressed(VideoFacade videofacade, Watchable watchable)
    {
        videofacade = VideoPlayerActivity.createIntentForPlayer(videofacade, watchable);
        videofacade.setFlags(0x4000000);
        startActivity(videofacade);
    }

    public void onResumeInternal()
    {
        super.onResumeInternal();
        LOG.debug("onResumeInternal");
        (new AsyncTask() {

            final SeriesDetailActivity this$0;

            protected transient Boolean doInBackground(Void avoid[])
            {
                return Boolean.valueOf(((PlayerUserSettings)getUserSettings.getUserSettings()).getHasSeenMenuOptions());
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected void onPostExecute(Boolean boolean1)
            {
                if (!boolean1.booleanValue())
                {
                    (new Handler(getMainLooper())).postDelayed(new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            openOptionsMenu();
                            ((PlayerUserSettings)
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$1 = _cls1.this;
                super();
            }
                    }, 200L);
                }
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Boolean)obj);
            }

            
            {
                this$0 = SeriesDetailActivity.this;
                super();
            }
        }).execute(new Void[0]);
    }




}
