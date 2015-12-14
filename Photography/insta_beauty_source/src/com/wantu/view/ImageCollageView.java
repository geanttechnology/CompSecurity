// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import bpl;
import bpm;
import bpn;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.model.res.TFrameItemInfo;
import java.util.List;
import wantu.sephiroth.android.library.imagezoom.RoundCornerImageViewTouch;

// Referenced classes of package com.wantu.view:
//            ImagesMovingView

public class ImageCollageView extends RelativeLayout
    implements android.view.View.OnLongClickListener, bpn
{

    int KMaxPix;
    private String TAG;
    private List bitmaps;
    private float lastX;
    private float lastY;
    public bpl listener;
    TPhotoComposeInfo mComposeInfo;
    Context mContext;
    TFrameItemInfo mFrameInfo;
    int mHeight;
    int mWidth;
    RoundCornerImageViewTouch m_v1;
    RoundCornerImageViewTouch m_v2;
    RoundCornerImageViewTouch m_v3;
    RoundCornerImageViewTouch m_v4;
    RoundCornerImageViewTouch m_v5;
    RoundCornerImageViewTouch m_v6;
    RoundCornerImageViewTouch m_v7;
    RoundCornerImageViewTouch m_v8;
    RoundCornerImageViewTouch m_v9;
    private float mergetX;
    private float mergetY;
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

    private RoundCornerImageViewTouch getImageViewByRect(Rect rect)
    {
        int ai[] = new int[9];
        ai[0] = 0x7f0d00f1;
        ai[1] = 0x7f0d018d;
        ai[2] = 0x7f0d0243;
        ai[3] = 0x7f0d0244;
        ai[4] = 0x7f0d0245;
        ai[5] = 0x7f0d0246;
        ai[6] = 0x7f0d0247;
        ai[7] = 0x7f0d0248;
        ai[8] = 0x7f0d0249;
        for (int i = 0; i < ai.length; i++)
        {
            RoundCornerImageViewTouch roundcornerimageviewtouch = (RoundCornerImageViewTouch)findViewById(ai[i]);
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)roundcornerimageviewtouch.getLayoutParams();
            int j = layoutparams.leftMargin;
            int k = layoutparams.topMargin;
            int l = layoutparams.width;
            int i1 = layoutparams.height;
            if (rect.left == j && rect.top == k && rect.width() == l && rect.height() == i1)
            {
                return roundcornerimageviewtouch;
            }
        }

        return null;
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
        View.inflate(getContext(), 0x7f03006e, this);
        m_v1 = (RoundCornerImageViewTouch)findViewById(0x7f0d00f1);
        m_v1.setOnClickListener(new bpm(this, 0));
        m_v2 = (RoundCornerImageViewTouch)findViewById(0x7f0d018d);
        m_v2.setOnClickListener(new bpm(this, 1));
        m_v3 = (RoundCornerImageViewTouch)findViewById(0x7f0d0243);
        m_v3.setOnClickListener(new bpm(this, 2));
        m_v4 = (RoundCornerImageViewTouch)findViewById(0x7f0d0244);
        m_v4.setOnClickListener(new bpm(this, 3));
        m_v5 = (RoundCornerImageViewTouch)findViewById(0x7f0d0245);
        m_v5.setOnClickListener(new bpm(this, 4));
        m_v6 = (RoundCornerImageViewTouch)findViewById(0x7f0d0246);
        m_v6.setOnClickListener(new bpm(this, 5));
        m_v7 = (RoundCornerImageViewTouch)findViewById(0x7f0d0247);
        m_v7.setOnClickListener(new bpm(this, 6));
        m_v8 = (RoundCornerImageViewTouch)findViewById(0x7f0d0248);
        m_v8.setOnClickListener(new bpm(this, 7));
        m_v9 = (RoundCornerImageViewTouch)findViewById(0x7f0d0249);
        m_v9.setOnClickListener(new bpm(this, 8));
    }

    private void layoutCompose(int i, int j)
    {
        int k = (int)(((float)i / (float)j) * 306F);
        float f = (float)j / 306F;
        f = (float)i / (float)k;
        RoundCornerImageViewTouch roundcornerimageviewtouch = (RoundCornerImageViewTouch)findViewById(0x7f0d00f1);
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

    private boolean rectIsEqual(Rect rect, Rect rect1)
    {
        while (rect == null || rect1 == null || rect.left != rect1.left || rect.top != rect1.top || rect.bottom != rect1.bottom || rect.right != rect1.right) 
        {
            return false;
        }
        return true;
    }

    private void setAllImageViewsScroolEnable(boolean flag)
    {
        int ai[] = new int[9];
        ai[0] = 0x7f0d00f1;
        ai[1] = 0x7f0d018d;
        ai[2] = 0x7f0d0243;
        ai[3] = 0x7f0d0244;
        ai[4] = 0x7f0d0245;
        ai[5] = 0x7f0d0246;
        ai[6] = 0x7f0d0247;
        ai[7] = 0x7f0d0248;
        ai[8] = 0x7f0d0249;
        for (int i = 0; i < ai.length; i++)
        {
            RoundCornerImageViewTouch roundcornerimageviewtouch = (RoundCornerImageViewTouch)findViewById(ai[i]);
            if (roundcornerimageviewtouch != null)
            {
                roundcornerimageviewtouch.setScrollEnabled(flag);
            }
        }

    }

    public void ImageMovingTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 2: default 36
    //                   0 37
    //                   1 126
    //                   2 54;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        lastX = motionevent.getX();
        lastY = motionevent.getY();
        return;
_L4:
        if (movingView.getVisibility() != 4 && movingView != null)
        {
            float f = motionevent.getX();
            float f1 = motionevent.getY();
            int i = (int)(mergetX + f);
            int k = (int)(mergetY + f1);
            movingView.movePosition((int)(f - lastX), (int)(f1 - lastY), i, k);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (movingView != null && movingView.getVisibility() == 0)
        {
            motionevent = movingView.getStartRect();
            Object obj = movingView.getTargetRect();
            if (!rectIsEqual(motionevent, ((Rect) (obj))) && motionevent != null && obj != null)
            {
                motionevent = getImageViewByRect(motionevent);
                obj = getImageViewByRect(((Rect) (obj)));
                if (motionevent != null && obj != null)
                {
                    int j = ((Integer)motionevent.getTag()).intValue();
                    int l = ((Integer)((RoundCornerImageViewTouch) (obj)).getTag()).intValue();
                    Bitmap bitmap = getBitmapByTag(j);
                    motionevent.setImageBitmap(getBitmapByTag(l), true, null, 2.5F);
                    motionevent.setTag(Integer.valueOf(l));
                    ((RoundCornerImageViewTouch) (obj)).setImageBitmap(bitmap, true, null, 2.5F);
                    ((RoundCornerImageViewTouch) (obj)).setTag(Integer.valueOf(j));
                    if (listener != null)
                    {
                        listener.a(motionevent, ((View) (obj)));
                    }
                }
            }
            movingView.setVisibility(4);
            movingView.setStartRectAndBitmap(null, null);
            setAllImageViewsScroolEnable(true);
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void changeCornerRadius(int i)
    {
        RoundCornerImageViewTouch roundcornerimageviewtouch = (RoundCornerImageViewTouch)findViewById(0x7f0d00f1);
        RoundCornerImageViewTouch roundcornerimageviewtouch1 = (RoundCornerImageViewTouch)findViewById(0x7f0d018d);
        RoundCornerImageViewTouch roundcornerimageviewtouch2 = (RoundCornerImageViewTouch)findViewById(0x7f0d0243);
        RoundCornerImageViewTouch roundcornerimageviewtouch3 = (RoundCornerImageViewTouch)findViewById(0x7f0d0244);
        RoundCornerImageViewTouch roundcornerimageviewtouch4 = (RoundCornerImageViewTouch)findViewById(0x7f0d0245);
        RoundCornerImageViewTouch roundcornerimageviewtouch5 = (RoundCornerImageViewTouch)findViewById(0x7f0d0246);
        RoundCornerImageViewTouch roundcornerimageviewtouch6 = (RoundCornerImageViewTouch)findViewById(0x7f0d0247);
        RoundCornerImageViewTouch roundcornerimageviewtouch7 = (RoundCornerImageViewTouch)findViewById(0x7f0d0248);
        RoundCornerImageViewTouch roundcornerimageviewtouch8 = (RoundCornerImageViewTouch)findViewById(0x7f0d0249);
        roundcornerimageviewtouch.changeRadius(i);
        roundcornerimageviewtouch1.changeRadius(i);
        roundcornerimageviewtouch2.changeRadius(i);
        roundcornerimageviewtouch3.changeRadius(i);
        roundcornerimageviewtouch4.changeRadius(i);
        roundcornerimageviewtouch5.changeRadius(i);
        roundcornerimageviewtouch6.changeRadius(i);
        roundcornerimageviewtouch7.changeRadius(i);
        roundcornerimageviewtouch8.changeRadius(i);
        radius = i;
    }

    public void changeCornerRadius(boolean flag)
    {
        RoundCornerImageViewTouch roundcornerimageviewtouch = (RoundCornerImageViewTouch)findViewById(0x7f0d00f1);
        RoundCornerImageViewTouch roundcornerimageviewtouch1 = (RoundCornerImageViewTouch)findViewById(0x7f0d018d);
        RoundCornerImageViewTouch roundcornerimageviewtouch2 = (RoundCornerImageViewTouch)findViewById(0x7f0d0243);
        RoundCornerImageViewTouch roundcornerimageviewtouch3 = (RoundCornerImageViewTouch)findViewById(0x7f0d0244);
        RoundCornerImageViewTouch roundcornerimageviewtouch4 = (RoundCornerImageViewTouch)findViewById(0x7f0d0245);
        RoundCornerImageViewTouch roundcornerimageviewtouch5 = (RoundCornerImageViewTouch)findViewById(0x7f0d0246);
        RoundCornerImageViewTouch roundcornerimageviewtouch6 = (RoundCornerImageViewTouch)findViewById(0x7f0d0247);
        RoundCornerImageViewTouch roundcornerimageviewtouch7 = (RoundCornerImageViewTouch)findViewById(0x7f0d0248);
        RoundCornerImageViewTouch roundcornerimageviewtouch8 = (RoundCornerImageViewTouch)findViewById(0x7f0d0249);
        int i = (int)getContext().getResources().getDimension(0x7f08002f);
        if (!flag)
        {
            i = 0;
        }
        roundcornerimageviewtouch.changeRadius(i);
        roundcornerimageviewtouch1.changeRadius(i);
        roundcornerimageviewtouch2.changeRadius(i);
        roundcornerimageviewtouch3.changeRadius(i);
        roundcornerimageviewtouch4.changeRadius(i);
        roundcornerimageviewtouch5.changeRadius(i);
        roundcornerimageviewtouch6.changeRadius(i);
        roundcornerimageviewtouch7.changeRadius(i);
        roundcornerimageviewtouch8.changeRadius(i);
        radius = i;
    }

    public void clearImageViwesBitmap()
    {
        RoundCornerImageViewTouch roundcornerimageviewtouch = (RoundCornerImageViewTouch)findViewById(0x7f0d00f1);
        RoundCornerImageViewTouch roundcornerimageviewtouch1 = (RoundCornerImageViewTouch)findViewById(0x7f0d018d);
        RoundCornerImageViewTouch roundcornerimageviewtouch2 = (RoundCornerImageViewTouch)findViewById(0x7f0d0243);
        RoundCornerImageViewTouch roundcornerimageviewtouch3 = (RoundCornerImageViewTouch)findViewById(0x7f0d0244);
        RoundCornerImageViewTouch roundcornerimageviewtouch4 = (RoundCornerImageViewTouch)findViewById(0x7f0d0245);
        RoundCornerImageViewTouch roundcornerimageviewtouch5 = (RoundCornerImageViewTouch)findViewById(0x7f0d0246);
        RoundCornerImageViewTouch roundcornerimageviewtouch6 = (RoundCornerImageViewTouch)findViewById(0x7f0d0247);
        RoundCornerImageViewTouch roundcornerimageviewtouch7 = (RoundCornerImageViewTouch)findViewById(0x7f0d0248);
        RoundCornerImageViewTouch roundcornerimageviewtouch8 = (RoundCornerImageViewTouch)findViewById(0x7f0d0249);
        roundcornerimageviewtouch.clear();
        roundcornerimageviewtouch1.clear();
        roundcornerimageviewtouch2.clear();
        roundcornerimageviewtouch3.clear();
        roundcornerimageviewtouch4.clear();
        roundcornerimageviewtouch5.clear();
        roundcornerimageviewtouch6.clear();
        roundcornerimageviewtouch7.clear();
        roundcornerimageviewtouch8.clear();
        if (bitmaps != null)
        {
            bitmaps.clear();
        }
        radius = 0.0F;
    }

    public Bitmap getOutputImage()
    {
        return null;
    }

    public float getRadius()
    {
        return radius;
    }

    public void movingPosition(int i, int j)
    {
    }

    public boolean onLongClick(View view)
    {
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" onLongClick:").toString());
        if (movingView != null)
        {
            movingView.setVisibility(0);
        }
        if (view instanceof RoundCornerImageViewTouch)
        {
            view = (RoundCornerImageViewTouch)view;
            view.setScrollEnabled(false);
            Object obj = (android.widget.FrameLayout.LayoutParams)view.getLayoutParams();
            int i = ((android.widget.FrameLayout.LayoutParams) (obj)).leftMargin;
            int j = ((android.widget.FrameLayout.LayoutParams) (obj)).topMargin;
            int k = ((android.widget.FrameLayout.LayoutParams) (obj)).width;
            int l = ((android.widget.FrameLayout.LayoutParams) (obj)).height;
            mergetX = i;
            mergetY = j;
            obj = new Rect();
            obj.left = i;
            obj.right = i + k;
            obj.top = j;
            obj.bottom = j + l;
            if (movingView != null)
            {
                view = view.getDispalyImage(k, l);
                movingView.setStartRectAndBitmap(((Rect) (obj)), view);
            }
        }
        return true;
    }

    public void setCollageBackGroup(TFrameItemInfo tframeiteminfo, Context context)
    {
        mFrameInfo = tframeiteminfo;
        context = (ImageView)findViewById(0x7f0d0242);
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
        bitmaps = list;
        RoundCornerImageViewTouch roundcornerimageviewtouch = (RoundCornerImageViewTouch)findViewById(0x7f0d00f1);
        RoundCornerImageViewTouch roundcornerimageviewtouch1 = (RoundCornerImageViewTouch)findViewById(0x7f0d018d);
        RoundCornerImageViewTouch roundcornerimageviewtouch2 = (RoundCornerImageViewTouch)findViewById(0x7f0d0243);
        RoundCornerImageViewTouch roundcornerimageviewtouch3 = (RoundCornerImageViewTouch)findViewById(0x7f0d0244);
        RoundCornerImageViewTouch roundcornerimageviewtouch4 = (RoundCornerImageViewTouch)findViewById(0x7f0d0245);
        RoundCornerImageViewTouch roundcornerimageviewtouch5 = (RoundCornerImageViewTouch)findViewById(0x7f0d0246);
        RoundCornerImageViewTouch roundcornerimageviewtouch6 = (RoundCornerImageViewTouch)findViewById(0x7f0d0247);
        RoundCornerImageViewTouch roundcornerimageviewtouch7 = (RoundCornerImageViewTouch)findViewById(0x7f0d0248);
        RoundCornerImageViewTouch roundcornerimageviewtouch8 = (RoundCornerImageViewTouch)findViewById(0x7f0d0249);
        int i;
        if (list.size() > 8)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        roundcornerimageviewtouch8.setVisibility(i);
        if (list.size() > 7)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        roundcornerimageviewtouch7.setVisibility(i);
        if (list.size() > 6)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        roundcornerimageviewtouch6.setVisibility(i);
        if (list.size() > 5)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        roundcornerimageviewtouch5.setVisibility(i);
        if (list.size() > 4)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        roundcornerimageviewtouch4.setVisibility(i);
        if (list.size() > 3)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        roundcornerimageviewtouch3.setVisibility(i);
        if (list.size() > 2)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        roundcornerimageviewtouch2.setVisibility(i);
        if (list.size() > 1)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        roundcornerimageviewtouch1.setVisibility(i);
        if (list.size() > 0)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        roundcornerimageviewtouch.setVisibility(i);
        roundcornerimageviewtouch.setOnLongClickListener(this);
        roundcornerimageviewtouch1.setOnLongClickListener(this);
        roundcornerimageviewtouch2.setOnLongClickListener(this);
        roundcornerimageviewtouch3.setOnLongClickListener(this);
        roundcornerimageviewtouch4.setOnLongClickListener(this);
        roundcornerimageviewtouch5.setOnLongClickListener(this);
        roundcornerimageviewtouch6.setOnLongClickListener(this);
        roundcornerimageviewtouch7.setOnLongClickListener(this);
        roundcornerimageviewtouch8.setOnLongClickListener(this);
        roundcornerimageviewtouch.setMovingListener(this);
        roundcornerimageviewtouch1.setMovingListener(this);
        roundcornerimageviewtouch2.setMovingListener(this);
        roundcornerimageviewtouch3.setMovingListener(this);
        roundcornerimageviewtouch4.setMovingListener(this);
        roundcornerimageviewtouch5.setMovingListener(this);
        roundcornerimageviewtouch6.setMovingListener(this);
        roundcornerimageviewtouch7.setMovingListener(this);
        roundcornerimageviewtouch8.setMovingListener(this);
        roundcornerimageviewtouch.setTag(Integer.valueOf(0));
        roundcornerimageviewtouch1.setTag(Integer.valueOf(1));
        roundcornerimageviewtouch2.setTag(Integer.valueOf(2));
        roundcornerimageviewtouch3.setTag(Integer.valueOf(3));
        roundcornerimageviewtouch4.setTag(Integer.valueOf(4));
        roundcornerimageviewtouch5.setTag(Integer.valueOf(5));
        roundcornerimageviewtouch6.setTag(Integer.valueOf(6));
        roundcornerimageviewtouch7.setTag(Integer.valueOf(7));
        roundcornerimageviewtouch8.setTag(Integer.valueOf(8));
        if (list.size() <= 5);
        if (roundcornerimageviewtouch.getVisibility() == 0)
        {
            roundcornerimageviewtouch.setImageBitmap((Bitmap)list.get(0), flag, null, 2.5F);
        }
        if (roundcornerimageviewtouch1.getVisibility() == 0)
        {
            roundcornerimageviewtouch1.setImageBitmap((Bitmap)list.get(1), flag, null, 2.5F);
        }
        if (roundcornerimageviewtouch2.getVisibility() == 0)
        {
            roundcornerimageviewtouch2.setImageBitmap((Bitmap)list.get(2), flag, null, 2.5F);
        }
        if (roundcornerimageviewtouch3.getVisibility() == 0)
        {
            roundcornerimageviewtouch3.setImageBitmap((Bitmap)list.get(3), flag, null, 2.5F);
        }
        if (roundcornerimageviewtouch4.getVisibility() == 0)
        {
            roundcornerimageviewtouch4.setImageBitmap((Bitmap)list.get(4), flag, null, 2.5F);
        }
        if (roundcornerimageviewtouch5.getVisibility() == 0)
        {
            roundcornerimageviewtouch5.setImageBitmap((Bitmap)list.get(5), flag, null, 2.5F);
        }
        if (roundcornerimageviewtouch6.getVisibility() == 0)
        {
            roundcornerimageviewtouch6.setImageBitmap((Bitmap)list.get(6), flag, null, 2.5F);
        }
        if (roundcornerimageviewtouch7.getVisibility() == 0)
        {
            roundcornerimageviewtouch7.setImageBitmap((Bitmap)list.get(7), flag, null, 2.5F);
        }
        if (roundcornerimageviewtouch8.getVisibility() == 0)
        {
            roundcornerimageviewtouch8.setImageBitmap((Bitmap)list.get(8), flag, null, 2.5F);
        }
    }

    public void setCollageStyle(TPhotoComposeInfo tphotocomposeinfo)
    {
        mComposeInfo = tphotocomposeinfo;
        invalidate();
    }

    public void setCollageStyle(TPhotoComposeInfo tphotocomposeinfo, int i)
    {
        mHeight = i;
        mWidth = i;
        mComposeInfo = tphotocomposeinfo;
        radius = getResources().getDisplayMetrics().density * 1.0F;
        layoutCompose(i, i);
        requestLayout();
        setMovingViewParamters();
    }

    public void setCollageStyle(TPhotoComposeInfo tphotocomposeinfo, int i, int j)
    {
        mHeight = i;
        mWidth = j;
        mComposeInfo = tphotocomposeinfo;
        radius = getResources().getDisplayMetrics().density * 1.0F;
        tphotocomposeinfo = getLayoutParams();
        tphotocomposeinfo.height = i;
        tphotocomposeinfo.width = j;
        layoutCompose(i, j);
        requestLayout();
        setMovingViewParamters();
    }

    public void setIsUseShade(boolean flag)
    {
        m_v1.setIsUsingShadow(flag);
        m_v2.setIsUsingShadow(flag);
        m_v3.setIsUsingShadow(flag);
        m_v4.setIsUsingShadow(flag);
        m_v5.setIsUsingShadow(flag);
        m_v6.setIsUsingShadow(flag);
        m_v7.setIsUsingShadow(flag);
        m_v8.setIsUsingShadow(flag);
        m_v9.setIsUsingShadow(flag);
    }

    public void setItemOnClickListener(bpl bpl1)
    {
        listener = bpl1;
    }

    public void setMovingViewParamters()
    {
    }

    public void setViewBitmap(View view, Bitmap bitmap)
    {
        if (m_v1 == view)
        {
            m_v1.setImageBitmap(bitmap);
        }
        if (m_v2 == view)
        {
            m_v2.setImageBitmap(bitmap);
        }
        if (m_v3 == view)
        {
            m_v3.setImageBitmap(bitmap);
        }
        if (m_v4 == view)
        {
            m_v4.setImageBitmap(bitmap);
        }
        if (m_v5 == view)
        {
            m_v5.setImageBitmap(bitmap);
        }
        if (m_v6 == view)
        {
            m_v6.setImageBitmap(bitmap);
        }
        if (m_v7 == view)
        {
            m_v7.setImageBitmap(bitmap);
        }
        if (m_v8 == view)
        {
            m_v8.setImageBitmap(bitmap);
        }
        if (m_v9 == view)
        {
            m_v9.setImageBitmap(bitmap);
        }
    }
}
