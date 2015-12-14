// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.picsart.studio.view.g;
import com.socialin.android.d;
import com.socialin.android.picsart.profile.fragment.at;
import com.socialin.android.picsart.profile.fragment.bj;
import com.socialin.android.picsart.profile.fragment.q;
import com.socialin.android.picsart.profile.fragment.v;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            MainPagerActivity

public final class e extends PagerAdapter
    implements g
{

    public static final int a[] = {
        0x7f0805bb, 0x7f0802c4, 0x7f08028d, 0x7f0805b3
    };
    public static final String b[] = {
        "my.network.fragment", "explore.fragment", "artists.fragment", "contests.fragment"
    };
    final FragmentManager c;
    FragmentTransaction d;
    Fragment e;
    int f;
    private boolean g;
    private Context h;

    public e(FragmentManager fragmentmanager, Context context)
    {
        g = false;
        d = null;
        e = null;
        h = null;
        c = fragmentmanager;
        h = context;
    }

    public static int a(int i)
    {
        for (int j = 0; j < 4; j++)
        {
            if (a[j] == i)
            {
                return j;
            }
        }

        return -2;
    }

    private String b(int i)
    {
        return h.getString(a[i]);
    }

    public final View a(int i, ViewGroup viewgroup)
    {
        byte byte0;
        byte0 = -1;
        viewgroup = (ImageView)LayoutInflater.from(h).inflate(0x7f030154, viewgroup, false);
        a[i % 4];
        JVM INSTR lookupswitch 4: default 72
    //                   2131231373: 156
    //                   2131231428: 138
    //                   2131232179: 150
    //                   2131232187: 144;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        int j = -1;
_L11:
        viewgroup.setImageResource(j);
        a[i % 4];
        JVM INSTR lookupswitch 4: default 128
    //                   2131231373: 180
    //                   2131231428: 162
    //                   2131232179: 174
    //                   2131232187: 168;
           goto _L6 _L7 _L8 _L9 _L10
_L7:
        break MISSING_BLOCK_LABEL_180;
_L6:
        i = byte0;
_L12:
        viewgroup.setId(i);
        return viewgroup;
_L3:
        j = 0x7f020785;
          goto _L11
_L5:
        j = 0x7f02078c;
          goto _L11
_L4:
        j = 0x7f020784;
          goto _L11
_L2:
        j = 0x7f02078f;
          goto _L11
_L8:
        i = 0x7f100077;
          goto _L12
_L10:
        i = 0x7f100089;
          goto _L12
_L9:
        i = 0x7f100075;
          goto _L12
        i = 0x7f10009b;
          goto _L12
    }

    public final void a(boolean flag)
    {
        if (e != null)
        {
            e.setMenuVisibility(flag);
            e.setUserVisibleHint(flag);
        }
    }

    public final boolean a()
    {
        g = true;
        notifyDataSetChanged();
        g = false;
        return true;
    }

    public final CharSequence c(int i)
    {
        return b(i);
    }

    public final void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        if (d == null)
        {
            d = c.beginTransaction();
        }
        if (d.b)
        {
            (new StringBuilder("Detaching item #")).append(a[i]).append(": f=").append(obj).append(" v=").append(((Fragment)obj).getView());
        }
        d.detach((Fragment)obj);
    }

    public final void finishUpdate(ViewGroup viewgroup)
    {
        if (d != null)
        {
            d.commitAllowingStateLoss();
            d = null;
            c.executePendingTransactions();
        }
    }

    public final int getCount()
    {
        return 4;
    }

    public final int getItemPosition(Object obj)
    {
        if (g)
        {
            return -2;
        } else
        {
            return super.getItemPosition(obj);
        }
    }

    public final CharSequence getPageTitle(int i)
    {
        int ai[] = a;
        return h.getString(ai[i % 4]);
    }

    public final Object instantiateItem(ViewGroup viewgroup, int i)
    {
        Object obj;
        long l;
        boolean flag;
        flag = true;
        if (d == null)
        {
            d = c.beginTransaction();
        }
        l = a[i];
        obj = b[i];
        obj = c.findFragmentByTag(((String) (obj)));
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (d.b)
        {
            (new StringBuilder("Attaching item #")).append(l).append(": f=").append(obj);
        }
        d.attach(((Fragment) (obj)));
        a(true);
        viewgroup = ((ViewGroup) (obj));
_L9:
        if (viewgroup != e)
        {
            viewgroup.setMenuVisibility(false);
            viewgroup.setUserVisibleHint(false);
        }
        return viewgroup;
_L2:
        Bundle bundle;
        int j = a[i];
        bundle = new Bundle();
        if (a[f] != j)
        {
            flag = false;
        }
        bundle.putBoolean("load.ad", flag);
        j;
        JVM INSTR lookupswitch 4: default 196
    //                   2131231373: 289
    //                   2131231428: 275
    //                   2131232179: 282
    //                   2131232187: 212;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break MISSING_BLOCK_LABEL_289;
_L5:
        break; /* Loop/switch isn't completed */
_L3:
        throw new IllegalStateException("Invalid fragment title");
_L7:
        obj = at.m();
_L10:
        ((Fragment) (obj)).setArguments(bundle);
        if (d.b)
        {
            (new StringBuilder("Adding item #")).append(l).append(": f=").append(obj);
        }
        d.add(viewgroup.getId(), ((Fragment) (obj)), b[i]);
        viewgroup = ((ViewGroup) (obj));
        if (true) goto _L9; else goto _L8
_L8:
        obj = v.m();
          goto _L10
_L6:
        obj = q.a();
          goto _L10
        obj = bj.m();
          goto _L10
    }

    public final boolean isViewFromObject(View view, Object obj)
    {
        return ((Fragment)obj).getView() == view;
    }

    public final void restoreState(Parcelable parcelable, ClassLoader classloader)
    {
    }

    public final Parcelable saveState()
    {
        return null;
    }

    public final void setPrimaryItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup = (Fragment)obj;
        if (viewgroup != e && viewgroup != null && viewgroup.isResumed())
        {
            if (e != null)
            {
                e.setMenuVisibility(false);
                e.setUserVisibleHint(false);
            }
            viewgroup.setMenuVisibility(true);
            viewgroup.setUserVisibleHint(true);
            if (h instanceof MainPagerActivity)
            {
                obj = ((MainPagerActivity)h).getSupportActionBar();
                if (obj != null)
                {
                    ((ActionBar) (obj)).setTitle(b(i));
                }
            }
            e = viewgroup;
        }
    }

    public final void startUpdate(ViewGroup viewgroup)
    {
    }

}
