// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.gotv.crackle.adapters.ExpandListAdapter;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.DetailsProvider;
import com.gotv.crackle.data.QueueManager;
import com.gotv.crackle.fragments.EpisodeDetailsButtonsFragment;
import com.gotv.crackle.fragments.MovieDetailsButtonsFragment;
import com.gotv.crackle.fragments.MovieDetailsThumbnailFragment;
import com.gotv.crackle.fragments.SeasonEpisodeFragment;
import com.gotv.crackle.fragments.ShowDetailsButtonsFragment;
import com.gotv.crackle.fragments.WatchlistDetailsTitleFragment;
import com.gotv.crackle.fragments.WatchlistDetailsWhyCracklesFragment;
import com.gotv.crackle.model.MediaListItem;
import com.gotv.crackle.util.OmnitureWrapper;
import com.gotv.crackle.views.ThreeLayout;
import com.sessionm.api.SessionM;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.gotv.crackle:
//            BaseMediaDetailsActivity, Application, ApplicationConstants

public class ShowWatchlistDetailsActivity extends BaseMediaDetailsActivity
    implements com.gotv.crackle.fragments.ShowDetailsThumbnailFragment.ShowDetailsThumbnailListener, com.gotv.crackle.fragments.ShowDetailsButtonsFragment.ShowDetailsButtonListener, com.gotv.crackle.fragments.SeasonEpisodeFragment.ShowDetailsSeasonEpisodeListener, com.gotv.crackle.fragments.EpisodeDetailsButtonsFragment.EpisodeDetailsButtonListener, com.gotv.crackle.fragments.MovieDetailsThumbnailFragment.MovieDetailsThumbnailListener, com.gotv.crackle.fragments.MovieDetailsButtonsFragment.MovieDetailsButtonListener
{
    private static final class CurrentScreen extends Enum
    {

        private static final CurrentScreen $VALUES[];
        public static final CurrentScreen CHANNEL;
        public static final CurrentScreen MEDIA;
        public static final CurrentScreen PLAYLIST;

        public static CurrentScreen valueOf(String s)
        {
            return (CurrentScreen)Enum.valueOf(com/gotv/crackle/ShowWatchlistDetailsActivity$CurrentScreen, s);
        }

        public static CurrentScreen[] values()
        {
            return (CurrentScreen[])$VALUES.clone();
        }

        static 
        {
            CHANNEL = new CurrentScreen("CHANNEL", 0);
            PLAYLIST = new CurrentScreen("PLAYLIST", 1);
            MEDIA = new CurrentScreen("MEDIA", 2);
            $VALUES = (new CurrentScreen[] {
                CHANNEL, PLAYLIST, MEDIA
            });
        }

        private CurrentScreen(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String SAVE_CURRENT_SCREEN = "saveCurrentScreen";
    private static final String SAVE_IS_SHOW = "saveIsShow";
    private static final String SAVE_MEDIA_ID = "saveMediaID";
    private CurrentScreen mCurrentScreen;
    private View mEpisodeDetailsGroup;
    private DetailsProvider mEpisodeDetailsProvider;
    private ExpandListAdapter mExpandListAdapter;
    private boolean mIsBrowseEpisodeClicked;
    private boolean mIsShowScreen;
    private MovieDetailsButtonsFragment mMovieButtonsFrag;
    private View mMovieDetailsGroup;
    private ProgressDialog mProgDialog;
    private String mRestoreMediaID;
    private String mSaveMediaID;
    private SeasonEpisodeFragment mSeasonEpisodeFrag;
    private View mSeasonEpisodeGroup;
    private ShowDetailsButtonsFragment mShowDetailsButtonsFrag;
    private View mShowDetailsGroup;
    private ThreeLayout mThreeLayout;
    private TextView mVideosText;

    public ShowWatchlistDetailsActivity()
    {
        mIsShowScreen = true;
        mIsBrowseEpisodeClicked = false;
        mCurrentScreen = CurrentScreen.CHANNEL;
    }

    private void displayRightLayout()
    {
        if (Application.getInstance().isLandscape())
        {
            mThreeLayout.setRightLayoutVisibility(true);
        }
        if (mIsBrowseEpisodeClicked)
        {
            mSeasonEpisodeFrag.expandList(0);
            mExpandListAdapter.setSelectedId(((MediaListItem)((com.gotv.crackle.data.DetailsProvider.Playlist)mDetailsProvider.getPlaylists().get(0)).mediaItemsList.get(0)).getID());
            mExpandListAdapter.notifyDataSetChanged();
            mIsBrowseEpisodeClicked = false;
        } else
        if (mRestoreMediaID != null)
        {
            mSeasonEpisodeFrag.expandList(0);
            mExpandListAdapter.setSelectedId(mRestoreMediaID);
            mExpandListAdapter.notifyDataSetChanged();
            mRestoreMediaID = null;
            return;
        }
    }

    private void fillDetailsWhyCracklesData(int i, DetailsProvider detailsprovider)
    {
        ((WatchlistDetailsWhyCracklesFragment)getSupportFragmentManager().findFragmentById(i)).setWatchlistDetailsWhyCrackles(detailsprovider.getWhyItCrackles());
    }

    private void fillMovieData()
    {
        MovieDetailsThumbnailFragment moviedetailsthumbnailfragment = (MovieDetailsThumbnailFragment)getSupportFragmentManager().findFragmentById(0x7f0a01ab);
        if (moviedetailsthumbnailfragment != null)
        {
            moviedetailsthumbnailfragment.setThumbnail(mEpisodeDetailsProvider.getThumbnailUrl(), mImageLoader, mImageOptions);
            moviedetailsthumbnailfragment.setProgress(mEpisodeDetailsProvider.getMediaId(), mEpisodeDetailsProvider.getDurationInSeconds());
        }
        fillDetailsWhyCracklesData(0x7f0a01ae, mEpisodeDetailsProvider);
        fillMediaDetailsTitleData(0x7f0a01ac, mEpisodeDetailsProvider);
        fillMediaDetailsMoreInfoData(0x7f0a01af, mEpisodeDetailsProvider);
    }

    private void fillShowChannelData()
    {
        fillChannelThumbnail(mDetailsProvider);
        if (mSeasonEpisodeFrag != null)
        {
            mExpandListAdapter = new ExpandListAdapter(this, mDetailsProvider);
            mSeasonEpisodeFrag.setPlaylistAdapter(mExpandListAdapter);
        }
        int j = 0;
        for (int i = 0; i < mDetailsProvider.getPlaylists().size(); i++)
        {
            j += ((com.gotv.crackle.data.DetailsProvider.Playlist)mDetailsProvider.getPlaylists().get(i)).mediaItemsList.size();
        }

        mVideosText.setText(getResources().getQuantityString(0x7f0e0002, j, new Object[] {
            Integer.valueOf(j)
        }));
    }

    private void fillWatchlistChannelData()
    {
        if (mDetailsProvider != null && mDetailsProvider.getTitle() != null)
        {
            Application.getInstance().getOmnitureTracker().watchlistRecommendedTitle(mDetailsProvider.getTitle());
            mLoadingProgress.setVisibility(4);
            fillChannelThumbnail(mDetailsProvider);
            WatchlistDetailsTitleFragment watchlistdetailstitlefragment = (WatchlistDetailsTitleFragment)getSupportFragmentManager().findFragmentById(0x7f0a01a6);
            if (watchlistdetailstitlefragment != null)
            {
                watchlistdetailstitlefragment.setWatchlistDetailsTitle(mDetailsProvider.getTitle());
                fillDetailsWhyCracklesData(0x7f0a01a7, mDetailsProvider);
                mExpandListAdapter = new ExpandListAdapter(this, mDetailsProvider);
                mSeasonEpisodeFrag.setPlaylistAdapter(mExpandListAdapter);
            }
        }
    }

    private void getEpisodeData(String s)
    {
        mProgDialog = ProgressDialog.show(this, "", "Loading...", true, false);
        if (getFullQueueManager() != null)
        {
            getFullQueueManager().getWatchList();
        }
        mEpisodeDetailsProvider = new DetailsProvider();
        mEpisodeDetailsProvider.getDataWithMediaId(new com.gotv.crackle.data.DataRequest.DataRequestListener() {

            final ShowWatchlistDetailsActivity this$0;

            public void onDataFailed(String s1, String s2)
            {
                onMediaDataFailed(s1, s2);
            }

            public void onDataSuccess(String s1)
            {
                onMediaDataSuccess();
            }

            
            {
                this$0 = ShowWatchlistDetailsActivity.this;
                super();
            }
        }, s);
    }

    private void updateEpisodeButtonsMediaId(String s)
    {
        EpisodeDetailsButtonsFragment episodedetailsbuttonsfragment = (EpisodeDetailsButtonsFragment)getSupportFragmentManager().findFragmentById(0x7f0a0174);
        if (mCategory.equalsIgnoreCase("watchlists"))
        {
            mMovieButtonsFrag = (MovieDetailsButtonsFragment)getSupportFragmentManager().findFragmentById(0x7f0a01ad);
        }
        boolean flag1 = false;
        boolean flag = flag1;
        if (getFullQueueManager() != null)
        {
            flag = flag1;
            if (getFullQueueManager().getIDsList() != null)
            {
                flag = flag1;
                if (getFullQueueManager().getIDsList().contains(s))
                {
                    flag = true;
                }
            }
        }
        if (episodedetailsbuttonsfragment != null)
        {
            episodedetailsbuttonsfragment.setAddToWatchlistButtonState(flag);
        }
        if (mMovieButtonsFrag != null)
        {
            mMovieButtonsFrag.setAddToWatchlistButtonState(flag);
        }
    }

    private void updateMediaButtonsMediaId(String s)
    {
        EpisodeDetailsButtonsFragment episodedetailsbuttonsfragment = (EpisodeDetailsButtonsFragment)getSupportFragmentManager().findFragmentById(0x7f0a0174);
        MovieDetailsButtonsFragment moviedetailsbuttonsfragment = (MovieDetailsButtonsFragment)getSupportFragmentManager().findFragmentById(0x7f0a01ad);
        boolean flag1 = false;
        boolean flag = flag1;
        if (getFullQueueManager() != null)
        {
            flag = flag1;
            if (getFullQueueManager().getIDsList() != null)
            {
                flag = flag1;
                if (getFullQueueManager().getIDsList().contains(s))
                {
                    flag = true;
                }
            }
        }
        if (episodedetailsbuttonsfragment != null)
        {
            episodedetailsbuttonsfragment.setAddToWatchlistButtonState(flag);
        }
        if (moviedetailsbuttonsfragment != null)
        {
            moviedetailsbuttonsfragment.setAddToWatchlistButtonState(flag);
        }
    }

    public String getSectionName()
    {
        return ApplicationConstants.getFreeWheelShowsSiteSection();
    }

    protected void initViews()
    {
        super.initViews();
        mSeasonEpisodeFrag = (SeasonEpisodeFragment)getSupportFragmentManager().findFragmentById(0x7f0a0171);
        if (Application.getInstance().isTablet() && Application.getInstance().isLandscape())
        {
            mSeasonEpisodeFrag.displayPlaylistGradient();
        }
        mShowDetailsGroup = findViewById(0x7f0a016b);
        mEpisodeDetailsGroup = findViewById(0x7f0a0172);
        if (Application.getInstance().isTablet() && Application.getInstance().isLandscape())
        {
            mThreeLayout = (ThreeLayout)findViewById(0x7f0a0176);
            mThreeLayout.setAnimationDuration(500L);
        }
        if (mCategory.equalsIgnoreCase("shows"))
        {
            mVideosText = (TextView)findViewById(0x7f0a017f);
        } else
        if (mCategory.equalsIgnoreCase("watchlists"))
        {
            mMovieDetailsGroup = findViewById(0x7f0a01a8);
            mShowDetailsButtonsFrag = (ShowDetailsButtonsFragment)getSupportFragmentManager().findFragmentById(0x7f0a016e);
            mShowDetailsButtonsFrag.setBrowseTitle(getResources().getString(0x7f0b010b));
            mShowDetailsButtonsFrag.setAddWatchlistOnTitle(getResources().getString(0x7f0b0105));
            mShowDetailsButtonsFrag.setAddWatchlistOffTitle(getResources().getString(0x7f0b0104));
            return;
        }
    }

    public void onBackPressed()
    {
        if (!mIsShowScreen)
        {
            onShowInfoClick();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onBrowseEpisodesClick()
    {
label0:
        {
            if (mDetailsProvider.getRequestState() == com.gotv.crackle.data.DataRequest.RequestState.COMPLETE)
            {
                mSeasonEpisodeGroup = findViewById(0x7f0a0170);
                setActionBarTitle((new StringBuilder()).append(" ").append(mDetailsProvider.getTitle()).toString());
                if (mSeasonEpisodeGroup == null || mSeasonEpisodeGroup.getVisibility() != 4 && mSeasonEpisodeGroup.getVisibility() != 8)
                {
                    break label0;
                }
                mShowDetailsGroup.setVisibility(4);
                mSeasonEpisodeGroup.setVisibility(0);
                mCurrentScreen = CurrentScreen.PLAYLIST;
            }
            return;
        }
        mIsBrowseEpisodeClicked = true;
        mSaveMediaID = ((MediaListItem)((com.gotv.crackle.data.DetailsProvider.Playlist)mDetailsProvider.getPlaylists().get(0)).mediaItemsList.get(0)).getID();
        getEpisodeData(mSaveMediaID);
        if (Application.getInstance().isLandscape())
        {
            mThreeLayout.startLeftAnimation();
            mSeasonEpisodeFrag.hidePlaylistGradient();
        } else
        {
            mEpisodeDetailsGroup.setVisibility(0);
            mShowDetailsGroup.setVisibility(4);
        }
        mIsShowScreen = false;
        supportInvalidateOptionsMenu();
    }

    protected void onChannelDataSuccess()
    {
        if (mDetailsProvider.getDetailsType() == com.gotv.crackle.data.DetailsProvider.DetailsType.Show)
        {
            runOnUiThread(new Runnable() {

                final ShowWatchlistDetailsActivity this$0;

                public void run()
                {
                    fillData();
                    fillShowChannelData();
                    if (mRestoreMediaID == null) goto _L2; else goto _L1
_L1:
                    if (!Application.getInstance().isTablet()) goto _L4; else goto _L3
_L3:
                    onEpisodeClicked(mRestoreMediaID);
_L6:
                    return;
_L4:
                    if (mCurrentScreen == CurrentScreen.PLAYLIST)
                    {
                        onBrowseEpisodesClick();
                        return;
                    }
                    if (mCurrentScreen == CurrentScreen.MEDIA)
                    {
                        onBrowseEpisodesClick();
                        onEpisodeClicked(mRestoreMediaID);
                        return;
                    }
                    continue; /* Loop/switch isn't completed */
_L2:
                    if (mMediaID != null)
                    {
                        if (!Application.getInstance().isTablet())
                        {
                            onBrowseEpisodesClick();
                        }
                        onEpisodeClicked(mMediaID);
                        return;
                    }
                    if (true) goto _L6; else goto _L5
_L5:
                }

            
            {
                this$0 = ShowWatchlistDetailsActivity.this;
                super();
            }
            });
        } else
        if (mDetailsProvider.getDetailsType() == com.gotv.crackle.data.DetailsProvider.DetailsType.Watchlist)
        {
            runOnUiThread(new Runnable() {

                final ShowWatchlistDetailsActivity this$0;

                public void run()
                {
                    fillWatchlistChannelData();
                    if (mRestoreMediaID != null)
                    {
                        if (Application.getInstance().isTablet())
                        {
                            onEpisodeClicked(mRestoreMediaID);
                        } else
                        {
                            if (mCurrentScreen == CurrentScreen.PLAYLIST)
                            {
                                onBrowseEpisodesClick();
                                return;
                            }
                            if (mCurrentScreen == CurrentScreen.MEDIA)
                            {
                                onBrowseEpisodesClick();
                                onEpisodeClicked(mRestoreMediaID);
                                return;
                            }
                        }
                    }
                }

            
            {
                this$0 = ShowWatchlistDetailsActivity.this;
                super();
            }
            });
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            if (Application.getInstance().isTablet())
            {
                mIsShowScreen = bundle.getBoolean("saveIsShow");
                mRestoreMediaID = bundle.getString("saveMediaID");
            } else
            {
                mCurrentScreen = CurrentScreen.valueOf(bundle.getString("saveCurrentScreen"));
                if (mCurrentScreen == CurrentScreen.MEDIA)
                {
                    mRestoreMediaID = bundle.getString("saveMediaID");
                } else
                {
                    mRestoreMediaID = "";
                }
            }
        }
        getIntentExtras();
        if (!mCategory.equalsIgnoreCase("shows")) goto _L2; else goto _L1
_L1:
        setContentView(0x7f03006c);
_L4:
        initViews();
        return;
_L2:
        if (mCategory.equalsIgnoreCase("watchlists"))
        {
            setContentView(0x7f03007e);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onDataFailed(String s, String s1)
    {
        super.onDataFailed(s, s1);
    }

    public void onDataSuccess(String s)
    {
        super.onDataSuccess(s);
        if (s.equalsIgnoreCase("FULL_WATCHLIST"))
        {
            runOnUiThread(new Runnable() {

                final ShowWatchlistDetailsActivity this$0;

                public void run()
                {
                    if (mChannelID != null)
                    {
                        ShowDetailsButtonsFragment showdetailsbuttonsfragment = (ShowDetailsButtonsFragment)getSupportFragmentManager().findFragmentById(0x7f0a016e);
                        if (showdetailsbuttonsfragment != null)
                        {
                            boolean flag1 = false;
                            boolean flag = flag1;
                            if (getFullQueueManager() != null)
                            {
                                flag = flag1;
                                if (getFullQueueManager().getIDsList() != null)
                                {
                                    flag = flag1;
                                    if (getFullQueueManager().getIDsList().contains(mChannelID))
                                    {
                                        flag = true;
                                    }
                                }
                            }
                            showdetailsbuttonsfragment.setAddToWatchlistButtonState(flag);
                        }
                    }
                    if (mEpisodeDetailsProvider != null && mEpisodeDetailsProvider.getMediaId() != null)
                    {
                        updateEpisodeButtonsMediaId(mEpisodeDetailsProvider.getMediaId());
                    }
                }

            
            {
                this$0 = ShowWatchlistDetailsActivity.this;
                super();
            }
            });
            super.onDataSuccess(s);
        }
    }

    public void onEpisodeAddToWatchlistCheckChanged(boolean flag)
    {
        EpisodeDetailsButtonsFragment episodedetailsbuttonsfragment;
        boolean flag2;
        episodedetailsbuttonsfragment = (EpisodeDetailsButtonsFragment)getSupportFragmentManager().findFragmentById(0x7f0a0174);
        flag2 = false;
        if (CrackleAccountManager.getUserID() == null) goto _L2; else goto _L1
_L1:
        if (getFullQueueManager() == null) goto _L4; else goto _L3
_L3:
        if (mEpisodeDetailsProvider == null) goto _L6; else goto _L5
_L5:
        String s = mEpisodeDetailsProvider.getMediaId();
        if (!flag) goto _L8; else goto _L7
_L7:
        boolean flag1;
        flag1 = flag2;
        if (s != null)
        {
            SessionM.getInstance().logAction("addToMyQueue");
            getFullQueueManager().addMediaToWatchlist(s);
            flag1 = flag2;
        }
_L10:
        if (episodedetailsbuttonsfragment != null && flag1)
        {
            episodedetailsbuttonsfragment.setAddToWatchlistButtonState(false);
        }
        return;
_L8:
        flag1 = flag2;
        if (s != null)
        {
            getFullQueueManager().removeMediaFromWatchlist(s);
            flag1 = flag2;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        flag1 = true;
        continue; /* Loop/switch isn't completed */
_L4:
        flag1 = true;
        continue; /* Loop/switch isn't completed */
_L2:
        showDialogFragment(0xa7b54);
        flag1 = true;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void onEpisodeClicked(MediaListItem medialistitem)
    {
        onEpisodeClicked(medialistitem.getID());
    }

    public void onEpisodeClicked(String s)
    {
label0:
        {
            if (mEpisodeDetailsGroup != null && (mEpisodeDetailsGroup instanceof ScrollView))
            {
                ((ScrollView)mEpisodeDetailsGroup).fullScroll(33);
            }
            mExpandListAdapter.setSelectedId(s);
            mExpandListAdapter.notifyDataSetChanged();
            if (mDetailsProvider == null)
            {
                break label0;
            }
            int i = 0;
            Iterator iterator = mDetailsProvider.getPlaylists().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.gotv.crackle.data.DetailsProvider.Playlist playlist = (com.gotv.crackle.data.DetailsProvider.Playlist)iterator.next();
                Iterator iterator1 = playlist.mediaItemsList.iterator();
                int j = i;
                do
                {
                    i = j;
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    if (((MediaListItem)iterator1.next()).getID().equalsIgnoreCase(s))
                    {
                        j = mDetailsProvider.getPlaylists().indexOf(playlist);
                    }
                } while (true);
            } while (true);
            mSeasonEpisodeFrag.expandList(i);
        }
        mSaveMediaID = s;
        getEpisodeData(s);
        if (Application.getInstance().isTablet())
        {
            if (Application.getInstance().isLandscape())
            {
                if (mIsShowScreen)
                {
                    mThreeLayout.startLeftAnimation();
                    mThreeLayout.setRightLayoutVisibility(false);
                    mSeasonEpisodeFrag.hidePlaylistGradient();
                }
            } else
            {
                mEpisodeDetailsGroup.setVisibility(0);
                mShowDetailsGroup.setVisibility(4);
            }
        } else
        {
            mSeasonEpisodeGroup.setVisibility(8);
        }
        mCurrentScreen = CurrentScreen.MEDIA;
        setActionBarTitle((new StringBuilder()).append(" ").append(mDetailsProvider.getTitle()).toString());
        mIsShowScreen = false;
        supportInvalidateOptionsMenu();
        mProgDialog.show();
    }

    public void onEpisodeDetailsWatchNowClick()
    {
        playMediaItem(mEpisodeDetailsProvider.getMediaId());
    }

    protected void onMediaDataFailed(String s, String s1)
    {
        onDataFailed(s, s1);
    }

    protected void onMediaDataSuccess()
    {
        if (mEpisodeDetailsProvider != null)
        {
            mCurrentDetailsProvider = mEpisodeDetailsProvider;
            runOnUiThread(new Runnable() {

                final ShowWatchlistDetailsActivity this$0;

                public void run()
                {
                    if (mCategory.equalsIgnoreCase("shows"))
                    {
                        if (mEpisodeDetailsProvider.getDetailsType() == com.gotv.crackle.data.DetailsProvider.DetailsType.Episode)
                        {
                            if (Application.getInstance().isTablet())
                            {
                                displayRightLayout();
                            } else
                            {
                                mEpisodeDetailsGroup.setVisibility(0);
                                mSeasonEpisodeGroup.setVisibility(8);
                                mRestoreMediaID = null;
                            }
                            updateEpisodeButtonsMediaId(mEpisodeDetailsProvider.getMediaId());
                            fillMediaDetailsTitleData(0x7f0a0173, mEpisodeDetailsProvider);
                            fillMediaDetailsMoreInfoData(0x7f0a0175, mEpisodeDetailsProvider);
                            mProgDialog.dismiss();
                        }
                    } else
                    if (mCategory.equalsIgnoreCase("watchlists"))
                    {
                        if (mEpisodeDetailsProvider.getDetailsType() == com.gotv.crackle.data.DetailsProvider.DetailsType.Episode)
                        {
                            mEpisodeDetailsGroup.setVisibility(0);
                            mMovieDetailsGroup.setVisibility(4);
                            updateMediaButtonsMediaId(mEpisodeDetailsProvider.getMediaId());
                            fillMediaDetailsTitleData(0x7f0a0173, mEpisodeDetailsProvider);
                            fillMediaDetailsMoreInfoData(0x7f0a0175, mEpisodeDetailsProvider);
                        } else
                        {
                            mEpisodeDetailsGroup.setVisibility(4);
                            mMovieDetailsGroup.setVisibility(0);
                            updateMediaButtonsMediaId(mEpisodeDetailsProvider.getMediaId());
                            fillMovieData();
                        }
                        if (Application.getInstance().isTablet())
                        {
                            displayRightLayout();
                        } else
                        {
                            mSeasonEpisodeGroup.setVisibility(8);
                            mRestoreMediaID = null;
                        }
                        mProgDialog.dismiss();
                        return;
                    }
                }

            
            {
                this$0 = ShowWatchlistDetailsActivity.this;
                super();
            }
            });
        }
    }

    public void onMovieAddToWatchlistCheckChanged(boolean flag)
    {
        onEpisodeAddToWatchlistCheckChanged(flag);
    }

    public void onMovieDetailsPlayClick()
    {
        playMediaItem(mEpisodeDetailsProvider.getMediaId());
    }

    public void onMovieDetailsWatchNowClick()
    {
        playMediaItem(mEpisodeDetailsProvider.getMediaId());
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        MenuItem menuitem;
        MenuItem menuitem1;
        MenuItem menuitem2;
        menuitem = menu.findItem(0x7f0a01c5);
        menuitem1 = menu.findItem(0x7f0a01c4);
        menuitem2 = menu.findItem(0x7f0a01c3);
        if (!mIsShowScreen) goto _L2; else goto _L1
_L1:
        if (menuitem != null)
        {
            menuitem.setVisible(false);
        }
        if (menuitem1 != null)
        {
            menuitem1.setVisible(false);
        }
        if (menuitem2 != null)
        {
            menuitem2.setVisible(false);
        }
_L4:
        super.onPrepareOptionsMenu(menu);
        return true;
_L2:
        if (menuitem != null)
        {
            if (!Application.getInstance().isTablet())
            {
                MenuItemCompat.setShowAsAction(menuitem, 0);
            }
            menuitem.setVisible(true);
        }
        if (menuitem1 != null)
        {
            menuitem1.setVisible(true);
        }
        if (menuitem2 != null)
        {
            menuitem2.setVisible(true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onResume()
    {
        if (mExpandListAdapter != null)
        {
            mExpandListAdapter.notifyDataSetChanged();
        }
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (!Application.getInstance().isLandscape())
        {
            bundle.putBoolean("saveIsShow", mIsShowScreen);
        } else
        {
            bundle.putBoolean("saveIsShow", true);
        }
        bundle.putString("saveMediaID", mSaveMediaID);
        bundle.putString("saveCurrentScreen", mCurrentScreen.toString());
    }

    public void onShowDetailsAddToWatchlistCheckChanged(boolean flag)
    {
        ShowDetailsButtonsFragment showdetailsbuttonsfragment = (ShowDetailsButtonsFragment)getSupportFragmentManager().findFragmentById(0x7f0a016e);
        boolean flag1 = false;
        if (CrackleAccountManager.getUserID() != null)
        {
            if (getFullQueueManager() != null || mChannelID != null)
            {
                if (flag)
                {
                    SessionM.getInstance().logAction("addToMyQueue");
                    getFullQueueManager().addChannelToWatchlsit(mChannelID);
                } else
                {
                    getFullQueueManager().removeChannelFromWatchlist(mChannelID);
                }
            } else
            {
                flag1 = true;
            }
        } else
        {
            showDialogFragment(0xa7b54);
            flag1 = true;
        }
        if (showdetailsbuttonsfragment != null && flag1)
        {
            showdetailsbuttonsfragment.setAddToWatchlistButtonState(false);
        }
    }

    public void onShowDetailsPlayClick()
    {
        playMediaItem(mDetailsProvider.getMediaId());
    }

    public void onShowDetailsWatchNowClick()
    {
        playMediaItem(mDetailsProvider.getMediaId());
    }

    public void onShowInfoClick()
    {
        if (Application.getInstance().isTablet())
        {
            if (Application.getInstance().isLandscape())
            {
                mThreeLayout.startRightAnimation();
                mSeasonEpisodeFrag.displayPlaylistGradient();
            } else
            {
                mEpisodeDetailsGroup.setVisibility(4);
                mShowDetailsGroup.setVisibility(0);
                if (mMovieDetailsGroup != null)
                {
                    mMovieDetailsGroup.setVisibility(4);
                }
            }
        } else
        {
            mShowDetailsGroup.setVisibility(0);
            mEpisodeDetailsGroup.setVisibility(8);
            if (mMovieDetailsGroup != null)
            {
                mMovieDetailsGroup.setVisibility(4);
            }
            mCurrentScreen = CurrentScreen.CHANNEL;
        }
        if (mCategory.equalsIgnoreCase("shows"))
        {
            setActionBarTitle((new StringBuilder()).append(" ").append(getResources().getString(0x7f0b0095)).toString());
        } else
        if (mCategory.equalsIgnoreCase("watchlists"))
        {
            setActionBarTitle((new StringBuilder()).append(" ").append(getResources().getString(0x7f0b0096)).toString());
        }
        mIsShowScreen = true;
        mSaveMediaID = null;
        supportInvalidateOptionsMenu();
    }

    protected void performMenuAction(int i)
    {
        if (i == 0x102002c && !mIsShowScreen)
        {
            onShowInfoClick();
            return;
        } else
        {
            super.performMenuAction(i);
            return;
        }
    }





/*
    static String access$102(ShowWatchlistDetailsActivity showwatchlistdetailsactivity, String s)
    {
        showwatchlistdetailsactivity.mRestoreMediaID = s;
        return s;
    }

*/










}
