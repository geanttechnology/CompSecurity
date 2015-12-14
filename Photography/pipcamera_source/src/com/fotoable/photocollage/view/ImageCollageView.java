// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view;

import aix;
import aiy;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.fotoable.photocollage.model.res.collage.TPhotoCollageComposeInfo;
import com.instamag.activity.view.ImagesMovingView;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.model.res.TFrameItemInfo;
import ev;
import java.util.ArrayList;
import java.util.List;
import lz;
import wantu.sephiroth.android.library.imagezoom.TRoundImageViewLayout;

public class ImageCollageView extends RelativeLayout
    implements aix
{

    int KMaxPix;
    private String TAG;
    private List bitmaps;
    private int edge;
    lz listener;
    TPhotoCollageComposeInfo mComposeInfo;
    Context mContext;
    TFrameItemInfo mFrameInfo;
    int mHeight;
    boolean mIsFirstSet;
    boolean mIsUsingBK;
    boolean mIsUsingShadow;
    TRoundImageViewLayout mTRoundImageViewLayout;
    int mWidth;
    ImagesMovingView movingView;
    private float radius;

    public ImageCollageView(Context context)
    {
        super(context);
        KMaxPix = 612;
        TAG = "ImageCollageView";
        bitmaps = null;
        initView();
    }

    public ImageCollageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        KMaxPix = 612;
        TAG = "ImageCollageView";
        bitmaps = null;
        initView();
    }

    public ImageCollageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        KMaxPix = 612;
        TAG = "ImageCollageView";
        bitmaps = null;
        initView();
    }

    private Bitmap getBitmapByTag(int i)
    {
        while (bitmaps == null || bitmaps.size() <= i) 
        {
            return null;
        }
        return (Bitmap)bitmaps.get(i);
    }

    private Rect getLayoutPosition(int i, Rect rect)
    {
        float f = (float)i / 306F;
        i = (int)((float)rect.left * f + 0.5F);
        int j = (int)((float)rect.top * f + 0.5F);
        int k = (int)((float)(rect.right - rect.left) * f + 0.5F);
        int l = (int)(f * (float)(rect.bottom - rect.top) + 0.5F);
        rect = new Rect();
        rect.left = i;
        rect.top = j;
        rect.right = i + k;
        rect.bottom = l + j;
        return rect;
    }

    private void initView()
    {
        View.inflate(getContext(), 0x7f030043, this);
        mTRoundImageViewLayout = (TRoundImageViewLayout)findViewById(0x7f0c013a);
        mTRoundImageViewLayout.setDelegate(this);
    }

    private void layoutCompose(int i, int j)
    {
        int k = (int)(((float)i / (float)j) * 306F);
        float f = (float)j / 306F;
        float f1 = (float)i / (float)k;
        mTRoundImageViewLayout.setVisibility(0);
        aiy aiy1 = new aiy(translatePointsListWithScale(1.0F, f, f1), mComposeInfo.getVectorPointsArray(), bitmaps, (int)radius, mIsUsingShadow, mIsFirstSet, 2.5F);
        aiy1.a(mComposeInfo.getDefaultEdge());
        mTRoundImageViewLayout.configByInfo(aiy1);
    }

    public static Bitmap loadBitmapFromView(View view, int i, int j)
    {
        Log.v("lb", (new StringBuilder()).append("LayoutParams width = ").append(view.getLayoutParams().width).append(" height = ").append(view.getLayoutParams().height).toString());
        Bitmap bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.layout(0, 0, i, j);
        view.draw(canvas);
        return bitmap;
    }

    private List translatePointsListWithScale(float f, float f1, float f2)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < mComposeInfo.getTrackPointsArray().size(); i++)
        {
            ArrayList arraylist1 = new ArrayList();
            List list = (List)mComposeInfo.getTrackPointsArray().get(i);
            if (list != null && list.size() > 0)
            {
                for (int j = 0; j < list.size(); j++)
                {
                    Point point = (Point)list.get(j);
                    arraylist1.add(new Point((int)((float)point.x * f * f1 + 0.5F), (int)((float)point.y * f * f2 + 0.5F)));
                }

            }
            arraylist.add(arraylist1);
        }

        return arraylist;
    }

    private List translatePointsWithScale(List list, float f, float f1, float f2)
    {
        ArrayList arraylist = new ArrayList();
        if (list != null && list.size() > 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                Point point = (Point)list.get(i);
                arraylist.add(new Point((int)((float)point.x * f * f1 + 0.5F), (int)((float)point.y * f * f2 + 0.5F)));
            }

        }
        return arraylist;
    }

    public void cancelSelected()
    {
        if (mTRoundImageViewLayout != null && mTRoundImageViewLayout.getVisibility() == 0)
        {
            mTRoundImageViewLayout.cancelSelected();
        }
    }

    public void changeCornerRadius(int i)
    {
        if (mTRoundImageViewLayout != null && mTRoundImageViewLayout.getVisibility() == 0)
        {
            mTRoundImageViewLayout.changeViewCorner(i);
        }
        radius = i;
    }

    public void changeCornerRadius(boolean flag)
    {
        int i = (int)getContext().getResources().getDimension(0x7f08002d);
        if (!flag)
        {
            i = 0;
        }
        if (mTRoundImageViewLayout != null && mTRoundImageViewLayout.getVisibility() == 0)
        {
            mTRoundImageViewLayout.changeViewCorner(i);
        }
        radius = i;
    }

    public void changeEdge(int i)
    {
        edge = i;
        if (mTRoundImageViewLayout != null && mTRoundImageViewLayout.getVisibility() == 0)
        {
            mTRoundImageViewLayout.changeViewEdge(i);
        }
    }

    public void clearImageViwesBitmap()
    {
        if (mTRoundImageViewLayout != null)
        {
            mTRoundImageViewLayout.setBitmapsNull();
        }
        if (bitmaps != null)
        {
            bitmaps.clear();
        }
        radius = 0.0F;
    }

    public void clearResource(boolean flag)
    {
        if (flag && mTRoundImageViewLayout != null)
        {
            mTRoundImageViewLayout.setBitmapsNull();
        }
    }

    public float getEdge()
    {
        if (mTRoundImageViewLayout != null && mTRoundImageViewLayout.getVisibility() == 0)
        {
            return (float)mTRoundImageViewLayout.getEdge();
        } else
        {
            return (float)edge;
        }
    }

    public Bitmap getOutputImage()
    {
        Paint paint = new Paint(1);
        float f;
        Object obj;
        Bitmap bitmap;
        Canvas canvas;
        Object obj1;
        int i;
        int j;
        int k;
        if (PIPCameraApplication.b)
        {
            i = 612;
        } else
        {
            i = 960;
        }
        Exception exception;
        if (mComposeInfo != null)
        {
            j = (int)((float)i * mComposeInfo.getAspectRatio());
        } else
        {
            j = i;
        }
        bitmap = Bitmap.createBitmap(i, j, ev.a(false));
        canvas = new Canvas(bitmap);
        if (mFrameInfo == null) goto _L2; else goto _L1
_L1:
        if (!mFrameInfo.isTiledImage) goto _L4; else goto _L3
_L3:
        obj1 = mFrameInfo.getImageBitmap();
        if ((new BitmapDrawable(getResources(), null)).getOpacity() == -1) goto _L6; else goto _L5
_L5:
        obj = android.graphics.Bitmap.Config.ARGB_8888;
_L7:
        obj = ev.a(((Bitmap) (obj1)), i, j, ((android.graphics.Bitmap.Config) (obj)));
_L8:
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_279;
        }
        try
        {
            canvas.drawColor(mFrameInfo.getBgColor());
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
_L2:
        if (mTRoundImageViewLayout != null && mTRoundImageViewLayout.getVisibility() == 0)
        {
            k = mTRoundImageViewLayout.getWidth();
            f = (float)i / (float)k;
            obj = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
            obj1 = new Canvas(((Bitmap) (obj)));
            ((Canvas) (obj1)).setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            ((Canvas) (obj1)).scale(f, f);
            mTRoundImageViewLayout.draw(((Canvas) (obj1)));
            if (obj != null && !((Bitmap) (obj)).isRecycled())
            {
                canvas.drawBitmap(((Bitmap) (obj)), 0.0F, 0.0F, paint);
                ((Bitmap) (obj)).recycle();
            }
        }
        return bitmap;
_L6:
        obj = android.graphics.Bitmap.Config.RGB_565;
          goto _L7
_L4:
        obj = mFrameInfo.getImageBitmap();
          goto _L8
        canvas.drawBitmap(((Bitmap) (obj)), new Rect(0, 0, ((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight()), new Rect(0, 0, i, j), paint);
          goto _L2
    }

    public float getRadius()
    {
        if (mTRoundImageViewLayout != null && mTRoundImageViewLayout.getVisibility() == 0)
        {
            return (float)mTRoundImageViewLayout.getViewCorner();
        } else
        {
            return radius;
        }
    }

    public Bitmap getSelectBitmap()
    {
        int i = getSelectIndex();
        if (i == -1)
        {
            return null;
        } else
        {
            return getBitmapByTag(i);
        }
    }

    public int getSelectIndex()
    {
        if (mTRoundImageViewLayout != null && mTRoundImageViewLayout.getVisibility() == 0)
        {
            return mTRoundImageViewLayout.getSelectIndex();
        } else
        {
            return -1;
        }
    }

    public Bitmap getTouchBitmapWithTag(int i)
    {
        return getBitmapByTag(i);
    }

    public boolean isUseBK()
    {
        return mIsUsingBK;
    }

    public boolean isUseShadow()
    {
        if (mTRoundImageViewLayout != null && mTRoundImageViewLayout.getVisibility() == 0)
        {
            mTRoundImageViewLayout.isUseShadow();
        }
        return mIsUsingShadow;
    }

    public void setCollageBackGroup(TFrameItemInfo tframeiteminfo, Context context)
    {
        mFrameInfo = tframeiteminfo;
        context = (ImageView)findViewById(0x7f0c0139);
        Bitmap bitmap;
        try
        {
            bitmap = tframeiteminfo.getImageBitmap();
        }
        // Misplaced declaration of an exception variable
        catch (TFrameItemInfo tframeiteminfo)
        {
            return;
        }
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        context.setImageBitmap(null);
        context.setBackgroundColor(tframeiteminfo.getBgColor());
        return;
        if (tframeiteminfo.isTiledImage)
        {
            context.setImageBitmap(null);
            tframeiteminfo = new BitmapDrawable(getResources(), bitmap);
            tframeiteminfo.setTileModeXY(android.graphics.Shader.TileMode.REPEAT, android.graphics.Shader.TileMode.REPEAT);
            context.setBackgroundDrawable(tframeiteminfo);
            return;
        }
        context.setImageBitmap(null);
        context.setBackgroundColor(0xff000000);
        context.setImageBitmap(bitmap);
        return;
    }

    public void setCollageImages(List list, boolean flag)
    {
        clearResource(true);
        bitmaps = list;
        mIsFirstSet = flag;
    }

    public void setCollageStyle(TPhotoCollageComposeInfo tphotocollagecomposeinfo)
    {
        mComposeInfo = tphotocollagecomposeinfo;
        invalidate();
    }

    public void setCollageStyle(TPhotoCollageComposeInfo tphotocollagecomposeinfo, int i, int j)
    {
        mHeight = i;
        mWidth = j;
        mComposeInfo = tphotocollagecomposeinfo;
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        float f = tphotocollagecomposeinfo.getRoundRadius();
        radius = displaymetrics.density * f;
        tphotocollagecomposeinfo = getLayoutParams();
        tphotocollagecomposeinfo.height = i;
        tphotocollagecomposeinfo.width = j;
        layoutCompose(i, j);
        requestLayout();
        clearResource(false);
    }

    public void setCollageWithRepleacedImages(List list)
    {
        clearResource(false);
        bitmaps = list;
    }

    public void setIsTransForm(boolean flag)
    {
        if (mTRoundImageViewLayout != null && mTRoundImageViewLayout.getVisibility() == 0)
        {
            mTRoundImageViewLayout.setIsTransform(flag);
        }
    }

    public void setIsUseBK(boolean flag)
    {
        mIsUsingBK = flag;
        if (mTRoundImageViewLayout != null && mTRoundImageViewLayout.getVisibility() == 0)
        {
            mTRoundImageViewLayout.setIsUsingBK(flag);
        }
    }

    public void setIsUseShade(boolean flag)
    {
        mIsUsingShadow = flag;
        if (mTRoundImageViewLayout != null && mTRoundImageViewLayout.getVisibility() == 0)
        {
            mTRoundImageViewLayout.setIsUsingShadow(flag);
        }
    }

    public void setItemOnClickListener(lz lz)
    {
        listener = lz;
        if (mTRoundImageViewLayout != null)
        {
            mTRoundImageViewLayout.setOnViewItemClickListener(listener);
        }
    }

    public void setSelectBitmap(Bitmap bitmap, boolean flag)
    {
        if (mTRoundImageViewLayout != null && mTRoundImageViewLayout.getVisibility() == 0)
        {
            mTRoundImageViewLayout.setSelectedBitmap(bitmap);
            int i = mTRoundImageViewLayout.getSelectIndex();
            bitmaps.set(i, bitmap);
        }
    }
}
