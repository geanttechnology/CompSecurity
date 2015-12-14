// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.BaseArcMenuActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.af;
import com.cyberlink.beautycircle.controller.a.am;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.controller.a.ax;
import com.cyberlink.beautycircle.controller.a.s;
import com.cyberlink.beautycircle.controller.adapter.a;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.f;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.BCTileImage;
import com.cyberlink.beautycircle.model.Comment;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.NetworkContest;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.ad;
import com.cyberlink.beautycircle.utility.i;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.cyberlink.beautycircle.view.widgetpool.common.PostContentTextView;
import com.perfectcorp.a.b;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.d;
import com.perfectcorp.utility.e;
import com.rockerhieu.emojicon.EmojiconEditText;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            h, g, f

public class PostActivity extends BaseArcMenuActivity
{

    public static final UUID o = UUID.randomUUID();
    private TreeMap A;
    private int B;
    private int C;
    private boolean D;
    private String E;
    private String F;
    private final String G = "howto";
    private boolean H;
    private Long I;
    private Long J;
    private long K;
    private android.view.View.OnClickListener L;
    private android.view.View.OnClickListener M;
    private PagerAdapter N;
    DynamicDrawableSpan p;
    DynamicDrawableSpan q;
    DynamicDrawableSpan r;
    DynamicDrawableSpan s;
    protected android.view.View.OnClickListener t;
    protected android.support.v4.view.ViewPager.OnPageChangeListener u;
    protected TextWatcher v;
    private EmojiconEditText w;
    private TextView x;
    private ViewPager y;
    private ArrayList z;

    public PostActivity()
    {
        w = null;
        x = null;
        y = null;
        z = new ArrayList();
        A = new TreeMap();
        B = 0;
        C = 0;
        D = true;
        E = null;
        F = null;
        H = false;
        p = null;
        q = null;
        r = null;
        s = null;
        I = Long.valueOf(0L);
        J = Long.valueOf(0L);
        K = 0L;
        t = new android.view.View.OnClickListener() {

            final PostActivity a;

            public void onClick(View view)
            {
                view = (com.cyberlink.beautycircle.controller.activity.g)com.cyberlink.beautycircle.controller.activity.PostActivity.e(a).get(Integer.valueOf(com.cyberlink.beautycircle.controller.activity.PostActivity.d(a)));
                if (view != null)
                {
                    com.cyberlink.beautycircle.controller.activity.g.c(view);
                }
            }

            
            {
                a = PostActivity.this;
                super();
            }
        };
        u = new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final PostActivity a;

            public void onPageScrollStateChanged(int i1)
            {
            }

            public void onPageScrolled(int i1, float f1, int j1)
            {
            }

            public void onPageSelected(int i1)
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    Integer.valueOf(i1)
                });
                com.cyberlink.beautycircle.controller.activity.PostActivity.a(a, i1);
                com.cyberlink.beautycircle.controller.activity.g g1 = (com.cyberlink.beautycircle.controller.activity.g)com.cyberlink.beautycircle.controller.activity.PostActivity.e(a).get(Integer.valueOf(i1));
                if (g1 != null)
                {
                    if (!com.cyberlink.beautycircle.controller.activity.g.d(g1))
                    {
                        com.cyberlink.beautycircle.controller.activity.g.c(g1);
                    }
                    Object obj = Long.valueOf(System.currentTimeMillis());
                    com.perfectcorp.a.b.a(new af(Long.toString(com.cyberlink.beautycircle.controller.activity.g.b(g1)), com.cyberlink.beautycircle.controller.activity.PostActivity.g(a), PostActivity.h(a), ((Long) (obj))));
                    com.perfectcorp.a.b.a(new am(null, null, null, null, ((Long) (obj)).longValue() - PostActivity.h(a).longValue()));
                    com.cyberlink.beautycircle.controller.activity.PostActivity.a(a, Long.valueOf(System.currentTimeMillis()));
                    obj = (Post)com.cyberlink.beautycircle.controller.activity.PostActivity.b(a).get(com.cyberlink.beautycircle.controller.activity.PostActivity.d(a));
                    if (obj != null && ((Post) (obj)).extLookUrl != null && !((Post) (obj)).extLookUrl.isEmpty() && com.cyberlink.beautycircle.controller.activity.PostActivity.i(a) != ((Post) (obj)).postId.longValue())
                    {
                        com.cyberlink.beautycircle.controller.activity.PostActivity.b(a, Long.valueOf(System.currentTimeMillis()));
                        if (ad.d(((Post) (obj)).d()))
                        {
                            com.perfectcorp.a.b.a(new s(com.cyberlink.beautycircle.controller.activity.PostActivity.g(a), "show", "video", ((Post) (obj)).postId, 0L));
                        } else
                        {
                            com.perfectcorp.a.b.a(new s(com.cyberlink.beautycircle.controller.activity.PostActivity.g(a), "show", "picture", ((Post) (obj)).postId, 0L));
                        }
                        com.cyberlink.beautycircle.controller.activity.PostActivity.a(a, ((Post) (obj)).postId.longValue());
                    }
                    com.cyberlink.beautycircle.controller.activity.g.e(g1);
                }
            }

            
            {
                a = PostActivity.this;
                super();
            }
        };
        v = new TextWatcher() {

            final PostActivity a;

            public void afterTextChanged(Editable editable)
            {
label0:
                {
                    if (com.cyberlink.beautycircle.controller.activity.PostActivity.j(a) != null && com.cyberlink.beautycircle.controller.activity.PostActivity.k(a) != null)
                    {
                        if (!com.cyberlink.beautycircle.controller.activity.PostActivity.j(a).getText().toString().isEmpty())
                        {
                            break label0;
                        }
                        com.cyberlink.beautycircle.controller.activity.PostActivity.k(a).setEnabled(false);
                    }
                    return;
                }
                com.cyberlink.beautycircle.controller.activity.PostActivity.k(a).setEnabled(true);
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            
            {
                a = PostActivity.this;
                super();
            }
        };
        L = new android.view.View.OnClickListener() {

            final PostActivity a;

            public void onClick(View view)
            {
                view = (com.cyberlink.beautycircle.controller.activity.g)com.cyberlink.beautycircle.controller.activity.PostActivity.e(a).get(Integer.valueOf(com.cyberlink.beautycircle.controller.activity.PostActivity.d(a)));
                if (view == null)
                {
                    return;
                }
                aq.c = "comment";
                String s1 = com.cyberlink.beautycircle.controller.activity.PostActivity.a(a, com.cyberlink.beautycircle.controller.activity.g.a(view));
                if (s1 != null)
                {
                    com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.e(s1, 0L, "comment", com.cyberlink.beautycircle.controller.activity.PostActivity.f(a), 0L));
                }
                com.perfectcorp.a.b.a(new am(am.b, "comment", Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.b(view)), Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.a(view).creator.userId), 0L));
                if (((com.cyberlink.beautycircle.controller.activity.g) (view)).a > 0)
                {
                    com.cyberlink.beautycircle.c.a(a, com.cyberlink.beautycircle.controller.activity.g.a(view), false, 2);
                    return;
                } else
                {
                    AccountManager.a(a, new com.cyberlink.beautycircle.utility.b(this, view) {

                        final com.cyberlink.beautycircle.controller.activity.g a;
                        final _cls3 b;

                        public void a()
                        {
                            Globals.b("Get AccountToken Fail");
                        }

                        public void a(String s1)
                        {
                            b.a.runOnUiThread(new Runnable(this) {

                                final _cls1 a;

                                public void run()
                                {
                                    com.cyberlink.beautycircle.c.a(a.b.a, com.cyberlink.beautycircle.controller.activity.g.a(a.a), true, 2);
                                }

            
            {
                a = _pcls1;
                super();
            }
                            });
                        }

                        public void b()
                        {
                            Globals.b("Get AccountToken Cancel");
                        }

            
            {
                b = _pcls3;
                a = g1;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                a = PostActivity.this;
                super();
            }
        };
        M = new android.view.View.OnClickListener() {

            final PostActivity a;

            public void onClick(View view)
            {
                view = (com.cyberlink.beautycircle.controller.activity.g)com.cyberlink.beautycircle.controller.activity.PostActivity.e(a).get(Integer.valueOf(com.cyberlink.beautycircle.controller.activity.PostActivity.d(a)));
                if (view == null)
                {
                    return;
                }
                aq.c = "comment";
                String s1 = com.cyberlink.beautycircle.controller.activity.PostActivity.a(a, com.cyberlink.beautycircle.controller.activity.g.a(view));
                if (s1 != null)
                {
                    com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.e(s1, 0L, "comment", com.cyberlink.beautycircle.controller.activity.PostActivity.f(a), 0L));
                }
                com.perfectcorp.a.b.a(new am(am.b, "comment", Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.b(view)), Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.a(view).creator.userId), 0L));
                AccountManager.a(a, new com.cyberlink.beautycircle.utility.b(this, view) {

                    final com.cyberlink.beautycircle.controller.activity.g a;
                    final _cls4 b;

                    public void a()
                    {
                        Globals.b("Get AccountToken Fail");
                    }

                    public void a(String s1)
                    {
                        b.a.runOnUiThread(new Runnable(this) {

                            final _cls1 a;

                            public void run()
                            {
                                com.cyberlink.beautycircle.c.a(a.b.a, com.cyberlink.beautycircle.controller.activity.g.a(a.a), true, 2);
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                    }

                    public void b()
                    {
                        Globals.b("Get AccountToken Cancel");
                    }

            
            {
                b = _pcls4;
                a = g1;
                super();
            }
                });
            }

            
            {
                a = PostActivity.this;
                super();
            }
        };
        N = new PagerAdapter() {

            final PostActivity a;

            public void destroyItem(ViewGroup viewgroup, int i1, Object obj)
            {
                if (obj == null || !(obj instanceof com.cyberlink.beautycircle.controller.activity.g)) goto _L2; else goto _L1
_L1:
                obj = (com.cyberlink.beautycircle.controller.activity.g)obj;
                viewgroup.removeView(com.cyberlink.beautycircle.controller.activity.g.h(((com.cyberlink.beautycircle.controller.activity.g) (obj))));
                viewgroup = com.cyberlink.beautycircle.controller.activity.PostActivity.e(a).entrySet().iterator();
_L6:
                if (!viewgroup.hasNext()) goto _L4; else goto _L3
_L3:
                java.util.Map.Entry entry = (java.util.Map.Entry)viewgroup.next();
                if (entry.getValue() != obj) goto _L6; else goto _L5
_L5:
                viewgroup = (Integer)entry.getKey();
_L8:
                if (viewgroup != null)
                {
                    com.cyberlink.beautycircle.controller.activity.PostActivity.e(a).remove(viewgroup);
                }
_L2:
                return;
_L4:
                viewgroup = null;
                if (true) goto _L8; else goto _L7
_L7:
            }

            public int getCount()
            {
                return com.cyberlink.beautycircle.controller.activity.PostActivity.b(a).size();
            }

            public Object instantiateItem(ViewGroup viewgroup, int i1)
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    Integer.valueOf(i1)
                });
                if (i1 < com.cyberlink.beautycircle.controller.activity.PostActivity.b(a).size())
                {
                    com.cyberlink.beautycircle.controller.activity.g g1 = (com.cyberlink.beautycircle.controller.activity.g)com.cyberlink.beautycircle.controller.activity.PostActivity.e(a).get(Integer.valueOf(i1));
                    Object obj = g1;
                    if (g1 == null)
                    {
                        obj = (Post)com.cyberlink.beautycircle.controller.activity.PostActivity.b(a).get(i1);
                        obj = new com.cyberlink.beautycircle.controller.activity.g(a, viewgroup, ((Post) (obj)));
                        com.cyberlink.beautycircle.controller.activity.PostActivity.e(a).put(Integer.valueOf(i1), obj);
                    }
                    viewgroup = ((ViewGroup) (obj));
                    if (i1 == com.cyberlink.beautycircle.controller.activity.PostActivity.d(a))
                    {
                        com.perfectcorp.utility.e.b(new Object[] {
                            "PostId = ", Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.b(((com.cyberlink.beautycircle.controller.activity.g) (obj))))
                        });
                        viewgroup = AccountManager.f();
                        if (viewgroup == null)
                        {
                            viewgroup = "none";
                        } else
                        {
                            viewgroup = viewgroup.toString();
                        }
                        com.perfectcorp.a.b.a(new ax(viewgroup, com.cyberlink.beautycircle.controller.activity.PostActivity.g(a), "visit", Long.toString(com.cyberlink.beautycircle.controller.activity.g.b(((com.cyberlink.beautycircle.controller.activity.g) (obj))))));
                        viewgroup = ((ViewGroup) (obj));
                        if (!com.cyberlink.beautycircle.controller.activity.g.d(((com.cyberlink.beautycircle.controller.activity.g) (obj))))
                        {
                            com.cyberlink.beautycircle.controller.activity.g.c(((com.cyberlink.beautycircle.controller.activity.g) (obj)));
                            com.cyberlink.beautycircle.controller.activity.g.e(((com.cyberlink.beautycircle.controller.activity.g) (obj)));
                            viewgroup = ((ViewGroup) (obj));
                        }
                    }
                } else
                {
                    viewgroup = null;
                }
                if (Globals.e != null && i1 == com.cyberlink.beautycircle.controller.activity.PostActivity.b(a).size() - 1)
                {
                    (new com.perfectcorp.utility.j(this, i1) {

                        final int a;
                        final _cls9 b;

                        protected volatile Object a(Object obj)
                        {
                            return a((Void)obj);
                        }

                        protected ArrayList a(Void void1)
                        {
                            if (Globals.e != null)
                            {
                                if ((void1 = Globals.e.b(a + 1, 20)) != null)
                                {
                                    return ((com.cyberlink.beautycircle.model.network.d) (void1)).b;
                                }
                            }
                            return null;
                        }

            
            {
                b = _pcls9;
                a = i1;
                super();
            }
                    }).d(null).a(new com.perfectcorp.utility.m(this) {

                        final _cls9 a;

                        protected void a(ArrayList arraylist)
                        {
                            if (arraylist == null)
                            {
                                return;
                            } else
                            {
                                com.cyberlink.beautycircle.controller.activity.PostActivity.b(a.a).addAll(arraylist);
                                com.cyberlink.beautycircle.controller.activity.PostActivity.c(a.a).notifyDataSetChanged();
                                return;
                            }
                        }

                        protected void b(Object obj)
                        {
                            a((ArrayList)obj);
                        }

            
            {
                a = _pcls9;
                super();
            }
                    });
                }
                return viewgroup;
            }

            public boolean isViewFromObject(View view, Object obj)
            {
                return view.getTag().equals(Integer.valueOf(obj.hashCode()));
            }

            
            {
                a = PostActivity.this;
                super();
            }
        };
    }

    static int a(PostActivity postactivity, int i1)
    {
        postactivity.B = i1;
        return i1;
    }

    static long a(PostActivity postactivity, long l1)
    {
        postactivity.K = l1;
        return l1;
    }

    static Long a(PostActivity postactivity, Long long1)
    {
        postactivity.I = long1;
        return long1;
    }

    static String a(PostActivity postactivity, Post post)
    {
        return postactivity.b(post);
    }

    private String a(boolean flag, long l1)
    {
        Object obj = (new StringBuilder()).append(" \u2022 ");
        int i1;
        if (flag)
        {
            i1 = m.bc_post_comment_unlike;
        } else
        {
            i1 = m.bc_post_comment_like;
        }
        obj = ((StringBuilder) (obj)).append(getString(i1)).append(" ").toString();
        if (l1 != 0L)
        {
            return (new StringBuilder()).append(((String) (obj))).append("\u2022").append(" ").toString();
        } else
        {
            return (new StringBuilder()).append(((String) (obj))).append("     ").toString();
        }
    }

    private void a(View view, boolean flag, boolean flag1)
    {
        if (view != null)
        {
            view.setTag(Boolean.valueOf(flag));
            View view1 = view.findViewById(j.like_ico);
            if (view1 != null)
            {
                view1.setSelected(flag);
                if (flag1)
                {
                    ObjectAnimator.ofPropertyValuesHolder(view1, new PropertyValuesHolder[] {
                        PropertyValuesHolder.ofFloat("scaleX", new float[] {
                            1.0F, 2.0F, 1.0F
                        }), PropertyValuesHolder.ofFloat("scaleY", new float[] {
                            1.0F, 2.0F, 1.0F
                        })
                    }).setDuration(300L).start();
                }
            }
            view = view.findViewById(j.like_text);
            if (view != null)
            {
                view.setSelected(flag);
                return;
            }
        }
    }

    private void a(TextView textview, Date date, boolean flag, long l1, long l2)
    {
        if (textview != null)
        {
            Object obj = new h(this);
            obj.a = date;
            obj.b = flag;
            obj.c = l1;
            obj.d = l2;
            textview.setTag(obj);
            int i1 = (int)((double)textview.getTextSize() * 0.80000000000000004D);
            if (r == null)
            {
                r = new DynamicDrawableSpan(1, i1) {

                    final int a;
                    final PostActivity b;

                    public Drawable getDrawable()
                    {
                        Drawable drawable = b.getResources().getDrawable(com.cyberlink.beautycircle.i.bc_issue_comment_time);
                        if (drawable != null)
                        {
                            drawable.setBounds(0, 0, a, a);
                        }
                        return drawable;
                    }

            
            {
                b = PostActivity.this;
                a = j1;
                super(i1);
            }
                };
            }
            date = new SpannableString((new StringBuilder()).append("  ").append(com.cyberlink.beautycircle.utility.i.a(date)).toString());
            date.setSpan(r, 0, 1, 17);
            textview.setText(date);
            date = a(flag, l1);
            obj = new SpannableString(date);
            ((SpannableString) (obj)).setSpan(new com.cyberlink.beautycircle.controller.activity.f(date) {

                final PostActivity a;

                public void onClick(View view)
                {
                    a.a((TextView)view);
                }

            
            {
                a = PostActivity.this;
                super(PostActivity.this, s1);
            }
            }, 0, ((SpannableString) (obj)).length(), 17);
            textview.append(((CharSequence) (obj)));
            textview.setMovementMethod(LinkMovementMethod.getInstance());
            if (l1 > 0L)
            {
                if (s == null)
                {
                    s = new DynamicDrawableSpan(1, i1) {

                        final int a;
                        final PostActivity b;

                        public Drawable getDrawable()
                        {
                            Drawable drawable = b.getResources().getDrawable(com.cyberlink.beautycircle.i.bc_issue_comment_like);
                            if (drawable != null)
                            {
                                drawable.setBounds(0, 0, a, a);
                            }
                            return drawable;
                        }

            
            {
                b = PostActivity.this;
                a = j1;
                super(i1);
            }
                    };
                }
                SpannableString spannablestring = new SpannableString((new StringBuilder()).append("  ").append(l1).toString());
                date = new com.cyberlink.beautycircle.controller.activity.f(date, l2) {

                    final long a;
                    final PostActivity b;

                    public void onClick(View view)
                    {
                        com.cyberlink.beautycircle.c.a(b, "Comment", a);
                    }

            
            {
                b = PostActivity.this;
                a = l1;
                super(PostActivity.this, s1);
            }
                };
                spannablestring.setSpan(new ForegroundColorSpan(getResources().getColor(g.bc_color_main_style_hightlight)), 0, spannablestring.length(), 33);
                spannablestring.setSpan(s, 0, 1, 17);
                spannablestring.setSpan(date, 0, spannablestring.length(), 17);
                textview.append(spannablestring);
            }
        }
    }

    static void a(PostActivity postactivity)
    {
        postactivity.v();
    }

    static void a(PostActivity postactivity, View view, boolean flag, boolean flag1)
    {
        postactivity.a(view, flag, flag1);
    }

    static void a(PostActivity postactivity, TextView textview, Date date, boolean flag, long l1, long l2)
    {
        postactivity.a(textview, date, flag, l1, l2);
    }

    static void a(PostActivity postactivity, Comment comment)
    {
        postactivity.a(comment);
    }

    static void a(PostActivity postactivity, com.cyberlink.beautycircle.model.Contest.VoteStatus votestatus, int i1)
    {
        postactivity.a(votestatus, i1);
    }

    static void a(PostActivity postactivity, PostContentTextView postcontenttextview, String s1)
    {
        postactivity.a(postcontenttextview, s1);
    }

    static void a(PostActivity postactivity, boolean flag)
    {
        postactivity.b(flag);
    }

    private void a(Comment comment)
    {
        for (String s1 = AccountManager.b(); s1 == null || s1.isEmpty() || comment == null;)
        {
            return;
        }

        com.cyberlink.beautycircle.c.a(this, comment.creator.avatar, Long.valueOf(comment.commentId), comment.comment, null);
    }

    private void a(com.cyberlink.beautycircle.model.Contest.VoteStatus votestatus, int i1)
    {
        if (votestatus.voteNum != null)
        {
            votestatus.voteNum = Long.valueOf(votestatus.voteNum.longValue() + (long)i1);
        }
        runOnUiThread(new Runnable(votestatus) {

            final com.cyberlink.beautycircle.model.Contest.VoteStatus a;
            final PostActivity b;

            public void run()
            {
                TopBarFragment topbarfragment = b.b();
                if (topbarfragment == null)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "Topbar null"
                    });
                } else
                if (a.voteNum != null)
                {
                    topbarfragment.b(a.voteNum.toString());
                    return;
                }
            }

            
            {
                b = PostActivity.this;
                a = votestatus;
                super();
            }
        });
    }

    private void a(PostContentTextView postcontenttextview, String s1)
    {
label0:
        {
            if (postcontenttextview != null)
            {
                if (s1 != null && !s1.isEmpty())
                {
                    break label0;
                }
                postcontenttextview.setVisibility(8);
            }
            return;
        }
        postcontenttextview.setTextViewHTML(s1);
        postcontenttextview.setVisibility(0);
    }

    private void a(boolean flag)
    {
        boolean flag1 = false;
        View view = findViewById(j.empty_layout);
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        view.setVisibility(i1);
        view = findViewById(j.normal_layout);
        i1 = ((flag1) ? 1 : 0);
        if (flag)
        {
            i1 = 4;
        }
        view.setVisibility(i1);
    }

    static int b(PostActivity postactivity, int i1)
    {
        postactivity.C = i1;
        return i1;
    }

    static Long b(PostActivity postactivity, Long long1)
    {
        postactivity.J = long1;
        return long1;
    }

    private String b(Post post)
    {
        if (post == null || post.circles == null || post.circles.size() == 0)
        {
            return null;
        } else
        {
            return ((com.cyberlink.beautycircle.model.Post.PostCircle)post.circles.get(0)).defaultType;
        }
    }

    static ArrayList b(PostActivity postactivity)
    {
        return postactivity.z;
    }

    static void b(PostActivity postactivity, boolean flag)
    {
        postactivity.a(flag);
    }

    private void b(boolean flag)
    {
        runOnUiThread(new Runnable(flag) {

            final boolean a;
            final PostActivity b;

            public void run()
            {
                TopBarFragment topbarfragment = b.b();
                if (topbarfragment == null)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "Topbar null"
                    });
                    return;
                }
                if (a)
                {
                    topbarfragment.e(true);
                    topbarfragment.g(false);
                    topbarfragment.c(m.bc_top_bar_voted_btn);
                    return;
                } else
                {
                    topbarfragment.e(false);
                    topbarfragment.g(true);
                    topbarfragment.c(m.bc_top_bar_vote_btn);
                    return;
                }
            }

            
            {
                b = PostActivity.this;
                a = flag;
                super();
            }
        });
    }

    static PagerAdapter c(PostActivity postactivity)
    {
        return postactivity.N;
    }

    static int d(PostActivity postactivity)
    {
        return postactivity.B;
    }

    static TreeMap e(PostActivity postactivity)
    {
        return postactivity.A;
    }

    static boolean f(PostActivity postactivity)
    {
        return postactivity.H;
    }

    static String g(PostActivity postactivity)
    {
        return postactivity.E;
    }

    static Long h(PostActivity postactivity)
    {
        return postactivity.I;
    }

    static long i(PostActivity postactivity)
    {
        return postactivity.K;
    }

    static EmojiconEditText j(PostActivity postactivity)
    {
        return postactivity.w;
    }

    static TextView k(PostActivity postactivity)
    {
        return postactivity.x;
    }

    static String l(PostActivity postactivity)
    {
        return postactivity.F;
    }

    static boolean m(PostActivity postactivity)
    {
        return postactivity.D;
    }

    static android.view.View.OnClickListener n(PostActivity postactivity)
    {
        return postactivity.L;
    }

    static android.view.View.OnClickListener o(PostActivity postactivity)
    {
        return postactivity.M;
    }

    static Long p(PostActivity postactivity)
    {
        return postactivity.J;
    }

    static int q(PostActivity postactivity)
    {
        return postactivity.C;
    }

    static boolean r(PostActivity postactivity)
    {
        return postactivity.BaseActivity.e();
    }

    private void u()
    {
        x = (TextView)findViewById(j.post_comment_btn);
        if (x != null)
        {
            x.setOnClickListener(new android.view.View.OnClickListener() {

                final PostActivity a;

                public void onClick(View view)
                {
                    view = (com.cyberlink.beautycircle.controller.activity.g)com.cyberlink.beautycircle.controller.activity.PostActivity.e(a).get(Integer.valueOf(com.cyberlink.beautycircle.controller.activity.PostActivity.d(a)));
                    if (view != null)
                    {
                        view.g();
                    }
                    aq.c = "comment";
                    String s1 = com.cyberlink.beautycircle.controller.activity.PostActivity.a(a, com.cyberlink.beautycircle.controller.activity.g.a(view));
                    if (s1 != null)
                    {
                        com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.e(s1, 0L, "comment", com.cyberlink.beautycircle.controller.activity.PostActivity.f(a), 0L));
                    }
                    if (view != null)
                    {
                        com.perfectcorp.a.b.a(new am(am.b, "comment", Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.b(view)), Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.a(view).creator.userId), 0L));
                    }
                }

            
            {
                a = PostActivity.this;
                super();
            }
            });
            x.setEnabled(false);
        }
        w = (EmojiconEditText)findViewById(j.post_comment_text);
        if (w != null)
        {
            w.addTextChangedListener(v);
        }
        y = (ViewPager)findViewById(j.post_view_pager);
        y.setOnPageChangeListener(u);
        y.setAdapter(N);
        DialogUtils.a(findViewById(j.empty_layout), m.bc_post_not_exist, true, t);
    }

    private void v()
    {
        findViewById(j.empty_layout).setVisibility(8);
        findViewById(j.normal_layout).setVisibility(4);
    }

    protected void a(TextView textview)
    {
        aq.c = "comment_like";
        AccountManager.a(this, new com.cyberlink.beautycircle.utility.b(textview) {

            final TextView a;
            final PostActivity b;

            public void a()
            {
                Globals.b("getAccountToken Fail");
            }

            public void a(String s1)
            {
                h h1 = (h)a.getTag();
                Date date = h1.a;
                boolean flag = h1.b;
                long l1 = h1.c;
                int i1;
                long l2;
                long l3;
                if (flag)
                {
                    i1 = -1;
                } else
                {
                    i1 = 1;
                }
                l2 = i1;
                l3 = h1.d;
                b.runOnUiThread(new Runnable(this, date, flag, l1 + l2, l3) {

                    final Date a;
                    final boolean b;
                    final long c;
                    final long d;
                    final _cls14 e;

                    public void run()
                    {
                        PostActivity postactivity = e.b;
                        TextView textview = e.a;
                        Date date = a;
                        boolean flag;
                        if (!b)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        com.cyberlink.beautycircle.controller.activity.PostActivity.a(postactivity, textview, date, flag, c, d);
                    }

            
            {
                e = _pcls14;
                a = date;
                b = flag;
                c = l1;
                d = l2;
                super();
            }
                });
                if (flag)
                {
                    NetworkPost.b(s1, "Comment", l3);
                } else
                {
                    NetworkPost.a(s1, "Comment", l3);
                }
                t.d.a();
            }

            public void b()
            {
                Globals.b("getAccountToken Cancel");
            }

            
            {
                b = PostActivity.this;
                a = textview;
                super();
            }
        });
    }

    public String d(String s1)
    {
        if (A == null)
        {
            return null;
        }
        s1 = (com.cyberlink.beautycircle.controller.activity.g)A.get(Integer.valueOf(B));
        if (s1 != null)
        {
            s1 = String.format(Locale.getDefault(), "ybc://post/%d", new Object[] {
                Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.b(s1))
            });
        } else
        {
            s1 = null;
        }
        return s1;
    }

    protected boolean e()
    {
        Intent intent = new Intent();
        Object obj = (com.cyberlink.beautycircle.controller.activity.g)A.get(Integer.valueOf(B));
        if (obj != null)
        {
            obj = ((com.cyberlink.beautycircle.controller.activity.g) (obj)).b();
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            intent.putExtra("PostId", ((java.io.Serializable) (obj)));
            setResult(48256, intent);
        }
        super.e();
        overridePendingTransition(f.bc_slide_in_left, f.bc_slide_out_right);
        return true;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "requestCode: ", String.valueOf(i1), ", resultCode: ", String.valueOf(j1), ", data: ", intent
        });
        super.onActivityResult(i1, j1, intent);
        if (i1 != 48149 || j1 != -1) goto _L2; else goto _L1
_L1:
        intent = (com.cyberlink.beautycircle.controller.activity.g)A.get(Integer.valueOf(B));
        if (intent != null)
        {
            intent.e();
        }
_L4:
        return;
_L2:
        if (i1 != 48163 || j1 != -1)
        {
            break; /* Loop/switch isn't completed */
        }
        intent = (com.cyberlink.beautycircle.controller.activity.g)A.get(Integer.valueOf(B));
        if (intent != null)
        {
            intent.e();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (i1 != 48150)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (j1 != -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        intent = (com.cyberlink.beautycircle.controller.activity.g)A.get(Integer.valueOf(B));
        if (intent != null)
        {
            intent.h();
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (j1 != 48257) goto _L4; else goto _L5
_L5:
        e();
        return;
        if (i1 != 48157 || j1 != 48256) goto _L4; else goto _L6
_L6:
        a(intent);
        if (intent != null)
        {
            BCTileImage.a((Post)Model.a(com/cyberlink/beautycircle/model/Post, intent.getStringExtra("ShareInPost")));
            return;
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    protected void onCreate(Bundle bundle)
    {
        int i1;
        long l1;
        super.onCreate(bundle);
        setContentView(k.bc_activity_post);
        u();
        Object obj = getIntent();
        D = ((Intent) (obj)).getBooleanExtra("ShowTopPanel", true);
        C = ((Intent) (obj)).getIntExtra("ScrollPosition", 0);
        H = ((Intent) (obj)).getBooleanExtra("Slide", false);
        E = ((Intent) (obj)).getStringExtra("sourceType");
        F = ((Intent) (obj)).getStringExtra("PostType");
        boolean flag = ((Intent) (obj)).getBooleanExtra("HasListAdapter", false);
        l1 = ((Intent) (obj)).getLongExtra("PostId", -1L);
        if (l1 == -1L)
        {
            String s1 = ((Intent) (obj)).getStringExtra("Post");
            if (s1 != null)
            {
                obj = (Post)Model.a(com/cyberlink/beautycircle/model/Post, s1);
                if (obj != null && ((Post) (obj)).postId != null)
                {
                    l1 = ((Post) (obj)).postId.longValue();
                }
            } else
            {
                obj = ((Intent) (obj)).getData();
                d d1 = com.perfectcorp.utility.c.a(((Uri) (obj)));
                long l2 = l1;
                if (d1 != null)
                {
                    l2 = l1;
                    if (d1.b != null)
                    {
                        l2 = d1.b.longValue();
                    }
                }
                E = ((Uri) (obj)).getQueryParameter("sourceType");
                flag = false;
                l1 = l2;
            }
        }
        if ("ymk".equals(E))
        {
            s.a = "ymk";
        }
        if (!flag)
        {
            Globals.e = null;
        }
        if (Globals.e == null)
        {
            break MISSING_BLOCK_LABEL_344;
        }
        z.addAll(Globals.e.f());
        N.notifyDataSetChanged();
        i1 = 0;
_L5:
        if (i1 >= z.size()) goto _L2; else goto _L1
_L1:
        if (((Post)z.get(i1)).postId.longValue() != l1) goto _L4; else goto _L3
_L3:
        B = i1;
        y.setCurrentItem(i1, false);
_L2:
        b("");
        b(bundle);
        return;
_L4:
        i1++;
          goto _L5
        Post.a(null, l1).a(new com.perfectcorp.utility.m(l1) {

            final long a;
            final PostActivity b;

            protected void a(Post post)
            {
                Post post1 = post;
                if (post == null)
                {
                    post1 = new Post();
                    post1.postId = Long.valueOf(a);
                    com.cyberlink.beautycircle.controller.activity.PostActivity.a(b);
                    b.k();
                }
                com.cyberlink.beautycircle.controller.activity.PostActivity.b(b).add(post1);
                com.cyberlink.beautycircle.controller.activity.PostActivity.c(b).notifyDataSetChanged();
            }

            protected void b(Object obj1)
            {
                a((Post)obj1);
            }

            
            {
                b = PostActivity.this;
                a = l1;
                super();
            }
        });
          goto _L2
    }

    protected void onPause()
    {
        com.cyberlink.beautycircle.controller.activity.g g1 = (com.cyberlink.beautycircle.controller.activity.g)A.get(Integer.valueOf(B));
        if (g1 != null)
        {
            Long long1 = Long.valueOf(System.currentTimeMillis());
            if (com.cyberlink.beautycircle.controller.activity.g.a(g1) != null && com.cyberlink.beautycircle.controller.activity.g.a(g1).circles != null && com.cyberlink.beautycircle.controller.activity.g.a(g1).circles.size() > 0)
            {
                String s1 = b(com.cyberlink.beautycircle.controller.activity.g.a(g1));
                if (s1 != null)
                {
                    com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.e(s1, long1.longValue() - I.longValue(), "PostView", H, 0L));
                }
            }
            com.perfectcorp.a.b.a(new af(Long.toString(com.cyberlink.beautycircle.controller.activity.g.b(g1)), E, I, long1));
            com.perfectcorp.a.b.a(new am(null, null, null, null, long1.longValue() - I.longValue()));
            I = Long.valueOf(System.currentTimeMillis());
        }
        super.onPause();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
    }

    public void onResume()
    {
        if (z.size() > 0)
        {
            Object obj = (Post)z.get(B);
            if (obj != null && ((Post) (obj)).extLookUrl != null && !((Post) (obj)).extLookUrl.isEmpty())
            {
                J = Long.valueOf(System.currentTimeMillis());
                if (ad.d(((Post) (obj)).d()))
                {
                    com.perfectcorp.a.b.a(new s(E, "show", "video", ((Post) (obj)).postId, 0L));
                } else
                {
                    com.perfectcorp.a.b.a(new s(E, "show", "picture", ((Post) (obj)).postId, 0L));
                }
                K = ((Post) (obj)).postId.longValue();
            }
            I = Long.valueOf(System.currentTimeMillis());
            if (obj != null)
            {
                com.perfectcorp.a.b.a(new am(am.b, "show", ((Post) (obj)).postId, AccountManager.c(), 0L));
            }
        }
        obj = (com.cyberlink.beautycircle.controller.activity.g)A.get(Integer.valueOf(B));
        if (obj != null && com.cyberlink.beautycircle.controller.activity.g.f(((com.cyberlink.beautycircle.controller.activity.g) (obj))))
        {
            com.perfectcorp.a.b.a(new am(am.b, "related_post_show", com.cyberlink.beautycircle.controller.activity.g.a(((com.cyberlink.beautycircle.controller.activity.g) (obj))).postId, Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.a(((com.cyberlink.beautycircle.controller.activity.g) (obj))).creator.userId), 0L));
        }
        super.onResume();
    }

    public void onRightBtnClick(View view)
    {
        com.cyberlink.beautycircle.controller.activity.g g1 = (com.cyberlink.beautycircle.controller.activity.g)A.get(Integer.valueOf(B));
        if (g1 != null && com.cyberlink.beautycircle.controller.activity.g.a(g1) != null)
        {
            view = com.cyberlink.beautycircle.controller.activity.g.a(g1).postId;
        } else
        {
            view = null;
        }
        if ("contest".equals(com.cyberlink.beautycircle.controller.activity.g.a(g1).postSource))
        {
            b(true);
            if (view != null)
            {
                a(com.cyberlink.beautycircle.controller.activity.g.g(g1), 1);
                NetworkContest.b(view).a(new com.perfectcorp.utility.m(view, g1) {

                    final Long a;
                    final com.cyberlink.beautycircle.controller.activity.g b;
                    final PostActivity c;

                    protected void a(int i1)
                    {
                        com.perfectcorp.utility.e.d(new Object[] {
                            "Vote Fail: ", a, ", code=", Integer.valueOf(i1)
                        });
                        if (i1 != 0x80000001)
                        {
                            Globals.b((new StringBuilder()).append("Vote Fail: code=").append(i1).toString());
                        }
                        com.cyberlink.beautycircle.controller.activity.PostActivity.a(c, com.cyberlink.beautycircle.controller.activity.g.g(b), -1);
                        if (i1 != 0x80000001)
                        {
                            com.cyberlink.beautycircle.controller.activity.PostActivity.a(c, false);
                        }
                        super.a(i1);
                    }

                    protected void a(com.cyberlink.beautycircle.model.network.NetworkContest.ContestResult contestresult)
                    {
                        com.perfectcorp.utility.e.c(new Object[] {
                            "Vote: ", a, ", response=", contestresult.result
                        });
                        if (contestresult.result == null)
                        {
                            a(0x80000001);
                            return;
                        }
                        if ("OK".equals(contestresult.result.status))
                        {
                            Globals.b("Vote Succeed.");
                            return;
                        }
                        if ("Repeat".equals(contestresult.result.status))
                        {
                            Globals.b("Vote Repeated.");
                            a(0x80000001);
                            return;
                        } else
                        {
                            a(0x80000001);
                            return;
                        }
                    }

                    protected void b(Object obj)
                    {
                        a((com.cyberlink.beautycircle.model.network.NetworkContest.ContestResult)obj);
                    }

            
            {
                c = PostActivity.this;
                a = long1;
                b = g1;
                super();
            }
                });
            }
        } else
        if ("howto".equals(F))
        {
            if (com.cyberlink.beautycircle.controller.activity.g.a(g1) != null && com.cyberlink.beautycircle.controller.activity.g.a(g1).circles != null && com.cyberlink.beautycircle.controller.activity.g.a(g1).circles.size() > 0)
            {
                long l1 = System.currentTimeMillis();
                com.perfectcorp.a.b.a(new s(E, "more", null, com.cyberlink.beautycircle.controller.activity.g.a(g1).postId, l1 - J.longValue()));
                if (g1 != null)
                {
                    com.cyberlink.beautycircle.controller.a.e.a = "more";
                    com.cyberlink.beautycircle.c.a(this, "", ((com.cyberlink.beautycircle.model.Post.PostCircle)com.cyberlink.beautycircle.controller.activity.g.a(g1).circles.get(0)).circleTypeId, null, false, true, true);
                    finish();
                    return;
                }
            }
        } else
        {
            if (g1 != null && com.cyberlink.beautycircle.controller.activity.g.a(g1) != null && com.cyberlink.beautycircle.controller.activity.g.a(g1).creator != null)
            {
                com.perfectcorp.a.b.a(new am(am.b, "circleIt", Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.b(g1)), Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.a(g1).creator.userId), 0L));
            }
            aq.c = "circle_it";
            view = b(com.cyberlink.beautycircle.controller.activity.g.a(g1));
            if (view != null)
            {
                com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.e(view, 0L, "circleIt", H, 0L));
            }
            AccountManager.a(this, new com.cyberlink.beautycircle.utility.b(g1) {

                final com.cyberlink.beautycircle.controller.activity.g a;
                final PostActivity b;

                public void a()
                {
                    Globals.b("Get AccountToken Fail");
                }

                public void a(String s1)
                {
                    if (a != null)
                    {
                        com.cyberlink.beautycircle.c.a(b, com.cyberlink.beautycircle.controller.activity.g.a(a));
                    }
                }

                public void b()
                {
                    Globals.b("Get AccountToken Cancel");
                }

            
            {
                b = PostActivity.this;
                a = g1;
                super();
            }
            });
            return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    public void q()
    {
        com.cyberlink.beautycircle.controller.activity.g g1 = (com.cyberlink.beautycircle.controller.activity.g)A.get(Integer.valueOf(B));
        if (g1 != null)
        {
            g1.a();
        }
    }

}
