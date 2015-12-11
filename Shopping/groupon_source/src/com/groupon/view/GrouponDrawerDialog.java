// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groupon.foundations.dialog.BaseDialogFragment;

public abstract class GrouponDrawerDialog extends BaseDialogFragment
    implements android.view.View.OnClickListener
{
    public static interface OnDrawerDialogDismiss
    {

        public abstract void onDrawerDialogDismiss(Bundle bundle);
    }


    private View background;
    private LinearLayout content;
    private OnDrawerDialogDismiss dismissListener;
    private Button submit;
    private TextView title;

    public GrouponDrawerDialog()
    {
    }

    protected void dismissCurrentDialog()
    {
        Dialog dialog = getDialog();
        if (dialog != null && dialog.isShowing())
        {
            dialog.dismiss();
        }
    }

    protected abstract Bundle getResultBundle();

    protected abstract String getSubmitButtonText();

    protected abstract String getTitle();

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755266: 
            dismissCurrentDialog();
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(1, 0x7f0a010d);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300d4, viewgroup, false);
        title = (TextView)layoutinflater.findViewById(0x7f10007a);
        submit = (Button)layoutinflater.findViewById(0x7f100102);
        background = layoutinflater.findViewById(0x7f10020c);
        content = (LinearLayout)layoutinflater.findViewById(0x7f100132);
        title.setText(getTitle());
        submit.setText(getSubmitButtonText());
        submit.setOnClickListener(this);
        background.setOnClickListener(new android.view.View.OnClickListener() {

            final GrouponDrawerDialog this$0;

            public void onClick(View view)
            {
                dismissCurrentDialog();
            }

            
            {
                this$0 = GrouponDrawerDialog.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
        if (dismissListener != null)
        {
            dismissListener.onDrawerDialogDismiss(getResultBundle());
        }
    }

    protected void setContentView(View view)
    {
        content.addView(view, 0, new android.view.ViewGroup.LayoutParams(-1, -2));
    }

    public void setOnDismissListener(OnDrawerDialogDismiss ondrawerdialogdismiss)
    {
        dismissListener = ondrawerdialogdismiss;
    }

    protected void setSubmitListener(android.view.View.OnClickListener onclicklistener)
    {
        Button button = submit;
        if (onclicklistener == null)
        {
            onclicklistener = this;
        }
        button.setOnClickListener(onclicklistener);
    }

    protected void updateHeader(String s, String s1)
    {
        title.setText(s);
        submit.setText(s1);
    }
}
