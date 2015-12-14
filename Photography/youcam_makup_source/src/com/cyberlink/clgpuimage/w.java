// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.cyberlink.clgpuimage:
//            u, GPUImageMaskAlphaBlendFilter, x, af

class w extends u
{

    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private final float g[];
    private int h;
    private int i;
    private int j;
    private final AtomicReference k;

    private void a(byte byte0)
    {
        i = GPUImageMaskAlphaBlendFilter.f();
        GLES20.glTexImage2D(3553, 0, 6406, 1, 1, 0, 6406, 5121, ByteBuffer.allocateDirect(1).put(0, byte0));
    }

    static void a(w w1)
    {
        w1.f();
    }

    private void f()
    {
        x x1 = (x)k.getAndSet(null);
        if (x1 == null)
        {
            return;
        }
        if (x1.a != null)
        {
            GLES20.glBindTexture(3553, j);
            int ai[] = new int[1];
            GLES20.glGetIntegerv(3317, ai, 0);
            GLES20.glPixelStorei(3317, 1);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, az, aA, 6406, 5121, x1.a);
            GLES20.glPixelStorei(3317, ai[0]);
            h = j;
            return;
        } else
        {
            h = i;
            return;
        }
    }

    public void a()
    {
        super.a();
        Matrix.setIdentityM(g, 0);
        a = af.a("uniform mat4 transformMatrix;\n\nattribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nvarying vec2 textureCoordinate;\n\nvoid main()\n{\n    gl_Position = transformMatrix * position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputMaskTexture;\n\nvoid main()\n{\n   lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n   lowp float mask = texture2D(inputMaskTexture, textureCoordinate).a;\n   gl_FragColor = vec4(textureColor.rgb, textureColor.a * mask);\n}");
        b = GLES20.glGetAttribLocation(a, "position");
        c = GLES20.glGetAttribLocation(a, "inputTextureCoordinate");
        d = GLES20.glGetUniformLocation(a, "transformMatrix");
        e = GLES20.glGetUniformLocation(a, "inputImageTexture");
        f = GLES20.glGetUniformLocation(a, "inputMaskTexture");
        a((byte)-1);
        j = GPUImageMaskAlphaBlendFilter.f();
        h = i;
    }

    public void a(int l, int i1)
    {
        super.a(l, i1);
        GLES20.glBindTexture(3553, j);
        GLES20.glTexImage2D(3553, 0, 6406, l, i1, 0, 6406, 5121, null);
    }

    void a(int l, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        super.b(l, floatbuffer, floatbuffer1);
    }

    public void c()
    {
        if (a != 0)
        {
            GLES20.glDeleteProgram(a);
            a = 0;
        }
        if (i != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                i
            }, 0);
            i = -1;
        }
        if (j != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                j
            }, 0);
            j = -1;
        }
        h = -1;
        super.c();
    }

    void c(int l, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        GLES20.glUseProgram(a);
        boolean flag = GLES20.glIsEnabled(3042);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        floatbuffer.position(0);
        GLES20.glVertexAttribPointer(b, 2, 5126, false, 0, floatbuffer);
        GLES20.glEnableVertexAttribArray(b);
        floatbuffer1.position(0);
        GLES20.glVertexAttribPointer(c, 2, 5126, false, 0, floatbuffer1);
        GLES20.glEnableVertexAttribArray(c);
        GLES20.glUniformMatrix4fv(d, 1, false, g, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, l);
        GLES20.glUniform1i(e, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, h);
        GLES20.glUniform1i(f, 1);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(b);
        GLES20.glDisableVertexAttribArray(c);
        GLES20.glBindTexture(3553, 0);
        if (!flag)
        {
            GLES20.glBlendFunc(1, 0);
            GLES20.glDisable(3042);
        }
    }
}
