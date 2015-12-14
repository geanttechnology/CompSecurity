// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.opengl.GLES20;
import com.wantu.piprender.renderengine.filters.BaseImageFilter;
import com.wantu.piprender.renderengine.filters.ImageFilterFactory;
import java.util.HashMap;

public class xx extends BaseImageFilter
{

    protected int a;
    protected int b;
    protected float c;
    private xj o;

    public xx()
    {
        a("UnsharpMask");
    }

    public void a()
    {
        super.a();
        o.a();
    }

    public void a(float f, float f1)
    {
        super.a(f, f1);
        o.a(f, f1);
    }

    protected void a(int i)
    {
        b = GLES20.glGetUniformLocation(i, "blurTex");
        a = GLES20.glGetUniformLocation(i, "strength");
    }

    public void a(int i, int j)
    {
        int k = o.c(j);
        GLES20.glBindFramebuffer(36160, i);
        GLES20.glUseProgram(c());
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, j);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, k);
        GLES20.glUniform1i(e, 0);
        GLES20.glUniform1f(f, m);
        GLES20.glUniform1f(g, n);
        GLES20.glUniform1f(a, c);
        GLES20.glUniform1i(b, 1);
        GLES20.glEnableVertexAttribArray(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_VERTEX.ordinal());
        GLES20.glVertexAttribPointer(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_VERTEX.ordinal(), 3, 5126, false, 0, this.j);
        GLES20.glEnableVertexAttribArray(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal());
        GLES20.glVertexAttribPointer(com.wantu.piprender.renderengine.filters.BaseImageFilter.Attribute.RE_ATTRIB_TEXTUREPOSITON.ordinal(), 2, 5126, false, 0, l);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, 0);
    }

    public void a(Context context, HashMap hashmap)
    {
        super.a(context, hashmap);
        if (hashmap.containsKey("strength"))
        {
            c = ((Float)hashmap.get(Float.valueOf(c))).floatValue();
        }
        o = ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.GAUSSIANBLUR, hashmap);
    }

    public void a(wf wf)
    {
        super.a(wf);
        o.a(wf);
    }

    public void b(int i)
    {
        a(0, i);
    }
}
