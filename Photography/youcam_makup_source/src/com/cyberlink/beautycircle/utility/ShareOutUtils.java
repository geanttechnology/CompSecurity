// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.BaseFbActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.a.ax;
import com.cyberlink.beautycircle.controller.a.ay;
import com.cyberlink.beautycircle.controller.a.bb;
import com.cyberlink.beautycircle.controller.activity.ContestActivity;
import com.cyberlink.beautycircle.controller.adapter.ShareAdapter;
import com.cyberlink.beautycircle.d;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.NetworkContest;
import com.cyberlink.beautycircle.view.widgetpool.facebook.LoginButton;
import com.cyberlink.you.u;
import com.facebook.HttpMethod;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.perfectcorp.a.b;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.s;
import com.sina.weibo.sdk.exception.WeiboException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            AccountManager, ab, ae, ah, 
//            ai, af, b

public class ShareOutUtils
{

    public static void a(Activity activity, ShareInfo shareinfo, String s1)
    {
        Object obj;
        if (shareinfo.f != null)
        {
            obj = shareinfo.f.toString();
        } else
        {
            obj = "";
        }
        shareinfo = new Intent("android.intent.action.VIEW", Uri.parse(String.format("https://www.pinterest.com/pin/create/button/?url=%s&media=%s&description=%s", new Object[] {
            s.a(s1), s.a(((String) (obj))), s.a(shareinfo.c)
        })));
        s1 = activity.getPackageManager().queryIntentActivities(shareinfo, 0).iterator();
        do
        {
            if (!s1.hasNext())
            {
                break;
            }
            obj = (ResolveInfo)s1.next();
            if (((ResolveInfo) (obj)).activityInfo.packageName.toLowerCase(Locale.US).startsWith("com.pinterest"))
            {
                shareinfo.setPackage(((ResolveInfo) (obj)).activityInfo.packageName);
            }
        } while (true);
        activity.startActivity(shareinfo);
    }

    private static void a(Activity activity, String s1, String s2)
    {
        s1 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("https://twitter.com/intent/tweet?text=%s&url=%s", new Object[] {
            s.a(s1), s.a(s2)
        })));
        s2 = activity.getPackageManager().queryIntentActivities(s1, 0).iterator();
        do
        {
            if (!s2.hasNext())
            {
                break;
            }
            ResolveInfo resolveinfo = (ResolveInfo)s2.next();
            if (resolveinfo.activityInfo.packageName.toLowerCase(Locale.US).startsWith("com.twitter"))
            {
                s1.setPackage(resolveinfo.activityInfo.packageName);
            }
        } while (true);
        activity.startActivity(s1);
    }

    private static void a(BaseFbActivity basefbactivity, ShareInfo shareinfo)
    {
        AccountManager.a(basefbactivity, new com.cyberlink.beautycircle.utility.b(shareinfo, basefbactivity) {

            final ShareInfo a;
            final BaseFbActivity b;

            public void a()
            {
                Globals.b("Get AccountToken Fail");
            }

            public void a(String s1)
            {
                if (a.a instanceof Post)
                {
                    s1 = a.a.toString();
                    Globals.b("ToDo: [BC Messages] Implement Share Post");
                    u.a(b, com.cyberlink.beautycircle.utility.AccountManager.b());
                    u.b(b, s1);
                }
            }

            public void b()
            {
                Globals.b("Get AccountToken Cancel");
            }

            
            {
                a = shareinfo;
                b = basefbactivity;
                super();
            }
        });
    }

    public static void a(BaseFbActivity basefbactivity, ShareInfo shareinfo, com.cyberlink.beautycircle.controller.adapter.ShareAdapter.ShareListMode sharelistmode, int i, android.content.DialogInterface.OnDismissListener ondismisslistener)
    {
        if (basefbactivity == null || shareinfo == null)
        {
            com.perfectcorp.utility.e.e(new Object[] {
                "Invalid parameter: activity=", basefbactivity, " shareInfo=", shareinfo
            });
            return;
        }
        Dialog dialog = new Dialog(basefbactivity);
        dialog.requestWindowFeature(1);
        dialog.setContentView(k.bc_dialog_share_to_opt);
        dialog.findViewById(j.itemMore).setVisibility(8);
        ((TextView)dialog.findViewById(j.bc_dialog_desc)).setText(i);
        sharelistmode = ShareAdapter.a(basefbactivity, "text/plain", sharelistmode);
        ListView listview = (ListView)dialog.findViewById(j.content_list);
        listview.setAdapter(sharelistmode);
        listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(dialog, sharelistmode, basefbactivity, shareinfo) {

            final Dialog a;
            final ShareAdapter b;
            final BaseFbActivity c;
            final ShareInfo d;

            public void onItemClick(AdapterView adapterview, View view, int l, long l1)
            {
                a.dismiss();
                adapterview = ((ResolveInfo)b.getItem(l)).activityInfo.packageName;
                ShareOutUtils.a(c, d, adapterview);
            }

            
            {
                a = dialog;
                b = shareadapter;
                c = basefbactivity;
                d = shareinfo;
                super();
            }
        });
        dialog.getWindow().setBackgroundDrawableResource(g.bc_color_transparent);
        if (ondismisslistener != null)
        {
            dialog.setOnDismissListener(ondismisslistener);
        }
        dialog.show();
    }

    public static void a(BaseFbActivity basefbactivity, ShareInfo shareinfo, String s1)
    {
        class ShareInfo.ShareSource extends Enum
        {

            public static final ShareInfo.ShareSource a;
            public static final ShareInfo.ShareSource b;
            public static final ShareInfo.ShareSource c;
            private static final ShareInfo.ShareSource d[];

            public static ShareInfo.ShareSource valueOf(String s4)
            {
                return (ShareInfo.ShareSource)Enum.valueOf(com/cyberlink/beautycircle/utility/ShareOutUtils$ShareInfo$ShareSource, s4);
            }

            public static ShareInfo.ShareSource[] values()
            {
                return (ShareInfo.ShareSource[])d.clone();
            }

            static 
            {
                a = new ShareInfo.ShareSource("BrandEvent", 0);
                b = new ShareInfo.ShareSource("Contest", 1);
                c = new ShareInfo.ShareSource("Post", 2);
                d = (new ShareInfo.ShareSource[] {
                    a, b, c
                });
            }

            private ShareInfo.ShareSource(String s1, int i)
            {
                super(s1, i);
            }
        }

        String s2;
        if (s1.startsWith(com.cyberlink.beautycircle.controller.adapter.s.a))
        {
            s2 = s1.substring(com.cyberlink.beautycircle.controller.adapter.s.a.length());
        } else
        {
            s2 = s1;
        }
        com.perfectcorp.a.b.a(new ay(s2));
        if (ShareInfo.ShareSource.c.equals(shareinfo.g))
        {
            s1 = AccountManager.f();
            String s3;
            if (s1 == null)
            {
                s1 = "none";
            } else
            {
                s1 = s1.toString();
            }
            if (shareinfo.b == null)
            {
                s3 = "none";
            } else
            {
                s3 = shareinfo.b.toString();
            }
            com.perfectcorp.a.b.a(new ax(s1, s2, "share", s3));
        }
        if (shareinfo.e != null)
        {
            if (shareinfo.e.equals("QUERY_DEEPLINK"))
            {
                s1 = basefbactivity.e(s2);
            } else
            if (shareinfo.e.equals("QUERY_POST_DEEPLINK"))
            {
                s1 = BaseActivity.a(s2, basefbactivity.a(basefbactivity.n, s2), shareinfo.b);
            } else
            if (shareinfo.e.equals("QUERY_CONTEST_POST_DEEPLINK"))
            {
                s1 = NetworkContest.a(basefbactivity.a(basefbactivity.n, s2), shareinfo.b);
            } else
            {
                s1 = shareinfo.e;
            }
        } else
        {
            s1 = null;
        }
        if (com.cyberlink.beautycircle.utility.ShareInfo.ShareSource.b.equals(shareinfo.g))
        {
            com.perfectcorp.a.b.a(new bb(shareinfo.h, "share", shareinfo.i, "Yes", s2, shareinfo.b.longValue()));
        }
        if (s2.equals(d.d))
        {
            d(basefbactivity, shareinfo, s1);
        } else
        if (s2.equals(d.e))
        {
            a(((Activity) (basefbactivity)), shareinfo.c, s1);
            if (shareinfo.j != null)
            {
                shareinfo.j.a();
                return;
            }
        } else
        {
            if (s2.equals(d.h))
            {
                a(((Activity) (basefbactivity)), shareinfo, s1);
                return;
            }
            if (s2.equals(d.q))
            {
                c(basefbactivity, shareinfo, s1);
                return;
            }
            if (s2.equals(d.i))
            {
                f(basefbactivity, shareinfo, s1);
                return;
            }
            if (s2.equals(d.j))
            {
                a(basefbactivity, shareinfo, s1, false);
                return;
            }
            if (s2.equals(com.cyberlink.beautycircle.controller.adapter.s.f))
            {
                a(basefbactivity, shareinfo, s1, true);
                return;
            }
            if (s2.equals(com.cyberlink.beautycircle.controller.adapter.s.g))
            {
                a(basefbactivity, shareinfo);
                return;
            } else
            {
                a(basefbactivity, shareinfo, s1, s2);
                shareinfo.j.a();
                return;
            }
        }
    }

    private static void a(BaseFbActivity basefbactivity, ShareInfo shareinfo, String s1, String s2)
    {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        String s3;
        if (shareinfo.c == null)
        {
            s3 = "";
        } else
        {
            s3 = (new StringBuilder()).append(shareinfo.c).append(" ").toString();
        }
        intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(s3).append(s1).toString());
        intent.setType("text/plain");
        if (s2 == null)
        {
            basefbactivity.startActivity(Intent.createChooser(intent, basefbactivity.getString(m.bc_share_more_option_title)));
            return;
        }
        if (com.cyberlink.beautycircle.utility.ShareInfo.ShareSource.b.equals(shareinfo.g))
        {
            com.perfectcorp.a.b.a(new bb(shareinfo.h, "share", shareinfo.i, "Yes", s2, shareinfo.b.longValue()));
        }
        intent.setPackage(s2);
        try
        {
            basefbactivity.startActivity(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (BaseFbActivity basefbactivity)
        {
            com.perfectcorp.utility.e.e(new Object[] {
                basefbactivity
            });
        }
    }

    private static void a(BaseFbActivity basefbactivity, ShareInfo shareinfo, String s1, boolean flag)
    {
        if (basefbactivity.k == null)
        {
            basefbactivity.k = new ae(basefbactivity);
        }
        basefbactivity.k.a(shareinfo.c, shareinfo.d, s1, shareinfo.f, new af(shareinfo, basefbactivity) {

            final ShareInfo a;
            final BaseFbActivity b;

            public void a()
            {
                if (com.cyberlink.beautycircle.utility.ShareInfo.ShareSource.b.equals(a.g))
                {
                    com.perfectcorp.a.b.a(new bb(a.h, "share", a.i, "Yes", d.j, a.b.longValue()));
                }
                b.l();
                Globals.a(b.getString(m.bc_share_success));
                b.s();
            }

            public void b()
            {
                if (com.cyberlink.beautycircle.utility.ShareInfo.ShareSource.b.equals(a.g))
                {
                    com.perfectcorp.a.b.a(new bb(a.h, "share", a.i, "No", d.j, a.b.longValue()));
                }
                b.l();
                Globals.a(b.getString(m.bc_share_fail));
            }

            
            {
                a = shareinfo;
                b = basefbactivity;
                super();
            }
        }, flag);
    }

    static void b(BaseFbActivity basefbactivity, ShareInfo shareinfo, String s1)
    {
        e(basefbactivity, shareinfo, s1);
    }

    private static void c(BaseFbActivity basefbactivity, ShareInfo shareinfo, String s1)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        String s2;
        if (shareinfo.c == null)
        {
            s2 = "";
        } else
        {
            s2 = (new StringBuilder()).append(shareinfo.c).append(" ").toString();
        }
        intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(s2).append(s1).toString());
        intent.putExtra("android.intent.extra.STREAM", ContestActivity.r);
        intent.setType("image/*");
        if (com.cyberlink.beautycircle.utility.ShareInfo.ShareSource.b.equals(shareinfo.g))
        {
            com.perfectcorp.a.b.a(new bb(shareinfo.h, "share", shareinfo.i, "Yes", "android.intent.extra.STREAM", shareinfo.b.longValue()));
        }
        intent.setPackage(d.q);
        basefbactivity.startActivity(intent);
    }

    private static void d(BaseFbActivity basefbactivity, ShareInfo shareinfo, String s1)
    {
        if (Session.getActiveSession().isOpened())
        {
            e(basefbactivity, shareinfo, s1);
        } else
        {
            basefbactivity.l = true;
            basefbactivity.m = new Runnable(basefbactivity, shareinfo, s1) {

                final BaseFbActivity a;
                final ShareInfo b;
                final String c;

                public void run()
                {
                    com.cyberlink.beautycircle.utility.ShareOutUtils.b(a, b, c);
                }

            
            {
                a = basefbactivity;
                b = shareinfo;
                c = s1;
                super();
            }
            };
            if (basefbactivity.i != null)
            {
                basefbactivity.i.performClick();
                return;
            }
        }
    }

    private static void e(BaseFbActivity basefbactivity, ShareInfo shareinfo, String s1)
    {
        String s2 = d.d;
        Session session = Session.getActiveSession();
        if (s1 != null)
        {
            Bundle bundle = new Bundle();
            bundle.putString("id", s1);
            bundle.putString("scrape", "true");
            (new Request(session, "", bundle, HttpMethod.GET, new com.facebook.Request.Callback(shareinfo, basefbactivity, s1, s2) {

                final ShareInfo a;
                final BaseFbActivity b;
                final String c;
                final String d;

                public void onCompleted(Response response)
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "response", response.toString()
                    });
                    response = a.c;
                    String s3 = a.d;
                    String s4 = a.f.toString();
                    b.a(response, s3, s4, c, d, null, -1L);
                }

            
            {
                a = shareinfo;
                b = basefbactivity;
                c = s1;
                d = s2;
                super();
            }
            })).executeAsync();
            return;
        } else
        {
            basefbactivity.l();
            return;
        }
    }

    private static void f(BaseFbActivity basefbactivity, ShareInfo shareinfo, String s1)
    {
        s1 = (new StringBuilder()).append(shareinfo.c).append(" \n").append(s1).toString();
        if (basefbactivity.j == null)
        {
            basefbactivity.j = new ah(basefbactivity);
        }
        basefbactivity.k();
        basefbactivity.j.a(s1, shareinfo.f, new ai(shareinfo, basefbactivity) {

            final ShareInfo a;
            final BaseFbActivity b;

            public void a()
            {
                if (com.cyberlink.beautycircle.utility.ShareInfo.ShareSource.b.equals(a.g))
                {
                    com.perfectcorp.a.b.a(new bb(a.h, "share", a.i, "Yes", d.i, a.b.longValue()));
                }
                b.l();
                Globals.a(b.getString(m.bc_share_success));
                b.s();
            }

            public void a(WeiboException weiboexception)
            {
                if (com.cyberlink.beautycircle.utility.ShareInfo.ShareSource.b.equals(a.g))
                {
                    com.perfectcorp.a.b.a(new bb(a.h, "share", a.i, "No", d.i, a.b.longValue()));
                }
                b.l();
                Globals.a(b.getString(m.bc_share_fail));
                com.perfectcorp.utility.e.e(new Object[] {
                    weiboexception
                });
            }

            
            {
                a = shareinfo;
                b = basefbactivity;
                super();
            }
        });
    }

    private class ShareInfo
    {

        public Model a;
        public Long b;
        public String c;
        public String d;
        public String e;
        public Uri f;
        public ShareSource g;
        public String h;
        public String i;
        public ab j;

        public static ShareInfo a(com.cyberlink.beautycircle.model.Contest.ContestInfo contestinfo)
        {
            ShareInfo shareinfo = new ShareInfo();
            shareinfo.g = com.cyberlink.beautycircle.utility.ShareSource.b;
            shareinfo.b = contestinfo.id;
            shareinfo.c = contestinfo.title;
            shareinfo.d = contestinfo.descriptionForFacebook;
            shareinfo.e = contestinfo.shareURL;
            shareinfo.f = contestinfo.thumbnail;
            return shareinfo.a();
        }

        public static ShareInfo a(com.cyberlink.beautycircle.model.Event.BrandEventInfo brandeventinfo)
        {
            ShareInfo shareinfo = new ShareInfo();
            shareinfo.g = ShareSource.a;
            shareinfo.b = brandeventinfo.id;
            shareinfo.c = brandeventinfo.title;
            shareinfo.d = brandeventinfo.description;
            shareinfo.e = "QUERY_DEEPLINK";
            shareinfo.f = brandeventinfo.imageUrl;
            return shareinfo.a();
        }

        public static ShareInfo a(Post post)
        {
            ShareInfo shareinfo = new ShareInfo();
            shareinfo.g = ShareSource.c;
            shareinfo.a = post;
            shareinfo.b = post.postId;
            shareinfo.c = post.title;
            shareinfo.d = post.content;
            shareinfo.e = "QUERY_POST_DEEPLINK";
            shareinfo.f = post.b();
            return shareinfo.a();
        }

        public ShareInfo a()
        {
            if (d != null)
            {
                d = d.replaceAll("\\<(/?[^\\>]+)\\>", "");
            }
            return this;
        }

        public ShareInfo()
        {
        }
    }

}
