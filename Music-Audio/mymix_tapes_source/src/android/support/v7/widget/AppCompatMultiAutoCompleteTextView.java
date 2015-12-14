// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.internal.widget.TintContextWrapper;
import android.support.v7.internal.widget.TintInfo;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.MultiAutoCompleteTextView;

public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView
    implements TintableBackgroundView
{

    private static final int TINT_ATTRS[] = {
        0x10100d4, 0x1010176
    };
    private TintInfo mBackgroundTint;
    private TintManager mTintManager;

    public AppCompatMultiAutoCompleteTextView(Context context)
    {
        this(context, null);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, android.support.v7.appcompat.R.attr.autoCompleteTextViewStyle);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeset, int i)
    {
        super(TintContextWrapper.wrap(context), attributeset, i);
        if (TintManager.SHOULD_BE_USED)
        {
            context = TintTypedArray.obtainStyledAttributes(getContext(), attributeset, TINT_ATTRS, i, 0);
            mTintManager = context.getTintManager();
            if (context.hasValue(0))
            {
                attributeset = context.getTintManager().getTintList(context.getResourceId(0, -1));
                if (attributeset != null)
                {
                    setSupportBackgroundTintList(attributeset);
                }
            }
            if (context.hasValue(1))
            {
                setDropDownBackgroundDrawable(context.getDrawable(1));
            }
            context.recycle();
        }
    }

    private void applySupportBackgroundTint()
    {
        if (getBackground() != null && mBackgroundTint != null)
        {
            TintManager.tintViewBackground(this, mBackgroundTint);
        }
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        applySupportBackgroundTint();
    }

    public ColorStateList getSupportBackgroundTintList()
    {
        if (mBackgroundTint != null)
        {
            return mBackgroundTint.mTintList;
        } else
        {
            return null;
        }
    }

    public android.graphics.PorterDuff.Mode getSupportBackgroundTintMode()
    {
        if (mBackgroundTint != null)
        {
            return mBackgroundTint.mTintMode;
        } else
        {
            return null;
        }
    }

    public void setDropDownBackgroundResource(int i)
    {
        if (mTintManager != null)
        {
            setDropDownBackgroundDrawable(mTintManager.getDrawable(i));
            return;
        } else
        {
            super.setDropDownBackgroundResource(i);
            return;
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorstatelist)
    {
        if (mBackgroundTint == null)
        {
            mBackgroundTint = new TintInfo();
        }
        mBackgroundTint.mTintList = colorstatelist;
        mBackgroundTint.mHasTintList = true;
        applySupportBackgroundTint();
    }

    public void setSupportBackgroundTintMode(android.graphics.PorterDuff.Mode mode)
    {
        if (mBackgroundTint == null)
        {
            mBackgroundTint = new TintInfo();
        }
        mBackgroundTint.mTintMode = mode;
        mBackgroundTint.mHasTintMode = true;
        applySupportBackgroundTint();
    }

}
