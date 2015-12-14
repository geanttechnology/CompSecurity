// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.a.a;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            AboutActivity

class b
    implements android.view.ener
{

    final AboutActivity a;
    private a b;

    public void onClick(View view)
    {
        if (b != null && !b.isVisible())
        {
            o.a(a, b, "LegalDialog");
            return;
        } else
        {
            b = new a();
            o.a(a, b, "LegalDialog");
            return;
        }
    }

    _cls9(AboutActivity aboutactivity)
    {
        a = aboutactivity;
        super();
        b = null;
    }
}
