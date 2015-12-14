// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.view.View;
import com.cyberlink.beautycircle.model.CircleBasic;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            CirclePager, CircleList

class a
    implements android.view.stener
{

    final CirclePager a;

    public void onClick(View view)
    {
        if (!view.isSelected())
        {
            CirclePager.a(a, view, (CircleBasic)view.getTag(), true, true, false);
            CircleList.a(CirclePager.h(a));
        }
    }

    (CirclePager circlepager)
    {
        a = circlepager;
        super();
    }
}
