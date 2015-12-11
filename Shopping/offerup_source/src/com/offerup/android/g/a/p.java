// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.t;
import android.support.v4.b.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.offerup.android.dto.Photo;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

// Referenced classes of package com.offerup.android.g.a:
//            s, q, r, ae

public final class p extends Fragment
{

    private ImageView a;
    private View b;
    private ImageView c;
    private ProgressBar d;
    private ae e;
    private Photo f;

    public p()
    {
    }

    static ImageView a(p p1)
    {
        return p1.a;
    }

    public static p a(ae ae, int i, Photo photo)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("photo", photo);
        bundle.putInt("photo_index", i);
        photo = new p();
        photo.setArguments(bundle);
        photo.e = ae;
        return photo;
    }

    private void a(Bundle bundle)
    {
        if (bundle != null)
        {
            f = (Photo)bundle.getParcelable("photo");
        } else
        {
            f = (Photo)getArguments().getParcelable("photo");
        }
        if (f != null)
        {
            d.setVisibility(0);
            b.setVisibility(4);
            bundle = new ColorDrawable(android.support.v4.b.a.b(getActivity(), 0x7f0e00ba));
            Picasso.with(getActivity().getApplicationContext()).load(f.getDetailUri()).placeholder(bundle).into(a, new s(this));
            return;
        } else
        {
            d.setVisibility(8);
            b.setVisibility(0);
            return;
        }
    }

    static ae b(p p1)
    {
        return p1.e;
    }

    static Photo c(p p1)
    {
        return p1.f;
    }

    static ProgressBar d(p p1)
    {
        return p1.d;
    }

    static View e(p p1)
    {
        return p1.b;
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f04008b, viewgroup, false);
        b = layoutinflater.findViewById(0x7f1001f8);
        d = (ProgressBar)layoutinflater.findViewById(0x7f1001f7);
        c = (ImageView)layoutinflater.findViewById(0x7f100207);
        a = (ImageView)layoutinflater.findViewById(0x7f100206);
        c.setOnClickListener(new q(this));
        a.setOnClickListener(new r(this));
        a(bundle);
        return layoutinflater;
    }

    public final void onDestroy()
    {
        e = null;
        super.onDestroy();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable("photo", f);
        super.onSaveInstanceState(bundle);
    }

    public final void onViewStateRestored(Bundle bundle)
    {
        super.onViewStateRestored(bundle);
        a(bundle);
    }
}
