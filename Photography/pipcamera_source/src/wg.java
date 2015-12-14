// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import java.nio.IntBuffer;

public class wg
{

    public IntBuffer a;
    public IntBuffer b;

    private wg()
    {
        a = IntBuffer.allocate(1);
        b = IntBuffer.allocate(1);
    }

    public static wg a(int i, int j)
    {
        wg wg1 = new wg();
        wa.a(wg1.a, null, wg1.b, i, j);
        return wg1;
    }

    public int a()
    {
        return a.get(0);
    }

    public int b()
    {
        return b.get(0);
    }

    public void c()
    {
        if (a != null)
        {
            a.position(0);
            GLES20.glDeleteFramebuffers(1, a);
            a.clear();
        }
        if (b != null)
        {
            b.position(0);
            GLES20.glDeleteTextures(1, b);
            b.clear();
        }
    }
}
