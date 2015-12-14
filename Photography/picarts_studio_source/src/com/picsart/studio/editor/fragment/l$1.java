// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Color;
import com.picsart.studio.editor.view.FrameEditorView;
import com.socialin.android.colorpicker.c;
import com.socialin.android.photo.view.ColorPickerPreview;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            l

final class a
    implements c
{

    private l a;

    public final void a(int i)
    {
        int j = Color.red(i);
        int k = Color.green(i);
        int i1 = Color.blue(i);
        j = Color.argb(Color.alpha(l.a(a).f()), j, k, i1);
        l.a(a).setOverlayColor(j);
        if (l.b(a) != null)
        {
            l.b(a).setColor(i);
        }
    }

    ckerPreview(l l1)
    {
        a = l1;
        super();
    }
}
