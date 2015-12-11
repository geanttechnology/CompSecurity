// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.poshmark.application.PMApplication;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMTextView

public class PMProgressDialog extends Dialog
{
    public class AutoHideTimerTask extends TimerTask
    {

        PMProgressDialog parent;
        final PMProgressDialog this$0;

        public void run()
        {
            com.poshmark.ui.PMActivity pmactivity = PMApplication.getApplicationObject().getTopActivity();
            if (pmactivity != null)
            {
                pmactivity.runOnUiThread(new Runnable() {

                    final AutoHideTimerTask this$1;

                    public void run()
                    {
                        bAutoHide = false;
                        dismiss();
                        if (dismissListener != null)
                        {
                            dismissListener.dialogDismissed();
                            dismissListener = null;
                        }
                    }

            
            {
                this$1 = AutoHideTimerTask.this;
                super();
            }
                });
            }
        }

        AutoHideTimerTask(PMProgressDialog pmprogressdialog1)
        {
            this$0 = PMProgressDialog.this;
            super();
            parent = pmprogressdialog1;
        }
    }

    public static interface ProgressDialogAutoDismissListener
    {

        public abstract void dialogDismissed();
    }


    boolean bAutoHide;
    ProgressDialogAutoDismissListener dismissListener;
    private ImageView imageView;
    private ProgressBar progressBar;
    private PMTextView textView;

    public PMProgressDialog(Context context)
    {
        super(context, 0x7f080015);
        bAutoHide = false;
        getContext();
        context = (LinearLayout)getLayoutInflater().inflate(0x7f0300a6, null);
        setContentView(context);
        textView = (PMTextView)context.findViewById(0x7f0c0273);
        imageView = (ImageView)context.findViewById(0x7f0c0272);
        progressBar = (ProgressBar)context.findViewById(0x7f0c0061);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public void onStart()
    {
        super.onStart();
    }

    public void onStop()
    {
        super.onStop();
    }

    public void setAutoHideFlag(boolean flag)
    {
        bAutoHide = flag;
        if (flag)
        {
            progressBar.setVisibility(8);
            return;
        } else
        {
            progressBar.setVisibility(0);
            return;
        }
    }

    public void setDismissListener(ProgressDialogAutoDismissListener progressdialogautodismisslistener)
    {
        dismissListener = progressdialogautodismisslistener;
    }

    public void setMessage(String s)
    {
        if (s != null)
        {
            textView.setVisibility(0);
            textView.setText(s);
            return;
        } else
        {
            textView.setVisibility(8);
            textView.setText(null);
            return;
        }
    }

    public void show()
    {
        super.show();
        if (bAutoHide)
        {
            AutoHideTimerTask autohidetimertask = new AutoHideTimerTask(this);
            (new Timer()).schedule(autohidetimertask, 1500L);
        }
    }
}
