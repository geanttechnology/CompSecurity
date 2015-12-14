// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;
import java.util.List;

class mScrapList
{

    static final int INVALID_LAYOUT = 0x80000000;
    static final int ITEM_DIRECTION_HEAD = -1;
    static final int ITEM_DIRECTION_TAIL = 1;
    static final int LAYOUT_END = 1;
    static final int LAYOUT_START = -1;
    static final int SCOLLING_OFFSET_NaN = 0x80000000;
    static final String TAG = "LinearLayoutManager#LayoutState";
    int mAvailable;
    int mCurrentPosition;
    int mExtra;
    boolean mIsPreLayout;
    int mItemDirection;
    int mLayoutDirection;
    int mOffset;
    boolean mRecycle;
    List mScrapList;
    int mScrollingOffset;

    private View nextFromLimitedList()
    {
        int l = mScrapList.size();
        int i = 0x7fffffff;
        int j = 0;
        mScrapList mscraplist = null;
        for (; j < l; j++)
        {
            mScrapList mscraplist1 = (mScrapList)mScrapList.get(j);
            if (!mIsPreLayout && mscraplist1.d())
            {
                continue;
            }
            int k = (mscraplist1.tPosition() - mCurrentPosition) * mItemDirection;
            if (k < 0 || k >= i)
            {
                continue;
            }
            mscraplist = mscraplist1;
            if (k == 0)
            {
                break;
            }
            mscraplist = mscraplist1;
            i = k;
        }

        if (mscraplist != null)
        {
            mCurrentPosition = mscraplist.tPosition() + mItemDirection;
            return mscraplist.;
        } else
        {
            return null;
        }
    }

    boolean hasMore( )
    {
        return mCurrentPosition >= 0 && mCurrentPosition < .mCurrentPosition();
    }

    void log()
    {
        (new StringBuilder("avail:")).append(mAvailable).append(", ind:").append(mCurrentPosition).append(", dir:").append(mItemDirection).append(", offset:").append(mOffset).append(", layoutDir:").append(mLayoutDirection);
    }

    View next(mLayoutDirection mlayoutdirection)
    {
        if (mScrapList != null)
        {
            return nextFromLimitedList();
        } else
        {
            mlayoutdirection = mlayoutdirection.Position(mCurrentPosition);
            mCurrentPosition = mCurrentPosition + mItemDirection;
            return mlayoutdirection;
        }
    }

    ()
    {
        mRecycle = true;
        mExtra = 0;
        mIsPreLayout = false;
        mScrapList = null;
    }
}
