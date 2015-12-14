// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.supertooltips;

import android.graphics.Typeface;
import android.view.View;

public class ToolTip
{
    public static final class AnimationType extends Enum
    {

        private static final AnimationType $VALUES[];
        public static final AnimationType FROM_MASTER_VIEW;
        public static final AnimationType FROM_TOP;
        public static final AnimationType NONE;

        public static AnimationType valueOf(String s)
        {
            return (AnimationType)Enum.valueOf(com/nhaarman/supertooltips/ToolTip$AnimationType, s);
        }

        public static AnimationType[] values()
        {
            return (AnimationType[])$VALUES.clone();
        }

        static 
        {
            FROM_MASTER_VIEW = new AnimationType("FROM_MASTER_VIEW", 0);
            FROM_TOP = new AnimationType("FROM_TOP", 1);
            NONE = new AnimationType("NONE", 2);
            $VALUES = (new AnimationType[] {
                FROM_MASTER_VIEW, FROM_TOP, NONE
            });
        }

        private AnimationType(String s, int i)
        {
            super(s, i);
        }
    }


    private AnimationType mAnimationType;
    private int mColor;
    private View mContentView;
    private boolean mShouldShowShadow;
    private CharSequence mText;
    private int mTextColor;
    private int mTextResId;
    private Typeface mTypeface;

    public ToolTip()
    {
        mText = null;
        mTypeface = null;
        mTextResId = 0;
        mColor = 0;
        mContentView = null;
        mAnimationType = AnimationType.FROM_MASTER_VIEW;
    }

    public AnimationType getAnimationType()
    {
        return mAnimationType;
    }

    public int getColor()
    {
        return mColor;
    }

    public View getContentView()
    {
        return mContentView;
    }

    public CharSequence getText()
    {
        return mText;
    }

    public int getTextColor()
    {
        return mTextColor;
    }

    public int getTextResId()
    {
        return mTextResId;
    }

    public Typeface getTypeface()
    {
        return mTypeface;
    }

    public boolean shouldShowShadow()
    {
        return mShouldShowShadow;
    }

    public ToolTip withAnimationType(AnimationType animationtype)
    {
        mAnimationType = animationtype;
        return this;
    }

    public ToolTip withColor(int i)
    {
        mColor = i;
        return this;
    }

    public ToolTip withContentView(View view)
    {
        mContentView = view;
        return this;
    }

    public ToolTip withShadow()
    {
        mShouldShowShadow = true;
        return this;
    }

    public ToolTip withText(int i)
    {
        mTextResId = i;
        mText = null;
        return this;
    }

    public ToolTip withText(int i, Typeface typeface)
    {
        mTextResId = i;
        mText = null;
        withTypeface(typeface);
        return this;
    }

    public ToolTip withText(CharSequence charsequence)
    {
        mText = charsequence;
        mTextResId = 0;
        return this;
    }

    public ToolTip withTextColor(int i)
    {
        mTextColor = i;
        return this;
    }

    public void withTypeface(Typeface typeface)
    {
        mTypeface = typeface;
    }

    public ToolTip withoutShadow()
    {
        mShouldShowShadow = false;
        return this;
    }
}
