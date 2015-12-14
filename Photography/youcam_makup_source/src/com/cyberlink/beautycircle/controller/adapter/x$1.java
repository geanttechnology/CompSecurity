// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.view.View;
import com.cyberlink.beautycircle.BaseFbActivity;
import com.cyberlink.beautycircle.model.Post;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            x

class a
    implements android.view..OnClickListener
{

    final x a;

    public void onClick(View view)
    {
        if (a.c != null)
        {
            ((BaseFbActivity)a.c).a(view, (Post)view.getTag());
        }
    }

    (x x1)
    {
        a = x1;
        super();
    }
}
