// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.FragmentManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.editor.view.BorderEditorView;
import com.socialin.android.colorpicker.c;
import com.socialin.android.colorpicker.h;
import com.socialin.android.photo.view.ColorPickerPreview;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i

public final class d extends i
{

    private BorderEditorView c;
    private SlidingDrawer d;
    private SeekBar e;
    private SeekBar f;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private ToggleButton m;
    private ToggleButton n;
    private ColorPickerPreview o;
    private ColorPickerPreview p;
    private boolean q;
    private c r;
    private final c s = new c() {

        private d a;

        public final void a(int i1)
        {
            if (d.a(a) != null)
            {
                d.a(a).setOuterBorderColor(i1);
            }
            if (d.b(a) != null)
            {
                d.b(a).setColor(i1);
            }
            com.picsart.studio.editor.fragment.d.c(a).open();
        }

            
            {
                a = d.this;
                super();
            }
    };
    private final c t = new c() {

        private d a;

        public final void a(int i1)
        {
            if (d.a(a) != null)
            {
                d.a(a).setInnerBorderColor(i1);
            }
            if (d.d(a) != null)
            {
                d.d(a).setColor(i1);
            }
            com.picsart.studio.editor.fragment.d.c(a).open();
        }

            
            {
                a = d.this;
                super();
            }
    };
    private final com.socialin.android.colorpicker.d u = new com.socialin.android.colorpicker.d() {

        private d a;

        public final void a()
        {
            com.picsart.studio.editor.fragment.d.c(a).close();
            d.a(a).setColorSelectedListener(com.picsart.studio.editor.fragment.d.e(a));
            d.a(a).a();
            d.a(a).invalidate();
        }

        public final void b()
        {
        }

            
            {
                a = d.this;
                super();
            }
    };

    public d()
    {
        q = false;
    }

    private int a(int i1)
    {
        return (int)TypedValue.applyDimension(1, i1, getResources().getDisplayMetrics());
    }

    static int a(d d1, int i1)
    {
        return d1.a(i1);
    }

    static BorderEditorView a(d d1)
    {
        return d1.c;
    }

    static c a(d d1, c c1)
    {
        d1.r = c1;
        return c1;
    }

    static void a(d d1, c c1, int i1, String s1)
    {
        h h1 = new h();
        h1.a(d1.u);
        h1.a(c1);
        h1.a = i1;
        h1.b = i1;
        h1.show(d1.getFragmentManager(), s1);
        d1.c.setEyeDropperActive(false);
    }

    static ColorPickerPreview b(d d1)
    {
        return d1.o;
    }

    static SlidingDrawer c(d d1)
    {
        return d1.d;
    }

    static ColorPickerPreview d(d d1)
    {
        return d1.p;
    }

    static c e(d d1)
    {
        return d1.r;
    }

    static c f(d d1)
    {
        return d1.t;
    }

    static c g(d d1)
    {
        return d1.s;
    }

    static TextView h(d d1)
    {
        return d1.k;
    }

    static TextView i(d d1)
    {
        return d1.l;
    }

    private void i()
    {
        c.setMode(com.picsart.studio.editor.view.BorderEditorView.Mode.INNER);
        f.setVisibility(8);
        j.setVisibility(8);
        e.setVisibility(0);
        i.setVisibility(0);
        m.setChecked(true);
        n.setChecked(false);
    }

    static TextView j(d d1)
    {
        return d1.i;
    }

    private void j()
    {
        c.setMode(com.picsart.studio.editor.view.BorderEditorView.Mode.OUTER);
        f.setVisibility(0);
        j.setVisibility(0);
        e.setVisibility(8);
        i.setVisibility(8);
        m.setChecked(false);
        n.setChecked(true);
    }

    static TextView k(d d1)
    {
        return d1.j;
    }

    static void l(d d1)
    {
        d1.i();
    }

    static void m(d d1)
    {
        d1.j();
    }

    public final void a(Bitmap bitmap)
    {
        super.a(bitmap);
        if (c != null)
        {
            c.setImage(bitmap);
        }
    }

    public final Tool e()
    {
        return Tool.BORDER;
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030101, viewgroup, false);
    }

    public final void onResume()
    {
        super.onResume();
        if (m.isChecked())
        {
            i();
            return;
        } else
        {
            j();
            return;
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        byte byte0;
        if (c.g)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        bundle.putByte("isEyeDropperActive", byte0);
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        c = (BorderEditorView)view.findViewById(0x7f1001c2);
        c.setImage(h);
        android.app.Fragment fragment = getFragmentManager().findFragmentByTag("innerColorPicker");
        Object obj = getFragmentManager().findFragmentByTag("outerColorPicker");
        if (fragment != null)
        {
            ((h)fragment).a(t);
            ((h)fragment).a(u);
        } else
        if (obj != null)
        {
            ((h)obj).a(s);
            ((h)obj).a(u);
        }
        if (bundle != null)
        {
            SeekBar seekbar;
            FrameLayout framelayout;
            boolean flag;
            if (bundle.getByte("isEyeDropperActive") == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            q = flag;
        }
        c.setEyeDropperActive(q);
        c.setColorSelectedListener(r);
        d = (SlidingDrawer)view.findViewById(0x7f1002a2);
        d.setSaveEnabled(false);
        if (!q)
        {
            d.open();
        }
        view.findViewById(0x7f10054f).setOnClickListener(new android.view.View.OnClickListener() {

            private d a;

            public final void onClick(View view1)
            {
                a.g.a(a);
            }

            
            {
                a = d.this;
                super();
            }
        });
        view.findViewById(0x7f100550).setOnClickListener(new android.view.View.OnClickListener() {

            private d a;

            public final void onClick(View view1)
            {
                com.picsart.studio.editor.e.a().e.d("border");
                BorderEditorView bordereditorview = d.a(a);
                if (bordereditorview.h == null)
                {
                    view1 = null;
                } else
                {
                    float f2 = (float)bordereditorview.a / bordereditorview.f;
                    float f3 = (float)bordereditorview.c / bordereditorview.f;
                    float f1 = f2;
                    if (bordereditorview.e == com.picsart.studio.editor.view.BorderEditorView.Mode.OUTER)
                    {
                        f1 = f2 + f3;
                    }
                    int i1 = (int)f1;
                    view1 = Bitmap.createBitmap(bordereditorview.h.getWidth() + i1 * 2, bordereditorview.h.getHeight() + i1 * 2, android.graphics.Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(view1);
                    canvas.translate(i1, i1);
                    if (bordereditorview.e == com.picsart.studio.editor.view.BorderEditorView.Mode.OUTER)
                    {
                        bordereditorview.b(canvas);
                    } else
                    {
                        bordereditorview.a(canvas);
                    }
                }
                a.g.a(a, view1, RasterAction.create(view1, com.picsart.studio.editor.e.a().d.getHistoryDataDirectory()));
            }

            
            {
                a = d.this;
                super();
            }
        });
        bundle = (SeekBar)view.findViewById(0x7f100556);
        seekbar = (SeekBar)view.findViewById(0x7f100552);
        e = (SeekBar)view.findViewById(0x7f10055c);
        f = (SeekBar)view.findViewById(0x7f10055a);
        k = (TextView)view.findViewById(0x7f100555);
        l = (TextView)view.findViewById(0x7f100551);
        i = (TextView)view.findViewById(0x7f10055b);
        j = (TextView)view.findViewById(0x7f100559);
        m = (ToggleButton)view.findViewById(0x7f10055d);
        n = (ToggleButton)view.findViewById(0x7f10055e);
        obj = (FrameLayout)view.findViewById(0x7f100557);
        framelayout = (FrameLayout)view.findViewById(0x7f100553);
        p = (ColorPickerPreview)view.findViewById(0x7f100558);
        o = (ColorPickerPreview)view.findViewById(0x7f100554);
        p.setColor(-1);
        o.setColor(0xff000000);
        ((FrameLayout) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            private d a;

            public final void onClick(View view1)
            {
                d.a(a, d.f(a));
                d.a(a, d.f(a), d.a(a).d, "innerColorPicker");
            }

            
            {
                a = d.this;
                super();
            }
        });
        framelayout.setOnClickListener(new android.view.View.OnClickListener() {

            private d a;

            public final void onClick(View view1)
            {
                d.a(a, d.g(a));
                d.a(a, d.g(a), d.a(a).b, "outerColorPicker");
            }

            
            {
                a = d.this;
                super();
            }
        });
        bundle.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            private d a;

            public final void onProgressChanged(SeekBar seekbar1, int i1, boolean flag1)
            {
                d.a(a).setInnerBorderSize(d.a(a, i1));
                com.picsart.studio.editor.fragment.d.h(a).setText(a.getString(0x7f080395, new Object[] {
                    Integer.valueOf(i1)
                }));
            }

            public final void onStartTrackingTouch(SeekBar seekbar1)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar1)
            {
            }

            
            {
                a = d.this;
                super();
            }
        });
        seekbar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            private d a;

            public final void onProgressChanged(SeekBar seekbar1, int i1, boolean flag1)
            {
                d.a(a).setOuterBorderSize(d.a(a, i1));
                d.i(a).setText(a.getString(0x7f0804cc, new Object[] {
                    Integer.valueOf(i1)
                }));
            }

            public final void onStartTrackingTouch(SeekBar seekbar1)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar1)
            {
            }

            
            {
                a = d.this;
                super();
            }
        });
        e.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            private d a;

            public final void onProgressChanged(SeekBar seekbar1, int i1, boolean flag1)
            {
                d.a(a).setInnerBorderOpacity(i1);
                d.j(a).setText(a.getString(0x7f0804be, new Object[] {
                    Integer.valueOf(i1)
                }));
            }

            public final void onStartTrackingTouch(SeekBar seekbar1)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar1)
            {
            }

            
            {
                a = d.this;
                super();
            }
        });
        f.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            private d a;

            public final void onProgressChanged(SeekBar seekbar1, int i1, boolean flag1)
            {
                d.a(a).setCornerRadius(i1);
                d.k(a).setText(a.getString(0x7f080101, new Object[] {
                    Integer.valueOf(i1)
                }));
            }

            public final void onStartTrackingTouch(SeekBar seekbar1)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar1)
            {
            }

            
            {
                a = d.this;
                super();
            }
        });
        m.setOnClickListener(new android.view.View.OnClickListener() {

            private d a;

            public final void onClick(View view1)
            {
                d.l(a);
            }

            
            {
                a = d.this;
                super();
            }
        });
        n.setOnClickListener(new android.view.View.OnClickListener() {

            private d a;

            public final void onClick(View view1)
            {
                d.m(a);
            }

            
            {
                a = d.this;
                super();
            }
        });
        j();
        c.setInnerBorderColor(-1);
        c.setOuterBorderColor(0xff000000);
        bundle.setProgress(4);
        c.setInnerBorderSize(a(4));
        k.setText(getString(0x7f080395, new Object[] {
            Integer.valueOf(4)
        }));
        seekbar.setProgress(12);
        c.setOuterBorderSize(a(12));
        l.setText(getString(0x7f0804cc, new Object[] {
            Integer.valueOf(12)
        }));
        e.setProgress(155);
        c.setInnerBorderOpacity(155);
        i.setText(getString(0x7f0804be, new Object[] {
            Integer.valueOf(155)
        }));
        f.setProgress(0);
        c.setCornerRadius(0);
        j.setText(getString(0x7f080101, new Object[] {
            Integer.valueOf(0)
        }));
    }
}
