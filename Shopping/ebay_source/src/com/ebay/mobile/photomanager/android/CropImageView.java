// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Toast;
import com.ebay.mobile.photomanager.CropPhotoActivity;
import com.ebay.mobile.photomanager.TemporaryFileManager;
import com.ebay.nautilus.kernel.util.FwLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.ebay.mobile.photomanager.android:
//            ImageViewTouchBase, HighlightView, RotateBitmap

public class CropImageView extends ImageViewTouchBase
{
    public static final class Direction extends Enum
    {

        private static final Direction $VALUES[];
        public static final Direction LEFT;
        public static final Direction RIGHT;

        public static Direction valueOf(String s)
        {
            return (Direction)Enum.valueOf(com/ebay/mobile/photomanager/android/CropImageView$Direction, s);
        }

        public static Direction[] values()
        {
            return (Direction[])$VALUES.clone();
        }

        static 
        {
            LEFT = new Direction("LEFT", 0);
            RIGHT = new Direction("RIGHT", 1);
            $VALUES = (new Direction[] {
                LEFT, RIGHT
            });
        }

        private Direction(String s, int i)
        {
            super(s, i);
        }
    }


    private final String TAG = "CropImageView";
    public CountDownLatch latch;
    private Bitmap mBitmap;
    private int mBottom;
    private HighlightView mCrop;
    private ArrayList mHighlightViews;
    private float mLastX;
    private float mLastY;
    private int mLeft;
    private int mMotionEdge;
    private HighlightView mMotionHighlightView;
    private int mRight;
    private boolean mSaving;
    private int mTop;
    private boolean mWaitingToPick;

    public CropImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        latch = new CountDownLatch(1);
        mSaving = false;
        mWaitingToPick = false;
        mHighlightViews = new ArrayList();
        mMotionHighlightView = null;
    }

    private void centerBasedOnHighlightView(HighlightView highlightview)
    {
        Rect rect = highlightview.mDrawRect;
        float f = rect.width();
        float f1 = rect.height();
        float f2 = getWidth();
        float f3 = getHeight();
        f = Math.max(1.0F, Math.min((f2 / f) * 0.6F, (f3 / f1) * 0.6F) * getScale());
        if ((double)(Math.abs(f - getScale()) / f) > 0.10000000000000001D)
        {
            float af[] = new float[2];
            af[0] = highlightview.mCropRect.centerX();
            af[1] = highlightview.mCropRect.centerY();
            getImageMatrix().mapPoints(af);
            zoomTo(f, af[0], af[1], 300F);
        }
        ensureVisible(highlightview);
    }

    private void ensureVisible(HighlightView highlightview)
    {
        highlightview = highlightview.mDrawRect;
        int i = Math.max(0, mLeft - ((Rect) (highlightview)).left);
        int l = Math.min(0, mRight - ((Rect) (highlightview)).right);
        int j = Math.max(0, mTop - ((Rect) (highlightview)).top);
        int k = Math.min(0, mBottom - ((Rect) (highlightview)).bottom);
        if (i == 0)
        {
            i = l;
        }
        if (j == 0)
        {
            j = k;
        }
        if (i != 0 || j != 0)
        {
            panBy(i, j);
        }
    }

    private void recomputeFocus(MotionEvent motionevent)
    {
        for (int i = 0; i < mHighlightViews.size(); i++)
        {
            HighlightView highlightview = (HighlightView)mHighlightViews.get(i);
            highlightview.setFocus(false);
            highlightview.invalidate();
        }

        int j = 0;
        do
        {
label0:
            {
                if (j < mHighlightViews.size())
                {
                    HighlightView highlightview1 = (HighlightView)mHighlightViews.get(j);
                    if (highlightview1.getHit(motionevent.getX(), motionevent.getY()) == 1)
                    {
                        break label0;
                    }
                    if (!highlightview1.hasFocus())
                    {
                        highlightview1.setFocus(true);
                        highlightview1.invalidate();
                    }
                }
                invalidate();
                return;
            }
            j++;
        } while (true);
    }

    public void add(HighlightView highlightview)
    {
        mHighlightViews.add(highlightview);
        invalidate();
    }

    public volatile void clear()
    {
        super.clear();
    }

    public void cropForSave()
    {
        if (mHighlightViews != null && mHighlightViews.size() >= 1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mCrop = (HighlightView)mHighlightViews.get(0);
        if (mCrop == null) goto _L1; else goto _L3
_L3:
        Rect rect;
        int i;
        int j;
        rect = mCrop.getCropRect();
        j = rect.width();
        i = rect.height();
        Bitmap bitmap;
        if (CropPhotoActivity.log.isLoggable)
        {
            FwLog.println(CropPhotoActivity.log, (new StringBuilder()).append("Attempting crop. width:").append(j).append(" height:").append(i).toString());
        }
        bitmap = Bitmap.createBitmap(j, i, android.graphics.Bitmap.Config.RGB_565);
_L5:
        Canvas canvas = new Canvas(bitmap);
        Rect rect1 = new Rect(0, 0, j, i);
        canvas.drawBitmap(mBitmap, rect, rect1, null);
        clear();
        mBitmap.recycle();
        initImage(bitmap, false);
        return;
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        try
        {
            j /= 2;
            i /= 2;
            if (CropPhotoActivity.log.isLoggable)
            {
                FwLog.println(CropPhotoActivity.log, (new StringBuilder()).append("Out of memory, trying crop again with a reduced image size. width:").append(j).append(" height:").append(i).toString());
            }
            outofmemoryerror = Bitmap.createBitmap(j, i, android.graphics.Bitmap.Config.RGB_565);
        }
        catch (OutOfMemoryError outofmemoryerror1)
        {
            if (CropPhotoActivity.log.isLoggable)
            {
                FwLog.println(CropPhotoActivity.log, (new StringBuilder()).append("Still not enough memory, return uncropped image. width:").append(mBitmap.getWidth()).append(" height:").append(mBitmap.getHeight()).toString());
            }
            Toast.makeText(getContext(), getContext().getText(0x7f07078b), 1).show();
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void initImage(Bitmap bitmap, boolean flag)
    {
        if (bitmap == null)
        {
            return;
        }
        mWaitingToPick = false;
        mHighlightViews.clear();
        HighlightView highlightview = new HighlightView(this);
        int l = bitmap.getWidth();
        int k = bitmap.getHeight();
        Rect rect = new Rect(0, 0, l, k);
        int i = (l * 9) / 10;
        int j = (k * 9) / 10;
        l = (l - i) / 2;
        k = (k - j) / 2;
        RectF rectf = new RectF(l, k, l + i, k + j);
        highlightview.setup(getImageMatrix(), rect, rectf, false, false);
        if (flag)
        {
            add(highlightview);
        }
        clear();
        setImage(bitmap, flag);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        for (int i = 0; i < mHighlightViews.size(); i++)
        {
            ((HighlightView)mHighlightViews.get(i)).draw(canvas);
        }

    }

    public volatile boolean onKeyDown(int i, KeyEvent keyevent)
    {
        return super.onKeyDown(i, keyevent);
    }

    public volatile boolean onKeyUp(int i, KeyEvent keyevent)
    {
        return super.onKeyUp(i, keyevent);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        mLeft = i;
        mRight = k;
        mTop = j;
        mBottom = l;
        super.onLayout(flag, i, j, k, l);
        if (mBitmapDisplayed.getBitmap() != null)
        {
            Iterator iterator = mHighlightViews.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                HighlightView highlightview = (HighlightView)iterator.next();
                highlightview.mMatrix.set(getImageMatrix());
                highlightview.invalidate();
                if (highlightview.mIsFocused)
                {
                    centerBasedOnHighlightView(highlightview);
                }
            } while (true);
        }
        latch.countDown();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (mSaving)
        {
            return false;
        }
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 40
    //                   0 70
    //                   1 205
    //                   2 350;
           goto _L1 _L2 _L3 _L4
_L1:
        motionevent.getAction();
        JVM INSTR tableswitch 1 2: default 68
    //                   1 428
    //                   2 437;
           goto _L5 _L6 _L7
_L5:
        return true;
_L2:
        if (!mWaitingToPick) goto _L9; else goto _L8
_L8:
        recomputeFocus(motionevent);
          goto _L1
_L9:
        int i = 0;
_L13:
        if (i >= mHighlightViews.size()) goto _L1; else goto _L10
_L10:
        HighlightView highlightview;
        int k;
        highlightview = (HighlightView)mHighlightViews.get(i);
        k = highlightview.getHit(motionevent.getX(), motionevent.getY());
        if (k == 1) goto _L12; else goto _L11
_L11:
        mMotionEdge = k;
        mMotionHighlightView = highlightview;
        mLastX = motionevent.getX();
        mLastY = motionevent.getY();
        if (k == 32)
        {
            mMotionHighlightView.setMode(HighlightView.ModifyMode.Move);
        } else
        {
            mMotionHighlightView.setFocus(true);
            mMotionHighlightView.setMode(HighlightView.ModifyMode.Grow);
        }
          goto _L1
_L12:
        i++;
          goto _L13
_L3:
        if (mWaitingToPick)
        {
            for (int j = 0; j < mHighlightViews.size(); j++)
            {
                HighlightView highlightview1 = (HighlightView)mHighlightViews.get(j);
                if (highlightview1.hasFocus())
                {
                    mCrop = highlightview1;
                    int l = 0;
                    while (l < mHighlightViews.size()) 
                    {
                        if (l != j)
                        {
                            ((HighlightView)mHighlightViews.get(l)).setHidden(true);
                        }
                        l++;
                    }
                    centerBasedOnHighlightView(highlightview1);
                    mWaitingToPick = false;
                    return true;
                }
            }

        } else
        if (mMotionHighlightView != null)
        {
            centerBasedOnHighlightView(mMotionHighlightView);
            mMotionHighlightView.setMode(HighlightView.ModifyMode.None);
        }
        mMotionHighlightView = null;
          goto _L1
_L4:
        if (mWaitingToPick)
        {
            recomputeFocus(motionevent);
        } else
        if (mMotionHighlightView != null)
        {
            mMotionHighlightView.handleMotion(mMotionEdge, motionevent.getX() - mLastX, motionevent.getY() - mLastY);
            mLastX = motionevent.getX();
            mLastY = motionevent.getY();
            ensureVisible(mMotionHighlightView);
        }
          goto _L1
_L6:
        center(true, true);
          goto _L5
_L7:
        if (getScale() == 1.0F)
        {
            center(true, true);
        }
          goto _L5
    }

    protected void postTranslate(float f, float f1)
    {
        super.postTranslate(f, f1);
        for (int i = 0; i < mHighlightViews.size(); i++)
        {
            HighlightView highlightview = (HighlightView)mHighlightViews.get(i);
            highlightview.mMatrix.postTranslate(f, f1);
            highlightview.invalidate();
        }

    }

    public void rotate(Direction direction)
    {
        Object obj = new Matrix();
        int i;
        if (direction == Direction.RIGHT)
        {
            i = 90;
        } else
        {
            i = -90;
        }
        ((Matrix) (obj)).postRotate(i);
        direction = null;
        obj = Bitmap.createBitmap(mBitmap, 0, 0, mBitmap.getWidth(), mBitmap.getHeight(), ((Matrix) (obj)), true);
        direction = ((Direction) (obj));
_L2:
        if (direction != null)
        {
            clear();
            mBitmap.recycle();
            initImage(direction, true);
        }
        return;
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        Toast.makeText(getContext(), getContext().getText(0x7f07078c), 1).show();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public Uri save()
    {
        Uri uri;
        Object obj1;
        Uri uri1;
        File file;
        File file1;
        if (mSaving)
        {
            return null;
        }
        mSaving = true;
        file = null;
        uri1 = null;
        file1 = getContext().getCacheDir();
        uri = uri1;
        obj1 = file;
        file1 = File.createTempFile("cropped", "jpg", file1);
        uri = uri1;
        obj1 = file;
        TemporaryFileManager.instance.add(file1);
        uri = uri1;
        obj1 = file;
        FileOutputStream fileoutputstream = new FileOutputStream(file1);
        uri = uri1;
        obj1 = file;
        mBitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 90, fileoutputstream);
        uri = uri1;
        obj1 = file;
        fileoutputstream.close();
        uri = uri1;
        obj1 = file;
        uri1 = Uri.parse(file1.toURI().toString());
        uri = uri1;
        obj1 = uri1;
        if (!CropPhotoActivity.log.isLoggable)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        uri = uri1;
        obj1 = uri1;
        file = new File(file1.toURI());
        uri = uri1;
        obj1 = uri1;
        FwLog.println(CropPhotoActivity.log, (new StringBuilder()).append("Size of saved image on disk is: ").append((float)file.length() / 1024F).append(" kB").toString());
        mSaving = false;
        return uri1;
        obj1;
        ((IOException) (obj1)).printStackTrace();
        mSaving = false;
        return uri;
        Object obj;
        obj;
        Log.e("CropImageView", (new StringBuilder()).append("exception = ").append(obj).toString());
        mSaving = false;
        return ((Uri) (obj1));
        obj;
        mSaving = false;
        throw obj;
    }

    public void setImage(Bitmap bitmap, boolean flag)
    {
        mBitmap = bitmap;
        if (flag)
        {
            setImageBitmapResetBase(bitmap, true);
            center(true, true);
        }
    }

    public volatile void setImageBitmap(Bitmap bitmap)
    {
        super.setImageBitmap(bitmap);
    }

    public volatile void setImageBitmapResetBase(Bitmap bitmap, boolean flag)
    {
        super.setImageBitmapResetBase(bitmap, flag);
    }

    public volatile void setImageRotateBitmapResetBase(RotateBitmap rotatebitmap, boolean flag)
    {
        super.setImageRotateBitmapResetBase(rotatebitmap, flag);
    }

    public volatile void setRecycler(ImageViewTouchBase.Recycler recycler)
    {
        super.setRecycler(recycler);
    }

    protected void zoomIn()
    {
        super.zoomIn();
        HighlightView highlightview;
        for (Iterator iterator = mHighlightViews.iterator(); iterator.hasNext(); highlightview.invalidate())
        {
            highlightview = (HighlightView)iterator.next();
            highlightview.mMatrix.set(getImageMatrix());
        }

    }

    protected void zoomOut()
    {
        super.zoomOut();
        HighlightView highlightview;
        for (Iterator iterator = mHighlightViews.iterator(); iterator.hasNext(); highlightview.invalidate())
        {
            highlightview = (HighlightView)iterator.next();
            highlightview.mMatrix.set(getImageMatrix());
        }

    }

    protected void zoomTo(float f, float f1, float f2)
    {
        super.zoomTo(f, f1, f2);
        HighlightView highlightview;
        for (Iterator iterator = mHighlightViews.iterator(); iterator.hasNext(); highlightview.invalidate())
        {
            highlightview = (HighlightView)iterator.next();
            highlightview.mMatrix.set(getImageMatrix());
        }

    }

    public void zoomToMax()
    {
        initImage(mBitmap, true);
    }
}
