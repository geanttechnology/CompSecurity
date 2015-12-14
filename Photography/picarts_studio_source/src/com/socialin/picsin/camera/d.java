// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.socialin.android.dialog.g;
import com.socialin.android.photo.exif.ExifTool;
import com.socialin.android.photo.imgop.ImageOp;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.photo.imgop.ImageResize;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.o;
import com.socialin.android.util.w;
import com.socialin.camera.opengl.a;
import com.socialin.camera.opengl.aa;
import com.socialin.camera.opengl.e;
import com.socialin.camera.opengl.q;
import com.socialin.camera.opengl.r;
import com.socialin.camera.opengl.s;
import com.socialin.camera.opengl.t;
import com.socialin.camera.opengl.v;
import com.socialin.picsin.camera.view.c;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import myobfuscated.az.b;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

public final class d extends Thread
{

    int a;
    boolean b;
    int c;
    String d;
    final CameraMainActivity e;
    private byte f[];
    private Bitmap g;
    private int h;
    private boolean i;

    public d(CameraMainActivity cameramainactivity, Bitmap bitmap, int j, int k, boolean flag)
    {
        e = cameramainactivity;
        super();
        f = null;
        g = null;
        a = 0;
        b = false;
        c = 0;
        h = -1;
        g = bitmap;
        a = j;
        h = k;
        i = flag;
    }

    public d(CameraMainActivity cameramainactivity, Bitmap bitmap, int j, boolean flag)
    {
        e = cameramainactivity;
        super();
        f = null;
        g = null;
        a = 0;
        b = false;
        c = 0;
        h = -1;
        g = bitmap;
        a = j;
        i = flag;
    }

    public d(CameraMainActivity cameramainactivity, byte abyte0[], int j)
    {
        e = cameramainactivity;
        super();
        f = null;
        g = null;
        a = 0;
        b = false;
        c = 0;
        h = -1;
        f = abyte0;
        a = j;
    }

    static Bitmap a(d d1)
    {
        return d1.g;
    }

    public final void run()
    {
        String s2;
        (new StringBuilder()).append(e.getString(0x7f0808fc)).append("_").append(System.currentTimeMillis());
        s2 = (new StringBuilder()).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath()).append("/").append(e.getResources().getString(0x7f0808fc)).append("/").append(e.getResources().getString(0x7f0808c3)).append("/").toString();
        if (CameraMainActivity.z(e) != null) goto _L2; else goto _L1
_L1:
        String s1 = (new StringBuilder()).append(System.currentTimeMillis()).append(".jpg").toString();
        d = (new StringBuilder()).append(s2).append(s1).toString();
_L14:
        if (f == null) goto _L4; else goto _L3
_L3:
        Object obj = new ByteArrayInputStream(f);
        FileUtils.a(d, ((java.io.InputStream) (obj)));
_L15:
        f = null;
        int k = 0;
_L35:
        int l;
        e.runOnUiThread(new Runnable() {

            private d a;

            public final void run()
            {
                try
                {
                    if (!CameraMainActivity.A(a.e))
                    {
                        CameraMainActivity.u(a.e).dismiss();
                    }
                    return;
                }
                catch (Exception exception)
                {
                    return;
                }
            }

            
            {
                a = d.this;
                super();
            }
        });
        com.socialin.picsin.camera.CameraMainActivity.a(e, d);
        com.socialin.picsin.camera.CameraMainActivity.c(e, a);
        obj = CameraMainActivity.B(e);
        l = CameraMainActivity.C(e);
        obj = new ExifInterface(((String) (obj)));
        int j = 1;
        l;
        JVM INSTR lookupswitch 3: default 2445
    //                   90: 2331
    //                   180: 2338
    //                   270: 2344;
           goto _L5 _L6 _L7 _L8
_L5:
        ((ExifInterface) (obj)).setAttribute("Orientation", String.valueOf(j));
        ((ExifInterface) (obj)).saveAttributes();
_L53:
        b = true;
        ExifTool.a(CameraMainActivity.B(e), "Exif.Photo.UserComment", "{\"from\":\"picsart_camera\"}");
        if (k == 0)
        {
            break MISSING_BLOCK_LABEL_344;
        }
        com.socialin.picsin.camera.CameraMainActivity.b(e, false);
        c;
        JVM INSTR tableswitch 1 2: default 2448
    //                   1 2359
    //                   2 2404;
           goto _L9 _L10 _L11
_L9:
        new o(e, d, "image/*");
        return;
_L2:
        if (!(CameraMainActivity.z(e) instanceof Uri)) goto _L13; else goto _L12
_L12:
        final class _cls4
            implements Runnable
        {

            private d a;

            public final void run()
            {
                com.socialin.picsin.camera.CameraMainActivity.b(a.e, a.e.getString(0x7f08009e));
            }

            
            {
                a = d.this;
                super();
            }
        }

        Object obj1;
        d = w.a((Uri)CameraMainActivity.z(e), e);
          goto _L14
_L13:
        Object obj2;
        Object obj3;
        try
        {
            d = (String)CameraMainActivity.z(e);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            ((Exception) (obj1)).printStackTrace();
            float f1;
            Object obj4;
            Object obj5;
            Canvas canvas;
            Paint paint;
            int i1;
            int j1;
            int k1;
            int l1;
            try
            {
                CameraMainActivity.u(e).dismiss();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
            e.runOnUiThread(new _cls4());
            return;
        }
          goto _L14
        obj1;
        ((IOException) (obj1)).printStackTrace();
          goto _L15
_L4:
        if (h == -1 || com.socialin.picsin.camera.CameraMainActivity.o(e).c != h) goto _L17; else goto _L16
_L16:
        obj4 = com.socialin.picsin.camera.CameraMainActivity.o(e);
        obj2 = g;
        obj1 = obj2;
        j = h;
        obj3 = obj1;
        if (obj1 == null) goto _L19; else goto _L18
_L18:
        obj3 = obj1;
        if (((Bitmap) (obj1)).isRecycled()) goto _L19; else goto _L20
_L20:
        obj3 = obj1;
        j;
        JVM INSTR tableswitch 4 19: default 2452
    //                   4 1477
    //                   5 1252
    //                   6 632
    //                   7 1363
    //                   8 939
    //                   9 1122
    //                   10 632
    //                   11 632
    //                   12 632
    //                   13 632
    //                   14 632
    //                   15 632
    //                   16 632
    //                   17 632
    //                   18 1882
    //                   19 2174;
           goto _L21 _L22 _L23 _L19 _L24 _L25 _L26 _L19 _L19 _L19 _L19 _L19 _L19 _L19 _L19 _L27 _L28
_L19:
        g = ((Bitmap) (obj3));
_L17:
        obj1 = new File(s2);
        if (!((File) (obj1)).exists() && ((File) (obj1)).mkdir())
        {
            Log.e("CameraMainActivity", "cant create directory");
        }
        obj1 = new FileOutputStream(d);
        g.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, ((java.io.OutputStream) (obj1)));
        ((FileOutputStream) (obj1)).flush();
        ((FileOutputStream) (obj1)).close();
        if (!i) goto _L30; else goto _L29
_L29:
        a;
        JVM INSTR lookupswitch 2: default 2458
    //                   90: 2314
    //                   270: 2314;
           goto _L30 _L31 _L31
_L30:
        obj2 = null;
        obj1 = obj2;
        if (g == null)
        {
            break MISSING_BLOCK_LABEL_801;
        }
        obj1 = obj2;
        if (g.isRecycled())
        {
            break MISSING_BLOCK_LABEL_801;
        }
        obj2 = w.a(g, 128, 128);
        obj1 = obj2;
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_801;
        }
        obj1 = obj2;
        if (!((Bitmap) (obj2)).isRecycled())
        {
            obj1 = w.d(((Bitmap) (obj2)), a);
        }
        j = com.socialin.picsin.camera.CameraMainActivity.c(e).E();
        if (j == 0) goto _L33; else goto _L32
_L32:
        g = w.d(g, j);
_L33:
        e.runOnUiThread(new Runnable(((Bitmap) (obj1))) {

            private Bitmap a;
            private d b;

            public final void run()
            {
                if (b.e.findViewById(0x7f10022b).getVisibility() == 0)
                {
                    ((ImageView)b.e.findViewById(0x7f10022c)).setImageBitmap(com.socialin.picsin.camera.d.a(b));
                }
                ((ImageView)b.e.findViewById(0x7f100228)).setImageBitmap(null);
                if (com.socialin.picsin.camera.CameraMainActivity.w(b.e) != null && !com.socialin.picsin.camera.CameraMainActivity.w(b.e).isRecycled())
                {
                    com.socialin.android.util.c.a(com.socialin.picsin.camera.CameraMainActivity.w(b.e), "CameraMainActivity");
                }
                com.socialin.picsin.camera.CameraMainActivity.b(b.e, a);
                ((ImageView)b.e.findViewById(0x7f100228)).setImageBitmap(com.socialin.picsin.camera.CameraMainActivity.w(b.e));
                b.e.findViewById(0x7f100227).setVisibility(0);
                com.socialin.picsin.camera.CameraMainActivity.v(b.e);
            }

            
            {
                b = d.this;
                a = bitmap;
                super();
            }
        });
        obj1 = com.socialin.picsin.camera.CameraMainActivity.r(e);
        com.socialin.picsin.camera.CameraMainActivity.a(e, g);
        i1 = 1;
        j = 1;
        k = j;
        if (obj1 == null) goto _L35; else goto _L34
_L34:
        k = j;
        if (((Bitmap) (obj1)).isRecycled()) goto _L35; else goto _L36
_L36:
        com.socialin.android.util.c.a(((Bitmap) (obj1)));
        k = j;
          goto _L35
        obj1;
        k = i1;
_L48:
        ((Exception) (obj1)).printStackTrace();
        Log.e("ex", "cant save");
        Log.e("ex", ((Exception) (obj1)).toString());
          goto _L35
_L25:
        obj3 = obj1;
        if (((a) (obj4)).i == null) goto _L19; else goto _L37
_L37:
        obj2 = ((a) (obj4)).i;
        j = ((Bitmap) (obj1)).getWidth();
        k = ((Bitmap) (obj1)).getHeight();
        i1 = j / 2;
        j1 = k / 2;
        k1 = Math.min(j, k) / 2;
        f1 = ((aa) (obj2)).a / 100F;
        k1 = (int)((float)k1 * f1);
        f1 = (float)(((double)((aa) (obj2)).b * 3.1415926535897931D) / 180D / 2D);
        obj2 = ImageOpCommon.allocNativeBuffer(((Bitmap) (obj1)).getWidth() * ((Bitmap) (obj1)).getHeight() * 4);
        ((ByteBuffer) (obj2)).position(0);
        ((Bitmap) (obj1)).copyPixelsToBuffer(((java.nio.Buffer) (obj2)));
        ((ByteBuffer) (obj2)).position(0);
        obj3 = ImageOpCommon.allocNativeBuffer(((ByteBuffer) (obj2)).capacity());
        ((ByteBuffer) (obj3)).position(0);
        ImageOpCommon.swirled3(((java.nio.Buffer) (obj2)), ((java.nio.Buffer) (obj3)), j, k, i1, j1, k1, f1);
        ((ByteBuffer) (obj3)).position(0);
        ((Bitmap) (obj1)).copyPixelsFromBuffer(((java.nio.Buffer) (obj3)));
        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj2)));
        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj3)));
        obj3 = obj1;
          goto _L19
_L26:
        obj3 = obj1;
        if (((a) (obj4)).j == null) goto _L19; else goto _L38
_L38:
        obj2 = ((a) (obj4)).j;
        j = ((Bitmap) (obj1)).getWidth();
        k = ((Bitmap) (obj1)).getHeight();
        obj3 = ImageOpCommon.allocNativeBuffer(((Bitmap) (obj1)).getWidth() * ((Bitmap) (obj1)).getHeight() * 4);
        ((ByteBuffer) (obj3)).position(0);
        ((Bitmap) (obj1)).copyPixelsToBuffer(((java.nio.Buffer) (obj3)));
        ((ByteBuffer) (obj3)).position(0);
        obj4 = ImageOpCommon.allocNativeBuffer(((ByteBuffer) (obj3)).capacity());
        ((ByteBuffer) (obj4)).position(0);
        ImageOpCommon.mirrorWithFlip(((java.nio.Buffer) (obj3)), ((java.nio.Buffer) (obj4)), j, k, ((v) (obj2)).a, 0, 0);
        ((ByteBuffer) (obj4)).position(0);
        ((Bitmap) (obj1)).copyPixelsFromBuffer(((java.nio.Buffer) (obj4)));
        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj3)));
        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj4)));
        obj3 = obj1;
          goto _L19
_L23:
        obj3 = obj1;
        if (((a) (obj4)).g == null) goto _L19; else goto _L39
_L39:
        obj2 = ((a) (obj4)).g;
        j = ((Bitmap) (obj1)).getWidth();
        k = ((Bitmap) (obj1)).getHeight();
        obj3 = ImageOpCommon.allocNativeBuffer(((Bitmap) (obj1)).getWidth() * ((Bitmap) (obj1)).getHeight() * 4);
        ((ByteBuffer) (obj3)).position(0);
        ((Bitmap) (obj1)).copyPixelsToBuffer(((java.nio.Buffer) (obj3)));
        ((ByteBuffer) (obj3)).position(0);
        ImageOpCommon.lightCross(((java.nio.Buffer) (obj3)), j, k, ((t) (obj2)).c, ((t) (obj2)).b, ((t) (obj2)).a);
        ((ByteBuffer) (obj3)).position(0);
        ((Bitmap) (obj1)).copyPixelsFromBuffer(((java.nio.Buffer) (obj3)));
        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj3)));
        obj3 = obj1;
          goto _L19
_L24:
        obj3 = obj1;
        if (((a) (obj4)).h == null) goto _L19; else goto _L40
_L40:
        obj2 = ((a) (obj4)).h;
        j = ((Bitmap) (obj1)).getWidth();
        k = ((Bitmap) (obj1)).getHeight();
        obj3 = ImageOpCommon.allocNativeBuffer(((Bitmap) (obj1)).getWidth() * ((Bitmap) (obj1)).getHeight() * 4);
        ((ByteBuffer) (obj3)).position(0);
        ((Bitmap) (obj1)).copyPixelsToBuffer(((java.nio.Buffer) (obj3)));
        ((ByteBuffer) (obj3)).position(0);
        ImageOpCommon.changeHueSaturation(((java.nio.Buffer) (obj3)), j, k, (int)((s) (obj2)).a, (int)((s) (obj2)).b, (int)((s) (obj2)).c);
        ((ByteBuffer) (obj3)).position(0);
        ((Bitmap) (obj1)).copyPixelsFromBuffer(((java.nio.Buffer) (obj3)));
        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj3)));
        obj3 = obj1;
          goto _L19
_L22:
        obj3 = obj1;
        if (((a) (obj4)).f == null) goto _L19; else goto _L41
_L41:
        obj5 = ((a) (obj4)).f;
        ((e) (obj5)).e;
        JVM INSTR tableswitch 0 0: default 2468
    //                   0 2477;
           goto _L42 _L43
_L43:
        break MISSING_BLOCK_LABEL_2471;
_L42:
        j = ((Bitmap) (obj1)).getWidth();
        k = ((Bitmap) (obj1)).getHeight();
        obj3 = new android.graphics.BitmapFactory.Options();
        obj3.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        obj3 = com.socialin.android.util.c.a(((e) (obj5)).f, ((android.graphics.BitmapFactory.Options) (obj3)));
        i1 = ((Bitmap) (obj3)).getWidth();
        j1 = ((Bitmap) (obj3)).getHeight();
        k1 = ((Bitmap) (obj3)).getRowBytes();
        l1 = ((Bitmap) (obj3)).getHeight();
        if (obj3 == null) goto _L45; else goto _L44
_L44:
        if (!((Bitmap) (obj3)).isMutable() || k1 * l1 != i1 * j1 * 4) goto _L46; else goto _L45
_L45:
        if (j == ((Bitmap) (obj3)).getWidth() && k == ((Bitmap) (obj3)).getHeight()) goto _L47; else goto _L46
_L46:
        obj4 = com.socialin.android.util.c.a(j, k, android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas(((Bitmap) (obj4)));
        paint = new Paint();
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawBitmap(((Bitmap) (obj3)), new Rect(0, 0, ((Bitmap) (obj3)).getWidth(), ((Bitmap) (obj3)).getHeight()), new Rect(0, 0, j, k), paint);
        ((Bitmap) (obj3)).recycle();
        obj3 = obj4;
_L47:
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_2471;
        }
        try
        {
            if (!((Bitmap) (obj3)).isRecycled())
            {
                j = ((Bitmap) (obj1)).getWidth();
                k = ((Bitmap) (obj1)).getHeight();
                obj4 = ImageOpCommon.allocNativeBuffer(((Bitmap) (obj3)).getWidth() * ((Bitmap) (obj3)).getHeight() * 4);
                ((ByteBuffer) (obj4)).position(0);
                ((Bitmap) (obj3)).copyPixelsToBuffer(((java.nio.Buffer) (obj4)));
                ((ByteBuffer) (obj4)).position(0);
                ((Bitmap) (obj3)).recycle();
                obj3 = ImageOpCommon.allocNativeBuffer(j * k * 4);
                ((ByteBuffer) (obj3)).position(0);
                ((Bitmap) (obj1)).copyPixelsToBuffer(((java.nio.Buffer) (obj3)));
                ((ByteBuffer) (obj3)).position(0);
                ImageOpCommon.blend(((java.nio.Buffer) (obj3)), ((java.nio.Buffer) (obj4)), j, k, (int)((e) (obj5)).b, ((e) (obj5)).e);
                ((ByteBuffer) (obj3)).position(0);
                ((Bitmap) (obj1)).copyPixelsFromBuffer(((java.nio.Buffer) (obj3)));
                ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj4)));
                ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj3)));
            }
            break MISSING_BLOCK_LABEL_2471;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            k = 0;
        }
          goto _L48
_L27:
        obj3 = obj1;
        if (((a) (obj4)).n == null) goto _L19; else goto _L49
_L49:
        obj2 = ((a) (obj4)).n;
        obj3 = ((a) (obj4)).a;
        j = ((Bitmap) (obj1)).getWidth();
        k = ((Bitmap) (obj1)).getHeight();
        obj4 = myobfuscated.az.b.a(((android.content.Context) (obj3)), "sinEnc", ((q) (obj2)).f, 0, 0, true);
        obj3 = obj1;
        if (obj4 == null) goto _L19; else goto _L50
_L50:
        obj3 = obj1;
        if (((Bitmap) (obj4)).isRecycled()) goto _L19; else goto _L51
_L51:
        i1 = ((Bitmap) (obj4)).getWidth();
        j1 = ((Bitmap) (obj4)).getHeight();
        obj5 = ImageOpCommon.allocNativeBuffer(i1 * j1 * 4);
        ((ByteBuffer) (obj5)).position(0);
        ((Bitmap) (obj4)).copyPixelsToBuffer(((java.nio.Buffer) (obj5)));
        ((ByteBuffer) (obj5)).position(0);
        ((Bitmap) (obj4)).recycle();
        obj3 = ImageOpCommon.allocNativeBuffer(j * k * 4);
        ((ByteBuffer) (obj3)).position(0);
        ImageResize.resize(((ByteBuffer) (obj5)), i1, j1, ((ByteBuffer) (obj3)), j, k, 0);
        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj5)));
        ((ByteBuffer) (obj3)).position(0);
        obj4 = ImageOpCommon.allocNativeBuffer(j * k * 4);
        ((Bitmap) (obj1)).copyPixelsToBuffer(((java.nio.Buffer) (obj4)));
        obj5 = ImageOpCommon.allocNativeBuffer(j * k * 4);
        ((ByteBuffer) (obj4)).position(0);
        ((ByteBuffer) (obj5)).position(0);
        ImageOp.holgaart4buf(((java.nio.Buffer) (obj4)), ((java.nio.Buffer) (obj5)), j, k, j, k, (int)((q) (obj2)).b, (int)((q) (obj2)).c, 0, ((java.nio.Buffer) (obj3)), j, k, (int)((q) (obj2)).a, false, -1);
        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj3)));
        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj4)));
        ((ByteBuffer) (obj5)).position(0);
        ((Bitmap) (obj1)).copyPixelsFromBuffer(((java.nio.Buffer) (obj5)));
        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj5)));
        obj3 = obj1;
          goto _L19
_L28:
        obj3 = obj1;
        if (((a) (obj4)).o == null) goto _L19; else goto _L52
_L52:
        obj2 = ((a) (obj4)).o;
        obj3 = ImageOpCommon.allocNativeBuffer(((Bitmap) (obj1)).getWidth() * ((Bitmap) (obj1)).getHeight() * 4);
        ((Bitmap) (obj1)).copyPixelsToBuffer(((java.nio.Buffer) (obj3)));
        obj4 = ImageOpCommon.allocNativeBuffer(((Bitmap) (obj1)).getWidth() * ((Bitmap) (obj1)).getHeight() * 4);
        ((ByteBuffer) (obj3)).position(0);
        ((ByteBuffer) (obj4)).position(0);
        ImageOp.holgaart14buf(((java.nio.Buffer) (obj3)), ((java.nio.Buffer) (obj4)), ((Bitmap) (obj1)).getWidth(), ((Bitmap) (obj1)).getHeight(), ((Bitmap) (obj1)).getWidth(), ((Bitmap) (obj1)).getHeight(), (int)((r) (obj2)).b, (int)((r) (obj2)).c, (int)((r) (obj2)).a, false, -1);
        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj3)));
        ((ByteBuffer) (obj4)).position(0);
        ((Bitmap) (obj1)).copyPixelsFromBuffer(((java.nio.Buffer) (obj4)));
        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj4)));
        obj3 = obj1;
          goto _L19
_L31:
        g = w.d(g, 180);
          goto _L30
_L6:
        j = 6;
          goto _L5
_L7:
        j = 3;
          goto _L5
_L8:
        j = 8;
          goto _L5
        obj1;
        ((IOException) (obj1)).printStackTrace();
          goto _L53
_L10:
        obj1 = new File(d);
        if (((File) (obj1)).exists() && ((File) (obj1)).delete())
        {
            new o(e, ((File) (obj1)).getAbsolutePath(), "image/*");
            return;
        }
          goto _L54
_L11:
        new o(e, d, "image/*");
        e.runOnUiThread(new Runnable() {

            private d a;

            public final void run()
            {
                com.socialin.picsin.camera.CameraMainActivity.b(a.e, true);
            }

            
            {
                a = d.this;
                super();
            }
        });
        return;
_L54:
        return;
_L21:
        obj3 = obj1;
          goto _L19
        obj3 = obj2;
          goto _L19
    }
}
