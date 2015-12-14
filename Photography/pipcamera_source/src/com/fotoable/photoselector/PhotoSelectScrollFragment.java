// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import na;
import nb;
import nr;

// Referenced classes of package com.fotoable.photoselector:
//            PhotoSelectScrollView

public class PhotoSelectScrollFragment extends Fragment
    implements nb
{

    private PhotoSelectScrollView a;
    private na b;

    public PhotoSelectScrollFragment()
    {
    }

    static na a(PhotoSelectScrollFragment photoselectscrollfragment)
    {
        return photoselectscrollfragment.b;
    }

    public void a(Object obj)
    {
        if (b != null)
        {
            b.a(obj);
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        System.out.println("Fragment-->onAttach");
        try
        {
            b = (na)activity;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            Log.v("PhotoSelectScrollFragmentCallBack", "must implement PhotoSelectScrollFragmentCallBack");
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        System.out.println("Fragment-->onCreate");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        int i = 0;
        System.out.println("Fragment-->onCreateView");
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(com.fotoable.fotophotoselector.R.layout.photo_select_fragment_lib, viewgroup, false);
        ((Button)layoutinflater.findViewById(com.fotoable.fotophotoselector.R.id.next_btn)).setOnClickListener(new android.view.View.OnClickListener() {

            final PhotoSelectScrollFragment a;

            public void onClick(View view)
            {
label0:
                {
                    if (PhotoSelectScrollFragment.a(a) != null)
                    {
                        if (PhotoSelectScrollFragment.a(a).a() == null || PhotoSelectScrollFragment.a(a).a().size() <= 0)
                        {
                            break label0;
                        }
                        PhotoSelectScrollFragment.a(a).b();
                    }
                    return;
                }
                Toast.makeText(a.getActivity(), a.getResources().getString(com.fotoable.fotophotoselector.R.string.photo_selected_zero), 0).show();
            }

            
            {
                a = PhotoSelectScrollFragment.this;
                super();
            }
        });
        a = (PhotoSelectScrollView)layoutinflater.findViewById(com.fotoable.fotophotoselector.R.id.photo_list_view);
        if (b != null)
        {
            viewgroup = b.a();
            if (viewgroup != null)
            {
                for (; i < viewgroup.size(); i++)
                {
                    bundle = (nr)viewgroup.get(i);
                    a.addItem(bundle);
                }

            }
        }
        a.setCallback(this);
        return layoutinflater;
    }

    public void onPause()
    {
        super.onPause();
        System.out.println("Fragment-->onPause");
    }
}
