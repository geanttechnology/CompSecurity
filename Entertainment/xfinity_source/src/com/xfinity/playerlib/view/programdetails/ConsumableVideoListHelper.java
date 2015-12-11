// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.comcast.cim.utils.UIUtil;
import com.commonsware.MergeAdapter;
import com.google.common.collect.Sets;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import com.xfinity.playerlib.model.consumable.TvSeriesFacade;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.view.common.PlayNowConsumableEpisodeArrayAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ConsumableVideoListHelper
{
    public static interface InfoClickListenerFactory
    {

        public abstract com.xfinity.playerlib.view.common.PlayNowConsumableEpisodeArrayAdapter.OnInfoClickListener create(PlayNowConsumableEpisodeArrayAdapter playnowconsumableepisodearrayadapter);
    }


    public ConsumableVideoListHelper()
    {
    }

    public Tuple populateConsumableVideoList(Activity activity, ListView listview, TvSeriesFacade tvseriesfacade, Watchable watchable, UIUtil uiutil, InfoClickListenerFactory infoclicklistenerfactory, Long long1, 
            Long long2, boolean flag, VideoEntitlement videoentitlement, Map map, boolean flag1)
    {
        LayoutInflater layoutinflater = (LayoutInflater)activity.getSystemService("layout_inflater");
        MergeAdapter mergeadapter = new MergeAdapter();
        HashMap hashmap = new HashMap();
        Object obj = new HashMap();
        int j = 0;
        boolean flag2 = false;
        VideoFacade videofacade;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); hashmap.put(videofacade.getProgramId(), map.get(videofacade)))
        {
            videofacade = (VideoFacade)iterator.next();
            ((Map) (obj)).put(Long.valueOf(videofacade.getVideoId()), map.get(videofacade));
        }

        map = Sets.newHashSet();
        obj = tvseriesfacade.getSeasonNumberToEpisodeMap().entrySet().iterator();
        do
        {
            if (((Iterator) (obj)).hasNext())
            {
                Object obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                List list = (List)((java.util.Map.Entry) (obj1)).getValue();
                if (long2 != null || flag)
                {
                    tvseriesfacade = list.iterator();
                    do
                    {
                        if (!tvseriesfacade.hasNext())
                        {
                            break;
                        }
                        Set set = ((SeriesWatchable)tvseriesfacade.next()).getVideos();
                        if (set != null)
                        {
                            Iterator iterator1 = set.iterator();
                            do
                            {
                                if (!iterator1.hasNext())
                                {
                                    break;
                                }
                                VideoFacade videofacade1 = (VideoFacade)iterator1.next();
                                if (long2 != null)
                                {
                                    if (videofacade1.getNetworkInfo() == null || videofacade1.getNetworkInfo().getCompanyId() != long2.longValue())
                                    {
                                        iterator1.remove();
                                    }
                                } else
                                if (flag && !videoentitlement.isEntitled(videofacade1.getProviderCode()))
                                {
                                    iterator1.remove();
                                }
                            } while (true);
                        }
                        if (set.size() == 0)
                        {
                            tvseriesfacade.remove();
                        }
                    } while (true);
                }
                if (list.size() <= 0)
                {
                    continue;
                }
                tvseriesfacade = "Other Seasons";
                int i;
                boolean flag3;
                if (((Integer)((java.util.Map.Entry) (obj1)).getKey()).intValue() > 0)
                {
                    tvseriesfacade = (new StringBuilder()).append("Season ").append(((java.util.Map.Entry) (obj1)).getKey()).toString();
                } else
                if (((Integer)((java.util.Map.Entry) (obj1)).getKey()).intValue() == -1)
                {
                    tvseriesfacade = "Other Videos";
                }
                obj1 = layoutinflater.inflate(com.xfinity.playerlib.R.layout.series_video_list_season_header, null);
                ((TextView)((View) (obj1)).findViewById(com.xfinity.playerlib.R.id.label)).setText(tvseriesfacade);
                ((View) (obj1)).setContentDescription(((View) (obj1)).getContext().getString(com.xfinity.playerlib.R.string.content_description_episode_item_season_heading, new Object[] {
                    tvseriesfacade
                }));
                mergeadapter.addView(((View) (obj1)), true);
                tvseriesfacade = new PlayNowConsumableEpisodeArrayAdapter(activity, 0, list, layoutinflater, uiutil, long1, hashmap, null);
                tvseriesfacade.setOnInfoClickListener(infoclicklistenerfactory.create(tvseriesfacade));
                mergeadapter.addAdapter(tvseriesfacade);
                i = list.indexOf(watchable);
                if (i >= 0)
                {
                    i = j + i;
                    flag3 = true;
                } else
                {
                    flag3 = flag2;
                    i = j;
                    if (!flag2)
                    {
                        i = j + list.size();
                        flag3 = flag2;
                    }
                }
                if (watchable != null && flag1)
                {
                    tvseriesfacade.setCheckedPos(list.indexOf(watchable));
                }
                map.add(tvseriesfacade);
                flag2 = flag3;
                j = i;
                continue;
            }
            listview.setAdapter(mergeadapter);
            listview.setSelection(j);
            return new Tuple(map, mergeadapter);
        } while (true);
    }
}
