// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.graphics.drawable;


public interface EditableDrawable
{
    public static interface OnSizeChange
    {

        public abstract void onSizeChanged(EditableDrawable editabledrawable, float f, float f1, float f2, float f3);
    }


    public static final int CURSOR_BLINK_TIME = 400;

    public abstract void beginEdit();

    public abstract void endEdit();

    public abstract float getFontMetrics(android.graphics.Paint.FontMetrics fontmetrics);

    public abstract int getNumLines();

    public abstract boolean getStrokeEnabled();

    public abstract CharSequence getText();

    public abstract int getTextColor();

    public abstract float getTextSize();

    public abstract int getTextStrokeColor();

    public abstract boolean isEditing();

    public abstract boolean isTextHint();

    public abstract void setBounds(float f, float f1, float f2, float f3);

    public abstract void setOnSizeChangeListener(OnSizeChange onsizechange);

    public abstract void setStrokeEnabled(boolean flag);

    public abstract void setText(CharSequence charsequence);

    public abstract void setText(String s);

    public abstract void setTextColor(int i);

    public abstract void setTextHint(CharSequence charsequence);

    public abstract void setTextHint(String s);

    public abstract void setTextStrokeColor(int i);
}
