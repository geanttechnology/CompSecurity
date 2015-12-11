// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.os.Bundle;
import android.support.v4.app.aa;
import android.support.v4.app.an;
import android.support.v4.app.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.offerup.android.dto.Item;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.g.a:
//            h

public final class k extends h
{

    private TextView b;

    public k()
    {
    }

    public static k a()
    {
        return new k();
    }

    protected final void a(Item item)
    {
        if (StringUtils.isEmpty(item.getDescription()))
        {
            getActivity().getSupportFragmentManager().a().b(this).b();
            return;
        } else
        {
            getActivity().getSupportFragmentManager().a().c(this).b();
            item = item.getDescription();
            b.setText(item);
            return;
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f04008a, viewgroup, false);
        b = (TextView)layoutinflater.findViewById(0x7f100205);
        return layoutinflater;
    }
}
