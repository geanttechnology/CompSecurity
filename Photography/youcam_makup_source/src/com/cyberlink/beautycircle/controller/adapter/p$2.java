// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.net.Uri;
import android.view.View;
import com.cyberlink.beautycircle.controller.a.f;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.g;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            p

class a
    implements android.view..OnClickListener
{

    final Uri a;
    final p b;

    public void onClick(View view)
    {
        com.perfectcorp.a.b.a(new f("more_info", a.getQueryParameter("SkuType"), a.getQueryParameter("SkuGuid"), a.getQueryParameter("SkuItemGuid")));
        g.a(p.a(b), a);
    }

    (p p1, Uri uri)
    {
        b = p1;
        a = uri;
        super();
    }
}
