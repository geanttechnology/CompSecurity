// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            PhoneCoverAdapter

public class TabletFeaturedAccessibleAdapter extends PhoneCoverAdapter
{

    protected void adjustImageHeight(View view)
    {
        view = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.cover_art);
        view.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, coverImageHeightPx));
        view.requestLayout();
    }

    protected Point getCoverImageHeight()
    {
        Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        return new Point(display.getWidth() / 3, display.getWidth() / 6);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = super.getView(i, view, viewgroup);
        adjustImageHeight(view);
        return view;
    }

    protected int getViewLayoutId()
    {
        return com.xfinity.playerlib.R.layout.tablet_cover_accessible;
    }
}
