// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more;

import android.widget.Toast;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.flurry.DatabaseUpgradeCrashEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.kernelctrl.z;

// Referenced classes of package com.cyberlink.youcammakeup.database.more:
//            DatabaseOpenHelper

class this._cls0 extends RuntimeException
{

    final DatabaseOpenHelper this$0;

    public ()
    {
        this$0 = DatabaseOpenHelper.this;
        super();
        databaseopenhelper = Toast.makeText(Globals.d(), "Database upgrade failed!", 1);
        if (DatabaseOpenHelper.b())
        {
            show();
            return;
        } else
        {
            a.a(new DatabaseUpgradeCrashEvent(z.v()));
            return;
        }
    }
}
