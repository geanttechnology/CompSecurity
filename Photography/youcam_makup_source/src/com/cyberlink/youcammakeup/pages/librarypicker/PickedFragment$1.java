// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker;

import android.view.View;
import android.widget.LinearLayout;
import com.cyberlink.youcammakeup.pages.librarypicker.a.b;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker:
//            PickedFragment

class a
    implements android.view.ner
{

    final b a;
    final PickedFragment b;

    public void onClick(View view)
    {
        a.setOnCloseListener(null);
        b.b.removeView(a);
        b.a();
    }

    (PickedFragment pickedfragment, b b1)
    {
        b = pickedfragment;
        a = b1;
        super();
    }
}
