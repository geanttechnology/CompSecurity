// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.plp.presenter;


public class com.target.ui.fragment.product.plp.presenter.a
{
    public static class a
    {

        int currentDecorationOffset;
        boolean decorationEnabled;
        int eventType;
        int firstDecoratedItemPosition;
        int firstVisibleItemBottom;
        int firstVisibleItemPosition;
        int firstVisibleItemTop;
        int scrollDeltaY;

        public a a(int i)
        {
            eventType = i;
            return this;
        }

        public a a(boolean flag)
        {
            decorationEnabled = flag;
            return this;
        }

        public com.target.ui.fragment.product.plp.presenter.a a()
        {
            return new com.target.ui.fragment.product.plp.presenter.a(this);
        }

        public a b(int i)
        {
            currentDecorationOffset = i;
            return this;
        }

        public a c(int i)
        {
            firstDecoratedItemPosition = i;
            return this;
        }

        public a d(int i)
        {
            firstVisibleItemBottom = i;
            return this;
        }

        public a e(int i)
        {
            firstVisibleItemPosition = i;
            return this;
        }

        public a f(int i)
        {
            firstVisibleItemTop = i;
            return this;
        }

        public a g(int i)
        {
            scrollDeltaY = i;
            return this;
        }

        public a()
        {
        }
    }


    private int mCurrentDecorationOffset;
    private boolean mDecorationEnabled;
    private int mEventType;
    private int mFirstDecoratedItemPosition;
    private int mFirstVisibleItemBottom;
    private int mFirstVisibleItemPosition;
    private int mFirstVisibleItemTop;
    private int mScrollDeltaY;

    private com.target.ui.fragment.product.plp.presenter.a(a a1)
    {
        mCurrentDecorationOffset = a1.currentDecorationOffset;
        mDecorationEnabled = a1.decorationEnabled;
        mEventType = a1.eventType;
        mFirstVisibleItemBottom = a1.firstVisibleItemBottom;
        mFirstVisibleItemPosition = a1.firstVisibleItemPosition;
        mFirstVisibleItemTop = a1.firstVisibleItemTop;
        mFirstDecoratedItemPosition = a1.firstDecoratedItemPosition;
        mScrollDeltaY = a1.scrollDeltaY;
    }


    public int a()
    {
        return mCurrentDecorationOffset;
    }

    public int b()
    {
        return mEventType;
    }

    public int c()
    {
        return mFirstDecoratedItemPosition;
    }

    public int d()
    {
        return mFirstVisibleItemBottom;
    }

    public int e()
    {
        return mFirstVisibleItemPosition;
    }

    public int f()
    {
        return mFirstVisibleItemTop;
    }

    public int g()
    {
        return mScrollDeltaY;
    }

    public boolean h()
    {
        return mDecorationEnabled;
    }
}
