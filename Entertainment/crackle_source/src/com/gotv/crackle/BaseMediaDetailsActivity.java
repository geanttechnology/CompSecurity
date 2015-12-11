// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.fanhattan.services.contextualmenu.api.ContextualMenu;
import com.fanhattan.services.contextualmenu.api.ContextualMenuItem;
import com.fanhattan.services.contextualmenu.api.ContextualMenuSection;
import com.fanhattan.services.contextualmenu.api.ContextualMenuService;
import com.freewheel.ad.AdFetcher;
import com.freewheel.ad.IAdHolder;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.DetailsProvider;
import com.gotv.crackle.data.QueueManager;
import com.gotv.crackle.fragments.EpisodeDetailsMoreInfoFragment;
import com.gotv.crackle.fragments.EpisodeDetailsTitleFragment;
import com.gotv.crackle.fragments.ShowDetailsThumbnailFragment;
import com.gotv.crackle.helpers.ChromeCastHelper;
import com.gotv.crackle.helpers.MyCrackleViewHelper;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.util.OmnitureWrapper;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.sessionm.api.SessionM;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.ISlot;

// Referenced classes of package com.gotv.crackle:
//            Application, ApplicationConstants, MainActivity, TwitterWebActivity

public class BaseMediaDetailsActivity extends BaseActivity
    implements com.fanhattan.services.contextualmenu.api.ContextualMenuService.ContextualMenuCallback, IAdHolder
{

    public static final String FANHATTAN_MENU_ID_ABOUT = "FAN_ID_ABOUT";
    public static final String FANHATTAN_MENU_ID_SETTINGS = "FAN_ID_SETTINGS";
    protected static final int FOLDERS_DIALOG = 3;
    public static final String MEDIA_ITEM_ID = "MEDIA_ITEM_ID";
    public static final String START_PLAYING_EXTRA = "START_PLAYING";
    private IAdContext adContext;
    private AdFetcher adFetcher;
    protected ActionBar mActionBar;
    protected String mActionBarTitle;
    private RelativeLayout mAdContainer;
    private String mAmazonBuyLink;
    protected MenuItem mBuyItem;
    protected TextView mCastText;
    protected String mCategory;
    protected String mChannelID;
    private ContextualMenuService mContextualMenuService;
    protected DetailsProvider mCurrentDetailsProvider;
    protected TextView mDescriptionText;
    protected DetailsProvider mDetailsProvider;
    protected ScrollView mDetailsScrollView;
    protected TextView mDirectorsText;
    protected TextView mGenresText;
    protected ProgressBar mLoadingProgress;
    protected String mMediaID;
    protected TextView mMoreInfoLabel;
    protected TextView mRatingText;
    protected String mRootChannel;
    protected Dialog mShareDialog;
    protected boolean mStartPlaying;
    protected boolean mSuppressResumePrompt;
    protected ImageView mThumbnailView;
    protected TextView mTitleText;
    protected TextView mWhyCracklesLabel;
    protected TextView mWhyCracklesText;
    protected TextView mWritersText;
    private android.view.View.OnClickListener shareItemClickListener;

    public BaseMediaDetailsActivity()
    {
        shareItemClickListener = new android.view.View.OnClickListener() {

            final BaseMediaDetailsActivity this$0;

            public void onClick(View view)
            {
                if (mCurrentDetailsProvider != null && mCurrentDetailsProvider.getRequestState() == com.gotv.crackle.data.DataRequest.RequestState.COMPLETE)
                {
                    if (view.getId() == 0x7f0a0169)
                    {
                        mShareDialog.hide();
                        postToFacebook(false, mCurrentDetailsProvider.getMediaDetailsItem());
                        Application.getInstance().getOmnitureTracker().onVideoShare("Facebook", mCurrentDetailsProvider.getMediaId(), mCurrentDetailsProvider.getTitle(), mCurrentDetailsProvider.getTitle(), mCurrentDetailsProvider.getRootChannelID(), mCurrentDetailsProvider.getMediaType(), mCurrentDetailsProvider.getSeason(), mCurrentDetailsProvider.getEpisode(), "", "", mCurrentDetailsProvider.getDuration());
                    } else
                    {
                        if (view.getId() == 0x7f0a016a)
                        {
                            mShareDialog.hide();
                            view = new Intent(BaseMediaDetailsActivity.this, com/gotv/crackle/TwitterWebActivity);
                            view.putExtra("share_link", mCurrentDetailsProvider.getPermaLink());
                            view.putExtra("share_title", mCurrentDetailsProvider.getTitle());
                            startActivity(view);
                            Application.getInstance().getOmnitureTracker().onVideoShare("Twitter", mCurrentDetailsProvider.getMediaId(), mCurrentDetailsProvider.getTitle(), mCurrentDetailsProvider.getTitle(), mCurrentDetailsProvider.getRootChannelID(), mCurrentDetailsProvider.getMediaType(), mCurrentDetailsProvider.getSeason(), mCurrentDetailsProvider.getEpisode(), "", "", mCurrentDetailsProvider.getDuration());
                            return;
                        }
                        if (view.getId() == 0x7f0a0165)
                        {
                            try
                            {
                                shareMailClicked(mCurrentDetailsProvider.getMediaDetailsItem());
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            mShareDialog.hide();
                            Application.getInstance().getOmnitureTracker().onVideoShare("Email", mCurrentDetailsProvider.getMediaId(), mCurrentDetailsProvider.getTitle(), mCurrentDetailsProvider.getTitle(), mCurrentDetailsProvider.getRootChannelID(), mCurrentDetailsProvider.getMediaType(), mCurrentDetailsProvider.getSeason(), mCurrentDetailsProvider.getEpisode(), "", "", mCurrentDetailsProvider.getDuration());
                            return;
                        }
                        if (view.getId() == 0x7f0a0167)
                        {
                            mShareDialog.hide();
                            shareSMSClicked(mCurrentDetailsProvider.getMediaDetailsItem());
                            Application.getInstance().getOmnitureTracker().onVideoShare("SMS", mCurrentDetailsProvider.getMediaId(), mCurrentDetailsProvider.getTitle(), mCurrentDetailsProvider.getTitle(), mCurrentDetailsProvider.getRootChannelID(), mCurrentDetailsProvider.getMediaType(), mCurrentDetailsProvider.getSeason(), mCurrentDetailsProvider.getEpisode(), "", "", mCurrentDetailsProvider.getDuration());
                            return;
                        }
                    }
                }
            }

            
            {
                this$0 = BaseMediaDetailsActivity.this;
                super();
            }
        };
    }

    private void getData()
    {
        mLoadingProgress.setVisibility(0);
        fetchChannelData();
    }

    private void setUpAddWatchListButton()
    {
        ToggleButton togglebutton = (ToggleButton)findViewById(0x7f0a0112);
        if (togglebutton != null)
        {
            if (Application.isFanhattan())
            {
                togglebutton.setVisibility(8);
            }
            QueueManager queuemanager = getFullQueueManager();
            togglebutton.setOnCheckedChangeListener(null);
            if (queuemanager != null)
            {
                if (queuemanager.getIDsList() != null)
                {
                    if (queuemanager.getIDsList().contains(mChannelID) || queuemanager.getIDsList().contains(mMediaID))
                    {
                        togglebutton.setChecked(true);
                    } else
                    {
                        togglebutton.setChecked(false);
                    }
                } else
                {
                    togglebutton.setChecked(false);
                }
            } else
            {
                togglebutton.setChecked(false);
            }
            togglebutton.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

                final BaseMediaDetailsActivity this$0;

                public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
                {
                    String s = CrackleAccountManager.getUserID();
                    if (s == null)
                    {
                        break MISSING_BLOCK_LABEL_130;
                    }
                    compoundbutton = new QueueManager(BaseMediaDetailsActivity.this, s);
                    if (!flag) goto _L2; else goto _L1
_L1:
                    if (mChannelID == null) goto _L4; else goto _L3
_L3:
                    SessionM.getInstance().logAction("addToMyQueue");
                    compoundbutton.addChannelToWatchlsit(mChannelID);
_L6:
                    return;
_L4:
                    if (mMediaID == null) goto _L6; else goto _L5
_L5:
                    SessionM.getInstance().logAction("addToMyQueue");
                    compoundbutton.addMediaToWatchlist(mMediaID);
                    return;
_L2:
                    if (mChannelID != null)
                    {
                        compoundbutton.removeChannelFromWatchlist(mChannelID);
                        return;
                    }
                    if (mMediaID == null) goto _L6; else goto _L7
_L7:
                    compoundbutton.removeMediaFromWatchlist(mMediaID);
                    return;
                    compoundbutton.setChecked(false);
                    BaseActivity.showDialogFragment(getSupportFragmentManager(), 0xa7b54);
                    return;
                }

            
            {
                this$0 = BaseMediaDetailsActivity.this;
                super();
            }
            });
        }
    }

    public void beforeSubmitRequest(String s)
    {
        adContext.setSiteSection(s, 0, 0, 0, 0);
        if (Application.getInstance().isTablet())
        {
            adContext.addSiteSectionNonTemporalSlot("BANNER_SLOT", null, 728, 90, null, false, null, null);
            return;
        } else
        {
            adContext.addSiteSectionNonTemporalSlot("BANNER_SLOT", null, 320, 50, null, false, null, null);
            return;
        }
    }

    public ContextualMenu createContextualMenu()
    {
        ContextualMenu contextualmenu = new ContextualMenu(getPackageName());
        ContextualMenuSection contextualmenusection = new ContextualMenuSection(getString(0x7f0b002d));
        contextualmenusection.add(new ContextualMenuItem("FAN_ID_SETTINGS", getString(0x7f0b011a)));
        contextualmenusection.add(new ContextualMenuItem("FAN_ID_ABOUT", getString(0x7f0b006a)));
        contextualmenu.add(contextualmenusection);
        return contextualmenu;
    }

    protected boolean enableAds()
    {
        return true;
    }

    protected void fetchChannelData()
    {
        mDetailsProvider = new DetailsProvider();
        if (mChannelID != null)
        {
            mDetailsProvider.getDataWithChannelId(new com.gotv.crackle.data.DataRequest.DataRequestListener() {

                final BaseMediaDetailsActivity this$0;

                public void onDataFailed(String s, String s1)
                {
                    onChannelDataFailed(s, s1);
                    s = new Intent(BaseMediaDetailsActivity.this, com/gotv/crackle/MainActivity);
                    startActivity(s);
                }

                public void onDataSuccess(String s)
                {
label0:
                    {
                        if (s.equalsIgnoreCase("DetailsProvider"))
                        {
                            mCurrentDetailsProvider = mDetailsProvider;
                            if (mDetailsProvider != null && mDetailsProvider.getDetailsType() == com.gotv.crackle.data.DetailsProvider.DetailsType.Movie)
                            {
                                Application.getInstance().getOmnitureTracker().detailScreenMovie(mDetailsProvider.getTitle());
                            }
                            if (!mStartPlaying || mDetailsProvider.getMediaId() == null || isConnected.isConnected())
                            {
                                break label0;
                            }
                            if (mMediaID != null)
                            {
                                s = mMediaID;
                            } else
                            {
                                s = mDetailsProvider.getMediaId();
                            }
                            playMediaItem(s, new Runnable() {

                                final _cls1 this$1;

                                public void run()
                                {
                                    finish();
                                }

            
            {
                this$1 = _cls1.this;
                super();
            }
                            });
                        }
                        return;
                    }
                    if (!Application.isLeanBack() && !Application.isNookTablet())
                    {
                        runOnUiThread(new Runnable() {

                            final _cls1 this$1;

                            public void run()
                            {
                                if (mDetailsProvider.getMediaDetailsItem() != null && !mDetailsProvider.getMediaDetailsItem().getAmazonLink().isEmpty() && !mDetailsProvider.getMediaDetailsItem().getAmazonLink().equalsIgnoreCase("null") && mBuyItem != null)
                                {
                                    mBuyItem.setVisible(true);
                                    mAmazonBuyLink = mDetailsProvider.getMediaDetailsItem().getAmazonLink();
                                }
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        });
                    }
                    if (!Application.isLeanBack())
                    {
                        runOnUiThread(new Runnable() {

                            final _cls1 this$1;

                            public void run()
                            {
                                getAd();
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        });
                    }
                    onChannelDataSuccess();
                }

            
            {
                this$0 = BaseMediaDetailsActivity.this;
                super();
            }
            }, mChannelID);
            return;
        } else
        {
            finish();
            return;
        }
    }

    protected void fillChannelThumbnail(DetailsProvider detailsprovider)
    {
        ShowDetailsThumbnailFragment showdetailsthumbnailfragment = (ShowDetailsThumbnailFragment)getSupportFragmentManager().findFragmentById(0x7f0a016c);
        if (showdetailsthumbnailfragment != null)
        {
            showdetailsthumbnailfragment.setThumbnail(detailsprovider.getThumbnailUrl(), mImageLoader, mImageOptions);
        }
    }

    protected void fillData()
    {
        mLoadingProgress.setVisibility(4);
        loadThumbnail();
        setUpAddWatchListButton();
        if (mDetailsProvider.getTitle() == null)
        {
            mTitleText.setVisibility(8);
        } else
        {
            if (mDetailsProvider.getDetailsType() == com.gotv.crackle.data.DetailsProvider.DetailsType.Show)
            {
                Application.getInstance().getOmnitureTracker().detailScreenShow(mDetailsProvider.getTitle(), mDetailsProvider.getRootChannel());
            }
            mTitleText.setText(mDetailsProvider.getTitle());
        }
        if (mDetailsProvider.getRating() == null)
        {
            mRatingText.setVisibility(8);
        } else
        if (Application.getInstance().isTablet())
        {
            mRatingText.setText((new StringBuilder()).append(getResources().getString(0x7f0b00a8)).append(" ").append(mDetailsProvider.getRating()).toString());
        } else
        {
            mRatingText.setText(setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b00a8)).append(" ").toString(), mDetailsProvider.getRating()));
        }
        if (mDetailsProvider.getWhyItCrackles() == null)
        {
            mWhyCracklesLabel.setVisibility(8);
            mWhyCracklesText.setVisibility(8);
        } else
        if (Application.getInstance().isTablet())
        {
            mWhyCracklesText.setText(mDetailsProvider.getWhyItCrackles());
        } else
        {
            mWhyCracklesText.setText(setStringColor("", mDetailsProvider.getWhyItCrackles()));
        }
        if (mDetailsProvider.getGenres() == null && mDetailsProvider.getCast() == null && mDetailsProvider.getDirectors() == null && mDetailsProvider.getWriters() == null && mDetailsProvider.getDescription() == null)
        {
            mMoreInfoLabel.setVisibility(8);
            return;
        }
        if (!Application.getInstance().isTablet())
        {
            mMoreInfoLabel.setTextColor(getResources().getColor(0x7f070023));
        }
        if (mDetailsProvider.getGenres() == null)
        {
            mGenresText.setVisibility(8);
        } else
        if (Application.getInstance().isTablet())
        {
            mGenresText.setText((new StringBuilder()).append(getResources().getString(0x7f0b00aa)).append(" ").append(mDetailsProvider.getGenres()).toString());
        } else
        {
            mGenresText.setText(setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b00aa)).append(" ").toString(), mDetailsProvider.getGenres()));
        }
        if (mDetailsProvider.getCast() == null)
        {
            mCastText.setVisibility(8);
        } else
        if (Application.getInstance().isTablet())
        {
            mCastText.setText((new StringBuilder()).append(getResources().getString(0x7f0b00ab)).append(" ").append(mDetailsProvider.getCast()).toString());
        } else
        {
            mCastText.setText(setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b00ab)).append(" ").toString(), mDetailsProvider.getCast()));
        }
        if (mDetailsProvider.getDirectors() == null)
        {
            mDirectorsText.setVisibility(8);
        } else
        if (Application.getInstance().isTablet())
        {
            mDirectorsText.setText((new StringBuilder()).append(getResources().getString(0x7f0b00ac)).append(" ").append(mDetailsProvider.getDirectors()).toString());
        } else
        {
            mDirectorsText.setText(setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b00ac)).append(" ").toString(), mDetailsProvider.getDirectors()));
        }
        if (mDetailsProvider.getWriters() == null)
        {
            mWritersText.setVisibility(8);
        } else
        if (Application.getInstance().isTablet())
        {
            mWritersText.setText((new StringBuilder()).append(getResources().getString(0x7f0b00ad)).append(" ").append(mDetailsProvider.getWriters()).toString());
        } else
        {
            mWritersText.setText(setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b00ad)).append(" ").toString(), mDetailsProvider.getWriters()));
        }
        if (mDetailsProvider.getDescription() == null)
        {
            mDescriptionText.setVisibility(8);
            return;
        }
        Object obj = null;
        String s = obj;
        if (mCategory != null)
        {
            if (mCategory.equalsIgnoreCase("movies"))
            {
                s = getResources().getString(0x7f0b0108);
            } else
            {
                s = obj;
                if (mCategory.equalsIgnoreCase("shows"))
                {
                    s = getResources().getString(0x7f0b0109);
                }
            }
        }
        if (Application.getInstance().isTablet())
        {
            mDescriptionText.setText((new StringBuilder()).append(s).append(" ").append(mDetailsProvider.getDescription()).toString());
            return;
        } else
        {
            mDescriptionText.setText(setStringColor((new StringBuilder()).append(s).append(" ").toString(), mDetailsProvider.getDescription()));
            return;
        }
    }

    protected void fillMediaDetailsMoreInfoData(int i, DetailsProvider detailsprovider)
    {
        EpisodeDetailsMoreInfoFragment episodedetailsmoreinfofragment;
label0:
        {
            episodedetailsmoreinfofragment = (EpisodeDetailsMoreInfoFragment)getSupportFragmentManager().findFragmentById(i);
            if (episodedetailsmoreinfofragment != null)
            {
                if (detailsprovider.getGenres() != null || detailsprovider.getCast() != null || detailsprovider.getDirectors() != null || detailsprovider.getWriters() != null || detailsprovider.getDescription() != null)
                {
                    break label0;
                }
                episodedetailsmoreinfofragment.hideMoreInfo();
            }
            return;
        }
        episodedetailsmoreinfofragment.setInfoLabelTextColor();
        episodedetailsmoreinfofragment.setEpisodeDetailsGenre(detailsprovider.getGenres());
        episodedetailsmoreinfofragment.setEpisodeDetailsCast(detailsprovider.getCast());
        episodedetailsmoreinfofragment.setEpisodeDetailsDirectors(detailsprovider.getDirectors());
        episodedetailsmoreinfofragment.setEpisodeDetailsWriters(detailsprovider.getWriters());
        episodedetailsmoreinfofragment.setEpisodeDetailsDescription(detailsprovider.getDescription());
    }

    protected void fillMediaDetailsTitleData(int i, DetailsProvider detailsprovider)
    {
        EpisodeDetailsTitleFragment episodedetailstitlefragment = (EpisodeDetailsTitleFragment)getSupportFragmentManager().findFragmentById(i);
        if (episodedetailstitlefragment != null)
        {
            if (detailsprovider.getSeason() == null || detailsprovider.getSeason().equalsIgnoreCase("") || detailsprovider.getEpisode() == null || detailsprovider.getEpisode().equalsIgnoreCase(""))
            {
                episodedetailstitlefragment.setEpisodeDetailsTitle(detailsprovider.getTitle());
            } else
            {
                episodedetailstitlefragment.setEpisodeDetailsTitle((new StringBuilder()).append("S").append(detailsprovider.getSeason()).append(" E").append(detailsprovider.getEpisode()).append(": ").append(detailsprovider.getTitle()).toString());
            }
            episodedetailstitlefragment.setEpisodeDetailsStarRating(detailsprovider.getStarRating());
            episodedetailstitlefragment.setEpisodeDetailsExpires(detailsprovider.getExpires());
            episodedetailstitlefragment.setEpisodeDetailsRating(detailsprovider.getRating());
            episodedetailstitlefragment.setEpisodeDetailsDuration(detailsprovider.getDuration());
            episodedetailstitlefragment.setEpisodeDetailsAudio(detailsprovider.getAudio());
            episodedetailstitlefragment.setEpisodeDetailsSubtitles(detailsprovider.getSubtitles());
        }
    }

    public void getAd()
    {
        adFetcher = new AdFetcher(this);
        adFetcher.loadAd(getSectionName());
    }

    public Activity getBaseActivity()
    {
        return this;
    }

    protected void getIntentExtras()
    {
        Intent intent;
        intent = getIntent();
        mChannelID = intent.getStringExtra("ID");
        mMediaID = intent.getStringExtra("MEDIA_ITEM_ID");
        mCategory = intent.getStringExtra("EXTRA_CATEGORY");
        if (mCategory == null) goto _L2; else goto _L1
_L1:
        if (!mCategory.equalsIgnoreCase("movies")) goto _L4; else goto _L3
_L3:
        mActionBarTitle = (new StringBuilder()).append(" ").append(getResources().getString(0x7f0b0094)).toString();
_L2:
        mStartPlaying = intent.getBooleanExtra("START_PLAYING", false);
        mSuppressResumePrompt = intent.getBooleanExtra("SUPPRESS_RESUME_PROMPT", true);
        if (mChannelID != null) goto _L6; else goto _L5
_L5:
        finish();
_L8:
        return;
_L4:
        if (mCategory.equalsIgnoreCase("shows"))
        {
            mActionBarTitle = (new StringBuilder()).append(" ").append(getResources().getString(0x7f0b0095)).toString();
        } else
        if (mCategory.equalsIgnoreCase("watchlists"))
        {
            mActionBarTitle = (new StringBuilder()).append(" ").append(getResources().getString(0x7f0b0096)).toString();
        }
        continue; /* Loop/switch isn't completed */
_L6:
        mRootChannel = intent.getStringExtra("ROOT_CHANNEL");
        if (mRootChannel != null) goto _L8; else goto _L7
_L7:
        mRootChannel = "";
        return;
        if (true) goto _L2; else goto _L9
_L9:
    }

    public String getSectionName()
    {
        return ApplicationConstants.getFreeWheelMoviesSiteSection();
    }

    public String getVideoAssetId()
    {
        if (mDetailsProvider != null)
        {
            return mDetailsProvider.getChannelId();
        } else
        {
            return null;
        }
    }

    public int getVideoDurationInSec()
    {
        return 0;
    }

    public String getVideoTitle()
    {
        if (mDetailsProvider != null)
        {
            return mDetailsProvider.getTitle();
        } else
        {
            return null;
        }
    }

    protected void initViews()
    {
        mActionBar = getSupportActionBar();
        setActionBarTitle(mActionBarTitle);
        mLoadingProgress = (ProgressBar)findViewById(0x7f0a00a2);
        mThumbnailView = (ImageView)findViewById(0x7f0a0099);
        setMovieThumbnailSize();
        if (mCategory != null && mCategory.equalsIgnoreCase("movies"))
        {
            Object obj = (ImageButton)findViewById(0x7f0a007e);
            if (obj != null)
            {
                ((ImageButton) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                    final BaseMediaDetailsActivity this$0;

                    public void onClick(View view)
                    {
                        playMediaItem(mDetailsProvider.getMediaId());
                    }

            
            {
                this$0 = BaseMediaDetailsActivity.this;
                super();
            }
                });
            }
            obj = (Button)findViewById(0x7f0a00dd);
            if (obj != null)
            {
                ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                    final BaseMediaDetailsActivity this$0;

                    public void onClick(View view)
                    {
                        playMediaItem(mDetailsProvider.getMediaId());
                    }

            
            {
                this$0 = BaseMediaDetailsActivity.this;
                super();
            }
                });
                if (Application.isFanhattan())
                {
                    ((Button) (obj)).setBackgroundResource(0x7f0200c1);
                }
            }
        }
        mTitleText = (TextView)findViewById(0x7f0a0031);
        mRatingText = (TextView)findViewById(0x7f0a0100);
        mWhyCracklesLabel = (TextView)findViewById(0x7f0a0104);
        mWhyCracklesText = (TextView)findViewById(0x7f0a0105);
        mMoreInfoLabel = (TextView)findViewById(0x7f0a00e0);
        mGenresText = (TextView)findViewById(0x7f0a0106);
        mCastText = (TextView)findViewById(0x7f0a0107);
        mDirectorsText = (TextView)findViewById(0x7f0a0108);
        mWritersText = (TextView)findViewById(0x7f0a0109);
        mDescriptionText = (TextView)findViewById(0x7f0a010a);
        mDetailsScrollView = (ScrollView)findViewById(0x7f0a017a);
        if (mDetailsScrollView != null)
        {
            if (Application.isFanhattan())
            {
                mDetailsScrollView.setVerticalScrollBarEnabled(true);
                mDetailsScrollView.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

                    final BaseMediaDetailsActivity this$0;

                    public void onFocusChange(View view, boolean flag)
                    {
                        if (flag)
                        {
                            view.scrollBy(0, 1);
                            view.scrollBy(0, -1);
                        }
                    }

            
            {
                this$0 = BaseMediaDetailsActivity.this;
                super();
            }
                });
            } else
            {
                mDetailsScrollView.setVerticalScrollBarEnabled(false);
            }
        }
        if (Application.getInstance().isTablet())
        {
            mWhyCracklesLabel.setPadding(0, 0, 0, 0);
            mWhyCracklesText.setPadding(0, 0, 0, 0);
            mMoreInfoLabel.setPadding(0, 0, 0, 0);
            try
            {
                mGenresText.setPadding(0, 0, 0, 0);
                mCastText.setPadding(0, 0, 0, 0);
                mDirectorsText.setPadding(0, 0, 0, 0);
                mWritersText.setPadding(0, 0, 0, 0);
                mDescriptionText.setPadding(0, 0, 0, 0);
            }
            catch (Exception exception) { }
        }
        getData();
    }

    protected void loadThumbnail()
    {
        mImageLoader.displayImage(mDetailsProvider.getThumbnailUrl(), mThumbnailView, mImageOptions);
    }

    public void onAdContextCreated(IAdContext iadcontext)
    {
        adContext = iadcontext;
    }

    public void onAdManagerLoadFailed()
    {
    }

    public void onAppSdkEvent(long l, int i, String s)
    {
    }

    protected void onChannelDataFailed(String s, String s1)
    {
        onDataFailed(s, s1);
    }

    protected void onChannelDataSuccess()
    {
    }

    public void onCloseContextualMenu()
    {
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        mImageLoader.clearMemoryCache();
        super.onConfigurationChanged(configuration);
        if (mCategory != null && mCategory.equalsIgnoreCase("movies"))
        {
            setMovieThumbnailSize();
        }
    }

    public boolean onContextualMenuSelected(String s)
    {
        if ("FAN_ID_SETTINGS".equals(s))
        {
            performMenuAction(0x7f0a01b3);
            return true;
        }
        if ("FAN_ID_ABOUT".equals(s))
        {
            performMenuAction(0x7f0a01b6);
            return true;
        } else
        {
            return false;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (Application.isLeanBack())
        {
            mRootView = findViewById(0x1020002);
            mRootView.setPadding(Application.getDisplayIndependantPixelSize(20), mRootView.getPaddingTop(), Application.getDisplayIndependantPixelSize(20), Application.getDisplayIndependantPixelSize(20));
            mRootView.setBackgroundColor(getResources().getColor(0x7f070027));
        }
        if (Application.isFanhattan())
        {
            mContextualMenuService = new ContextualMenuService(this, this);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        if (Application.isLeanBack())
        {
            getMenuInflater().inflate(0x7f0f0005, menu);
        } else
        {
            getMenuInflater().inflate(0x7f0f0004, menu);
        }
        mChromeCastHelper.setupMenuItem(menu);
        return true;
    }

    public void onDataFailed(String s, String s1)
    {
        super.onDataFailed(s, s1);
    }

    public void onDataSuccess(String s)
    {
        if (!s.equalsIgnoreCase("DetailsProvider"))
        {
            if (s.equalsIgnoreCase("FULL_WATCHLIST"))
            {
                runOnUiThread(new Runnable() {

                    final BaseMediaDetailsActivity this$0;

                    public void run()
                    {
                        setUpAddWatchListButton();
                    }

            
            {
                this$0 = BaseMediaDetailsActivity.this;
                super();
            }
                });
            }
            super.onDataSuccess(s);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i = menuitem.getItemId();
        if (i == 0x7f0a01b7)
        {
            sMyCrackleHelper.showSigInOut(this, menuitem);
        } else
        {
            performMenuAction(i);
        }
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        if (Application.isFanhattan())
        {
            mContextualMenuService.onPause();
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        MenuItem menuitem = menu.findItem(0x7f0a01b4);
        if (!MyCrackleViewHelper.isEnableSessionM() && menuitem != null)
        {
            menuitem.setVisible(false);
        }
        menuitem = menu.findItem(0x7f0a01b7);
        MenuItem menuitem1;
        if (menuitem != null)
        {
            if (CrackleAccountManager.isLoggedIn())
            {
                menuitem.setTitle(getResources().getString(0x7f0b0066));
            } else
            {
                menuitem.setTitle(getResources().getString(0x7f0b0065));
            }
        }
        mBuyItem = menu.findItem(0x7f0a01c5);
        menuitem = menu.findItem(0x7f0a01c4);
        menuitem1 = menu.findItem(0x7f0a01c3);
        if (mCategory != null && mCategory.equalsIgnoreCase("movies") && !Application.getInstance().isTablet() && mBuyItem != null)
        {
            MenuItemCompat.setShowAsAction(mBuyItem, 0);
        }
        if (mAmazonBuyLink == null && mBuyItem != null)
        {
            mBuyItem.setVisible(false);
        }
        if (Application.isLeanBack())
        {
            if (menuitem != null)
            {
                menuitem.setVisible(false);
            }
            if (menuitem1 != null)
            {
                menuitem1.setVisible(false);
            }
        }
        menu = menu.findItem(0x7f0a01c2);
        MenuItemCompat.setShowAsAction(menu, 2);
        menu.setVisible(false);
        return true;
    }

    public void onRequestComplete(IEvent ievent)
    {
        if (this != null)
        {
            try
            {
                mAdContainer = (RelativeLayout)findViewById(0x7f0a00a3);
            }
            // Misplaced declaration of an exception variable
            catch (IEvent ievent) { }
            ievent = adContext.getSlotsByTimePositionClass(adContext.getConstants().TIME_POSITION_CLASS_DISPLAY());
            if (ievent.size() >= 1)
            {
                ievent = ievent.iterator();
                while (ievent.hasNext()) 
                {
                    final ISlot slot = (ISlot)ievent.next();
                    if (slot.getCustomId().compareTo("BANNER_SLOT") == 0 && mAdContainer != null)
                    {
                        slot.setParameter("renderer.html.shouldUseDip", "true");
                        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                        layoutparams.addRule(13);
                        final ViewGroup vg = slot.getBase();
                        vg.setLayoutParams(layoutparams);
                        runOnUiThread(new Runnable() {

                            final BaseMediaDetailsActivity this$0;
                            final ISlot val$slot;
                            final ViewGroup val$vg;

                            public void run()
                            {
                                try
                                {
                                    ((ViewGroup)vg.getParent()).removeView(vg);
                                }
                                catch (Exception exception) { }
                                mAdContainer.setVisibility(0);
                                mAdContainer.addView(vg);
                                mAdContainer.requestLayout();
                                slot.play();
                            }

            
            {
                this$0 = BaseMediaDetailsActivity.this;
                vg = viewgroup;
                slot = islot;
                super();
            }
                        });
                    }
                }
            }
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (Application.isFanhattan())
        {
            mContextualMenuService.onResume();
        }
    }

    protected void performMenuAction(int i)
    {
        if (i != 0x102002c) goto _L2; else goto _L1
_L1:
        Intent intent = new Intent(this, com/gotv/crackle/MainActivity);
        intent.addFlags(0x4000000);
        startActivity(intent);
_L4:
        return;
_L2:
        if (i == 0x7f0a01bc)
        {
            sMyCrackleHelper.showHistory(this);
            return;
        }
        if (i == 0x7f0a01b3)
        {
            sMyCrackleHelper.showSettings(this);
            return;
        }
        if (i == 0x7f0a01b4)
        {
            sMyCrackleHelper.showSessionMPortal();
            return;
        }
        if (i == 0x7f0a01b5)
        {
            sMyCrackleHelper.showGiveFeedback(this);
            return;
        }
        if (i == 0x7f0a01b6)
        {
            sMyCrackleHelper.showAboutCrackle(this);
            return;
        }
        if (i != 0x7f0a01c5)
        {
            break; /* Loop/switch isn't completed */
        }
        if (mAmazonBuyLink != null)
        {
            sMyCrackleHelper.showBuy(this, mDetailsProvider.getMediaDetailsItem());
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (i == 0x7f0a01c4)
        {
            Application.getInstance().getOmnitureTracker().onVideoShare("FacebookLike", mDetailsProvider.getMediaId(), mDetailsProvider.getTitle(), mDetailsProvider.getTitle(), mDetailsProvider.getRootChannelID(), mDetailsProvider.getMediaType(), mDetailsProvider.getSeason(), mDetailsProvider.getEpisode(), "", "", mDetailsProvider.getDuration());
            postToFacebook(true, mCurrentDetailsProvider.getMediaDetailsItem());
            return;
        }
        if (i == 0x7f0a01c3)
        {
            Application.getInstance().getOmnitureTracker().onVideoShare("ShareGeneral", mDetailsProvider.getMediaId(), mDetailsProvider.getTitle(), mDetailsProvider.getTitle(), mDetailsProvider.getRootChannelID(), mDetailsProvider.getMediaType(), mDetailsProvider.getSeason(), mDetailsProvider.getEpisode(), "", "", mDetailsProvider.getDuration());
            SessionM.getInstance().presentActivity(com.sessionm.api.SessionM.ActivityType.ACHIEVEMENT);
            showShareDialog();
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    protected void setMovieThumbnailSize()
    {
        int i;
        if (Application.getInstance().isLandscape())
        {
            i = Application.getScreenWidth() / 4;
        } else
        {
            i = Application.getScreenWidth() / 3;
        }
        mThumbnailView.getLayoutParams().width = i;
        mThumbnailView.getLayoutParams().height = Application.getHeightFromAspectRatio(i);
    }

    protected SpannableStringBuilder setStringColor(String s, String s1)
    {
        ForegroundColorSpan foregroundcolorspan = new ForegroundColorSpan(Color.parseColor(getResources().getString(0x7f070023)));
        s = (new StringBuilder()).append(s).append(s1).toString();
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(s);
        spannablestringbuilder.setSpan(foregroundcolorspan, s.indexOf(s1), s.indexOf(s1) + s1.length(), 18);
        return spannablestringbuilder;
    }

    protected void showShareDialog()
    {
        mShareDialog = new Dialog(this);
        mShareDialog.setTitle(0x7f0b00b6);
        mShareDialog.setCanceledOnTouchOutside(true);
        View view = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f03006b, null, false);
        View view1 = view.findViewById(0x7f0a0169);
        View view2 = view.findViewById(0x7f0a016a);
        View view3 = view.findViewById(0x7f0a0165);
        View view4 = view.findViewById(0x7f0a0167);
        if (Application.isNookTablet() || Application.getInstance().isTabletSizedScreen())
        {
            view4.setVisibility(8);
            view.findViewById(0x7f0a0168).setVisibility(8);
        }
        view1.setOnClickListener(shareItemClickListener);
        view2.setOnClickListener(shareItemClickListener);
        view3.setOnClickListener(shareItemClickListener);
        view4.setOnClickListener(shareItemClickListener);
        mShareDialog.setContentView(view);
        mShareDialog.getWindow().setLayout(Application.getDisplayIndependantPixelSize(300), -2);
        mShareDialog.show();
    }



/*
    static String access$102(BaseMediaDetailsActivity basemediadetailsactivity, String s)
    {
        basemediadetailsactivity.mAmazonBuyLink = s;
        return s;
    }

*/


}
