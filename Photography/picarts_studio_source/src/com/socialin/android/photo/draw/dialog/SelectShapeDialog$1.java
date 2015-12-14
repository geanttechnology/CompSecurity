// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;

import android.widget.TextView;
import com.picsart.studio.view.FloatSeekBar;
import com.picsart.studio.view.c;
import com.socialin.android.brushlib.svg.ShapeParams;
import com.socialin.android.photo.draw.shape.ShapePreview;

// Referenced classes of package com.socialin.android.photo.draw.dialog:
//            SelectShapeDialog

final class a extends c
{

    private SelectShapeDialog a;

    public final void a(FloatSeekBar floatseekbar, float f, boolean flag)
    {
        floatseekbar.getId();
        JVM INSTR lookupswitch 2: default 32
    //                   2131755490: 43
    //                   2131756136: 105;
           goto _L1 _L2 _L3
_L1:
        SelectShapeDialog.d(a).invalidate();
        return;
_L2:
        SelectShapeDialog.a(a).setText((new StringBuilder()).append(String.valueOf(Math.round((f / 255F) * 100F))).append("%").toString());
        if (flag)
        {
            SelectShapeDialog.b(a).setOpacity(Math.round(f));
        }
        continue; /* Loop/switch isn't completed */
_L3:
        com.socialin.android.photo.draw.dialog.SelectShapeDialog.c(a).setText((new StringBuilder()).append(String.valueOf(Math.round(f))).append("px").toString());
        if (flag)
        {
            SelectShapeDialog.b(a).setSize(Math.round(f));
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    (SelectShapeDialog selectshapedialog)
    {
        a = selectshapedialog;
        super();
    }
}
