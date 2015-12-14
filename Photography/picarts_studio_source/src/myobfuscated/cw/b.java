// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cw;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.picsart.studio.view.g;
import com.socialin.android.d;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package myobfuscated.cw:
//            c

public class b extends PagerAdapter
    implements g
{

    private static final String a = myobfuscated/cw/b.getSimpleName();
    private List b;
    private Activity c;
    private Fragment d;
    private FragmentTransaction e;
    private FragmentManager f;
    private LayoutInflater g;

    public b(Activity activity, FragmentManager fragmentmanager)
    {
        b = new ArrayList();
        d = null;
        g = null;
        f = fragmentmanager;
        c = activity;
        g = c.getLayoutInflater();
    }

    public final Fragment a()
    {
        Fragment fragment;
        try
        {
            fragment = f.findFragmentByTag(((c)b.get(1)).d);
        }
        catch (Exception exception)
        {
            com.socialin.android.d.b(a, "getFragment", exception);
            return null;
        }
        return fragment;
    }

    public final View a(int i, ViewGroup viewgroup)
    {
        viewgroup = (TextView)g.inflate(0x7f030256, viewgroup, false);
        viewgroup.setText(c(i));
        viewgroup.setId(((c)b.get(i)).e);
        return viewgroup;
    }

    public final void a(CharSequence charsequence, Class class1, Bundle bundle, int i)
    {
        charsequence = new c(class1, bundle, charsequence, i);
        b.add(charsequence);
    }

    public final CharSequence c(int i)
    {
        return ((c)b.get(i)).c;
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        if (e == null)
        {
            e = f.beginTransaction();
        }
        e.detach((Fragment)obj);
    }

    public void finishUpdate(ViewGroup viewgroup)
    {
        if (e != null)
        {
            e.commitAllowingStateLoss();
            e = null;
            f.executePendingTransactions();
        }
    }

    public int getCount()
    {
        return b.size();
    }

    public int getItemPosition(Object obj)
    {
        return super.getItemPosition(obj);
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        if (e == null)
        {
            e = f.beginTransaction();
        }
        Object obj = ((c)b.get(i)).d;
        obj = f.findFragmentByTag(((String) (obj)));
        if (obj != null)
        {
            e.attach(((Fragment) (obj)));
        } else
        {
            Fragment fragment = f.findFragmentByTag(((c)b.get(i)).d);
            obj = fragment;
            if (fragment == null)
            {
                c c1 = (c)b.get(i);
                obj = Fragment.instantiate(c, c1.a.getName(), c1.b);
                c1.d = (new StringBuilder("PagerFragment.")).append(i).toString();
            }
            e.add(viewgroup.getId(), ((Fragment) (obj)), (new StringBuilder("PagerFragment.")).append(i).toString());
        }
        if (obj != d)
        {
            ((Fragment) (obj)).setMenuVisibility(false);
            ((Fragment) (obj)).setUserVisibleHint(false);
        }
        return obj;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return ((Fragment)obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classloader)
    {
    }

    public Parcelable saveState()
    {
        return null;
    }

    public void setPrimaryItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup = (Fragment)obj;
        if (viewgroup != d)
        {
            d = viewgroup;
        }
    }

    public void startUpdate(ViewGroup viewgroup)
    {
    }

}
