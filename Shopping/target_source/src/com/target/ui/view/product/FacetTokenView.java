// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.ui.util.j;
import com.target.ui.view.a;

public class FacetTokenView extends LinearLayout
{
    static class Views extends a
    {

        TextView textView;

        Views(View view)
        {
            super(view);
        }
    }


    private Views mViews;

    public FacetTokenView(Context context)
    {
        super(context);
        b(null);
    }

    public FacetTokenView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b(attributeset);
    }

    public FacetTokenView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b(attributeset);
    }

    private Rect a(AttributeSet attributeset)
    {
        int i = getResources().getDimensionPixelSize(0x7f0a016f);
        Rect rect = new Rect(i, i, i, i);
        if (attributeset != null)
        {
            if ((attributeset = getContext().obtainStyledAttributes(attributeset, com.target.ui.a.a.FacetTokenView)) != null)
            {
                rect.bottom = attributeset.getDimensionPixelSize(0, i);
                rect.left = attributeset.getDimensionPixelSize(1, i);
                rect.right = attributeset.getDimensionPixelSize(2, i);
                rect.top = attributeset.getDimensionPixelSize(3, i);
                attributeset.recycle();
                return rect;
            }
        }
        return rect;
    }

    private void b(AttributeSet attributeset)
    {
        setOrientation(0);
        inflate(getContext(), 0x7f030160, this);
        mViews = new Views(this);
        android.graphics.drawable.Drawable drawable;
        if (j.b())
        {
            drawable = getResources().getDrawable(0x7f020129, null);
        } else
        {
            drawable = getResources().getDrawable(0x7f020129);
        }
        attributeset = a(attributeset);
        setBackground(new InsetDrawable(drawable, ((Rect) (attributeset)).left, ((Rect) (attributeset)).top, ((Rect) (attributeset)).right, ((Rect) (attributeset)).bottom));
    }

    public void setFacetLabel(String s)
    {
        mViews.textView.setText(s);
    }
}
