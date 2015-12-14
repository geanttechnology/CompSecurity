// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import com.picsart.studio.editor.view.TiltShiftEditorView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            w, TiltShiftFragment

final class a
    implements w
{

    private TiltShiftFragment a;

    public final void a(Bitmap bitmap)
    {
        if (TiltShiftFragment.a(a) != 0 || bitmap == TiltShiftFragment.b(a) || bitmap == TiltShiftFragment.c(a))
        {
            TiltShiftFragment.d(a).setBlurredImage(bitmap);
            TiltShiftFragment.d(a).invalidate();
        }
        if (TiltShiftFragment.e(a))
        {
            TiltShiftFragment.f(a);
        }
    }

    (TiltShiftFragment tiltshiftfragment)
    {
        a = tiltshiftfragment;
        super();
    }
}
