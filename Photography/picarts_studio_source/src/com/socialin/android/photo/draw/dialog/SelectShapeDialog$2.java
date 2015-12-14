// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;

import android.widget.RadioGroup;
import com.socialin.android.brushlib.svg.ShapeParams;
import com.socialin.android.photo.draw.shape.ShapePreview;

// Referenced classes of package com.socialin.android.photo.draw.dialog:
//            c, SelectShapeDialog

final class a
    implements c
{

    private SelectShapeDialog a;

    public final void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        i;
        JVM INSTR tableswitch 2131757094 2131757095: default 24
    //                   2131757094 35
    //                   2131757095 57;
           goto _L1 _L2 _L3
_L1:
        SelectShapeDialog.d(a).invalidate();
        return;
_L2:
        SelectShapeDialog.b(a).setStroke(false);
        SelectShapeDialog.a(a, false);
        continue; /* Loop/switch isn't completed */
_L3:
        SelectShapeDialog.b(a).setStroke(true);
        SelectShapeDialog.a(a, true);
        if (true) goto _L1; else goto _L4
_L4:
    }

    (SelectShapeDialog selectshapedialog)
    {
        a = selectshapedialog;
        super();
    }
}
