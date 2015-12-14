// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;


// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            BCToastView

class a
    implements Runnable
{

    final BCToastView a;

    public void run()
    {
        if (BCToastView.c(a).equals(imationType.a))
        {
            BCToastView.a(a, null);
            return;
        } else
        {
            a.a(null);
            return;
        }
    }

    imationType(BCToastView bctoastview)
    {
        a = bctoastview;
        super();
    }
}
