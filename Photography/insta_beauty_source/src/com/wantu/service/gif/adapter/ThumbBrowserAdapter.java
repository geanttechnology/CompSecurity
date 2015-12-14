// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.service.gif.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import bod;
import bot;
import com.wantu.view.BorderImageView;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ThumbBrowserAdapter extends BaseAdapter
{

    private HashMap mBitmapCache;
    private Activity mContex;
    private bod mGifScanner;
    private List mSelected;
    private int padding_in_px;

    public ThumbBrowserAdapter(Activity activity, bod bod1)
    {
        mSelected = new LinkedList();
        padding_in_px = 100;
        mBitmapCache = new HashMap();
        mContex = activity;
        mGifScanner = bod1;
        padding_in_px = (int)(mContex.getResources().getDisplayMetrics().density * (float)100 + 0.5F);
    }

    private Bitmap getBitmap(String s, int i)
    {
        Bitmap bitmap = null;
        if (mBitmapCache.get(s) != null)
        {
            bitmap = (Bitmap)((SoftReference)mBitmapCache.get(s)).get();
        }
        Object obj1 = bitmap;
        if (bitmap == null)
        {
            obj1 = mGifScanner.a(i);
            Object obj = obj1;
            if (obj1 == null)
            {
                i = mGifScanner.b(i);
                obj = bot.a(bot.b(mContex, i), padding_in_px, padding_in_px);
            }
            obj1 = new SoftReference(obj);
            mBitmapCache.put(s, obj1);
            obj1 = obj;
        }
        return ((Bitmap) (obj1));
    }

    public void addSelect(int i)
    {
        mSelected.add(Integer.valueOf(i));
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

    public int getSelectedCount()
    {
        return mSelected.size();
    }

    public List getSelectedImageIdList()
    {
        LinkedList linkedlist = new LinkedList();
        for (int i = 0; i < mSelected.size(); i++)
        {
            linkedlist.add(Integer.valueOf(getImageId(((Integer)mSelected.get(i)).intValue())));
        }

        return linkedlist;
    }

    public List getSelectedList()
    {
        return mSelected;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null) goto _L2; else goto _L1
_L1:
        view = (BorderImageView)view;
_L3:
        Bitmap bitmap = getBitmap(String.valueOf(i), i);
        viewgroup = bitmap;
        if (mSelected.indexOf(Integer.valueOf(i)) == -1)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        viewgroup = bitmap;
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        viewgroup = getWaterBitmap(bitmap, i);
        view.setImageBitmap(viewgroup);
        return view;
_L2:
        view = new BorderImageView(mContex);
        try
        {
            view.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
            view.setLayoutParams(new android.widget.AbsListView.LayoutParams(padding_in_px, padding_in_px));
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            continue; /* Loop/switch isn't completed */
        }
          goto _L3
        viewgroup;
        view = null;
_L5:
        viewgroup.printStackTrace();
        return view;
        viewgroup;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public Bitmap getWaterBitmap(Bitmap bitmap, int i)
    {
        Object obj = null;
        i = mSelected.indexOf(Integer.valueOf(i));
        Bitmap bitmap1 = obj;
        if (bitmap != null)
        {
            bitmap1 = obj;
            if (i != -1)
            {
                bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap1);
                canvas.drawBitmap(bitmap, 0.0F, 0.0F, new Paint(161));
                canvas.drawARGB(126, 0, 0, 0);
                Paint paint = new Paint();
                paint.setColor(0xffcccccc);
                paint.setTextSize(30F);
                paint.setTypeface(Typeface.DEFAULT_BOLD);
                android.graphics.Paint.FontMetrics fontmetrics = paint.getFontMetrics();
                int j = ((int)Math.ceil(fontmetrics.descent - fontmetrics.top) + 2) / 2;
                paint.setTextAlign(android.graphics.Paint.Align.CENTER);
                int k = bitmap.getWidth() / 2;
                int l = bitmap.getHeight() / 2;
                canvas.drawText(String.valueOf(i + 1), k, (j + l) - 10, paint);
            }
        }
        return bitmap1;
    }

    public boolean isSelected(int i)
    {
        return mSelected.indexOf(Integer.valueOf(i)) != -1;
    }

    public void removeSelect(int i)
    {
        i = mSelected.indexOf(Integer.valueOf(i));
        if (i != -1)
        {
            mSelected.remove(i);
        }
    }
}
