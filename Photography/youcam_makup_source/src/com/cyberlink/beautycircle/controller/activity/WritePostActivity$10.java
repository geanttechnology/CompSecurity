// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.b;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            WritePostActivity

class a
    implements b
{

    final WritePostActivity a;

    public void a()
    {
        Globals.b("Get AccountToken Fail");
    }

    public void a(String s)
    {
        if (s != null)
        {
            DialogUtils.a(a, "", a.getResources().getString(m.bc_post_delete_confirm_text), a.getResources().getString(m.bc_post_cancel), null, a.getResources().getString(m.bc_post_delete), new Runnable(s) {

                final String a;
                final WritePostActivity._cls10 b;

                public void run()
                {
                    b.a.k();
                    NetworkPost.a(a, WritePostActivity.d(b.a)).a(new com.perfectcorp.utility.m(this) {

                        final _cls1 a;

                        protected void a()
                        {
                            a.b.a.l();
                        }

                        protected void a(int i)
                        {
                            a.b.a.l();
                            Globals.a(a.b.a.getResources().getString(m.bc_server_connect_fail));
                            e.e(new Object[] {
                                "DeletePost: ", Integer.valueOf(i)
                            });
                        }

                        protected void a(Void void1)
                        {
                            a.b.a.l();
                            t.b.a();
                            a.b.a.setResult(48257);
                            WritePostActivity.c(a.b.a);
                        }

                        protected void b(Object obj)
                        {
                            a((Void)obj);
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                }

            
            {
                b = WritePostActivity._cls10.this;
                a = s;
                super();
            }
            });
        }
    }

    public void b()
    {
        Globals.b("Get AccountToken Cancel");
    }

    _cls1.a(WritePostActivity writepostactivity)
    {
        a = writepostactivity;
        super();
    }
}
