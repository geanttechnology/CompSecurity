// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.os.Handler;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            p

final class a
    implements Runnable
{

    private long a;
    private p b;

    public final void run()
    {
        if (b.getActivity() != null && !b.getActivity().isFinishing())
        {
            p.a(b);
            p.b(b).postDelayed(this, a);
        }
    }

    (p p1, long l)
    {
        b = p1;
        a = l;
        super();
    }
}
