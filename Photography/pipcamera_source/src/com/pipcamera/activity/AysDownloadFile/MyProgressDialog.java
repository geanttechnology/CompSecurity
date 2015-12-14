// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.AysDownloadFile;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MyProgressDialog extends AlertDialog
{

    private static final NumberFormat n = NumberFormat.getPercentInstance();
    private static final DecimalFormat o = new DecimalFormat("###.##");
    private ProgressBar a;
    private ProgressBar b;
    private TextView c;
    private TextView d;
    private TextView e;
    private MyProgressStyle f;
    private View g;
    private View h;
    private double i;
    private double j;
    private int k;
    private int l;
    private Handler m;

    public MyProgressDialog(Context context)
    {
        super(context);
        k = 1024;
        l = 0;
    }

    static double a(MyProgressDialog myprogressdialog)
    {
        return myprogressdialog.j;
    }

    static int a(MyProgressDialog myprogressdialog, int i1)
    {
        myprogressdialog.l = i1;
        return i1;
    }

    static DecimalFormat a()
    {
        return o;
    }

    static double b(MyProgressDialog myprogressdialog)
    {
        return myprogressdialog.i;
    }

    static NumberFormat b()
    {
        return n;
    }

    static int c(MyProgressDialog myprogressdialog)
    {
        return myprogressdialog.l;
    }

    private void c()
    {
        m.sendEmptyMessage(0);
    }

    static MyProgressStyle d(MyProgressDialog myprogressdialog)
    {
        return myprogressdialog.f;
    }

    static ProgressBar e(MyProgressDialog myprogressdialog)
    {
        return myprogressdialog.b;
    }

    static ProgressBar f(MyProgressDialog myprogressdialog)
    {
        return myprogressdialog.a;
    }

    static int g(MyProgressDialog myprogressdialog)
    {
        return myprogressdialog.k;
    }

    static TextView h(MyProgressDialog myprogressdialog)
    {
        return myprogressdialog.c;
    }

    static TextView i(MyProgressDialog myprogressdialog)
    {
        return myprogressdialog.d;
    }

    public void a(double d1)
    {
        if (d1 > 1048576D)
        {
            k = 0x100000;
        } else
        {
            k = 1024;
        }
        i = d1 / (double)k;
    }

    public void a(MyProgressStyle myprogressstyle)
    {
        f = myprogressstyle;
    }

    public void b(double d1)
    {
        j = d1 / (double)k;
        c();
    }

    protected void onCreate(Bundle bundle)
    {
        Object obj = LayoutInflater.from(getContext());
        m = new Handler() {

            final MyProgressDialog a;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                double d1 = MyProgressDialog.a(a) / MyProgressDialog.b(a);
                if (MyProgressDialog.c(a) != (int)(d1 * 100D))
                {
                    if (MyProgressDialog.d(a) == MyProgressStyle.STYLE_MYSPINNER)
                    {
                        MyProgressDialog.e(a).setProgress((int)(d1 * 100D));
                    } else
                    {
                        MyProgressDialog.f(a).setProgress((int)(d1 * 100D));
                        TextView textview1 = MyProgressDialog.h(a);
                        StringBuilder stringbuilder1 = (new StringBuilder()).append(MyProgressDialog.a().format(MyProgressDialog.a(a))).append("/").append(MyProgressDialog.a().format(MyProgressDialog.b(a)));
                        if (MyProgressDialog.g(a) == 1024)
                        {
                            message = "K";
                        } else
                        {
                            message = "M";
                        }
                        textview1.setText(stringbuilder1.append(message).toString());
                        MyProgressDialog.i(a).setText(MyProgressDialog.b().format(d1));
                    }
                    MyProgressDialog.a(a, (int)(d1 * 100D));
                }
            }

            
            {
                a = MyProgressDialog.this;
                super();
            }
        };
        View view = ((LayoutInflater) (obj)).inflate(0x7f03005d, null);
        g = view.findViewById(0x7f0c0197);
        h = view.findViewById(0x7f0c019a);
        b = (ProgressBar)view.findViewById(0x7f0c019b);
        e = (TextView)view.findViewById(0x7f0c019c);
        a = (ProgressBar)view.findViewById(0x7f0c00fb);
        a.setMax(100);
        c = (TextView)view.findViewById(0x7f0c0198);
        d = (TextView)view.findViewById(0x7f0c0199);
        TextView textview = c;
        StringBuilder stringbuilder = (new StringBuilder()).append(o.format(0L)).append("/").append(o.format(0L));
        if (k == 1024)
        {
            obj = "K";
        } else
        {
            obj = "M";
        }
        textview.setText(stringbuilder.append(((String) (obj))).toString());
        d.setText(n.format(0L));
        if (f == MyProgressStyle.STYLE_MYPROGRESS)
        {
            g.setVisibility(0);
            h.setVisibility(4);
        } else
        {
            g.setVisibility(4);
            h.setVisibility(0);
        }
        setView(view);
        c();
        super.onCreate(bundle);
    }


    private class MyProgressStyle extends Enum
    {

        private static final MyProgressStyle $VALUES[];
        public static final MyProgressStyle STYLE_MYPROGRESS;
        public static final MyProgressStyle STYLE_MYSPINNER;

        public static MyProgressStyle valueOf(String s)
        {
            return (MyProgressStyle)Enum.valueOf(com/pipcamera/activity/AysDownloadFile/MyProgressDialog$MyProgressStyle, s);
        }

        public static MyProgressStyle[] values()
        {
            return (MyProgressStyle[])$VALUES.clone();
        }

        static 
        {
            STYLE_MYPROGRESS = new MyProgressStyle("STYLE_MYPROGRESS", 0);
            STYLE_MYSPINNER = new MyProgressStyle("STYLE_MYSPINNER", 1);
            $VALUES = (new MyProgressStyle[] {
                STYLE_MYPROGRESS, STYLE_MYSPINNER
            });
        }

        private MyProgressStyle(String s, int i1)
        {
            super(s, i1);
        }
    }

}
