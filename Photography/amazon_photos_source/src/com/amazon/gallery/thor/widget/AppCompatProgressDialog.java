// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AppCompatProgressDialog extends Dialog
{
    public static class Builder
    {

        protected boolean cancellable;
        protected final Context context;
        protected boolean indeterminate;
        protected int max;
        protected String message;
        private android.content.DialogInterface.OnCancelListener onCancelListener;
        protected ProgressStyle progressStyle;
        protected String title;

        public AppCompatProgressDialog build()
        {
            return new AppCompatProgressDialog(this);
        }

        public Builder setCancellable(boolean flag)
        {
            cancellable = flag;
            return this;
        }

        public Builder setIndeterminate(boolean flag)
        {
            indeterminate = flag;
            return this;
        }

        public Builder setMax(int i)
        {
            max = i;
            return this;
        }

        public Builder setMessage(String s)
        {
            message = s;
            return this;
        }

        public Builder setStyle(ProgressStyle progressstyle)
        {
            progressStyle = progressstyle;
            return this;
        }

        public AppCompatProgressDialog show()
        {
            AppCompatProgressDialog appcompatprogressdialog = build();
            appcompatprogressdialog.show();
            return appcompatprogressdialog;
        }


        public Builder(Context context1)
        {
            progressStyle = ProgressStyle.SPINNER;
            indeterminate = true;
            max = 1;
            context = context1;
        }
    }

    public static final class ProgressStyle extends Enum
    {

        private static final ProgressStyle $VALUES[];
        public static final ProgressStyle HORIZONTAL;
        public static final ProgressStyle SPINNER;

        public static ProgressStyle valueOf(String s)
        {
            return (ProgressStyle)Enum.valueOf(com/amazon/gallery/thor/widget/AppCompatProgressDialog$ProgressStyle, s);
        }

        public static ProgressStyle[] values()
        {
            return (ProgressStyle[])$VALUES.clone();
        }

        static 
        {
            HORIZONTAL = new ProgressStyle("HORIZONTAL", 0);
            SPINNER = new ProgressStyle("SPINNER", 1);
            $VALUES = (new ProgressStyle[] {
                HORIZONTAL, SPINNER
            });
        }

        private ProgressStyle(String s, int i)
        {
            super(s, i);
        }
    }


    private Builder builder;
    private View contentView;
    private final Context context;
    private AlertDialog dialogDelegate;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private LayoutInflater inflater;
    private TextView messageView;
    private TextView minMaxView;
    private TextView percentageView;
    private ProgressBar progressBar;

    public AppCompatProgressDialog(Builder builder1)
    {
        super(builder1.context);
        context = builder1.context;
        builder = builder1;
        inflater = LayoutInflater.from(context);
        setLayout();
        init();
    }

    private void init()
    {
        messageView = (TextView)contentView.findViewById(0x7f0c0005);
        messageView.setText(builder.message);
        progressBar = (ProgressBar)contentView.findViewById(0x7f0c0004);
        int i = context.getResources().getColor(0x7f090004);
        android.graphics.PorterDuff.Mode mode = android.graphics.PorterDuff.Mode.SRC_ATOP;
        progressBar.getIndeterminateDrawable().setColorFilter(i, mode);
        if (isIndeterminateAllowed())
        {
            progressBar.getProgressDrawable().setColorFilter(i, mode);
            percentageView = (TextView)contentView.findViewById(0x7f0c0095);
            minMaxView = (TextView)contentView.findViewById(0x7f0c0096);
            setIndeterminate(builder.indeterminate);
            if (!isIndeterminate())
            {
                updateProgress(0);
            }
        }
        dialogDelegate = (new android.support.v7.app.AlertDialog.Builder(context)).setCancelable(builder.cancellable).setOnCancelListener(builder.onCancelListener).setView(contentView).setTitle(builder.title).create();
    }

    private void setLayout()
    {
        static class _cls2
        {

            static final int $SwitchMap$com$amazon$gallery$thor$widget$AppCompatProgressDialog$ProgressStyle[];

            static 
            {
                $SwitchMap$com$amazon$gallery$thor$widget$AppCompatProgressDialog$ProgressStyle = new int[ProgressStyle.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$thor$widget$AppCompatProgressDialog$ProgressStyle[ProgressStyle.HORIZONTAL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$thor$widget$AppCompatProgressDialog$ProgressStyle[ProgressStyle.SPINNER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.com.amazon.gallery.thor.widget.AppCompatProgressDialog.ProgressStyle[builder.progressStyle.ordinal()];
        JVM INSTR tableswitch 1 2: default 36
    //                   1 46
    //                   2 63;
           goto _L1 _L2 _L3
_L1:
        throw new UnsupportedOperationException("Not a valid progress style!");
_L2:
        int i = 0x7f03001f;
_L5:
        contentView = inflater.inflate(i, null);
        return;
_L3:
        i = 0x7f03001e;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void dismiss()
    {
        dialogDelegate.dismiss();
    }

    public void hide()
    {
        dialogDelegate.hide();
    }

    public boolean isIndeterminate()
    {
        return builder.indeterminate;
    }

    public boolean isIndeterminateAllowed()
    {
        return builder.progressStyle == ProgressStyle.HORIZONTAL;
    }

    public boolean isShowing()
    {
        return dialogDelegate.isShowing();
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        dialogDelegate.onRestoreInstanceState(bundle);
    }

    public Bundle onSaveInstanceState()
    {
        return dialogDelegate.onSaveInstanceState();
    }

    public void setDismissMessage(Message message)
    {
        dialogDelegate.setDismissMessage(message);
    }

    public void setIndeterminate(boolean flag)
    {
        byte byte1 = 8;
        if (!isIndeterminateAllowed())
        {
            throw new UnsupportedOperationException((new StringBuilder()).append("You cannot set progress as indeterminate with current style: ").append(builder.progressStyle.toString()).toString());
        }
        progressBar.setIndeterminate(flag);
        TextView textview = percentageView;
        byte byte0;
        if (flag)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        textview.setVisibility(byte0);
        textview = minMaxView;
        if (flag)
        {
            byte0 = byte1;
        } else
        {
            byte0 = 0;
        }
        textview.setVisibility(byte0);
    }

    public void setMessage(final String message)
    {
        handler.post(new Runnable() {

            final AppCompatProgressDialog this$0;
            final String val$message;

            public void run()
            {
                messageView.setText(message);
            }

            
            {
                this$0 = AppCompatProgressDialog.this;
                message = s;
                super();
            }
        });
    }

    public void setOnCancelListener(android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        dialogDelegate.setOnCancelListener(oncancellistener);
    }

    public void setOnDismissListener(android.content.DialogInterface.OnDismissListener ondismisslistener)
    {
        dialogDelegate.setOnDismissListener(ondismisslistener);
    }

    public void setTitle(int i)
    {
        dialogDelegate.setTitle(i);
    }

    public void setTitle(CharSequence charsequence)
    {
        dialogDelegate.setTitle(charsequence);
    }

    public void show()
    {
        dialogDelegate.show();
    }

    public void updateProgress(int i)
    {
        if (isIndeterminate())
        {
            throw new UnsupportedOperationException("You cannot update progress on an indeterminate progress bar");
        }
        int j = i;
        if (i > builder.max)
        {
            j = builder.max;
        }
        i = 0;
        if (j > 0)
        {
            i = (int)(((float)j / (float)builder.max) * 100F);
        }
        progressBar.setProgress(i);
        percentageView.setText(String.format("%d%%", new Object[] {
            Integer.valueOf(i)
        }));
        minMaxView.setText(String.format("%d/%d", new Object[] {
            Integer.valueOf(j), Integer.valueOf(builder.max)
        }));
    }

}
