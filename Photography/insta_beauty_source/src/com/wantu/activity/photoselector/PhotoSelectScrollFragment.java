// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.photoselector;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import asx;
import bjl;
import bjm;
import bjp;
import java.io.PrintStream;
import java.util.List;

// Referenced classes of package com.wantu.activity.photoselector:
//            PhotoSelectScrollView

public class PhotoSelectScrollFragment extends Fragment
    implements bjp
{

    private PhotoSelectScrollView a;
    private bjm b;
    private int c;
    private TextView d;

    public PhotoSelectScrollFragment()
    {
        c = 9;
    }

    public static bjm a(PhotoSelectScrollFragment photoselectscrollfragment)
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
            b = (bjm)activity;
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
        layoutinflater = layoutinflater.inflate(0x7f0300af, viewgroup, false);
        viewgroup = (Button)layoutinflater.findViewById(0x7f0d010b);
        d = (TextView)layoutinflater.findViewById(0x7f0d0034);
        viewgroup.setOnClickListener(new bjl(this));
        a = (PhotoSelectScrollView)layoutinflater.findViewById(0x7f0d02df);
        if (b != null)
        {
            viewgroup = b.a();
            if (viewgroup != null)
            {
                for (int i = 0; i < viewgroup.size(); i++)
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
