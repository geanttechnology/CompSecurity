// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.net.Uri;
import android.view.View;
import com.perfectcorp.utility.g;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g

class a
    implements android.view..OnClickListener
{

    final Uri a;
    final com.cyberlink.beautycircle.controller.activity.g b;

    public void onClick(View view)
    {
        g.a(b.b, a);
    }

    (com.cyberlink.beautycircle.controller.activity.g g1, Uri uri)
    {
        b = g1;
        a = uri;
        super();
    }
}
