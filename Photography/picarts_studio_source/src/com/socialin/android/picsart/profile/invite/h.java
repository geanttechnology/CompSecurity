// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.invite;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.appboy.Appboy;
import com.flurry.android.tumblr.PostListener;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import com.socialin.android.util.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myobfuscated.cv.a;

// Referenced classes of package com.socialin.android.picsart.profile.invite:
//            i

public class h extends Fragment
{

    private final String a = com/socialin/android/picsart/profile/invite/h.getSimpleName();
    private SharedPreferences b;
    private GridLayout c;
    private List d;
    private boolean e;
    private LayoutInflater f;
    private PostListener g;

    public h()
    {
        e = false;
        g = new _cls10();
    }

    static Intent a(h h1, String s, String s1)
    {
        String s2 = GalleryUtils.a((int)i.b() / 1000, h1.getActivity(), true);
        Intent intent = new Intent("android.intent.action.SEND");
        if (!TextUtils.isEmpty(s))
        {
            intent.setPackage(s);
        }
        intent.setType("text/plain");
        if (h1.e)
        {
            s = h1.getString(0x7f0803a9, new Object[] {
                s2
            });
        } else
        {
            s = h1.getString(0x7f0803aa);
        }
        intent.putExtra("android.intent.extra.SUBJECT", s);
        if (h1.e)
        {
            h1 = h1.getString(0x7f0803a7, new Object[] {
                s2, s1
            });
        } else
        {
            h1 = h1.getString(0x7f0803a8, new Object[] {
                s1
            });
        }
        intent.putExtra("android.intent.extra.TEXT", h1);
        intent.addFlags(0x10000000);
        return intent;
    }

    static String a(List list, String s)
    {
        if (list.isEmpty()) goto _L2; else goto _L1
_L1:
        Iterator iterator = list.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        list = (ResolveInfo)iterator.next();
        if (!s.equals(((ResolveInfo) (list)).activityInfo.applicationInfo.packageName)) goto _L6; else goto _L5
_L5:
        if (list != null)
        {
            return ((ResolveInfo) (list)).activityInfo.name;
        }
_L2:
        return null;
_L4:
        list = null;
        if (true) goto _L5; else goto _L7
_L7:
    }

    private void a()
    {
        Iterator iterator = d.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            a a1 = (a)iterator.next();
            if (a1 != null)
            {
                ViewGroup viewgroup = (ViewGroup)f.inflate(0x7f030245, null, false);
                ((ImageView)viewgroup.findViewById(0x7f100a6b)).setImageDrawable(a1.a);
                TextView textview = (TextView)viewgroup.findViewById(0x7f100a6c);
                textview.setTextColor(-1);
                textview.setText(a1.b);
                if (a1.c != null)
                {
                    viewgroup.findViewById(0x7f100a6a).setOnClickListener(a1.c);
                }
                c.addView(viewgroup);
            }
        } while (true);
    }

    static void a(h h1, String s)
    {
        if (h1.e)
        {
            AnalyticUtils.getInstance(h1.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.InviteFlowSendInviteEvent("ad_remover", s, h1.b.getInt("invite_send_count_ad_remover", 0)));
            Appboy.getInstance(h1.getActivity()).logCustomEvent("Invite_Flow_Invite_Sent_AdRemover");
            return;
        } else
        {
            int j = i.b(h1.getActivity().getApplicationContext()).getInt("invite_send_count_drawer", 0);
            Appboy.getInstance(h1.getActivity()).logCustomEvent("Invite_Flow_Invite_Sent");
            AnalyticUtils.getInstance(h1.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.InviteFlowSendInviteEvent("", s, j));
            return;
        }
    }

    static boolean a(h h1)
    {
        return h1.e;
    }

    static PostListener b(h h1)
    {
        return h1.g;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        b = com.socialin.android.picsart.profile.invite.i.a(getActivity().getApplicationContext());
        f = LayoutInflater.from(getActivity());
        if (getArguments() != null)
        {
            e = getArguments().getBoolean("isAdRemover", false);
        }
        getView().findViewById(0x7f1006b2).setOnClickListener(new _cls1());
        c = (GridLayout)getView().findViewById(0x7f1006b1);
        d = new ArrayList();
        bundle = new a(getResources().getDrawable(0x7f020647), getString(0x7f0802c7));
        bundle.c = new _cls5();
        d.add(bundle);
        bundle = getActivity().getPackageManager();
        try
        {
            bundle.getPackageInfo("com.twitter.android", 1);
            bundle = new a(getResources().getDrawable(0x7f02064d), getString(0x7f080360));
            bundle.c = new _cls8();
            d.add(bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            com.socialin.android.d.b(a, "Twitter is not installed !!!!! ", bundle);
        }
        if (Utils.d(getActivity()) <= 480F)
        {
            bundle = getActivity().getPackageManager();
            Object obj;
            a a1;
            try
            {
                bundle.getPackageInfo("com.whatsapp", 1);
                bundle = new a(getResources().getDrawable(0x7f02064e), getString(0x7f080372));
                bundle.c = new _cls7();
                d.add(bundle);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                com.socialin.android.d.b(a, "WhatsApp is not installed !!!!! ", bundle);
            }
        }
        bundle = getActivity().getPackageManager();
        try
        {
            bundle.getPackageInfo("com.facebook.orca", 1);
            bundle = new a(getResources().getDrawable(0x7f020203), getString(0x7f0802c8));
            bundle.c = new _cls6();
            d.add(bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            com.socialin.android.d.b(a, "Messenger is not installed !!!!! ", bundle);
        }
        bundle = SocialinV3.getInstance().getSettings();
        if (bundle.isTumblrEnabled())
        {
            obj = new a(getResources().getDrawable(0x7f020729), getString(0x7f08035e));
            obj.c = new _cls9();
            d.add(obj);
        }
        if (getString(0x7f0808c8).equals(getString(0x7f0808cc)))
        {
            if (bundle.isWeiboEnabled())
            {
                obj = getActivity().getPackageManager();
                try
                {
                    ((PackageManager) (obj)).getPackageInfo("com.sina.weibo", 1);
                    a1 = new a(getResources().getDrawable(0x7f0206be), getString(0x7f0807d7));
                    a1.c = new _cls12(((PackageManager) (obj)));
                    d.add(a1);
                }
                catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
                {
                    com.socialin.android.d.b(a, "sinaweibo is not installed !!!!! ", namenotfoundexception);
                }
                obj = getActivity().getPackageManager();
                try
                {
                    ((PackageManager) (obj)).getPackageInfo("com.tencent.WBlog", 1);
                    a1 = new a(getResources().getDrawable(0x7f0206f8), getString(0x7f0807db));
                    a1.c = new _cls2(((PackageManager) (obj)));
                    d.add(a1);
                }
                catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1)
                {
                    com.socialin.android.d.b(a, "tenweibo is not installed !!!!! ", namenotfoundexception1);
                }
            }
            if (bundle.isWeChatEnabled())
            {
                obj = getActivity().getPackageManager();
                try
                {
                    ((PackageManager) (obj)).getPackageInfo("com.tencent.mm", 1);
                    a1 = new a(getResources().getDrawable(0x7f020755), getString(0x7f0807da));
                    a1.c = new _cls3(((PackageManager) (obj)));
                    d.add(a1);
                }
                catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception2)
                {
                    com.socialin.android.d.b(a, "WeChat is not installed !!!!! ", namenotfoundexception2);
                }
            }
            if (bundle.isQQEnabled())
            {
                bundle = getActivity().getPackageManager();
                try
                {
                    bundle.getPackageInfo("com.tencent.mobileqqi", 1);
                    obj = new a(getResources().getDrawable(0x7f0205e1), getString(0x7f0807d9));
                    obj.c = new _cls4(bundle);
                    d.add(obj);
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    com.socialin.android.d.b(a, "QQ is not installed !!!!! ", bundle);
                }
            }
        }
        bundle = new Intent("android.intent.action.SEND", null);
        bundle.setDataAndType(null, "text/*");
        bundle = getActivity().getPackageManager().queryIntentActivities(bundle, 0x10000);
        if (bundle != null && bundle.size() > 0)
        {
            obj = new a(getResources().getDrawable(0x7f02064b), getString(0x7f080303));
            obj.c = new _cls11(bundle, getString(0x7f080908), true);
            d.add(obj);
        }
        a();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030145, viewgroup, false);
    }

    /* member class not found */
    class _cls10 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls9 {}


    /* member class not found */
    class _cls12 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls11 {}

}
