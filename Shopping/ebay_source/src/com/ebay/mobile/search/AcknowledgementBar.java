// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.common.EbayTimer;

public class AcknowledgementBar
    implements android.view.View.OnClickListener, android.view.animation.Animation.AnimationListener, com.ebay.common.EbayTimer.OnTimerEvent
{
    public static interface Listener
    {

        public abstract void onAction(Object obj);

        public abstract void onNonActionDismiss();
    }

    public static class SimpleListener
        implements Listener
    {

        public void onAction(Object obj)
        {
        }

        public void onNonActionDismiss()
        {
        }

        public SimpleListener()
        {
        }
    }


    private View ackBarView;
    private Button actionButton;
    private final Animation animateIn;
    private final Animation animateOut;
    private Object data;
    private View dismissButton;
    private Listener listener;
    private TextView subTitleView;
    private long timeout;
    final EbayTimer timer;
    private TextView titleView;

    public AcknowledgementBar(Context context, ViewGroup viewgroup, int i)
    {
        timeout = 3000L;
        ackBarView = viewgroup.findViewById(0x7f100087);
        if (ackBarView == null)
        {
            ackBarView = LayoutInflater.from(context).inflate(i, viewgroup, false);
            viewgroup.addView(ackBarView);
        }
        titleView = (TextView)ackBarView.findViewById(0x7f10005f);
        subTitleView = (TextView)ackBarView.findViewById(0x7f10008a);
        actionButton = (Button)ackBarView.findViewById(0x7f100089);
        actionButton.setOnClickListener(this);
        dismissButton = ackBarView.findViewById(0x7f100088);
        if (dismissButton != null)
        {
            dismissButton.setOnClickListener(this);
            enableDismissControl(true);
        }
        timer = (new EbayTimer(timeout)).setNotifyOnStart(false);
        context = new AnimationSet(true);
        context.addAnimation(new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F));
        context.addAnimation(new AlphaAnimation(0.0F, 1.0F));
        animateIn = context;
        animateIn.setAnimationListener(this);
        animateIn.setDuration(350L);
        context = new AnimationSet(true);
        context.addAnimation(new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F));
        context.addAnimation(new AlphaAnimation(1.0F, 0.0F));
        animateOut = context;
        animateOut.setDuration(350L);
        animateOut.setAnimationListener(this);
    }

    private void cleanup()
    {
        listener = null;
        data = null;
        timer.setOnTimerEvent(null);
    }

    public void OnTimer()
    {
        dismiss();
    }

    public void dismiss()
    {
        if (!timer.isTimerRunning() || listener == null)
        {
            return;
        }
        timer.stop();
        ackBarView.startAnimation(animateOut);
        if (listener != null)
        {
            listener.onNonActionDismiss();
        }
        cleanup();
    }

    public AcknowledgementBar enableDismissControl(boolean flag)
    {
        if (dismissButton != null)
        {
            View view = dismissButton;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
        }
        return this;
    }

    public void onAnimationEnd(Animation animation)
    {
        int i = 0;
        boolean flag;
        if (animation == animateIn)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        animation = ackBarView;
        if (!flag)
        {
            i = 4;
        }
        animation.setVisibility(i);
        if (flag)
        {
            timer.start();
        } else
        if (listener != null)
        {
            listener.onNonActionDismiss();
            cleanup();
            return;
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        ackBarView.setVisibility(0);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755145: 
            timer.stop();
            ackBarView.startAnimation(animateOut);
            if (listener != null)
            {
                listener.onAction(data);
            }
            cleanup();
            return;

        case 2131755144: 
            dismiss();
            return;
        }
    }

    public void show(String s, String s1, Object obj, Listener listener1)
    {
        if (timer.isTimerRunning())
        {
            dismiss();
        }
        timer.setOnTimerEvent(this);
        data = obj;
        listener = listener1;
        titleView.setText(s);
        if (TextUtils.isEmpty(s1))
        {
            subTitleView.setVisibility(8);
        } else
        {
            subTitleView.setText(s1);
            subTitleView.setVisibility(0);
        }
        ackBarView.startAnimation(animateIn);
    }
}
