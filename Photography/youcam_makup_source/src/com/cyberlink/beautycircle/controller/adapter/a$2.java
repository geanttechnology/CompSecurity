// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.view.View;
import com.cyberlink.beautycircle.model.Post;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            a

class a
    implements android.view..OnClickListener
{

    final a a;

    public void onClick(View view)
    {
        view = (Post)view.getTag();
        a.a(view);
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
