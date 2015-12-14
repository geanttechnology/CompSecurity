// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;

import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.brushlib.brush.Brush;
import myobfuscated.cf.a;

// Referenced classes of package com.socialin.android.photo.draw.dialog:
//            SelectBrushDialog

final class a
    implements android.view.
{

    private SelectBrushDialog a;

    public final void onClick(View view)
    {
        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.gBrushCloseEvent(SelectBrushDialog.d(a), SelectBrushDialog.e(a), SelectBrushDialog.f(a), SelectBrushDialog.h(a).a(SelectBrushDialog.g(a).c()), SelectBrushDialog.g(a).e(), com.socialin.android.photo.draw.dialog.SelectBrushDialog.a(a)));
        a.finish();
    }

    hCloseEvent(SelectBrushDialog selectbrushdialog)
    {
        a = selectbrushdialog;
        super();
    }
}
