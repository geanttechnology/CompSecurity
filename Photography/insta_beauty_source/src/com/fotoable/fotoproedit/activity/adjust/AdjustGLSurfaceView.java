// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.adjust;

import ajd;
import aje;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.Log;
import com.fotoable.fotoproedit.activity.mosaic.MosaicGLSurfaceView;
import java.io.IOException;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class AdjustGLSurfaceView extends GLSurfaceView
    implements android.opengl.GLSurfaceView.Renderer
{

    private static final String TAG = "AdjustGLSurfaceView";
    private static Context _context;
    private ajd mAdjust;
    private float mColortemprature;
    private float mContrast;
    private float mGamma;
    private float mHighlight;
    private boolean mNeedSaveImage;
    private int mOriTexture;
    private Bitmap mOriginalImage;
    private float mSaturation;
    private float mShadow;
    private float mSharpness;
    private float mWhiteblance;
    private aje operDelegate;
    int viewPortHeight;
    int viewPortWidth;

    public AdjustGLSurfaceView(Context context)
    {
        super(context);
        mSaturation = 1.0F;
        mGamma = 1.0F;
        mSharpness = 0.0F;
        mContrast = 1.0F;
        mWhiteblance = 1.0F;
        mShadow = 0.0F;
        mHighlight = 0.0F;
        mColortemprature = 6600F;
        mNeedSaveImage = false;
        _context = context;
        setEGLContextClientVersion(2);
        setRenderer(this);
        setRenderMode(0);
        setDebugFlags(3);
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

    public static void checkGlError(String s)
    {
        int i = GLES20.glGetError();
        if (i != 0)
        {
            Log.e("AdjustGLSurfaceView", (new StringBuilder()).append(s).append(": glError ").append(i).toString());
            throw new RuntimeException((new StringBuilder()).append(s).append(": glError ").append(i).toString());
        } else
        {
            return;
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
            mAdjust.b();
            IntBuffer intbuffer = IntBuffer.allocate(i * j);
            intbuffer.rewind();
            GLES20.glReadPixels(0, 0, i, j, 6408, 5121, intbuffer);
            Bitmap bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
            intbuffer.rewind();
            bitmap.copyPixelsFromBuffer(intbuffer);
            saveImage(flipImage(bitmap));
            GLES20.glDeleteFramebuffers(1, ai, 0);
            GLES20.glDeleteTextures(1, ai1, 0);
            return;
        }
    }

    private Bitmap flipImage(Bitmap bitmap)
    {
        Matrix matrix = new Matrix();
        matrix.preScale(1.0F, -1F);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
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

    private void saveImage(Bitmap bitmap)
    {
        if (operDelegate != null)
        {
            operDelegate.a(bitmap);
        }
    }

    private void setOriTexture()
    {
        deleteGlTexture(mOriTexture);
        mOriTexture = bitmapToTexture(mOriginalImage);
    }

    public void onDrawFrame(GL10 gl10)
    {
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, viewPortWidth, viewPortHeight);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
        mAdjust.a(mSaturation);
        mAdjust.b(mGamma);
        mAdjust.c(mSharpness);
        mAdjust.d(mContrast);
        mAdjust.e(mWhiteblance);
        mAdjust.g(mHighlight);
        mAdjust.f(mShadow);
        mAdjust.h(mColortemprature);
        mAdjust.b();
        if (mNeedSaveImage)
        {
            mNeedSaveImage = false;
            doSaveImage();
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int j)
    {
        GLES20.glViewport(0, 0, i, j);
        mAdjust.d = i;
        mAdjust.e = j;
        viewPortWidth = i;
        viewPortHeight = j;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
        setOriTexture();
        mAdjust = new ajd();
        mAdjust.c = mOriTexture;
    }

    public void releaseOpenGLResource()
    {
        mAdjust.a();
        MosaicGLSurfaceView.deleteGlTexture(mOriTexture);
        mOriTexture = 0;
    }

    public void saveImage()
    {
        mNeedSaveImage = true;
        requestRender();
    }

    public void setColortemprature(float f)
    {
        mColortemprature = f;
        requestRender();
    }

    public void setContrast(float f)
    {
        mContrast = f;
        requestRender();
    }

    public void setGamma(float f)
    {
        mGamma = f;
        requestRender();
    }

    public void setHighlight(float f)
    {
        mHighlight = f;
        requestRender();
    }

    public void setOperateDelegate(aje aje1)
    {
        operDelegate = aje1;
    }

    public void setOriImage(Bitmap bitmap)
    {
        mOriginalImage = bitmap;
    }

    public void setSaturation(float f)
    {
        mSaturation = f;
        requestRender();
    }

    public void setShadow(float f)
    {
        mShadow = f;
        requestRender();
    }

    public void setSharpness(float f)
    {
        mSharpness = f;
        requestRender();
    }

    public void setWhiteblance(float f)
    {
        mWhiteblance = f;
        requestRender();
    }
}
