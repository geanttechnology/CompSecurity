// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import agj;
import agk;
import agl;
import agm;
import agn;
import ago;
import agp;
import agq;
import agr;
import ags;
import agu;
import agv;
import agx;
import agy;
import agz;
import aha;
import ahb;
import ahc;
import ajn;
import akr;
import als;
import ama;
import amd;
import amo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anl;
import apq;
import aqe;
import aqx;
import azn;
import bjd;
import bje;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.fotoable.fotoproedit.activity.font.FontKeyBoardBottomView;
import com.fotoable.fotoproedit.activity.font.FontLabelCursorView;
import com.fotoable.fotoproedit.activity.font.FontSldeLineView;
import com.fotoable.fotoproedit.activity.font.FontTextLabelInfo;
import com.fotoable.fotoproedit.activity.font.FontTextLabelView;
import com.fotoable.fotoproedit.activity.font.FontTextTouchView;
import com.fotoable.fotoproedit.activity.font.fontEditText;
import com.fotoable.fotoproedit.view.ui.FontPreViewDialog;
import com.fotoable.fotoproedit.view.ui.ProEidtActionBarView;
import com.fotoable.fotoproedit.view.ui.scroll.TProEditTextBottomBar;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.utility.ui.ProcessDialogFragment;
import java.io.File;
import java.util.ArrayList;
import uv;
import yp;

public class ProEditFontActivity extends FullscreenActivity
    implements amd, amo
{

    private int A;
    private float B;
    private ProcessDialogFragment C;
    private String D;
    private FontLabelCursorView E;
    private TextView F;
    private Button G;
    private ImageView H;
    private ImageView I;
    private ImageView J;
    private ArrayList K;
    private boolean L;
    private boolean M;
    private FrameLayout N;
    private BroadcastReceiver O;
    private android.view.View.OnClickListener P;
    private akr Q;
    private boolean R;
    private android.view.ViewTreeObserver.OnGlobalLayoutListener S;
    private TextWatcher T;
    private ajn U;
    boolean a;
    RelativeLayout b;
    bjd c;
    bje d;
    anl e;
    public Handler f;
    Runnable g;
    private String h;
    private TProEditTextBottomBar i;
    private FontKeyBoardBottomView j;
    private com.fotoable.fotoproedit.view.ui.scroll.TProEditTextBottomBar.COMBOTTOMBTN k;
    private ama l;
    private fontEditText m;
    private RelativeLayout n;
    private int o;
    private FontPreViewDialog p;
    private boolean q;
    private ProEidtActionBarView r;
    private ImageView s;
    private boolean t;
    private FontTextTouchView u;
    private Bitmap v;
    private FontTextLabelView w;
    private FrameLayout x;
    private FrameLayout y;
    private FontSldeLineView z;

    public ProEditFontActivity()
    {
        a = false;
        h = "keyboardH";
        k = com.fotoable.fotoproedit.view.ui.scroll.TProEditTextBottomBar.COMBOTTOMBTN.KEYBOARD;
        o = 216;
        q = false;
        t = false;
        A = 0;
        B = 1.0F;
        L = false;
        M = true;
        d = new agj(this);
        O = new agu(this);
        P = new agy(this);
        e = new aha(this);
        Q = new ahb(this);
        R = false;
        f = new Handler();
        g = new ahc(this);
        S = new agk(this);
        T = new agl(this);
        U = new ago(this);
    }

    public static boolean A(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.R;
    }

    public static RelativeLayout B(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.n;
    }

    public static int C(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.o;
    }

    public static String D(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.h;
    }

    public static boolean E(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.L;
    }

    public static ama F(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.l;
    }

    public static TextView G(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.F;
    }

    public static FontPreViewDialog H(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.p;
    }

    public static int a(ProEditFontActivity proeditfontactivity, int i1)
    {
        proeditfontactivity.o = i1;
        return i1;
    }

    public static ama a(ProEditFontActivity proeditfontactivity, ama ama1)
    {
        proeditfontactivity.l = ama1;
        return ama1;
    }

    public static Bitmap a(ProEditFontActivity proeditfontactivity, Bitmap bitmap)
    {
        proeditfontactivity.v = bitmap;
        return bitmap;
    }

    private Rect a(View view)
    {
        Rect rect = new Rect();
        int ai[] = new int[2];
        if (view == null)
        {
            return rect;
        } else
        {
            view.getLocationOnScreen(ai);
            rect.left = ai[0];
            rect.top = ai[1];
            rect.right = rect.left + view.getWidth();
            rect.bottom = rect.top + view.getHeight();
            return rect;
        }
    }

    public static FontPreViewDialog a(ProEditFontActivity proeditfontactivity, FontPreViewDialog fontpreviewdialog)
    {
        proeditfontactivity.p = fontpreviewdialog;
        return fontpreviewdialog;
    }

    public static com.fotoable.fotoproedit.view.ui.scroll.TProEditTextBottomBar.COMBOTTOMBTN a(ProEditFontActivity proeditfontactivity, com.fotoable.fotoproedit.view.ui.scroll.TProEditTextBottomBar.COMBOTTOMBTN combottombtn)
    {
        proeditfontactivity.k = combottombtn;
        return combottombtn;
    }

    private void a(View view, float f1, float f2, float f3)
    {
        TranslateAnimation translateanimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, 0.0F, 0, f1);
        translateanimation.setDuration(300L);
        translateanimation.setFillEnabled(true);
        translateanimation.setFillAfter(true);
        translateanimation.setInterpolator(new DecelerateInterpolator());
        translateanimation.setAnimationListener(new agr(this, view, f2, f3));
        view.startAnimation(translateanimation);
    }

    private void a(View view, int i1, int j1, long l1, boolean flag)
    {
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        if (view.getVisibility() != 0)
        {
            return;
        }
        try
        {
            TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, i1, j1);
            translateanimation.setDuration(l1);
            translateanimation.setInterpolator(new DecelerateInterpolator());
            translateanimation.setAnimationListener(new agx(this, flag, view));
            view.startAnimation(translateanimation);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
    }

    private void a(View view, int i1, long l1, boolean flag)
    {
        view.setVisibility(0);
        Animation animation = AnimationUtils.loadAnimation(this, i1);
        animation.setDuration(l1);
        animation.setAnimationListener(new ags(this, view, flag));
        view.startAnimation(animation);
    }

    public static void a(ProEditFontActivity proeditfontactivity)
    {
        proeditfontactivity.j();
    }

    public static void a(ProEditFontActivity proeditfontactivity, View view)
    {
        proeditfontactivity.b(view);
    }

    public static void a(ProEditFontActivity proeditfontactivity, View view, int i1, long l1, boolean flag)
    {
        proeditfontactivity.a(view, i1, l1, flag);
    }

    public static void a(ProEditFontActivity proeditfontactivity, FontTextLabelView fonttextlabelview)
    {
        proeditfontactivity.a(fonttextlabelview);
    }

    private void a(FontTextLabelView fonttextlabelview)
    {
        Object obj = fonttextlabelview.viewSize();
        Object obj1 = fonttextlabelview.centerPt();
        int i1 = (int)(((PointF) (obj1)).x - (float)(((aqe) (obj)).a() / 2));
        int j1 = (int)(((PointF) (obj1)).y - (float)(((aqe) (obj)).b() / 2));
        int k1 = ((aqe) (obj)).a();
        int l1 = ((aqe) (obj)).b();
        obj = new android.widget.FrameLayout.LayoutParams(-1, -1);
        obj.leftMargin = i1;
        obj.topMargin = j1;
        obj.gravity = 51;
        obj.width = k1;
        obj.height = l1;
        fonttextlabelview.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        fonttextlabelview = new Point(i1, j1);
        obj = new Point(i1 + k1, j1);
        obj1 = new Point(k1 + i1, j1 + l1);
        Point point = new Point(i1, l1 + j1);
        ArrayList arraylist = new ArrayList();
        arraylist.add(obj);
        arraylist.add(point);
        arraylist.add(obj1);
        arraylist.add(fonttextlabelview);
        z.setPtArray(arraylist);
    }

    private void a(FontTextLabelView fonttextlabelview, boolean flag)
    {
        if (fonttextlabelview == null)
        {
            return;
        }
        Point point;
        Point point1;
        Point point2;
        ArrayList arraylist;
        if (flag)
        {
            z.setVisibility(0);
        } else
        {
            z.setVisibility(4);
        }
        point = fonttextlabelview.getLBpt();
        point1 = fonttextlabelview.getLTpt();
        point2 = fonttextlabelview.getRBpt();
        fonttextlabelview = fonttextlabelview.getRTpt();
        arraylist = new ArrayList();
        arraylist.add(point1);
        arraylist.add(fonttextlabelview);
        arraylist.add(point2);
        arraylist.add(point);
        z.setPtArray(arraylist);
    }

    public static void a(File file)
    {
        if (!file.isFile()) goto _L2; else goto _L1
_L1:
        file.delete();
_L4:
        return;
_L2:
        if (file.isDirectory())
        {
            file = file.listFiles();
            if (file != null && file.length != 0)
            {
                int j1 = file.length;
                int i1 = 0;
                while (i1 < j1) 
                {
                    a(file[i1]);
                    i1++;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(ArrayList arraylist)
    {
        try
        {
            c = new bjd();
            c.a(d);
            c.a(arraylist);
            c.b(azn.d());
            c.d(new ArrayList[] {
                arraylist
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist)
        {
            arraylist.printStackTrace();
        }
    }

    private void a(boolean flag)
    {
        if (flag)
        {
            H.setVisibility(0);
            if (w != null && !w.hasBg())
            {
                J.setVisibility(4);
            } else
            {
                J.setVisibility(0);
            }
            if (K.size() > 1)
            {
                I.setVisibility(0);
            } else
            {
                I.setVisibility(4);
            }
            s();
        } else
        {
            H.setVisibility(4);
            J.setVisibility(4);
            I.setVisibility(4);
        }
        a(w, flag);
    }

    private boolean a(MotionEvent motionevent)
    {
        int j1 = (int)motionevent.getX();
        int k1 = (int)motionevent.getY();
        int i1 = 0;
        boolean flag = false;
        for (; i1 < K.size(); i1++)
        {
            motionevent = (FontTextLabelView)K.get(i1);
            Rect rect = a(((View) (motionevent)));
            flag = motionevent.isTouchLabel(j1 - rect.left, k1 - rect.top);
            if (flag)
            {
                motionevent.bringToFront();
                K.remove(i1);
                K.add(0, motionevent);
                b(motionevent);
                L = true;
                if (w != null)
                {
                    j.setStyleFontAndTxt(w.labelinfo(), w.fontInfo());
                }
                m.setText(w.getText());
                m.setSelection(m.getText().length());
                return flag;
            }
        }

        return flag;
    }

    public static boolean a(ProEditFontActivity proeditfontactivity, MotionEvent motionevent)
    {
        return proeditfontactivity.a(motionevent);
    }

    public static boolean a(ProEditFontActivity proeditfontactivity, boolean flag)
    {
        proeditfontactivity.M = flag;
        return flag;
    }

    public static Bitmap b(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.v;
    }

    public static Rect b(ProEditFontActivity proeditfontactivity, View view)
    {
        return proeditfontactivity.a(view);
    }

    private void b(View view)
    {
        q = true;
        view.setFocusableInTouchMode(true);
        if (view.requestFocus())
        {
            ((InputMethodManager)getSystemService("input_method")).showSoftInput(view, 1);
        }
    }

    public static void b(ProEditFontActivity proeditfontactivity, FontTextLabelView fonttextlabelview)
    {
        proeditfontactivity.b(fonttextlabelview);
    }

    private void b(FontTextLabelView fonttextlabelview)
    {
        if (w != null)
        {
            if (w.getText().length() == 0)
            {
                w.setLabelTextStr(getResources().getText(0x7f06029c).toString());
                w.onTextCreate();
            }
            z.setVisibility(4);
            a(w);
        }
        w = fonttextlabelview;
        if (w != null)
        {
            a(w, true);
            w.onTextCreate();
            s();
        }
    }

    public static void b(File file)
    {
        if (file.isDirectory())
        {
            file = file.listFiles();
            if (file != null && file.length != 0)
            {
                int j1 = file.length;
                int i1 = 0;
                while (i1 < j1) 
                {
                    File file1 = file[i1];
                    if (file1.isFile() && file1.getName().endsWith(".zip"))
                    {
                        file1.delete();
                    }
                    i1++;
                }
            }
        }
    }

    private void b(boolean flag)
    {
        a(false);
        Object obj = new Rect();
        if (w != null)
        {
            obj = a(w);
        }
        int i1 = getResources().getDisplayMetrics().heightPixels - (o + yp.a(this, 200F)) - ((Rect) (obj)).top;
        if (i1 < 0)
        {
            float f1 = ((android.widget.FrameLayout.LayoutParams)x.getLayoutParams()).bottomMargin - i1;
            a(x, i1, f1, -1F);
        }
        obj = (android.widget.FrameLayout.LayoutParams)i.getLayoutParams();
        if ((float)((android.widget.FrameLayout.LayoutParams) (obj)).bottomMargin == 0.0F)
        {
            a(i, -o + yp.a(this, 44F), o, -1F);
        } else
        {
            obj.bottomMargin = o;
            i.requestLayout();
        }
        a(i, o, 0, 300L, true);
        a(j, -o, 0.0F, o);
        (new Handler()).postDelayed(new agp(this, flag), 300L);
    }

    public static boolean b(ProEditFontActivity proeditfontactivity, boolean flag)
    {
        proeditfontactivity.t = flag;
        return flag;
    }

    public static ImageView c(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.s;
    }

    public static void c(ProEditFontActivity proeditfontactivity, boolean flag)
    {
        proeditfontactivity.b(flag);
    }

    public static void d(ProEditFontActivity proeditfontactivity)
    {
        proeditfontactivity.m();
    }

    public static void d(ProEditFontActivity proeditfontactivity, boolean flag)
    {
        proeditfontactivity.a(flag);
    }

    public static void e(ProEditFontActivity proeditfontactivity)
    {
        proeditfontactivity.n();
    }

    public static boolean e(ProEditFontActivity proeditfontactivity, boolean flag)
    {
        proeditfontactivity.L = flag;
        return flag;
    }

    public static FrameLayout f(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.N;
    }

    public static boolean g(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.M;
    }

    public static String h()
    {
        return InstaBeautyApplication.a().b().getApplicationContext().getDir("onlineRes", 0).getAbsolutePath();
    }

    public static void h(ProEditFontActivity proeditfontactivity)
    {
        proeditfontactivity.s();
    }

    public static boolean i(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.t;
    }

    private void j()
    {
        (new Thread(new agv(this))).start();
    }

    public static void j(ProEditFontActivity proeditfontactivity)
    {
        proeditfontactivity.p();
    }

    private void k()
    {
        if (w != null && K.size() > 1)
        {
            K.remove(w);
            y.removeView(w);
            b(((FontTextLabelView) (null)));
            a(false);
        }
    }

    public static void k(ProEditFontActivity proeditfontactivity)
    {
        proeditfontactivity.u();
    }

    public static fontEditText l(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.m;
    }

    private void l()
    {
        if (w != null)
        {
            w.startFlip();
            w.onTextCreate();
        }
    }

    public static FontKeyBoardBottomView m(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.j;
    }

    private void m()
    {
        if (v == null)
        {
            f();
            finish();
            return;
        }
        float f1 = getResources().getDisplayMetrics().heightPixels - yp.a(this, 116F);
        if (azn.a(this))
        {
            f1 = getResources().getDisplayMetrics().heightPixels - yp.a(this, 166F);
        }
        float f3 = getResources().getDisplayMetrics().widthPixels - yp.a(this, 16F);
        float f5 = v.getWidth();
        float f4 = v.getHeight();
        float f2 = f4 / f1;
        if (f5 / f4 > f3 / f1)
        {
            f2 = f5 / f3;
        }
        B = f2;
        f5 /= f2;
        f2 = f4 / f2;
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams((int)f5, (int)f2);
        layoutparams.gravity = 83;
        layoutparams.bottomMargin = (int)((float)yp.a(this, 108F) + (f1 - f2) / 2.0F);
        f4 = yp.a(this, 108F);
        A = (int)((f1 - f2) / 2.0F + f4);
        layoutparams.leftMargin = (int)((float)yp.a(this, 8F) + (f3 - f5) / 2.0F);
        x.setLayoutParams(layoutparams);
    }

    public static FontTextLabelView n(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.w;
    }

    private void n()
    {
        float f1 = (float)v.getWidth() / B;
        float f2 = (float)v.getHeight() / B;
        FontTextLabelView fonttextlabelview = new FontTextLabelView(this, null);
        y.addView(fonttextlabelview);
        E.bringToFront();
        fonttextlabelview.setFontLabelSize(0);
        fonttextlabelview.setCPoint((int)f1 / 2, (int)f2 / 2);
        fonttextlabelview.setNewScale(0.4F);
        fonttextlabelview.setLabelTextStr(getResources().getText(0x7f06029c).toString());
        fonttextlabelview.setListener(new agz(this));
        fonttextlabelview.onTextCreate();
        a(fonttextlabelview);
        K.add(fonttextlabelview);
        b(fonttextlabelview);
        a(true);
        if (K.size() > 1)
        {
            I.setVisibility(0);
            return;
        } else
        {
            I.setVisibility(4);
            return;
        }
    }

    private void o()
    {
        i.setListner(e);
        j.setListener(U);
        n.getViewTreeObserver().addOnGlobalLayoutListener(S);
        m.addTextChangedListener(T);
        m.clearFocus();
        getWindow().setSoftInputMode(2);
        u.setListener(Q);
        o = aqx.a(this, h, yp.a(this, 216F));
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)j.getLayoutParams();
        layoutparams.width = getResources().getDisplayMetrics().widthPixels;
        layoutparams.height = o;
        layoutparams.bottomMargin = -o;
        j.setLayoutParams(layoutparams);
        n.setBackgroundColor(Color.rgb(70, 70, 70));
    }

    public static void o(ProEditFontActivity proeditfontactivity)
    {
        proeditfontactivity.v();
    }

    private void p()
    {
        if (w == null && K != null && K.size() > 0)
        {
            b((FontTextLabelView)K.get(K.size() - 1));
        }
        if (w != null)
        {
            z.setVisibility(0);
            if (m.getText().length() == 0)
            {
                w.setLabelTextStr("");
                w.onTextCreate();
                a(w);
                s();
            }
        }
    }

    public static void p(ProEditFontActivity proeditfontactivity)
    {
        proeditfontactivity.t();
    }

    public static FrameLayout q(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.x;
    }

    private void q()
    {
        if (m.getText().length() == 0 && w != null)
        {
            w.setLabelTextStr(getResources().getString(0x7f06029c));
            w.onTextCreate();
            a(w);
            s();
        }
    }

    public static ImageView r(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.I;
    }

    private void r()
    {
        l = new ama();
        l.a("sans");
    }

    private void s()
    {
        if (w != null)
        {
            Object obj = w.viewSize();
            Object obj1 = w.centerPt();
            a(x);
            int i1 = (int)(((PointF) (obj1)).x - (float)(((aqe) (obj)).a() / 2));
            int j1 = (int)(((PointF) (obj1)).y - (float)(((aqe) (obj)).b() / 2));
            obj1 = w.cursorPt1();
            obj = w.cursorPt2();
            float f1 = i1;
            float f2 = ((PointF) (obj1)).x;
            float f3 = j1;
            obj1 = new PointF(f1 + f2, ((PointF) (obj1)).y + f3);
            f1 = i1;
            f2 = ((PointF) (obj)).x;
            f3 = j1;
            obj = new PointF(f1 + f2, ((PointF) (obj)).y + f3);
            E.setLocation(((PointF) (obj1)), ((PointF) (obj)));
            obj = new PointF((float)i1 + w.deletePt().x, (float)j1 + w.deletePt().y);
            obj1 = new PointF((float)i1 + w.flipPt().x, (float)j1 + w.flipPt().y);
            Object obj2 = new PointF((float)i1 + w.rotatePt().x, (float)j1 + w.rotatePt().y);
            i1 = yp.a(this, 50F);
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(40, 40);
            layoutparams.leftMargin = (int)(((PointF) (obj2)).x - (float)(i1 / 2));
            layoutparams.topMargin = (int)(((PointF) (obj2)).y - (float)(i1 / 2));
            layoutparams.gravity = 51;
            layoutparams.width = i1;
            layoutparams.height = i1;
            H.setLayoutParams(layoutparams);
            obj2 = new android.widget.FrameLayout.LayoutParams(40, 40);
            obj2.leftMargin = (int)(((PointF) (obj1)).x - (float)(i1 / 2));
            obj2.topMargin = (int)(((PointF) (obj1)).y - (float)(i1 / 2));
            obj2.gravity = 51;
            obj2.width = i1;
            obj2.height = i1;
            J.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            obj1 = new android.widget.FrameLayout.LayoutParams(40, 40);
            obj1.leftMargin = (int)(((PointF) (obj)).x - (float)(i1 / 2));
            obj1.topMargin = (int)(((PointF) (obj)).y - (float)(i1 / 2));
            obj1.gravity = 51;
            obj1.width = i1;
            obj1.height = i1;
            I.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            a(w, true);
        }
    }

    public static void s(ProEditFontActivity proeditfontactivity)
    {
        proeditfontactivity.k();
    }

    public static ImageView t(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.J;
    }

    private void t()
    {
        v();
        if (t)
        {
            t = false;
            q();
            x();
            a(r, 0x7f04000b, 300L, true);
        }
    }

    private void u()
    {
        if (R)
        {
            return;
        } else
        {
            R = true;
            s();
            f.postDelayed(g, 1000L);
            return;
        }
    }

    public static void u(ProEditFontActivity proeditfontactivity)
    {
        proeditfontactivity.l();
    }

    public static TProEditTextBottomBar v(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.i;
    }

    private void v()
    {
        R = false;
        E.setVisibility(4);
    }

    public static FontSldeLineView w(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.z;
    }

    private void w()
    {
        Log.d("ProEditFontActivity", "clearResource...");
        try
        {
            Object obj = getFilesDir().getAbsolutePath();
            obj = new File((new StringBuilder()).append(((String) (obj))).append("/font").toString());
            if (((File) (obj)).exists())
            {
                a(((File) (obj)));
            }
            obj = new File((new StringBuilder()).append(h()).append("/fonts").toString());
            if (((File) (obj)).exists())
            {
                b(((File) (obj)));
            }
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            return;
        }
    }

    public static ImageView x(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.H;
    }

    private void x()
    {
        float f1 = ((android.widget.FrameLayout.LayoutParams)x.getLayoutParams()).bottomMargin - A;
        a(x, f1, A, -1F);
        a(i, o - yp.a(this, 44F), yp.a(this, 40F), -1F);
        a(j, o, -o - 3, o);
        (new Handler()).postDelayed(new agq(this), 300L);
    }

    private Bitmap y()
    {
        for (int i1 = 0; i1 < y.getChildCount(); i1++)
        {
            View view = y.getChildAt(i1);
            if ((view instanceof FontTextLabelView) && ((FontTextLabelView)view).getText().toString().equals(""))
            {
                view.setVisibility(4);
            }
        }

        int j1 = y.getWidth();
        int k1 = y.getHeight();
        float f1;
        float f2;
        float f3;
        Bitmap bitmap;
        Canvas canvas;
        if (k1 * j1 > v.getWidth() * v.getHeight())
        {
            k1 = (int)Math.sqrt((int)((float)(j1 * k1) / (float)(v.getWidth() * v.getHeight()) + 1.0F));
            j1 = k1;
            if (k1 < 1)
            {
                j1 = 1;
            }
            k1 = j1;
            if (j1 > 5)
            {
                k1 = 5;
            }
        } else
        {
            k1 = 1;
        }
        a(false);
        bitmap = Bitmap.createBitmap(v.getWidth() * k1, v.getHeight() * k1, android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        f1 = B;
        f2 = k1;
        f3 = B;
        canvas.scale(f1 * f2, (float)k1 * f3);
        y.draw(canvas);
        return bitmap;
    }

    public static boolean y(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.q;
    }

    public static FontLabelCursorView z(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.E;
    }

    protected void a()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("ACTION_MAG_MATERIAL_SHARETOWECHAT");
        registerReceiver(O, intentfilter);
    }

    public void a(ama ama1)
    {
        if (w != null)
        {
            w.setFontLabelFontInfo(ama1);
            w.onTextCreate();
            a(w);
            s();
        }
    }

    public void a(Boolean boolean1)
    {
        p.a(null);
        p.dismissAllowingStateLoss();
        p = null;
    }

    public void a(String s1)
    {
        D = s1;
    }

    public void b()
    {
        k = com.fotoable.fotoproedit.view.ui.scroll.TProEditTextBottomBar.COMBOTTOMBTN.DEFAULT;
        i.setBottomUnselected();
        hideSoftKeyborad(m);
    }

    public void b(ama ama1)
    {
        p.a(null);
        p.dismissAllowingStateLoss();
        p = null;
        als.a(this).a(new agn(this, ama1));
        als.a(this).a(ama1, true);
    }

    public void c()
    {
        if (C != null)
        {
            return;
        }
        try
        {
            C = ProcessDialogFragment.a(g());
            C.setCancelable(false);
            C.show(getSupportFragmentManager(), "process");
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void d()
    {
        apq.a("text");
        int i1 = 0;
        String s1 = null;
        String s3 = null;
        String s2 = null;
        while (i1 < K.size()) 
        {
            FontTextLabelView fonttextlabelview = (FontTextLabelView)K.get(i1);
            if (fonttextlabelview.labelinfo().o)
            {
                s3 = fonttextlabelview.labelinfo().i;
            } else
            {
                s2 = String.format("#%06X", new Object[] {
                    Integer.valueOf(0xffffff & fonttextlabelview.labelinfo().j)
                });
            }
            if (fonttextlabelview.labelinfo().a >= 0)
            {
                s1 = (new StringBuilder()).append("newstyle_").append(fonttextlabelview.labelinfo().a).toString();
            }
            apq.a(s2, s3, s1, l.f);
            i1++;
        }
        c();
        try
        {
            Bitmap bitmap = y();
            uv.c().a(bitmap, new agm(this));
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        f();
    }

    public void e()
    {
        f();
        w();
        finish();
        overridePendingTransition(0, 0x7f04001e);
    }

    public void f()
    {
        try
        {
            if (C != null)
            {
                C.dismissAllowingStateLoss();
                a(getResources().getString(0x7f0601c6));
            }
        }
        catch (Exception exception) { }
        C = null;
    }

    public String g()
    {
        return D;
    }

    public void hideSoftKeyborad(View view)
    {
        if (view != null && q)
        {
            q = false;
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 1);
        }
    }

    public void i()
    {
        p = null;
    }

    public void onBackPressed()
    {
        if (t)
        {
            t();
            return;
        } else
        {
            f();
            w();
            finish();
            overridePendingTransition(0, 0x7f040038);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03003b);
        s = (ImageView)findViewById(0x7f0d015e);
        i = (TProEditTextBottomBar)findViewById(0x7f0d014d);
        u = (FontTextTouchView)findViewById(0x7f0d0165);
        r = (ProEidtActionBarView)findViewById(0x7f0d00ba);
        j = (FontKeyBoardBottomView)findViewById(0x7f0d0169);
        r.setActionBarTitle("");
        n = (RelativeLayout)findViewById(0x7f0d0166);
        m = (fontEditText)findViewById(0x7f0d0167);
        x = (FrameLayout)findViewById(0x7f0d015c);
        b = (RelativeLayout)findViewById(0x7f0d00b0);
        bundle = (android.widget.FrameLayout.LayoutParams)x.getLayoutParams();
        if (!azn.a(this))
        {
            bundle.topMargin = yp.a(this, 9F);
            b.setVisibility(8);
        }
        y = (FrameLayout)findViewById(0x7f0d015d);
        z = (FontSldeLineView)findViewById(0x7f0d015f);
        E = (FontLabelCursorView)findViewById(0x7f0d0160);
        F = (TextView)findViewById(0x7f0d0164);
        G = (Button)findViewById(0x7f0d0168);
        I = (ImageView)findViewById(0x7f0d0162);
        J = (ImageView)findViewById(0x7f0d0161);
        H = (ImageView)findViewById(0x7f0d0163);
        N = (FrameLayout)findViewById(0x7f0d016a);
        N.setVisibility(0);
        F.setVisibility(4);
        E.setVisibility(4);
        r.setOnAcceptListener(this);
        bundle = getIntent();
        if (getIntent() != null)
        {
            a = bundle.getBooleanExtra("KISDERECTEDTOSAVE_STRING", false);
            if (a)
            {
                bundle = bundle.getStringExtra("KIMAGEURL");
                if (bundle != null)
                {
                    ArrayList arraylist = new ArrayList();
                    arraylist.add(Uri.parse(bundle));
                    a(arraylist);
                }
            }
        }
        K = new ArrayList();
        G.setOnClickListener(P);
        a(getResources().getString(0x7f0601c6));
        r();
        o();
        a();
        if (!a)
        {
            j();
        }
        bundle = i;
        int i1 = yp.a(this, 56F);
        a(bundle, yp.a(this, 44F) + i1, 0, 300L, true);
        bundle = r;
        i1 = yp.a(this, 56F);
        a(bundle, yp.a(this, 44F) + i1, 0, 300L, true);
    }

    protected void onDestroy()
    {
        unregisterReceiver(O);
        super.onDestroy();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && p != null)
        {
            p.a(null);
            p.dismiss();
            p = null;
        }
        return super.onKeyDown(i1, keyevent);
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        FlurryAgent.onPageView();
        if (azn.a(this))
        {
            FotoAdFactory.createAdBanner(this, b);
        }
    }

    protected void onStart()
    {
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
    }
}
