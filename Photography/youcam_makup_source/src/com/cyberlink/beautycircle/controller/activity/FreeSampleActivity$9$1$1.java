// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.Dialog;
import android.content.res.Resources;
import android.view.View;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.q;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            FreeSampleActivity

class a extends m
{

    final a a;

    protected void a(int i)
    {
        super.a(i);
        e.b(new Object[] {
            "Follow userId=", FreeSampleActivity.a(a.a.a).dId, " fail: ", Integer.valueOf(i)
        });
        String s = a.a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_follow_fail);
        Globals.a(String.format(Locale.getDefault(), s, new Object[] {
            com.cyberlink.beautycircle.controller.activity.FreeSampleActivity.e(a.a.a).displayName
        }));
    }

    public void a(Void void1)
    {
        e.b(new Object[] {
            "Follow userId=", FreeSampleActivity.a(a.a.a).dId, " success"
        });
        void1 = a.a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_follow_success);
        Globals.a(String.format(Locale.getDefault(), void1, new Object[] {
            com.cyberlink.beautycircle.controller.activity.FreeSampleActivity.e(a.a.a).displayName
        }));
        a.a.a.dismiss();
        c.a(a.a.a, FreeSampleActivity.a(a.a.a));
    }

    public void b(Object obj)
    {
        a((Void)obj);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/FreeSampleActivity$9

/* anonymous class */
    class FreeSampleActivity._cls9
        implements android.view.View.OnClickListener
    {

        final Dialog a;
        final FreeSampleActivity b;

        public void onClick(View view)
        {
            (new FreeSampleActivity._cls9._cls2()).d(null).a(new FreeSampleActivity._cls9._cls1(this));
        }

            
            {
                b = freesampleactivity;
                a = dialog;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/FreeSampleActivity$9$2

/* anonymous class */
        class FreeSampleActivity._cls9._cls2 extends j
        {

            final FreeSampleActivity._cls9 a;

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected String a(Void void1)
            {
                return AccountManager.b();
            }

                    
                    {
                        a = FreeSampleActivity._cls9.this;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/FreeSampleActivity$9$1

/* anonymous class */
    class FreeSampleActivity._cls9._cls1 extends m
    {

        final FreeSampleActivity._cls9 a;

        protected void a(String s)
        {
            if (AccountManager.c() != null)
            {
                com.perfectcorp.a.b.a(new q(FreeSampleActivity.a(a.b).brandId, AccountManager.c()));
            }
            NetworkUser.a(s, FreeSampleActivity.a(a.b).brandId.longValue()).a(new FreeSampleActivity._cls9._cls1._cls1(this));
        }

        protected void b(Object obj)
        {
            a((String)obj);
        }

            
            {
                a = _pcls9;
                super();
            }
    }

}
