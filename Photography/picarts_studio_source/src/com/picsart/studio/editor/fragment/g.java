// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.CurveAction;
import com.picsart.studio.editor.view.CurvesEditorView;
import com.picsart.studio.editor.view.RGBConvertView;
import com.picsart.studio.editor.view.o;
import com.picsart.studio.editor.view.p;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.util.AnalyticUtils;
import java.util.ArrayList;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i

public final class g extends i
{

    private CurvesEditorView c;
    private RGBConvertView d;
    private View e;
    private TimeCalculator f;

    public g()
    {
    }

    public static View a(g g1)
    {
        return g1.e;
    }

    static RGBConvertView b(g g1)
    {
        return g1.d;
    }

    static TimeCalculator c(g g1)
    {
        return g1.f;
    }

    public final void a(Bitmap bitmap)
    {
        super.a(bitmap);
        if (c != null)
        {
            c.setImage(bitmap);
            c.a(d.d, d.e, d.f, d.g);
        }
    }

    public final void d()
    {
        super.d();
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCurvesCloseEvent(com.picsart.studio.editor.e.a().e.a, "back", (int)f.d()));
    }

    public final Tool e()
    {
        return Tool.CURVES;
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            f = new TimeCalculator();
            return;
        } else
        {
            f = (TimeCalculator)bundle.getParcelable("time_calculator");
            return;
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030104, viewgroup, false);
    }

    public final void onPause()
    {
        super.onPause();
        f.b();
    }

    public final void onResume()
    {
        super.onResume();
        f.c();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (f != null)
        {
            bundle.putParcelable("time_calculator", f);
        }
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        c = (CurvesEditorView)view.findViewById(0x7f1001c2);
        d = (RGBConvertView)view.findViewById(0x7f100574);
        d.setOnPointsChangedListener(new p(this));
        d.setCurveChangeListenerForAnalytics(new o(this));
        d.setOnValuesChangedListener(c);
        if (h != null)
        {
            c.setImage(h);
        }
        ((RadioGroup)view.findViewById(0x7f10034b)).setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            private g a;

            public final void onCheckedChanged(RadioGroup radiogroup, int j)
            {
                if (g.b(a) == null)
                {
                    return;
                }
                if (j != 0x7f10034d) goto _L2; else goto _L1
_L1:
                g.b(a).setDrawChannel(0);
_L4:
                g.b(a).invalidate();
                return;
_L2:
                if (j == 0x7f10034e)
                {
                    g.b(a).setDrawChannel(1);
                } else
                if (j == 0x7f10034f)
                {
                    g.b(a).setDrawChannel(2);
                } else
                if (j == 0x7f10034c)
                {
                    g.b(a).setDrawChannel(3);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = g.this;
                super();
            }
        });
        view.findViewById(0x7f100351).setOnClickListener(new android.view.View.OnClickListener() {

            private g a;

            public final void onClick(View view1)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCurvesTryEvent(com.picsart.studio.editor.e.a().e.a, "original"));
                view1 = g.b(a);
                view1.a(((RGBConvertView) (view1)).b);
                view1.setTouchPointIndex(-1);
                g.b(a).a(g.b(a).b, false);
                g.b(a).invalidate();
            }

            
            {
                a = g.this;
                super();
            }
        });
        e = view.findViewById(0x7f100352);
        e.setEnabled(false);
        e.setOnClickListener(new android.view.View.OnClickListener() {

            private g a;

            public final void onClick(View view1)
            {
                view1 = g.b(a);
                ArrayList arraylist = (ArrayList)((RGBConvertView) (view1)).a.get(((RGBConvertView) (view1)).b);
                boolean flag;
                if (((RGBConvertView) (view1)).c > 0 && ((RGBConvertView) (view1)).c < arraylist.size() - 1)
                {
                    arraylist.remove(((RGBConvertView) (view1)).c);
                    view1.b(((RGBConvertView) (view1)).b);
                    view1.setTouchPointIndex(-1);
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCurvesTryEvent(com.picsart.studio.editor.e.a().e.a, "delete"));
                    g.b(a).invalidate();
                    g.b(a).a(g.b(a).b, false);
                }
            }

            
            {
                a = g.this;
                super();
            }
        });
        view.findViewById(0x7f100350).setOnClickListener(new android.view.View.OnClickListener() {

            private g a;

            public final void onClick(View view1)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCurvesCloseEvent(com.picsart.studio.editor.e.a().e.a, "cancel", (int)com.picsart.studio.editor.fragment.g.c(a).d()));
                a.g.a(a);
            }

            
            {
                a = g.this;
                super();
            }
        });
        view.findViewById(0x7f100245).setOnClickListener(new android.view.View.OnClickListener() {

            private g a;

            public final void onClick(View view1)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.EditToolsApplyEvent("tool_curves"));
                com.picsart.studio.editor.e.a().e.c("curves");
                view1 = CurvesEditorView.a(a.h, g.b(a).d, g.b(a).e, g.b(a).f, g.b(a).g);
                CurveAction curveaction = CurveAction.create(g.b(a).a);
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCurvesCloseEvent(com.picsart.studio.editor.e.a().e.a, "done", (int)com.picsart.studio.editor.fragment.g.c(a).d()));
                a.g.a(a, view1, curveaction);
            }

            
            {
                a = g.this;
                super();
            }
        });
    }
}
