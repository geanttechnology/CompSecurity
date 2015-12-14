// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.PointF;
import android.net.Uri;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.am;
import com.cyberlink.beautycircle.controller.a.s;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.l;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.FileMetadata;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.ad;
import com.cyberlink.beautycircle.utility.i;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.a.b;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.u;
import com.rockerhieu.emojicon.EmojiconTextView;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            m, n

public abstract class a extends com.cyberlink.beautycircle.controller.adapter.m
{

    private boolean a;
    public Long b[];
    public Activity c;
    public long d;
    protected android.view.View.OnClickListener e;
    private com.cyberlink.beautycircle.model.s f;
    private boolean k;
    private boolean l;

    public a(Activity activity, ViewGroup viewgroup, int i1, com.cyberlink.beautycircle.model.s s1, n n)
    {
        super(activity, viewgroup, i1, 20, n);
        a = true;
        f = null;
        b = null;
        k = false;
        d = 0L;
        l = false;
        e = new android.view.View.OnClickListener() {

            final a a;

            public void onClick(View view)
            {
                view = (Post)view.getTag();
                a.a(view);
            }

            
            {
                a = a.this;
                super();
            }
        };
        if (activity == null)
        {
            throw new NullPointerException("The first parameter cannot be null");
        } else
        {
            c = activity;
            f = s1;
            return;
        }
    }

    private void a(TextView textview, long l1, long l2)
    {
label0:
        {
            if (textview != null)
            {
                if (l1 != 0L || l2 != 0L)
                {
                    break label0;
                }
                textview.setVisibility(8);
            }
            return;
        }
        textview.setVisibility(0);
        String s1 = "";
        if (l1 != 0L)
        {
            s1 = (new StringBuilder()).append(Globals.n().getResources().getQuantityString(l.bc_countpattern_like_count_short, (int)l1, new Object[] {
                Long.valueOf(l1)
            })).append("  ").toString();
        }
        String s2 = s1;
        if (l2 != 0L)
        {
            s2 = (new StringBuilder()).append(s1).append(Globals.n().getResources().getQuantityString(l.bc_countpattern_comment_count_short, (int)l2, new Object[] {
                Long.valueOf(l2)
            })).append("  ").toString();
        }
        textview.setText(s2);
    }

    protected abstract d a(int i1, int j1);

    protected void a(View view)
    {
        view = (Post)view.getTag();
        AccountManager.a(c, new com.cyberlink.beautycircle.utility.b(view) {

            final Post a;
            final a b;

            public void a()
            {
                Globals.b("Get AccountToken Fail");
            }

            public void a(String s1)
            {
                if (s1 != null)
                {
                    DialogUtils.a(b.c, s1, "Post", a.postId.longValue(), com.cyberlink.beautycircle.utility.DialogUtils.ReportSource.a, null);
                }
            }

            public void b()
            {
                Globals.b("Get AccountToken Cancel");
            }

            
            {
                b = a.this;
                a = post;
                super();
            }
        });
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
            view.setSelected(flag);
            textview.setText(String.format(Locale.getDefault(), "%,d", new Object[] {
                Long.valueOf(l1)
            }));
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

    public void a(TextView textview, Date date)
    {
        if (textview == null || date == null)
        {
            return;
        } else
        {
            textview.setText(i.a(date));
            return;
        }
    }

    protected void a(Post post)
    {
        if (post == null || h())
        {
            return;
        }
        if (l)
        {
            com.perfectcorp.a.b.a(new am(am.a, "related_post", post.postId, Long.valueOf(post.creator.userId), 0L));
            s.a = "bc_related_post";
        }
        com.cyberlink.beautycircle.c.a(c, post, true, this, 4, j);
        d = d + 1L;
    }

    public void a(Post post, View view)
    {
        Object obj = view.findViewById(j.post_info_bar);
        if (obj != null)
        {
            ((View) (obj)).setVisibility(0);
        }
        obj = view.findViewById(j.bc_view_discover_auther_div);
        Object obj1 = view.findViewById(j.post_top_panel);
        UICImageView uicimageview;
        if (a)
        {
            if (obj1 != null)
            {
                ((View) (obj1)).setVisibility(0);
            }
            if (obj != null)
            {
                ((View) (obj)).setVisibility(0);
            }
            Locale locale;
            Long long1;
            if (post.creator != null)
            {
                obj = post.creator.b();
            } else
            {
                obj = new UserInfo();
                obj.id = -1L;
                obj.avatarUrl = null;
                obj.displayName = "";
                obj.userType = "Unknown";
            }
            obj1 = (UICImageView)view.findViewById(j.post_avatar);
            if (obj1 != null)
            {
                ((UICImageView) (obj1)).setImageURI(((UserInfo) (obj)).avatarUrl);
                ((UICImageView) (obj1)).setOnClickListener(new android.view.View.OnClickListener(((UserInfo) (obj))) {

                    final UserInfo a;
                    final a b;

                    public void onClick(View view1)
                    {
                        if (a.id != -1L)
                        {
                            com.cyberlink.beautycircle.c.a(b.c, a.id, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a);
                        }
                    }

            
            {
                b = a.this;
                a = userinfo;
                super();
            }
                });
            }
            obj1 = (TextView)view.findViewById(j.post_try_it);
            if (obj1 != null && post.extLookUrl != null)
            {
                ((TextView) (obj1)).setVisibility(0);
            } else
            {
                ((TextView) (obj1)).setVisibility(8);
            }
            obj1 = (ImageView)view.findViewById(j.avatar_crown);
            if (obj != null)
            {
                com.cyberlink.beautycircle.a.a(((ImageView) (obj1)), ((UserInfo) (obj)).userType);
            }
            obj1 = (EmojiconTextView)view.findViewById(j.post_author);
            if (obj1 != null)
            {
                ((EmojiconTextView) (obj1)).setText(((UserInfo) (obj)).displayName);
                ((EmojiconTextView) (obj1)).setOnClickListener(new android.view.View.OnClickListener(((UserInfo) (obj))) {

                    final UserInfo a;
                    final a b;

                    public void onClick(View view1)
                    {
                        if (a.id != -1L)
                        {
                            com.cyberlink.beautycircle.c.a(b.c, a.id, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a);
                        }
                    }

            
            {
                b = a.this;
                a = userinfo;
                super();
            }
                });
            }
            obj1 = (TextView)view.findViewById(j.circle_name);
            if (obj1 != null && post.circles != null && post.circles.size() > 0)
            {
                String s1 = ((com.cyberlink.beautycircle.model.Post.PostCircle)post.circles.get(0)).circleName;
                if (s1 != null)
                {
                    ((TextView) (obj1)).setText(s1);
                }
            }
            obj1 = view.findViewById(j.more_option);
            if (obj1 != null)
            {
                if ("CL".equals(((UserInfo) (obj)).userType))
                {
                    ((View) (obj1)).setVisibility(4);
                } else
                {
                    ((View) (obj1)).setVisibility(0);
                    ((View) (obj1)).setTag(post);
                    ((View) (obj1)).setOnClickListener(new android.view.View.OnClickListener(((UserInfo) (obj)), ((View) (obj1))) {

                        final UserInfo a;
                        final View b;
                        final a c;

                        public void onClick(View view1)
                        {
                            boolean flag1 = false;
                            view1 = new PopupMenu(c.c, view1);
                            Menu menu = view1.getMenu();
                            boolean flag = flag1;
                            if (AccountManager.c() != null)
                            {
                                flag = flag1;
                                if (AccountManager.c().longValue() == a.id)
                                {
                                    flag = true;
                                }
                            }
                            if (AccountManager.c() == null || AccountManager.c() != null && !flag && !"CL".equals(a.userType))
                            {
                                menu.add(m.bc_post_comment_menu_report).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(this) {

                                    final _cls6 a;

                                    public boolean onMenuItemClick(MenuItem menuitem)
                                    {
                                        a.c.a(a.b);
                                        return true;
                                    }

            
            {
                a = _pcls6;
                super();
            }
                                });
                            }
                            if (flag)
                            {
                                menu.add(m.bc_post_delete).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(this) {

                                    final _cls6 a;

                                    public boolean onMenuItemClick(MenuItem menuitem)
                                    {
                                        a.c.b(a.b);
                                        return true;
                                    }

            
            {
                a = _pcls6;
                super();
            }
                                });
                            }
                            view1.show();
                        }

            
            {
                c = a.this;
                a = userinfo;
                b = view;
                super();
            }
                    });
                }
            }
        } else
        {
            if (obj1 != null)
            {
                ((View) (obj1)).setVisibility(8);
            }
            if (obj != null)
            {
                ((View) (obj)).setVisibility(8);
            }
        }
        obj = view.findViewById(j.post_box);
        obj1 = view.findViewById(j.post_text_box);
        if (obj != null)
        {
            if (post.d() != null)
            {
                ((View) (obj)).setBackgroundResource(g.bc_issue_redirect);
                ((View) (obj)).setTag(post);
                if (obj1 != null)
                {
                    ((View) (obj1)).setPadding(Globals.a(10), 0, Globals.a(10), Globals.a(10));
                }
            } else
            {
                ((View) (obj)).setBackgroundResource(0);
                ((View) (obj)).setTag(post);
                if (obj1 != null)
                {
                    ((View) (obj1)).setPadding(0, 0, 0, 0);
                }
            }
        }
        obj = (TextView)view.findViewById(j.post_host);
        if (obj != null)
        {
            if (post.d() != null)
            {
                if (obj != null)
                {
                    obj1 = u.a(post.d().toString(), true);
                    if (obj1 == null)
                    {
                        obj1 = post.d().toString();
                        locale = Locale.getDefault();
                        long1 = post.postId;
                        obj = obj1;
                        if (obj1 == null)
                        {
                            obj = "[null]";
                        }
                        com.perfectcorp.utility.e.b(new Object[] {
                            String.format(locale, "CRASH ID: (%d), domain (%s)", new Object[] {
                                long1, obj
                            })
                        });
                        Globals.b((new StringBuilder()).append("CRASH ID: ").append(post.postId).toString());
                    } else
                    {
                        ((TextView) (obj)).setText(((CharSequence) (obj1)));
                        ((TextView) (obj)).setVisibility(0);
                    }
                }
            } else
            if (obj != null)
            {
                ((TextView) (obj)).setText("");
                ((TextView) (obj)).setVisibility(8);
            }
        }
        uicimageview = (UICImageView)view.findViewById(j.post_cover);
        if (uicimageview != null)
        {
            obj1 = post.c();
            Integer integer;
            Integer integer1;
            if (obj1 != null)
            {
                obj = ((FileMetadata) (obj1)).originalUrl;
                integer1 = ((FileMetadata) (obj1)).width;
                integer = ((FileMetadata) (obj1)).height;
                obj1 = ((FileMetadata) (obj1)).dominantedColor;
            } else
            {
                integer = Integer.valueOf(0);
                integer1 = Integer.valueOf(0);
                obj1 = null;
                obj = null;
            }
            if (obj != null)
            {
                if (Globals.d())
                {
                    obj = null;
                }
                uicimageview.setVisibility(0);
                uicimageview.a(((Uri) (obj)), integer1, integer, ((String) (obj1)));
                uicimageview.setTag(post);
                uicimageview.setOnClickListener(e);
                if (!k)
                {
                    uicimageview.setOnLongClickListener(new android.view.View.OnLongClickListener(post, uicimageview) {

                        final Post a;
                        final UICImageView b;
                        final a c;

                        public boolean onLongClick(View view1)
                        {
                            if (c.h != null)
                            {
                                c.h.a(a);
                                b.setOnClickListener(null);
                            }
                            return false;
                        }

            
            {
                c = a.this;
                a = post;
                b = uicimageview;
                super();
            }
                    });
                } else
                {
                    uicimageview.setOnTouchListener(new android.view.View.OnTouchListener(uicimageview, post) {

                        public long a;
                        public long b;
                        public PointF c;
                        public long d;
                        public Runnable e;
                        final UICImageView f;
                        final Post g;
                        final a h;

                        public boolean a(float f1, float f2, float f3)
                        {
                            return f1 >= -f3 && f2 >= -f3 && f1 < (float)(f.getRight() - f.getLeft()) + f3 && f2 < (float)(f.getBottom() - f.getTop()) + f3;
                        }

                        public boolean onTouch(View view1, MotionEvent motionevent)
                        {
                            if (motionevent.getAction() != 0) goto _L2; else goto _L1
_L1:
                            a = Long.valueOf(System.currentTimeMillis()).longValue();
                            c.set(motionevent.getX(), motionevent.getY());
                            f.postDelayed(e, b);
_L4:
                            return false;
_L2:
                            if (motionevent.getAction() == 1)
                            {
                                if (Long.valueOf(System.currentTimeMillis()).longValue() - a < b)
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
                h = a.this;
                f = uicimageview;
                g = post;
                super();
                a = 0L;
                b = 250L;
                c = new PointF();
                d = ViewConfiguration.get(f.getContext()).getScaledTouchSlop();
                e = new _cls1(this);
            }
                    });
                }
            } else
            {
                uicimageview.setVisibility(8);
                uicimageview.setOnClickListener(null);
                uicimageview.setOnLongClickListener(null);
            }
        }
        obj = view.findViewById(j.post_play_icon);
        if (obj != null)
        {
            if (ad.d(post.d()))
            {
                ((View) (obj)).setVisibility(0);
            } else
            {
                ((View) (obj)).setVisibility(8);
            }
        }
        obj = view.findViewById(j.post_icon_panel);
        obj1 = view.findViewById(j.post_tag_icon);
        if (obj != null && obj1 != null)
        {
            if (post.gotProductTag != null && post.gotProductTag.booleanValue())
            {
                ((View) (obj)).setVisibility(0);
                ((View) (obj1)).setVisibility(0);
                ((View) (obj1)).setClickable(true);
                ((View) (obj1)).setOnClickListener(new android.view.View.OnClickListener(post) {

                    final Post a;
                    final a b;

                    public void onClick(View view1)
                    {
                        com.cyberlink.beautycircle.c.a(b.c, a, true, b, 4, b.j);
                        view1 = b;
                        view1.d = ((a) (view1)).d + 1L;
                    }

            
            {
                b = a.this;
                a = post;
                super();
            }
                });
            } else
            {
                ((View) (obj)).setVisibility(8);
                ((View) (obj1)).setVisibility(8);
            }
        }
        obj = (TextView)view.findViewById(j.post_description);
        if (obj != null)
        {
            if (post.content == null || post.content.isEmpty())
            {
                ((TextView) (obj)).setVisibility(8);
            } else
            {
                ((TextView) (obj)).setText(Html.fromHtml(post.content));
                ((TextView) (obj)).setVisibility(0);
            }
        }
        obj = (TextView)view.findViewById(j.post_title);
        if (obj != null)
        {
            ((TextView) (obj)).setText(post.title);
        }
        a((TextView)view.findViewById(j.post_like_comment_count), post.likeCount.longValue(), post.commentCount.longValue());
        b(post, view);
    }

    protected volatile void a(Model model)
    {
        a((Post)model);
    }

    public volatile void a(Model model, View view)
    {
        a((Post)model, view);
    }

    public void a_()
    {
        l = true;
    }

    public d b(int i1, int j1)
    {
        if (!h()) goto _L2; else goto _L1
_L1:
        d d2;
        b = null;
        d2 = a(i1, j1);
        if (d2 == null || d2.b == null) goto _L4; else goto _L3
_L3:
        d d1;
        d1 = d2;
        if (f != null)
        {
            f.c();
            f.a(d2);
            d1 = d2;
        }
_L6:
        return d1;
_L4:
        if (f != null)
        {
            d2 = f.a(i1, j1);
        } else
        {
            d2 = null;
        }
        d1 = d2;
        if (c != null)
        {
            d1 = d2;
            if (!com.cyberlink.beautycircle.model.network.c.a())
            {
                ((BaseActivity)c).a(c.getString(m.bc_server_connect_fail), 3000);
                return d2;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (f != null)
        {
            d2 = f.a(i1, j1);
        } else
        {
            d2 = null;
        }
        if (d2 != null && d2.b != null && !d2.b.isEmpty())
        {
            break; /* Loop/switch isn't completed */
        }
        d2 = a(i1, j1);
        d1 = d2;
        if (f != null)
        {
            f.a(d2);
            return d2;
        }
        if (true) goto _L6; else goto _L5
_L5:
        d1 = d2;
        if (g)
        {
            d1 = d2;
            if (c != null)
            {
                c.runOnUiThread(new Runnable() {

                    final a a;

                    public void run()
                    {
                        if (a.h())
                        {
                            a.c();
                        }
                    }

            
            {
                a = a.this;
                super();
            }
                });
                return d2;
            }
        }
        if (true) goto _L6; else goto _L7
_L7:
    }

    public void b()
    {
        notifyDataSetChanged();
    }

    protected void b(View view)
    {
        view = (Post)view.getTag();
        AccountManager.a(c, new com.cyberlink.beautycircle.utility.b(view) {

            final Post a;
            final a b;

            public void a()
            {
                Globals.b("Get AccountToken Fail");
            }

            public void a(String s1)
            {
                if (s1 != null)
                {
                    DialogUtils.a(b.c, "", b.c.getResources().getString(m.bc_post_delete_confirm_text), b.c.getResources().getString(m.bc_post_cancel), new Runnable(this) {

                        final _cls3 a;

                        public void run()
                        {
                        }

            
            {
                a = _pcls3;
                super();
            }
                    }, b.c.getResources().getString(m.bc_post_delete), new Runnable(this, s1) {

                        final String a;
                        final _cls3 b;

                        public void run()
                        {
                            NetworkPost.a(a, b.a.postId).a(new com.perfectcorp.utility.m(this) {

                                final _cls2 a;

                                public void a(int i1)
                                {
                                }

                                public void a(Void void1)
                                {
                                    t.b.a();
                                    a.b.b.d(a.b.a);
                                }

                                public void b(Object obj)
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
                b = _pcls3;
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
                b = a.this;
                a = post;
                super();
            }
        });
    }

    protected void b(Post post)
    {
    }

    protected void b(Post post, View view)
    {
        if (view.findViewById(j.post_like_comment_outter) == null || post == null)
        {
            return;
        } else
        {
            View view1 = view.findViewById(j.post_like_icon);
            View view2 = view.findViewById(j.post_comment_icon);
            View view3 = view.findViewById(j.post_repost_icon);
            a(view1, (TextView)view.findViewById(j.post_like_count), view2, (TextView)view.findViewById(j.post_comment_count), view3, (TextView)view.findViewById(j.post_repost_count), Globals.a(post.isLiked), Globals.a(post.likeCount), Globals.a(post.commentCount), Globals.a(post.circleInCount));
            a((TextView)view.findViewById(j.post_time_ago), post.createdTime);
            return;
        }
    }

    protected volatile void b(Model model)
    {
        b((Post)model);
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/adapter/a$8$1

/* anonymous class */
    class _cls1
        implements Runnable
    {

        final _cls8 a;

        public void run()
        {
            if (a.h.h != null)
            {
                a.h.h.a(a.g);
                a.f.setOnClickListener(null);
            }
        }

            
            {
                a = _pcls8;
                super();
            }
    }

}
