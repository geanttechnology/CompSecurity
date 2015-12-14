// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.imgop;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.Type;
import android.util.Log;
import com.socialin.android.util.c;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import myobfuscated.bb.ao;
import myobfuscated.bb.ap;
import myobfuscated.bb.bc;
import myobfuscated.bb.bd;
import myobfuscated.bb.be;
import myobfuscated.bb.bf;
import myobfuscated.bb.bj;
import myobfuscated.bb.bq;
import myobfuscated.bb.br;
import myobfuscated.bb.bs;
import myobfuscated.bb.bt;
import myobfuscated.bb.bu;
import myobfuscated.bb.bx;
import myobfuscated.bb.ca;
import myobfuscated.bb.cb;
import myobfuscated.bb.cc;
import myobfuscated.bb.cd;
import myobfuscated.bb.j;
import myobfuscated.bb.k;
import myobfuscated.bb.l;
import myobfuscated.bb.m;
import myobfuscated.bb.n;
import myobfuscated.bb.o;
import myobfuscated.bb.p;
import myobfuscated.bb.q;
import myobfuscated.bb.r;
import myobfuscated.bb.s;
import myobfuscated.bb.t;

// Referenced classes of package com.socialin.android.photo.imgop:
//            ImageOpCommon

public class RenderScriptOp
{

    public static boolean a = false;

    public RenderScriptOp()
    {
    }

    public static native void TinyPlanet(Buffer buffer, Buffer buffer1, int i1, int j1, float f1, float f2);

    private static void a(Bitmap bitmap, float f1, int i1)
    {
        Canvas canvas = new Canvas(bitmap);
        int j1 = bitmap.getWidth();
        int k1 = bitmap.getHeight();
        bitmap = new Paint(1);
        bitmap.setColor(i1);
        bitmap.setStyle(android.graphics.Paint.Style.FILL);
        Path path = new Path();
        path.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        float f2 = 2.0F * f1;
        path.moveTo(0.0F, 0.0F);
        path.lineTo(f1, 0.0F);
        path.arcTo(new RectF(0.0F, 0.0F, f2, f2), -90F, -90F);
        path.close();
        path.moveTo(j1, 0.0F);
        path.lineTo((float)j1 - f1, 0.0F);
        path.arcTo(new RectF((float)j1 - f2, 0.0F, j1, f2), -90F, 90F);
        path.close();
        path.moveTo(0.0F, k1);
        path.lineTo(f1, k1);
        path.arcTo(new RectF(0.0F, (float)k1 - f2, f2, k1), 90F, 90F);
        path.close();
        path.moveTo(j1, k1);
        path.lineTo((float)j1 - f1, k1);
        path.arcTo(new RectF((float)j1 - f2, (float)k1 - f2, j1, k1), 90F, -90F);
        path.close();
        canvas.drawPath(path, bitmap);
    }

    public static void a(Bitmap bitmap, int i1)
    {
        int j1 = bitmap.getWidth();
        int k1 = bitmap.getHeight();
        ByteBuffer bytebuffer = allocNativeBuffer(j1 * k1 * 1);
        bytebuffer.rewind();
        bitmap.copyPixelsToBuffer(bytebuffer);
        medianblur4buf(bytebuffer, j1, k1, 1, i1 | 1);
        bytebuffer.rewind();
        bitmap.copyPixelsFromBuffer(bytebuffer);
        freeNativeBuffer(bytebuffer);
    }

    private static void a(RenderScript renderscript, Allocation allocation, Allocation allocation1, int i1, float f1)
    {
        Allocation allocation2 = Allocation.createTyped(renderscript, allocation1.getType());
        bd bd1 = new bd(renderscript);
        a(renderscript, bd1, allocation, allocation2, i1, 3);
        bd1.destroy();
        renderscript = new bx(renderscript);
        renderscript.a(allocation, allocation2, f1);
        renderscript.a(allocation1);
        renderscript.destroy();
        allocation2.destroy();
    }

    private static void a(RenderScript renderscript, Allocation allocation, Allocation allocation1, int i1, int j1)
    {
        Allocation allocation2 = Allocation.createTyped(renderscript, allocation1.getType());
        a(renderscript, new bd(renderscript), allocation, allocation2, i1 * 2 + 1, j1);
        renderscript = new br(renderscript);
        renderscript.a(allocation, allocation2);
        renderscript.a(allocation1);
        allocation2.destroy();
    }

    public static void a(RenderScript renderscript, bd bd1, Allocation allocation, Allocation allocation1, int i1, int j1)
    {
        if (j1 <= 0)
        {
            return;
        }
        int k1 = allocation.getType().getX();
        int l1 = allocation.getType().getY();
        Allocation allocation3 = Allocation.createTyped(renderscript, (new android.renderscript.Type.Builder(renderscript, Element.I32_4(renderscript))).setX(k1).setY(l1).create());
        if (j1 == 1)
        {
            bd1.a(allocation, allocation3, i1);
            bd1.a(allocation1);
            allocation3.destroy();
            return;
        }
        Allocation allocation2 = Allocation.createTyped(renderscript, allocation.getType());
        if (j1 % 2 == 0)
        {
            bd1.a(allocation, allocation3, i1);
            bd1.a(allocation2);
            renderscript = allocation2;
        } else
        {
            bd1.a(allocation, allocation3, i1);
            bd1.a(allocation1);
            renderscript = allocation1;
            allocation1 = allocation2;
        }
        do
        {
            j1--;
            if (j1 > 0)
            {
                bd1.a(renderscript, allocation3, i1);
                bd1.a(allocation1);
                allocation = renderscript;
                renderscript = allocation1;
                allocation1 = allocation;
            } else
            {
                allocation3.destroy();
                allocation2.destroy();
                return;
            }
        } while (true);
    }

    public static void a(RenderScript renderscript, be be1, Allocation allocation, Allocation allocation1, int i1)
    {
        int j1 = allocation.getType().getX();
        int k1 = allocation.getType().getY();
        renderscript = Allocation.createTyped(renderscript, (new android.renderscript.Type.Builder(renderscript, Element.I32(renderscript))).setX(j1).setY(k1).create());
        be1.a(allocation, renderscript, i1);
        be1.a(allocation1);
        renderscript.destroy();
    }

    public static boolean a(Bitmap bitmap, Allocation allocation, float f1, int i1)
    {
        int j1 = allocation.getType().getX();
        int k1 = allocation.getType().getY();
        boolean flag;
        if (bitmap == null || bitmap.isRecycled())
        {
            bitmap = com.socialin.android.util.c.a(j1, k1, android.graphics.Bitmap.Config.ARGB_8888);
            flag = true;
        } else
        {
            flag = false;
        }
        if (bitmap == null)
        {
            return false;
        }
        allocation.copyTo(bitmap);
        a(bitmap, f1, i1);
        allocation.copyFrom(bitmap);
        if (flag)
        {
            com.socialin.android.util.c.a(bitmap);
        }
        return true;
    }

    public static boolean a(Bitmap bitmap, ByteBuffer bytebuffer, int i1, int j1, float f1, int k1)
    {
        if (bitmap == null || bitmap.isRecycled())
        {
            bitmap = com.socialin.android.util.c.a(i1, j1, android.graphics.Bitmap.Config.ARGB_8888);
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (bitmap == null)
        {
            return false;
        }
        bytebuffer.position(0);
        bitmap.copyPixelsFromBuffer(bytebuffer);
        a(bitmap, f1, k1);
        bytebuffer.position(0);
        bitmap.copyPixelsToBuffer(bytebuffer);
        if (i1 != 0)
        {
            com.socialin.android.util.c.a(bitmap);
        }
        return true;
    }

    public static boolean a(RenderScript renderscript, Allocation allocation, Allocation allocation1, int i1)
    {
        if (renderscript == null)
        {
            return false;
        }
        Log.e("ex1", "applySeafoamRenderscript");
        int j1;
        int k1;
        try
        {
            renderscript = new ao(renderscript);
            j1 = allocation.getType().getX();
            k1 = allocation1.getType().getY();
        }
        // Misplaced declaration of an exception variable
        catch (RenderScript renderscript)
        {
            return false;
        }
        if (i1 != 100)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        allocation1.copy2DRangeFrom(0, 0, j1, k1, allocation, 0, 0);
_L1:
        renderscript.destroy();
        return true;
        renderscript.a(i1);
        renderscript.a(allocation, allocation1);
          goto _L1
    }

    public static native ByteBuffer allocNativeBuffer(long l1);

    public static boolean b(RenderScript renderscript, Allocation allocation, Allocation allocation1, int i1)
    {
        if (renderscript == null)
        {
            return false;
        }
        Log.e("ex1", "applyDodgerRenderscript");
        int j1;
        int k1;
        try
        {
            renderscript = new ap(renderscript);
            j1 = allocation.getType().getX();
            k1 = allocation1.getType().getY();
        }
        // Misplaced declaration of an exception variable
        catch (RenderScript renderscript)
        {
            return false;
        }
        if (i1 != 100)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        allocation1.copy2DRangeFrom(0, 0, j1, k1, allocation, 0, 0);
_L1:
        renderscript.destroy();
        return true;
        renderscript.a(allocation.getType().getX(), allocation.getType().getY(), i1);
        renderscript.a(allocation, allocation1);
          goto _L1
    }

    public static boolean c(RenderScript renderscript, Allocation allocation, Allocation allocation1, int i1)
    {
        if (renderscript == null)
        {
            return false;
        }
        Log.e("ex1", "applyWarmAmberRenderscript");
        Object obj;
        int j1;
        int k1;
        try
        {
            j1 = allocation.getType().getX();
            k1 = allocation.getType().getY();
        }
        // Misplaced declaration of an exception variable
        catch (RenderScript renderscript)
        {
            return false;
        }
        if (i1 != 100)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        allocation1.copy2DRangeFrom(0, 0, j1, k1, allocation, 0, 0);
        return true;
        obj = new bs(renderscript);
        ((bs) (obj)).a(0.6902736F, 0.3108398F, 0.1817802F, 0.1275287F, 0.81725F, 0.002383852F, 0.1613428F, 0.1327136F, 0.4914772F);
        ((bs) (obj)).a(allocation, allocation1);
        ((bs) (obj)).destroy();
        obj = new cb(renderscript);
        ((cb) (obj)).a(allocation1);
        ((cb) (obj)).destroy();
        a(renderscript, allocation1, allocation1, 3, 0.25F);
        obj = new cc(renderscript);
        ((cc) (obj)).a(allocation1);
        ((cc) (obj)).destroy();
        obj = new bs(renderscript);
        ((bs) (obj)).a(0.8978955F, 0.05072874F, 0.1292816F, 0.04905615F, 0.9839892F, -0.03334523F, 0.01564136F, -0.05293298F, 0.8270896F);
        ((bs) (obj)).a(allocation1, allocation1);
        ((bs) (obj)).destroy();
        renderscript = new cd(renderscript);
        renderscript.a(i1);
        renderscript.a(allocation, allocation1);
        renderscript.destroy();
        return true;
    }

    public static native void calculateHistogram(Buffer buffer, int i1, int j1, int ai[], int ai1[], int ai2[]);

    public static boolean d(RenderScript renderscript, Allocation allocation, Allocation allocation1, int i1)
    {
        if (renderscript == null)
        {
            return false;
        }
        Log.e("ex1", "applyVintageIvoryRenderscript");
        int j1;
        int k1;
        try
        {
            renderscript = new ca(renderscript);
            j1 = allocation.getType().getX();
            k1 = allocation1.getType().getY();
        }
        // Misplaced declaration of an exception variable
        catch (RenderScript renderscript)
        {
            return false;
        }
        if (i1 != 100)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        allocation1.copy2DRangeFrom(0, 0, j1, k1, allocation, 0, 0);
_L1:
        renderscript.destroy();
        return true;
        renderscript.a(i1);
        renderscript.a(allocation, allocation1);
          goto _L1
    }

    public static native void drawOrientations4array(byte abyte0[], float af[], float af1[], int i1, int j1, float f1, float f2, float f3);

    public static boolean e(RenderScript renderscript, Allocation allocation, Allocation allocation1, int i1)
    {
        if (renderscript == null)
        {
            return false;
        }
        Log.e("ex1", "applyCrispRenderscript");
        bc bc1;
        q q1;
        r r1;
        bj bj1;
        bq bq1;
        bf bf1;
        Allocation allocation2;
        int j1;
        int k1;
        try
        {
            j1 = allocation.getType().getX();
            k1 = allocation.getType().getY();
        }
        // Misplaced declaration of an exception variable
        catch (RenderScript renderscript)
        {
            return false;
        }
        if (i1 != 100)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        allocation1.copy2DRangeFrom(0, 0, j1, k1, allocation, 0, 0);
        return true;
        bc1 = new bc(renderscript);
        a(renderscript, allocation, allocation1, 5, 2);
        bc1.a(allocation1, allocation, 8);
        bc1.a(allocation1);
        q1 = new q(renderscript);
        q1.a(allocation1);
        allocation2 = Allocation.createTyped(renderscript, allocation1.getType());
        a(renderscript, allocation1, allocation2, 16, 3);
        r1 = new r(renderscript);
        r1.a(allocation2, allocation1);
        bj1 = new bj(renderscript);
        bj1.a(1.12F);
        bj1.a(allocation1, allocation1);
        bq1 = new bq(renderscript);
        bq1.a();
        bq1.a(allocation1, allocation2);
        bf1 = new bf(renderscript);
        bf1.a(allocation2, allocation1, 51);
        bf1.a(allocation1);
        allocation2.destroy();
        renderscript = new s(renderscript);
        renderscript.a(i1);
        renderscript.a(allocation, allocation1);
        bc1.destroy();
        q1.destroy();
        r1.destroy();
        renderscript.destroy();
        bj1.destroy();
        bq1.destroy();
        bf1.destroy();
        return true;
    }

    public static native void edge(Buffer buffer, Buffer buffer1, int i1, int j1, float f1);

    public static native void estimateWhiteBox(Buffer buffer, Buffer buffer1, int i1, int j1, int k1, int l1);

    public static boolean f(RenderScript renderscript, Allocation allocation, Allocation allocation1, int i1)
    {
        if (renderscript == null)
        {
            return false;
        }
        int j1;
        int k1;
        try
        {
            j1 = allocation.getType().getX();
            k1 = allocation.getType().getY();
        }
        // Misplaced declaration of an exception variable
        catch (RenderScript renderscript)
        {
            return false;
        }
        if (i1 != 100)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        allocation1.copy2DRangeFrom(0, 0, j1, k1, allocation, 0, 0);
        return true;
        renderscript = new t(renderscript);
        renderscript.a(i1);
        renderscript.a(allocation, allocation1);
        renderscript.destroy();
        return true;
    }

    public static native ByteBuffer freeNativeBuffer(ByteBuffer bytebuffer);

    public static native void fx(Buffer buffer, Buffer buffer1, int i1, int j1, Buffer buffer2, int k1, int l1, int i2, 
            int j2);

    public static boolean g(RenderScript renderscript, Allocation allocation, Allocation allocation1, int i1)
    {
        if (renderscript == null)
        {
            return false;
        }
        Object obj;
        Object obj1;
        int j1;
        int k1;
        try
        {
            j1 = allocation.getType().getX();
            k1 = allocation.getType().getY();
        }
        // Misplaced declaration of an exception variable
        catch (RenderScript renderscript)
        {
            return false;
        }
        if (i1 != 100)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        allocation1.copy2DRangeFrom(0, 0, j1, k1, allocation, 0, 0);
        return true;
        a(renderscript, allocation, allocation1, 77, 0.09F);
        obj = Allocation.createTyped(renderscript, allocation1.getType());
        obj1 = new bd(renderscript);
        a(renderscript, ((bd) (obj1)), allocation1, ((Allocation) (obj)), 21, 3);
        ((bd) (obj1)).destroy();
        obj1 = new bu(renderscript);
        ((bu) (obj1)).a(allocation1, ((Allocation) (obj)), 2.69F, 8.11F, 1.98F, 4.94F);
        ((bu) (obj1)).a(allocation1);
        ((bu) (obj1)).destroy();
        if (obj == allocation1)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        ((Allocation) (obj)).destroy();
        obj = new bj(renderscript);
        ((bj) (obj)).a(1.1F);
        ((bj) (obj)).a(allocation1, allocation1);
        ((bj) (obj)).destroy();
        renderscript = new j(renderscript);
        renderscript.a(i1);
        renderscript.a(allocation, allocation1);
        renderscript.destroy();
        return true;
    }

    public static boolean h(RenderScript renderscript, Allocation allocation, Allocation allocation1, int i1)
    {
        if (renderscript == null)
        {
            return false;
        }
        int j1;
        int k1;
        try
        {
            j1 = allocation.getType().getX();
            k1 = allocation.getType().getY();
        }
        // Misplaced declaration of an exception variable
        catch (RenderScript renderscript)
        {
            return false;
        }
        if (i1 != 100)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        allocation1.copy2DRangeFrom(0, 0, j1, k1, allocation, 0, 0);
        return true;
        renderscript = new k(renderscript);
        renderscript.a(i1);
        renderscript.a(allocation, allocation1);
        renderscript.destroy();
        return true;
    }

    public static boolean i(RenderScript renderscript, Allocation allocation, Allocation allocation1, int i1)
    {
        if (renderscript == null)
        {
            return false;
        }
        int j1;
        int k1;
        try
        {
            j1 = allocation.getType().getX();
            k1 = allocation.getType().getY();
        }
        // Misplaced declaration of an exception variable
        catch (RenderScript renderscript)
        {
            return false;
        }
        if (i1 != 100)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        allocation1.copy2DRangeFrom(0, 0, j1, k1, allocation, 0, 0);
        return true;
        renderscript = new l(renderscript);
        renderscript.a(i1);
        renderscript.a(allocation, allocation1);
        renderscript.destroy();
        return true;
    }

    public static boolean j(RenderScript renderscript, Allocation allocation, Allocation allocation1, int i1)
    {
        if (renderscript == null)
        {
            return false;
        }
        m m1;
        bt bt1;
        bc bc1;
        Object obj;
        int j1;
        int k1;
        try
        {
            j1 = allocation.getType().getX();
            k1 = allocation.getType().getY();
        }
        // Misplaced declaration of an exception variable
        catch (RenderScript renderscript)
        {
            return false;
        }
        if (i1 != 100)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        allocation1.copy2DRangeFrom(0, 0, j1, k1, allocation, 0, 0);
        return true;
        m1 = new m(renderscript);
        m1.a(j1, k1);
        m1.a(allocation, allocation1);
        obj = Allocation.createTyped(renderscript, allocation1.getType());
        bt1 = new bt(renderscript);
        bt1.a(7, 13, 17, -8, 25, -5, -3, 11, -5, 10, 1);
        bt1.a(allocation1, ((Allocation) (obj)));
        bc1 = new bc(renderscript);
        bc1.a(((Allocation) (obj)), allocation1, 5);
        bc1.a(allocation1);
        ((Allocation) (obj)).destroy();
        obj = new n(renderscript);
        ((n) (obj)).a(allocation1);
        bt1.a(25, 3, 4, -22, 7, 4, 14, 0, 0, 0, 0);
        bt1.a(allocation1, allocation1);
        renderscript = new o(renderscript);
        renderscript.a(i1);
        renderscript.a(allocation, allocation1);
        bt1.destroy();
        bc1.destroy();
        m1.destroy();
        ((n) (obj)).destroy();
        renderscript.destroy();
        return true;
    }

    public static boolean k(RenderScript renderscript, Allocation allocation, Allocation allocation1, int i1)
    {
        if (renderscript == null)
        {
            return false;
        }
        bs bs1;
        bj bj1;
        int j1;
        int k1;
        try
        {
            j1 = allocation.getType().getX();
            k1 = allocation.getType().getY();
        }
        // Misplaced declaration of an exception variable
        catch (RenderScript renderscript)
        {
            return false;
        }
        if (i1 != 100)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        allocation1.copy2DRangeFrom(0, 0, j1, k1, allocation, 0, 0);
        return true;
        bs1 = new bs(renderscript);
        bs1.a(0.8594344F, 0.07600155F, 0.08613195F, -0.03134111F, 0.948999F, -0.02067296F, -0.01029104F, -0.03320033F, 0.9027592F);
        bs1.a(allocation, allocation1);
        bj1 = new bj(renderscript);
        bj1.a(1.05F);
        bj1.a(allocation1, allocation1);
        renderscript = new p(renderscript);
        renderscript.a(j1, k1, i1);
        renderscript.a(allocation, allocation1);
        bs1.destroy();
        bj1.destroy();
        renderscript.destroy();
        return true;
    }

    public static native void medianFilter4buf(Buffer buffer, Buffer buffer1, int i1, int j1, int k1);

    public static native void medianblur4buf(Buffer buffer, int i1, int j1, int k1, int l1);

    public static native void shadows(Buffer buffer, Buffer buffer1, int i1, int j1, float f1);

    static 
    {
        try
        {
            System.loadLibrary("RenderScriptOp");
            a = true;
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            try
            {
                System.load((new StringBuilder("/data/data/")).append(System.getProperty("packageName")).append("/lib/RenderScriptOp.so").toString());
                a = true;
            }
            catch (UnsatisfiedLinkError unsatisfiedlinkerror1)
            {
                Log.e(com/socialin/android/photo/imgop/ImageOpCommon.getSimpleName(), "Can't load \"imageop\" library.");
                Log.e(com/socialin/android/photo/imgop/ImageOpCommon.getSimpleName(), unsatisfiedlinkerror1.getMessage());
            }
        }
    }
}
