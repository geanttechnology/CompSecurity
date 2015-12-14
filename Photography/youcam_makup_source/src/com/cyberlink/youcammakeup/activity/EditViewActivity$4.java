// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.masteraccess.b;
import com.cyberlink.youcammakeup.masteraccess.c;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class a
    implements c
{

    final EditViewActivity a;

    public void a()
    {
        m.e("notifyByInsertFirst", "onCancel");
    }

    public void a(com.cyberlink.youcammakeup.masteraccess. )
    {
        m.e("notifyByInsertFirst", "onError");
    }

    public void a(b b1)
    {
        m.c("notifyByInsertFirst", "onComplete");
        StatusManager.j().a(b1.a(), EditViewActivity.a);
        a.runOnUiThread(new Runnable() {

            final EditViewActivity._cls4 a;

            public void run()
            {
                a.a.D();
            }

            
            {
                a = EditViewActivity._cls4.this;
                super();
            }
        });
    }

    _cls1.a(EditViewActivity editviewactivity)
    {
        a = editviewactivity;
        super();
    }
}
