// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import java.nio.IntBuffer;

public class blr extends bln
{

    public void a()
    {
        if (a != null)
        {
            a.position(0);
            GLES20.glDeleteFramebuffers(1, a);
        }
        if (b != null)
        {
            b[0].position(0);
            b[1].position(0);
            GLES20.glDeleteFramebuffers(1, b[0]);
            GLES20.glDeleteFramebuffers(1, b[1]);
        }
        if (c != null)
        {
            c.position(0);
            GLES20.glDeleteFramebuffers(1, c);
        }
        if (d != null)
        {
            d.position(0);
            GLES20.glDeleteFramebuffers(1, d);
        }
    }
}
