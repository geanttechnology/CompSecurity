// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;

import android.view.View;
import com.picsart.studio.view.FloatSeekBar;
import com.socialin.android.brushlib.svg.ShapeParams;

// Referenced classes of package com.socialin.android.photo.draw.dialog:
//            SelectShapeDialog

final class a
    implements android.view.
{

    private SelectShapeDialog a;

    public final void onClick(View view)
    {
        if (SelectShapeDialog.e(a).a() != SelectShapeDialog.e(a).b)
        {
            SelectShapeDialog.b(a).setSize(SelectShapeDialog.b(a).getSize() + 1.0F);
            SelectShapeDialog.e(a).setValue(SelectShapeDialog.b(a).getSize());
        }
    }

    (SelectShapeDialog selectshapedialog)
    {
        a = selectshapedialog;
        super();
    }
}
