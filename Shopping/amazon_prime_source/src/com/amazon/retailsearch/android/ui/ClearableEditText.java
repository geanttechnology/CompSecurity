// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

public class ClearableEditText extends EditText
    implements TextWatcher
{

    private static final int DEFAULT_CLEAR_BUTTON_DRAWABLE;
    private Bitmap mClearTextBitmap;
    private int mClearTextButtonPaddingLeft;
    private int mClearTextButtonPaddingRight;
    private boolean mIsClearTextButtonEnabled;
    private boolean mIsClearTextButtonVisible;
    private boolean mIsHandlingAction;
    private Paint mPaint;

    public ClearableEditText(Context context)
    {
        super(context);
    }

    public ClearableEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public ClearableEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    private void loadClearButtonBitmap()
    {
        if (mClearTextBitmap == null)
        {
            mClearTextBitmap = BitmapFactory.decodeResource(getResources(), DEFAULT_CLEAR_BUTTON_DRAWABLE);
        }
    }

    private void removeClearButtonBitmap()
    {
        if (mClearTextBitmap != null)
        {
            mClearTextBitmap.recycle();
            mClearTextBitmap = null;
        }
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void enableClearTextButton(boolean flag)
    {
        if (!flag || mIsClearTextButtonEnabled) goto _L2; else goto _L1
_L1:
        mPaint = new Paint();
        loadClearButtonBitmap();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight() + mClearTextBitmap.getWidth(), getPaddingBottom());
        addTextChangedListener(this);
_L4:
        mIsClearTextButtonEnabled = flag;
        invalidate();
        return;
_L2:
        if (!flag && mIsClearTextButtonEnabled)
        {
            if (mClearTextBitmap != null)
            {
                setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight() - mClearTextBitmap.getWidth(), getPaddingBottom());
                removeClearButtonBitmap();
            }
            mPaint = null;
            removeTextChangedListener(this);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (mIsClearTextButtonEnabled)
        {
            loadClearButtonBitmap();
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        removeClearButtonBitmap();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (mIsClearTextButtonEnabled && mIsClearTextButtonVisible && mClearTextBitmap != null)
        {
            canvas.drawBitmap(mClearTextBitmap, (getScrollX() + getWidth()) - mClearTextBitmap.getWidth() - mClearTextButtonPaddingRight, getScrollY() + (getHeight() - mClearTextBitmap.getHeight()) / 2, mPaint);
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        boolean flag;
        if (!TextUtils.isEmpty(charsequence))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsClearTextButtonVisible = flag;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (mIsClearTextButtonEnabled && mIsClearTextButtonVisible && motionevent.getX() > (float)(getRight() - getPaddingRight()))
        {
            switch (motionevent.getAction())
            {
            case 2: // '\002'
            default:
                return true;

            case 0: // '\0'
                mIsHandlingAction = true;
                return true;

            case 1: // '\001'
                if (mIsHandlingAction)
                {
                    setText("");
                }
                mIsHandlingAction = false;
                return true;

            case 3: // '\003'
                mIsHandlingAction = false;
                return true;
            }
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

    public void setClearTextButtonPadding(int i, int j)
    {
        setPadding(getPaddingLeft(), getPaddingTop(), (getPaddingRight() - mClearTextButtonPaddingLeft - mClearTextButtonPaddingRight) + i + j, getPaddingBottom());
        mClearTextButtonPaddingLeft = i;
        mClearTextButtonPaddingRight = j;
        invalidate();
    }

    static 
    {
        DEFAULT_CLEAR_BUTTON_DRAWABLE = com.amazon.retailsearch.R.drawable.rs_clear_search_api_holo_light;
    }
}
