// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import android.util.Log;
import java.nio.IntBuffer;

public class blp
{

    public static void a(int i, int j, IntBuffer intbuffer)
    {
        intbuffer.position(0);
        GLES20.glGenTextures(1, intbuffer);
        GLES20.glBindTexture(3553, intbuffer.get(0));
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, i, j, 0, 6408, 5121, null);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, intbuffer.get(0), 0);
    }

    public static void a(IntBuffer intbuffer, IntBuffer intbuffer1, IntBuffer intbuffer2, int i, int j)
    {
        intbuffer.position(0);
        GLES20.glGenFramebuffers(1, intbuffer);
        GLES20.glBindFramebuffer(36160, intbuffer.get(0));
        a(i, j, intbuffer2);
        if (GLES20.glCheckFramebufferStatus(36160) != 36053)
        {
            Log.e("FBO-Helper", "Failure with framebuffer generation");
        }
        GLES20.glBindFramebuffer(36160, 0);
    }
}
