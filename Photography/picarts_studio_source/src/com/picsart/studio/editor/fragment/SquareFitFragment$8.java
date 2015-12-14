// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import com.picsart.studio.editor.view.SquareFitEditorView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            w, SquareFitFragment

final class a
    implements w
{

    private SquareFitFragment a;

    public final void a(Bitmap bitmap)
    {
        Bitmap bitmap1;
        if (SquareFitFragment.a(a) == 0)
        {
            bitmap1 = SquareFitFragment.D(a);
        } else
        {
            bitmap1 = SquareFitFragment.E(a);
        }
        SquareFitFragment.b(bitmap1);
        SquareFitFragment.c(a).setBlurredImage(bitmap);
        if (a.getActivity() == null || a.getActivity().isFinishing())
        {
            SquareFitFragment.x(a);
            return;
        } else
        {
            SquareFitFragment.F(a);
            return;
        }
    }

    (SquareFitFragment squarefitfragment)
    {
        a = squarefitfragment;
        super();
    }
}
