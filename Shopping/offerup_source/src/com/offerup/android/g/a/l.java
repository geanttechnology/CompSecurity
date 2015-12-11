// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.b.a.a.g;
import com.offerup.android.dto.Image;
import com.offerup.android.dto.ImageCollection;
import com.offerup.android.dto.Photo;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import uk.co.senab.photoview.PhotoViewAttacher;

// Referenced classes of package com.offerup.android.g.a:
//            o, m, n

public final class l extends Fragment
{

    private ImageView a;
    private PhotoViewAttacher b;
    private uk.co.senab.photoview.PhotoViewAttacher.OnFlingListener c;
    private o d;
    private uk.co.senab.photoview.PhotoViewAttacher.OnPhotoTapListener e;
    private Photo f;
    private View g;
    private ProgressBar h;
    private int i;

    public l()
    {
    }

    public static l a(int j, Photo photo)
    {
        if (photo == null || j < 0)
        {
            return null;
        } else
        {
            Bundle bundle = new Bundle();
            bundle.putInt("photo_index", j);
            bundle.putParcelable("photo", photo);
            photo = new l();
            photo.setArguments(bundle);
            return photo;
        }
    }

    static PhotoViewAttacher a(l l1)
    {
        return l1.b;
    }

    private void a()
    {
        h.setVisibility(4);
        g.setVisibility(0);
        a.setVisibility(4);
    }

    private void a(Bundle bundle)
    {
        i = bundle.getInt("photo_index");
        if (bundle.containsKey("photo"))
        {
            f = (Photo)bundle.getParcelable("photo");
            return;
        } else
        {
            f = null;
            return;
        }
    }

    static o b(l l1)
    {
        return l1.d;
    }

    static void c(l l1)
    {
        l1.h.setVisibility(4);
        l1.g.setVisibility(4);
        l1.a.setVisibility(0);
    }

    static void d(l l1)
    {
        l1.a();
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            c = (uk.co.senab.photoview.PhotoViewAttacher.OnFlingListener)activity;
        }
        catch (ClassCastException classcastexception)
        {
            com.b.a.a.g.a(this, classcastexception);
        }
        try
        {
            d = (o)activity;
        }
        catch (ClassCastException classcastexception1)
        {
            com.b.a.a.g.a(this, classcastexception1);
        }
        try
        {
            e = (uk.co.senab.photoview.PhotoViewAttacher.OnPhotoTapListener)activity;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            com.b.a.a.g.a(this, activity);
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (bundle == null)
        {
            a(getArguments());
        } else
        {
            a(bundle);
        }
        layoutinflater = layoutinflater.inflate(0x7f040087, viewgroup, false);
        h = (ProgressBar)layoutinflater.findViewById(0x7f1001f7);
        g = layoutinflater.findViewById(0x7f1001f8);
        a = (ImageView)layoutinflater.findViewById(0x7f10006a);
        b = new PhotoViewAttacher(a);
        viewgroup = b;
        viewgroup.setOnFlingListener(c);
        viewgroup.setOnMatrixChangeListener(new m(this));
        viewgroup.setOnPhotoTapListener(e);
        viewgroup.setMinimumScale(1.0F);
        viewgroup.setMediumScale(3F);
        viewgroup.setMaximumScale(3F);
        viewgroup.setAllowParentInterceptOnEdge(false);
        return layoutinflater;
    }

    public final void onDetach()
    {
        c = null;
        d = null;
        e = null;
        super.onDetach();
    }

    public final void onResume()
    {
        super.onResume();
        Object obj = f;
        if (obj != null && ((Photo) (obj)).getImages() != null && ((Photo) (obj)).getImages().getDetail() != null && ((Photo) (obj)).getImages().getDetailFull() != null)
        {
            obj = ((Photo) (obj)).getImages().getDetailFull().getUri();
            if (getActivity() == null)
            {
                a();
                com.b.a.a.g.a(this, new Exception("AD-1534 fragment tried to load image before activity is attached"));
            }
            h.setVisibility(0);
            g.setVisibility(4);
            a.setVisibility(4);
            Picasso.with(getActivity().getApplicationContext()).load(((android.net.Uri) (obj))).into(a, new n(this));
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("photo_index", i);
        if (f != null)
        {
            bundle.putParcelable("photo", f);
        } else
        {
            bundle.remove("photo");
        }
        super.onSaveInstanceState(bundle);
    }

    public final void onViewStateRestored(Bundle bundle)
    {
        super.onViewStateRestored(bundle);
        if (bundle == null)
        {
            a(getArguments());
            return;
        } else
        {
            a(bundle);
            return;
        }
    }
}
