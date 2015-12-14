// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.gpu;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;

// Referenced classes of package com.photo.gpu:
//            e

final class init>
    implements Runnable
{

    private Bitmap a;
    private boolean b;
    private e c;

    public final void run()
    {
        e e1 = c;
        Bitmap bitmap = a;
        int i = e.d(c);
        boolean flag = b;
        int ai[] = new int[1];
        if (i == -1)
        {
            GLES20.glGenTextures(1, ai, 0);
            GLES20.glBindTexture(3553, ai[0]);
            GLES20.glTexParameterf(3553, 10240, 9729F);
            GLES20.glTexParameterf(3553, 10241, 9729F);
            GLES20.glTexParameterf(3553, 10242, 33071F);
            GLES20.glTexParameterf(3553, 10243, 33071F);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        } else
        {
            GLES20.glBindTexture(3553, i);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            ai[0] = i;
        }
        if (flag)
        {
            bitmap.recycle();
        }
        e.a(e1, ai[0]);
        e.b(c, a.getWidth());
        e.c(c, a.getHeight());
        e.e(c);
    }

    itmap(e e1, Bitmap bitmap, boolean flag)
    {
        c = e1;
        a = bitmap;
        b = false;
        super();
    }
}
