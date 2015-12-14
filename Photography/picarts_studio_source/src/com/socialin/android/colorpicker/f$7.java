// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.colorpicker;

import android.graphics.Color;
import android.view.View;

// Referenced classes of package com.socialin.android.colorpicker:
//            f, a

final class a
    implements android.view..OnClickListener
{

    private f a;

    public final void onClick(View view)
    {
        int i = view.getId();
        if (i == 0x7f1007a2)
        {
            f.c(a).a(Color.red(f.c(a).b) - 1);
        } else
        {
            if (i == 0x7f1007a4)
            {
                f.c(a).a(Color.red(f.c(a).b) + 1);
                return;
            }
            if (i == 0x7f1007a6)
            {
                f.c(a).b(Color.green(f.c(a).b) - 1);
                return;
            }
            if (i == 0x7f1007a8)
            {
                f.c(a).b(Color.green(f.c(a).b) + 1);
                return;
            }
            if (i == 0x7f1007aa)
            {
                f.c(a).c(Color.blue(f.c(a).b) - 1);
                return;
            }
            if (i == 0x7f1007ac)
            {
                f.c(a).c(Color.blue(f.c(a).b) + 1);
                return;
            }
        }
    }

    (f f1)
    {
        a = f1;
        super();
    }
}
