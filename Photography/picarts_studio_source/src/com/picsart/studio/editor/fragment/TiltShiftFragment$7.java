// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;


// Referenced classes of package com.picsart.studio.editor.fragment:
//            TiltShiftFragment

final class a
    implements android.view.lobalLayoutListener
{

    private TiltShiftFragment a;

    public final void onGlobalLayout()
    {
        TiltShiftFragment.i(a);
        if (TiltShiftFragment.j(a))
        {
            TiltShiftFragment.a(a, this);
        }
    }

    (TiltShiftFragment tiltshiftfragment)
    {
        a = tiltshiftfragment;
        super();
    }
}
