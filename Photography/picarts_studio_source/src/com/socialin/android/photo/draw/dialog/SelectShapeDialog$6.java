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
        if (SelectShapeDialog.f(a).a() != SelectShapeDialog.f(a).a)
        {
            SelectShapeDialog.b(a).setOpacity(SelectShapeDialog.b(a).getOpacity() - 2);
            SelectShapeDialog.f(a).setValue(SelectShapeDialog.b(a).getOpacity());
        }
    }

    (SelectShapeDialog selectshapedialog)
    {
        a = selectshapedialog;
        super();
    }
}
