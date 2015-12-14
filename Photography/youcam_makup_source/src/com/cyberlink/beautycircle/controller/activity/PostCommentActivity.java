// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.f;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.Comment;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.b;
import com.cyberlink.beautycircle.utility.i;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.d;
import com.perfectcorp.utility.e;
import com.rockerhieu.emojicon.EmojiconEditText;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            k, j, i

public class PostCommentActivity extends BaseActivity
{

    public static final UUID e = UUID.randomUUID();
    DynamicDrawableSpan f;
    DynamicDrawableSpan g;
    protected android.view.View.OnClickListener h;
    protected TextWatcher i;
    protected android.view.View.OnFocusChangeListener j;
    private EmojiconEditText k;
    private TextView l;
    private com.cyberlink.beautycircle.controller.activity.j m;
    private int n;
    private boolean o;

    public PostCommentActivity()
    {
        k = null;
        l = null;
        n = 0;
        o = false;
        f = null;
        g = null;
        h = new android.view.View.OnClickListener() {

            final PostCommentActivity a;

            public void onClick(View view)
            {
                if (com.cyberlink.beautycircle.controller.activity.PostCommentActivity.b(a) != null)
                {
                    com.cyberlink.beautycircle.controller.activity.j.a(com.cyberlink.beautycircle.controller.activity.PostCommentActivity.b(a));
                }
            }

            
            {
                a = PostCommentActivity.this;
                super();
            }
        };
        i = new TextWatcher() {

            final PostCommentActivity a;

            public void afterTextChanged(Editable editable)
            {
label0:
                {
                    if (com.cyberlink.beautycircle.controller.activity.PostCommentActivity.c(a) != null && com.cyberlink.beautycircle.controller.activity.PostCommentActivity.d(a) != null)
                    {
                        if (!com.cyberlink.beautycircle.controller.activity.PostCommentActivity.c(a).getText().toString().isEmpty())
                        {
                            break label0;
                        }
                        com.cyberlink.beautycircle.controller.activity.PostCommentActivity.d(a).setEnabled(false);
                    }
                    return;
                }
                com.cyberlink.beautycircle.controller.activity.PostCommentActivity.d(a).setEnabled(true);
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            
            {
                a = PostCommentActivity.this;
                super();
            }
        };
        j = new android.view.View.OnFocusChangeListener() {

            final PostCommentActivity a;

            public void onFocusChange(View view, boolean flag)
            {
                if (flag && AccountManager.b() == null)
                {
                    a.i();
                    view.clearFocus();
                    AccountManager.a(a, null);
                }
            }

            
            {
                a = PostCommentActivity.this;
                super();
            }
        };
    }

    static int a(PostCommentActivity postcommentactivity, int i1)
    {
        postcommentactivity.n = i1;
        return i1;
    }

    static com.cyberlink.beautycircle.controller.activity.j a(PostCommentActivity postcommentactivity, com.cyberlink.beautycircle.controller.activity.j j1)
    {
        postcommentactivity.m = j1;
        return j1;
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

    private void a(TextView textview, Date date, boolean flag, long l1, long l2)
    {
        if (textview != null)
        {
            Object obj = new com.cyberlink.beautycircle.controller.activity.k(this);
            obj.a = date;
            obj.b = flag;
            obj.c = l1;
            obj.d = l2;
            textview.setTag(obj);
            int i1 = (int)((double)textview.getTextSize() * 0.80000000000000004D);
            if (f == null)
            {
                f = new DynamicDrawableSpan(1, i1) {

                    final int a;
                    final PostCommentActivity b;

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
                b = PostCommentActivity.this;
                a = j1;
                super(i1);
            }
                };
            }
            date = new SpannableString((new StringBuilder()).append("  ").append(com.cyberlink.beautycircle.utility.i.a(date)).toString());
            date.setSpan(f, 0, 1, 17);
            textview.setText(date);
            date = a(flag, l1);
            obj = new SpannableString(date);
            ((SpannableString) (obj)).setSpan(new com.cyberlink.beautycircle.controller.activity.i(date) {

                final PostCommentActivity a;

                public void onClick(View view)
                {
                    a.a((TextView)view);
                }

            
            {
                a = PostCommentActivity.this;
                super(PostCommentActivity.this, s);
            }
            }, 0, ((SpannableString) (obj)).length(), 17);
            textview.append(((CharSequence) (obj)));
            textview.setMovementMethod(LinkMovementMethod.getInstance());
            if (l1 > 0L)
            {
                if (g == null)
                {
                    g = new DynamicDrawableSpan(1, i1) {

                        final int a;
                        final PostCommentActivity b;

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
                b = PostCommentActivity.this;
                a = j1;
                super(i1);
            }
                    };
                }
                SpannableString spannablestring = new SpannableString((new StringBuilder()).append("  ").append(l1).toString());
                date = new com.cyberlink.beautycircle.controller.activity.i(date, l2) {

                    final long a;
                    final PostCommentActivity b;

                    public void onClick(View view)
                    {
                        com.cyberlink.beautycircle.c.a(b, "Comment", a);
                    }

            
            {
                b = PostCommentActivity.this;
                a = l1;
                super(PostCommentActivity.this, s);
            }
                };
                spannablestring.setSpan(new ForegroundColorSpan(getResources().getColor(g.bc_color_main_style_hightlight)), 0, spannablestring.length(), 33);
                spannablestring.setSpan(g, 0, 1, 17);
                spannablestring.setSpan(date, 0, spannablestring.length(), 17);
                textview.append(spannablestring);
            }
        }
    }

    static void a(PostCommentActivity postcommentactivity)
    {
        postcommentactivity.q();
    }

    static void a(PostCommentActivity postcommentactivity, TextView textview, Date date, boolean flag, long l1, long l2)
    {
        postcommentactivity.a(textview, date, flag, l1, l2);
    }

    static void a(PostCommentActivity postcommentactivity, Comment comment)
    {
        postcommentactivity.a(comment);
    }

    static void a(PostCommentActivity postcommentactivity, boolean flag)
    {
        postcommentactivity.a(flag);
    }

    private void a(Comment comment)
    {
        for (String s = AccountManager.b(); s == null || s.isEmpty() || comment == null;)
        {
            return;
        }

        com.cyberlink.beautycircle.c.a(this, comment.creator.avatar, Long.valueOf(comment.commentId), comment.comment, null);
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

    static com.cyberlink.beautycircle.controller.activity.j b(PostCommentActivity postcommentactivity)
    {
        return postcommentactivity.m;
    }

    static EmojiconEditText c(PostCommentActivity postcommentactivity)
    {
        return postcommentactivity.k;
    }

    static TextView d(PostCommentActivity postcommentactivity)
    {
        return postcommentactivity.l;
    }

    static boolean e(PostCommentActivity postcommentactivity)
    {
        return postcommentactivity.o;
    }

    static void f(PostCommentActivity postcommentactivity)
    {
        postcommentactivity.o();
    }

    static int g(PostCommentActivity postcommentactivity)
    {
        return postcommentactivity.n;
    }

    private void o()
    {
        if (k != null)
        {
            k.requestFocus();
            showSoftInput(k);
        }
    }

    private void p()
    {
        l = (TextView)findViewById(j.post_comment_btn);
        if (l != null)
        {
            l.setOnClickListener(new android.view.View.OnClickListener() {

                final PostCommentActivity a;

                public void onClick(View view)
                {
                    if (com.cyberlink.beautycircle.controller.activity.PostCommentActivity.b(a) != null)
                    {
                        com.cyberlink.beautycircle.controller.activity.PostCommentActivity.b(a).e();
                    }
                }

            
            {
                a = PostCommentActivity.this;
                super();
            }
            });
            l.setEnabled(false);
        }
        k = (EmojiconEditText)findViewById(j.post_comment_text);
        if (k != null)
        {
            k.addTextChangedListener(i);
            k.setOnFocusChangeListener(j);
        }
        DialogUtils.a(findViewById(j.empty_layout), m.bc_post_not_exist, true, h);
    }

    private void q()
    {
        findViewById(j.empty_layout).setVisibility(8);
        findViewById(j.normal_layout).setVisibility(4);
    }

    protected void a(TextView textview)
    {
        aq.c = "comment_like";
        AccountManager.a(this, new b(textview) {

            final TextView a;
            final PostCommentActivity b;

            public void a()
            {
                Globals.b("getAccountToken Fail");
            }

            public void a(String s)
            {
                com.cyberlink.beautycircle.controller.activity.k k1 = (com.cyberlink.beautycircle.controller.activity.k)a.getTag();
                Date date = k1.a;
                boolean flag = k1.b;
                long l1 = k1.c;
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
                l3 = k1.d;
                b.runOnUiThread(new Runnable(this, date, flag, l1 + l2, l3) {

                    final Date a;
                    final boolean b;
                    final long c;
                    final long d;
                    final _cls7 e;

                    public void run()
                    {
                        PostCommentActivity postcommentactivity = e.b;
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
                        PostCommentActivity.a(postcommentactivity, textview, date, flag, c, d);
                    }

            
            {
                e = _pcls7;
                a = date;
                b = flag;
                c = l1;
                d = l2;
                super();
            }
                });
                if (flag)
                {
                    NetworkPost.b(s, "Comment", l3);
                } else
                {
                    NetworkPost.a(s, "Comment", l3);
                }
                t.d.a();
                b.setResult(-1);
            }

            public void b()
            {
                Globals.b("getAccountToken Cancel");
            }

            
            {
                b = PostCommentActivity.this;
                a = textview;
                super();
            }
        });
    }

    public String d(String s)
    {
        s = null;
        if (m != null)
        {
            s = String.format(Locale.getDefault(), "ybc://post/%d", new Object[] {
                Long.valueOf(com.cyberlink.beautycircle.controller.activity.j.b(m))
            });
        }
        return s;
    }

    protected boolean e()
    {
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
        if (i1 == 48149 && j1 == -1 && m != null)
        {
            m.b();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        long l1;
        long l2;
        super.onCreate(bundle);
        setContentView(k.bc_activity_post_comment);
        p();
        bundle = getIntent();
        o = bundle.getBooleanExtra("CommentMode", false);
        n = bundle.getIntExtra("ScrollPosition", 0);
        l2 = bundle.getLongExtra("PostId", -1L);
        l1 = l2;
        if (l2 != -1L) goto _L2; else goto _L1
_L1:
        String s = bundle.getStringExtra("Post");
        if (s == null) goto _L4; else goto _L3
_L3:
        bundle = (Post)Model.a(com/cyberlink/beautycircle/model/Post, s);
        if (bundle != null && ((Post) (bundle)).postId != null)
        {
            l1 = ((Post) (bundle)).postId.longValue();
        } else
        {
            l1 = l2;
        }
_L2:
        Post.a(null, l1).a(new com.perfectcorp.utility.m(l1) {

            final long a;
            final PostCommentActivity b;

            protected void a(Post post)
            {
                Post post1 = post;
                if (post == null)
                {
                    post1 = new Post();
                    post1.postId = Long.valueOf(a);
                    PostCommentActivity.a(b);
                    b.k();
                }
                post = (ViewGroup)b.findViewById(j.post_view);
                PostCommentActivity.a(b, new com.cyberlink.beautycircle.controller.activity.j(b, post, post1));
                com.cyberlink.beautycircle.controller.activity.j.a(com.cyberlink.beautycircle.controller.activity.PostCommentActivity.b(b));
            }

            protected void b(Object obj)
            {
                a((Post)obj);
            }

            
            {
                b = PostCommentActivity.this;
                a = l1;
                super();
            }
        });
        b(m.bc_post_comment_title);
        return;
_L4:
        bundle = com.perfectcorp.utility.c.a(bundle.getData());
        l1 = l2;
        if (bundle != null)
        {
            l1 = l2;
            if (((d) (bundle)).b != null)
            {
                l1 = ((d) (bundle)).b.longValue();
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

}
