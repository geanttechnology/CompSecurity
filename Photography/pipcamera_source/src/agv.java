// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;

public class agv
{

    public static final float a[];

    public static int a()
    {
        int ai[] = new int[1];
        GLES20.glGenTextures(1, ai, 0);
        a("glGenTextures");
        int i = ai[0];
        GLES20.glBindTexture(36197, i);
        a((new StringBuilder()).append("glBindTexture ").append(i).toString());
        GLES20.glTexParameterf(36197, 10241, 9728F);
        GLES20.glTexParameterf(36197, 10240, 9729F);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        a("glTexParameter");
        return i;
    }

    public static int a(int i, String s)
    {
        int j = GLES20.glCreateShader(i);
        GLES20.glShaderSource(j, s);
        GLES20.glCompileShader(j);
        s = new int[1];
        GLES20.glGetShaderiv(j, 35713, s, 0);
        if (s[0] == 0)
        {
            Log.e("Grafika", (new StringBuilder()).append("Could not compile shader ").append(i).append(":").toString());
            Log.e("Grafika", (new StringBuilder()).append(" ").append(GLES20.glGetShaderInfoLog(j)).toString());
            GLES20.glDeleteShader(j);
            return 0;
        } else
        {
            return j;
        }
    }

    public static int a(String s, String s1)
    {
        int i = a(35633, s);
        int j;
        if (i != 0)
        {
            if ((j = a(35632, s1)) != 0)
            {
                int k = GLES20.glCreateProgram();
                if (k == 0)
                {
                    Log.e("Grafika", "Could not create program");
                }
                GLES20.glAttachShader(k, i);
                GLES20.glAttachShader(k, j);
                GLES20.glLinkProgram(k);
                s = new int[1];
                GLES20.glGetProgramiv(k, 35714, s, 0);
                if (s[0] != 1)
                {
                    Log.e("Grafika", "Could not link program: ");
                    Log.e("Grafika", GLES20.glGetProgramInfoLog(k));
                    GLES20.glDeleteProgram(k);
                    return 0;
                } else
                {
                    return k;
                }
            }
        }
        return 0;
    }

    public static void a(String s)
    {
        int i = GLES20.glGetError();
        if (i != 0)
        {
            s = (new StringBuilder()).append(s).append(": glError 0x").append(Integer.toHexString(i)).toString();
            Log.e("Grafika", s);
            throw new RuntimeException(s);
        } else
        {
            return;
        }
    }

    public static void b(int i, String s)
    {
        if (i < 0)
        {
            throw new RuntimeException((new StringBuilder()).append("Unable to locate '").append(s).append("' in program").toString());
        } else
        {
            return;
        }
    }

    static 
    {
        a = new float[16];
        Matrix.setIdentityM(a, 0);
    }
}
