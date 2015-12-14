// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.editor.view.PerspectiveView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            t

final class a
    implements android.view..OnClickListener
{

    private t a;

    public final void onClick(View view)
    {
        t.b(a).setMode(com.picsart.studio.editor.view.pectiveView.PerspectiveMode.HORIZONTAL);
        t.c(a);
    }

    iveView(t t1)
    {
        a = t1;
        super();
    }
}
