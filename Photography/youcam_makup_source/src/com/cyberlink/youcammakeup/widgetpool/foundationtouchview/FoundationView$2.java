// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.foundationtouchview;


// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.foundationtouchview:
//            FoundationView

class a
    implements Runnable
{

    final FoundationView a;

    public void run()
    {
        FoundationView.a(a, true);
        a.invalidate();
    }

    (FoundationView foundationview)
    {
        a = foundationview;
        super();
    }
}
