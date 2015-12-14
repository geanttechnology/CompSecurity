// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.mosaic;

import aky;
import akz;
import ala;
import alb;
import ald;
import ale;
import ali;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.Log;
import android.view.MotionEvent;
import java.io.IOException;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MosaicGLSurfaceView extends GLSurfaceView
    implements android.opengl.GLSurfaceView.Renderer
{

    public static final String ClassicMosaicPath = "mosaic";
    public static final String MaoboliPath = "maoboli";
    private static final String TAG = "MosaicGLSurfaceView";
    private static Context _context;
    private static float f[] = new float[9];
    static MosaicGLSurfaceView gView;
    private static PointF returnPt = new PointF();
    private static float tm1[] = new float[2];
    private static float tm2[] = new float[2];
    static final float zoomMax = 3F;
    static final float zoomMin = 1F;
    private float bg_b;
    private float bg_g;
    private float bg_r;
    private float down_mid_x;
    private float down_mid_y;
    private int fb[];
    private float initDis;
    private aky mBg;
    private String mBrushImagePath;
    private int mBrushType;
    private int mBrushWid;
    private boolean mClearFrameBuffer;
    private int mColor;
    private int mCurPenIndex;
    PointF mCurPt;
    ArrayList mEachPenArray;
    ArrayList mEachPenVertexArray;
    private final float mMVPMatrix[] = new float[16];
    private Bitmap mMaoboli;
    private Matrix mMat;
    private int mMinPenSize;
    private ala mMosaic;
    private String mMosaicImagePath;
    private boolean mMosaicOrPaint;
    private boolean mNeedSaveImage;
    private int mOriTexture;
    private Bitmap mOriginalImage;
    private int mPointStep;
    PointF mPreviousPt;
    private final float mProjectionMatrix[] = new float[16];
    private Matrix mSaveMat;
    private float mScale;
    private final float mViewMatrix[] = new float[16];
    private PointF mid;
    private ali preNextDelegate;
    private float randomStrength;
    private int renderTex[];
    private float squareCoords[] = {
        -1F, -1F, 1.0F, -1F, -1F, 1.0F, 1.0F, 1.0F
    };
    private float tranCoords[] = {
        -1F, -1F, 1.0F, -1F, -1F, 1.0F, 1.0F, 1.0F
    };
    boolean twoFingers;
    float viewPortHeight;
    float viewPortWidth;
    boolean zooming;

    public MosaicGLSurfaceView(Context context)
    {
        super(context);
        mMinPenSize = 32;
        mMosaicOrPaint = true;
        mPointStep = 1;
        mClearFrameBuffer = true;
        mBrushType = 2;
        mBrushWid = 64;
        mColor = 0;
        randomStrength = 0.5F;
        mNeedSaveImage = false;
        mCurPenIndex = 0;
        twoFingers = false;
        zooming = false;
        mid = new PointF();
        initDis = 1.0F;
        mMat = new Matrix();
        mSaveMat = new Matrix();
        down_mid_x = 0.0F;
        down_mid_y = 0.0F;
        fb = new int[1];
        renderTex = new int[1];
        mScale = 1.0F;
        gView = this;
        _context = context;
        setEGLContextClientVersion(2);
        setRenderer(this);
        setRenderMode(0);
        setDebugFlags(3);
        mEachPenArray = new ArrayList();
        mEachPenVertexArray = new ArrayList();
        mPreviousPt = new PointF();
        mCurPt = new PointF();
        int i = context.getResources().getColor(0x7f0c0092);
        bg_r = (float)(i >> 16 & 0xff) / 255F;
        bg_g = (float)(i >> 8 & 0xff) / 255F;
        bg_b = (float)(i >> 0 & 0xff) / 255F;
    }

    private void CalculateScale()
    {
        mMat.getValues(f);
        mScale = f[0];
    }

    private void addVertexToEachVertexArray(PointF pointf, PointF pointf1)
    {
        int i = 1;
        if (mBrushImagePath.indexOf("paintBrush0.png") > 0 || mBrushImagePath.indexOf("paintBrush1.png") > 0 || mBrushImagePath.indexOf("paintBrush4.png") > 0 || mBrushImagePath.indexOf("paintBrush12.png") > 0)
        {
            mPointStep = 1;
        }
        if (mBrushType == 4 || mBrushType == 2 || mBrushType == 0)
        {
            mPointStep = 1;
        }
        int j = Math.min(Math.max((int)(Math.ceil(Math.sqrt((pointf1.x - pointf.x) * (pointf1.x - pointf.x) + (pointf1.y - pointf.y) * (pointf1.y - pointf.y))) / (double)mPointStep), 1), 64);
        float af[];
        if (mBrushType != 1)
        {
            i = j;
        }
        af = new float[i * 2];
        for (j = 0; j < i; j++)
        {
            int k = j * 2;
            af[k] = pointf.x + (pointf1.x - pointf.x) * ((float)j / (float)i);
            af[k + 1] = pointf.y + (pointf1.y - pointf.y) * ((float)j / (float)i);
        }

        pointf = new ald(this);
        pointf.a = mColor;
        pointf.d = mBrushType;
        pointf.e = (int)((float)mBrushWid / mScale);
        pointf.f = mBrushImagePath;
        pointf.g = mMosaicImagePath;
        pointf.b = af;
        pointf.c = new float[((ald) (pointf)).b.length];
        for (i = 0; i < ((ald) (pointf)).c.length; i += 2)
        {
            ((ald) (pointf)).c[i] = ((ald) (pointf)).b[i] + (float)minusOne2OneRand() * (float)((ald) (pointf)).e * randomStrength;
            ((ald) (pointf)).c[i + 1] = ((ald) (pointf)).b[i + 1] + (float)minusOne2OneRand() * (float)((ald) (pointf)).e * randomStrength;
        }

        mEachPenVertexArray.add(pointf);
        pointf1 = new ArrayList();
        pointf1.add(pointf);
        mMosaic.a(pointf1);
    }

    public static int bitmapToTexture(Bitmap bitmap)
    {
        int ai[] = new int[1];
        GLES20.glGenTextures(1, ai, 0);
        if (ai[0] != 0)
        {
            GLES20.glBindTexture(3553, ai[0]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        }
        return ai[0];
    }

    private void calculateCoords(float f1, float f2)
    {
        float f3 = mOriginalImage.getWidth();
        float f4 = mOriginalImage.getHeight();
        if (f3 / f4 > f1 / f2)
        {
            f1 = (f4 * f1) / f3 / f2;
            squareCoords[0] = -1F;
            squareCoords[1] = -f1;
            squareCoords[2] = 1.0F;
            squareCoords[3] = -f1;
            squareCoords[4] = -1F;
            squareCoords[5] = f1;
            squareCoords[6] = 1.0F;
            squareCoords[7] = f1;
            return;
        } else
        {
            f1 = (f3 * f2) / f4 / f1;
            squareCoords[0] = -f1;
            squareCoords[1] = -1F;
            squareCoords[2] = f1;
            squareCoords[3] = -1F;
            squareCoords[4] = -f1;
            squareCoords[5] = 1.0F;
            squareCoords[6] = f1;
            squareCoords[7] = 1.0F;
            return;
        }
    }

    private boolean canMoveNext()
    {
        return mCurPenIndex < mEachPenArray.size();
    }

    private boolean canMovePrevious()
    {
        return mCurPenIndex > 0;
    }

    public static void checkGlError(String s)
    {
        int i = GLES20.glGetError();
        if (i != 0)
        {
            Log.e("MosaicGLSurfaceView", (new StringBuilder()).append(s).append(": glError ").append(i).toString());
            throw new RuntimeException((new StringBuilder()).append(s).append(": glError ").append(i).toString());
        } else
        {
            return;
        }
    }

    private PointF convertMidPoint()
    {
        float af[] = new float[4];
        af[0] = mid.x;
        af[1] = mid.y;
        android.opengl.Matrix.multiplyMV(af, 0, mMVPMatrix, 0, af, 0);
        af[0] = af[0] - 1.0F;
        af[1] = af[1] + 1.0F;
        return new PointF(af[0], af[1]);
    }

    private PointF convertTouchPoint(float f1, float f2)
    {
        CalculateScale();
        float f4 = squareCoords[4];
        float f3 = squareCoords[5];
        float f5 = squareCoords[2];
        float f6 = squareCoords[3];
        tm1[0] = f4;
        tm1[1] = f3;
        tm2[0] = f5;
        tm2[1] = f6;
        mMat.mapPoints(tm1);
        mMat.mapPoints(tm2);
        f6 = (viewPortWidth * Math.abs(tm2[0] - tm1[0])) / 2.0F;
        f5 = (viewPortHeight * Math.abs(tm2[1] - tm1[1])) / 2.0F;
        float f8 = Math.min(f6, viewPortWidth);
        f5 = Math.min(f5, viewPortHeight);
        if (f8 < viewPortWidth)
        {
            f1 = (f1 - (viewPortWidth - f8) / 2.0F) / f8;
            returnPt.x = f1 * viewPortWidth;
        } else
        {
            float f7 = tm1[0];
            f1 = (f1 * 2.0F) / f8;
            f8 = mScale;
            f1 = (f1 + (f4 - f7 - (1.0F + f4))) / (Math.abs(f4) * f8 * 2.0F);
            returnPt.x = f1 * viewPortWidth;
        }
        if (f5 < viewPortHeight)
        {
            f1 = (f2 - (viewPortHeight - f5) / 2.0F) / f5;
            returnPt.y = f1 * viewPortHeight;
        } else
        {
            f1 = ((tm1[1] - f3 - (1.0F - f3)) + (f2 * 2.0F) / f5) / (f3 * mScale * 2.0F);
            returnPt.y = f1 * viewPortHeight;
        }
        return returnPt;
    }

    private void correctMatrix()
    {
        mMat.mapPoints(tranCoords, squareCoords);
        PointF pointf = convertMidPoint();
        float f1 = 0.0F;
        float f5 = 0.0F;
        boolean flag = false;
        float f3 = tranCoords[2] - tranCoords[0];
        float f2 = tranCoords[5] - tranCoords[1];
        float f4 = f3 / 2.0F;
        f4 = f2 / 2.0F;
        if ((double)f3 >= 2D)
        {
            f3 = 1.0F;
        } else
        {
            f3 /= 2.0F;
        }
        if ((double)f2 >= 2D)
        {
            f2 = 1.0F;
        } else
        {
            f2 /= 2.0F;
        }
        if (tranCoords[0] > -f3)
        {
            f1 = -f3 - tranCoords[0];
            pointf.x = -f3;
            flag = true;
        }
        f4 = f1;
        if (tranCoords[2] < f3)
        {
            f4 = f3 - tranCoords[2];
            pointf.x = f3;
            flag = true;
        }
        f1 = f5;
        if (tranCoords[1] > -f2)
        {
            f1 = -f2 - tranCoords[1];
            pointf.y = f2;
            flag = true;
        }
        if (tranCoords[5] < f2)
        {
            f1 = f2 - tranCoords[5];
            pointf.y = f2;
            flag = true;
        }
        if (flag)
        {
            mMat.postTranslate(f4, f1);
        }
        f1 = (tranCoords[2] - tranCoords[0]) / 2.0F;
        f3 = (3F * (squareCoords[2] - squareCoords[0])) / 2.0F;
        f2 = (1.0F * (squareCoords[2] - squareCoords[0])) / 2.0F;
        if (f1 > f3)
        {
            f3 /= f1;
            mMat.postScale(f3, f3, pointf.x, pointf.y);
        }
        if (f1 < f2)
        {
            f1 = f2 / f1;
            mMat.postScale(f1, f1, pointf.x, pointf.y);
        }
    }

    public static void deleteGlTexture(int i)
    {
        if (i == 0)
        {
            return;
        } else
        {
            GLES20.glDeleteTextures(1, new int[] {
                i
            }, 0);
            return;
        }
    }

    private void doSaveImage()
    {
        int i = mOriginalImage.getWidth();
        int j = mOriginalImage.getHeight();
        int ai[] = new int[1];
        int ai1[] = new int[1];
        GLES20.glGenFramebuffers(1, ai, 0);
        GLES20.glGenTextures(1, ai1, 0);
        GLES20.glBindTexture(3553, ai1[0]);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, i, j, 0, 6408, 5121, null);
        GLES20.glBindFramebuffer(36160, ai[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, ai1[0], 0);
        if (GLES20.glCheckFramebufferStatus(36160) != 36053)
        {
            return;
        } else
        {
            GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
            GLES20.glClear(16640);
            GLES20.glViewport(0, 0, i, j);
            Object obj = new Matrix();
            mBg.a(((Matrix) (obj)));
            mBg.a(new float[] {
                -1F, -1F, 1.0F, -1F, -1F, 1.0F, 1.0F, 1.0F
            });
            mBg.d = mOriTexture;
            mBg.b();
            mMosaic.a(getCurrentPenArray());
            mMosaic.b();
            obj = IntBuffer.allocate(i * j);
            ((IntBuffer) (obj)).rewind();
            GLES20.glReadPixels(0, 0, i, j, 6408, 5121, ((java.nio.Buffer) (obj)));
            Bitmap bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
            ((IntBuffer) (obj)).rewind();
            bitmap.copyPixelsFromBuffer(((java.nio.Buffer) (obj)));
            saveImage(flipImage(bitmap));
            GLES20.glDeleteFramebuffers(1, ai, 0);
            GLES20.glDeleteTextures(1, ai1, 0);
            return;
        }
    }

    private static void dumpMotionEvent(MotionEvent motionevent)
    {
        int i = 0;
        StringBuilder stringbuilder = new StringBuilder();
        int j = motionevent.getAction();
        int k = j & 0xff;
        stringbuilder.append("event ACTION_").append((new String[] {
            "DOWN", "UP", "MOVE", "CANCEL", "OUTSIDE", "POINTER_DOWN", "POINTER_UP", "7?", "8?", "9?"
        })[k]);
        if (k == 5 || k == 6)
        {
            stringbuilder.append("(pid ").append(j >> 8);
            stringbuilder.append(")");
        }
        stringbuilder.append("[");
        for (; i < motionevent.getPointerCount(); i++)
        {
            stringbuilder.append("#").append(i);
            stringbuilder.append("(pid ").append(motionevent.getPointerId(i));
            stringbuilder.append(")=").append((int)motionevent.getX(i));
            stringbuilder.append(",").append((int)motionevent.getY(i));
            if (i + 1 < motionevent.getPointerCount())
            {
                stringbuilder.append(";");
            }
        }

        stringbuilder.append("]");
        Log.d("MosaicGLSurfaceView", stringbuilder.toString());
    }

    private Bitmap flipImage(Bitmap bitmap)
    {
        Matrix matrix = new Matrix();
        matrix.preScale(1.0F, -1F);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    private Bitmap generateMaoboli(Bitmap bitmap)
    {
        return akz.a(bitmap, (int)((double)bitmap.getWidth() * 0.080000000000000002D));
    }

    public static Bitmap getBitmapFromAssetPath(String s)
    {
        AssetManager assetmanager = _context.getAssets();
        Object obj = null;
        try
        {
            s = assetmanager.open(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = obj;
        }
        return BitmapFactory.decodeStream(s);
    }

    private ArrayList getCurrentPenArray()
    {
        if (mEachPenArray.size() == 0)
        {
            return mEachPenArray;
        }
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < mCurPenIndex; i++)
        {
            arraylist.add(mEachPenArray.get(i));
        }

        if (arraylist.size() > 0)
        {
            ald ald1 = (ald)arraylist.get(0);
            setMosaicLastDrawPoint(ald1.b[0], ald1.b[1]);
            mMosaic.e = true;
        }
        return arraylist;
    }

    public static int loadShader(int i, String s)
    {
        i = GLES20.glCreateShader(i);
        GLES20.glShaderSource(i, s);
        GLES20.glCompileShader(i);
        return i;
    }

    public static int loadTexture(String s)
    {
        int ai[] = new int[1];
        GLES20.glGenTextures(1, ai, 0);
        if (ai[0] != 0)
        {
            GLES20.glBindTexture(3553, ai[0]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLUtils.texImage2D(3553, 0, getBitmapFromAssetPath(s), 0);
        }
        return ai[0];
    }

    private void makeEachPenToVertex()
    {
        if (mEachPenVertexArray == null || mEachPenVertexArray.size() == 0)
        {
            return;
        }
        int i = 0;
        int j = 0;
        for (; i < mEachPenVertexArray.size(); i++)
        {
            j += ((ald)mEachPenVertexArray.get(i)).b.length;
        }

        ald ald1 = new ald(this);
        ald1.a = mColor;
        ald1.d = mBrushType;
        ald1.e = (int)((float)mBrushWid / mScale);
        ald1.f = mBrushImagePath;
        ald1.g = mMosaicImagePath;
        ald1.b = new float[j];
        ald1.c = new float[j];
        i = 0;
        j = 0;
        for (; i < mEachPenVertexArray.size(); i++)
        {
            ald ald2 = (ald)mEachPenVertexArray.get(i);
            System.arraycopy(ald2.b, 0, ald1.b, j, ald2.b.length);
            System.arraycopy(ald2.c, 0, ald1.c, j, ald2.c.length);
            j += ald2.b.length;
        }

        mEachPenArray.add(ald1);
        mCurPenIndex = mCurPenIndex + 1;
        updatePreNext();
    }

    private void midPoint(PointF pointf, MotionEvent motionevent)
    {
        if (motionevent.getPointerCount() < 2)
        {
            return;
        }
        try
        {
            float f1 = motionevent.getX(0);
            float f2 = motionevent.getX(1);
            float f3 = motionevent.getY(0);
            float f4 = motionevent.getY(1);
            pointf.set((f1 + f2) / 2.0F, (f3 + f4) / 2.0F);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PointF pointf)
        {
            Log.v("TAG", pointf.getLocalizedMessage());
        }
    }

    public static double minusOne2OneRand()
    {
        return 2D * Math.random() - 1.0D;
    }

    private void removeTailPens()
    {
        if (canMoveNext())
        {
            mEachPenArray = getCurrentPenArray();
            updatePreNext();
        }
    }

    private void saveImage(Bitmap bitmap)
    {
        if (preNextDelegate != null)
        {
            preNextDelegate.a(bitmap);
        }
    }

    private void setMosaicLastDrawPoint(float f1, float f2)
    {
        mMosaic.d.x = f1;
        mMosaic.d.y = f2;
    }

    private void setOriTexture()
    {
        deleteGlTexture(mOriTexture);
        mOriTexture = bitmapToTexture(mOriginalImage);
    }

    private void setupFBO(int ai[], int ai1[], int i, int j)
    {
        if (ai != null && ai[0] != 0)
        {
            GLES20.glDeleteTextures(1, ai, 0);
            ai[0] = 0;
        }
        if (ai1 != null && ai1[0] != 0)
        {
            GLES20.glDeleteFramebuffers(1, ai1, 0);
            ai1[0] = 0;
        }
        GLES20.glGenFramebuffers(1, ai1, 0);
        GLES20.glGenTextures(1, ai, 0);
        GLES20.glBindTexture(3553, ai[0]);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, i, j, 0, 6408, 5121, null);
        GLES20.glBindFramebuffer(36160, ai1[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, ai[0], 0);
        if (GLES20.glCheckFramebufferStatus(36160) != 36053)
        {
            return;
        } else
        {
            GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
            GLES20.glClear(16640);
            return;
        }
    }

    public static Bitmap smallBitmapToBigBitmap(Bitmap bitmap)
    {
        int i = gView.mOriginalImage.getWidth();
        int j = gView.mOriginalImage.getHeight();
        float f3 = bitmap.getWidth();
        float f4 = bitmap.getHeight();
        Bitmap bitmap1 = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        for (float f1 = 0.0F; f1 < (float)i; f1 += f3)
        {
            for (float f2 = 0.0F; f2 < (float)j; f2 += f4)
            {
                canvas.drawBitmap(bitmap, f1, f2, null);
            }

        }

        return bitmap1;
    }

    private float spacing(MotionEvent motionevent)
    {
        double d;
        try
        {
            float f1 = motionevent.getX(0) - motionevent.getX(1);
            float f2 = motionevent.getY(0) - motionevent.getY(1);
            d = Math.sqrt(f1 * f1 + f2 * f2);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            Log.v("TAG", motionevent.getLocalizedMessage());
            return initDis;
        }
        return (float)d;
    }

    private void updatePreNext()
    {
        if (preNextDelegate != null)
        {
            preNextDelegate.a(canMovePrevious(), canMoveNext());
        }
    }

    public void moveNext()
    {
        if (canMoveNext())
        {
            mClearFrameBuffer = true;
            mCurPenIndex = mCurPenIndex + 1;
            updatePreNext();
            ArrayList arraylist = getCurrentPenArray();
            mMosaic.a(arraylist);
            requestRender();
        }
    }

    public void movePrevious()
    {
        if (canMovePrevious())
        {
            mClearFrameBuffer = true;
            mCurPenIndex = mCurPenIndex - 1;
            updatePreNext();
            ArrayList arraylist = getCurrentPenArray();
            mMosaic.a(arraylist);
            requestRender();
        }
    }

    public void onDrawFrame(GL10 gl10)
    {
        GLES20.glBindFramebuffer(36160, fb[0]);
        if (mClearFrameBuffer)
        {
            mClearFrameBuffer = false;
            GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
            GLES20.glClear(16640);
        }
        mMosaic.b();
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glClearColor(bg_r, bg_g, bg_b, 1.0F);
        GLES20.glClear(16640);
        mBg.a(mMat);
        mBg.d = mOriTexture;
        mBg.b();
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(1, 771);
        mBg.d = renderTex[0];
        mBg.b();
        if (mNeedSaveImage)
        {
            mNeedSaveImage = false;
            doSaveImage();
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int j)
    {
        calculateCoords(i, j);
        GLES20.glViewport(0, 0, i, j);
        android.opengl.Matrix.orthoM(mProjectionMatrix, 0, 0.0F, i, j, 0.0F, -1F, 1.0F);
        android.opengl.Matrix.setLookAtM(mViewMatrix, 0, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
        android.opengl.Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);
        mMosaic.a = i;
        mMosaic.b = j;
        mMosaic.c = squareCoords[6] / squareCoords[7];
        mMosaic.a(mMVPMatrix);
        viewPortWidth = i;
        viewPortHeight = j;
        setupFBO(renderTex, fb, i, j);
        mBg.a(squareCoords);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
        setOriTexture();
        mMosaic = new ala();
        mMosaic.h = mOriTexture;
        mMosaic.a(getCurrentPenArray());
        if (mMosaicOrPaint)
        {
            mMosaic.g = mOriginalImage;
            mMosaic.f = mMaoboli;
        }
        mBg = new aky();
        mBg.d = mOriTexture;
        mBg.a(mMat);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (mMosaic != null) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        float af[];
        float af1[];
        int j = motionevent.getPointerCount();
        int ai[] = new int[j];
        af = new float[j];
        af1 = new float[j];
        for (int i = 0; i < j; i++)
        {
            ai[i] = motionevent.getPointerId(i);
            af[i] = motionevent.getX(i);
            af1[i] = motionevent.getY(i);
        }

        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 6: default 136
    //                   0 138
    //                   1 657
    //                   2 367
    //                   3 657
    //                   4 136
    //                   5 315
    //                   6 627;
           goto _L3 _L4 _L5 _L6 _L5 _L3 _L7 _L8
_L3:
        return true;
_L4:
        twoFingers = false;
        zooming = false;
        if (mMosaic != null)
        {
            mMosaic.e = false;
        }
        removeTailPens();
        mPointStep = (int)(-2.5D * (double)mScale + 10.5D);
        mPointStep = (int)(((float)mBrushWid / (float)(mMinPenSize / 2)) * (float)mPointStep);
        motionevent = convertTouchPoint(af[0], af1[0]);
        mPreviousPt.x = ((PointF) (motionevent)).x;
        mPreviousPt.y = ((PointF) (motionevent)).y;
        setMosaicLastDrawPoint(mPreviousPt.x, mPreviousPt.y);
        mCurPt.x = mPreviousPt.x;
        mCurPt.y = mPreviousPt.y;
        mEachPenVertexArray.clear();
        addVertexToEachVertexArray(mPreviousPt, mCurPt);
        requestRender();
        return true;
_L7:
        twoFingers = true;
        zooming = true;
        initDis = spacing(motionevent);
        midPoint(mid, motionevent);
        down_mid_x = mid.x;
        down_mid_y = mid.y;
        return true;
_L6:
        if (!zooming)
        {
            break; /* Loop/switch isn't completed */
        }
        if (twoFingers)
        {
            makeEachPenToVertex();
            mMosaic.a(new ArrayList());
            mMat.set(mSaveMat);
            midPoint(mid, motionevent);
            float f1 = ((mid.x - down_mid_x) * 2.0F) / viewPortWidth;
            float f2 = ((mid.y - down_mid_y) * 2.0F) / viewPortHeight;
            mMat.postTranslate(f1, -f2);
            f1 = spacing(motionevent) / initDis;
            motionevent = convertMidPoint();
            mMat.postScale(f1, f1, ((PointF) (motionevent)).x, ((PointF) (motionevent)).y);
            requestRender();
            return true;
        }
        if (true) goto _L1; else goto _L9
_L9:
        motionevent = convertTouchPoint(af[0], af1[0]);
        mCurPt.x = ((PointF) (motionevent)).x;
        mCurPt.y = ((PointF) (motionevent)).y;
        if (mCurPt.x != mPreviousPt.x || mCurPt.y != mPreviousPt.y)
        {
            addVertexToEachVertexArray(mPreviousPt, mCurPt);
            mPreviousPt.x = mCurPt.x;
            mPreviousPt.y = mCurPt.y;
            requestRender();
            return true;
        }
          goto _L1
_L8:
        twoFingers = false;
        correctMatrix();
        mSaveMat.set(mMat);
        CalculateScale();
        requestRender();
        return true;
_L5:
        if (!zooming)
        {
            makeEachPenToVertex();
        } else
        {
            correctMatrix();
            mSaveMat.set(mMat);
            CalculateScale();
            requestRender();
        }
        zooming = false;
        twoFingers = false;
        return true;
    }

    public void releaseOpenGLResource()
    {
        GLES20.glDeleteFramebuffers(1, fb, 0);
        fb[0] = 0;
        GLES20.glDeleteTextures(1, renderTex, 0);
        renderTex[0] = 0;
        mMosaic.a();
        mBg.a();
        deleteGlTexture(mOriTexture);
        mOriTexture = 0;
    }

    public void saveImage()
    {
        mNeedSaveImage = true;
        requestRender();
    }

    public void setBrushImagePath(String s)
    {
        mBrushImagePath = s;
    }

    public void setBrushSize(int i)
    {
        mBrushWid = i;
    }

    public void setMinPenSize(int i)
    {
        mMinPenSize = i;
    }

    public void setMosaicImagePath(String s)
    {
        mMosaicImagePath = s;
    }

    public void setMosaicOrPaint(boolean flag)
    {
        mMosaicOrPaint = flag;
        if (mMosaicOrPaint)
        {
            mMaoboli = generateMaoboli(mOriginalImage);
        }
    }

    public void setOperateDelegate(ali ali1)
    {
        preNextDelegate = ali1;
    }

    public void setOriImage(Bitmap bitmap, boolean flag, ale ale)
    {
        (new Thread(new alb(this, bitmap, flag, ale))).start();
    }

    public void setPenColor(int i)
    {
        mColor = i;
    }

    public void shift3DPen()
    {
        mBrushType = 4;
    }

    public void shiftColorPen()
    {
        mBrushType = 3;
    }

    public void shiftEraser()
    {
        mBrushType = 2;
    }

    public void shiftNormalMosaic()
    {
        mBrushType = 0;
    }

    public void shiftRandomMosaic()
    {
        mBrushType = 1;
    }



/*
    public static Bitmap access$002(MosaicGLSurfaceView mosaicglsurfaceview, Bitmap bitmap)
    {
        mosaicglsurfaceview.mOriginalImage = bitmap;
        return bitmap;
    }

*/

}
