// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.d;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.t;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.offerup.android.dto.FollowProfile;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.Person;
import com.offerup.android.utils.ba;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

// Referenced classes of package com.offerup.android.g.d:
//            e

public final class d extends Fragment
{

    private RatingBar a;
    private TextView b;
    private ImageView c;
    private CardView d;
    private Item e;
    private Person f;

    public d()
    {
    }

    static void a(d d1)
    {
        d1.d.setVisibility(8);
    }

    static TextView b(d d1)
    {
        return d1.b;
    }

    public final int a()
    {
        if (a == null || a.getRating() == 0.0F)
        {
            d.setVisibility(0);
            return 0;
        } else
        {
            return Math.round(a.getRating());
        }
    }

    public final void a(Item item, Person person)
    {
        e = item;
        f = person;
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f04009c, viewgroup, false);
        viewgroup = getResources().getStringArray(0x7f0f0004);
        a = (RatingBar)layoutinflater.findViewById(0x7f100276);
        b = (TextView)layoutinflater.findViewById(0x7f100274);
        c = (ImageView)layoutinflater.findViewById(0x7f100273);
        d = (CardView)layoutinflater.findViewById(0x7f100279);
        a.setOnRatingBarChangeListener(new e(this, viewgroup));
        return layoutinflater;
    }

    public final void onResume()
    {
        super.onResume();
        Item item = e;
        Person person = f;
        Person person1 = item.getOwner();
        if (ba.a(item) && person != null)
        {
            b.setText(String.format(getString(0x7f0901d1), new Object[] {
                person.getFirstName()
            }));
            Picasso.with(getActivity().getApplicationContext()).load(person.getGetProfile().getAvatarNormal()).into(c);
            return;
        } else
        {
            b.setText(String.format(getString(0x7f0901cb), new Object[] {
                person1.getFirstName()
            }));
            Picasso.with(getActivity().getApplicationContext()).load(person1.getGetProfile().getAvatarNormal()).into(c);
            return;
        }
    }
}
