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

class a
    implements b
{

    final String a;
    final _cls1.a b;

    public void a()
    {
        Globals.b("getAccountToken Fail");
    }

    public void a(String s)
    {
        b.b.k();
        NetworkPost.a(s, EditCommentActivity.d(b.b), a, com.cyberlink.beautycircle.controller.activity.EditCommentActivity.e(b.b)).a(new m() {

            final EditCommentActivity._cls2._cls1 a;

            protected void a(int i)
            {
                if (i != 523) goto _L2; else goto _L1
_L1:
                String s1 = a.b.a.getResources().getString(com.cyberlink.beautycircle.m.bc_post_comment_you_blocked_toast);
                e.a(a.b.a, s1);
_L4:
                a.b.a.l();
                Globals.a(a.b.a.getResources().getString(com.cyberlink.beautycircle.m.bc_server_connect_fail));
                e.e(new Object[] {
                    "updateComment error: ", Integer.valueOf(i)
                });
                return;
_L2:
                if (i == 524)
                {
                    String s2 = a.b.a.getResources().getString(com.cyberlink.beautycircle.m.bc_post_comment_blocked_you_toast);
                    e.a(a.b.a, s2);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            protected void a(Void void1)
            {
                a.b.a.l();
                void1 = new Intent();
                a.b.a.setResult(-1, void1);
                EditCommentActivity.c(a.b.a);
            }

            protected void b(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = EditCommentActivity._cls2._cls1.this;
                super();
            }
        });
    }

    public void b()
    {
        Globals.b("getAccountToken Cancel");
    }

    _cls1.a(_cls1.a a1, String s)
    {
        b = a1;
        a = s;
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

}
