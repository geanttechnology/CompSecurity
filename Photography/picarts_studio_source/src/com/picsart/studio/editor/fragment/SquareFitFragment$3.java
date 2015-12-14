// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.view.View;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.view.SquareFitEditorView;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SquareFitFragment

final class a
    implements android.view.
{

    private SquareFitFragment a;

    public final void onClick(View view)
    {
        if (SquareFitFragment.g(a) != null)
        {
            if (SquareFitFragment.w(a))
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.FitCloseEvent(com.picsart.studio.editor.fragment.SquareFitFragment.c, "instagram_share_skip", com.picsart.studio.editor.fragment.SquareFitFragment.c(a).l, SquareFitFragment.g(a).getHeight(), SquareFitFragment.g(a).getWidth()));
            } else
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.FitCloseEvent(com.picsart.studio.editor.fragment.SquareFitFragment.c, "cancel", com.picsart.studio.editor.fragment.SquareFitFragment.c(a).l, SquareFitFragment.g(a).getHeight(), SquareFitFragment.g(a).getWidth()));
            }
        }
        SquareFitFragment.x(a);
        if (a.g != null)
        {
            a.g.a(a);
        }
    }

    itCloseEvent(SquareFitFragment squarefitfragment)
    {
        a = squarefitfragment;
        super();
    }
}
