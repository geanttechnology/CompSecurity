// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;


// Referenced classes of package com.picsart.studio.editor.fragment:
//            SquareFitFragment

final class a
    implements android.view.obalLayoutListener
{

    private SquareFitFragment a;

    public final void onGlobalLayout()
    {
        SquareFitFragment.j(a);
        if (SquareFitFragment.k(a))
        {
            SquareFitFragment.a(a, this);
        }
    }

    (SquareFitFragment squarefitfragment)
    {
        a = squarefitfragment;
        super();
    }
}
