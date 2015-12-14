// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.opengl.GLES20;
import com.wantu.piprender.renderengine.filters.BaseImageFilter;
import java.util.HashMap;

public class xz extends BaseImageFilter
{

    private int a;
    private float b;
    private int c;
    private float o;
    private int p;
    private float q;

    public xz()
    {
        a("SelectiveBlur");
    }

    public void a(float f)
    {
        q = f;
    }

    protected void a(int i)
    {
        a = GLES20.glGetUniformLocation(i, "texelWidthOffset");
        c = GLES20.glGetUniformLocation(i, "texelHeightOffset");
        p = GLES20.glGetUniformLocation(i, "threshold");
    }

    public void a(int i, int j)
    {
        GLES20.glBindFramebuffer(36160, i);
        GLES20.glUseProgram(c());
        GLES20.glBindTexture(3553, j);
        GLES20.glUniform1i(e, 0);
        GLES20.glUniform1f(f, m);
        GLES20.glUniform1f(g, n);
        GLES20.glUniform1f(a, b);
        GLES20.glUniform1f(c, o);
        GLES20.glUniform1f(p, q);
        GLES20.glEnableVertexAttribArray(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_VERTEX.ordinal());
        GLES20.glVertexAttribPointer(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_VERTEX.ordinal(), 3, 5126, false, 0, this.j);
        GLES20.glEnableVertexAttribArray(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal());
        GLES20.glVertexAttribPointer(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal(), 2, 5126, false, 0, l);
        GLES20.glDrawArrays(5, 0, 4);
    }

    public void a(Context context, HashMap hashmap)
    {
        super.a(context, hashmap);
        if (hashmap != null);
    }

    public void b(float f)
    {
        o = f;
    }

    public void b(int i)
    {
        a(0, i);
    }

    public void c(float f)
    {
        b = f;
    }
}
