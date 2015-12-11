// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.d;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.b.a.a.g;
import com.offerup.android.activities.RatingActivity;
import com.offerup.android.dto.Item;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

// Referenced classes of package com.offerup.android.g.d:
//            b, c

public final class a extends Fragment
{

    private ImageView a;
    private TextView b;
    private Button c;
    private c d;
    private View e;
    private Item f;

    public a()
    {
    }

    static c a(a a1)
    {
        return a1.d;
    }

    public final void a(Item item)
    {
        f = item;
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            d = (RatingActivity)activity;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            g.c(getClass().getSimpleName(), (new StringBuilder()).append(getClass().getSimpleName()).append(" must implement OnWrongItemButtonSelectedListener").toString());
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        e = layoutinflater.inflate(0x7f04009b, viewgroup, false);
        a = (ImageView)e.findViewById(0x7f100270);
        b = (TextView)e.findViewById(0x7f100271);
        c = (Button)e.findViewById(0x7f100272);
        return e;
    }

    public final void onDetach()
    {
        super.onDetach();
        d = null;
    }

    public final void onResume()
    {
        super.onResume();
        Item item = f;
        if (item != null)
        {
            e.setVisibility(0);
            b.setText(item.getTitle());
            Picasso.with(getActivity().getApplicationContext()).load(item.getGetImgPermalinkMedium()).into(a);
            c.setOnClickListener(new b(this));
        }
    }
}
