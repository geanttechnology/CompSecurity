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

class d
    implements Runnable
{

    final Date a;
    final boolean b;
    final long c;
    final long d;
    final d e;

    public void run()
    {
        PostActivity postactivity = e.e;
        TextView textview = e.e;
        Date date = a;
        boolean flag;
        if (!b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        PostActivity.a(postactivity, textview, date, flag, c, d);
    }

    ( , Date date, boolean flag, long l, long l1)
    {
        e = ;
        a = date;
        b = flag;
        c = l;
        d = l1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/PostActivity$14

/* anonymous class */
    class PostActivity._cls14
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
            b.runOnUiThread(new PostActivity._cls14._cls1(this, date, flag, l + l1, l2));
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

            
            {
                b = postactivity;
                a = textview;
                super();
            }
    }

}
