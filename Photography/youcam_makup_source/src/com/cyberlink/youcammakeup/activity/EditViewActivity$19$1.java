// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.DialogInterface;
import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKManualEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.IntroDialogUtils;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class a
    implements android.content.issListener
{

    final a a;

    public void onDismiss(DialogInterface dialoginterface)
    {
        a.a.Y();
        EditViewActivity.g(a.a, false);
        com.cyberlink.youcammakeup.activity.EditViewActivity.b(a.a).setClickable(true);
    }

    l.BeautyToolPanel(l.BeautyToolPanel beautytoolpanel)
    {
        a = beautytoolpanel;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/EditViewActivity$19

/* anonymous class */
    class EditViewActivity._cls19
        implements android.view.View.OnClickListener
    {

        final EditViewActivity a;
        private android.content.DialogInterface.OnDismissListener b;

        public void onClick(View view)
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKManualEvent(com.cyberlink.youcammakeup.clflurry.YMKManualEvent.HintButton.a, com.cyberlink.youcammakeup.clflurry.YMKManualEvent.Operation.b));
            while (!StatusManager.j().E().booleanValue() || IntroDialogUtils.a(StatusManager.j().s()) == null && StatusManager.j().r() != MakeupMode.a || EditViewActivity.C(a)) 
            {
                return;
            }
            EditViewActivity.g(a, true);
            com.cyberlink.youcammakeup.activity.EditViewActivity.b(a).setClickable(false);
            a.X();
            if (b == null)
            {
                b = new EditViewActivity._cls19._cls1(this);
            }
            view = StatusManager.j().s();
            if (EditViewActivity.D(a) != null && view == BeautyMode.v || view == BeautyMode.r || view == BeautyMode.s || view == BeautyMode.b || view == BeautyMode.a || view == BeautyMode.m || view == BeautyMode.l)
            {
                view = IntroDialogUtils.a(view, ((BeautyToolPanel)EditViewActivity.D(a)).C(), false);
                IntroDialogUtils.b(a.getFragmentManager(), b, null, view, false);
            } else
            if (EditViewActivity.D(a) != null && view == BeautyMode.y)
            {
                view = IntroDialogUtils.a(view, false, ((BeautyToolPanel)EditViewActivity.D(a)).Q());
                IntroDialogUtils.b(a.getFragmentManager(), b, null, view, false);
            } else
            {
                IntroDialogUtils.a(a.getFragmentManager(), b, null);
            }
            StatusManager.j().R();
        }

            
            {
                a = editviewactivity;
                super();
            }
    }

}
