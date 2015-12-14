// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class b
    implements Runnable
{

    final Fragment a;
    final boolean b;
    final CameraCtrl c;

    public void run()
    {
        CameraCtrl.a(c, a);
        FragmentTransaction fragmenttransaction = CameraCtrl.u(c).getFragmentManager().beginTransaction();
        if (b)
        {
            fragmenttransaction.setCustomAnimations(0x7f04001f, 0);
        }
        Globals.d(new Runnable(fragmenttransaction) {

            final FragmentTransaction a;
            final CameraCtrl._cls29 b;

            public void run()
            {
                while (CameraCtrl.u(b.c) == null || ((BaseActivity)CameraCtrl.u(b.c)).b()) 
                {
                    return;
                }
                a.replace(CameraCtrl.K(b.c), b.a);
                a.commitAllowingStateLoss();
            }

            
            {
                b = CameraCtrl._cls29.this;
                a = fragmenttransaction;
                super();
            }
        });
    }

    _cls1.a(CameraCtrl cameractrl, Fragment fragment, boolean flag)
    {
        c = cameractrl;
        a = fragment;
        b = flag;
        super();
    }
}
