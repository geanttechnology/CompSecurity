// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.picsart.studio.editor.view.SquareFitEditorView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SquareFitFragment

final class a
    implements android.view..SquareFitFragment._cls22
{

    private SquareFitFragment a;

    public final void onClick(View view)
    {
        SquareFitFragment.m(a).setVisibility(0);
        if (SquareFitFragment.n(a) != null)
        {
            SquareFitFragment.n(a).setVisibility(8);
        } else
        {
            SquareFitFragment.o(a).setVisibility(8);
        }
        SquareFitFragment.p(a).setVisibility(8);
        SquareFitFragment.a(a, areFitMode.BLUR);
        SquareFitFragment.q(a);
        SquareFitFragment.c(a).setMode(SquareFitFragment.r(a));
        SquareFitFragment.a(a, SquareFitFragment.a(a), SquareFitFragment.s(a), SquareFitFragment.t(a), SquareFitFragment.u(a));
    }

    areFitMode(SquareFitFragment squarefitfragment)
    {
        a = squarefitfragment;
        super();
    }
}
