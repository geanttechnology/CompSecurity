// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;


public class ListState
{

    public int firstVisibleItem;
    public boolean hasNewScrollState;
    private boolean mDirty;
    private int mScrollState;
    public int totalItemCount;
    public int visibleItemCount;

    public ListState()
    {
    }

    public boolean isDirty()
    {
        return mDirty;
    }

    public boolean isFling()
    {
        return mScrollState == 2;
    }

    public void setDirty(boolean flag)
    {
        mDirty = flag;
    }

    public void setScrollState(int i)
    {
        mScrollState = i;
    }

    public boolean shouldUpdate()
    {
        return mScrollState != 2 && mDirty;
    }
}
