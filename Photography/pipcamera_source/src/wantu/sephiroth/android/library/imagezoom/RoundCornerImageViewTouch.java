// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package wantu.sephiroth.android.library.imagezoom;

import ajb;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import ew;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package wantu.sephiroth.android.library.imagezoom:
//            ImageViewTouch

public class RoundCornerImageViewTouch extends ImageViewTouch
{

    public static String TAG = "RoundCornerImageViewTouch";
    private Paint mBKPaint;
    private Shader mBmpShader;
    private Path mContaintPath;
    private List mContaintPoints;
    private RectF mFrame;
    private LinearGradient mGradient;
    private Paint mHighlightPaint;
    private boolean mIsBK;
    private boolean mIsHighlight;
    private boolean mIsInsertZero;
    private boolean mIsUsingShadow;
    private Paint mPaint;
    private Path mPath;
    private List mPoints;
    private Paint mShadowPaint;
    private int padding;
    private int radius;

    public RoundCornerImageViewTouch(Context context)
    {
        super(context);
        padding = 0;
        mFrame = new RectF();
        mIsUsingShadow = true;
        mIsHighlight = false;
        mIsBK = false;
        mIsInsertZero = false;
        radius = (int)getContext().getResources().getDimension(0x7f08002d);
    }

    public RoundCornerImageViewTouch(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        padding = 0;
        mFrame = new RectF();
        mIsUsingShadow = true;
        mIsHighlight = false;
        mIsBK = false;
        mIsInsertZero = false;
        radius = (int)getContext().getResources().getDimension(0x7f08002d);
    }

    private Point caculateCenterPoint(List list)
    {
        int j = 0;
        int k = 0;
        int i = 0;
        for (; j < list.size(); j++)
        {
            Point point = (Point)list.get(j);
            k += point.y;
            i += point.x;
        }

        return new Point(i / 4, k / 4);
    }

    private List caculateInsertPoint(List list, int i)
    {
        ArrayList arraylist = new ArrayList();
        Point point = caculateCenterPoint(list);
        int k = 0;
        do
        {
            while (k < list.size()) 
            {
                Point point1 = (Point)list.get(k);
                Point point2 = new Point();
                int l = point1.x;
                int j;
                if (point.x > point1.x)
                {
                    j = 1;
                } else
                if (point.x == point1.x)
                {
                    j = 0;
                } else
                {
                    j = -1;
                }
                point2.x = j * i + l;
                l = point1.y;
                if (point.y > point1.y)
                {
                    j = 1;
                } else
                if (point.y == point1.y)
                {
                    j = 0;
                } else
                {
                    j = -1;
                }
                point2.y = j * i + l;
                arraylist.add(point2);
                k++;
            }
            return arraylist;
        } while (true);
    }

    private Shader createShader(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return null;
        } else
        {
            return new BitmapShader(bitmap, android.graphics.Shader.TileMode.REPEAT, android.graphics.Shader.TileMode.REPEAT);
        }
    }

    private Path getPathInsertPotins(List list, int i)
    {
        Path path = new Path();
        list = caculateInsertPoint(list, i);
        if (list != null && list.size() > 0)
        {
            if (radius > 0)
            {
                list = pointsWithCorner(list);
                i = 0;
                while (i < list.size()) 
                {
                    Point point = (Point)list.get(i);
                    Point point2;
                    if (i == 0)
                    {
                        path.moveTo(point.x, point.y);
                    } else
                    {
                        path.lineTo(point.x, point.y);
                    }
                    point = (Point)list.get(i + 1);
                    point2 = (Point)list.get(i + 2);
                    path.quadTo(point.x, point.y, point2.x, point2.y);
                    i += 3;
                }
            } else
            {
                path.moveTo(((Point)list.get(0)).x, ((Point)list.get(0)).y);
                for (i = 1; i < list.size(); i++)
                {
                    Point point1 = (Point)list.get(i);
                    path.lineTo(point1.x, point1.y);
                }

            }
            path.close();
        }
        return path;
    }

    private List pointsWithCorner(List list)
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
        while (i < list.size()) 
        {
            Point point;
            Point point1;
            ArrayList arraylist1;
            if (i < list.size() - 1)
            {
                point1 = new Point((Point)list.get(i));
                point = new Point((Point)list.get(i + 1));
            } else
            if (i == list.size() - 1)
            {
                point1 = new Point((Point)list.get(i));
                point = new Point((Point)list.get(0));
            } else
            {
                point = null;
                point1 = null;
            }
            arraylist.add(new Point(point1.x, point1.y));
            if (point1.x == point.x)
            {
                int j;
                int i1;
                int l1;
                int k2;
                if (point.y - point1.y > 0)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                l1 = point1.y;
                k2 = radius;
                if (j != 0)
                {
                    i1 = 1;
                } else
                {
                    i1 = -1;
                }
                point1.y = i1 * k2 + l1;
                i1 = point.y;
                l1 = radius;
                if (j != 0)
                {
                    j = 1;
                } else
                {
                    j = -1;
                }
                point.y = i1 - j * l1;
            } else
            if (point1.y == point.y)
            {
                int k;
                int j1;
                int i2;
                int l2;
                if (point.x - point1.x > 0)
                {
                    k = 1;
                } else
                {
                    k = 0;
                }
                i2 = point1.x;
                l2 = radius;
                if (k != 0)
                {
                    j1 = 1;
                } else
                {
                    j1 = -1;
                }
                point1.x = j1 * l2 + i2;
                j1 = point.x;
                i2 = radius;
                if (k != 0)
                {
                    k = 1;
                } else
                {
                    k = -1;
                }
                point.x = j1 - k * i2;
            } else
            {
                float f1 = (float)(point.y - point1.y) / (float)(point.x - point1.x);
                float f = (float)Math.sqrt((float)(radius * radius) / (1.0F + f1 * f1));
                f1 = Math.abs(f1 * f);
                float f2;
                int l;
                int k1;
                int j2;
                if (point.x - point1.x > 0)
                {
                    k1 = 1;
                } else
                {
                    k1 = 0;
                }
                if (point.y - point1.y > 0)
                {
                    l = 1;
                } else
                {
                    l = 0;
                }
                f2 = point1.x;
                if (k1 != 0)
                {
                    j2 = 1;
                } else
                {
                    j2 = -1;
                }
                point1.x = (int)((float)j2 * f + f2);
                f2 = point1.y;
                if (l != 0)
                {
                    j2 = 1;
                } else
                {
                    j2 = -1;
                }
                point1.y = (int)((float)j2 * f1 + f2);
                f2 = point.x;
                if (k1 != 0)
                {
                    k1 = 1;
                } else
                {
                    k1 = -1;
                }
                point.x = (int)(f2 - (float)k1 * f);
                f = point.y;
                if (l != 0)
                {
                    l = 1;
                } else
                {
                    l = -1;
                }
                point.y = (int)(f - (float)l * f1);
            }
            arraylist.add(new Point(point1.x, point1.y));
            arraylist.add(new Point(point.x, point.y));
            i++;
        }
        arraylist1 = new ArrayList();
        i = 1;
        while (i < arraylist.size()) 
        {
            if (i < arraylist.size() - 3)
            {
                list = (Point)arraylist.get(i + 1);
                point = (Point)arraylist.get(i + 3);
                point1 = (Point)arraylist.get(i + 2);
            } else
            if (i == arraylist.size() - 2)
            {
                list = (Point)arraylist.get(i + 1);
                point = (Point)arraylist.get(1);
                point1 = (Point)arraylist.get(0);
            } else
            {
                point1 = null;
                point = null;
                list = null;
            }
            arraylist1.add(list);
            arraylist1.add(point1);
            arraylist1.add(point);
            i += 3;
        }
        return arraylist1;
    }

    private void setContaintPathWithPotins(List list)
    {
        if (list != null && list.size() > 0)
        {
            if (mContaintPath == null)
            {
                mContaintPath = new Path();
            } else
            {
                mContaintPath.reset();
            }
            if (radius > 0)
            {
                list = pointsWithCorner(list);
                int i = 0;
                while (i < list.size()) 
                {
                    Point point = (Point)list.get(i);
                    Point point2;
                    if (i == 0)
                    {
                        mContaintPath.moveTo(point.x, point.y);
                    } else
                    {
                        mContaintPath.lineTo(point.x, point.y);
                    }
                    point = (Point)list.get(i + 1);
                    point2 = (Point)list.get(i + 2);
                    mContaintPath.quadTo(point.x, point.y, point2.x, point2.y);
                    i += 3;
                }
            } else
            {
                mContaintPath.moveTo(((Point)list.get(0)).x, ((Point)list.get(0)).y);
                for (int j = 1; j < list.size(); j++)
                {
                    Point point1 = (Point)list.get(j);
                    mContaintPath.lineTo(point1.x, point1.y);
                }

            }
            mContaintPath.close();
        }
    }

    private void setPathWithPotins(List list)
    {
        if (list != null && list.size() > 0)
        {
            if (mPath == null)
            {
                mPath = new Path();
            } else
            {
                mPath.reset();
            }
            if (radius > 0)
            {
                list = pointsWithCorner(list);
                int i = 0;
                while (i < list.size()) 
                {
                    Point point = (Point)list.get(i);
                    Point point2;
                    if (i == 0)
                    {
                        mPath.moveTo(point.x, point.y);
                    } else
                    {
                        mPath.lineTo(point.x, point.y);
                    }
                    point = (Point)list.get(i + 1);
                    point2 = (Point)list.get(i + 2);
                    mPath.quadTo(point.x, point.y, point2.x, point2.y);
                    i += 3;
                }
            } else
            {
                mPath.moveTo(((Point)list.get(0)).x, ((Point)list.get(0)).y);
                for (int j = 1; j < list.size(); j++)
                {
                    Point point1 = (Point)list.get(j);
                    mPath.lineTo(point1.x, point1.y);
                }

            }
            mPath.close();
        }
    }

    public void changeRadius(int i)
    {
        radius = i;
        invalidate();
    }

    public Path getContaintPath()
    {
        return mContaintPath;
    }

    public Bitmap getDispalyImage(int i, int j)
    {
        float f;
        Bitmap bitmap;
        Canvas canvas;
        Matrix matrix;
        Bitmap bitmap1;
        int i1;
        int k = getWidth();
        f = (float)i / (float)k;
        bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        matrix = getImageMatrix();
        matrix.postScale(f, f);
        bitmap1 = ((ajb)getDrawable()).a();
        i1 = (int)getContext().getResources().getDimension(0x7f08002e);
        int l;
        if (mIsUsingShadow)
        {
            l = i1;
        } else
        {
            l = 0;
        }
        try
        {
            padding = l;
            padding = (int)((float)padding * f + 0.5F);
            RectF rectf = new RectF(padding, padding, i - padding, j - padding);
            i = (int)((float)radius * f);
            if (mIsUsingShadow)
            {
                RectF rectf1 = new RectF(rectf);
                rectf1.inset((float)ew.a(getContext(), 1.0F) * f, (float)ew.a(getContext(), 1.0F) * f);
                mShadowPaint.setMaskFilter(new BlurMaskFilter((float)i1 * f, android.graphics.BlurMaskFilter.Blur.OUTER));
                canvas.drawRoundRect(rectf1, i, i, mShadowPaint);
                mShadowPaint.setMaskFilter(new BlurMaskFilter(i1, android.graphics.BlurMaskFilter.Blur.OUTER));
            }
            canvas.saveLayer(rectf, null, 31);
            Paint paint = new Paint();
            paint.setFilterBitmap(true);
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(0xff424242);
            Path path = new Path();
            path.addRoundRect(rectf, i, i, android.graphics.Path.Direction.CW);
            canvas.drawPath(path, paint);
            paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap1, matrix, paint);
            canvas.restore();
            matrix.postScale(1.0F / f, 1.0F / f);
        }
        catch (Exception exception)
        {
            return null;
        }
        return bitmap;
    }

    public boolean getIsUsingShadow()
    {
        return mIsUsingShadow;
    }

    public int getRadius()
    {
        return radius;
    }

    protected void init()
    {
        super.init();
        mPaint = new Paint();
        mPaint.setFilterBitmap(true);
        mPaint.setAntiAlias(true);
        mShadowPaint = new Paint(1);
        int i = (int)getContext().getResources().getDimension(0x7f08002e);
        mShadowPaint.setMaskFilter(new BlurMaskFilter(i, android.graphics.BlurMaskFilter.Blur.OUTER));
        mShadowPaint.setColor(0xff000000);
        mHighlightPaint = new Paint(1);
        mHighlightPaint.setAntiAlias(true);
        i = (int)getContext().getResources().getDimension(0x7f080030);
        mHighlightPaint.setStrokeWidth(i);
        mHighlightPaint.setColor(Color.parseColor("#007aff"));
        mHighlightPaint.setStyle(android.graphics.Paint.Style.STROKE);
        mBKPaint = new Paint(1);
        mBKPaint.setAntiAlias(true);
        i = (int)getContext().getResources().getDimension(0x7f08002c);
        mBKPaint.setStrokeWidth(i);
        mBKPaint.setColor(Color.parseColor("#000000"));
        mBKPaint.setStyle(android.graphics.Paint.Style.STROKE);
    }

    public boolean isContaintPoint(Point point)
    {
        if (mContaintPath != null)
        {
            RectF rectf = new RectF();
            mContaintPath.computeBounds(rectf, true);
            Region region = new Region();
            region.setPath(mContaintPath, new Region((int)rectf.left, (int)rectf.top, (int)rectf.right, (int)rectf.bottom));
            if (region.contains(point.x, point.y))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isHighlight()
    {
        return mIsHighlight;
    }

    public boolean isUseBK()
    {
        return mIsBK;
    }

    protected void onBitmapChanged(Drawable drawable)
    {
        if (drawable == null)
        {
            mBmpShader = null;
            return;
        } else
        {
            mBmpShader = createShader(((ajb)drawable).a());
            mPaint.setShader(mBmpShader);
            super.onBitmapChanged(drawable);
            return;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        boolean flag = false;
        if (mBmpShader != null)
        {
            Log.v("Round corner view", (new StringBuilder()).append("width: ").append(getWidth()).append("  height").append(getHeight()).toString());
            int i = (int)getContext().getResources().getDimension(0x7f08002e);
            if (!mIsUsingShadow)
            {
                i = 0;
            }
            padding = i;
            mFrame.set(padding, padding, getWidth() - padding, getHeight() - padding);
            if (mPoints != null && mPoints.size() > 0)
            {
                if (mIsUsingShadow)
                {
                    i = (int)getContext().getResources().getDimension(0x7f08002e);
                    canvas.drawPath(getPathInsertPotins(mPoints, i), mShadowPaint);
                }
                if (mBmpShader != null)
                {
                    mBmpShader.setLocalMatrix(getImageViewMatrix());
                    if (mIsUsingShadow)
                    {
                        i = (int)getContext().getResources().getDimension(0x7f08002e);
                    } else
                    {
                        i = 0;
                    }
                    canvas.drawPath(getPathInsertPotins(mPoints, i), mPaint);
                }
                if (mIsBK)
                {
                    i = (int)getContext().getResources().getDimension(0x7f08002c);
                    if (!mIsInsertZero);
                    i = ((flag) ? 1 : 0);
                    if (mIsUsingShadow)
                    {
                        i = (int)getContext().getResources().getDimension(0x7f08002e);
                    }
                    canvas.drawPath(getPathInsertPotins(mPoints, i), mBKPaint);
                }
                if (mIsHighlight)
                {
                    i = (int)getContext().getResources().getDimension(0x7f08002f);
                    if (mIsUsingShadow)
                    {
                        i = (int)getContext().getResources().getDimension(0x7f08002e);
                    }
                    canvas.drawPath(getPathInsertPotins(mPoints, i), mHighlightPaint);
                    return;
                }
            }
        }
    }

    public void setBK(boolean flag)
    {
        mIsBK = flag;
        invalidate();
    }

    public void setContaintPoints(List list)
    {
        mContaintPoints = list;
        setContaintPathWithPotins(mContaintPoints);
    }

    public void setHighlight(boolean flag)
    {
        mIsHighlight = flag;
        invalidate();
    }

    public void setIsInsertZero(boolean flag)
    {
        mIsInsertZero = flag;
    }

    public void setIsUsingShadow(boolean flag)
    {
        mIsUsingShadow = flag;
        invalidate();
    }

    public void setPoints(List list)
    {
        mPoints = list;
        setPathWithPotins(mPoints);
    }

    public void setRadius(int i)
    {
        radius = i;
    }

}
