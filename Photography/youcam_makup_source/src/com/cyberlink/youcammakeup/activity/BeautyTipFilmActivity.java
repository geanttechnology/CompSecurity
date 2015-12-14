// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.NetworkBaseActivity;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ap;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bb;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bc;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bd;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.pages.moreview.d;
import com.cyberlink.youcammakeup.pages.moreview.g;
import java.util.Collection;
import java.util.Iterator;

public class BeautyTipFilmActivity extends NetworkBaseActivity
{

    String a;
    private GridView b;
    private d c;
    private TextView d;
    private boolean e;
    private NetworkManager f;
    private long g;
    private String h;
    private android.view.View.OnClickListener i;
    private android.view.View.OnClickListener j;

    public BeautyTipFilmActivity()
    {
        a = com/cyberlink/youcammakeup/activity/BeautyTipFilmActivity.getName();
        e = true;
        i = new android.view.View.OnClickListener() {

            final BeautyTipFilmActivity a;

            public void onClick(View view)
            {
                a.finish();
            }

            
            {
                a = BeautyTipFilmActivity.this;
                super();
            }
        };
        j = new android.view.View.OnClickListener() {

            final BeautyTipFilmActivity a;

            public void onClick(View view)
            {
                af.a(com.cyberlink.youcammakeup.Globals.ActivityType.j);
                BeautyTipFilmActivity.a(a);
            }

            
            {
                a = BeautyTipFilmActivity.this;
                super();
            }
        };
    }

    static void a(BeautyTipFilmActivity beautytipfilmactivity)
    {
        beautytipfilmactivity.l();
    }

    static long b(BeautyTipFilmActivity beautytipfilmactivity)
    {
        return beautytipfilmactivity.g;
    }

    static TextView c(BeautyTipFilmActivity beautytipfilmactivity)
    {
        return beautytipfilmactivity.d;
    }

    private void k()
    {
        boolean flag1 = false;
        StatusManager.j().a("beautyTipFilmPage");
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.j, this);
        findViewById(0x7f0c0087).setOnClickListener(i);
        b = (GridView)findViewById(0x7f0c0089);
        d = (TextView)findViewById(0x7f0c0088);
        f = Globals.d().w();
        Bundle bundle;
        boolean flag;
        if (h != null && !h.equals(z.c("")))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bundle = getIntent().getExtras();
        if (bundle != null)
        {
            if (bundle.containsKey("categoryId"))
            {
                g = bundle.getLong("categoryId");
                StatusManager.j().a(bundle.getLong("categoryId"));
            }
            if (bundle.containsKey("categoryName") && !flag)
            {
                d.setText(bundle.getString("categoryName"));
                StatusManager.j().a(bundle.getString("categoryName"));
            }
            if (bundle.containsKey("lastModifiedChanged"))
            {
                if (bundle.getBoolean("lastModifiedChanged") || flag)
                {
                    flag1 = true;
                }
                e = flag1;
            }
        }
        if (flag)
        {
            m();
        }
        l();
    }

    private void l()
    {
        if (c != null)
        {
            c.a();
            c.b();
            c = null;
        }
        c = new d(b.getContext(), StatusManager.j().b(), e, j);
        b.setAdapter(c);
    }

    private void m()
    {
        Object obj = Globals.d().K();
        if (obj != null && ((Pair) (obj)).second != null)
        {
            if ((obj = ((ap)((Pair) (obj)).second).b()) != null)
            {
                f.a(new bc(f, 1, ((Collection) (obj)).size(), true, new bd() {

                    final BeautyTipFilmActivity a;

                    public void a(bb bb1)
                    {
                        bb1 = bb1.a().iterator();
                        do
                        {
                            com.cyberlink.youcammakeup.database.more.a.d d1;
                            Activity activity;
label0:
                            {
                                if (bb1.hasNext())
                                {
                                    d1 = (com.cyberlink.youcammakeup.database.more.a.d)bb1.next();
                                    if (Long.valueOf(d1.a()).longValue() != BeautyTipFilmActivity.b(a))
                                    {
                                        continue;
                                    }
                                    activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.j);
                                    if (activity != null)
                                    {
                                        break label0;
                                    }
                                }
                                return;
                            }
                            activity.runOnUiThread(new Runnable(this, d1) {

                                final com.cyberlink.youcammakeup.database.more.a.d a;
                                final _cls3 b;

                                public void run()
                                {
                                    BeautyTipFilmActivity.c(b.a).setText(a.f());
                                    StatusManager.j().a(a.f());
                                }

            
            {
                b = _pcls3;
                a = d1;
                super();
            }
                            });
                        } while (true);
                    }

                    public void a(bn bn1)
                    {
                        if (bn1 == null);
                    }

                    public volatile void a(Object obj1)
                    {
                        a((bb)obj1);
                    }

                    public void a(Void void1)
                    {
                    }

                    public void b(Object obj1)
                    {
                        a((bn)obj1);
                    }

                    public void c(Object obj1)
                    {
                        a((Void)obj1);
                    }

            
            {
                a = BeautyTipFilmActivity.this;
                super();
            }
                }));
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030004);
        if (bundle != null && bundle.containsKey("prevLanguage"))
        {
            h = bundle.getString("prevLanguage");
        }
        k();
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (c != null)
        {
            c.a();
            c.b();
            c = null;
        }
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.j, null);
        StatusManager.j().a(-1L);
    }

    protected void onPause()
    {
        Globals.d().c("beautyTipFilmActivity");
        StatusManager.j().C();
        super.onPause();
    }

    public void onResume()
    {
        Globals.d().c(null);
        super.onResume();
        for (int i1 = 0; i1 < b.getChildCount(); i1++)
        {
            g g1 = (g)b.getChildAt(i1);
            c.a(Long.valueOf(g1.getFilmId()), g1);
        }

        af.e(com.cyberlink.youcammakeup.Globals.ActivityType.j);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("prevLanguage", z.c(""));
    }
}
