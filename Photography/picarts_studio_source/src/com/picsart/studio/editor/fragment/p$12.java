// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.editor.utils.a;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            p

final class a
    implements android.view.OnClickListener
{

    private p a;

    public final void onClick(View view)
    {
        if (p.j() != null)
        {
            p.j().a();
        }
        p.o(a);
        if (p.m(a))
        {
            a.a(p.g(a));
        }
    }

    (p p1)
    {
        a = p1;
        super();
    }
}
