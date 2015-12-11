// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.utils.container.Tuple3;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.xfinity.playerlib.image.ProgramDetailArtImageLoader;
import com.xfinity.playerlib.model.consumable.MovieFacade;
import com.xfinity.playerlib.model.consumable.hal.HalMovieConsumable;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.util.Map;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            MovieDetailFragment, EpisodeBookmarkCache

class stener extends DefaultTaskExecutionListener
{

    final is._cls0 this$1;
    final DibicProgram val$dibicMovie;
    final VideoEntitlement val$entitlement;

    public void onError(TaskExecutionException taskexecutionexception)
    {
        onLoadingFailed();
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((Map)obj);
    }

    public void onPostExecute(Map map)
    {
        presentConsumableMovie(map, val$entitlement, val$dibicMovie);
        onLoadingFinished();
        MovieDetailFragment.access$300(_fld0).setVisibility(0);
    }

    stener()
    {
        this$1 = final_stener;
        val$entitlement = videoentitlement;
        val$dibicMovie = DibicProgram.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/programdetails/MovieDetailFragment$2

/* anonymous class */
    class MovieDetailFragment._cls2 extends DefaultTaskExecutionListener
    {

        final MovieDetailFragment this$0;

        public void onError(TaskExecutionException taskexecutionexception)
        {
            onLoadingFailed();
        }

        public void onPostExecute(Tuple3 tuple3)
        {
            MovieDetailFragment.access$200(MovieDetailFragment.this).setVisibility(8);
            final VideoEntitlement entitlement = (VideoEntitlement)tuple3.e1;
            HalMovieConsumable halmovieconsumable = (HalMovieConsumable)tuple3.e2;
            dibicResource = (DibicResource)tuple3.e3;
            if (instanceState.showPanelFittedLayout)
            {
                int i = getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.detail_art_land_2x_width);
                int j = getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.detail_art_land_2x_height);
                programDetailArtImageLoader.loadDetailProgramArt(halmovieconsumable.getMerlinEntityId(), MovieDetailFragment.access$300(MovieDetailFragment.this), i, j);
            } else
            {
                programDetailArtImageLoader.loadDetailProgramArt(halmovieconsumable.getMerlinEntityId(), MovieDetailFragment.access$300(MovieDetailFragment.this));
            }
            tuple3 = dibicResource.getProgramByMerlinId(halmovieconsumable.getMerlinEntityId());
            if (tuple3 != null)
            {
                try
                {
                    MovieDetailFragment.access$402(MovieDetailFragment.this, new MovieFacade(halmovieconsumable));
                    MovieDetailFragment.access$502(MovieDetailFragment.this, MovieDetailFragment.access$600(MovieDetailFragment.this).create(new EpisodeBookmarkCache(bookmarkDAO, MovieDetailFragment.access$400(MovieDetailFragment.this))));
                    MovieDetailFragment.access$702(MovieDetailFragment.this, MovieDetailFragment.access$500(MovieDetailFragment.this).execute(tuple3. new MovieDetailFragment._cls2._cls1()));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Tuple3 tuple3)
                {
                    showFailureState(tuple3);
                }
                break MISSING_BLOCK_LABEL_259;
            }
            showFailureState(null);
            return;
            MovieDetailFragment.access$800(MovieDetailFragment.this).error("Caught exception while trying to build MovieFacade", tuple3);
            return;
        }

        public volatile void onPostExecute(Object obj)
        {
            onPostExecute((Tuple3)obj);
        }

        public void onPreAsynchronousExecute()
        {
            MovieDetailFragment.access$100(MovieDetailFragment.this).getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.string.loading);
        }

            
            {
                this$0 = MovieDetailFragment.this;
                super();
            }
    }

}
