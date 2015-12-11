// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.ui;


// Referenced classes of package com.amazon.mShop.ui:
//            BottomToolBar

public static class mIconId
{

    private int mIconId;
    private boolean mIsEnabled;
    private int mItemId;
    private String mItemName;
    private int mItemNameId;

    public int getIconId()
    {
        return mIconId;
    }

    public int getItemId()
    {
        return mItemId;
    }

    public String getItemName()
    {
        return mItemName;
    }

    public int getItemNameId()
    {
        return mItemNameId;
    }

    public boolean isEnabled()
    {
        return mIsEnabled;
    }

    public void setEnabled(boolean flag)
    {
        mIsEnabled = flag;
    }

    public void setItemName(String s)
    {
        mItemName = s;
    }

    public (int i, int j, int k, boolean flag)
    {
        mItemNameId = j;
        mItemId = i;
        mIsEnabled = flag;
        mIconId = k;
    }

    public mIconId(int i, int j, boolean flag)
    {
        this(i, j, -1, flag);
    }

    public <init>(int i, String s, boolean flag)
    {
        mItemName = s;
        mItemId = i;
        mIsEnabled = flag;
        mIconId = -1;
    }
}
