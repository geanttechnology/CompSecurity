// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.view.View;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ab, ah, aa

class a
    implements ab
{

    final n a;

    public void a()
    {
        Object obj;
        byte byte0;
        if (ah.d(a.a) == null)
        {
            long l = StatusManager.j().l();
            MotionControlHelper.e().b(StatusManager.j().f(l));
        }
        a.a.dismissAllowingStateLoss();
        obj = StatusManager.j().r();
        byte0 = 0;
        if (obj != MakeupMode.a) goto _L2; else goto _L1
_L1:
        byte byte1;
        byte1 = 8;
        obj = a.a.getActivity();
        byte0 = byte1;
        if (!(obj instanceof EditViewActivity)) goto _L2; else goto _L3
_L3:
        if (ah.d(a.a) == null) goto _L5; else goto _L4
_L4:
        ((EditViewActivity)obj).a(MakeupMode.a, BeautyMode.D, ah.d(a.a));
        byte0 = byte1;
_L2:
        StatusManager.j().a(-1, -1, -1, -1, -1, -1, byte0, -1);
        return;
_L5:
        byte0 = byte1;
        if (ah.e(a.a).isEnabled())
        {
            ((EditViewActivity)obj).n();
            byte0 = byte1;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    ntrolHelper(ntrolHelper ntrolhelper)
    {
        a = ntrolhelper;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/dialogs/ah$9

/* anonymous class */
    class ah._cls9
        implements Runnable
    {

        final ah a;

        public void run()
        {
            o.a(a.getActivity());
            aa aa1 = new aa(a.getActivity());
            aa1.a(new ah._cls9._cls1(this));
            aa1.show();
        }

            
            {
                a = ah1;
                super();
            }
    }

}
