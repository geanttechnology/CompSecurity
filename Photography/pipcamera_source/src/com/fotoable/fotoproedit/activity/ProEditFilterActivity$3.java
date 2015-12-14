// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditFilterActivity

class a
    implements android.view.EditFilterActivity._cls3
{

    final ProEditFilterActivity a;

    public void onClick(View view)
    {
        if (ProEditFilterActivity.e(a).isSelected())
        {
            return;
        } else
        {
            ProEditFilterActivity.f(a);
            ProEditFilterActivity.a(a, 0);
            ProEditFilterActivity.a(a, ProEditFilterActivity.e(a));
            return;
        }
    }

    (ProEditFilterActivity proeditfilteractivity)
    {
        a = proeditfilteractivity;
        super();
    }
}
