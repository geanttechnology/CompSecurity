// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.controller.activity.HotTopicActivity;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.BCTileImage;
import com.cyberlink.beautycircle.model.CircleType;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.model.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            a, m, n

public class g extends a
{

    public boolean a;
    public long f;
    private String k;
    private com.cyberlink.beautycircle.model.Post.PostCircle l;
    private Long m;

    public g(Activity activity, ViewGroup viewgroup, int i, s s, n n)
    {
        super(activity, viewgroup, i, s, n);
        k = "Date";
        l = null;
        m = null;
        a = false;
        f = 0L;
    }

    static Long a(g g1, Long long1)
    {
        g1.m = long1;
        return long1;
    }

    static void a(g g1)
    {
        g1.m.c();
    }

    static void b(g g1)
    {
        g1.m.c();
    }

    protected d a(int i, int i1)
    {
        if (l == null) goto _L2; else goto _L1
_L1:
        Object obj;
        m = l.circleTypeId;
        obj = l.defaultType;
_L4:
        f = i + i1;
        Long long1 = AccountManager.c();
        obj = (d)Post.a(null, m, null, k, long1, ((String) (obj)), Integer.valueOf(i), Integer.valueOf(i1)).a(new j() {

            final g a;

            public d a(d d1)
            {
                if (a.h() && d1 != null && d1.b != null && d1.b.size() > 0)
                {
                    BCTileImage.a(d1.b);
                }
                return d1;
            }

            public volatile Object a(Object obj1)
            {
                return a((d)obj1);
            }

            public void a(int j1)
            {
                super.a(j1);
                if (a.c != null && (a.c instanceof MainActivity))
                {
                    ((BaseActivity)a.c).a(a.c.getString(m.bc_server_connect_fail), 3000);
                }
            }

            
            {
                a = g.this;
                super();
            }
        }).d();
        return ((d) (obj));
        obj;
        ((InterruptedException) (obj)).printStackTrace();
_L3:
        return null;
        obj;
        ((ExecutionException) (obj)).printStackTrace();
        continue; /* Loop/switch isn't completed */
        obj;
        ((CancellationException) (obj)).printStackTrace();
        if (true) goto _L3; else goto _L2
_L2:
        obj = null;
          goto _L4
    }

    public void a(Long long1)
    {
        m = long1;
    }

    public void c()
    {
        if ((m == null || m.longValue() == -1L) && (c instanceof HotTopicActivity))
        {
            CircleType.a(c.getIntent().getStringExtra("CategoryType")).a(new com.perfectcorp.utility.m() {

                final g a;

                protected void a(int i)
                {
                    super.a(i);
                    g.b(a);
                }

                protected void a(CircleType circletype)
                {
                    if (circletype != null)
                    {
                        if (circletype.circleTypeName != null)
                        {
                            ((HotTopicActivity)a.c).b().c(circletype.circleTypeName);
                        }
                        if (circletype.id != null)
                        {
                            g.a(a, circletype.id);
                        }
                    }
                    g.a(a);
                }

                protected void b(Object obj)
                {
                    a((CircleType)obj);
                }

            
            {
                a = g.this;
                super();
            }
            });
            return;
        } else
        {
            super.c();
            return;
        }
    }
}
