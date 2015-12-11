// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import co.vine.android.client.AppController;
import co.vine.android.widget.GenericTimelineAdapter;
import java.lang.ref.WeakReference;

// Referenced classes of package co.vine.android:
//            BaseTimelineFragment, ExploreChannelsActivity, BaseArrayListFragment

public class ExploreChannelsFragment extends BaseTimelineFragment
{

    public static final String ARG_CHANNEL_ID = "channelId";
    public static final String ARG_COLOR = "color";
    public static final String ARG_SORT = "sort";
    public static final String ARG_TAG = "tag";
    public static final String CATEGORY_CHANNELS = "channels";
    private static final String EVENT_SOURCE_TITLE = "Explore Channel: ";
    public static final String SORT_POPULAR = "popular";
    public static final String SORT_RECENT = "recent";
    private WeakReference mCallback;
    private String mChannelId;
    private int mColor;
    private String mSort;
    private String mTabTag;

    public ExploreChannelsFragment()
    {
    }

    private void handleFocus()
    {
label0:
        {
            if (mCallback != null && mCallback.get() != null)
            {
                if (!((ExploreChannelsActivity)mCallback.get()).isShowing(mTabTag))
                {
                    break label0;
                }
                setFocused(true);
                if (mAdapter.isEmpty())
                {
                    showProgress(3);
                    fetchContent(3, false);
                }
                if (!mFeedAdapter.isPlaying())
                {
                    mFeedAdapter.onResume(true);
                }
            }
            return;
        }
        setFocused(false);
        mFeedAdapter.onResume(false);
    }

    public static Bundle prepareArguments(Intent intent, boolean flag, String s, String s1, String s2, int i)
    {
        intent = BaseArrayListFragment.prepareArguments(intent, flag);
        intent.putString("channelId", s);
        intent.putString("sort", s1);
        intent.putString("tag", s2);
        intent.putInt("color", i);
        return intent;
    }

    protected String fetchPosts(int i, long l, boolean flag)
    {
        byte byte0;
        if (mSort.equals("popular"))
        {
            byte0 = 8;
        } else
        {
            byte0 = 9;
        }
        return mAppController.fetchPosts(mAppController.getActiveSession(), 10, mAppController.getActiveId(), byte0, i, l, flag, mChannelId, mSort, null);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mFeedAdapter.setProfileColor(0xffffff & mColor);
        mListView.setAdapter(mFeedAdapter);
        if (((ExploreChannelsActivity)getActivity()).hasTabs())
        {
            setUpUnderNavHeader();
            ((android.view.ViewGroup.MarginLayoutParams)mEmptyProgress.getLayoutParams()).topMargin = getActivity().getResources().getDimensionPixelSize(0x7f0b0084);
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mCallback = new WeakReference((ExploreChannelsActivity)activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        mChannelId = bundle.getString("channelId");
        setFlurryEventSource((new StringBuilder()).append("Explore Channel: ").append(mChannelId).toString());
        mSort = bundle.getString("sort");
        if (mSort == null)
        {
            mSort = "popular";
        }
        mColor = bundle.getInt("color");
        mTabTag = bundle.getString("tag");
        if (mTabTag == null)
        {
            mTabTag = "popular";
        }
    }

    public void onMoveTo(int i)
    {
        super.onMoveTo(i);
        ((ExploreChannelsActivity)getActivity()).resetNav();
    }

    public void onPause()
    {
        super.onPause();
        setFocused(false);
        mFeedAdapter.onPause(false);
    }

    public void onResume()
    {
        super.onResume();
        handleFocus();
        mFeedAdapter.startLoadingTimeProfiling("ExploreChannels");
        if (mFeedAdapter.isEmpty())
        {
            fetchContent(3, true);
        }
    }
}
