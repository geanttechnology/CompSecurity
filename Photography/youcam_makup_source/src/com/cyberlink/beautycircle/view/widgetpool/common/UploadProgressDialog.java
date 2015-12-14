// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;

public class UploadProgressDialog extends Dialog
{

    private TextView a;
    private TextView b;
    private ProgressBar c;
    private android.content.DialogInterface.OnClickListener d;

    public UploadProgressDialog(Context context)
    {
        super(context);
        a = null;
        b = null;
        c = null;
        d = null;
        requestWindowFeature(1);
        getWindow().setBackgroundDrawableResource(g.bc_color_transparent);
        setContentView(k.bc_dialog_upload);
        a = (TextView)findViewById(j.bc_upload_dialog_message);
        b = (TextView)findViewById(j.bc_upload_dialog_cancel_btn);
        b.setOnClickListener(new android.view.View.OnClickListener() {

            final UploadProgressDialog a;

            public void onClick(View view)
            {
                if (UploadProgressDialog.a(a) != null)
                {
                    a.dismiss();
                }
                UploadProgressDialog.a(a).onClick(a, 0);
            }

            
            {
                a = UploadProgressDialog.this;
                super();
            }
        });
        c = (ProgressBar)findViewById(j.bc_upload_dialog_progressbar);
        setCanceledOnTouchOutside(false);
    }

    static android.content.DialogInterface.OnClickListener a(UploadProgressDialog uploadprogressdialog)
    {
        return uploadprogressdialog.d;
    }

    public void a(int i)
    {
        if (c != null)
        {
            c.setMax(i);
        }
    }

    public void a(android.content.DialogInterface.OnClickListener onclicklistener)
    {
        d = onclicklistener;
    }

    public void a(String s)
    {
        if (s != null && a != null)
        {
            a.setText(s);
        }
    }

    public boolean a()
    {
        if (c != null)
        {
            return c.isIndeterminate();
        } else
        {
            return false;
        }
    }

    public void b()
    {
        if (b != null)
        {
            b.setVisibility(8);
        }
    }

    public int getProgress()
    {
        if (c != null)
        {
            return c.getProgress();
        } else
        {
            return 0;
        }
    }

    public void onBackPressed()
    {
    }

    public void setProgress(int i)
    {
        if (c != null)
        {
            c.setProgress(i);
        }
    }
}
