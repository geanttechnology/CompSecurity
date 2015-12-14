// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.cyberlink.beautycircle.controller.a.am;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.controller.fragment.e;
import com.cyberlink.beautycircle.model.BCTileImage;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.cyberlink.beautycircle.view.widgetpool.common.BCArcMenu;
import com.cyberlink.beautycircle.view.widgetpool.common.BCToastView;
import com.cyberlink.beautycircle.view.widgetpool.common.ObservableRelativeLayout;
import com.cyberlink.beautycircle.view.widgetpool.common.b;
import com.cyberlink.beautycircle.view.widgetpool.common.l;
import com.perfectcorp.model.Model;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle:
//            BaseFbActivity, m, j, c, 
//            Globals

public abstract class BaseArcMenuActivity extends BaseFbActivity
{

    public e e;
    public String f;
    public boolean g;
    private BCToastView o;
    private BCArcMenu p;
    private MotionEvent q;
    private l r;
    private b s;

    public BaseArcMenuActivity()
    {
        e = null;
        o = null;
        p = null;
        q = null;
        f = null;
        g = false;
        r = new l() {

            final BaseArcMenuActivity a;

            public boolean a(MotionEvent motionevent)
            {
                BaseArcMenuActivity.a(a, motionevent);
                return a.a(motionevent);
            }

            
            {
                a = BaseArcMenuActivity.this;
                super();
            }
        };
        s = new b() {

            final BaseArcMenuActivity a;

            public void a()
            {
                a.q();
            }

            public void b()
            {
                if (a.f != null)
                {
                    com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.e(a.f, 0L, "circleIt", a.g, 0L));
                }
                com.perfectcorp.a.b.a(new am(am.a, "circleIt".toString(), a.n.postId, Long.valueOf(a.n.creator.userId), 0L));
                com.cyberlink.beautycircle.BaseArcMenuActivity.b(a);
            }

            public void c()
            {
                if (a.f != null)
                {
                    com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.e(a.f, 0L, "like", a.g, 0L));
                }
                com.perfectcorp.a.b.a(new am(am.a, "like".toString(), a.n.postId, Long.valueOf(a.n.creator.userId), 0L));
                a.p();
            }

            public void d()
            {
                if (a.f != null)
                {
                    com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.e(a.f, 0L, "share", a.g, 0L));
                }
                com.perfectcorp.a.b.a(new am(am.a, "share".toString(), a.n.postId, Long.valueOf(a.n.creator.userId), 0L));
                BaseArcMenuActivity.c(a);
            }

            public void e()
            {
                BaseArcMenuActivity.d(a);
            }

            
            {
                a = BaseArcMenuActivity.this;
                super();
            }
        };
    }

    static MotionEvent a(BaseArcMenuActivity basearcmenuactivity, MotionEvent motionevent)
    {
        basearcmenuactivity.q = motionevent;
        return motionevent;
    }

    static BCToastView a(BaseArcMenuActivity basearcmenuactivity)
    {
        return basearcmenuactivity.o;
    }

    static void b(BaseArcMenuActivity basearcmenuactivity)
    {
        basearcmenuactivity.u();
    }

    static void c(BaseArcMenuActivity basearcmenuactivity)
    {
        basearcmenuactivity.v();
    }

    static void d(BaseArcMenuActivity basearcmenuactivity)
    {
        basearcmenuactivity.w();
    }

    private void u()
    {
        if (n == null)
        {
            return;
        } else
        {
            AccountManager.a(this, new com.cyberlink.beautycircle.utility.b() {

                final BaseArcMenuActivity a;

                public void a()
                {
                    com.cyberlink.beautycircle.Globals.b("Get AccountToken Fail");
                    a.n = null;
                }

                public void a(String s1)
                {
                    com.cyberlink.beautycircle.c.a(a, a.n);
                    a.n = null;
                }

                public void b()
                {
                    com.cyberlink.beautycircle.Globals.b("Get AccountToken Cancel");
                    a.n = null;
                }

            
            {
                a = BaseArcMenuActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void v()
    {
        if (n == null)
        {
            return;
        } else
        {
            a(com.cyberlink.beautycircle.controller.adapter.ShareAdapter.ShareListMode.c);
            return;
        }
    }

    private void w()
    {
        if (n == null)
        {
            return;
        } else
        {
            AccountManager.a(this, new com.cyberlink.beautycircle.utility.b() {

                final BaseArcMenuActivity a;

                public void a()
                {
                    com.cyberlink.beautycircle.Globals.b("Get AccountToken Fail");
                }

                public void a(String s1)
                {
                    if (s1 != null)
                    {
                        com.cyberlink.beautycircle.c.a(a, -1L, null, null, false, null, Long.valueOf(a.n.postId.longValue()), null);
                    }
                }

                public void b()
                {
                    com.cyberlink.beautycircle.Globals.b("Get AccountToken Cancel");
                }

            
            {
                a = BaseArcMenuActivity.this;
                super();
            }
            });
            return;
        }
    }

    public void a(Intent intent)
    {
        if (intent != null && intent.hasExtra("CreatorId") && intent.hasExtra("CircleId") && intent.hasExtra("CircleName"))
        {
            long l = intent.getLongExtra("CreatorId", 0L);
            long l1 = intent.getLongExtra("CircleId", 0L);
            String s1 = intent.getStringExtra("CircleName");
            intent = (Uri)intent.getParcelableExtra("CircleIcon");
            if (o != null)
            {
                o.a(intent, s1);
                o.setMainDescText(String.format(Locale.getDefault(), getResources().getString(m.bc_toast_circled_to), new Object[] {
                    s1
                }));
                o.setClickListener(new android.view.View.OnClickListener(Long.valueOf(l), Long.valueOf(l1)) {

                    final Long a;
                    final Long b;
                    final BaseArcMenuActivity c;

                    public void onClick(View view)
                    {
                        BaseArcMenuActivity.a(c).b(new Runnable(this) {

                            final _cls1 a;

                            public void run()
                            {
                                com.cyberlink.beautycircle.c.a(a.c, a.a, a.b);
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                    }

            
            {
                c = BaseArcMenuActivity.this;
                a = long1;
                b = long2;
                super();
            }
                });
                o.a(3000L);
            }
        }
    }

    public void a(Post post)
    {
        boolean flag = true;
        if (post != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (p == null || q == null) goto _L1; else goto _L3
_L3:
        Object obj;
        n = post;
        q.setAction(1);
        dispatchTouchEvent(q);
        obj = p;
        long l;
        if (post.isLiked.booleanValue())
        {
            flag = false;
        }
        ((BCArcMenu) (obj)).setIsLike(flag);
        obj = AccountManager.c();
        if (post.creator == null) goto _L5; else goto _L4
_L4:
        l = post.creator.userId;
_L6:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        if (!((Long) (obj)).equals(Long.valueOf(l)) || "contest".equals(post.postSource))
        {
            break MISSING_BLOCK_LABEL_162;
        }
        p.a(416);
_L7:
        q.setAction(0);
        dispatchTouchEvent(q);
        return;
_L5:
        l = -1L;
          goto _L6
        try
        {
            p.a(224);
        }
        // Misplaced declaration of an exception variable
        catch (Post post)
        {
            post.printStackTrace();
            q();
            return;
        }
          goto _L7
    }

    public void a(ObservableRelativeLayout observablerelativelayout)
    {
        if (observablerelativelayout != null)
        {
            observablerelativelayout.setOnInterceptTouchEventListener(r);
        }
    }

    public boolean a(MotionEvent motionevent)
    {
        return false;
    }

    public void b(Bundle bundle)
    {
        ObservableRelativeLayout observablerelativelayout = (ObservableRelativeLayout)findViewById(j.main_observable_root_layout);
        a(observablerelativelayout);
        a(bundle, false);
        o();
        initArcMenu(observablerelativelayout);
    }

    public void initArcMenu(View view)
    {
        p = (BCArcMenu)view.findViewById(j.bc_arc_menu);
        if (p != null)
        {
            p.setCallback(s);
        }
    }

    public void o()
    {
        o = (BCToastView)findViewById(j.bc_toast_view);
        if (o != null)
        {
            o.setAnimataionType(com.cyberlink.beautycircle.view.widgetpool.common.BCToastView.AnimationType.b);
        }
    }

    protected void onActivityResult(int i, int k, Intent intent)
    {
        super.onActivityResult(i, k, intent);
        i;
        JVM INSTR tableswitch 48157 48157: default 28
    //                   48157 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (k == 48256)
        {
            a(intent);
            if (intent != null)
            {
                BCTileImage.a((Post)Model.a(com/cyberlink/beautycircle/model/Post, intent.getStringExtra("ShareInPost")));
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void p()
    {
        aq.c = "like";
        if (n == null)
        {
            return;
        } else
        {
            AccountManager.a(this, new com.cyberlink.beautycircle.utility.b() {

                final BaseArcMenuActivity a;

                public void a()
                {
                    com.cyberlink.beautycircle.Globals.b("Get AccountToken Fail");
                    a.n = null;
                }

                public void a(String s1)
                {
                    if (a.n.isLiked.booleanValue())
                    {
                        NetworkPost.b(s1, "Post", a.n.postId.longValue());
                        a.n.isLiked = Boolean.valueOf(false);
                        s1 = a.n;
                        s1.likeCount = Long.valueOf(((Post) (s1)).likeCount.longValue() - 1L);
                    } else
                    {
                        NetworkPost.a(s1, "Post", a.n.postId.longValue());
                        BCTileImage.a(a.n);
                        a.n.isLiked = Boolean.valueOf(true);
                        s1 = a.n;
                        s1.likeCount = Long.valueOf(((Post) (s1)).likeCount.longValue() + 1L);
                    }
                    t.d.a();
                    a.n = null;
                }

                public void b()
                {
                    com.cyberlink.beautycircle.Globals.b("Get AccountToken Cancel");
                    a.n = null;
                }

            
            {
                a = BaseArcMenuActivity.this;
                super();
            }
            });
            return;
        }
    }

    public void q()
    {
        e e1 = r();
        if (e1 != null)
        {
            e1.a();
        }
    }

    public e r()
    {
        return e;
    }
}
