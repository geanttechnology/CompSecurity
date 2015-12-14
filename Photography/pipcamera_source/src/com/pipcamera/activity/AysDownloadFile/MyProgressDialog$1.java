// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.AysDownloadFile;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;

// Referenced classes of package com.pipcamera.activity.AysDownloadFile:
//            MyProgressDialog

class a extends Handler
{

    final MyProgressDialog a;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        double d = MyProgressDialog.a(a) / MyProgressDialog.b(a);
        if (MyProgressDialog.c(a) != (int)(d * 100D))
        {
            if (MyProgressDialog.d(a) == ProgressStyle.STYLE_MYSPINNER)
            {
                MyProgressDialog.e(a).setProgress((int)(d * 100D));
            } else
            {
                MyProgressDialog.f(a).setProgress((int)(d * 100D));
                TextView textview = MyProgressDialog.h(a);
                StringBuilder stringbuilder = (new StringBuilder()).append(MyProgressDialog.a().format(MyProgressDialog.a(a))).append("/").append(MyProgressDialog.a().format(MyProgressDialog.b(a)));
                if (MyProgressDialog.g(a) == 1024)
                {
                    message = "K";
                } else
                {
                    message = "M";
                }
                textview.setText(stringbuilder.append(message).toString());
                MyProgressDialog.i(a).setText(MyProgressDialog.b().format(d));
            }
            MyProgressDialog.a(a, (int)(d * 100D));
        }
    }

    ProgressStyle(MyProgressDialog myprogressdialog)
    {
        a = myprogressdialog;
        super();
    }
}
