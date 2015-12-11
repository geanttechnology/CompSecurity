// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable;

import android.net.Uri;
import com.comcast.cim.cmasl.utils.container.Either;
import com.comcast.cim.cmasl.utils.container.RightEither;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.comcast.cim.cmasl.utils.i18n.Iso629Util;
import com.comcast.cim.model.Rating;
import com.comcast.cim.utils.UIPresentationUtil;
import com.google.common.collect.Sets;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.consumable.hal.HalEpisode;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.model.consumable.hal.HalTvSeason;
import com.xfinity.playerlib.model.consumable.hal.HalTvSeriesConsumable;
import com.xfinity.playerlib.model.consumable.hal.HalVideo;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.consumable:
//            BaseWatchable, SeriesWatchable, VideoFacade, TvSeriesFacade, 
//            SeriesWatchableInfo

public class EpisodeFacade extends BaseWatchable
    implements SeriesWatchable
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/consumable/EpisodeFacade);
    private HalEpisode episodeEntity;
    private HalTvSeason seasonEntity;
    private String seriesSortTitle;
    private HalTvSeriesConsumable tvSeriesEntity;
    private final Set videos;

    public EpisodeFacade(HalEpisode halepisode, HalTvSeriesConsumable haltvseriesconsumable)
    {
        seriesSortTitle = null;
        Validate.notNull(halepisode);
        Validate.notNull(haltvseriesconsumable);
        tvSeriesEntity = haltvseriesconsumable;
        episodeEntity = halepisode;
        seasonEntity = haltvseriesconsumable.findSeasonForEpisode(halepisode);
        videos = buildVideosFromSeriesAndEpisode(halepisode, haltvseriesconsumable);
        initFromVideos();
    }

    public EpisodeFacade(HalTvSeriesConsumable haltvseriesconsumable, MerlinId merlinid)
    {
        seriesSortTitle = null;
        Validate.notNull(merlinid);
        Validate.notNull(haltvseriesconsumable);
        tvSeriesEntity = haltvseriesconsumable;
        episodeEntity = haltvseriesconsumable.findEpisodeByMerlinId(merlinid);
        seasonEntity = haltvseriesconsumable.findSeasonForEpisode(episodeEntity);
        videos = buildVideosFromSeriesAndEpisode(episodeEntity, haltvseriesconsumable);
        initFromVideos();
    }

    private Set buildVideosFromSeriesAndEpisode(HalEpisode halepisode, HalTvSeriesConsumable haltvseriesconsumable)
    {
        java.util.HashSet hashset = Sets.newHashSet();
        for (Iterator iterator = halepisode.getVideos().iterator(); iterator.hasNext(); hashset.add(new VideoFacade((HalVideo)iterator.next(), halepisode.getMerlinEntityId(), haltvseriesconsumable.getMerlinEntityId()))) { }
        return hashset;
    }

    private VideoFacade getVideoOnSameNetworkIfAvail(SeriesWatchable serieswatchable, VideoFacade videofacade, String s)
    {
        Object obj = Iso629Util.getLocaleByLanguageCode(s);
        s = ((String) (obj));
        if (obj == null)
        {
            s = Iso629Util.getLocaleByLanguageCode("en");
        }
        serieswatchable = serieswatchable.getVideos().iterator();
label0:
        do
        {
            if (serieswatchable.hasNext())
            {
                obj = (VideoFacade)serieswatchable.next();
                if (videofacade.getNetworkInfo().getCompanyId() != ((VideoFacade) (obj)).getNetworkInfo().getCompanyId())
                {
                    continue;
                }
                Object obj1 = videofacade.getVideoRating();
                Object obj2 = ((VideoFacade) (obj)).getVideoRating();
                if ((obj1 == null || !((Rating) (obj1)).equals(obj2)) && (obj1 != null || obj2 != null))
                {
                    continue;
                }
                obj1 = ((VideoFacade) (obj)).getLanguageCodes().iterator();
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        continue label0;
                    }
                    obj2 = Iso629Util.getLocaleByLanguageCode((String)((Iterator) (obj1)).next());
                } while (!s.getLanguage().equals(((Locale) (obj2)).getLanguage()));
                break;
            } else
            {
                return null;
            }
        } while (true);
        return ((VideoFacade) (obj));
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            if (!super.equals(obj))
            {
                return false;
            }
            obj = (EpisodeFacade)obj;
            if (episodeEntity == null ? ((EpisodeFacade) (obj)).episodeEntity != null : !episodeEntity.equals(((EpisodeFacade) (obj)).episodeEntity))
            {
                return false;
            }
            if (tvSeriesEntity == null ? ((EpisodeFacade) (obj)).tvSeriesEntity != null : !tvSeriesEntity.equals(((EpisodeFacade) (obj)).tvSeriesEntity))
            {
                return false;
            }
            if (videos == null ? ((EpisodeFacade) (obj)).videos != null : !videos.equals(((EpisodeFacade) (obj)).videos))
            {
                return false;
            }
        }
        return true;
    }

    public Either getBackingEntity()
    {
        return new RightEither(tvSeriesEntity);
    }

    public String getCast()
    {
        return tvSeriesEntity.castListAsString();
    }

    public String getDescription()
    {
        return episodeEntity.getDescription();
    }

    public String getDisplayTitle()
    {
        String s;
label0:
        {
            String s1 = getEpisodeTitle();
            if (s1 != null)
            {
                s = s1;
                if (!s1.isEmpty())
                {
                    break label0;
                }
            }
            s = FastDateFormat.getDateInstance(1).format(getOriginalAirdate());
        }
        return s;
    }

    public Uri getEntityDeeplinkUri(String s)
    {
        return Uri.parse((new StringBuilder()).append(s).append("://entity/0/").append(getParentMerlinIdIfApplicable().getSimpleId()).append("/").append(getMerlinId().getSimpleId()).toString());
    }

    public MerlinId getEpisodeId()
    {
        return episodeEntity.getMerlinEntityId();
    }

    public Integer getEpisodeNumber()
    {
        return Integer.valueOf(episodeEntity.getEpisodeNumber());
    }

    public String getEpisodeTitle()
    {
        return episodeEntity.getTitle();
    }

    public MerlinId getMerlinId()
    {
        return getEpisodeId();
    }

    public com.xfinity.playerlib.model.MerlinId.Namespace getMerlinIdNamespace()
    {
        return episodeEntity.getMerlinEntityId().getNamespace();
    }

    public String getNextItemDisplayTitle()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(getSeriesTitle()).append(". ").append(UIPresentationUtil.getSeriesString(getSeasonNumber(), getEpisodeNumber()));
        return stringbuilder.toString();
    }

    public Tuple getNextVideoItem(VideoFacade videofacade, String s)
    {
        TvSeriesFacade tvseriesfacade = new TvSeriesFacade(tvSeriesEntity);
        int i = tvseriesfacade.getAllEpisodeFacades().size() - 1;
        do
        {
label0:
            {
label1:
                {
                    if (i > 0)
                    {
                        SeriesWatchable serieswatchable = (SeriesWatchable)tvseriesfacade.getAllEpisodeFacades().get(i);
                        if (!serieswatchable.getMerlinId().equals(getMerlinId()))
                        {
                            break label0;
                        }
                        if (serieswatchable.getSeasonNumber().intValue() >= 0)
                        {
                            break label1;
                        }
                    }
                    return null;
                }
                SeriesWatchable serieswatchable1 = (SeriesWatchable)tvseriesfacade.getAllEpisodeFacades().get(i - 1);
                VideoFacade videofacade1 = getVideoOnSameNetworkIfAvail(serieswatchable1, videofacade, s);
                if (videofacade1 != null)
                {
                    return new Tuple(videofacade1, serieswatchable1);
                }
            }
            i--;
        } while (true);
    }

    public Date getOriginalAirdate()
    {
        return episodeEntity.getOriginalAirdate();
    }

    public MerlinId getParentMerlinIdIfApplicable()
    {
        return tvSeriesEntity.getMerlinEntityId();
    }

    public Uri getPlaybackDeeplinkUri(String s)
    {
        return Uri.parse((new StringBuilder()).append(s).append("://playback/0/").append(getParentMerlinIdIfApplicable().getSimpleId()).append("/").append(getMerlinId().getSimpleId()).toString());
    }

    public Integer getSeasonNumber()
    {
        return Integer.valueOf(seasonEntity.getSeasonNumber());
    }

    public SeriesWatchableInfo getSeriesInfoIfApplicable()
    {
        return this;
    }

    public String getSeriesSortTitle()
    {
        if (seriesSortTitle == null)
        {
            seriesSortTitle = UIPresentationUtil.getSortStringFromTitle(getSeriesTitle());
        }
        return seriesSortTitle;
    }

    public String getSeriesTitle()
    {
        return tvSeriesEntity.getTitle();
    }

    public String getTitle()
    {
        return getEpisodeTitle();
    }

    public Set getVideos()
    {
        return videos;
    }

    public int hashCode()
    {
        int k = 0;
        int l = super.hashCode();
        int i;
        int j;
        if (videos != null)
        {
            i = videos.hashCode();
        } else
        {
            i = 0;
        }
        if (episodeEntity != null)
        {
            j = episodeEntity.hashCode();
        } else
        {
            j = 0;
        }
        if (tvSeriesEntity != null)
        {
            k = tvSeriesEntity.hashCode();
        }
        return ((l * 31 + i) * 31 + j) * 31 + k;
    }

    public boolean isNew()
    {
        return episodeEntity.isNew();
    }

}
