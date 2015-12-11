// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import com.freewheel.ad.AdFetcher;
import com.freewheel.ad.IAdHolder;
import com.gotv.crackle.Application;
import com.gotv.crackle.ApplicationConstants;
import com.gotv.crackle.DetailsActivityResolver;
import com.gotv.crackle.MainActivity;
import com.gotv.crackle.adapters.BrowseGridAdapter;
import com.gotv.crackle.adapters.BrowseGridViewAdapter;
import com.gotv.crackle.adapters.BrowseItemListAdapter;
import com.gotv.crackle.adapters.BrowseListAdapter;
import com.gotv.crackle.adapters.SpinnerListAdapter;
import com.gotv.crackle.data.BrowseAPI;
import com.gotv.crackle.data.GenreList;
import com.gotv.crackle.data.ItemsListRequest;
import com.gotv.crackle.data.Localization;
import com.gotv.crackle.model.BrowseModel;
import com.gotv.crackle.model.CrackleItem;
import com.gotv.crackle.model.GenreItem;
import com.gotv.crackle.util.OmnitureWrapper;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.ISlot;

public class BrowseShowsFragment extends Fragment
    implements com.gotv.crackle.data.DataRequest.DataRequestListener, IAdHolder
{

    public static final String CATEGORY = "shows";
    public static final String EXTRA_CATEGORY = "EXTRA_CATEGORY";
    public static final int VIEW_STYLE_GRID = 0;
    public static final int VIEW_STYLE_LIST = 1;
    public static int sCurrentViewStyle;
    private IAdContext adContext;
    private AdFetcher adFetcher;
    private android.widget.AdapterView.OnItemSelectedListener filterSpinnerItemSelectedListener;
    private RelativeLayout mAdContainer;
    private List mBrowseListItems;
    private BrowseAPI mBrowseRequester;
    private ItemsListRequest mCrackleRequester;
    private String mCurrentFilter;
    private String mCurrentGenre;
    private String mCurrentGenreName;
    private FragmentActivity mFa;
    private android.view.View.OnFocusChangeListener mFocusChangedListener;
    private GenreList mGenreList;
    private GridView mGridView;
    private android.widget.AdapterView.OnItemClickListener mItemClickListener;
    private android.widget.AdapterView.OnItemSelectedListener mItemSelectedListener;
    protected View mLastAnimatedView;
    private ListView mListView;
    private View mListViewHeader;
    private ProgressBar mLoadingProgress;
    private android.view.View.OnClickListener mOnClickListener;
    private android.view.View.OnClickListener mPlayItemListener;
    private View mRootView;
    private String mSectionName;
    private boolean mShowAllThumbnailAdded;
    private Spinner mSortBySpinner;
    private Spinner mSubCategorySpinner;
    private android.widget.AdapterView.OnItemSelectedListener subCategorySpinnerItemSelectedListener;

    public BrowseShowsFragment()
    {
        mBrowseListItems = new ArrayList();
        mCurrentFilter = "all";
        mShowAllThumbnailAdded = false;
        mOnClickListener = new android.view.View.OnClickListener() {

            final BrowseShowsFragment this$0;

            public void onClick(View view)
            {
                launchMediaDetails(view, false);
            }

            
            {
                this$0 = BrowseShowsFragment.this;
                super();
            }
        };
        mItemClickListener = new android.widget.AdapterView.OnItemClickListener() {

            final BrowseShowsFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                view.setTag((BrowseModel)adapterview.getItemAtPosition(i));
                launchMediaDetails(view, false);
            }

            
            {
                this$0 = BrowseShowsFragment.this;
                super();
            }
        };
        mPlayItemListener = new android.view.View.OnClickListener() {

            final BrowseShowsFragment this$0;

            public void onClick(View view)
            {
                launchMediaDetails(view, true);
            }

            
            {
                this$0 = BrowseShowsFragment.this;
                super();
            }
        };
        mItemSelectedListener = new android.widget.AdapterView.OnItemSelectedListener() {

            final BrowseShowsFragment this$0;

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
                this$0 = BrowseShowsFragment.this;
                super();
            }
        };
        mFocusChangedListener = new android.view.View.OnFocusChangeListener() {

            final BrowseShowsFragment this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (mLastAnimatedView != null && !flag)
                {
                    mLastAnimatedView.startAnimation(AnimationUtils.loadAnimation(mFa, 0x7f040007));
                }
            }

            
            {
                this$0 = BrowseShowsFragment.this;
                super();
            }
        };
        subCategorySpinnerItemSelectedListener = new android.widget.AdapterView.OnItemSelectedListener() {

            final BrowseShowsFragment this$0;

            public void onItemSelected(AdapterView adapterview, View view, int i, long l)
            {
                mCurrentGenre = (String)adapterview.getAdapter().getItem(i);
                switchGenre();
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                this$0 = BrowseShowsFragment.this;
                super();
            }
        };
        filterSpinnerItemSelectedListener = new android.widget.AdapterView.OnItemSelectedListener() {

            final BrowseShowsFragment this$0;

            public void onItemSelected(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = getResources().getStringArray(0x7f0d0003)[i];
                mCurrentFilter = adapterview;
                switchGenre();
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                this$0 = BrowseShowsFragment.this;
                super();
            }
        };
    }

    private void initSubCategorySpinner()
    {
        mBrowseListItems = new ArrayList();
        mBrowseListItems.add(getResources().getString(0x7f0b009c));
        mBrowseListItems.add(getResources().getString(0x7f0b009d));
        mBrowseListItems.add(getResources().getString(0x7f0b009e));
        mBrowseListItems.add(getResources().getString(0x7f0b00a0));
        mSubCategorySpinner = (Spinner)mFa.findViewById(0x7f0a0055);
        mSubCategorySpinner.setVisibility(0);
        if (Application.isLeanBack())
        {
            mSubCategorySpinner.setPadding(Application.dpToPx(30), mSubCategorySpinner.getPaddingTop(), mSubCategorySpinner.getPaddingRight(), mSubCategorySpinner.getPaddingBottom());
        }
        mSubCategorySpinner.setAdapter(new BrowseListAdapter((MainActivity)mFa, mBrowseListItems, mGenreList.getItems()));
        mSubCategorySpinner.setOnItemSelectedListener(subCategorySpinnerItemSelectedListener);
    }

    private void switchGenre()
    {
        try
        {
            Integer.parseInt(mCurrentGenre);
            Iterator iterator = mGenreList.getItems().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                GenreItem genreitem = (GenreItem)iterator.next();
                if (mCurrentGenre.compareTo(genreitem.getID()) == 0)
                {
                    mCurrentGenreName = genreitem.getName();
                }
            } while (true);
        }
        catch (Exception exception)
        {
            mCurrentGenreName = mCurrentGenre;
        }
        Application.getInstance().getOmnitureTracker().browseShowGenres(mCurrentGenreName);
        if (mListView != null)
        {
            mListView.setAdapter(null);
        } else
        {
            mGridView.setAdapter(null);
        }
        mCrackleRequester = null;
        mBrowseRequester = null;
        mLoadingProgress.setVisibility(0);
        ((MainActivity)mFa).mImageLoader.clearMemoryCache();
        if (mCurrentGenre == getResources().getString(0x7f0b009c))
        {
            mSortBySpinner.setVisibility(4);
            mCrackleRequester = new ItemsListRequest(this, com.gotv.crackle.data.ItemsListRequest.ItemsListType.Featured, "shows");
            return;
        }
        if (mCurrentGenre == getResources().getString(0x7f0b009d))
        {
            mSortBySpinner.setVisibility(4);
            mCrackleRequester = new ItemsListRequest(this, com.gotv.crackle.data.ItemsListRequest.ItemsListType.Popular, "shows");
            return;
        }
        if (mCurrentGenre == getResources().getString(0x7f0b009e))
        {
            mSortBySpinner.setVisibility(4);
            mCrackleRequester = new ItemsListRequest(this, com.gotv.crackle.data.ItemsListRequest.ItemsListType.Recent, "shows");
            return;
        }
        if (mCurrentGenre == getResources().getString(0x7f0b00a0))
        {
            if (Application.getInstance().getLocalization().isLatinAmericaUI())
            {
                mSortBySpinner.setVisibility(0);
            }
            mBrowseRequester = new BrowseAPI(this, "shows", mCurrentFilter, "all", "alpha");
            mSubCategorySpinner.setOnItemSelectedListener(null);
            mSubCategorySpinner.setSelection(3);
            mSubCategorySpinner.setOnItemSelectedListener(subCategorySpinnerItemSelectedListener);
            return;
        }
        if (Application.getInstance().getLocalization().isLatinAmericaUI())
        {
            mSortBySpinner.setVisibility(0);
        }
        mBrowseRequester = new BrowseAPI(this, "shows", "all", mCurrentGenre, "alpha");
    }

    private void switchMode()
    {
        if (isAdded()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag;
        flag = mCurrentGenreName.equalsIgnoreCase(getString(0x7f0b00a0));
        ((MainActivity)mFa).mImageLoader.clearMemoryCache();
        if (mCrackleRequester == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (mListView != null)
        {
            if (sCurrentViewStyle == 0)
            {
                mRootView.setBackgroundColor(getResources().getColor(0x7f070027));
                mListViewHeader.setVisibility(8);
                if (!flag && !mShowAllThumbnailAdded)
                {
                    CrackleItem crackleitem = new CrackleItem();
                    crackleitem.setID(mFa.getString(0x7f0b00d9));
                    mCrackleRequester.getItems().add(crackleitem);
                    mShowAllThumbnailAdded = true;
                }
                mListView.setAdapter(new BrowseGridAdapter((MainActivity)mFa, mCrackleRequester.getItems(), mOnClickListener, com.gotv.crackle.base.BaseActivity.AppSection.SHOWS, null));
                mListView.setOnItemClickListener(null);
                return;
            }
            mRootView.setBackgroundColor(getResources().getColor(0x7f070028));
            mListViewHeader.setVisibility(0);
            if (!flag && !mShowAllThumbnailAdded)
            {
                CrackleItem crackleitem1 = new CrackleItem();
                crackleitem1.setID(mFa.getString(0x7f0b00d9));
                mCrackleRequester.getItems().add(crackleitem1);
                mShowAllThumbnailAdded = true;
            }
            mListView.setAdapter(new BrowseItemListAdapter((MainActivity)mFa, mCrackleRequester.getItems(), mOnClickListener, mPlayItemListener, com.gotv.crackle.base.BaseActivity.AppSection.SHOWS));
            return;
        }
        if (mGridView != null)
        {
            mListViewHeader.setVisibility(8);
            if (!flag && !mShowAllThumbnailAdded)
            {
                CrackleItem crackleitem2 = new CrackleItem();
                crackleitem2.setID(mFa.getString(0x7f0b00d9));
                mCrackleRequester.getItems().add(crackleitem2);
                mShowAllThumbnailAdded = true;
            }
            mGridView.setAdapter(new BrowseGridViewAdapter((MainActivity)mFa, mCrackleRequester.getItems(), com.gotv.crackle.base.BaseActivity.AppSection.SHOWS));
            mGridView.setOnItemClickListener(mItemClickListener);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (mBrowseRequester == null) goto _L1; else goto _L3
_L3:
        if (mListView != null)
        {
            if (sCurrentViewStyle == 0)
            {
                mRootView.setBackgroundColor(getResources().getColor(0x7f070027));
                mListViewHeader.setVisibility(8);
                if (!flag && !mShowAllThumbnailAdded)
                {
                    CrackleItem crackleitem3 = new CrackleItem();
                    crackleitem3.setID(mFa.getString(0x7f0b00d9));
                    mCrackleRequester.getItems().add(crackleitem3);
                    mShowAllThumbnailAdded = true;
                }
                mListView.setAdapter(new BrowseGridAdapter((MainActivity)mFa, mBrowseRequester.getItems(), mOnClickListener, com.gotv.crackle.base.BaseActivity.AppSection.SHOWS, null));
                return;
            }
            mRootView.setBackgroundColor(getResources().getColor(0x7f070028));
            mListViewHeader.setVisibility(0);
            if (!flag && !mShowAllThumbnailAdded)
            {
                CrackleItem crackleitem4 = new CrackleItem();
                crackleitem4.setID(mFa.getString(0x7f0b00d9));
                mCrackleRequester.getItems().add(crackleitem4);
                mShowAllThumbnailAdded = true;
            }
            mListView.setAdapter(new BrowseItemListAdapter((MainActivity)mFa, mBrowseRequester.getItems(), mOnClickListener, mPlayItemListener, com.gotv.crackle.base.BaseActivity.AppSection.SHOWS));
            return;
        }
        if (mGridView != null)
        {
            mListViewHeader.setVisibility(8);
            if (!flag && !mShowAllThumbnailAdded)
            {
                CrackleItem crackleitem5 = new CrackleItem();
                crackleitem5.setID(mFa.getString(0x7f0b00d9));
                mCrackleRequester.getItems().add(crackleitem5);
                mShowAllThumbnailAdded = true;
            }
            mGridView.setAdapter(new BrowseGridViewAdapter((MainActivity)mFa, mBrowseRequester.getItems(), com.gotv.crackle.base.BaseActivity.AppSection.SHOWS));
            mGridView.setOnItemClickListener(mItemClickListener);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
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
        return mSectionName;
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
        String s = ((BrowseModel)view.getTag()).getID();
        if (s.equalsIgnoreCase(getString(0x7f0b00d9)))
        {
            mCurrentGenre = getString(0x7f0b00a0);
            switchGenre();
            return;
        }
        view = ((BrowseModel)view.getTag()).getRootChannelID();
        Intent intent = new Intent((MainActivity)mFa, com/gotv/crackle/DetailsActivityResolver);
        intent.putExtra("ID", s);
        intent.putExtra("ROOT_CHANNEL", view);
        if (flag)
        {
            intent.putExtra("START_PLAYING", true);
        }
        startActivity(intent);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mRootView = mFa.findViewById(0x7f0a0052);
        mSectionName = ApplicationConstants.getFreeWheelShowsSiteSection();
        mSortBySpinner = (Spinner)mFa.findViewById(0x7f0a0056);
        if (Application.getInstance().getLocalization().isLatinAmericaUI())
        {
            bundle = Arrays.asList(getResources().getStringArray(0x7f0d0002));
            mSortBySpinner.setAdapter(new SpinnerListAdapter((MainActivity)mFa, bundle));
            mSortBySpinner.setOnItemSelectedListener(filterSpinnerItemSelectedListener);
        }
        mGenreList = new GenreList(this, "shows");
        mListViewHeader = mFa.findViewById(0x7f0a0057);
        mListViewHeader.findViewById(0x7f0a0073).setVisibility(8);
        mListViewHeader.findViewById(0x7f0a0076).setVisibility(8);
        mListViewHeader.findViewById(0x7f0a0075).setVisibility(8);
        mLoadingProgress = (ProgressBar)mFa.findViewById(0x7f0a0053);
        mLoadingProgress.setVisibility(0);
        if (Application.isLeanBack())
        {
            mGridView = (GridView)mFa.findViewById(0x7f0a005f);
            mGridView.setOnItemSelectedListener(mItemSelectedListener);
            mGridView.setOnFocusChangeListener(mFocusChangedListener);
        } else
        {
            mListView = (ListView)mFa.findViewById(0x7f0a0058);
        }
        if (mCurrentGenre == null)
        {
            mCurrentGenre = getResources().getString(0x7f0b009c);
            mCurrentGenreName = mCurrentGenre;
        }
        switchGenre();
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
        switchMode();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        mFa = super.getActivity();
        if (Application.isLeanBack())
        {
            return layoutinflater.inflate(0x7f03001a, viewgroup, false);
        } else
        {
            return layoutinflater.inflate(0x7f030019, viewgroup, false);
        }
    }

    public void onDataFailed(String s, final String Message)
    {
        if (getActivity() != null)
        {
            getActivity().runOnUiThread(new Runnable() {

                final BrowseShowsFragment this$0;
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
                this$0 = BrowseShowsFragment.this;
                Message = s;
                super();
            }
            });
        }
    }

    public void onDataSuccess(final String tag)
    {
        if (getActivity() != null)
        {
            getActivity().runOnUiThread(new Runnable() {

                final BrowseShowsFragment this$0;
                final String val$tag;

                public void run()
                {
                    mLoadingProgress.setVisibility(4);
                    if (tag == "ItemsListRequest-Featured" || tag == "ItemsListRequest-Popular" || tag == "ItemsListRequest-Recent" || tag == "BrowseAPI")
                    {
                        switchMode();
                    }
                    if (tag == "GenreList")
                    {
                        initSubCategorySpinner();
                    }
                }

            
            {
                this$0 = BrowseShowsFragment.this;
                tag = s;
                super();
            }
            });
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
                mAdContainer = (RelativeLayout)mFa.findViewById(0x7f0a0059);
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

                            final BrowseShowsFragment this$0;
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
                this$0 = BrowseShowsFragment.this;
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
        Application.getInstance().getOmnitureTracker().showsSectional();
        if (mBrowseRequester == null) goto _L2; else goto _L1
_L1:
        if (mBrowseRequester.getRequestState() == com.gotv.crackle.data.DataRequest.RequestState.COMPLETE)
        {
            switchMode();
        }
_L4:
        super.onResume();
        return;
_L2:
        if (mCrackleRequester != null && mCrackleRequester.getRequestState() == com.gotv.crackle.data.DataRequest.RequestState.COMPLETE)
        {
            switchMode();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void refreshData()
    {
        switchGenre();
    }



/*
    static String access$102(BrowseShowsFragment browseshowsfragment, String s)
    {
        browseshowsfragment.mCurrentGenre = s;
        return s;
    }

*/



/*
    static String access$302(BrowseShowsFragment browseshowsfragment, String s)
    {
        browseshowsfragment.mCurrentFilter = s;
        return s;
    }

*/




}
