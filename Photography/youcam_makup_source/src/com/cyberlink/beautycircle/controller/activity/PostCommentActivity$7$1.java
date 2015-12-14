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
//            PostCommentActivity, k

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
        PostCommentActivity postcommentactivity = e.e;
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
        PostCommentActivity.a(postcommentactivity, textview, date, flag, c, d);
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

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/PostCommentActivity$7

/* anonymous class */
    class PostCommentActivity._cls7
        implements b
    {

        final TextView a;
        final PostCommentActivity b;

        public void a()
        {
            Globals.b("getAccountToken Fail");
        }

        public void a(String s)
        {
            k k1 = (k)a.getTag();
            Date date = k1.a;
            boolean flag = k1.b;
            long l = k1.c;
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
            l2 = k1.d;
            b.runOnUiThread(new PostCommentActivity._cls7._cls1(this, date, flag, l + l1, l2));
            if (flag)
            {
                NetworkPost.b(s, "Comment", l2);
            } else
            {
                NetworkPost.a(s, "Comment", l2);
            }
            t.d.a();
            b.setResult(-1);
        }

        public void b()
        {
            Globals.b("getAccountToken Cancel");
        }

            
            {
                b = postcommentactivity;
                a = textview;
                super();
            }
    }

}
