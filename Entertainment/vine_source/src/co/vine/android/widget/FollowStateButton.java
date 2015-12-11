// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import co.vine.android.Settings;
import co.vine.android.api.VineUser;

public class FollowStateButton extends Button
{

    public static final int STATE_FOLLOWING = 3;
    public static final int STATE_FOLLOW_REQUESTED = 4;
    public static final int STATE_NOT_FOLLOWING = 2;
    public static final int STATE_SELF = 1;
    private int mColor;
    private int mFollowRequestedDrawableRes;
    private int mFollowRequestedText;
    private int mFollowRequestedTextColor;
    private int mFollowingDrawableRes;
    private int mFollowingText;
    private int mFollowingTextColor;
    private int mNotFollowingDrawableRes;
    private int mNotFollowingText;
    private int mNotFollowingTextColor;
    private int mSelfDrawableRes;
    private int mSelfText;
    private int mSelfTextColor;
    private int mState;

    public FollowStateButton(Context context)
    {
        this(context, null);
    }

    public FollowStateButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public FollowStateButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = context.obtainStyledAttributes(attributeset, co.vine.android.R.styleable.FollowStateButton, i, 0);
        mSelfDrawableRes = context.getResourceId(0, 0x7f0200c0);
        mNotFollowingDrawableRes = context.getResourceId(3, 0x7f0200b4);
        mFollowingDrawableRes = context.getResourceId(6, 0x7f0200b7);
        mFollowRequestedDrawableRes = context.getResourceId(9, 0x7f0200bd);
        mSelfText = context.getResourceId(1, 0x7f0e01c5);
        mNotFollowingText = context.getResourceId(4, 0x7f0e00fb);
        mFollowingText = context.getResourceId(7, 0x7f0e0102);
        mFollowRequestedText = context.getResourceId(10, 0x7f0e0100);
        attributeset = getResources();
        mSelfTextColor = context.getColor(2, attributeset.getColor(0x7f090070));
        mNotFollowingTextColor = context.getColor(5, attributeset.getColor(0x7f09005c));
        mFollowingTextColor = context.getColor(5, attributeset.getColor(0x7f090051));
        mFollowRequestedTextColor = context.getColor(11, attributeset.getColor(0x7f09005c));
        mColor = attributeset.getColor(0x7f090096);
        context.recycle();
        setPadding(getResources().getDimensionPixelSize(0x7f0b0044), 0, 0, 0);
        invalidate();
    }

    private void setColors()
    {
        int i = mColor;
        mFollowingTextColor = -1;
        mNotFollowingTextColor = i;
        mFollowRequestedTextColor = i;
        if (getBackground() != null && mState != 1)
        {
            getBackground().setColorFilter(i, android.graphics.PorterDuff.Mode.SRC_ATOP);
        }
    }

    private void setState(int i)
    {
        i;
        JVM INSTR tableswitch 1 4: default 32
    //                   1 37
    //                   2 69
    //                   3 101
    //                   4 133;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        setColors();
        return;
_L2:
        setBackgroundResource(mSelfDrawableRes);
        setText(mSelfText);
        setTextColor(mSelfTextColor);
        mState = 1;
        continue; /* Loop/switch isn't completed */
_L3:
        setBackgroundResource(mNotFollowingDrawableRes);
        setText(mNotFollowingText);
        setTextColor(mNotFollowingTextColor);
        mState = 2;
        continue; /* Loop/switch isn't completed */
_L4:
        setBackgroundResource(mFollowingDrawableRes);
        setText(mFollowingText);
        setTextColor(mFollowingTextColor);
        mState = 3;
        continue; /* Loop/switch isn't completed */
_L5:
        setBackgroundResource(mFollowRequestedDrawableRes);
        setText(mFollowRequestedText);
        setTextColor(mFollowRequestedTextColor);
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void follow(VineUser vineuser)
    {
        if (vineuser.isPrivate())
        {
            if (mState != 4)
            {
                setState(4);
                invalidate();
            }
        } else
        if (mState != 3)
        {
            setState(3);
            invalidate();
            return;
        }
    }

    public int getState()
    {
        return mState;
    }

    public void setUser(long l, VineUser vineuser)
    {
        mColor = vineuser.profileBackground;
        if (mColor == Settings.DEFAULT_PROFILE_COLOR || mColor <= 0)
        {
            mColor = getResources().getColor(0x7f090096);
        }
        mColor = mColor | 0xff000000;
        if (l == vineuser.userId)
        {
            setState(1);
        } else
        if (vineuser.hasFollowRequested())
        {
            setState(4);
        } else
        if (vineuser.isFollowing())
        {
            setState(3);
        } else
        {
            setState(2);
        }
        setColors();
        invalidate();
    }

    public void unfollow()
    {
        if (mState != 2)
        {
            setState(2);
            invalidate();
        }
    }
}
