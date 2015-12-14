// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;

public class FadeImageButton extends ImageButton
{

    public static AlphaAnimation buttonClick = new AlphaAnimation(1.0F, 0.8F);

    public FadeImageButton(Context context)
    {
        super(context);
        addEffect();
    }

    public FadeImageButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        addEffect();
    }

    public FadeImageButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        addEffect();
    }

    private void addEffect()
    {
        setOnTouchListener(new android.view.View.OnTouchListener() {

            final FadeImageButton this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                switch (motionevent.getAction())
                {
                default:
                    return false;

                case 0: // '\0'
                    setColorFilter(0x99000000);
                    Log.d("FadeButton", "Darkened");
                    return false;

                case 1: // '\001'
                    setColorFilter(0);
                    break;
                }
                Log.d("FadeButton", "Lightened");
                return false;
            }

            
            {
                this$0 = FadeImageButton.this;
                super();
            }
        });
    }

}
