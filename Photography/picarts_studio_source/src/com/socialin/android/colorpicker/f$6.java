// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.colorpicker;

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
        if (i == 0x7f100651)
        {
            f.c(a).a(f.c(a).a() + 1.0F);
        } else
        {
            if (i == 0x7f10064f)
            {
                f.c(a).a(f.c(a).a() - 1.0F);
                return;
            }
            if (i == 0x7f100655)
            {
                f.c(a).b(f.c(a).b() + 0.01F);
                return;
            }
            if (i == 0x7f100653)
            {
                f.c(a).b(f.c(a).b() - 0.01F);
                return;
            }
            if (i == 0x7f100659)
            {
                f.c(a).c(f.c(a).c() + 0.01F);
                return;
            }
            if (i == 0x7f100657)
            {
                f.c(a).c(f.c(a).c() - 0.01F);
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
