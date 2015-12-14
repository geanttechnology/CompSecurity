// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.picsart.shop:
//            g, d

public class f extends Fragment
{

    RecyclerView a;
    g b;
    android.support.v7.widget.RecyclerView.OnScrollListener c;
    int d;
    private d e;
    private String f[];

    public f()
    {
        a = null;
        e = null;
        c = null;
        d = 0;
        f = new String[0];
        b = new g();
    }

    static RecyclerView a(f f1)
    {
        return f1.a;
    }

    static d b(f f1)
    {
        return f1.e;
    }

    static android.support.v7.widget.RecyclerView.OnScrollListener c(f f1)
    {
        return f1.c;
    }

    public void onActivityCreated(Bundle bundle)
    {
        int i = 0;
        super.onActivityCreated(bundle);
        Object obj = new LinearLayoutManager(getActivity(), 1, false);
        a.addItemDecoration(b);
        a.setLayoutManager(((android.support.v7.widget.RecyclerView.LayoutManager) (obj)));
        e = new d(getActivity());
        if (bundle != null)
        {
            obj = bundle;
        } else
        {
            obj = getArguments();
        }
        if (obj != null)
        {
            f = ((Bundle) (obj)).getStringArray("tagsList");
        }
        if (f == null && bundle != null)
        {
            f = bundle.getStringArray("categories");
        }
        if (f != null)
        {
            for (; i < f.length; i++)
            {
                e.add(f[i]);
            }

            a.setAdapter(e);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0301cf, viewgroup, false);
        a = (RecyclerView)layoutinflater.findViewById(0x7f100868);
        if (c != null)
        {
            a.setOnScrollListener(c);
        }
        return layoutinflater;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putStringArray("categories", f);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
    }

    // Unreferenced inner class com/picsart/shop/f$1

/* anonymous class */
    final class _cls1
        implements Runnable
    {

        private int a;
        private int b;
        private f c;

        public final void run()
        {
            f.a(c).setOnScrollListener(null);
            if (f.b(c) != null && f.b(c).getItemCount() > 0)
            {
                if (a == 0)
                {
                    f.a(c).scrollToPosition(0);
                } else
                {
                    f.a(c).scrollBy(0, -b);
                }
            }
            f.a(c).setOnScrollListener(f.c(c));
        }

            
            {
                c = f.this;
                a = i;
                b = j;
                super();
            }
    }

}
