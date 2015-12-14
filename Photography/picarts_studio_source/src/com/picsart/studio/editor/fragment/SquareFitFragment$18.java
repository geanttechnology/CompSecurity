// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import com.picsart.studio.editor.view.SquareFitEditorView;
import com.picsart.studio.view.FloatSeekBar;
import com.picsart.studio.view.c;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SquareFitFragment

final class a extends c
{

    private SquareFitFragment a;

    public final void a(FloatSeekBar floatseekbar)
    {
        floatseekbar = AnalyticUtils.getInstance(a.getActivity());
        String s = com.picsart.studio.editor.fragment.SquareFitFragment.c;
        SquareFitEditorView squarefiteditorview = com.picsart.studio.editor.fragment.SquareFitFragment.c(a);
        int i = squarefiteditorview.l + 1;
        squarefiteditorview.l = i;
        floatseekbar.track(new com.socialin.android.apiv3.events.itTryEvent(s, "blur", i, SquareFitFragment.g(a).getHeight(), SquareFitFragment.g(a).getWidth()));
    }

    public final void a(FloatSeekBar floatseekbar, float f, boolean flag)
    {
        if (flag && !SquareFitFragment.d(a))
        {
            SquareFitFragment.b(a, (int)f);
        }
    }

    tTryEvent(SquareFitFragment squarefitfragment)
    {
        a = squarefitfragment;
        super();
    }
}
