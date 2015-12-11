// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets.navigationdrawer;

import android.view.View;

// Referenced classes of package com.abtnprojects.ambatana.ui.widgets.navigationdrawer:
//            f, k, g

class a
    implements android.view..OnClickListener
{

    final k a;
    final f b;

    public void onClick(View view)
    {
        if (f.a(b) != null)
        {
            f.a(b).setSelected(false);
        }
        f.a(b, a.getAdapterPosition());
        view.setSelected(true);
        f.a(b, view);
        if (f.b(b) != null)
        {
            f.b(b).a(a.getAdapterPosition());
        }
    }

    (f f1, k k1)
    {
        b = f1;
        a = k1;
        super();
    }
}
