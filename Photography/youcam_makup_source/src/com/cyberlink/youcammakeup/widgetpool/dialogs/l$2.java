// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            l, m

class a
    implements android.view..OnClickListener
{

    final l a;

    public void onClick(View view)
    {
        if (l.a(a) != null && !l.a(a).b(view, l.b(a).getText().toString()))
        {
            return;
        } else
        {
            a.dismiss();
            return;
        }
    }

    (l l1)
    {
        a = l1;
        super();
    }
}
