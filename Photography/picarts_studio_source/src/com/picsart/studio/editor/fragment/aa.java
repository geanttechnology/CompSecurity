// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.TransformAction;
import com.picsart.studio.editor.view.FlipRotateEditorView;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i

public final class aa extends i
{

    private FlipRotateEditorView c;
    private TimeCalculator d;

    public aa()
    {
    }

    static TimeCalculator a(aa aa1)
    {
        return aa1.d;
    }

    static FlipRotateEditorView b(aa aa1)
    {
        return aa1.c;
    }

    public final void a(Bitmap bitmap)
    {
        super.a(bitmap);
        if (c != null)
        {
            c.setImage(bitmap);
        }
    }

    public final void d()
    {
        super.d();
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolFlipRotateCloseEvent(com.picsart.studio.editor.e.a().e.a, "back", (int)d.d()));
    }

    public final Tool e()
    {
        return Tool.TRANSFORM;
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            d = new TimeCalculator();
            return;
        } else
        {
            d = (TimeCalculator)bundle.getParcelable("time_calculator");
            return;
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030120, viewgroup, false);
    }

    public final void onPause()
    {
        super.onPause();
        d.b();
    }

    public final void onResume()
    {
        super.onResume();
        d.c();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (d != null)
        {
            bundle.putParcelable("time_calculator", d);
        }
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        c = (FlipRotateEditorView)view.findViewById(0x7f1001c2);
        c.setImage(h);
        view.findViewById(0x7f10054f).setOnClickListener(new android.view.View.OnClickListener() {

            private aa a;

            public final void onClick(View view1)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolFlipRotateCloseEvent(com.picsart.studio.editor.e.a().e.a, "cancel", (int)aa.a(a).d()));
                a.g.a(a);
            }

            
            {
                a = aa.this;
                super();
            }
        });
        view.findViewById(0x7f100550).setOnClickListener(new android.view.View.OnClickListener() {

            private aa a;

            public final void onClick(View view1)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.EditToolsApplyEvent("tool_flip_rotate"));
                com.picsart.studio.editor.e.a().e.c("flip_rotate");
                view1 = aa.b(a).g();
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolFlipRotateCloseEvent(com.picsart.studio.editor.e.a().e.a, "done", (int)aa.a(a).d()));
                a.g.a(a, view1, TransformAction.create(aa.b(a).i));
            }

            
            {
                a = aa.this;
                super();
            }
        });
        view.findViewById(0x7f10062e).setOnClickListener(new android.view.View.OnClickListener() {

            private aa a;

            public final void onClick(View view1)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolFlipRotateTryEvent(com.picsart.studio.editor.e.a().e.a, "flip_horizontally"));
                aa.b(a).e();
            }

            
            {
                a = aa.this;
                super();
            }
        });
        view.findViewById(0x7f10062f).setOnClickListener(new android.view.View.OnClickListener() {

            private aa a;

            public final void onClick(View view1)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolFlipRotateTryEvent(com.picsart.studio.editor.e.a().e.a, "flip_vertically"));
                aa.b(a).f();
            }

            
            {
                a = aa.this;
                super();
            }
        });
        view.findViewById(0x7f100597).setOnClickListener(new android.view.View.OnClickListener() {

            private aa a;

            public final void onClick(View view1)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolFlipRotateTryEvent(com.picsart.studio.editor.e.a().e.a, "rotate_cw"));
                aa.b(a).a(90F);
            }

            
            {
                a = aa.this;
                super();
            }
        });
        view.findViewById(0x7f100596).setOnClickListener(new android.view.View.OnClickListener() {

            private aa a;

            public final void onClick(View view1)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolFlipRotateTryEvent(com.picsart.studio.editor.e.a().e.a, "rotate_ccw"));
                aa.b(a).a(-90F);
            }

            
            {
                a = aa.this;
                super();
            }
        });
    }
}
