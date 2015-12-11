// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.ContentUris;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.Util;
import co.vine.android.widget.SpanClickListener;
import co.vine.android.widget.StyledClickableSpan;

// Referenced classes of package co.vine.android:
//            BaseControllerFragment

public class SingleFragmentWrapper
{

    public static final String ARG_LOCKED = "locked";
    public static final String ARG_POST_ID = "post_id";
    public static final String ARG_SHARE_ID = "post_share_id";
    public static final String ARG_TAKE_FOCUS = "take_focus";
    public static final String ARG_USERNAME = "username";
    public static final String ARG_USER_ID = "userId";
    private AppController mAppController;
    private BaseControllerFragment mFragment;
    private boolean mLocked;
    private long mPostId;
    private String mShareId;
    private AppSessionListener mSinglePostListener;
    private long mUserId;
    private String mUsername;

    public SingleFragmentWrapper()
    {
    }

    public String fetchPostContent()
    {
        return mAppController.fetchPost(mAppController.getActiveSession(), mPostId);
    }

    public String fetchPostId()
    {
        return mAppController.fetchPostId(mAppController.getActiveSession(), mShareId);
    }

    public long getPostId()
    {
        return mPostId;
    }

    public String getSharedId()
    {
        return mShareId;
    }

    public boolean isLocked()
    {
        return mLocked;
    }

    public boolean onCreate(BaseControllerFragment basecontrollerfragment, AppSessionListener appsessionlistener)
    {
        boolean flag = false;
        mFragment = basecontrollerfragment;
        mAppController = mFragment.getAppController();
        basecontrollerfragment = basecontrollerfragment.getArguments();
        mLocked = basecontrollerfragment.getBoolean("locked", false);
        if (!mLocked)
        {
            mPostId = basecontrollerfragment.getLong("post_id");
            mShareId = basecontrollerfragment.getString("post_share_id");
            boolean flag1 = basecontrollerfragment.getBoolean("take_focus", false);
            mSinglePostListener = appsessionlistener;
            if (flag1)
            {
                flag = true;
            }
            return flag;
        } else
        {
            mUsername = basecontrollerfragment.getString("username");
            mUserId = basecontrollerfragment.getLong("userId");
            return false;
        }
    }

    public Loader onCreateLoader()
    {
        if (mLocked)
        {
            return null;
        } else
        {
            return new CursorLoader(mFragment.getActivity(), ContentUris.withAppendedId(co.vine.android.provider.Vine.PostCommentsLikesView.CONTENT_URI_ALL_TIMELINE_SINGLE, mPostId), co.vine.android.provider.VineDatabaseSQL.PostCommentsLikesQuery.PROJECTION, null, null, null);
        }
    }

    public View onCreateLockedView(View view, SpanClickListener spanclicklistener)
    {
        TextView textview = (TextView)view.findViewById(0x7f0a014b);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        spanclicklistener = new StyledClickableSpan(1, Long.valueOf(mUserId), spanclicklistener);
        spanclicklistener.setColor(mFragment.getResources().getColor(0x7f090096));
        String s = mFragment.getString(0x7f0e017d, new Object[] {
            mUsername
        });
        textview.setText(Util.getSpannedText(new Object[] {
            spanclicklistener
        }, s, '"'));
        return view;
    }

    public void onGetPostIdComplete(long l)
    {
        mPostId = l;
    }

    public void onPause()
    {
        if (mSinglePostListener != null)
        {
            mAppController.removeListener(mSinglePostListener);
        }
    }

    public boolean onResume()
    {
        if (isLocked())
        {
            return false;
        }
        if (mSinglePostListener != null)
        {
            mAppController.addListener(mSinglePostListener);
        }
        return true;
    }
}
