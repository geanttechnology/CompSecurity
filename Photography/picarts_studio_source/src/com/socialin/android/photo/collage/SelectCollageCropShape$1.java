// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.collage;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.socialin.android.photo.collage:
//            SelectCollageCropShape, a

final class a
    implements android.widget.stener
{

    private SelectCollageCropShape a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent();
        adapterview.putExtra("shape", a.c[i]);
        a.setResult(-1, adapterview);
        a.finish();
        AnalyticUtils.getInstance(a).trackLocalAction("selectCollageCropShape:selectItem");
    }

    A(SelectCollageCropShape selectcollagecropshape)
    {
        a = selectcollagecropshape;
        super();
    }
}
