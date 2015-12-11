// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.view.View;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            c

class a
    implements android.view..OnClickListener
{

    final String a;
    final c b;

    public void onClick(View view)
    {
        if (view.getTag().equals(a))
        {
            c.a(b);
            return;
        } else
        {
            c.b(b);
            return;
        }
    }

    (c c1, String s)
    {
        b = c1;
        a = s;
        super();
    }
}
