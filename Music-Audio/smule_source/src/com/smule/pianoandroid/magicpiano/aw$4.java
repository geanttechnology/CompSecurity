// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import com.smule.android.c.f;
import com.smule.android.c.o;
import com.smule.pianoandroid.utils.q;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            aw

class b
    implements android.view.OnClickListener
{

    final String a;
    final f b;
    final aw c;

    public void onClick(View view)
    {
        if (aw.d(c) != null)
        {
            if (a != null)
            {
                q.a(a, o.f, b);
            }
            aw.d(c).onClick(view);
        }
    }

    (aw aw1, String s, f f)
    {
        c = aw1;
        a = s;
        b = f;
        super();
    }
}
