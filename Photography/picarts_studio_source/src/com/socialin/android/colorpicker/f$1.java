// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.colorpicker;

import android.graphics.Color;
import android.view.View;

// Referenced classes of package com.socialin.android.colorpicker:
//            f, d, a, c

final class a
    implements android.view..OnClickListener
{

    private f a;

    public final void onClick(View view)
    {
        if (f.a(a) != null)
        {
            if (view.getId() == 0x7f100384)
            {
                f.b(a).a();
                a.dismiss();
            } else
            {
                if (view.getId() == 0x7f100380)
                {
                    f.a(a).a(Color.HSVToColor(f.c(a).a));
                    a.dismiss();
                    return;
                }
                if (view.getId() == 0x7f10037f)
                {
                    a.dismiss();
                    return;
                }
            }
        }
    }

    (f f1)
    {
        a = f1;
        super();
    }
}
