// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.b.a.a.g;
import com.offerup.android.dto.FollowProfile;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.Person;
import com.offerup.android.dto.Rating;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

// Referenced classes of package com.offerup.android.g.a:
//            h, ai, ah

public final class ag extends h
{

    private ai b;
    private Context c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private RatingBar g;
    private LinearLayout h;
    private Person i;

    public ag()
    {
    }

    static Person a(ag ag1)
    {
        return ag1.i;
    }

    public static ag a()
    {
        return new ag();
    }

    static ai b(ag ag1)
    {
        return ag1.b;
    }

    protected final void a(Item item)
    {
        if (item != null && item.getOwner() != null)
        {
            i = item.getOwner();
            Picasso.with(c).load(i.getGetProfile().getAvatarNormal()).placeholder(getResources().getDrawable(0x7f0201bd)).into(d);
            e.setText(i.getFirstName());
            if (i.getGetProfile() != null && i.getGetProfile().isVerifiedUser())
            {
                item = getResources().getDrawable(0x7f020154);
                int j = item.getIntrinsicHeight();
                item.setBounds(0, 0, item.getIntrinsicWidth(), j);
                e.setTextColor(getResources().getColor(0x7f0e0125));
                e.setCompoundDrawables(item, null, null, null);
            }
            item = i.getGetProfile().getRating();
            if (item != null && item.getCount() != 0)
            {
                g.setRating(item.getAverage());
                f.setText(String.format("(%d)", new Object[] {
                    Integer.valueOf(item.getCount())
                }));
                h.setVisibility(0);
            }
            return;
        } else
        {
            com.b.a.a.g.c(getClass().getSimpleName(), String.format("Unable to update %s with null item", new Object[] {
                getClass().getSimpleName()
            }));
            return;
        }
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            b = (ai)activity;
            return;
        }
        catch (Exception exception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement ProfileFragmentListener").toString());
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f04008e, viewgroup, false);
        c = getActivity().getApplicationContext();
        h = (LinearLayout)layoutinflater.findViewById(0x7f100219);
        d = (ImageView)layoutinflater.findViewById(0x7f100217);
        e = (TextView)layoutinflater.findViewById(0x7f100218);
        f = (TextView)layoutinflater.findViewById(0x7f10021b);
        g = (RatingBar)layoutinflater.findViewById(0x7f10021a);
        layoutinflater.setOnClickListener(new ah(this));
        return layoutinflater;
    }

    public final void onDetach()
    {
        b = null;
        super.onDetach();
    }
}
