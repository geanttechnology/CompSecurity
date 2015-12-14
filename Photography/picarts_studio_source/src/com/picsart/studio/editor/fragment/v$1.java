// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.widget.SlidingDrawer;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.e;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.colorpicker.c;
import com.socialin.android.photo.collage.ShapeCropView;
import com.socialin.android.photo.view.ColorPickerPreview;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            v

final class a
    implements c
{

    private v a;

    public final void a(int i)
    {
        a[v.a(a).ordinal()];
        JVM INSTR tableswitch 1 2: default 36
    //                   1 89
    //                   2 103;
           goto _L1 _L2 _L3
_L1:
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.tsFactory.ToolShapeCropTryEvent(e.a().e.a, "color_change"));
        com.picsart.studio.editor.fragment.v.c(a).setColor(i);
        v.d(a).open();
        return;
_L2:
        v.b(a).setBorderColor(i);
        continue; /* Loop/switch isn't completed */
_L3:
        v.b(a).setOverlayColor(i);
        if (true) goto _L1; else goto _L4
_L4:
    }

    eCropView(v v1)
    {
        a = v1;
        super();
    }
}
