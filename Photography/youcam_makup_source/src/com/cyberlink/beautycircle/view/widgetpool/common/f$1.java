// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            f, CircleList, g

class a
    implements android.view..OnClickListener
{

    final f a;

    public void onClick(View view)
    {
        if (CircleList.e(a.a) != null)
        {
            CircleList.e(a.a).a();
        }
    }

    leList(f f1)
    {
        a = f1;
        super();
    }
}
