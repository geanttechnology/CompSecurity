// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class x
    implements android.opengl.GLSurfaceView.Renderer
{

    public static final float a[] = {
        -1F, 1.0F, 1.0F, 1.0F, -1F, -1F, 1.0F, -1F
    };
    public static final float b[] = {
        0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F
    };
    public static String c = "attribute vec4 position; \nattribute vec2 inputTextureCoordinate; \n \nvarying vec2 texture_coordinate; \n \nvoid main() \n{ \n    gl_Position = position; \n    texture_coordinate = inputTextureCoordinate; \n} \n";
    public static String d = "precision mediump float; \n \nvarying vec2 texture_coordinate; \nuniform sampler2D inputImageTexture; \n \nuniform vec2 sampling_offset_start; \nuniform vec2 sampling_step; \n \nvoid main() \n{ \n    vec4 center = texture2D(inputImageTexture, texture_coordinate); \n    center.a = center.g * center.g; \n \n    vec4 average_info = center; \n \n    const int one_side_sampling_number = 2; \n    vec2 sampling_offset = sampling_offset_start; \n    for (int i = 0; i < one_side_sampling_number; i++) \n    { \n        vec4 surround_0 = texture2D(inputImageTexture, texture_coordinate + sampling_offset); \n        surround_0.a = surround_0.g * surround_0.g; \n \n        vec4 surround_1 = texture2D(inputImageTexture, texture_coordinate - sampling_offset); \n        surround_1.a = surround_1.g * surround_1.g; \n \n        average_info += surround_0 + surround_1; \n \n        sampling_offset += sampling_step; \n        } \n \n        average_info /= float(2 * one_side_sampling_number + 1); \n \n        gl_FragColor = average_info; \n    } \n";
    public static String e = "attribute vec4 position; \nattribute vec2 inputTextureCoordinate; \n \nvarying vec2 texture_coordinate; \n \nvoid main() \n{ \n    gl_Position = position; \n    texture_coordinate = inputTextureCoordinate; \n} \n";
    public static String f = "precision mediump float; \n \nvarying vec2 texture_coordinate; \nuniform sampler2D rootImageTexture; \nuniform sampler2D inputImageTexture; \n \nuniform vec2 sampling_offset_start; \nuniform vec2 sampling_step; \n \nuniform float strength; \n \nconst vec3 reference_skin = vec3(0.88, 0.79, 0.79); \nvoid main() \n{ \n    vec4 average_info = texture2D(inputImageTexture, texture_coordinate); \n \n    const int one_side_sampling_number = 2; \n    vec2 sampling_offset = sampling_offset_start; \n    for (int i = 0; i < one_side_sampling_number; i++) \n    { \n        vec4 surround_0 = texture2D(inputImageTexture, texture_coordinate + sampling_offset); \n        vec4 surround_1 = texture2D(inputImageTexture, texture_coordinate - sampling_offset); \n        average_info += surround_0 + surround_1; \n \n        sampling_offset += sampling_step; \n    } \n \n    average_info /= float(2 * one_side_sampling_number + 1); \n \n    float mean = average_info.g; \n    float sqaure_mean = average_info.a;  \n    float variance = max(0.00001, sqaure_mean - mean * mean); \n \n    float epsilon = strength; \n    float src_weight = variance / (variance + (epsilon * epsilon)); \n \n    const float base_src_weight = 0.2; \n    src_weight = src_weight + base_src_weight - src_weight * base_src_weight; \n    src_weight = 1.0 - ((1.0 - src_weight) * min(1.0, average_info.g * 2.5)); \n \n   vec4 root_source = texture2D(rootImageTexture, texture_coordinate); \n \n    average_info = mix(average_info, root_source, src_weight); \n \n    average_info.rgb = max(vec3(0.0), (average_info.rgb - vec3(0.031372)) * vec3(1.0324)); \n \n    float reference_skin_weight = dot(average_info.rgb, reference_skin) / 18.0;    average_info.rgb = mix(average_info.rgb, reference_skin, reference_skin_weight); \n    gl_FragColor = vec4(average_info.rgb, 1.0); \n} \n";
    private int A;
    private boolean B;
    private FloatBuffer C;
    private FloatBuffer D;
    private GLSurfaceView g;
    private int h[];
    private int i[];
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private final Queue x = new ConcurrentLinkedQueue();
    private int y;
    private int z;

    public x()
    {
        C = ByteBuffer.allocateDirect(a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        C.put(a).position(0);
        D = ByteBuffer.allocateDirect(b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        D.put(b).position(0);
        B = false;
    }

    public static int a(String s1, int i1)
    {
        int ai[] = new int[1];
        i1 = GLES20.glCreateShader(i1);
        GLES20.glShaderSource(i1, s1);
        GLES20.glCompileShader(i1);
        GLES20.glGetShaderiv(i1, 35713, ai, 0);
        if (ai[0] == 0)
        {
            Log.d("Load Shader Failed", (new StringBuilder()).append("Compilation\n").append(GLES20.glGetShaderInfoLog(i1)).toString());
            return 0;
        } else
        {
            return i1;
        }
    }

    public static int a(String s1, String s2)
    {
        int ai[] = new int[1];
        int i1 = a(s1, 35633);
        if (i1 == 0)
        {
            Log.d("Load Program", "Vertex Shader Failed");
            return 0;
        }
        int j1 = a(s2, 35632);
        if (j1 == 0)
        {
            Log.d("Load Program", "Fragment Shader Failed");
            return 0;
        }
        int k1 = GLES20.glCreateProgram();
        GLES20.glAttachShader(k1, i1);
        GLES20.glAttachShader(k1, j1);
        GLES20.glLinkProgram(k1);
        GLES20.glGetProgramiv(k1, 35714, ai, 0);
        if (ai[0] <= 0)
        {
            Log.d("Load Program", "Linking Failed");
            return 0;
        } else
        {
            GLES20.glDeleteShader(i1);
            GLES20.glDeleteShader(j1);
            return k1;
        }
    }

    private void a(Queue queue)
    {
        queue;
        JVM INSTR monitorenter ;
        for (; !queue.isEmpty(); queue.poll())
        {
            ((Runnable)queue.peek()).run();
        }

        break MISSING_BLOCK_LABEL_40;
        Exception exception;
        exception;
        queue;
        JVM INSTR monitorexit ;
        throw exception;
        queue;
        JVM INSTR monitorexit ;
    }

    public void a()
    {
        B = true;
        y = 0;
        g.setRenderMode(1);
    }

    public void a(int i1, int j1)
    {
        a(new Runnable(i1, j1) {

            final int a;
            final int b;
            final x c;

            public void run()
            {
                c.b(a, b);
            }

            
            {
                c = x.this;
                a = i1;
                b = j1;
                super();
            }
        });
        g.requestRender();
        z = i1;
        A = j1;
    }

    public void a(GLSurfaceView glsurfaceview)
    {
        g = glsurfaceview;
        g.setRenderMode(0);
    }

    protected void a(Runnable runnable)
    {
        x.add(runnable);
    }

    public int b()
    {
        g.setRenderMode(0);
        B = false;
        a(new Runnable() {

            final x a;

            public void run()
            {
                a.c();
            }

            
            {
                a = x.this;
                super();
            }
        });
        g.requestRender();
        return y;
    }

    public void b(int i1, int j1)
    {
        j = a(c, d);
        k = GLES20.glGetAttribLocation(j, "position");
        l = GLES20.glGetUniformLocation(j, "inputImageTexture");
        m = GLES20.glGetAttribLocation(j, "inputTextureCoordinate");
        n = GLES20.glGetUniformLocation(j, "sampling_offset_start");
        o = GLES20.glGetUniformLocation(j, "sampling_step");
        p = a(e, f);
        q = GLES20.glGetAttribLocation(p, "position");
        r = GLES20.glGetUniformLocation(p, "inputImageTexture");
        s = GLES20.glGetAttribLocation(p, "inputTextureCoordinate");
        t = GLES20.glGetUniformLocation(p, "sampling_offset_start");
        u = GLES20.glGetUniformLocation(p, "sampling_step");
        w = GLES20.glGetUniformLocation(p, "strength");
        v = GLES20.glGetUniformLocation(p, "rootImageTexture");
        h = new int[3];
        i = new int[3];
        for (int k1 = 0; k1 < 3; k1++)
        {
            GLES20.glGenFramebuffers(1, h, k1);
            GLES20.glGenTextures(1, i, k1);
            GLES20.glBindTexture(3553, i[k1]);
            GLES20.glTexImage2D(3553, 0, 6408, i1, j1, 0, 6408, 5121, null);
            GLES20.glTexParameterf(3553, 10240, 9729F);
            GLES20.glTexParameterf(3553, 10241, 9729F);
            GLES20.glTexParameterf(3553, 10242, 33071F);
            GLES20.glTexParameterf(3553, 10243, 33071F);
            GLES20.glBindFramebuffer(36160, h[k1]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i[k1], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }

    }

    public void c()
    {
        if (i != null)
        {
            GLES20.glDeleteTextures(i.length, i, 0);
            i = null;
        }
        if (h != null)
        {
            GLES20.glDeleteFramebuffers(h.length, h, 0);
            h = null;
        }
        GLES20.glDeleteProgram(j);
        GLES20.glDeleteProgram(p);
    }

    public void c(int i1, int j1)
    {
        GLES20.glUseProgram(j);
        GLES20.glViewport(0, 0, i1, j1);
        C.position(0);
        GLES20.glVertexAttribPointer(k, 2, 5126, false, 0, C);
        GLES20.glEnableVertexAttribArray(k);
        D.position(0);
        GLES20.glVertexAttribPointer(m, 2, 5126, false, 0, D);
        GLES20.glEnableVertexAttribArray(m);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i[0]);
        GLES20.glUniform1i(l, 0);
        GLES20.glUniform2f(n, 3.5F, 0.0F);
        GLES20.glUniform2f(o, 2.5F, 0.0F);
        GLES20.glBindFramebuffer(36160, h[1]);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(k);
        GLES20.glDisableVertexAttribArray(m);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(p);
        C.position(0);
        GLES20.glVertexAttribPointer(q, 2, 5126, false, 0, C);
        GLES20.glEnableVertexAttribArray(q);
        D.position(0);
        GLES20.glVertexAttribPointer(s, 2, 5126, false, 0, D);
        GLES20.glEnableVertexAttribArray(s);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i[0]);
        GLES20.glUniform1i(v, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, i[1]);
        GLES20.glUniform1i(r, 1);
        GLES20.glUniform2f(t, 3.5F, 0.0F);
        GLES20.glUniform2f(u, 2.5F, 0.0F);
        GLES20.glUniform1f(w, 0.5F);
        GLES20.glBindFramebuffer(36160, h[2]);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(q);
        GLES20.glDisableVertexAttribArray(s);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        y = y + 1;
    }

    public void onDrawFrame(GL10 gl10)
    {
        GLES20.glClear(16640);
        a(x);
        if (B)
        {
            c(z, A);
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i1, int j1)
    {
        GLES20.glClearColor(1.0F, 1.0F, 1.0F, 0.0F);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
    }

}
