// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.Activity;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.makeup.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.n;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.p;
import com.pf.common.utility.m;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            ExtraDownloadActivity

class a
    implements Runnable
{

    final String a;
    final a b;

    public void run()
    {
        ExtraDownloadActivity.c(b.b).setText(a);
    }

    ( , String s)
    {
        b = ;
        a = s;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/ExtraDownloadActivity$8

/* anonymous class */
    class ExtraDownloadActivity._cls8
        implements p
    {

        final ExtraDownloadActivity a;

        public void a(bn bn1)
        {
            if (bn1 != null)
            {
                m.b("ExtraDownloadActivity", (new StringBuilder()).append("[GetCategoryTask] error ").append(bn1.toString()).toString());
            }
        }

        public void a(n n1)
        {
            if (n1 != null && n1.a() != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            n1 = n1.a().iterator();
_L5:
            if (!n1.hasNext()) goto _L1; else goto _L3
_L3:
            a a1 = (a)n1.next();
            if (Long.valueOf(a1.a()).longValue() != ExtraDownloadActivity.b(a)) goto _L5; else goto _L4
_L4:
            Activity activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.c);
            if (activity == null) goto _L1; else goto _L6
_L6:
            activity.runOnUiThread(new ExtraDownloadActivity._cls8._cls1(this, a1.b()));
              goto _L5
        }

        public volatile void a(Object obj)
        {
            a((n)obj);
        }

        public void a(Void void1)
        {
            m.b("ExtraDownloadActivity", "[GetCategoryTask] cancel");
        }

        public void b(Object obj)
        {
            a((bn)obj);
        }

        public void c(Object obj)
        {
            a((Void)obj);
        }

            
            {
                a = extradownloadactivity;
                super();
            }
    }

}
