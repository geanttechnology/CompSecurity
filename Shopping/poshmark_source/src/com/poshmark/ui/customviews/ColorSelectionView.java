// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.poshmark.data_model.models.PMColor;
import com.poshmark.utils.ViewUtils;
import java.util.Iterator;
import java.util.List;

public class ColorSelectionView extends LinearLayout
{

    Context context;

    public ColorSelectionView(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        context = context1;
    }

    public void addAllColors(List list)
    {
        removeAllColors();
        if (list != null && !list.isEmpty())
        {
            for (list = list.iterator(); list.hasNext(); addColor((PMColor)list.next())) { }
        }
    }

    public void addColor(PMColor pmcolor)
    {
        ImageView imageview = new ImageView(context);
        Object obj = new android.widget.LinearLayout.LayoutParams(-2, -2);
        obj.height = (int)ViewUtils.dipToPixels(context, 30F);
        obj.width = (int)ViewUtils.dipToPixels(context, 30F);
        int i = (int)ViewUtils.dipToPixels(context, 10F);
        ((android.widget.LinearLayout.LayoutParams) (obj)).setMargins(i, 0, i, 0);
        imageview.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        obj = (GradientDrawable)context.getResources().getDrawable(0x7f020038);
        ((GradientDrawable) (obj)).setColor(Color.parseColor(pmcolor.rgb.trim()));
        imageview.setImageDrawable(((android.graphics.drawable.Drawable) (obj)));
        addView(imageview);
    }

    public void removeAllColors()
    {
        removeAllViews();
    }
}
