// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import com.aviary.android.feather.sdk.graphics.GlowBitmapDrawable;
import com.aviary.android.feather.sdk.utils.UIUtils;

public class AviaryHighlightImageButton extends ImageView
{
    public static interface OnCheckedChangeListener
    {

        public abstract void onCheckedChanged(AviaryHighlightImageButton aviaryhighlightimagebutton, boolean flag, boolean flag1);
    }

    static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i)
            {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        boolean checked;

        public String toString()
        {
            return (new StringBuilder()).append("CompoundButton.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" checked=").append(checked).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(checked));
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            checked = ((Boolean)parcel.readValue(null)).booleanValue();
        }


        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }


    private static final int CHECKED_STATE_SET[] = {
        0x10100a0
    };
    private static final String LOG_TAG = "AviaryHighlightImageButton";
    private android.graphics.PorterDuff.Mode mBlendMode;
    private boolean mBroadcasting;
    private boolean mChecked;
    private ColorFilter mColorFilterTintChecked;
    private ColorFilter mColorFilterTintPressed;
    private ColorFilter mColorFilterTintSelected;
    private int mGlowSize;
    private int mGlowStatus;
    private int mHighlightColorChecked;
    private int mHighlightColorPressed;
    private int mHighlightColorSelected;
    private int mHighlightMode;
    private OnCheckedChangeListener mOnCheckedChangeListener;
    private boolean mToggleEnabled;
    private boolean mUnToggleUserEnabled;

    public AviaryHighlightImageButton(Context context)
    {
        this(context, null);
    }

    public AviaryHighlightImageButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, com.aviary.android.feather.sdk.R.attr.aviaryHighlightImageButtonStyle);
    }

    public AviaryHighlightImageButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mHighlightColorPressed = 0;
        mHighlightColorChecked = 0;
        mHighlightColorSelected = 0;
        context = context.getTheme().obtainStyledAttributes(attributeset, com.aviary.android.feather.sdk.R.styleable.AviaryHighlightImageButton, i, 0);
        mHighlightColorPressed = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryHighlightImageButton_aviary_highlightColorPressed, -1);
        mHighlightColorChecked = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryHighlightImageButton_aviary_highlightColorChecked, -1);
        mHighlightColorSelected = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryHighlightImageButton_aviary_highlightColorSelected, -1);
        mToggleEnabled = context.getBoolean(com.aviary.android.feather.sdk.R.styleable.AviaryHighlightImageButton_aviary_toggleable, false);
        mUnToggleUserEnabled = context.getBoolean(com.aviary.android.feather.sdk.R.styleable.AviaryHighlightImageButton_aviary_untoggleable, true);
        attributeset = context.getString(com.aviary.android.feather.sdk.R.styleable.AviaryHighlightImageButton_aviary_blendMode);
        mGlowStatus = context.getInt(com.aviary.android.feather.sdk.R.styleable.AviaryHighlightImageButton_aviary_glowMode, 0);
        mGlowSize = context.getInt(com.aviary.android.feather.sdk.R.styleable.AviaryHighlightImageButton_aviary_glowSize, 7);
        mHighlightMode = context.getInteger(com.aviary.android.feather.sdk.R.styleable.AviaryHighlightImageButton_aviary_highlightMode, 2);
        boolean flag = context.getBoolean(com.aviary.android.feather.sdk.R.styleable.AviaryHighlightImageButton_aviary_checked, false);
        if (!mToggleEnabled)
        {
            flag = false;
        }
        if (UIUtils.checkBits(mGlowStatus, 2))
        {
            mColorFilterTintPressed = new LightingColorFilter(mHighlightColorPressed, mHighlightColorPressed);
        }
        if (UIUtils.checkBits(mGlowStatus, 4))
        {
            mColorFilterTintChecked = new LightingColorFilter(mHighlightColorChecked, mHighlightColorChecked);
        }
        if (UIUtils.checkBits(mGlowStatus, 8))
        {
            mColorFilterTintSelected = new LightingColorFilter(mHighlightColorSelected, mHighlightColorSelected);
        }
        if (attributeset != null)
        {
            mBlendMode = android.graphics.PorterDuff.Mode.valueOf(attributeset);
        } else
        {
            mBlendMode = android.graphics.PorterDuff.Mode.MULTIPLY;
        }
        setChecked(flag, false);
        flag = context.getBoolean(com.aviary.android.feather.sdk.R.styleable.AviaryHighlightImageButton_android_focusable, true);
        context.recycle();
        setFocusable(flag);
        if (getDrawable() instanceof GlowBitmapDrawable)
        {
            ((GlowBitmapDrawable)getDrawable()).updateConfig(mHighlightColorPressed, mHighlightColorChecked, mHighlightColorSelected, mGlowSize, mHighlightMode, mGlowStatus);
        }
    }

    static boolean glowChecked(int i)
    {
        return UIUtils.checkBits(i, 4);
    }

    static boolean glowPressed(int i)
    {
        return UIUtils.checkBits(i, 2);
    }

    static boolean glowSelected(int i)
    {
        return UIUtils.checkBits(i, 8);
    }

    public boolean isChecked()
    {
        return mChecked;
    }

    public int[] onCreateDrawableState(int i)
    {
        Drawable drawable = getDrawable();
        int ai[] = super.onCreateDrawableState(i + 1);
        if (drawable != null && mBlendMode != null)
        {
            boolean flag = isPressed();
            boolean flag1 = isChecked();
            updateDrawable(drawable, flag, flag1, isSelected());
            if (flag1)
            {
                mergeDrawableStates(ai, CHECKED_STATE_SET);
            }
        }
        return ai;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(com/aviary/android/feather/sdk/widget/AviaryHighlightImageButton.getName());
        accessibilityevent.setChecked(mChecked);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
    {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            accessibilitynodeinfo.setClassName(com/aviary/android/feather/sdk/widget/AviaryHighlightImageButton.getName());
        }
        accessibilitynodeinfo.setCheckable(mToggleEnabled);
        accessibilitynodeinfo.setChecked(mChecked);
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        setChecked(((SavedState) (parcelable)).checked, false);
        requestLayout();
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.checked = isChecked();
        return savedstate;
    }

    protected boolean onSetAlpha(int i)
    {
        return false;
    }

    public boolean performClick()
    {
        toggle();
        return super.performClick();
    }

    public void setChecked(boolean flag)
    {
        setChecked(flag, false);
    }

    protected void setChecked(boolean flag, boolean flag1)
    {
        if (mToggleEnabled && mChecked != flag)
        {
            mChecked = flag;
            refreshDrawableState();
            if (!mBroadcasting)
            {
                mBroadcasting = true;
                if (mOnCheckedChangeListener != null)
                {
                    mOnCheckedChangeListener.onCheckedChanged(this, mChecked, flag1);
                }
                mBroadcasting = false;
                return;
            }
        }
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        Drawable drawable = getDrawable();
        if (drawable instanceof GlowBitmapDrawable)
        {
            ((GlowBitmapDrawable)drawable).setBitmap(bitmap);
            setImageDrawable((GlowBitmapDrawable)drawable);
            return;
        } else
        {
            setImageDrawable(new GlowBitmapDrawable(bitmap, mHighlightColorPressed, mHighlightColorChecked, mHighlightColorSelected, mGlowSize, mHighlightMode, mGlowStatus));
            return;
        }
    }

    public void setImageDrawable(Drawable drawable)
    {
        if (!(drawable instanceof BitmapDrawable)) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = getDrawable();
        if (obj instanceof GlowBitmapDrawable)
        {
            ((GlowBitmapDrawable)obj).setBitmap(((BitmapDrawable)drawable).getBitmap());
        } else
        {
            obj = new GlowBitmapDrawable(((BitmapDrawable)drawable).getBitmap(), mHighlightColorPressed, mHighlightColorChecked, mHighlightColorSelected, mGlowSize, mHighlightMode, mGlowStatus);
        }
_L4:
        super.setImageDrawable(((Drawable) (obj)));
        return;
_L2:
        obj = drawable;
        if (drawable instanceof StateListDrawable)
        {
            obj = drawable;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setImageResource(int i)
    {
        Resources resources = getResources();
        try
        {
            setImageDrawable(resources.getDrawable(i));
            invalidate();
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        super.setImageResource(i);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener oncheckedchangelistener)
    {
        mOnCheckedChangeListener = oncheckedchangelistener;
    }

    public void setPressed(boolean flag)
    {
        super.setPressed(flag);
        Drawable drawable = getDrawable();
        if (drawable != null && mBlendMode != null)
        {
            updateDrawable(drawable, flag, isChecked(), isSelected());
        }
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        Drawable drawable = getDrawable();
        if (drawable != null && mBlendMode != null)
        {
            updateDrawable(drawable, isPressed(), isChecked(), flag);
        }
    }

    public void toggle()
    {
        if (mChecked && !mUnToggleUserEnabled)
        {
            return;
        }
        boolean flag;
        if (!mChecked)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setChecked(flag, true);
    }

    protected void updateDrawable(Drawable drawable, boolean flag, boolean flag1, boolean flag2)
    {
        if (drawable.isStateful())
        {
            invalidate();
        } else
        if (flag || flag1 || flag2)
        {
            if (flag && UIUtils.checkBits(mHighlightMode, 2))
            {
                if (mColorFilterTintPressed != null)
                {
                    drawable.setColorFilter(mColorFilterTintPressed);
                    return;
                } else
                {
                    drawable.setColorFilter(mHighlightColorPressed, mBlendMode);
                    return;
                }
            }
            if (flag1 && UIUtils.checkBits(mHighlightMode, 4))
            {
                if (mColorFilterTintChecked != null)
                {
                    drawable.setColorFilter(mColorFilterTintChecked);
                    return;
                } else
                {
                    drawable.setColorFilter(mHighlightColorChecked, mBlendMode);
                    return;
                }
            }
            if (flag2 && UIUtils.checkBits(mHighlightMode, 8))
            {
                if (mColorFilterTintSelected != null)
                {
                    drawable.setColorFilter(mColorFilterTintSelected);
                    return;
                } else
                {
                    drawable.setColorFilter(mHighlightColorChecked, mBlendMode);
                    return;
                }
            }
        } else
        {
            drawable.clearColorFilter();
            return;
        }
    }

}
