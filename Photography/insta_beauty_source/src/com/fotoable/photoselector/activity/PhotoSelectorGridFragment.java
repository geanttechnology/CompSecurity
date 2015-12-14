// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.activity;

import aef;
import aeg;
import aeh;
import aei;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.GridView;
import aqy;
import ase;
import asf;
import aso;
import atc;
import com.fotoable.comlib.util.ImageCache;
import com.fotoable.photoselector.model.GroupGridAdapter;
import java.util.ArrayList;
import zr;
import zt;

public class PhotoSelectorGridFragment extends Fragment
    implements android.widget.AdapterView.OnItemClickListener
{

    public GroupGridAdapter a;
    protected ArrayList b;
    private int c;
    private int d;
    private zt e;
    private zt f;
    private asf g;

    public PhotoSelectorGridFragment()
    {
        f = null;
    }

    public static int a(PhotoSelectorGridFragment photoselectorgridfragment)
    {
        return photoselectorgridfragment.c;
    }

    public static PhotoSelectorGridFragment a(String s)
    {
        PhotoSelectorGridFragment photoselectorgridfragment = new PhotoSelectorGridFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tag", s);
        photoselectorgridfragment.setArguments(bundle);
        return photoselectorgridfragment;
    }

    public static int b(PhotoSelectorGridFragment photoselectorgridfragment)
    {
        return photoselectorgridfragment.d;
    }

    private zt b()
    {
        if (f == null)
        {
            zr zr1 = new zr(getActivity().getApplicationContext(), ImageCache.b);
            zr1.a(0.05F);
            zr1.g = true;
            f = new aqy(getActivity(), c());
            f.b(aeg.empty_photo);
            if (atc.a(getActivity()))
            {
                f.a(getActivity().getSupportFragmentManager(), zr1);
            }
        }
        return f;
    }

    private int c()
    {
        return getActivity().getResources().getDimensionPixelSize(aef.encrypt_image_thumbnail_size);
    }

    public void a()
    {
        if (a != null)
        {
            a.recycleImage();
        }
    }

    public void a(ArrayList arraylist)
    {
        a();
        b = arraylist;
        a.setFileList(b);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        Log.d("PhotoSelectorGridFragment", "onAttach");
        try
        {
            g = (asf)activity;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            Log.e("PhotoSelectScrollFragmentCallBack", "must implement PhotoSelectScrollFragmentCallBack");
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(false);
        c = c();
        e = b();
        d = getResources().getDimensionPixelSize(aef.encrypt_image_thumbnail_spacing);
        b = g.a(getTag());
        a = new GroupGridAdapter(getActivity(), b, e);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Log.d("PhotoSelectorGridFragment", "onCreateView");
        layoutinflater = layoutinflater.inflate(aei.encrypt_image_grid_fragment, viewgroup, false);
        viewgroup = (GridView)layoutinflater.findViewById(aeh.encrypt_gridView);
        viewgroup.setAdapter(a);
        viewgroup.setOnItemClickListener(this);
        viewgroup.getViewTreeObserver().addOnGlobalLayoutListener(new ase(this, viewgroup));
        return layoutinflater;
    }

    public void onDestroy()
    {
        a();
        super.onDestroy();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        while (b == null || b.size() < i + 1 || !(b.get(i) instanceof aso) || g == null) 
        {
            return;
        }
        g.a(getTag(), (aso)b.get(i));
    }

    public void onPause()
    {
        super.onPause();
        Log.d("PhotoSelectorGridFragment", "onPause");
        e.a(true);
    }

    public void onResume()
    {
        super.onResume();
        Log.d("PhotoSelectorGridFragment", "onResume");
        e.a(false);
    }
}
