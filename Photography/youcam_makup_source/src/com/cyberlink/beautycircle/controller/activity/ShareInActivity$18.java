// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.widget.TextView;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleBasic;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.view.widgetpool.common.CircleList;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.cyberlink.beautycircle.view.widgetpool.common.g;
import com.perfectcorp.utility.e;
import java.util.TreeSet;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInActivity

class a
    implements g
{

    final ShareInActivity a;

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

                final ShareInActivity._cls18 a;

                public void run()
                {
                    a.a.finish();
                }

            
            {
                a = ShareInActivity._cls18.this;
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

            final ShareInActivity._cls18 a;

            public void run()
            {
                a.a.finish();
            }

            
            {
                a = ShareInActivity._cls18.this;
                super();
            }
        });
    }

    public void a(TreeSet treeset)
    {
        ShareInActivity.a(a, treeset);
        if (!treeset.isEmpty())
        {
            CircleBasic circlebasic = (CircleBasic)treeset.first();
            if (circlebasic == null)
            {
                return;
            }
            StringBuilder stringbuilder = new StringBuilder(circlebasic.circleName);
            CircleBasic circlebasic1 = (CircleBasic)treeset.higher(circlebasic);
            if (circlebasic1 != null)
            {
                stringbuilder.append(", ").append(circlebasic1.circleName);
                if ((CircleBasic)treeset.higher(circlebasic1) != null)
                {
                    stringbuilder.append(", ...");
                }
            }
            if (com.cyberlink.beautycircle.controller.activity.ShareInActivity.g(a) != null)
            {
                com.cyberlink.beautycircle.controller.activity.ShareInActivity.g(a).setText(stringbuilder);
            }
            CircleList.a(ShareInActivity.h(a), circlebasic);
            ShareInActivity.h(a).setVisibility(0);
        } else
        {
            if (com.cyberlink.beautycircle.controller.activity.ShareInActivity.g(a) != null)
            {
                com.cyberlink.beautycircle.controller.activity.ShareInActivity.g(a).setText("");
            }
            ShareInActivity.h(a).setVisibility(4);
        }
        ShareInActivity.a(a, false);
        ShareInActivity.i(a);
    }

    public void b()
    {
    }

    public void c()
    {
    }

    _cls2.a(ShareInActivity shareinactivity)
    {
        a = shareinactivity;
        super();
    }
}
