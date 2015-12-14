// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.ShareInXmlParser;
import com.cyberlink.beautycircle.utility.b;
import com.cyberlink.beautycircle.view.widgetpool.common.CircleList;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInActivity

class a
    implements Runnable
{

    final ViewById a;

    public void run()
    {
        ShareInActivity.a(a.a).a(true);
        ShareInActivity.a(a.a, new WebView(a.a));
        android.view.ms ms = new android.view.ms(1920, 1080);
        com.cyberlink.beautycircle.controller.activity.ShareInActivity.b(a.a).setLayoutParams(ms);
        ((ViewGroup)a.a.findViewById(j.bc_sharein_background)).addView(com.cyberlink.beautycircle.controller.activity.ShareInActivity.b(a.a));
        com.cyberlink.beautycircle.controller.activity.ShareInActivity.b(a.a).setTranslationY(-1080F);
        ShareInActivity.a(a.a, new ShareInXmlParser(a.a, a.a, com.cyberlink.beautycircle.controller.activity.ShareInActivity.b(a.a)));
        ShareInActivity.d(a.a).a(ShareInActivity.c(a.a), false);
        a.a.findViewById(j.no_image_loading_cursor).setVisibility(0);
        a.a.findViewById(j.image_loading_cursor).setVisibility(0);
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/ShareInActivity$1

/* anonymous class */
    class ShareInActivity._cls1
        implements b
    {

        final ShareInActivity a;

        public void a()
        {
            a.runOnUiThread(new ShareInActivity._cls1._cls2());
        }

        public void a(String s)
        {
            a.runOnUiThread(new ShareInActivity._cls1._cls1(this));
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

        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/ShareInActivity$1$2

/* anonymous class */
        class ShareInActivity._cls1._cls2
            implements Runnable
        {

            final ShareInActivity._cls1 a;

            public void run()
            {
                DialogUtils.a(a.a, a.a.getString(m.bc_sharein_dialog_title), a.a.getString(m.bc_user_log_in_description), new ShareInActivity._cls1._cls2._cls1(this));
            }

                    
                    {
                        a = ShareInActivity._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/ShareInActivity$1$2$1

/* anonymous class */
        class ShareInActivity._cls1._cls2._cls1
            implements Runnable
        {

            final ShareInActivity._cls1._cls2 a;

            public void run()
            {
                a.a.a.finish();
            }

                    
                    {
                        a = _pcls2;
                        super();
                    }
        }

    }

}
