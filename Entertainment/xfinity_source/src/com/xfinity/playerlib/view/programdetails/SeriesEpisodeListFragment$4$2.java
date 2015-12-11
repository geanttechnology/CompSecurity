// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.cmasl.android.util.view.widget.CheckableRelativeLayout;
import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.model.system.PlayerAndroidDevice;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import com.xfinity.playerlib.model.consumable.TvSeriesFacade;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.WatchableKey;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.view.common.PlayNowConsumableEpisodeArrayAdapter;
import com.xfinity.playerlib.view.favorite.BookmarkMenuItemDelegate;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            SeriesEpisodeListFragment, SeriesResource

class this._cls1
    implements ClickListenerFactory
{

    final Detail this$1;

    public com.xfinity.playerlib.view.common.dapter.OnInfoClickListener create(PlayNowConsumableEpisodeArrayAdapter playnowconsumableepisodearrayadapter)
    {
        return new com.xfinity.playerlib.view.common.PlayNowConsumableEpisodeArrayAdapter.OnInfoClickListener() {

            final SeriesEpisodeListFragment._cls4._cls2 this$2;

            public void onClick(SeriesWatchable serieswatchable, int i)
            {
                SeriesEpisodeListFragment.access$200(this$0).resetWatchableInfo();
                SeriesEpisodeListFragment.access$200(this$0).episodeId = serieswatchable.getMerlinId();
                SeriesEpisodeListFragment.access$1300(this$0).showSeriesWatchableDetail(serieswatchable);
            }

            
            {
                this$2 = SeriesEpisodeListFragment._cls4._cls2.this;
                super();
            }
        };
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4

/* anonymous class */
    class SeriesEpisodeListFragment._cls4 extends DefaultTaskExecutionListener
    {

        final SeriesEpisodeListFragment this$0;

        public void onError(TaskExecutionException taskexecutionexception)
        {
            SeriesEpisodeListFragment.access$000(SeriesEpisodeListFragment.this).onLoadingFailed();
        }

        public void onPostExecute(SeriesResource seriesresource)
        {
            VideoEntitlement videoentitlement;
            DibicProgram dibicprogram;
            notAvailableContainer.setVisibility(8);
            SeriesEpisodeListFragment.access$602(SeriesEpisodeListFragment.this, seriesresource.tvSeriesFacade);
            SeriesEpisodeListFragment.access$702(SeriesEpisodeListFragment.this, seriesresource.dibicResource);
            videoentitlement = seriesresource.entitlement;
            dibicprogram = SeriesEpisodeListFragment.access$700(SeriesEpisodeListFragment.this).getProgramByMerlinId(SeriesEpisodeListFragment.access$600(SeriesEpisodeListFragment.this).getMerlinId());
            if (dibicprogram != null) goto _L2; else goto _L1
_L1:
            SeriesEpisodeListFragment.access$800(SeriesEpisodeListFragment.this);
_L9:
            return;
_L2:
            Object obj;
            Object obj1;
            obj = null;
            obj1 = null;
            if (!SeriesEpisodeListFragment.access$200(SeriesEpisodeListFragment.this).hasOnlySeriesInfo() || SeriesEpisodeListFragment.access$600(SeriesEpisodeListFragment.this).getAllEpisodeFacades().size() <= 0)
            {
                break MISSING_BLOCK_LABEL_602;
            }
            obj = SeriesEpisodeListFragment.access$600(SeriesEpisodeListFragment.this).getAllEpisodeFacades();
            if (SeriesEpisodeListFragment.access$200(SeriesEpisodeListFragment.this).companyId == null && !SeriesEpisodeListFragment.access$200(SeriesEpisodeListFragment.this).wantsSubscriptionOnly) goto _L4; else goto _L3
_L3:
            Iterator iterator = ((List) (obj)).iterator();
_L10:
            obj = obj1;
            if (!iterator.hasNext()) goto _L6; else goto _L5
_L5:
            obj = (SeriesWatchable)iterator.next();
            if (obj1 == null) goto _L8; else goto _L7
_L7:
            obj = obj1;
_L6:
            SeriesEpisodeListFragment.access$902(SeriesEpisodeListFragment.this, new VideoFavorite(SeriesEpisodeListFragment.access$600(SeriesEpisodeListFragment.this).getMerlinId(), SeriesEpisodeListFragment.access$600(SeriesEpisodeListFragment.this).getTitle(), dibicprogram.isAdult()));
            Iterator iterator1;
            VideoFacade videofacade;
            if (SeriesEpisodeListFragment.access$200(SeriesEpisodeListFragment.this).showSeriesArt.booleanValue() && (!playerAndroidDevice.isTabletDevice() || !SeriesEpisodeListFragment.access$500(SeriesEpisodeListFragment.this).isAccessibilityEnabled()))
            {
                seriesTitleContainer.setVisibility(8);
                getActivity().setTitle(SeriesEpisodeListFragment.access$600(SeriesEpisodeListFragment.this).getTitle());
                SeriesEpisodeListFragment.access$1000(SeriesEpisodeListFragment.this).setVisibility(8);
                bookmarkMenuItemDelegate.setupFavorite(SeriesEpisodeListFragment.this, true, SeriesEpisodeListFragment.access$1100(SeriesEpisodeListFragment.this), SeriesEpisodeListFragment.access$900(SeriesEpisodeListFragment.this));
            } else
            {
                SeriesEpisodeListFragment.access$1000(SeriesEpisodeListFragment.this).setText(SeriesEpisodeListFragment.access$600(SeriesEpisodeListFragment.this).getTitle());
                SeriesEpisodeListFragment.access$1000(SeriesEpisodeListFragment.this).setVisibility(0);
                bookmarkMenuItemDelegate.setupFavorite(SeriesEpisodeListFragment.this, false, SeriesEpisodeListFragment.access$1100(SeriesEpisodeListFragment.this), SeriesEpisodeListFragment.access$900(SeriesEpisodeListFragment.this));
            }
            SeriesEpisodeListFragment.access$500(SeriesEpisodeListFragment.this).getTalkDelegate().setTitle(getString(com.xfinity.playerlib.R.string.content_description_detail_title, new Object[] {
                "tv series", SeriesEpisodeListFragment.access$600(SeriesEpisodeListFragment.this).getTitle()
            }));
            SeriesEpisodeListFragment.access$1400(SeriesEpisodeListFragment.this).setOnClickListener(new SeriesEpisodeListFragment._cls4._cls1());
            obj1 = new SeriesEpisodeListFragment._cls4._cls2();
            SeriesEpisodeListFragment.access$1500(SeriesEpisodeListFragment.this, seriesresource.bookmarkMap, ((com.xfinity.playerlib.model.consumable.Watchable) (obj)), SeriesEpisodeListFragment.access$600(SeriesEpisodeListFragment.this), ((ConsumableVideoListHelper.InfoClickListenerFactory) (obj1)), videoentitlement);
            if (SeriesEpisodeListFragment.access$1600(SeriesEpisodeListFragment.this) != null)
            {
                SeriesEpisodeListFragment.access$1700(SeriesEpisodeListFragment.this).onRestoreInstanceState(SeriesEpisodeListFragment.access$1600(SeriesEpisodeListFragment.this));
                return;
            }
              goto _L9
_L8:
            iterator1 = ((SeriesWatchable) (obj)).getVideos().iterator();
_L12:
            if (iterator1.hasNext())
            {
                videofacade = (VideoFacade)iterator1.next();
                if (SeriesEpisodeListFragment.access$200(SeriesEpisodeListFragment.this).companyId == null || videofacade.getNetworkInfo() == null || videofacade.getNetworkInfo().getCompanyId() != SeriesEpisodeListFragment.access$200(SeriesEpisodeListFragment.this).companyId.longValue())
                {
                    continue; /* Loop/switch isn't completed */
                }
                obj1 = obj;
            }
              goto _L10
            if (!SeriesEpisodeListFragment.access$200(SeriesEpisodeListFragment.this).wantsSubscriptionOnly || !videoentitlement.isEntitled(videofacade.getProviderCode())) goto _L12; else goto _L11
_L11:
            obj1 = obj;
              goto _L10
_L4:
            obj = (SeriesWatchable)((List) (obj)).get(0);
              goto _L6
            if (SeriesEpisodeListFragment.access$200(SeriesEpisodeListFragment.this).watchableKey != null)
            {
                obj = SeriesEpisodeListFragment.access$600(SeriesEpisodeListFragment.this).findWatchableByVideoId(SeriesEpisodeListFragment.access$200(SeriesEpisodeListFragment.this).watchableKey.getVideoId());
            } else
            if (SeriesEpisodeListFragment.access$200(SeriesEpisodeListFragment.this).useEpisodeId())
            {
                obj = SeriesEpisodeListFragment.access$600(SeriesEpisodeListFragment.this).findEpisodeById(SeriesEpisodeListFragment.access$200(SeriesEpisodeListFragment.this).episodeId);
            }
              goto _L6
        }

        public volatile void onPostExecute(Object obj)
        {
            onPostExecute((SeriesResource)obj);
        }

        public void onPreAsynchronousExecute()
        {
            SeriesEpisodeListFragment.access$500(SeriesEpisodeListFragment.this).getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.string.loading);
        }

            
            {
                this$0 = SeriesEpisodeListFragment.this;
                super();
            }

        // Unreferenced inner class com/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$1

/* anonymous class */
        class SeriesEpisodeListFragment._cls4._cls1
            implements android.view.View.OnClickListener
        {

            final SeriesEpisodeListFragment._cls4 this$1;

            public void onClick(View view)
            {
                SeriesEpisodeListFragment.access$200(this$0).resetWatchableInfo();
                SeriesEpisodeListFragment.access$200(this$0).seriesDetailSelected = true;
                SeriesEpisodeListFragment.access$1200(this$0);
                SeriesEpisodeListFragment.access$1300(this$0).showSeriesDetail();
            }

                    
                    {
                        this$1 = SeriesEpisodeListFragment._cls4.this;
                        super();
                    }
        }

    }

}
