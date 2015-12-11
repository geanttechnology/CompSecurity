// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.poshmark.utils.TextValidator;
import com.poshmark.utils.ViewUtils;

public class PMEditText extends EditText
{
    public static interface OnTapListener
    {

        public abstract void onTap(View view);
    }


    String defaultMessage;
    boolean isKeyboardInput;
    boolean isRequired;
    OnTapListener listener;
    String message;
    com.poshmark.utils.TextValidator.MODE mode;
    TextValidator validator;

    public PMEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        isRequired = false;
        isKeyboardInput = true;
        validator = new TextValidator();
        defaultMessage = getResources().getString(0x7f06022a);
        Object obj = getContext().obtainStyledAttributes(attributeset, com.poshmark.app.R.styleable.PMEditText);
        isRequired = ((TypedArray) (obj)).getBoolean(0, false);
        isKeyboardInput = ((TypedArray) (obj)).getBoolean(1, true);
        if (isKeyboardInput)
        {
            mode = com.poshmark.utils.TextValidator.MODE.getMode(((TypedArray) (obj)).getInt(2, 1));
            validator.setValidatorMode(mode);
        }
        message = ((TypedArray) (obj)).getString(3);
        if (message == null)
        {
            message = defaultMessage;
        }
        attributeset = getContext().obtainStyledAttributes(attributeset, com.poshmark.app.R.styleable.PMCommon);
        obj = attributeset.getString(0);
        if (obj != null)
        {
            ViewUtils.setTypefaceForView(context, ((String) (obj)), this);
        }
        attributeset.recycle();
    }

    private boolean tapInView(float f, float f1)
    {
        int ai[] = new int[2];
        getLocationOnScreen(ai);
        int i = ai[0];
        int j = ai[1];
        return f > (float)i && f < (float)(getWidth() + i) && f1 > (float)j && f1 < (float)(getHeight() + j);
    }

    public String getValidatorString()
    {
        return getValidatorString(false);
    }

    public String getValidatorString(boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        String s = message;
_L4:
        return s;
_L2:
        String s1;
        s1 = validator.getErrorMessage(getContext(), getText().toString());
        if (s1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s = s1;
        if (!s1.isEmpty()) goto _L4; else goto _L3
_L3:
        return message;
    }

    public boolean isValid()
    {
        return validator.isValid(getText().toString());
    }

    public boolean onCheckIsTextEditor()
    {
        return isKeyboardInput;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag1 = true;
        boolean flag;
        if (isKeyboardInput)
        {
            flag = super.onTouchEvent(motionevent);
        } else
        {
            flag = flag1;
            if (motionevent.getAction() == 1)
            {
                flag = flag1;
                if (tapInView(motionevent.getRawX(), motionevent.getRawY()))
                {
                    flag = flag1;
                    if (listener != null)
                    {
                        listener.onTap(this);
                        return true;
                    }
                }
            }
        }
        return flag;
    }

    public void setOnTapListener(OnTapListener ontaplistener)
    {
        listener = ontaplistener;
    }
}
