// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditFilterActivity

class a
    implements android.view.EditFilterActivity._cls4
{

    final ProEditFilterActivity a;

    public void onClick(View view)
    {
        if (ProEditFilterActivity.g(a).isSelected())
        {
            return;
        }
        ProEditFilterActivity.f(a);
        if (ProEditFilterActivity.h(a))
        {
            ProEditFilterActivity.a(a, false);
            ProEditFilterActivity.a(a, ProEditFilterActivity.i(a), 1);
        }
        ProEditFilterActivity.a(a, 1);
        ProEditFilterActivity.a(a, ProEditFilterActivity.g(a));
    }

    (ProEditFilterActivity proeditfilteractivity)
    {
        a = proeditfilteractivity;
        super();
    }
}
