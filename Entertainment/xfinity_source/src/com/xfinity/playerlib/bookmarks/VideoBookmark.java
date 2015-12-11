// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.bookmarks;

import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.Program;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.tracking.VideoMilestone;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.bookmarks:
//            Bookmark, BookmarkId

public abstract class VideoBookmark extends Bookmark
    implements Program
{
    public static final class BookmarkCategory extends Enum
    {

        private static final BookmarkCategory $VALUES[];
        public static final BookmarkCategory CATEGORY_RECENT;
        public static final BookmarkCategory CATEGORY_RESUMEPOINT;

        public static BookmarkCategory valueOf(String s)
        {
            return (BookmarkCategory)Enum.valueOf(com/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory, s);
        }

        public static BookmarkCategory[] values()
        {
            return (BookmarkCategory[])$VALUES.clone();
        }

        static 
        {
            CATEGORY_RESUMEPOINT = new BookmarkCategory("CATEGORY_RESUMEPOINT", 0);
            CATEGORY_RECENT = new BookmarkCategory("CATEGORY_RECENT", 1);
            $VALUES = (new BookmarkCategory[] {
                CATEGORY_RESUMEPOINT, CATEGORY_RECENT
            });
        }

        private BookmarkCategory(String s, int i)
        {
            super(s, i);
        }
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/bookmarks/VideoBookmark);
    protected List categories;
    protected int episodeNumber;
    private BookmarkId id;
    protected VideoMilestone lastTrackedMilestone;
    protected MerlinId merlinId;
    protected MerlinId parentMerlinId;
    protected int seasonNumber;
    public long videoId;

    protected VideoBookmark()
    {
        parentMerlinId = null;
        merlinId = null;
        categories = new ArrayList();
        seasonNumber = -1;
        episodeNumber = -1;
        categories = new ArrayList();
    }

    public void addCategory(BookmarkCategory bookmarkcategory)
    {
        if (!categories.contains(bookmarkcategory))
        {
            categories.add(bookmarkcategory);
        }
    }

    public List getCategories()
    {
        return categories;
    }

    public int getEpisodeNumber()
    {
        return episodeNumber;
    }

    public BookmarkId getId()
    {
        if (id == null)
        {
            id = new BookmarkId(merlinId, networkId, companyId, videoId);
        }
        return id;
    }

    public VideoMilestone getLastTrackedMilestone()
    {
        return lastTrackedMilestone;
    }

    public MerlinId getMerlinId()
    {
        return merlinId;
    }

    public com.xfinity.playerlib.model.MerlinId.Namespace getMerlinIdNamespace()
    {
        return merlinId.getNamespace();
    }

    public MerlinId getParentMerlinIdIfApplicable()
    {
        return parentMerlinId;
    }

    public int getSeasonNumber()
    {
        return seasonNumber;
    }

    public long getVideoId()
    {
        return videoId;
    }

    public boolean isMovie()
    {
        return getMerlinId().getNamespace() == com.xfinity.playerlib.model.MerlinId.Namespace.Movie;
    }

    public void setLastTrackedMilestone(VideoMilestone videomilestone)
    {
        lastTrackedMilestone = videomilestone;
    }

    public String toString()
    {
        return (new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)).append("bookmarkId", getId()).append("parentMerlinId", parentMerlinId).append("position", position).append("duration", duration).append("categories", categories).append("program type", merlinId.getNamespace()).append("expirationDate", expirationDate).append("season number", seasonNumber).append("episode number", episodeNumber).append("timestamp", timestamp).append("lastTrackedMilestone", lastTrackedMilestone).toString();
    }

    public boolean updateLegacyNonEpisodeBookmarkWithConsumable(VideoFacade videofacade)
    {
        boolean flag = false;
        if (videofacade.getProgramId() != merlinId)
        {
            merlinId = videofacade.getProgramId();
            flag = true;
        }
        if (getCompanyId() != videofacade.getNetworkInfo().getCompanyId())
        {
            companyId = videofacade.getNetworkInfo().getCompanyId();
            flag = true;
        }
        return flag;
    }

    public boolean updateWithConsumable(VideoFacade videofacade, Watchable watchable)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            watchable = watchable.getTitle();
            if ((title != null || watchable == null) && (title == null || watchable != null))
            {
                flag = flag1;
                if (title == null)
                {
                    break label0;
                }
                flag = flag1;
                if (title.equals(watchable))
                {
                    break label0;
                }
            }
            title = watchable;
            flag = true;
        }
        boolean flag2;
label1:
        {
            watchable = videofacade.getExpirationDate();
            if ((expirationDate != null || watchable == null) && (expirationDate == null || watchable != null))
            {
                flag2 = flag;
                if (expirationDate == null)
                {
                    break label1;
                }
                flag2 = flag;
                if (expirationDate.equals(watchable))
                {
                    break label1;
                }
            }
            expirationDate = videofacade.getExpirationDate();
            flag2 = true;
        }
        int i = videofacade.getDurationInSeconds();
        if (duration == -1)
        {
            duration = i * 1000;
            flag2 = true;
        }
        if (companyId != videofacade.getNetworkInfo().getCompanyId())
        {
            companyId = videofacade.getNetworkInfo().getCompanyId();
            flag2 = true;
        }
        return flag2;
    }

}
