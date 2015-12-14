// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import android.util.Log;

public class vt
{

    public static int a(int i, int j, String as[])
    {
        boolean flag;
        int k;
        flag = false;
        k = GLES20.glCreateProgram();
        if (k == 0) goto _L2; else goto _L1
_L1:
        GLES20.glAttachShader(k, i);
        GLES20.glAttachShader(k, j);
        if (as != null)
        {
            j = as.length;
            for (i = 0; i < j; i++)
            {
                GLES20.glBindAttribLocation(k, i, as[i]);
            }

        }
        GLES20.glLinkProgram(k);
        as = new int[1];
        GLES20.glGetProgramiv(k, 35714, as, 0);
        if (as[0] != 0) goto _L2; else goto _L3
_L3:
        Log.e("ShaderHelper", (new StringBuilder()).append("Error compiling program: ").append(GLES20.glGetProgramInfoLog(k)).toString());
        GLES20.glDeleteProgram(k);
        i = ((flag) ? 1 : 0);
_L5:
        if (i == 0)
        {
            throw new RuntimeException("Error creating program.");
        } else
        {
            return i;
        }
_L2:
        i = k;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static int a(int i, String s)
    {
        boolean flag = false;
        i = GLES20.glCreateShader(i);
        if (i != 0)
        {
            GLES20.glShaderSource(i, s);
            GLES20.glCompileShader(i);
            s = new int[1];
            GLES20.glGetShaderiv(i, 35713, s, 0);
            if (s[0] == 0)
            {
                Log.e("ShaderHelper", (new StringBuilder()).append("Error compiling shader: ").append(GLES20.glGetShaderInfoLog(i)).toString());
                GLES20.glDeleteShader(i);
                i = ((flag) ? 1 : 0);
            }
        }
        if (i == 0)
        {
            throw new RuntimeException("Error creating shader.");
        } else
        {
            return i;
        }
    }
}
