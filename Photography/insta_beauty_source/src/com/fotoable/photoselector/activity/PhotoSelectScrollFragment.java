// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.activity;

import aeh;
import aei;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import art;
import aru;
import arz;
import asx;
import java.io.PrintStream;
import java.util.List;

// Referenced classes of package com.fotoable.photoselector.activity:
//            PhotoSelectScrollView

public class PhotoSelectScrollFragment extends Fragment
    implements arz
{

    private PhotoSelectScrollView a;
    private aru b;
    private TextView c;

    public PhotoSelectScrollFragment()
    {
    }

    public static aru a(PhotoSelectScrollFragment photoselectscrollfragment)
    {
        return photoselectscrollfragment.b;
    }

    public void a()
    {
        if (b != null)
        {
            b.e();
        }
    }

    public void a(asx asx1)
    {
        if (a != null)
        {
            Log.v("PhotoSelectScrollFragment", "AddItem");
            a.addItem(asx1);
        }
    }

    public void a(Object obj)
    {
        if (b != null)
        {
            b.a(obj);
        }
    }

    public void a(String s)
    {
        if (c != null)
        {
            c.setText(s);
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        System.out.println("Fragment-->onAttach");
        try
        {
            b = (aru)activity;
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
        layoutinflater = layoutinflater.inflate(aei.photo_select_fragment_new, viewgroup, false);
        c = (TextView)layoutinflater.findViewById(aeh.title);
        ((Button)layoutinflater.findViewById(aeh.next_btn)).setOnClickListener(new art(this));
        a = (PhotoSelectScrollView)layoutinflater.findViewById(aeh.photo_list_view);
        if (b != null)
        {
            viewgroup = b.c();
            if (viewgroup != null)
            {
                for (; i < viewgroup.size(); i++)
                {
                    bundle = (asx)viewgroup.get(i);
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
