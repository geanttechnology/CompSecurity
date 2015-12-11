// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

public class AnimatedDialog extends Dialog
{

    private boolean isClosing_;

    public AnimatedDialog(Context context)
    {
        super(context);
        isClosing_ = false;
        init(context);
    }

    public AnimatedDialog(Context context, int i)
    {
        super(context, i);
        isClosing_ = false;
        init(context);
    }

    public AnimatedDialog(Context context, boolean flag, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        super(context, flag, oncancellistener);
        isClosing_ = false;
        init(context);
    }

    private void init(Context context)
    {
        setDialogWindowAttributes();
        setOnKeyListener(new android.content.DialogInterface.OnKeyListener() {

            final AnimatedDialog this$0;

            public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
            {
                if (i == 4)
                {
                    slideClose();
                }
                return true;
            }

            
            {
                this$0 = AnimatedDialog.this;
                super();
            }
        });
    }

    private void slideClose()
    {
        if (!isClosing_)
        {
            isClosing_ = true;
            TranslateAnimation translateanimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
            translateanimation.setDuration(500L);
            translateanimation.setInterpolator(new DecelerateInterpolator());
            ((ViewGroup)getWindow().getDecorView()).getChildAt(0).startAnimation(translateanimation);
            translateanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                final AnimatedDialog this$0;

                public void onAnimationEnd(Animation animation)
                {
                    dismiss();
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            
            {
                this$0 = AnimatedDialog.this;
                super();
            }
            });
        }
    }

    private void slideOpen()
    {
        TranslateAnimation translateanimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
        translateanimation.setDuration(500L);
        translateanimation.setInterpolator(new AccelerateInterpolator());
        ((ViewGroup)getWindow().getDecorView()).getChildAt(0).startAnimation(translateanimation);
        super.show();
    }

    public void cancel()
    {
        slideClose();
    }

    public void setContentView(int i)
    {
        setDialogWindowAttributes();
        super.setContentView(i);
    }

    public void setDialogWindowAttributes()
    {
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().addFlags(2);
        getWindow().addFlags(1024);
        android.view.WindowManager.LayoutParams layoutparams = new android.view.WindowManager.LayoutParams();
        layoutparams.copyFrom(getWindow().getAttributes());
        layoutparams.width = -1;
        layoutparams.height = -1;
        layoutparams.gravity = 80;
        layoutparams.dimAmount = 0.8F;
        getWindow().setAttributes(layoutparams);
        getWindow().setWindowAnimations(0x10a0002);
        setCanceledOnTouchOutside(true);
    }

    public void show()
    {
        slideOpen();
    }

}
