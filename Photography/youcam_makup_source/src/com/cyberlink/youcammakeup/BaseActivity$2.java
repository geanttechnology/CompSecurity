// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup;

import android.os.Process;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.utility.r;

// Referenced classes of package com.cyberlink.youcammakeup:
//            BaseActivity, Globals

class a
    implements Runnable
{

    final String a;
    final BaseActivity b;

    public void run()
    {
        Globals.d().i().a(new r() {

            final BaseActivity._cls2 a;

            public void a()
            {
                Globals.d().H();
                a.b.finish();
                Process.killProcess(Process.myPid());
            }

            
            {
                a = BaseActivity._cls2.this;
                super();
            }
        });
        Globals.d().i().a(b, null, a, true);
    }

    _cls1.a(BaseActivity baseactivity, String s)
    {
        b = baseactivity;
        a = s;
        super();
    }
}
