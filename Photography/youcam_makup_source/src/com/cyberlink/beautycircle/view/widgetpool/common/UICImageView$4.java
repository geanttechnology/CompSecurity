// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;


// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            UICImageView, d, q

class a
    implements Runnable
{

    final UICImageView a;

    public void run()
    {
        a.setImageBitmap(UICImageView.e(a));
        if (UICImageView.f(a) && UICImageView.g(a) != null && UICImageView.e(a) != null)
        {
            a.clearAnimation();
            UICImageView.g(a).a(a);
        }
        if (a.a != null)
        {
            a.a.a(UICImageView.e(a));
        }
    }

    (UICImageView uicimageview)
    {
        a = uicimageview;
        super();
    }
}
