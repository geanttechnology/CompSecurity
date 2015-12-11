// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import co.vine.android.animation.SimpleAnimationListener;

public class TooltipOverlayView extends FrameLayout
    implements android.view.View.OnTouchListener
{

    private Context mContext;
    private TextView mTextView;
    private int mTop;

    public TooltipOverlayView(Context context, int i)
    {
        super(context);
        mContext = context;
        context = getResources();
        setOnTouchListener(this);
        setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        Object obj = (TextView)LayoutInflater.from(mContext).inflate(0x7f03009c, this, false);
        int j = context.getColor(0x7f090083);
        ((TextView) (obj)).getBackground().setColorFilter(j, android.graphics.PorterDuff.Mode.SRC_IN);
        ((TextView) (obj)).setText(i);
        mTextView = ((TextView) (obj));
        obj = new View(mContext);
        ((View) (obj)).setBackgroundDrawable(new ColorDrawable(context.getColor(0x7f090015)));
        addView(((View) (obj)));
        addView(mTextView);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (mTextView != null)
        {
            mTextView.setY(mTop + getResources().getDimensionPixelSize(0x7f0b007b));
        }
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (getAnimation() == null)
        {
            view = new AlphaAnimation(1.0F, 0.0F);
            view.setDuration(200L);
            view.setFillAfter(true);
            view.setAnimationListener(new SimpleAnimationListener() {

                final TooltipOverlayView this$0;

                public void onAnimationEnd(Animation animation)
                {
                    setVisibility(8);
                    animation = (ViewGroup)getParent();
                    if (animation != null)
                    {
                        animation.removeView(TooltipOverlayView.this);
                    }
                }

            
            {
                this$0 = TooltipOverlayView.this;
                super();
            }
            });
            startAnimation(view);
        }
        return false;
    }

    public void showTooltip(int i)
    {
        mTop = i;
        ((ViewGroup)((Activity)mContext).getWindow().getDecorView()).addView(this);
        requestLayout();
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation.setDuration(200L);
        alphaanimation.setFillAfter(true);
        alphaanimation.setAnimationListener(new SimpleAnimationListener() {

            final TooltipOverlayView this$0;

            public void onAnimationEnd(Animation animation)
            {
                clearAnimation();
            }

            
            {
                this$0 = TooltipOverlayView.this;
                super();
            }
        });
        startAnimation(alphaanimation);
    }
}
