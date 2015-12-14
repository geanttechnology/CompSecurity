// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.graphics.Bitmap;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.d.a;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            CircleList, UICImageView

final class b
    implements a
{

    final UICImageView a;
    final String b;

    public void a(String s, View view)
    {
    }

    public void a(String s, View view, Bitmap bitmap)
    {
    }

    public void a(String s, View view, FailReason failreason)
    {
        a.setImageURI(null);
        if (e.a)
        {
            e.e(new Object[] {
                s
            });
            a.a(com.cyberlink.beautycircle.view.widgetpool.common.CircleList.a("!"));
            return;
        } else
        {
            a.a(com.cyberlink.beautycircle.view.widgetpool.common.CircleList.a(b));
            return;
        }
    }

    public void b(String s, View view)
    {
        a(s, view, ((FailReason) (null)));
    }

    (UICImageView uicimageview, String s)
    {
        a = uicimageview;
        b = s;
        super();
    }
}
