// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.view.View;
import android.widget.CheckBox;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            v, w

class a
    implements android.view..OnClickListener
{

    final v a;

    public void onClick(View view)
    {
        if (v.a(a) != null)
        {
            boolean flag = v.b(a).isChecked();
            v.a(a).b(flag);
        }
    }

    (v v1)
    {
        a = v1;
        super();
    }
}
