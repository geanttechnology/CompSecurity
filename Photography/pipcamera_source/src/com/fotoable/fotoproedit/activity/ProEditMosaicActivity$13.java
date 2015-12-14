// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.view.View;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditMosaicActivity

class a
    implements android.view.ditMosaicActivity._cls13
{

    final ProEditMosaicActivity a;

    public void onClick(View view)
    {
        ProEditMosaicActivity proeditmosaicactivity = a;
        boolean flag;
        if (!view.isSelected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ProEditMosaicActivity.a(proeditmosaicactivity, flag);
    }

    (ProEditMosaicActivity proeditmosaicactivity)
    {
        a = proeditmosaicactivity;
        super();
    }
}
