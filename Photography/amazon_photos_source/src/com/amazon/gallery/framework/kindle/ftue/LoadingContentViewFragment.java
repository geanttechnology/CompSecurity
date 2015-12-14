// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;

public class LoadingContentViewFragment extends Fragment
{

    public LoadingContentViewFragment()
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (viewgroup == null)
        {
            layoutinflater = null;
        } else
        {
            viewgroup = layoutinflater.inflate(0x7f0300a9, viewgroup, false);
            layoutinflater = viewgroup;
            if (!BuildFlavors.isFos4())
            {
                ((ProgressBar)viewgroup.findViewById(0x7f0c0184)).getIndeterminateDrawable().setColorFilter(getResources().getColor(0x7f090004), android.graphics.PorterDuff.Mode.SRC_ATOP);
                return viewgroup;
            }
        }
        return layoutinflater;
    }
}
