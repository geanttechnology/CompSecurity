// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.poshmark.ui.customviews.GestureView;
import com.poshmark.ui.customviews.PMButton;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

public class GestureTester_II extends PMFragment
{

    PMButton crop;
    LinearLayout croppable_space;
    GestureView croppable_view;
    ImageView cropped_image;

    public GestureTester_II()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f030056, viewgroup, false);
        croppable_space = (LinearLayout)layoutinflater.findViewById(0x7f0c015a);
        croppable_view = (GestureView)layoutinflater.findViewById(0x7f0c0159);
        cropped_image = (ImageView)layoutinflater.findViewById(0x7f0c015c);
        crop = (PMButton)layoutinflater.findViewById(0x7f0c00eb);
        return layoutinflater;
    }

    public void setViewNameForAnalytics()
    {
    }
}
