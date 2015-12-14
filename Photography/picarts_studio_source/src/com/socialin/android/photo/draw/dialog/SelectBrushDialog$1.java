// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;

import android.content.Intent;
import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.brushlib.brush.Brush;
import com.socialin.android.brushlib.brush.BrushHistory;
import myobfuscated.cf.a;

// Referenced classes of package com.socialin.android.photo.draw.dialog:
//            SelectBrushDialog

final class a
    implements android.view.
{

    private SelectBrushDialog a;

    public final void onClick(View view)
    {
        SelectBrushDialog.b(a).setBrushSelectedParams(SelectBrushDialog.b(a).getSelectedBrushId(com.socialin.android.photo.draw.dialog.SelectBrushDialog.a(a)), SelectBrushDialog.c(a), com.socialin.android.photo.draw.dialog.SelectBrushDialog.a(a));
        SelectBrushDialog.b(a).saveToFile();
        view = new Intent();
        view.putExtra("extra.brush.history", SelectBrushDialog.b(a));
        a.setResult(-1, view);
        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.gBrushApplyEvent(SelectBrushDialog.d(a), SelectBrushDialog.e(a), SelectBrushDialog.f(a), SelectBrushDialog.h(a).a(SelectBrushDialog.g(a).c()), SelectBrushDialog.g(a).e(), com.socialin.android.photo.draw.dialog.SelectBrushDialog.a(a)));
        a.finish();
    }

    hApplyEvent(SelectBrushDialog selectbrushdialog)
    {
        a = selectbrushdialog;
        super();
    }
}
