// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class oj
{

    private static String f = "ActivityCameraDegreeAdjust";
    private static String g = "PreviewAdjustFront";
    private static String h = "PictureAdjustFront";
    private static String i = "PreviewAdjustBack";
    private static String j = "PictureAdjustBack";
    AlertDialog a;
    Context b;
    AlertDialog c;
    AlertDialog d;
    private String e;
    private boolean k;
    private or l;
    private int m;
    private int n;
    private int o;
    private int p;

    public oj(Context context, boolean flag, or or)
    {
        e = "ActivityCameraSettingCorrectAllDlg";
        k = true;
        m = 0;
        n = 0;
        b = context;
        k = flag;
        l = or;
    }

    static int a(oj oj1, int i1)
    {
        oj1.m = i1;
        return i1;
    }

    public static int a(boolean flag, Context context)
    {
        Object obj;
        int i1;
        int j1;
        int l1;
        obj = new android.hardware.Camera.CameraInfo();
        l1 = Camera.getNumberOfCameras();
        j1 = 1;
        if (!flag)
        {
            j1 = 0;
        }
        i1 = 0;
_L3:
        if (i1 >= l1)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        Camera.getCameraInfo(i1, ((android.hardware.Camera.CameraInfo) (obj)));
        if (((android.hardware.Camera.CameraInfo) (obj)).facing != j1) goto _L2; else goto _L1
_L1:
        int k1 = ((android.hardware.Camera.CameraInfo) (obj)).orientation;
        obj = j;
        if (qd.c(i1))
        {
            obj = h;
        }
        return context.getSharedPreferences(((String) (obj)), 32768).getInt(((String) (obj)), 0) + k1;
_L2:
        i1++;
          goto _L3
        i1 = 0;
          goto _L1
    }

    private View a(Bitmap bitmap, AlertDialog alertdialog)
    {
        View view = LayoutInflater.from(b).inflate(0x7f03001e, null);
        ImageView imageview = (ImageView)view.findViewById(0x7f0d007b);
        Button button = (Button)view.findViewById(0x7f0d007c);
        ((Button)view.findViewById(0x7f0d007d)).setOnClickListener(new on(this, alertdialog));
        p = 0;
        button.setOnClickListener(new oo(this, bitmap, imageview));
        imageview.setImageBitmap(bitmap);
        return view;
    }

    private void a(int i1)
    {
        if (i1 % 90 != 0)
        {
            return;
        }
        String s = j;
        if (k)
        {
            s = h;
        }
        SharedPreferences sharedpreferences = b.getSharedPreferences(s, 32768);
        int j1 = sharedpreferences.getInt(s, 0);
        sharedpreferences.edit().putInt(s, (j1 + i1) % 360).commit();
    }

    public static void a(Context context, qk qk)
    {
        AlertDialog alertdialog = (new android.app.AlertDialog.Builder(context)).create();
        alertdialog.getWindow().clearFlags(2);
        alertdialog.setCanceledOnTouchOutside(false);
        alertdialog.show();
        context = (LinearLayout)LayoutInflater.from(context).inflate(0x7f030048, null);
        ((LinearLayout)context.findViewById(0x7f0d01b6)).setVisibility(8);
        alertdialog.setContentView(context, new android.view.ViewGroup.LayoutParams(-1, -1));
        ((Button)context.findViewById(0x7f0d01b5)).setOnClickListener(new oq(alertdialog, qk));
    }

    public static void a(Context context, ql ql)
    {
        AlertDialog alertdialog = (new android.app.AlertDialog.Builder(context)).create();
        alertdialog.getWindow().clearFlags(2);
        alertdialog.setCanceledOnTouchOutside(false);
        alertdialog.show();
        context = (LinearLayout)LayoutInflater.from(context).inflate(0x7f03006c, null);
        ((LinearLayout)context.findViewById(0x7f0d0240)).setVisibility(8);
        alertdialog.setContentView(context, new android.view.ViewGroup.LayoutParams(-1, -1));
        ((Button)context.findViewById(0x7f0d01b5)).setOnClickListener(new op(alertdialog, ql));
    }

    static void a(oj oj1)
    {
        oj1.c();
    }

    static int b(oj oj1)
    {
        return oj1.n;
    }

    static int b(oj oj1, int i1)
    {
        oj1.n = i1;
        return i1;
    }

    static or c(oj oj1)
    {
        return oj1.l;
    }

    private void c()
    {
        c = (new android.app.AlertDialog.Builder(b)).create();
        c.getWindow().clearFlags(2);
        c.setCanceledOnTouchOutside(true);
        c.show();
        LinearLayout linearlayout = (LinearLayout)LayoutInflater.from(b).inflate(0x7f03001f, null);
        Object obj = new android.view.ViewGroup.LayoutParams(-1, -1);
        c.setContentView(linearlayout, ((android.view.ViewGroup.LayoutParams) (obj)));
        obj = (Button)linearlayout.findViewById(0x7f0d007e);
        m = 0;
        n = 0;
        ((Button) (obj)).setOnClickListener(new ol(this));
        ((Button)linearlayout.findViewById(0x7f0d007f)).setOnClickListener(new om(this));
        c.show();
    }

    static void c(oj oj1, int i1)
    {
        oj1.a(i1);
    }

    static int d(oj oj1)
    {
        return oj1.m;
    }

    static int d(oj oj1, int i1)
    {
        oj1.p = i1;
        return i1;
    }

    static int e(oj oj1, int i1)
    {
        oj1.o = i1;
        return i1;
    }

    static boolean e(oj oj1)
    {
        return oj1.k;
    }

    static String f(oj oj1)
    {
        return oj1.e;
    }

    static int g(oj oj1)
    {
        return oj1.o;
    }

    static int h(oj oj1)
    {
        return oj1.p;
    }

    public void a()
    {
        a = (new android.app.AlertDialog.Builder(b)).create();
        a.getWindow().clearFlags(2);
        a.setCanceledOnTouchOutside(true);
        a.show();
        View view = LayoutInflater.from(b).inflate(0x7f03001d, null);
        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-1, -1);
        ((Button)view.findViewById(0x7f0d007a)).setOnClickListener(new ok(this));
        a.setContentView(view, layoutparams);
    }

    public void a(Bitmap bitmap)
    {
        d = (new android.app.AlertDialog.Builder(b)).create();
        d.getWindow().clearFlags(2);
        d.setCanceledOnTouchOutside(false);
        d.show();
        d.setContentView(a(bitmap, d));
    }

    public void b()
    {
        if (a != null)
        {
            a.dismiss();
        }
        if (c != null)
        {
            c.dismiss();
        }
        if (d != null)
        {
            d.dismiss();
        }
    }

}
