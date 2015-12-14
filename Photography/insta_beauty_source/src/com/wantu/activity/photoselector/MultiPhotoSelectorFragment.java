// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.photoselector;

import android.os.Bundle;
import aso;
import com.fotoable.photoselector.MediaStorePhotosDB;
import com.fotoable.photoselector.model.GroupGridAdapter;
import com.fotoable.photoselector.ui.MediaStoreGridFragment;
import java.util.ArrayList;

public class MultiPhotoSelectorFragment extends MediaStoreGridFragment
    implements android.widget.AdapterView.OnItemClickListener
{

    private final ArrayList d = new ArrayList(20);

    public MultiPhotoSelectorFragment()
    {
    }

    public static MultiPhotoSelectorFragment a(String s)
    {
        MultiPhotoSelectorFragment multiphotoselectorfragment = new MultiPhotoSelectorFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tag", s);
        multiphotoselectorfragment.setArguments(bundle);
        return multiphotoselectorfragment;
    }

    public final ArrayList a()
    {
        return d;
    }

    protected void a(aso aso1)
    {
        if (d.size() <= 30)
        {
            if (d.remove(aso1))
            {
                aso1.f();
                int i = 0;
                while (i < d.size()) 
                {
                    ((aso)d.get(i)).a(i + 1);
                    i++;
                }
            } else
            {
                d.add(aso1);
                aso1.a(d.size());
                return;
            }
        }
    }

    public void b(boolean flag)
    {
        c = MediaStorePhotosDB.a().a(com.fotoable.photoselector.MediaStorePhotosDB.MediaSortMode.MediaSortMode_Date);
        b.setFileList(c);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        setHasOptionsMenu(true);
    }

    public void onPause()
    {
        super.onPause();
        for (int i = 0; i < d.size(); i++)
        {
            ((aso)d.get(i)).f();
        }

    }
}
