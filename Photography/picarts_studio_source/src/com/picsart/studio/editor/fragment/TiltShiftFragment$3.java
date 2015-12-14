// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
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
        TiltShiftFragment.d(a).setBlurredImage(bitmap);
        if (a.getActivity() == null || a.getActivity().isFinishing())
        {
            TiltShiftFragment.o(a);
            return;
        } else
        {
            TiltShiftFragment.v(a);
            return;
        }
    }

    (TiltShiftFragment tiltshiftfragment)
    {
        a = tiltshiftfragment;
        super();
    }
}
