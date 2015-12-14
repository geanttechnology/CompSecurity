// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.b;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import com.rockerhieu.emojicon.EmojiconEditText;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            EditCommentActivity

class a extends m
{

    final a a;

    protected void a(int i)
    {
        if (i != 523) goto _L2; else goto _L1
_L1:
        String s = a.a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_post_comment_you_blocked_toast);
        e.a(a.a.a, s);
_L4:
        a.a.a.l();
        Globals.a(a.a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_server_connect_fail));
        e.e(new Object[] {
            "updateComment error: ", Integer.valueOf(i)
        });
        return;
_L2:
        if (i == 524)
        {
            String s1 = a.a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_post_comment_blocked_you_toast);
            e.a(a.a.a, s1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void a(Void void1)
    {
        a.a.a.l();
        void1 = new Intent();
        a.a.a.setResult(-1, void1);
        EditCommentActivity.c(a.a.a);
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

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/EditCommentActivity$2

/* anonymous class */
    class EditCommentActivity._cls2
        implements android.view.View.OnClickListener
    {

        final EditCommentActivity a;

        public void onClick(View view)
        {
            a.i();
            view = EditCommentActivity.a(a).getText().toString();
            AccountManager.a(a, new EditCommentActivity._cls2._cls1(this, view));
        }

            
            {
                a = editcommentactivity;
                super();
            }
    }


    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/EditCommentActivity$2$1

/* anonymous class */
    class EditCommentActivity._cls2._cls1
        implements b
    {

        final String a;
        final EditCommentActivity._cls2 b;

        public void a()
        {
            Globals.b("getAccountToken Fail");
        }

        public void a(String s)
        {
            b.a.k();
            NetworkPost.a(s, EditCommentActivity.d(b.a), a, com.cyberlink.beautycircle.controller.activity.EditCommentActivity.e(b.a)).a(new EditCommentActivity._cls2._cls1._cls1(this));
        }

        public void b()
        {
            Globals.b("getAccountToken Cancel");
        }

            
            {
                b = _pcls2;
                a = s;
                super();
            }
    }

}
