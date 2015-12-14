// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.BCTileImage;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        BCTileImage.b(g.a(a.a));
    }

    ource(ource ource)
    {
        a = ource;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/g$35

/* anonymous class */
    class g._cls35
        implements b
    {

        final g a;

        public void a()
        {
            Globals.b("Get AccountToken Fail");
        }

        public void a(String s)
        {
            if (s != null)
            {
                com.cyberlink.beautycircle.utility.DialogUtils.ReportSource reportsource1 = com.cyberlink.beautycircle.utility.DialogUtils.ReportSource.a;
                com.cyberlink.beautycircle.utility.DialogUtils.ReportSource reportsource = reportsource1;
                if (g.a(a) != null)
                {
                    reportsource = reportsource1;
                    if ("contest".equals(g.a(a).postSource))
                    {
                        reportsource = com.cyberlink.beautycircle.utility.DialogUtils.ReportSource.c;
                    }
                }
                DialogUtils.a(a.b, s, "Post", com.cyberlink.beautycircle.controller.activity.g.b(a), reportsource, new g._cls35._cls1(this));
            }
        }

        public void b()
        {
            Globals.b("Get AccountToken Cancel");
        }

            
            {
                a = g1;
                super();
            }
    }

}
