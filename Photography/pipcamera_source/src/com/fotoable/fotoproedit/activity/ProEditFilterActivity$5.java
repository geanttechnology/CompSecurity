// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditFilterActivity

class a
    implements android.view.EditFilterActivity._cls5
{

    final ProEditFilterActivity a;

    public void onClick(View view)
    {
        if (ProEditFilterActivity.j(a).isSelected())
        {
            return;
        }
        ProEditFilterActivity.f(a);
        if (ProEditFilterActivity.k(a))
        {
            ProEditFilterActivity.b(a, false);
            ProEditFilterActivity.a(a, ProEditFilterActivity.l(a), 2);
        }
        ProEditFilterActivity.a(a, 2);
        ProEditFilterActivity.a(a, ProEditFilterActivity.j(a));
    }

    (ProEditFilterActivity proeditfilteractivity)
    {
        a = proeditfilteractivity;
        super();
    }
}
