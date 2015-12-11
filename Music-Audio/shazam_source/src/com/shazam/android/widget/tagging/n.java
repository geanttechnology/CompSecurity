// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.widget.tagging;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.shazam.android.util.h.h;
import com.xrigau.syncscrolling.view.a;

// Referenced classes of package com.shazam.android.widget.tagging:
//            o, p, a, i

public final class n
{

    public n()
    {
    }

    public static o a(Activity activity)
    {
        activity = h.a(activity);
        if (activity == null)
        {
            return null;
        } else
        {
            return (o)activity.getTag(0x7f110034);
        }
    }

    public static p a(Object obj)
    {
        return (p)obj.getClass().getAnnotation(com/shazam/android/widget/tagging/p);
    }

    public static void a(Activity activity, Object obj)
    {
        com.shazam.android.widget.tagging.a a1 = b(activity).getController();
        int j = a(obj).c();
        if (j > 0)
        {
            activity = activity.findViewById(j);
            if (activity instanceof a)
            {
                a1.b((a)activity);
            }
            if (activity instanceof ListView)
            {
                a1.b((ListView)activity, new android.widget.AbsListView.OnScrollListener[0]);
            }
            if (activity instanceof RecyclerView)
            {
                a1.a((RecyclerView)activity);
            }
        }
    }

    public static void a(Activity activity, Object obj, boolean flag)
    {
        com.shazam.android.widget.tagging.a a1 = b(activity).getController();
        if (flag)
        {
            a1.d();
        }
        if (obj instanceof i)
        {
            ((i)obj).a(a1);
        }
        obj = a(obj);
        if (obj != null && ((p) (obj)).a())
        {
            boolean flag1;
            if (a(((p) (obj))) && 2 == activity.getResources().getConfiguration().orientation)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag1)
            {
                a1.a();
            }
        }
    }

    public static void a(Fragment fragment)
    {
        b(fragment.getActivity(), fragment);
    }

    public static void a(Fragment fragment, boolean flag)
    {
        a(((Activity) (fragment.getActivity())), fragment, flag);
    }

    public static boolean a(p p1)
    {
        return p1 != null && p1.d();
    }

    public static o b(Activity activity)
    {
        o o2 = a(activity);
        o o1 = o2;
        if (o2 == null)
        {
            o1 = new o(activity);
            activity = h.a(activity);
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2);
            layoutparams.gravity = 85;
            activity.addView(o1, layoutparams);
            activity.setTag(0x7f110034, o1);
        }
        o1.bringToFront();
        return o1;
    }

    public static void b(Activity activity, Object obj)
    {
        com.shazam.android.widget.tagging.a a1 = b(activity).getController();
        int j = a(obj).c();
        if (j > 0)
        {
            activity = activity.findViewById(j);
            if (activity instanceof a)
            {
                a1.a((a)activity);
            }
            if (activity instanceof ListView)
            {
                a1.a((ListView)activity, new android.widget.AbsListView.OnScrollListener[0]);
            }
            if (activity instanceof RecyclerView)
            {
                a1.a((RecyclerView)activity, new android.support.v7.widget.RecyclerView.l[0]);
            }
        }
    }

    public static void b(Fragment fragment)
    {
        a(fragment.getActivity(), fragment);
    }
}
