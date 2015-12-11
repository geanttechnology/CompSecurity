// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import co.vine.android.client.AppController;
import co.vine.android.widget.GenericTimelineAdapter;

// Referenced classes of package co.vine.android:
//            BaseTimelineFragment, BaseArrayListFragment

public class ExploreTimelineFragment extends BaseTimelineFragment
{

    public static final String ARG_CATEGORY = "category";
    public static final String ARG_DATA = "data";
    public static final String ARG_TAG = "tag";
    public static final String CATEGORY_ON_THE_RISE = "trending-people";
    public static final String CATEGORY_POPULAR_NOW = "popular-now";
    public static final String CATEGORY_TAG = "tag";
    public static final String CATEGORY_TIMELINES = "timelines";
    private static final String EVENT_SOURCE_TITLE = "Explore Timeline: ";
    private String mCategory;
    private Uri mData;
    private String mTag;

    public ExploreTimelineFragment()
    {
    }

    public static Bundle prepareArguments(Intent intent, boolean flag, String s, String s1, Uri uri)
    {
        intent = BaseArrayListFragment.prepareArguments(intent, flag);
        intent.putString("category", s);
        intent.putString("tag", s1);
        intent.putParcelable("data", uri);
        return intent;
    }

    protected String fetchPosts(int i, long l, boolean flag)
    {
        byte byte0;
        if ("trending-people".equals(mCategory))
        {
            byte0 = 4;
        } else
        if ("popular-now".equals(mCategory))
        {
            byte0 = 5;
        } else
        if ("tag".equals(mCategory))
        {
            if (mTag == null)
            {
                throw new IllegalArgumentException("You have to specify a tag.");
            }
            byte0 = 6;
        } else
        if ("timelines".equals(mCategory))
        {
            byte0 = 11;
        } else
        {
            throw new IllegalArgumentException("You have to specify a category.");
        }
        return mAppController.fetchPosts(mAppController.getActiveSession(), 10, mAppController.getActiveId(), byte0, i, l, flag, mTag, null, mData);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mListView.setAdapter(mFeedAdapter);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        mCategory = bundle.getString("category");
        mData = (Uri)bundle.getParcelable("data");
        mTag = bundle.getString("tag");
        setFlurryEventSource((new StringBuilder()).append("Explore Timeline: ").append(mCategory).toString());
        setFocused(true);
    }

    public void onPause()
    {
        super.onPause();
        mFeedAdapter.onPause(isFocused());
    }

    public void onResume()
    {
        super.onResume();
        mFeedAdapter.onResume(isFocused());
        mFeedAdapter.startLoadingTimeProfiling("ExploreTimeline");
        if (mFeedAdapter.getCount() == 0 && !mFetched)
        {
            fetchContent(3, true);
        }
    }
}
