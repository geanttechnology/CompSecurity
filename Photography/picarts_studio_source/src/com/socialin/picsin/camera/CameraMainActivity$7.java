// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.socialin.android.dialog.g;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.camera.opengl.CameraOpenGlSurfaceView;
import com.socialin.camera.opengl.a;
import com.socialin.camera.opengl.h;
import com.socialin.picsin.camera.view.c;
import java.nio.ByteBuffer;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity, d

final class e
    implements Runnable
{

    private ByteBuffer a;
    private Bitmap b;
    private long c;
    private int d;
    private int e;
    private CameraMainActivity f;

    public final void run()
    {
        if (!f.isFinishing()) goto _L2; else goto _L1
_L1:
        if (a != null)
        {
            ImageOpCommon.freeNativeBuffer(a);
        }
        if (b != null && !b.isRecycled())
        {
            b.recycle();
        }
_L4:
        return;
_L2:
        if (CameraMainActivity.p(f) == null || CameraMainActivity.p(f).w == c)
        {
            break; /* Loop/switch isn't completed */
        }
        if (a != null)
        {
            ImageOpCommon.freeNativeBuffer(a);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj = CameraMainActivity.p(f);
        obj = new Point(((h) (obj)).k, ((h) (obj)).l);
        if ((((Point) (obj)).x != d || ((Point) (obj)).y != e) && !CameraMainActivity.o(f).b()) goto _L6; else goto _L5
_L5:
        CameraMainActivity.q(f);
        int i = -1;
        Bitmap bitmap;
        if (CameraMainActivity.o(f).b())
        {
            bitmap = b;
            i = CameraMainActivity.o(f).c;
        } else
        {
            bitmap = com.socialin.android.util.c.b(CameraMainActivity.r(f), android.graphics._fld88);
        }
        if (a != null)
        {
            ImageOpCommon.freeNativeBuffer(a);
        }
        f.d = new d(f, bitmap, CameraMainActivity.s(f), i, com.socialin.picsin.camera.CameraMainActivity.c(f).z());
        f.d.start();
        if (CameraMainActivity.p(f) != null)
        {
            CameraMainActivity.p(f).g = false;
        }
_L8:
        com.socialin.picsin.camera.CameraMainActivity.c(f).setPictureTaking(false);
        com.socialin.picsin.camera.CameraMainActivity.a(f, g.a(f, null, f.getString(0x7f080679)));
        CameraMainActivity.u(f).setCancelable(false);
        return;
_L6:
        if (CameraMainActivity.p(f) != null && CameraMainActivity.t(f) != null)
        {
            h h1 = CameraMainActivity.p(f);
            ByteBuffer bytebuffer = a;
            int j = d;
            int k = e;
            h1.s = 0;
            h1.n = true;
            h1.o = bytebuffer;
            h1.p = m.a(Math.max(j, k));
            h1.q = j;
            h1.r = k;
            h1.m = (new float[] {
                0.0F, (float)k / (float)h1.p, (float)j / (float)h1.p, (float)k / (float)h1.p, 0.0F, 0.0F, (float)j / (float)h1.p, 0.0F
            });
            h1.j = h.a(h1.m);
            CameraMainActivity.t(f).setLayoutParams(new android.widget.rams(d, e));
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    ew(CameraMainActivity cameramainactivity, ByteBuffer bytebuffer, Bitmap bitmap, long l, int i, int j)
    {
        f = cameramainactivity;
        a = bytebuffer;
        b = bitmap;
        c = l;
        d = i;
        e = j;
        super();
    }
}
