// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.res.Resources;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.a;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.Comment;
import com.cyberlink.beautycircle.model.CompletePost;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.Tags;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.model.r;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.b;
import com.cyberlink.beautycircle.view.widgetpool.common.ObservableScrollView;
import com.cyberlink.beautycircle.view.widgetpool.common.PostContentTextView;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.utility.e;
import com.rockerhieu.emojicon.EmojiconEditText;
import com.rockerhieu.emojicon.EmojiconTextView;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PostCommentActivity

class j
{

    final PostCommentActivity a;
    private long b;
    private Post c;
    private Post d;
    private SwipeRefreshLayout e;
    private ObservableScrollView f;
    private LinearLayout g;
    private LinearLayout h;
    private View i;
    private View j;
    private int k;
    private android.view.View.OnClickListener l;
    private android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener m;

    protected j(PostCommentActivity postcommentactivity, ViewGroup viewgroup, Post post)
    {
        a = postcommentactivity;
        super();
        b = -1L;
        c = null;
        d = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = 0;
        l = new android.view.View.OnClickListener() {

            final j a;

            public void onClick(View view)
            {
                a.d();
            }

            
            {
                a = j.this;
                super();
            }
        };
        m = new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

            final j a;

            public void onRefresh()
            {
                if (j.i(a) != null)
                {
                    j.i(a).removeAllViews();
                }
                if (j.j(a) != null)
                {
                    j.j(a).setVisibility(8);
                }
                com.cyberlink.beautycircle.controller.activity.j.c(a, 0);
                com.cyberlink.beautycircle.controller.activity.j.a(a);
            }

            
            {
                a = j.this;
                super();
            }
        };
        c = post;
        d = post;
        if (post != null)
        {
            b = post.postId.longValue();
        }
        i = ((LayoutInflater)postcommentactivity.getSystemService("layout_inflater")).inflate(k.bc_view_post_comment, viewgroup, false);
        i.setTag(Integer.valueOf(hashCode()));
        if (d.creator != null)
        {
            com.cyberlink.beautycircle.controller.activity.PostCommentActivity.a(postcommentactivity, false);
        }
        h();
        g();
        viewgroup.addView(i);
    }

    static Post a(j j1, Post post)
    {
        j1.d = post;
        return post;
    }

    private void a(int i1)
    {
        if (f != null)
        {
            if (i1 == 1)
            {
                f.post(new Runnable() {

                    final j a;

                    public void run()
                    {
                        com.cyberlink.beautycircle.controller.activity.j.e(a).fullScroll(33);
                    }

            
            {
                a = j.this;
                super();
            }
                });
                return;
            }
            if (i1 == 2)
            {
                f.post(new Runnable() {

                    final j a;

                    public void run()
                    {
                        com.cyberlink.beautycircle.controller.activity.j.e(a).fullScroll(130);
                    }

            
            {
                a = j.this;
                super();
            }
                });
                return;
            }
        }
    }

    private void a(long l1, View view)
    {
        String s = AccountManager.b();
        if (s == null || s.isEmpty())
        {
            return;
        }
        if (d != null)
        {
            d.a(Long.valueOf(d.commentCount.longValue() - 1L), new r() {

                final j a;

                public void a(Post post)
                {
                    if (post != null)
                    {
                        com.cyberlink.beautycircle.controller.activity.j.a(a, post);
                    }
                    com.cyberlink.beautycircle.controller.activity.j.b(a, j.f(a));
                }

            
            {
                a = j.this;
                super();
            }
            });
        }
        DialogUtils.a(a, "", a.getResources().getString(m.bc_post_comment_delete_confirm_text), a.getResources().getString(m.bc_post_cancel), new Runnable() {

            final j a;

            public void run()
            {
            }

            
            {
                a = j.this;
                super();
            }
        }, a.getResources().getString(m.bc_post_comment_menu_delete), new Runnable(s, l1, view) {

            final String a;
            final long b;
            final View c;
            final j d;

            public void run()
            {
                NetworkPost.b(a, Long.valueOf(b));
                com.cyberlink.beautycircle.controller.activity.j.a(d, c);
                d.a.setResult(-1);
            }

            
            {
                d = j.this;
                a = s;
                b = l1;
                c = view;
                super();
            }
        });
    }

    private void a(long l1, Comment comment)
    {
        View view = ((LayoutInflater)a.getSystemService("layout_inflater")).inflate(k.bc_view_issue_comment, g, false);
        a(l1, comment, view);
        g.addView(view);
        c();
        ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[] {
            PropertyValuesHolder.ofFloat("alpha", new float[] {
                0.0F, 1.0F
            }), PropertyValuesHolder.ofFloat("translationX", new float[] {
                (float)g.getWidth(), 0.0F
            })
        }).setDuration(300L).start();
    }

    private void a(long l1, Comment comment, View view)
    {
        if (comment == null)
        {
            return;
        }
        view.setOnLongClickListener(new android.view.View.OnLongClickListener(comment, l1) {

            final Comment a;
            final long b;
            final j c;

            public boolean onLongClick(View view1)
            {
                boolean flag1 = false;
                PopupMenu popupmenu = new PopupMenu(c.a, view1);
                Menu menu = popupmenu.getMenu();
                if (e.a)
                {
                    menu.add(m.bc_post_comment_menu_copy).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(this) {

                        final _cls5 a;

                        public boolean onMenuItemClick(MenuItem menuitem)
                        {
                            ((ClipboardManager)a.c.a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, a.a.comment));
                            return true;
                        }

            
            {
                a = _pcls5;
                super();
            }
                    });
                }
                UserInfo userinfo = AccountManager.d();
                if (a.creator != null)
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "Creator userId:", Long.valueOf(a.creator.userId)
                    });
                }
                if (userinfo != null)
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "Account userId:", Long.valueOf(userinfo.id)
                    });
                }
                com.perfectcorp.utility.e.b(new Object[] {
                    "creatorId:", Long.valueOf(b)
                });
                if (userinfo != null && (userinfo.id == a.creator.userId || userinfo.id == b))
                {
                    menu.add(m.bc_post_comment_menu_delete).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(this, view1) {

                        final View a;
                        final _cls5 b;

                        public boolean onMenuItemClick(MenuItem menuitem)
                        {
                            com.cyberlink.beautycircle.controller.activity.j.a(b.c, b.a.commentId, a);
                            return true;
                        }

            
            {
                b = _pcls5;
                a = view;
                super();
            }
                    });
                }
                if (userinfo != null && userinfo.id == a.creator.userId)
                {
                    menu.add(m.bc_post_comment_menu_edit).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(this) {

                        final _cls5 a;

                        public boolean onMenuItemClick(MenuItem menuitem)
                        {
                            com.cyberlink.beautycircle.controller.activity.PostCommentActivity.a(a.c.a, a.a);
                            return true;
                        }

            
            {
                a = _pcls5;
                super();
            }
                    });
                }
                boolean flag = flag1;
                if (a.creator != null)
                {
                    flag = flag1;
                    if (a.creator.b().c())
                    {
                        flag = true;
                    }
                }
                if ((userinfo == null || userinfo.id != a.creator.userId) && !flag && !"CL".equals(a.creator.userType))
                {
                    menu.add(m.bc_post_comment_menu_report).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(this, view1) {

                        final View a;
                        final _cls5 b;

                        public boolean onMenuItemClick(MenuItem menuitem)
                        {
                            com.cyberlink.beautycircle.controller.activity.j.b(b.c, b.a.commentId, a);
                            return true;
                        }

            
            {
                b = _pcls5;
                a = view;
                super();
            }
                    });
                }
                menu.add(m.bc_post_comment_menu_cancel);
                popupmenu.show();
                return true;
            }

            
            {
                c = j.this;
                a = comment;
                b = l1;
                super();
            }
        });
        Object obj = (UICImageView)view.findViewById(com.cyberlink.beautycircle.j.comment_avatar);
        if (obj != null)
        {
            ((UICImageView) (obj)).setImageURI(comment.creator.avatar);
            ((UICImageView) (obj)).setOnClickListener(new android.view.View.OnClickListener(comment) {

                final Comment a;
                final j b;

                public void onClick(View view1)
                {
                    com.cyberlink.beautycircle.c.a(b.a, a.creator.userId, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a);
                }

            
            {
                b = j.this;
                a = comment;
                super();
            }
            });
        }
        obj = (ImageView)view.findViewById(com.cyberlink.beautycircle.j.avatar_crown);
        if (comment.creator != null)
        {
            com.cyberlink.beautycircle.a.a(((ImageView) (obj)), comment.creator.userType);
        }
        obj = (EmojiconTextView)view.findViewById(com.cyberlink.beautycircle.j.comment_auther);
        if (obj != null)
        {
            if (e.a)
            {
                ((EmojiconTextView) (obj)).setText((new StringBuilder()).append("[#").append(comment.creator.userId).append("] ").append(comment.creator.displayName).toString());
            } else
            {
                ((EmojiconTextView) (obj)).setText(comment.creator.displayName);
            }
            ((EmojiconTextView) (obj)).setOnClickListener(new android.view.View.OnClickListener(comment) {

                final Comment a;
                final j b;

                public void onClick(View view1)
                {
                    com.cyberlink.beautycircle.c.a(b.a, a.creator.userId, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a);
                }

            
            {
                b = j.this;
                a = comment;
                super();
            }
            });
        }
        obj = (PostContentTextView)view.findViewById(com.cyberlink.beautycircle.j.comment_text);
        if (obj != null)
        {
            if (e.a)
            {
                ((PostContentTextView) (obj)).setTextViewHTML((new StringBuilder()).append("[#").append(comment.commentId).append("]\r\n").append(comment.comment).toString());
            } else
            {
                ((PostContentTextView) (obj)).setTextViewHTML(comment.comment);
            }
        }
        com.cyberlink.beautycircle.controller.activity.PostCommentActivity.a(a, (TextView)view.findViewById(com.cyberlink.beautycircle.j.comment_time), comment.lastModified, comment.isLiked, comment.likeCount, comment.commentId);
    }

    private void a(View view)
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[] {
            PropertyValuesHolder.ofFloat("alpha", new float[] {
                1.0F, 0.0F
            }), PropertyValuesHolder.ofFloat("translationX", new float[] {
                0.0F, (float)(g.getWidth() * -1)
            })
        }).setDuration(300L);
        objectanimator.addListener(new android.animation.Animator.AnimatorListener(view) {

            final View a;
            final j b;

            public void onAnimationCancel(Animator animator)
            {
                j.i(b).removeView(a);
                b.c();
            }

            public void onAnimationEnd(Animator animator)
            {
                j.i(b).removeView(a);
                b.c();
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                b = j.this;
                a = view;
                super();
            }
        });
        objectanimator.start();
    }

    static void a(j j1)
    {
        j1.f();
    }

    static void a(j j1, int i1)
    {
        j1.a(i1);
    }

    static void a(j j1, long l1, View view)
    {
        j1.a(l1, view);
    }

    static void a(j j1, long l1, Comment comment)
    {
        j1.a(l1, comment);
    }

    static void a(j j1, View view)
    {
        j1.a(view);
    }

    private void a(Post post)
    {
        if (c != null && c.postId != null && post != null && post.postId != null && c.postId.equals(post.postId))
        {
            c.isLiked = post.isLiked;
            c.likeCount = post.likeCount;
            c.commentCount = post.commentCount;
        }
    }

    static int b(j j1, int i1)
    {
        i1 = j1.k + i1;
        j1.k = i1;
        return i1;
    }

    static long b(j j1)
    {
        return j1.b;
    }

    private void b(long l1, View view)
    {
        aq.c = "report_comment";
        AccountManager.a(a, new b(l1, view) {

            final long a;
            final View b;
            final j c;

            public void a()
            {
                Globals.b("Get AccountToken Fail");
            }

            public void a(String s)
            {
                if (s != null)
                {
                    DialogUtils.a(c.a, s, "Comment", a, com.cyberlink.beautycircle.utility.DialogUtils.ReportSource.a, new Runnable(this) {

                        final _cls8 a;

                        public void run()
                        {
                            com.cyberlink.beautycircle.controller.activity.j.a(a.c, a.b);
                        }

            
            {
                a = _pcls8;
                super();
            }
                    });
                }
            }

            public void b()
            {
                Globals.b("Get AccountToken Cancel");
            }

            
            {
                c = j.this;
                a = l1;
                b = view;
                super();
            }
        });
    }

    static void b(j j1, long l1, View view)
    {
        j1.b(l1, view);
    }

    static void b(j j1, Post post)
    {
        j1.a(post);
    }

    static int c(j j1, int i1)
    {
        j1.k = i1;
        return i1;
    }

    static SwipeRefreshLayout c(j j1)
    {
        return j1.e;
    }

    static void d(j j1)
    {
        j1.g();
    }

    static ObservableScrollView e(j j1)
    {
        return j1.f;
    }

    static Post f(j j1)
    {
        return j1.d;
    }

    private void f()
    {
        k = 0;
        if (d != null && d.creator != null)
        {
            g();
            d();
            if (com.cyberlink.beautycircle.controller.activity.PostCommentActivity.e(a))
            {
                PostCommentActivity.f(a);
            }
            return;
        } else
        {
            NetworkPost.a(AccountManager.c(), b).a(new com.perfectcorp.utility.m() {

                final j a;

                protected void a(int i1)
                {
                    com.cyberlink.beautycircle.controller.activity.PostCommentActivity.a(a.a, true);
                    a.a.l();
                }

                protected void a(CompletePost completepost)
                {
                    if (completepost == null || completepost.mainPost == null)
                    {
                        com.cyberlink.beautycircle.controller.activity.PostCommentActivity.a(a.a, true);
                        a.a.l();
                        return;
                    }
                    if (com.cyberlink.beautycircle.controller.activity.j.c(a) != null)
                    {
                        com.cyberlink.beautycircle.controller.activity.j.c(a).setRefreshing(false);
                    }
                    com.cyberlink.beautycircle.controller.activity.PostCommentActivity.a(a.a, false);
                    com.cyberlink.beautycircle.controller.activity.j.a(a, completepost.mainPost);
                    com.cyberlink.beautycircle.controller.activity.j.d(a);
                    a.d();
                    if (com.cyberlink.beautycircle.controller.activity.PostCommentActivity.e(a.a))
                    {
                        PostCommentActivity.f(a.a);
                    }
                    a.a.l();
                }

                protected void b(Object obj)
                {
                    a((CompletePost)obj);
                }

            
            {
                a = j.this;
                super();
            }
            });
            return;
        }
    }

    static int g(j j1)
    {
        return j1.k;
    }

    private void g()
    {
        if (d != null)
        {
            f = (ObservableScrollView)i.findViewById(com.cyberlink.beautycircle.j.post_scroll_panel);
            g = (LinearLayout)i.findViewById(com.cyberlink.beautycircle.j.comment_layout);
            h = (LinearLayout)i.findViewById(com.cyberlink.beautycircle.j.comment_layout_outter);
            j = i.findViewById(com.cyberlink.beautycircle.j.more_comment_btn);
            if (j != null)
            {
                j.setVisibility(8);
                j.setOnClickListener(l);
                return;
            }
        }
    }

    static View h(j j1)
    {
        return j1.j;
    }

    private void h()
    {
        e = (SwipeRefreshLayout)i.findViewById(com.cyberlink.beautycircle.j.bc_pull_to_refresh_layout);
        if (e != null)
        {
            e.setColorSchemeResources(new int[] {
                g.bc_color_main_style, g.bc_color_main_style, g.bc_color_main_style, g.bc_color_main_style
            });
            e.setOnRefreshListener(m);
        }
    }

    static LinearLayout i(j j1)
    {
        return j1.g;
    }

    static LinearLayout j(j j1)
    {
        return j1.h;
    }

    protected void a()
    {
        if (com.cyberlink.beautycircle.controller.activity.PostCommentActivity.g(a) == 2)
        {
            f.post(new Runnable() {

                final j a;

                public void run()
                {
                    com.cyberlink.beautycircle.controller.activity.j.a(a, 2);
                }

            
            {
                a = j.this;
                super();
            }
            });
        }
        com.cyberlink.beautycircle.controller.activity.PostCommentActivity.a(a, 0);
    }

    protected void a(long l1, ArrayList arraylist)
    {
        LayoutInflater layoutinflater = (LayoutInflater)a.getSystemService("layout_inflater");
        View view;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); g.addView(view, 0))
        {
            Comment comment = (Comment)arraylist.next();
            view = layoutinflater.inflate(k.bc_view_issue_comment, g, false);
            a(l1, comment, view);
        }

    }

    protected void b()
    {
        g.removeAllViewsInLayout();
        k = 0;
        d();
    }

    protected void c()
    {
        if (g.getChildCount() > 0)
        {
            h.setVisibility(0);
            return;
        } else
        {
            h.setVisibility(8);
            return;
        }
    }

    protected void d()
    {
        NetworkPost.a("Post", d.postId.longValue(), AccountManager.c(), k, 20).a(new com.perfectcorp.utility.m() {

            final j a;

            protected void a(d d1)
            {
                if (j.f(a) != null)
                {
                    com.cyberlink.beautycircle.controller.activity.j.b(a, d1.b.size());
                    a.a(j.f(a).creator.userId, d1.b);
                    a.c();
                    View view = j.h(a);
                    int i1;
                    if (d1.a.intValue() > com.cyberlink.beautycircle.controller.activity.j.g(a))
                    {
                        i1 = 0;
                    } else
                    {
                        i1 = 8;
                    }
                    view.setVisibility(i1);
                }
                a.a();
            }

            protected void b(Object obj)
            {
                a((d)obj);
            }

            
            {
                a = j.this;
                super();
            }
        });
    }

    protected void e()
    {
        String s = com.cyberlink.beautycircle.controller.activity.PostCommentActivity.c(a).getText().toString();
        if (s.isEmpty())
        {
            return;
        } else
        {
            a.i();
            com.cyberlink.beautycircle.controller.activity.PostCommentActivity.d(a).setEnabled(false);
            AccountManager.a(a, new b(s) {

                final String a;
                final j b;

                public void a()
                {
                    com.cyberlink.beautycircle.controller.activity.PostCommentActivity.d(b.a).setEnabled(true);
                    com.perfectcorp.utility.e.e(new Object[] {
                        "getAccountToken Fail"
                    });
                }

                public void a(String s1)
                {
                    if (j.f(b) == null)
                    {
                        return;
                    } else
                    {
                        j.f(b).a(Long.valueOf(j.f(b).commentCount.longValue() + 1L), new r(this) {

                            final _cls13 a;

                            public void a(Post post)
                            {
                                if (post != null)
                                {
                                    com.cyberlink.beautycircle.controller.activity.j.a(a.b, post);
                                }
                                com.cyberlink.beautycircle.controller.activity.j.b(a.b, j.f(a.b));
                            }

            
            {
                a = _pcls13;
                super();
            }
                        });
                        NetworkPost.a(s1, "Post", j.f(b).postId.longValue(), a, new Tags()).a(new com.perfectcorp.utility.m(this) {

                            final _cls13 a;

                            protected void a()
                            {
                                com.cyberlink.beautycircle.controller.activity.PostCommentActivity.d(a.b.a).setEnabled(true);
                            }

                            protected void a(int i1)
                            {
                                if (i1 != 523) goto _L2; else goto _L1
_L1:
                                String s = a.b.a.getResources().getString(m.bc_post_comment_you_blocked_toast);
                                com.perfectcorp.utility.e.a(a.b.a, s);
_L4:
                                com.cyberlink.beautycircle.controller.activity.PostCommentActivity.d(a.b.a).setEnabled(true);
                                return;
_L2:
                                if (i1 == 524)
                                {
                                    String s1 = a.b.a.getResources().getString(m.bc_post_comment_blocked_you_toast);
                                    com.perfectcorp.utility.e.a(a.b.a, s1);
                                }
                                if (true) goto _L4; else goto _L3
_L3:
                            }

                            protected void a(Comment comment)
                            {
                                com.cyberlink.beautycircle.controller.activity.PostCommentActivity.c(a.b.a).setText("");
                                com.cyberlink.beautycircle.controller.activity.PostCommentActivity.d(a.b.a).setEnabled(true);
                                com.cyberlink.beautycircle.controller.activity.j.a(a.b, 2);
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
                                com.cyberlink.beautycircle.controller.activity.j.a(a.b, j.f(a.b).creator.userId, comment);
                                a.b.a.setResult(-1);
                            }

                            protected void b(Object obj)
                            {
                                a((Comment)obj);
                            }

            
            {
                a = _pcls13;
                super();
            }
                        });
                        return;
                    }
                }

                public void b()
                {
                    com.cyberlink.beautycircle.controller.activity.PostCommentActivity.d(b.a).setEnabled(true);
                    com.perfectcorp.utility.e.e(new Object[] {
                        "getAccountToken Abort"
                    });
                }

            
            {
                b = j.this;
                a = s;
                super();
            }
            });
            return;
        }
    }
}
