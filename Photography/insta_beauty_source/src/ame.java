// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.fotoable.fotoproedit.view.ui.MyProgressDialog;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ame extends Handler
{

    final MyProgressDialog a;

    public ame(MyProgressDialog myprogressdialog)
    {
        a = myprogressdialog;
        super();
    }

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        double d = MyProgressDialog.a(a) / MyProgressDialog.b(a);
        if (MyProgressDialog.c(a) != (int)(d * 100D))
        {
            if (MyProgressDialog.d(a) == com.fotoable.fotoproedit.view.ui.MyProgressDialog.MyProgressStyle.STYLE_MYSPINNER)
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
}
