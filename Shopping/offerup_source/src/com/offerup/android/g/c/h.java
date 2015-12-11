// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.offerup.android.activities.PostPostingHelpActivity;
import com.offerup.android.activities.a;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

// Referenced classes of package com.offerup.android.g.c:
//            i, j, k

public final class h extends Fragment
{

    private String a;
    private String b;
    private Uri c;
    private boolean d;
    private boolean e;
    private Button f;
    private Button g;
    private Button h;
    private TextView i;
    private a j;

    public h()
    {
    }

    public static h a(String s, String s1, Uri uri, boolean flag, boolean flag1)
    {
        h h1 = new h();
        Bundle bundle = new Bundle();
        h1.getClass();
        bundle.putBoolean("is_edit", flag1);
        h1.getClass();
        bundle.putString("url", s);
        h1.getClass();
        bundle.putBoolean("has_made_first_post", flag);
        if (uri != null)
        {
            h1.getClass();
            bundle.putParcelable("image_uri", uri);
        }
        h1.getClass();
        bundle.putString("title", s1);
        h1.setArguments(bundle);
        return h1;
    }

    private void a(Bundle bundle)
    {
        a = bundle.getString("url");
        d = bundle.getBoolean("has_made_first_post");
        b = bundle.getString("title");
        c = (Uri)bundle.getParcelable("image_uri");
        e = bundle.getBoolean("is_edit");
    }

    static boolean a(h h1)
    {
        return h1.e;
    }

    static a b(h h1)
    {
        return h1.j;
    }

    static String c(h h1)
    {
        return h1.a;
    }

    public final void onAttach(Context context)
    {
        super.onAttach(context);
        j = new a(getActivity());
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        if (bundle == null)
        {
            a(getArguments());
        } else
        {
            a(bundle);
        }
        layoutinflater = layoutinflater.inflate(0x7f040096, viewgroup, false);
        viewgroup = (ImageView)layoutinflater.findViewById(0x7f10006a);
        if (c != null)
        {
            Picasso.with(getActivity().getApplicationContext()).load(c).into(viewgroup);
        }
        i = (TextView)layoutinflater.findViewById(0x7f10006e);
        i.setText(b);
        f = (Button)layoutinflater.findViewById(0x7f100256);
        f.setOnClickListener(new i(this));
        g = (Button)layoutinflater.findViewById(0x7f100257);
        g.setOnClickListener(new j(this));
        h = (Button)layoutinflater.findViewById(0x7f1002af);
        h.setOnClickListener(new k(this));
        return layoutinflater;
    }

    public final void onDetach()
    {
        j = null;
        super.onDetach();
    }

    public final void onResume()
    {
        super.onResume();
        com.offerup.android.tracker.a.a("item_posted");
        if (!d)
        {
            d = true;
            startActivity(new Intent(getActivity(), com/offerup/android/activities/PostPostingHelpActivity));
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        bundle.putString("url", a);
        bundle.putBoolean("has_made_first_post", d);
        if (c != null)
        {
            bundle.putParcelable("image_uri", c);
        }
        bundle.putString("title", b);
        super.onSaveInstanceState(bundle);
    }

    public final void onViewStateRestored(Bundle bundle)
    {
        super.onViewStateRestored(bundle);
        if (bundle != null)
        {
            a(bundle);
        }
    }
}
