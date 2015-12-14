// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
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
import fo;
import fq;
import java.util.ArrayList;
import mt;
import nl;

// Referenced classes of package com.fotoable.photoselector.ui:
//            BasicMediaStorePhotoFragment

public abstract class MediaStoreGridFragment extends BasicMediaStorePhotoFragment
    implements android.widget.AdapterView.OnItemClickListener
{

    public GroupGridAdapter b;
    public ArrayList c;
    private int d;
    private int e;
    private fq f;
    private fq g;

    public MediaStoreGridFragment()
    {
        c = new ArrayList(20);
        g = null;
    }

    static int a(MediaStoreGridFragment mediastoregridfragment)
    {
        return mediastoregridfragment.d;
    }

    private fq a()
    {
        if (g == null)
        {
            fo fo1 = new fo(getActivity().getApplicationContext(), ImageCache.b);
            fo1.g = true;
            fo1.a(0.05F);
            g = new mt(getActivity(), b());
            g.b(com.fotoable.fotophotoselector.R.drawable.empty_photo);
            g.a(getActivity().getSupportFragmentManager(), fo1);
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
        return getActivity().getResources().getDimensionPixelSize(com.fotoable.fotophotoselector.R.dimen.encrypt_image_thumbnail_size);
    }

    static int b(MediaStoreGridFragment mediastoregridfragment)
    {
        return mediastoregridfragment.e;
    }

    public abstract void a(nl nl1);

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
        e = getResources().getDimensionPixelSize(com.fotoable.fotophotoselector.R.dimen.encrypt_image_thumbnail_spacing);
        b = new GroupGridAdapter(getActivity(), c, f);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(com.fotoable.fotophotoselector.R.layout.encrypt_image_grid_fragment, viewgroup, false);
        viewgroup = (GridView)layoutinflater.findViewById(com.fotoable.fotophotoselector.R.id.encrypt_gridView);
        viewgroup.setAdapter(b);
        viewgroup.setOnItemClickListener(this);
        viewgroup.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(viewgroup) {

            final GridView a;
            final MediaStoreGridFragment b;

            public void onGlobalLayout()
            {
                if (b.b.getNumColumns() == 0)
                {
                    int i = (int)Math.floor(a.getWidth() / (MediaStoreGridFragment.a(b) + MediaStoreGridFragment.b(b)));
                    if (i > 0)
                    {
                        int j = a.getWidth() / i;
                        int k = MediaStoreGridFragment.b(b);
                        b.b.setNumColumns(i);
                        b.b.setItemHeight(j - k);
                        Log.d("MultiPhotoSelectorFragment", (new StringBuilder()).append("onCreateView - numColumns set to ").append(i).toString());
                    }
                }
            }

            
            {
                b = MediaStoreGridFragment.this;
                a = gridview;
                super();
            }
        });
        return layoutinflater;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        while (c == null || c.size() < i + 1 || !(c.get(i) instanceof nl)) 
        {
            return;
        }
        a((nl)c.get(i));
    }
}
