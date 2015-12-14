// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            WritePostActivity

class a extends m
{

    final WritePostActivity a;

    protected void a()
    {
        e.b(new Object[] {
            "Requesting createPosts cancelled."
        });
        a.l();
        WritePostActivity.a(a, false);
    }

    protected void a(int i)
    {
        e.e(new Object[] {
            "Requesting createPosts error:", Integer.valueOf(i)
        });
        String s1 = (new StringBuilder()).append(a.getResources().getString(com.cyberlink.beautycircle.m.bc_write_post_message_create_post_fail)).append(s.a(i)).toString();
        DialogUtils.a(a, s1);
        a.l();
        WritePostActivity.a(a, false);
    }

    protected void a(com.cyberlink.beautycircle.model.network.stsResult stsresult)
    {
        e.b(new Object[] {
            "createPosts success"
        });
        a.a(com.cyberlink.beautycircle.m.bc_write_post_dialog_title, Float.valueOf(1.0F), WritePostActivity.x(a), new Runnable() {

            final WritePostActivity._cls4 a;

            public void run()
            {
                a.a.l();
                WritePostActivity.a(a.a, false);
                Globals.a(a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_write_post_success));
                t.b.a();
                WritePostActivity.b(a.a, true);
            }

            
            {
                a = WritePostActivity._cls4.this;
                super();
            }
        });
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.network.stsResult)obj);
    }

    _cls1.a(WritePostActivity writepostactivity)
    {
        a = writepostactivity;
        super();
    }
}
