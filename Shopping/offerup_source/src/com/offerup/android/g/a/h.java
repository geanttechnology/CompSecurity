// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.offerup.android.b.a;
import com.offerup.android.dto.Item;
import com.squareup.otto.Bus;

// Referenced classes of package com.offerup.android.g.a:
//            i

public abstract class h extends Fragment
{

    protected Item a;
    private boolean b;
    private Object c;
    private boolean d;

    public h()
    {
        c = new i(this);
        com.offerup.android.b.a.getInstance().register(c);
    }

    private boolean a()
    {
        return a != null && b && isResumed();
    }

    static boolean a(h h1)
    {
        return h1.a();
    }

    static boolean a(h h1, boolean flag)
    {
        h1.d = flag;
        return flag;
    }

    protected abstract void a(Item item);

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        b = true;
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public void onDetach()
    {
        com.offerup.android.b.a.getInstance().unregister(c);
        b = false;
        super.onDetach();
    }

    public void onResume()
    {
        super.onResume();
        if (!d && a())
        {
            a(a);
        }
    }
}
