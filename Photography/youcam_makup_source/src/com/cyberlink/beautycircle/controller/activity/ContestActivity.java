// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.controller.a.bb;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkContest;
import com.cyberlink.beautycircle.model.network.NetworkEvent;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.ShareOutUtils;
import com.cyberlink.beautycircle.utility.ab;
import com.cyberlink.beautycircle.utility.ae;
import com.cyberlink.beautycircle.utility.ah;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.c;
import com.perfectcorp.utility.d;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            WebViewerActivity, DeepLinkActivity, y

public class ContestActivity extends WebViewerActivity
{

    private boolean A;
    private boolean B;
    private String C;
    private String D;
    private long y;
    private com.cyberlink.beautycircle.model.Contest.ContestInfo z;

    public ContestActivity()
    {
        A = false;
        B = false;
        C = null;
        D = null;
    }

    static com.cyberlink.beautycircle.model.Contest.ContestInfo a(ContestActivity contestactivity)
    {
        return contestactivity.z;
    }

    static com.cyberlink.beautycircle.model.Contest.ContestInfo a(ContestActivity contestactivity, com.cyberlink.beautycircle.model.Contest.ContestInfo contestinfo)
    {
        contestactivity.z = contestinfo;
        return contestinfo;
    }

    private void a(Intent intent)
    {
        y = intent.getLongExtra("eventId", -1L);
        C = intent.getStringExtra("sourceType");
        A = intent.getBooleanExtra("IsFromDeepLink", false);
        if (C == null)
        {
            C = "banner";
        }
        if (AccountManager.c() != null)
        {
            D = "Login";
        } else
        {
            D = "Register";
        }
        com.perfectcorp.a.b.a(new bb(C, "pageView", D, "", null, y));
        if (false)
        {
            getString(m.bc_host_contest);
            throw new NullPointerException();
        } else
        {
            Globals.b((new StringBuilder()).append("normal:").append(y).toString());
            NetworkContest.a(Long.valueOf(y)).a(new com.perfectcorp.utility.m() {

                final ContestActivity a;

                protected void a(com.cyberlink.beautycircle.model.Contest.ContestInfoResult contestinforesult)
                {
                    if (contestinforesult != null && contestinforesult.result != null && !contestinforesult.result.status.equals("Error") && !contestinforesult.result.status.equals("Repeat"))
                    {
                        ContestActivity.a(a, contestinforesult.result);
                        ContestActivity.a(a).id = Long.valueOf(com.cyberlink.beautycircle.controller.activity.ContestActivity.b(a));
                        a.s = contestinforesult.result.joinContestURL;
                        if (a.f != null && a.s != null)
                        {
                            contestinforesult = AccountManager.b();
                            contestinforesult = NetworkEvent.a(a.s, contestinforesult);
                            a.f.loadUrl(contestinforesult);
                            DeepLinkActivity.f(contestinforesult);
                        }
                        if (com.cyberlink.beautycircle.controller.activity.ContestActivity.c(a))
                        {
                            a.b().b(x.k);
                            a.b().a(0xc4100000, x.a, x.j, 0);
                            return;
                        }
                    }
                }

                protected void b(Object obj)
                {
                    a((com.cyberlink.beautycircle.model.Contest.ContestInfoResult)obj);
                }

            
            {
                a = ContestActivity.this;
                super();
            }
            });
            return;
        }
    }

    static boolean a(ContestActivity contestactivity, boolean flag)
    {
        contestactivity.B = flag;
        return flag;
    }

    static long b(ContestActivity contestactivity)
    {
        return contestactivity.y;
    }

    static boolean c(ContestActivity contestactivity)
    {
        return contestactivity.A;
    }

    protected boolean a(WebView webview, String s)
    {
        boolean flag1 = false;
        if (!B && s != null) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        d d1;
        webview = Uri.parse(s);
        s = webview.getQueryParameter("action");
        d1 = com.perfectcorp.utility.c.a(webview);
        flag = flag1;
        if (d1 == null) goto _L4; else goto _L3
_L3:
        flag = flag1;
        if (d1.a == null) goto _L4; else goto _L5
_L5:
        if (d1.a.equals(getString(m.bc_host_signup)))
        {
            aq.c = "contest";
            B = true;
            com.cyberlink.beautycircle.c.a(this, 2, 0, 0);
            return true;
        }
        flag = flag1;
        if (!d1.a.equals(getString(m.bc_host_contest))) goto _L4; else goto _L6
_L6:
        if (!"vote".equals(s)) goto _L8; else goto _L7
_L7:
        com.perfectcorp.a.b.a(new bb(C, "vote", D, "", null, y));
_L10:
        return true;
_L8:
        if ("submit".equals(s))
        {
            com.perfectcorp.a.b.a(new bb(C, "submit", D, "", null, y));
        } else
        if ("share".equals(s))
        {
            try
            {
                long l = Long.parseLong(webview.getQueryParameter("postId"));
                s = Uri.parse(webview.getQueryParameter("imgurl"));
                com.cyberlink.beautycircle.c.a(this, z.toString(), Long.valueOf(l), s);
                finish();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Globals.b((new StringBuilder()).append("Parse fail: ").append(webview).toString());
                com.perfectcorp.utility.e.e(new Object[] {
                    "Parse fail: ", webview
                });
                com.perfectcorp.utility.e.e(new Object[] {
                    s
                });
            }
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    public String d(String s)
    {
        String s1;
        String s2;
label0:
        {
            s1 = null;
            if (y > 0L)
            {
                s1 = getString(m.bc_scheme);
                s2 = getString(m.bc_host_contest);
                if (s == null)
                {
                    break label0;
                }
                s1 = String.format(Locale.getDefault(), "%s://%s/%d?%s=%s", new Object[] {
                    s1, s2, Long.valueOf(y), "sourceType", s
                });
            }
            return s1;
        }
        return String.format(Locale.getDefault(), "%s://%s/%d", new Object[] {
            s1, s2, Long.valueOf(y)
        });
    }

    protected boolean e()
    {
        com.perfectcorp.a.b.a(new bb(C, "back", D, "", null, y));
        return super.e();
    }

    protected void onActivityResult(int i, int k, Intent intent)
    {
        super.onActivityResult(i, k, intent);
        com.perfectcorp.utility.e.b(new Object[] {
            "requestCode:", Integer.toHexString(i), ", resultCode: ", Integer.toHexString(k)
        });
        if (i == 48144 && k == 48256 && f != null && z != null)
        {
            intent = AccountManager.b();
            intent = NetworkEvent.a(z.joinContestURL, intent);
            if (intent != null)
            {
                intent = (new StringBuilder()).append(intent).append("#join").toString();
                v = true;
                f.loadUrl(intent);
                DeepLinkActivity.f(intent);
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        y y1 = new y(this);
        y1.b = false;
        y1.f = false;
        a(y1);
        super.onCreate(bundle);
        b("");
        b().a(0xe4000000, x.a, x.j, 0);
        t.a(false);
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
    }

    public void onNewIntent(Intent intent)
    {
        com.perfectcorp.utility.e.c(new Object[] {
            intent.getData()
        });
        super.onNewIntent(intent);
        setIntent(intent);
        a(intent);
    }

    public void onResume()
    {
        super.onResume();
        B = false;
        com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.x(Long.toString(y), C, "CONTEST"));
    }

    public void onRightBtnClick(View view)
    {
        if (z == null)
        {
            com.perfectcorp.utility.e.e(new Object[] {
                "No contest info."
            });
            return;
        } else
        {
            int i = m.bc_freesample_share_title_not_join;
            view = com.cyberlink.beautycircle.utility.ShareOutUtils.ShareInfo.a(z);
            view.h = C;
            view.i = D;
            view.j = new ab() {

                final ContestActivity a;

                public void a()
                {
                    a.l();
                }

            
            {
                a = ContestActivity.this;
                super();
            }
            };
            ShareOutUtils.a(this, view, com.cyberlink.beautycircle.controller.adapter.ShareAdapter.ShareListMode.c, i, new android.content.DialogInterface.OnDismissListener() {

                final ContestActivity a;

                public void onDismiss(DialogInterface dialoginterface)
                {
                    ContestActivity.a(a, false);
                }

            
            {
                a = ContestActivity.this;
                super();
            }
            });
            return;
        }
    }

    public void onRightSubBtnClick(View view)
    {
        com.cyberlink.beautycircle.c.a(this, "");
        finish();
    }
}
