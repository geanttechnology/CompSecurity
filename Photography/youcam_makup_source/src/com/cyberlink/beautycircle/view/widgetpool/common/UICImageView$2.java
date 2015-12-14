// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import com.nostra13.universalimageloader.core.f;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            UICImageView

class a
    implements Runnable
{

    final UICImageView a;

    public void run()
    {
        if (UICImageView.a(a) == null)
        {
            return;
        } else
        {
            f.b().a(UICImageView.b(a), UICImageView.a(a), a);
            return;
        }
    }

    (UICImageView uicimageview)
    {
        a = uicimageview;
        super();
    }
}
