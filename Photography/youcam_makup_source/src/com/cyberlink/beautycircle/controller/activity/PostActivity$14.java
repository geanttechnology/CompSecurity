// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.utility.b;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import java.util.Date;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PostActivity, h

class a
    implements b
{

    final TextView a;
    final PostActivity b;

    public void a()
    {
        Globals.b("getAccountToken Fail");
    }

    public void a(String s)
    {
        h h1 = (h)a.getTag();
        Date date = h1.a;
        boolean flag = h1.b;
        long l = h1.c;
        int i;
        long l1;
        long l2;
        if (flag)
        {
            i = -1;
        } else
        {
            i = 1;
        }
        l1 = i;
        l2 = h1.d;
        b.runOnUiThread(new Runnable(date, flag, l + l1, l2) {

            final Date a;
            final boolean b;
            final long c;
            final long d;
            final PostActivity._cls14 e;

            public void run()
            {
                PostActivity postactivity = e.b;
                TextView textview = e.a;
                Date date1 = a;
                boolean flag1;
                if (!b)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                PostActivity.a(postactivity, textview, date1, flag1, c, d);
            }

            
            {
                e = PostActivity._cls14.this;
                a = date;
                b = flag;
                c = l;
                d = l1;
                super();
            }
        });
        if (flag)
        {
            NetworkPost.b(s, "Comment", l2);
        } else
        {
            NetworkPost.a(s, "Comment", l2);
        }
        t.d.a();
    }

    public void b()
    {
        Globals.b("getAccountToken Cancel");
    }

    _cls1.d(PostActivity postactivity, TextView textview)
    {
        b = postactivity;
        a = textview;
        super();
    }
}
