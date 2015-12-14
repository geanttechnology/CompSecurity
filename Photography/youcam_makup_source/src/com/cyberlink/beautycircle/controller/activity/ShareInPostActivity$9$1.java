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
    implements Runnable
{

    final sh a;

    public void run()
    {
        a.a.finish();
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/ShareInPostActivity$9

/* anonymous class */
    class ShareInPostActivity._cls9
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
                DialogUtils.a(a, a.getResources().getString(m.bc_dialog_title_warning), s1, new ShareInPostActivity._cls9._cls2());
                return;

            case 32769: 
                e.e(new Object[] {
                    "Not logged in"
                });
                break;
            }
            DialogUtils.a(a, a.getResources().getString(m.bc_sharein_dialog_title), a.getResources().getString(m.bc_write_post_message_must_sign_in), new ShareInPostActivity._cls9._cls1(this));
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

            
            {
                a = shareinpostactivity;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/ShareInPostActivity$9$2

/* anonymous class */
        class ShareInPostActivity._cls9._cls2
            implements Runnable
        {

            final ShareInPostActivity._cls9 a;

            public void run()
            {
                a.a.finish();
            }

                    
                    {
                        a = ShareInPostActivity._cls9.this;
                        super();
                    }
        }

    }

}
