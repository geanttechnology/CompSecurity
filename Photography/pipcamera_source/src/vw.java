// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.IntBuffer;

public abstract class vw
{

    protected final String a = "RenderingEngine";
    public Context b;

    public vw(Context context)
    {
        b = context;
    }

    protected int a(String s, int i)
    {
        return vt.a(i, s);
    }

    public int a(String s, String s1, wi wi1)
    {
        int i = vt.a(a(s, 35633), a(s1, 35632), new String[] {
            "Position", "inputTextureCoordinate"
        });
        wi1.b = i;
        s = wi1.a;
        s.a = GLES20.glGetUniformLocation(i, "Projection");
        s.b = GLES20.glGetUniformLocation(i, "Modelview");
        s.c = GLES20.glGetUniformLocation(i, "videoFrame");
        s.d = GLES20.glGetUniformLocation(i, "width");
        s.e = GLES20.glGetUniformLocation(i, "height");
        return i;
    }

    public void a(float f, float f1, int i)
    {
        f = 1.0F / f;
        f1 = 1.0F / f1;
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(i, "Projection"), 1, false, new float[] {
            f, 0.0F, 0.0F, 0.0F, 0.0F, f1, 0.0F, 0.0F, 0.0F, 0.0F, 
            -1F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F
        }, 0);
    }

    public void a(int i)
    {
        float af[] = new float[16];
        Matrix.setIdentityM(af, 0);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(i, "Modelview"), 1, false, af, 0);
    }

    public void a(String s)
    {
        int i = GLES20.glGetError();
        if (i != 0)
        {
            Log.e("RenderingEngine", (new StringBuilder()).append(s).append("'s errorcode:").append(Integer.toHexString(i)).toString());
        }
    }

    public void a(IntBuffer intbuffer, IntBuffer intbuffer1, IntBuffer intbuffer2, int i, int j)
    {
        wa.a(intbuffer, intbuffer1, intbuffer2, i, j);
    }
}
