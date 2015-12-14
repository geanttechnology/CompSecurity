// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class agw
{

    private static agw e = null;
    public int a[] = {
        0
    };
    public int b[] = {
        0, 0, 0, 0
    };
    private agu c;
    private FloatBuffer d;

    private agw()
    {
        c = null;
        d = null;
    }

    public static agw a()
    {
        if (e != null)
        {
            return e;
        } else
        {
            e = new agw();
            return e;
        }
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        GLES20.glBindFramebuffer(36160, a[0]);
        GLES20.glViewport(b[0], b[1], b[2], b[3]);
        GLES20.glClear(16384);
        c.a();
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(c.a("position"));
        GLES20.glVertexAttribPointer(c.a("position"), 2, 5126, false, 0, d);
        floatbuffer = ByteBuffer.allocateDirect(32);
        floatbuffer.order(ByteOrder.nativeOrder());
        floatbuffer = floatbuffer.asFloatBuffer();
        floatbuffer.put(floatbuffer1);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(c.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(c.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(c.b("inputImageTexture"), 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(c.a("position"));
        GLES20.glDisableVertexAttribArray(c.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
    }

    public void a(agu agu1)
    {
        c = agu1;
    }

    public void a(FloatBuffer floatbuffer)
    {
        d = floatbuffer;
    }

}
