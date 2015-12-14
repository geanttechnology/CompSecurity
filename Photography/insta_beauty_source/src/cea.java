// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class cea
{

    private static final float e[] = {
        1.0F, 1.0F, -1F, 1.0F, 1.0F, -1F, -1F, -1F
    };
    private static final float f[] = {
        1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F
    };
    int a;
    int b;
    int c;
    int d;
    private final FloatBuffer g = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private final FloatBuffer h = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private int i;
    private final float j[] = new float[16];

    public cea()
    {
        g.put(e);
        g.flip();
        h.put(f);
        h.flip();
        i = a("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\n\nvoid main() {\n\tgl_Position = uMVPMatrix * aPosition;\n\tvTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying highp vec2 vTextureCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}");
        GLES20.glUseProgram(i);
        a = GLES20.glGetAttribLocation(i, "aPosition");
        b = GLES20.glGetAttribLocation(i, "aTextureCoord");
        c = GLES20.glGetUniformLocation(i, "uMVPMatrix");
        d = GLES20.glGetUniformLocation(i, "uTexMatrix");
        Matrix.setIdentityM(j, 0);
        GLES20.glUniformMatrix4fv(c, 1, false, j, 0);
        GLES20.glUniformMatrix4fv(d, 1, false, j, 0);
        GLES20.glVertexAttribPointer(a, 2, 5126, false, 8, g);
        GLES20.glVertexAttribPointer(b, 2, 5126, false, 8, h);
        GLES20.glEnableVertexAttribArray(a);
        GLES20.glEnableVertexAttribArray(b);
    }

    public static int a(String s, String s1)
    {
        int l = 0;
        int i1 = GLES20.glCreateShader(35633);
        GLES20.glShaderSource(i1, s);
        GLES20.glCompileShader(i1);
        s = new int[1];
        GLES20.glGetShaderiv(i1, 35713, s, 0);
        int k = i1;
        if (s[0] == 0)
        {
            GLES20.glDeleteShader(i1);
            k = 0;
        }
        i1 = GLES20.glCreateShader(35632);
        GLES20.glShaderSource(i1, s1);
        GLES20.glCompileShader(i1);
        GLES20.glGetShaderiv(i1, 35713, s, 0);
        if (s[0] == 0)
        {
            GLES20.glDeleteShader(i1);
        } else
        {
            l = i1;
        }
        i1 = GLES20.glCreateProgram();
        GLES20.glAttachShader(i1, k);
        GLES20.glAttachShader(i1, l);
        GLES20.glLinkProgram(i1);
        return i1;
    }

    public void a()
    {
        if (i >= 0)
        {
            GLES20.glDeleteProgram(i);
        }
        i = -1;
    }

}
