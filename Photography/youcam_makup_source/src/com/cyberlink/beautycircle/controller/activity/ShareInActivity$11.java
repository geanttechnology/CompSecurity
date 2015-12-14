// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleBasic;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInActivity

class a extends j
{

    final ShareInActivity a;

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected Void a(Void void1)
    {
        void1 = AccountManager.b();
        if (void1 == null)
        {
            DialogUtils.a(a, m.bc_write_post_message_must_sign_in);
            a.l();
        } else
        {
            Post post = new Post();
            post.circleIds = new ArrayList();
            CircleBasic circlebasic;
            for (Iterator iterator = ShareInActivity.q(a).iterator(); iterator.hasNext(); post.circleIds.add(circlebasic.id))
            {
                circlebasic = (CircleBasic)iterator.next();
            }

            post.title = ((TextView)a.findViewById(com.cyberlink.beautycircle.j.title)).getText().toString();
            post.content = ((TextView)a.findViewById(com.cyberlink.beautycircle.j.description)).getText().toString();
            post.attachments = new com.cyberlink.beautycircle.model.ments();
            post.attachments.files = new ArrayList();
            post.attachments.files.add(ShareInActivity.B(a));
            if (c())
            {
                e.b(new Object[] {
                    "The promise task is cancelled."
                });
                return null;
            }
            com.cyberlink.beautycircle.controller.activity.ShareInActivity.b(a, NetworkPost.a(void1, ShareInActivity.D(a), post, null));
            if (ShareInActivity.E(a) != null)
            {
                ShareInActivity.E(a).a(new com.perfectcorp.utility.m() {

                    final ShareInActivity._cls11 a;

                    public void a()
                    {
                        e.b(new Object[] {
                            "The create post is canceled."
                        });
                    }

                    public void a(int i)
                    {
                        e.e(new Object[] {
                            Integer.valueOf(i)
                        });
                        a.a.l();
                        ShareInActivity.a(a.a, m.bc_write_post_message_create_post_fail, null);
                    }

                    protected void a(com.cyberlink.beautycircle.model.network.NetworkPost.CreatePostsResult createpostsresult)
                    {
                        if (!c())
                        {
                            e.b(new Object[] {
                                "The create post is finish."
                            });
                            a.a.a(m.bc_sharein_dialog_title, Float.valueOf(1.0F), ShareInActivity.s(a.a), new Runnable(this) {

                                final _cls1 a;

                                public void run()
                                {
                                    b.a(new com.cyberlink.beautycircle.controller.a.j("external"));
                                    t.b.a();
                                    a.a.a.l();
                                    if (ShareInActivity.f(a.a.a) != null)
                                    {
                                        Globals.a(a.a.a.getResources().getString(m.bc_sharein_success));
                                        c.a(a.a.a, com.cyberlink.beautycircle.controller.activity.MainActivity.TabPage.b);
                                    }
                                    a.a.a.setResult(-1);
                                    a.a.a.finish();
                                }

            
            {
                a = _pcls1;
                super();
            }
                            });
                            return;
                        } else
                        {
                            e.b(new Object[] {
                                "The create post is canceled. Don't show progress animation."
                            });
                            a.a.finish();
                            return;
                        }
                    }

                    protected void b(Object obj)
                    {
                        a((com.cyberlink.beautycircle.model.network.NetworkPost.CreatePostsResult)obj);
                    }

            
            {
                a = ShareInActivity._cls11.this;
                super();
            }
                });
                return null;
            }
        }
        return null;
    }

    public void a()
    {
        e.b(new Object[] {
            "Cancel create post promise task"
        });
        ShareInActivity.F(a);
    }

    public void a(int i)
    {
        e.e(new Object[] {
            Integer.valueOf(i)
        });
        a.l();
        ShareInActivity.a(a, m.bc_write_post_message_create_post_fail, null);
    }

    _cls1.a(ShareInActivity shareinactivity)
    {
        a = shareinactivity;
        super();
    }
}
