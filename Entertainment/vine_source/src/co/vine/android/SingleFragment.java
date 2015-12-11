// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import co.vine.android.api.VinePost;
import co.vine.android.client.AppSessionListener;
import co.vine.android.widget.FeedAdapter;
import co.vine.android.widget.GenericTimelineAdapter;

// Referenced classes of package co.vine.android:
//            BaseTimelineFragment, SingleFragmentWrapper

public class SingleFragment extends BaseTimelineFragment
{
    class SinglePostListener extends AppSessionListener
    {

        final SingleFragment this$0;

        public void onGetPostIdComplete(String s, int i, String s1, long l)
        {
            mWrapper.onGetPostIdComplete(l);
            fetchPostContent(3);
        }

        public void onGetSinglePostComplete(String s, int i, String s1, VinePost vinepost)
        {
            mFetched = true;
            ((FeedAdapter)mFeedAdapter).mergePost(vinepost);
        }

        SinglePostListener()
        {
            this$0 = SingleFragment.this;
            super();
        }
    }


    private static final String EVENT_SOURCE_TITLE = "Single Post";
    private final SingleFragmentWrapper mWrapper = new SingleFragmentWrapper();

    public SingleFragment()
    {
    }

    private void fetchPostId(int i)
    {
        if (!mWrapper.isLocked())
        {
            addRequest(mWrapper.fetchPostId(), i);
        }
    }

    protected void fetchContent(int i, boolean flag)
    {
    }

    protected void fetchPostContent(int i)
    {
        if (!mWrapper.isLocked())
        {
            addRequest(mWrapper.fetchPostContent(), i);
        }
    }

    protected String fetchPosts(int i, long l, boolean flag)
    {
        throw new IllegalStateException("Cannot fetch on single post");
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (!mWrapper.isLocked())
        {
            mListView.setAdapter(mFeedAdapter);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (mWrapper.onCreate(this, new SinglePostListener()))
        {
            setFocused(true);
        }
        setFlurryEventSource("Single Post");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (mWrapper.isLocked())
        {
            return mWrapper.onCreateLockedView(createView(layoutinflater, 0x7f03006a, viewgroup), this);
        } else
        {
            return super.onCreateView(layoutinflater, viewgroup, bundle);
        }
    }

    public void onPause()
    {
        super.onPause();
        mFeedAdapter.onPause(isFocused());
        mWrapper.onPause();
    }

    public void onResume()
    {
        super.onResume();
        if (mWrapper.onResume())
        {
            mFeedAdapter.onResume(isFocused());
            if (!mFetched)
            {
                if (mWrapper.getPostId() > 0L)
                {
                    fetchPostContent(3);
                } else
                if (mWrapper.getSharedId() != null)
                {
                    fetchPostId(3);
                    return;
                }
            }
        }
    }

}
