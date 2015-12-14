// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.res.Resources;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleBasic;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.view.widgetpool.common.g;
import java.util.ArrayList;
import java.util.TreeSet;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            WritePostActivity

class a
    implements g
{

    final WritePostActivity a;

    public void a()
    {
        com.cyberlink.beautycircle.c.a(a, null, Boolean.valueOf(false));
    }

    public void a(int i)
    {
        if (i == 32769)
        {
            DialogUtils.a(a, a.getResources().getString(m.bc_sharein_dialog_title), a.getResources().getString(m.bc_write_post_message_must_sign_in), new Runnable() {

                final WritePostActivity._cls12 a;

                public void run()
                {
                    WritePostActivity.f(a.a);
                }

            
            {
                a = WritePostActivity._cls12.this;
                super();
            }
            });
            return;
        } else
        {
            String s1 = (new StringBuilder()).append(a.getResources().getString(m.bc_register_error_network_unavailabe)).append(s.a(i)).toString();
            DialogUtils.a(a, a.getResources().getString(m.bc_dialog_title_warning), s1, new Runnable() {

                final WritePostActivity._cls12 a;

                public void run()
                {
                    com.cyberlink.beautycircle.controller.activity.WritePostActivity.g(a.a);
                }

            
            {
                a = WritePostActivity._cls12.this;
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
            WritePostActivity.a(a, (CircleBasic)treeset.first());
            WritePostActivity.a(a, false, true);
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
        if (!WritePostActivity.h(a) && WritePostActivity.i(a).isEmpty())
        {
            WritePostActivity.j(a);
            Object obj = a.getIntent();
            if (obj != null)
            {
                String s1 = ((Intent) (obj)).getStringExtra("FilePath");
                if (s1 != null && !s1.isEmpty())
                {
                    ((com.cyberlink.beautycircle.controller.fragment.c)WritePostActivity.i(a).get(0)).a(s1);
                }
                obj = ((Intent) (obj)).getStringExtra("Content");
                if (obj != null)
                {
                    ((com.cyberlink.beautycircle.controller.fragment.c)WritePostActivity.i(a).get(0)).b(((String) (obj)));
                }
            }
        }
    }

    _cls2.a(WritePostActivity writepostactivity)
    {
        a = writepostactivity;
        super();
    }
}
