// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.common;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import com.auditude.ads.util.StringUtil;
import com.comcast.cim.utils.TextFlowHelper;
import com.comcast.cim.utils.UIPresentationUtil;
import com.comcast.cim.utils.UIUtil;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.time.FastDateFormat;

public class PlayNowConsumableEpisodeArrayAdapter extends ArrayAdapter
{
    private class ConsumableEpisodeHolder
    {

        protected View downloadableIndicator;
        protected TextView episodeNumText;
        protected View listItemContainer;
        protected ImageView newIndicator;
        protected TextView progressIndicator;
        final PlayNowConsumableEpisodeArrayAdapter this$0;
        protected TextView titleText;
        protected ImageView watchingIndicator;

        private ConsumableEpisodeHolder()
        {
            this$0 = PlayNowConsumableEpisodeArrayAdapter.this;
            super();
        }

    }

    private class ContentDescription
    {

        protected String episodeNumber;
        protected String episodeTitle;
        protected boolean isAvailableForDownload;
        protected boolean isNew;
        protected boolean isWatching;
        protected String seasonNumber;
        protected String seriesTitle;
        final PlayNowConsumableEpisodeArrayAdapter this$0;
        protected String timeRemaining;

        public String getContentDescription(Context context)
        {
            String s;
            String s1;
            String s2;
            String s3;
            if (isNew)
            {
                s = context.getString(com.xfinity.playerlib.R.string.content_description_new_episode);
            } else
            {
                s = "";
            }
            if (isWatching)
            {
                s1 = context.getString(com.xfinity.playerlib.R.string.on_now);
            } else
            {
                s1 = "";
            }
            if (isAvailableForDownload)
            {
                s2 = context.getString(com.xfinity.playerlib.R.string.available_for_download);
            } else
            {
                s2 = "";
            }
            if (StringUtil.isNullOrEmpty(episodeNumber))
            {
                s3 = "";
            } else
            {
                s3 = context.getString(com.xfinity.playerlib.R.string.content_description_just_episode_number, new Object[] {
                    episodeNumber
                });
            }
            episodeNumber = s3;
            if (StringUtil.isNullOrEmpty(seasonNumber))
            {
                s3 = "";
            } else
            {
                s3 = context.getString(com.xfinity.playerlib.R.string.content_description_just_season_number, new Object[] {
                    seasonNumber
                });
            }
            seasonNumber = s3;
            return context.getString(com.xfinity.playerlib.R.string.content_description_episode_item, new Object[] {
                episodeNumber, s, episodeTitle, seriesTitle, seasonNumber, s1, timeRemaining, s2
            });
        }

        public void setContentDescription(View view)
        {
            view.setContentDescription(getContentDescription(view.getContext()));
        }

        public void setupTitleText(SeriesWatchable serieswatchable)
        {
            String s = serieswatchable.getDisplayTitle();
            if (s == null || s.length() <= 0) goto _L2; else goto _L1
_L1:
            episodeTitle = s;
_L4:
            if (serieswatchable.getSeriesTitle() != null)
            {
                seriesTitle = serieswatchable.getSeriesTitle();
            }
            return;
_L2:
            if (serieswatchable.getOriginalAirdate() != null)
            {
                episodeTitle = FastDateFormat.getInstance("MMM d, yyyy").format(serieswatchable.getOriginalAirdate());
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private ContentDescription()
        {
            this$0 = PlayNowConsumableEpisodeArrayAdapter.this;
            super();
            episodeTitle = "";
            seriesTitle = "";
            seasonNumber = "";
            episodeNumber = "";
            timeRemaining = "";
        }

    }

    public static interface OnInfoClickListener
    {

        public abstract void onClick(SeriesWatchable serieswatchable, int i);
    }


    Map bookmarks;
    private int checkedPos;
    private Long currentlyWatchingVideoId;
    private LayoutInflater inflater;
    Map nonEpisodeBookmarks;
    private OnInfoClickListener onInfoClickListener;

    public PlayNowConsumableEpisodeArrayAdapter(Activity activity, int i, List list, LayoutInflater layoutinflater, UIUtil uiutil, Long long1, Map map, 
            Map map1)
    {
        super(activity, i, list);
        checkedPos = -1;
        inflater = layoutinflater;
        bookmarks = map;
        nonEpisodeBookmarks = map1;
        currentlyWatchingVideoId = long1;
    }

    private String buildEpisodeString(Context context, SeriesWatchable serieswatchable)
    {
        if (serieswatchable.getEpisodeNumber().intValue() > 0)
        {
            return context.getString(com.xfinity.playerlib.R.string.just_episode, new Object[] {
                serieswatchable.getEpisodeNumber()
            });
        } else
        {
            return null;
        }
    }

    private void updateTitleText(TextView textview, SeriesWatchable serieswatchable)
    {
        String s = serieswatchable.getDisplayTitle();
        if (s != null && s.length() > 0)
        {
            textview.setText(UIPresentationUtil.addQuotesToString(s));
        } else
        {
            if (serieswatchable.getOriginalAirdate() != null)
            {
                textview.setText(FastDateFormat.getInstance("MMM d, yyyy").format(serieswatchable.getOriginalAirdate()));
                return;
            }
            if (serieswatchable.getSeriesTitle() != null)
            {
                textview.setText(serieswatchable.getSeriesTitle());
                return;
            }
        }
    }

    public View getView(final int position, View view, ViewGroup viewgroup)
    {
        ContentDescription contentdescription = new ContentDescription();
        ConsumableEpisodeHolder consumableepisodeholder;
        View view1;
        final SeriesWatchable watchable;
        boolean flag;
        if (view == null)
        {
            view1 = inflater.inflate(com.xfinity.playerlib.R.layout.consumable_episode_list_item, null);
            consumableepisodeholder = new ConsumableEpisodeHolder();
            consumableepisodeholder.listItemContainer = view1.findViewById(com.xfinity.playerlib.R.id.list_item_container);
            consumableepisodeholder.titleText = (TextView)view1.findViewById(com.xfinity.playerlib.R.id.consumable_episode_title);
            consumableepisodeholder.newIndicator = (ImageView)view1.findViewById(com.xfinity.playerlib.R.id.new_indicator);
            consumableepisodeholder.episodeNumText = (TextView)view1.findViewById(com.xfinity.playerlib.R.id.episode_num);
            consumableepisodeholder.watchingIndicator = (ImageView)view1.findViewById(com.xfinity.playerlib.R.id.watching_indicator);
            consumableepisodeholder.progressIndicator = (TextView)view1.findViewById(com.xfinity.playerlib.R.id.progressIndicator);
            consumableepisodeholder.downloadableIndicator = view1.findViewById(com.xfinity.playerlib.R.id.downloadable_indicator);
            view1.setTag(consumableepisodeholder);
        } else
        {
            consumableepisodeholder = (ConsumableEpisodeHolder)view.getTag();
            view1 = view;
        }
        view = (Checkable)view1;
        if (position == checkedPos)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setChecked(flag);
        watchable = (SeriesWatchable)getItem(position);
        if (consumableepisodeholder.titleText != null)
        {
            updateTitleText(consumableepisodeholder.titleText, watchable);
            contentdescription.setupTitleText(watchable);
        }
        if (consumableepisodeholder.newIndicator != null)
        {
            if (watchable.isNew())
            {
                consumableepisodeholder.newIndicator.setVisibility(0);
                TextFlowHelper.tryFlowText(consumableepisodeholder.newIndicator, consumableepisodeholder.titleText, viewgroup);
            } else
            {
                consumableepisodeholder.newIndicator.setVisibility(8);
            }
            contentdescription.isNew = watchable.isNew();
        }
        if (consumableepisodeholder.episodeNumText != null && watchable.getEpisodeNumber() != null)
        {
            view = buildEpisodeString(consumableepisodeholder.episodeNumText.getContext(), watchable);
            consumableepisodeholder.episodeNumText.setText(view);
            consumableepisodeholder.episodeNumText.setVisibility(0);
            if (watchable.getEpisodeNumber().intValue() < 1)
            {
                view = "";
            } else
            {
                view = watchable.getEpisodeNumber().toString();
            }
            contentdescription.episodeNumber = view;
            if (watchable.getSeasonNumber().intValue() < 1)
            {
                view = "";
            } else
            {
                view = watchable.getSeasonNumber().toString();
            }
            contentdescription.seasonNumber = view;
        } else
        {
            consumableepisodeholder.episodeNumText.setVisibility(4);
        }
        view1.setOnClickListener(new android.view.View.OnClickListener() {

            final PlayNowConsumableEpisodeArrayAdapter this$0;
            final int val$position;
            final SeriesWatchable val$watchable;

            public void onClick(View view2)
            {
                if (onInfoClickListener != null)
                {
                    onInfoClickListener.onClick(watchable, position);
                }
            }

            
            {
                this$0 = PlayNowConsumableEpisodeArrayAdapter.this;
                watchable = serieswatchable;
                position = i;
                super();
            }
        });
        consumableepisodeholder.progressIndicator.setVisibility(8);
        if (watchable.getMerlinId() != null)
        {
            view = null;
            if (bookmarks != null)
            {
                view = (VideoBookmark)bookmarks.get(watchable.getMerlinId());
            } else
            if (nonEpisodeBookmarks != null)
            {
                view = (VideoBookmark)nonEpisodeBookmarks.get(Long.valueOf(((VideoFacade)watchable.getVideos().iterator().next()).getVideoId()));
            }
            if (view != null && view.getCategories().contains(com.xfinity.playerlib.bookmarks.VideoBookmark.BookmarkCategory.CATEGORY_RECENT) && view.getPosition() > 0)
            {
                consumableepisodeholder.progressIndicator.setText(UIPresentationUtil.getRemainingTime(view1.getContext(), view.getDuration(), view.getPosition()));
                contentdescription.timeRemaining = UIPresentationUtil.getRemainingTimeTalkBack(view1.getContext(), view.getDuration(), view.getPosition());
                consumableepisodeholder.progressIndicator.setVisibility(0);
            } else
            {
                consumableepisodeholder.progressIndicator.setVisibility(8);
            }
            if (currentlyWatchingVideoId != null)
            {
                if (watchable.findVideoById(currentlyWatchingVideoId.longValue()) != null)
                {
                    consumableepisodeholder.watchingIndicator.setVisibility(0);
                    contentdescription.isWatching = true;
                } else
                {
                    consumableepisodeholder.watchingIndicator.setVisibility(4);
                }
            } else
            {
                consumableepisodeholder.watchingIndicator.setVisibility(8);
            }
        }
        if (watchable.hasDownloadableVideo())
        {
            consumableepisodeholder.downloadableIndicator.setVisibility(0);
            contentdescription.isAvailableForDownload = true;
        } else
        {
            consumableepisodeholder.downloadableIndicator.setVisibility(4);
        }
        contentdescription.setContentDescription(consumableepisodeholder.listItemContainer);
        return view1;
    }

    public void setCheckedPos(int i)
    {
        checkedPos = i;
        notifyDataSetChanged();
    }

    public void setOnInfoClickListener(OnInfoClickListener oninfoclicklistener)
    {
        onInfoClickListener = oninfoclicklistener;
    }

}
