// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import axw;
import bkd;
import bkn;
import bkt;
import bph;
import com.wantu.imagelib.decorator.sprite.ImageCanvasSurfaceView;
import com.wantu.model.res.TPhotoFreeComposeLayoutInfo;
import com.wantu.model.res.TPhotoFreeComposeStyleInfo;
import com.wantu.model.res.TPhotoFreeFrameLayoutInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FreeImageCollageView extends RelativeLayout
    implements bkt
{

    int KMaxPix;
    bkd currentSelectDec;
    HashMap decMapBitmapIndex;
    bph listener;
    private List mBitmaps;
    private ImageCanvasSurfaceView mCanvasView;
    private TPhotoFreeFrameLayoutInfo mComposeInfo;
    Context mContext;
    TPhotoFreeComposeStyleInfo mFrameInfo;

    public FreeImageCollageView(Context context)
    {
        super(context);
        KMaxPix = 612;
        mBitmaps = new ArrayList();
        decMapBitmapIndex = new HashMap();
        initView();
    }

    public FreeImageCollageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        KMaxPix = 612;
        mBitmaps = new ArrayList();
        decMapBitmapIndex = new HashMap();
        initView();
    }

    public FreeImageCollageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        KMaxPix = 612;
        mBitmaps = new ArrayList();
        decMapBitmapIndex = new HashMap();
        initView();
    }

    private void layoutCompose(int i)
    {
        if (mComposeInfo != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        float f3;
        Iterator iterator;
        int j;
        iterator = mComposeInfo.layoutInfoes.iterator();
        f3 = (float)i / 306F;
        mCanvasView.clearSprite();
        j = 0;
_L6:
        if (!iterator.hasNext()) goto _L1; else goto _L3
_L3:
        float f;
        bkd bkd1;
        Matrix matrix;
        Matrix matrix1;
        Matrix matrix2;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        TPhotoFreeComposeLayoutInfo tphotofreecomposelayoutinfo = (TPhotoFreeComposeLayoutInfo)iterator.next();
        bkd1 = new bkd();
        decMapBitmapIndex.put(bkd1, Integer.valueOf(j));
        bkd1.i = (Bitmap)mBitmaps.get(j);
        f = bkd1.i.getWidth();
        float f1 = bkd1.i.getHeight();
        bkd1.b = mFrameInfo.photoBackgroundColor;
        if (!mFrameInfo.margin.isEmpty())
        {
            mFrameInfo.margin = new RectF(3F, 3F, 3F, 3F);
        }
        bkd1.f = (mFrameInfo.margin.bottom * f1) / 153F;
        bkd1.e = (mFrameInfo.margin.left * f1) / 153F;
        bkd1.d = (mFrameInfo.margin.right * f1) / 153F;
        bkd1.c = (mFrameInfo.margin.top * f1) / 153F;
        bkd1.g = f;
        bkd1.h = f1;
        matrix = new Matrix();
        matrix1 = new Matrix();
        matrix2 = new Matrix();
        float f4 = (float)Math.toDegrees(tphotofreecomposelayoutinfo.rotateRadius);
        matrix.setRotate(f4);
        int i1 = tphotofreecomposelayoutinfo.position.x;
        int k = tphotofreecomposelayoutinfo.position.y;
        j1 = (int)((float)i1 * f3);
        k1 = (int)((float)k * f3);
        k = (int)(f / 2.0F);
        i1 = (int)(f1 / 2.0F);
        float f5 = j1 - k;
        float f6 = k1 - i1;
        matrix1.setTranslate(f5 + (float)axw.a(getContext(), 6F), f6 + (float)axw.a(getContext(), 6F));
        RectF rectf = new RectF(0.0F, 0.0F, f, f1);
        Matrix matrix3 = new Matrix();
        matrix3.postRotate(f4, f / 2.0F, f1 / 2.0F);
        matrix3.mapRect(rectf);
        l1 = (int)(rectf.right - rectf.left);
        i2 = (int)(rectf.bottom - rectf.top);
        j2 = i - axw.a(getContext(), 12F);
        f = tphotofreecomposelayoutinfo.scale;
_L8:
        int l = (int)((float)(l1 / 2) * f);
        int k2 = (int)((float)(i2 / 2) * f);
        float f2;
        boolean flag;
        boolean flag1;
        if (j1 - l > 0 && l + j1 < j2)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        flag1 = false;
        flag = flag1;
        if (k1 - k2 > 0)
        {
            flag = flag1;
            if (k2 + k1 < j2)
            {
                flag = true;
            }
        }
        if (!l || !flag) goto _L5; else goto _L4
_L4:
        matrix2.setScale(f, f);
        mCanvasView.addGifDecortor(bkd1, matrix, matrix1, matrix2);
        j++;
          goto _L6
_L5:
        f2 = (float)((double)f - 0.050000000000000003D);
        f = f2;
        if ((double)f2 >= 0.10000000000000001D) goto _L8; else goto _L7
_L7:
        f = f2;
          goto _L4
    }

    private void layoutComposeReload(int i)
    {
        if (mComposeInfo != null)
        {
            Iterator iterator = mCanvasView.getSprite().iterator();
            while (iterator.hasNext()) 
            {
                bkn bkn1 = (bkn)iterator.next();
                bkd bkd1 = bkn1.a();
                bkd1.b = mFrameInfo.photoBackgroundColor;
                if (!mFrameInfo.margin.isEmpty())
                {
                    mFrameInfo.margin = new RectF(3F, 3F, 3F, 3F);
                }
                float f = bkd1.i.getWidth();
                f = bkd1.i.getHeight();
                bkd1.f = (mFrameInfo.margin.bottom * f) / 153F;
                bkd1.e = (mFrameInfo.margin.left * f) / 153F;
                bkd1.d = (mFrameInfo.margin.right * f) / 153F;
                bkd1.c = (f * mFrameInfo.margin.top) / 153F;
                bkn1.a(bkd1);
            }
        }
    }

    public void clearBitmaps()
    {
    }

    public void editButtonClicked()
    {
        if (listener != null && currentSelectDec != null)
        {
            int i = ((Integer)decMapBitmapIndex.get(currentSelectDec)).intValue();
            listener.a(currentSelectDec, i);
        }
    }

    public Bitmap getResultBitmap()
    {
        if (mCanvasView != null)
        {
            return mCanvasView.getResultBitmap();
        } else
        {
            return null;
        }
    }

    public void initView()
    {
        View.inflate(getContext(), 0x7f030066, this);
        mCanvasView = (ImageCanvasSurfaceView)findViewById(0x7f0d0229);
        mCanvasView.startRender();
        mCanvasView.setSpriteCallBack(this);
    }

    public Bitmap loadBitmapFromView(View view, int i, int j)
    {
        Log.v("lb", (new StringBuilder()).append("LayoutParams width = ").append(view.getLayoutParams().width).append(" height = ").append(view.getLayoutParams().height).toString());
        Bitmap bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.layout(0, 0, i, j);
        view.draw(canvas);
        return bitmap;
    }

    public void onHide()
    {
        if (mCanvasView != null)
        {
            mCanvasView.onHide();
            mCanvasView.setVisibility(8);
        }
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
    }

    public void onPause()
    {
        if (mCanvasView != null)
        {
            mCanvasView.onPause();
        }
    }

    public void onResume()
    {
        if (mCanvasView != null)
        {
            mCanvasView.onResume();
        }
    }

    public void onShow()
    {
        if (mCanvasView != null)
        {
            mCanvasView.onShow();
            mCanvasView.setVisibility(0);
        }
    }

    public void onStop()
    {
    }

    public void replaceSelectBitmap(Bitmap bitmap)
    {
        mCanvasView.replaceCurrentSpriteWithImage(bitmap);
    }

    public void setCollageBackGroup(TPhotoFreeComposeStyleInfo tphotofreecomposestyleinfo, int i)
    {
        Bitmap bitmap;
        Bitmap bitmap1;
        if (mFrameInfo == null)
        {
            mFrameInfo = tphotofreecomposestyleinfo;
            layoutCompose(i);
        } else
        {
            mFrameInfo = tphotofreecomposestyleinfo;
            layoutComposeReload(i);
        }
        if (mCanvasView == null) goto _L2; else goto _L1
_L1:
        bitmap1 = tphotofreecomposestyleinfo.getImageBitmap();
        if (bitmap1 != null) goto _L4; else goto _L3
_L3:
        bitmap = null;
_L6:
        try
        {
            mCanvasView.setBackgroundBitmap(tphotofreecomposestyleinfo.backgroundColor, bitmap, i, i, mFrameInfo.photoBackgroundColor);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
_L2:
        if (mFrameInfo.forgroundFrameurl != null && mFrameInfo.forgroundFrameurl.length() > 0)
        {
            tphotofreecomposestyleinfo = tphotofreecomposestyleinfo.getBitmapByPath(mFrameInfo.forgroundFrameurl);
            mCanvasView.setForeGroundBitmap(tphotofreecomposestyleinfo, i, i);
            return;
        } else
        {
            mCanvasView.setForeGroundBitmap(null, 0, 0);
            return;
        }
_L4:
        bitmap = bitmap1;
        if (i <= 0) goto _L6; else goto _L5
_L5:
        bitmap = Bitmap.createScaledBitmap(bitmap1, i, i, true);
          goto _L6
    }

    public void setCollageImages(List list, boolean flag, int i)
    {
        mBitmaps.clear();
        decMapBitmapIndex.clear();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Bitmap bitmap = (Bitmap)list.next();
            if (bitmap != null)
            {
                int k = bitmap.getWidth();
                int l = bitmap.getHeight();
                int j = Math.min(i / 2, k);
                k = (int)(((float)j / (float)k) * (float)l);
                if (j > 0 && k > 0)
                {
                    mBitmaps.add(Bitmap.createScaledBitmap(bitmap, j, k, true));
                }
            }
        } while (true);
    }

    public void setCollageStyle(TPhotoFreeFrameLayoutInfo tphotofreeframelayoutinfo, int i)
    {
        mComposeInfo = tphotofreeframelayoutinfo;
        layoutCompose(i);
    }

    public void setSpriteStateCallback(bph bph1)
    {
        listener = bph1;
    }

    public void spriteSelected(bkd bkd1)
    {
        if (currentSelectDec != bkd1 && listener != null)
        {
            int i = ((Integer)decMapBitmapIndex.get(bkd1)).intValue();
            listener.b(bkd1, i);
        }
        currentSelectDec = bkd1;
    }
}
