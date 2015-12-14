// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            CirclePager, g

class a
    implements android.view.stener
{

    final CirclePager a;

    public void onClick(View view)
    {
        if (CirclePager.d(a) != null)
        {
            CirclePager.d(a).a();
        }
    }

    (CirclePager circlepager)
    {
        a = circlepager;
        super();
    }
}
