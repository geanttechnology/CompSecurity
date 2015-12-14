// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.EditingData;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class a
    implements android.view.
{

    private SelectionFragment a;

    public final void onClick(View view)
    {
        if (!SelectionFragment.a(a))
        {
            if (view.getId() == 0x7f100066)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.lectionTryEvent(SelectionFragment.b(a).a, "cut"));
                SelectionFragment.c(a);
                return;
            }
            if (view.getId() == 0x7f100064)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.lectionTryEvent(SelectionFragment.b(a).a, "copy"));
                SelectionFragment.d(a);
                return;
            }
            if (view.getId() == 0x7f10006b)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.lectionTryEvent(SelectionFragment.b(a).a, "paste"));
                SelectionFragment.e(a);
                return;
            }
            if (view.getId() == 0x7f100063)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.lectionTryEvent(SelectionFragment.b(a).a, "clear"));
                SelectionFragment.f(a);
                return;
            }
            if (view.getId() == 0x7f100065)
            {
                SelectionFragment.g(a);
                return;
            }
            if (view.getId() == 0x7f100069)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.lectionTryEvent(SelectionFragment.b(a).a, "inverse"));
                SelectionFragment.h(a);
                return;
            }
            if (view.getId() == 0x7f100068)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.lectionTryEvent(SelectionFragment.b(a).a, "effect_click"));
                SelectionFragment.i(a);
                return;
            }
            if (view.getId() == 0x7f10006d)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.lectionTryEvent(SelectionFragment.b(a).a, "save_to_clipart"));
                SelectionFragment.j(a);
                return;
            }
            if (view.getId() == 0x7f100067)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.lectionTryEvent(SelectionFragment.b(a).a, "deselect"));
                SelectionFragment.k(a);
                return;
            }
            if (view.getId() == 0x7f10006c)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.lectionTryEvent(SelectionFragment.b(a).a, "original"));
                SelectionFragment.l(a);
                return;
            }
            if (view.getId() == 0x7f10006a)
            {
                SelectionFragment.m(a);
                return;
            }
        }
    }

    ectionTryEvent(SelectionFragment selectionfragment)
    {
        a = selectionfragment;
        super();
    }
}
