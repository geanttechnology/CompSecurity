// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import android.text.Html;
import com.gotv.crackle.Application;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.model.ChannelItem;
import com.gotv.crackle.model.FolderItem;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.model.MediaListItem;
import com.gotv.crackle.model.PlayListItem;
import com.gotv.crackle.util.DateTimeFormatter;
import com.gotv.crackle.util.StringUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.gotv.crackle.data:
//            DataRequest, VideoDubSubtitleProcessor, Localization, ChannelFolderList, 
//            ChannelDetails

public class DetailsProvider extends DataRequest
    implements DataRequest.DataRequestListener
{
    public static final class DetailsType extends Enum
    {

        private static final DetailsType $VALUES[];
        public static final DetailsType Episode;
        public static final DetailsType Movie;
        public static final DetailsType Pending;
        public static final DetailsType Show;
        public static final DetailsType Watchlist;

        public static DetailsType valueOf(String s)
        {
            return (DetailsType)Enum.valueOf(com/gotv/crackle/data/DetailsProvider$DetailsType, s);
        }

        public static DetailsType[] values()
        {
            return (DetailsType[])$VALUES.clone();
        }

        static 
        {
            Pending = new DetailsType("Pending", 0);
            Movie = new DetailsType("Movie", 1);
            Show = new DetailsType("Show", 2);
            Episode = new DetailsType("Episode", 3);
            Watchlist = new DetailsType("Watchlist", 4);
            $VALUES = (new DetailsType[] {
                Pending, Movie, Show, Episode, Watchlist
            });
        }

        private DetailsType(String s, int i)
        {
            super(s, i);
        }
    }

    public class Playlist
    {

        public List mediaItemsList;
        public String name;
        final DetailsProvider this$0;

        public Playlist()
        {
            this$0 = DetailsProvider.this;
            super();
            name = null;
            mediaItemsList = new ArrayList();
        }
    }


    public static final String TAG = "DetailsProvider";
    private List mAllMediaItems;
    private String mAudio;
    private String mCast;
    private ChannelDetails mChannelDetails;
    private ChannelFolderList mChannelFolderList;
    private String mChannelId;
    private DataRequest.DataRequestListener mDataRequestListener;
    private String mDescription;
    private DetailsType mDetailsType;
    private String mDirectors;
    private String mDuration;
    private String mDurationInSeconds;
    private String mEpisode;
    private String mExpires;
    private String mGenres;
    private String mLargeThumbnailUrl;
    private List mMPMNumbersList;
    private MediaDetailsItem mMediaDetailsItem;
    private String mMediaId;
    private String mMediaType;
    private String mPermaLink;
    private List mPlayLists;
    private String mRating;
    private String mRootChannel;
    private String mRootChannelID;
    private String mSeason;
    private String mShowName;
    private Integer mStarRating;
    private String mSubtitles;
    private String mThumbnailUrl;
    private String mTitle;
    private VideoDubSubtitleProcessor mVideoDubSubtitleProcessor;
    private String mWhyItCrackles;
    private String mWriters;

    public DetailsProvider()
    {
        mDetailsType = DetailsType.Pending;
        mMPMNumbersList = new ArrayList();
        mMediaDetailsItem = null;
        mTitle = null;
        mShowName = null;
        mStarRating = null;
        mDescription = null;
        mExpires = null;
        mRating = null;
        mDuration = null;
        mDurationInSeconds = null;
        mGenres = null;
        mCast = null;
        mDirectors = null;
        mWriters = null;
        mWhyItCrackles = null;
        mSeason = null;
        mEpisode = null;
        mSubtitles = null;
        mAudio = null;
        mThumbnailUrl = null;
        mLargeThumbnailUrl = null;
        mMediaType = null;
        mRootChannelID = null;
        mPermaLink = null;
        mRootChannel = null;
        mPlayLists = new ArrayList();
        mAllMediaItems = new ArrayList();
    }

    private void fillInWithChannelDetails(ChannelItem channelitem)
    {
        setTitle(channelitem.getName());
        setDescription(channelitem.getDescription());
        setRating(channelitem.getRating());
        setGenres(channelitem.getGenre());
        setRootChannelID(channelitem.getRrootChannelID());
        setRootChannel(channelitem.getRootChannel());
        if (channelitem.getStarring() != null)
        {
            setCast(Html.fromHtml(channelitem.getStarring()).toString().trim());
        }
        if (channelitem.getDirector() != null && channelitem.getDirector().compareTo("") != 0)
        {
            setDirectors(StringUtil.removeHtmlFromString(channelitem.getDirector()).trim());
        }
        if (mDetailsType == DetailsType.Watchlist)
        {
            setWhyItCrackles(StringUtil.removeHtmlFromString(channelitem.getDescription()).trim());
        } else
        {
            setWhyItCrackles(StringUtil.removeHtmlFromString(channelitem.getWhyItCrackles()).trim());
        }
        mThumbnailUrl = channelitem.getChannelArt_185_277();
        mLargeThumbnailUrl = channelitem.getThumbnailLarge();
    }

    private void fillInWithMediaDetails(VideoDubSubtitleProcessor videodubsubtitleprocessor)
    {
        MediaDetailsItem mediadetailsitem;
        mediadetailsitem = videodubsubtitleprocessor.getCurrentItem();
        setMediaDetailsItem(mediadetailsitem);
        setTitle(mediadetailsitem.getTitle());
        setDescription(mediadetailsitem.getDescription());
        setStarRating(mediadetailsitem.getUserRating());
        Date date = mediadetailsitem.getRightsExpirationDate();
        if (date == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.add(5, 90);
        if ((new Date(calendar.getTimeInMillis())).after(date))
        {
            String s;
            if (!Application.getInstance().getLocalization().isLatinAmericaUI())
            {
                s = "MMM d, yyyy";
            } else
            {
                s = "d MMM, yyyy";
            }
            try
            {
                setExpires(DateTimeFormatter.stringWithDateFormat(date, s));
            }
            catch (Exception exception) { }
        }
        setRating(mediadetailsitem.getRating());
        if (mediadetailsitem.getDuration() != null && mediadetailsitem.getDuration().compareTo("") != 0)
        {
            setDuration(DateTimeFormatter.getHourMinuteString(mediadetailsitem.getDuration()));
        }
        setGenres(mediadetailsitem.getGenre());
        setCast(mediadetailsitem.getCast());
        if (mediadetailsitem.getDirectors() != null && mediadetailsitem.getDirectors().compareTo("") != 0)
        {
            setDirectors(StringUtil.removeHtmlFromString(mediadetailsitem.getDirectors()).trim());
        }
        setWriters(mediadetailsitem.getWriters());
        setWhyItCrackles(StringUtil.removeHtmlFromString(mediadetailsitem.getWhyItCrackles()).trim());
        setSeason(mediadetailsitem.getSeason());
        setEpisode(mediadetailsitem.getEpisode());
        setShowName(mediadetailsitem.getShowName());
        mThumbnailUrl = mediadetailsitem.getThumbnailOneSheet185x277();
        mLargeThumbnailUrl = mediadetailsitem.getThumbnail_854x480();
        if (videodubsubtitleprocessor.getDubbedItem() != null)
        {
            mAudio = videodubsubtitleprocessor.getDubbedItem().getLocalizedLanguage();
        }
        if (videodubsubtitleprocessor.getSubbedItem() != null)
        {
            if (mAudio == null)
            {
                mAudio = "";
            } else
            {
                mAudio = (new StringBuilder()).append(mAudio).append(", ").toString();
            }
            mAudio = (new StringBuilder()).append(mAudio).append(videodubsubtitleprocessor.getSubbedItem().getLocalizedLanguage()).toString();
            videodubsubtitleprocessor = videodubsubtitleprocessor.getSubbedItem().getClosedCaptionFiles().keySet().iterator();
            while (videodubsubtitleprocessor.hasNext()) 
            {
                s = (String)videodubsubtitleprocessor.next();
                if (mSubtitles == null)
                {
                    mSubtitles = "";
                } else
                {
                    mSubtitles = (new StringBuilder()).append(mSubtitles).append(", ").toString();
                }
                mSubtitles = (new StringBuilder()).append(mSubtitles).append(s).toString();
            }
        }
        setDurationInSeconds(mediadetailsitem.getDurationInSeconds());
        setMediaType(mediadetailsitem.getMediaType());
        setRootChannelID(mediadetailsitem.getRootChannelID());
        setPermaLink(mediadetailsitem.getPermaLink());
        return;
    }

    private boolean isWatchComplete(double d, double d1)
    {
        return d > 0.10000000000000001D * d1 + d1;
    }

    private void setCast(String s)
    {
        mCast = s;
    }

    private void setDescription(String s)
    {
        mDescription = s;
    }

    private void setDirectors(String s)
    {
        mDirectors = s;
    }

    private void setDuration(String s)
    {
        mDuration = s;
    }

    private void setDurationInSeconds(String s)
    {
        mDurationInSeconds = s;
    }

    private void setEpisode(String s)
    {
        mEpisode = s;
    }

    private void setExpires(String s)
    {
        mExpires = s;
    }

    private void setGenres(String s)
    {
        mGenres = s;
    }

    private void setMediaDetailsItem(MediaDetailsItem mediadetailsitem)
    {
        mMediaDetailsItem = mediadetailsitem;
    }

    private void setMediaType(String s)
    {
        mMediaType = s;
    }

    private void setPermaLink(String s)
    {
        mPermaLink = s;
    }

    private void setRating(String s)
    {
        mRating = s;
    }

    private void setRootChannelID(String s)
    {
        mRootChannelID = s;
    }

    private void setSeason(String s)
    {
        mSeason = s;
    }

    private void setShowName(String s)
    {
        mShowName = s;
    }

    private void setStarRating(Integer integer)
    {
        mStarRating = integer;
    }

    private void setTitle(String s)
    {
        mTitle = s;
    }

    private void setWhyItCrackles(String s)
    {
        mWhyItCrackles = s;
    }

    private void setWriters(String s)
    {
        mWriters = s;
    }

    public void fillInPlayLists(ChannelFolderList channelfolderlist)
    {
label0:
        {
            for (channelfolderlist = channelfolderlist.getItems().iterator(); channelfolderlist.hasNext();)
            {
                Iterator iterator = ((FolderItem)channelfolderlist.next()).getPlayLists().iterator();
                while (iterator.hasNext()) 
                {
                    Object obj = (PlayListItem)iterator.next();
                    if (((PlayListItem) (obj)).isLockedToChannel().booleanValue())
                    {
                        Playlist playlist = new Playlist();
                        playlist.name = ((PlayListItem) (obj)).getName();
                        obj = ((PlayListItem) (obj)).getMediaList().iterator();
                        do
                        {
                            if (!((Iterator) (obj)).hasNext())
                            {
                                break;
                            }
                            MediaListItem medialistitem1 = (MediaListItem)((Iterator) (obj)).next();
                            if (!mMPMNumbersList.contains(medialistitem1.getMPMNumber()))
                            {
                                playlist.mediaItemsList.add(medialistitem1);
                                mMPMNumbersList.add(medialistitem1.getMPMNumber());
                            }
                        } while (true);
                        if (playlist.mediaItemsList.size() > 0)
                        {
                            mPlayLists.add(playlist);
                        }
                        mAllMediaItems.addAll(playlist.mediaItemsList);
                    }
                }
            }

            if (mPlayLists.size() <= 0)
            {
                break label0;
            }
            boolean flag = false;
            mMediaId = ((MediaListItem)((Playlist)mPlayLists.get(0)).mediaItemsList.get(0)).getID();
            channelfolderlist = mPlayLists.iterator();
            do
            {
                if (!channelfolderlist.hasNext())
                {
                    break;
                }
                Iterator iterator1 = ((Playlist)channelfolderlist.next()).mediaItemsList.iterator();
                int i = ((flag) ? 1 : 0);
                do
                {
                    flag = i;
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    MediaListItem medialistitem = (MediaListItem)iterator1.next();
                    flag = i;
                    if (i == true)
                    {
                        flag = false;
                        mMediaId = medialistitem.getID();
                    }
                    int j = SharedPrefsManager.getPlayProgressForItem(medialistitem.getID());
                    long l = SharedPrefsManager.getProgressTimestampForItem(medialistitem.getID()).longValue();
                    i = ((flag) ? 1 : 0);
                    if (l > 0L)
                    {
                        i = ((flag) ? 1 : 0);
                        if (l > 0L)
                        {
                            i = medialistitem.getDurationInSeconds().intValue();
                            if (isWatchComplete(j, i * 1000))
                            {
                                i = 1;
                            } else
                            {
                                mMediaId = medialistitem.getID();
                                i = ((flag) ? 1 : 0);
                            }
                        }
                    }
                } while (true);
            } while (true);
            if (flag)
            {
                mMediaId = ((MediaListItem)((Playlist)mPlayLists.get(0)).mediaItemsList.get(0)).getID();
            }
        }
    }

    public String getAudio()
    {
        return mAudio;
    }

    public String getCast()
    {
        return mCast;
    }

    public String getChannelId()
    {
        return mChannelId;
    }

    public void getDataWithChannelId(DataRequest.DataRequestListener datarequestlistener, String s)
    {
        if (mState != DataRequest.RequestState.RUNNING)
        {
            mState = DataRequest.RequestState.RUNNING;
            mChannelId = s;
            mDataRequestListener = datarequestlistener;
            mChannelDetails = new ChannelDetails(this, s);
            mChannelFolderList = new ChannelFolderList(this, s);
        }
    }

    public void getDataWithMediaId(DataRequest.DataRequestListener datarequestlistener, String s)
    {
        if (mState != DataRequest.RequestState.RUNNING)
        {
            mState = DataRequest.RequestState.RUNNING;
            mMediaId = s;
            mDataRequestListener = datarequestlistener;
            mVideoDubSubtitleProcessor = new VideoDubSubtitleProcessor();
            mVideoDubSubtitleProcessor.getData(this, mMediaId);
        }
    }

    public String getDescription()
    {
        return mDescription;
    }

    public DetailsType getDetailsType()
    {
        return mDetailsType;
    }

    public String getDirectors()
    {
        return mDirectors;
    }

    public String getDuration()
    {
        return mDuration;
    }

    public String getDurationInSeconds()
    {
        return mDurationInSeconds;
    }

    public String getEpisode()
    {
        return mEpisode;
    }

    public String getExpires()
    {
        return mExpires;
    }

    public String getGenres()
    {
        return mGenres;
    }

    public String getLargeThumbnailUrl()
    {
        return mLargeThumbnailUrl;
    }

    public MediaDetailsItem getMediaDetailsItem()
    {
        return mMediaDetailsItem;
    }

    public String getMediaId()
    {
        return mMediaId;
    }

    public String getMediaType()
    {
        return mMediaType;
    }

    public String getNextMediaIdAfter(String s)
    {
        if (mAllMediaItems != null)
        {
            boolean flag = false;
            Iterator iterator = mAllMediaItems.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                MediaListItem medialistitem = (MediaListItem)iterator.next();
                if (flag)
                {
                    return medialistitem.getID();
                }
                if (medialistitem.getID().equals(s))
                {
                    flag = true;
                }
            } while (true);
        }
        return null;
    }

    public String getPermaLink()
    {
        return mPermaLink;
    }

    public List getPlaylists()
    {
        return mPlayLists;
    }

    public String getRating()
    {
        return mRating;
    }

    public String getRootChannel()
    {
        return mRootChannel;
    }

    public String getRootChannelID()
    {
        return mRootChannelID;
    }

    public String getSeason()
    {
        return mSeason;
    }

    public String getShowName()
    {
        return mShowName;
    }

    public Integer getStarRating()
    {
        return mStarRating;
    }

    public String getSubtitles()
    {
        return mSubtitles;
    }

    public String getThumbnailUrl()
    {
        return mThumbnailUrl;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public String getWhyItCrackles()
    {
        return mWhyItCrackles;
    }

    public String getWriters()
    {
        return mWriters;
    }

    public void onDataFailed(String s, String s1)
    {
        mState = DataRequest.RequestState.FAILED;
        mDataRequestListener.onDataFailed("DetailsProvider", s1);
    }

    public void onDataSuccess(String s)
    {
        if (s.compareTo("ChannelDetails") == 0 || s.compareTo("ChannelFolderList") == 0)
        {
            break MISSING_BLOCK_LABEL_20;
        }
          goto _L1
_L6:
        do
        {
            return;
        } while (mChannelDetails == null || mChannelFolderList == null || mChannelDetails.getRequestState() != DataRequest.RequestState.COMPLETE || mChannelFolderList.getRequestState() != DataRequest.RequestState.COMPLETE);
        s = mChannelDetails.getItem().getRrootChannelID();
        if (!s.equalsIgnoreCase("82")) goto _L3; else goto _L2
_L2:
        mDetailsType = DetailsType.Movie;
        mMediaId = ((MediaListItem)((PlayListItem)((FolderItem)mChannelFolderList.getItems().get(0)).getPlayLists().get(0)).getMediaList().get(0)).getID();
        mVideoDubSubtitleProcessor = new VideoDubSubtitleProcessor();
        mVideoDubSubtitleProcessor.getData(this, mMediaId);
_L4:
        fillInWithChannelDetails(mChannelDetails.getItem());
        return;
_L3:
        if (s.equalsIgnoreCase("46") || s.equalsIgnoreCase("114"))
        {
            mDetailsType = DetailsType.Show;
            fillInPlayLists(mChannelFolderList);
            mState = DataRequest.RequestState.COMPLETE;
            mDataRequestListener.onDataSuccess("DetailsProvider");
        } else
        if (s.equalsIgnoreCase("586"))
        {
            mDetailsType = DetailsType.Watchlist;
            fillInPlayLists(mChannelFolderList);
            mState = DataRequest.RequestState.COMPLETE;
            mDataRequestListener.onDataSuccess("DetailsProvider");
        }
        if (true) goto _L4; else goto _L1
_L1:
        if (!s.equalsIgnoreCase("VideoDubSubtitleProcessor")) goto _L6; else goto _L5
_L5:
        fillInWithMediaDetails(mVideoDubSubtitleProcessor);
        s = mVideoDubSubtitleProcessor.getCurrentItem().getRootChannelID();
        if (!s.equalsIgnoreCase("82")) goto _L8; else goto _L7
_L7:
        mDetailsType = DetailsType.Movie;
_L10:
        mState = DataRequest.RequestState.COMPLETE;
        mDataRequestListener.onDataSuccess("DetailsProvider");
        return;
_L8:
        if (s.equalsIgnoreCase("46") || s.equalsIgnoreCase("114"))
        {
            mDetailsType = DetailsType.Episode;
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void setRootChannel(String s)
    {
        mRootChannel = s;
    }
}
