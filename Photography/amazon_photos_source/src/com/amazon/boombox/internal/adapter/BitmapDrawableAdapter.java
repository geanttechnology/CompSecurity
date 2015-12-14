// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.internal.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.util.List;

// Referenced classes of package com.amazon.boombox.internal.adapter:
//            AsyncDrawableAdapter

public class BitmapDrawableAdapter
    implements AsyncDrawableAdapter
{

    private List mBitmaps;
    private Context mContext;

    public BitmapDrawableAdapter(Context context, List list)
    {
        mContext = context;
        mBitmaps = list;
    }

    public void dispose(Drawable drawable)
    {
    }

    public void getCount(AsyncDrawableAdapter.Listener listener)
    {
        listener.onCountReady(mBitmaps.size());
    }

    public void getDrawable(int i, int j, int k, AsyncDrawableAdapter.Listener listener)
    {
        listener.onDrawableReady(i, new BitmapDrawable(mContext.getResources(), (Bitmap)mBitmaps.get(i)));
    }
}
