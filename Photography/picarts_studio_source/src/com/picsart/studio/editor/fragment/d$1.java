// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.widget.SlidingDrawer;
import com.picsart.studio.editor.view.BorderEditorView;
import com.socialin.android.colorpicker.c;
import com.socialin.android.photo.view.ColorPickerPreview;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            d

final class a
    implements c
{

    private d a;

    public final void a(int i)
    {
        if (d.a(a) != null)
        {
            d.a(a).setOuterBorderColor(i);
        }
        if (d.b(a) != null)
        {
            d.b(a).setColor(i);
        }
        com.picsart.studio.editor.fragment.d.c(a).open();
    }

    ckerPreview(d d1)
    {
        a = d1;
        super();
    }
}
