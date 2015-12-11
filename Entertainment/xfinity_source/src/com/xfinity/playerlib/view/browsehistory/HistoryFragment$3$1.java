// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsehistory;

import android.app.Activity;
import android.view.View;
import com.comcast.cim.utils.UIUtil;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.xfinity.playerlib.view.browsehistory:
//            HistoryFragment

class val.view
    implements Runnable
{

    final val.view this$1;
    final Activity val$activity;
    final View val$view;

    public void run()
    {
        ((oPlayOrResumePressedListener)val$activity).onVideoPlayOrResumePressed((VideoBookmark)val$view.getTag());
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$activity = activity1;
        val$view = View.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/browsehistory/HistoryFragment$3

/* anonymous class */
    class HistoryFragment._cls3
        implements android.view.View.OnClickListener
    {

        final HistoryFragment this$0;

        public void onClick(View view1)
        {
            Object obj = (VideoBookmark)view1.getTag();
            final Object activity;
            if (((VideoBookmark) (obj)).isMovie())
            {
                activity = HistoryFragment.access$500(HistoryFragment.this).getProgramByMerlinId(((VideoBookmark) (obj)).getMerlinId());
            } else
            {
                activity = HistoryFragment.access$500(HistoryFragment.this).getProgramByMerlinId(((VideoBookmark) (obj)).getParentMerlinIdIfApplicable());
            }
            if (videoEntitlement.isEntitled(((com.xfinity.playerlib.model.dibic.DibicProgram) (activity))))
            {
                activity = getActivity();
                obj = downloadsManager.findFileWithVideoId(((VideoBookmark) (obj)).getVideoId());
                if (obj != null)
                {
                    view1 = ((PlayerDownloadFile) (obj)).getWatchable();
                    Iterator iterator = view1.getVideos().iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        VideoFacade videofacade = (VideoFacade)iterator.next();
                        if (videofacade.getVideoId() != ((PlayerDownloadFile) (obj)).getVideoId())
                        {
                            continue;
                        }
                        ((com.xfinity.playerlib.view.programdetails.DetailFragment.PlayPressedListener)activity).onPlayOrResumePressed(videofacade, view1);
                        break;
                    } while (true);
                    return;
                } else
                {
                    uiUtil.ensureConnectivityBeforeExecuting(view1.getContext(), view1. new HistoryFragment._cls3._cls1());
                    return;
                }
            } else
            {
                HistoryFragment.access$600(HistoryFragment.this, ((com.xfinity.playerlib.model.dibic.DibicProgram) (activity)));
                return;
            }
        }

            
            {
                this$0 = HistoryFragment.this;
                super();
            }
    }

}
