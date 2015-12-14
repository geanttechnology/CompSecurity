// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.view.View;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.model.network.NetworkCircle;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            CircleEditorActivity

class a extends m
{

    final a a;

    protected void a()
    {
        Globals.a(a.a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_user_circle_delete_fail));
        a.a.a.l();
    }

    protected void a(int i)
    {
        Globals.a(a.a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_user_circle_delete_fail));
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

    ( )
    {
        a = ;
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
            DialogUtils.a(a, null, a.getResources().getString(com.cyberlink.beautycircle.m.bc_edit_circle_delete_message), a.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_button_cancel), null, a.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_button_ok), new CircleEditorActivity._cls6._cls1(this));
        }

            
            {
                a = circleeditoractivity;
                super();
            }
    }


    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/CircleEditorActivity$6$1

/* anonymous class */
    class CircleEditorActivity._cls6._cls1
        implements Runnable
    {

        final CircleEditorActivity._cls6 a;

        public void run()
        {
            a.a.k();
            NetworkCircle.a(AccountManager.b(), CircleEditorActivity.a(a.a).id).a(new CircleEditorActivity._cls6._cls1._cls1(this));
        }

            
            {
                a = _pcls6;
                super();
            }
    }

}
