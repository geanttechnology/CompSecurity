// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.Button;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class SpinnerButton extends Button
{

    private CharSequence buttonText;
    private Drawable oldDrawable;
    private boolean oldEnabled;
    private Drawable progress;
    private boolean useCompoundDrawable;

    public SpinnerButton(Context context)
    {
        super(context);
    }

    public SpinnerButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context, attributeset);
    }

    public SpinnerButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context, attributeset);
    }

    public Drawable getProgress()
    {
        return progress;
    }

    protected void init(Context context, AttributeSet attributeset)
    {
        attributeset = context.obtainStyledAttributes(attributeset, com.groupon.R.styleable.SpinnerButton, 0, 0);
        useCompoundDrawable = attributeset.getBoolean(0, false);
        context = attributeset.getDrawable(1);
        if (context == null)
        {
            context = getResources().getDrawable(0x7f0202f7);
        }
        progress = context;
        attributeset.recycle();
    }

    public boolean isSpinning()
    {
        Ln.d("SPINNING: isSpinning: drawable = %s", new Object[] {
            progress
        });
        if (progress instanceof Animatable)
        {
            Animatable animatable = (Animatable)progress;
            Ln.d("SPINNING: isSpinning? %s", new Object[] {
                Boolean.valueOf(animatable.isRunning())
            });
            return animatable.isRunning();
        } else
        {
            Ln.d("SPINNING: not an animatable", new Object[0]);
            return false;
        }
    }

    protected void revertFromBackground()
    {
        setBackground(oldDrawable);
        setEnabled(oldEnabled);
        setText(buttonText);
    }

    protected void revertFromCompoundDrawable()
    {
        Drawable adrawable[] = getCompoundDrawables();
        setCompoundDrawablesWithIntrinsicBounds(adrawable[0], adrawable[1], oldDrawable, adrawable[3]);
        setEnabled(oldEnabled);
    }

    protected void revertProgressDrawable()
    {
        if (useCompoundDrawable)
        {
            revertFromCompoundDrawable();
            return;
        } else
        {
            revertFromBackground();
            return;
        }
    }

    public void setProgress(Drawable drawable)
    {
        progress = drawable;
    }

    protected void setProgressAsBackground()
    {
        oldDrawable = getBackground();
        LayerDrawable layerdrawable = new LayerDrawable(new Drawable[] {
            oldDrawable, progress
        });
        int i = getPaddingLeft();
        int j = getPaddingTop();
        int k = getPaddingRight();
        int l = getPaddingBottom();
        setBackground(layerdrawable);
        setPadding(i, j, k, l);
        oldEnabled = isEnabled();
        setEnabled(false);
        setText("");
    }

    protected void setProgressAsCompoundDrawable()
    {
        Drawable adrawable[] = getCompoundDrawables();
        oldDrawable = adrawable[2];
        setCompoundDrawablesWithIntrinsicBounds(adrawable[0], adrawable[1], progress, adrawable[3]);
        oldEnabled = isEnabled();
        setEnabled(false);
    }

    protected void setProgressDrawable()
    {
        if (useCompoundDrawable)
        {
            setProgressAsCompoundDrawable();
            return;
        } else
        {
            setProgressAsBackground();
            return;
        }
    }

    public void setText(CharSequence charsequence, android.widget.TextView.BufferType buffertype)
    {
        super.setText(charsequence, buffertype);
        if (Strings.notEmpty(charsequence))
        {
            buttonText = charsequence;
        }
    }

    public void setupCancelActionButtonStyle()
    {
        setBackgroundResource(0x7f020097);
        progress.setColorFilter(getResources().getColor(0x7f0e01c8), android.graphics.PorterDuff.Mode.SRC_IN);
        setTextColor(getResources().getColor(0x7f0e01c8));
    }

    public void setupPrimaryActionButtonStyle()
    {
        setBackgroundResource(0x7f0202b8);
        progress.setColorFilter(getResources().getColor(0x7f0e01a9), android.graphics.PorterDuff.Mode.SRC_IN);
        setTextColor(getResources().getColor(0x7f0e01d7));
    }

    public void setupSecondaryActionButtonStyle()
    {
        setBackgroundResource(0x7f0202d4);
        progress.setColorFilter(getResources().getColor(0x7f0e01d9), android.graphics.PorterDuff.Mode.SRC_IN);
        setTextColor(getResources().getColor(0x7f0e01d9));
    }

    public void startSpinning()
    {
        if (isSpinning())
        {
            Ln.d("SPINNING: startSpinning: already spinning", new Object[0]);
        } else
        {
            Ln.d("SPINNING: startSpinning", new Object[0]);
            setProgressDrawable();
            if (progress instanceof Animatable)
            {
                ((Animatable)progress).start();
                return;
            }
        }
    }

    public void stopSpinning()
    {
        if (!isSpinning())
        {
            Ln.d("SPINNING: stopSpinning: not spinning", new Object[0]);
            return;
        }
        Ln.d("SPINNING: stopSpinning", new Object[0]);
        if (progress instanceof Animatable)
        {
            ((Animatable)progress).stop();
        }
        revertProgressDrawable();
    }
}
