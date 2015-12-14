// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.view.View;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.clflurry.YMKClicksSaveMyLookEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.MakeupMode;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ah

class a
    implements Runnable
{

    final iss a;

    public void run()
    {
        android.app.Activity activity = a.a.getActivity();
        if (activity instanceof EditViewActivity)
        {
            ah.h(a.a);
            ((EditViewActivity)activity).a(MakeupMode.a, BeautyMode.D, ah.d(a.a));
        }
        a.a.dismiss();
    }

    nager(nager nager)
    {
        a = nager;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/dialogs/ah$2

/* anonymous class */
    class ah._cls2
        implements android.view.View.OnClickListener
    {

        final ah a;

        public void onClick(View view)
        {
            b.a(new YMKClicksSaveMyLookEvent(com.cyberlink.youcammakeup.clflurry.YMKClicksSaveMyLookEvent.ButtonName.d));
            view = new ah._cls2._cls1(this);
            ah.i(a).post(view);
            StatusManager.j().a(-1, -1, -1, -1, -1, -1, 8, -1);
        }

            
            {
                a = ah1;
                super();
            }
    }

}
