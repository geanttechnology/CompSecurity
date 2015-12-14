// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.ui;

import aef;
import aeg;
import aeh;
import aei;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.GridView;
import aqy;
import asl;
import aso;
import com.fotoable.comlib.util.ImageCache;
import com.fotoable.photoselector.model.GroupGridAdapter;
import java.util.ArrayList;
import zr;
import zt;

// Referenced classes of package com.fotoable.photoselector.ui:
//            BasicMediaStorePhotoFragment

public abstract class MediaStoreGridFragment extends BasicMediaStorePhotoFragment
    implements android.widget.AdapterView.OnItemClickListener
{

    public GroupGridAdapter b;
    public ArrayList c;
    private int d;
    private int e;
    private zt f;
    private zt g;

    public MediaStoreGridFragment()
    {
        c = new ArrayList(20);
        g = null;
    }

    public static int a(MediaStoreGridFragment mediastoregridfragment)
    {
        return mediastoregridfragment.d;
    }

    private zt a()
    {
        if (g == null)
        {
            zr zr1 = new zr(getActivity().getApplicationContext(), ImageCache.b);
            zr1.g = true;
            zr1.a(0.05F);
            g = new aqy(getActivity(), b());
            g.b(aeg.empty_photo);
            g.a(getActivity().getSupportFragmentManager(), zr1);
        }
        return g;
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

    public static int b(MediaStoreGridFragment mediastoregridfragment)
    {
        return mediastoregridfragment.e;
    }

    public abstract void a(aso aso1);

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        d = b();
        f = a();
        if (a(getActivity().getApplicationContext(), "isNewphotoAlbumStyle", "needRefresh") && !a(getActivity().getApplicationContext(), "isNewphotoAlbumStyle", "hasClearCache"))
        {
            f.h();
            a(getActivity().getApplicationContext(), "isNewphotoAlbumStyle", "hasClearCache", true);
        }
        e = getResources().getDimensionPixelSize(aef.encrypt_image_thumbnail_spacing);
        b = new GroupGridAdapter(getActivity(), c, f);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(aei.encrypt_image_grid_fragment, viewgroup, false);
        viewgroup = (GridView)layoutinflater.findViewById(aeh.encrypt_gridView);
        viewgroup.setAdapter(b);
        viewgroup.setOnItemClickListener(this);
        viewgroup.getViewTreeObserver().addOnGlobalLayoutListener(new asl(this, viewgroup));
        return layoutinflater;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        while (c == null || c.size() < i + 1 || !(c.get(i) instanceof aso)) 
        {
            return;
        }
        a((aso)c.get(i));
    }
}
