// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.net.Uri;
import android.widget.TextView;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleBasic;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.b;
import com.cyberlink.beautycircle.view.widgetpool.common.g;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.l;
import java.util.TreeSet;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        a.a.a.finish();
    }

    Param(Param param)
    {
        a = param;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/ShareInActivity$12

/* anonymous class */
    class ShareInActivity._cls12
        implements b
    {

        final ShareInActivity a;

        public void a()
        {
            a.runOnUiThread(new ShareInActivity._cls12._cls3(this));
        }

        public void a(String s)
        {
            ShareInActivity.a(a, Float.valueOf(0.0F));
            ShareInActivity.a(a, ShareInActivity.f(a).categoryType).a(new ShareInActivity._cls12._cls1());
            s = (TextView)a.findViewById(com.cyberlink.beautycircle.j.title);
            TextView textview = (TextView)a.findViewById(com.cyberlink.beautycircle.j.description);
            a.runOnUiThread(new ShareInActivity._cls12._cls2(s, textview));
        }

        public void b()
        {
            e.b(new Object[] {
                "Sign in abort"
            });
            a.finish();
        }

            
            {
                a = shareinactivity;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/ShareInActivity$12$1

/* anonymous class */
        class ShareInActivity._cls12._cls1 extends l
        {

            final ShareInActivity._cls12 a;

            protected void a()
            {
                a.a.l();
                super.a();
            }

            protected void a(int i)
            {
                a.a.l();
                ShareInActivity.a(a.a, m.bc_write_post_message_create_post_fail, null);
                super.a(i);
            }

            protected void a(CircleBasic circlebasic)
            {
                if (circlebasic == null)
                {
                    b(0x80000003);
                    return;
                }
                TreeSet treeset = new TreeSet();
                treeset.add(circlebasic);
                com.cyberlink.beautycircle.controller.activity.ShareInActivity.e(a.a).a(treeset);
                if (ShareInActivity.f(a.a).imageUri != null)
                {
                    circlebasic = Uri.parse(ShareInActivity.f(a.a).imageUri);
                } else
                {
                    circlebasic = null;
                }
                if (circlebasic != null)
                {
                    ShareInActivity.a(a.a, Float.valueOf(0.125F));
                    ShareInActivity.a(a.a, circlebasic);
                    return;
                } else
                {
                    a.a.l();
                    b(0x80000003);
                    return;
                }
            }

            protected void b(Object obj)
            {
                a((CircleBasic)obj);
            }

                    
                    {
                        a = ShareInActivity._cls12.this;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/ShareInActivity$12$2

/* anonymous class */
        class ShareInActivity._cls12._cls2
            implements Runnable
        {

            final TextView a;
            final TextView b;
            final ShareInActivity._cls12 c;

            public void run()
            {
                a.setText(ShareInActivity.f(c.a).title);
                b.setText(ShareInActivity.f(c.a).description);
            }

                    
                    {
                        c = ShareInActivity._cls12.this;
                        a = textview;
                        b = textview1;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/ShareInActivity$12$3

/* anonymous class */
    class ShareInActivity._cls12._cls3
        implements Runnable
    {

        final ShareInActivity._cls12 a;

        public void run()
        {
            DialogUtils.a(a.a, a.a.getString(m.bc_sharein_dialog_title), a.a.getString(m.bc_user_log_in_description), new ShareInActivity._cls12._cls3._cls1(this));
        }

            
            {
                a = _pcls12;
                super();
            }
    }

}
