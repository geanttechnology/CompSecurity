// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.clone;

import android.app.DialogFragment;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.picsart.studio.EditingData;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.utils.TimeCalculator;
import com.picsart.studio.utils.c;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.a;
import com.socialin.android.dialog.b;
import com.socialin.android.dialog.g;
import com.socialin.android.util.w;
import java.io.File;
import java.util.HashMap;
import myobfuscated.bw.d;
import myobfuscated.bw.e;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.effects.clone:
//            d, f, BrushStyleView, CloneSurfaceView, 
//            e, c

public class CloneActivity extends AdBaseActivity
    implements com.picsart.effects.clone.d, f
{

    EditingData a;
    private HashMap b;
    private int c;
    private String d;
    private int e;
    private Bitmap f;
    private Bitmap g;
    private boolean h;
    private HandlerThread i;
    private Handler j;
    private CloneSurfaceView k;
    private com.picsart.effects.clone.c l;
    private g m;
    private String n;
    private Point o;
    private String p;
    private String q;
    private TimeCalculator r;
    private TimeCalculator s;

    public CloneActivity()
    {
        c = 0;
        d = null;
        e = 0;
        f = null;
        g = null;
        o = new Point();
        q = null;
        a = null;
    }

    static Bitmap a(CloneActivity cloneactivity, Bitmap bitmap)
    {
        cloneactivity.f = bitmap;
        return bitmap;
    }

    static EditingData a(CloneActivity cloneactivity)
    {
        return cloneactivity.a;
    }

    static g a(CloneActivity cloneactivity, g g1)
    {
        cloneactivity.m = g1;
        return g1;
    }

    static void a(CloneActivity cloneactivity, View view)
    {
        BrushStyleView brushstyleview = (BrushStyleView)view.findViewById(0x7f10028c);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            brushstyleview.setLayerType(1, null);
        }
        int i1 = (int)cloneactivity.k.f;
        brushstyleview.setBrushPercentSize(i1);
        brushstyleview.setOpacity(255 - cloneactivity.k.e);
        brushstyleview.setHardness(100F - (100F - cloneactivity.k.d));
        brushstyleview.invalidate();
        Object obj = (TextView)view.findViewById(0x7f10028d);
        ((TextView) (obj)).setText((new StringBuilder()).append(cloneactivity.getResources().getString(0x7f08006a)).append(" : ").append(i1).toString());
        SeekBar seekbar = (SeekBar)view.findViewById(0x7f10028e);
        seekbar.setMax(100);
        seekbar.setProgress(i1);
        seekbar.setOnSeekBarChangeListener(cloneactivity. new android.widget.SeekBar.OnSeekBarChangeListener(((TextView) (obj)), brushstyleview) {

            private TextView a;
            private BrushStyleView b;
            private CloneActivity c;

            public final void onProgressChanged(SeekBar seekbar1, int j1, boolean flag)
            {
                if (com.picsart.effects.clone.CloneActivity.b(c) != null)
                {
                    com.picsart.effects.clone.CloneActivity.b(c).a(seekbar1.getProgress(), false);
                }
                a.setText((new StringBuilder()).append(c.getResources().getString(0x7f08006a)).append(" : ").append(seekbar1.getProgress()).toString());
                b.setBrushPercentSize(j1);
                b.invalidate();
            }

            public final void onStartTrackingTouch(SeekBar seekbar1)
            {
                if (com.picsart.effects.clone.CloneActivity.b(c) != null)
                {
                    com.picsart.effects.clone.CloneActivity.b(c).a(seekbar1.getProgress(), false);
                }
                a.setText((new StringBuilder()).append(c.getResources().getString(0x7f08006a)).append(" : ").append(seekbar1.getProgress()).toString());
            }

            public final void onStopTrackingTouch(SeekBar seekbar1)
            {
                if (com.picsart.effects.clone.CloneActivity.b(c) != null)
                {
                    com.picsart.effects.clone.CloneActivity.b(c).a(seekbar1.getProgress(), false);
                }
                a.setText((new StringBuilder()).append(c.getResources().getString(0x7f08006a)).append(" : ").append(seekbar1.getProgress()).toString());
                AnalyticUtils.getInstance(c).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCloneTryEvent(com.picsart.effects.clone.CloneActivity.a(c).a, "brush_changed"));
            }

            
            {
                c = CloneActivity.this;
                a = textview;
                b = brushstyleview;
                super();
            }
        });
        obj = (SeekBar)view.findViewById(0x7f1001e2);
        ((SeekBar) (obj)).setMax(255);
        ((SeekBar) (obj)).setProgress(255 - cloneactivity.k.e);
        ((TextView)view.findViewById(0x7f1001e1)).setText((new StringBuilder()).append(cloneactivity.getString(0x7f080069)).append(" ").append(255 - cloneactivity.k.e).toString());
        ((SeekBar) (obj)).setOnSeekBarChangeListener(cloneactivity. new android.widget.SeekBar.OnSeekBarChangeListener(view, brushstyleview) {

            private View a;
            private BrushStyleView b;
            private CloneActivity c;

            public final void onProgressChanged(SeekBar seekbar1, int j1, boolean flag)
            {
                j1 = seekbar1.getProgress();
                ((TextView)a.findViewById(0x7f1001e1)).setText((new StringBuilder()).append(c.getString(0x7f080069)).append(" ").append(j1).toString());
                b.setOpacity(j1);
                b.invalidate();
            }

            public final void onStartTrackingTouch(SeekBar seekbar1)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar1)
            {
                CloneSurfaceView clonesurfaceview = com.picsart.effects.clone.CloneActivity.b(c);
                int j1 = seekbar1.getProgress();
                if (clonesurfaceview.a != null)
                {
                    seekbar1 = clonesurfaceview.a.obtainMessage();
                    seekbar1.what = 9;
                    seekbar1.arg1 = 255 - j1;
                    clonesurfaceview.a(seekbar1, false);
                }
                AnalyticUtils.getInstance(c).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCloneTryEvent(com.picsart.effects.clone.CloneActivity.a(c).a, "brush_changed"));
            }

            
            {
                c = CloneActivity.this;
                a = view;
                b = brushstyleview;
                super();
            }
        });
        obj = (SeekBar)view.findViewById(0x7f1001e4);
        ((SeekBar) (obj)).setMax(100);
        i1 = (int)(100F - cloneactivity.k.d);
        ((SeekBar) (obj)).setProgress(i1);
        ((TextView)view.findViewById(0x7f1001e3)).setText((new StringBuilder()).append(cloneactivity.getString(0x7f080068)).append(" ").append(i1).toString());
        ((SeekBar) (obj)).setOnSeekBarChangeListener(cloneactivity. new android.widget.SeekBar.OnSeekBarChangeListener(view, brushstyleview) {

            private View a;
            private BrushStyleView b;
            private CloneActivity c;

            public final void onProgressChanged(SeekBar seekbar1, int j1, boolean flag)
            {
                j1 = seekbar1.getProgress();
                ((TextView)a.findViewById(0x7f1001e3)).setText((new StringBuilder()).append(c.getString(0x7f080068)).append(" ").append(j1).toString());
                b.setHardness(100 - j1);
                b.invalidate();
            }

            public final void onStartTrackingTouch(SeekBar seekbar1)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar1)
            {
                CloneSurfaceView clonesurfaceview = com.picsart.effects.clone.CloneActivity.b(c);
                int j1 = seekbar1.getProgress();
                if (clonesurfaceview.a != null)
                {
                    seekbar1 = clonesurfaceview.a.obtainMessage();
                    seekbar1.what = 8;
                    seekbar1.arg1 = j1;
                    clonesurfaceview.a(seekbar1, false);
                }
                AnalyticUtils.getInstance(c).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCloneTryEvent(com.picsart.effects.clone.CloneActivity.a(c).a, "brush_changed"));
            }

            
            {
                c = CloneActivity.this;
                a = view;
                b = brushstyleview;
                super();
            }
        });
    }

    static Bitmap b(CloneActivity cloneactivity, Bitmap bitmap)
    {
        cloneactivity.g = bitmap;
        return bitmap;
    }

    static CloneSurfaceView b(CloneActivity cloneactivity)
    {
        return cloneactivity.k;
    }

    static void c(CloneActivity cloneactivity)
    {
        View view = cloneactivity.findViewById(0x7f100133);
        if (view.getVisibility() == 8)
        {
            view.startAnimation(AnimationUtils.loadAnimation(cloneactivity, 0x7f04001c));
            view.setVisibility(0);
            return;
        } else
        {
            view.startAnimation(AnimationUtils.loadAnimation(cloneactivity, 0x7f04001b));
            view.setVisibility(8);
            return;
        }
    }

    static void d(CloneActivity cloneactivity)
    {
        b b1 = new b();
        b1.a = cloneactivity.getString(0x7f0805fb);
        b1.f = 0x7f030069;
        b1.h = false;
        b1.g = true;
        b1.p = cloneactivity. new com.socialin.android.dialog.c() {

            private CloneActivity a;

            public final void onViewCreated(View view, DialogFragment dialogfragment)
            {
                com.picsart.effects.clone.CloneActivity.a(a, view);
            }

            
            {
                a = CloneActivity.this;
                super();
            }
        };
        b1.a().show(cloneactivity.getFragmentManager(), null);
    }

    static TimeCalculator e(CloneActivity cloneactivity)
    {
        return cloneactivity.s;
    }

    static Handler f(CloneActivity cloneactivity)
    {
        return cloneactivity.j;
    }

    static void g(CloneActivity cloneactivity)
    {
        cloneactivity.k = (CloneSurfaceView)cloneactivity.findViewById(0x7f10012c);
        cloneactivity.k.setCloneSurfaceViewUIActions(cloneactivity);
        cloneactivity.k.setOrigBitmaps(cloneactivity.f, cloneactivity.g);
        cloneactivity.k.setActionsListenerForAnalytics(new com.picsart.effects.clone.e(cloneactivity));
        cloneactivity.findViewById(0x7f100130).setOnClickListener(cloneactivity. new android.view.View.OnClickListener() {

            private CloneActivity a;

            public final void onClick(View view)
            {
                a.findViewById(0x7f100130).setBackgroundResource(0x7f0205a1);
                a.findViewById(0x7f100131).setBackgroundResource(0x7f02068f);
                com.picsart.effects.clone.CloneActivity.c(a);
                if (com.picsart.effects.clone.CloneActivity.b(a) != null)
                {
                    com.picsart.effects.clone.CloneActivity.b(a).b(0);
                }
            }

            
            {
                a = CloneActivity.this;
                super();
            }
        });
        Object obj = cloneactivity.findViewById(0x7f100135);
        ((View) (obj)).setEnabled(false);
        ((View) (obj)).setOnClickListener(cloneactivity. new android.view.View.OnClickListener() {

            private CloneActivity a;

            public final void onClick(View view)
            {
                if (com.picsart.effects.clone.CloneActivity.b(a) != null)
                {
                    view = com.picsart.effects.clone.CloneActivity.b(a);
                    if (((CloneSurfaceView) (view)).a != null)
                    {
                        Message message = ((CloneSurfaceView) (view)).a.obtainMessage();
                        message.what = 5;
                        view.a(message, false);
                    }
                    a.b(0x7f080679);
                }
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCloneTryEvent(com.picsart.effects.clone.CloneActivity.a(a).a, "undo"));
            }

            
            {
                a = CloneActivity.this;
                super();
            }
        });
        obj = cloneactivity.findViewById(0x7f100137);
        ((View) (obj)).setEnabled(false);
        ((View) (obj)).setOnClickListener(cloneactivity. new android.view.View.OnClickListener() {

            private CloneActivity a;

            public final void onClick(View view)
            {
                if (com.picsart.effects.clone.CloneActivity.b(a) != null)
                {
                    view = com.picsart.effects.clone.CloneActivity.b(a);
                    if (((CloneSurfaceView) (view)).a != null)
                    {
                        Message message = ((CloneSurfaceView) (view)).a.obtainMessage();
                        message.what = 6;
                        view.a(message, false);
                    }
                    a.b(0x7f080679);
                }
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCloneTryEvent(com.picsart.effects.clone.CloneActivity.a(a).a, "original"));
            }

            
            {
                a = CloneActivity.this;
                super();
            }
        });
        obj = cloneactivity. new android.view.View.OnClickListener() {

            private CloneActivity a;

            public final void onClick(View view)
            {
                if (view.getId() == 0x7f100139)
                {
                    AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCloneTryEvent(com.picsart.effects.clone.CloneActivity.a(a).a, "erase"));
                } else
                {
                    AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCloneTryEvent(com.picsart.effects.clone.CloneActivity.a(a).a, "draw"));
                }
                a.a(view.getId());
            }

            
            {
                a = CloneActivity.this;
                super();
            }
        };
        cloneactivity.findViewById(0x7f100139).setEnabled(false);
        cloneactivity.findViewById(0x7f100138).setEnabled(false);
        cloneactivity.findViewById(0x7f100139).setOnClickListener(((android.view.View.OnClickListener) (obj)));
        cloneactivity.findViewById(0x7f100138).setOnClickListener(((android.view.View.OnClickListener) (obj)));
        cloneactivity.findViewById(0x7f100136).setOnClickListener(cloneactivity. new android.view.View.OnClickListener() {

            private CloneActivity a;

            public final void onClick(View view)
            {
                com.picsart.effects.clone.CloneActivity.d(a);
            }

            
            {
                a = CloneActivity.this;
                super();
            }
        });
        cloneactivity.findViewById(0x7f100132).setOnClickListener(cloneactivity. new android.view.View.OnClickListener() {

            private CloneActivity a;

            public final void onClick(View view)
            {
                if (com.picsart.effects.clone.CloneActivity.b(a) != null)
                {
                    view = com.picsart.effects.clone.CloneActivity.b(a);
                    if (((CloneSurfaceView) (view)).a != null)
                    {
                        Message message = ((CloneSurfaceView) (view)).a.obtainMessage();
                        message.what = 10;
                        view.a(message, false);
                    }
                    a.b(0x7f080679);
                    AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCloneCloseEvent(com.picsart.effects.clone.CloneActivity.a(a).a, "done", (int)com.picsart.effects.clone.CloneActivity.e(a).d()));
                }
            }

            
            {
                a = CloneActivity.this;
                super();
            }
        });
        cloneactivity.findViewById(0x7f10012e).setOnClickListener(cloneactivity. new android.view.View.OnClickListener() {

            private CloneActivity a;

            public final void onClick(View view)
            {
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCloneCloseEvent(com.picsart.effects.clone.CloneActivity.a(a).a, "cancel", (int)com.picsart.effects.clone.CloneActivity.e(a).d()));
                a.finish();
            }

            
            {
                a = CloneActivity.this;
                super();
            }
        });
        cloneactivity.findViewById(0x7f100131).setOnClickListener(cloneactivity. new android.view.View.OnClickListener() {

            private CloneActivity a;

            public final void onClick(View view)
            {
                a.findViewById(0x7f100131).setBackgroundResource(0x7f0205a1);
                a.findViewById(0x7f100130).setBackgroundResource(0x7f02068f);
                if (a.findViewById(0x7f100133).getVisibility() == 0)
                {
                    com.picsart.effects.clone.CloneActivity.c(a);
                }
                if (com.picsart.effects.clone.CloneActivity.b(a) != null)
                {
                    com.picsart.effects.clone.CloneActivity.b(a).b(1);
                }
            }

            
            {
                a = CloneActivity.this;
                super();
            }
        });
        cloneactivity.findViewById(0x7f10012f).setOnClickListener(cloneactivity. new android.view.View.OnClickListener() {

            private CloneActivity a;

            public final void onClick(View view)
            {
                if (com.picsart.effects.clone.CloneActivity.b(a) != null)
                {
                    view.setEnabled(false);
                    view = (ToggleButton)a.findViewById(0x7f100139);
                    ToggleButton togglebutton = (ToggleButton)a.findViewById(0x7f100138);
                    view.setChecked(false);
                    togglebutton.setChecked(true);
                    view.setEnabled(false);
                    togglebutton.setEnabled(false);
                    com.picsart.effects.clone.CloneActivity.b(a).b(2);
                }
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCloneTryEvent(com.picsart.effects.clone.CloneActivity.a(a).a, "target_click"));
            }

            
            {
                a = CloneActivity.this;
                super();
            }
        });
        cloneactivity.k.setCanInit(true);
        obj = myobfuscated.f.m.f();
        ((myobfuscated.bw.a) (obj)).a(cloneactivity.k, cloneactivity. new e() {

            private CloneActivity a;

            public final boolean a(MotionEvent motionevent)
            {
                if (com.picsart.effects.clone.CloneActivity.b(a) == null)
                {
                    return false;
                } else
                {
                    com.picsart.effects.clone.CloneActivity.b(a).a(motionevent);
                    return true;
                }
            }

            public final boolean b(MotionEvent motionevent)
            {
                if (com.picsart.effects.clone.CloneActivity.b(a) == null)
                {
                    return false;
                } else
                {
                    return com.picsart.effects.clone.CloneActivity.b(a).a(motionevent);
                }
            }

            public final boolean c(MotionEvent motionevent)
            {
                if (com.picsart.effects.clone.CloneActivity.b(a) == null)
                {
                    return false;
                }
                if (!com.picsart.effects.clone.CloneActivity.b(a).g)
                {
                    a.a(0x7f100139);
                }
                return com.picsart.effects.clone.CloneActivity.b(a).a(motionevent);
            }

            public final void d(MotionEvent motionevent)
            {
            }

            
            {
                a = CloneActivity.this;
                super();
            }
        });
        if (myobfuscated.bw.a.a())
        {
            ((myobfuscated.bw.a) (obj)).a(cloneactivity.k, cloneactivity. new d() {

                private CloneActivity a;

                public final void a()
                {
                    ToggleButton togglebutton;
                    ToggleButton togglebutton1;
label0:
                    {
                        if (com.picsart.effects.clone.CloneActivity.b(a) != null && !com.picsart.effects.clone.CloneActivity.b(a).g)
                        {
                            com.picsart.effects.clone.CloneActivity.b(a).a(-1);
                            togglebutton = (ToggleButton)a.findViewById(0x7f100139);
                            togglebutton1 = (ToggleButton)a.findViewById(0x7f100138);
                            if (!togglebutton.isChecked())
                            {
                                break label0;
                            }
                            togglebutton.setChecked(false);
                            togglebutton1.setChecked(true);
                        }
                        return;
                    }
                    togglebutton.setChecked(true);
                    togglebutton1.setChecked(false);
                }

                public final boolean a(View view, MotionEvent motionevent)
                {
                    return false;
                }

            
            {
                a = CloneActivity.this;
                super();
            }
            });
        }
        if (!cloneactivity.k.b && cloneactivity.k.c)
        {
            cloneactivity.k.a(cloneactivity.k.getWidth(), cloneactivity.k.getHeight());
        }
        cloneactivity.k.setEnableEffectsAnalytics(cloneactivity.h);
    }

    static g h(CloneActivity cloneactivity)
    {
        return cloneactivity.m;
    }

    static String i(CloneActivity cloneactivity)
    {
        return cloneactivity.n;
    }

    static String j(CloneActivity cloneactivity)
    {
        return cloneactivity.p;
    }

    static Point k(CloneActivity cloneactivity)
    {
        return cloneactivity.o;
    }

    static String l(CloneActivity cloneactivity)
    {
        return cloneactivity.q;
    }

    public final int a()
    {
        return c;
    }

    public final void a(int i1)
    {
        if (k == null)
        {
            return;
        }
        if (i1 == 0x7f100139)
        {
            ((ToggleButton)findViewById(0x7f100139)).setChecked(true);
            ((ToggleButton)findViewById(0x7f100138)).setChecked(false);
            i1 = 1;
        } else
        {
            ((ToggleButton)findViewById(0x7f100138)).setChecked(true);
            ((ToggleButton)findViewById(0x7f100139)).setChecked(false);
            i1 = 0;
        }
        k.a(i1);
    }

    public final void a(Bitmap bitmap)
    {
        o.x = bitmap.getWidth();
        o.y = bitmap.getHeight();
        if (n != null)
        {
            w.a(new File(n), bitmap, android.graphics.Bitmap.CompressFormat.PNG, this);
        } else
        if (p != null)
        {
            w.a(p, bitmap);
            return;
        }
    }

    public final void a(Bitmap bitmap, Bitmap bitmap1, boolean flag)
    {
        runOnUiThread(new Runnable(bitmap, flag, bitmap1) {

            private Bitmap a;
            private boolean b;
            private Bitmap c;
            private CloneActivity d;

            public final void run()
            {
                d.e();
                if (CloneActivity.f(d) != null)
                {
                    Looper looper = CloneActivity.f(d).getLooper();
                    if (looper != null)
                    {
                        looper.quit();
                    }
                }
                if (d.isFinishing()) goto _L2; else goto _L1
_L1:
                if ((a == null || a.isRecycled()) && b || c == null || c.isRecycled()) goto _L4; else goto _L3
_L3:
                com.picsart.effects.clone.CloneActivity.a(d, a);
                com.picsart.effects.clone.CloneActivity.b(d, c);
                com.picsart.effects.clone.CloneActivity.g(d);
_L6:
                return;
_L4:
                d.finish();
                return;
_L2:
                if (a != null && !a.isRecycled())
                {
                    a.recycle();
                }
                if (c != null && !c.isRecycled())
                {
                    c.recycle();
                    return;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                d = CloneActivity.this;
                a = bitmap;
                b = flag;
                c = bitmap1;
                super();
            }
        });
    }

    public final void a(boolean flag)
    {
        runOnUiThread(new Runnable(flag) {

            private boolean a;
            private CloneActivity b;

            public final void run()
            {
                View view = b.findViewById(0x7f100135);
                View view1 = b.findViewById(0x7f100137);
                view.setEnabled(a);
                view1.setEnabled(a);
            }

            
            {
                b = CloneActivity.this;
                a = flag;
                super();
            }
        });
    }

    public final String b()
    {
        return d;
    }

    public final void b(int i1)
    {
        runOnUiThread(new Runnable(i1) {

            private int a;
            private CloneActivity b;

            public final void run()
            {
                b.e();
                com.picsart.effects.clone.CloneActivity.a(b, com.socialin.android.dialog.g.a(b, null, b.getString(a)));
            }

            
            {
                b = CloneActivity.this;
                a = i1;
                super();
            }
        });
    }

    public final HashMap c()
    {
        return b;
    }

    public final int d()
    {
        return e;
    }

    public final void e()
    {
        runOnUiThread(new Runnable() {

            private CloneActivity a;

            public final void run()
            {
                if (CloneActivity.h(a) != null && CloneActivity.h(a).isShowing())
                {
                    CloneActivity.h(a).dismiss();
                }
            }

            
            {
                a = CloneActivity.this;
                super();
            }
        });
    }

    public final void f()
    {
        runOnUiThread(new Runnable() {

            private CloneActivity a;

            public final void run()
            {
                Intent intent = new Intent();
                if (CloneActivity.i(a) == null) goto _L2; else goto _L1
_L1:
                intent.putExtra("path", CloneActivity.i(a));
_L4:
                if (CloneActivity.l(a) != null)
                {
                    AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCloneEvent(CloneActivity.l(a)));
                }
                if (com.picsart.effects.clone.CloneActivity.a(a) != null)
                {
                    intent.putExtra("editing_data", com.picsart.effects.clone.CloneActivity.a(a));
                }
                a.setResult(-1, intent);
                a.finish();
                return;
_L2:
                if (CloneActivity.j(a) != null)
                {
                    HashMap hashmap = new HashMap();
                    hashmap.put("width", Integer.valueOf(CloneActivity.k(a).x));
                    hashmap.put("height", Integer.valueOf(CloneActivity.k(a).y));
                    hashmap.put("path", CloneActivity.j(a));
                    intent.putExtra("result_buffer_Data", hashmap);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = CloneActivity.this;
                super();
            }
        });
    }

    public final void g()
    {
        runOnUiThread(new Runnable(true) {

            private boolean a;
            private CloneActivity b;

            public final void run()
            {
                b.findViewById(0x7f10012f).setEnabled(a);
                ToggleButton togglebutton = (ToggleButton)b.findViewById(0x7f100139);
                ToggleButton togglebutton1 = (ToggleButton)b.findViewById(0x7f100138);
                togglebutton.setEnabled(true);
                togglebutton1.setEnabled(true);
                b.findViewById(0x7f100130).setBackgroundResource(0x7f0205a1);
                b.findViewById(0x7f100131).setBackgroundResource(0x7f02068f);
            }

            
            {
                b = CloneActivity.this;
                a = true;
                super();
            }
        });
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCloneCloseEvent(a.a, "back", (int)s.d()));
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        r = new TimeCalculator();
        Intent intent;
        boolean flag;
        if (bundle == null)
        {
            s = new TimeCalculator();
        } else
        {
            s = (TimeCalculator)bundle.getParcelable("time_calculator");
        }
        getSupportActionBar().hide();
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f03001c);
        if (bundle != null)
        {
            if (bundle.containsKey("editing_data"))
            {
                a = (EditingData)bundle.getParcelable("editing_data");
            }
        } else
        {
            bundle = getIntent();
            if (bundle.hasExtra("editing_data"))
            {
                a = (EditingData)bundle.getParcelableExtra("editing_data");
            }
        }
        intent = getIntent();
        flag = intent.getBooleanExtra("openedFromEffects", true);
        h = intent.getBooleanExtra("enable_effects_analytics", true);
        if (intent.hasExtra("origin"))
        {
            bundle = intent.getStringExtra("origin");
        } else
        {
            bundle = "unknown";
        }
        if (intent.hasExtra("editing_data"))
        {
            a = (EditingData)intent.getParcelableExtra("editing_data");
            Log.e("ex1", (new StringBuilder("editingData uid = ")).append(a.a).toString());
        }
        if (a == null)
        {
            a = EditingData.a(com.picsart.studio.utils.c.a(this, null), bundle);
        }
        if (flag)
        {
            n = intent.getStringExtra("saveToPath");
            p = intent.getStringExtra("buffer_to_save");
        }
        d = intent.getStringExtra("path");
        if (getIntent().hasExtra("bufferData"))
        {
            b = (HashMap)intent.getSerializableExtra("bufferData");
        }
        c = intent.getIntExtra("degree", 0);
        e = intent.getIntExtra("maxPixel", PicsartContext.a());
        Log.e("ex1", (new StringBuilder("CloneActivity maxPixelsCount = ")).append(e).toString());
        if (intent.hasExtra("intentKeyLaunchSource"))
        {
            q = intent.getStringExtra("intentKeyLaunchSource");
        }
        l = new com.picsart.effects.clone.c(this);
        if (i == null)
        {
            i = new HandlerThread("clone_crop_thread");
            i.start();
            j = new Handler(i.getLooper(), l);
        }
        l.a = j;
        bundle = l;
        if (((com.picsart.effects.clone.c) (bundle)).a != null)
        {
            Message message = ((com.picsart.effects.clone.c) (bundle)).a.obtainMessage();
            message.what = 0;
            ((com.picsart.effects.clone.c) (bundle)).a.sendMessage(message);
        }
        findViewById(0x7f10012f).setEnabled(false);
        b(0x7f080679);
        initAd();
    }

    protected void onPause()
    {
        super.onPause();
        s.b();
        if (m != null && m.isShowing())
        {
            m.dismiss();
        }
        r.b();
        if (a != null)
        {
            EditingData editingdata = a;
            editingdata.i = (int)((long)editingdata.i + r.d());
        }
    }

    protected void onResume()
    {
        super.onResume();
        r.a();
        s.c();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (a != null)
        {
            bundle.putParcelable("editing_data", a);
        }
        if (s != null)
        {
            bundle.putParcelable("time_calculator", s);
        }
    }
}
