// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import android.graphics.drawable.Drawable;
import com.target.ui.model.MapDisplayableItem;

// Referenced classes of package com.target.ui.view.map:
//            StoreMapView

private class mSelectedDrawable
{

    private MapDisplayableItem mMapDisplayableItem;
    private Drawable mSelectedDrawable;
    private Drawable mUnselectedDrawable;
    final StoreMapView this$0;

    static MapDisplayableItem a(mSelectedDrawable mselecteddrawable)
    {
        return mselecteddrawable.mMapDisplayableItem;
    }

    static Drawable b(mMapDisplayableItem mmapdisplayableitem)
    {
        return mmapdisplayableitem.mSelectedDrawable;
    }

    static Drawable c(mSelectedDrawable mselecteddrawable)
    {
        return mselecteddrawable.mUnselectedDrawable;
    }

    public (MapDisplayableItem mapdisplayableitem, Drawable drawable, Drawable drawable1)
    {
        this$0 = StoreMapView.this;
        super();
        mMapDisplayableItem = mapdisplayableitem;
        mUnselectedDrawable = drawable;
        mSelectedDrawable = drawable1;
    }
}
