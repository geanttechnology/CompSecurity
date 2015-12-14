// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import java.util.ArrayList;

public class agu
{

    private String a;
    private String b;
    private ArrayList c;
    private int d;

    public agu(String s, String s1)
    {
        c = new ArrayList();
        d = 0;
        a = s;
        b = s1;
        d = agv.a(a, b);
    }

    public int a(String s)
    {
        return GLES20.glGetAttribLocation(d, s);
    }

    public void a()
    {
        GLES20.glUseProgram(d);
    }

    public void a(boolean flag)
    {
        GLES20.glDeleteProgram(d);
        d = 0;
    }

    public int b(String s)
    {
        return GLES20.glGetUniformLocation(d, s);
    }
}
