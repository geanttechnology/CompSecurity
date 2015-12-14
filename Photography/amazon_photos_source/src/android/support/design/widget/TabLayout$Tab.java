// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

// Referenced classes of package android.support.design.widget:
//            TabLayout

public static final class mParent
{

    private CharSequence mContentDesc;
    private View mCustomView;
    private Drawable mIcon;
    private final TabLayout mParent;
    private int mPosition;
    private CharSequence mText;

    public CharSequence getContentDescription()
    {
        return mContentDesc;
    }

    View getCustomView()
    {
        return mCustomView;
    }

    public Drawable getIcon()
    {
        return mIcon;
    }

    public int getPosition()
    {
        return mPosition;
    }

    public CharSequence getText()
    {
        return mText;
    }

    public void select()
    {
        mParent.selectTab(this);
    }

    void setPosition(int i)
    {
        mPosition = i;
    }

    public mPosition setText(CharSequence charsequence)
    {
        mText = charsequence;
        if (mPosition >= 0)
        {
            TabLayout.access$100(mParent, mPosition);
        }
        return this;
    }


    (TabLayout tablayout)
    {
        mPosition = -1;
        mParent = tablayout;
    }
}
