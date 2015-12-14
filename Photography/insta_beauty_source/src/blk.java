// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.util.Log;
import com.wantu.model.res.EResType;
import com.wantu.model.res.pip.TDFSceneInfo;
import com.wantu.piprender.ESceneMode;
import com.wantu.piprender.renderengine.RenderingEngine;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class blk
    implements android.opengl.GLSurfaceView.Renderer
{

    RenderingEngine a;
    int b;
    private TDFSceneInfo c;
    private float d;
    private int e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private Bitmap m;

    private RectF a(RectF rectf, float f1)
    {
        RectF rectf1 = new RectF(rectf);
        if (rectf.width() / rectf.height() > f1)
        {
            rectf1.inset(0.0F, (int)(-((rectf.width() / f1 - rectf.height()) / 2.0F)));
            return rectf1;
        } else
        {
            rectf1.inset((int)(-((rectf.height() * f1 - rectf.width()) / 2.0F)), 0.0F);
            return rectf1;
        }
    }

    private void a(RectF rectf, RectF rectf1, float af[], boolean flag)
    {
        if (af == null)
        {
            return;
        }
        rectf = new RectF(rectf);
        Matrix matrix = new Matrix();
        matrix.setTranslate(-rectf1.centerX(), -rectf1.centerY());
        matrix.mapRect(rectf);
        matrix = new Matrix();
        matrix.setScale(1.0F / (rectf1.width() / 2.0F), 1.0F / (rectf1.height() / 2.0F));
        matrix.mapRect(rectf);
        if (flag)
        {
            rectf1 = new Matrix();
            rectf1.setScale(1.0F, -1F);
            rectf1.mapRect(rectf);
        }
        af[0] = rectf.left;
        af[1] = rectf.bottom;
        af[2] = rectf.left;
        af[3] = rectf.top;
        af[4] = rectf.right;
        af[5] = rectf.bottom;
        af[6] = rectf.right;
        af[7] = rectf.top;
    }

    public void a()
    {
        a.a();
    }

    public void a(float f1, float f2)
    {
        float f4 = g + f1;
        float f3 = h + f2;
        if (f4 > j || f4 < i)
        {
            f1 = 0.0F;
        }
        if (f3 > l || f3 < k)
        {
            f2 = 0.0F;
        }
        Log.v("mm", (new StringBuilder()).append(f1).append(":").append(f2).toString());
        a.a(f1, f2);
        g = g + f1;
        h = h + f2;
        g = Math.min(Math.max(g, i), j);
        h = Math.min(Math.max(h, k), l);
    }

    public void a(Bitmap bitmap)
    {
        d = (float)bitmap.getWidth() / (float)bitmap.getHeight();
        if (b != -1)
        {
            GLES20.glDeleteTextures(1, IntBuffer.wrap(new int[] {
                b
            }));
            b = -1;
        }
        b = blj.a(bitmap);
    }

    public void a(TDFSceneInfo tdfsceneinfo)
    {
        blo blo1;
        RectF rectf = new RectF(0.0F, 0.0F, tdfsceneinfo.sceneSize.x, tdfsceneinfo.sceneSize.y);
        RectF rectf1 = new RectF(tdfsceneinfo.frameRect);
        blo1 = new blo();
        RectF rectf2 = a(rectf1, d);
        blo1.f.e = rectf1.width();
        blo1.f.f = rectf1.height();
        a(rectf2, rectf1, blo1.f.a, false);
        a(rectf1, rectf, blo1.f.c, true);
        blo1.e = a(d);
        i = (float)((double)blo1.f.a[0] + 1.0D);
        j = (float)((double)(-blo1.f.a[0]) - 1.0D);
        k = (float)((double)(-blo1.f.a[1]) + 1.0D);
        l = (float)((double)blo1.f.a[1] - 1.0D);
        if (tdfsceneinfo.getResType() != EResType.NETWORK) goto _L2; else goto _L1
_L1:
        blo1.i = EResType.NETWORK;
        if (tdfsceneinfo.alphaTexturePath != null)
        {
            blo1.g = tdfsceneinfo.alphaTexturePath;
        }
_L4:
        blo1.h = tdfsceneinfo.getMode().ordinal();
        e = tdfsceneinfo.getMode().ordinal();
        a.a(blo1);
        c = tdfsceneinfo;
        g = 0.0F;
        h = 0.0F;
        return;
_L2:
        if (tdfsceneinfo.alphaTexturePath != null)
        {
            blo1.g = tdfsceneinfo.alphaTexturePath;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public float[] a(float f1)
    {
        if (f1 > 1.0F)
        {
            return (new float[] {
                -f1, 1.0F, -f1, -1F, f1, 1.0F, f1, -1F
            });
        } else
        {
            return (new float[] {
                -1F, 1.0F / f1, -1F, -1F / f1, 1.0F, 1.0F / f1, 1.0F, -1F / f1
            });
        }
    }

    public void b(float f1)
    {
        f = f1;
    }

    public void onDrawFrame(GL10 gl10)
    {
        a.b(b);
    }

    public void onSurfaceChanged(GL10 gl10, int i1, int j1)
    {
        a.a(i1, j1);
        a(c);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        a.b();
        (new android.graphics.BitmapFactory.Options()).inScaled = false;
        gl10 = m;
        Log.v("lb", (new StringBuilder()).append("pip render source bimtap width = ").append(gl10.getWidth()).append(" height = ").append(gl10.getHeight()).toString());
        a(gl10);
    }
}
