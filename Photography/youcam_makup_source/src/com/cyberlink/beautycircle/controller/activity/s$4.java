// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.CircleDetail;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            s

class a
    implements android.view..OnClickListener
{

    final s a;

    public void onClick(View view)
    {
        view = (CircleDetail)view.getTag();
        if (view == null)
        {
            return;
        } else
        {
            c.a(a.e, ((CircleDetail) (view)).circleCreatorId, ((CircleDetail) (view)).id);
            return;
        }
    }

    (s s1)
    {
        a = s1;
        super();
    }
}
