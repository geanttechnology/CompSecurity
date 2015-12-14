// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.helper.c;
import com.picsart.studio.editor.history.EnhanceAction;
import com.picsart.studio.editor.view.EditorView;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.w;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i

public final class k extends i
{

    private EditorView c;
    private SeekBar d;
    private TextView e;
    private RadioGroup f;
    private c i;
    private TimeCalculator j;
    private int k[] = {
        90, 20, 0
    };
    private int l[];

    public k()
    {
        l = (new int[] {
            k[0], k[1], k[2]
        });
    }

    static void a(k k1)
    {
        k1.k();
    }

    static void b(k k1)
    {
        k1.l();
    }

    static int[] c(k k1)
    {
        return k1.l;
    }

    static int d(k k1)
    {
        return k1.n();
    }

    static void e(k k1)
    {
        k1.i();
    }

    static TimeCalculator f(k k1)
    {
        return k1.j;
    }

    static int[] g(k k1)
    {
        return k1.k;
    }

    static SeekBar h(k k1)
    {
        return k1.d;
    }

    private void i()
    {
        if (i != null)
        {
            i.a(l[0], l[1], l[2]);
            c.invalidate();
        }
    }

    private void j()
    {
        Bitmap bitmap = w.f(h, 2048);
        Bitmap bitmap1 = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        i = new c(bitmap, bitmap1);
        if (bitmap != h)
        {
            bitmap.recycle();
        }
        c.setImage(bitmap1);
        i();
    }

    private void k()
    {
        e.setText(String.valueOf(m()));
    }

    private void l()
    {
        d.setProgress(m());
    }

    private int m()
    {
        return l[n()];
    }

    private int n()
    {
        int i1 = f.getCheckedRadioButtonId();
        if (i1 == 0x7f10058a)
        {
            return 0;
        }
        if (i1 == 0x7f100546)
        {
            return 1;
        }
        return i1 != 0x7f10058b ? -1 : 2;
    }

    public final void a(Bitmap bitmap)
    {
        super.a(bitmap);
        if (c != null)
        {
            j();
        }
    }

    public final void d()
    {
        super.d();
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolEnhanceCloseEvent(com.picsart.studio.editor.e.a().e.a, "back", (int)j.d()));
    }

    public final Tool e()
    {
        return Tool.ENHANCE;
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            j = new TimeCalculator();
        } else
        {
            j = (TimeCalculator)bundle.getParcelable("time_calculator");
        }
        if (bundle != null)
        {
            l = bundle.getIntArray("values");
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030107, viewgroup, false);
    }

    public final void onDestroy()
    {
        super.onDestroy();
        i.a();
    }

    public final void onPause()
    {
        super.onPause();
        j.b();
    }

    public final void onResume()
    {
        super.onResume();
        j.c();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (j != null)
        {
            bundle.putParcelable("time_calculator", j);
        }
        bundle.putIntArray("values", l);
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        c = (EditorView)view.findViewById(0x7f1001c2);
        if (h != null)
        {
            j();
        }
        f = (RadioGroup)view.findViewById(0x7f100589);
        f.setOnCheckedChangeListener(new com.socialin.android.photo.draw.dialog.c() {

            private k a;

            public final void onCheckedChanged(RadioGroup radiogroup, int i1)
            {
                k.a(a);
                k.b(a);
            }

            
            {
                a = k.this;
                super();
            }
        });
        e = (TextView)view.findViewById(0x7f100587);
        d = (SeekBar)view.findViewById(0x7f100588);
        d.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            private k a;

            public final void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                com.picsart.studio.editor.fragment.k.c(a)[k.d(a)] = i1;
                k.a(a);
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
                com.picsart.studio.editor.fragment.k.e(a);
                switch (k.d(a))
                {
                default:
                    return;

                case 0: // '\0'
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolEnhanceTryEvent(com.picsart.studio.editor.e.a().e.a, "amount_change"));
                    return;

                case 1: // '\001'
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolEnhanceTryEvent(com.picsart.studio.editor.e.a().e.a, "saturation_change"));
                    return;

                case 2: // '\002'
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolEnhanceTryEvent(com.picsart.studio.editor.e.a().e.a, "fade_change"));
                    break;
                }
            }

            
            {
                a = k.this;
                super();
            }
        });
        view.findViewById(0x7f10054f).setOnClickListener(new android.view.View.OnClickListener() {

            private k a;

            public final void onClick(View view1)
            {
                a.g.a(a);
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolEnhanceCloseEvent(com.picsart.studio.editor.e.a().e.a, "cancel", (int)k.f(a).d()));
            }

            
            {
                a = k.this;
                super();
            }
        });
        view.findViewById(0x7f100550).setOnClickListener(new android.view.View.OnClickListener() {

            private k a;

            public final void onClick(View view1)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.EditToolsApplyEvent("tool_enhance"));
                com.picsart.studio.editor.e.a().e.c("enhance");
                view1 = a.h.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
                c c1 = new c(a.h, view1);
                c1.a(com.picsart.studio.editor.fragment.k.c(a)[0], com.picsart.studio.editor.fragment.k.c(a)[1], com.picsart.studio.editor.fragment.k.c(a)[2]);
                c1.a();
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolEnhanceCloseEvent(com.picsart.studio.editor.e.a().e.a, "done", (int)k.f(a).d()));
                a.g.a(a, view1, EnhanceAction.create(com.picsart.studio.editor.fragment.k.c(a)[0], com.picsart.studio.editor.fragment.k.c(a)[1], com.picsart.studio.editor.fragment.k.c(a)[2]));
            }

            
            {
                a = k.this;
                super();
            }
        });
        view.findViewById(0x7f100571).setOnClickListener(new android.view.View.OnClickListener() {

            private k a;

            public final void onClick(View view1)
            {
                com.picsart.studio.editor.fragment.k.c(a)[k.d(a)] = k.g(a)[k.d(a)];
                com.picsart.studio.editor.fragment.k.e(a);
                k.a(a);
                k.b(a);
            }

            
            {
                a = k.this;
                super();
            }
        });
        view = view.findViewById(0x7f10054d);
        if (view != null)
        {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(view) {

                private View a;
                private k b;

                public final void onGlobalLayout()
                {
                    int i1 = a.getWidth();
                    int j1 = a.getHeight();
                    if (i1 > 0 && j1 > 0)
                    {
                        Utils.a(a, this);
                        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)k.h(b).getLayoutParams();
                        layoutparams.width = j1;
                        k.h(b).setLayoutParams(layoutparams);
                        k.h(b).setTranslationX((float)(i1 - k.h(b).getHeight()) / 2.0F);
                        k.h(b).setPivotX(j1);
                        k.h(b).setPivotY(0.0F);
                        k.h(b).setRotation(270F);
                    }
                }

            
            {
                b = k.this;
                a = view;
                super();
            }
            });
        }
        k();
        l();
    }
}
