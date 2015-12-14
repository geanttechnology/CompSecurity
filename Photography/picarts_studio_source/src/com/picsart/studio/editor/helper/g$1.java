// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.helper;

import android.util.SparseArray;
import android.view.View;
import com.socialin.android.adapter.a;
import myobfuscated.cb.c;

// Referenced classes of package com.picsart.studio.editor.helper:
//            g, h

final class c
    implements android.view..OnClickListener
{

    private h a;
    private int b;
    private c c;
    private g d;

    public final void onClick(View view)
    {
        if (com.picsart.studio.editor.helper.g.a(d) >= 0 && g.b(d).get(com.picsart.studio.editor.helper.g.a(d)) != null)
        {
            ((h)g.b(d).get(com.picsart.studio.editor.helper.g.a(d))).b.setBackgroundResource(0);
        }
        a.b.setBackgroundResource(0x7f020077);
        com.picsart.studio.editor.helper.g.a(d, b);
        com.picsart.studio.editor.helper.g.c(d).a(b, null, new Object[] {
            c.c
        });
    }

    (g g1, h h1, int i, c c1)
    {
        d = g1;
        a = h1;
        b = i;
        c = c1;
        super();
    }
}
