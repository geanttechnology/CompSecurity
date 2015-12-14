// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.uicomp;

import aef;
import aeh;
import aei;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.GridView;
import asv;
import asw;
import atb;
import com.fotoable.photoselector.model.GroupGridAdapter;
import zt;

public class ImageGridFragment extends Fragment
    implements android.widget.AdapterView.OnItemClickListener
{

    protected zt a;
    protected atb b;
    private int c;
    private int d;
    private GroupGridAdapter e;

    public ImageGridFragment()
    {
    }

    public static GroupGridAdapter a(ImageGridFragment imagegridfragment)
    {
        return imagegridfragment.e;
    }

    public static int b(ImageGridFragment imagegridfragment)
    {
        return imagegridfragment.c;
    }

    public static int c(ImageGridFragment imagegridfragment)
    {
        return imagegridfragment.d;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            String s = getArguments().getString("instanceid");
            b = ((asv)activity).a(s);
            return;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement FragmentGetActivityCallback").toString());
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        d = getResources().getDimensionPixelSize(aef.encrypt_image_thumbnail_spacing);
        if (b != null)
        {
            c = b.c();
            a = b.a();
        }
        e = new GroupGridAdapter(getActivity(), b.b(), a);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(aei.encrypt_image_grid_fragment, viewgroup, false);
        viewgroup = (GridView)layoutinflater.findViewById(aeh.encrypt_gridView);
        viewgroup.setAdapter(e);
        viewgroup.setOnItemClickListener(this);
        viewgroup.getViewTreeObserver().addOnGlobalLayoutListener(new asw(this, viewgroup));
        return layoutinflater;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (b == null);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return super.onOptionsItemSelected(menuitem);
    }

    public void onPause()
    {
        super.onPause();
        a.a(true);
    }

    public void onResume()
    {
        super.onResume();
        a.a(false);
        e.notifyDataSetChanged();
    }
}
