// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.p;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.offerup.android.tracker.a;
import com.offerup.android.utils.ay;

// Referenced classes of package com.offerup.android.g:
//            af, ak, al, am, 
//            ao, ap, aq, ar, 
//            as, ag, ai, aj

public final class ae extends p
{

    private View a;
    private View b;
    private View c;
    private View d;
    private View e;
    private ImageView f;
    private ay g;
    private Uri h;

    public ae()
    {
    }

    static ay a(ae ae1)
    {
        return ae1.g;
    }

    static Uri b(ae ae1)
    {
        return ae1.h;
    }

    public final void onAttach(Context context)
    {
        super.onAttach(context);
        g = new ay(getActivity());
        context = getArguments();
        if (context != null)
        {
            h = (Uri)context.getParcelable("uri");
            return;
        } else
        {
            com.offerup.android.tracker.a.a("invitemodal");
            return;
        }
    }

    public final Dialog onCreateDialog(Bundle bundle)
    {
        bundle = super.onCreateDialog(bundle);
        bundle.getWindow().requestFeature(1);
        bundle.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setStyle(2, 0x7f0c00f4);
        return bundle;
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        int i;
        if (h == null)
        {
            i = 0x7f040081;
        } else
        {
            i = 0x7f040090;
        }
        layoutinflater = layoutinflater.inflate(i, viewgroup, false);
        a = layoutinflater.findViewById(0x7f100157);
        b = layoutinflater.findViewById(0x7f100158);
        c = layoutinflater.findViewById(0x7f100159);
        d = layoutinflater.findViewById(0x7f10015a);
        e = layoutinflater.findViewById(0x7f10015b);
        f = (ImageView)layoutinflater.findViewById(0x7f1001dd);
        if (h == null)
        {
            a.setOnClickListener(new af(this));
            b.setOnClickListener(new ak(this));
            c.setOnClickListener(new al(this));
            d.setOnClickListener(new am(this));
            e.setOnClickListener(new ao(this));
            f.setOnClickListener(new ap(this));
            return layoutinflater;
        } else
        {
            a.setOnClickListener(new aq(this));
            b.setOnClickListener(new ar(this));
            c.setOnClickListener(new as(this));
            d.setOnClickListener(new ag(this));
            e.setOnClickListener(new ai(this));
            f.setOnClickListener(new aj(this));
            return layoutinflater;
        }
    }
}
