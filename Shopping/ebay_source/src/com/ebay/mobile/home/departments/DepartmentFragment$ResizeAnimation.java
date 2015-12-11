// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.ebay.mobile.home.channels.ChannelDispatcher;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

class backgroundWeight extends Animation
{

    public final int backgroundOffsetY;
    public final float backgroundWeight;
    public final View boundView;
    public final int endHeight;
    public final boolean isGrowing;
    public final int startHeight;
    final DepartmentFragment this$0;

    protected void applyTransformation(float f, Transformation transformation)
    {
        float f1;
        DepartmentFragment departmentfragment;
        int i;
        if (isGrowing)
        {
            f1 = (float)endHeight * f;
        } else
        {
            f1 = (float)startHeight - (float)startHeight * f;
        }
        transformation = boundView.getLayoutParams();
        if (f == 1.0F)
        {
            i = endHeight;
        } else
        {
            i = (int)f1;
        }
        transformation.endHeight = i;
        boundView.requestLayout();
        if (f == 1.0F)
        {
            f1 = endHeight;
        }
        f1 = (float)Math.min((double)(backgroundWeight * f1) - (double)backgroundOffsetY, 0.0D);
        transformation = getView();
        if (transformation != null)
        {
            transformation = (ImageView)transformation.findViewById(0x7f1000c7);
            if (transformation != null)
            {
                transformation.setY(f1);
            }
        }
        transformation = DepartmentFragment.access$500(DepartmentFragment.this);
        departmentfragment = DepartmentFragment.this;
        if (!isGrowing)
        {
            f = 1.0F - f;
        }
        transformation.onCategoryExpansion(departmentfragment, f);
    }

    public boolean willChangeBounds()
    {
        return true;
    }

    public I(View view, int i, int j)
    {
        this$0 = DepartmentFragment.this;
        super();
        boundView = view;
        startHeight = i;
        endHeight = j;
        boolean flag;
        if (i <= j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isGrowing = flag;
        backgroundOffsetY = view.getResources().getDimensionPixelSize(0x7f090138);
        backgroundWeight = view.getResources().getFraction(0x7f0f0000, 1, 1);
    }
}
