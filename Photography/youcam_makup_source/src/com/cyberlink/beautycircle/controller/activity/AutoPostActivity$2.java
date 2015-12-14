// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleBasic;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.view.widgetpool.common.g;
import java.util.TreeSet;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            AutoPostActivity

class a
    implements g
{

    final AutoPostActivity a;

    public void a()
    {
        com.cyberlink.beautycircle.c.a(a, null, Boolean.valueOf(false));
    }

    public void a(int i)
    {
        if (i == 32769)
        {
            DialogUtils.a(a, null, a.getResources().getString(m.bc_write_post_message_must_sign_in), null, null, a.getResources().getString(m.bc_dialog_button_ok), new Runnable() {

                final AutoPostActivity._cls2 a;

                public void run()
                {
                    com.cyberlink.beautycircle.controller.activity.AutoPostActivity.s(a.a);
                }

            
            {
                a = AutoPostActivity._cls2.this;
                super();
            }
            });
            return;
        } else
        {
            String s1 = (new StringBuilder()).append(a.getResources().getString(m.bc_register_error_network_unavailabe)).append(s.a(i)).toString();
            DialogUtils.a(a, null, s1, null, null, a.getResources().getString(m.bc_dialog_button_ok), new Runnable() {

                final AutoPostActivity._cls2 a;

                public void run()
                {
                    AutoPostActivity.t(a.a);
                }

            
            {
                a = AutoPostActivity._cls2.this;
                super();
            }
            });
            return;
        }
    }

    public void a(TreeSet treeset)
    {
        if (treeset == null || treeset.isEmpty())
        {
            return;
        } else
        {
            AutoPostActivity.a(a, (CircleBasic)treeset.first());
            AutoPostActivity.a(a, false, true);
            return;
        }
    }

    public void b()
    {
        a.k();
    }

    public void c()
    {
        a.l();
    }

    _cls2.a(AutoPostActivity autopostactivity)
    {
        a = autopostactivity;
        super();
    }
}
