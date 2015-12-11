// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.renderscript.RSInvalidStateException;
import android.support.v8.renderscript.RenderScript;
import co.vine.android.VineNotSupportedException;
import co.vine.android.util.CrashUtil;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.recorder:
//            RsYuv, VideoData, CameraSetting, RecordConfigUtils

public class PictureConverter
{
    public class ScaleStep
    {

        private final Bitmap mPreScaleBitmap;
        private final Canvas mPreScaleCanvas;
        private final Matrix mPreScaleMatrix;
        private final int scaledH;
        private final int scaledW;
        final PictureConverter this$0;

        private void scale()
        {
            mPreScaleCanvas.drawBitmap(srcBmp, mPreScaleMatrix, mPaint);
        }





        private ScaleStep(float f)
        {
            this$0 = PictureConverter.this;
            super();
            mPreScaleMatrix = new Matrix();
            scaledW = (int)((float)lastH * f);
            scaledH = lastH;
            mPreScaleMatrix.setScale((float)scaledW / (float)lastW, 1.0F);
            mPreScaleBitmap = Bitmap.createBitmap(scaledW, scaledH, RecordConfigUtils.DEFAULT_BITMAP_CONFIG);
            mPreScaleCanvas = new Canvas(mPreScaleBitmap);
        }

    }


    public final int LOCK[] = new int[0];
    private int lastH;
    private int lastW;
    private RsYuv mFilterYuv;
    private int mLastDegree;
    private boolean mLastFront;
    private boolean mLastMirrored;
    private final Matrix mMatrix = new Matrix();
    private final Paint mPaint = new Paint();
    private RenderScript mRS;
    private ScaleStep mScaleStep;
    private final int mTargetSize;
    private Bitmap srcBmp;

    public PictureConverter(RenderScript renderscript, int i, CameraSetting camerasetting)
        throws VineNotSupportedException
    {
        mLastDegree = 0xfffe7961;
        mLastMirrored = false;
        mRS = renderscript;
        mTargetSize = i;
        try
        {
            setCameraSetting(camerasetting);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RenderScript renderscript)
        {
            throw new VineNotSupportedException();
        }
    }

    private void allocate(int i, int j, int k)
        throws VineNotSupportedException
    {
        mFilterYuv = new RsYuv(mRS, j, k);
    }

    private void convertUsingRenderScript(CameraSetting camerasetting, VideoData videodata, boolean flag)
    {
        if (videodata.data == null)
        {
            CrashUtil.log("Data is null.");
        }
        if (mRS != null && (mFilterYuv == null || flag))
        {
            try
            {
                mFilterYuv = new RsYuv(mRS, camerasetting.originalW, camerasetting.originalH);
            }
            // Misplaced declaration of an exception variable
            catch (CameraSetting camerasetting)
            {
                CrashUtil.log("Failed to RsYuv, it should never reach here.");
            }
        }
        mFilterYuv.execute(videodata.data, srcBmp);
    }

    private void giveMatrixNewValuesWithScaleIfDegreeHasChanged(int i, boolean flag)
    {
        if (mLastDegree != i || mLastMirrored != flag)
        {
            float f;
            float f1;
            float f2;
            int j;
            int k;
            if (mScaleStep == null)
            {
                j = lastW;
            } else
            {
                j = mScaleStep.scaledW;
            }
            if (mScaleStep == null)
            {
                k = lastH;
            } else
            {
                k = mScaleStep.scaledH;
            }
            mMatrix.reset();
            f = Math.max((float)mTargetSize / (float)j, (float)mTargetSize / (float)k);
            f2 = j;
            f1 = k;
            f2 = -(f2 * f - (float)mTargetSize) / 2.0F;
            f1 = -(f1 * f - (float)mTargetSize) / 2.0F;
            mMatrix.postRotate(i, j / 2, k / 2);
            SLog.d("Creating with mirrored {}.", Boolean.valueOf(flag));
            if (flag)
            {
                mMatrix.postScale(-f, f);
                mMatrix.postTranslate(-f2 + (float)mTargetSize, f1);
            } else
            {
                mMatrix.postScale(f, f);
                mMatrix.postTranslate(f2, f1);
            }
            mLastMirrored = flag;
            mLastDegree = i;
        }
    }

    private void setCameraSetting(CameraSetting camerasetting)
        throws VineNotSupportedException
    {
        if (srcBmp != null)
        {
            srcBmp.recycle();
            srcBmp = null;
        }
        srcBmp = Bitmap.createBitmap(camerasetting.originalW, camerasetting.originalH, RecordConfigUtils.DEFAULT_BITMAP_CONFIG);
        int i = camerasetting.originalW;
        int j = camerasetting.originalH;
        lastH = camerasetting.originalH;
        lastW = camerasetting.originalW;
        mLastFront = camerasetting.frontFacing;
        if (camerasetting.frontFacing && camerasetting.frontFacingAspectRatio > 0.0F)
        {
            mScaleStep = new ScaleStep(camerasetting.frontFacingAspectRatio);
        } else
        if (camerasetting.backFacingAspectRatio > 0.0F)
        {
            mScaleStep = new ScaleStep(camerasetting.backFacingAspectRatio);
        } else
        {
            mScaleStep = null;
        }
        giveMatrixNewValuesWithScaleIfDegreeHasChanged(camerasetting.degrees, false);
        allocate(i * j, camerasetting.originalW, camerasetting.originalH);
    }

    public boolean convert(CameraSetting camerasetting, VideoData videodata, boolean flag)
    {
        try
        {
            convertUsingRenderScript(camerasetting, videodata, flag);
        }
        // Misplaced declaration of an exception variable
        catch (CameraSetting camerasetting)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (CameraSetting camerasetting)
        {
            return false;
        }
        return true;
    }

    public void draw(Canvas canvas)
    {
        if (mScaleStep == null)
        {
            canvas.drawBitmap(srcBmp, mMatrix, mPaint);
            return;
        } else
        {
            mScaleStep.scale();
            canvas.drawBitmap(mScaleStep.mPreScaleBitmap, mMatrix, mPaint);
            return;
        }
    }

    public void drawGeneric(Canvas canvas, Bitmap bitmap, Matrix matrix)
    {
        canvas.drawBitmap(bitmap, matrix, mPaint);
    }

    public void giveMatrixNewValuesWithScaleIfDegreeHasChangedWithKnownConfigs(int i, boolean flag)
    {
        giveMatrixNewValuesWithScaleIfDegreeHasChanged(i, flag);
    }

    public boolean updateSettingsIfNeeded(CameraSetting camerasetting)
    {
        boolean flag;
        if (lastW != camerasetting.originalW || lastH != camerasetting.originalH || camerasetting.frontFacing != mLastFront)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (srcBmp == null || flag)
        {
            try
            {
                setCameraSetting(camerasetting);
            }
            // Misplaced declaration of an exception variable
            catch (CameraSetting camerasetting)
            {
                CrashUtil.log("Failed to make RsYuv, it should never reach here.");
                return flag;
            }
        }
        return flag;
    }




}
