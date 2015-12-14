// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.b;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.cyberlink.youcammakeup.utility.bd;

// Referenced classes of package com.cyberlink.youcammakeup.b:
//            h

class b
    implements Runnable
{

    final String a;
    final Activity b;
    final h c;

    public void run()
    {
        if ("$LinkToUStore".equalsIgnoreCase(a))
        {
            bd.a(b, "com.cyberlink.U", "ymk", "bigbangsharedialog");
            return;
        } else
        {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(a));
            b.startActivity(intent);
            return;
        }
    }

    y.bd(h h1, String s, Activity activity)
    {
        c = h1;
        a = s;
        b = activity;
        super();
    }
}
