// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class SimpleFloatViewManager
    implements DragSortListView.FloatViewManager
{

    private int mFloatBGColor;
    private Bitmap mFloatBitmap;
    private ImageView mImageView;
    private ListView mListView;

    public SimpleFloatViewManager(ListView listview)
    {
        mFloatBGColor = 0xff000000;
        mListView = listview;
    }

    public View onCreateFloatView(int i)
    {
        View view = mListView.getChildAt((mListView.getHeaderViewsCount() + i) - mListView.getFirstVisiblePosition());
        if (view == null)
        {
            return null;
        }
        view.setPressed(false);
        view.setDrawingCacheEnabled(true);
        mFloatBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        if (mImageView == null)
        {
            mImageView = new ImageView(mListView.getContext());
        }
        mImageView.setBackgroundColor(mFloatBGColor);
        mImageView.setPadding(0, 0, 0, 0);
        mImageView.setImageBitmap(mFloatBitmap);
        mImageView.setLayoutParams(new android.view.ViewGroup.LayoutParams(view.getWidth(), view.getHeight()));
        return mImageView;
    }

    public void onDestroyFloatView(View view)
    {
        ((ImageView)view).setImageDrawable(null);
        mFloatBitmap.recycle();
        mFloatBitmap = null;
    }

    public void onDragFloatView(View view, Point point, Point point1)
    {
    }

    public void setBackgroundColor(int i)
    {
        mFloatBGColor = i;
    }
}
