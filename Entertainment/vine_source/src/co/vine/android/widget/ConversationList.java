// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import co.vine.android.views.SdkListView;

public class ConversationList extends SdkListView
    implements android.widget.AbsListView.OnScrollListener
{
    public static interface GetMoreListener
    {

        public abstract void getMore();
    }


    private View mGetMoreHeaderProgressContainer;
    private GetMoreListener mGetMoreListener;
    private View mProgressView;
    private android.widget.AbsListView.OnScrollListener mScrollListener;

    public ConversationList(Context context)
    {
        super(context);
    }

    public ConversationList(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public ConversationList(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void deactivateRefresh()
    {
        deactivateRefresh(false);
    }

    public void deactivateRefresh(boolean flag)
    {
        mProgressView.setVisibility(8);
        if (flag)
        {
            removeHeaderView(mGetMoreHeaderProgressContainer);
        }
    }

    public void hideProgress()
    {
        mProgressView.setVisibility(4);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        super.setOnScrollListener(this);
        mGetMoreHeaderProgressContainer = LayoutInflater.from(getContext()).inflate(0x7f03002d, null);
        mProgressView = mGetMoreHeaderProgressContainer.findViewById(0x7f0a00b0);
        addHeaderView(mGetMoreHeaderProgressContainer, null, false);
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (j != 0)
        {
            if (mGetMoreListener != null && i == 0 && mProgressView.getVisibility() != 8 && getChildAt(0) == mGetMoreHeaderProgressContainer)
            {
                mGetMoreListener.getMore();
            }
            if (mScrollListener != null)
            {
                mScrollListener.onScroll(abslistview, i, j, k);
                return;
            }
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (mScrollListener != null)
        {
            mScrollListener.onScrollStateChanged(abslistview, i);
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (getCount() > 0)
        {
            setSelection(getCount() - 1);
        }
    }

    public void reactivateRefresh()
    {
        mProgressView.setVisibility(4);
    }

    public void setGetMoreListener(GetMoreListener getmorelistener)
    {
        mGetMoreListener = getmorelistener;
    }

    public void setOnScrollListener(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        mScrollListener = onscrolllistener;
    }

    public void showProgress()
    {
        if (mProgressView.getVisibility() != 8)
        {
            mProgressView.setVisibility(0);
        }
    }
}
