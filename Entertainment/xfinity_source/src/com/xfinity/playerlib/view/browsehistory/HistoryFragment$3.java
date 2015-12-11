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

class this._cls0
    implements android.view.er
{

    final HistoryFragment this$0;

    public void onClick(final View view)
    {
        Object obj = (VideoBookmark)view.getTag();
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
                view = ((PlayerDownloadFile) (obj)).getWatchable();
                Iterator iterator = view.getVideos().iterator();
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
                    ((com.xfinity.playerlib.view.programdetails.yPressedListener)activity).onPlayOrResumePressed(videofacade, view);
                    break;
                } while (true);
                return;
            } else
            {
                uiUtil.ensureConnectivityBeforeExecuting(view.getContext(), new Runnable() {

                    final HistoryFragment._cls3 this$1;
                    final Activity val$activity;
                    final View val$view;

                    public void run()
                    {
                        ((HistoryFragment.VideoPlayOrResumePressedListener)activity).onVideoPlayOrResumePressed((VideoBookmark)view.getTag());
                    }

            
            {
                this$1 = HistoryFragment._cls3.this;
                activity = activity1;
                view = view1;
                super();
            }
                });
                return;
            }
        } else
        {
            HistoryFragment.access$600(HistoryFragment.this, ((com.xfinity.playerlib.model.dibic.DibicProgram) (activity)));
            return;
        }
    }

    _cls1.val.view()
    {
        this$0 = HistoryFragment.this;
        super();
    }
}
