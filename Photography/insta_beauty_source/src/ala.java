// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLES20;
import com.fotoable.fotoproedit.activity.mosaic.MosaicGLSurfaceView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

public class ala
{

    public int a;
    public int b;
    public float c;
    public PointF d;
    public boolean e;
    public Bitmap f;
    public Bitmap g;
    public int h;
    private final String i = "uniform mat4 uMVPMatrix;attribute vec4 vPosition;attribute vec2 inTexcoord;attribute vec2 inTexcoordBase;varying vec2 varTexcoord;varying vec2 varTexcoordBase;void main() {  gl_Position = uMVPMatrix * vPosition;  varTexcoord = inTexcoord;  varTexcoordBase = inTexcoordBase;}";
    private final String j = "precision mediump float;uniform sampler2D texture;uniform sampler2D textureBase;varying vec2 varTexcoord;varying vec2 varTexcoordBase;void main() {  vec4 te = texture2D(texture, varTexcoord.st, 0.0);  vec4 teb = texture2D(textureBase, varTexcoordBase.st, 0.0);  vec4 res = teb * te;  gl_FragColor = res;}";
    private FloatBuffer k;
    private FloatBuffer l;
    private FloatBuffer m;
    private int n;
    private int o;
    private int p;
    private ArrayList q;
    private final int r = 8;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private String x;
    private String y;
    private int z;

    public ala()
    {
        d = new PointF();
        e = false;
        x = null;
        y = null;
        z = 0;
        v = MosaicGLSurfaceView.loadShader(35633, "uniform mat4 uMVPMatrix;attribute vec4 vPosition;attribute vec2 inTexcoord;attribute vec2 inTexcoordBase;varying vec2 varTexcoord;varying vec2 varTexcoordBase;void main() {  gl_Position = uMVPMatrix * vPosition;  varTexcoord = inTexcoord;  varTexcoordBase = inTexcoordBase;}");
        w = MosaicGLSurfaceView.loadShader(35632, "precision mediump float;uniform sampler2D texture;uniform sampler2D textureBase;varying vec2 varTexcoord;varying vec2 varTexcoordBase;void main() {  vec4 te = texture2D(texture, varTexcoord.st, 0.0);  vec4 teb = texture2D(textureBase, varTexcoordBase.st, 0.0);  vec4 res = teb * te;  gl_FragColor = res;}");
        s = GLES20.glCreateProgram();
        GLES20.glAttachShader(s, v);
        GLES20.glAttachShader(s, w);
        GLES20.glLinkProgram(s);
    }

    private int a(ald ald1, float af[], float af1[], float af2[])
    {
        int l1 = ald1.b.length / 2;
        PointF pointf = a(ald1.e);
        int i1 = 0;
        for (int j1 = 0; j1 < l1; j1++)
        {
            int k1 = j1 * 2;
            PointF pointf4 = new PointF(ald1.b[k1], ald1.b[k1 + 1]);
            PointF pointf1 = new PointF(pointf4.x - pointf.x, pointf4.y - pointf.y);
            PointF pointf2 = new PointF(pointf4.x + pointf.x, pointf4.y - pointf.y);
            PointF pointf3 = new PointF(pointf4.x - pointf.x, pointf4.y + pointf.y);
            pointf4 = new PointF(pointf4.x + pointf.x, pointf4.y + pointf.y);
            k1 = i1;
            if (i1 != 0)
            {
                af[i1] = pointf1.x;
                af[i1 + 1] = pointf1.y;
                af1[i1] = 0.0F;
                af1[i1 + 1] = 0.0F;
                af2[i1] = pointf1.x / (float)a;
                af2[i1 + 1] = 1.0F - pointf1.y / (float)b;
                k1 = i1 + 2;
            }
            af[k1] = pointf1.x;
            af[k1 + 1] = pointf1.y;
            af1[k1] = 0.0F;
            af1[k1 + 1] = 0.0F;
            af2[k1] = pointf1.x / (float)a;
            af2[k1 + 1] = 1.0F - pointf1.y / (float)b;
            i1 = k1 + 2;
            af[i1] = pointf2.x;
            af[i1 + 1] = pointf2.y;
            af1[i1] = 1.0F;
            af1[i1 + 1] = 0.0F;
            af2[i1] = pointf2.x / (float)a;
            af2[i1 + 1] = 1.0F - pointf2.y / (float)b;
            i1 += 2;
            af[i1] = pointf3.x;
            af[i1 + 1] = pointf3.y;
            af1[i1] = 0.0F;
            af1[i1 + 1] = 1.0F;
            af2[i1] = pointf3.x / (float)a;
            af2[i1 + 1] = 1.0F - pointf3.y / (float)b;
            i1 += 2;
            af[i1] = pointf4.x;
            af[i1 + 1] = pointf4.y;
            af1[i1] = 1.0F;
            af1[i1 + 1] = 1.0F;
            af2[i1] = pointf4.x / (float)a;
            af2[i1 + 1] = 1.0F - pointf4.y / (float)b;
            k1 = i1 + 2;
            i1 = k1;
            if (j1 != l1 - 1)
            {
                af[k1] = pointf4.x;
                af[k1 + 1] = pointf4.y;
                af1[k1] = 1.0F;
                af1[k1 + 1] = 1.0F;
                af2[k1] = pointf4.x / (float)a;
                af2[k1 + 1] = 1.0F - pointf4.y / (float)b;
                i1 = k1 + 2;
            }
        }

        return i1 / 2;
    }

    private Bitmap a(Bitmap bitmap)
    {
        int i2 = bitmap.getWidth();
        int j2 = bitmap.getHeight();
        Bitmap bitmap1 = Bitmap.createBitmap(i2, j2, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        int l2 = (int)Math.ceil((float)i2 / (float)15);
        int i3 = (int)Math.ceil((float)j2 / (float)15);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        for (int i1 = 0; i1 < l2; i1++)
        {
            for (int j1 = 0; j1 < i3; j1++)
            {
                int j3 = 15 * i1;
                int k3 = 15 * j1;
                int k1 = j3 + 15;
                if (k1 > i2)
                {
                    k1 = i2;
                }
                int k2 = k3 + 15;
                int l1 = k2;
                if (k2 > j2)
                {
                    l1 = j2;
                }
                k2 = bitmap.getPixel(j3, k3);
                Rect rect = new Rect(j3, k3, k1, l1);
                paint.setColor(k2);
                canvas.drawRect(rect, paint);
            }

        }

        canvas.save();
        return bitmap1;
    }

    private PointF a(int i1)
    {
        PointF pointf = new PointF();
        if (c > 1.0F)
        {
            pointf.x = i1;
            pointf.y = (float)i1 * c;
        } else
        {
            pointf.x = (float)i1 / c;
            pointf.y = i1;
        }
        pointf.x = pointf.x / 2.0F;
        pointf.y = pointf.y / 2.0F;
        return pointf;
    }

    private void a(String s1)
    {
        if (x != null && x == s1)
        {
            return;
        } else
        {
            x = s1;
            MosaicGLSurfaceView.deleteGlTexture(t);
            t = MosaicGLSurfaceView.loadTexture(s1);
            return;
        }
    }

    private int b(ald ald1, float af[], float af1[], float af2[])
    {
        int l1 = ald1.b.length / 2;
        float f3 = ald1.e / 2;
        if (e)
        {
            d.x = ald1.b[0];
            d.y = ald1.b[1];
        }
        int i1 = 0;
        int j1 = 0;
        while (j1 < l1) 
        {
            int k1 = j1 * 2;
            PointF pointf = new PointF(ald1.b[k1], ald1.b[k1 + 1]);
            float f1 = pointf.x - d.x;
            float f2 = pointf.y - d.y;
            double d1 = Math.sqrt(f1 * f1 + f2 * f2);
            d1 = (double)f2 / d1;
            PointF pointf1;
            PointF pointf2;
            PointF pointf3;
            PointF pointf4;
            Matrix matrix;
            float af3[];
            if ((double)f1 > 0.0D)
            {
                d1 = -1D * Math.acos(d1);
            } else
            if ((double)f1 < 0.0D)
            {
                d1 = Math.acos(d1);
            } else
            {
                d1 = 0.0D;
            }
            d.x = pointf.x;
            d.y = pointf.y;
            pointf.x = ald1.c[k1];
            pointf.y = ald1.c[k1 + 1];
            pointf1 = new PointF(pointf.x - f3, pointf.y - f3);
            pointf2 = new PointF(pointf.x + f3, pointf.y - f3);
            pointf3 = new PointF(pointf.x - f3, pointf.y + f3);
            pointf4 = new PointF(pointf.x + f3, pointf.y + f3);
            d1 = (d1 * 180D) / 3.1415926535897931D;
            matrix = new Matrix();
            matrix.setRotate((float)d1, pointf.x, pointf.y);
            if (c > 1.0F)
            {
                f2 = 1.0F;
                f1 = c;
            } else
            {
                f2 = 1.0F / c;
                f1 = 1.0F;
            }
            matrix.postScale(f2, f1, pointf.x, pointf.y);
            af3 = new float[2];
            af3[0] = pointf1.x;
            af3[1] = pointf1.y;
            matrix.mapPoints(af3);
            pointf1.x = af3[0];
            pointf1.y = af3[1];
            af3[0] = pointf2.x;
            af3[1] = pointf2.y;
            matrix.mapPoints(af3);
            pointf2.x = af3[0];
            pointf2.y = af3[1];
            af3[0] = pointf3.x;
            af3[1] = pointf3.y;
            matrix.mapPoints(af3);
            pointf3.x = af3[0];
            pointf3.y = af3[1];
            af3[0] = pointf4.x;
            af3[1] = pointf4.y;
            matrix.mapPoints(af3);
            pointf4.x = af3[0];
            pointf4.y = af3[1];
            f1 = pointf.x / (float)a;
            f2 = 1.0F - pointf.y / (float)b;
            if (i1 != 0)
            {
                af[i1] = pointf1.x;
                af[i1 + 1] = pointf1.y;
                af1[i1] = 0.0F;
                af1[i1 + 1] = 0.0F;
                af2[i1] = f1;
                af2[i1 + 1] = f2;
                i1 += 2;
            }
            af[i1] = pointf1.x;
            af[i1 + 1] = pointf1.y;
            af1[i1] = 0.0F;
            af1[i1 + 1] = 0.0F;
            af2[i1] = f1;
            af2[i1 + 1] = f2;
            i1 += 2;
            af[i1] = pointf2.x;
            af[i1 + 1] = pointf2.y;
            af1[i1] = 1.0F;
            af1[i1 + 1] = 0.0F;
            af2[i1] = f1;
            af2[i1 + 1] = f2;
            i1 += 2;
            af[i1] = pointf3.x;
            af[i1 + 1] = pointf3.y;
            af1[i1] = 0.0F;
            af1[i1 + 1] = 1.0F;
            af2[i1] = f1;
            af2[i1 + 1] = f2;
            i1 += 2;
            af[i1] = pointf4.x;
            af[i1 + 1] = pointf4.y;
            af1[i1] = 1.0F;
            af1[i1 + 1] = 1.0F;
            af2[i1] = f1;
            af2[i1 + 1] = f2;
            k1 = i1 + 2;
            i1 = k1;
            if (j1 != l1 - 1)
            {
                af[k1] = pointf4.x;
                af[k1 + 1] = pointf4.y;
                af1[k1] = 1.0F;
                af1[k1 + 1] = 1.0F;
                af2[k1] = f1;
                af2[k1 + 1] = f2;
                i1 = k1 + 2;
            }
            j1++;
        }
        return i1 / 2;
    }

    private void b(int i1)
    {
        if (z != 0 && z == i1)
        {
            return;
        } else
        {
            Bitmap bitmap = Bitmap.createBitmap(120, 120, android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setColor(i1);
            paint.setAntiAlias(true);
            canvas.drawRect(new Rect(0, 0, 120, 120), paint);
            MosaicGLSurfaceView.deleteGlTexture(u);
            u = MosaicGLSurfaceView.bitmapToTexture(bitmap);
            return;
        }
    }

    private void b(String s1)
    {
        if (y != null && y == s1)
        {
            return;
        }
        y = s1;
        MosaicGLSurfaceView.deleteGlTexture(u);
        if (s1 == "mosaic")
        {
            u = MosaicGLSurfaceView.bitmapToTexture(a(g));
            return;
        }
        if (s1 == "maoboli")
        {
            u = MosaicGLSurfaceView.bitmapToTexture(f);
            return;
        } else
        {
            u = MosaicGLSurfaceView.bitmapToTexture(MosaicGLSurfaceView.smallBitmapToBigBitmap(MosaicGLSurfaceView.getBitmapFromAssetPath(s1)));
            return;
        }
    }

    private int c(ald ald1, float af[], float af1[], float af2[])
    {
        int l1 = ald1.b.length / 2;
        float f3 = ald1.e / 2;
        if (e)
        {
            d.x = ald1.b[0];
            d.y = ald1.b[1];
        }
        int i1 = 0;
        int j1 = 0;
        while (j1 < l1) 
        {
            int k1 = j1 * 2;
            PointF pointf4 = new PointF(ald1.b[k1], ald1.b[k1 + 1]);
            float f1 = pointf4.x - d.x;
            float f2 = pointf4.y - d.y;
            double d1 = Math.sqrt(f1 * f1 + f2 * f2);
            d1 = (double)f2 / d1;
            PointF pointf;
            PointF pointf1;
            PointF pointf2;
            PointF pointf3;
            Matrix matrix;
            float af3[];
            if ((double)f1 > 0.0D)
            {
                d1 = -1D * Math.acos(d1);
            } else
            if ((double)f1 < 0.0D)
            {
                d1 = Math.acos(d1);
            } else
            {
                d1 = 0.0D;
            }
            d.x = pointf4.x;
            d.y = pointf4.y;
            pointf = new PointF(pointf4.x - f3, pointf4.y - f3);
            pointf1 = new PointF(pointf4.x + f3, pointf4.y - f3);
            pointf2 = new PointF(pointf4.x - f3, pointf4.y + f3);
            pointf3 = new PointF(pointf4.x + f3, pointf4.y + f3);
            d1 = (d1 * 180D) / 3.1415926535897931D;
            matrix = new Matrix();
            matrix.setRotate((float)d1, pointf4.x, pointf4.y);
            if (c > 1.0F)
            {
                f2 = 1.0F;
                f1 = c;
            } else
            {
                f2 = 1.0F / c;
                f1 = 1.0F;
            }
            matrix.postScale(f2, f1, pointf4.x, pointf4.y);
            af3 = new float[2];
            af3[0] = pointf.x;
            af3[1] = pointf.y;
            matrix.mapPoints(af3);
            pointf.x = af3[0];
            pointf.y = af3[1];
            af3[0] = pointf1.x;
            af3[1] = pointf1.y;
            matrix.mapPoints(af3);
            pointf1.x = af3[0];
            pointf1.y = af3[1];
            af3[0] = pointf2.x;
            af3[1] = pointf2.y;
            matrix.mapPoints(af3);
            pointf2.x = af3[0];
            pointf2.y = af3[1];
            af3[0] = pointf3.x;
            af3[1] = pointf3.y;
            matrix.mapPoints(af3);
            pointf3.x = af3[0];
            pointf3.y = af3[1];
            if (i1 != 0)
            {
                af[i1] = pointf.x;
                af[i1 + 1] = pointf.y;
                af1[i1] = 0.0F;
                af1[i1 + 1] = 0.0F;
                af2[i1] = 0.0F;
                af2[i1 + 1] = 0.0F;
                i1 += 2;
            }
            af[i1] = pointf.x;
            af[i1 + 1] = pointf.y;
            af1[i1] = 0.0F;
            af1[i1 + 1] = 0.0F;
            af2[i1] = 0.0F;
            af2[i1 + 1] = 0.0F;
            i1 += 2;
            af[i1] = pointf1.x;
            af[i1 + 1] = pointf1.y;
            af1[i1] = 1.0F;
            af1[i1 + 1] = 0.0F;
            af2[i1] = 1.0F;
            af2[i1 + 1] = 0.0F;
            i1 += 2;
            af[i1] = pointf2.x;
            af[i1 + 1] = pointf2.y;
            af1[i1] = 0.0F;
            af1[i1 + 1] = 1.0F;
            af2[i1] = 0.0F;
            af2[i1 + 1] = 1.0F;
            i1 += 2;
            af[i1] = pointf3.x;
            af[i1 + 1] = pointf3.y;
            af1[i1] = 1.0F;
            af1[i1 + 1] = 1.0F;
            af2[i1] = 1.0F;
            af2[i1 + 1] = 1.0F;
            k1 = i1 + 2;
            i1 = k1;
            if (j1 != l1 - 1)
            {
                af[k1] = pointf3.x;
                af[k1 + 1] = pointf3.y;
                af1[k1] = 1.0F;
                af1[k1 + 1] = 1.0F;
                af2[k1] = 1.0F;
                af2[k1 + 1] = 1.0F;
                i1 = k1 + 2;
            }
            j1++;
        }
        return i1 / 2;
    }

    public void a()
    {
        MosaicGLSurfaceView.deleteGlTexture(t);
        t = 0;
        MosaicGLSurfaceView.deleteGlTexture(u);
        u = 0;
        GLES20.glDeleteShader(v);
        GLES20.glDeleteShader(w);
        GLES20.glDeleteProgram(s);
    }

    public void a(ArrayList arraylist)
    {
        q = arraylist;
    }

    public void a(float af[])
    {
        GLES20.glUseProgram(s);
        n = GLES20.glGetUniformLocation(s, "uMVPMatrix");
        MosaicGLSurfaceView.checkGlError("glGetUniformLocation");
        GLES20.glUniformMatrix4fv(n, 1, false, af, 0);
        MosaicGLSurfaceView.checkGlError("glUniformMatrix4fv");
    }

    public void b()
    {
        if (q != null && q.size() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j1;
        GLES20.glUseProgram(s);
        o = GLES20.glGetUniformLocation(s, "texture");
        p = GLES20.glGetUniformLocation(s, "textureBase");
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(1, 771);
        j1 = 0;
_L6:
        if (j1 >= q.size()) goto _L1; else goto _L3
_L3:
        Object obj;
        int i1;
        obj = (ald)q.get(j1);
        i1 = ((ald) (obj)).b.length / 2;
        if (i1 >= 1) goto _L5; else goto _L4
_L4:
        j1++;
          goto _L6
_L5:
        float af[];
        float af1[];
        float af2[];
        i1 = ((i1 - 1) * 2 + i1 * 4) * 2;
        af2 = new float[i1];
        af1 = new float[i1];
        af = new float[i1];
        a(((ald) (obj)).f);
        ((ald) (obj)).d;
        JVM INSTR tableswitch 0 4: default 200
    //                   0 456
    //                   1 527
    //                   2 589
    //                   3 651
    //                   4 722;
           goto _L7 _L8 _L9 _L10 _L11 _L12
_L12:
        break MISSING_BLOCK_LABEL_722;
_L7:
        i1 = 0;
_L13:
        obj = ByteBuffer.allocateDirect(af2.length * 4);
        ((ByteBuffer) (obj)).order(ByteOrder.nativeOrder());
        k = ((ByteBuffer) (obj)).asFloatBuffer();
        k.put(af2);
        k.position(0);
        af2 = ByteBuffer.allocateDirect(af1.length * 4);
        af2.order(ByteOrder.nativeOrder());
        l = af2.asFloatBuffer();
        l.put(af1);
        l.position(0);
        af1 = ByteBuffer.allocateDirect(af.length * 4);
        af1.order(ByteOrder.nativeOrder());
        m = af1.asFloatBuffer();
        m.put(af);
        m.position(0);
        int k1 = GLES20.glGetAttribLocation(s, "vPosition");
        GLES20.glEnableVertexAttribArray(k1);
        GLES20.glVertexAttribPointer(k1, 2, 5126, false, 8, k);
        int l1 = GLES20.glGetAttribLocation(s, "inTexcoord");
        GLES20.glEnableVertexAttribArray(l1);
        GLES20.glVertexAttribPointer(l1, 2, 5126, false, 8, l);
        int i2 = GLES20.glGetAttribLocation(s, "inTexcoordBase");
        GLES20.glEnableVertexAttribArray(i2);
        GLES20.glVertexAttribPointer(i2, 2, 5126, false, 8, m);
        GLES20.glDrawArrays(5, 0, i1);
        GLES20.glDisableVertexAttribArray(k1);
        GLES20.glDisableVertexAttribArray(l1);
        GLES20.glDisableVertexAttribArray(i2);
          goto _L4
_L8:
        b(((ald) (obj)).g);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, t);
        GLES20.glUniform1i(o, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, u);
        GLES20.glUniform1i(p, 1);
        i1 = a(((ald) (obj)), af2, af1, af);
          goto _L13
_L9:
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, t);
        GLES20.glUniform1i(o, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, h);
        GLES20.glUniform1i(p, 1);
        i1 = b(((ald) (obj)), af2, af1, af);
          goto _L13
_L10:
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, t);
        GLES20.glUniform1i(o, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, h);
        GLES20.glUniform1i(p, 1);
        i1 = a(((ald) (obj)), af2, af1, af);
          goto _L13
_L11:
        b(((ald) (obj)).a);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, t);
        GLES20.glUniform1i(o, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, u);
        GLES20.glUniform1i(p, 1);
        i1 = c(((ald) (obj)), af2, af1, af);
          goto _L13
        obj.a = -1;
        b(((ald) (obj)).a);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, t);
        GLES20.glUniform1i(o, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, u);
        GLES20.glUniform1i(p, 1);
        i1 = a(((ald) (obj)), af2, af1, af);
          goto _L13
    }
}
