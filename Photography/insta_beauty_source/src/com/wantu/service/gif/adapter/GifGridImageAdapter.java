// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.service.gif.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import bod;
import bot;
import com.wantu.view.BorderImageView;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class GifGridImageAdapter extends BaseAdapter
{

    private Activity mActivity;
    private HashMap mBitmapCache;
    private bod mGifScanner;
    private int padding_in_px;

    public GifGridImageAdapter(Activity activity, bod bod1)
    {
        padding_in_px = 100;
        mBitmapCache = new HashMap();
        mActivity = activity;
        mGifScanner = bod1;
        padding_in_px = (int)(mActivity.getResources().getDisplayMetrics().density * (float)100 + 0.5F);
    }

    public int getCount()
    {
        return mGifScanner.a();
    }

    public int getImageId(int i)
    {
        return mGifScanner.b(i);
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null) goto _L2; else goto _L1
_L1:
        Object obj;
        String s;
        int j;
        try
        {
            view = (BorderImageView)view;
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            view = null;
            continue; /* Loop/switch isn't completed */
        }
_L3:
        j = mGifScanner.b(i);
        s = String.valueOf(j);
        if (mBitmapCache.get(s) == null)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        viewgroup = (Bitmap)((SoftReference)mBitmapCache.get(s)).get();
_L6:
        obj = viewgroup;
        if (viewgroup != null)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        obj = mGifScanner.a(i);
        viewgroup = ((ViewGroup) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        viewgroup = bot.a(bot.b(mActivity, j), padding_in_px, padding_in_px);
        obj = new SoftReference(viewgroup);
        mBitmapCache.put(s, obj);
        obj = viewgroup;
        view.setImageBitmap(((Bitmap) (obj)));
        return view;
_L2:
        view = new BorderImageView(mActivity);
        view.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        view.setLayoutParams(new android.widget.AbsListView.LayoutParams(padding_in_px, padding_in_px));
          goto _L3
        viewgroup;
_L5:
        viewgroup.printStackTrace();
        return view;
        viewgroup;
        if (true) goto _L5; else goto _L4
_L4:
        viewgroup = null;
          goto _L6
    }
}
