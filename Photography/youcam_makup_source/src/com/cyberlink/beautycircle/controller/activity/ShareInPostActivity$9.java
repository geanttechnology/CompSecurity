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
import com.perfectcorp.utility.e;
import java.util.TreeSet;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInPostActivity

class a
    implements g
{

    final ShareInPostActivity a;

    public void a()
    {
        com.cyberlink.beautycircle.c.a(a, null, Boolean.valueOf(false));
    }

    public void a(int i)
    {
        switch (i)
        {
        default:
            String s1 = (new StringBuilder()).append(a.getResources().getString(m.bc_register_error_network_unavailabe)).append(s.a(i)).toString();
            DialogUtils.a(a, a.getResources().getString(m.bc_dialog_title_warning), s1, new Runnable() {

                final ShareInPostActivity._cls9 a;

                public void run()
                {
                    a.a.finish();
                }

            
            {
                a = ShareInPostActivity._cls9.this;
                super();
            }
            });
            return;

        case 32769: 
            e.e(new Object[] {
                "Not logged in"
            });
            break;
        }
        DialogUtils.a(a, a.getResources().getString(m.bc_sharein_dialog_title), a.getResources().getString(m.bc_write_post_message_must_sign_in), new Runnable() {

            final ShareInPostActivity._cls9 a;

            public void run()
            {
                a.a.finish();
            }

            
            {
                a = ShareInPostActivity._cls9.this;
                super();
            }
        });
    }

    public void a(TreeSet treeset)
    {
        if (treeset.isEmpty())
        {
            ShareInPostActivity.a(a, null);
            return;
        } else
        {
            ShareInPostActivity.a(a, (CircleBasic)treeset.first());
            ShareInPostActivity.d(a);
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

    _cls2.a(ShareInPostActivity shareinpostactivity)
    {
        a = shareinpostactivity;
        super();
    }
}
