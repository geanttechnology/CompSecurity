// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.amazon.gallery.framework.model.tags.Tag;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            ViewFactory

public class ShadowedItemFactory
    implements ViewFactory
{

    private ViewFactory childFactory;
    private Context context;

    public ShadowedItemFactory()
    {
    }

    private FrameLayout inflateShadow()
    {
        ViewGroup viewgroup = (ViewGroup)View.inflate(context, 0x7f0300d5, null);
        FrameLayout framelayout = (FrameLayout)viewgroup.findViewById(0x7f0c01e1);
        framelayout.setLayoutParams(new android.widget.AbsListView.LayoutParams(context.getResources().getDimensionPixelSize(0x7f0a0032) + framelayout.getPaddingLeft() + framelayout.getPaddingRight(), context.getResources().getDimensionPixelSize(0x7f0a0031) + framelayout.getPaddingTop() + framelayout.getPaddingBottom()));
        viewgroup.removeView(framelayout);
        return framelayout;
    }

    public View createView(Tag tag)
    {
        FrameLayout framelayout = inflateShadow();
        if (childFactory != null)
        {
            tag = childFactory.getView(0, tag, null);
            framelayout.addView(tag);
            framelayout.setTag(tag.getTag());
        }
        return framelayout;
    }

    public volatile View createView(Object obj)
    {
        return createView((Tag)obj);
    }

    public View getView(int i, Tag tag, View view)
    {
        View view1;
        if (view == null)
        {
            view1 = createView(tag);
        } else
        {
            view1 = view;
            if (childFactory != null)
            {
                childFactory.getView(i, tag, ((FrameLayout)view).getChildAt(0));
                return view;
            }
        }
        return view1;
    }

    public volatile View getView(int i, Object obj, View view)
    {
        return getView(i, (Tag)obj, view);
    }

    public void onViewDestroy(View view)
    {
        childFactory.onViewDestroy(view);
    }

    public void reset()
    {
        childFactory.reset();
    }

    public void setBoundingSize(int i, int j)
    {
    }

    public void setChildFactory(ViewFactory viewfactory)
    {
        childFactory = viewfactory;
    }

    public void setContext(Context context1)
    {
        context = context1;
    }
}
