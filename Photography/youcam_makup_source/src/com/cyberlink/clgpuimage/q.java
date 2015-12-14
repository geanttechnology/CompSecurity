// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

// Referenced classes of package com.cyberlink.clgpuimage:
//            u

public class q extends u
{

    private static String c = "attribute vec4 position; \nattribute vec2 inputTextureCoordinate; \n \nvarying vec2 texture_coordinate; \n \nvoid main() \n{ \n    gl_Position = position; \n    texture_coordinate = inputTextureCoordinate; \n} \n";
    private static String d = "precision mediump float; \n \nvarying vec2 texture_coordinate; \n \nuniform sampler2D inputImageTexture; \nuniform sampler2D inputImageTexture2; \nuniform int isHD; \n \nconst mat3 yuv2rgb_forHD = mat3( \n        1,        1,         1, \n        0,       -0.343,     1.765, \n        1.400,   -0.711,     0 \n        ); \n \nconst mat3 yuv2rgb_forSD = mat3( \n        1,        1,         1, \n        0,       -0.344,     1.772, \n        1.402,   -0.714,     0 \n        ); \n \nvoid main() \n{ \n    vec3 yuv; \n    yuv.x = texture2D(inputImageTexture, texture_coordinate).r; \n    yuv.yz = texture2D(inputImageTexture2, texture_coordinate).ar; \n    vec3 rgb; \n    if (isHD == 1) \n        rgb = yuv2rgb_forHD * (yuv - vec3(0.0, 0.5, 0.5)); \n    else \n        rgb = yuv2rgb_forSD * (yuv - vec3(0.0, 0.5, 0.5)); \n    gl_FragColor = vec4(rgb, 1.0); \n} \n";
    protected int a;
    protected int b;
    private int e[];
    private int f[];
    private int g;

    public q()
    {
        super(c, d);
        e = null;
        f = null;
        g = 1;
    }

    private void f()
    {
        if (f != null)
        {
            GLES20.glDeleteTextures(f.length, f, 0);
            f = null;
        }
        if (e != null)
        {
            GLES20.glDeleteFramebuffers(e.length, e, 0);
            e = null;
        }
    }

    public int a(int i, int j, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        if (!i() || e == null || f == null)
        {
            return -1;
        }
        GLES20.glBindFramebuffer(36160, e[0]);
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
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(ax, 0);
        }
        if (j != -1)
        {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, j);
            GLES20.glUniform1i(a, 3);
        }
        GLES20.glUniform1i(b, g);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(aw);
        GLES20.glDisableVertexAttribArray(ay);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        return f[0];
    }

    public void a()
    {
        super.a();
        a = GLES20.glGetUniformLocation(l(), "inputImageTexture2");
        b = GLES20.glGetUniformLocation(l(), "isHD");
        e = new int[1];
        f = new int[1];
    }

    public void a(int i, int j)
    {
        super.a(i, j);
        if (e != null)
        {
            f();
        }
        e = new int[1];
        f = new int[1];
        GLES20.glGenFramebuffers(1, e, 0);
        GLES20.glGenTextures(1, f, 0);
        GLES20.glBindTexture(3553, f[0]);
        GLES20.glTexImage2D(3553, 0, 6408, i, j, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729F);
        GLES20.glTexParameterf(3553, 10241, 9729F);
        GLES20.glTexParameterf(3553, 10242, 33071F);
        GLES20.glTexParameterf(3553, 10243, 33071F);
        GLES20.glBindFramebuffer(36160, e[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, f[0], 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public void b(int i, int j)
    {
        if (i >= 576 && j >= 576)
        {
            g = 1;
            return;
        } else
        {
            g = 0;
            return;
        }
    }

    public void c()
    {
        f();
        super.c();
    }

}
