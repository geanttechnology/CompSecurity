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
//            j, PostCommentActivity

class a
    implements r
{

    final a a;

    public void a(Post post)
    {
        if (post != null)
        {
            j.a(a.a, post);
        }
        com.cyberlink.beautycircle.controller.activity.j.b(a.a, j.f(a.a));
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/j$13

/* anonymous class */
    class j._cls13
        implements b
    {

        final String a;
        final com.cyberlink.beautycircle.controller.activity.j b;

        public void a()
        {
            PostCommentActivity.d(b.a).setEnabled(true);
            e.e(new Object[] {
                "getAccountToken Fail"
            });
        }

        public void a(String s)
        {
            if (j.f(b) == null)
            {
                return;
            } else
            {
                j.f(b).a(Long.valueOf(j.f(b).commentCount.longValue() + 1L), new j._cls13._cls1(this));
                NetworkPost.a(s, "Post", j.f(b).postId.longValue(), a, new Tags()).a(new j._cls13._cls2());
                return;
            }
        }

        public void b()
        {
            PostCommentActivity.d(b.a).setEnabled(true);
            e.e(new Object[] {
                "getAccountToken Abort"
            });
        }

            
            {
                b = j1;
                a = s;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/j$13$2

/* anonymous class */
        class j._cls13._cls2 extends m
        {

            final j._cls13 a;

            protected void a()
            {
                PostCommentActivity.d(a.b.a).setEnabled(true);
            }

            protected void a(int i)
            {
                if (i != 523) goto _L2; else goto _L1
_L1:
                String s = a.b.a.getResources().getString(com.cyberlink.beautycircle.m.bc_post_comment_you_blocked_toast);
                e.a(a.b.a, s);
_L4:
                PostCommentActivity.d(a.b.a).setEnabled(true);
                return;
_L2:
                if (i == 524)
                {
                    String s1 = a.b.a.getResources().getString(com.cyberlink.beautycircle.m.bc_post_comment_blocked_you_toast);
                    e.a(a.b.a, s1);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            protected void a(Comment comment)
            {
                PostCommentActivity.c(a.b.a).setText("");
                PostCommentActivity.d(a.b.a).setEnabled(true);
                j.a(a.b, 2);
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
                j.a(a.b, j.f(a.b).creator.userId, comment);
                a.b.a.setResult(-1);
            }

            protected void b(Object obj)
            {
                a((Comment)obj);
            }

                    
                    {
                        a = j._cls13.this;
                        super();
                    }
        }

    }

}
