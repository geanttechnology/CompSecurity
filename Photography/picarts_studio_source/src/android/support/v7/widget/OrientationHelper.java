// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;

public abstract class OrientationHelper
{

    public static final int HORIZONTAL = 0;
    private static final int INVALID_SIZE = 0x80000000;
    public static final int VERTICAL = 1;
    private int mLastTotalSpace;
    protected final RecyclerView.LayoutManager mLayoutManager;

    private OrientationHelper(RecyclerView.LayoutManager layoutmanager)
    {
        mLastTotalSpace = 0x80000000;
        mLayoutManager = layoutmanager;
    }

    OrientationHelper(RecyclerView.LayoutManager layoutmanager, _cls1 _pcls1)
    {
        this(layoutmanager);
    }

    public static OrientationHelper createHorizontalHelper(RecyclerView.LayoutManager layoutmanager)
    {
        return new _cls1(layoutmanager);
    }

    public static OrientationHelper createOrientationHelper(RecyclerView.LayoutManager layoutmanager, int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException("invalid orientation");

        case 0: // '\0'
            return createHorizontalHelper(layoutmanager);

        case 1: // '\001'
            return createVerticalHelper(layoutmanager);
        }
    }

    public static OrientationHelper createVerticalHelper(RecyclerView.LayoutManager layoutmanager)
    {
        return new _cls2(layoutmanager);
    }

    public abstract int getDecoratedEnd(View view);

    public abstract int getDecoratedMeasurement(View view);

    public abstract int getDecoratedMeasurementInOther(View view);

    public abstract int getDecoratedStart(View view);

    public abstract int getEnd();

    public abstract int getEndAfterPadding();

    public abstract int getEndPadding();

    public abstract int getStartAfterPadding();

    public abstract int getTotalSpace();

    public int getTotalSpaceChange()
    {
        if (0x80000000 == mLastTotalSpace)
        {
            return 0;
        } else
        {
            return getTotalSpace() - mLastTotalSpace;
        }
    }

    public abstract void offsetChild(View view, int i);

    public abstract void offsetChildren(int i);

    public void onLayoutComplete()
    {
        mLastTotalSpace = getTotalSpace();
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
