// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.view.View;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.model.network.NetworkCircle;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            CircleEditorActivity

class a
    implements Runnable
{

    final _cls1.a a;

    public void run()
    {
        a.a.k();
        NetworkCircle.a(AccountManager.b(), CircleEditorActivity.a(a.a).id).a(new com.perfectcorp.utility.m() {

            final CircleEditorActivity._cls6._cls1 a;

            protected void a()
            {
                Globals.a(a.a.a.getResources().getString(m.bc_user_circle_delete_fail));
                a.a.a.l();
            }

            protected void a(int i)
            {
                Globals.a(a.a.a.getResources().getString(m.bc_user_circle_delete_fail));
                a.a.a.l();
            }

            protected void a(Void void1)
            {
                a.a.a.l();
                t.a.a();
                a.a.a.setResult(48257);
                CircleEditorActivity.e(a.a.a);
            }

            protected void b(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = CircleEditorActivity._cls6._cls1.this;
                super();
            }
        });
    }

    _cls1.a(_cls1.a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/CircleEditorActivity$6

/* anonymous class */
    class CircleEditorActivity._cls6
        implements android.view.View.OnClickListener
    {

        final CircleEditorActivity a;

        public void onClick(View view)
        {
            DialogUtils.a(a, null, a.getResources().getString(m.bc_edit_circle_delete_message), a.getResources().getString(m.bc_dialog_button_cancel), null, a.getResources().getString(m.bc_dialog_button_ok), new CircleEditorActivity._cls6._cls1(this));
        }

            
            {
                a = circleeditoractivity;
                super();
            }
    }

}
