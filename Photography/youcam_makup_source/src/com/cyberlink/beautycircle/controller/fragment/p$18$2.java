// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.controller.activity.MeActivity;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.view.widgetpool.common.CLMultiColumnListView;
import com.cyberlink.beautycircle.view.widgetpool.common.MeTabScrollView;
import com.perfectcorp.utility.j;
import java.util.TreeMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p, TopBarFragment, q

class a
    implements Runnable
{

    final t a;

    public void run()
    {
        if (p.e(a.a) != null)
        {
            if (p.e(a.a).circleCount != null)
            {
                a.a.c(p.e(a.a).circleCount.intValue());
            }
            if (p.e(a.a).productFeatureCount != null)
            {
                p.c(a.a, p.e(a.a).productFeatureCount.intValue());
            }
            if (p.e(a.a).postCount != null)
            {
                p.d(a.a, p.e(a.a).postCount.intValue());
            }
            if (p.e(a.a).likedTargetCount != null)
            {
                p.e(a.a, p.e(a.a).likedTargetCount.intValue());
            }
            if (p.e(a.a).followingCount != null)
            {
                p.f(a.a, p.e(a.a).followingCount.intValue());
            }
            if (p.e(a.a).followerCount != null)
            {
                p.g(a.a, p.e(a.a).followerCount.intValue());
            }
        }
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/p$18

/* anonymous class */
    class p._cls18 extends AsyncTask
    {

        final p a;

        protected transient UserInfo a(Void avoid[])
        {
            Long long1;
            boolean flag;
            flag = true;
            long1 = null;
            Object obj = p.A(a);
            obj;
            JVM INSTR monitorenter ;
            if (p.B(a) == null) goto _L2; else goto _L1
_L1:
            avoid = p.B(a);
            p.b(a, null);
              goto _L3
_L22:
            if (p.a(a) == -1L) goto _L5; else goto _L4
_L4:
            Object obj1 = a;
            if (avoid == null) goto _L7; else goto _L6
_L6:
            if (p.a(a) != ((UserInfo) (avoid)).id) goto _L7; else goto _L8
_L8:
            p.b(((p) (obj1)), flag);
_L17:
            if (!p.h(a)) goto _L10; else goto _L9
_L9:
            obj1 = AccountManager.b();
            if (obj1 == null) goto _L12; else goto _L11
_L11:
            if (((String) (obj1)).isEmpty()) goto _L12; else goto _L13
_L13:
            if (p.e(a) == null) goto _L15; else goto _L14
_L14:
            flag = p.C(a);
            if (!flag) goto _L16; else goto _L15
_L15:
            p.a(a, (UserInfo)NetworkUser.a(long1.longValue(), long1, AccountManager.b()).d());
            p.a(a, false);
            AccountManager.a(((String) (obj1)), p.e(a), false);
_L18:
            if (!p.f(a) && p.x(a) != null)
            {
                p.x(a).post(new p._cls18._cls1());
            }
            avoid = a.getActivity();
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_262;
            }
            if (avoid instanceof MainActivity)
            {
                avoid.runOnUiThread(new p._cls18._cls2(this));
            }
            p.c(a, true);
_L19:
            obj;
            JVM INSTR monitorexit ;
            return p.e(a);
_L2:
            avoid = AccountManager.d();
              goto _L3
_L23:
            long1 = Long.valueOf(((UserInfo) (avoid)).id);
            break; /* Loop/switch isn't completed */
_L5:
            p.b(a, true);
              goto _L17
            avoid;
            obj;
            JVM INSTR monitorexit ;
            throw avoid;
            Exception exception;
            exception;
            p.a(a, avoid);
            exception.printStackTrace();
              goto _L18
_L16:
            p.a(a, avoid);
              goto _L18
_L12:
            if (!p.f(a))
            {
                break MISSING_BLOCK_LABEL_450;
            }
            p.a(a, null);
            p.a(a, null);
            p.a(a, null);
            p.a(a, null);
            p.a(a, null);
            p.a(a, null);
            p.c(a, null);
            avoid = a.getActivity();
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_450;
            }
            if (avoid instanceof MainActivity)
            {
                avoid.runOnUiThread(new p._cls18._cls3(avoid));
            }
            p.c(a, false);
              goto _L19
_L10:
            p.c(a, false);
            if (p.e(a) == null || p.e(a).userType == null) goto _L21; else goto _L20
_L20:
            flag = p.C(a);
            if (!flag) goto _L19; else goto _L21
_L21:
            p.a(a, (UserInfo)NetworkUser.a(p.a(a), AccountManager.c(), AccountManager.b()).d());
            p.d(a, true);
            p.a(a, false);
              goto _L19
            avoid;
            avoid.printStackTrace();
              goto _L19
            avoid;
            avoid.printStackTrace();
              goto _L19
            avoid;
            avoid.printStackTrace();
              goto _L19
_L3:
            if (avoid != null) goto _L23; else goto _L22
_L7:
            flag = false;
              goto _L8
        }

        protected void a(UserInfo userinfo)
        {
            p.c(a, userinfo);
            if (userinfo != null)
            {
                if (p.D(a) != null)
                {
                    boolean flag;
                    if (p.h(a) && p.f(a))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    p.D(a).a(p.a(a, userinfo, flag));
                }
                p.E(a);
                p.a(a, userinfo.eventImageList);
            }
            userinfo = a.getActivity();
            if (p.F(a))
            {
                p.e(a, false);
                if (userinfo != null && (userinfo instanceof MeActivity) && ((MeActivity)userinfo).b().b() != null)
                {
                    ((MeActivity)userinfo).b().b().performClick();
                }
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((Void[])aobj);
        }

        protected void onPostExecute(Object obj)
        {
            a((UserInfo)obj);
        }

            
            {
                a = p1;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/p$18$1

/* anonymous class */
        class p._cls18._cls1
            implements Runnable
        {

            final p._cls18 a;

            public void run()
            {
                q q1 = (q)p.o(a.a).get(Integer.valueOf(0));
                if (q1 != null && q1.b().equals(com.cyberlink.beautycircle.model.MeADPager.DisplayType.b))
                {
                    q1.a(p.e(a.a), p.h(a.a), p.f(a.a));
                }
            }

                    
                    {
                        a = p._cls18.this;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/p$18$3

/* anonymous class */
        class p._cls18._cls3
            implements Runnable
        {

            final Activity a;
            final p._cls18 b;

            public void run()
            {
                if (b.a.g != null)
                {
                    ((CLMultiColumnListView)b.a.g).setAdapter(null);
                }
                b.a.c(0);
                p.c(b.a, 0);
                p.d(b.a, 0);
                p.e(b.a, 0);
                p.f(b.a, 0);
                p.g(b.a, 0);
                ((MainActivity)a).a(0, false);
                q q1 = (q)p.o(b.a).get(Integer.valueOf(0));
                if (q1 != null && q1.b().equals(com.cyberlink.beautycircle.model.MeADPager.DisplayType.b))
                {
                    q1.a(null, p.h(b.a), false);
                }
            }

                    
                    {
                        b = p._cls18.this;
                        a = activity;
                        super();
                    }
        }

    }

}
