// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.controller.a.o;
import com.cyberlink.beautycircle.controller.a.q;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkEvent;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.ShareOutUtils;
import com.cyberlink.beautycircle.utility.ab;
import com.cyberlink.beautycircle.utility.r;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.c;
import com.perfectcorp.utility.d;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            WebViewerActivity, DeepLinkActivity

public class FreeSampleActivity extends WebViewerActivity
{

    private String A;
    private com.cyberlink.beautycircle.model.Event.BrandEventInfo B;
    private UserInfo C;
    private boolean D;
    private boolean E;
    private boolean F;
    private long G;
    private long y;
    private boolean z;

    public FreeSampleActivity()
    {
        z = false;
        E = false;
        F = false;
        G = 0L;
    }

    static com.cyberlink.beautycircle.model.Event.BrandEventInfo a(FreeSampleActivity freesampleactivity)
    {
        return freesampleactivity.B;
    }

    static com.cyberlink.beautycircle.model.Event.BrandEventInfo a(FreeSampleActivity freesampleactivity, com.cyberlink.beautycircle.model.Event.BrandEventInfo brandeventinfo)
    {
        freesampleactivity.B = brandeventinfo;
        return brandeventinfo;
    }

    static UserInfo a(FreeSampleActivity freesampleactivity, UserInfo userinfo)
    {
        freesampleactivity.C = userinfo;
        return userinfo;
    }

    private void a(Intent intent)
    {
        EventAction eventaction = EventAction.a;
        Uri uri = intent.getData();
        String s1;
        Long long1;
        if (uri != null)
        {
            intent = com.perfectcorp.utility.c.a(uri);
            com.perfectcorp.utility.e.b(new Object[] {
                "host=", ((d) (intent)).a, ", id=", ((d) (intent)).b
            });
            s1 = ((d) (intent)).a;
            class _cls2
            {

                static final int a[];

                static 
                {
                    a = new int[EventAction.values().length];
                    try
                    {
                        a[EventAction.a.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        a[com.cyberlink.beautycircle.controller.activity.EventAction.b.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        a[com.cyberlink.beautycircle.controller.activity.EventAction.c.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        a[com.cyberlink.beautycircle.controller.activity.EventAction.e.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[com.cyberlink.beautycircle.controller.activity.EventAction.d.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            long l;
            if (((d) (intent)).b != null)
            {
                l = ((d) (intent)).b.longValue();
            } else
            {
                l = -1L;
            }
            y = l;
            A = uri.getQueryParameter("sourceType");
            z = true;
        } else
        {
            y = intent.getLongExtra("eventId", -1L);
            eventaction = EventAction.a(intent.getStringExtra("eventAction"));
            A = intent.getStringExtra("sourceType");
            s1 = null;
        }
        long1 = AccountManager.c();
        intent = eventaction;
        if (eventaction == EventAction.a)
        {
            if (s1 == null)
            {
                intent = EventAction.a;
            } else
            if (s1.equals(getString(m.bc_host_free_sample)) || s1.equals(getString(m.bc_host_event)))
            {
                intent = EventAction.a(uri.getQueryParameter("action"));
            } else
            if (s1.equals(getString(m.bc_host_free_sample_apply)))
            {
                intent = com.cyberlink.beautycircle.controller.activity.EventAction.b;
            } else
            if (s1.equals(getString(m.bc_host_free_sample_listuser)))
            {
                intent = com.cyberlink.beautycircle.controller.activity.EventAction.c;
            } else
            {
                intent = eventaction;
                if (s1.equals(getString(m.bc_host_free_sample_message)))
                {
                    intent = com.cyberlink.beautycircle.controller.activity.EventAction.e;
                }
            }
        }
        switch (_cls2.a[intent.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            Globals.b((new StringBuilder()).append("normal:").append(y).toString());
            if (y == -1L)
            {
                com.cyberlink.beautycircle.c.a(this, com.cyberlink.beautycircle.controller.fragment.PageFreeSampleListFragment.EventListType.a, true, null);
                finish();
                return;
            } else
            {
                NetworkEvent.a(y, long1).a(new com.perfectcorp.utility.m(long1) {

                    final Long a;
                    final FreeSampleActivity b;

                    protected void a(com.cyberlink.beautycircle.model.network.NetworkEvent.BrandEventInfoResult brandeventinforesult)
                    {
                        if (brandeventinforesult != null && brandeventinforesult.result != null)
                        {
                            FreeSampleActivity.a(b, brandeventinforesult.result);
                            if (FreeSampleActivity.a(b) != null)
                            {
                                com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.x(FreeSampleActivity.a(b).id.toString(), com.cyberlink.beautycircle.controller.activity.FreeSampleActivity.b(b), FreeSampleActivity.a(b).serviceType));
                            }
                            if ("CONSULTATION".equals(FreeSampleActivity.a(b).serviceType) && ("Selected".equals(FreeSampleActivity.a(b).userStatus) || "Redeemed".equals(FreeSampleActivity.a(b).userStatus)))
                            {
                                com.cyberlink.beautycircle.c.a(b, Long.valueOf(com.cyberlink.beautycircle.controller.activity.FreeSampleActivity.c(b)));
                                b.finish();
                            }
                            b.s = NetworkEvent.a(brandeventinforesult.result.eventLink, com.cyberlink.beautycircle.controller.activity.FreeSampleActivity.c(b), a);
                            if (b.f != null && b.s != null)
                            {
                                b.f.loadUrl(b.s);
                                DeepLinkActivity.f(b.s);
                            }
                            if (com.cyberlink.beautycircle.controller.activity.FreeSampleActivity.d(b) && "FREE_SAMPLE".equals(FreeSampleActivity.a(b).serviceType))
                            {
                                b.b().b(x.l);
                                b.b().a(0xc4100000, x.a, x.j, 0);
                                return;
                            }
                            if (FreeSampleActivity.a(b).organizerLogo != null)
                            {
                                b.b().a(FreeSampleActivity.a(b).organizerLogo);
                                return;
                            }
                            if (FreeSampleActivity.a(b).organizerName != null)
                            {
                                b.b().c(FreeSampleActivity.a(b).organizerName);
                                return;
                            }
                        }
                    }

                    protected void b(Object obj)
                    {
                        a((com.cyberlink.beautycircle.model.network.NetworkEvent.BrandEventInfoResult)obj);
                    }

            
            {
                b = FreeSampleActivity.this;
                a = long1;
                super();
            }
                });
                return;
            }

        case 2: // '\002'
            Globals.b((new StringBuilder()).append("apply:").append(y).toString());
            if (G > 0L)
            {
                long l1 = System.currentTimeMillis();
                com.perfectcorp.a.b.a(new o(A, Long.valueOf(y), "join_event", l1 - G));
            }
            if (B != null && B.id.longValue() == y)
            {
                g(B.applyType);
                return;
            } else
            {
                k();
                NetworkEvent.a(y, long1).a(new com.perfectcorp.utility.m() {

                    final FreeSampleActivity a;

                    protected void a(com.cyberlink.beautycircle.model.network.NetworkEvent.BrandEventInfoResult brandeventinforesult)
                    {
                        a.l();
                        if (brandeventinforesult == null || brandeventinforesult.result == null)
                        {
                            FreeSampleActivity.a(a, false);
                            return;
                        } else
                        {
                            FreeSampleActivity.a(a, brandeventinforesult.result);
                            FreeSampleActivity.a(a, FreeSampleActivity.a(a).applyType);
                            a.finish();
                            return;
                        }
                    }

                    protected void b(Object obj)
                    {
                        a((com.cyberlink.beautycircle.model.network.NetworkEvent.BrandEventInfoResult)obj);
                    }

            
            {
                a = FreeSampleActivity.this;
                super();
            }
                });
                return;
            }

        case 3: // '\003'
            com.cyberlink.beautycircle.c.a(this, com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.e, Long.valueOf(0L), Long.valueOf(y));
            finish();
            return;

        case 4: // '\004'
        case 5: // '\005'
            com.cyberlink.beautycircle.c.a(this, Long.valueOf(y));
            finish();
            return;
        }
    }

    static void a(FreeSampleActivity freesampleactivity, String s1)
    {
        freesampleactivity.g(s1);
    }

    static boolean a(FreeSampleActivity freesampleactivity, boolean flag)
    {
        freesampleactivity.E = flag;
        return flag;
    }

    static String b(FreeSampleActivity freesampleactivity)
    {
        return freesampleactivity.A;
    }

    static boolean b(FreeSampleActivity freesampleactivity, boolean flag)
    {
        freesampleactivity.F = flag;
        return flag;
    }

    static long c(FreeSampleActivity freesampleactivity)
    {
        return freesampleactivity.y;
    }

    static boolean d(FreeSampleActivity freesampleactivity)
    {
        return freesampleactivity.z;
    }

    static UserInfo e(FreeSampleActivity freesampleactivity)
    {
        return freesampleactivity.C;
    }

    private void g(String s1)
    {
        if (s1 != null && B != null)
        {
            if ("CONSULTATION".equals(B.serviceType))
            {
                if (AccountManager.b() == null)
                {
                    aq.c = "consultation";
                    com.cyberlink.beautycircle.c.a(this, 3, 0, 8, B.title);
                    return;
                } else
                {
                    com.cyberlink.beautycircle.c.a(this, B);
                    return;
                }
            }
            if ("FillInfo".equals(s1))
            {
                aq.c = "free_gift";
                if (AccountManager.b() == null)
                {
                    com.cyberlink.beautycircle.c.a(this, 2, 0, 5);
                    return;
                }
                if (r.a())
                {
                    com.cyberlink.beautycircle.c.a(this, B);
                    return;
                } else
                {
                    DialogUtils.a(this, null, getResources().getString(m.bc_freesample_fill_data_dialog), null, null, getResources().getString(m.bc_freesample_fill_data_button), new Runnable() {

                        final FreeSampleActivity a;

                        public void run()
                        {
                            com.cyberlink.beautycircle.c.b(a, 5);
                        }

            
            {
                a = FreeSampleActivity.this;
                super();
            }
                    }, true, new android.content.DialogInterface.OnDismissListener() {

                        final FreeSampleActivity a;

                        public void onDismiss(DialogInterface dialoginterface)
                        {
                            FreeSampleActivity.a(a, false);
                        }

            
            {
                a = FreeSampleActivity.this;
                super();
            }
                    });
                    return;
                }
            }
            if ("ShareLink".equals(s1))
            {
                aq.c = "free_gift";
                if (AccountManager.b() == null)
                {
                    com.cyberlink.beautycircle.c.a(this, 2, 0, 0);
                    return;
                } else
                {
                    a(true);
                    return;
                }
            }
            if ("FollowBrand".equals(s1))
            {
                aq.c = "free_gift";
                if (AccountManager.b() == null)
                {
                    com.cyberlink.beautycircle.c.a(this, 2, 0, 0);
                    return;
                } else
                {
                    NetworkUser.a(B.brandId.longValue(), AccountManager.c(), AccountManager.b()).a(new com.perfectcorp.utility.m() {

                        final FreeSampleActivity a;

                        public void a(int i)
                        {
                            Globals.b((new StringBuilder()).append("Fetching UserInfo error: ").append(i).toString());
                        }

                        public void a(UserInfo userinfo)
                        {
                            if (userinfo != null)
                            {
                                FreeSampleActivity.a(a, userinfo);
                                if (userinfo.isFollowed.booleanValue())
                                {
                                    com.cyberlink.beautycircle.c.a(a, FreeSampleActivity.a(a));
                                    return;
                                } else
                                {
                                    a.o();
                                    return;
                                }
                            } else
                            {
                                a(0x80000003);
                                return;
                            }
                        }

                        public void b(Object obj)
                        {
                            a((UserInfo)obj);
                        }

            
            {
                a = FreeSampleActivity.this;
                super();
            }
                    });
                    return;
                }
            }
        }
    }

    private void p()
    {
        if (D)
        {
            com.cyberlink.beautycircle.c.a(this, B);
        }
    }

    public void a(boolean flag)
    {
        if (B == null)
        {
            com.perfectcorp.utility.e.e(new Object[] {
                "mEventInfo null"
            });
            return;
        }
        D = flag;
        com.cyberlink.beautycircle.utility.ShareOutUtils.ShareInfo shareinfo;
        int i;
        if (flag)
        {
            i = m.bc_freesample_share_title;
        } else
        {
            i = m.bc_freesample_share_title_not_join;
        }
        shareinfo = com.cyberlink.beautycircle.utility.ShareOutUtils.ShareInfo.a(B);
        shareinfo.j = new ab() {

            final FreeSampleActivity a;

            public void a()
            {
                a.l();
                com.cyberlink.beautycircle.controller.activity.FreeSampleActivity.b(a, true);
            }

            
            {
                a = FreeSampleActivity.this;
                super();
            }
        };
        ShareOutUtils.a(this, shareinfo, com.cyberlink.beautycircle.controller.adapter.ShareAdapter.ShareListMode.d, i, new android.content.DialogInterface.OnDismissListener() {

            final FreeSampleActivity a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                FreeSampleActivity.a(a, false);
            }

            
            {
                a = FreeSampleActivity.this;
                super();
            }
        });
    }

    protected boolean a(WebView webview, String s1)
    {
        if (E || s1 == null)
        {
            return true;
        }
        webview = Uri.parse(s1);
        s1 = com.perfectcorp.utility.c.a(webview);
        if (s1 != null && ((d) (s1)).a != null && (((d) (s1)).a.equals(getString(m.bc_host_free_sample_apply)) || ((d) (s1)).a.equals(getString(m.bc_host_free_sample_listuser)) || ((d) (s1)).a.equals(getString(m.bc_host_free_sample_message)) || ((d) (s1)).a.equals(getString(m.bc_host_event))))
        {
            E = true;
            if (((d) (s1)).a.equals(getString(m.bc_host_free_sample_apply)) || ((d) (s1)).a.equals(getString(m.bc_host_event)))
            {
                s1 = new Intent();
                s1.setData(webview);
                a(((Intent) (s1)));
                return true;
            }
        }
        return false;
    }

    public String d(String s1)
    {
        String s2;
        String s3;
        String s4;
label0:
        {
            s2 = null;
            if (y > 0L)
            {
                s3 = getString(m.bc_scheme);
                s4 = getString(m.bc_host_event);
                s2 = null;
                Object obj = null;
                if (B != null)
                {
                    s2 = obj;
                    if ("FREE_SAMPLE".equals(B.serviceType))
                    {
                        s2 = "free_gift";
                    }
                    if ("CONTEST".equals(B.serviceType))
                    {
                        s2 = "contest";
                    }
                    if ("CONSULTATION".equals(B.serviceType))
                    {
                        s2 = "consultation";
                    }
                }
                if (s1 == null)
                {
                    break label0;
                }
                s2 = String.format(Locale.getDefault(), "%s://%s/%d?%s=%s&%s=%s", new Object[] {
                    s3, s4, Long.valueOf(y), "sourceType", s1, "campaign", s2
                });
            }
            return s2;
        }
        return String.format(Locale.getDefault(), "%s://%s/%d?&%s=%s", new Object[] {
            s3, s4, Long.valueOf(y), "campaign", s2
        });
    }

    public void o()
    {
        if (C == null)
        {
            com.perfectcorp.utility.e.e(new Object[] {
                "No brand info."
            });
            return;
        }
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(k.bc_dialog_follow_event);
        Object obj = (UICImageView)dialog.findViewById(com.cyberlink.beautycircle.j.avatar_image);
        if (obj != null && C.avatarUrl != null)
        {
            ((UICImageView) (obj)).setImageURI(C.avatarUrl);
        }
        obj = (TextView)dialog.findViewById(com.cyberlink.beautycircle.j.bc_dialog_display_name);
        if (obj != null)
        {
            ((TextView) (obj)).setText(C.displayName);
        }
        dialog.findViewById(com.cyberlink.beautycircle.j.freesample_follow_btn).setOnClickListener(new android.view.View.OnClickListener(dialog) {

            final Dialog a;
            final FreeSampleActivity b;

            public void onClick(View view)
            {
                (new j(this) {

                    final _cls9 a;

                    protected volatile Object a(Object obj)
                    {
                        return a((Void)obj);
                    }

                    protected String a(Void void1)
                    {
                        return AccountManager.b();
                    }

            
            {
                a = _pcls9;
                super();
            }
                }).d(null).a(new com.perfectcorp.utility.m(this) {

                    final _cls9 a;

                    protected void a(String s1)
                    {
                        if (AccountManager.c() != null)
                        {
                            com.perfectcorp.a.b.a(new q(FreeSampleActivity.a(a.b).brandId, AccountManager.c()));
                        }
                        NetworkUser.a(s1, FreeSampleActivity.a(a.b).brandId.longValue()).a(new com.perfectcorp.utility.m(this) {

                            final _cls1 a;

                            protected void a(int i)
                            {
                                super.a(i);
                                com.perfectcorp.utility.e.b(new Object[] {
                                    "Follow userId=", FreeSampleActivity.a(a.a.b).brandId, " fail: ", Integer.valueOf(i)
                                });
                                String s1 = a.a.b.getResources().getString(m.bc_follow_fail);
                                Globals.a(String.format(Locale.getDefault(), s1, new Object[] {
                                    com.cyberlink.beautycircle.controller.activity.FreeSampleActivity.e(a.a.b).displayName
                                }));
                            }

                            public void a(Void void1)
                            {
                                com.perfectcorp.utility.e.b(new Object[] {
                                    "Follow userId=", FreeSampleActivity.a(a.a.b).brandId, " success"
                                });
                                void1 = a.a.b.getResources().getString(m.bc_follow_success);
                                Globals.a(String.format(Locale.getDefault(), void1, new Object[] {
                                    com.cyberlink.beautycircle.controller.activity.FreeSampleActivity.e(a.a.b).displayName
                                }));
                                a.a.a.dismiss();
                                com.cyberlink.beautycircle.c.a(a.a.b, FreeSampleActivity.a(a.a.b));
                            }

                            public void b(Object obj)
                            {
                                a((Void)obj);
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                    }

                    protected void b(Object obj)
                    {
                        a((String)obj);
                    }

            
            {
                a = _pcls9;
                super();
            }
                });
            }

            
            {
                b = FreeSampleActivity.this;
                a = dialog;
                super();
            }
        });
        dialog.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final FreeSampleActivity a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                FreeSampleActivity.a(a, false);
            }

            
            {
                a = FreeSampleActivity.this;
                super();
            }
        });
        dialog.show();
    }

    protected void onActivityResult(int i, int l, Intent intent)
    {
        super.onActivityResult(i, l, intent);
        com.perfectcorp.utility.e.b(new Object[] {
            "requestCode:", Integer.toHexString(i), ", resultCode: ", Integer.toHexString(l)
        });
        if (i != 48141) goto _L2; else goto _L1
_L1:
        if (l == 48256)
        {
            com.cyberlink.beautycircle.c.a(this, B);
        }
_L4:
        return;
_L2:
        if (i != 48161)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (l == -1 && f != null)
        {
            f.reload();
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (i != 48144 || l != 48256 || f == null || B == null) goto _L4; else goto _L3
_L3:
        s = NetworkEvent.a(B.eventLink, y, AccountManager.c());
        if (s != null)
        {
            s = (new StringBuilder()).append(s).append("#ask").toString();
            v = true;
            f.loadUrl(s);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        b("");
        b().a(0xe4000000, x.a, x.j, 0);
        t.a(false);
        a(getIntent());
        a(bundle, false);
    }

    public void onNewIntent(Intent intent)
    {
        if (intent != null)
        {
            com.perfectcorp.utility.e.c(new Object[] {
                intent.getData()
            });
            super.onNewIntent(intent);
            setIntent(intent);
            a(intent);
        }
    }

    public void onResume()
    {
        super.onResume();
        E = false;
        if (F)
        {
            F = false;
            p();
        }
        if (B != null)
        {
            com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.x(B.id.toString(), A, B.serviceType));
        }
        G = System.currentTimeMillis();
        com.perfectcorp.a.b.a(new o(A, Long.valueOf(y), "show", 0L));
    }

    public void onRightBtnClick(View view)
    {
        a(false);
    }

    public void onRightSubBtnClick(View view)
    {
        com.cyberlink.beautycircle.c.a(this, com.cyberlink.beautycircle.controller.fragment.PageFreeSampleListFragment.EventListType.a, z, B.locale);
    }

    public void s()
    {
        super.s();
        p();
    }

    public void t()
    {
        super.t();
    }

    private class EventAction extends Enum
    {

        public static final EventAction a;
        public static final EventAction b;
        public static final EventAction c;
        public static final EventAction d;
        public static final EventAction e;
        private static final EventAction f[];
        public String action;

        public static EventAction a(String s1)
        {
            EventAction eventaction = a;
            if (b.action.equals(s1))
            {
                eventaction = b;
            } else
            {
                if (d.action.equals(s1))
                {
                    return d;
                }
                if (e.action.equals(s1))
                {
                    return e;
                }
                if (c.action.equals(s1))
                {
                    return c;
                }
            }
            return eventaction;
        }

        public static EventAction valueOf(String s1)
        {
            return (EventAction)Enum.valueOf(com/cyberlink/beautycircle/controller/activity/FreeSampleActivity$EventAction, s1);
        }

        public static EventAction[] values()
        {
            return (EventAction[])f.clone();
        }

        static 
        {
            a = new EventAction("NONE", 0, "");
            b = new EventAction("APPLY", 1, "apply");
            c = new EventAction("LISTUSER", 2, "listuser");
            d = new EventAction("MESSAGE", 3, "message");
            e = new EventAction("RESULT", 4, "result");
            f = (new EventAction[] {
                a, b, c, d, e
            });
        }

        private EventAction(String s1, int i, String s2)
        {
            super(s1, i);
            action = s2;
        }
    }

}
