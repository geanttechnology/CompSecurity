// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import co.vine.android.widget.SpanClickListener;

// Referenced classes of package co.vine.android:
//            BaseFragment, UsersActivity, ProfileActivity, SingleActivity, 
//            ProfileFragment, HashtagActivity, CommentsActivity

public class VineSpanClicker
    implements SpanClickListener
{

    public static final int FOLLOWERS_SPAN = 5;
    public static final int FOLLOWING_SPAN = 6;
    public static final int MANY_LIKES_SPAN = 2;
    public static final int OLDER_COMMENTS_SPAN = 3;
    public static final int POST_SPAN = 9;
    public static final int REVINED_BY_SPAN = 8;
    public static final int REVINERS_SPAN = 7;
    public static final int SPAN_FLAGS = 33;
    public static final int TAG_SPAN = 4;
    public static final int USERNAME_SPAN = 1;
    private FragmentActivity mActivity;
    private String mFlurryEventSource;
    private BaseFragment mFragment;
    private long mUserId;

    public VineSpanClicker(FragmentActivity fragmentactivity)
    {
        mActivity = fragmentactivity;
    }

    public VineSpanClicker(BaseFragment basefragment)
    {
        mFragment = basefragment;
    }

    public FragmentActivity getActivity()
    {
        if (mFragment != null)
        {
            return mFragment.getActivity();
        } else
        {
            return mActivity;
        }
    }

    public void onFollowersClicked()
    {
        Object obj = getActivity();
        if (obj != null)
        {
            obj = new Intent(((android.content.Context) (obj)), co/vine/android/UsersActivity);
            ((Intent) (obj)).putExtra("p_id", mUserId);
            ((Intent) (obj)).putExtra("u_type", 2);
            startActivity(((Intent) (obj)));
        }
    }

    public void onFollowingClicked()
    {
        Object obj = getActivity();
        if (obj != null)
        {
            obj = new Intent(((android.content.Context) (obj)), co/vine/android/UsersActivity);
            ((Intent) (obj)).putExtra("p_id", mUserId);
            ((Intent) (obj)).putExtra("u_type", 1);
            startActivity(((Intent) (obj)));
        }
    }

    public void onRevineBySpanClicked(long l)
    {
        FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity != null)
        {
            ProfileActivity.start(fragmentactivity, l, mFlurryEventSource);
        }
    }

    public void onSpanClicked(View view, int i, Object obj)
    {
        view = getActivity();
        if (view == null) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 1 9: default 60
    //                   1 124
    //                   2 71
    //                   3 194
    //                   4 185
    //                   5 66
    //                   6 61
    //                   7 213
    //                   8 255
    //                   9 112;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L2:
        return;
_L8:
        onFollowingClicked();
        return;
_L7:
        onFollowersClicked();
        return;
_L4:
        obj = (Long)obj;
        view = new Intent(view, co/vine/android/UsersActivity);
        view.putExtra("post_id", ((Long) (obj)).longValue());
        view.putExtra("u_type", 5);
        startActivity(view);
        return;
_L11:
        SingleActivity.start(view, ((Long)obj).longValue());
        return;
_L3:
        long l;
        if (mFragment == null || !(mFragment instanceof ProfileFragment))
        {
            break; /* Loop/switch isn't completed */
        }
        l = ((ProfileFragment)mFragment).getUserId();
        if (obj != null && obj.equals(Long.valueOf(l))) goto _L2; else goto _L12
_L12:
        ProfileActivity.start(view, ((Long)obj).longValue(), mFlurryEventSource);
        return;
_L6:
        HashtagActivity.start(view, (String)obj);
        return;
_L5:
        obj = (co.vine.android.widget.GenericVideoAdapter.SpanCommentObjectTag)obj;
        CommentsActivity.start(view, ((co.vine.android.widget.GenericVideoAdapter.SpanCommentObjectTag) (obj)).postId, ((co.vine.android.widget.GenericVideoAdapter.SpanCommentObjectTag) (obj)).authorId, true);
        return;
_L9:
        obj = (co.vine.android.widget.GenericVideoAdapter.SpanCommentObjectTag)obj;
        view = new Intent(view, co/vine/android/UsersActivity);
        view.putExtra("post_id", ((co.vine.android.widget.GenericVideoAdapter.SpanCommentObjectTag) (obj)).postId);
        view.putExtra("u_type", 9);
        startActivity(view);
        return;
_L10:
        onRevineBySpanClicked(((Long)obj).longValue());
        return;
    }

    public void setFlurryEventSource(String s)
    {
        mFlurryEventSource = s;
    }

    public void setUserId(long l)
    {
        mUserId = l;
    }

    public void startActivity(Intent intent)
    {
        if (mFragment != null)
        {
            mFragment.startActivity(intent);
            return;
        } else
        {
            mActivity.startActivity(intent);
            return;
        }
    }
}
