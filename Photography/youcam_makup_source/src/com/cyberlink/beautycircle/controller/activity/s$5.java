// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.UserInfo;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            s

class a
    implements android.view..OnClickListener
{

    final s a;

    public void onClick(View view)
    {
        view = (UserInfo)view.getTag();
        if (view == null)
        {
            return;
        } else
        {
            c.a(a.e, ((UserInfo) (view)).id, com.cyberlink.beautycircle.model.bItem.MeListMode.a);
            return;
        }
    }

    de(s s1)
    {
        a = s1;
        super();
    }
}
