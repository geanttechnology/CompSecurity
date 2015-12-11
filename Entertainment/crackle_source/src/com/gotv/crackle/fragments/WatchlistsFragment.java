// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.freewheel.ad.AdFetcher;
import com.freewheel.ad.IAdHolder;
import com.gotv.crackle.Application;
import com.gotv.crackle.ApplicationConstants;
import com.gotv.crackle.DetailsActivityResolver;
import com.gotv.crackle.MainActivity;
import com.gotv.crackle.adapters.BrowseGridAdapter;
import com.gotv.crackle.adapters.BrowseGridViewAdapter;
import com.gotv.crackle.adapters.BrowseItemListAdapter;
import com.gotv.crackle.adapters.MyWatchlistItemListAdapter;
import com.gotv.crackle.data.BrowseAPI;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.QueueManager;
import com.gotv.crackle.dialogs.MainDialogFragment;
import com.gotv.crackle.model.BrowseModel;
import com.gotv.crackle.util.OmnitureWrapper;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import java.util.Iterator;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.ISlot;

public class WatchlistsFragment extends Fragment
    implements com.gotv.crackle.data.DataRequest.DataRequestListener, IAdHolder, com.gotv.crackle.base.BaseActivity.SignInListener
{

    public static final int VIEW_STYLE_GRID = 0;
    public static final int VIEW_STYLE_LIST = 1;
    public static int sCurrentViewStyle;
    private static boolean sMyOrRecommended;
    private IAdContext adContext;
    private AdFetcher adFetcher;
    private RelativeLayout mAdContainer;
    private BrowseAPI mBrowseRequest;
    private ActionBarActivity mFa;
    private android.view.View.OnFocusChangeListener mFocusChangedListener;
    private GridView mGridView;
    private android.view.View.OnClickListener mItemClickListener;
    private android.widget.AdapterView.OnItemSelectedListener mItemSelectedListener;
    protected View mLastAnimatedView;
    private ListView mListView;
    private View mListViewHeader;
    private ProgressBar mLoadingProgress;
    private Button mMyWatchListButton;
    private android.widget.AdapterView.OnItemClickListener mOnItemClickListener;
    private android.view.View.OnClickListener mPlayItemListener;
    private QueueManager mQueueManager;
    private Button mRecommendedWatchListButton;

    public WatchlistsFragment()
    {
        mOnItemClickListener = new android.widget.AdapterView.OnItemClickListener() {

            final WatchlistsFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                view.setTag((BrowseModel)adapterview.getItemAtPosition(i));
                launchMediaDetails(view, false);
            }

            
            {
                this$0 = WatchlistsFragment.this;
                super();
            }
        };
        mItemClickListener = new android.view.View.OnClickListener() {

            final WatchlistsFragment this$0;

            public void onClick(View view)
            {
                launchMediaDetails(view, false);
            }

            
            {
                this$0 = WatchlistsFragment.this;
                super();
            }
        };
        mPlayItemListener = new android.view.View.OnClickListener() {

            final WatchlistsFragment this$0;

            public void onClick(View view)
            {
                launchMediaDetails(view, true);
            }

            
            {
                this$0 = WatchlistsFragment.this;
                super();
            }
        };
        mItemSelectedListener = new android.widget.AdapterView.OnItemSelectedListener() {

            final WatchlistsFragment this$0;

            public void onItemSelected(AdapterView adapterview, View view, int i, long l)
            {
                if (view != null)
                {
                    view.startAnimation(AnimationUtils.loadAnimation(mFa, 0x7f040006));
                }
                if (mLastAnimatedView != null && mLastAnimatedView != view)
                {
                    mLastAnimatedView.startAnimation(AnimationUtils.loadAnimation(mFa, 0x7f040007));
                }
                mLastAnimatedView = view;
            }

            public void onNothingSelected(AdapterView adapterview)
            {
                if (mLastAnimatedView != null)
                {
                    mLastAnimatedView.startAnimation(AnimationUtils.loadAnimation(mFa, 0x7f040007));
                }
            }

            
            {
                this$0 = WatchlistsFragment.this;
                super();
            }
        };
        mFocusChangedListener = new android.view.View.OnFocusChangeListener() {

            final WatchlistsFragment this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (mLastAnimatedView != null && !flag)
                {
                    mLastAnimatedView.startAnimation(AnimationUtils.loadAnimation(mFa, 0x7f040007));
                }
            }

            
            {
                this$0 = WatchlistsFragment.this;
                super();
            }
        };
    }

    private void fetchRecWatchlistData()
    {
        Application.getInstance().getOmnitureTracker().recommendedWatchlists();
        mLoadingProgress.setVisibility(0);
        mListViewHeader.findViewById(0x7f0a0075).setVisibility(8);
        mBrowseRequest = new BrowseAPI(this, "collections", "all", "all", "date");
    }

    private void switchMode()
    {
        ((MainActivity)mFa).mImageLoader.clearMemoryCache();
        if (mQueueManager == null) goto _L2; else goto _L1
_L1:
        mMyWatchListButton.setBackgroundResource(0x7f020130);
        mRecommendedWatchListButton.setBackgroundResource(0x7f020131);
        mMyWatchListButton.setTextColor(0x7f070018);
        mRecommendedWatchListButton.setTextColor(0xff777777);
        if (sCurrentViewStyle != 0) goto _L4; else goto _L3
_L3:
        if (mListView == null) goto _L6; else goto _L5
_L5:
        mListView.setBackgroundColor(getResources().getColor(0x7f070027));
        if (!sMyOrRecommended) goto _L8; else goto _L7
_L7:
        mListView.setAdapter(new BrowseGridAdapter((MainActivity)mFa, mQueueManager.getItems(), mItemClickListener, com.gotv.crackle.base.BaseActivity.AppSection.WATCHLISTS, null));
_L10:
        return;
_L8:
        if (Application.getInstance().isTablet())
        {
            mListView.setAdapter(new BrowseGridAdapter((MainActivity)mFa, mQueueManager.getItems(), mItemClickListener, com.gotv.crackle.base.BaseActivity.AppSection.WATCHLISTS, null));
            return;
        } else
        {
            mListView.setBackgroundColor(mFa.getResources().getColor(0x7f07001b));
            mListView.setAdapter(new MyWatchlistItemListAdapter((MainActivity)mFa, mQueueManager.getItems(), mItemClickListener, mPlayItemListener));
            return;
        }
_L6:
        if (mGridView != null)
        {
            mGridView.setAdapter(new BrowseGridViewAdapter((MainActivity)mFa, mQueueManager.getItems(), com.gotv.crackle.base.BaseActivity.AppSection.WATCHLISTS));
            mGridView.setOnItemClickListener(mOnItemClickListener);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        mListView.setBackgroundColor(getResources().getColor(0x7f070028));
        mListViewHeader.setVisibility(0);
        mListView.setAdapter(new BrowseItemListAdapter((MainActivity)mFa, mQueueManager.getItems(), mItemClickListener, mPlayItemListener, com.gotv.crackle.base.BaseActivity.AppSection.WATCHLISTS));
        return;
_L2:
        if (mBrowseRequest != null)
        {
            mMyWatchListButton.setBackgroundResource(0x7f020131);
            mRecommendedWatchListButton.setBackgroundResource(0x7f020130);
            mMyWatchListButton.setTextColor(0xff777777);
            mRecommendedWatchListButton.setTextColor(0x7f070018);
            if (sCurrentViewStyle == 0)
            {
                if (mListView != null)
                {
                    mListView.setBackgroundColor(getResources().getColor(0x7f070027));
                    BrowseGridAdapter browsegridadapter = new BrowseGridAdapter((MainActivity)mFa, mBrowseRequest.getItems(), mItemClickListener, com.gotv.crackle.base.BaseActivity.AppSection.WATCHLISTS, null);
                    browsegridadapter.setIsRecommendedWatchlist(true);
                    mListView.setAdapter(browsegridadapter);
                    return;
                }
                if (mGridView != null)
                {
                    BrowseGridViewAdapter browsegridviewadapter = new BrowseGridViewAdapter((MainActivity)mFa, mBrowseRequest.getItems(), com.gotv.crackle.base.BaseActivity.AppSection.WATCHLISTS);
                    browsegridviewadapter.setIsRecommendedWatchlist(true);
                    mGridView.setAdapter(browsegridviewadapter);
                    mGridView.setOnItemClickListener(mOnItemClickListener);
                    return;
                }
            } else
            {
                mListView.setBackgroundColor(getResources().getColor(0x7f070028));
                mListViewHeader.setVisibility(0);
                mListView.setAdapter(new BrowseItemListAdapter((MainActivity)mFa, mBrowseRequest.getItems(), mItemClickListener, mPlayItemListener, com.gotv.crackle.base.BaseActivity.AppSection.WATCHLISTS));
                return;
            }
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    private void switchType()
    {
        ((MainActivity)mFa).mImageLoader.clearMemoryCache();
        if (mListView != null)
        {
            mListView.setAdapter(null);
        } else
        if (mGridView != null)
        {
            mGridView.setAdapter(null);
        }
        mQueueManager = null;
        mBrowseRequest = null;
        if (!sMyOrRecommended)
        {
            String s = CrackleAccountManager.getUserID();
            if (s != null)
            {
                Application.getInstance().getOmnitureTracker().myWatchlists();
                mLoadingProgress.setVisibility(0);
                mListViewHeader.findViewById(0x7f0a0075).setVisibility(0);
                mQueueManager = new QueueManager(this, s);
                mQueueManager.getWatchList();
                return;
            } else
            {
                ((MainActivity)mFa).removeDialogFragment(0xa7b54);
                MainDialogFragment maindialogfragment = MainDialogFragment.newInstance(0xa7b54);
                maindialogfragment.show(((MainActivity)mFa).getSupportFragmentManager(), "dialog686932");
                maindialogfragment.setOnCancelledListener(new android.content.DialogInterface.OnCancelListener() {

                    final WatchlistsFragment this$0;

                    public void onCancel(DialogInterface dialoginterface)
                    {
                        WatchlistsFragment.sMyOrRecommended = true;
                        switchType();
                    }

            
            {
                this$0 = WatchlistsFragment.this;
                super();
            }
                });
                return;
            }
        } else
        {
            fetchRecWatchlistData();
            return;
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

    public void displayGridView()
    {
        mListViewHeader.setVisibility(8);
        sCurrentViewStyle = 0;
        switchMode();
    }

    public void displayListView()
    {
        mListViewHeader.setVisibility(0);
        sCurrentViewStyle = 1;
        switchMode();
    }

    public void displayRecWatchlist()
    {
        if (mListView == null) goto _L2; else goto _L1
_L1:
        mListView.setAdapter(null);
_L4:
        mQueueManager = null;
        mBrowseRequest = null;
        fetchRecWatchlistData();
        return;
_L2:
        if (mGridView != null)
        {
            mGridView.setAdapter(null);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected boolean enableAds()
    {
        return true;
    }

    public void getAd()
    {
        adFetcher = new AdFetcher(this);
        adFetcher.loadAd(getSectionName());
    }

    public Activity getBaseActivity()
    {
        return getActivity();
    }

    public String getSectionName()
    {
        return ApplicationConstants.getFreeWheelWatchSiteSection();
    }

    public String getVideoAssetId()
    {
        return null;
    }

    public int getVideoDurationInSec()
    {
        return 0;
    }

    public String getVideoTitle()
    {
        return null;
    }

    protected void launchMediaDetails(View view, boolean flag)
    {
        view = (BrowseModel)view.getTag();
        Intent intent = new Intent((MainActivity)mFa, com/gotv/crackle/DetailsActivityResolver);
        if (view.getItemType().equalsIgnoreCase("Channel"))
        {
            intent.putExtra("ID", view.getID());
        } else
        {
            intent.putExtra("MEDIA_ITEM_ID", view.getID());
        }
        if (flag)
        {
            intent.putExtra("START_PLAYING", true);
        }
        intent.putExtra("ROOT_CHANNEL", view.getRootChannel());
        startActivity(intent);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        ((MainActivity)mFa).setSignInListener(this);
        if (!Application.isLeanBack())
        {
            mListView = (ListView)mFa.findViewById(0x7f0a0069);
        } else
        {
            mGridView = (GridView)mFa.findViewById(0x7f0a006e);
            mGridView.setOnItemSelectedListener(mItemSelectedListener);
            mGridView.setOnFocusChangeListener(mFocusChangedListener);
        }
        mLoadingProgress = (ProgressBar)mFa.findViewById(0x7f0a0063);
        if (CrackleAccountManager.getUserID() == null)
        {
            sMyOrRecommended = true;
        }
        mFa.findViewById(0x7f0a0065).setVisibility(0);
        mMyWatchListButton = (Button)mFa.findViewById(0x7f0a0066);
        mRecommendedWatchListButton = (Button)mFa.findViewById(0x7f0a0067);
        if (Application.isFanhattan())
        {
            mMyWatchListButton.setVisibility(8);
            mRecommendedWatchListButton.setVisibility(8);
        }
        if (Application.getInstance().isTablet())
        {
            mMyWatchListButton.setLayoutParams(new android.widget.LinearLayout.LayoutParams(Application.dpToPx(230), Application.dpToPx(44)));
            mMyWatchListButton.setTextSize(1, 18F);
            mRecommendedWatchListButton.setLayoutParams(new android.widget.LinearLayout.LayoutParams(Application.dpToPx(230), Application.dpToPx(44)));
            mRecommendedWatchListButton.setTextSize(1, 18F);
            ((RelativeLayout)mFa.findViewById(0x7f0a006a)).getLayoutParams().height = Application.dpToPx(90);
        }
        mMyWatchListButton.setOnClickListener(new android.view.View.OnClickListener() {

            final WatchlistsFragment this$0;

            public void onClick(View view)
            {
                WatchlistsFragment.sMyOrRecommended = false;
                switchType();
            }

            
            {
                this$0 = WatchlistsFragment.this;
                super();
            }
        });
        mRecommendedWatchListButton.setOnClickListener(new android.view.View.OnClickListener() {

            final WatchlistsFragment this$0;

            public void onClick(View view)
            {
                WatchlistsFragment.sMyOrRecommended = true;
                switchType();
            }

            
            {
                this$0 = WatchlistsFragment.this;
                super();
            }
        });
        mListViewHeader = mFa.findViewById(0x7f0a0068);
        mListViewHeader.findViewById(0x7f0a0073).setVisibility(8);
        mListViewHeader.findViewById(0x7f0a0074).setVisibility(8);
        mListViewHeader.findViewById(0x7f0a0076).setVisibility(8);
        if (!Application.isLeanBack())
        {
            getAd();
        }
    }

    public void onAdContextCreated(IAdContext iadcontext)
    {
        adContext = iadcontext;
    }

    public void onAdManagerLoadFailed()
    {
    }

    public void onConfigurationChanged()
    {
        ((MainActivity)mFa).mImageLoader.clearMemoryCache();
        switchMode();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        mFa = (ActionBarActivity)super.getActivity();
        if (Application.isLeanBack())
        {
            return layoutinflater.inflate(0x7f03001c, viewgroup, false);
        } else
        {
            return layoutinflater.inflate(0x7f03001b, viewgroup, false);
        }
    }

    public void onDataFailed(String s, final String Message)
    {
        if (getActivity() != null)
        {
            getActivity().runOnUiThread(new Runnable() {

                final WatchlistsFragment this$0;
                final String val$Message;

                public void run()
                {
                    mLoadingProgress.setVisibility(4);
                    try
                    {
                        ((MainActivity)mFa).mNetworkDialog.setMessage(Message);
                        ((MainActivity)mFa).mNetworkDialog.show();
                        return;
                    }
                    catch (Exception exception)
                    {
                        return;
                    }
                }

            
            {
                this$0 = WatchlistsFragment.this;
                Message = s;
                super();
            }
            });
        }
    }

    public void onDataSuccess(String s)
    {
        if (getActivity() != null)
        {
            ((MainActivity)mFa).removeDialogFragment(42340);
            if (s.compareTo("FULL_WATCHLIST") == 0 || s.compareTo("BrowseAPI") == 0)
            {
                getActivity().runOnUiThread(new Runnable() {

                    final WatchlistsFragment this$0;

                    public void run()
                    {
                        mLoadingProgress.setVisibility(4);
                        switchMode();
                    }

            
            {
                this$0 = WatchlistsFragment.this;
                super();
            }
                });
            } else
            if (s.compareTo("GENERAL_QUEUE") == 0)
            {
                getActivity().runOnUiThread(new Runnable() {

                    final WatchlistsFragment this$0;

                    public void run()
                    {
                        switchType();
                    }

            
            {
                this$0 = WatchlistsFragment.this;
                super();
            }
                });
                return;
            }
        }
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onRequestComplete(IEvent ievent)
    {
        if (getActivity() != null)
        {
            try
            {
                mAdContainer = (RelativeLayout)mFa.findViewById(0x7f0a00a3);
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
                        mFa.runOnUiThread(new Runnable() {

                            final WatchlistsFragment this$0;
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
                this$0 = WatchlistsFragment.this;
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

    public void onResume()
    {
        switchType();
        super.onResume();
    }

    public void onSignInSuccess()
    {
        switchType();
    }


/*
    static boolean access$002(boolean flag)
    {
        sMyOrRecommended = flag;
        return flag;
    }

*/





}
