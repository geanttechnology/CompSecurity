// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.ByteBuffer;

// Referenced classes of package com.cyberlink.clgpuimage:
//            u, af

public class ad extends u
{

    private ByteBuffer a;
    private Bitmap b;
    public int j;
    public int k;
    public int l;

    public void a()
    {
        super.a();
        j = GLES20.glGetAttribLocation(l(), "inputTextureCoordinate2");
        k = GLES20.glGetUniformLocation(l(), "inputImageTexture2");
        GLES20.glEnableVertexAttribArray(j);
        if (b != null && !b.isRecycled())
        {
            a(b);
        }
    }

    public void a(Bitmap bitmap)
    {
        if (bitmap == null || !bitmap.isRecycled())
        {
            b = bitmap;
            if (b != null)
            {
                a(new Runnable(bitmap) {

                    final Bitmap a;
                    final ad b;

                    public void run()
                    {
                        if (b.l != -1 || a == null || a.isRecycled())
                        {
                            return;
                        } else
                        {
                            GLES20.glActiveTexture(33987);
                            b.l = af.a(a, -1, false);
                            return;
                        }
                    }

            
            {
                b = ad.this;
                a = bitmap;
                super();
            }
                });
                return;
            }
        }
    }

    public void c()
    {
        super.c();
        GLES20.glDeleteTextures(1, new int[] {
            l
        }, 0);
        l = -1;
    }

    protected void e()
    {
        GLES20.glEnableVertexAttribArray(j);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, l);
        GLES20.glUniform1i(k, 3);
        a.position(0);
        GLES20.glVertexAttribPointer(j, 2, 5126, false, 0, a);
    }
}
