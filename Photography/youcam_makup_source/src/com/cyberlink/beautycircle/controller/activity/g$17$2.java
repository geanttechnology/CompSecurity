// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.widget.TextView;
import com.cyberlink.beautycircle.model.Comment;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.Tags;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.model.r;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.b;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import com.rockerhieu.emojicon.EmojiconEditText;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g, PostActivity

class a extends m
{

    final a a;

    protected void a()
    {
        PostActivity.k(a.a.b).setEnabled(true);
    }

    protected void a(int i)
    {
        if (i != 523) goto _L2; else goto _L1
_L1:
        String s = a.a.b.getResources().getString(com.cyberlink.beautycircle.m.bc_post_comment_you_blocked_toast);
        e.a(a.a.b, s);
_L4:
        PostActivity.k(a.a.b).setEnabled(true);
        return;
_L2:
        if (i == 524)
        {
            String s1 = a.a.b.getResources().getString(com.cyberlink.beautycircle.m.bc_post_comment_blocked_you_toast);
            e.a(a.a.b, s1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void a(Comment comment)
    {
        com.cyberlink.beautycircle.controller.activity.PostActivity.j(a.a.b).setText("");
        PostActivity.k(a.a.b).setEnabled(true);
        g.a(a.a, 2);
        UserInfo userinfo = AccountManager.d();
        Creator creator = new Creator();
        if (userinfo != null)
        {
            creator.avatar = userinfo.avatarUrl;
            creator.userId = userinfo.id;
            creator.displayName = userinfo.displayName;
        }
        comment.creator = creator;
        comment.comment = a.a;
        comment.likeCount = 0L;
        g.a(a.a, g.a(a.a).creator.userId, comment);
    }

    protected void b(Object obj)
    {
        a((Comment)obj);
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/g$17

/* anonymous class */
    class g._cls17
        implements b
    {

        final String a;
        final g b;

        public void a()
        {
            e.e(new Object[] {
                "getAccountToken Fail"
            });
        }

        public void a(String s)
        {
            if (g.a(b) == null)
            {
                return;
            } else
            {
                g.a(b).a(Long.valueOf(g.a(b).commentCount.longValue() + 1L), new g._cls17._cls1());
                NetworkPost.a(s, "Post", g.a(b).postId.longValue(), a, new Tags()).a(new g._cls17._cls2(this));
                return;
            }
        }

        public void b()
        {
            e.e(new Object[] {
                "getAccountToken Abort"
            });
        }

            
            {
                b = g1;
                a = s;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/g$17$1

/* anonymous class */
        class g._cls17._cls1
            implements r
        {

            final g._cls17 a;

            public void a(Post post)
            {
                if (post != null)
                {
                    g.a(a.b, post);
                }
                a.b.a(g.a(a.b));
                com.cyberlink.beautycircle.controller.activity.g.b(a.b, g.a(a.b));
            }

                    
                    {
                        a = g._cls17.this;
                        super();
                    }
        }

    }

}
