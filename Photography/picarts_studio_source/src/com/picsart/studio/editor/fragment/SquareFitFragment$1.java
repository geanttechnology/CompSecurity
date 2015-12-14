// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

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
        if (SquareFitFragment.a(a) != 0 || bitmap == SquareFitFragment.b(a))
        {
            SquareFitFragment.c(a).setBlurredImage(bitmap);
            SquareFitFragment.c(a).invalidate();
        }
        if (SquareFitFragment.d(a) && !SquareFitFragment.e(a))
        {
            SquareFitFragment.f(a);
        }
    }

    (SquareFitFragment squarefitfragment)
    {
        a = squarefitfragment;
        super();
    }
}
