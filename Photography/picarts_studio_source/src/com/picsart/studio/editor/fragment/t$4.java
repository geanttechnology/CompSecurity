// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.editor.c;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            t

final class a
    implements android.view..OnClickListener
{

    private t a;

    public final void onClick(View view)
    {
        if (a.g != null)
        {
            a.g.a(a);
        }
        t.b(a, "close");
    }

    (t t1)
    {
        a = t1;
        super();
    }
}
