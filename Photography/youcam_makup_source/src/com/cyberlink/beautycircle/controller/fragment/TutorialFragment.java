// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;

public class TutorialFragment extends Fragment
{

    public TutorialFragment()
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(k.bc_fragment_tutorial, viewgroup, false);
        viewgroup = (Tutorial)getArguments().getSerializable(com/cyberlink/beautycircle/controller/fragment/TutorialFragment$Tutorial.toString());
        if (viewgroup == null) goto _L2; else goto _L1
_L1:
        View view;
        bundle = (ImageView)layoutinflater.findViewById(j.bc_tutorial_bg);
        if (bundle != null && ((Tutorial) (viewgroup)).bg != null)
        {
            bundle.setImageResource(((Tutorial) (viewgroup)).bg.intValue());
            bundle.post(new Runnable(bundle) {

                final ImageView a;
                final TutorialFragment b;

                public void run()
                {
                    Matrix matrix = new Matrix();
                    matrix.reset();
                    float f2 = a.getWidth();
                    float f3 = a.getHeight();
                    float f = a.getDrawable().getIntrinsicWidth();
                    float f1 = a.getDrawable().getIntrinsicHeight();
                    if (f / f2 > f1 / f3)
                    {
                        matrix.setScale(f3 / f1, f3 / f1);
                        f1 = (f * f3) / f1;
                        f = f3;
                    } else
                    {
                        matrix.setScale(f2 / f, f2 / f);
                        f = (f1 * f2) / f;
                        f1 = f2;
                    }
                    matrix.preTranslate((f2 - f1) / 2.0F, (f3 - f) / 2.0F);
                    a.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
                    a.setImageMatrix(matrix);
                }

            
            {
                b = TutorialFragment.this;
                a = imageview;
                super();
            }
            });
        }
        bundle = (TextView)layoutinflater.findViewById(j.bc_tutorial_title);
        view = layoutinflater.findViewById(j.bc_tutorial_logo);
        if (bundle == null || ((Tutorial) (viewgroup)).title == null) goto _L4; else goto _L3
_L3:
        bundle.setText(((Tutorial) (viewgroup)).title.intValue());
_L6:
        bundle = (TextView)layoutinflater.findViewById(j.bc_tutorial_desc);
        if (bundle != null && ((Tutorial) (viewgroup)).desc != null)
        {
            bundle.setText(((Tutorial) (viewgroup)).desc.intValue());
        }
_L2:
        return layoutinflater;
_L4:
        if (view != null)
        {
            view.setVisibility(0);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private class Tutorial
        implements Serializable
    {

        public Integer bg;
        public Integer desc;
        public Integer title;

        public Tutorial(Integer integer, Integer integer1, Integer integer2)
        {
            bg = integer;
            title = integer1;
            desc = integer2;
        }
    }

}
