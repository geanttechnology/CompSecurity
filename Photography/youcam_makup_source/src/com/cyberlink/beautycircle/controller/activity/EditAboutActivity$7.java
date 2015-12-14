// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import com.cyberlink.beautycircle.utility.AccountManager;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            EditAboutActivity

class a
    implements Runnable
{

    final int a;
    final EditAboutActivity b;

    public void run()
    {
        Intent intent = new Intent();
        b.setResult(a, intent);
        EditAboutActivity.i(b);
        AccountManager.d(AccountManager.b());
    }

    (EditAboutActivity editaboutactivity, int i)
    {
        b = editaboutactivity;
        a = i;
        super();
    }
}
