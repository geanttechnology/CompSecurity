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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.pipcamera.activity.photoselector.PhotoSelectScrollView;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import ll;
import nr;
import sr;

public class PhotoSelectScrollFragment extends Fragment
    implements sr
{

    private PhotoSelectScrollView a;
    private ll b;
    private int c;
    private TextView d;

    public PhotoSelectScrollFragment()
    {
        c = 9;
    }

    static ll a(PhotoSelectScrollFragment photoselectscrollfragment)
    {
        return photoselectscrollfragment.b;
    }

    public void a()
    {
        if (b != null)
        {
            b.c();
        }
    }

    public void a(int i)
    {
        c = i;
        String s = String.format(getActivity().getResources().getString(0x7f060048), new Object[] {
            Integer.valueOf(c)
        });
        if (d != null)
        {
            d.setText(s);
        }
    }

    public void a(Object obj)
    {
        if (b != null)
        {
            b.a(obj);
        }
    }

    public void a(nr nr1)
    {
        if (a != null)
        {
            Log.v("PhotoSelectScrollFragment", "AddItem");
            a.addItem(nr1);
            a.scroolToLast();
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        System.out.println("Fragment-->onAttach");
        try
        {
            b = (ll)activity;
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
        System.out.println("Fragment-->onCreateView");
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f030066, viewgroup, false);
        viewgroup = (Button)layoutinflater.findViewById(0x7f0c0080);
        d = (TextView)layoutinflater.findViewById(0x7f0c002d);
        viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

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
                Toast.makeText(a.getActivity(), a.getResources().getString(0x7f060046), 0).show();
            }

            
            {
                a = PhotoSelectScrollFragment.this;
                super();
            }
        });
        a = (PhotoSelectScrollView)layoutinflater.findViewById(0x7f0c01df);
        if (b != null)
        {
            viewgroup = b.a();
            if (viewgroup != null)
            {
                for (int i = 0; i < viewgroup.size(); i++)
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
