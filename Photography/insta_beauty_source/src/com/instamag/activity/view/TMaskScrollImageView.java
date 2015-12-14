// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import bfp;
import bfq;
import bfr;
import bfs;
import bjf;
import bku;
import bpn;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMaskInfo;
import com.wantu.imagelib.filter.TImageFilterManager;
import com.wantu.imagerender.ImageGLSurfaceView;
import java.util.Iterator;
import java.util.List;
import wantu.sephiroth.android.library.imagezoom.MaskScrollImageViewTouch;

// Referenced classes of package com.instamag.activity.view:
//            MaskColorView

public class TMaskScrollImageView extends FrameLayout
{

    private static final String TAG = "TMaskScrollImageView";
    private MaskScrollImageViewTouch backImageView;
    private MaskColorView backgroundAlpaView;
    private Bitmap backgroundSrcBmp;
    private Bitmap centerSrcBmp;
    private MaskScrollImageViewTouch centerView;
    private MaskScrollImageViewTouch clickedViewTouch;
    private ImageView foregroundView;
    private TImageFilterManager mFilterManager;
    private TPhotoMaskInfo maskInfo;
    private bfs maskViewDelegate;

    public TMaskScrollImageView(Context context, TPhotoMaskInfo tphotomaskinfo, Bitmap bitmap)
    {
        super(context);
        maskViewDelegate = null;
        maskInfo = tphotomaskinfo;
        centerSrcBmp = bitmap;
        createSubViews(context, tphotomaskinfo, bitmap);
    }

    private void MaskScrollImageViewTouchClicked(MaskScrollImageViewTouch maskscrollimageviewtouch)
    {
        clickedViewTouch = maskscrollimageviewtouch;
        if (maskViewDelegate != null)
        {
            maskViewDelegate.MaskInfoScrollViewClicked(this);
        }
    }

    private void createSubViews(Context context, TPhotoMaskInfo tphotomaskinfo, Bitmap bitmap)
    {
        addView(backgroundAlpaView, layoutparams);
        centerView = new MaskScrollImageViewTouch(context);
        centerView.setOnClickListener(new bfq(this));
        if (maskInfo.innerFrame != null && !maskInfo.innerFrame.isEmpty())
        {
            android.widget.FrameLayout.LayoutParams layoutparams1 = new android.widget.FrameLayout.LayoutParams((int)TPhotoComposeInfo.getScaledValue(maskInfo.innerFrame.width()), (int)TPhotoComposeInfo.getScaledValue(maskInfo.innerFrame.height()));
            layoutparams1.setMargins((int)TPhotoComposeInfo.getScaledValue(maskInfo.innerFrame.left), (int)TPhotoComposeInfo.getScaledValue(maskInfo.innerFrame.top), 0, 0);
            layoutparams1.gravity = 51;
            addView(centerView, layoutparams1);
            if (tphotomaskinfo.maskImagePath != null && tphotomaskinfo.maskImagePath.length() != 0)
            {
                centerView.setMask(getAlphaMaskBitmapByInfo(tphotomaskinfo, tphotomaskinfo.maskImagePath));
            }
        }
        if (maskInfo.foregroundFrame != null && !tphotomaskinfo.foregroundFrame.isEmpty())
        {
            foregroundView = new ImageView(context);
            context = new android.widget.FrameLayout.LayoutParams((int)(maskInfo.foregroundFrame.width() * TPhotoComposeInfo.scale), (int)(maskInfo.foregroundFrame.height() * TPhotoComposeInfo.scale));
            context.setMargins((int)TPhotoComposeInfo.getScaledValue(maskInfo.foregroundFrame.left), (int)TPhotoComposeInfo.getScaledValue(maskInfo.foregroundFrame.top), 0, 0);
            context.gravity = 51;
            addView(foregroundView, context);
            if (tphotomaskinfo.foregroundColor != 0)
            {
                foregroundView.setBackgroundColor(tphotomaskinfo.foregroundColor);
            }
            if (tphotomaskinfo.foregroundImagePath != null && tphotomaskinfo.foregroundImagePath.length() > 0)
            {
                foregroundView.setImageBitmap(tphotomaskinfo.getBitmapByPath(tphotomaskinfo.foregroundImagePath));
            }
        }
        if (tphotomaskinfo.is3DTransform())
        {
            float f = ((Float)tphotomaskinfo.transforms.get(0)).floatValue();
            ((Float)tphotomaskinfo.transforms.get(1)).floatValue();
            float f1 = ((Float)tphotomaskinfo.transforms.get(2)).floatValue();
            float f3 = ((Float)tphotomaskinfo.transforms.get(3)).floatValue();
            float f5 = ((Float)tphotomaskinfo.transforms.get(4)).floatValue();
            if ((double)f < 1.0D)
            {
                f = 1.0F;
            }
            context = get3dProcessBitmap(centerSrcBmp, f1, f3, f5);
            if (context != null)
            {
                i = (int)TPhotoComposeInfo.getScaledValue(maskInfo.innerFrame.width());
                int j = (int)TPhotoComposeInfo.getScaledValue(maskInfo.innerFrame.height());
                float f2 = (float)i / 2.0F;
                float f4 = (float)j / 2.0F;
                if (f != 1.0F)
                {
                    centerView.zoomScaleToFitView(f, f2, f4);
                }
                updateCenterViewImage(context);
                return;
            } else
            {
                centerView.setImageBitmap(bitmap);
                return;
            }
        } else
        {
            centerView.setImageBitmap(bitmap);
            return;
        }
        {
            backImageView = new MaskScrollImageViewTouch(context);
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            layoutparams.gravity = 51;
            addView(backImageView, layoutparams);
            if (tphotomaskinfo.backgroundColor != 0)
            {
                backImageView.setBackgroundColor(tphotomaskinfo.backgroundColor);
            }
            if (tphotomaskinfo.backgroundImagePath != null && tphotomaskinfo.backgroundImagePath.length() != 0)
            {
                backImageView.setImageBitmap(tphotomaskinfo.getBitmapByPath(tphotomaskinfo.backgroundImagePath));
            }
            if (!tphotomaskinfo.isPIP)
            {
                break MISSING_BLOCK_LABEL_255;
            }
            backImageView.setImageBitmap(bitmap);
            backImageView.setOnClickListener(new bfp(this));
            if (tphotomaskinfo.backmaskImagePath != null && tphotomaskinfo.backmaskImagePath.length() > 0)
            {
                backImageView.setMask(getAlphaMaskBitmapByInfo(tphotomaskinfo, tphotomaskinfo.backmaskImagePath));
            }
            if (tphotomaskinfo.backgroundColor == 0)
            {
                break MISSING_BLOCK_LABEL_255;
            }
            layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            layoutparams.gravity = 51;
            backgroundAlpaView = new MaskColorView(context);
            backgroundAlpaView.setClickable(false);
            if (backImageView != null)
            {
                backImageView.setBackgroundColor(0);
            }
            int i;
            if (tphotomaskinfo.backmaskImagePath != null && tphotomaskinfo.backmaskImagePath.length() > 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
        }
        if ((i == 0 || tphotomaskinfo.backgroundColor == 0) && tphotomaskinfo.backgroundColor != 0)
        {
            backgroundAlpaView.setBackgroundColor(tphotomaskinfo.backgroundColor);
        }
        break MISSING_BLOCK_LABEL_245;
    }

    private boolean existFilterName(String s)
    {
        for (Iterator iterator = getFilterManger().getmKeyOderArray().iterator(); iterator.hasNext();)
        {
            if (((String)iterator.next()).equalsIgnoreCase(s))
            {
                return true;
            }
        }

        return false;
    }

    private Bitmap get3dProcessBitmap(Bitmap bitmap, float f, float f1, float f2)
    {
        Bitmap bitmap1;
        try
        {
            bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap1);
            Matrix matrix = new Matrix();
            Camera camera = new Camera();
            if (android.os.Build.VERSION.SDK_INT >= 12)
            {
                camera.setLocation(0.0F, 0.0F, bitmap.getWidth() / 2);
            }
            camera.save();
            float f3 = (float)bitmap.getWidth() / 2.0F;
            float f4 = (float)bitmap.getHeight() / 2.0F;
            camera.rotateZ(-f2);
            camera.rotateY(f1);
            camera.rotateX(f);
            camera.getMatrix(matrix);
            matrix.preTranslate(-f3, -f4);
            matrix.postTranslate(f3, f4);
            canvas.drawBitmap(bitmap, matrix, null);
            camera.restore();
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return null;
        }
        return bitmap1;
    }

    private Bitmap getAlphaMaskBitmapByInfo(TPhotoMaskInfo tphotomaskinfo, String s)
    {
        if (tphotomaskinfo != null && s != null)
        {
            if ((tphotomaskinfo = tphotomaskinfo.getBitmapByPath(s)) != null)
            {
                s = tphotomaskinfo.extractAlpha();
                tphotomaskinfo.recycle();
                return s;
            }
        }
        return null;
    }

    private TImageFilterManager getFilterManger()
    {
        if (mFilterManager == null)
        {
            mFilterManager = new TImageFilterManager();
        }
        return mFilterManager;
    }

    private boolean isOriginalFilter(String s)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            if (s != null)
            {
                flag = flag1;
                if (s == null)
                {
                    break label0;
                }
                flag = flag1;
                if (s.length() != 0)
                {
                    break label0;
                }
            }
            flag = true;
        }
        if (s != null && s.equalsIgnoreCase(getContext().getResources().getString(0x7f0601a0)))
        {
            return true;
        } else
        {
            return flag;
        }
    }

    private void processforeGroundCenterViewByFilterName(ImageGLSurfaceView imageglsurfaceview, String s, Bitmap bitmap, boolean flag)
    {
        if (flag)
        {
            updateCenterViewImageWithSameScale(bitmap);
            return;
        } else
        {
            updateCenterViewImage(bitmap);
            return;
        }
    }

    public void changeMaskScrollViewImage(Bitmap bitmap, ImageGLSurfaceView imageglsurfaceview)
    {
        if (centerView != null)
        {
            updateCenterViewImage(bitmap);
        }
        if (backImageView != null && maskInfo.isPIP)
        {
            processBackgroundGaussianCenterView(imageglsurfaceview, bitmap, bku.c(getContext(), "Gaussian"), false);
        }
    }

    public PointF getBackviewCenterPointF()
    {
        if (backImageView != null)
        {
            return backImageView.getImageCenterPointF();
        } else
        {
            return null;
        }
    }

    public Bitmap getCenterBitmap()
    {
        return centerSrcBmp;
    }

    public MaskScrollImageViewTouch getCenterView()
    {
        return centerView;
    }

    public PointF getCenviewCenterPointF()
    {
        if (centerView != null)
        {
            return centerView.getImageCenterPointF();
        } else
        {
            return null;
        }
    }

    public TPhotoMaskInfo getMaskInfo()
    {
        return maskInfo;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
    }

    public void processBackgroundGaussianCenterView(ImageGLSurfaceView imageglsurfaceview, Bitmap bitmap, String s, boolean flag)
    {
        if (bitmap != null && imageglsurfaceview != null)
        {
            imageglsurfaceview = new bjf(bitmap);
            imageglsurfaceview.a(new bfr(this, flag));
            imageglsurfaceview.execute(new Context[] {
                getContext()
            });
        }
    }

    public void processImageByFilterName(ImageGLSurfaceView imageglsurfaceview, String s, Bitmap bitmap)
    {
        if (clickedViewTouch == null || clickedViewTouch != centerView) goto _L2; else goto _L1
_L1:
        if (!isOriginalFilter(s)) goto _L4; else goto _L3
_L3:
        updateCenterViewImageWithSameScale(bitmap);
_L6:
        return;
_L4:
        processforeGroundCenterViewByFilterName(imageglsurfaceview, s, bitmap, true);
        return;
_L2:
        if (clickedViewTouch != null && clickedViewTouch == backImageView)
        {
            processBackgroundGaussianCenterView(imageglsurfaceview, bitmap, s, true);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void renderInCanvas(Canvas canvas)
    {
        if (backImageView != null)
        {
            canvas.save();
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)backImageView.getLayoutParams();
            canvas.translate(layoutparams.leftMargin, layoutparams.topMargin);
            canvas.clipRect(0, 0, backImageView.getWidth(), backImageView.getHeight());
            backImageView.draw(canvas);
            canvas.restore();
        }
        if (backgroundAlpaView != null)
        {
            canvas.save();
            android.widget.FrameLayout.LayoutParams layoutparams1 = (android.widget.FrameLayout.LayoutParams)backgroundAlpaView.getLayoutParams();
            canvas.translate(layoutparams1.leftMargin, layoutparams1.topMargin);
            canvas.clipRect(0, 0, backgroundAlpaView.getWidth(), backgroundAlpaView.getHeight());
            backgroundAlpaView.draw(canvas);
            canvas.restore();
        }
        if (centerView != null)
        {
            canvas.save();
            android.widget.FrameLayout.LayoutParams layoutparams2 = (android.widget.FrameLayout.LayoutParams)centerView.getLayoutParams();
            canvas.translate(layoutparams2.leftMargin, layoutparams2.topMargin);
            canvas.clipRect(0, 0, centerView.getWidth(), centerView.getHeight());
            centerView.renderInCanvas(canvas);
            canvas.restore();
        }
        if (foregroundView != null)
        {
            canvas.save();
            android.widget.FrameLayout.LayoutParams layoutparams3 = (android.widget.FrameLayout.LayoutParams)foregroundView.getLayoutParams();
            canvas.translate(layoutparams3.leftMargin, layoutparams3.topMargin);
            canvas.clipRect(0, 0, foregroundView.getWidth(), foregroundView.getHeight());
            foregroundView.draw(canvas);
            canvas.restore();
        }
    }

    public void setBackviewCenter(PointF pointf, int i, int j)
    {
        if (backImageView == null);
    }

    public void setCenterviewCenter(PointF pointf, int i, int j)
    {
        if (centerView == null);
    }

    public void setImageMovingDelegate(bpn bpn)
    {
        if (centerView != null)
        {
            centerView.setMovingListener(bpn);
        }
    }

    public void setImageTouchViewScrollEnabled(boolean flag)
    {
        if (centerView != null)
        {
            centerView.setScrollEnabled(flag);
        }
    }

    public void setLongClickDelegate(android.view.View.OnLongClickListener onlongclicklistener)
    {
        if (centerView != null)
        {
            centerView.setOnLongClickListener(onlongclicklistener);
        }
    }

    public void setMaskDelegate(bfs bfs1)
    {
        maskViewDelegate = bfs1;
    }

    public void setMaskInfo(TPhotoMaskInfo tphotomaskinfo)
    {
        Log.v("TMaskScrollImageView", (new StringBuilder()).append("TMaskScrollImageView setMaskInfo:").append(tphotomaskinfo.is3DTransform()).toString());
        maskInfo = tphotomaskinfo;
        createSubViews(getContext(), maskInfo, centerSrcBmp);
    }

    public void updateBackgroundImage(Bitmap bitmap, boolean flag)
    {
        if (backgroundSrcBmp != null && !backgroundSrcBmp.isRecycled())
        {
            backgroundSrcBmp.recycle();
            backgroundSrcBmp = null;
        }
        backgroundSrcBmp = bitmap;
        if (backImageView != null)
        {
            MaskScrollImageViewTouch maskscrollimageviewtouch = backImageView;
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            maskscrollimageviewtouch.setImageBitmap(bitmap, flag);
        }
    }

    public void updateCenter3dTransformImage(Bitmap bitmap, boolean flag)
    {
        float f;
label0:
        {
            if (maskInfo.is3DTransform())
            {
                f = ((Float)maskInfo.transforms.get(0)).floatValue();
                ((Float)maskInfo.transforms.get(1)).floatValue();
                bitmap = get3dProcessBitmap(bitmap, ((Float)maskInfo.transforms.get(2)).floatValue(), ((Float)maskInfo.transforms.get(3)).floatValue(), ((Float)maskInfo.transforms.get(4)).floatValue());
                if (bitmap != null)
                {
                    if (!flag)
                    {
                        break label0;
                    }
                    updateCenterViewImageWithSameScale(bitmap);
                }
            }
            return;
        }
        if (f != 1.0F)
        {
            int i = (int)TPhotoComposeInfo.getScaledValue(maskInfo.innerFrame.width());
            int j = (int)TPhotoComposeInfo.getScaledValue(maskInfo.innerFrame.height());
            float f1 = (float)i / 2.0F;
            float f2 = (float)j / 2.0F;
            centerView.zoomScaleToFitView(f, f1, f2);
        }
        updateCenterViewImage(bitmap);
    }

    public void updateCenterViewImage(Bitmap bitmap)
    {
        centerSrcBmp = bitmap;
        if (centerView != null)
        {
            centerView.setImageBitmap(bitmap);
        }
    }

    public void updateCenterViewImageWithSameScale(Bitmap bitmap)
    {
        centerSrcBmp = bitmap;
        if (centerView != null)
        {
            centerView.setImageBitmap(bitmap, false);
        }
    }




}
