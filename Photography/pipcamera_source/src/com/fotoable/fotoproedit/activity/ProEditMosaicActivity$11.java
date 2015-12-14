// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.view.View;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditMosaicActivity

class a
    implements android.view.ditMosaicActivity._cls11
{

    final ProEditMosaicActivity a;

    public void onClick(View view)
    {
        if (view.isSelected())
        {
            return;
        } else
        {
            ProEditMosaicActivity.a(a, ProEditMosaicActivity.n(a), true);
            ProEditMosaicActivity.a(a, ProEditMosaicActivity.o(a), false);
            ProEditMosaicActivity.a(a, ProEditMosaicActivity.f(a));
            return;
        }
    }

    (ProEditMosaicActivity proeditmosaicactivity)
    {
        a = proeditmosaicactivity;
        super();
    }
}
