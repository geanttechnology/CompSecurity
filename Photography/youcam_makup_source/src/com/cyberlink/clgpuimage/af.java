// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import java.nio.ByteBuffer;

public class af
{

    public static int a(Bitmap bitmap, int i, boolean flag)
    {
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
        return ai[0];
    }

    public static int a(String s, int i)
    {
        int ai[] = new int[1];
        i = GLES20.glCreateShader(i);
        GLES20.glShaderSource(i, s);
        GLES20.glCompileShader(i);
        GLES20.glGetShaderiv(i, 35713, ai, 0);
        if (ai[0] == 0)
        {
            Log.d("Load Shader Failed", (new StringBuilder()).append("Compilation\n").append(GLES20.glGetShaderInfoLog(i)).toString());
            return 0;
        } else
        {
            return i;
        }
    }

    public static int a(String s, String s1)
    {
        int ai[] = new int[1];
        int i = a(s, 35633);
        if (i == 0)
        {
            Log.d("Load Program", "Vertex Shader Failed");
            return 0;
        }
        int j = a(s1, 35632);
        if (j == 0)
        {
            Log.d("Load Program", "Fragment Shader Failed");
            return 0;
        }
        int k = GLES20.glCreateProgram();
        GLES20.glAttachShader(k, i);
        GLES20.glAttachShader(k, j);
        GLES20.glLinkProgram(k);
        GLES20.glGetProgramiv(k, 35714, ai, 0);
        if (ai[0] <= 0)
        {
            Log.d("Load Program", "Linking Failed");
            return 0;
        } else
        {
            GLES20.glDeleteShader(i);
            GLES20.glDeleteShader(j);
            return k;
        }
    }

    public static int a(ByteBuffer bytebuffer, int i, int j, int k)
    {
        int ai[] = new int[1];
        if (k == -1)
        {
            GLES20.glGenTextures(1, ai, 0);
            GLES20.glBindTexture(3553, ai[0]);
            GLES20.glTexParameterf(3553, 10240, 9729F);
            GLES20.glTexParameterf(3553, 10241, 9729F);
            GLES20.glTexParameterf(3553, 10242, 33071F);
            GLES20.glTexParameterf(3553, 10243, 33071F);
            GLES20.glTexImage2D(3553, 0, 6409, i, j, 0, 6409, 5121, bytebuffer);
        } else
        {
            GLES20.glBindTexture(3553, k);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, i, j, 6409, 5121, bytebuffer);
            ai[0] = k;
        }
        return ai[0];
    }

    public static int b(ByteBuffer bytebuffer, int i, int j, int k)
    {
        int ai[] = new int[1];
        if (k == -1)
        {
            GLES20.glGenTextures(1, ai, 0);
            GLES20.glBindTexture(3553, ai[0]);
            GLES20.glTexParameterf(3553, 10240, 9729F);
            GLES20.glTexParameterf(3553, 10241, 9729F);
            GLES20.glTexParameterf(3553, 10242, 33071F);
            GLES20.glTexParameterf(3553, 10243, 33071F);
            GLES20.glTexImage2D(3553, 0, 6410, i / 2, j / 2, 0, 6410, 5121, bytebuffer);
        } else
        {
            GLES20.glBindTexture(3553, k);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, i / 2, j / 2, 6410, 5121, bytebuffer);
            ai[0] = k;
        }
        return ai[0];
    }
}
