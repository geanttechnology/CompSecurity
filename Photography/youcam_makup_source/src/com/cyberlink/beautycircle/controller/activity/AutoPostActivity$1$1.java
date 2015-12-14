// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.view.widgetpool.common.CirclePager;
import java.util.TreeSet;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            AutoPostActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        AutoPostActivity.a(a.a);
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/AutoPostActivity$1

/* anonymous class */
    class AutoPostActivity._cls1
        implements android.view.View.OnClickListener
    {

        final AutoPostActivity a;

        public void onClick(View view)
        {
            if (AccountManager.b() == null)
            {
                DialogUtils.a(a, null, a.getResources().getString(m.bc_write_post_message_must_sign_in), null, null, a.getResources().getString(m.bc_dialog_button_ok), new AutoPostActivity._cls1._cls1(this));
                return;
            }
            if (AutoPostActivity.b(a).getSelectedCircles().isEmpty())
            {
                DialogUtils.a(a, null, a.getResources().getString(m.bc_write_post_message_need_circle), null, null, a.getResources().getString(m.bc_dialog_button_ok), new AutoPostActivity._cls1._cls2());
                return;
            } else
            {
                AutoPostActivity.d(a).setVisibility(8);
                AutoPostActivity.e(a).setVisibility(0);
                AutoPostActivity.a(a, false, false);
                AutoPostActivity.f(a);
                return;
            }
        }

            
            {
                a = autopostactivity;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/AutoPostActivity$1$2

/* anonymous class */
        class AutoPostActivity._cls1._cls2
            implements Runnable
        {

            final AutoPostActivity._cls1 a;

            public void run()
            {
                AutoPostActivity.c(a.a);
            }

                    
                    {
                        a = AutoPostActivity._cls1.this;
                        super();
                    }
        }

    }

}
