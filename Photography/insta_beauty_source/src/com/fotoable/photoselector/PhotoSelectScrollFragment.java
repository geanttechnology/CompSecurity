// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector;

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
import ark;
import arl;
import arn;
import asx;
import java.io.PrintStream;
import java.util.List;

// Referenced classes of package com.fotoable.photoselector:
//            PhotoSelectScrollView

public class PhotoSelectScrollFragment extends Fragment
    implements arn
{

    private PhotoSelectScrollView a;
    private arl b;

    public PhotoSelectScrollFragment()
    {
    }

    public static arl a(PhotoSelectScrollFragment photoselectscrollfragment)
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
            b = (arl)activity;
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
        layoutinflater = layoutinflater.inflate(aei.photo_select_fragment_lib, viewgroup, false);
        ((Button)layoutinflater.findViewById(aeh.next_btn)).setOnClickListener(new ark(this));
        a = (PhotoSelectScrollView)layoutinflater.findViewById(aeh.photo_list_view);
        if (b != null)
        {
            viewgroup = b.a();
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
