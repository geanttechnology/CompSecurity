// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.view.View;
import com.cyberlink.beautycircle.model.CircleBasic;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            f, CircleList

class a
    implements android.view..OnClickListener
{

    final f a;

    public void onClick(View view)
    {
        CircleList.a(a.a, (CircleBasic)view.getTag());
    }

    leList(f f1)
    {
        a = f1;
        super();
    }
}
