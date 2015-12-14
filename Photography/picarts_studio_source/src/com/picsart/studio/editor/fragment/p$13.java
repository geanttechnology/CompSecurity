// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import com.socialin.android.dialog.a;
import com.socialin.android.dialog.b;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            p

final class a
    implements Runnable
{

    private p a;

    public final void run()
    {
        p.p(a);
        com.picsart.studio.editor.fragment.p.a(a, p.q(a).a());
        p.r(a).show(a.getFragmentManager(), "gif_generation");
        p.s(a);
    }

    (p p1)
    {
        a = p1;
        super();
    }
}
