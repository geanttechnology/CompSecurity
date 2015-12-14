// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.collage;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

// Referenced classes of package com.socialin.android.photo.collage:
//            SelectCollageBgActivity

final class a extends android.support.v7.widget.n
{

    private SelectCollageBgActivity a;

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.tivity._cls1 _pcls1)
    {
        super.getItemOffsets(rect, view, recyclerview, _pcls1);
        rect.set(SelectCollageBgActivity.a(a), SelectCollageBgActivity.a(a), SelectCollageBgActivity.a(a), SelectCollageBgActivity.a(a));
    }

    (SelectCollageBgActivity selectcollagebgactivity)
    {
        a = selectcollagebgactivity;
        super();
    }
}
