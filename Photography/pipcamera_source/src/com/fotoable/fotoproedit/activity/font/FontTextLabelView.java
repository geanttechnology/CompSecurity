// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import com.pipcamera.application.PIPCameraApplication;
import ew;
import hb;
import hr;
import hx;
import iq;
import kp;

// Referenced classes of package com.fotoable.fotoproedit.activity.font:
//            FontTextLabelInfo, FontOnlineInfo

public class FontTextLabelView extends View
{

    private String TAG;
    private FontOnlineInfo bginfo;
    private PointF bglbPt;
    private PointF bgltPt;
    private PointF bgrbPt;
    private PointF bgrtPt;
    private PointF centerPt;
    private PointF csPtInBmp1;
    private PointF csPtInBmp2;
    private float curLabelScale;
    private String curText;
    private int curTextSize;
    private PointF cursorP1;
    private PointF cursorP2;
    private hb fontInfo;
    private FontTextLabelInfo labelinfo;
    public float lastAngle;
    public float lastScale;
    private hr mListener;
    private Paint mStrokePaint;
    public Bitmap mTextImg;
    private Paint mTextPaint;
    private Matrix matrix;
    private int maxLabelSize;
    private boolean needFlip;
    private float newAngle;
    private float newScale;
    private int onedp;
    private Paint paint;
    private int tranX;
    private int tranY;
    private int txtLines;
    private int viewH;
    private int viewW;

    public FontTextLabelView(Context context)
    {
        super(context);
        TAG = "FontTextLabelView";
        matrix = new Matrix();
        bgltPt = new PointF();
        bgrtPt = new PointF();
        bgrbPt = new PointF();
        bglbPt = new PointF();
        curTextSize = 80;
        maxLabelSize = 0x7d000;
        txtLines = 1;
        newAngle = 0.0F;
        newScale = 1.0F;
        lastAngle = 0.0F;
        lastScale = 1.0F;
        cursorP1 = new PointF();
        cursorP2 = new PointF();
        csPtInBmp1 = new PointF();
        csPtInBmp2 = new PointF();
        centerPt = new PointF();
        curText = "";
        needFlip = false;
        onedp = ew.a(getContext(), 1.0F);
        curLabelScale = 1.0F;
        init();
    }

    public FontTextLabelView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TAG = "FontTextLabelView";
        matrix = new Matrix();
        bgltPt = new PointF();
        bgrtPt = new PointF();
        bgrbPt = new PointF();
        bglbPt = new PointF();
        curTextSize = 80;
        maxLabelSize = 0x7d000;
        txtLines = 1;
        newAngle = 0.0F;
        newScale = 1.0F;
        lastAngle = 0.0F;
        lastScale = 1.0F;
        cursorP1 = new PointF();
        cursorP2 = new PointF();
        csPtInBmp1 = new PointF();
        csPtInBmp2 = new PointF();
        centerPt = new PointF();
        curText = "";
        needFlip = false;
        onedp = ew.a(getContext(), 1.0F);
        curLabelScale = 1.0F;
        init();
    }

    public FontTextLabelView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        TAG = "FontTextLabelView";
        matrix = new Matrix();
        bgltPt = new PointF();
        bgrtPt = new PointF();
        bgrbPt = new PointF();
        bglbPt = new PointF();
        curTextSize = 80;
        maxLabelSize = 0x7d000;
        txtLines = 1;
        newAngle = 0.0F;
        newScale = 1.0F;
        lastAngle = 0.0F;
        lastScale = 1.0F;
        cursorP1 = new PointF();
        cursorP2 = new PointF();
        csPtInBmp1 = new PointF();
        csPtInBmp2 = new PointF();
        centerPt = new PointF();
        curText = "";
        needFlip = false;
        onedp = ew.a(getContext(), 1.0F);
        curLabelScale = 1.0F;
        init();
    }

    public static double degreeToRadian(double d)
    {
        return (3.1415926535897931D * d) / 180D;
    }

    private String getMaxLenStr(String as[])
    {
        int i = 0;
        txtLines = as.length;
        float f = 0.0F;
        String s = as[0];
        while (i < as.length) 
        {
            float f2 = mStrokePaint.measureText(as[i]);
            float f1 = f;
            if (f2 > f)
            {
                s = as[i];
                f1 = f2;
            }
            i++;
            f = f1;
        }
        return s;
    }

    private PointF getRectSize(PointF pointf, PointF pointf1, PointF pointf2, PointF pointf3)
    {
        PointF pointf4 = new PointF(0.0F, 0.0F);
        float f1 = pointf.x;
        float f3 = pointf.x;
        float f = f1;
        if (pointf1.x > f1)
        {
            f = pointf1.x;
        }
        f1 = f;
        if (pointf2.x > f)
        {
            f1 = pointf2.x;
        }
        float f2 = f1;
        if (pointf3.x > f1)
        {
            f2 = pointf3.x;
        }
        f = f3;
        if (pointf1.x < f3)
        {
            f = pointf1.x;
        }
        f1 = f;
        if (pointf2.x < f)
        {
            f1 = pointf2.x;
        }
        f = f1;
        if (pointf3.x < f1)
        {
            f = pointf3.x;
        }
        pointf4.x = f2 - f;
        f1 = pointf.y;
        f3 = pointf.y;
        f = f1;
        if (pointf1.y > f1)
        {
            f = pointf1.y;
        }
        f1 = f;
        if (pointf2.y > f)
        {
            f1 = pointf2.y;
        }
        f2 = f1;
        if (pointf3.y > f1)
        {
            f2 = pointf3.y;
        }
        f = f3;
        if (pointf1.y < f3)
        {
            f = pointf1.y;
        }
        f1 = f;
        if (pointf2.y < f)
        {
            f1 = pointf2.y;
        }
        f = f1;
        if (pointf3.y < f1)
        {
            f = pointf3.y;
        }
        pointf4.y = f2 - f;
        return pointf4;
    }

    private Bitmap getTextBitmap()
    {
        resetPaint();
        String as[] = labelinfo.m.split("\n");
        PointF pointf = getTextBound(as);
        int i2 = ew.a(getContext(), 10F);
        int j2 = (int)(pointf.x + (float)(i2 * 2));
        int k1 = (int)(pointf.y * (float)txtLines + (float)(i2 * 2) + labelinfo.c * (float)txtLines);
        Bitmap bitmap = Bitmap.createBitmap(j2, k1, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        android.graphics.Paint.FontMetrics fontmetrics = mTextPaint.getFontMetrics();
        for (int i = 0; i < txtLines; i++)
        {
            float f4 = (((float)i + 0.5F) * pointf.y + (float)i2) - (fontmetrics.top + fontmetrics.bottom) / 2.0F;
            float f = f4;
            if (i != 0)
            {
                f = f4 + labelinfo.c;
            }
            Log.e(TAG, (new StringBuilder()).append("text").append(i).append(":").append(as[i]).toString());
            canvas.drawText(as[i], i2, f, mTextPaint);
        }

        if (labelinfo.o)
        {
            Bitmap bitmap1 = labelinfo.a();
            if (bitmap1 != null)
            {
                Paint paint1 = new Paint();
                paint1.setAntiAlias(true);
                paint1.setColor(-1);
                paint1.setStrokeWidth(3F);
                paint1.setFilterBitmap(true);
                paint1.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
                android.graphics.Paint.FontMetrics fontmetrics1 = mTextPaint.getFontMetrics();
                int k2 = k1 / txtLines;
                int l2 = k2 * (bitmap1.getWidth() / bitmap1.getHeight());
                int j = i2 / 2;
                if (labelinfo.n)
                {
                    for (int k = 0; k < txtLines; k++)
                    {
                        float f1 = (int)(((float)k * labelinfo.c + ((float)k + 0.5F) * pointf.y + (float)i2) - (fontmetrics.top + fontmetrics.bottom) / 2.0F);
                        canvas.drawBitmap(bitmap1, null, new Rect(0, (int)(fontmetrics1.ascent + f1) - ew.a(getContext(), 5F), j2, (int)(f1 + fontmetrics1.descent) + ew.a(getContext(), 5F)), paint1);
                    }

                } else
                {
                    for (int l = 0; l < txtLines; l++)
                    {
                        int l1 = 0;
                        int i3 = l * k2;
                        for (; l1 < j2; l1 += l2)
                        {
                            canvas.drawBitmap(bitmap1, null, new Rect(l1, i3, l1 + l2, i3 + k2), paint1);
                        }

                    }

                }
                paint1.setXfermode(null);
            }
        }
        mStrokePaint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER));
        if (labelinfo.g != 0.0F)
        {
            for (int i1 = 0; i1 < txtLines; i1++)
            {
                float f5 = (((float)i1 + 0.5F) * pointf.y + (float)i2) - (fontmetrics.top + fontmetrics.bottom) / 2.0F;
                float f2 = f5;
                if (i1 != 0)
                {
                    f2 = f5 + labelinfo.c;
                }
                canvas.drawText(as[i1], i2, f2, mStrokePaint);
            }

        }
        float f7 = (float)ew.a(getContext(), labelinfo.d) * curLabelScale;
        mStrokePaint.setColor(labelinfo.e);
        if (labelinfo.f)
        {
            BlurMaskFilter blurmaskfilter = new BlurMaskFilter(labelinfo.p, android.graphics.BlurMaskFilter.Blur.SOLID);
            mStrokePaint.setMaskFilter(blurmaskfilter);
        } else
        {
            mStrokePaint.setMaskFilter(null);
        }
        if (labelinfo.f || labelinfo.d != 0.0F)
        {
            for (int j1 = 0; j1 < txtLines; j1++)
            {
                float f6 = (((float)j1 + 0.5F) * pointf.y + (float)i2) - (fontmetrics.top + fontmetrics.bottom) / 2.0F;
                float f3 = f6;
                if (j1 != 0)
                {
                    f3 = f6 + labelinfo.c;
                }
                canvas.drawText(as[j1], (float)i2 + f7, f3 + f7, mStrokePaint);
            }

        }
        return bitmap;
    }

    private PointF getTextBound(String as[])
    {
        float f;
        float f1;
        float f2;
        float f3;
        curTextSize = (int)mStrokePaint.getTextSize();
        as = getMaxLenStr(as);
        f3 = mStrokePaint.measureText(as, 0, as.length());
        f2 = mStrokePaint.descent() - mStrokePaint.ascent();
        f1 = f2;
        f = f3;
        if (f3 * f2 * (float)txtLines >= (float)maxLabelSize) goto _L2; else goto _L1
_L1:
        f1 = f3;
        f = f2;
_L7:
        f2 = f;
        f3 = f1;
        if (f1 * f * (float)txtLines >= (float)maxLabelSize) goto _L4; else goto _L3
_L3:
        if (curTextSize <= ew.c(getContext(), 80F)) goto _L6; else goto _L5
_L5:
        f3 = f1;
        f2 = f;
_L4:
        mTextPaint.setTextSize(curTextSize);
        curLabelScale = (float)curTextSize / (float)ew.c(getContext(), 80F);
        return new PointF(f3 + 5F, f2);
_L6:
        curTextSize = curTextSize + 2;
        mStrokePaint.setTextSize(curTextSize);
        f1 = mStrokePaint.measureText(as, 0, as.length());
        f = mStrokePaint.descent() - mStrokePaint.ascent();
          goto _L7
_L10:
        mStrokePaint.setTextSize(curTextSize);
        f = mStrokePaint.measureText(as, 0, as.length());
        f1 = mStrokePaint.descent() - mStrokePaint.ascent();
_L2:
        f2 = f1;
        f3 = f;
        if (f * f1 * (float)txtLines <= (float)maxLabelSize) goto _L4; else goto _L8
_L8:
        curTextSize = curTextSize - 2;
        if (curTextSize > 0) goto _L10; else goto _L9
_L9:
        curTextSize = curTextSize + 2;
        f2 = f1;
        f3 = f;
          goto _L4
    }

    private void init()
    {
        paint = new Paint();
        paint.setFilterBitmap(true);
        paint.setAntiAlias(true);
        paint.setColor(Color.argb(255, 255, 255, 255));
        paint.setStrokeWidth(4F);
        newScale = 1.0F;
        newAngle = 0.0F;
        if (PIPCameraApplication.b)
        {
            maxLabelSize = 0x32000;
        }
        mTextPaint = new Paint();
        mStrokePaint = new Paint();
        bginfo = new FontOnlineInfo();
        labelinfo = new FontTextLabelInfo();
        int i = getResources().getDisplayMetrics().widthPixels / 2;
        int j = getResources().getDisplayMetrics().heightPixels / 2;
        int k = ew.a(getContext(), 50F);
        centerPt = new PointF(i, j - k);
        onTextCreate();
    }

    private PointF intersects(PointF pointf, PointF pointf1, PointF pointf2, PointF pointf3)
    {
        PointF pointf4 = new PointF(0.0F, 0.0F);
        double d = (pointf1.y - pointf.y) * (pointf.x - pointf2.x) - (pointf1.x - pointf.x) * (pointf.y - pointf2.y);
        double d1 = (pointf1.y - pointf.y) * (pointf3.x - pointf2.x) - (pointf1.x - pointf.x) * (pointf3.y - pointf2.y);
        pointf4.x = (int)((double)pointf2.x + ((double)(pointf3.x - pointf2.x) * d) / d1);
        double d2 = pointf2.y;
        pointf4.y = (int)((d * (double)(pointf3.y - pointf2.y)) / d1 + d2);
        return pointf4;
    }

    public static double radianToDegree(double d)
    {
        return (180D * d) / 3.1415926535897931D;
    }

    private PointF refreshPt(PointF pointf, int i, int j)
    {
        return new PointF(pointf.x + (float)i, pointf.y + (float)j);
    }

    private void resetPaint()
    {
        mStrokePaint.setTextSize(curTextSize);
        mStrokePaint.setFilterBitmap(true);
        mStrokePaint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        mStrokePaint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        mStrokePaint.setStrokeMiter(0.0F);
        mStrokePaint.setColor(labelinfo.h);
        float f = labelinfo.g;
        f = ew.a(getContext(), f);
        float f1 = curLabelScale;
        mStrokePaint.setStrokeWidth(f * f1);
        mStrokePaint.setAntiAlias(true);
        mTextPaint.setFilterBitmap(true);
        mTextPaint.setTextSize(curTextSize);
        mTextPaint.setColor(labelinfo.j);
        mTextPaint.setAntiAlias(true);
        if (fontInfo != null)
        {
            mStrokePaint.setTypeface(iq.a().a(fontInfo));
            mTextPaint.setTypeface(iq.a().a(fontInfo));
        }
        mStrokePaint.setFilterBitmap(true);
        mTextPaint.setFilterBitmap(true);
    }

    private Bitmap reverseBitmap(Bitmap bitmap, int i)
    {
        Object obj = null;
        i;
        JVM INSTR tableswitch 0 1: default 28
    //                   0 71
    //                   1 122;
           goto _L1 _L2 _L3
_L1:
        float af[] = null;
_L5:
        if (af != null)
        {
            obj = new Matrix();
            ((Matrix) (obj)).setValues(af);
            obj = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), ((Matrix) (obj)), true);
        }
        return ((Bitmap) (obj));
_L2:
        af = new float[9];
        af;
        af[0] = -1F;
        af[1] = 0.0F;
        af[2] = 0.0F;
        af[3] = 0.0F;
        af[4] = 1.0F;
        af[5] = 0.0F;
        af[6] = 0.0F;
        af[7] = 0.0F;
        af[8] = 1.0F;
        continue; /* Loop/switch isn't completed */
_L3:
        af = new float[9];
        af;
        af[0] = 1.0F;
        af[1] = 0.0F;
        af[2] = 0.0F;
        af[3] = 0.0F;
        af[4] = -1F;
        af[5] = 0.0F;
        af[6] = 0.0F;
        af[7] = 0.0F;
        af[8] = 1.0F;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static PointF roationPoint(PointF pointf, PointF pointf1, float f)
    {
        double d1;
        double d2;
        PointF pointf2;
        pointf1.x = pointf1.x - pointf.x;
        pointf1.y = pointf1.y - pointf.y;
        d1 = 0.0D;
        pointf2 = new PointF();
        d2 = Math.sqrt(pointf1.x * pointf1.x + pointf1.y * pointf1.y);
        if (pointf1.x == 0.0F && pointf1.y == 0.0F)
        {
            return pointf;
        }
        if (pointf1.x < 0.0F || pointf1.y < 0.0F) goto _L2; else goto _L1
_L1:
        double d = Math.asin((double)pointf1.y / d2);
_L4:
        d = degreeToRadian(radianToDegree(d) + (double)f);
        pointf2.x = (int)Math.round(Math.cos(d) * d2);
        pointf2.y = (int)Math.round(Math.sin(d) * d2);
        pointf2.x = pointf2.x + pointf.x;
        pointf2.y = pointf2.y + pointf.y;
        return pointf2;
_L2:
        if (pointf1.x < 0.0F && pointf1.y >= 0.0F)
        {
            d = Math.asin((double)Math.abs(pointf1.x) / d2) + 1.5707963267948966D;
        } else
        if (pointf1.x < 0.0F && pointf1.y < 0.0F)
        {
            d = Math.asin((double)Math.abs(pointf1.y) / d2) + 3.1415926535897931D;
        } else
        {
            d = d1;
            if (pointf1.x >= 0.0F)
            {
                d = d1;
                if (pointf1.y < 0.0F)
                {
                    d = Math.asin((double)pointf1.x / d2) + 4.7123889803846897D;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Bitmap bgImg()
    {
        return mTextImg;
    }

    public PointF centerPt()
    {
        return centerPt;
    }

    public PointF cursorPt1()
    {
        return cursorP1;
    }

    public PointF cursorPt2()
    {
        return cursorP2;
    }

    public PointF deletePt()
    {
        return bgltPt;
    }

    public PointF flipPt()
    {
        return bgrtPt;
    }

    public hb fontInfo()
    {
        return fontInfo;
    }

    public Point getBitmapSpacing()
    {
        return new Point(tranX, tranY);
    }

    public Point getLBpt()
    {
        return new Point(((int)bglbPt.x + (int)centerPt.x) - viewW / 2, ((int)bglbPt.y + (int)centerPt.y) - viewH / 2);
    }

    public Point getLTpt()
    {
        return new Point(((int)bgltPt.x + (int)centerPt.x) - viewW / 2, ((int)bgltPt.y + (int)centerPt.y) - viewH / 2);
    }

    public Point getRBpt()
    {
        return new Point(((int)bgrbPt.x + (int)centerPt.x) - viewW / 2, ((int)bgrbPt.y + (int)centerPt.y) - viewH / 2);
    }

    public Point getRTpt()
    {
        return new Point(((int)bgrtPt.x + (int)centerPt.x) - viewW / 2, ((int)bgrtPt.y + (int)centerPt.y) - viewH / 2);
    }

    public String getText()
    {
        return curText;
    }

    public boolean hasBg()
    {
        return bginfo.hasBg;
    }

    public boolean isTouchLabel(int i, int j)
    {
        return hx.a(bgltPt, bgrtPt, bgrbPt, bglbPt, new PointF(i, j));
    }

    public FontTextLabelInfo labelinfo()
    {
        return labelinfo;
    }

    protected void onDraw(Canvas canvas)
    {
        if (mTextImg != null)
        {
            paint.setAlpha(labelinfo.k);
            canvas.drawBitmap(mTextImg, matrix, paint);
        }
        if (mListener != null)
        {
            mListener.a(this);
        }
    }

    public void onTextCreate()
    {
        Log.e(TAG, (new StringBuilder()).append(TAG).append(" onTextCreate").toString());
        Bitmap bitmap;
        Object obj;
        if (labelinfo.m.length() == 0)
        {
            int i = ew.a(getContext(), 21F);
            int l = ew.a(getContext(), 80F);
            bitmap = Bitmap.createBitmap(i * 2, l, android.graphics.Bitmap.Config.ARGB_8888);
            txtLines = 1;
            csPtInBmp1.set(i, i / 7);
            csPtInBmp2.set(i, l - i / 7);
        } else
        {
            bitmap = getTextBitmap();
            int k = ew.a(getContext(), 3F);
            csPtInBmp1.set(bitmap.getWidth() - k, (bitmap.getHeight() * (txtLines - 1)) / txtLines + k);
            csPtInBmp2.set(bitmap.getWidth() - k, bitmap.getHeight() - k);
        }
        obj = bitmap;
        if (bginfo.hasBg)
        {
            Bitmap bitmap1 = bginfo.getBgImage();
            Rect rect = bginfo.getTextRect();
            float f = (float)bitmap.getHeight() / (float)rect.height();
            if ((float)bitmap.getWidth() / (float)bitmap.getHeight() > (float)rect.width() / (float)rect.height())
            {
                f = (float)bitmap.getWidth() / (float)rect.width();
            }
            int j = (int)((float)bitmap.getWidth() / f);
            int i1 = (int)((float)bitmap.getHeight() / f);
            int j1 = (rect.width() - j) / 2;
            j1 = rect.left + j1;
            int k1 = (rect.height() - i1) / 2;
            k1 = rect.top + k1;
            rect = new Rect(j1, k1, j1 + j, k1 + i1);
            if (needFlip)
            {
                bitmap1 = reverseBitmap(bitmap1, 0);
                int l1 = bitmap1.getWidth() - (j1 + j);
                rect = new Rect(l1, k1, l1 + j, k1 + i1);
            }
            obj = bitmap;
            if (bitmap1 != null)
            {
                obj = new Canvas(bitmap1);
                Paint paint1 = new Paint();
                paint1.setColor(-1);
                paint1.setStrokeWidth(4F);
                paint1.setAntiAlias(true);
                paint1.setFilterBitmap(true);
                ((Canvas) (obj)).drawBitmap(bitmap, null, rect, paint1);
                if (bitmap != null && !bitmap.isRecycled())
                {
                    bitmap.recycle();
                }
                int i2 = ew.a(getContext(), 3F);
                csPtInBmp1.set((j1 + j) - i2, ((txtLines - 1) * i1) / txtLines + k1 + i2);
                csPtInBmp2.set((j1 + j) - i2, (k1 + i1) - i2);
                if (labelinfo.m.length() == 0)
                {
                    i2 = (i1 - i2 * 20) / 2;
                    csPtInBmp1.set(j / 2 + j1, k1 + i2);
                    csPtInBmp2.set(j / 2 + j1, (k1 + i1) - i2);
                }
                obj = bitmap1;
            }
        }
        setImage(((Bitmap) (obj)));
        updateLabelView();
    }

    public void refreshDrawingPt(int i, int j, int k, int l, float f)
    {
        PointF pointf1 = new PointF(i, j);
        PointF pointf2 = new PointF(k, j);
        PointF pointf3 = new PointF(k, l);
        PointF pointf4 = new PointF(i, l);
        PointF pointf = new PointF((i + k) / 2, (j + l) / 2);
        bgltPt = roationPoint(pointf, pointf1, f);
        bgrtPt = roationPoint(pointf, pointf2, f);
        bgrbPt = roationPoint(pointf, pointf3, f);
        bglbPt = roationPoint(pointf, pointf4, f);
        pointf1 = getRectSize(bgltPt, bgrtPt, bgrbPt, bglbPt);
        pointf2 = intersects(bgrtPt, bglbPt, bgltPt, bgrbPt);
        tranX = (int)(pointf1.x / 2.0F - pointf2.x);
        tranY = (int)(pointf1.y / 2.0F - pointf2.y);
        bgrtPt = refreshPt(bgrtPt, tranX, tranY);
        bgltPt = refreshPt(bgltPt, tranX, tranY);
        bgrbPt = refreshPt(bgrbPt, tranX, tranY);
        bglbPt = refreshPt(bglbPt, tranX, tranY);
        viewW = (int)pointf1.x;
        viewH = (int)pointf1.y;
        float f1 = newScale * lastScale;
        cursorP1.set((int)(csPtInBmp1.x * f1), (int)(csPtInBmp1.y * f1));
        cursorP2.set((int)(csPtInBmp2.x * f1), (int)(f1 * csPtInBmp2.y));
        cursorP1 = roationPoint(pointf, cursorP1, f);
        cursorP2 = roationPoint(pointf, cursorP2, f);
        cursorP1 = refreshPt(cursorP1, tranX, tranY);
        cursorP2 = refreshPt(cursorP2, tranX, tranY);
    }

    public PointF rotatePt()
    {
        return bgrbPt;
    }

    public void setCPoint(int i, int j)
    {
        centerPt.x = i;
        centerPt.y = j;
    }

    public void setCPointD(int i, int j)
    {
        centerPt.x = centerPt.x + (float)i;
        centerPt.y = centerPt.y + (float)j;
    }

    public void setFlip(boolean flag)
    {
        needFlip = flag;
    }

    public void setFontLabelFontInfo(hb hb)
    {
        fontInfo = hb;
    }

    public void setFontLabelInfo1(FontTextLabelInfo fonttextlabelinfo)
    {
        labelinfo.a = fonttextlabelinfo.a;
        labelinfo.j = fonttextlabelinfo.j;
        labelinfo.i = fonttextlabelinfo.i;
        labelinfo.e = fonttextlabelinfo.e;
        labelinfo.d = fonttextlabelinfo.d * 1.2F;
        labelinfo.h = fonttextlabelinfo.h;
        labelinfo.g = fonttextlabelinfo.g * 1.2F;
        labelinfo.o = fonttextlabelinfo.o;
        labelinfo.n = fonttextlabelinfo.n;
        labelinfo.p = 18F;
        labelinfo.f = fonttextlabelinfo.f;
    }

    public void setFontLabelSize(int i)
    {
        labelinfo.r = 0;
    }

    public void setImage(Bitmap bitmap)
    {
        mTextImg = bitmap;
    }

    public void setImageRotate(float f)
    {
        newAngle = f;
    }

    public void setImageScale(float f)
    {
        newScale = f;
    }

    public void setLabelBg(FontOnlineInfo fontonlineinfo)
    {
        bginfo = fontonlineinfo;
    }

    public void setLabelNeedGuass(boolean flag)
    {
        labelinfo.f = flag;
    }

    public void setLabelStrokeColor(int i)
    {
        labelinfo.h = i;
    }

    public void setLabelStrokeSize(int i)
    {
        labelinfo.g = i;
    }

    public void setLabelTextImage(FontTextLabelInfo fonttextlabelinfo)
    {
        labelinfo.o = fonttextlabelinfo.o;
        if (fonttextlabelinfo.o)
        {
            labelinfo.n = fonttextlabelinfo.n;
            labelinfo.i = fonttextlabelinfo.i;
            return;
        } else
        {
            labelinfo.j = fonttextlabelinfo.j;
            return;
        }
    }

    public void setLabelTextStr(String s)
    {
        String s1 = s;
        if (s.length() > 0)
        {
            if (!s.equals(getResources().getText(0x7f060267)))
            {
                curText = s;
            }
            s1 = s;
            if (s.substring(s.length() - 1).equals("\n"))
            {
                s1 = (new StringBuilder()).append(s).append(" ").toString();
            }
        }
        labelinfo.m = s1;
    }

    public void setListener(hr hr1)
    {
        mListener = hr1;
    }

    public void setNewScale(float f)
    {
        newScale = f;
    }

    public void setShadowLabelColor(int i)
    {
        labelinfo.e = i;
    }

    public void setShadowLabelVal(int i)
    {
        labelinfo.d = i;
    }

    public void setTextLabelAlpha(int i)
    {
        labelinfo.k = i;
        invalidate();
    }

    public void startFlip()
    {
        boolean flag;
        if (!needFlip)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        needFlip = flag;
    }

    public void storeTransform()
    {
        lastScale = lastScale * newScale;
        newScale = 1.0F;
        lastAngle = lastAngle - newAngle;
        newAngle = 0.0F;
    }

    public void updateLabelView()
    {
        float f = newScale * lastScale;
        float f1 = lastAngle - newAngle;
        refreshDrawingPt(0, 0, (int)((float)mTextImg.getWidth() * f), (int)((float)mTextImg.getHeight() * f), f1);
        matrix.reset();
        matrix.postScale(f, f);
        matrix.postRotate(f1, ((float)mTextImg.getWidth() * f) / 2.0F, ((float)mTextImg.getHeight() * f) / 2.0F);
        matrix.postTranslate(tranX, tranY);
        invalidate();
    }

    public kp viewSize()
    {
        return new kp(viewW, viewH);
    }
}
