// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more;

import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.bu;
import java.io.File;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.database.more:
//            DatabaseOpenHelper

class a
    implements bu
{

    final DatabaseOpenHelper a;

    public void a(List list)
    {
        bo.u();
        com.cyberlink.youcammakeup.database.more.DatabaseOpenHelper.a((new StringBuilder()).append(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a.b()).append(File.separator).append("makeup").toString(), com.cyberlink.youcammakeup.utility.Type.b);
    }

    (DatabaseOpenHelper databaseopenhelper)
    {
        a = databaseopenhelper;
        super();
    }
}
