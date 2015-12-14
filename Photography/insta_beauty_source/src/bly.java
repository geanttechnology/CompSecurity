// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import java.nio.IntBuffer;

public class bly extends bln
{

    public IntBuffer e;

    public void a()
    {
        if (a != null && a.get(0) != 0)
        {
            a.position(0);
            GLES20.glDeleteTextures(1, a);
        }
        if (b != null)
        {
            b[0].position(0);
            b[1].position(0);
            if (b[0].get(0) != 0)
            {
                GLES20.glDeleteTextures(1, b[0]);
            }
            if (b[1].get(0) != 0)
            {
                GLES20.glDeleteTextures(1, b[1]);
            }
        }
        if (c != null && c.get(0) != 0)
        {
            c.position(0);
            GLES20.glDeleteTextures(1, c);
        }
        if (d != null && d.get(0) != 0)
        {
            d.position(0);
            GLES20.glDeleteTextures(1, d);
        }
        if (e != null && e.get(0) != 0)
        {
            e.position(0);
            GLES20.glDeleteTextures(1, e);
        }
    }
}
