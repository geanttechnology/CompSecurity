// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.view.View;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            b

class a
    implements android.view..OnClickListener
{

    final b a;

    public void onClick(View view)
    {
        if (view.getTag().equals(.A.c()))
        {
            b.a(a);
            return;
        }
        if (view.getTag().equals(.M.c()))
        {
            b.b(a);
            return;
        } else
        {
            b.a(a, true);
            return;
        }
    }

    (b b1)
    {
        a = b1;
        super();
    }
}
