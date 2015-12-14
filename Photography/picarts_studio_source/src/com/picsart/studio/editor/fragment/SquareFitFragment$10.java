// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.support.v7.graphics.Palette;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SquareFitFragment

final class a
    implements android.support.v7.graphics.istener
{

    private SquareFitFragment a;

    public final void onGenerated(Palette palette)
    {
        SquareFitFragment.a(a, new int[6]);
        SquareFitFragment.I(a)[0] = palette.getMutedColor(-1);
        SquareFitFragment.I(a)[2] = palette.getVibrantColor(-1);
        SquareFitFragment.I(a)[1] = palette.getDarkMutedColor(-1);
        SquareFitFragment.I(a)[3] = palette.getDarkVibrantColor(-1);
        SquareFitFragment.I(a)[4] = palette.getLightMutedColor(-1);
        SquareFitFragment.I(a)[5] = palette.getLightVibrantColor(-1);
        SquareFitFragment.J(a);
    }

    (SquareFitFragment squarefitfragment)
    {
        a = squarefitfragment;
        super();
    }
}
