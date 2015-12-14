// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.Dialog;
import android.view.View;
import android.widget.TextView;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.model.network.NetworkEvent;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            FreeSampleResultActivity

class a extends m
{

    final a a;

    protected void a(int i)
    {
        super.a(i);
    }

    protected void a(Void void1)
    {
        if (FreeSampleResultActivity.e(a.a.a) != null && FreeSampleResultActivity.f(a.a.a) != null)
        {
            FreeSampleResultActivity.e(a.a.a).setVisibility(8);
            if ("CONSULTATION".equals(FreeSampleResultActivity.d(a.a.a).pe))
            {
                FreeSampleResultActivity.f(a.a.a).setText(com.cyberlink.beautycircle.m.bc_consultation_result_store_btn_redeemed);
            } else
            {
                FreeSampleResultActivity.f(a.a.a).setText(com.cyberlink.beautycircle.m.bc_freesample_result_store_btn_redeemed);
            }
            FreeSampleResultActivity.f(a.a.a).setEnabled(false);
        }
        a.a.dismiss();
    }

    protected void b(Object obj)
    {
        a((Void)obj);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/FreeSampleResultActivity$3

/* anonymous class */
    class FreeSampleResultActivity._cls3
        implements android.view.View.OnClickListener
    {

        final FreeSampleResultActivity a;

        public void onClick(View view)
        {
            view = new Dialog(a);
            view.requestWindowFeature(1);
            view.setContentView(k.bc_dialog_store_confirm);
            TextView textview = (TextView)view.findViewById(j.bc_dialog_positive);
            TextView textview1 = (TextView)view.findViewById(j.bc_dialog_negative);
            if ("CONSULTATION".equals(FreeSampleResultActivity.d(a).serviceType))
            {
                TextView textview2 = (TextView)view.findViewById(j.bc_dialog_confirm_desc);
                if (textview2 != null)
                {
                    textview2.setText(com.cyberlink.beautycircle.m.bc_consultation_result_dialog_confirm_desc);
                }
                textview2 = (TextView)view.findViewById(j.bc_dialog_confirm_alert);
                if (textview2 != null)
                {
                    textview2.setVisibility(8);
                }
                if (textview != null)
                {
                    textview.setText(com.cyberlink.beautycircle.m.bc_consultation_result_dialog_confirm_ok);
                }
                if (textview1 != null)
                {
                    textview1.setText(com.cyberlink.beautycircle.m.bc_consultation_result_dialog_confirm_cancel);
                }
            }
            textview1.setOnClickListener(new FreeSampleResultActivity._cls3._cls1(view));
            textview.setOnClickListener(new FreeSampleResultActivity._cls3._cls2(this, view));
            view.show();
        }

            
            {
                a = freesampleresultactivity;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/FreeSampleResultActivity$3$1

/* anonymous class */
        class FreeSampleResultActivity._cls3._cls1
            implements android.view.View.OnClickListener
        {

            final Dialog a;
            final FreeSampleResultActivity._cls3 b;

            public void onClick(View view)
            {
                a.cancel();
            }

                    
                    {
                        b = FreeSampleResultActivity._cls3.this;
                        a = dialog;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/FreeSampleResultActivity$3$2

/* anonymous class */
    class FreeSampleResultActivity._cls3._cls2
        implements android.view.View.OnClickListener
    {

        final Dialog a;
        final FreeSampleResultActivity._cls3 b;

        public void onClick(View view)
        {
            NetworkEvent.b(AccountManager.b(), FreeSampleResultActivity.a(b.a).longValue()).a(new FreeSampleResultActivity._cls3._cls2._cls1(this));
        }

            
            {
                b = _pcls3;
                a = dialog;
                super();
            }
    }

}
