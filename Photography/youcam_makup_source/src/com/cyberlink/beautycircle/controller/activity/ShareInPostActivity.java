// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.g;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleBasic;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.u;
import com.cyberlink.beautycircle.utility.v;
import com.cyberlink.beautycircle.view.widgetpool.common.CirclePager;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.a.b;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.TreeSet;

public class ShareInPostActivity extends BaseActivity
{

    protected android.view.View.OnClickListener e;
    protected android.view.View.OnClickListener f;
    protected android.view.View.OnClickListener g;
    private ImageView h;
    private EditText i;
    private UICImageView j;
    private TextView k;
    private CirclePager l;
    private View m;
    private Post n;
    private CircleBasic o;
    private u p;
    private com.cyberlink.beautycircle.view.widgetpool.common.g q;

    public ShareInPostActivity()
    {
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        e = new android.view.View.OnClickListener() {

            final ShareInPostActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.controller.activity.ShareInPostActivity.c(a);
            }

            
            {
                a = ShareInPostActivity.this;
                super();
            }
        };
        f = new android.view.View.OnClickListener() {

            final ShareInPostActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.c.a(a, null, Boolean.valueOf(false));
            }

            
            {
                a = ShareInPostActivity.this;
                super();
            }
        };
        g = new android.view.View.OnClickListener() {

            final ShareInPostActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.controller.activity.ShareInPostActivity.d(a);
            }

            
            {
                a = ShareInPostActivity.this;
                super();
            }
        };
        p = new u() {

            final ShareInPostActivity a;

            public void a()
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "OnNewCircle"
                });
                com.cyberlink.beautycircle.controller.activity.ShareInPostActivity.e(a).a();
            }

            
            {
                a = ShareInPostActivity.this;
                super();
            }
        };
        q = new com.cyberlink.beautycircle.view.widgetpool.common.g() {

            final ShareInPostActivity a;

            public void a()
            {
                com.cyberlink.beautycircle.c.a(a, null, Boolean.valueOf(false));
            }

            public void a(int i1)
            {
                switch (i1)
                {
                default:
                    String s1 = (new StringBuilder()).append(a.getResources().getString(m.bc_register_error_network_unavailabe)).append(s.a(i1)).toString();
                    DialogUtils.a(a, a.getResources().getString(m.bc_dialog_title_warning), s1, new Runnable(this) {

                        final _cls9 a;

                        public void run()
                        {
                            a.a.finish();
                        }

            
            {
                a = _pcls9;
                super();
            }
                    });
                    return;

                case 32769: 
                    com.perfectcorp.utility.e.e(new Object[] {
                        "Not logged in"
                    });
                    break;
                }
                DialogUtils.a(a, a.getResources().getString(m.bc_sharein_dialog_title), a.getResources().getString(m.bc_write_post_message_must_sign_in), new Runnable(this) {

                    final _cls9 a;

                    public void run()
                    {
                        a.a.finish();
                    }

            
            {
                a = _pcls9;
                super();
            }
                });
            }

            public void a(TreeSet treeset)
            {
                if (treeset.isEmpty())
                {
                    ShareInPostActivity.a(a, null);
                    return;
                } else
                {
                    ShareInPostActivity.a(a, (CircleBasic)treeset.first());
                    com.cyberlink.beautycircle.controller.activity.ShareInPostActivity.d(a);
                    return;
                }
            }

            public void b()
            {
                a.k();
            }

            public void c()
            {
                a.l();
            }

            
            {
                a = ShareInPostActivity.this;
                super();
            }
        };
    }

    static CircleBasic a(ShareInPostActivity shareinpostactivity, CircleBasic circlebasic)
    {
        shareinpostactivity.o = circlebasic;
        return circlebasic;
    }

    static boolean a(ShareInPostActivity shareinpostactivity)
    {
        return shareinpostactivity.BaseActivity.e();
    }

    static View b(ShareInPostActivity shareinpostactivity)
    {
        return shareinpostactivity.m;
    }

    static boolean c(ShareInPostActivity shareinpostactivity)
    {
        return shareinpostactivity.e();
    }

    static void d(ShareInPostActivity shareinpostactivity)
    {
        shareinpostactivity.p();
    }

    static CirclePager e(ShareInPostActivity shareinpostactivity)
    {
        return shareinpostactivity.l;
    }

    static CircleBasic f(ShareInPostActivity shareinpostactivity)
    {
        return shareinpostactivity.o;
    }

    static void g(ShareInPostActivity shareinpostactivity)
    {
        shareinpostactivity.q();
    }

    static Post h(ShareInPostActivity shareinpostactivity)
    {
        return shareinpostactivity.n;
    }

    static EditText i(ShareInPostActivity shareinpostactivity)
    {
        return shareinpostactivity.i;
    }

    static boolean j(ShareInPostActivity shareinpostactivity)
    {
        return shareinpostactivity.BaseActivity.e();
    }

    private void o()
    {
        Long long1 = AccountManager.c();
        if (n == null || n.postId == null || long1 == null)
        {
            return;
        } else
        {
            NetworkPost.a(n.postId.longValue(), long1.longValue(), Integer.valueOf(0), Integer.valueOf(1)).a(new j() {

                final ShareInPostActivity a;

                protected CircleBasic a(d d1)
                {
                    if (d1 != null && d1.b != null && !d1.b.isEmpty())
                    {
                        return (CircleBasic)d1.b.get(0);
                    } else
                    {
                        return null;
                    }
                }

                protected volatile Object a(Object obj)
                {
                    return a((d)obj);
                }

            
            {
                a = ShareInPostActivity.this;
                super();
            }
            }).a(new com.perfectcorp.utility.m() {

                final ShareInPostActivity a;

                protected void a(CircleBasic circlebasic)
                {
                    if (circlebasic != null && com.cyberlink.beautycircle.controller.activity.ShareInPostActivity.b(a) != null)
                    {
                        com.cyberlink.beautycircle.controller.activity.ShareInPostActivity.b(a).setVisibility(0);
                        com.cyberlink.beautycircle.controller.activity.ShareInPostActivity.b(a).setOnClickListener(new android.view.View.OnClickListener(this, circlebasic) {

                            final CircleBasic a;
                            final _cls2 b;

                            public void onClick(View view)
                            {
                                com.cyberlink.beautycircle.c.a(b.a, a.circleCreatorId, a.id);
                            }

            
            {
                b = _pcls2;
                a = circlebasic;
                super();
            }
                        });
                    }
                }

                protected void b(Object obj)
                {
                    a((CircleBasic)obj);
                }

            
            {
                a = ShareInPostActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void p()
    {
        k();
        AccountManager.a(this, new com.cyberlink.beautycircle.utility.b() {

            final ShareInPostActivity a;

            public void a()
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "getAccountToken fail"
                });
                a.l();
                DialogUtils.a(a, m.bc_write_post_message_must_sign_in);
            }

            public void a(String s)
            {
                if (ShareInPostActivity.f(a) == null)
                {
                    a.l();
                    DialogUtils.a(a, m.bc_write_post_message_need_circle);
                    return;
                } else
                {
                    NetworkPost.a(s, ShareInPostActivity.h(a).postId, ShareInPostActivity.i(a).getText().toString(), ShareInPostActivity.f(a).id).a(new com.perfectcorp.utility.m(this) {

                        final _cls8 a;

                        protected void a()
                        {
                            a.a.l();
                            a(0x80000005);
                        }

                        protected void a(int i1)
                        {
                            com.perfectcorp.utility.e.e(new Object[] {
                                "NetworkPost.circleInPost fail: ", Integer.valueOf(i1)
                            });
                            a.a.l();
                            String s1 = (new StringBuilder()).append(a.a.getResources().getString(m.bc_write_post_message_create_post_fail)).append(s.a(i1)).toString();
                            DialogUtils.a(a.a, s1);
                        }

                        protected void a(com.cyberlink.beautycircle.model.network.NetworkPost.CircleInPostResult circleinpostresult)
                        {
                            com.perfectcorp.utility.e.b(new Object[] {
                                "NetworkPost.circleInPost done"
                            });
                            com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.j("internal"));
                            a.a.l();
                            com.cyberlink.beautycircle.controller.activity.ShareInPostActivity.g(a.a);
                        }

                        protected void b(Object obj)
                        {
                            a((com.cyberlink.beautycircle.model.network.NetworkPost.CircleInPostResult)obj);
                        }

            
            {
                a = _pcls8;
                super();
            }
                    });
                    return;
                }
            }

            public void b()
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "getAccountToken abort"
                });
                a.l();
                DialogUtils.a(a, m.bc_write_post_message_must_sign_in);
            }

            
            {
                a = ShareInPostActivity.this;
                super();
            }
        });
    }

    private void q()
    {
        Intent intent = new Intent();
        if (o != null)
        {
            if (o.circleCreatorId != null)
            {
                intent.putExtra("CreatorId", o.circleCreatorId);
            }
            if (o.id != null)
            {
                intent.putExtra("CircleId", o.id);
            }
            if (o.circleName != null)
            {
                intent.putExtra("CircleName", o.circleName);
            }
            if (o.iconUrl != null)
            {
                intent.putExtra("CircleIcon", o.iconUrl);
            }
            if (n != null)
            {
                intent.putExtra("ShareInPost", n.toString());
            }
        }
        setResult(48256, intent);
        j(this);
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_share_in_post);
        bundle = findViewById(com.cyberlink.beautycircle.j.bc_sharein_background);
        if (bundle != null)
        {
            bundle.setOnClickListener(e);
        }
        h = (ImageView)findViewById(com.cyberlink.beautycircle.j.bc_sharein_btn);
        if (h != null)
        {
            h.setOnClickListener(e);
        }
        k = (TextView)findViewById(com.cyberlink.beautycircle.j.bc_sharein_accept);
        k.setOnClickListener(g);
        bundle = findViewById(com.cyberlink.beautycircle.j.create_circle_btn);
        if (bundle != null)
        {
            bundle.setOnClickListener(f);
        }
        n = (Post)Model.a(com/cyberlink/beautycircle/model/Post, getIntent().getStringExtra("ShareInPost"));
        if (n == null)
        {
            com.perfectcorp.utility.e.e(new Object[] {
                "mPost == null"
            });
            DialogUtils.a(this, getResources().getString(m.bc_dialog_title_error), getResources().getString(m.bc_write_post_message_create_post_fail), new Runnable() {

                final ShareInPostActivity a;

                public void run()
                {
                    ShareInPostActivity.a(a);
                }

            
            {
                a = ShareInPostActivity.this;
                super();
            }
            });
        }
        m = findViewById(com.cyberlink.beautycircle.j.bc_sharein_alert_repost);
        o();
        i = (EditText)findViewById(com.cyberlink.beautycircle.j.post_title);
        i.setText(n.title);
        j = (UICImageView)findViewById(com.cyberlink.beautycircle.j.post_cover);
        j.setImageURI(n.b());
        l = (CirclePager)findViewById(com.cyberlink.beautycircle.j.circle_pager);
        l.setCreateCircleBtnPos(com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.CreateCircleBtnPos.a);
        l.setPickMode(true);
        l.setEventListener(q);
        l.a();
        t.a.a(p);
        com.perfectcorp.a.b.a(new g("internal"));
    }

    public void onDestroy()
    {
        com.perfectcorp.utility.e.c(new Object[0]);
        t.a.b(p);
        super.onDestroy();
    }

    protected void onPause()
    {
        com.perfectcorp.utility.e.c(new Object[0]);
        super.onPause();
    }

    protected void onResume()
    {
        com.perfectcorp.utility.e.c(new Object[0]);
        super.onResume();
    }

    protected void onStart()
    {
        com.perfectcorp.utility.e.c(new Object[0]);
        super.onStart();
    }
}
