// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
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
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.fotoproedit.activity.font.FontKeyBoardBottomView;
import com.fotoable.fotoproedit.activity.font.FontLabelCursorView;
import com.fotoable.fotoproedit.activity.font.FontPreViewDialog;
import com.fotoable.fotoproedit.activity.font.FontSldeLineView;
import com.fotoable.fotoproedit.activity.font.FontTextLabelInfo;
import com.fotoable.fotoproedit.activity.font.FontTextLabelView;
import com.fotoable.fotoproedit.activity.font.FontTextTouchView;
import com.fotoable.fotoproedit.activity.font.TProEditTextBottomBar;
import com.fotoable.fotoproedit.activity.font.fontEditText;
import com.fotoable.photocollage.view.ProEidtActionBarView;
import com.pipcamera.activity.FullscreenActivity;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.utility.ui.ProcessDialogFragment;
import ew;
import gm;
import go;
import hb;
import hc;
import hd;
import hr;
import hu;
import hz;
import iq;
import ir;
import is;
import java.io.File;
import java.util.ArrayList;
import kf;
import kp;
import la;
import ma;

public class ProEditFontActivity extends FullscreenActivity
    implements hd, ma
{

    private FontLabelCursorView A;
    private TextView B;
    private Button C;
    private ImageView D;
    private ImageView E;
    private ImageView F;
    private ArrayList G;
    private boolean H;
    private boolean I;
    private RelativeLayout J;
    private FrameLayout K;
    private FrameLayout L;
    private android.view.View.OnClickListener M;
    private hu N;
    private boolean O;
    private android.view.ViewTreeObserver.OnGlobalLayoutListener P;
    private TextWatcher Q;
    private hc R;
    hz a;
    Handler b;
    Runnable c;
    private String d;
    private TProEditTextBottomBar e;
    private FontKeyBoardBottomView f;
    private com.fotoable.fotoproedit.activity.font.TProEditTextBottomBar.COMBOTTOMBTN g;
    private hb h;
    private fontEditText i;
    private RelativeLayout j;
    private int k;
    private FontPreViewDialog l;
    private boolean m;
    private ProEidtActionBarView n;
    private ImageView o;
    private boolean p;
    private FontTextTouchView q;
    private Bitmap r;
    private FontTextLabelView s;
    private FrameLayout t;
    private FrameLayout u;
    private FontSldeLineView v;
    private int w;
    private float x;
    private ProcessDialogFragment y;
    private String z;

    public ProEditFontActivity()
    {
        d = "keyboardH";
        g = com.fotoable.fotoproedit.activity.font.TProEditTextBottomBar.COMBOTTOMBTN.KEYBOARD;
        k = 216;
        m = false;
        p = false;
        w = 0;
        x = 1.0F;
        H = false;
        I = true;
        M = new android.view.View.OnClickListener() {

            final ProEditFontActivity a;

            public void onClick(View view)
            {
                ProEditFontActivity.d(a);
            }

            
            {
                a = ProEditFontActivity.this;
                super();
            }
        };
        a = new hz() {

            final ProEditFontActivity a;

            public void a(com.fotoable.fotoproedit.activity.font.TProEditTextBottomBar.COMBOTTOMBTN combottombtn)
            {
                ProEditFontActivity.a(a, combottombtn);
                class _cls8
                {

                    static final int a[];

                    static 
                    {
                        a = new int[com.fotoable.fotoproedit.activity.font.TProEditTextBottomBar.COMBOTTOMBTN.values().length];
                        try
                        {
                            a[com.fotoable.fotoproedit.activity.font.TProEditTextBottomBar.COMBOTTOMBTN.KEYBOARD.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            a[com.fotoable.fotoproedit.activity.font.TProEditTextBottomBar.COMBOTTOMBTN.FONT.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            a[com.fotoable.fotoproedit.activity.font.TProEditTextBottomBar.COMBOTTOMBTN.STYLE.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            a[com.fotoable.fotoproedit.activity.font.TProEditTextBottomBar.COMBOTTOMBTN.BUBBLE.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                _cls8.a[combottombtn.ordinal()];
                JVM INSTR tableswitch 1 4: default 48
            //                           1 49
            //                           2 138
            //                           3 224
            //                           4 350;
                   goto _L1 _L2 _L3 _L4 _L5
_L1:
                return;
_L2:
                if (!ProEditFontActivity.h(a))
                {
                    ProEditFontActivity.b(a, true);
                    ProEditFontActivity.i(a);
                    ProEditFontActivity.c(a, true);
                    ProEditFontActivity.a(a, ProEditFontActivity.j(a), 0x7f040009, 300L, false);
                    ProEditFontActivity.k(a);
                } else
                {
                    ProEditFontActivity.a(a, ProEditFontActivity.l(a));
                }
                ProEditFontActivity.m(a).hiddenAll();
                return;
_L3:
                a.hideSoftKeyborad(ProEditFontActivity.l(a));
                if (!ProEditFontActivity.h(a))
                {
                    ProEditFontActivity.b(a, true);
                    ProEditFontActivity.i(a);
                    ProEditFontActivity.c(a, false);
                    ProEditFontActivity.a(a, ProEditFontActivity.j(a), 0x7f040009, 300L, false);
                    ProEditFontActivity.k(a);
                }
                ProEditFontActivity.m(a).showFontView();
                return;
_L4:
                a.hideSoftKeyborad(ProEditFontActivity.l(a));
                if (!ProEditFontActivity.h(a))
                {
                    ProEditFontActivity.b(a, true);
                    ProEditFontActivity.i(a);
                    ProEditFontActivity.c(a, false);
                    ProEditFontActivity.a(a, ProEditFontActivity.j(a), 0x7f040009, 300L, false);
                    ProEditFontActivity.k(a);
                }
                ProEditFontActivity.m(a).showStyleView();
                if (ProEditFontActivity.n(a) != null)
                {
                    ProEditFontActivity.m(a).setStyleFontAndTxt(ProEditFontActivity.n(a).labelinfo(), ProEditFontActivity.n(a).fontInfo());
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L5:
                a.hideSoftKeyborad(ProEditFontActivity.l(a));
                if (!ProEditFontActivity.h(a))
                {
                    ProEditFontActivity.b(a, true);
                    ProEditFontActivity.i(a);
                    ProEditFontActivity.c(a, false);
                    ProEditFontActivity.a(a, ProEditFontActivity.j(a), 0x7f040009, 300L, false);
                    ProEditFontActivity.k(a);
                    return;
                }
                if (true) goto _L1; else goto _L6
_L6:
            }

            
            {
                a = ProEditFontActivity.this;
                super();
            }
        };
        N = new hu() {

            final ProEditFontActivity a;

            public PointF a()
            {
                if (ProEditFontActivity.n(a) != null)
                {
                    Rect rect = ProEditFontActivity.b(a, ProEditFontActivity.q(a));
                    return new PointF((float)rect.left + ProEditFontActivity.n(a).centerPt().x, (float)rect.top + ProEditFontActivity.n(a).centerPt().y);
                } else
                {
                    return new PointF();
                }
            }

            public void a(float f1)
            {
                if (ProEditFontActivity.n(a) != null)
                {
                    ProEditFontActivity.n(a).setImageScale(f1);
                    ProEditFontActivity.n(a).updateLabelView();
                    ProEditFontActivity.a(a, ProEditFontActivity.n(a));
                }
                ProEditFontActivity.o(a);
                ProEditFontActivity.p(a);
                ProEditFontActivity.g(a);
            }

            public void a(float f1, float f2)
            {
                if (ProEditFontActivity.n(a) != null)
                {
                    ProEditFontActivity.n(a).setImageRotate(f1);
                    ProEditFontActivity.n(a).setImageScale(f2);
                    ProEditFontActivity.n(a).updateLabelView();
                    ProEditFontActivity.a(a, ProEditFontActivity.n(a));
                }
                ProEditFontActivity.o(a);
                ProEditFontActivity.p(a);
                ProEditFontActivity.g(a);
            }

            public void a(int i1, int j1)
            {
                if (ProEditFontActivity.n(a) != null)
                {
                    ProEditFontActivity.n(a).setCPointD(i1, j1);
                    ProEditFontActivity.a(a, ProEditFontActivity.n(a));
                }
                ProEditFontActivity.o(a);
                ProEditFontActivity.p(a);
                ProEditFontActivity.g(a);
            }

            public void a(MotionEvent motionevent)
            {
                int i1 = (int)motionevent.getX();
                int j1 = (int)motionevent.getY();
                if (ProEditFontActivity.r(a).getVisibility() == 0 && ProEditFontActivity.b(a, ProEditFontActivity.r(a)).contains(i1, j1))
                {
                    ProEditFontActivity.s(a);
                } else
                {
                    if (ProEditFontActivity.t(a).getVisibility() == 0 && ProEditFontActivity.b(a, ProEditFontActivity.t(a)).contains(i1, j1))
                    {
                        ProEditFontActivity.u(a);
                        return;
                    }
                    if (ProEditFontActivity.n(a) != null)
                    {
                        boolean flag = ProEditFontActivity.a(a, motionevent);
                        if (ProEditFontActivity.h(a))
                        {
                            if (!flag)
                            {
                                ProEditFontActivity.p(a);
                                return;
                            }
                            if (ProEditFontActivity.n(a).getText().length() == 0)
                            {
                                ProEditFontActivity.n(a).setLabelTextStr("");
                                ProEditFontActivity.n(a).onTextCreate();
                                ProEditFontActivity.a(a, ProEditFontActivity.n(a));
                                ProEditFontActivity.g(a);
                                return;
                            }
                        } else
                        {
                            if (flag)
                            {
                                ProEditFontActivity.b(a, true);
                                ProEditFontActivity.i(a);
                                ProEditFontActivity.c(a, true);
                                ProEditFontActivity.v(a).setKeyBoardBtnSelected();
                                ProEditFontActivity.a(a, ProEditFontActivity.j(a), 0x7f040009, 300L, false);
                                ProEditFontActivity.k(a);
                                return;
                            }
                            if (ProEditFontActivity.n(a) != null)
                            {
                                ProEditFontActivity.w(a).setVisibility(4);
                            }
                            ProEditFontActivity.b(a, null);
                            ProEditFontActivity.d(a, false);
                            return;
                        }
                    } else
                    {
                        ProEditFontActivity.a(a, motionevent);
                        return;
                    }
                }
            }

            public void b()
            {
                if (ProEditFontActivity.n(a) != null)
                {
                    ProEditFontActivity.n(a).storeTransform();
                }
            }

            public void b(float f1)
            {
                if (ProEditFontActivity.n(a) != null)
                {
                    ProEditFontActivity.n(a).setImageRotate(f1);
                    ProEditFontActivity.n(a).updateLabelView();
                    ProEditFontActivity.a(a, ProEditFontActivity.n(a));
                }
                ProEditFontActivity.o(a);
                ProEditFontActivity.p(a);
                ProEditFontActivity.g(a);
            }

            public boolean b(MotionEvent motionevent)
            {
                return ProEditFontActivity.b(a, ProEditFontActivity.x(a)).contains((int)motionevent.getX(), (int)motionevent.getY());
            }

            public void c(MotionEvent motionevent)
            {
                while (ProEditFontActivity.n(a) != null || !ProEditFontActivity.a(a, motionevent) || ProEditFontActivity.y(a)) 
                {
                    return;
                }
                ProEditFontActivity.d(a, true);
            }

            
            {
                a = ProEditFontActivity.this;
                super();
            }
        };
        O = false;
        b = new Handler();
        c = new Runnable() {

            final ProEditFontActivity a;

            public void run()
            {
                if (ProEditFontActivity.z(a).getVisibility() == 4)
                {
                    ProEditFontActivity.z(a).setVisibility(0);
                } else
                {
                    ProEditFontActivity.z(a).setVisibility(4);
                }
                if (ProEditFontActivity.A(a))
                {
                    a.b.postDelayed(this, 1000L);
                    return;
                } else
                {
                    ProEditFontActivity.z(a).setVisibility(4);
                    return;
                }
            }

            
            {
                a = ProEditFontActivity.this;
                super();
            }
        };
        P = new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final ProEditFontActivity a;

            public void onGlobalLayout()
            {
                if (ProEditFontActivity.B(a).getVisibility() == 0)
                {
                    Rect rect = new Rect();
                    ProEditFontActivity.B(a).getWindowVisibleDisplayFrame(rect);
                    int j1 = a.getResources().getDisplayMetrics().heightPixels - (rect.bottom - rect.top);
                    if (j1 != ProEditFontActivity.C(a) && j1 > 100)
                    {
                        la.b(a, ProEditFontActivity.D(a), j1);
                        ProEditFontActivity.a(a, j1);
                        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)ProEditFontActivity.m(a).getLayoutParams();
                        layoutparams.height = j1;
                        int i1;
                        if (layoutparams.bottomMargin < 0)
                        {
                            i1 = j1;
                        } else
                        {
                            i1 = layoutparams.bottomMargin;
                        }
                        layoutparams.bottomMargin = i1;
                        ProEditFontActivity.m(a).requestLayout();
                        ((android.widget.FrameLayout.LayoutParams)ProEditFontActivity.v(a).getLayoutParams()).bottomMargin = j1;
                        ProEditFontActivity.v(a).requestLayout();
                    }
                    Log.e("ProEditFontActivity", (new StringBuilder()).append("heightDifference\uFF1A").append(j1).toString());
                }
            }

            
            {
                a = ProEditFontActivity.this;
                super();
            }
        };
        Q = new TextWatcher() {

            final ProEditFontActivity a;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
                if (ProEditFontActivity.n(a) != null && !ProEditFontActivity.E(a))
                {
                    ProEditFontActivity.n(a).setLabelTextStr(charsequence.toString());
                    ProEditFontActivity.n(a).onTextCreate();
                    ProEditFontActivity.a(a, ProEditFontActivity.n(a));
                    ProEditFontActivity.g(a);
                    return;
                } else
                {
                    ProEditFontActivity.e(a, false);
                    return;
                }
            }

            
            {
                a = ProEditFontActivity.this;
                super();
            }
        };
        R = new hc() {

            final ProEditFontActivity a;

            public void a()
            {
                ProEditFontActivity.a(a, ProEditFontActivity.G(a), 0x7f040013, 300L, false);
            }

            public void a(int i1)
            {
                if (ProEditFontActivity.n(a) != null)
                {
                    ProEditFontActivity.n(a).setLabelStrokeSize(i1);
                    ProEditFontActivity.n(a).onTextCreate();
                    ProEditFontActivity.a(a, ProEditFontActivity.n(a));
                }
                Log.e("ProEditFontActivity", "getFontStrokeNum");
                ProEditFontActivity.G(a).setVisibility(0);
                ProEditFontActivity.G(a).setText((new StringBuilder()).append(a.getResources().getString(0x7f0601a8)).append(":").append(String.valueOf(i1)).toString());
                ProEditFontActivity.g(a);
            }

            public void a(FontTextLabelInfo fonttextlabelinfo)
            {
                fonttextlabelinfo.r = 0;
                if (ProEditFontActivity.n(a) != null)
                {
                    ProEditFontActivity.n(a).setFlip(false);
                    ProEditFontActivity.n(a).setFontLabelInfo1(fonttextlabelinfo);
                    ProEditFontActivity.n(a).onTextCreate();
                }
                Log.e("ProEditFontActivity", "getFontStyle");
                ProEditFontActivity.g(a);
            }

            public void a(hb hb1)
            {
                ProEditFontActivity.a(a, hb1);
                if (!ProEditFontActivity.F(a).a && !ProEditFontActivity.F(a).e)
                {
                    break MISSING_BLOCK_LABEL_198;
                }
                if (!iq.a().b(ProEditFontActivity.F(a))) goto _L2; else goto _L1
_L1:
                if (iq.a().a(ProEditFontActivity.F(a)) != null && ProEditFontActivity.n(a) != null)
                {
                    ProEditFontActivity.n(a).setFontLabelFontInfo(ProEditFontActivity.F(a));
                    ProEditFontActivity.n(a).onTextCreate();
                    ProEditFontActivity.a(a, ProEditFontActivity.n(a));
                    ProEditFontActivity.g(a);
                }
_L4:
                return;
_L2:
                if (ProEditFontActivity.H(a) != null) goto _L4; else goto _L3
_L3:
                ProEditFontActivity.a(a, FontPreViewDialog.a());
                ProEditFontActivity.H(a).a(a);
                ProEditFontActivity.H(a).a(ProEditFontActivity.F(a));
                ProEditFontActivity.H(a).show(a.getSupportFragmentManager(), "preview");
                return;
                a.a(ProEditFontActivity.F(a));
                return;
            }

            public void b()
            {
                ProEditFontActivity.a(a, ProEditFontActivity.G(a), 0x7f040013, 300L, false);
            }

            public void b(int i1)
            {
                if (ProEditFontActivity.n(a) != null)
                {
                    ProEditFontActivity.n(a).setLabelStrokeColor(i1);
                    ProEditFontActivity.n(a).onTextCreate();
                }
                Log.e("ProEditFontActivity", "getFontStrokeColor");
            }

            public void b(FontTextLabelInfo fonttextlabelinfo)
            {
                if (ProEditFontActivity.n(a) != null)
                {
                    ProEditFontActivity.n(a).setLabelTextImage(fonttextlabelinfo);
                    ProEditFontActivity.n(a).onTextCreate();
                }
                Log.e("ProEditFontActivity", "getFontForgroundColor");
            }

            public void c()
            {
                ProEditFontActivity.G(a).setVisibility(4);
            }

            public void c(int i1)
            {
                if (ProEditFontActivity.n(a) != null)
                {
                    ProEditFontActivity.n(a).setShadowLabelVal(i1);
                    ProEditFontActivity.n(a).onTextCreate();
                    ProEditFontActivity.a(a, ProEditFontActivity.n(a));
                }
                Log.e("ProEditFontActivity", "getFontShadowNum");
                ProEditFontActivity.G(a).setVisibility(0);
                ProEditFontActivity.G(a).setText((new StringBuilder()).append(a.getResources().getString(0x7f0601a7)).append(":").append(String.valueOf(i1)).toString());
                ProEditFontActivity.g(a);
            }

            public void d(int i1)
            {
                if (ProEditFontActivity.n(a) != null)
                {
                    ProEditFontActivity.n(a).setShadowLabelColor(i1);
                    ProEditFontActivity.n(a).onTextCreate();
                }
                Log.e("ProEditFontActivity", "getFontShadowColor");
            }

            public void e(int i1)
            {
                if (ProEditFontActivity.n(a) != null)
                {
                    ProEditFontActivity.n(a).setTextLabelAlpha(i1);
                    ProEditFontActivity.n(a).onTextCreate();
                }
                Log.e("ProEditFontActivity", "getFontTranspareny");
            }

            
            {
                a = ProEditFontActivity.this;
                super();
            }
        };
    }

    static boolean A(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.O;
    }

    static RelativeLayout B(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.j;
    }

    static int C(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.k;
    }

    static String D(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.d;
    }

    static boolean E(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.H;
    }

    static hb F(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.h;
    }

    static TextView G(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.B;
    }

    static FontPreViewDialog H(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.l;
    }

    static int a(ProEditFontActivity proeditfontactivity, int i1)
    {
        proeditfontactivity.k = i1;
        return i1;
    }

    static Bitmap a(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.r;
    }

    static Bitmap a(ProEditFontActivity proeditfontactivity, Bitmap bitmap)
    {
        proeditfontactivity.r = bitmap;
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

    static FontPreViewDialog a(ProEditFontActivity proeditfontactivity, FontPreViewDialog fontpreviewdialog)
    {
        proeditfontactivity.l = fontpreviewdialog;
        return fontpreviewdialog;
    }

    static com.fotoable.fotoproedit.activity.font.TProEditTextBottomBar.COMBOTTOMBTN a(ProEditFontActivity proeditfontactivity, com.fotoable.fotoproedit.activity.font.TProEditTextBottomBar.COMBOTTOMBTN combottombtn)
    {
        proeditfontactivity.g = combottombtn;
        return combottombtn;
    }

    static hb a(ProEditFontActivity proeditfontactivity, hb hb1)
    {
        proeditfontactivity.h = hb1;
        return hb1;
    }

    private void a(View view, float f1, float f2, float f3)
    {
        TranslateAnimation translateanimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, 0.0F, 0, f1);
        translateanimation.setDuration(300L);
        translateanimation.setFillEnabled(true);
        translateanimation.setFillAfter(true);
        translateanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener(view, f2, f3) {

            final View a;
            final float b;
            final float c;
            final ProEditFontActivity d;

            public void onAnimationEnd(Animation animation)
            {
                a.clearAnimation();
                animation = (android.widget.FrameLayout.LayoutParams)a.getLayoutParams();
                animation.bottomMargin = (int)b;
                if (c >= 0.0F)
                {
                    animation.height = (int)c;
                }
                a.requestLayout();
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                d = ProEditFontActivity.this;
                a = view;
                b = f1;
                c = f2;
                super();
            }
        });
        view.startAnimation(translateanimation);
    }

    private void a(View view, int i1, long l1, boolean flag)
    {
        view.setVisibility(0);
        Animation animation = AnimationUtils.loadAnimation(this, i1);
        animation.setDuration(l1);
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener(view, flag) {

            final View a;
            final boolean b;
            final ProEditFontActivity c;

            public void onAnimationEnd(Animation animation1)
            {
                a.clearAnimation();
                if (b)
                {
                    a.setVisibility(0);
                    return;
                } else
                {
                    a.setVisibility(4);
                    return;
                }
            }

            public void onAnimationRepeat(Animation animation1)
            {
            }

            public void onAnimationStart(Animation animation1)
            {
            }

            
            {
                c = ProEditFontActivity.this;
                a = view;
                b = flag;
                super();
            }
        });
        view.startAnimation(animation);
    }

    static void a(ProEditFontActivity proeditfontactivity, View view)
    {
        proeditfontactivity.b(view);
    }

    static void a(ProEditFontActivity proeditfontactivity, View view, int i1, long l1, boolean flag)
    {
        proeditfontactivity.a(view, i1, l1, flag);
    }

    static void a(ProEditFontActivity proeditfontactivity, FontTextLabelView fonttextlabelview)
    {
        proeditfontactivity.a(fonttextlabelview);
    }

    private void a(FontTextLabelView fonttextlabelview)
    {
        Object obj = fonttextlabelview.viewSize();
        Object obj1 = fonttextlabelview.centerPt();
        int i1 = (int)(((PointF) (obj1)).x - (float)(((kp) (obj)).a() / 2));
        int j1 = (int)(((PointF) (obj1)).y - (float)(((kp) (obj)).b() / 2));
        int k1 = ((kp) (obj)).a();
        int l1 = ((kp) (obj)).b();
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
        v.setPtArray(arraylist);
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
            v.setVisibility(0);
        } else
        {
            v.setVisibility(4);
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
        v.setPtArray(arraylist);
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

    private void a(boolean flag)
    {
        if (flag)
        {
            D.setVisibility(0);
            if (s != null && !s.hasBg())
            {
                F.setVisibility(4);
            } else
            {
                F.setVisibility(0);
            }
            if (G.size() > 1)
            {
                E.setVisibility(0);
            } else
            {
                E.setVisibility(4);
            }
            r();
        } else
        {
            D.setVisibility(4);
            F.setVisibility(4);
            E.setVisibility(4);
        }
        a(s, flag);
    }

    private boolean a(MotionEvent motionevent)
    {
        int j1 = (int)motionevent.getX();
        int k1 = (int)motionevent.getY();
        int i1 = 0;
        boolean flag = false;
        for (; i1 < G.size(); i1++)
        {
            motionevent = (FontTextLabelView)G.get(i1);
            Rect rect = a(((View) (motionevent)));
            flag = motionevent.isTouchLabel(j1 - rect.left, k1 - rect.top);
            if (flag)
            {
                motionevent.bringToFront();
                G.remove(i1);
                G.add(0, motionevent);
                b(motionevent);
                H = true;
                if (s != null)
                {
                    f.setStyleFontAndTxt(s.labelinfo(), s.fontInfo());
                }
                i.setText(s.getText());
                i.setSelection(i.getText().length());
                return flag;
            }
        }

        return flag;
    }

    static boolean a(ProEditFontActivity proeditfontactivity, MotionEvent motionevent)
    {
        return proeditfontactivity.a(motionevent);
    }

    static boolean a(ProEditFontActivity proeditfontactivity, boolean flag)
    {
        proeditfontactivity.I = flag;
        return flag;
    }

    static Rect b(ProEditFontActivity proeditfontactivity, View view)
    {
        return proeditfontactivity.a(view);
    }

    static ImageView b(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.o;
    }

    private void b(View view)
    {
        m = true;
        view.setFocusableInTouchMode(true);
        if (view.requestFocus())
        {
            ((InputMethodManager)getSystemService("input_method")).showSoftInput(view, 1);
            Log.e("ProEditFontActivity", "keyboard will show");
        }
    }

    static void b(ProEditFontActivity proeditfontactivity, FontTextLabelView fonttextlabelview)
    {
        proeditfontactivity.b(fonttextlabelview);
    }

    private void b(FontTextLabelView fonttextlabelview)
    {
        if (s != null)
        {
            if (s.getText().length() == 0)
            {
                s.setLabelTextStr(getResources().getText(0x7f060267).toString());
                s.onTextCreate();
            }
            v.setVisibility(4);
            a(s);
        }
        s = fonttextlabelview;
        if (s != null)
        {
            a(s, true);
            s.onTextCreate();
            r();
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
        if (s != null)
        {
            obj = a(s);
        }
        int i1 = getResources().getDisplayMetrics().heightPixels - (k + ew.a(this, 200F)) - ((Rect) (obj)).top;
        if (i1 < 0)
        {
            float f1 = ((android.widget.FrameLayout.LayoutParams)t.getLayoutParams()).bottomMargin - i1;
            a(t, i1, f1, -1F);
        }
        obj = (android.widget.FrameLayout.LayoutParams)e.getLayoutParams();
        if ((float)((android.widget.FrameLayout.LayoutParams) (obj)).bottomMargin == 0.0F)
        {
            a(e, -k, k, -1F);
        } else
        {
            obj.bottomMargin = k;
            e.requestLayout();
        }
        a(f, -k, 0.0F, k);
        (new Handler()).postDelayed(new Runnable(flag) {

            final boolean a;
            final ProEditFontActivity b;

            public void run()
            {
                if (a)
                {
                    ProEditFontActivity.a(b, ProEditFontActivity.l(b));
                }
                ProEditFontActivity.g(b);
            }

            
            {
                b = ProEditFontActivity.this;
                a = flag;
                super();
            }
        }, 300L);
    }

    static boolean b(ProEditFontActivity proeditfontactivity, boolean flag)
    {
        proeditfontactivity.p = flag;
        return flag;
    }

    static void c(ProEditFontActivity proeditfontactivity)
    {
        proeditfontactivity.l();
    }

    static void c(ProEditFontActivity proeditfontactivity, boolean flag)
    {
        proeditfontactivity.b(flag);
    }

    static void d(ProEditFontActivity proeditfontactivity)
    {
        proeditfontactivity.m();
    }

    static void d(ProEditFontActivity proeditfontactivity, boolean flag)
    {
        proeditfontactivity.a(flag);
    }

    static FrameLayout e(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.K;
    }

    static boolean e(ProEditFontActivity proeditfontactivity, boolean flag)
    {
        proeditfontactivity.H = flag;
        return flag;
    }

    static boolean f(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.I;
    }

    public static String g()
    {
        return PIPCameraApplication.b().c().getApplicationContext().getDir("onlineRes", 0).getAbsolutePath();
    }

    static void g(ProEditFontActivity proeditfontactivity)
    {
        proeditfontactivity.r();
    }

    static boolean h(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.p;
    }

    private void i()
    {
        (new Thread(new Runnable() {

            final ProEditFontActivity a;

            public void run()
            {
                for (int i1 = 0; ProEditFontActivity.a(a) == null && i1 < 6; ProEditFontActivity.a(a, gm.c().k()))
                {
                    i1++;
                }

                a.runOnUiThread(new Runnable(this) {

                    final _cls1 a;

                    public void run()
                    {
                        if (ProEditFontActivity.a(a.a) == null)
                        {
                            a.a.finish();
                            return;
                        } else
                        {
                            ProEditFontActivity.b(a.a).setImageBitmap(ProEditFontActivity.a(a.a));
                            ProEditFontActivity.c(a.a);
                            ProEditFontActivity.d(a.a);
                            ProEditFontActivity.e(a.a).setVisibility(8);
                            return;
                        }
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            
            {
                a = ProEditFontActivity.this;
                super();
            }
        })).start();
    }

    static void i(ProEditFontActivity proeditfontactivity)
    {
        proeditfontactivity.o();
    }

    static FrameLayout j(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.L;
    }

    private void j()
    {
        if (s != null && G.size() > 1)
        {
            G.remove(s);
            u.removeView(s);
            b(((FontTextLabelView) (null)));
            a(false);
        }
    }

    private void k()
    {
        if (s != null)
        {
            s.startFlip();
            s.onTextCreate();
        }
    }

    static void k(ProEditFontActivity proeditfontactivity)
    {
        proeditfontactivity.t();
    }

    static fontEditText l(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.i;
    }

    private void l()
    {
        if (r == null)
        {
            c();
            finish();
            return;
        }
        float f1;
        float f2;
        float f3;
        float f4;
        float f5;
        android.widget.FrameLayout.LayoutParams layoutparams;
        if (J.getVisibility() != 0)
        {
            f1 = getResources().getDisplayMetrics().heightPixels - ew.a(this, 116F);
        } else
        {
            f1 = getResources().getDisplayMetrics().heightPixels - ew.a(this, 166F);
        }
        f3 = getResources().getDisplayMetrics().widthPixels - ew.a(this, 16F);
        f5 = r.getWidth();
        f4 = r.getHeight();
        f2 = f4 / f1;
        if (f5 / f4 > f3 / f1)
        {
            f2 = f5 / f3;
        }
        x = f2;
        f5 /= f2;
        f2 = f4 / f2;
        layoutparams = new android.widget.FrameLayout.LayoutParams((int)f5, (int)f2);
        layoutparams.gravity = 83;
        layoutparams.bottomMargin = (int)((float)ew.a(this, 58F) + (f1 - f2) / 2.0F);
        f4 = ew.a(this, 58F);
        w = (int)((f1 - f2) / 2.0F + f4);
        layoutparams.leftMargin = (int)((float)ew.a(this, 8F) + (f3 - f5) / 2.0F);
        t.setLayoutParams(layoutparams);
    }

    static FontKeyBoardBottomView m(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.f;
    }

    private void m()
    {
        float f1 = (float)r.getWidth() / x;
        float f2 = (float)r.getHeight() / x;
        FontTextLabelView fonttextlabelview = new FontTextLabelView(this, null);
        u.addView(fonttextlabelview);
        A.bringToFront();
        fonttextlabelview.setFontLabelSize(0);
        fonttextlabelview.setCPoint((int)f1 / 2, (int)f2 / 2);
        fonttextlabelview.setNewScale(0.4F);
        fonttextlabelview.setLabelTextStr(getResources().getText(0x7f060267).toString());
        fonttextlabelview.setListener(new hr() {

            final ProEditFontActivity a;

            public void a(FontTextLabelView fonttextlabelview1)
            {
                if (ProEditFontActivity.f(a))
                {
                    ProEditFontActivity.a(a, false);
                    ProEditFontActivity.g(a);
                }
            }

            
            {
                a = ProEditFontActivity.this;
                super();
            }
        });
        fonttextlabelview.onTextCreate();
        a(fonttextlabelview);
        G.add(fonttextlabelview);
        b(fonttextlabelview);
        a(true);
        if (G.size() > 1)
        {
            E.setVisibility(0);
            return;
        } else
        {
            E.setVisibility(4);
            return;
        }
    }

    static FontTextLabelView n(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.s;
    }

    private void n()
    {
        e.setListner(a);
        f.setListener(R);
        j.getViewTreeObserver().addOnGlobalLayoutListener(P);
        i.addTextChangedListener(Q);
        i.clearFocus();
        getWindow().setSoftInputMode(2);
        q.setListener(N);
        k = la.a(this, d, ew.a(this, 216F));
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)f.getLayoutParams();
        layoutparams.width = getResources().getDisplayMetrics().widthPixels;
        layoutparams.height = k;
        layoutparams.bottomMargin = -k;
        f.setLayoutParams(layoutparams);
        j.setBackgroundColor(Color.rgb(70, 70, 70));
    }

    private void o()
    {
        if (s == null && G != null && G.size() > 0)
        {
            b((FontTextLabelView)G.get(G.size() - 1));
        }
        if (s != null)
        {
            v.setVisibility(0);
            if (i.getText().length() == 0)
            {
                s.setLabelTextStr("");
                s.onTextCreate();
                a(s);
                r();
            }
        }
    }

    static void o(ProEditFontActivity proeditfontactivity)
    {
        proeditfontactivity.u();
    }

    private void p()
    {
        if (i.getText().length() == 0 && s != null)
        {
            s.setLabelTextStr(getResources().getString(0x7f060267));
            s.onTextCreate();
            a(s);
            r();
        }
    }

    static void p(ProEditFontActivity proeditfontactivity)
    {
        proeditfontactivity.s();
    }

    static FrameLayout q(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.t;
    }

    private void q()
    {
        h = new hb();
        h.a("sans");
    }

    static ImageView r(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.E;
    }

    private void r()
    {
        if (s != null)
        {
            Object obj = s.viewSize();
            Object obj1 = s.centerPt();
            a(t);
            int i1 = (int)(((PointF) (obj1)).x - (float)(((kp) (obj)).a() / 2));
            int j1 = (int)(((PointF) (obj1)).y - (float)(((kp) (obj)).b() / 2));
            obj1 = s.cursorPt1();
            obj = s.cursorPt2();
            float f1 = i1;
            float f2 = ((PointF) (obj1)).x;
            float f3 = j1;
            obj1 = new PointF(f1 + f2, ((PointF) (obj1)).y + f3);
            f1 = i1;
            f2 = ((PointF) (obj)).x;
            f3 = j1;
            obj = new PointF(f1 + f2, ((PointF) (obj)).y + f3);
            A.setLocation(((PointF) (obj1)), ((PointF) (obj)));
            obj = new PointF((float)i1 + s.deletePt().x, (float)j1 + s.deletePt().y);
            obj1 = new PointF((float)i1 + s.flipPt().x, (float)j1 + s.flipPt().y);
            Object obj2 = new PointF((float)i1 + s.rotatePt().x, (float)j1 + s.rotatePt().y);
            i1 = ew.a(this, 50F);
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(40, 40);
            layoutparams.leftMargin = (int)(((PointF) (obj2)).x - (float)(i1 / 2));
            layoutparams.topMargin = (int)(((PointF) (obj2)).y - (float)(i1 / 2));
            layoutparams.gravity = 51;
            layoutparams.width = i1;
            layoutparams.height = i1;
            D.setLayoutParams(layoutparams);
            obj2 = new android.widget.FrameLayout.LayoutParams(40, 40);
            obj2.leftMargin = (int)(((PointF) (obj1)).x - (float)(i1 / 2));
            obj2.topMargin = (int)(((PointF) (obj1)).y - (float)(i1 / 2));
            obj2.gravity = 51;
            obj2.width = i1;
            obj2.height = i1;
            F.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            obj1 = new android.widget.FrameLayout.LayoutParams(40, 40);
            obj1.leftMargin = (int)(((PointF) (obj)).x - (float)(i1 / 2));
            obj1.topMargin = (int)(((PointF) (obj)).y - (float)(i1 / 2));
            obj1.gravity = 51;
            obj1.width = i1;
            obj1.height = i1;
            E.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            a(s, true);
        }
    }

    private void s()
    {
        u();
        if (p)
        {
            p = false;
            p();
            w();
            a(L, 0x7f04000a, 300L, true);
        }
    }

    static void s(ProEditFontActivity proeditfontactivity)
    {
        proeditfontactivity.j();
    }

    static ImageView t(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.F;
    }

    private void t()
    {
        if (O)
        {
            return;
        } else
        {
            O = true;
            r();
            b.postDelayed(c, 1000L);
            return;
        }
    }

    private void u()
    {
        O = false;
        A.setVisibility(4);
    }

    static void u(ProEditFontActivity proeditfontactivity)
    {
        proeditfontactivity.k();
    }

    static TProEditTextBottomBar v(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.e;
    }

    private void v()
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
            obj = new File((new StringBuilder()).append(g()).append("/fonts").toString());
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

    static FontSldeLineView w(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.v;
    }

    private void w()
    {
        float f1 = ((android.widget.FrameLayout.LayoutParams)t.getLayoutParams()).bottomMargin - w;
        a(t, f1, w, -1F);
        a(e, k, 0.0F, -1F);
        a(f, k, -k - 3, k);
        (new Handler()).postDelayed(new Runnable() {

            final ProEditFontActivity a;

            public void run()
            {
                a.a();
                if (ProEditFontActivity.n(a) != null)
                {
                    ProEditFontActivity.g(a);
                    ProEditFontActivity.d(a, true);
                }
            }

            
            {
                a = ProEditFontActivity.this;
                super();
            }
        }, 300L);
    }

    private Bitmap x()
    {
        for (int i1 = 0; i1 < u.getChildCount(); i1++)
        {
            View view = u.getChildAt(i1);
            if ((view instanceof FontTextLabelView) && ((FontTextLabelView)view).getText().toString().equals(""))
            {
                view.setVisibility(4);
            }
        }

        int j1 = u.getWidth();
        int k1 = u.getHeight();
        float f1;
        float f2;
        float f3;
        Bitmap bitmap;
        Canvas canvas;
        if (k1 * j1 > r.getWidth() * r.getHeight())
        {
            k1 = (int)Math.sqrt((int)((float)(j1 * k1) / (float)(r.getWidth() * r.getHeight()) + 1.0F));
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
        bitmap = Bitmap.createBitmap(r.getWidth() * k1, r.getHeight() * k1, android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        f1 = x;
        f2 = k1;
        f3 = x;
        canvas.scale(f1 * f2, (float)k1 * f3);
        u.draw(canvas);
        return bitmap;
    }

    static ImageView x(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.D;
    }

    static boolean y(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.m;
    }

    static FontLabelCursorView z(ProEditFontActivity proeditfontactivity)
    {
        return proeditfontactivity.A;
    }

    public void a()
    {
        g = com.fotoable.fotoproedit.activity.font.TProEditTextBottomBar.COMBOTTOMBTN.DEFAULT;
        e.setBottomUnselected();
        hideSoftKeyborad(i);
    }

    public void a(hb hb1)
    {
        if (s != null)
        {
            s.setFontLabelFontInfo(hb1);
            s.onTextCreate();
            a(s);
            r();
        }
    }

    public void a(Boolean boolean1)
    {
        l.a(null);
        l.dismissAllowingStateLoss();
        l = null;
    }

    public void a(String s1)
    {
        z = s1;
    }

    public void b()
    {
        if (y != null)
        {
            return;
        }
        try
        {
            y = ProcessDialogFragment.a(f());
            y.setCancelable(false);
            y.show(getSupportFragmentManager(), "process");
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void b(hb hb1)
    {
        l.a(null);
        l.dismissAllowingStateLoss();
        l = null;
        ir.a(this).a(new is(hb1) {

            final hb a;
            final ProEditFontActivity b;

            public void a()
            {
                Toast.makeText(PIPCameraApplication.a, PIPCameraApplication.a.getResources().getString(0x7f0600d7), 0).show();
            }

            public void a(Typeface typeface)
            {
                Log.e("ProEditFontActivity", (new StringBuilder()).append("Font_").append(ProEditFontActivity.F(b).f).append("_installed").toString());
                if (ProEditFontActivity.n(b) != null)
                {
                    ProEditFontActivity.n(b).setFontLabelFontInfo(a);
                    ProEditFontActivity.n(b).onTextCreate();
                    ProEditFontActivity.a(b, ProEditFontActivity.n(b));
                    ProEditFontActivity.g(b);
                }
                ProEditFontActivity.m(b).refreshFontList();
            }

            
            {
                b = ProEditFontActivity.this;
                a = hb1;
                super();
            }
        });
        ir.a(this).a(hb1, true);
    }

    public void c()
    {
        try
        {
            if (y != null)
            {
                y.dismissAllowingStateLoss();
                a(getResources().getString(0x7f0601a4));
            }
        }
        catch (Exception exception) { }
        y = null;
    }

    public void d()
    {
        int i1 = 0;
        while (i1 < G.size()) 
        {
            Object obj = (FontTextLabelView)G.get(i1);
            String s1;
            if (((FontTextLabelView) (obj)).labelinfo().o)
            {
                s1 = ((FontTextLabelView) (obj)).labelinfo().i;
            } else
            {
                String.format("#%06X", new Object[] {
                    Integer.valueOf(0xffffff & ((FontTextLabelView) (obj)).labelinfo().j)
                });
            }
            if (((FontTextLabelView) (obj)).labelinfo().a >= 0)
            {
                (new StringBuilder()).append("newstyle_").append(((FontTextLabelView) (obj)).labelinfo().a).toString();
            }
            obj = h.f;
            i1++;
        }
        b();
        Bitmap bitmap;
        try
        {
            bitmap = x();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Log.e("ProEditFontActivity", "accapted Exception");
            c();
            return;
        }
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        kf.b("font");
        b();
        gm.c().a(new go() {

            final ProEditFontActivity a;

            public void a()
            {
                a.setResult(-1);
                a.c();
                a.finish();
                a.overridePendingTransition(0, 0x7f040027);
                Log.e("ProEditFontActivity", "font save finish");
            }

            
            {
                a = ProEditFontActivity.this;
                super();
            }
        }, bitmap, this);
    }

    public void e()
    {
        Log.e("ProEditFontActivity", "backclicked");
        c();
        v();
        finish();
        overridePendingTransition(0, 0x7f040027);
    }

    public String f()
    {
        return z;
    }

    public void h()
    {
        l = null;
    }

    public void hideSoftKeyborad(View view)
    {
        if (view != null && m)
        {
            m = false;
            InputMethodManager inputmethodmanager = (InputMethodManager)getSystemService("input_method");
            Log.e("ProEditFontActivity", "keyboard will hidden");
            inputmethodmanager.hideSoftInputFromWindow(view.getWindowToken(), 1);
        }
    }

    public void onBackPressed()
    {
        if (p)
        {
            s();
            return;
        } else
        {
            c();
            v();
            finish();
            overridePendingTransition(0, 0x7f040027);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030028);
        o = (ImageView)findViewById(0x7f0c00c5);
        e = (TProEditTextBottomBar)findViewById(0x7f0c00d0);
        q = (FontTextTouchView)findViewById(0x7f0c00cc);
        n = (ProEidtActionBarView)findViewById(0x7f0c0088);
        f = (FontKeyBoardBottomView)findViewById(0x7f0c00d1);
        n.setActionBarTitle(getResources().getString(0x7f060268));
        j = (RelativeLayout)findViewById(0x7f0c00cd);
        i = (fontEditText)findViewById(0x7f0c00ce);
        t = (FrameLayout)findViewById(0x7f0c00c3);
        u = (FrameLayout)findViewById(0x7f0c00c4);
        v = (FontSldeLineView)findViewById(0x7f0c00c6);
        A = (FontLabelCursorView)findViewById(0x7f0c00c7);
        B = (TextView)findViewById(0x7f0c00cb);
        C = (Button)findViewById(0x7f0c00cf);
        E = (ImageView)findViewById(0x7f0c00c9);
        F = (ImageView)findViewById(0x7f0c00c8);
        D = (ImageView)findViewById(0x7f0c00ca);
        K = (FrameLayout)findViewById(0x7f0c00d2);
        L = (FrameLayout)findViewById(0x7f0c006f);
        K.setVisibility(0);
        B.setVisibility(4);
        A.setVisibility(4);
        J = (RelativeLayout)findViewById(0x7f0c0055);
        n.setOnAcceptListener(this);
        G = new ArrayList();
        C.setOnClickListener(M);
        a(getResources().getString(0x7f0601a4));
        q();
        n();
        i();
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && l != null)
        {
            l.a(null);
            l.dismiss();
            l = null;
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
        Log.v("ProEditFontActivity", "ProEditFontActivity onResume");
        if (!ew.n(this))
        {
            J.setVisibility(0);
            FotoAdFactory.createAdBanner(this, J);
            return;
        } else
        {
            J.setVisibility(8);
            return;
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
