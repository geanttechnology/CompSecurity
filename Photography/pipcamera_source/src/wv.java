// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.opengl.GLES20;
import com.wantu.piprender.renderengine.filters.BaseImageFilter;
import java.util.HashMap;

public class wv extends BaseImageFilter
{

    protected int a;
    protected int b;
    protected int c;

    public wv()
    {
        a("CrtScanline");
    }

    public void a()
    {
        super.a();
    }

    protected void a(int i)
    {
        a = GLES20.glGetUniformLocation(i, "rubyInputSize");
        b = GLES20.glGetUniformLocation(i, "rubyOutputSize");
        c = GLES20.glGetUniformLocation(i, "textureCoordinateSize");
    }

    public void a(int i, int j)
    {
        GLES20.glBindFramebuffer(36160, i);
        GLES20.glUseProgram(c());
        GLES20.glBindTexture(3553, j);
        GLES20.glUniform1i(e, 0);
        GLES20.glUniform1f(this.f, m);
        GLES20.glUniform1f(g, n);
        float f = m;
        float f1 = m;
        GLES20.glUniform2f(a, f, f1);
        GLES20.glUniform2f(b, (float)((double)f * 1.3999999999999999D), (float)((double)f1 * 1.3999999999999999D));
        GLES20.glUniform2f(c, f, f1);
        GLES20.glEnableVertexAttribArray(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_VERTEX.ordinal());
        GLES20.glVertexAttribPointer(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_VERTEX.ordinal(), 3, 5126, false, 0, this.j);
        GLES20.glEnableVertexAttribArray(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal());
        GLES20.glVertexAttribPointer(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal(), 2, 5126, false, 0, l);
        GLES20.glDrawArrays(5, 0, 4);
    }

    public void a(Context context, HashMap hashmap)
    {
        super.a(context, hashmap);
    }

    public void b(int i)
    {
        a(0, i);
    }
}
