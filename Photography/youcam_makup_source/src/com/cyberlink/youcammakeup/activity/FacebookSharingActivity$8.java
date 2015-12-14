// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.Activity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            FacebookSharingActivity

class a
    implements l
{

    final FacebookSharingActivity a;

    public void a(a a1)
    {
    }

    public void a(bn bn1)
    {
        if (bn1 == null);
    }

    public volatile void a(Object obj)
    {
        a((String)obj);
    }

    public void a(String s)
    {
        Activity activity = Globals.d().a(com.cyberlink.youcammakeup.tivity._fld8);
        if (activity == null)
        {
            return;
        } else
        {
            activity.runOnUiThread(new Runnable(s) {

                final String a;
                final FacebookSharingActivity._cls8 b;

                public void run()
                {
                    com.cyberlink.youcammakeup.activity.FacebookSharingActivity.a(b.a, a);
                }

            
            {
                b = FacebookSharingActivity._cls8.this;
                a = s;
                super();
            }
            });
            return;
        }
    }

    public void a(Void void1)
    {
    }

    public void b(Object obj)
    {
        a((bn)obj);
    }

    public void c(Object obj)
    {
        a((Void)obj);
    }

    public void d(Object obj)
    {
        a((a)obj);
    }

    _cls1.a(FacebookSharingActivity facebooksharingactivity)
    {
        a = facebooksharingactivity;
        super();
    }
}
