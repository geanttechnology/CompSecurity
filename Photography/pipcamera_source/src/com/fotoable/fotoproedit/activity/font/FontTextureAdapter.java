// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ew;
import hv;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

// Referenced classes of package com.fotoable.fotoproedit.activity.font:
//            FontTextLabelInfo

public class FontTextureAdapter extends BaseAdapter
{

    private AssetManager assetManager;
    private int clickTemp;
    private ArrayList colorList;
    private Context mContext;

    public FontTextureAdapter(Context context)
    {
        clickTemp = -1;
        mContext = context;
        assetManager = mContext.getResources().getAssets();
        colorList = new ArrayList();
    }

    private Bitmap getImageFromAssetsFile(String s)
    {
        InputStream inputstream;
        inputstream = assetManager.open(s);
        s = BitmapFactory.decodeStream(inputstream);
        inputstream.close();
        return s;
        IOException ioexception;
        ioexception;
        s = null;
_L2:
        ioexception.printStackTrace();
        return s;
        ioexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public int getCount()
    {
        if (colorList != null)
        {
            return colorList.size();
        } else
        {
            return 0;
        }
    }

    public Object getItem(int i)
    {
        if (colorList != null && i < colorList.size())
        {
            return colorList.get(i);
        } else
        {
            return null;
        }
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj = (FontTextLabelInfo)colorList.get(i);
        Paint paint;
        Bitmap bitmap;
        int j;
        int k;
        if (view == null)
        {
            view = LayoutInflater.from(mContext).inflate(0x7f0300b7, null);
            viewgroup = new hv(this);
            viewgroup.a = (FrameLayout)view.findViewById(0x7f0c02c7);
            viewgroup.b = (ImageView)view.findViewById(0x7f0c02c8);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (hv)view.getTag();
        }
        j = (((WindowManager)mContext.getSystemService("window")).getDefaultDisplay().getWidth() - ew.a(mContext, 72F)) / 7;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2.0F);
        paint.setColor(-1);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        k = ew.a(mContext, 6F);
        bitmap = Bitmap.createBitmap(j, j, android.graphics.Bitmap.Config.ARGB_8888);
        if (!((FontTextLabelInfo) (obj)).o)
        {
            Canvas canvas = new Canvas(bitmap);
            RectF rectf = new RectF(0.0F, 0.0F, j, j);
            paint.setColor(((FontTextLabelInfo) (obj)).j);
            canvas.drawRoundRect(rectf, k, k, paint);
        } else
        {
            obj = getImageFromAssetsFile(((FontTextLabelInfo) (obj)).i);
            Canvas canvas1 = new Canvas(bitmap);
            Rect rect = new Rect(0, 0, j, j);
            canvas1.drawRoundRect(new RectF(rect), k, k, paint);
            paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
            if (obj != null)
            {
                canvas1.drawBitmap(((Bitmap) (obj)), null, rect, paint);
            }
        }
        obj = new BitmapDrawable(mContext.getResources(), bitmap);
        if (android.os.Build.VERSION.SDK_INT > 16)
        {
            ((hv) (viewgroup)).b.setBackground(((android.graphics.drawable.Drawable) (obj)));
        } else
        {
            ((hv) (viewgroup)).b.setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj)));
        }
        if (clickTemp == i)
        {
            ((hv) (viewgroup)).a.setBackgroundResource(0x7f020100);
            return view;
        } else
        {
            ((hv) (viewgroup)).a.setBackgroundColor(mContext.getResources().getColor(0x7f0b007d));
            return view;
        }
    }

    public void setColorList(ArrayList arraylist)
    {
        colorList.clear();
        colorList.addAll(arraylist);
        notifyDataSetChanged();
    }

    public void setSeclection(int i)
    {
        clickTemp = i;
    }
}
