// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.android.bitmapfun.util;

import aaj;
import aeh;
import aei;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import asp;
import gr;
import zu;

// Referenced classes of package com.example.android.bitmapfun.util:
//            ImageDetailActivity

public class ImageDetailFragment extends Fragment
{

    private asp a;
    private ImageView b;
    private zu c;
    private gr d;

    public ImageDetailFragment()
    {
    }

    public static ImageDetailFragment a(String s)
    {
        ImageDetailFragment imagedetailfragment = new ImageDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("extra_image_data", s);
        imagedetailfragment.setArguments(bundle);
        return imagedetailfragment;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (com/example/android/bitmapfun/util/ImageDetailActivity.isInstance(getActivity()))
        {
            c = ((ImageDetailActivity)getActivity()).b();
            c.a(a, b);
        }
        if (android/view/View$OnClickListener.isInstance(getActivity()) && aaj.c())
        {
            b.setOnClickListener((android.view.View.OnClickListener)getActivity());
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            d = (gr)activity;
            return;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement ImageDetailFragmentCallback").toString());
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getArguments() != null)
        {
            bundle = getArguments().getString("extra_image_data");
        } else
        {
            bundle = null;
        }
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        a = d.a(bundle);
        return;
        bundle;
        bundle.printStackTrace();
        return;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(aei.image_detail_fragment, viewgroup, false);
        b = (ImageView)layoutinflater.findViewById(aeh.imageView);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (b != null)
        {
            zu.a(b);
            b.setImageDrawable(null);
        }
    }
}
