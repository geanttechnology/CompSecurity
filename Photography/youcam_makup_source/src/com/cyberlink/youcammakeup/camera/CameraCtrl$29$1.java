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

class a
    implements Runnable
{

    final FragmentTransaction a;
    final eLoss b;

    public void run()
    {
        while (CameraCtrl.u(b.b) == null || ((BaseActivity)CameraCtrl.u(b.b)).b()) 
        {
            return;
        }
        a.replace(CameraCtrl.K(b.b), b.b);
        a.commitAllowingStateLoss();
    }

    ( , FragmentTransaction fragmenttransaction)
    {
        b = ;
        a = fragmenttransaction;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/camera/CameraCtrl$29

/* anonymous class */
    class CameraCtrl._cls29
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
            Globals.d(new CameraCtrl._cls29._cls1(this, fragmenttransaction));
        }

            
            {
                c = cameractrl;
                a = fragment;
                b = flag;
                super();
            }
    }

}
