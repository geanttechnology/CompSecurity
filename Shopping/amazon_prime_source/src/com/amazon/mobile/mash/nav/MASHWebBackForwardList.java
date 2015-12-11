// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.nav;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mobile.mash.nav:
//            MASHWebHistoryItem

public class MASHWebBackForwardList
{

    private int mCurrentIndex;
    private List mWebHistoryItemList;

    public MASHWebBackForwardList()
    {
        mCurrentIndex = -1;
        mWebHistoryItemList = new ArrayList();
    }

    public void addHistoryItem(MASHWebHistoryItem mashwebhistoryitem)
    {
        mCurrentIndex = mCurrentIndex + 1;
        int i = mWebHistoryItemList.size();
        int j = mCurrentIndex;
        if (j != i)
        {
            for (i--; i >= j; i--)
            {
                mWebHistoryItemList.remove(i);
            }

        }
        mWebHistoryItemList.add(mashwebhistoryitem);
    }

    public int getCurrentIndex()
    {
        return mCurrentIndex;
    }

    public MASHWebHistoryItem getCurrentItem()
    {
        return getItemAtIndex(mCurrentIndex);
    }

    public MASHWebHistoryItem getItemAtIndex(int i)
    {
        if (i < 0 || i >= getSize())
        {
            return null;
        } else
        {
            return (MASHWebHistoryItem)mWebHistoryItemList.get(i);
        }
    }

    public int getSize()
    {
        return mWebHistoryItemList.size();
    }

    public void setCurrentIndex(int i)
    {
        mCurrentIndex = i;
    }
}
