// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.activity.photoselector;

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
import com.fotoable.comlib.util.ImageCache;
import com.fotoable.photoselector.model.GroupGridAdapter;
import com.pipcamera.application.PIPCameraApplication;
import fo;
import fq;
import java.util.ArrayList;
import la;
import ln;
import mt;
import nl;
import nw;

public class PhotoSelectorGridFragment extends Fragment
    implements android.widget.AdapterView.OnItemClickListener
{

    protected GroupGridAdapter a;
    protected ArrayList b;
    private int c;
    private int d;
    private fq e;
    private fq f;
    private ln g;

    public PhotoSelectorGridFragment()
    {
        f = null;
    }

    static int a(PhotoSelectorGridFragment photoselectorgridfragment)
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

    static int b(PhotoSelectorGridFragment photoselectorgridfragment)
    {
        return photoselectorgridfragment.d;
    }

    private fq b()
    {
        if (f == null)
        {
            fo fo1 = new fo(getActivity().getApplicationContext(), ImageCache.b);
            fo1.a(0.25F);
            fo1.g = true;
            f = new mt(getActivity(), c());
            f.b(0x7f0200f7);
            if (nw.a(getActivity()))
            {
                f.a(getActivity().getSupportFragmentManager(), fo1);
            }
        }
        return f;
    }

    private int c()
    {
        return getActivity().getResources().getDimensionPixelSize(0x7f08003e);
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
            g = (ln)activity;
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
        if (la.c(PIPCameraApplication.a, "isNewphotoAlbumStyle", "needRefresh") && !la.c(PIPCameraApplication.a, "isNewphotoAlbumStyle", "hasClearCache"))
        {
            e.h();
            la.a(PIPCameraApplication.a, "isNewphotoAlbumStyle", "hasClearCache", true);
        }
        d = getResources().getDimensionPixelSize(0x7f08003f);
        b = g.a(getTag());
        a = new GroupGridAdapter(getActivity(), b, e);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Log.d("PhotoSelectorGridFragment", "onCreateView");
        layoutinflater = layoutinflater.inflate(0x7f03003a, viewgroup, false);
        viewgroup = (GridView)layoutinflater.findViewById(0x7f0c0125);
        viewgroup.setAdapter(a);
        viewgroup.setOnItemClickListener(this);
        viewgroup.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(viewgroup) {

            final GridView a;
            final PhotoSelectorGridFragment b;

            public void onGlobalLayout()
            {
                if (b.a.getNumColumns() == 0)
                {
                    int i = (int)Math.floor(a.getWidth() / (PhotoSelectorGridFragment.a(b) + PhotoSelectorGridFragment.b(b)));
                    if (i > 0)
                    {
                        int j = a.getWidth() / i;
                        int k = PhotoSelectorGridFragment.b(b);
                        b.a.setNumColumns(i);
                        b.a.setItemHeight(j - k);
                        Log.d("PhotoSelectorGridFragment", (new StringBuilder()).append("onCreateView - numColumns set to ").append(i).toString());
                    }
                }
            }

            
            {
                b = PhotoSelectorGridFragment.this;
                a = gridview;
                super();
            }
        });
        return layoutinflater;
    }

    public void onDestroy()
    {
        a();
        super.onDestroy();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        while (b == null || b.size() < i + 1 || !(b.get(i) instanceof nl) || g == null) 
        {
            return;
        }
        g.a(getTag(), (nl)b.get(i));
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
