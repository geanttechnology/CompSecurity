// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

// Referenced classes of package com.cyberlink.clgpuimage:
//            u

public class p extends u
{

    private static String b = "attribute vec4 position; \nattribute vec2 inputTextureCoordinate; \n \nvarying vec2 texture_coordinate; \n \nuniform mat4 transformMatrix; \n \nvoid main() \n{ \n    gl_Position = position; \n    texture_coordinate = (transformMatrix * vec4(inputTextureCoordinate.xy, 0.0, 1.0)).xy; \n} \n";
    private static String c = "#extension GL_OES_EGL_image_external : require\nprecision mediump float; \nvarying vec2 texture_coordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, texture_coordinate);\n}";
    private static int f = 36197;
    protected int a;
    private int d[];
    private int e[];

    public p()
    {
        super(b, c);
        d = null;
        e = null;
    }

    private void m()
    {
        if (e != null)
        {
            GLES20.glDeleteTextures(e.length, e, 0);
            e = null;
        }
        if (d != null)
        {
            GLES20.glDeleteFramebuffers(d.length, d, 0);
            d = null;
        }
    }

    public int a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        if (!i() || d == null || e == null)
        {
            return -1;
        }
        GLES20.glBindFramebuffer(36160, d[0]);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GLES20.glUseProgram(av);
        d_();
        if (!i())
        {
            return -1;
        }
        floatbuffer.position(0);
        GLES20.glVertexAttribPointer(aw, 2, 5126, false, 0, floatbuffer);
        GLES20.glEnableVertexAttribArray(aw);
        floatbuffer1.position(0);
        GLES20.glVertexAttribPointer(ay, 2, 5126, false, 0, floatbuffer1);
        GLES20.glEnableVertexAttribArray(ay);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(f, i);
            GLES20.glUniform1i(ax, 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(aw);
        GLES20.glDisableVertexAttribArray(ay);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindTexture(f, 0);
        GLES20.glBindFramebuffer(36160, 0);
        return e[0];
    }

    public void a()
    {
        super.a();
        d = new int[1];
        e = new int[1];
        a = GLES20.glGetUniformLocation(av, "transformMatrix");
    }

    public void a(int i, int j)
    {
        super.a(i, j);
        if (d != null)
        {
            m();
        }
        d = new int[1];
        e = new int[1];
        GLES20.glGenFramebuffers(1, d, 0);
        GLES20.glGenTextures(1, e, 0);
        GLES20.glBindTexture(3553, e[0]);
        GLES20.glTexImage2D(3553, 0, 6408, i, j, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729F);
        GLES20.glTexParameterf(3553, 10241, 9729F);
        GLES20.glTexParameterf(3553, 10242, 33071F);
        GLES20.glTexParameterf(3553, 10243, 33071F);
        GLES20.glBindFramebuffer(36160, d[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, e[0], 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public void c()
    {
        m();
        super.c();
    }

    public int f()
    {
        return a;
    }

}
