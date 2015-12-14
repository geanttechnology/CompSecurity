// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph;

import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.photo.morph.brushes.AbstractBrush;
import com.photo.morph.brushes.MoveBrush;
import com.photo.morph.brushes.RestoreBrush;
import com.photo.morph.brushes.SelectBrush;
import com.photo.morph.brushes.SqueezeBrush;
import com.photo.morph.brushes.SwirlBrush;
import com.photo.morph.brushes.a;
import com.picsart.effects.clone.BrushStyleView;
import com.picsart.studio.EditingData;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.b;
import com.socialin.android.dialog.g;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.util.ArrayList;
import java.util.HashMap;
import myobfuscated.f.m;

// Referenced classes of package com.photo.morph:
//            a, MorphGLSurfaceView, MorphRenderer

public class StretchActivity extends AdBaseActivity
    implements com.photo.morph.a
{

    MorphGLSurfaceView a;
    MoveBrush b;
    SqueezeBrush c;
    RestoreBrush d;
    HashMap e;
    private SwirlBrush f;
    private SelectBrush g;
    private String h;
    private int i;
    private int j;
    private g k;
    private com.socialin.android.dialog.a l;
    private float m;
    private float n;
    private boolean o;
    private RadioButton p;
    private View q;
    private boolean r;
    private RelativeLayout s;
    private EditingData t;
    private TimeCalculator u;
    private String v;
    private TimeCalculator w;

    public StretchActivity()
    {
        a = null;
        l = null;
        m = 0.0F;
        n = 0.0F;
        o = true;
        p = null;
        q = null;
        r = false;
        v = null;
    }

    static void A(StretchActivity stretchactivity)
    {
        stretchactivity.h();
    }

    static float a(StretchActivity stretchactivity, float f1)
    {
        stretchactivity.m = f1;
        return f1;
    }

    static Bitmap a(StretchActivity stretchactivity)
    {
        return stretchactivity.j();
    }

    static View a(StretchActivity stretchactivity, View view)
    {
        stretchactivity.q = view;
        return view;
    }

    static RadioButton a(StretchActivity stretchactivity, RadioButton radiobutton)
    {
        stretchactivity.p = radiobutton;
        return radiobutton;
    }

    static void a(StretchActivity stretchactivity, Bitmap bitmap)
    {
        stretchactivity.a = new MorphGLSurfaceView(stretchactivity);
        stretchactivity.a.setListener(stretchactivity);
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        stretchactivity.a.setLayoutParams(layoutparams);
        ((FrameLayout)stretchactivity.findViewById(0x7f100147)).addView(stretchactivity.a);
        stretchactivity.a.setBitmap(bitmap);
        stretchactivity.b.e = stretchactivity.o;
        stretchactivity.a.setBrush(stretchactivity.b);
    }

    private void a(boolean flag)
    {
        if (flag)
        {
            findViewById(0x7f100150).setVisibility(0);
            findViewById(0x7f100151).setEnabled(true);
            return;
        } else
        {
            findViewById(0x7f100150).setVisibility(4);
            findViewById(0x7f100151).setEnabled(false);
            return;
        }
    }

    static boolean a(StretchActivity stretchactivity, boolean flag)
    {
        stretchactivity.r = flag;
        return flag;
    }

    static float b(StretchActivity stretchactivity, float f1)
    {
        stretchactivity.n = f1;
        return f1;
    }

    static void b(StretchActivity stretchactivity)
    {
        stretchactivity.b = new MoveBrush((byte)0);
        stretchactivity.b.a(158F);
        stretchactivity.b.b(0.2F);
        stretchactivity.c = new SqueezeBrush();
        stretchactivity.c.a(256F);
        stretchactivity.c.b(0.5F);
        stretchactivity.f = new SwirlBrush();
        stretchactivity.f.a(256F);
        stretchactivity.f.b(0.5F);
        stretchactivity.d = new RestoreBrush(com.photo.morph.brushes.RestoreBrush.Mode.PHOTOSHOP, (byte)0);
        stretchactivity.d.a(200F);
        stretchactivity.d.b(0.9F);
        stretchactivity.g = new SelectBrush(com.photo.morph.brushes.SelectBrush.Mode.SELECT, (byte)0);
        stretchactivity.g.a(80F);
    }

    static void b(StretchActivity stretchactivity, View view)
    {
        Object obj = (BrushStyleView)view.findViewById(0x7f10028c);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            ((BrushStyleView) (obj)).setLayerType(1, null);
        }
        Object obj1 = stretchactivity.a.c;
        stretchactivity.m = ((a) (obj1)).a();
        stretchactivity.n = ((a) (obj1)).b();
        float f1 = stretchactivity.a.a();
        float f2 = ((a) (obj1)).a() * f1;
        int i1 = (int)(f1 * 512F);
        i1 = Math.min((int)Utils.a(150F, stretchactivity), i1);
        f1 = f2;
        if (f2 > (float)i1)
        {
            f1 = i1;
        }
        ((BrushStyleView) (obj)).setBrushMinPercent(0.0F);
        ((BrushStyleView) (obj)).setHardness(0.0F);
        int j1 = (int)((f1 / (float)i1) * 100F);
        ((BrushStyleView) (obj)).setBrushPercentSize(j1);
        ((BrushStyleView) (obj)).invalidate();
        obj1 = (TextView)view.findViewById(0x7f10028d);
        ((TextView) (obj1)).setText((new StringBuilder()).append(stretchactivity.getResources().getString(0x7f08006a)).append(" : ").append(j1).toString());
        SeekBar seekbar = (SeekBar)view.findViewById(0x7f10028e);
        seekbar.setMax(100);
        seekbar.setProgress(j1);
        seekbar.setOnSeekBarChangeListener(stretchactivity. new android.widget.SeekBar.OnSeekBarChangeListener(((TextView) (obj1)), i1, ((BrushStyleView) (obj))) {

            private TextView a;
            private int b;
            private BrushStyleView c;
            private StretchActivity d;

            public final void onProgressChanged(SeekBar seekbar1, int k1, boolean flag1)
            {
                a.setText((new StringBuilder()).append(d.getResources().getString(0x7f08006a)).append(" : ").append(seekbar1.getProgress()).toString());
                c.setBrushPercentSize(k1);
                c.invalidate();
            }

            public final void onStartTrackingTouch(SeekBar seekbar1)
            {
                a.setText((new StringBuilder()).append(d.getResources().getString(0x7f08006a)).append(" : ").append(seekbar1.getProgress()).toString());
            }

            public final void onStopTrackingTouch(SeekBar seekbar1)
            {
                a.setText((new StringBuilder()).append(d.getResources().getString(0x7f08006a)).append(" : ").append(seekbar1.getProgress()).toString());
                float f3 = (float)seekbar1.getProgress() / 100F;
                float f4 = b;
                float f5 = 1.0F / StretchActivity.e(d).a();
                com.photo.morph.StretchActivity.a(d, f3 * f4 * f5);
            }

            
            {
                d = StretchActivity.this;
                a = textview;
                b = i1;
                c = brushstyleview;
                super();
            }
        });
        obj = (SeekBar)view.findViewById(0x7f100a77);
        view = (TextView)view.findViewById(0x7f100a76);
        boolean flag;
        if (stretchactivity.a != null && stretchactivity.a.c == stretchactivity.g)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            ((SeekBar) (obj)).setVisibility(8);
            view.setVisibility(8);
            return;
        }
        ((SeekBar) (obj)).setMax(100);
        if (stretchactivity.a != null)
        {
            f1 = stretchactivity.a.c.b();
        } else
        {
            f1 = 0.0F;
        }
        flag = (int)(f1 * 100F);
        ((SeekBar) (obj)).setProgress(flag);
        view.setText((new StringBuilder()).append(stretchactivity.getString(0x7f080066)).append(flag).toString());
        ((SeekBar) (obj)).setOnSeekBarChangeListener(stretchactivity. new android.widget.SeekBar.OnSeekBarChangeListener(view) {

            private TextView a;
            private StretchActivity b;

            public final void onProgressChanged(SeekBar seekbar1, int k1, boolean flag1)
            {
                a.setText((new StringBuilder()).append(b.getString(0x7f080066)).append(k1).toString());
            }

            public final void onStartTrackingTouch(SeekBar seekbar1)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar1)
            {
                com.photo.morph.StretchActivity.b(b, (float)seekbar1.getProgress() / 100F);
            }

            
            {
                b = StretchActivity.this;
                a = textview;
                super();
            }
        });
    }

    static void c(StretchActivity stretchactivity)
    {
        stretchactivity.findViewById(0x7f100148).setOnClickListener(stretchactivity. new android.view.View.OnClickListener() {

            private StretchActivity a;

            public final void onClick(View view)
            {
                if (StretchActivity.e(a) != null)
                {
                    StretchActivity.e(a).b();
                }
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolStretchCloseEvent(StretchActivity.f(a).a, "cancel", (int)com.photo.morph.StretchActivity.g(a).d()));
                a.finish();
            }

            
            {
                a = StretchActivity.this;
                super();
            }
        });
        stretchactivity.findViewById(0x7f10014f).setOnClickListener(stretchactivity. new android.view.View.OnClickListener() {

            final StretchActivity a;

            public final void onClick(View view)
            {
                if (!StretchActivity.h(a))
                {
                    if (StretchActivity.e(a) != null)
                    {
                        StretchActivity.e(a).b();
                    }
                    com.photo.morph.StretchActivity.a(a, true);
                    view = StretchActivity.e(a).b.i();
                    if (view != null && !view.isRecycled())
                    {
                        a.a(Integer.valueOf(0x7f080573));
                        (new Thread(new Runnable(this, view) {

                            final Bitmap a;
                            final _cls9 b;

                            public final void run()
                            {
                                StretchActivity stretchactivity = b.a;
                                Bitmap bitmap = a;
                                boolean flag;
                                if (com.socialin.android.util.w.a(stretchactivity))
                                {
                                    stretchactivity.e = com.socialin.android.util.w.a((String)stretchactivity.e.get("path"), bitmap);
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                                b.a.runOnUiThread(new Runnable(this, flag) {

                                    private boolean a;
                                    private _cls1 b;

                                    public final void run()
                                    {
                                        b.b.a.d();
                                        if (b.a != null && !b.a.isRecycled())
                                        {
                                            com.socialin.android.util.c.a(b.a);
                                        }
                                        if (b.b.a.isFinishing())
                                        {
                                            return;
                                        }
                                        if (a)
                                        {
                                            Intent intent = new Intent();
                                            intent.putExtra("bufferData", StretchActivity.i(b.b.a));
                                            if (StretchActivity.j(b.b.a) != null)
                                            {
                                                AnalyticUtils.getInstance(b.b.a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolStretchEvent(StretchActivity.j(b.b.a)));
                                            }
                                            if (StretchActivity.f(b.b.a) != null)
                                            {
                                                StretchActivity.f(b.b.a).c("stretch");
                                                intent.putExtra("editing_data", StretchActivity.f(b.b.a));
                                            }
                                            b.b.a.setResult(-1, intent);
                                            AnalyticUtils.getInstance(b.b.a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolStretchCloseEvent(StretchActivity.f(b.b.a).a, "done", (int)com.photo.morph.StretchActivity.g(b.b.a).d()));
                                            b.b.a.finish();
                                        } else
                                        {
                                            Utils.b(b.b.a, 0x7f0805ca);
                                        }
                                        com.photo.morph.StretchActivity.a(b.b.a, false);
                                    }

            
            {
                b = _pcls1;
                a = flag;
                super();
            }
                                });
                            }

            
            {
                b = _pcls9;
                a = bitmap;
                super();
            }
                        })).start();
                        return;
                    }
                }
            }

            
            {
                a = StretchActivity.this;
                super();
            }
        });
        stretchactivity.findViewById(0x7f100151).setOnClickListener(stretchactivity. new android.view.View.OnClickListener() {

            private StretchActivity a;

            public final void onClick(View view)
            {
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolStretchTryEvent(StretchActivity.f(a).a, "erase_select"));
                StretchActivity.e(a).b.setDefaultSelection();
                StretchActivity.k(a);
                if (StretchActivity.e(a).c == StretchActivity.l(a) && StretchActivity.l(a).f == com.photo.morph.brushes.SelectBrush.Mode.UNSELECT)
                {
                    com.photo.morph.StretchActivity.m(a);
                    if (StretchActivity.n(a) != null)
                    {
                        StretchActivity.n(a).setChecked(false);
                    }
                    StretchActivity.o(a).setVisibility(0);
                }
            }

            
            {
                a = StretchActivity.this;
                super();
            }
        });
        stretchactivity.i();
        android.view.View.OnClickListener onclicklistener = stretchactivity. new android.view.View.OnClickListener() {

            private StretchActivity a;

            public final void onClick(View view)
            {
                a a1 = StretchActivity.e(a).c;
                if (view.getId() == 0x7f100149)
                {
                    AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolStretchTryEvent(StretchActivity.f(a).a, "select"));
                    if (a1 == StretchActivity.l(a) && StretchActivity.l(a).f == com.photo.morph.brushes.SelectBrush.Mode.SELECT)
                    {
                        StretchActivity.p(a);
                        return;
                    }
                    com.photo.morph.StretchActivity.m(a);
                } else
                {
                    AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolStretchTryEvent(StretchActivity.f(a).a, "deselect"));
                    if (a1 == StretchActivity.l(a) && StretchActivity.l(a).f == com.photo.morph.brushes.SelectBrush.Mode.UNSELECT)
                    {
                        StretchActivity.p(a);
                        return;
                    }
                    if (StretchActivity.o(a) != null)
                    {
                        StretchActivity.o(a).setVisibility(8);
                    }
                    com.photo.morph.StretchActivity.a(a, a.findViewById(0x7f10014c));
                    StretchActivity.q(a);
                    a.g();
                    StretchActivity.l(a).f = com.photo.morph.brushes.SelectBrush.Mode.UNSELECT;
                }
                if (StretchActivity.n(a) != null)
                {
                    StretchActivity.n(a).setChecked(false);
                }
                StretchActivity.o(a).setVisibility(0);
            }

            
            {
                a = StretchActivity.this;
                super();
            }
        };
        stretchactivity.findViewById(0x7f100149).setOnClickListener(onclicklistener);
        stretchactivity.findViewById(0x7f10014b).setOnClickListener(onclicklistener);
        stretchactivity.findViewById(0x7f10014d).setOnClickListener(stretchactivity. new android.view.View.OnClickListener() {

            private StretchActivity a;

            public final void onClick(View view)
            {
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolStretchTryEvent(StretchActivity.f(a).a, "original"));
                StretchActivity.e(a).b.setDefaultCoords();
            }

            
            {
                a = StretchActivity.this;
                super();
            }
        });
    }

    static void d(StretchActivity stretchactivity)
    {
        Object obj = (RadioButton)stretchactivity.findViewById(0x7f100154);
        RadioButton radiobutton = (RadioButton)stretchactivity.findViewById(0x7f100157);
        RadioButton radiobutton1 = (RadioButton)stretchactivity.findViewById(0x7f10015a);
        RadioButton radiobutton2 = (RadioButton)stretchactivity.findViewById(0x7f10015d);
        RadioButton radiobutton3 = (RadioButton)stretchactivity.findViewById(0x7f100160);
        RadioButton radiobutton4 = (RadioButton)stretchactivity.findViewById(0x7f100163);
        android.view.View.OnClickListener onclicklistener = stretchactivity. new android.view.View.OnClickListener() {

            private StretchActivity a;

            public final void onClick(View view)
            {
                StretchActivity.r(a);
                if (view.getId() != 0x7f100154)
                {
                    break MISSING_BLOCK_LABEL_243;
                }
                StretchActivity stretchactivity1 = a;
                boolean flag;
                if (stretchactivity1.a != null && stretchactivity1.a.c == stretchactivity1.b)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag) goto _L2; else goto _L1
_L1:
                StretchActivity.p(a);
_L4:
                return;
_L2:
                StretchActivity stretchactivity2 = a;
                if (stretchactivity2.a != null)
                {
                    stretchactivity2.a.setBrush(stretchactivity2.b);
                    stretchactivity2.b.a(158F);
                    stretchactivity2.b.b(0.2F);
                    stretchactivity2.a.setTouchMode(MorphGLSurfaceView.TouchMode.PAINT);
                    stretchactivity2.h();
                }
                if (StretchActivity.o(a) != null)
                {
                    StretchActivity.o(a).setVisibility(8);
                }
                com.photo.morph.StretchActivity.a(a, a.findViewById(0x7f100156));
_L5:
                StretchActivity.e(a).c.a(StretchActivity.t(a));
                if (StretchActivity.n(a) != null)
                {
                    StretchActivity.n(a).setChecked(false);
                }
                com.photo.morph.StretchActivity.a(a, (RadioButton)view);
                StretchActivity.n(a).setChecked(true);
                if (StretchActivity.o(a) == null) goto _L4; else goto _L3
_L3:
                StretchActivity.o(a).setVisibility(0);
                return;
                if (view.getId() == 0x7f100157)
                {
                    AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolStretchTryEvent(StretchActivity.f(a).a, "ccw"));
                    if (a.e() && StretchActivity.s(a).f == com.photo.morph.brushes.SwirlBrush.Mode.LEFT)
                    {
                        StretchActivity.p(a);
                        return;
                    }
                    a.f();
                    a.a(com.photo.morph.brushes.SwirlBrush.Mode.LEFT);
                    if (StretchActivity.o(a) != null)
                    {
                        StretchActivity.o(a).setVisibility(8);
                    }
                    com.photo.morph.StretchActivity.a(a, a.findViewById(0x7f100159));
                } else
                if (view.getId() == 0x7f10015a)
                {
                    AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolStretchTryEvent(StretchActivity.f(a).a, "cw"));
                    if (a.e() && StretchActivity.s(a).f == com.photo.morph.brushes.SwirlBrush.Mode.RIGHT)
                    {
                        StretchActivity.p(a);
                        return;
                    }
                    a.f();
                    a.a(com.photo.morph.brushes.SwirlBrush.Mode.RIGHT);
                    if (StretchActivity.o(a) != null)
                    {
                        StretchActivity.o(a).setVisibility(8);
                    }
                    com.photo.morph.StretchActivity.a(a, a.findViewById(0x7f10015c));
                } else
                if (view.getId() == 0x7f10015d)
                {
                    AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolStretchTryEvent(StretchActivity.f(a).a, "center"));
                    StretchActivity stretchactivity3 = a;
                    boolean flag1;
                    if (stretchactivity3.a != null && stretchactivity3.a.c == stretchactivity3.c)
                    {
                        if (stretchactivity3.c.f == com.photo.morph.brushes.SqueezeBrush.Mode.IN)
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                    } else
                    {
                        flag1 = false;
                    }
                    if (flag1)
                    {
                        StretchActivity.p(a);
                        return;
                    }
                    stretchactivity3 = a;
                    if (stretchactivity3.a != null)
                    {
                        stretchactivity3.a.setBrush(stretchactivity3.c);
                        stretchactivity3.c.f = com.photo.morph.brushes.SqueezeBrush.Mode.IN;
                        stretchactivity3.c.a(256F);
                        stretchactivity3.c.b(0.5F);
                        stretchactivity3.a.setTouchMode(MorphGLSurfaceView.TouchMode.PAINT);
                        stretchactivity3.h();
                    }
                    if (StretchActivity.o(a) != null)
                    {
                        StretchActivity.o(a).setVisibility(8);
                    }
                    com.photo.morph.StretchActivity.a(a, a.findViewById(0x7f10015f));
                } else
                if (view.getId() == 0x7f100160)
                {
                    AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolStretchTryEvent(StretchActivity.f(a).a, "out"));
                    StretchActivity stretchactivity4 = a;
                    boolean flag2;
                    if (stretchactivity4.a != null && stretchactivity4.a.c == stretchactivity4.c)
                    {
                        if (stretchactivity4.c.f == com.photo.morph.brushes.SqueezeBrush.Mode.OUT)
                        {
                            flag2 = true;
                        } else
                        {
                            flag2 = false;
                        }
                    } else
                    {
                        flag2 = false;
                    }
                    if (flag2)
                    {
                        StretchActivity.p(a);
                        return;
                    }
                    stretchactivity4 = a;
                    if (stretchactivity4.a != null)
                    {
                        stretchactivity4.a.setBrush(stretchactivity4.c);
                        stretchactivity4.c.f = com.photo.morph.brushes.SqueezeBrush.Mode.OUT;
                        stretchactivity4.c.a(256F);
                        stretchactivity4.c.b(0.5F);
                        stretchactivity4.a.setTouchMode(MorphGLSurfaceView.TouchMode.PAINT);
                        stretchactivity4.h();
                    }
                    if (StretchActivity.o(a) != null)
                    {
                        StretchActivity.o(a).setVisibility(8);
                    }
                    com.photo.morph.StretchActivity.a(a, a.findViewById(0x7f100162));
                } else
                if (view.getId() == 0x7f100163)
                {
                    AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolStretchTryEvent(StretchActivity.f(a).a, "reverse"));
                    StretchActivity stretchactivity5 = a;
                    boolean flag3;
                    if (stretchactivity5.a != null && stretchactivity5.a.c == stretchactivity5.d)
                    {
                        flag3 = true;
                    } else
                    {
                        flag3 = false;
                    }
                    if (flag3)
                    {
                        StretchActivity.p(a);
                        return;
                    }
                    stretchactivity5 = a;
                    if (stretchactivity5.a != null)
                    {
                        stretchactivity5.a.setBrush(stretchactivity5.d);
                        stretchactivity5.d.a(200F);
                        stretchactivity5.d.b(0.9F);
                        stretchactivity5.a.setTouchMode(MorphGLSurfaceView.TouchMode.PAINT);
                        stretchactivity5.h();
                    }
                    if (StretchActivity.o(a) != null)
                    {
                        StretchActivity.o(a).setVisibility(8);
                    }
                    com.photo.morph.StretchActivity.a(a, a.findViewById(0x7f100165));
                }
                  goto _L5
            }

            
            {
                a = StretchActivity.this;
                super();
            }
        };
        ((RadioButton) (obj)).setOnClickListener(onclicklistener);
        radiobutton.setOnClickListener(onclicklistener);
        radiobutton1.setOnClickListener(onclicklistener);
        radiobutton2.setOnClickListener(onclicklistener);
        radiobutton3.setOnClickListener(onclicklistener);
        radiobutton4.setOnClickListener(onclicklistener);
        ((RadioButton) (obj)).setChecked(true);
        stretchactivity.p = ((RadioButton) (obj));
        obj = stretchactivity.findViewById(0x7f100156);
        ((View) (obj)).setVisibility(0);
        stretchactivity.q = ((View) (obj));
    }

    static MorphGLSurfaceView e(StretchActivity stretchactivity)
    {
        return stretchactivity.a;
    }

    static EditingData f(StretchActivity stretchactivity)
    {
        return stretchactivity.t;
    }

    static TimeCalculator g(StretchActivity stretchactivity)
    {
        return stretchactivity.w;
    }

    static boolean h(StretchActivity stretchactivity)
    {
        return stretchactivity.r;
    }

    static HashMap i(StretchActivity stretchactivity)
    {
        return stretchactivity.e;
    }

    private void i()
    {
        findViewById(0x7f100149).setBackgroundResource(0x7f02068f);
        findViewById(0x7f10014b).setBackgroundResource(0x7f02068f);
    }

    private Bitmap j()
    {
        Bitmap bitmap;
        Bitmap bitmap1;
        bitmap1 = null;
        bitmap = bitmap1;
        if (e == null) goto _L2; else goto _L1
_L1:
        bitmap = bitmap1;
        Object obj = com.socialin.android.util.w.a(e, j, i);
        Object obj1 = null;
_L5:
        if (obj1 == null || obj1 == obj)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        bitmap = ((Bitmap) (obj));
        ((Bitmap) (obj1)).recycle();
        bitmap = ((Bitmap) (obj));
        try
        {
            System.gc();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            exception = bitmap;
        }
        if (obj != null)
        {
            Log.e("ex1", (new StringBuilder("StretchActivity origBitmap w = ")).append(((Bitmap) (obj)).getWidth()).append(" h = ").append(((Bitmap) (obj)).getHeight()).toString());
        }
        return ((Bitmap) (obj));
_L2:
        obj = com.socialin.android.util.w.b(h, j, i);
        System.gc();
_L6:
        bitmap = bitmap1;
        if (((Bitmap) (obj)).isMutable()) goto _L4; else goto _L3
_L3:
        bitmap = bitmap1;
        bitmap1 = com.socialin.android.util.c.b(((Bitmap) (obj)), android.graphics.Bitmap.Config.ARGB_8888);
        obj1 = obj;
        obj = bitmap1;
          goto _L5
_L7:
        bitmap = bitmap1;
        ((Exception) (obj1)).printStackTrace();
          goto _L6
_L4:
        bitmap = ((Bitmap) (obj));
        obj1 = obj;
        obj = bitmap;
          goto _L5
        obj1;
          goto _L7
        obj1;
        exception = null;
          goto _L7
    }

    static String j(StretchActivity stretchactivity)
    {
        return stretchactivity.v;
    }

    private void k()
    {
        RelativeLayout relativelayout = (RelativeLayout)findViewById(0x7f100146);
        if (s != null)
        {
            relativelayout.removeView(s);
        }
        s = (RelativeLayout)getLayoutInflater().inflate(0x7f03014d, relativelayout, false);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams.addRule(2, 0x7f100127);
        s.setLayoutParams(layoutparams);
        relativelayout.addView(s);
        s.setOnClickListener(new android.view.View.OnClickListener(relativelayout) {

            private RelativeLayout a;
            private StretchActivity b;

            public final void onClick(View view)
            {
                a.removeView(StretchActivity.y(b));
                StretchActivity.z(b);
            }

            
            {
                b = StretchActivity.this;
                a = relativelayout;
                super();
            }
        });
    }

    static void k(StretchActivity stretchactivity)
    {
        stretchactivity.a(false);
    }

    static SelectBrush l(StretchActivity stretchactivity)
    {
        return stretchactivity.g;
    }

    static void m(StretchActivity stretchactivity)
    {
        if (stretchactivity.q != null)
        {
            stretchactivity.q.setVisibility(8);
        }
        stretchactivity.q = stretchactivity.findViewById(0x7f10014a);
        stretchactivity.findViewById(0x7f100149).setBackgroundResource(0x7f0205a1);
        stretchactivity.findViewById(0x7f10014b).setBackgroundResource(0x7f02068f);
        stretchactivity.g();
        stretchactivity.g.f = com.photo.morph.brushes.SelectBrush.Mode.SELECT;
    }

    static RadioButton n(StretchActivity stretchactivity)
    {
        return stretchactivity.p;
    }

    static View o(StretchActivity stretchactivity)
    {
        return stretchactivity.q;
    }

    static void p(StretchActivity stretchactivity)
    {
        b b1 = (new b()).a(1, 0x7f0c0181);
        b1.f = 0x7f03024a;
        b1.h = false;
        b1 = b1.a(stretchactivity. new android.view.View.OnClickListener() {

            private StretchActivity a;

            public final void onClick(View view)
            {
                view = a;
                float f1 = StretchActivity.u(a);
                if (((StretchActivity) (view)).a != null)
                {
                    ((StretchActivity) (view)).a.c.a(f1);
                }
                view = a;
                f1 = StretchActivity.v(a);
                if (((StretchActivity) (view)).a != null)
                {
                    ((StretchActivity) (view)).a.c.b(f1);
                }
            }

            
            {
                a = StretchActivity.this;
                super();
            }
        });
        b1.g = true;
        b1.p = stretchactivity. new com.socialin.android.dialog.c() {

            private StretchActivity a;

            public final void onViewCreated(View view, DialogFragment dialogfragment)
            {
                com.photo.morph.StretchActivity.b(a, view);
            }

            
            {
                a = StretchActivity.this;
                super();
            }
        };
        stretchactivity.l = b1.a();
        stretchactivity.l.show(stretchactivity.getFragmentManager(), null);
    }

    static void q(StretchActivity stretchactivity)
    {
        stretchactivity.findViewById(0x7f100149).setBackgroundResource(0x7f02068f);
        stretchactivity.findViewById(0x7f10014b).setBackgroundResource(0x7f0205a1);
    }

    static void r(StretchActivity stretchactivity)
    {
        stretchactivity.i();
    }

    static SwirlBrush s(StretchActivity stretchactivity)
    {
        return stretchactivity.f;
    }

    static boolean t(StretchActivity stretchactivity)
    {
        return stretchactivity.o;
    }

    static float u(StretchActivity stretchactivity)
    {
        return stretchactivity.m;
    }

    static float v(StretchActivity stretchactivity)
    {
        return stretchactivity.n;
    }

    static void w(StretchActivity stretchactivity)
    {
        Object obj = new com.socialin.android.util.a(stretchactivity);
        int i1 = ((com.socialin.android.util.a) (obj)).a.getSharedPreferences(((com.socialin.android.util.a) (obj)).b, 0).getInt("stretchHintCount", 0);
        if (i1 == 0)
        {
            stretchactivity.k();
        }
        obj = ((com.socialin.android.util.a) (obj)).a.getSharedPreferences(((com.socialin.android.util.a) (obj)).b, 0).edit();
        ((android.content.SharedPreferences.Editor) (obj)).putInt("stretchHintCount", i1 + 1);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        stretchactivity.findViewById(0x7f10014e).setOnClickListener(stretchactivity. new android.view.View.OnClickListener() {

            private StretchActivity a;

            public final void onClick(View view)
            {
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolStretchTryEvent(StretchActivity.f(a).a, "info_click"));
                StretchActivity.x(a);
            }

            
            {
                a = StretchActivity.this;
                super();
            }
        });
    }

    static void x(StretchActivity stretchactivity)
    {
        stretchactivity.k();
    }

    static RelativeLayout y(StretchActivity stretchactivity)
    {
        return stretchactivity.s;
    }

    static RelativeLayout z(StretchActivity stretchactivity)
    {
        stretchactivity.s = null;
        return null;
    }

    protected final ProgressDialog a(Integer integer)
    {
        if (k != null && k.isShowing())
        {
            return k;
        } else
        {
            k = new g(this);
            k.setMessage(getString(integer.intValue()));
            k.setCancelable(true);
            k.setCanceledOnTouchOutside(true);
            myobfuscated.f.m.a(this, k);
            return k;
        }
    }

    public final void a()
    {
        if (a != null && a.c == g)
        {
            a(true);
        }
    }

    public final void a(com.photo.morph.brushes.SwirlBrush.Mode mode)
    {
        if (f != null)
        {
            f.f = mode;
        }
    }

    public final boolean a(a a1)
    {
        return a1 == g;
    }

    public final void b()
    {
        runOnUiThread(new Runnable() {

            private StretchActivity a;

            public final void run()
            {
                a.d();
                com.photo.morph.StretchActivity.w(a);
            }

            
            {
                a = StretchActivity.this;
                super();
            }
        });
    }

    public final void c()
    {
        runOnUiThread(new Runnable() {

            final StretchActivity a;

            public final void run()
            {
                (new Handler()).post(new Runnable(this) {

                    private _cls7 a;

                    public final void run()
                    {
                        StretchActivity.A(a.a);
                    }

            
            {
                a = _pcls7;
                super();
            }
                });
            }

            
            {
                a = StretchActivity.this;
                super();
            }
        });
    }

    protected final void d()
    {
        if (!isFinishing() && k != null && k.isShowing())
        {
            myobfuscated.f.m.b(this, k);
            k = null;
        }
    }

    public final boolean e()
    {
        return a != null && a.c == f;
    }

    public final void f()
    {
        if (a != null)
        {
            a.setBrush(f);
            f.a(256F);
            f.b(0.5F);
            a.setTouchMode(MorphGLSurfaceView.TouchMode.PAINT);
            h();
        }
    }

    public final void g()
    {
        if (a != null)
        {
            g.f = com.photo.morph.brushes.SelectBrush.Mode.SELECT;
            if (a.c != g)
            {
                g.a(80F);
                g.e = o;
            }
            a.setBrush(g);
            a.setTouchMode(MorphGLSurfaceView.TouchMode.PAINT);
            h();
        }
    }

    protected ViewGroup getAdLayout()
    {
        View view = findViewById(0x7f100128);
        if (view != null)
        {
            return (RelativeLayout)view;
        } else
        {
            return null;
        }
    }

    final void h()
    {
        if (a != null)
        {
            a a1 = a.c;
            float f3 = a.a();
            float f2 = a1.a() * f3;
            int i1 = (int)(512F * f3);
            i1 = Math.min((int)Utils.a(150F, this), i1);
            float f1 = f2;
            if (f2 > (float)i1)
            {
                f1 = i1;
            }
            a1.a(f1 * (1.0F / f3));
        }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.ToolStretchCloseEvent(t.a, "back", (int)w.d()));
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            w = (TimeCalculator)bundle.getParcelable("time_calculator");
        }
        if (w == null)
        {
            w = new TimeCalculator();
        }
        getSupportActionBar().hide();
        getWindow().setFlags(1024, 1024);
        View view;
        View view1;
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        if (getResources().getConfiguration().orientation == 1)
        {
            setRequestedOrientation(1);
        } else
        {
            setRequestedOrientation(0);
        }
        if (bundle == null) goto _L2; else goto _L1
_L1:
        if (bundle.containsKey("editing_data"))
        {
            t = (EditingData)bundle.getParcelable("editing_data");
        }
_L4:
        if (!com.photo.morph.MorphGLSurfaceView.a)
        {
            bundle = new ArrayList();
            bundle.add("morph");
            bundle = com.socialin.android.photo.imgop.b.a(this, bundle);
            if (!bundle.containsKey("morph") || !((Boolean)bundle.get("morph")).booleanValue())
            {
                break; /* Loop/switch isn't completed */
            }
            com.photo.morph.MorphGLSurfaceView.a = true;
        }
        setContentView(0x7f030025);
        initAd();
        bundle = getIntent();
        h = bundle.getStringExtra("path");
        i = bundle.getIntExtra("degree", 0);
        if (bundle.hasExtra("bufferData"))
        {
            e = (HashMap)getIntent().getSerializableExtra("bufferData");
        }
        j = bundle.getIntExtra("maxPixels", PicsartContext.a());
        Log.e("ex1", (new StringBuilder("StretchActivity pixelsMaxCount = ")).append(j).toString());
        if (bundle.hasExtra("openedFromEffects"))
        {
            bundle.getBooleanExtra("openedFromEffects", false);
        }
        if (bundle.hasExtra("launchSource"))
        {
            v = bundle.getStringExtra("launchSource");
        }
        u = new TimeCalculator();
        a(false);
        bundle = findViewById(0x7f100156);
        view = findViewById(0x7f100159);
        view1 = findViewById(0x7f10015c);
        view2 = findViewById(0x7f10015f);
        view3 = findViewById(0x7f100162);
        view4 = findViewById(0x7f100165);
        view5 = findViewById(0x7f10014a);
        view6 = findViewById(0x7f10014c);
        bundle.setVisibility(8);
        view.setVisibility(8);
        view1.setVisibility(8);
        view2.setVisibility(8);
        view3.setVisibility(8);
        view4.setVisibility(8);
        view5.setVisibility(8);
        view6.setVisibility(8);
        (new Thread(new Runnable() {

            final StretchActivity a;

            public final void run()
            {
                Bitmap bitmap = com.photo.morph.StretchActivity.a(a);
                a.runOnUiThread(new Runnable(this, bitmap) {

                    final Bitmap a;
                    final _cls1 b;

                    public final void run()
                    {
                        if (a == null || a.isRecycled())
                        {
                            b.a.d();
                            Utils.b(b.a, 0x7f080429);
                            b.a.finish();
                            return;
                        } else
                        {
                            (new Handler()).post(new Runnable(this) {

                                private _cls1 a;

                                public final void run()
                                {
                                    com.photo.morph.StretchActivity.b(a.b.a);
                                    com.photo.morph.StretchActivity.a(a.b.a, a.a);
                                    com.photo.morph.StretchActivity.c(a.b.a);
                                    StretchActivity.d(a.b.a);
                                }

            
            {
                a = _pcls1;
                super();
            }
                            });
                            return;
                        }
                    }

            
            {
                b = _pcls1;
                a = bitmap;
                super();
            }
                });
            }

            
            {
                a = StretchActivity.this;
                super();
            }
        })).start();
        a(Integer.valueOf(0x7f08043d));
        return;
_L2:
        bundle = getIntent();
        if (bundle.hasExtra("editing_data"))
        {
            t = (EditingData)bundle.getParcelableExtra("editing_data");
        }
        if (true) goto _L4; else goto _L3
_L3:
        Utils.b(this, 0x7f0805ca);
        finish();
        return;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return false;
    }

    protected void onDestroy()
    {
        if (a != null)
        {
            a.b.j();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && s != null)
        {
            ((RelativeLayout)findViewById(0x7f100146)).removeView(s);
            s = null;
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    protected void onPause()
    {
        if (a != null)
        {
            a.onPause();
        }
        w.b();
        u.b();
        if (t != null)
        {
            EditingData editingdata = t;
            editingdata.i = (int)((long)editingdata.i + u.d());
        }
        super.onPause();
    }

    protected void onResume()
    {
        if (a != null)
        {
            a.onResume();
        }
        u.a();
        w.c();
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (t != null)
        {
            bundle.putParcelable("editing_data", t);
        }
        if (w != null)
        {
            bundle.putParcelable("time_calculator", w);
        }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        View view = findViewById(0x7f100152);
        Object obj;
        Object obj1;
        boolean flag1;
        if (view == null)
        {
            view = findViewById(0x7f100166);
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        obj = findViewById(0x7f100153);
        if (view == null || obj == null) goto _L2; else goto _L1
_L1:
        obj1 = (FrameLayout)view;
        obj = (LinearLayout)obj;
        if (!flag1) goto _L4; else goto _L3
_L3:
        if (((LinearLayout) (obj)).getWidth() > 0 && ((FrameLayout) (obj1)).getWidth() > 0 && ((LinearLayout) (obj)).getWidth() < ((FrameLayout) (obj1)).getWidth())
        {
            obj1 = (android.widget.FrameLayout.LayoutParams)((LinearLayout) (obj)).getLayoutParams();
            obj1.gravity = 1;
            ((LinearLayout) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        }
_L6:
        view.setVisibility(0);
_L2:
        return;
_L4:
        if (((LinearLayout) (obj)).getHeight() > 0 && ((FrameLayout) (obj1)).getHeight() > 0 && ((LinearLayout) (obj)).getHeight() < ((FrameLayout) (obj1)).getHeight())
        {
            obj1 = (android.widget.FrameLayout.LayoutParams)((LinearLayout) (obj)).getLayoutParams();
            obj1.gravity = 16;
            ((LinearLayout) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
