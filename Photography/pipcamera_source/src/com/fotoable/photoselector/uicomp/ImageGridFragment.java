// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.uicomp;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.GridView;
import com.fotoable.photoselector.model.GroupGridAdapter;
import fq;
import nq;
import nv;

public class ImageGridFragment extends Fragment
    implements android.widget.AdapterView.OnItemClickListener
{

    protected fq a;
    protected nv b;
    private int c;
    private int d;
    private GroupGridAdapter e;

    public ImageGridFragment()
    {
    }

    static GroupGridAdapter a(ImageGridFragment imagegridfragment)
    {
        return imagegridfragment.e;
    }

    static int b(ImageGridFragment imagegridfragment)
    {
        return imagegridfragment.c;
    }

    static int c(ImageGridFragment imagegridfragment)
    {
        return imagegridfragment.d;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            String s = getArguments().getString("instanceid");
            b = ((nq)activity).a(s);
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
        d = getResources().getDimensionPixelSize(com.fotoable.fotophotoselector.R.dimen.encrypt_image_thumbnail_spacing);
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
        layoutinflater = layoutinflater.inflate(com.fotoable.fotophotoselector.R.layout.encrypt_image_grid_fragment, viewgroup, false);
        viewgroup = (GridView)layoutinflater.findViewById(com.fotoable.fotophotoselector.R.id.encrypt_gridView);
        viewgroup.setAdapter(e);
        viewgroup.setOnItemClickListener(this);
        viewgroup.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(viewgroup) {

            final GridView a;
            final ImageGridFragment b;

            public void onGlobalLayout()
            {
                if (ImageGridFragment.a(b).getNumColumns() == 0)
                {
                    int i = (int)Math.floor(a.getWidth() / (ImageGridFragment.b(b) + ImageGridFragment.c(b)));
                    if (i > 0)
                    {
                        int j = a.getWidth() / i;
                        int k = ImageGridFragment.c(b);
                        ImageGridFragment.a(b).setNumColumns(i);
                        ImageGridFragment.a(b).setItemHeight(j - k);
                        Log.d("ImageGridFragment", (new StringBuilder()).append("onCreateView - numColumns set to ").append(i).toString());
                    }
                }
            }

            
            {
                b = ImageGridFragment.this;
                a = gridview;
                super();
            }
        });
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
