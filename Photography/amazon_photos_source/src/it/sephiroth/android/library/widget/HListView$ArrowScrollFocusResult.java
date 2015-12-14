// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;


// Referenced classes of package it.sephiroth.android.library.widget:
//            HListView

private static class <init>
{

    private int mAmountToScroll;
    private int mSelectedPosition;

    public int getAmountToScroll()
    {
        return mAmountToScroll;
    }

    public int getSelectedPosition()
    {
        return mSelectedPosition;
    }

    void populate(int i, int j)
    {
        mSelectedPosition = i;
        mAmountToScroll = j;
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
