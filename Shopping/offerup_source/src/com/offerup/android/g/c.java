// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.b.a.a.g;
import com.offerup.android.dto.Sort;
import java.util.Iterator;
import java.util.List;

public abstract class c extends Fragment
{

    protected Context a;
    protected List b;
    protected Sort c;
    protected Sort d;
    private View e;

    public c()
    {
    }

    public abstract void a();

    protected abstract void a(View view);

    public final void a(List list)
    {
        c = null;
        d = null;
        try
        {
            b = list;
            list = b.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                Sort sort = (Sort)list.next();
                if (sort.isSelected() && c == null)
                {
                    c = sort;
                }
                if (sort.isDefaultValue() && d == null)
                {
                    d = sort;
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            g.a(com/offerup/android/g/c.getSimpleName(), list);
        }
        a(e);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        e = layoutinflater.inflate(0x7f04009f, viewgroup, false);
        a = getActivity().getApplicationContext();
        c = new Sort();
        return e;
    }
}
