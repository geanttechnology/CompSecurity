// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview;


// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview:
//            AdapterView

class s
    implements Runnable
{

    final AdapterView a;

    private s(AdapterView adapterview)
    {
        a = adapterview;
        super();
    }

    s(AdapterView adapterview, AdapterView._cls1 _pcls1)
    {
        this(adapterview);
    }

    public void run()
    {
        if (a.ah)
        {
            if (a.getAdapter() != null)
            {
                a.post(this);
            }
            return;
        } else
        {
            AdapterView.b(a);
            AdapterView.c(a);
            return;
        }
    }
}
