// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;

public class blx extends bln
{

    void a()
    {
        if (a != null)
        {
            GLES20.glDeleteRenderbuffers(1, a);
        }
        if (b != null)
        {
            GLES20.glDeleteRenderbuffers(1, b[0]);
            GLES20.glDeleteRenderbuffers(1, b[1]);
        }
        if (c != null)
        {
            GLES20.glDeleteRenderbuffers(1, c);
        }
        if (d != null)
        {
            GLES20.glDeleteRenderbuffers(1, d);
        }
    }
}
