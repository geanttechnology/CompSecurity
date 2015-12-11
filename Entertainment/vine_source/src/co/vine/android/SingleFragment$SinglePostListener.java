// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.api.VinePost;
import co.vine.android.client.AppSessionListener;
import co.vine.android.widget.FeedAdapter;

// Referenced classes of package co.vine.android:
//            SingleFragment, SingleFragmentWrapper

class this._cls0 extends AppSessionListener
{

    final SingleFragment this$0;

    public void onGetPostIdComplete(String s, int i, String s1, long l)
    {
        SingleFragment.access$000(SingleFragment.this).onGetPostIdComplete(l);
        fetchPostContent(3);
    }

    public void onGetSinglePostComplete(String s, int i, String s1, VinePost vinepost)
    {
        mFetched = true;
        ((FeedAdapter)mFeedAdapter).mergePost(vinepost);
    }

    ()
    {
        this$0 = SingleFragment.this;
        super();
    }
}
