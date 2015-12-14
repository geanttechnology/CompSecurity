// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.gallery.framework.model.Persistable;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            CoverViewInterface

public abstract class AbstractCoverViewFactory
    implements CoverViewInterface
{

    private final int layoutId;
    private android.widget.ImageView.ScaleType scaleType;

    protected AbstractCoverViewFactory(int i)
    {
        scaleType = android.widget.ImageView.ScaleType.CENTER_CROP;
        layoutId = i;
    }

    public View createCoverView(Context context, Persistable persistable)
    {
        context = (ViewGroup)LayoutInflater.from(context).inflate(layoutId, null, false);
        context.setTag(createViewHolder(persistable, context));
        return context;
    }

    public void onActivityPaused()
    {
    }

    public void onActivityResumed()
    {
    }

    public void setScaleType(android.widget.ImageView.ScaleType scaletype)
    {
        scaleType = scaletype;
    }
}
