// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.CompletePost;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            WritePostActivity

class a extends m
{

    final WritePostActivity a;

    protected void a()
    {
        a(0x80000005);
    }

    protected void a(int i)
    {
        a.l();
        String s = a.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_title_error);
        String s1 = a.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_message_post_not_existed);
        DialogUtils.a(Globals.d, s, s1, new Runnable() {

            final WritePostActivity._cls8 a;

            public void run()
            {
                WritePostActivity.a(a.a);
            }

            
            {
                a = WritePostActivity._cls8.this;
                super();
            }
        });
    }

    protected void a(CompletePost completepost)
    {
        if (completepost != null)
        {
            WritePostActivity.a(a, completepost);
            WritePostActivity.a(a, completepost, true);
        }
    }

    protected void b(Object obj)
    {
        a((CompletePost)obj);
    }

    _cls1.a(WritePostActivity writepostactivity)
    {
        a = writepostactivity;
        super();
    }
}
