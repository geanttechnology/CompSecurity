// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.view.FloatSeekBar;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SquareFitFragment

final class a
    implements android.view..SquareFitFragment._cls21
{

    private SquareFitFragment a;

    public final void onClick(View view)
    {
        SquareFitFragment.l(a).setValue(50F);
        SquareFitFragment.a(a, SquareFitFragment.g(a));
        SquareFitFragment.b(a, 50);
    }

    (SquareFitFragment squarefitfragment)
    {
        a = squarefitfragment;
        super();
    }
}
