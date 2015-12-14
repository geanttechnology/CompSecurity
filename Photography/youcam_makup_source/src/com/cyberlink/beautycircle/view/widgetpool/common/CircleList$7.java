// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.graphics.Bitmap;
import android.view.View;
import com.cyberlink.beautycircle.model.CircleBasic;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.d.a;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            CircleList, UICImageView

final class b
    implements a
{

    final CircleBasic a;
    final UICImageView b;

    public void a(String s, View view)
    {
    }

    public void a(String s, View view, Bitmap bitmap)
    {
    }

    public void a(String s, View view, FailReason failreason)
    {
        a.iconUrl = null;
        if (e.a)
        {
            e.e(new Object[] {
                s
            });
            a.iconBmp = com.cyberlink.beautycircle.view.widgetpool.common.CircleList.a("!");
        } else
        {
            a.iconBmp = com.cyberlink.beautycircle.view.widgetpool.common.CircleList.a(a.circleName);
        }
        b.setImageURI(null);
        b.a(a.iconBmp);
    }

    public void b(String s, View view)
    {
        a(s, view, ((FailReason) (null)));
    }

    (CircleBasic circlebasic, UICImageView uicimageview)
    {
        a = circlebasic;
        b = uicimageview;
        super();
    }
}
