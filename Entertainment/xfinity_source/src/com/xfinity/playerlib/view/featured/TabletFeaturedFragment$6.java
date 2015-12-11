// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.view.View;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.xfinity.playerlib.bookmarks.Bookmark;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            TabletFeaturedFragment

class ionListener extends DefaultTaskExecutionListener
{

    final TabletFeaturedFragment this$0;
    final Bookmark val$bookmark;

    public void onError(TaskExecutionException taskexecutionexception)
    {
        TabletFeaturedFragment.access$200().error("Couldn't get title for last watched", taskexecutionexception);
    }

    public void onPostExecute(DibicResource dibicresource)
    {
label0:
        {
            if (val$bookmark instanceof VideoBookmark)
            {
                dibicresource = dibicresource.getProgramByMerlinId(((VideoBookmark)val$bookmark).getParentMerlinIdIfApplicable());
                if (val$bookmark.isFinished())
                {
                    break label0;
                }
                lastWatchedContainer.setContentDescription(getString(com.xfinity.playerlib.ion_last_watched_episode, new Object[] {
                    dibicresource.getTitle(), val$bookmark.getTitle(), Integer.valueOf(val$bookmark.getPercentWatched())
                }));
            }
            return;
        }
        lastWatchedContainer.setContentDescription(getString(com.xfinity.playerlib.ion_last_watched_episode_finished, new Object[] {
            dibicresource.getTitle(), val$bookmark.getTitle()
        }));
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((DibicResource)obj);
    }

    ception()
    {
        this$0 = final_tabletfeaturedfragment;
        val$bookmark = Bookmark.this;
        super();
    }
}
