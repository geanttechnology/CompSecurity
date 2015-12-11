// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.WatchableKey;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.view.BaseInstanceState;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            BabyGuideMovieActivity, BabyGuideSeriesEntityActivity, MovieDetailActivity, SeriesEntityActivity, 
//            EpisodeDetailFragment, SeriesEpisodeListFragment, MovieDetailFragment

public class DetailIntentHelper
{
    public static class Builder
    {

        private VideoBookmark bookmark;
        private Long companyId;
        private Long currentlyPlayingVideoId;
        private MerlinId episodeId;
        private VideoFavorite favorite;
        private boolean inBabyGuide;
        private BaseInstanceState instanceState;
        private boolean loadAsActivity;
        private MerlinId merlinId;
        private boolean noReferenceObject;
        private com.xfinity.playerlib.model.MerlinId.Namespace overrideNamespace;
        private DibicProgram program;
        private MerlinId seriesId;
        private SeriesWatchable seriesWatchable;
        private boolean shouldHideSeriesTitle;
        private boolean showDetail;
        private boolean showPanelFittedLayout;
        private boolean showSeriesArt;
        private VideoFacade video;
        private boolean wantsSubscriptionOnly;
        private WatchableKey watchableKey;

        private Class getDetailActivityClassForNameSpace(com.xfinity.playerlib.model.MerlinId.Namespace namespace, boolean flag)
        {
            if (flag)
            {
                if (namespace.equals(com.xfinity.playerlib.model.MerlinId.Namespace.Movie))
                {
                    return com/xfinity/playerlib/view/programdetails/BabyGuideMovieActivity;
                } else
                {
                    return com/xfinity/playerlib/view/programdetails/BabyGuideSeriesEntityActivity;
                }
            }
            if (namespace.equals(com.xfinity.playerlib.model.MerlinId.Namespace.Movie))
            {
                return com/xfinity/playerlib/view/programdetails/MovieDetailActivity;
            } else
            {
                return com/xfinity/playerlib/view/programdetails/SeriesEntityActivity;
            }
        }

        private Fragment getFragmentForNamespace(com.xfinity.playerlib.model.MerlinId.Namespace namespace)
        {
            static class _cls1
            {

                static final int $SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace[];

                static 
                {
                    $SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace = new int[com.xfinity.playerlib.model.MerlinId.Namespace.values().length];
                    try
                    {
                        $SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace[com.xfinity.playerlib.model.MerlinId.Namespace.TvSeries.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace[com.xfinity.playerlib.model.MerlinId.Namespace.TvEpisode.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace[com.xfinity.playerlib.model.MerlinId.Namespace.Movie.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.xfinity.playerlib.model.MerlinId.Namespace[namespace.ordinal()])
            {
            default:
                throw new IllegalArgumentException((new StringBuilder()).append("Didn't expect ").append(namespace).toString());

            case 1: // '\001'
                if (showDetail)
                {
                    return new EpisodeDetailFragment();
                } else
                {
                    return new SeriesEpisodeListFragment();
                }

            case 2: // '\002'
                return new EpisodeDetailFragment();

            case 3: // '\003'
                return new MovieDetailFragment();
            }
        }

        private BaseInstanceState getInstanceStateForNamespace(com.xfinity.playerlib.model.MerlinId.Namespace namespace)
        {
            if (hasNoReferenceObject() || program != null)
            {
                if (namespace.equals(com.xfinity.playerlib.model.MerlinId.Namespace.Movie))
                {
                    return new DetailFragment.InstanceState();
                } else
                {
                    return new SeriesEntityActivity.InstanceState();
                }
            }
            if (watchableKey != null)
            {
                if (watchableKey.isMovie())
                {
                    return new DetailFragment.InstanceState();
                }
                if (namespace != null && namespace.equals(com.xfinity.playerlib.model.MerlinId.Namespace.TvEpisode))
                {
                    return new DetailFragment.InstanceState();
                } else
                {
                    return new SeriesEntityActivity.InstanceState();
                }
            }
            switch (_cls1..SwitchMap.com.xfinity.playerlib.model.MerlinId.Namespace[namespace.ordinal()])
            {
            default:
                throw new IllegalArgumentException((new StringBuilder()).append("Didn't expect ").append(namespace).toString());

            case 1: // '\001'
                if (showDetail)
                {
                    return new DetailFragment.InstanceState();
                } else
                {
                    return new SeriesEpisodeListFragment.InstanceState();
                }

            case 2: // '\002'
                return new DetailFragment.InstanceState();

            case 3: // '\003'
                return new DetailFragment.InstanceState();
            }
        }

        private BaseInstanceState getInstanceStateForNamespace(com.xfinity.playerlib.model.MerlinId.Namespace namespace, boolean flag)
        {
            if (flag && namespace != com.xfinity.playerlib.model.MerlinId.Namespace.Movie)
            {
                return new SeriesEntityActivity.InstanceState();
            } else
            {
                return getInstanceStateForNamespace(namespace);
            }
        }

        private com.xfinity.playerlib.model.MerlinId.Namespace getNamespace()
        {
            if (overrideNamespace != null)
            {
                return overrideNamespace;
            }
            if (bookmark != null)
            {
                return bookmark.getParentMerlinIdIfApplicable().getNamespace();
            }
            if (seriesWatchable != null)
            {
                return seriesWatchable.getParentMerlinIdIfApplicable().getNamespace();
            }
            if (favorite != null)
            {
                return favorite.getMerlinId().getNamespace();
            }
            if (video != null)
            {
                return video.getProgramId().getNamespace();
            }
            if (program != null)
            {
                return program.getMerlinIdNamespace();
            }
            if (watchableKey != null)
            {
                if (watchableKey.isMovie())
                {
                    return com.xfinity.playerlib.model.MerlinId.Namespace.Movie;
                } else
                {
                    return com.xfinity.playerlib.model.MerlinId.Namespace.TvSeries;
                }
            } else
            {
                return null;
            }
        }

        public DetailIntentHelper build()
        {
            return new DetailIntentHelper(this, null);
        }

        public Builder companyId(Long long1)
        {
            companyId = long1;
            return this;
        }

        public Builder currentlyPlayingVideo(Long long1)
        {
            currentlyPlayingVideoId = long1;
            return this;
        }

        public Builder episodeId(MerlinId merlinid)
        {
            episodeId = merlinid;
            return this;
        }

        protected boolean hasNoReferenceObject()
        {
            return noReferenceObject;
        }

        public Builder isInBabyGuide(boolean flag)
        {
            inBabyGuide = flag;
            return this;
        }

        public Builder loadAsActivity(boolean flag)
        {
            loadAsActivity = flag;
            return this;
        }

        public Builder overrideNamespace(com.xfinity.playerlib.model.MerlinId.Namespace namespace)
        {
            overrideNamespace = namespace;
            return this;
        }

        public Builder shouldHideSeriesTitle(boolean flag)
        {
            shouldHideSeriesTitle = flag;
            return this;
        }

        public Builder showDetail(boolean flag)
        {
            showDetail = flag;
            return this;
        }

        public Builder showPanelFittedLayout(boolean flag)
        {
            showPanelFittedLayout = flag;
            return this;
        }

        public Builder showSeriesArt(boolean flag)
        {
            showSeriesArt = flag;
            return this;
        }

        public Builder wantsSubscriptionOnly(boolean flag)
        {
            wantsSubscriptionOnly = flag;
            return this;
        }























        public Builder(VideoBookmark videobookmark)
        {
            shouldHideSeriesTitle = true;
            noReferenceObject = false;
            bookmark = videobookmark;
        }

        public Builder(MerlinId merlinid)
        {
            shouldHideSeriesTitle = true;
            noReferenceObject = false;
            overrideNamespace = merlinid.getNamespace();
            merlinId = merlinid;
            seriesId = merlinid;
            noReferenceObject = true;
        }

        public Builder(VideoFavorite videofavorite)
        {
            shouldHideSeriesTitle = true;
            noReferenceObject = false;
            favorite = videofavorite;
        }

        public Builder(SeriesWatchable serieswatchable)
        {
            shouldHideSeriesTitle = true;
            noReferenceObject = false;
            seriesWatchable = serieswatchable;
        }

        public Builder(VideoFacade videofacade)
        {
            shouldHideSeriesTitle = true;
            noReferenceObject = false;
            video = videofacade;
        }

        public Builder(WatchableKey watchablekey)
        {
            shouldHideSeriesTitle = true;
            noReferenceObject = false;
            watchableKey = watchablekey;
        }

        public Builder(DibicProgram dibicprogram)
        {
            shouldHideSeriesTitle = true;
            noReferenceObject = false;
            program = dibicprogram;
        }

        public Builder(BaseInstanceState baseinstancestate, com.xfinity.playerlib.model.MerlinId.Namespace namespace)
        {
            shouldHideSeriesTitle = true;
            noReferenceObject = false;
            instanceState = baseinstancestate;
            overrideNamespace = namespace;
            currentlyPlayingVideoId = baseinstancestate.currentlyPlayingVideoId;
        }
    }


    Class infoClass;
    Fragment infoFragment;
    BaseInstanceState instanceState;

    private DetailIntentHelper(Builder builder)
    {
        boolean flag1 = true;
        super();
        instanceState = builder.getInstanceStateForNamespace(builder.getNamespace(), builder.loadAsActivity);
        infoFragment = builder.getFragmentForNamespace(builder.getNamespace());
        com.xfinity.playerlib.model.MerlinId.Namespace namespace = builder.getNamespace();
        boolean flag = flag1;
        if (builder.currentlyPlayingVideoId == null)
        {
            if (builder.inBabyGuide)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
        }
        infoClass = builder.getDetailActivityClassForNameSpace(namespace, flag);
        instanceState.setCurrentlyPlayingVideoId(builder.currentlyPlayingVideoId);
        instanceState.setShouldHideSeriesTitle(builder.shouldHideSeriesTitle);
        instanceState.setShowPanelFittedLayout(builder.showPanelFittedLayout);
        instanceState.setLoadAsActivity(Boolean.valueOf(builder.loadAsActivity));
        instanceState.setEpisodeId(builder.episodeId);
        instanceState.setSeriesId(builder.seriesId);
        instanceState.setMerlinId(builder.merlinId);
        instanceState.showSeriesArt(Boolean.valueOf(builder.showSeriesArt));
        instanceState.setCompanyId(builder.companyId);
        instanceState.setWantsSubscriptionOnly(builder.wantsSubscriptionOnly);
        if (builder.watchableKey != null)
        {
            instanceState.setWatchableKey(builder.watchableKey);
            instanceState.setSeriesId(builder.watchableKey.getParentMerlinId());
        } else
        {
            if (builder.bookmark != null)
            {
                instanceState.setMerlinId(builder.bookmark.getMerlinId());
                instanceState.setCompanyId(Long.valueOf(builder.bookmark.getCompanyId()));
                instanceState.setSeriesId(builder.bookmark.getParentMerlinIdIfApplicable());
                instanceState.setVideoId(Long.valueOf(builder.bookmark.getVideoId()));
                instanceState.setEpisodeId(builder.bookmark.getMerlinId());
                instanceState.setNonEpisodeVideoId(Long.valueOf(builder.bookmark.getVideoId()));
                BaseInstanceState baseinstancestate = instanceState;
                if (builder.bookmark.companyId != 0L)
                {
                    builder = Long.valueOf(builder.bookmark.companyId);
                } else
                {
                    builder = null;
                }
                baseinstancestate.setCompanyId(builder);
                return;
            }
            if (builder.video != null)
            {
                instanceState.setSeriesId(builder.video.getParentMerlinIdIfApplicable());
                instanceState.setNonEpisodeVideoId(Long.valueOf(builder.video.getVideoId()));
                instanceState.setEpisodeId(builder.video.getProgramId());
                instanceState.setMerlinId(builder.video.getProgramId());
                return;
            }
            if (builder.favorite != null)
            {
                instanceState.setSeriesId(builder.favorite.getMerlinId());
                instanceState.setMerlinId(builder.favorite.getMerlinId());
                return;
            }
            if (builder.seriesWatchable != null)
            {
                instanceState.setSeriesId(builder.seriesWatchable.getParentMerlinIdIfApplicable());
                instanceState.setEpisodeId(builder.seriesWatchable.getMerlinId());
                return;
            }
            if (builder.instanceState != null)
            {
                instanceState.setWatchableKey(builder.instanceState.watchableKey);
                instanceState.setSeriesId(builder.instanceState.seriesId);
                instanceState.setEpisodeId(builder.instanceState.episodeId);
                instanceState.setVideoId(builder.instanceState.videoId);
                return;
            }
            if (builder.program != null)
            {
                instanceState.setMerlinId(builder.program.getMerlinId());
                instanceState.setSeriesId(builder.program.getMerlinId());
                return;
            }
        }
    }

    DetailIntentHelper(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public Bundle getBundle()
    {
        return instanceState.addToBundle(new Bundle());
    }

    public Fragment getFragment()
    {
        infoFragment.setArguments(getBundle());
        return infoFragment;
    }

    public Intent getIntent(Context context)
    {
        context = new Intent(context, infoClass);
        context.putExtras(getBundle());
        return context;
    }
}
