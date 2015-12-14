// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.beautycircle.BaseFbActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.l;
import com.cyberlink.beautycircle.controller.adapter.ShareAdapter;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.controller.fragment.y;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CompletePost;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.ShareOutUtils;
import com.cyberlink.beautycircle.utility.ab;
import com.cyberlink.beautycircle.utility.ae;
import com.cyberlink.beautycircle.utility.ah;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.a.b;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import java.util.Locale;

public class ContestShareActivity extends BaseFbActivity
{

    private long e;
    private com.cyberlink.beautycircle.model.Contest.ContestInfo f;
    private Long g;
    private Uri o;
    private String p;
    private String q;

    public ContestShareActivity()
    {
        p = null;
        q = null;
    }

    static com.cyberlink.beautycircle.model.Contest.ContestInfo a(ContestShareActivity contestshareactivity)
    {
        return contestshareactivity.f;
    }

    private void a(Intent intent)
    {
        String s1 = intent.getStringExtra("eventInfo");
        if (s1 != null)
        {
            f = (com.cyberlink.beautycircle.model.Contest.ContestInfo)Model.a(com/cyberlink/beautycircle/model/Contest$ContestInfo, s1);
            if (f != null && f.id != null)
            {
                e = f.id.longValue();
            }
        }
        g = Long.valueOf(intent.getLongExtra("PostId", -1L));
        if (g.longValue() == -1L)
        {
            g = null;
        }
        o = (Uri)intent.getParcelableExtra("PhotoUri");
        if (o != null)
        {
            ((UICImageView)findViewById(j.post_img)).setImageURI(o);
        }
        if (AccountManager.c() != null)
        {
            q = "Login";
            return;
        } else
        {
            q = "Register";
            return;
        }
    }

    private void a(ViewGroup viewgroup, ShareAdapter shareadapter, com.cyberlink.beautycircle.utility.ShareOutUtils.ShareInfo shareinfo)
    {
        shareinfo.h = p;
        shareinfo.i = q;
        shareinfo.j = new ab() {

            final ContestShareActivity a;

            public void a()
            {
                a.l();
            }

            
            {
                a = ContestShareActivity.this;
                super();
            }
        };
        int i1 = shareadapter.getCount();
        for (int i = 0; i < i1; i++)
        {
            View view = shareadapter.a(i, viewgroup);
            view.setOnClickListener(new android.view.View.OnClickListener(shareadapter, i, shareinfo) {

                final ShareAdapter a;
                final int b;
                final com.cyberlink.beautycircle.utility.ShareOutUtils.ShareInfo c;
                final ContestShareActivity d;

                public void onClick(View view1)
                {
                    view1 = ((ResolveInfo)a.getItem(b)).activityInfo.packageName;
                    ShareOutUtils.a(d, c, view1);
                    com.perfectcorp.a.b.a(new l("share", Long.toString(com.cyberlink.beautycircle.controller.activity.ContestShareActivity.b(d)), view1));
                }

            
            {
                d = ContestShareActivity.this;
                a = shareadapter;
                b = i;
                c = shareinfo;
                super();
            }
            });
            viewgroup.addView(view);
        }

    }

    static void a(ContestShareActivity contestshareactivity, ViewGroup viewgroup, ShareAdapter shareadapter, com.cyberlink.beautycircle.utility.ShareOutUtils.ShareInfo shareinfo)
    {
        contestshareactivity.a(viewgroup, shareadapter, shareinfo);
    }

    static long b(ContestShareActivity contestshareactivity)
    {
        return contestshareactivity.e;
    }

    private void o()
    {
        ViewGroup viewgroup = (ViewGroup)findViewById(j.share_panel);
        ShareAdapter shareadapter = ShareAdapter.a(this, "*/*", com.cyberlink.beautycircle.controller.adapter.ShareAdapter.ShareListMode.e);
        NetworkPost.a(AccountManager.c(), g.longValue()).a(new com.perfectcorp.utility.m(viewgroup, shareadapter) {

            final ViewGroup a;
            final ShareAdapter b;
            final ContestShareActivity c;

            protected void a(int i)
            {
                super.a(i);
                Globals.b("Query post fail, share the event.");
                com.cyberlink.beautycircle.utility.ShareOutUtils.ShareInfo shareinfo = com.cyberlink.beautycircle.utility.ShareOutUtils.ShareInfo.a(ContestShareActivity.a(c));
                ContestShareActivity.a(c, a, b, shareinfo);
            }

            protected void a(CompletePost completepost)
            {
                if (completepost == null || completepost.mainPost == null)
                {
                    b(0x80000003);
                    return;
                } else
                {
                    c.n = completepost.mainPost;
                    completepost = com.cyberlink.beautycircle.utility.ShareOutUtils.ShareInfo.a(c.n);
                    completepost.e = "QUERY_CONTEST_POST_DEEPLINK";
                    ContestShareActivity.a(c, a, b, completepost);
                    return;
                }
            }

            protected void b(Object obj)
            {
                a((CompletePost)obj);
            }

            
            {
                c = ContestShareActivity.this;
                a = viewgroup;
                b = shareadapter;
                super();
            }
        });
    }

    public String d(String s1)
    {
        String s2;
        String s3;
label0:
        {
            s2 = null;
            if (e > 0L)
            {
                s2 = getString(m.bc_scheme);
                s3 = getString(m.bc_host_contest);
                if (s1 == null)
                {
                    break label0;
                }
                s2 = String.format(Locale.getDefault(), "%s://%s/%d?%s=%s", new Object[] {
                    s2, s3, Long.valueOf(e), "sourceType", s1
                });
            }
            return s2;
        }
        return String.format(Locale.getDefault(), "%s://%s/%d", new Object[] {
            s2, s3, Long.valueOf(e)
        });
    }

    protected boolean e()
    {
        com.perfectcorp.a.b.a(new l("back", Long.toString(e), null));
        return super.e();
    }

    protected void onActivityResult(int i, int i1, Intent intent)
    {
        super.onActivityResult(i, i1, intent);
        com.perfectcorp.utility.e.b(new Object[] {
            "requestCode:", Integer.toHexString(i), ", resultCode: ", Integer.toHexString(i1)
        });
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_contest_share);
        b("");
        b().a(0xc1000000, x.a, 0, y.i);
        a(getIntent());
        a(bundle, false);
        if (j == null)
        {
            j = new ah(this);
        }
        if (k == null)
        {
            k = new ae(this);
        }
        o();
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        a(intent);
    }

    public void onResume()
    {
        super.onResume();
        com.perfectcorp.a.b.a(new l("show", Long.toString(e), null));
    }

    public void onRightBtnClick(View view)
    {
        if (g == null)
        {
            com.perfectcorp.utility.e.e(new Object[] {
                "No PostId."
            });
            return;
        } else
        {
            c.a(this, g.longValue(), true, 0, null, null);
            finish();
            return;
        }
    }

    public void s()
    {
        super.s();
        DialogUtils.a(this, m.bc_sharein_success);
    }
}
