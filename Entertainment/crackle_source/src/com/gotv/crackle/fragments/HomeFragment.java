// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

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
import android.widget.ProgressBar;
import com.freewheel.ad.SlideShowAdRequester;
import com.gotv.crackle.Application;
import com.gotv.crackle.DetailsActivityResolver;
import com.gotv.crackle.MainActivity;
import com.gotv.crackle.MyCrackleSettingsActivity;
import com.gotv.crackle.adapters.BrowseGridAdapter;
import com.gotv.crackle.adapters.HeroPagerAdapter;
import com.gotv.crackle.data.ItemsListRequest;
import com.gotv.crackle.data.Localization;
import com.gotv.crackle.data.MediaDetailsRequest;
import com.gotv.crackle.data.SlideShowList;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.model.BrowseModel;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.model.SlideShowItem;
import com.gotv.crackle.util.OmnitureWrapper;
import com.gotv.crackle.views.CrackleListView;
import com.gotv.crackle.views.HeroViewPager;
import com.gotv.crackle.views.PagerIndicator;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.Calendar;
import java.util.List;

public class HomeFragment extends Fragment
    implements com.gotv.crackle.data.DataRequest.DataRequestListener
{

    protected ItemsListRequest mCrackleRequester;
    private ActionBarActivity mFa;
    private HeroViewPager mFeaturedPager;
    private android.view.View.OnClickListener mItemClickListener;
    private CrackleListView mListView;
    private ProgressBar mLoadingProgress;
    private MediaDetailsRequest mMediaDetailsRequest;
    private PagerIndicator mPagerIndicator;
    private AlertDialog mPushDialog;
    private String mResumeItemId;
    private SlideShowAdRequester mSlideShowAdRequester;
    protected SlideShowList mSlideShowList;

    public HomeFragment()
    {
        mItemClickListener = new android.view.View.OnClickListener() {

            final HomeFragment this$0;

            public void onClick(View view)
            {
                launchMediaDetails(view);
            }

            
            {
                this$0 = HomeFragment.this;
                super();
            }
        };
    }

    private void refreshSlideShow()
    {
        int i = 95;
        if (mSlideShowList.getItems().size() > 2)
        {
            mFeaturedPager.getLayoutParams();
            HeroPagerAdapter heropageradapter = new HeroPagerAdapter(getActivity(), mItemClickListener, mSlideShowList.getItems(), mSlideShowAdRequester.getSlideShowAdSlotMap());
            if (Application.getInstance().isLandscape())
            {
                int j = heropageradapter.getSlideShowItemHeight();
                android.widget.LinearLayout.LayoutParams layoutparams;
                if (!Application.getInstance().isTablet())
                {
                    i = 15;
                }
                i = j + Application.getDisplayIndependantPixelSize(i);
            } else
            {
                int k = heropageradapter.getSlideShowItemHeight();
                if (!Application.getInstance().isTablet())
                {
                    i = 100;
                }
                i = k + Application.getDisplayIndependantPixelSize(i);
            }
            layoutparams = new android.widget.LinearLayout.LayoutParams(-1, i);
            mFeaturedPager.setLayoutParams(layoutparams);
            mPagerIndicator.setNumberOfPages(mSlideShowList.getItems().size());
            mFeaturedPager.setAdapter(heropageradapter);
            mFeaturedPager.setCurrentItem(heropageradapter.getCount() / 2, false);
            mFeaturedPager.setIndicator(mPagerIndicator);
        }
    }

    protected void launchMediaDetails(View view)
    {
        Intent intent;
        intent = new Intent(mFa, com/gotv/crackle/DetailsActivityResolver);
        if (view.getTag() instanceof MediaDetailsItem)
        {
            view = ((MediaDetailsItem)view.getTag()).getID();
            ((MainActivity)mFa).playMediaItem(view);
            return;
        }
        if (!(view.getTag() instanceof BrowseModel)) goto _L2; else goto _L1
_L1:
        intent.putExtra("ID", ((BrowseModel)view.getTag()).getID());
_L4:
        startActivity(intent);
        return;
_L2:
        if (view.getTag() instanceof SlideShowItem)
        {
            int i = mSlideShowList.getItems().indexOf((SlideShowItem)view.getTag());
            Application.getInstance().getOmnitureTracker().slideShowItem(((SlideShowItem)view.getTag()).getTitle(), i);
            String s = ((SlideShowItem)view.getTag()).getAppDataID();
            if (((SlideShowItem)view.getTag()).getAppNextScreenType().equalsIgnoreCase("VideoDetail"))
            {
                intent.putExtra("MEDIA_ITEM_ID", s);
            } else
            {
                intent.putExtra("ID", s);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = (LayoutInflater)mFa.getSystemService("layout_inflater");
        mLoadingProgress = (ProgressBar)mFa.findViewById(0x7f0a00f5);
        mLoadingProgress.setVisibility(0);
        bundle = bundle.inflate(0x7f03004f, null);
        mFeaturedPager = (HeroViewPager)bundle.findViewById(0x7f0a00f8);
        Calendar calendar;
        long l;
        if (Application.isLeanBack())
        {
            int i = Application.getDisplayIndependantPixelSize(2);
            mFeaturedPager.setPadding(i, i, i, i);
            mFeaturedPager.setOnClickListener(new android.view.View.OnClickListener() {

                final HomeFragment this$0;

                public void onClick(View view)
                {
                    int j = mFeaturedPager.getCurrentItem();
                    int k = mSlideShowList.getItems().size();
                    view.setTag((SlideShowItem)mSlideShowList.getItems().get(j % k));
                    launchMediaDetails(view);
                }

            
            {
                this$0 = HomeFragment.this;
                super();
            }
            });
            ((ViewGroup)mFa.findViewById(0x7f0a00f7)).addView(bundle);
        } else
        {
            mListView = (CrackleListView)mFa.findViewById(0x7f0a00f4);
            mListView.addHeaderView(bundle);
        }
        mPagerIndicator = (PagerIndicator)mFa.findViewById(0x7f0a00f9);
        if (SharedPrefsManager.getFirstLaunchTime() == 0L)
        {
            SharedPrefsManager.setFirstLaunchTime(System.currentTimeMillis());
        }
        bundle = Calendar.getInstance();
        bundle.setTimeInMillis(System.currentTimeMillis());
        l = SharedPrefsManager.getFirstLaunchTime();
        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l);
        calendar.add(11, 720);
        if (Application.getInstance().getLocalization().allRequestsComplete() && !SharedPrefsManager.getPushQuestionAsked() && !Application.isNookTablet() && (bundle.after(calendar) || SharedPrefsManager.getNumberOfLaunches() >= 5) && !Application.isLeanBack())
        {
            bundle = new android.app.AlertDialog.Builder(getActivity());
            bundle.setMessage(getResources().getString(0x7f0b00cf));
            bundle.setPositiveButton(getResources().getString(0x7f0b011a), new android.content.DialogInterface.OnClickListener() {

                final HomeFragment this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    SharedPrefsManager.setPushQuestionAsked(true);
                    dialoginterface.dismiss();
                    dialoginterface = new Intent(getActivity(), com/gotv/crackle/MyCrackleSettingsActivity);
                    getActivity().startActivity(dialoginterface);
                }

            
            {
                this$0 = HomeFragment.this;
                super();
            }
            });
            bundle.setNegativeButton(getResources().getString(0x7f0b00ce), new android.content.DialogInterface.OnClickListener() {

                final HomeFragment this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    SharedPrefsManager.setIsPushEnabled(false);
                    SharedPrefsManager.setPushQuestionAsked(true);
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = HomeFragment.this;
                super();
            }
            });
            mPushDialog = bundle.create();
            mPushDialog.show();
            SharedPrefsManager.setPushQuestionAsked(true);
        }
    }

    public void onConfigurationChanged()
    {
        ((MainActivity)mFa).mImageLoader.clearMemoryCache();
        refreshSlideShow();
        updateData();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        mFa = (ActionBarActivity)super.getActivity();
        if (Application.isLeanBack())
        {
            return layoutinflater.inflate(0x7f03004e, viewgroup, false);
        } else
        {
            return layoutinflater.inflate(0x7f03004d, viewgroup, false);
        }
    }

    public void onDataFailed(String s, final String Message)
    {
        if (getActivity() != null && !s.equalsIgnoreCase("MediaDetails"))
        {
            mFa.runOnUiThread(new Runnable() {

                final HomeFragment this$0;
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
                this$0 = HomeFragment.this;
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
            if (s.equalsIgnoreCase("SlideShowList") && !Application.isLeanBack() && mSlideShowList != null && mSlideShowAdRequester != null)
            {
                mSlideShowAdRequester.run(mSlideShowList.getItems());
            }
            updateData();
        }
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        if (Application.getInstance().getOmnitureTracker() != null)
        {
            Application.getInstance().getOmnitureTracker().homeScreen();
        }
        refreshData();
        super.onResume();
    }

    public void refreshData()
    {
        mLoadingProgress.setVisibility(0);
        if (mListView != null)
        {
            mListView.setAdapter(null);
        }
        mFeaturedPager.setAdapter(null);
        mResumeItemId = SharedPrefsManager.getLastViewedMediaItem();
        mSlideShowAdRequester = new SlideShowAdRequester(getActivity(), this);
        mSlideShowList = new SlideShowList(this, "home");
        if (!Application.isLeanBack())
        {
            if (mResumeItemId != null)
            {
                mMediaDetailsRequest = new MediaDetailsRequest(this, mResumeItemId);
            }
            mCrackleRequester = new ItemsListRequest(this, com.gotv.crackle.data.ItemsListRequest.ItemsListType.Featured, "moviesandtv");
        }
    }

    public void updateData()
    {
        if ((Application.isLeanBack() || mCrackleRequester != null) && mSlideShowAdRequester != null && (Application.isLeanBack() || mCrackleRequester.getRequestState() == com.gotv.crackle.data.DataRequest.RequestState.COMPLETE && mSlideShowAdRequester.getRequestState() == com.gotv.crackle.data.DataRequest.RequestState.COMPLETE) && (mMediaDetailsRequest == null || mMediaDetailsRequest.getRequestState() == com.gotv.crackle.data.DataRequest.RequestState.COMPLETE || mMediaDetailsRequest.getRequestState() == com.gotv.crackle.data.DataRequest.RequestState.FAILED))
        {
            mFa.runOnUiThread(new Runnable() {

                final HomeFragment this$0;

                public void run()
                {
                    if (mListView != null)
                    {
                        if (mMediaDetailsRequest != null)
                        {
                            mListView.setAdapter(new BrowseGridAdapter((MainActivity)mFa, mCrackleRequester.getItems(), mItemClickListener, com.gotv.crackle.base.BaseActivity.AppSection.HOME, mMediaDetailsRequest.getItem()));
                        } else
                        {
                            mListView.setAdapter(new BrowseGridAdapter((MainActivity)mFa, mCrackleRequester.getItems(), mItemClickListener, com.gotv.crackle.base.BaseActivity.AppSection.HOME, null));
                        }
                    }
                    refreshSlideShow();
                    mLoadingProgress.setVisibility(4);
                }

            
            {
                this$0 = HomeFragment.this;
                super();
            }
            });
        }
    }







}
