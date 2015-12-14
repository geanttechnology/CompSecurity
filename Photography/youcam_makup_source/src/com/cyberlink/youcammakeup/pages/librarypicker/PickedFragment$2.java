// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker;

import android.widget.HorizontalScrollView;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker:
//            PickedFragment

class a
    implements Runnable
{

    final PickedFragment a;

    public void run()
    {
        a.c.fullScroll(66);
    }

    (PickedFragment pickedfragment)
    {
        a = pickedfragment;
        super();
    }
}
