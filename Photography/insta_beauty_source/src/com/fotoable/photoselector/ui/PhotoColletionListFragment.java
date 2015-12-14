// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.ui;

import aef;
import aeg;
import aeh;
import aei;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import aqy;
import asm;
import asn;
import atc;
import com.fotoable.comlib.util.ImageCache;
import zr;
import zt;

public class PhotoColletionListFragment extends Fragment
    implements android.widget.AdapterView.OnItemClickListener
{

    private asn a;
    private asm b;
    private zt c;
    private zt d;
    private int e;
    private int f;
    private String g;

    public PhotoColletionListFragment()
    {
        d = null;
        g = "foldercache";
    }

    public static PhotoColletionListFragment a(String s)
    {
        PhotoColletionListFragment photocolletionlistfragment = new PhotoColletionListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tag", s);
        photocolletionlistfragment.setArguments(bundle);
        return photocolletionlistfragment;
    }

    private zt a()
    {
        if (d == null)
        {
            zr zr1 = new zr(getActivity().getApplicationContext(), ImageCache.b);
            zr1.d = android.graphics.Bitmap.CompressFormat.JPEG;
            zr1.e = 50;
            zr1.a(0.05F);
            d = new aqy(getActivity(), b());
            d.b(aeg.empty_photo);
            if (atc.a(getActivity()))
            {
                d.a(getActivity().getSupportFragmentManager(), zr1);
            }
        }
        return d;
    }

    public static zt a(PhotoColletionListFragment photocolletionlistfragment)
    {
        return photocolletionlistfragment.c;
    }

    public static void a(Context context, String s, String s1, boolean flag)
    {
        context = context.getSharedPreferences(s, 0).edit();
        context.putBoolean(s1, flag);
        context.apply();
    }

    public static boolean a(Context context, String s, String s1)
    {
        return context.getSharedPreferences(s, 0).getBoolean(s1, false);
    }

    private int b()
    {
        return getActivity().getResources().getDimensionPixelSize(aef.encrypt_image_thumbnail_size);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        Log.d("PhotoColletionListFragment", "onAttach");
        try
        {
            a = (asn)activity;
            return;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement OnArticleSelectedListener").toString());
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Log.d("PhotoColletionListFragment", "onCreate");
        e = b();
        c = a();
        if (a(getActivity().getApplicationContext(), "isNewphotoAlbumStyle", "needRefresh") && !a(getActivity().getApplicationContext(), "isNewphotoAlbumStyle", "hasClearCache"))
        {
            c.h();
            a(getActivity().getApplicationContext(), "isNewphotoAlbumStyle", "hasClearCache", true);
        }
        b = new asm(this, getActivity(), null, c);
        b.a(a.b(getTag()));
        f = getResources().getDimensionPixelSize(aef.encrypt_image_thumbnail_spacing);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Log.d("PhotoColletionListFragment", "onCreateView");
        layoutinflater = layoutinflater.inflate(aei.view_photocollectionlist, viewgroup, false);
        viewgroup = (ListView)layoutinflater.findViewById(aeh.photocollectionlistview);
        viewgroup.setAdapter(b);
        viewgroup.setOnItemClickListener(this);
        return layoutinflater;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (a != null)
        {
            a.a(getTag(), b.getItem(i));
        }
    }

    public void onPause()
    {
        Log.d("PhotoColletionListFragment", "onPause");
        super.onPause();
        c.a(true);
    }

    public void onResume()
    {
        Log.d("PhotoColletionListFragment", "onResume");
        super.onResume();
        c.a(false);
        b.notifyDataSetChanged();
    }
}
