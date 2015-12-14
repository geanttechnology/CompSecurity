// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class ProgressHUD extends Dialog
{

    public ProgressHUD(Context context)
    {
        super(context);
    }

    public ProgressHUD(Context context, int i)
    {
        super(context, i);
    }

    public static ProgressHUD show(Context context, CharSequence charsequence, boolean flag, boolean flag1, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        context = new ProgressHUD(context, 0x7f09009b);
        context.setTitle("");
        context.setContentView(0x7f030034);
        if (charsequence == null || charsequence.length() == 0)
        {
            context.findViewById(0x7f0800f6).setVisibility(8);
        } else
        {
            ((TextView)context.findViewById(0x7f0800f6)).setText(charsequence);
        }
        context.setCancelable(flag1);
        context.setOnCancelListener(oncancellistener);
        context.getWindow().getAttributes().gravity = 17;
        charsequence = context.getWindow().getAttributes();
        charsequence.dimAmount = 0.2F;
        context.getWindow().setAttributes(charsequence);
        context.show();
        return context;
    }

    public void onWindowFocusChanged(boolean flag)
    {
        ((AnimationDrawable)((ImageView)findViewById(0x7f0800f5)).getBackground()).start();
    }

    public void setMessage(CharSequence charsequence)
    {
        if (charsequence != null && charsequence.length() > 0)
        {
            findViewById(0x7f0800f6).setVisibility(0);
            TextView textview = (TextView)findViewById(0x7f0800f6);
            textview.setText(charsequence);
            textview.invalidate();
        }
    }
}
