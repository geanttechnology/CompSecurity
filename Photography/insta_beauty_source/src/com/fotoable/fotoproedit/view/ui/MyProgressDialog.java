// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui;

import ame;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
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

    public static double a(MyProgressDialog myprogressdialog)
    {
        return myprogressdialog.j;
    }

    public static int a(MyProgressDialog myprogressdialog, int i1)
    {
        myprogressdialog.l = i1;
        return i1;
    }

    public static DecimalFormat a()
    {
        return o;
    }

    public static double b(MyProgressDialog myprogressdialog)
    {
        return myprogressdialog.i;
    }

    public static NumberFormat b()
    {
        return n;
    }

    public static int c(MyProgressDialog myprogressdialog)
    {
        return myprogressdialog.l;
    }

    private void c()
    {
        m.sendEmptyMessage(0);
    }

    public static MyProgressStyle d(MyProgressDialog myprogressdialog)
    {
        return myprogressdialog.f;
    }

    public static ProgressBar e(MyProgressDialog myprogressdialog)
    {
        return myprogressdialog.b;
    }

    public static ProgressBar f(MyProgressDialog myprogressdialog)
    {
        return myprogressdialog.a;
    }

    public static int g(MyProgressDialog myprogressdialog)
    {
        return myprogressdialog.k;
    }

    public static TextView h(MyProgressDialog myprogressdialog)
    {
        return myprogressdialog.c;
    }

    public static TextView i(MyProgressDialog myprogressdialog)
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
        m = new ame(this);
        View view = ((LayoutInflater) (obj)).inflate(0x7f0300a5, null);
        g = view.findViewById(0x7f0d02ae);
        h = view.findViewById(0x7f0d02b1);
        b = (ProgressBar)view.findViewById(0x7f0d02b2);
        e = (TextView)view.findViewById(0x7f0d02b3);
        a = (ProgressBar)view.findViewById(0x7f0d01a6);
        a.setMax(100);
        c = (TextView)view.findViewById(0x7f0d02af);
        d = (TextView)view.findViewById(0x7f0d02b0);
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
            return (MyProgressStyle)Enum.valueOf(com/fotoable/fotoproedit/view/ui/MyProgressDialog$MyProgressStyle, s);
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
