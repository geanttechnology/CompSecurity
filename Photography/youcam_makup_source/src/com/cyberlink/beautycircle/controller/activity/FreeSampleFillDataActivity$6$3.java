// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkEvent;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.i;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.m;
import java.util.Calendar;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            FreeSampleFillDataActivity

class a extends m
{

    final a a;

    protected void a(int i)
    {
        super.a(i);
        Globals.b((new StringBuilder()).append("Join fail:").append(a.a.f.f).append(", code:").append(i).toString());
    }

    protected void a(Void void1)
    {
        Globals.b((new StringBuilder()).append("Join:").append(a.a.f.f).toString());
        t.g.a();
        void1 = (new StringBuilder()).append("<b>").append(a.a.getString(com.cyberlink.beautycircle.m.bc_freesample_join_success_title)).append("</b><br><br>").append(a.a.getString(com.cyberlink.beautycircle.m.bc_freesample_join_success_consultation)).toString();
        if ("CONSULTATION".equals(a.a.f.e))
        {
            DialogUtils.a(a.a, null, void1, null, null, a.a.getString(com.cyberlink.beautycircle.m.bc_consultation_view_reservation), null, true, new android.content.DialogInterface.OnDismissListener() {

                final FreeSampleFillDataActivity._cls6._cls3 a;

                public void onDismiss(DialogInterface dialoginterface)
                {
                    a.a.a.setResult(-1);
                    c.a(a.a.a, a.a.a.f.id);
                    a.a.a.finish();
                }

            
            {
                a = FreeSampleFillDataActivity._cls6._cls3.this;
                super();
            }
            });
            return;
        } else
        {
            DialogUtils.a(a.a, null, a.a.getString(com.cyberlink.beautycircle.m.bc_freesample_join_success_message), null, null, a.a.getString(com.cyberlink.beautycircle.m.bc_dialog_button_ok), new Runnable() {

                final FreeSampleFillDataActivity._cls6._cls3 a;

                public void run()
                {
                    a.a.a.setResult(-1);
                    a.a.a.finish();
                }

            
            {
                a = FreeSampleFillDataActivity._cls6._cls3.this;
                super();
            }
            }, false, null);
            return;
        }
    }

    protected void b(Object obj)
    {
        a((Void)obj);
    }

    b(b b1)
    {
        a = b1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/FreeSampleFillDataActivity$6

/* anonymous class */
    class FreeSampleFillDataActivity._cls6
        implements android.view.View.OnClickListener
    {

        final FreeSampleFillDataActivity a;

        public void onClick(View view)
        {
            if (com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.c(a) && a.f != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            if (a.e)
            {
                break; /* Loop/switch isn't completed */
            }
            if (FreeSampleFillDataActivity.d(a) != null)
            {
                ((ScrollView)a.findViewById(j.free_sample_scroll_panel)).pageScroll(130);
                FreeSampleFillDataActivity.d(a).setVisibility(4);
                FreeSampleFillDataActivity.d(a).postDelayed(new FreeSampleFillDataActivity._cls6._cls1(), 100L);
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
            com.cyberlink.beautycircle.model.Event.AddressInfo addressinfo;
            view = AccountManager.b();
            com.cyberlink.beautycircle.model.network.NetworkEvent.JoinEventParam joineventparam = new com.cyberlink.beautycircle.model.network.NetworkEvent.JoinEventParam();
            long l;
            if (a.f.id != null)
            {
                l = a.f.id.longValue();
            } else
            {
                l = -1L;
            }
            joineventparam.brandEventId = l;
            joineventparam.name = com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.e(a).getText().toString();
            joineventparam.phone = FreeSampleFillDataActivity.f(a).getText().toString();
            addressinfo = new com.cyberlink.beautycircle.model.Event.AddressInfo();
            if (!a.f.receiveType.equals("Home".toString())) goto _L5; else goto _L4
_L4:
            addressinfo.address = FreeSampleFillDataActivity.g(a).getText().toString();
_L7:
            joineventparam.address = addressinfo.toString();
            joineventparam.email = FreeSampleFillDataActivity.k(a).getText().toString();
            (new FreeSampleFillDataActivity._cls6._cls2(joineventparam, addressinfo)).executeOnExecutor(com.perfectcorp.utility.j.q, new Void[0]);
            NetworkEvent.a(view, joineventparam).a(new FreeSampleFillDataActivity._cls6._cls3(this));
            return;
_L5:
            if (a.f.receiveType.equals("Store".toString()))
            {
                addressinfo.location = FreeSampleFillDataActivity.h(a).getText().toString();
                addressinfo.name = com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.i(a).getText().toString();
                addressinfo.address = com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.j(a).getText().toString();
                addressinfo.userAddress = FreeSampleFillDataActivity.g(a).getText().toString();
            }
            if (true) goto _L7; else goto _L6
_L6:
        }

            
            {
                a = freesamplefilldataactivity;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/FreeSampleFillDataActivity$6$1

/* anonymous class */
        class FreeSampleFillDataActivity._cls6._cls1
            implements Runnable
        {

            final FreeSampleFillDataActivity._cls6 a;

            public void run()
            {
                FreeSampleFillDataActivity.d(a.a).setVisibility(0);
            }

                    
                    {
                        a = FreeSampleFillDataActivity._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/FreeSampleFillDataActivity$6$2

/* anonymous class */
        class FreeSampleFillDataActivity._cls6._cls2 extends AsyncTask
        {

            final com.cyberlink.beautycircle.model.network.NetworkEvent.JoinEventParam a;
            final com.cyberlink.beautycircle.model.Event.AddressInfo b;
            final FreeSampleFillDataActivity._cls6 c;

            protected transient Void a(Void avoid[])
            {
                String s;
                String s1;
                String s2;
                String s3;
                String s4;
                UserInfo userinfo;
                boolean flag;
                boolean flag2;
label0:
                {
                    userinfo = AccountManager.d();
                    flag = false;
                    boolean flag1 = false;
                    s = null;
                    s1 = null;
                    avoid = null;
                    s4 = null;
                    s3 = null;
                    s2 = avoid;
                    if (a == null)
                    {
                        break label0;
                    }
                    String s5 = a.name;
                    if (userinfo.name == null || !userinfo.name.equals(s5))
                    {
                        userinfo.name = s5;
                        flag1 = true;
                    }
                    String s6 = a.phone;
                    if (userinfo.phone == null || !userinfo.phone.equals(s6))
                    {
                        userinfo.phone = s6;
                        flag1 = true;
                    }
                    flag = flag1;
                    s = s5;
                    s1 = s6;
                    s2 = avoid;
                    if (AccountManager.f() == com.cyberlink.beautycircle.utility.AccountManager.AccountSource.a)
                    {
                        break label0;
                    }
                    avoid = a.email;
                    if (userinfo.receiveEmail != null)
                    {
                        flag = flag1;
                        s = s5;
                        s1 = s6;
                        s2 = avoid;
                        if (userinfo.receiveEmail.equals(avoid))
                        {
                            break label0;
                        }
                    }
                    userinfo.receiveEmail = avoid;
                    flag = true;
                    s2 = avoid;
                    s1 = s6;
                    s = s5;
                }
                flag2 = flag;
                avoid = s4;
                if (b == null) goto _L2; else goto _L1
_L1:
                if (!c.a.f.receiveType.equals("Home".toString())) goto _L4; else goto _L3
_L3:
                s4 = b.address;
                if (userinfo.address == null) goto _L6; else goto _L5
_L5:
                flag2 = flag;
                avoid = s4;
                if (userinfo.address.equals(s4)) goto _L2; else goto _L6
_L6:
                userinfo.address = s4;
                flag2 = true;
                avoid = s4;
_L2:
label1:
                {
                    if (FreeSampleFillDataActivity.b(c.a) != null)
                    {
                        s3 = i.d(FreeSampleFillDataActivity.b(c.a).getTime());
                    }
                    flag = flag2;
                    if (s3 == null)
                    {
                        break label1;
                    }
                    flag = flag2;
                    if (s3.isEmpty())
                    {
                        break label1;
                    }
                    flag = flag2;
                    if (s3.equals(userinfo.birthDay))
                    {
                        break label1;
                    }
                    if (userinfo.birthDay != null)
                    {
                        flag = flag2;
                        if (userinfo.birthDay.equals(s3))
                        {
                            break label1;
                        }
                    }
                    userinfo.birthDay = s3;
                    flag = true;
                }
                if (flag)
                {
                    e.c(new Object[] {
                        "UserInfo changed. Need update."
                    });
                    s4 = AccountManager.b();
                    NetworkUser.a(s4, null, null, null, null, null, null, s3, null, s, s1, s2, avoid, null).a(new FreeSampleFillDataActivity._cls6._cls2._cls1(this, s4, userinfo));
                }
                return null;
_L4:
                flag2 = flag;
                avoid = s4;
                if (!"CONSULTATION".equals(c.a.f.serviceType))
                {
                    continue; /* Loop/switch isn't completed */
                }
                s4 = b.userAddress;
                if (userinfo.address != null)
                {
                    flag2 = flag;
                    avoid = s4;
                    if (userinfo.address.equals(s4))
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                }
                userinfo.address = s4;
                flag2 = true;
                avoid = s4;
                if (true) goto _L2; else goto _L7
_L7:
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

                    
                    {
                        c = FreeSampleFillDataActivity._cls6.this;
                        a = joineventparam;
                        b = addressinfo;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/FreeSampleFillDataActivity$6$2$1

/* anonymous class */
        class FreeSampleFillDataActivity._cls6._cls2._cls1 extends m
        {

            final String a;
            final UserInfo b;
            final FreeSampleFillDataActivity._cls6._cls2 c;

            protected void a(com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse updateuserresponse)
            {
                AccountManager.a(a, b, false).a(new FreeSampleFillDataActivity._cls6._cls2._cls1._cls1(this));
            }

            protected void b(Object obj)
            {
                a((com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse)obj);
            }

                    
                    {
                        c = _pcls2;
                        a = s;
                        b = userinfo;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/FreeSampleFillDataActivity$6$2$1$1

/* anonymous class */
        class FreeSampleFillDataActivity._cls6._cls2._cls1._cls1 extends m
        {

            final FreeSampleFillDataActivity._cls6._cls2._cls1 a;

            protected void a(Boolean boolean1)
            {
                if (boolean1 != null && boolean1.booleanValue())
                {
                    e.c(new Object[] {
                        "Update user info success."
                    });
                }
            }

            protected void b(Object obj)
            {
                a((Boolean)obj);
            }

                    
                    {
                        a = _pcls1;
                        super();
                    }
        }

    }

}
