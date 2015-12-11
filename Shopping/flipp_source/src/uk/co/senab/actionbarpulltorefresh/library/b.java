// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.actionbarpulltorefresh.library;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import uk.co.senab.actionbarpulltorefresh.library.b.c;

// Referenced classes of package uk.co.senab.actionbarpulltorefresh.library:
//            PullToRefreshLayout, j, h

public final class b
{

    public h a;
    public uk.co.senab.actionbarpulltorefresh.library.a.b b;
    public HashMap c;
    private final Activity d;
    private int e[];
    private View f[];
    private ViewGroup g;

    private b(Activity activity)
    {
        d = activity;
    }

    b(Activity activity, byte byte0)
    {
        this(activity);
    }

    public final transient b a(View aview[])
    {
        f = aview;
        e = null;
        return this;
    }

    public final void a(PullToRefreshLayout pulltorefreshlayout)
    {
        int i1 = 0;
        int l1 = 0;
        int i = 0;
        j j1 = PullToRefreshLayout.a(d, a);
        j1.b = b;
        if (g != null)
        {
            ViewGroup viewgroup = g;
            for (View view = viewgroup.getChildAt(0); view != null; view = viewgroup.getChildAt(0))
            {
                viewgroup.removeViewAt(0);
                pulltorefreshlayout.addView(view);
            }

            viewgroup.addView(pulltorefreshlayout, -1, -1);
        }
        pulltorefreshlayout.setPullToRefreshAttacher(j1);
        if (e != null)
        {
            int ai[] = e;
            for (i1 = ai.length; i < i1; i++)
            {
                if (pulltorefreshlayout.findViewById(ai[i]) != null)
                {
                    pulltorefreshlayout.a(pulltorefreshlayout.findViewById(ai[i]));
                }
            }

        } else
        if (f != null)
        {
            View aview[] = f;
            l1 = aview.length;
            for (int k = i1; k < l1; k++)
            {
                if (aview[k] != null)
                {
                    pulltorefreshlayout.a(aview[k]);
                }
            }

        } else
        {
            pulltorefreshlayout.a();
            int k1 = pulltorefreshlayout.getChildCount();
            for (int l = l1; l < k1; l++)
            {
                pulltorefreshlayout.a(pulltorefreshlayout.getChildAt(l));
            }

        }
        if (c != null)
        {
            for (pulltorefreshlayout = c.entrySet().iterator(); pulltorefreshlayout.hasNext();)
            {
                Object obj = (java.util.Map.Entry)pulltorefreshlayout.next();
                Class class1 = (Class)((java.util.Map.Entry) (obj)).getKey();
                obj = (c)((java.util.Map.Entry) (obj)).getValue();
                Iterator iterator = j1.m.keySet().iterator();
                while (iterator.hasNext()) 
                {
                    View view1 = (View)iterator.next();
                    if (class1.isInstance(view1))
                    {
                        j1.m.put(view1, obj);
                    }
                }
            }

        }
    }
}
