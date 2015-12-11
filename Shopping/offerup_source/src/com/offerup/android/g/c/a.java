// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.c;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.offerup.android.h.b;
import com.squareup.otto.Bus;
import java.util.List;

// Referenced classes of package com.offerup.android.g.c:
//            b

public abstract class a extends Fragment
{

    b a;

    public a()
    {
    }

    void a()
    {
        b();
        List list = i();
        if (list.size() > 0)
        {
            a(list);
            return;
        } else
        {
            a.a();
            return;
        }
    }

    abstract void a(Bundle bundle);

    abstract void a(View view);

    abstract void a(List list);

    abstract void b();

    abstract void b(Bundle bundle);

    abstract void c();

    abstract String d();

    abstract int e();

    abstract int f();

    abstract int g();

    abstract int h();

    abstract List i();

    abstract Object j();

    public void onAttach(Context context)
    {
        super.onAttach(context);
        a = (b)context;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            b(getArguments());
            return;
        } else
        {
            b(bundle);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(g(), viewgroup, false);
        if (bundle == null)
        {
            b(getArguments());
        } else
        {
            b(bundle);
        }
        a(layoutinflater);
        ((TextView)layoutinflater.findViewById(0x7f10024e)).setText(e());
        viewgroup = (Button)layoutinflater.findViewById(0x7f1002ac);
        viewgroup.setOnClickListener(new com.offerup.android.g.c.b(this));
        viewgroup.setText(f());
        ((ImageView)layoutinflater.findViewById(0x7f1002ad)).setImageDrawable(android.support.v4.b.a.a(getActivity().getApplicationContext(), h()));
        c();
        return layoutinflater;
    }

    public void onPause()
    {
        b();
        a(getArguments());
        com.offerup.android.b.a.getInstance().post(j());
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        com.offerup.android.tracker.a.a(d());
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        a(bundle);
        super.onSaveInstanceState(bundle);
    }

    public void onViewStateRestored(Bundle bundle)
    {
        super.onViewStateRestored(bundle);
        if (bundle != null)
        {
            b(bundle);
        }
        c();
    }
}
