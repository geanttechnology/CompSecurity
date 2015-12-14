// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup;

import android.os.Process;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.utility.r;

// Referenced classes of package com.cyberlink.youcammakeup:
//            Globals, BaseActivity

class a
    implements r
{

    final sh a;

    public void a()
    {
        Globals.d().H();
        a.a.finish();
        Process.killProcess(Process.myPid());
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/BaseActivity$2

/* anonymous class */
    class BaseActivity._cls2
        implements Runnable
    {

        final String a;
        final BaseActivity b;

        public void run()
        {
            Globals.d().i().a(new BaseActivity._cls2._cls1(this));
            Globals.d().i().a(b, null, a, true);
        }

            
            {
                b = baseactivity;
                a = s;
                super();
            }
    }

}
