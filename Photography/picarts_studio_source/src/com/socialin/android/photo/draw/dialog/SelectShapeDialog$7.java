// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;

import android.content.Intent;
import android.view.View;
import com.socialin.android.brushlib.svg.ShapeParams;

// Referenced classes of package com.socialin.android.photo.draw.dialog:
//            SelectShapeDialog

final class a
    implements android.view.
{

    private SelectShapeDialog a;

    public final void onClick(View view)
    {
        view = new Intent();
        view.putExtra("extra.shape.name", SelectShapeDialog.g(a));
        view.putExtra("extra.shape.opacity", SelectShapeDialog.b(a).getOpacity());
        view.putExtra("extra.shape.thickness", SelectShapeDialog.b(a).getSize());
        view.putExtra("extra.shape.style", SelectShapeDialog.b(a).isStroke());
        a.setResult(-1, view);
        a.finish();
    }

    (SelectShapeDialog selectshapedialog)
    {
        a = selectshapedialog;
        super();
    }
}
