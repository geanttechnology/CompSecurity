// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.net.Uri;
import android.view.View;
import com.cyberlink.beautycircle.c;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInActivity

class a
    implements android.view.stener
{

    final ShareInActivity a;

    public boolean onLongClick(View view)
    {
        c.a(a, Uri.parse(com.cyberlink.beautycircle.controller.activity.ShareInActivity.c(a)));
        return false;
    }

    (ShareInActivity shareinactivity)
    {
        a = shareinactivity;
        super();
    }
}
