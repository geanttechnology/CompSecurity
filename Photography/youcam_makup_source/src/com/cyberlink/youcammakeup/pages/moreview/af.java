// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.widgetpool.a.b;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ao;
import com.cyberlink.youcammakeup.widgetpool.dialogs.k;
import com.cyberlink.youcammakeup.widgetpool.dialogs.z;

public class af
{

    public static final String a = (new StringBuilder()).append("HAS_SHOWN_RATE_US_DIALOG_").append(com.cyberlink.youcammakeup.widgetpool.a.b.a().b()).toString();
    public static final String b = (new StringBuilder()).append("RESULT_PAGE_COUNT_").append(com.cyberlink.youcammakeup.widgetpool.a.b.a().b()).toString();
    public static final String c = (new StringBuilder()).append("DOWNLOAD_TEMPLATE_COUNT_").append(com.cyberlink.youcammakeup.widgetpool.a.b.a().b()).toString();
    private static z d;
    private static k e;
    private static ao f;
    private static com.cyberlink.youcammakeup.Globals.ActivityType g = null;

    public static int a(a a1)
    {
        return (int)(((float)a1.a() * 100F) / (float)a1.b());
    }

    public static void a(Activity activity, View view, com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType badgeitemtype)
    {
        if (activity != null && a(badgeitemtype))
        {
            activity.runOnUiThread(new Runnable(view) {

                final View a;

                public void run()
                {
                    if (a != null)
                    {
                        a.setVisibility(0);
                    }
                }

            
            {
                a = view;
                super();
            }
            });
        }
    }

    public static void a(com.cyberlink.youcammakeup.Globals.ActivityType activitytype)
    {
        activitytype = Globals.d().a(activitytype);
        if (activitytype != null && d != null)
        {
            activitytype = activitytype.getFragmentManager();
            if (activitytype != null)
            {
                activitytype = activitytype.beginTransaction();
                activitytype.remove(d);
                activitytype.commit();
                d = null;
            }
        }
    }

    public static void a(com.cyberlink.youcammakeup.Globals.ActivityType activitytype, int i)
    {
        activitytype = Globals.d().a(activitytype);
        if (activitytype != null)
        {
            f = new ao();
            activitytype = activitytype.getFragmentManager();
            if (activitytype != null)
            {
                activitytype = activitytype.beginTransaction();
                activitytype.replace(i, f);
                activitytype.commitAllowingStateLoss();
            }
        }
    }

    public static void a(com.cyberlink.youcammakeup.Globals.ActivityType activitytype, android.view.View.OnClickListener onclicklistener, int i, String s)
    {
        a(activitytype, onclicklistener, null, i, s);
    }

    public static void a(com.cyberlink.youcammakeup.Globals.ActivityType activitytype, android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1, int i, String s)
    {
        Activity activity = Globals.d().a(activitytype);
        if (activity != null)
        {
            d = new z();
            d.a(onclicklistener);
            if (onclicklistener1 != null)
            {
                d.b(onclicklistener1);
            }
            d.a(activitytype);
            if (s != null && !s.isEmpty())
            {
                d.a(s);
            }
            activitytype = activity.getFragmentManager();
            if (activitytype != null && !activity.isFinishing())
            {
                activitytype = activitytype.beginTransaction();
                activitytype.replace(i, d);
                try
                {
                    activitytype.commit();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (com.cyberlink.youcammakeup.Globals.ActivityType activitytype)
                {
                    activitytype.printStackTrace();
                }
                return;
            }
        }
    }

    public static void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeViewType badgeviewtype)
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager == null)
        {
            return;
        } else
        {
            networkmanager.K().a(badgeviewtype);
            return;
        }
    }

    public static boolean a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType badgeitemtype)
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager == null)
        {
            return false;
        } else
        {
            return networkmanager.K().a(badgeitemtype);
        }
    }

    public static boolean a(String s, long l)
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager == null)
        {
            return false;
        } else
        {
            return networkmanager.K().a(s, l);
        }
    }

    public static void b(com.cyberlink.youcammakeup.Globals.ActivityType activitytype)
    {
        activitytype = Globals.d().a(activitytype);
        if (activitytype != null && e != null)
        {
            activitytype = activitytype.getFragmentManager();
            if (activitytype != null)
            {
                activitytype = activitytype.beginTransaction();
                activitytype.remove(e);
                activitytype.commit();
                e = null;
            }
        }
    }

    public static void b(com.cyberlink.youcammakeup.Globals.ActivityType activitytype, android.view.View.OnClickListener onclicklistener, int i, String s)
    {
        activitytype = Globals.d().a(activitytype);
        if (activitytype != null)
        {
            e = new k();
            e.a(onclicklistener);
            if (s != null && !s.isEmpty())
            {
                e.a(s);
            }
            activitytype = activitytype.getFragmentManager();
            if (activitytype != null)
            {
                activitytype = activitytype.beginTransaction();
                activitytype.replace(i, e);
                try
                {
                    activitytype.commit();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (com.cyberlink.youcammakeup.Globals.ActivityType activitytype)
                {
                    activitytype.printStackTrace();
                }
                return;
            }
        }
    }

    public static void b(String s, long l)
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager == null)
        {
            return;
        } else
        {
            networkmanager.K().d(s, l);
            return;
        }
    }

    public static boolean c(com.cyberlink.youcammakeup.Globals.ActivityType activitytype)
    {
        boolean flag1 = false;
        activitytype = Globals.d().a(activitytype);
        boolean flag = flag1;
        if (activitytype != null)
        {
            flag = flag1;
            if (f != null)
            {
                activitytype = activitytype.getFragmentManager();
                flag = flag1;
                if (activitytype != null)
                {
                    activitytype = activitytype.beginTransaction();
                    activitytype.remove(f);
                    try
                    {
                        activitytype.commit();
                        f = null;
                        g = null;
                    }
                    // Misplaced declaration of an exception variable
                    catch (com.cyberlink.youcammakeup.Globals.ActivityType activitytype)
                    {
                        activitytype.printStackTrace();
                        return false;
                    }
                    flag = true;
                }
            }
        }
        return flag;
    }

    public static void d(com.cyberlink.youcammakeup.Globals.ActivityType activitytype)
    {
        g = activitytype;
    }

    public static void e(com.cyberlink.youcammakeup.Globals.ActivityType activitytype)
    {
        if (activitytype != null && activitytype == g && c(activitytype))
        {
            g = null;
        }
    }

}
