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
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.a;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.am;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.controller.a.h;
import com.cyberlink.beautycircle.controller.a.s;
import com.cyberlink.beautycircle.controller.adapter.n;
import com.cyberlink.beautycircle.controller.adapter.r;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.controller.fragment.y;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.l;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.BCTileImage;
import com.cyberlink.beautycircle.model.Comment;
import com.cyberlink.beautycircle.model.CompletePost;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.FileMetadata;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.PostBase;
import com.cyberlink.beautycircle.model.Tags;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkContest;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.ac;
import com.cyberlink.beautycircle.utility.ad;
import com.cyberlink.beautycircle.utility.b;
import com.cyberlink.beautycircle.utility.i;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.cyberlink.beautycircle.view.widgetpool.common.CLMultiColumnListView;
import com.cyberlink.beautycircle.view.widgetpool.common.PostContentTextView;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.q;
import com.perfectcorp.utility.u;
import com.rockerhieu.emojicon.EmojiconEditText;
import com.rockerhieu.emojicon.EmojiconTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PostActivity

class g
{

    private android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener A;
    private android.view.View.OnClickListener B;
    private n C;
    int a;
    final PostActivity b;
    private long c;
    private CompletePost d;
    private Post e;
    private Post f;
    private String g;
    private com.cyberlink.beautycircle.model.Contest.VoteStatus h;
    private ArrayList i;
    private SwipeRefreshLayout j;
    private CLMultiColumnListView k;
    private com.cyberlink.beautycircle.controller.adapter.a l;
    private View m;
    private TextView n;
    private LinearLayout o;
    private ArrayList p;
    private View q;
    private View r;
    private boolean s;
    private boolean t;
    private ac u;
    private boolean v;
    private android.view.View.OnClickListener w;
    private android.view.View.OnClickListener x;
    private android.view.View.OnClickListener y;
    private android.view.View.OnClickListener z;

    protected g(PostActivity postactivity, ViewGroup viewgroup, Post post)
    {
        b = postactivity;
        super();
        c = -1L;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = new ArrayList();
        m = null;
        n = null;
        o = null;
        p = new ArrayList();
        q = null;
        r = null;
        a = 0;
        s = false;
        t = false;
        v = false;
        w = new android.view.View.OnClickListener() {

            final g a;

            public void onClick(View view)
            {
                if (com.cyberlink.beautycircle.controller.activity.g.a(a) != null && com.cyberlink.beautycircle.controller.activity.g.a(a).creator != null)
                {
                    com.cyberlink.beautycircle.c.a(a.b, com.cyberlink.beautycircle.controller.activity.g.a(a).creator.userId, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a);
                }
            }

            
            {
                a = g.this;
                super();
            }
        };
        x = new android.view.View.OnClickListener() {

            final g a;

            public void onClick(View view)
            {
                aq.c = "like";
                String s1 = com.cyberlink.beautycircle.controller.activity.PostActivity.a(a.b, com.cyberlink.beautycircle.controller.activity.g.a(a));
                if (s1 != null)
                {
                    com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.e(s1, 0L, "like", PostActivity.f(a.b), 0L));
                }
                com.perfectcorp.a.b.a(new am(am.b, "like", Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.b(a)), Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.a(a).creator.userId), 0L));
                boolean flag = ((Boolean)view.getTag()).booleanValue();
                AccountManager.a(a.b, new b(this, view, flag) {

                    final View a;
                    final boolean b;
                    final _cls18 c;

                    public void a()
                    {
                        Globals.b("Get AccountToken Fail");
                    }

                    public void a(String s1)
                    {
                        c.a.b.runOnUiThread(new Runnable(this) {

                            final _cls1 a;

                            public void run()
                            {
                                boolean flag1 = true;
                                Object obj = a.c.a.b;
                                View view = a.a;
                                TextView textview;
                                int i1;
                                long l1;
                                long l2;
                                boolean flag;
                                if (!a.b)
                                {
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                                com.cyberlink.beautycircle.controller.activity.PostActivity.a(((PostActivity) (obj)), view, flag, true);
                                obj = a.c.a;
                                view = com.cyberlink.beautycircle.controller.activity.g.m(a.c.a);
                                textview = g.p(a.c.a);
                                l1 = com.cyberlink.beautycircle.controller.activity.g.a(a.c.a).likeCount.longValue();
                                if (a.b)
                                {
                                    i1 = -1;
                                } else
                                {
                                    i1 = 1;
                                }
                                l2 = i1;
                                if (!a.b)
                                {
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                                com.cyberlink.beautycircle.controller.activity.g.a(((g) (obj)), view, textview, l1 + l2, flag);
                                obj = com.cyberlink.beautycircle.controller.activity.g.a(a.c.a);
                                if (!a.b)
                                {
                                    flag = flag1;
                                } else
                                {
                                    flag = false;
                                }
                                ((Post) (obj)).a(flag, new com.cyberlink.beautycircle.model.r(this) {

                                    final _cls1 a;

                                    public void a(Post post)
                                    {
                                        if (post != null)
                                        {
                                            com.cyberlink.beautycircle.controller.activity.g.a(a.a.c.a, post);
                                        }
                                        a.a.c.a.a(com.cyberlink.beautycircle.controller.activity.g.a(a.a.c.a));
                                        com.cyberlink.beautycircle.controller.activity.g.b(a.a.c.a, com.cyberlink.beautycircle.controller.activity.g.a(a.a.c.a));
                                    }

            
            {
                a = _pcls1;
                super();
            }
                                });
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                        if (b)
                        {
                            NetworkPost.b(s1, "Post", com.cyberlink.beautycircle.controller.activity.g.a(c.a).postId.longValue());
                        } else
                        {
                            NetworkPost.a(s1, "Post", com.cyberlink.beautycircle.controller.activity.g.a(c.a).postId.longValue());
                            BCTileImage.a(com.cyberlink.beautycircle.controller.activity.g.a(c.a));
                        }
                        t.d.a();
                    }

                    public void b()
                    {
                        Globals.b("Get AccountToken Cancel");
                    }

            
            {
                c = _pcls18;
                a = view;
                b = flag;
                super();
            }
                });
            }

            
            {
                a = g.this;
                super();
            }
        };
        y = new android.view.View.OnClickListener() {

            final g a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.c.a(a.b, com.cyberlink.beautycircle.controller.activity.g.a(a), false, 2);
            }

            
            {
                a = g.this;
                super();
            }
        };
        z = new android.view.View.OnClickListener() {

            final g a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.c.a(a.b, "Post", com.cyberlink.beautycircle.controller.activity.g.a(a).postId.longValue());
            }

            
            {
                a = g.this;
                super();
            }
        };
        A = new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

            final g a;

            public void onRefresh()
            {
                LinearLayout linearlayout = (LinearLayout)g.o(a).findViewById(j.post_layout);
                if (linearlayout != null)
                {
                    int i1 = linearlayout.getChildCount();
                    if (i1 > 1)
                    {
                        linearlayout.removeViews(1, i1 - 1);
                    }
                }
                if (com.cyberlink.beautycircle.controller.activity.g.q(a) != null)
                {
                    com.cyberlink.beautycircle.controller.activity.g.q(a).removeAllViews();
                }
                a.a = 0;
                com.cyberlink.beautycircle.controller.activity.g.c(a);
            }

            
            {
                a = g.this;
                super();
            }
        };
        B = new android.view.View.OnClickListener() {

            final g a;

            public void onClick(View view)
            {
                String s1 = com.cyberlink.beautycircle.controller.activity.PostActivity.a(a.b, com.cyberlink.beautycircle.controller.activity.g.a(a));
                if (s1 != null)
                {
                    com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.e(s1, 0L, "share", PostActivity.f(a.b), 0L));
                }
                com.perfectcorp.a.b.a(new am(am.b, "share", Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.b(a)), Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.a(a).creator.userId), 0L));
                a.b.a(view, com.cyberlink.beautycircle.controller.activity.g.a(a));
            }

            
            {
                a = g.this;
                super();
            }
        };
        C = new n() {

            final g a;

            public void a()
            {
                View view;
                com.perfectcorp.utility.e.b(new Object[0]);
                com.cyberlink.beautycircle.controller.activity.g.s(a).b(a.b());
                view = g.o(a).findViewById(j.post_related_posts);
                if (g.f(a)) goto _L2; else goto _L1
_L1:
                com.cyberlink.beautycircle.controller.activity.g.s(a).clear();
                if (view != null)
                {
                    view.setVisibility(8);
                }
_L4:
                if (com.cyberlink.beautycircle.controller.activity.g.s(a).getCount() > 80)
                {
                    com.cyberlink.beautycircle.controller.activity.g.s(a).c(false);
                }
                return;
_L2:
                if (view != null)
                {
                    view.setVisibility(0);
                    if (!com.cyberlink.beautycircle.controller.activity.g.t(a))
                    {
                        com.perfectcorp.a.b.a(new am(am.b, "related_post_show", com.cyberlink.beautycircle.controller.activity.g.a(a).postId, Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.a(a).creator.userId), 0L));
                    }
                    com.cyberlink.beautycircle.controller.activity.g.b(a, true);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            public void a(int i1)
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    Integer.valueOf(i1)
                });
            }

            public void a(Post post1)
            {
                if (post1 == null)
                {
                    return;
                } else
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        post1.postId
                    });
                    a.b.a(post1);
                    return;
                }
            }

            public void a(boolean flag)
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    Boolean.valueOf(flag)
                });
            }

            public void b(boolean flag)
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    Boolean.valueOf(flag)
                });
            }

            
            {
                a = g.this;
                super();
            }
        };
        e = post;
        f = post;
        if (post != null)
        {
            c = post.postId.longValue();
        }
        q = ((LayoutInflater)postactivity.getSystemService("layout_inflater")).inflate(k.bc_view_item_post_container, viewgroup, false);
        q.setTag(Integer.valueOf(hashCode()));
        if (f.creator != null)
        {
            com.cyberlink.beautycircle.controller.activity.PostActivity.b(postactivity, false);
        }
        o();
        n();
        c();
        viewgroup.addView(q);
    }

    static CompletePost a(g g1, CompletePost completepost)
    {
        g1.d = completepost;
        return completepost;
    }

    static com.cyberlink.beautycircle.model.Contest.VoteStatus a(g g1, com.cyberlink.beautycircle.model.Contest.VoteStatus votestatus)
    {
        g1.h = votestatus;
        return votestatus;
    }

    static Post a(g g1)
    {
        return g1.f;
    }

    static Post a(g g1, Post post)
    {
        g1.f = post;
        return post;
    }

    static ac a(g g1, ac ac1)
    {
        g1.u = ac1;
        return ac1;
    }

    private void a(int i1)
    {
        if (k != null)
        {
            if (i1 == 1)
            {
                k.post(new Runnable() {

                    final g a;

                    public void run()
                    {
                        com.cyberlink.beautycircle.controller.activity.g.l(a).l(33);
                    }

            
            {
                a = g.this;
                super();
            }
                });
                return;
            }
            if (i1 == 2)
            {
                k.post(new Runnable() {

                    final g a;

                    public void run()
                    {
                        com.cyberlink.beautycircle.controller.activity.g.l(a).l(130);
                    }

            
            {
                a = g.this;
                super();
            }
                });
                return;
            }
            if (i1 == 3)
            {
                k.post(new Runnable() {

                    final g a;

                    public void run()
                    {
                        com.cyberlink.beautycircle.controller.activity.g.l(a).scrollTo(0, com.cyberlink.beautycircle.controller.activity.g.m(a).getBottom());
                    }

            
            {
                a = g.this;
                super();
            }
                });
                return;
            }
            if (i1 == 4)
            {
                k.post(new Runnable() {

                    final g a;

                    public void run()
                    {
                        if (com.cyberlink.beautycircle.controller.activity.g.n(a) == null || com.cyberlink.beautycircle.controller.activity.g.n(a).isEmpty())
                        {
                            return;
                        } else
                        {
                            ac ac1 = (ac)com.cyberlink.beautycircle.controller.activity.g.n(a).get(0);
                            ac1.a.onClick(null);
                            Rect rect = new Rect();
                            ac1.b(rect);
                            com.cyberlink.beautycircle.controller.activity.g.l(a).scrollTo(0, rect.top);
                            return;
                        }
                    }

            
            {
                a = g.this;
                super();
            }
                });
                return;
            }
        }
    }

    private void a(long l1, View view)
    {
        String s1 = AccountManager.b();
        if (s1 == null || s1.isEmpty())
        {
            return;
        }
        if (f != null)
        {
            f.a(Long.valueOf(f.commentCount.longValue() - 1L), new com.cyberlink.beautycircle.model.r() {

                final g a;

                public void a(Post post)
                {
                    if (post != null)
                    {
                        com.cyberlink.beautycircle.controller.activity.g.a(a, post);
                    }
                    a.a(com.cyberlink.beautycircle.controller.activity.g.a(a));
                    com.cyberlink.beautycircle.controller.activity.g.b(a, com.cyberlink.beautycircle.controller.activity.g.a(a));
                }

            
            {
                a = g.this;
                super();
            }
            });
        }
        DialogUtils.a(b, "", b.getResources().getString(m.bc_post_comment_delete_confirm_text), b.getResources().getString(m.bc_post_cancel), new Runnable() {

            final g a;

            public void run()
            {
            }

            
            {
                a = g.this;
                super();
            }
        }, b.getResources().getString(m.bc_post_comment_menu_delete), new Runnable(s1, l1, view) {

            final String a;
            final long b;
            final View c;
            final g d;

            public void run()
            {
                NetworkPost.b(a, Long.valueOf(b));
                com.cyberlink.beautycircle.controller.activity.g.a(d, c);
            }

            
            {
                d = g.this;
                a = s1;
                b = l1;
                c = view;
                super();
            }
        });
    }

    private void a(long l1, Comment comment)
    {
        View view = ((LayoutInflater)b.getSystemService("layout_inflater")).inflate(k.bc_view_issue_comment, o, false);
        a(l1, comment, view);
        o.addView(view);
        ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[] {
            PropertyValuesHolder.ofFloat("alpha", new float[] {
                0.0F, 1.0F
            }), PropertyValuesHolder.ofFloat("translationX", new float[] {
                (float)o.getWidth(), 0.0F
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
            final g c;

            public boolean onLongClick(View view1)
            {
                boolean flag1 = false;
                PopupMenu popupmenu = new PopupMenu(c.b, view1);
                Menu menu = popupmenu.getMenu();
                if (e.a)
                {
                    menu.add(m.bc_post_comment_menu_copy).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(this) {

                        final _cls27 a;

                        public boolean onMenuItemClick(MenuItem menuitem)
                        {
                            ((ClipboardManager)a.c.b.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, a.a.comment));
                            return true;
                        }

            
            {
                a = _pcls27;
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
                        final _cls27 b;

                        public boolean onMenuItemClick(MenuItem menuitem)
                        {
                            com.cyberlink.beautycircle.controller.activity.g.a(b.c, b.a.commentId, a);
                            return true;
                        }

            
            {
                b = _pcls27;
                a = view;
                super();
            }
                    });
                }
                if (userinfo != null && userinfo.id == a.creator.userId)
                {
                    menu.add(m.bc_post_comment_menu_edit).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(this) {

                        final _cls27 a;

                        public boolean onMenuItemClick(MenuItem menuitem)
                        {
                            com.cyberlink.beautycircle.controller.activity.PostActivity.a(a.c.b, a.a);
                            return true;
                        }

            
            {
                a = _pcls27;
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
                        final _cls27 b;

                        public boolean onMenuItemClick(MenuItem menuitem)
                        {
                            com.cyberlink.beautycircle.controller.activity.g.b(b.c, b.a.commentId, a);
                            return true;
                        }

            
            {
                b = _pcls27;
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
                c = g.this;
                a = comment;
                b = l1;
                super();
            }
        });
        Object obj = (UICImageView)view.findViewById(j.comment_avatar);
        if (obj != null)
        {
            ((UICImageView) (obj)).setImageURI(comment.creator.avatar);
            ((UICImageView) (obj)).setOnClickListener(new android.view.View.OnClickListener(comment) {

                final Comment a;
                final g b;

                public void onClick(View view1)
                {
                    com.cyberlink.beautycircle.c.a(b.b, a.creator.userId, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a);
                }

            
            {
                b = g.this;
                a = comment;
                super();
            }
            });
        }
        obj = (ImageView)view.findViewById(j.avatar_crown);
        if (comment.creator != null)
        {
            com.cyberlink.beautycircle.a.a(((ImageView) (obj)), comment.creator.userType);
        }
        obj = (EmojiconTextView)view.findViewById(j.comment_auther);
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
                final g b;

                public void onClick(View view1)
                {
                    com.cyberlink.beautycircle.c.a(b.b, a.creator.userId, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a);
                }

            
            {
                b = g.this;
                a = comment;
                super();
            }
            });
        }
        obj = (PostContentTextView)view.findViewById(j.comment_text);
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
        com.cyberlink.beautycircle.controller.activity.PostActivity.a(b, (TextView)view.findViewById(j.comment_time), comment.lastModified, comment.isLiked, comment.likeCount, comment.commentId);
    }

    private void a(View view, TextView textview, long l1, boolean flag)
    {
label0:
        {
            if (textview != null && view != null)
            {
                if (l1 != 0L)
                {
                    break label0;
                }
                view.setVisibility(8);
            }
            return;
        }
        view.setVisibility(0);
        if (flag && l1 == 1L)
        {
            textview.setText(b.getResources().getString(m.bc_you_like_countpattern));
            return;
        }
        if (flag && l1 > 1L)
        {
            textview.setText(b.getResources().getQuantityString(l.bc_you_countpattern_like_count, (int)l1 - 1, new Object[] {
                Long.valueOf(l1 - 1L)
            }));
            return;
        } else
        {
            textview.setText(b.getResources().getQuantityString(l.bc_countpattern_like_count, (int)l1, new Object[] {
                Long.valueOf(l1)
            }));
            return;
        }
    }

    private void a(View view, PostBase postbase)
    {
        View view1 = view.findViewById(j.post_photo);
        if (view1 != null)
        {
            view1.setVisibility(8);
        }
        view = (PostContentTextView)view.findViewById(j.post_article);
        com.cyberlink.beautycircle.controller.activity.PostActivity.a(b, view, postbase.content);
    }

    private void a(View view, PostBase postbase, com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile postattachmentfile, int i1, int j1)
    {
        boolean flag = true;
        boolean flag1 = false;
        if (i1 == 0)
        {
            g = f.extLookUrl;
        }
        if (i1 == j1)
        {
            f.extLookUrl = g;
        }
        View view1;
        int k1;
        if (!"ymk".equals(PostActivity.g(b)) && f.extLookUrl != null && !f.extLookUrl.isEmpty() && (i1 == 0 || i1 > 1 && i1 == j1))
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        if (f.extLookUrl != null && !f.extLookUrl.isEmpty() && i1 > 0)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (f.extLookUrl == null || f.extLookUrl.isEmpty() || i1 != 1)
        {
            flag = false;
        }
        view1 = view.findViewById(j.post_how_to_view);
        if (view1 != null)
        {
            View view2;
            int l1;
            if (j1 != 0)
            {
                l1 = 0;
            } else
            {
                l1 = 8;
            }
            view1.setVisibility(l1);
        }
        view2 = view.findViewById(j.post_try_it_outter);
        if (view2 != null)
        {
            Object obj;
            if (k1 != 0)
            {
                k1 = 0;
            } else
            {
                k1 = 8;
            }
            view2.setVisibility(k1);
            if (f.extLookUrl != null && !f.extLookUrl.isEmpty())
            {
                obj = Uri.parse(f.extLookUrl);
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                view2.setOnClickListener(new android.view.View.OnClickListener(((Uri) (obj))) {

                    final Uri a;
                    final g b;

                    public void onClick(View view3)
                    {
                        long l2 = System.currentTimeMillis();
                        com.perfectcorp.a.b.a(new s(PostActivity.g(b.b), "try_it", null, com.cyberlink.beautycircle.controller.activity.g.a(b).postId, l2 - PostActivity.p(b.b).longValue()));
                        com.perfectcorp.utility.g.a(b.b, a);
                    }

            
            {
                b = g.this;
                a = uri;
                super();
            }
                });
            }
        }
        obj = (TextView)view.findViewById(j.post_steps);
        if (obj != null)
        {
            if (flag)
            {
                k1 = 0;
            } else
            {
                k1 = 8;
            }
            ((TextView) (obj)).setVisibility(k1);
        }
        obj = (TextView)view.findViewById(j.post_how_to_header_subtitle);
        if (obj != null && postbase.tags != null)
        {
            if (j1 != 0)
            {
                k1 = 0;
            } else
            {
                k1 = 8;
            }
            ((TextView) (obj)).setVisibility(k1);
            ((TextView) (obj)).setText(postbase.tags.lookTag);
        }
        postbase = (TextView)view.findViewById(j.post_how_to_header_index);
        if (postbase != null)
        {
            if (j1 != 0)
            {
                k1 = 0;
            } else
            {
                k1 = 8;
            }
            postbase.setVisibility(k1);
            postbase.setText(Integer.toString(i1));
        }
        view = (ImageView)view.findViewById(j.storelink_btn);
        postbase = postattachmentfile.b().lookStoreUrl;
        if (view != null && postbase != null && !postbase.toString().isEmpty())
        {
            if (j1 != 0)
            {
                i1 = ((flag1) ? 1 : 0);
            } else
            {
                i1 = 8;
            }
            view.setVisibility(i1);
            view.setOnClickListener(new android.view.View.OnClickListener(postbase) {

                final Uri a;
                final g b;

                public void onClick(View view3)
                {
                    com.perfectcorp.utility.g.a(b.b, a);
                }

            
            {
                b = g.this;
                a = uri;
                super();
            }
            });
        }
    }

    private void a(View view, PostBase postbase, com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile postattachmentfile, Uri uri, int i1, int j1)
    {
        b(view, postbase);
        View view1 = view.findViewById(j.post_photo);
        View view2 = view.findViewById(j.post_box);
        PostContentTextView postcontenttextview = (PostContentTextView)view.findViewById(j.post_article);
        TextView textview = (TextView)view.findViewById(j.post_host);
        a(view, postbase, postattachmentfile, i1, j1);
        view = postattachmentfile.b();
        if (view1 != null && ((FileMetadata) (view)).originalUrl != null)
        {
            view1.setVisibility(0);
            postattachmentfile = (UICImageView)view1.findViewById(j.tag_points_photo);
            postattachmentfile.setDrawDefaultWhenChangingImage(false);
            postattachmentfile.a(((FileMetadata) (view)).originalUrl, ((FileMetadata) (view)).width, ((FileMetadata) (view)).height);
            view2.setOnClickListener(new android.view.View.OnClickListener(uri) {

                final Uri a;
                final g b;

                public void onClick(View view3)
                {
                    com.perfectcorp.a.b.a(new h(Long.toString(com.cyberlink.beautycircle.controller.activity.g.a(b).postId.longValue())));
                    if (ad.d(a) && com.cyberlink.beautycircle.controller.activity.g.a(b).extLookUrl != null && !com.cyberlink.beautycircle.controller.activity.g.a(b).extLookUrl.isEmpty())
                    {
                        long l1 = System.currentTimeMillis();
                        com.perfectcorp.a.b.a(new s(PostActivity.g(b.b), "video_play", null, com.cyberlink.beautycircle.controller.activity.g.a(b).postId, l1 - PostActivity.p(b.b).longValue()));
                    }
                    if (!ad.a(b.b, a))
                    {
                        com.cyberlink.beautycircle.c.a(b.b, a.toString(), 2);
                    }
                }

            
            {
                b = g.this;
                a = uri;
                super();
            }
            });
            view = view1.findViewById(j.post_play_icon);
            if (view != null)
            {
                if (ad.d(uri))
                {
                    view.setVisibility(0);
                } else
                {
                    view.setVisibility(8);
                }
            }
            a(view1, true, uri, Long.toString(f.postId.longValue()));
        }
        com.cyberlink.beautycircle.controller.activity.PostActivity.a(b, postcontenttextview, postbase.content);
        view2.setBackgroundResource(com.cyberlink.beautycircle.g.bc_issue_redirect);
        if (postcontenttextview != null)
        {
            postcontenttextview.setPadding(Globals.a(10), 0, Globals.a(10), 0);
        }
        if (textview != null)
        {
            view = com.perfectcorp.utility.u.a(uri.toString(), true);
            if (view != null)
            {
                textview.setText(view);
                textview.setPadding(Globals.a(10), 0, Globals.a(10), Globals.a(10));
                textview.setVisibility(0);
            }
        }
    }

    private void a(View view, boolean flag, Uri uri, String s1)
    {
        if (!t)
        {
            if (flag)
            {
                view.setOnClickListener(new android.view.View.OnClickListener(uri, s1) {

                    final Uri a;
                    final String b;
                    final g c;

                    public void onClick(View view1)
                    {
                        if (a != null)
                        {
                            com.perfectcorp.a.b.a(new h(b));
                            if (ad.d(a) && com.cyberlink.beautycircle.controller.activity.g.a(c).extLookUrl != null && !com.cyberlink.beautycircle.controller.activity.g.a(c).extLookUrl.isEmpty())
                            {
                                long l1 = System.currentTimeMillis();
                                com.perfectcorp.a.b.a(new s(PostActivity.g(c.b), "video_play", null, com.cyberlink.beautycircle.controller.activity.g.a(c).postId, l1 - PostActivity.p(c.b).longValue()));
                            }
                            if (!ad.a(c.b, a))
                            {
                                com.cyberlink.beautycircle.c.a(c.b, a.toString(), 2);
                            }
                        }
                    }

            
            {
                c = g.this;
                a = uri;
                b = s1;
                super();
            }
                });
            }
            view.setOnLongClickListener(new android.view.View.OnLongClickListener(view) {

                final View a;
                final g b;

                public boolean onLongClick(View view1)
                {
                    a.setOnClickListener(null);
                    b.b.a(com.cyberlink.beautycircle.controller.activity.g.a(b));
                    return false;
                }

            
            {
                b = g.this;
                a = view;
                super();
            }
            });
            return;
        } else
        {
            view.setOnTouchListener(new android.view.View.OnTouchListener(view) {

                public long a;
                public long b;
                public PointF c;
                public long d;
                public Runnable e;
                final View f;
                final g g;

                public boolean a(float f1, float f2, float f3)
                {
                    return f1 >= -f3 && f2 >= -f3 && f1 < (float)(f.getRight() - f.getLeft()) + f3 && f2 < (float)(f.getBottom() - f.getTop()) + f3;
                }

                public boolean onTouch(View view1, MotionEvent motionevent)
                {
                    if (motionevent.getAction() != 0) goto _L2; else goto _L1
_L1:
                    a = System.currentTimeMillis();
                    c.set(motionevent.getX(), motionevent.getY());
                    f.postDelayed(e, b);
_L4:
                    return false;
_L2:
                    if (motionevent.getAction() == 1)
                    {
                        if (System.currentTimeMillis() - a < b)
                        {
                            f.removeCallbacks(e);
                        }
                    } else
                    if (!a(motionevent.getX(), motionevent.getY(), d))
                    {
                        f.removeCallbacks(e);
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                g = g.this;
                f = view;
                super();
                a = 0L;
                b = 250L;
                c = new PointF();
                d = ViewConfiguration.get(f.getContext()).getScaledTouchSlop();
                e = new _cls1(this);
            }
            });
            return;
        }
    }

    private void a(TextView textview, Post post, boolean flag)
    {
        if (textview != null && post != null)
        {
            String s2 = "";
            String s1 = s2;
            if (flag)
            {
                s1 = s2;
                if (post.circles != null)
                {
                    s1 = s2;
                    if (post.circles.size() > 0)
                    {
                        String s3 = ((com.cyberlink.beautycircle.model.Post.PostCircle)post.circles.get(0)).circleName;
                        s1 = s3;
                        if (s3 == null)
                        {
                            s1 = "";
                        }
                    }
                }
            }
            if (post.createdTime != null)
            {
                int i1 = (int)((double)textview.getTextSize() * 0.80000000000000004D);
                if (b.p == null)
                {
                    b.p = new DynamicDrawableSpan(1, i1) {

                        final int a;
                        final g b;

                        public Drawable getDrawable()
                        {
                            Drawable drawable = b.b.getResources().getDrawable(com.cyberlink.beautycircle.i.bc_issue_comment_time);
                            if (drawable != null)
                            {
                                drawable.setBounds(0, 0, a, a);
                            }
                            return drawable;
                        }

            
            {
                b = g.this;
                a = j1;
                super(i1);
            }
                    };
                }
                post = new SpannableString((new StringBuilder()).append("  ").append(com.cyberlink.beautycircle.utility.i.a(post.createdTime)).toString());
                post.setSpan(b.p, 0, 1, 17);
                textview.setText(post);
                if (s1.length() != 0)
                {
                    textview.append(" \u2022 ");
                    if (b.q == null)
                    {
                        b.q = new DynamicDrawableSpan(1, i1) {

                            final int a;
                            final g b;

                            public Drawable getDrawable()
                            {
                                Drawable drawable = b.b.getResources().getDrawable(com.cyberlink.beautycircle.i.bc_issue_repost);
                                if (drawable != null)
                                {
                                    drawable.setBounds(0, 0, a, a);
                                }
                                return drawable;
                            }

            
            {
                b = g.this;
                a = j1;
                super(i1);
            }
                        };
                    }
                    post = new SpannableString((new StringBuilder()).append("  ").append(s1).toString());
                    post.setSpan(b.q, 0, 1, 17);
                    textview.append(post);
                }
            }
        }
    }

    static void a(g g1, int i1)
    {
        g1.a(i1);
    }

    static void a(g g1, long l1, View view)
    {
        g1.a(l1, view);
    }

    static void a(g g1, long l1, Comment comment)
    {
        g1.a(l1, comment);
    }

    static void a(g g1, View view)
    {
        g1.b(view);
    }

    static void a(g g1, View view, TextView textview, long l1, boolean flag)
    {
        g1.a(view, textview, l1, flag);
    }

    static void a(g g1, ArrayList arraylist, boolean flag)
    {
        g1.a(arraylist, flag);
    }

    private void a(ArrayList arraylist, boolean flag)
    {
        if (arraylist == null || arraylist.size() <= 0)
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "subPosts is null or empty"
            });
        } else
        {
            i.addAll(arraylist);
            LinearLayout linearlayout = (LinearLayout)r.findViewById(j.post_layout);
            LayoutInflater layoutinflater = (LayoutInflater)b.getSystemService("layout_inflater");
            int i1 = 0;
            Iterator iterator = arraylist.iterator();
            while (iterator.hasNext()) 
            {
                PostBase postbase = (PostBase)iterator.next();
                if (postbase != null)
                {
                    int j1 = i1;
                    if (!flag)
                    {
                        j1 = i1 + 1;
                    }
                    Object obj = null;
                    Object obj1 = null;
                    if (postbase.attachments != null)
                    {
                        com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile postattachmentfile1 = postbase.attachments.c();
                        com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile postattachmentfile = postbase.attachments.d();
                        obj = postattachmentfile1;
                        obj1 = postattachmentfile;
                        if (postattachmentfile1 == null)
                        {
                            obj = postattachmentfile;
                            obj1 = postattachmentfile;
                        }
                    }
                    Uri uri;
                    if (postbase instanceof Post)
                    {
                        uri = ((Post)postbase).d();
                    } else
                    {
                        uri = null;
                    }
                    if (uri == null && obj != null)
                    {
                        obj1 = layoutinflater.inflate(k.bc_view_item_post_content_photo, linearlayout, false);
                        b(((View) (obj1)), postbase, ((com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile) (obj)), j1, arraylist.size());
                        obj = obj1;
                    } else
                    if (uri != null && obj1 != null)
                    {
                        obj = layoutinflater.inflate(k.bc_view_item_post_content_photo, linearlayout, false);
                        a(((View) (obj)), postbase, ((com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile) (obj1)), uri, j1, arraylist.size());
                    } else
                    {
                        obj = layoutinflater.inflate(k.bc_view_item_post_content_photo, linearlayout, false);
                        a(((View) (obj)), postbase);
                    }
                    i1 = j1;
                    if (obj != null)
                    {
                        linearlayout.addView(((View) (obj)));
                        i1 = j1;
                    }
                }
            }
        }
    }

    static boolean a(g g1, boolean flag)
    {
        g1.s = flag;
        return flag;
    }

    static long b(g g1)
    {
        return g1.c;
    }

    private void b(long l1, View view)
    {
        aq.c = "report_comment";
        AccountManager.a(b, new b(l1, view) {

            final long a;
            final View b;
            final g c;

            public void a()
            {
                Globals.b("Get AccountToken Fail");
            }

            public void a(String s1)
            {
                if (s1 != null)
                {
                    DialogUtils.a(c.b, s1, "Comment", a, com.cyberlink.beautycircle.utility.DialogUtils.ReportSource.a, new Runnable(this) {

                        final _cls30 a;

                        public void run()
                        {
                            com.cyberlink.beautycircle.controller.activity.g.a(a.c, a.b);
                        }

            
            {
                a = _pcls30;
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
                c = g.this;
                a = l1;
                b = view;
                super();
            }
        });
    }

    private void b(View view)
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[] {
            PropertyValuesHolder.ofFloat("alpha", new float[] {
                1.0F, 0.0F
            }), PropertyValuesHolder.ofFloat("translationX", new float[] {
                0.0F, (float)(o.getWidth() * -1)
            })
        }).setDuration(300L);
        objectanimator.addListener(new android.animation.Animator.AnimatorListener(view) {

            final View a;
            final g b;

            public void onAnimationCancel(Animator animator)
            {
                onAnimationEnd(animator);
            }

            public void onAnimationEnd(Animator animator)
            {
                com.cyberlink.beautycircle.controller.activity.g.q(b).removeView(a);
                if (com.cyberlink.beautycircle.controller.activity.g.q(b).getChildCount() == 0)
                {
                    b.e();
                }
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                b = g.this;
                a = view;
                super();
            }
        });
        objectanimator.start();
    }

    private void b(View view, PostBase postbase)
    {
        if (postbase.tags != null && postbase.tags.productTags != null && postbase.tags.productTags.size() > 0)
        {
            view = new ac(view, true, false, true);
            view.a(postbase.tags.productTags);
            view.a(new android.view.View.OnLongClickListener(view) {

                final ac a;
                final g b;

                public boolean onLongClick(View view1)
                {
                    view1.setOnClickListener(null);
                    com.cyberlink.beautycircle.controller.activity.g.a(b, a);
                    b.b.a(com.cyberlink.beautycircle.controller.activity.g.a(b));
                    return false;
                }

            
            {
                b = g.this;
                a = ac1;
                super();
            }
            });
            p.add(view);
            return;
        } else
        {
            view = new ac(view, false, false, false);
            view.a(null);
            view.a(null);
            return;
        }
    }

    private void b(View view, PostBase postbase, com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile postattachmentfile, int i1, int j1)
    {
        b(view, postbase);
        View view1 = view.findViewById(j.post_photo);
        a(view, postbase, postattachmentfile, i1, j1);
        postattachmentfile = postattachmentfile.b();
        if (view1 != null && ((FileMetadata) (postattachmentfile)).originalUrl != null)
        {
            view1.setVisibility(0);
            UICImageView uicimageview = (UICImageView)view1.findViewById(j.tag_points_photo);
            uicimageview.setDrawDefaultWhenChangingImage(false);
            uicimageview.a(((FileMetadata) (postattachmentfile)).originalUrl, ((FileMetadata) (postattachmentfile)).width, ((FileMetadata) (postattachmentfile)).height);
            view1.setTag(postattachmentfile);
            a(view1, true, ((Uri) (null)), ((String) (null)));
        }
        view = (PostContentTextView)view.findViewById(j.post_article);
        com.cyberlink.beautycircle.controller.activity.PostActivity.a(b, view, postbase.content);
    }

    static void b(g g1, long l1, View view)
    {
        g1.b(l1, view);
    }

    static void b(g g1, Post post)
    {
        g1.b(post);
    }

    private void b(Post post)
    {
        if (e != null && e.postId != null && post != null && post.postId != null && e.postId.equals(post.postId))
        {
            e.isLiked = post.isLiked;
            e.likeCount = post.likeCount;
            e.commentCount = post.commentCount;
        }
    }

    static boolean b(g g1, boolean flag)
    {
        g1.v = flag;
        return flag;
    }

    static void c(g g1)
    {
        g1.l();
    }

    static boolean d(g g1)
    {
        return g1.s;
    }

    static void e(g g1)
    {
        g1.m();
    }

    static boolean f(g g1)
    {
        return g1.q();
    }

    static com.cyberlink.beautycircle.model.Contest.VoteStatus g(g g1)
    {
        return g1.h;
    }

    static View h(g g1)
    {
        return g1.q;
    }

    static SwipeRefreshLayout i(g g1)
    {
        return g1.j;
    }

    static void j(g g1)
    {
        g1.n();
    }

    static void k(g g1)
    {
        g1.p();
    }

    static CLMultiColumnListView l(g g1)
    {
        return g1.k;
    }

    private void l()
    {
        a = 0;
        NetworkPost.a(AccountManager.c(), c).a(new com.perfectcorp.utility.m() {

            final g a;

            protected void a(int i1)
            {
                com.cyberlink.beautycircle.controller.activity.PostActivity.b(a.b, true);
                a.b.l();
            }

            protected void a(CompletePost completepost)
            {
                if (completepost == null || completepost.mainPost == null)
                {
                    com.cyberlink.beautycircle.controller.activity.PostActivity.b(a.b, true);
                    a.b.l();
                    return;
                }
                if (com.cyberlink.beautycircle.controller.activity.g.i(a) != null)
                {
                    com.cyberlink.beautycircle.controller.activity.g.i(a).setRefreshing(false);
                }
                com.cyberlink.beautycircle.controller.activity.g.a(a, true);
                com.cyberlink.beautycircle.controller.activity.PostActivity.b(a.b, false);
                com.cyberlink.beautycircle.controller.activity.g.a(a, completepost);
                com.cyberlink.beautycircle.controller.activity.g.a(a, completepost.mainPost);
                com.cyberlink.beautycircle.controller.activity.g.j(a);
                a.c();
                com.cyberlink.beautycircle.controller.activity.g.a(a, completepost.subPosts, false);
                a.d();
                BCTileImage.a(completepost.mainPost);
                com.cyberlink.beautycircle.controller.activity.g.e(a);
                a.f();
                a.b.l();
            }

            protected void b(Object obj)
            {
                a((CompletePost)obj);
            }

            
            {
                a = g.this;
                super();
            }
        });
    }

    static View m(g g1)
    {
        return g1.m;
    }

    private void m()
    {
        b.b().c("");
        if ("contest".equals(f.postSource))
        {
            b.b().a(0x80000000, x.a, 0, 0);
            View view = r.findViewById(j.post_related_posts);
            if (view != null && "contest".equals(PostActivity.g(b)))
            {
                view.setVisibility(8);
            }
            NetworkContest.e(f.postId).a(new com.perfectcorp.utility.m() {

                final g a;

                protected void a(com.cyberlink.beautycircle.model.network.NetworkContest.QueryVoteStatusResult queryvotestatusresult)
                {
label0:
                    {
                        if (queryvotestatusresult != null && queryvotestatusresult.result != null)
                        {
                            com.cyberlink.beautycircle.controller.activity.g.a(a, queryvotestatusresult.result);
                            if (g.g(a).isVotePeriod == null || g.g(a).isVotePeriod.booleanValue())
                            {
                                break label0;
                            }
                            a.b.b().a(0xc8000000, x.a, x.m, 0);
                        }
                        return;
                    }
                    com.cyberlink.beautycircle.controller.activity.PostActivity.a(a.b, g.g(a), 0);
                    if (queryvotestatusresult.result.isVote != null && queryvotestatusresult.result.isVote.booleanValue())
                    {
                        a.b.b().a(0xc1000000, x.a, 0, y.f);
                        com.cyberlink.beautycircle.controller.activity.PostActivity.a(a.b, true);
                        return;
                    } else
                    {
                        a.b.b().a(0xc1000000, x.a, 0, y.e);
                        com.cyberlink.beautycircle.controller.activity.PostActivity.a(a.b, false);
                        return;
                    }
                }

                protected void b(Object obj)
                {
                    a((com.cyberlink.beautycircle.model.network.NetworkContest.QueryVoteStatusResult)obj);
                }

            
            {
                a = g.this;
                super();
            }
            });
            return;
        }
        if ("howto".equals(com.cyberlink.beautycircle.controller.activity.PostActivity.l(b)))
        {
            b.b().b("");
            if (l.getCount() == 0)
            {
                b.b().a(0xc4000000, x.a, x.k, 0);
            } else
            {
                b.b().g(true);
            }
            b.b().a(0xc1000000, x.a, 0, y.g);
            return;
        } else
        {
            b.b().b("");
            b.b().a(0xc8000000, x.a, x.m, 0);
            return;
        }
    }

    static ArrayList n(g g1)
    {
        return g1.p;
    }

    private void n()
    {
        boolean flag = true;
        p.clear();
        if (f != null)
        {
            k = (CLMultiColumnListView)q.findViewById(j.related_posts_list);
            if (r == null)
            {
                r = ((LayoutInflater)b.getSystemService("layout_inflater")).inflate(k.bc_view_item_post, k, false);
                k.c(r);
            }
            if (l == null)
            {
                l = new r(b, k, k.bc_view_item_discover_list, Long.valueOf(c), null, C);
                l.a_();
            }
            if (l != null && s)
            {
                l.c();
            }
            k.setOnScrollListener(new com.huewu.pla.lib.internal.d() {

                final g a;
                private int b;

                public void a(PLA_AbsListView pla_abslistview, int i1)
                {
                    if (i1 == 0)
                    {
                        com.cyberlink.beautycircle.controller.activity.g.k(a);
                    }
                }

                public void a(PLA_AbsListView pla_abslistview, int i1, int j1, int k1)
                {
                    if (i1 != 0) goto _L2; else goto _L1
_L1:
                    if (b != 0)
                    {
                        a.b.b().d(false);
                        a.b.b().h(true);
                    }
_L4:
                    b = i1;
                    return;
_L2:
                    if (b == 0)
                    {
                        a.b.b().d(true);
                        a.b.b().c(a.b.getString(m.bc_post_related_posts));
                        a.b.b().h(false);
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                a = g.this;
                super();
                b = -1;
            }
            });
            m = r.findViewById(j.like_list_btn);
            if (m != null)
            {
                m.setOnClickListener(z);
            }
            n = (TextView)r.findViewById(j.like_list_text);
            Object obj = r.findViewById(j.post_top_panel);
            if (com.cyberlink.beautycircle.controller.activity.PostActivity.m(b))
            {
                ((View) (obj)).setVisibility(0);
                obj = (UICImageView)r.findViewById(j.post_avatar);
                boolean flag1;
                if (obj != null)
                {
                    if (f.creator != null && f.creator.avatar != null)
                    {
                        ((UICImageView) (obj)).setImageURI(f.creator.avatar);
                        ((UICImageView) (obj)).setOnClickListener(w);
                    } else
                    {
                        ((UICImageView) (obj)).setImageURI(null);
                        ((UICImageView) (obj)).setOnClickListener(null);
                    }
                }
                obj = (ImageView)r.findViewById(j.avatar_crown);
                if (f.creator != null)
                {
                    com.cyberlink.beautycircle.a.a(((ImageView) (obj)), f.creator.userType);
                }
                obj = (EmojiconTextView)r.findViewById(j.post_author);
                if (obj != null)
                {
                    ((EmojiconTextView) (obj)).setOnClickListener(w);
                    Post post;
                    if (f.creator != null && f.creator.displayName != null)
                    {
                        ((EmojiconTextView) (obj)).setMovementMethod(LinkMovementMethod.getInstance());
                        ((EmojiconTextView) (obj)).setText(new com.perfectcorp.utility.r(f.creator.displayName, new q() {

                            final g a;

                            public void onClick(View view)
                            {
                                if (com.cyberlink.beautycircle.controller.activity.g.a(a) != null && com.cyberlink.beautycircle.controller.activity.g.a(a).creator != null)
                                {
                                    com.cyberlink.beautycircle.c.a(a.b, com.cyberlink.beautycircle.controller.activity.g.a(a).creator.userId, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a);
                                }
                            }

            
            {
                a = g.this;
                super();
            }
                        }));
                    } else
                    {
                        ((EmojiconTextView) (obj)).setText("");
                    }
                    if (f.sourcePostCreator != null && f.sourcePostCreator.displayName != null)
                    {
                        SpannableString spannablestring = new SpannableString(b.getResources().getString(m.bc_post_via));
                        spannablestring.setSpan(new ForegroundColorSpan(b.getResources().getColor(com.cyberlink.beautycircle.g.bc_color_main_edit_text)), 0, spannablestring.length(), 33);
                        ((EmojiconTextView) (obj)).append(spannablestring);
                        ((EmojiconTextView) (obj)).append(new com.perfectcorp.utility.r(f.sourcePostCreator.displayName, new q() {

                            final g a;

                            public void onClick(View view)
                            {
                                if (com.cyberlink.beautycircle.controller.activity.g.a(a) != null && com.cyberlink.beautycircle.controller.activity.g.a(a).sourcePostCreator != null)
                                {
                                    com.cyberlink.beautycircle.c.a(a.b, com.cyberlink.beautycircle.controller.activity.g.a(a).sourcePostCreator.userId, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a);
                                }
                            }

            
            {
                a = g.this;
                super();
            }
                        }));
                    }
                }
                obj = (TextView)r.findViewById(j.post_ago);
                post = f;
                if (f.sourcePostCreator != null)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                a(((TextView) (obj)), post, flag1);
                obj = r.findViewById(j.more_option);
                if (obj != null)
                {
                    if (f == null || f.creator == null || !f.creator.b().c())
                    {
                        flag = false;
                    }
                    if (flag)
                    {
                        ((View) (obj)).setVisibility(4);
                    } else
                    {
                        ((View) (obj)).setVisibility(0);
                        ((View) (obj)).setTag(f);
                        ((View) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                            final g a;

                            public void onClick(View view)
                            {
                                a.a(view);
                            }

            
            {
                a = g.this;
                super();
            }
                        });
                    }
                }
            } else
            {
                ((View) (obj)).setVisibility(8);
            }
            obj = (TextView)r.findViewById(j.post_title);
            if (obj != null)
            {
                ((TextView) (obj)).setText(f.title);
            }
            a(f);
            o = (LinearLayout)r.findViewById(j.comment_layout);
            obj = r.findViewById(j.issue_btn_like);
            if (f != null && obj != null)
            {
                com.cyberlink.beautycircle.controller.activity.PostActivity.a(b, ((View) (obj)), Globals.a(f.isLiked), false);
                a(m, n, Globals.a(f.likeCount), Globals.a(f.isLiked));
                ((View) (obj)).setOnClickListener(x);
            }
            obj = r.findViewById(j.issue_btn_comment);
            if (obj != null)
            {
                ((View) (obj)).setOnClickListener(com.cyberlink.beautycircle.controller.activity.PostActivity.n(b));
            }
            obj = r.findViewById(j.issue_btn_share);
            if (obj != null)
            {
                ((View) (obj)).setVisibility(0);
                ((View) (obj)).setOnClickListener(B);
            }
            obj = r.findViewById(j.more_comment_btn);
            if (obj != null)
            {
                ((View) (obj)).setVisibility(8);
                ((View) (obj)).setOnClickListener(y);
            }
            obj = r.findViewById(j.add_comment_btn);
            if (obj != null)
            {
                ((View) (obj)).setVisibility(8);
                ((View) (obj)).setOnClickListener(PostActivity.o(b));
                return;
            }
        }
    }

    static View o(g g1)
    {
        return g1.r;
    }

    private void o()
    {
        j = (SwipeRefreshLayout)q.findViewById(j.bc_pull_to_refresh_layout);
        if (j != null)
        {
            j.setColorSchemeResources(new int[] {
                com.cyberlink.beautycircle.g.bc_color_main_style, com.cyberlink.beautycircle.g.bc_color_main_style, com.cyberlink.beautycircle.g.bc_color_main_style, com.cyberlink.beautycircle.g.bc_color_main_style
            });
            j.setOnRefreshListener(A);
        }
    }

    static TextView p(g g1)
    {
        return g1.n;
    }

    private void p()
    {
        Rect rect = new Rect();
        k.getDrawingRect(rect);
        Iterator iterator = p.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ac ac1 = (ac)iterator.next();
            if (ac1.a(rect))
            {
                ac1.c();
            }
        } while (true);
    }

    static LinearLayout q(g g1)
    {
        return g1.o;
    }

    private boolean q()
    {
        return l.getCount() >= 5 && !"contest".equals(f.postSource);
    }

    static CompletePost r(g g1)
    {
        return g1.d;
    }

    static com.cyberlink.beautycircle.controller.adapter.a s(g g1)
    {
        return g1.l;
    }

    static boolean t(g g1)
    {
        return g1.v;
    }

    public void a()
    {
        View view1;
        a(f);
        view1 = ((LinearLayout)r.findViewById(j.post_layout)).getChildAt(0);
        if (view1 == null) goto _L2; else goto _L1
_L1:
        Object obj;
        com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile postattachmentfile;
        Uri uri;
        View view;
        if (f.attachments != null)
        {
            com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile postattachmentfile2 = f.attachments.c();
            com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile postattachmentfile1 = f.attachments.d();
            postattachmentfile = postattachmentfile1;
            obj = postattachmentfile2;
            if (postattachmentfile2 == null)
            {
                obj = postattachmentfile1;
                postattachmentfile = postattachmentfile1;
            }
        } else
        {
            postattachmentfile = null;
            obj = null;
        }
        uri = f.d();
        view = view1.findViewById(j.post_photo);
        if (uri != null || obj == null) goto _L4; else goto _L3
_L3:
        a(view, false, ((Uri) (null)), ((String) (null)));
_L2:
        if (u != null)
        {
            u.a();
            u = null;
        }
        obj = r.findViewById(j.issue_btn_like);
        if (f != null && obj != null)
        {
            com.cyberlink.beautycircle.controller.activity.PostActivity.a(b, ((View) (obj)), Globals.a(f.isLiked), false);
            a(m, n, Globals.a(f.likeCount), Globals.a(f.isLiked));
        }
        b(f);
        if (l != null)
        {
            l.b();
        }
        return;
_L4:
        if (uri != null && postattachmentfile != null)
        {
            a(view, true, uri, Long.toString(f.postId.longValue()));
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected void a(long l1, ArrayList arraylist)
    {
        LayoutInflater layoutinflater = (LayoutInflater)b.getSystemService("layout_inflater");
        View view;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); o.addView(view, 0))
        {
            Comment comment = (Comment)arraylist.next();
            view = layoutinflater.inflate(k.bc_view_issue_comment, o, false);
            a(l1, comment, view);
        }

    }

    protected void a(View view)
    {
        Menu menu;
        boolean flag1;
        flag1 = true;
        view = new PopupMenu(b, view);
        menu = view.getMenu();
        long l1;
        long l2;
        l1 = AccountManager.c().longValue();
        l2 = f.creator.userId;
        boolean flag;
        if (l1 == l2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L1:
        NullPointerException nullpointerexception;
        if (f == null || f.creator == null || !f.creator.b().c())
        {
            flag1 = false;
        }
        if (AccountManager.c() == null || AccountManager.c() != null && !flag && !flag1)
        {
            menu.add(m.bc_post_comment_menu_report).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

                final g a;

                public boolean onMenuItemClick(MenuItem menuitem)
                {
                    a.i();
                    return true;
                }

            
            {
                a = g.this;
                super();
            }
            });
        }
        if (flag)
        {
            if (!"contest".equals(f.postSource))
            {
                menu.add(m.bc_post_edit).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

                    final g a;

                    public boolean onMenuItemClick(MenuItem menuitem)
                    {
                        a.j();
                        return true;
                    }

            
            {
                a = g.this;
                super();
            }
                });
            }
            menu.add(m.bc_post_delete).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

                final g a;

                public boolean onMenuItemClick(MenuItem menuitem)
                {
                    a.k();
                    return true;
                }

            
            {
                a = g.this;
                super();
            }
            });
        }
        view.show();
        return;
        nullpointerexception;
        flag = false;
          goto _L1
    }

    public void a(View view, TextView textview, View view1, TextView textview1, View view2, TextView textview2, boolean flag, 
            long l1, long l2, long l3)
    {
        if (view == null || textview == null || view1 == null || textview1 == null || view2 == null || textview2 == null)
        {
            return;
        }
        if (l1 == 0L)
        {
            view.setVisibility(8);
            textview.setVisibility(8);
        } else
        {
            view.setVisibility(0);
            textview.setVisibility(0);
            textview.setText(String.format(Locale.getDefault(), "%,d", new Object[] {
                Long.valueOf(l1)
            }));
            view.setSelected(flag);
            textview.setSelected(flag);
        }
        if (l2 == 0L)
        {
            view1.setVisibility(8);
            textview1.setVisibility(8);
        } else
        {
            view1.setVisibility(0);
            textview1.setVisibility(0);
            textview1.setText(String.format(Locale.getDefault(), "%,d", new Object[] {
                Long.valueOf(l2)
            }));
        }
        if (l3 == 0L)
        {
            view2.setVisibility(8);
            textview2.setVisibility(8);
            return;
        } else
        {
            view2.setVisibility(0);
            textview2.setVisibility(0);
            textview2.setText(String.format(Locale.getDefault(), "%,d", new Object[] {
                Long.valueOf(l3)
            }));
            return;
        }
    }

    protected void a(Post post)
    {
        View view = r.findViewById(j.post_like_comment_outter);
        if (post != null)
        {
            View view1 = r.findViewById(j.post_like_icon);
            View view2 = r.findViewById(j.post_comment_icon);
            View view3 = r.findViewById(j.post_repost_icon);
            a(view1, (TextView)r.findViewById(j.post_like_count), view2, (TextView)r.findViewById(j.post_comment_count), view3, (TextView)r.findViewById(j.post_repost_count), Globals.a(post.isLiked), Globals.a(post.likeCount), Globals.a(post.commentCount), Globals.a(post.circleInCount));
            if (view != null)
            {
                if (Globals.a(post.likeCount) == 0L && Globals.a(post.commentCount) == 0L && Globals.a(post.circleInCount) == 0L)
                {
                    view.setVisibility(8);
                    return;
                } else
                {
                    view.setVisibility(0);
                    return;
                }
            }
        }
    }

    protected Long b()
    {
        if (f != null)
        {
            return f.postId;
        } else
        {
            return null;
        }
    }

    protected void c()
    {
        com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile postattachmentfile = null;
        if (f == null)
        {
            return;
        }
        View view = ((LinearLayout)r.findViewById(j.post_layout)).getChildAt(0);
        if (view != null)
        {
            Object obj;
            Uri uri;
            if (f.attachments != null)
            {
                com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile postattachmentfile2 = f.attachments.c();
                com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile postattachmentfile1 = f.attachments.d();
                obj = postattachmentfile2;
                postattachmentfile = postattachmentfile1;
                if (postattachmentfile2 == null)
                {
                    obj = postattachmentfile1;
                    postattachmentfile = postattachmentfile1;
                }
            } else
            {
                obj = null;
            }
            uri = f.d();
            if (uri == null && obj != null)
            {
                b(view, f, ((com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile) (obj)), 0, 0);
                return;
            }
            if (uri != null && postattachmentfile != null)
            {
                a(view, f, postattachmentfile, uri, 0, 0);
                return;
            } else
            {
                a(view, f);
                return;
            }
        } else
        {
            obj = new ArrayList(1);
            ((ArrayList) (obj)).add(f);
            a(((ArrayList) (obj)), true);
            return;
        }
    }

    protected void d()
    {
        if (com.cyberlink.beautycircle.controller.activity.PostActivity.q(b) != 2) goto _L2; else goto _L1
_L1:
        k.post(new Runnable() {

            final g a;

            public void run()
            {
                com.cyberlink.beautycircle.controller.activity.g.a(a, 2);
            }

            
            {
                a = g.this;
                super();
            }
        });
_L4:
        com.cyberlink.beautycircle.controller.activity.PostActivity.b(b, 0);
        p();
        return;
_L2:
        if (com.cyberlink.beautycircle.controller.activity.PostActivity.q(b) == 4)
        {
            k.post(new Runnable() {

                final g a;

                public void run()
                {
                    com.cyberlink.beautycircle.controller.activity.g.a(a, 4);
                }

            
            {
                a = g.this;
                super();
            }
            });
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void e()
    {
        o.removeAllViews();
        a = 0;
        f();
    }

    protected void f()
    {
        NetworkPost.a("Post", f.postId.longValue(), AccountManager.c(), a, 3).a(new com.perfectcorp.utility.m() {

            final g a;

            protected void a(d d1)
            {
                byte byte0 = 8;
                if (com.cyberlink.beautycircle.controller.activity.g.a(a) != null)
                {
                    Object obj = a;
                    obj.a = ((g) (obj)).a + d1.b.size();
                    a.a(com.cyberlink.beautycircle.controller.activity.g.a(a).creator.userId, d1.b);
                    obj = g.o(a).findViewById(j.more_comment_btn);
                    int i1;
                    if (d1.a.intValue() > a.a)
                    {
                        i1 = 0;
                    } else
                    {
                        i1 = 8;
                    }
                    ((View) (obj)).setVisibility(i1);
                    obj = g.o(a).findViewById(j.add_comment_btn);
                    i1 = byte0;
                    if (d1.a.intValue() > 0)
                    {
                        i1 = 0;
                    }
                    ((View) (obj)).setVisibility(i1);
                    if (com.cyberlink.beautycircle.controller.activity.g.a(a).commentCount != null && d1.a != null && com.cyberlink.beautycircle.controller.activity.g.a(a).commentCount.intValue() != d1.a.intValue())
                    {
                        com.perfectcorp.utility.e.e(new Object[] {
                            com.cyberlink.beautycircle.controller.activity.g.a(a).commentCount, " to ", d1.a
                        });
                        com.cyberlink.beautycircle.controller.activity.g.a(a).a(Long.valueOf(d1.a.longValue()), new com.cyberlink.beautycircle.model.r(this) {

                            final _cls16 a;

                            public void a(Post post)
                            {
                                if (post != null)
                                {
                                    com.cyberlink.beautycircle.controller.activity.g.a(a.a, post);
                                }
                                a.a.a(com.cyberlink.beautycircle.controller.activity.g.a(a.a));
                                com.cyberlink.beautycircle.controller.activity.g.b(a.a, com.cyberlink.beautycircle.controller.activity.g.a(a.a));
                            }

            
            {
                a = _pcls16;
                super();
            }
                        });
                    }
                }
            }

            protected void b(Object obj)
            {
                a((d)obj);
            }

            
            {
                a = g.this;
                super();
            }
        });
    }

    protected void g()
    {
        String s1 = com.cyberlink.beautycircle.controller.activity.PostActivity.j(b).getText().toString();
        if (s1.isEmpty())
        {
            return;
        } else
        {
            b.i();
            com.cyberlink.beautycircle.controller.activity.PostActivity.k(b).setEnabled(false);
            AccountManager.a(b, new b(s1) {

                final String a;
                final g b;

                public void a()
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "getAccountToken Fail"
                    });
                }

                public void a(String s2)
                {
                    if (com.cyberlink.beautycircle.controller.activity.g.a(b) == null)
                    {
                        return;
                    } else
                    {
                        com.cyberlink.beautycircle.controller.activity.g.a(b).a(Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.a(b).commentCount.longValue() + 1L), new com.cyberlink.beautycircle.model.r(this) {

                            final _cls17 a;

                            public void a(Post post)
                            {
                                if (post != null)
                                {
                                    com.cyberlink.beautycircle.controller.activity.g.a(a.b, post);
                                }
                                a.b.a(com.cyberlink.beautycircle.controller.activity.g.a(a.b));
                                com.cyberlink.beautycircle.controller.activity.g.b(a.b, com.cyberlink.beautycircle.controller.activity.g.a(a.b));
                            }

            
            {
                a = _pcls17;
                super();
            }
                        });
                        NetworkPost.a(s2, "Post", com.cyberlink.beautycircle.controller.activity.g.a(b).postId.longValue(), a, new Tags()).a(new com.perfectcorp.utility.m(this) {

                            final _cls17 a;

                            protected void a()
                            {
                                com.cyberlink.beautycircle.controller.activity.PostActivity.k(a.b.b).setEnabled(true);
                            }

                            protected void a(int i1)
                            {
                                if (i1 != 523) goto _L2; else goto _L1
_L1:
                                String s1 = a.b.b.getResources().getString(m.bc_post_comment_you_blocked_toast);
                                com.perfectcorp.utility.e.a(a.b.b, s1);
_L4:
                                com.cyberlink.beautycircle.controller.activity.PostActivity.k(a.b.b).setEnabled(true);
                                return;
_L2:
                                if (i1 == 524)
                                {
                                    String s2 = a.b.b.getResources().getString(m.bc_post_comment_blocked_you_toast);
                                    com.perfectcorp.utility.e.a(a.b.b, s2);
                                }
                                if (true) goto _L4; else goto _L3
_L3:
                            }

                            protected void a(Comment comment)
                            {
                                com.cyberlink.beautycircle.controller.activity.PostActivity.j(a.b.b).setText("");
                                com.cyberlink.beautycircle.controller.activity.PostActivity.k(a.b.b).setEnabled(true);
                                com.cyberlink.beautycircle.controller.activity.g.a(a.b, 2);
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
                                com.cyberlink.beautycircle.controller.activity.g.a(a.b, com.cyberlink.beautycircle.controller.activity.g.a(a.b).creator.userId, comment);
                            }

                            protected void b(Object obj)
                            {
                                a((Comment)obj);
                            }

            
            {
                a = _pcls17;
                super();
            }
                        });
                        return;
                    }
                }

                public void b()
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "getAccountToken Abort"
                    });
                }

            
            {
                b = g.this;
                a = s1;
                super();
            }
            });
            return;
        }
    }

    protected void h()
    {
        A.onRefresh();
    }

    protected void i()
    {
        aq.c = "report_post";
        AccountManager.a(b, new b() {

            final g a;

            public void a()
            {
                Globals.b("Get AccountToken Fail");
            }

            public void a(String s1)
            {
                if (s1 != null)
                {
                    com.cyberlink.beautycircle.utility.DialogUtils.ReportSource reportsource1 = com.cyberlink.beautycircle.utility.DialogUtils.ReportSource.a;
                    com.cyberlink.beautycircle.utility.DialogUtils.ReportSource reportsource = reportsource1;
                    if (com.cyberlink.beautycircle.controller.activity.g.a(a) != null)
                    {
                        reportsource = reportsource1;
                        if ("contest".equals(com.cyberlink.beautycircle.controller.activity.g.a(a).postSource))
                        {
                            reportsource = com.cyberlink.beautycircle.utility.DialogUtils.ReportSource.c;
                        }
                    }
                    DialogUtils.a(a.b, s1, "Post", com.cyberlink.beautycircle.controller.activity.g.b(a), reportsource, new Runnable(this) {

                        final _cls35 a;

                        public void run()
                        {
                            BCTileImage.b(com.cyberlink.beautycircle.controller.activity.g.a(a.a));
                        }

            
            {
                a = _pcls35;
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
                a = g.this;
                super();
            }
        });
    }

    protected void j()
    {
        AccountManager.a(b, new b() {

            final g a;

            public void a()
            {
                Globals.b("Get AccountToken Fail");
            }

            public void a(String s1)
            {
                if (s1 != null)
                {
                    com.cyberlink.beautycircle.c.a(a.b, com.cyberlink.beautycircle.controller.activity.g.r(a));
                }
            }

            public void b()
            {
                Globals.b("Get AccountToken Cancel");
            }

            
            {
                a = g.this;
                super();
            }
        });
    }

    protected void k()
    {
        AccountManager.a(b, new b() {

            final g a;

            public void a()
            {
                Globals.b("Get AccountToken Fail");
            }

            public void a(String s1)
            {
                if (s1 != null)
                {
                    DialogUtils.a(a.b, "", a.b.getResources().getString(m.bc_post_delete_confirm_text), a.b.getResources().getString(m.bc_post_cancel), new Runnable(this) {

                        final _cls37 a;

                        public void run()
                        {
                        }

            
            {
                a = _pcls37;
                super();
            }
                    }, a.b.getResources().getString(m.bc_post_delete), new Runnable(this, s1) {

                        final String a;
                        final _cls37 b;

                        public void run()
                        {
                            b.a.b.k();
                            NetworkContest.c(Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.b(b.a)));
                            NetworkPost.a(a, Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.b(b.a))).a(new com.perfectcorp.utility.m(this) {

                                final _cls2 a;

                                protected void a()
                                {
                                    a.b.a.b.l();
                                }

                                protected void a(int i1)
                                {
                                    a.b.a.b.l();
                                    Globals.a(a.b.a.b.getResources().getString(m.bc_server_connect_fail));
                                    com.perfectcorp.utility.e.e(new Object[] {
                                        "DeletePost: ", Integer.valueOf(i1)
                                    });
                                }

                                protected void a(Void void1)
                                {
                                    a.b.a.b.l();
                                    t.b.a();
                                    com.cyberlink.beautycircle.controller.activity.PostActivity.r(a.b.a.b);
                                }

                                protected void b(Object obj)
                                {
                                    a((Void)obj);
                                }

            
            {
                a = _pcls2;
                super();
            }
                            });
                        }

            
            {
                b = _pcls37;
                a = s1;
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
                a = g.this;
                super();
            }
        });
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/g$10$1

/* anonymous class */
    class _cls1
        implements Runnable
    {

        final _cls10 a;

        public void run()
        {
            a.f.setOnClickListener(null);
            a.g.b.a(com.cyberlink.beautycircle.controller.activity.g.a(a.g));
        }

            
            {
                a = _pcls10;
                super();
            }
    }

}
