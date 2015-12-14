// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.picsart.studio.editor.fragment.s;

// Referenced classes of package com.picsart.studio.editor.custommasks:
//            i, MaskStateHolder, d, h

public class l
{

    public RecyclerView a;
    public s b;

    public l(s s1, RecyclerView recyclerview)
    {
        b = s1;
        a = recyclerview;
        super();
    }

    public void a(h h)
    {
        s.f(b).b = s.k(b).a(h);
        s.e(b).a(h);
        b.getView().findViewById(0x7f1005c8).performClick();
        a.scrollToPosition(0);
    }
}
