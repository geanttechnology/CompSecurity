// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.service.gif.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import bns;
import bnt;
import bot;
import bpb;
import com.wantu.model.GifNetMaterial;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridNetMaterialAdapter extends BaseAdapter
{

    private Activity mContext;
    private List mGmts;
    private Map mImageCache;
    private bpb mImageLoader;
    private bns mtm;
    private int padding_in_px;

    public GridNetMaterialAdapter(Activity activity, List list)
    {
        mImageLoader = new bpb();
        mImageCache = new HashMap();
        padding_in_px = 100;
        mContext = activity;
        mGmts = list;
        mtm = new bns(mContext);
        padding_in_px = (int)(mContext.getResources().getDisplayMetrics().density * (float)100 + 0.5F);
    }

    public void drawImageView(ImageView imageview, Drawable drawable, boolean flag)
    {
        if (flag)
        {
            Object obj = ((BitmapDrawable)drawable).getBitmap().copy(android.graphics.Bitmap.Config.ARGB_8888, true);
            drawable = bot.a(((Bitmap) (obj)), padding_in_px, padding_in_px);
            if (obj != null && !((Bitmap) (obj)).isRecycled())
            {
                ((Bitmap) (obj)).recycle();
            }
            obj = mContext.getResources().getString(0x7f06016c);
            Paint paint = new Paint();
            paint.setColor(0xffcccccc);
            paint.setTextSize(15F);
            paint.setTextAlign(android.graphics.Paint.Align.CENTER);
            Object obj1 = paint.getFontMetrics();
            int i = (int)Math.ceil(((android.graphics.Paint.FontMetrics) (obj1)).descent - ((android.graphics.Paint.FontMetrics) (obj1)).top) + 2;
            obj1 = Bitmap.createBitmap(drawable.getWidth(), i + 8, android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(((Bitmap) (obj1)));
            canvas.drawARGB(126, 0, 0, 0);
            canvas.drawText(((String) (obj)), ((Bitmap) (obj1)).getWidth() / 2, i - 2, paint);
            obj = new Rect(0, drawable.getHeight() - ((Bitmap) (obj1)).getHeight(), drawable.getWidth(), drawable.getHeight());
            (new Canvas(drawable)).drawBitmap(((Bitmap) (obj1)), null, ((Rect) (obj)), new Paint());
            if (obj1 != null && !((Bitmap) (obj1)).isRecycled())
            {
                ((Bitmap) (obj1)).recycle();
            }
            imageview.setImageBitmap(drawable);
            return;
        } else
        {
            imageview.setImageDrawable(drawable);
            return;
        }
    }

    public int getCount()
    {
        return mGmts.size();
    }

    public GifNetMaterial getGifMaterial(int i)
    {
        return (GifNetMaterial)mGmts.get(i);
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
        view = (ImageView)view;
        String s;
        try
        {
            if (view.getDrawable() == null)
            {
                break MISSING_BLOCK_LABEL_42;
            }
            viewgroup = ((BitmapDrawable)view.getDrawable()).getBitmap();
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (viewgroup == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        if (viewgroup.isRecycled())
        {
            viewgroup.recycle();
        }
_L3:
        viewgroup = (GifNetMaterial)mGmts.get(i);
        s = bns.b(viewgroup.getId());
        loadImage(viewgroup, view, mtm.c(s));
        return view;
_L2:
        view = new ImageView(mContext);
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

    public void loadImage(GifNetMaterial gifnetmaterial, ImageView imageview, boolean flag)
    {
        gifnetmaterial = gifnetmaterial.getNetIconUrl();
        if (gifnetmaterial != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag1;
        Object obj = (SoftReference)mImageCache.get(gifnetmaterial);
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (Drawable)((SoftReference) (obj)).get();
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        drawImageView(imageview, ((Drawable) (obj)), flag);
        flag1 = true;
_L4:
        if (!flag1)
        {
            mImageLoader.a(gifnetmaterial, new bnt(this, imageview, flag, gifnetmaterial));
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        flag1 = false;
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void setGifItems(List list)
    {
        mGmts = list;
        notifyDataSetChanged();
    }

}
